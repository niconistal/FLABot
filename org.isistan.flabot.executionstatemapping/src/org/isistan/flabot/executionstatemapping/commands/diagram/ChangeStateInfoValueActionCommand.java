package org.isistan.flabot.executionstatemapping.commands.diagram;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue;
import org.isistan.flabot.executionstatemapping.model.semantic.FinalState;

public class ChangeStateInfoValueActionCommand extends Command
{
	protected FinalState state;
	
	protected ExecutionStateValue newValue;
	
	protected ExecutionStateValue oldValue;

	public ChangeStateInfoValueActionCommand(FinalState state, ExecutionStateValue value)
	{
		this.state = state;
		this.newValue = value;
		this.oldValue = state.getExecutionState();
		setLabel(Messages.getString("org.isistan.flabot.executionmapping.commands.diagram.ChangeStateInfoValueActionCommand.commandName")); //$NON-NLS-1$
	}
	
	@Override
	public boolean canExecute()
	{
		return (state != null);
	}
	
	@Override
	public void execute()
	{
		redo();
	}
	
	@Override
	public void redo()
	{
		state.setExecutionState(newValue);
	}
	
	@Override
	public void undo()
	{
		state.setExecutionState(oldValue);
	}
}