/**
 * $Id: NoteConnectionEditPart.java,v 1.5 2005/12/15 19:49:21 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.editparts;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.editpolicies.ContainerEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.isistan.flabot.edit.editor.commands.DeleteNoteConnectionCommand;
import org.isistan.flabot.edit.editor.commands.paste.AddNoteConnectionPasteCommand;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;

/**
 * @author $Author: franco $
 *
 */
public class NoteConnectionEditPart extends ConnectionEditPart {

	public static final String NOTE_CONNECTION = "NoteConnection"; //$NON-NLS-1$
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
		super.createEditPolicies();
		
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new ContainerEditPolicy() {
			
			public Command getCloneCommand(ChangeBoundsRequest request) {														
				ConnectionVisualModel copyVisualModel  = (ConnectionVisualModel)getHost().getModel();				
				AddNoteConnectionPasteCommand command = new AddNoteConnectionPasteCommand(copyVisualModel);
				return command;
			}
			
			public Command getCreateCommand(CreateRequest request) {
				return null;
			}
		});
		
		// Allows the removal of the connection model element
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy() {
			protected Command getDeleteCommand(GroupRequest request) {
				return new DeleteNoteConnectionCommand((ConnectionVisualModel) getHost().getModel());
			}
		});
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	protected IFigure createFigure() {
		PolylineConnection connection = (PolylineConnection) super.createFigure();
		connection.setLineWidth(1);
		connection.setLineStyle(Graphics.LINE_SOLID);
		connection.setOpaque(false);
		return connection;		
	}
}