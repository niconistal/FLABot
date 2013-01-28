package org.isistan.flabot.executionstatemapping.commands.diagram;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.StateContainer;

public class AssignPreFiltersToStateContainerCommand extends Command
{	
	private StateContainer stateContainer;
	
	private final List<ExecutionCondition> newPreFilterList;
	
	private final List<ExecutionCondition> oldPreFilterList;

	public AssignPreFiltersToStateContainerCommand(
			StateContainer stateContainer,
			List<ExecutionCondition> newPreFilterList)
	{
		this.stateContainer = stateContainer;	
		this.newPreFilterList = newPreFilterList;
		this.oldPreFilterList = (List<ExecutionCondition>) EcoreUtil.copyAll(stateContainer.getPreFilters());
		setLabel(Messages.getString("org.isistan.flabot.executionmapping.commands.diagram.AssignPreFiltersToStateContainerCommand.commandName")); //$NON-NLS-1$
	}

	@Override
	public void execute()
	{
		redo();
	}

	@Override
	public void redo()
	{
		setValues(newPreFilterList, oldPreFilterList);
	}

	private void setValues(List<ExecutionCondition> newList, List<ExecutionCondition> oldList)
	{
		stateContainer.getPreFilters().clear();
		stateContainer.getPreFilters().addAll(newList);
	}

	@Override
	public void undo()
	{		 		
		setValues(oldPreFilterList, newPreFilterList);
	}
}
