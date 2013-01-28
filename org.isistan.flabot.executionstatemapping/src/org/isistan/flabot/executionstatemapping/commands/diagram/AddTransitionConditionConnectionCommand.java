package org.isistan.flabot.executionstatemapping.commands.diagram;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.State;
import org.isistan.flabot.executionstatemapping.model.semantic.StateContainer;
import org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition;
import org.isistan.flabot.executionstatemapping.model.visual.StateDiagram;

public class AddTransitionConditionConnectionCommand extends Command {

	protected ConnectionVisualModel connection;	
	
	protected StateDiagram diagram;		
	
	protected NodeVisualModel source;
	
	protected NodeVisualModel target;
	
	public AddTransitionConditionConnectionCommand(StateDiagram diagram, NodeVisualModel source, ConnectionVisualModel connection) {				
		this.source = source;
		this.connection = connection;
		this.diagram = diagram;
		setLabel(Messages.getString("org.isistan.flabot.executionmapping.commands.diagram..AddTransitionConditionConnectionCommand.commandName")); //$NON-NLS-1$
	}
	
	@Override
	public boolean canUndo() {
		return (source.getDiagram() != null && target.getDiagram() != null);
	}
	
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	@Override
	public boolean canExecute() {
		if (source == null || connection == null || diagram == null)
		{
			return false;
		}
		
		// disallow source -> source connections
		if (source == null || target == null || 
			connection == null || source.equals(target)) {
			return false;
		}

		// disallow double source -> target connections
		for(ConnectionVisualModel connection : (List<ConnectionVisualModel>)source.getSourceConnections())
		{
			if (connection.getTarget() == target)
				return false;
		}
		return true;
	}
	
	public void setTarget(NodeVisualModel target) {
		if (target == null) {
			throw new IllegalArgumentException();
		}
		this.target = target;
	}
	
	@Override
	public void execute() {
		// create a new connection between source and target
		redo();
	}
	
	@Override
	public void redo() {
		connection.setSource(source);
		connection.setTarget(target);		
		
		((TransitionCondition)connection.getSemanticModel()).setSourceState((State)source.getSemanticModel());
		((TransitionCondition)connection.getSemanticModel()).setTargetState((State)target.getSemanticModel());
		((StateContainer)diagram.getSemanticModel()).getTransitionConditions().add((TransitionCondition)connection.getSemanticModel());
	}
	
	@Override
	public void undo() {
		((StateContainer)diagram.getSemanticModel()).getTransitionConditions().remove(connection.getSemanticModel());
		((TransitionCondition)connection.getSemanticModel()).setSourceState(null);
		((TransitionCondition)connection.getSemanticModel()).setTargetState(null);
		
		connection.setSource(null);
		connection.setTarget(null);		
	}
}