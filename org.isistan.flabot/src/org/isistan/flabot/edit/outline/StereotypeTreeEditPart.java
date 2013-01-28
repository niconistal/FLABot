/**
 * $Id: StereotypeTreeEditPart.java,v 1.8 2006/03/30 00:59:57 franco Exp $
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
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.Stereotype;
import org.isistan.flabot.edit.componenteditor.commands.model.DeleteStereotypeCommand;


/**
 * Tree edit part for Stereotypes (outline view)
 * @author $Author: franco $
 *
 */
public class StereotypeTreeEditPart extends FlabotModelTreeEditPart {
	private Image image;

	/**
	 * construct a new Stereotype tree edit part for the given
	 * Stereotype
	 * @param model
	 */
	public StereotypeTreeEditPart(Stereotype model) {
		super(model);
	}
	
	private Stereotype getCastedModel() {
		return (Stereotype) getModel();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractTreeEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
		// If this editpart is the root content of the viewer, then disallow removal
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {
			protected Command createDeleteCommand(GroupRequest deleteRequest) {
				return new DeleteStereotypeCommand((CoreModel)getParent().getModel(), getCastedModel());
			}
		});
	}
	
	protected Image getImage() {
		if (image == null) {
			image = ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/stereotype.gif").createImage(); //$NON-NLS-1$
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