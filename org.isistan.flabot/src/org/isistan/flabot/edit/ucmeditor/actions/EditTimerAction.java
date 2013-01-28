package org.isistan.flabot.edit.ucmeditor.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.coremodel.TimerNode;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.editor.commands.NotifierCommandWrapper;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.model.ModifyTimerCommand;
import org.isistan.flabot.edit.ucmeditor.dialogs.EditTimerDialog;
import org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.TimerNodeEditPart;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

public class EditTimerAction extends SelectionAction {
	
	/**
	 * Action id
	 */
	public static final String
		EDIT_TIMER = "EDIT_TIMER";   //$NON-NLS-1$

	/**
	 * Creates a new EditTimerAction in the given workbench part
	 * @param part
	 */
	public EditTimerAction(IWorkbenchPart part) {
		super(part);
		
		setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditTimerAction.text")); //$NON-NLS-1$
		setId(EDIT_TIMER);
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if a timer node is selected, false otherwise
	 */
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if a timer node is selected, false otherwise
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
		if (!(part.getCastedModel().getSemanticModel() instanceof TimerNode))
			return false;
		
		return true;
	}

	/**
	 * Opens a dialog for the user to edit the selected resonsibility node and then
	 * creates a command that executes the changes, that include pre and post condition modification (add/remove/modify) and responsibility properties (name, description, show dependencies or not).
	 * 
	 * @return the created command
	 */
	private Command getCommand() {		
		List editparts = getSelectedObjects();
		TimerNodeEditPart part = (TimerNodeEditPart)editparts.get(0);
		NodeVisualModel visualNode = part.getCastedModel();
		
		TimerNode timerNode = (TimerNode) part.getCastedModel().getSemanticModel();		
		UCMDiagram diagram = (UCMDiagram) visualNode.getDiagram();
		
		EditTimerDialog dialog = new EditTimerDialog(Display.getCurrent().getActiveShell(), timerNode);		
		TimerNode timerCopy = dialog.open(diagram.getMap());
		
		//if the action was not cancelled
		if (timerCopy != null) {
			CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditTimerAction.commandLabel"));  //$NON-NLS-1$
			
			commands.add( new ModifyTimerCommand(timerNode, timerCopy));
			
			return commands;
		}

		return null;
	}
	
	/**
	 * Shows an edition dialog, creates a command and then executes it.
	 */
	@Override
	public void run() {
		Command command = getCommand();
		if (command != null) {
			command = new NotifierCommandWrapper(command,
					getWorkbenchPart().getSite().getShell());
			CommandExecutor commandExecutor = (CommandExecutor)getWorkbenchPart().getAdapter(CommandExecutor.class);
			commandExecutor.executeCommand(command, false);
		}
	}
}
