/**
 * $Id: AddNewFolderAction.java,v 1.13 2006/03/17 22:28:02 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.editor.commands.AddDiagramFolder;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.editormodel.Folder;
import org.isistan.flabot.edit.outline.DiagramFolderTreeEditPart;
import org.isistan.flabot.edit.outline.DiagramTreeEditPart;
import org.isistan.flabot.edit.outline.FlabotModelTreeEditPart;
import org.isistan.flabot.messages.Messages;

/**
 * This action is used to add a new folder from the Outline. 
 * 
 * @author $Author: franco $
 *
 */
public class AddNewFolderAction extends Action {

	/**
	 * Action id
	 */
	public static final String
		ADD_FOLDER = "ADD_FOLDER";   //$NON-NLS-1$

	private EditPartViewer viewer;
	
	private Folder parent;

	private CommandExecutor commandExecutor;
	
	/**
	 * Creates a new AddNewFolderAction in the given viewer
	 * @param viewer
	 * @param commandExecutor
	 */
	public AddNewFolderAction(EditPartViewer viewer, CommandExecutor commandExecutor) {
		this.viewer = viewer;
		this.commandExecutor = commandExecutor;
		setText(Messages.getString("org.isistan.flabot.edit.editor.actions.AddNewFolderAction.text")); //$NON-NLS-1$
		setId(ADD_FOLDER);
	}
	
	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if a DiagramTreeEditPart or a  DiagramFolderTreeEditPart is selected, false otherwise
	 */
	@Override
	public boolean isEnabled() {
		return canPerformAction();
	}
	
	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if a DiagramTreeEditPart or a  DiagramFolderTreeEditPart is selected, false otherwise
	 */
	private boolean canPerformAction() {		
		if (getViewer().getSelectedEditParts().isEmpty())
			return false;
		
		List parts = getViewer().getSelectedEditParts();		
		if (parts.size() > 1) 
			return false;
		
		EditPart part = (EditPart) getViewer().getSelectedEditParts().get(0);	    	
    	parent = null;
    	if (part instanceof DiagramFolderTreeEditPart)
    		parent = (Folder)part.getModel();
    	else {
    		if (part instanceof DiagramTreeEditPart)
    			if (((Diagram)part.getModel()).getFolder() != null)	    			
	    			parent = ((Diagram)part.getModel()).getFolder();
	    		else 	    						
	    			parent = getMainFolder(part);	    		
    	}
    	if (parent == null)
    		return false; // the parent folder can't be determined
    	if (parent.getFileModel() == null)
    		return false; // the parent folder isn't contained in a file model
    	if (parent.getFileModel().eContainer() != null)
    		return false; // the container file model is an imported file
		
		return true;		
	}

	/**
	 * Returns the root folder for the given edit part.
	 * The root folder is the folder of the FlabotFileModel. Inside this folder are inserted the others.
	 * 
	 * @param part the edit part
	 * @return the root folder
	 */
	private Folder getMainFolder(EditPart part) {
		EditPart root = part;
		while (root.getParent().getModel() != null)
			root = (FlabotModelTreeEditPart) root.getParent();
	
		FlabotFileModel fileModel = (FlabotFileModel)root.getModel();
		return fileModel.getFolder();
	}
		
	/**
	 * Opens a dialog for the user to give a name for the folder, then
	 * creates a command that executes the insertion. 
	 * 
	 * @return the created command
	 */
	private Command getCommand() {
		
		InputDialog dlg = new InputDialog(
				getViewer().getControl().getShell(),
	            Messages.getString("org.isistan.flabot.edit.editor.actions.AddNewFolderAction.text"), //$NON-NLS-1$
	            Messages.getString("org.isistan.flabot.edit.editor.actions.AddNewFolderAction.enterFolderName"), //$NON-NLS-1$
	            "", //$NON-NLS-1$
	            null); //This is an optional validation class
	    dlg.open();

	    if(dlg.getReturnCode()==Window.OK)
	    	return new AddDiagramFolder(dlg.getValue(), parent);

		return null;
	}

	/**
	 * Shows an edition dialog, creates a command and then executes it.
	 */
	@Override
	public void run() {
		Command command = getCommand();
		if (command == null || !command.canExecute())
			return;
		commandExecutor.executeCommand(command, false);
	}
	
	/**
	 * Returns the edit part viewer of this action
	 *  
	 * @return the edit part viewer
	 */
	protected EditPartViewer getViewer() {
		return viewer;
	}
}