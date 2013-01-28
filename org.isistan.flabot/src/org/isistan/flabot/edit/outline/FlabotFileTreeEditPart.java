/**
 * $Id: FlabotFileTreeEditPart.java,v 1.7 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.outline;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.editormodel.Folder;

/**
 * A flabot file tree edit part, the root of the outline view
 * @author $Author: franco $
 *
 */
public class FlabotFileTreeEditPart extends FlabotModelTreeEditPart {

	/**
	 * construct a new flabot file tree edit part for the given
	 * file model
	 * @param model
	 */
	public FlabotFileTreeEditPart(FlabotFileModel model) {
		super(model);
	}
	
	
	/**
	 * Upon activation, attach to the model element as a property change listener.
	 */
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	public void activate() {
		if (!isActive()) {
			super.activate();
			getCastedModel().getFolder().eAdapters().add(this);
		}
	}

	/**
	 * Upon deactivation, detach from the model element as a property change listener.
	 */
	public void deactivate() {
		if (isActive()) {
			super.deactivate();
			getCastedModel().getFolder().eAdapters().remove(this);
		}
	}
	
	private FlabotFileModel getCastedModel() {
		return (FlabotFileModel) getModel();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractTreeEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
		// If this editpart is the root content of the viewer, then disallow removal
		if (getParent() instanceof RootEditPart) {
			installEditPolicy(EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy());
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
	 */
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	protected List getModelChildren() {
		List modelChildren = new ArrayList();
		modelChildren.add(getCastedModel().getCoreModel());
		
		List diagrams = getCastedModel().getDiagrams();
		for (Iterator iter=diagrams.iterator(); iter.hasNext();) {
			Diagram d = (Diagram) iter.next();
			if (d.getFolder() == null)
				modelChildren.add(d);
		}				
		
		Folder folder = getCastedModel().getFolder();
		for (Iterator iter=folder.getFolders().iterator(); iter.hasNext();)
			modelChildren.add(iter.next());

			modelChildren.addAll(getCastedModel().getImportedFiles());
		return modelChildren;
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

	@Override
	protected String getText() {
		return getCastedModel().toString();
	}
}