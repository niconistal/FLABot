/**
 * $Id: AddNoteConnectionCommand.java,v 1.9 2006/03/21 01:51:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.commands;

import java.util.Iterator;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.Note;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * AddNoteConnectionCommand
 * -	Adds a connection from a note to visual model.
 * -	Adds the note to the semantic model of the target (a NotedElementModel).
 * 
 * @author $Author: franco $
 *
 */
public class AddNoteConnectionCommand extends Command {

	protected ConnectionVisualModel connection;	

	protected NodeVisualModel source;
	protected NodeVisualModel target;
	
	/**
	 * Instantiates a command that can add a connection from a note to visual model.
	 * @param source the visual model of the note
	 * @param connection the visual model of the connection
	 */
	public AddNoteConnectionCommand(NodeVisualModel source, ConnectionVisualModel connection) {		
		setLabel(Messages.getString("org.isistan.flabot.edit.editor.commands.AddNoteConnectionCommand.label")); //$NON-NLS-1$
		this.source = source;
		this.connection = connection;
	}
		
	/**
	 * Verifies that the command can be executed.
	 * The connection must not be duplicated (source -> target connection exists already) 
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		if (source == null || connection == null)
			return false;
		
		// disallow source -> source connections
		if (source == null || target == null || 
				connection == null || source.equals(target)) {
			return false;
		}
		// return false, if the source -> target connection exists already
		for (Iterator iter = source.getSourceConnections().iterator(); iter.hasNext();) {
			ConnectionVisualModel conn = (ConnectionVisualModel) iter.next();
			if (conn.getTarget().equals(target)) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * Sets the target for the connection.
	 * @param target the target
	 * @throws IllegalArgumentException if target is null
	 */
	public void setTarget(NodeVisualModel target) {
		if (target == null) {
			throw new IllegalArgumentException();
		}
		this.target = target;
	}

	/**
	 * Executes the Command. This method should not be called if the Command is not
	 * executable.
	 * 
	 * @see redo()
	 */
	public void execute() {
		// create a new connection between source and target		
		redo();
	}
	
	/**
	 * Adds the note to the NotedElementModel.
	 * Sets the source and target of the connection visual model.
	 */	
	public void redo() {			
		((Note)source.getSemanticModel()).getTargets().add(target.getSemanticModel());
		
		connection.setSemanticModel(source.getSemanticModel());
		connection.setSource(source);
		connection.setTarget(target);
	}	
	
	/**
	 * Removes the note from the NotedElementModel.
	 * Unsets the source and target of the connection visual model.
	 */	
	public void undo() {
		connection.setSource(null);
		connection.setTarget(null);		
		connection.setSemanticModel(null);
		
		((Note)source.getSemanticModel()).getTargets().remove(target.getSemanticModel());								
	}
}