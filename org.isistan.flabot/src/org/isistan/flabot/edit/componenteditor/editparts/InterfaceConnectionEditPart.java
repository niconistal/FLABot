/** * $Id: InterfaceConnectionEditPart.java,v 1.18 2006/03/21 01:51:58 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.componenteditor.editparts;

import org.eclipse.draw2d.ColorConstants;import org.eclipse.draw2d.Graphics;import org.eclipse.draw2d.IFigure;import org.eclipse.draw2d.Label;import org.eclipse.emf.common.notify.Notification;import org.eclipse.gef.EditPolicy;import org.eclipse.gef.commands.Command;import org.eclipse.gef.commands.CompoundCommand;import org.eclipse.gef.editparts.AbstractGraphicalEditPart;import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;import org.eclipse.gef.editpolicies.ConnectionEditPolicy;import org.eclipse.gef.editpolicies.ContainerEditPolicy;import org.eclipse.gef.requests.ChangeBoundsRequest;import org.eclipse.gef.requests.CreateRequest;import org.eclipse.gef.requests.GroupRequest;import org.eclipse.ui.views.properties.IPropertySource;import org.isistan.flabot.coremodel.CoremodelPackage;import org.isistan.flabot.coremodel.InterfaceLink;import org.isistan.flabot.edit.componenteditor.commands.visual.DeleteInterfaceConnectionCommand;import org.isistan.flabot.edit.componentmodel.ComponentDiagram;import org.isistan.flabot.edit.editor.commands.paste.AddInterfaceConnectionPasteCommand;import org.isistan.flabot.edit.editor.figures.BendpointLocator;import org.isistan.flabot.edit.editor.figures.LineConnection;import org.isistan.flabot.edit.editor.properties.NamedElementPropertySource;import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;import org.isistan.flabot.messages.Messages;public class InterfaceConnectionEditPart extends ConnectionToConnectionEditPart {

	private Label name = new Label();
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
		super.createEditPolicies();
		
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new ContainerEditPolicy() {
					
			public Command getCloneCommand(ChangeBoundsRequest request) {																		
				ConnectionVisualModel copyVisualModel  = (ConnectionVisualModel)getHost().getModel();				
				AddInterfaceConnectionPasteCommand command = new AddInterfaceConnectionPasteCommand(copyVisualModel);
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
				if (c.getTargetConnections().size() > 0)
					commands.add(getConnectionsDeleteCommand(c.getTargetConnections()));
				ComponentDiagram diagram = (ComponentDiagram)((ScalableFreeformRootEditPart)c.getParent()).getContents().getModel();
				commands.add(new DeleteInterfaceConnectionCommand(diagram, getCastedModel()));				
				return commands;
			}
		});
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	protected IFigure createFigure() {
		LineConnection connection = new LineConnection(Graphics.LINE_SOLID, 1, ColorConstants.black);
		connection.setLineWidth(1);
		connection.setLineStyle(Graphics.LINE_SOLID);	
		
		updateName(connection);		
		return connection;
	}
	
	private InterfaceLink getSemanticModel() {
		return (InterfaceLink) getCastedModel().getSemanticModel();
	}
	
	private void updateName(LineConnection connection) {
		// workaround for bug 0000613: an empty label is never added to the connection
		String linkName = getSemanticModel().getName(); 
		if (linkName.length() > 0) {
			name.setText(linkName);
			if (name.getParent() == null)
				connection.add(name, new BendpointLocator(connection));
		} else {
			if (name.getParent() != null)
				connection.remove(name);
		}
	}
	
	public Object getAdapter(Class key) {
		if (IPropertySource.class == key)
			return new NamedElementPropertySource(Messages.getString("org.isistan.flabot.edit.componenteditor.editparts.InterfaceConnectionEditPart.propertyViewName"), getSemanticModel()); //$NON-NLS-1$
		return super.getAdapter(key);
	}
	
	/**
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		int type = notification.getEventType();
		int featureId = notification.getFeatureID(CoremodelPackage.class);
		switch(featureId) {
			case CoremodelPackage.INTERFACE_LINK__NAME:
				switch(type){
					case Notification.SET:
						updateName((LineConnection)getFigure());
						refreshBendpoints(getConnectionFigure());
				}
				break;	
		}
	}
}