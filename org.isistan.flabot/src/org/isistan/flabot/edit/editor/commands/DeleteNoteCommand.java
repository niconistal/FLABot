/**
 * $Id: DeleteNoteCommand.java,v 1.7 2006/03/21 01:51:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.commands;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * DeleteNoteCommand Mentioned in table as RemoveNoteCommand)
 * -	Removes a note visual model and its referenced note from diagram's list of notes.
 * 
 * @author $Author: franco $
 *
 */
public class DeleteNoteCommand extends Command {
	
	private final NodeVisualModel child;
	private final Diagram diagram;
	private boolean wasRemoved;
	
	/**
	 * Instantiates a command that can remove the note.
	 * @param diagram the diagram where the note is
	 * @param child the visual model of the note to remove
	 */
	public DeleteNoteCommand(Diagram diagram, NodeVisualModel child) {
		setLabel(Messages.getString("org.isistan.flabot.edit.editor.commands.DeleteNoteCommand.label")); //$NON-NLS-1$
		this.child = child;
		this.diagram = diagram;
	}
	
	/**
	 * The command can be undo if the note was removed.
	 * @return <code>true</code> if the command can be undone
	 */
	public boolean canUndo() {
		return wasRemoved;
	}
	
	/**
	 * Verifies that the command can be executed.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		return (diagram != null && child != null);
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
	 * Removes the note to the diagram's list of notes.
	 * Unsets the diagram of visual model of note.
	 */	
	public void redo() {			
		wasRemoved = diagram.getNotes().remove(child.getSemanticModel());
		if (wasRemoved)
			child.setDiagram(null);
	}
		
	/**
	 * Adds the note to the diagram's list of notes.
	 * Sets the diagram of visual model of note as the old diagram.
	 */	
	public void undo() {
		if (diagram.getNotes().add(child.getSemanticModel()))
			child.setDiagram(diagram);	
	}
}