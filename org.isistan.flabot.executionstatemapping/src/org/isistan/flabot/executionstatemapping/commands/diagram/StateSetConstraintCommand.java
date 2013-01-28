package org.isistan.flabot.executionstatemapping.commands.diagram;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.executionstatemapping.editor.figures.StateFigure;
import org.isistan.flabot.executionstatemapping.messages.Messages;

public class StateSetConstraintCommand extends Command {
	
	// the new bounds
	private final Rectangle newBounds;
	
	// the old bounds
	private Rectangle oldBounds;
	
	// the visual model 
	private final VisualModel visualModel;
	
	public StateSetConstraintCommand(VisualModel visualModel, Rectangle newBounds) {
		if (newBounds == null) {
			throw new IllegalArgumentException();
		}
		this.visualModel = visualModel;
		this.newBounds = newBounds.getCopy();
		setLabel(Messages.getString("org.isistan.flabot.executionmapping.commands.diagram.StateSetConstraintCommand.commandName")); //$NON-NLS-1$
	}
	
	@Override
	public boolean canUndo() {
		return (visualModel != null && visualModel.getDiagram() != null);
	}
	
	@Override
	public boolean canExecute() {
		return (visualModel != null && newBounds != null);
	}
	
	@Override
	public void execute() {
		oldBounds = Util.getDraw2DRectangle(
				visualModel.getLocation(), 
				visualModel.getSize());
		newBounds.setSize(newBounds.getSize().union(StateFigure.defaultsize));
		redo();
	}
	
	@Override
	public void redo() {
		visualModel.setLocation(Util.getPoint(newBounds.getLocation()));
		visualModel.setSize(Util.getDimension(newBounds.getSize()));
	}
	
	@Override
	public void undo() {
		visualModel.setLocation(Util.getPoint(oldBounds.getLocation()));
		visualModel.setSize(Util.getDimension(oldBounds.getSize()));
	}
}