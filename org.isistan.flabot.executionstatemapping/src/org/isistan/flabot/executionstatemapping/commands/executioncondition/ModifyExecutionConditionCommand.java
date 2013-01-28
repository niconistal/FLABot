package org.isistan.flabot.executionstatemapping.commands.executioncondition;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.ExceptionEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ReturnedValueEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ScopeEvaluationCondition;
import org.isistan.flabot.mapping.mappingmodel.PatternMapping;

public class ModifyExecutionConditionCommand extends Command
{
	private ExecutionCondition executionCondition;

	private final ExecutionCondition newExecutionCondition;

	private final ExecutionCondition oldExecutionCondition;

	public ModifyExecutionConditionCommand(
			ExecutionCondition executionCondition,
			ExecutionCondition newExecutionCondition)
	{
		this.executionCondition = executionCondition;
		this.newExecutionCondition = newExecutionCondition;
		this.oldExecutionCondition = (ExecutionCondition) EcoreUtil
				.copy(executionCondition);
		setLabel(Messages.getString("org.isistan.flabot.executionmapping.commands.executioncondition.ModifyExecutionConditionCommand.commandName")); //$NON-NLS-1$
	}

	@Override
	public void execute()
	{
		redo();
	}

	@Override
	public void redo()
	{
		setValues(newExecutionCondition);
	}

	private void setValues(ExecutionCondition executionConditionCopy)
	{
		executionCondition.setName(executionConditionCopy.getName());
		executionCondition.setInstanceOfClass(executionConditionCopy.getInstanceOfClass());
		
		if (executionConditionCopy.getPatternMapping() != null)
		{
			executionCondition.setPatternMapping((PatternMapping) EcoreUtil.copy(executionConditionCopy.getPatternMapping()));
		}
		
		if (executionConditionCopy.getReturnedValue() != null)
		{
			executionCondition.setReturnedValue((ReturnedValueEvaluationCondition)EcoreUtil
				.copy(executionConditionCopy
				.getReturnedValue()));
		}
		
		if (executionConditionCopy.getScope() != null)
		{
			executionCondition.setScope((ScopeEvaluationCondition)EcoreUtil
				.copy(executionConditionCopy
				.getScope()));
		}
		
		if (executionConditionCopy.getException() != null)
		{		
			executionCondition.setException((ExceptionEvaluationCondition)EcoreUtil
				.copy(executionConditionCopy
				.getException()));
		}

		executionCondition.getParameters().clear();
		executionCondition.getParameters().addAll(
				EcoreUtil.copyAll(executionConditionCopy.getParameters()));

		executionCondition.getFields().clear();
		executionCondition.getFields().addAll(
				EcoreUtil.copyAll(executionConditionCopy.getFields()));
		
		executionCondition.getInternalMethodCalls().clear();
		executionCondition.getInternalMethodCalls().addAll(
				EcoreUtil.copyAll(executionConditionCopy.getInternalMethodCalls()));
	}

	@Override
	public void undo()
	{
		setValues(oldExecutionCondition);
	}
}
