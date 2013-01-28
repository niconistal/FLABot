package org.isistan.flabot.executionstatemapping.editor.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.executionstatemapping.commands.diagram.ChangeStateInfoValueActionCommand;
import org.isistan.flabot.executionstatemapping.editor.dialogs.ChooseFinalStateValueDialog;
import org.isistan.flabot.executionstatemapping.editor.editparts.StateEditPart;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue;
import org.isistan.flabot.executionstatemapping.model.semantic.FinalState;
import org.isistan.flabot.executionstatemapping.model.semantic.State;
import org.isistan.flabot.executionstatemapping.model.semantic.StateType;

public class ChangeFinalStateValueAction extends SelectionAction {
	
	/**
	 * Action id
	 */
	public static final String
		CHANGE_FINAL_STATE_VALUE = "Change.Final.State.Value";  //$NON-NLS-1$
	
	private FinalState selectedState;
	
	public ChangeFinalStateValueAction(IWorkbenchPart part) {
		super(part);
		
		setText(Messages.getString("org.isistan.flabot.executionmapping.editor.actions.ChangeFinalStateValueAction.actionText")); //$NON-NLS-1$
		setToolTipText(Messages.getString("org.isistan.flabot.executionmapping.editor.actions.ChangeFinalStateValueAction.actionTooltip")); //$NON-NLS-1$
		setId(CHANGE_FINAL_STATE_VALUE);
	}
	
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}
	
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	private boolean canPerformAction() {	
		List selection = getSelectedObjects();
		if (selection == null ||
				selection.isEmpty()) 
		{
			return false;
		}
			
		if (selection.size() > 1)
		{
			return false;
		}
		
		Object o = selection.get(0);		
		if (o instanceof StateEditPart) 
		{
			VisualModel visualModel = (VisualModel) ((StateEditPart)o).getModel();
			State state = (State) visualModel.getSemanticModel(); 
			if ( state.getStateType() == StateType.FINAL)
			{
				selectedState = (FinalState) state;
				return true;
			}
		}
		
		return false;
	}
	
	protected Command getCommand() {
		ChooseFinalStateValueDialog dialog = new ChooseFinalStateValueDialog(Display.getCurrent().getActiveShell());
		ExecutionStateValue value = dialog.open(Messages.getString("org.isistan.flabot.executionmapping.editor.actions.ChangeFinalStateValueAction.chooseFinalState"), selectedState.getExecutionState()); //$NON-NLS-1$
		if (value != null)
		{
			return new ChangeStateInfoValueActionCommand(selectedState, value);
		}
		
		return null;
	}
	
	@Override
	public void run() 
	{
		CommandExecutor commandExecutor = (CommandExecutor)getWorkbenchPart().getAdapter(CommandExecutor.class);
		commandExecutor.executeCommand(getCommand(), false);
	}	
}