package org.isistan.flabot.executionstatemapping.editor.actions;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.executionstatemapping.InterfacePluginExecutionStateMapping;
import org.isistan.flabot.executionstatemapping.commands.diagram.AssignExecutionConditionToTransitionConditionCommand;
import org.isistan.flabot.executionstatemapping.commands.executioncondition.ManagePersistentTreeElementCommand;
import org.isistan.flabot.executionstatemapping.dialogs.GeneralExecutionConditionDialog;
import org.isistan.flabot.executionstatemapping.editor.StateEditor;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement;

public class NewGeneralExecutionConditionAction extends ChangeExecutionConditionAction {
	
	/**
	 * Action id
	 */
	public static final String
		NEW_GENERAL_EXECUTIONCONDITION = "New.General.ExecutionCondition";  //$NON-NLS-1$
	
	
	public NewGeneralExecutionConditionAction(IWorkbenchPart part) {
		super(part);
		
		setText(Messages.getString("org.isistan.flabot.executionmapping.editor.actions.NewGeneralExecutionConditionAction.actionText")); //$NON-NLS-1$
		setToolTipText(Messages.getString("org.isistan.flabot.executionmapping.editor.actions.NewGeneralExecutionConditionAction.actionTooltip")); //$NON-NLS-1$
		setId(NEW_GENERAL_EXECUTIONCONDITION);
	}
	
	@Override
	protected Command getCommand() 
	{
		GeneralExecutionConditionDialog eventD=new GeneralExecutionConditionDialog(Messages.getString("org.isistan.flabot.executionmapping.editor.actions.NewGeneralExecutionConditionAction.generalExecutionCondition")); //$NON-NLS-1$
		ExecutionCondition newExecutionCondition = eventD.showDialog(selectedTransitionCondition.getExecutionCondition());	
		if (newExecutionCondition != null) 
		{	
			CompoundCommand commands = new CompoundCommand();
			TreeStructuredElement container = InterfacePluginExecutionStateMapping.getFileModel(((StateEditor)getWorkbenchPart()).getParent()).getGeneralExecutionConditionsTree();
			commands.add(new ManagePersistentTreeElementCommand(container, newExecutionCondition, true));
			commands.add(new AssignExecutionConditionToTransitionConditionCommand(selectedTransitionCondition, newExecutionCondition));
			return commands;
		}
		return null;
	}
}
