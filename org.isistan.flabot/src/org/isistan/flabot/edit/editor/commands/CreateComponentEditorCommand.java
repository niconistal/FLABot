/**
 * $Id: CreateComponentEditorCommand.java,v 1.4 2006/03/21 01:51:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.commands;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.edit.componentmodel.ComponentDiagram;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;
import org.isistan.flabot.messages.Messages;

/**
 * This command creates and open a new Component digram and Component editor in a FlabotMultiPageEditor
 * 
 * @author $Author: franco $
 *
 */
public class CreateComponentEditorCommand extends Command {
	
	private FlabotMultiPageEditor editor;
	private FlabotFileModel fileModel;
	private ComponentDiagram diagram;
	
	/**
	 * Instantiates a command that can create and open a Component editor.
	 * @param editor the FlabotMultiPageEditor
	 * @param diagram the new Component diagram
	 */
	public CreateComponentEditorCommand(FlabotMultiPageEditor editor, ComponentDiagram diagram) {
		this.editor = editor;
		this.diagram = diagram;		
		setLabel(Messages.getString("org.isistan.flabot.edit.editor.commands.CreateComponentEditorCommand.label")); //$NON-NLS-1$
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
	 */
	public void redo() {
		fileModel.getDiagrams().add(diagram);
		editor.createNewComponentEditor(diagram);		
	}
	
	/**
	 * Removes the new Component editor in the FlabotMultiPageEditor.
	 * Removes the new diagram from the FlabotFileModel
	 */
	public void undo() {
		editor.removeDiagram(diagram);
		fileModel.getDiagrams().remove(diagram);
	}
}