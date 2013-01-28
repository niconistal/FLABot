/**
 * $Id: EditVisualizationCommand.java,v 1.10 2006/03/21 01:51:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.commands;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.swt.graphics.RGB;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * EditVisualizationCommand
 * -	Changes the visual properties of a visual model. This properties include foreground color, backfground color, line style, line width and size.
 * 
 * @author $Author: franco $
 *
 */
public class EditVisualizationCommand extends Command {
	
	private VisualModel visual;
	private RGB newbC;
	private RGB newfC;
	private int newlS;
	private int newlW;
	private RGB oldbC;
	private RGB oldfC;
	private int oldlS;
	private int oldlW;
	private Rectangle newBounds;
	private Rectangle oldBounds;
	private Dimension minSize;
	
	/**
	 * Instantiates a command that can change the visual properties of a visual model.
	 * @param visual the visual model to change
	 * @param bC the new background color
	 * @param fC the new foregound color
	 * @param lS the new line style
	 * @param lW the new line width
	 * @param dim the new size
	 * @param minSize the minimun dimension that the visual model can have
	 */
	public EditVisualizationCommand(VisualModel visual, RGB bC, RGB fC, int lS, int lW, Dimension dim, Dimension minSize)  {
		this.visual = visual;
		newbC = bC;
		newfC = fC;
		newlS = lS;
		newlW = lW;
		oldbC = Util.getSWTRGB(visual.getBackgroundColor());
		oldfC = Util.getSWTRGB(visual.getForegroundColor());
		oldlS = visual.getLineStyle();		
		oldlW = visual.getLineWidth();
		newBounds = new Rectangle(visual.getLocation().getX(),visual.getLocation().getY(),dim.width,dim.height);
		
		this.minSize = minSize;
		setLabel(Messages.getString("org.isistan.flabot.edit.editor.commands.EditVisualizationCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * Executes the Command. This method should not be called if the Command is not
	 * executable.
	 * 
	 *  @see redo()
	 */
	public void execute() {
		oldBounds = Util.getDraw2DRectangle(visual.getLocation(), visual.getSize());
		newBounds.setSize(newBounds.getSize().union(minSize));
		redo();
	}
	
	private void setVisualProperties(RGB bC, RGB fC, int lS, int lW, Dimension size) {
		visual.setBackgroundColor(Util.getColor(bC));
		visual.setForegroundColor(Util.getColor(fC));
		visual.setLineStyle(lS);
		visual.setLineWidth(lW);
		visual.setSize(Util.getDimension(size));
	}
	
	/**
	 * Sets the new visual properties (background color, foreground color, line style, line width and size)
	 */
	public void redo() {
		setVisualProperties(newbC, newfC, newlS, newlW, newBounds.getSize());
	}
	
	/**
	 * Sets the old visual properties (background color, foreground color, line style, line width and size)
	 */
	public void undo() {
		setVisualProperties(oldbC, oldfC, oldlS, oldlW, oldBounds.getSize());
	}
}