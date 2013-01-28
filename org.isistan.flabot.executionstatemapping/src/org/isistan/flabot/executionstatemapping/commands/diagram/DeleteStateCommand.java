package org.isistan.flabot.executionstatemapping.commands.diagram;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.State;
import org.isistan.flabot.executionstatemapping.model.semantic.StateContainer;
import org.isistan.flabot.executionstatemapping.model.visual.StateDiagram;

public class DeleteStateCommand extends Command {
	
	private final NodeVisualModel child;
	
	private final StateDiagram diagram;
	
	private boolean wasRemoved;
	
	public DeleteStateCommand(StateDiagram diagram, NodeVisualModel child) {
		this.child = child;
		this.diagram = diagram;
		setLabel(Messages.getString("org.isistan.flabot.executionmapping.commands.diagram.DeleteStateCommand.commandName")); //$NON-NLS-1$
	}
	
	@Override
	public boolean canUndo() {
		return wasRemoved;
	}
	
	@Override
	public boolean canExecute() {
		return (diagram != null && child != null);
	}
	
	@Override
	public void execute() {
		redo();
	}
	
	@Override
	public void redo() {			
		wasRemoved = ((StateContainer)diagram.getSemanticModel()).getStates().remove(child.getSemanticModel());
		if (wasRemoved)
			child.setDiagram(null);
	}
	
	@Override
	public void undo() {
		if (((StateContainer)diagram.getSemanticModel()).getStates().add((State) child.getSemanticModel()))
			child.setDiagram(diagram);	
	}
}