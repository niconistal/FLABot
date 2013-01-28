/** * $Id: PathSegmentEditPart.java,v 1.5 2006/01/27 00:09:19 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.edit.ucmeditor.editparts;

import org.eclipse.draw2d.IFigure;import org.eclipse.draw2d.PolylineConnection;import org.eclipse.emf.common.notify.Adapter;import org.eclipse.emf.common.notify.Notification;import org.eclipse.emf.common.notify.Notifier;import org.eclipse.gef.editparts.AbstractConnectionEditPart;import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;import org.isistan.flabot.edit.editormodel.EditormodelPackage;import org.isistan.flabot.edit.ucmeditor.figures.CurvePolylineConnection;/**
 * PathSegmentEditPart:
 * -	Edit part for visual model class ConnectionVisualModel.
 * -	Hooks into ConnectionVisualModel events and gets notified of visual changes. When necessary, if changes occur, they are applied to the CurvePolylineConnection.
 * -	Creates the figure that represents the segment using CurvePolylineConnection.
 * -	Adapter for IPropertySource class is not provided.
 * 
 * @author $Author: mblech $
 *
 */
public class PathSegmentEditPart extends AbstractConnectionEditPart {
	
	private Adapter adapter = new Adapter() {
		
		public void notifyChanged(Notification notification) {
			switch (notification.getEventType()) {
			case Notification.SET:
				switch(notification.getFeatureID(EditormodelPackage.class)) {
					case EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE_TERMINAL:						
						refreshSourceAnchor();
						break;
					case EditormodelPackage.CONNECTION_VISUAL_MODEL__TARGET_TERMINAL:
						refreshTargetAnchor();
						break;
				}
			}
		}
		public Notifier getTarget() {
			return getCastedModel();
		}
		public void setTarget(Notifier newTarget) {
			// do nothing
		}
		public boolean isAdapterForType(Object type) {
			return false;
		}
		
	};
	
	/**
	 * Upon activation, attach to the model element as a property change listener.
	 */
	public void activate() {
		if (!isActive()) {
			super.activate();
			getCastedModel().eAdapters().add(adapter);
		}
	}
	
	private ConnectionVisualModel getCastedModel() {
		return (ConnectionVisualModel) getModel();
	}

	@Override
	protected void createEditPolicies() {
		// do nothing, path segments shouldn't be deleted or changed
	}
	

	
	/**
	 * Upon deactivation, detach from the model element as a property change listener.
	 */
	public void deactivate() {
		if (isActive()) {
			super.deactivate();
			getCastedModel().eAdapters().remove(adapter);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	protected IFigure createFigure() {	
		PolylineConnection connection = new CurvePolylineConnection();
		return connection;
	}
}