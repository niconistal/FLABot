package org.isistan.flabot.executionstatemapping.editor.actions;

import org.eclipse.gef.commands.Command;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;
import org.isistan.flabot.executionstatemapping.InterfacePluginExecutionStateMapping;
import org.isistan.flabot.executionstatemapping.commands.diagram.AssignExecutionConditionToTransitionConditionCommand;
import org.isistan.flabot.executionstatemapping.dialogs.utils.DialogUtils;
import org.isistan.flabot.executionstatemapping.dialogs.utils.contentproviders.TreeExecutionConditionContentProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.labelproviders.TreeExecutionConditionLabelProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.validators.ExecutionConditionSelectionValidator;
import org.isistan.flabot.executionstatemapping.editor.StateEditor;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement;

public class AssignMethodExecutionConditionAction extends ChangeExecutionConditionAction {
	
	/**
	 * Action id
	 */
	public static final String
		ASSIGN_METHOD_EXECUTIONCONDITION = "Assign.Method.ExecutionCondition";  //$NON-NLS-1$
	
	public AssignMethodExecutionConditionAction(IWorkbenchPart part) {
		super(part);
		
		setText(Messages.getString("org.isistan.flabot.executionmapping.editor.actions.AssignMethodExecutionConditionAction.actionText")); //$NON-NLS-1$
		setToolTipText(Messages.getString("org.isistan.flabot.executionmapping.editor.actions.AssignMethodExecutionConditionAction.actionTooltip")); //$NON-NLS-1$
		setId(ASSIGN_METHOD_EXECUTIONCONDITION);
	}
	
	@Override
	protected Command getCommand() 
	{		
		FlabotMultiPageEditor editor = (FlabotMultiPageEditor) ((StateEditor)getWorkbenchPart()).getParent();				
		TreeStructuredElement[] treeParent = new TreeStructuredElement[] {InterfacePluginExecutionStateMapping.getFileModel(editor).getMethodExecutionConditionsTree(), InterfacePluginExecutionStateMapping.getFileModel(editor).getGeneralExecutionConditionsTree()};
		
		ExecutionCondition executionCondition =(ExecutionCondition) DialogUtils.getSelectedTreeElement(Messages.getString("org.isistan.flabot.executionmapping.editor.actions.AssignMethodExecutionConditionAction.executionConditionSelection"), Messages.getString("org.isistan.flabot.executionmapping.editor.actions.AssignMethodExecutionConditionAction.selectExecutionCondition"), new TreeExecutionConditionLabelProvider(), new TreeExecutionConditionContentProvider(), treeParent, new ExecutionConditionSelectionValidator(), null, null); //$NON-NLS-1$ //$NON-NLS-2$
		if (executionCondition != null)
		{
			return new AssignExecutionConditionToTransitionConditionCommand(selectedTransitionCondition, executionCondition);
		}
		return null;
	}
}