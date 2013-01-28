/**
 * $Id: ComponentSetConstraintCommand.java,v 1.1 2006/03/09 21:37:24 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.visual;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.edit.componenteditor.figures.ComponentFigure;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * ComponentSetConstraintCommand 
 * - Sets a new dimension and a new location to a visual model
 * 
 * @author $Author: franco $
 *
 */
public class ComponentSetConstraintCommand extends Command {
	
	// the new bounds
	private final Rectangle newBounds;
	
	// the old bounds
	private Rectangle oldBounds;
	
	// the visual model 
	private final VisualModel visualModel;
	
	/**
	 * Instantiates a command that can resize and/or move a component. 
	 * @param visualModel the component to manipulate
	 * @param newBounds the new size and location
	 * @throws IllegalArgumentException if any of the parameters is null
	 */
	public ComponentSetConstraintCommand(VisualModel visualModel, Rectangle newBounds) {
		if (newBounds == null) {
			throw new IllegalArgumentException();
		}
		this.visualModel = visualModel;
		this.newBounds = newBounds.getCopy();
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.ComponentSetConstraintCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * The command can be undone if the component exists in the diagram.
	 * @return <code>true</code> if the command can be undone
	 */
	public boolean canUndo() {
		return (visualModel != null && visualModel.getDiagram() != null);
	}

	/**
	 * Returns <code>true</code> if the visualModel and the new bounds exist. 
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		return (visualModel != null && newBounds != null);
	}
		
	/**
	 * Executes the Command. This method should not be called if the Command is not
	 * executable.
	 * Sets the new bounds to the visual model. If the new bounds cannot be applied, the minimun bounds of the visual model is set.
	 * 
	 *  @see redo()
	 */
	public void execute() {
		oldBounds = Util.getDraw2DRectangle(
				visualModel.getLocation(), 
				visualModel.getSize());
		newBounds.setSize(newBounds.getSize().union(ComponentFigure.defaultsize));
		redo();
	}
	
	/**
	 * Sets the new bounds to the visual model
	 */	
	public void redo() {
		visualModel.setLocation(Util.getPoint(newBounds.getLocation()));
		visualModel.setSize(Util.getDimension(newBounds.getSize()));
	}
	
	/**
	 * Sets the old bounds to the visual model 
	 */	
	public void undo() {
		visualModel.setLocation(Util.getPoint(oldBounds.getLocation()));
		visualModel.setSize(Util.getDimension(oldBounds.getSize()));
	}
}