/**
 * $Id: PathNodeSetConstraintCommand.java,v 1.2 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.messages.Messages;

/**
 * Command to move a path node
 * 
 * PathNodeSetConstraintCommand 
 * -	Establishes a new location and dimension to a visual model.
 * 
 * @author $Author: franco $
 *
 */
public class PathNodeSetConstraintCommand extends Command {

	private NodeVisualModel visual;
	private Rectangle newBounds;
	private Rectangle oldBounds;

	/**
	 * Create a new command to move a path node
	 * @param visual the visual model associated to the node
	 * @param newBounds the requested new size and position
	 * @throws IllegalArgumentException if any of the parameters is null
	 */
	public PathNodeSetConstraintCommand(NodeVisualModel visual, Rectangle newBounds) {
		if (visual == null || newBounds == null) {
			throw new IllegalArgumentException();
		}
		this.visual = visual;
		this.newBounds = newBounds.getCopy();
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.PathNodeSetConstraintCommand.label")); //$NON-NLS-1$
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		oldBounds = Util.getDraw2DRectangle(visual.getLocation(), visual.getSize());
		
		NodeVisualModel parent = (NodeVisualModel) visual.getParent();
		if (parent != null) {
			if (newBounds.x < 0) newBounds.x = 0;
			if (newBounds.y < 0) newBounds.y = 0;
			if (newBounds.x + visual.getSize().getWidth() > parent.getSize().getWidth())
				newBounds.x = parent.getSize().getWidth() - visual.getSize().getWidth();
			if (newBounds.y + visual.getSize().getHeight() > parent.getSize().getHeight())
				newBounds.y = parent.getSize().getHeight() - visual.getSize().getHeight();			
		}		
		redo();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	public void redo() {		
		visual.setLocation(Util.getPoint(newBounds.getLocation()));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		visual.setLocation(Util.getPoint(oldBounds.getLocation()));
	}

}