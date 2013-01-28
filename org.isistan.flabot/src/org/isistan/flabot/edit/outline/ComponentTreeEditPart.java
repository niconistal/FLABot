/**
 * $Id: ComponentTreeEditPart.java,v 1.9 2006/03/30 00:59:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.edit.componenteditor.commands.model.DeleteComponentCommand;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.multipage.dnd.ComponentDragListener;

/**
 * Tree edit part for components in the outline view
 * @author $Author: franco $
 *
 */
public class ComponentTreeEditPart extends FlabotModelTreeEditPart {

	ComponentDragListener dragListener;
	private Image image;
	
	/**
	 * construct a new core model tree edit part for the given
	 * core model
	 * @param model
	 */
	public ComponentTreeEditPart(ComponentModel model) {
		super(model);
	}
	
	private ComponentModel getCastedModel() {
		return (ComponentModel) getModel();
	}
	
	private ComponentDragListener getDragListener() {
		if (dragListener == null) 
			dragListener = new ComponentDragListener(getViewer());
		return dragListener;
	}
	
	public void activate() {	
		if (!isActive()) {
			super.activate();
			getViewer().addDragSourceListener(getDragListener());
		}
	}

	public void deactivate() {
		if (isActive()) {
			super.deactivate();
			getViewer().removeDragSourceListener(getDragListener());
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractTreeEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
		// If this editpart is the root content of the viewer, then disallow removal
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {
			
			protected Command createDeleteCommand(GroupRequest deleteRequest) {								
				return new DeleteComponentCommand(getCorrectCoreModel(), getCastedModel());
			}			
		});
	}

	private CoreModel getCorrectCoreModel() {
		EditPart root = this;
		while (root.getParent().getModel() != null)
			root = (FlabotModelTreeEditPart) root.getParent();
	
		FlabotFileModel fileModel = (FlabotFileModel)root.getModel();
		return fileModel.getCoreModel();
	}
	
	
	protected Image getImage() {
		if (image == null) {
			image = ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/component.gif").createImage(); //$NON-NLS-1$
		}
		return image;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
	 */
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	protected List getModelChildren() {
		List modelChildren = new ArrayList();
		modelChildren.addAll(getCastedModel().getFeatures());
		modelChildren.addAll(getCastedModel().getOwnedPorts());
		return modelChildren;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractTreeEditPart#getText()
	 */
	@Override
	protected String getText() {
		return getCastedModel().getName();
	}

	public void notifyChanged(Notification notification) {
		switch (notification.getEventType()) {
		case Notification.ADD:
		case Notification.ADD_MANY:
		case Notification.REMOVE:
		case Notification.REMOVE_MANY:
		case Notification.MOVE:
			refreshChildren();
			break;
		case Notification.SET:
		case Notification.UNSET:
			refreshVisuals();
			break;
		}
	}
}