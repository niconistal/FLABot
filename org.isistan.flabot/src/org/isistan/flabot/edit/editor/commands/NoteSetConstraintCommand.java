/**
 * $Id: NoteSetConstraintCommand.java,v 1.11 2006/03/21 01:51:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.commands;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.edit.editor.figures.NoteFigure;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * NoteSetConstraintCommand 
 * -	Establishes a new location and dimension to a visual model.
 * 
 * @author $Author: franco $
 *
 */
public class NoteSetConstraintCommand extends Command {

	private final Rectangle newBounds;
	private Rectangle oldBounds;
	
	private final VisualModel visualModel;
	
	/**
	 * Instantiates a command that can resize and/or move a note. 
	 * @param visualModel the visual model of the note to manipulate
	 * @param newBounds the new size and location
	 * @throws IllegalArgumentException if any of the parameters is null
	 */
	public NoteSetConstraintCommand(VisualModel visualModel, Rectangle newBounds) {
		if (newBounds == null) {
			throw new IllegalArgumentException();
		}
		this.visualModel = visualModel;
		this.newBounds = newBounds.getCopy();
		setLabel(Messages.getString("org.isistan.flabot.edit.editor.commands.NoteSetConstraintCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * Verifies that the command can be executed.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		return (visualModel != null && newBounds != null);
	}
		
	/**
	 * Executes the Command. This method should not be called if the Command is not
	 * executable.
	 * Sets the new bounds to the visual model. If the new bounds cannot be applied, the minimun bounds of the visual model is set.
	 * 
	 *  @see redo()
	 */
	public void execute() {
		oldBounds = Util.getDraw2DRectangle(
				visualModel.getLocation(), 
				visualModel.getSize());
		newBounds.setSize(newBounds.getSize().union(NoteFigure.defaultsize));
		redo();
	}
	
	/**
	 * Sets the new bounds to the visual model
	 */	
	public void redo() {
		visualModel.setLocation(Util.getPoint(newBounds.getLocation()));
		visualModel.setSize(Util.getDimension(newBounds.getSize().width, newBounds.getSize().height));
	}
	
	/**
	 * Sets the old bounds to the visual model 
	 */	
	public void undo() {
		visualModel.setLocation(Util.getPoint(oldBounds.getLocation()));
		visualModel.setSize(Util.getDimension(oldBounds.getSize().width, oldBounds.getSize().height));
	}
}