/**
 * $Id: EditNoteCommand.java,v 1.7 2006/03/21 01:51:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.commands;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.Note;
import org.isistan.flabot.messages.Messages;

/**
 * EditNoteCommand
 * -	Changes the text contained by the note.
 * 
 * @author $Author: franco $
 *
 */
public class EditNoteCommand extends Command {

	private String newName, oldName;
	private Note note;

	/**
	 * Instantiates a command that can change the text contained by the note.
	 * @param note the note to change
	 * @param s the text to set in the note
	 */
	public EditNoteCommand(Note note, String s) {
		this.note = note;
		if (s != null)
			newName = s;
		else
			newName = "";  //$NON-NLS-1$
		setLabel(Messages.getString("org.isistan.flabot.edit.editor.commands.EditNoteCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * Verifies that the command can be executed.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {	
		return (note != null);
	}	

	/**
	 * Executes the Command. This method should not be called if the Command is not
	 * executable.
	 * 
	 *  @see redo()
	 */	
	public void execute() {
		oldName = new String(note.getNote());
		redo();
	}

	/**
	 * Sets the new text in the note.
	 */
	public void redo() {
		note.setNote(newName);
	}
	
	/**
	 * Restores the old text in the note.
	 */
	public void undo() {
		note.setNote(oldName);
	}
}