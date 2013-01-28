package org.isistan.flabot.executionstatemapping.editor.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.executionstatemapping.editor.editparts.TransitionConditionConnectionEditPart;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.StateContainer;
import org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition;
import org.isistan.flabot.executionstatemapping.model.visual.StateDiagram;

public abstract class ChangeExecutionConditionAction extends SelectionAction {
	
	/**
	 * Action id
	 */
	public static final String
		CHANGE_EXECUTIONCONDITION = "Change.ExecutionCondition";  //$NON-NLS-1$
	
	protected TransitionCondition selectedTransitionCondition;
	
	protected StateContainer stateContainer;
	
	public ChangeExecutionConditionAction(IWorkbenchPart part) {
		super(part);
		
		setText(Messages.getString("org.isistan.flabot.executionmapping.editor.actions.ChangeExecutionConditionAction.actionText")); //$NON-NLS-1$
		setToolTipText(Messages.getString("org.isistan.flabot.executionmapping.editor.actions.ChangeExecutionConditionAction.actionTooltip")); //$NON-NLS-1$
		setId(CHANGE_EXECUTIONCONDITION);
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
		if (o instanceof TransitionConditionConnectionEditPart) 
		{
			VisualModel visualModel = (VisualModel) ((TransitionConditionConnectionEditPart)o).getModel();
			selectedTransitionCondition = (TransitionCondition) visualModel.getSemanticModel();			
			VisualModel sourceModel = (VisualModel) ((TransitionConditionConnectionEditPart)o).getSource().getModel();			
			stateContainer = (StateContainer) ((StateDiagram)sourceModel.getDiagram()).getSemanticModel();
			return true;
		}
		
		return false;
	}
	
	protected abstract Command getCommand();
	
	@Override
	public void run() 
	{
		CommandExecutor commandExecutor = (CommandExecutor)getWorkbenchPart().getAdapter(CommandExecutor.class);
		commandExecutor.executeCommand(getCommand(), false);
	}	
}
