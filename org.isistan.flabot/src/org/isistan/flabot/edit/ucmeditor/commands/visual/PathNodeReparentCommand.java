/**
 * $Id: PathNodeReparentCommand.java,v 1.4 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * Command that reparents a path node (used when path nodes are dragged
 * in and out from components)
 * @author $Author: franco $
 *
 */
public class PathNodeReparentCommand extends Command {
	
	protected NodeVisualModel newParent;
	protected NodeVisualModel visual;
	private Rectangle bounds;
	protected VisualModel oldParent;	
	private Point oldLocation;
	
	/**
	 * Create a reparent command for the given parent and node
	 * @param newParent the new parent
	 * @param visual the node
	 * @param bounds the requested bounds
	 */
	public PathNodeReparentCommand(NodeVisualModel newParent,
			NodeVisualModel visual, Rectangle bounds) {
		this.visual = visual;
		this.newParent = newParent;
		this.bounds = bounds;
		this.oldParent = visual.getParent();
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.PathNodeReparentCommand.label")); //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */	
	@Override
	public boolean canExecute() {
		if (visual == null || bounds == null)
			return false;
		if (newParent == null)
			return true;
		if (!(newParent.getSemanticModel() instanceof ComponentRole))
			return false;
		
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		oldLocation = Util.getDraw2DPoint(visual.getLocation());
		//visual.setLocation(bounds.getLocation().getCopy());
		doReparent();
	}

	private void doReparent() {
		visual.setLocation(Util.getPoint(bounds.getLocation()));
		if (newParent == null) {
			Diagram diagram = visual.getDiagram();
			visual.setParent(null);
			diagram.getChildren().add(visual);
		} else {
			if (bounds.x < 0) 
				bounds.x = 0;
			if (bounds.y < 0) 
				bounds.y = 0;
			if (bounds.x + visual.getSize().getWidth() > newParent.getSize().getWidth())
				bounds.x = newParent.getSize().getWidth() - visual.getSize().getWidth();
			if (bounds.y + visual.getSize().getHeight() > newParent.getSize().getHeight())
				bounds.y = newParent.getSize().getHeight() - visual.getSize().getHeight();
			visual.setParent(newParent);
		}	
	}
	
	private void undoReparent() {
		visual.setLocation(Util.getPoint(oldLocation));
		if (oldParent == null) {
			Diagram diagram = visual.getDiagram();
			visual.setParent(null);	
			diagram.getChildren().add(visual);
		} else
			visual.setParent(oldParent);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {
		doReparent();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		undoReparent();
	}
}