/**
 * $Id: AddDiagramFolder.java,v 1.3 2006/03/21 01:51:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.commands;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.editormodel.Folder;
import org.isistan.flabot.messages.Messages;

/**
 * CreateDiagramFolder
 * -	Creates a new folder.
 * 
 * @author $Author: franco $
 *
 */
public class AddDiagramFolder extends Command {
	
	private String name;
	private Folder parent = null;	
	private Folder folder = null;

	/**
	 * Instantiates a command that can create a new folder.
	 * @param name the name of the folder to create
	 * @param parent the parent folder
	 */
	public AddDiagramFolder(String name, Folder parent) {
		this.name = name;
		this.parent = parent;
		setLabel(Messages.getString("org.isistan.flabot.edit.editor.commands.AddDiagramFolder.label")); //$NON-NLS-1$
	}
	
	/**
	 * Verifies that the command can be executed.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		if (parent == null)
			return false;
		FlabotFileModel fileModel = parent.getFileModel();
		if (fileModel == null)
			return false;
		if (fileModel.eContainer() != null) {
			// the file is contained in another file, don't allow folder creation
			return false;
		}
		return true;
	}

	/**
	 * Executes the Command. This method should not be called if the Command is not
	 * executable.
	 * 
	 * @see redo()
	 */
	public void execute() {
		folder = EditormodelFactory.eINSTANCE.createFolder(name);	
		redo();
	}

	/**
	 * Sets the parent of the folder.
	 */	
	public void redo() {		
		folder.setParent(parent);
	}

	/**
	 * Unsets the parent of the folder.
	 */	
	public void undo() {
		folder.setParent(null);
	}
}