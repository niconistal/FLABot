package org.isistan.flabot.executionstatemapping.dialogs.utils.validators;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeType;

public class ExecutionConditionSelectionValidator implements ISelectionStatusValidator {

	private static final Status STATUS_OK = new Status(IStatus.OK,
			ExecutionConditionPlugin.PLUGIN_ID, IStatus.OK, "", null); //$NON-NLS-1$

	private static final Status STATUS_ERROR = new Status(IStatus.ERROR,
			ExecutionConditionPlugin.PLUGIN_ID, IStatus.ERROR,
			Messages.getString("org.isistan.flabot.executionmapping.dialogs.utils.validators.ExecutionConditionSelectionValidator.mustSelectCondition"), null); //$NON-NLS-1$
	
	
	public IStatus validate(Object[] selection) 
	{
		if (selection != null && selection.length == 1) 
		{
			if (((TreeStructuredElement) selection[0]).getType() == TreeType.EXECUTION_CONDITION_TYPE)
				return STATUS_OK;
		}
	return STATUS_ERROR;
	}
}
