/** $Id: StartPointEditPart.java,v 1.6 2006/03/30 00:59:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.outline;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.coremodel.SimplePathNode;

/**
 * Start Point edit part (outline view)
 * @author $Author: franco $
 *
 */
public class StartPointEditPart extends FlabotModelTreeEditPart {
	private Image image;

	/**
	 * construct a new start Point tree edit part for the given
	 * start Point
	 * @param model
	 */
	public StartPointEditPart(SimplePathNode model) {
		super(model);
	}
	
	private SimplePathNode getCastedModel() {
		return (SimplePathNode) getModel();
	}

	protected Image getImage() {
		if (image == null) {
			image = ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/path16x16.gif").createImage(); //$NON-NLS-1$
		}
		return image;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractTreeEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
		// Do nothing
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