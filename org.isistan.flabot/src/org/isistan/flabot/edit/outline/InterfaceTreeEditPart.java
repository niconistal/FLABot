/**
 * $Id: InterfaceTreeEditPart.java,v 1.10 2006/03/30 00:59:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.outline;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.coremodel.InterfaceModel;
import org.isistan.flabot.coremodel.PortModel;
import org.isistan.flabot.edit.componenteditor.commands.model.DeleteInterfaceCommand;
import org.isistan.flabot.edit.multipage.dnd.InterfaceDragListener;

/**
 * Tree edit part for interfaces (outline view)
 * @author $Author: franco $
 *
 */
public class InterfaceTreeEditPart extends FlabotModelTreeEditPart {
	
	InterfaceDragListener dragListener;
	private Image image;
	
	/**
	 * construct a new interface tree edit part for the given
	 * interface
	 * @param model
	 */
	public InterfaceTreeEditPart(InterfaceModel model) {
		super(model);
	}
	
	private InterfaceDragListener getDragListener() {
		if (dragListener == null) 
			dragListener = new InterfaceDragListener(getViewer());
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
	
	private InterfaceModel getCastedModel() {
		return (InterfaceModel) getModel();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractTreeEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
		// If this editpart is the root content of the viewer, then disallow removal
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {

			protected Command createDeleteCommand(GroupRequest deleteRequest) {
				return new DeleteInterfaceCommand(getCastedModel().getPort(), getCastedModel());
			}
			
		});
	}
	
	protected Image getImage() {
		if (image == null) {
			PortModel port = getCastedModel().getPort();
			if (port.getProvideds().contains(getCastedModel())) 
				image =  ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/provided.gif").createImage(); //$NON-NLS-1$
			else
				image =  ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/required.gif").createImage(); //$NON-NLS-1$
		}
		return image;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractTreeEditPart#getText()
	 */
	@Override
	protected String getText() {
		return getCastedModel().getName();
	}

	/**
	 * Adapter implementation
	 */

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