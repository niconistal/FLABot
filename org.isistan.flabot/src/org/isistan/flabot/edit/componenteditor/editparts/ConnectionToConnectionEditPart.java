/**
 * $Id: ConnectionToConnectionEditPart.java,v 1.6 2005/12/15 19:49:20 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.editparts;

import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.isistan.flabot.edit.componenteditor.figures.ConnectionToConnectionAnchor;
import org.isistan.flabot.edit.editor.commands.AddNoteConnectionCommand;
import org.isistan.flabot.edit.editor.editparts.ConnectionEditPart;
import org.isistan.flabot.edit.editor.editparts.NoteConnectionEditPart;
import org.isistan.flabot.edit.editor.figures.LineConnection;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;

/**
 * @author $Author: franco $
 *
 */
public class ConnectionToConnectionEditPart extends ConnectionEditPart implements NodeEditPart {
	private ConnectionAnchor anchor;
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
		super.createEditPolicies();
						
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new GraphicalNodeEditPolicy() {
						
			/* (non-Javadoc)
			 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCompleteCommand(org.eclipse.gef.requests.CreateConnectionRequest)
			 */
			protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
				if (request.getNewObjectType().equals(NoteConnectionEditPart.NOTE_CONNECTION)) {
					AddNoteConnectionCommand cmd = (AddNoteConnectionCommand) request.getStartCommand();
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
	
	protected List getModelSourceConnections() {
		return ((NodeVisualModel) getModel()).getSourceConnections();
	}
	
	protected List getModelTargetConnections() {
		return ((NodeVisualModel) getModel()).getTargetConnections();
	}
		
	protected ConnectionAnchor getConnectionAnchor() {			
		if (anchor == null)
			anchor = new ConnectionToConnectionAnchor((LineConnection)getFigure());
		return anchor;
	}
	
	public ConnectionAnchor getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart connection) {
		return null;
	}
	
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return null;
	}

	public ConnectionAnchor getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart connection) {
		return getConnectionAnchor();
	}
	
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		CreateConnectionRequest r = (CreateConnectionRequest) request;
		if (r.getNewObjectType().equals(NoteConnectionEditPart.NOTE_CONNECTION))
			return getConnectionAnchor();
		return null;
	}
	
	public CompoundCommand getConnectionsDeleteCommand(List connections) {
		CompoundCommand commands = new CompoundCommand();
		for (int i=0; i<connections.size(); i++) {
			EditPart selectionEditPart = (EditPart)connections.get(i);
			GroupRequest request = new GroupRequest();
			request.setEditParts(selectionEditPart);
			request.setType(RequestConstants.REQ_DELETE);
			commands.add(selectionEditPart.getCommand(request));
		}
		if (commands.size() == 0) return null;
		return commands;
	}
	
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		int type = notification.getEventType();
		int featureId = notification.getFeatureID(EditormodelPackage.class);
		if (notification.getNotifier() instanceof ConnectionVisualModel) {
			switch(type) {
				case Notification.ADD:
				case Notification.SET:
				case Notification.REMOVE:
					switch(featureId) {
						case EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE_CONNECTIONS:
							refreshSourceConnections();
							break;
						case EditormodelPackage.CONNECTION_VISUAL_MODEL__TARGET_CONNECTIONS:
							refreshTargetConnections();
							break;
					}
			}
		}
	}
}