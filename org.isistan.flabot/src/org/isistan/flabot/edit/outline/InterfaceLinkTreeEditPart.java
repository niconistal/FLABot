/**
 * $Id: InterfaceLinkTreeEditPart.java,v 1.5 2006/03/30 00:59:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.coremodel.InterfaceLink;
import org.isistan.flabot.messages.Messages;

/**
 * Tree edit part for interface links in the outline view
 * @author $Author: franco $
 *
 */
public class InterfaceLinkTreeEditPart extends FlabotModelTreeEditPart {

	private Image image;

	/**
	 * create a new instance of this tree edit part for the given link
	 * @param link
	 */
	public InterfaceLinkTreeEditPart(InterfaceLink link) {
		super(link);
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.edit.outline.FlabotModelTreeEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		//do nothing for now
	}

	protected Image getImage() {
		if (image == null) {
			image = ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/interface_link.gif").createImage(); //$NON-NLS-1$
		}
		return image;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.edit.outline.FlabotModelTreeEditPart#getText()
	 */
	@Override
	protected String getText() {
		String name = getCastedModel().getName();
		if (name.equals("")) //$NON-NLS-1$
			name = Messages.getString("org.isistan.flabot.edit.outline.InterfaceLinkTreeEditPart.defaultName"); //$NON-NLS-1$
		return name;
	}

	private InterfaceLink getCastedModel() {
		return (InterfaceLink) getModel();
	}
	
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	protected List getModelChildren() {
		List modelChildren = new ArrayList();
		modelChildren.add(getCastedModel().getSource());
		modelChildren.add(getCastedModel().getTarget());
		return modelChildren;
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
