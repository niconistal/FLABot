/**
 * $Id: ComponentSetConstraintCommand.java,v 1.4 2006/03/27 22:46:30 franco Exp $
 * $Header: /var/cvsroot/org.isistan.flabot/src/org/isistan/flabot/edit/ucmeditor/commands/visual/ComponentSetConstraintCommand.java,v 1.4 2006/03/27 22:46:30 franco Exp $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.edit.editor.figures.ComponentFigure;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * A command to resize/move a component
 * 
 * ComponentSetConstraintCommand
 * -	Establishes a new location and dimension to a visual model.
 * 
 * @author $Author: franco $
 *
 */
public class ComponentSetConstraintCommand extends Command {
	
	private NodeVisualModel visual;
	private Rectangle newBounds;
	private Rectangle oldBounds;

	/**
	 * Create a new command to resize/move a component
	 * @param visual the visual model associated to the component
	 * @param request the move/resize request
	 * @param newBounds the requested new size and position
	 * @throws IllegalArgumentException if any of the parameters is null
	 */
	public ComponentSetConstraintCommand(NodeVisualModel visual, Rectangle newBounds) {
		this.visual = visual;
		this.newBounds = newBounds.getCopy();
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.ComponentSetConstraintCommand.label")); //$NON-NLS-1$
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		return (visual != null && newBounds != null && checkResponsibilities(newBounds));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		oldBounds = Util.getDraw2DRectangle(visual.getLocation(), visual.getSize());
		newBounds.setSize(newBounds.getSize().union(ComponentFigure.defaultsize));
		redo();
	}
	
	public boolean checkResponsibilities(Rectangle bounds) {	
		List children = visual.getDiagram().getChildren(); 
		for (Iterator iter=children.iterator(); iter.hasNext();) {
			VisualModel child = (VisualModel)iter.next();
			if (child.getSemanticModel() instanceof ResponsibilityNode) {
				NodeVisualModel childNodeVisual = (NodeVisualModel) child;
				if ( (bounds.contains(new Rectangle(childNodeVisual.getAbsoluteLocation().getX(), childNodeVisual.getAbsoluteLocation().getY(), 0,0)) ||
					  bounds.contains(new Rectangle(childNodeVisual.getAbsoluteLocation().getX() + childNodeVisual.getSize().getWidth(), childNodeVisual.getAbsoluteLocation().getY() + childNodeVisual.getSize().getHeight(), 0,0))))				
				 	return false;
			}
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	public void redo() {
		visual.setSize(Util.getDimension(newBounds.getSize()));
		visual.setLocation(Util.getPoint(newBounds.getLocation()));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		visual.setSize(Util.getDimension(oldBounds.getSize()));
		visual.setLocation(Util.getPoint(oldBounds.getLocation()));
	}
}