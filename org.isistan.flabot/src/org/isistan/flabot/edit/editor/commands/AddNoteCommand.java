/**
 * $Id: AddNoteCommand.java,v 1.11 2006/03/21 01:51:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.commands;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.edit.editor.figures.NoteFigure;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.messages.Messages;

/**
 * AddNoteCommand
 * -	Creates a new note and adds it into the diagram's notes list. And creates a visual model referent to the note.
 * @author $Author: franco $
 *
 */
public class AddNoteCommand extends Command {
	
	protected Diagram diagram;
	protected NodeVisualModel visualModel = null;
	protected Rectangle bounds = null;
	
	private boolean noteAdded = false;
	
	/**
	 * Instantiates a command that can Creates a new note and adds it into the diagram's notes list.
	 * @param diagram the diagram in which the note will be added
	 * @param bounds the bounds (size and location) of the note in the diagram  
	 */
	public AddNoteCommand(NodeVisualModel visualModel, Diagram diagram, Rectangle bounds) {
		this.visualModel = visualModel;
		this.diagram = diagram;
		this.bounds = bounds;
		setLabel(Messages.getString("org.isistan.flabot.edit.editor.commands.AddNoteCommand.label")); //$NON-NLS-1$
	}	
	
	/**
	 * The command can be undone if the note was added to the diagram.
	 * @return <code>true</code> if the command can be undone
	 */
	public boolean canUndo() {
		return noteAdded;
	}
	
	/**
	 * Verifies that the command can be executed.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		return (diagram != null && bounds != null);
	}

	/**
	 * Executes the Command. This method should not be called if the command is not
	 * executable.
	 * Creates the visual and semantic model of the note.
	 * 
	 * @see redo()
	 */
	public void execute() {
		visualModel.setLocation(Util.getPoint(bounds.getLocation()));		
		visualModel.setSize(Util.getDimension(NoteFigure.defaultsize));
		
		redo();
	}

	/**
	 * Adds the note to the diagram's note list.
	 * Sets the diagram of the visual note.
	 */	
	public void redo() {
		noteAdded = diagram.getNotes().add(visualModel.getSemanticModel());
		if (noteAdded)
			visualModel.setDiagram(diagram);
	}

	/**
	 * Removes the note from the diagram's note list.
	 * Unsets the diagram of the visual note.
	 */	
	public void undo() {
		if (diagram.getNotes().remove(visualModel.getSemanticModel()))		
			visualModel.setDiagram(null);
	}
}