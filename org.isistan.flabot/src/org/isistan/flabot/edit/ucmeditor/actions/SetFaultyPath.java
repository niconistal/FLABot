
package org.isistan.flabot.edit.ucmeditor.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.TimerNode;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.editor.commands.NotifierCommandWrapper;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.model.ModifyComponentCommand;
import org.isistan.flabot.edit.ucmeditor.commands.model.ModifyTimerCommand;
import org.isistan.flabot.edit.ucmeditor.dialogs.EditComponentDialog;
import org.isistan.flabot.edit.ucmeditor.dialogs.EditTimerDialog;
import org.isistan.flabot.edit.ucmeditor.editparts.ComponentEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.TimerNodeEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.UCMDiagramEditPart;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;


public class SetFaultyPath extends SelectionAction{

  /**
	 * Action id
	 */
	public static final String
		EDIT_COMPONENT = "EDIT_COMPONENT";   //$NON-NLS-1$

	/**
	 * Creates a new EditComponentAction in the given workbench part
	 * @param part
	 */
	 public SetFaultyPath(IWorkbenchPart part) {
		super(part);

		setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.SetFaultyPath.text")); //$NON-NLS-1$
		setId(EDIT_COMPONENT);
	}
	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if a component is selected, false otherwise
	 */
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if a component is selected, false otherwise
	 */
	 private boolean canPerformAction() {
	 
	 	if (getSelectedObjects().isEmpty())
			return false;
		List parts = getSelectedObjects();

		if (parts.size() > 1) 
			return false;

		Object o = parts.get(0);
		if (!(o instanceof PathNodeEditPart))
			return false;
		PathNodeEditPart part = (PathNodeEditPart)o;
		SimplePathNode node = (SimplePathNode)part.getSemanticModel();
	 	return node.isEnd();
	 }
	 
	private Command getCommand() {
		List editparts = getSelectedObjects();
		PathNodeEditPart part = (PathNodeEditPart)editparts.get(0);
		NodeVisualModel visualNode = part.getCastedModel();				
		return new SetFaultyPath(visualNode);
	}

	/**
	 * Creates a command and then executes it.
	 */
	@Override
	public void run() {
		Command command = getCommand();
		CommandExecutor commandExecutor = (CommandExecutor)getWorkbenchPart().getAdapter(CommandExecutor.class);
		commandExecutor.executeCommand(command, false);
	}



}
