/**
 * $Id: EditorActivatorCommandWrapper.java,v 1.4 2005/12/23 00:47:18 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.commands;

import org.eclipse.gef.commands.Command;
import org.eclipse.ui.IEditorPart;
import org.isistan.flabot.edit.editor.FlabotGraphicalEditor;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;

/**
 * Wraps a command to activate the editor that originally executed the command
 * on undo and redo.
 * @author $Author: franco $
 *
 */
public class EditorActivatorCommandWrapper extends Command {

	private Command wrappedCommand;
	private FlabotMultiPageEditor multipageEditor;
	private Diagram activeDiagram;

	/**
	 * Create a new instance of EditorActivatorCommandWrapper for the given
	 * command and IEditorPart
	 * @param wrappedCommand the wrapped command
	 * @param multipageEditor the multipage editor
	 */
	public EditorActivatorCommandWrapper(
			Command wrappedCommand, FlabotMultiPageEditor multipageEditor) {
		this.wrappedCommand = wrappedCommand;
		this.multipageEditor = multipageEditor;
		activeDiagram = getActiveDiagram(multipageEditor);
	}
	
	private Diagram getActiveDiagram(FlabotMultiPageEditor multipageEditor2) {
		IEditorPart activeEditor = multipageEditor.getActiveEditor();
		if (activeEditor != null && activeEditor instanceof FlabotGraphicalEditor) {
			FlabotGraphicalEditor graphicalEditor =
				(FlabotGraphicalEditor) activeEditor;
			return graphicalEditor.getModel();
		}
		return null;
	}

	public void dispose() {
		super.dispose();
		wrappedCommand.dispose();
	}

	public boolean canExecute() {
		return wrappedCommand.canExecute();
	}

	public boolean canUndo() {
		return wrappedCommand.canUndo();
	}

	public void execute() {
		wrappedCommand.execute();
	}

	public String getDebugLabel() {
		return wrappedCommand.getDebugLabel();
	}

	public String getLabel() {
		return wrappedCommand.getLabel();
	}

	public void redo() {
		wrappedCommand.redo();
		activateEditor();
	}

	public void setDebugLabel(String label) {
		wrappedCommand.setDebugLabel(label);
	}

	public void setLabel(String label) {
		wrappedCommand.setLabel(label);
	}

	public String toString() {
		return wrappedCommand.toString();
	}

	public void undo() {
		wrappedCommand.undo();
		activateEditor();
	}

	private void activateEditor() {
		if (mustSwitch())
			multipageEditor.openDiagram(activeDiagram);
	}

	private boolean mustSwitch() {
		if (activeDiagram == null ||
				activeDiagram == getActiveDiagram(multipageEditor))
			return false;
		return true;
	}	
}