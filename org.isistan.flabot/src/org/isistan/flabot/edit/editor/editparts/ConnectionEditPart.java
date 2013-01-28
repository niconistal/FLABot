/** * $Id: ConnectionEditPart.java,v 1.11 2006/03/21 02:57:52 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.editor.editparts;

import java.beans.PropertyChangeEvent;import java.beans.PropertyChangeListener;import java.util.ArrayList;import java.util.List;import org.eclipse.draw2d.Connection;import org.eclipse.draw2d.RelativeBendpoint;import org.eclipse.draw2d.Shape;import org.eclipse.emf.common.notify.Adapter;import org.eclipse.emf.common.notify.Notification;import org.eclipse.emf.common.notify.Notifier;import org.eclipse.emf.ecore.EObject;import org.eclipse.gef.EditPolicy;import org.eclipse.gef.editparts.AbstractConnectionEditPart;import org.eclipse.swt.widgets.Display;import org.isistan.flabot.edit.editor.editpolicies.ConnectionBendpointEditPolicy;import org.isistan.flabot.edit.editormodel.ConnectionBendpoint;import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;import org.isistan.flabot.edit.editormodel.EditormodelPackage;import org.isistan.flabot.edit.editormodel.NodeVisualModel;import org.isistan.flabot.edit.editormodel.Util;/**
 * ConnectionEditPart:
 * -	Edit part for semantic model classes Relationship or the NoteElementModel’s feature Notes visual model class ConnectionVisualModel.
 * -	Hooks into ConnectionVisualModel and NodeVisualModel (from source and target) events and gets notified of visual property changes, and from connection changes (source/target change).
 * -	Creates the figure that represents the connection using PolylineConnection.
 * -	Adapter for IPropertySource class is not provided.
 * 
 * @author $Author: franco $
 *
 */
public abstract class ConnectionEditPart  extends AbstractConnectionEditPart implements PropertyChangeListener {
			
	protected ConnectionAdapter adapter = new ConnectionAdapter(this);
	
	private class ConnectionAdapter implements Adapter {
		
		private ConnectionEditPart editPart;
		private Notifier target;
		
		public ConnectionAdapter (ConnectionEditPart editPart) {
			this.editPart = editPart;
		}
		
		/**
		 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
		 */
		public void notifyChanged(Notification notification) {
			editPart.notifyChanged(notification);
		}
				
		/**
		 * @see org.eclipse.emf.common.notify.Adapter#setTarget(org.eclipse.emf.common.notify.Notifier)
		 */
		public void setTarget(Notifier newTarget) {
			target = newTarget;
		}
		
		/**
		 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
		 */
		public boolean isAdapterForType(Object type) {
			return (getModel().getClass() == type);
		}
		
		/**
		 * @see org.eclipse.emf.common.notify.Adapter#getTarget()
		 */
		public Notifier getTarget() {
			return target;
		}		
	}
			
	/**
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void notifyChanged(Notification notification) {
		refreshBendpoints(getConnectionFigure());
		int type = notification.getEventType();
		int featureId = notification.getFeatureID(EditormodelPackage.class);
		if (notification.getNotifier() instanceof ConnectionVisualModel) {
			switch(featureId) {
				case EditormodelPackage.VISUAL_MODEL__FOREGROUND_COLOR:
					if (type == Notification.SET)
						getFigure().setForegroundColor(Util.getSWRColor(Display.getCurrent(), getCastedModel().getForegroundColor()));
					break;
				
				case EditormodelPackage.VISUAL_MODEL__LINE_STYLE:
					if (type == Notification.SET)
						((Shape)getFigure()).setLineStyle(getCastedModel().getLineStyle());
					break;
				
				case EditormodelPackage.VISUAL_MODEL__LINE_WIDTH:
					if (type == Notification.SET)
						((Shape)getFigure()).setLineWidth(getCastedModel().getLineWidth());
					break;				
			}
		} else if (notification.getNotifier() instanceof NodeVisualModel) {			
			if (featureId == EditormodelPackage.POINT && type == Notification.ADD)
				refreshBendpoints(getConnectionFigure());		
			switch(type) {
				case Notification.ADD:
				case Notification.SET:
				case Notification.REMOVE:
					switch(featureId) {
						case EditormodelPackage.NODE_VISUAL_MODEL__SOURCE_CONNECTIONS:					
							refreshSourceConnections();
							break;
						case EditormodelPackage.NODE_VISUAL_MODEL__TARGET_CONNECTIONS:
							//View Bug
							//refreshTargetConnections();
							break;
					}
			}
		}
	}
		/**	 * Once the figure has been added to the ConnectionLayer, start listening for its router to change.	 */
	@Override	public void activateFigure() {
		super.activateFigure();
		
		getFigure().addPropertyChangeListener(Connection.PROPERTY_CONNECTION_ROUTER, this);
	}
		@Override
	public void deactivateFigure() {
		getFigure().removePropertyChangeListener(Connection.PROPERTY_CONNECTION_ROUTER, this);
		super.deactivateFigure();
	}
	
	/**
	 * Listens to changes in properties of the Wire (like the
	 * contents being carried), and reflects is in the visuals.
	 *
	 * @param event  Event notifying the change.
	 */
	public void propertyChange(PropertyChangeEvent event) {
		String property = event.getPropertyName();
		if (Connection.PROPERTY_CONNECTION_ROUTER.equals(property)){
			refreshBendpoints(getConnectionFigure());
		}
	}
		
	@Override	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new ConnectionBendpointEditPolicy());
	}
			/**	 * Updates the bendpoint of the figure	 * 	 * @param figure the figure to be updated	 */
	protected void refreshBendpoints(Connection figure) {
		List modelConstraint = getCastedModel().getBendpoints();
		List figureConstraint = new ArrayList();
		for (int i=0; i<modelConstraint.size(); i++) {
			ConnectionBendpoint wbp = (ConnectionBendpoint)modelConstraint.get(i);
			RelativeBendpoint rbp = new RelativeBendpoint(figure);
			rbp.setRelativeDimensions(
					Util.getDraw2DDimension(wbp.getFirstRelativeDimension()),
					Util.getDraw2DDimension(wbp.getSecondRelativeDimension())
					);
			rbp.setWeight((i+1) / ((float)modelConstraint.size()+1));
			figureConstraint.add(rbp);
		}
		figure.setRoutingConstraint(figureConstraint);
	}
	
	/**
	 * Upon activation, attach to the visual model, 	 * source visual model and target visual model	 * elements as a property change listener.
	 */	 @Override
	public void activate() {
		if (!isActive()) {
			hookIntoModel(getCastedModel());
			hookIntoModel(getCastedSource());
			hookIntoModel(getCastedTarget());
			super.activate();
		}
	}
		/**		 * Upon activation, attach to a model element as a property change listener.	 */
	protected void hookIntoModel(EObject model) {
		if(model != null) {
			model.eAdapters().add(adapter);
		}
	}
		/**	 * Upon deactivation, detach from a model element as a property change listener.	 */
	protected void unhookFromModel(EObject model) {
		if(model != null) {
			model.eAdapters().remove(adapter);
		}
	}

	/**
	 * Upon deactivation, detach from the visual model, 	 * source visual model and target visual model	 * elements as a property change listener.
	 */	@Override
	public void deactivate() {
		if (isActive()) {
			unhookFromModel(getCastedModel());
			unhookFromModel(getCastedSource());
			unhookFromModel(getCastedTarget());
			super.deactivate();
		}
	}
		/**	 * Returns the casted connection visual model.	 * 	 * @return the casted connection visual model	 */
	protected ConnectionVisualModel getCastedModel() {
		return (ConnectionVisualModel) getModel();
	}	
		/**	 * Returns the casted source visual model.	 * 	 * @return the casted source visual model	 */
	protected NodeVisualModel getCastedSource() {
		return ((ConnectionVisualModel) getModel()).getSource();
	}	
		/**	 * Returns the casted target visual model.	 * 	 * @return the casted target visual model	 */
	protected NodeVisualModel getCastedTarget() {
		return ((ConnectionVisualModel) getModel()).getTarget();
	}
}