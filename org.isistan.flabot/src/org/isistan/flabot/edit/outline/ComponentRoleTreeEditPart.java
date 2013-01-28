/**
 * $Id: ComponentRoleTreeEditPart.java,v 1.9 2006/03/30 00:59:57 franco Exp $
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
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.edit.ucmeditor.commands.model.DeleteComponentRoleCommand;

/**
 * Tree edit part for component roles in the outline view
 * @author $Author: franco $
 *
 */
public class ComponentRoleTreeEditPart extends FlabotModelTreeEditPart {
	
	private Image image = null;
	
	/**
	 * create an instance of this edit part for the given componentRole
	 * @param componentRole
	 */
	public ComponentRoleTreeEditPart(ComponentRole componentRole) {
		super(componentRole);
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.edit.outline.FlabotModelTreeEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		// If this editpart is the root content of the viewer, then disallow removal
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {
			protected Command createDeleteCommand(GroupRequest deleteRequest) {
				return new DeleteComponentRoleCommand(((UseCaseMap)getParent().getModel()).getCoreModel(), getCastedModel());
			}
		});
	}

	protected Image getImage() {
		if (image == null) {
			image = ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/role.gif").createImage(); //$NON-NLS-1$
		}
		return image;
	}
	
	/* (non-Javadoc)
	 * @see org.isistan.flabot.edit.outline.FlabotModelTreeEditPart#getText()
	 */
	@Override
	protected String getText() {
		return getCastedModel().getFullName();
	}
	
	private ComponentRole getCastedModel() {		
		return (ComponentRole) getModel();
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

}
