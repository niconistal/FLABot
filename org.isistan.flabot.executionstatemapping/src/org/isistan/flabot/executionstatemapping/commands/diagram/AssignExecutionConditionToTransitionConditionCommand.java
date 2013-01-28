package org.isistan.flabot.executionstatemapping.commands.diagram;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition;

public class AssignExecutionConditionToTransitionConditionCommand extends Command
{	
	private final TransitionCondition transitionCondition;
	
	private final ExecutionCondition newEvent;
	
	private final ExecutionCondition oldEvent;

	public AssignExecutionConditionToTransitionConditionCommand(
			TransitionCondition transitionCondition,
			ExecutionCondition event)
	{
		this.transitionCondition = transitionCondition;		
		this.newEvent = event;
		this.oldEvent = transitionCondition.getExecutionCondition();
		setLabel(Messages.getString("org.isistan.flabot.executionmapping.commands.diagram.AssignExecutionConditionToTransitionConditionCommand.commandName")); //$NON-NLS-1$
	}

	@Override
	public void execute()
	{
		redo();
	}

	@Override
	public void redo()
	{
		setValues(newEvent, oldEvent);
	}

	private void setValues(ExecutionCondition eventToAdd, ExecutionCondition eventToRemove)
	{
		transitionCondition.setExecutionCondition(eventToAdd);
	}

	@Override
	public void undo()
	{		 		
		setValues(oldEvent, newEvent);
	}
}