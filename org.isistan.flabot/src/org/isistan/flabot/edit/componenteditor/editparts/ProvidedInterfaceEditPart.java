/** * $Id: ProvidedInterfaceEditPart.java,v 1.9 2006/03/09 21:37:24 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.componenteditor.editparts;

import org.eclipse.draw2d.ColorConstants;import org.eclipse.draw2d.ConnectionAnchor;import org.eclipse.draw2d.IFigure;import org.eclipse.gef.ConnectionEditPart;import org.eclipse.gef.EditPolicy;import org.eclipse.gef.Request;import org.eclipse.gef.commands.Command;import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;import org.eclipse.gef.requests.CreateConnectionRequest;import org.eclipse.gef.requests.ReconnectRequest;import org.isistan.flabot.coremodel.InterfaceLink;import org.isistan.flabot.edit.componenteditor.commands.visual.AddInterfaceConnectionCommand;import org.isistan.flabot.edit.componenteditor.figures.ProvidedInterfaceFigure;import org.isistan.flabot.edit.componentmodel.ComponentDiagram;import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;import org.isistan.flabot.edit.editormodel.NodeVisualModel;public class ProvidedInterfaceEditPart extends InterfaceEditPart {
	
	public static final String PROVIDED_INTERFACE = "ProvidedInterface"; //$NON-NLS-1$ 
	
	protected void createEditPolicies() {
		super.createEditPolicies();
		
		// allow the creation of connections and 
		// and the reconnection of connections between Shape instances
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new GraphicalNodeEditPolicy() {
			/* (non-Javadoc)
			 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCompleteCommand(org.eclipse.gef.requests.CreateConnectionRequest)
			 */
			protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
				return null;
			}
			/* (non-Javadoc)
			 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCreateCommand(org.eclipse.gef.requests.CreateConnectionRequest)
			 */
			protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
				if (request.getNewObjectType() == InterfaceLink.class) {
					NodeVisualModel source = (NodeVisualModel) getHost().getModel();
					
					
					AddInterfaceConnectionCommand cmd = 
						new AddInterfaceConnectionCommand((ComponentDiagram)getHost().getParent().getParent().getParent().getModel(),
								source, (ConnectionVisualModel)request.getNewObject());
					request.setStartCommand(cmd);
					return cmd;
				}
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
		ProvidedInterfaceFigure f = new ProvidedInterfaceFigure();
		f.setBackgroundColor(ColorConstants.black);
		f.setOpaque(true);
		refreshLocation(f);
		return f;
	}
		
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return getConnectionAnchor();
	}
	
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return getConnectionAnchor();
	}

	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return null;
	}
	
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return null;
	}	
}