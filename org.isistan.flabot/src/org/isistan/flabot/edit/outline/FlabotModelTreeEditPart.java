/**
 * $Id: FlabotModelTreeEditPart.java,v 1.4 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.outline;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractTreeEditPart;
import org.eclipse.gef.tools.DragTreeItemsTracker;



/**
 * Base class for all tree edit parts in flabot outline view
 * @author $Author: franco $
 *
 */
public abstract class FlabotModelTreeEditPart extends AbstractTreeEditPart
	implements Adapter {
	private DragTracker tracker;

	/**
	 * construct a new tree edit part for the given
	 * model
	 * @param model
	 */
	public FlabotModelTreeEditPart(Notifier model) {
		setModel(model);
	}

	/**
	 * Upon activation, attach to the model element as a property change listener.
	 */
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	public void activate() {
		if (!isActive()) {
			super.activate();
			((Notifier)getModel()).eAdapters().add(this);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractTreeEditPart#createEditPolicies()
	 */
	protected abstract void createEditPolicies();

	/**
	 * Upon deactivation, detach from the model element as a property change listener.
	 */
	public void deactivate() {
		if (isActive()) {
			super.deactivate();
			((Notifier)getModel()).eAdapters().remove(this);
		}
	}

	/**
	 * Convenience method that returns the EditPart corresponding to a given child.
	 * @param child a model element instance
	 * @return the corresponding EditPart or null
	 */
	protected EditPart getEditPartForChild(Object child) {
		return (EditPart) getViewer().getEditPartRegistry().get(child);
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractTreeEditPart#getText()
	 */
	@Override
	protected abstract String getText();

	/**
	 * Adapter implementation
	 */
	/**
	 * subclasses must implement this method
	 */
	public abstract void notifyChanged(Notification notification);

	public Notifier getTarget() {
		return (Notifier)getModel();
	}

	public void setTarget(Notifier newTarget) {
		// do nothing
	}

	public boolean isAdapterForType(Object type) {
		return false;
	}
	
	/**
	 * Overridden to return a default <code>DragTracker</code> for GraphicalEditParts.
	 * @see org.eclipse.gef.EditPart#getDragTracker(Request)
	 */

	public DragTracker getDragTracker(Request request) {
		if (tracker == null)
			tracker = new DragTreeItemsTracker(this);
		return tracker;
	}
}