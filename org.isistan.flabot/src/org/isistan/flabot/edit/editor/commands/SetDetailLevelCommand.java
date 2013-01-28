/**
 * $Id: SetDetailLevelCommand.java,v 1.2 2006/03/21 01:51:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.commands;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * SetDetailLevelComponentCommand
 * -	Sets the level of detail in a visual model.
 * 
 * @author $Author: franco $
 *
 */
public class SetDetailLevelCommand extends Command {
	
	private VisualModel visual;
	private int newDetailLevel;
	private int oldDetailLevel;

	/**
	 * Instantiates a command that can sets the level of detail in a visual model.
	 * @param visual the visual model to set
	 * @param detailLevel the level of detail
	 */
	public SetDetailLevelCommand(VisualModel visual, int detailLevel) {
		this.visual = visual;
		this.newDetailLevel = detailLevel;
		this.oldDetailLevel = visual.getDetailLevel();
		setLabel(Messages.getString("org.isistan.flabot.edit.editor.commands.SetDetailLevelCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * Verifies that the command can be executed.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		return visual != null;
	}
	
	/**
	 * Executes the command. This method should not be called if the command is not
	 * executable.
	 * 
	 * @see redo()
	 */
	public void execute() {
		redo();
	}
	
	/**
	 * Sets the new level of detail in the visual model
	 */	
	public void redo() {
		visual.setDetailLevel(newDetailLevel);
	}
	
	/**
	 * Restores the old level of detail in the visual model
	 */	
	public void undo() {
		visual.setDetailLevel(oldDetailLevel);
	}
}