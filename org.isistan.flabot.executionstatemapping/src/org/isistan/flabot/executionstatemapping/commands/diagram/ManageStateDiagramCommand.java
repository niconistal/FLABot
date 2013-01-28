package org.isistan.flabot.executionstatemapping.commands.diagram;

import java.util.List;

import org.isistan.flabot.executionstatemapping.commands.executioncondition.CompoundManageCommand;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.visual.StateDiagram;

public class ManageStateDiagramCommand extends CompoundManageCommand {

	private List<StateDiagram> diagramList;
	
	private StateDiagram  diagram;	

	public ManageStateDiagramCommand(
			List<StateDiagram> diagramList,
			StateDiagram diagram,
			boolean addCommand) {
		super(addCommand);
		
		this.diagramList = diagramList;
		this.diagram = diagram;	
		this.addCommand=addCommand;
		if (addCommand)
		{
			setLabel(Messages.getString("org.isistan.executionmapping.commands.diagram.ManageStateDiagramCommand.commandAddName"));	 //$NON-NLS-1$
		}
		else
		{
			setLabel(Messages.getString("org.isistan.executionmapping.commands.diagram.ManageStateDiagramCommand.commandDeleteName")); //$NON-NLS-1$
		}
	}
	
	@Override
	public void add()
	{
		wasExecuted = diagramList.add(diagram);
	}
	
	@Override
	public void remove()
	{
		wasExecuted = diagramList.remove(diagram);
	}
}