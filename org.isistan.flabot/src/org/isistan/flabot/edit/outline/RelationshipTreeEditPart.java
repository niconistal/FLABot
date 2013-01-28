/**
 * $Id: RelationshipTreeEditPart.java,v 1.5 2006/04/01 03:51:42 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.coremodel.Relationship;
import org.isistan.flabot.messages.Messages;

/**
 * Tree edit part for relationships
 * @author $Author: franco $
 *
 */
public class RelationshipTreeEditPart extends FlabotModelTreeEditPart {

	private Image image;

	/**
	 * create a new instance of this edit part for the given relationship
	 * @param relationship
	 */
	public RelationshipTreeEditPart(Relationship relationship) {
		super(relationship);
	}

	@Override
	protected void createEditPolicies() {
		// do nothing for now
	}

	@Override
	protected String getText() {
		String name = getCastedModel().getName();
		if (name.equals("")) //$NON-NLS-1$
			name = Messages.getString("org.isistan.flabot.edit.outline.RelationshipTreeEditPart.defaultRelationshipName"); //$NON-NLS-1$
		return name;
	}

	private Relationship getCastedModel() {
		return (Relationship) getModel();
	}
	
	protected Image getImage() {
		if (image == null) {
			image = ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/relationship.gif").createImage(); //$NON-NLS-1$
		}
		return image;
	}
	
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
		modelChildren.add(getCastedModel().getSource());
		modelChildren.add(getCastedModel().getTarget());
		return modelChildren;
	}
	
	public String toString() {
		return new String(Messages.getString("org.isistan.flabot.edit.outline.RelationshipTreeEditPart.defaultRelationshipName")); //$NON-NLS-1$
	}

}
