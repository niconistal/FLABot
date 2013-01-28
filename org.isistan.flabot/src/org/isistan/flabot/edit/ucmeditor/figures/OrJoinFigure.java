/**
 * $Id: OrJoinFigure.java,v 1.10 2006/02/10 20:32:20 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.swt.graphics.RGB;

/**
 * OrJoinFigure
 * -	The figure used for Or Joins
 * 
 *  @author $Author: franco $
 */
public class OrJoinFigure extends ThreeConnectionFigure implements HandleBounds {

	private int nodeInputsCount;
	/**
	 * Instantiates an instance of OrJoinFigure
	 * 
	 * @param roration the fork rotation
	 * @param fC the foreground color of the join
	 */
	public OrJoinFigure(String rotation, RGB fc, IFigure parent, int nodeInputsCount) {		
		super(rotation, fc, parent);
		this.nodeInputsCount = nodeInputsCount;
	}
	
	/**
	 * Draw the Or Join
	 */
	public void paintFigure(Graphics g) {		
		Rectangle r = getBounds().getCopy();
		r.translate(0, 0);
		g.setLineWidth(3);		
		if (rotation.equals(LEFT))	
			drawLeft(g,r);
		else if (rotation.equals(RIGHT))
			drawRight(g,r);
		else if (rotation.equals(UP))
			drawUp(g,r);
		else if (rotation.equals(DOWN))
			drawDown(g,r);		
	}
	
	/**
	 * Draw the Or Fork with right rotation
	 */
	private void drawRight(Graphics g, Rectangle r) {
		// Draw the 2 left terminals
//		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + 10);
//		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.bottom() - 10);
		switch (nodeInputsCount)
		{
			case 2:
			{
				drawRight_TwoInputs(g, r);
				break;
			}
			case 3:
			{
				drawRight_ThreeInputs(g, r);
				break;
			}
			case 4:
			{
				drawRight_FourInputs(g, r);
				break;
			}
			case 5:
			{
				drawRight_FiveInputs(g, r);
				break;
			}
		}
		
		// Draw the right terminal
		g.drawLine(r.x, r.y + r.height / 2, r.x + r.width / 2, r.y + r.height / 2);
	}
	
	/**
	 * Draw the Or Fork with right rotation, and two inputs
	 */
	private void drawRight_TwoInputs(Graphics g, Rectangle r) {
		// Draw the 2 left terminals
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + 10);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.bottom() - 10);
		
	}
	
	/**
	 * Draw the Or Fork with right rotation, and three inputs
	 */
	private void drawRight_ThreeInputs(Graphics g, Rectangle r) {
		// Draw the 2 left terminals
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + 10);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + 20);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + 30);
		
	}
	
	/**
	 * Draw the Or Fork with right rotation, and four inputs
	 */
	private void drawRight_FourInputs(Graphics g, Rectangle r) {
		// Draw the 2 left terminals
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + 5);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + 15);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + 25);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + 35);
	}
	
	/**
	 * Draw the Or Fork with right rotation, and five inputs
	 */
	private void drawRight_FiveInputs(Graphics g, Rectangle r) {
		// Draw the 2 left terminals
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + 0);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + 10);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + 20);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + 30);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + 40);
	}
	
	/**
	 * Draw the Or Fork with left rotation
	 */
	private void drawLeft(Graphics g, Rectangle r) {
//		g.drawLine(r.x, r.y + 10, r.x + r.width / 2, r.y + r.height / 2);
//		g.drawLine(r.x, r.bottom() - 10, r.x + r.width / 2, r.y + r.height / 2);
		switch (nodeInputsCount)
		{
			case 2:
			{
				drawLeft_TwoInputs(g, r);
				break;
			}
			case 3:
			{
				drawLeft_ThreeInputs(g, r);
				break;
			}
			case 4:
			{
				drawLeft_FourInputs(g, r);
				break;
			}
			case 5:
			{
				drawLeft_FiveInputs(g, r);
				break;
			}
		}
		
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + r.height / 2);	
	}
	
	/**
	 * Draw the Or Fork with left rotation, and two inputs
	 */
	private void drawLeft_TwoInputs(Graphics g, Rectangle r) {
		g.drawLine(r.x, r.y + 10, r.x + r.width / 2, r.y + r.height / 2);
		g.drawLine(r.x, r.bottom() - 10, r.x + r.width / 2, r.y + r.height / 2);
	}
	
	/**
	 * Draw the Or Fork with left rotation, and three inputs
	 */
	private void drawLeft_ThreeInputs(Graphics g, Rectangle r) {
		g.drawLine(r.x, r.y + 10, r.x + r.width / 2, r.y + r.height / 2);
		g.drawLine(r.x, r.y + 20, r.x + r.width / 2, r.y + r.height / 2);
		g.drawLine(r.x, r.y + 30, r.x + r.width / 2, r.y + r.height / 2);
	}
	
	/**
	 * Draw the Or Fork with left rotation, and four inputs
	 */
	private void drawLeft_FourInputs(Graphics g, Rectangle r) {
		g.drawLine(r.x, r.y + 5, r.x + r.width / 2, r.y + r.height / 2);
		g.drawLine(r.x, r.y + 15, r.x + r.width / 2, r.y + r.height / 2);
		g.drawLine(r.x, r.y + 25, r.x + r.width / 2, r.y + r.height / 2);
		g.drawLine(r.x, r.y + 35, r.x + r.width / 2, r.y + r.height / 2);
	}
	
	/**
	 * Draw the Or Fork with left rotation, and five inputs
	 */
	private void drawLeft_FiveInputs(Graphics g, Rectangle r) {
		g.drawLine(r.x, r.y + 0, r.x + r.width / 2, r.y + r.height / 2);
		g.drawLine(r.x, r.y + 10, r.x + r.width / 2, r.y + r.height / 2);
		g.drawLine(r.x, r.y + 20, r.x + r.width / 2, r.y + r.height / 2);
		g.drawLine(r.x, r.y + 30, r.x + r.width / 2, r.y + r.height / 2);
		g.drawLine(r.x, r.y + 40, r.x + r.width / 2, r.y + r.height / 2);
	}
	
	/**
	 * Draw the Or Fork with up rotation
	 */
	private void drawUp(Graphics g, Rectangle r) {
//		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 10, r.y);
//		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.right() - 10, r.y);
//		
		switch (nodeInputsCount)
		{
			case 2:
			{
				drawUp_TwoInputs(g, r);
				break;
			}
			case 3:
			{
				drawUp_ThreeInputs(g, r);
				break;
			}
			case 4:
			{
				drawUp_FourInputs(g, r);
				break;
			}
			case 5:
			{
				drawUp_FiveInputs(g, r);
				break;
			}
		}
		g.drawLine(r.x + r.width / 2, r.bottom(), r.x + r.width / 2, r.y + r.height / 2);	
	}
	
	/**
	 * Draw the Or Fork with up rotation, and two inputs
	 */
	private void drawUp_TwoInputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 10, r.y);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.right() - 10, r.y);
	}
	
	/**
	 * Draw the Or Fork with up rotation, and three inputs
	 */
	private void drawUp_ThreeInputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 10, r.y);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 20, r.y);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 30, r.y);
	}
	
	/**
	 * Draw the Or Fork with up rotation, and four inputs
	 */
	private void drawUp_FourInputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 5, r.y);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 15, r.y);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 25, r.y);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 35, r.y);
	}
	
	/**
	 * Draw the Or Fork with up rotation, and five inputs
	 */
	private void drawUp_FiveInputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 0, r.y);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 10, r.y);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 20, r.y);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 30, r.y);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 40, r.y);
	}
	
	/**
	 * Draw the Or Fork with down rotation
	 */
	private void drawDown(Graphics g, Rectangle r) {
//		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 10, r.bottom());
//		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.right() - 10, r.bottom());
		
		switch (nodeInputsCount)
		{
			case 2:
			{
				drawDown_TwoInputs(g, r);
				break;
			}
			case 3:
			{
				drawDown_ThreeInputs(g, r);
				break;
			}
			case 4:
			{
				drawDown_FourInputs(g, r);
				break;
			}
			case 5:
			{
				drawDown_FiveInputs(g, r);
				break;
			}
		}
		
		g.drawLine(r.x + r.width / 2, r.y, r.x + r.width / 2, r.y + r.height / 2);
	}
	
	/**
	 * Draw the Or Fork with down rotation, and two inputs
	 */
	private void drawDown_TwoInputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 10, r.bottom());
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.right() - 10, r.bottom());
	}
	
	/**
	 * Draw the Or Fork with down rotation, and three inputs
	 */
	private void drawDown_ThreeInputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 10, r.bottom());
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 20, r.bottom());
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 30, r.bottom());		
	}
	
	/**
	 * Draw the Or Fork with down rotation, and four inputs
	 */
	private void drawDown_FourInputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 5, r.bottom());
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 15, r.bottom());
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 25, r.bottom());
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 35, r.bottom());
	}
	
	/**
	 * Draw the Or Fork with down rotation, and five inputs
	 */
	private void drawDown_FiveInputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 0, r.bottom());
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 10, r.bottom());
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 20, r.bottom());
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 30, r.bottom());
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 40, r.bottom());
	}
	
	/**
	 * Returns the Rectangle around which handles are to be placed.  The Rectangle should be
	 * in the same coordinate system as the figure itself.
	 * @return The rectangle used for handles
	 */
	public Rectangle getHandleBounds() {
		if (rotation.equals(LEFT) || rotation.equals(RIGHT))
			return getBounds().getCropped(new Insets(10,0,10,0));
		else
			return getBounds().getCropped(new Insets(0,10,0,10));
	}
}