/**
 * $Id: DeleteNoteConnectionCommand.java,v 1.7 2006/03/21 01:51:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.commands;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.Note;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * DeleteNoteConnectionCommand
 * -	Deletes a note connection.
 * -	Deletes the semantic note from the target.
 * 
 * @author $Author: franco $
 *
 */
public class DeleteNoteConnectionCommand extends Command {
	
	private ConnectionVisualModel connection;
	
	private NodeVisualModel source;
	private NodeVisualModel target;
	
	/**
	 * Instantiates a command that can deletes a note connection.
	 * @param connection the visual model of the connection tha will be deleted
	 */
	public DeleteNoteConnectionCommand(ConnectionVisualModel connection) {
		this.connection = connection;
		source = connection.getSource();
		target = connection.getTarget();
		setLabel(Messages.getString("org.isistan.flabot.edit.editor.commands.DeleteNoteConnectionCommand.label")); //$NON-NLS-1$
	}

	/**
	 * Verifies that the command can be executed.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		return (connection != null && source != null && target != null);
	}
	
	/**
	 * Executes the Command. This method should not be called if the Command is not
	 * executable.
	 * 
	 * @see redo()
	 */
	public void execute() {
		redo();
	}
	
	/**
	 * Removes the note from the NotedElementModel.
	 * Unsets the source and target of the connection visual model.
	 */	
	public void redo() {
		((Note) source.getSemanticModel()).getTargets().remove(target.getSemanticModel());
		connection.setSource(null);
		connection.setTarget(null);
	}
	
	/**
	 * Adds the note to the NotedElementModel.
	 * Sets the source and target of the connection visual model.
	 */	
	public void undo() {
		connection.setTarget(target);	
		connection.setSource(source);
		((Note)source.getSemanticModel()).getTargets().add(target.getSemanticModel());
	}	
}