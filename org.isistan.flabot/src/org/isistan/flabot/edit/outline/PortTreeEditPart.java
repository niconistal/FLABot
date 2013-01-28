/**
 * $Id: PortTreeEditPart.java,v 1.7 2006/03/30 00:59:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.coremodel.PortModel;
import org.isistan.flabot.edit.componenteditor.commands.model.DeletePortCommand;
import org.isistan.flabot.edit.multipage.dnd.PortDragListener;

/**
 * Tree edit part for ports in the outline view
 * @author $Author: franco $
 *
 */
public class PortTreeEditPart extends FlabotModelTreeEditPart {

	PortDragListener dragListener;
	private Image image;
	
	/**
	 * create an instance of this edit part for the given port
	 * @param port
	 */
	public PortTreeEditPart(PortModel port) {
		super(port);
	}

	
	private PortDragListener getDragListener() {
		if (dragListener == null) 
			dragListener = new PortDragListener(getViewer());
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
	 * @see org.isistan.flabot.edit.outline.FlabotModelTreeEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		// If this editpart is the root content of the viewer, then disallow removal
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {

			protected Command createDeleteCommand(GroupRequest deleteRequest) {
				return new DeletePortCommand(getCastedModel().getComponent(), getCastedModel());
			}
			
		});
	}

	protected Image getImage() {
		if (image == null) {
			image = ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/port.gif").createImage(); //$NON-NLS-1$
		}
		return image;
	}
	
	/* (non-Javadoc)
	 * @see org.isistan.flabot.edit.outline.FlabotModelTreeEditPart#getText()
	 */
	@Override
	protected String getText() {
		return getCastedModel().getName();
	}
	
	private PortModel getCastedModel() {
		return (PortModel) getModel();
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.edit.outline.FlabotModelTreeEditPart#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
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
	
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	protected List getModelChildren() {
		List modelChildren = new ArrayList();
		modelChildren.addAll(getCastedModel().getProvideds());
		modelChildren.addAll(getCastedModel().getRequireds());
		return modelChildren;
	}
}