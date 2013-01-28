/**
 * $Id: PortSetConstraintCommand.java,v 1.1 2006/03/09 21:37:24 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.visual;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * PortSetConstraintCommand 
 * -	Establishes a new location to a port visual model.
 * 
 * @author $Author: franco $
 *
 */
public class PortSetConstraintCommand extends Command {

	private final Rectangle newBounds;
	private Rectangle oldBounds;
	private Rectangle mouseBounds;

	private final ChangeBoundsRequest request;
		
	private final VisualModel visualModel;
	
	/**
	 * Instantiates a command that can move a port. 
	 * @param visualModel the port to manipulate
	 * @param req the move request
	 * @param mouseBounds the mouse location
	 * @param newBounds the new location
	 * @throws IllegalArgumentException if any of the parameters is null
	 */
	public PortSetConstraintCommand(VisualModel visualModel, ChangeBoundsRequest req, 
			Rectangle mouseBounds,Rectangle newBounds) {
		if (visualModel == null || req == null || mouseBounds == null || newBounds == null) {
			throw new IllegalArgumentException();
		}
		this.visualModel = visualModel;
		this.request = req;
		this.mouseBounds = mouseBounds;
		this.newBounds = newBounds.getCopy();
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.PortSetConstraintCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * The command can be undone if the port's parent is correct.
	 * @return <code>true</code> if the command can be undone
	 */
	public boolean canUndo() {
		return (visualModel != null && visualModel.getParent() != null);
	}
	
	/**
	 * Verifies that the command can be executed.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		Object type = request.getType();
		// make sure the Request is of a type we support:
		return (RequestConstants.REQ_MOVE.equals(type)
				|| RequestConstants.REQ_MOVE_CHILDREN.equals(type) 
				|| RequestConstants.REQ_RESIZE.equals(type)
				|| RequestConstants.REQ_RESIZE_CHILDREN.equals(type));
	}
	
	/**
	 * Arrange the new location of the port according to the location of the mouse.
	 * If the mouse is near the left side of a component when the port was moved, the port is moved to the left, otherwise the port is moved to the right.
	 */	
	public void arrangeNewBounds() {
		VisualModel parent = visualModel.getParent();
		
		boolean leftSide = true;
		int middle = (parent.getSize().getWidth()) / 2;		
		if (mouseBounds.x + mouseBounds.width > middle)
			leftSide = false;

		int leftOffset = 0;
		int rightOffset = parent.getSize().getWidth() - visualModel.getSize().getWidth();
			
		if (leftSide)
			newBounds.x = leftOffset;
		else
			newBounds.x = rightOffset;
				
	}
		
	/**
	 * Executes the Command. This method should not be called if the Command is not
	 * executable.
	 * 
	 * @see redo()
	 */
	public void execute() {
		oldBounds = Util.getDraw2DRectangle(
				visualModel.getLocation(), 
				visualModel.getSize()
				);

		arrangeNewBounds(); 
		
		redo();
	}
		
	/**
	 * Sets the new bounds (size and location)
	 */	
	public void redo() {
		visualModel.setLocation(Util.getPoint(newBounds.getLocation()));
		visualModel.setSize(Util.getDimension(newBounds.getSize()));
		updateChildrenLocation();
	}
	
	/**
	 * Unsets the new bounds (size and location)
	 */
	public void undo() {
		visualModel.setLocation(Util.getPoint(oldBounds.getLocation()));
		visualModel.setSize(Util.getDimension(oldBounds.getSize()));
		updateChildrenLocation();
	}
	
	/**
	 * Updates all its interfaces with the new location of the port
	 */	
	protected void updateChildrenLocation() {
		for (int i=0; i<visualModel.getChildren().size(); i++) {
			VisualModel m = (VisualModel) visualModel.getChildren().get(i);
			m.setLocation(m.getLocation());
		}
	}
}