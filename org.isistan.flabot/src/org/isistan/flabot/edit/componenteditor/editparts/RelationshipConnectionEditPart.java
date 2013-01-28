/** * $Id: RelationshipConnectionEditPart.java,v 1.26 2006/03/28 03:16:59 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.componenteditor.editparts;

import org.eclipse.draw2d.ColorConstants;import org.eclipse.draw2d.IFigure;import org.eclipse.draw2d.Label;import org.eclipse.draw2d.PolylineConnection;import org.eclipse.draw2d.PolylineDecoration;import org.eclipse.draw2d.RotatableDecoration;import org.eclipse.emf.common.notify.Notification;import org.eclipse.gef.EditPart;import org.eclipse.gef.EditPolicy;import org.eclipse.gef.commands.Command;import org.eclipse.gef.commands.CompoundCommand;import org.eclipse.gef.editparts.AbstractGraphicalEditPart;import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;import org.eclipse.gef.editpolicies.ConnectionEditPolicy;import org.eclipse.gef.editpolicies.ContainerEditPolicy;import org.eclipse.gef.requests.ChangeBoundsRequest;import org.eclipse.gef.requests.CreateRequest;import org.eclipse.gef.requests.GroupRequest;import org.eclipse.swt.widgets.Display;import org.eclipse.ui.views.properties.IPropertySource;import org.isistan.flabot.coremodel.CoremodelPackage;import org.isistan.flabot.coremodel.Relationship;import org.isistan.flabot.coremodel.RelationshipDirection;import org.isistan.flabot.edit.componenteditor.commands.visual.DeleteRelationshipConnectionCommand;import org.isistan.flabot.edit.componenteditor.properties.RelationshipConnectionProperty;import org.isistan.flabot.edit.componentmodel.ComponentDiagram;import org.isistan.flabot.edit.editor.commands.paste.AddRelationshipConnectionPasteCommand;import org.isistan.flabot.edit.editor.figures.BendpointLocator;import org.isistan.flabot.edit.editor.figures.LineConnection;import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;import org.isistan.flabot.edit.editormodel.Diagram;import org.isistan.flabot.edit.editormodel.Util;public class RelationshipConnectionEditPart extends ConnectionToConnectionEditPart {
	
	private Label name = new Label();		
	
	public void activate() {
		if (!isActive()) {
			hookIntoModel(getSemanticModel().getStereotype());
			super.activate();
		}
	}

	/**
	 * Upon deactivation, detach from the model element as a property change listener.
	 */
	public void deactivate() {
		if (isActive()) {
			unhookFromModel(getSemanticModel().getStereotype());
			super.deactivate();
		}
	}	
	
	/**
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		int type = notification.getEventType();
		int featureId = notification.getFeatureID(CoremodelPackage.class);
		switch(featureId) {
			case CoremodelPackage.RELATIONSHIP__DIRECTION:
				switch(type){
					case Notification.SET:
						refreshArrow((PolylineConnection) getFigure());
				}
				break;
			case CoremodelPackage.RELATIONSHIP__STEREOTYPE:
			case CoremodelPackage.STEREOTYPE__NAME:
				switch(type) {
					case Notification.SET:
						updateName((LineConnection) getFigure());
						refreshBendpoints(getConnectionFigure());
				}
				break;
		}
	}	
	
	protected Relationship getSemanticModel() {
		return (Relationship) getCastedModel().getSemanticModel();
	}
	
	protected void refreshArrow(PolylineConnection figure) {		
		RelationshipDirection direction=getSemanticModel().getDirection();
		RotatableDecoration sourceDecoration=null;
		RotatableDecoration targetDecoration=null;
		if (direction.equals(RelationshipDirection.SOURCE_LITERAL)
				|| direction.equals(RelationshipDirection.BIDIRECTIONAL_LITERAL)) {
			sourceDecoration=new PolylineDecoration();
		}
		if (direction.equals(RelationshipDirection.TARGET_LITERAL)
				|| direction.equals(RelationshipDirection.BIDIRECTIONAL_LITERAL)) {
			targetDecoration=new PolylineDecoration();
		}
		figure.setSourceDecoration(sourceDecoration);
		figure.setTargetDecoration(targetDecoration);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
		super.createEditPolicies();
		
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new ContainerEditPolicy() {
			
			public Command getCloneCommand(ChangeBoundsRequest request) {																	
				ConnectionVisualModel copyVisualModel  = (ConnectionVisualModel)getHost().getModel();				
				AddRelationshipConnectionPasteCommand command = new AddRelationshipConnectionPasteCommand(copyVisualModel);
				return command;
			}
			
			public Command getCreateCommand(CreateRequest request) {
				return null;
			}
		});
		
		// Allows the removal of the connection model element
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy() {
			protected Command getDeleteCommand(GroupRequest request) {
				AbstractGraphicalEditPart c = (AbstractGraphicalEditPart) getHost();
				CompoundCommand commands = new CompoundCommand();
				commands.add(getConnectionsDeleteCommand(c.getTargetConnections()));
				Diagram d = (Diagram) ((ScalableFreeformRootEditPart)getHost().getParent()).getContents().getModel();
				commands.add(new DeleteRelationshipConnectionCommand(d.getCoreModel(), getCastedModel()));
				return commands;
			}
		});				
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	protected IFigure createFigure() {
		LineConnection connection = new LineConnection(
				getCastedModel().getLineStyle(), 
				getCastedModel().getLineWidth(),
				Util.getSWRColor(Display.getCurrent(), getCastedModel().getForegroundColor()));		
		refreshArrow(connection);
		name.setOpaque(true);
		name.setBackgroundColor(ColorConstants.buttonLightest);
		
		updateName(connection);
		return connection;
	}
	
	private void updateName(LineConnection connection) {
		// workaround for bug 0000613: an empty label is never added to the connection
		Relationship relation = getSemanticModel();
		if (relation.getStereotype() != null) {
			name.setText("{" + relation.getStereotype().getName() + "}"); //$NON-NLS-1$ //$NON-NLS-2$
			if (name.getParent() == null)
				connection.add(name, new BendpointLocator(connection));
		} else {
			if (name.getParent() != null)
				connection.remove(name);
		}		
	}
	
	public Object getAdapter(Class key) {
		if (IPropertySource.class == key) {
			EditPart diagram = (EditPart) getParent().getChildren().get(0);
			return new RelationshipConnectionProperty(getSemanticModel(), (ComponentDiagram) diagram.getModel());
		}
		return super.getAdapter(key);
	}
}