/**
 * $Id: AddDiagramToFolderCommand.java,v 1.5 2006/03/21 01:51:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.commands;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.Folder;
import org.isistan.flabot.messages.Messages;

/**
 * AddDiagramToFolderCommand
 * -	Adds a diagram to a folder.
 * 
 * @author $Author: franco $
 *
 */
public class AddDiagramToFolderCommand extends Command {
	
	private Diagram diagram;
	private Folder newFolder;	
	private Folder oldFolder;

	/**
	 * Instantiates a command that can add a diagram to a folder.
	 * @param diagram the diagram to add
	 * @param folder the folder in which the diagram will be added  
	 */
	public AddDiagramToFolderCommand(Diagram diagram, Folder folder) {
		this.diagram = diagram;
		this.newFolder = folder;
		setLabel(Messages.getString("org.isistan.flabot.edit.editor.commands.AddDiagramToFolderCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * Verifies that the command can be executed.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		return (diagram != null && newFolder != null);
	}

	/**
	 * Executes the Command. This method should not be called if the command is not
	 * executable.
	 * 
	 * @see redo()
	 */
	public void execute() {		
		oldFolder = diagram.getFolder();
		redo();
	}

	/**
	 * Sets the new folder in the diagram.
	 */	
	public void redo() {
		diagram.setFolder(newFolder);		
	}

	/**
	 * Restores the old folder in the diagram.
	 */
	public void undo() {
		diagram.setFolder(oldFolder);
	}
}