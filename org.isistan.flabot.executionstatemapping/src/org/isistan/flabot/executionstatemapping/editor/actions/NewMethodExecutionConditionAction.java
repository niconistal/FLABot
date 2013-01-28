package org.isistan.flabot.executionstatemapping.editor.actions;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.internal.Workbench;
import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;
import org.isistan.flabot.executionstatemapping.InterfacePluginExecutionStateMapping;
import org.isistan.flabot.executionstatemapping.commands.diagram.AssignExecutionConditionToTransitionConditionCommand;
import org.isistan.flabot.executionstatemapping.commands.executioncondition.ManageMethodExecutionConditionCommand;
import org.isistan.flabot.executionstatemapping.dialogs.common.ExecutionConditionEditorBuilder;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;

public class NewMethodExecutionConditionAction extends ChangeExecutionConditionAction {
	
	/**
	 * Action id
	 */
	public static final String
		NEW_METHOD_EXECUTIONCONDITION = "New.Method.ExecutionCondition";  //$NON-NLS-1$
	
	
	public NewMethodExecutionConditionAction(IWorkbenchPart part) {
		super(part);
		
		setText(Messages.getString("org.isistan.flabot.executionmapping.editor.actions.NewMethodExecutionConditionAction.actionText")); //$NON-NLS-1$
		setToolTipText(Messages.getString("org.isistan.flabot.executionmapping.editor.actions.NewMethodExecutionConditionAction.actionTooltip")); //$NON-NLS-1$
		setId(NEW_METHOD_EXECUTIONCONDITION);
	}
	
	@Override
	protected Command getCommand() 
	{
		ManageMethodExecutionConditionCommand command = ExecutionConditionEditorBuilder.showNewMethodExecutionConditionDialog(null, InterfacePluginExecutionStateMapping.getFileModel(getEditor()));
		if (command != null)
		{
			CompoundCommand commands = new CompoundCommand();
			commands.add(command);
			commands.add(new AssignExecutionConditionToTransitionConditionCommand(selectedTransitionCondition, (ExecutionCondition)command.getNewTreeStructuredElement()));
			return commands;
		}
		return null;
	}
	
	@SuppressWarnings("restriction") //$NON-NLS-1$
	private FlabotMultiPageEditor getEditor()
	{
		return (FlabotMultiPageEditor) Workbench.getInstance().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
	}
}