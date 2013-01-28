/** * $Id: RequiredInterfaceEditPart.java,v 1.11 2006/03/09 21:37:24 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.componenteditor.editparts;

import org.eclipse.draw2d.ColorConstants;import org.eclipse.draw2d.ConnectionAnchor;import org.eclipse.draw2d.IFigure;import org.eclipse.gef.ConnectionEditPart;import org.eclipse.gef.EditPolicy;import org.eclipse.gef.Request;import org.eclipse.gef.commands.Command;import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;import org.eclipse.gef.requests.CreateConnectionRequest;import org.eclipse.gef.requests.ReconnectRequest;import org.isistan.flabot.coremodel.InterfaceLink;import org.isistan.flabot.edit.componenteditor.commands.visual.AddInterfaceConnectionCommand;import org.isistan.flabot.edit.componenteditor.figures.RequiredInterfaceFigure;import org.isistan.flabot.edit.editormodel.NodeVisualModel;public class RequiredInterfaceEditPart extends InterfaceEditPart {

	public static final String REQUIRED_INTERFACE = "RequiredInterface"; //$NON-NLS-1$
	
	protected void createEditPolicies() {
		super.createEditPolicies();
		
		// allow the creation of connections and 
		// and the reconnection of connections between Shape instances
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new GraphicalNodeEditPolicy() {
			/* (non-Javadoc)
			 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCompleteCommand(org.eclipse.gef.requests.CreateConnectionRequest)
			 */
			protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
				if (request.getNewObjectType() == InterfaceLink.class)  {
					AddInterfaceConnectionCommand cmd = (AddInterfaceConnectionCommand) request.getStartCommand();
					cmd.setTarget((NodeVisualModel) getHost().getModel());
					return cmd;
				}
				return null;
			}
			/* (non-Javadoc)
			 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCreateCommand(org.eclipse.gef.requests.CreateConnectionRequest)
			 */
			protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
				return null;
			}
			/* (non-Javadoc)
			 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectSourceCommand(org.eclipse.gef.requests.ReconnectRequest)
			 */
			protected Command getReconnectSourceCommand(ReconnectRequest request) {				
				return null;
			}
			/* (non-Javadoc)
			 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
			 */
			protected Command getReconnectTargetCommand(ReconnectRequest request) {
				return null;
			}
		});
	}
	
	protected IFigure createFigure() {
		RequiredInterfaceFigure f = new RequiredInterfaceFigure();
		f.setBackgroundColor(ColorConstants.black);
		f.setOpaque(true);
		refreshLocation(f);
		return f;
	}
	
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return null;
	}
	
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return null;
	}

	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return getConnectionAnchor();
	}
	
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		CreateConnectionRequest r = (CreateConnectionRequest) request;
		if (r.getNewObjectType() == InterfaceLink.class)
			return getConnectionAnchor();
		return null;
	}	
}