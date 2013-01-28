package org.isistan.flabot.executionstatemapping.commands.diagram;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.State;
import org.isistan.flabot.executionstatemapping.model.semantic.StateContainer;
import org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition;
import org.isistan.flabot.executionstatemapping.model.visual.StateDiagram;

public class DeleteTransitionConditionConnectionCommand extends Command {
	
	private StateDiagram diagram;
	
	private final ConnectionVisualModel connection;
	
	private NodeVisualModel source;
	
	private NodeVisualModel target;
	
	private State sourceState;
	
	private State targetState;
	
	public DeleteTransitionConditionConnectionCommand(ConnectionVisualModel connection) {
		this.connection = connection;
		setLabel(Messages.getString("org.isistan.flabot.executionmapping.commands.diagram.DeleteTransitionConditionConnectionCommand.commandName")); //$NON-NLS-1$
	}
	
	@Override
	public boolean canExecute() {
		return (connection != null);
	}
	
	@Override
	public void execute() {
		source = connection.getSource();
		target = connection.getTarget();
		diagram = (StateDiagram)source.getDiagram();
		
		sourceState = ((TransitionCondition)connection.getSemanticModel()).getSourceState();
		targetState = ((TransitionCondition)connection.getSemanticModel()).getTargetState();
		
		redo();
	}
	
	@Override
	public void redo() {			
		((StateContainer)diagram.getSemanticModel()).getTransitionConditions().remove(connection.getSemanticModel());
		
		connection.setSource(null);
		connection.setTarget(null);
				
		((TransitionCondition)connection.getSemanticModel()).setSourceState(null);
		((TransitionCondition)connection.getSemanticModel()).setTargetState(null);
	}
	
	@Override
	public void undo() {
		((TransitionCondition)connection.getSemanticModel()).setSourceState(sourceState);
		((TransitionCondition)connection.getSemanticModel()).setTargetState(targetState);
		connection.setSource(source);
		connection.setTarget(target);
		((StateContainer)diagram.getSemanticModel()).getTransitionConditions().add((TransitionCondition)connection.getSemanticModel());
	}
}