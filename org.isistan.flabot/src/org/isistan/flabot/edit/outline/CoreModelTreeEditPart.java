/**
 * $Id: CoreModelTreeEditPart.java,v 1.6 2006/03/30 00:59:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.messages.Messages;

/**
 * A core model tree edit part: root of the core model subtree in the outline
 * @author $Author: franco $
 *
 */
public class CoreModelTreeEditPart extends FlabotModelTreeEditPart {

	private Image image;

	/**
	 * construct a new core model tree edit part for the given
	 * core model
	 * @param model
	 */
	public CoreModelTreeEditPart(CoreModel model) {
		super(model);
	}
	
	private CoreModel getCastedModel() {
		return (CoreModel) getModel();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractTreeEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
		//do nothing, nothing should be doable from here
	}

	protected Image getImage() {
		if (image == null) {
			image = ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/core.gif").createImage(); //$NON-NLS-1$
		}
		return image;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
	 */
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	protected List getModelChildren() {
		List modelChildren = new ArrayList();
		modelChildren.addAll(getCastedModel().getComponents());
		modelChildren.addAll(getCastedModel().getResponsibilities());
		modelChildren.addAll(getCastedModel().getStereotypes());
		modelChildren.addAll(getCastedModel().getInterfaceLinks());
		modelChildren.addAll(getCastedModel().getRelationships());
		modelChildren.addAll(getCastedModel().getUseCaseMaps());
		return modelChildren;
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractTreeEditPart#getText()
	 */
	@Override
	protected String getText() {
		return Messages.getString("org.isistan.flabot.edit.outline.CoreModelTreeEditPart.defaultName"); //$NON-NLS-1$
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