/**
 * $Id: DeleteRelationshipConnectionCommand.java,v 1.2 2006/03/20 19:54:41 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.visual;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * -	Removes a relationship connection between two components 
 *      and removes the component relationship from the Core Model.
 * 
 * @author $Author: franco $
 *
 */
public class DeleteRelationshipConnectionCommand extends Command {
	
	private final ConnectionVisualModel connection;
	private NodeVisualModel source;
	private NodeVisualModel target;
	
	private CoreModel coreModel;
	
	/**
	 *	Instantiates a command that can remove a connection between two components.
	 * @param coreModel the core model where the connection model exists
	 * @param connection the visual model of the connection
	 */
	public DeleteRelationshipConnectionCommand(CoreModel coreModel, ConnectionVisualModel connection) {
		this.connection = connection;
		this.coreModel = coreModel;
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.DeleteRelationshipConnectionCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * Verifies that the command can be executed.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		return (connection != null);
	}
	
	/**
	 * Sets up the required variables for the execution of the redo method and calls it.
	 * 
	 * @see redo()
	 */
	public void execute() {
		source = connection.getSource();
		target = connection.getTarget();
		
		redo();
	}

	/**
	 * Removes the semantic relationship model from the core model.
	 * Unsets the source and target to the connection visual model.
	 */	
	public void redo() {
		coreModel.getRelationships().remove(connection.getSemanticModel());				
		connection.setSource(null);
		connection.setTarget(null);
	}
	
	/**
	 * Adds the semantic relationship model to the core model.
	 * Sets the source and target visual models to the connection visual model.
	 */	
	public void undo() {
		coreModel.getRelationships().add(connection.getSemanticModel());
		connection.setSource(source);
		connection.setTarget(target);
	}
}