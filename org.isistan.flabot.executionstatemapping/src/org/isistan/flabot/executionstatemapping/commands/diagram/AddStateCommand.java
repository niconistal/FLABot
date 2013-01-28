package org.isistan.flabot.executionstatemapping.commands.diagram;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.executionstatemapping.editor.figures.StateFigure;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticFactory;
import org.isistan.flabot.executionstatemapping.model.semantic.State;
import org.isistan.flabot.executionstatemapping.model.semantic.StateContainer;
import org.isistan.flabot.executionstatemapping.model.visual.StateDiagram;

public class AddStateCommand extends Command
{

	protected StateDiagram diagram;
	
	protected NodeVisualModel visualModel = null;
	
	protected Rectangle bounds = null;
	
	private boolean addedToCore;

	public AddStateCommand(NodeVisualModel visualModel, StateDiagram diagram,
			Rectangle bounds)
	{
		this.diagram = diagram;
		this.visualModel = visualModel;
		this.bounds = bounds;
		setLabel(Messages.getString("org.isistan.flabot.executionmapping.commands.diagram.AddStateCommand.commandName")); //$NON-NLS-1$
	}

	public State getState()
	{
		return (State) visualModel.getSemanticModel();
	}
	
	@Override
	public boolean canExecute()
	{
		return (visualModel != null && diagram != null && bounds != null);
	}	

	@Override
	public void execute()
	{
		State state = (State) visualModel.getSemanticModel();
		if (state == null)
			state = SemanticFactory.eINSTANCE.createState();
		state.setName(Messages.getString("org.isistan.flabot.executionmapping.commands.diagram.AddStateCommand.defaultStateName") + ((StateContainer)diagram.getSemanticModel()).getStates().size()); //$NON-NLS-1$
		visualModel.setSemanticModel(state);

		updateBounds();
		redo();
	}

	protected void updateBounds()
	{
		Point location = bounds.getLocation();
		location.x -= StateFigure.offset;
		visualModel.setLocation(Util.getPoint(location));

		Dimension d = StateFigure.defaultsize;
		if (visualModel.getSize().getWidth() < d.width
				&& visualModel.getSize().getHeight() < d.height)
			visualModel.setSize(Util.getDimension(d.width, d.height));
	}

	@Override
	public void redo()
	{
		addedToCore = ((StateContainer)diagram.getSemanticModel()).getStates().add(
				(State)visualModel.getSemanticModel());
		visualModel.setDiagram(diagram);
	}

	@Override
	public void undo()
	{
		visualModel.setDiagram(null);	
		if (addedToCore)
		{
			((StateContainer)diagram.getSemanticModel()).getStates().remove(
					visualModel.getSemanticModel());
		}
	}
}