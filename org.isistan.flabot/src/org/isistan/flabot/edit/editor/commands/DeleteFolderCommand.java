/**
 * $Id: DeleteFolderCommand.java,v 1.7 2006/03/21 01:51:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.commands.CompoundCommand;
import org.isistan.flabot.edit.editormodel.Folder;
import org.isistan.flabot.messages.Messages;

/**
 * DeleteFolderCommand
 * -	Deletes a folder and subfolders from the FlabotFileModel and also dessasing its diagrams.
 * -	Adds the note to the semantic model of the target (a NotedElementModel).
 * 
 * @author $Author: franco $
 *
 */
public class DeleteFolderCommand extends CompoundCommand {
	
	private Folder folder;
	
	private Folder oldParent;
	private List oldFolders = new ArrayList();
	
	/**
	 * Instantiates a command that can add a connection from a note to visual model.
	 * @param folder the folder to delete
	 */
	public DeleteFolderCommand(Folder folder) {
		this.folder = folder;
		setLabel(Messages.getString("org.isistan.flabot.edit.editor.commands.DeleteFolderCommand.label")); //$NON-NLS-1$
	}
		
	/**
	 * @return <code>true</code> if the command can be undone
	 */
	public boolean canUndo() {		
		return true;
	}
	
	/**
	 * Verifies that the command can be executed.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		if (folder == null)
			return false;
		if (folder.getFileModel() == null)
			return false; //the folder isn't in a file
		if (folder.getFileModel().eContainer() != null)
			return false; // the folder is in an imported file
		return true;
	}
	
	/**
	 * Executes the Command. This method should not be called if the Command is not
	 * executable.
	 * The command first execute all the DeleteFolderCommand of its subfolders.
	 * 
	 *  @see redo()
	 */
	public void execute() {
		List folders = folder.getFolders();
		for (Iterator iter = folders.iterator(); iter.hasNext();) {
			Folder f = (Folder) iter.next();
			add(new DeleteFolderCommand(f));
		}
		
		super.execute();
		
		oldParent = folder.getParent();		
		addListToList(folder.getFolders(), oldFolders);
		redo();
	}
		
	private void addListToList(List source, List target) {
		for(Iterator iter=source.iterator(); iter.hasNext();)
			target.add(iter.next());
	}
		
	/**
	 * Removes the folder diagrams.
	 * Unsets the parent of the folder.
	 */	
	private void doDeleteFolder() {
		folder.getDiagrams().clear();
		folder.setParent(null);		
	}
	
	/**
	 * Adds the removed folder diagrams.
	 * Sets the parent of the folder to the old one.
	 */	
	private void undoDeleteFolder() {		
		folder.setParent(oldParent);
		addListToList(oldFolders, folder.getFolders());		
	}

	@Override
	public void redo() {		
		super.redo();
		doDeleteFolder();
	}
	
	@Override
	public void undo() {
		undoDeleteFolder();
		super.undo();
	}
}