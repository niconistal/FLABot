/**
 * $Id: CreateUCMEditorCommand.java,v 1.5 2006/03/21 01:51:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.commands;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

/**
 * This command creates and open a new UCM digram and UCM editor in a FlabotMultiPageEditor
 * 
 * @author $Author: franco $
 *
 */
public class CreateUCMEditorCommand extends Command {
	
	private FlabotMultiPageEditor editor;
	private FlabotFileModel fileModel;
	private UCMDiagram diagram;
	
	/**
	 * Instantiates a command that can create and open a UCM editor.
	 * @param editor the FlabotMultiPageEditor
	 * @param diagram the new UCM diagram
	 */
	public CreateUCMEditorCommand(FlabotMultiPageEditor editor, UCMDiagram diagram) {
		this.editor = editor;
		this.diagram = diagram;
		setLabel(Messages.getString("org.isistan.flabot.edit.editor.commands.CreateUCMEditorCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * Verifies that the command can be executed.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		return (editor != null && diagram != null);
	}
	
	/**
	 * Executes the Command. This method should not be called if the command is not
	 * executable.
	 * 
	 * @see redo()
	 */
	public void execute() {
		this.fileModel = editor.getModel();
		redo();
	}
	
	/**
	 * Creates a new Component editor in the FlabotMultiPageEditor.
	 * Adds the new diagram to the FlabotFileModel
	 * Adds the new map to the CoreModel
	 */
	public void redo() {
		fileModel.getCoreModel().getUseCaseMaps().add(diagram.getMap());
		fileModel.getDiagrams().add(diagram);
		editor.createNewUCMEditor(diagram);		
	}
	
	/**
	 * Removes the new Component editor in the FlabotMultiPageEditor.
	 * Removes the new diagram from the FlabotFileModel
	 * Removes the new map from the CoreModel
	 */
	public void undo() {
		editor.removeDiagram(diagram);
		fileModel.getCoreModel().getUseCaseMaps().remove(diagram.getMap());
		fileModel.getDiagrams().remove(diagram);
	}
}