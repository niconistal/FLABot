/**
 * $Id: AndForkFigure.java,v 1.12 2006/02/10 20:32:20 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.RGB;

/**
 * AndForkFigure
 * -	The figure used for And Forks
 * 
 *  @author $Author: franco $
 */
public class AndForkFigure extends ThreeConnectionFigure  {
	
	private int nodeOutputsCount;
	
	/**
	 * Instantiates an instance of AndForkFigure
	 * 
	 * @param roration the fork rotation
	 * @param fC the foreground color of the fork
	 */
	public AndForkFigure(String rotation, RGB fc, IFigure parent, int nodeOutputsCount) {		
		super(rotation, fc, parent);
		this.nodeOutputsCount = nodeOutputsCount;
	}

	/**
	 * Draw the And Fork
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
	 * Draw the And Fork with right rotation
	 */
	private void drawRight(Graphics g, Rectangle r) {
		//Draw the two left terminal		
//		g.drawLine(r.x + 7, r.y + 10, r.x + r.width, r.y + 10);
//		g.drawLine(r.x + 7, r.bottom() - 10, r.x + r.width, r.bottom() - 10);
		
		//Draw the two left terminal
		switch (nodeOutputsCount)
		{
			case 2:
			{
				drawRight_TwoOutputs(g, r);
				break;
			}
			case 3:
			{
				drawRight_ThreeOutputs(g, r);
				break;
			}
			case 4:
			{
				drawRight_FourOutputs(g, r);
				break;
			}
			case 5:
			{
				drawRight_FiveOutputs(g, r);
				break;
			}
		}

		//Draw the main line 
		g.drawLine(r.x + 6 , r.y, r.x + 6, r.bottom());
		
		//Draw the right terminal
		g.drawLine(r.x, r.y + r.height / 2, r.x + 5, r.y + r.height / 2);
		
	}
	
	/**
	 * Draw the And Join with right rotation, and two outputs
	 */
	private void drawRight_TwoOutputs(Graphics g, Rectangle r) {
		//Draw the two left terminal
		g.drawLine(r.x + 7, r.y + 10, r.x + r.width, r.y + 10);
		g.drawLine(r.x + 7, r.bottom() - 10, r.x + r.width, r.bottom() - 10);	
	}
	
	/**
	 * Draw the And Join with right rotation, and three outputs
	 */
	private void drawRight_ThreeOutputs(Graphics g, Rectangle r) {
		//Draw the two left terminal
		g.drawLine(r.x + 7, r.y + 10, r.x + r.width, r.y + 10);
		g.drawLine(r.x + 7, r.y + 20, r.x + r.width, r.y + 20);
		g.drawLine(r.x + 7, r.y + 30, r.x + r.width, r.y + 30);
	}
	
	/**
	 * Draw the And Join with right rotation, and four outputs
	 */
	private void drawRight_FourOutputs(Graphics g, Rectangle r) {
		//Draw the two left terminal
		g.drawLine(r.x + 7, r.y + 5, r.x + r.width, r.y + 5);
		g.drawLine(r.x + 7, r.y + 15, r.x + r.width, r.y + 15);
		g.drawLine(r.x + 7, r.y + 25, r.x + r.width, r.y + 25);
		g.drawLine(r.x + 7, r.y + 35, r.x + r.width, r.y + 35);	
	}
	
	/**
	 * Draw the And Join with right rotation, and five outputs
	 */
	private void drawRight_FiveOutputs(Graphics g, Rectangle r) {
		//Draw the two left terminal
		g.drawLine(r.x + 7, r.y + 1, r.x + r.width, r.y + 1);
		g.drawLine(r.x + 7, r.y + 10, r.x + r.width, r.y + 10);
		g.drawLine(r.x + 7, r.y + 20, r.x + r.width, r.y + 20);
		g.drawLine(r.x + 7, r.y + 30, r.x + r.width, r.y + 30);
		g.drawLine(r.x + 7, r.y + 38, r.x + r.width, r.y + 38);	
	}
	
	/**
	 * Draw the And Fork with left rotation
	 */
	private void drawLeft(Graphics g, Rectangle r) {	
//		g.drawLine(r.right() - 7, r.y + 10, r.x, r.y + 10);
//		g.drawLine(r.right() - 7, r.bottom() - 10, r.x, r.bottom() - 10);

		//Draw the left terminal
		switch (nodeOutputsCount)
		{
			case 2:
			{
				drawLeft_TwoOutputs(g, r);
				break;
			}
			case 3:
			{
				drawLeft_ThreeOutputs(g, r);
				break;
			}
			case 4:
			{
				drawLeft_FourOutputs(g, r);
				break;
			}
			case 5:
			{
				drawLeft_FiveOutputs(g, r);
				break;
			}
		}
		
		g.drawLine(r.right() - 6 , r.y, r.right() - 6, r.bottom());
		
		g.drawLine(r.right(), r.y + r.height / 2, r.right() - 5, r.y + r.height / 2);
		
	}
	
	/**
	 * Draw the And Join with left rotation, and two outputs
	 */
	private void drawLeft_TwoOutputs(Graphics g, Rectangle r) {
		g.drawLine(r.right() - 7, r.y + 10, r.x, r.y + 10);
		g.drawLine(r.right() - 7, r.bottom() - 10, r.x, r.bottom() - 10);
	}
	
	/**
	 * Draw the And Join with left rotation, and three outputs
	 */
	private void drawLeft_ThreeOutputs(Graphics g, Rectangle r) {
		g.drawLine(r.right() - 7, r.y + 10, r.x, r.y + 10);
		g.drawLine(r.right() - 7, r.y + 20, r.x, r.y + 20);
		g.drawLine(r.right() - 7, r.y + 30, r.x, r.y + 30);
	}
	
	/**
	 * Draw the And Join with left rotation, and four outputs
	 */
	private void drawLeft_FourOutputs(Graphics g, Rectangle r) {
		g.drawLine(r.right() - 7, r.y + 5, r.x, r.y + 5);
		g.drawLine(r.right() - 7, r.y + 15, r.x, r.y + 15);
		g.drawLine(r.right() - 7, r.y + 25, r.x, r.y + 25);
		g.drawLine(r.right() - 7, r.y + 35, r.x, r.y + 35);
	}
	
	/**
	 * Draw the And Join with left rotation, and five outputs
	 */
	private void drawLeft_FiveOutputs(Graphics g, Rectangle r) {
		g.drawLine(r.right() - 7, r.y + 1, r.x, r.y + 1);
		g.drawLine(r.right() - 7, r.y + 10, r.x, r.y + 10);
		g.drawLine(r.right() - 7, r.y + 20, r.x, r.y + 20);
		g.drawLine(r.right() - 7, r.y + 30, r.x, r.y + 30);
		g.drawLine(r.right() - 7, r.y + 38, r.x, r.y + 38);
	}
	
	/**
	 * Draw the And Fork with up rotation
	 */
	private void drawUp(Graphics g, Rectangle r) {
//		g.drawLine(r.x + 10, r.y, r.x + 10, r.bottom() - 7);		
//		g.drawLine(r.right() - 10, r.y, r.right() - 10, r.bottom() - 7);
		
		switch (nodeOutputsCount)
		{
			case 2:
			{
				drawUp_TwoOutputs(g, r);
				break;
			}
			case 3:
			{
				drawUp_ThreeOutputs(g, r);
				break;
			}
			case 4:
			{
				drawUp_FourOutputs(g, r);
				break;
			}
			case 5:
			{
				drawUp_FiveOutputs(g, r);
				break;
			}
		}

		g.drawLine(r.x, r.bottom() - 6, r.right(), r.bottom() - 6);
		
		g.drawLine(r.x + r.width /2, r.bottom(), r.x + r.width /2, r.bottom() - 5);
	}
	
	/**
	 * Draw the And Join with up rotation, and two outputs
	 */
	private void drawUp_TwoOutputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + 10, r.y, r.x + 10, r.bottom() - 7);		
		g.drawLine(r.right() - 10, r.y, r.right() - 10, r.bottom() - 7);
	}
	
	/**
	 * Draw the And Join with up rotation, and three outputs
	 */
	private void drawUp_ThreeOutputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + 10, r.y, r.x + 10, r.bottom() - 7);		
		g.drawLine(r.x + 20, r.y, r.x + 20, r.bottom() - 7);
		g.drawLine(r.x + 30, r.y, r.x + 30, r.bottom() - 7);
	}
	
	/**
	 * Draw the And Join with up rotation, and four outputs
	 */
	private void drawUp_FourOutputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + 5, r.y, r.x + 5, r.bottom() - 7);		
		g.drawLine(r.x + 15, r.y, r.x + 15, r.bottom() - 7);
		g.drawLine(r.x + 25, r.y, r.x + 25, r.bottom() - 7);
		g.drawLine(r.x + 35, r.y, r.x + 35, r.bottom() - 7);
	}
	
	/**
	 * Draw the And Join with up rotation, and five outputs
	 */
	private void drawUp_FiveOutputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + 0, r.y, r.x + 1, r.bottom() - 7);		
		g.drawLine(r.x + 10, r.y, r.x + 10, r.bottom() - 7);
		g.drawLine(r.x + 20, r.y, r.x + 20, r.bottom() - 7);
		g.drawLine(r.x + 30, r.y, r.x + 30, r.bottom() - 7);
		g.drawLine(r.x + 38, r.y, r.x + 38, r.bottom() - 7);
	}
	
	/**
	 * Draw the And Fork with down rotation
	 */
	private void drawDown(Graphics g, Rectangle r) {
//		g.drawLine(r.x + 10, r.bottom(), r.x + 10, r.y + 7);		
//		g.drawLine(r.right() - 10, r.bottom(), r.right() - 10, r.y + 7);
		
		switch (nodeOutputsCount)
		{
			case 2:
			{
				drawDown_TwoOutputs(g, r);
				break;
			}
			case 3:
			{
				drawDown_ThreeOutputs(g, r);
				break;
			}
			case 4:
			{
				drawDown_FourOutputs(g, r);
				break;
			}
			case 5:
			{
				drawDown_FiveOutputs(g, r);
				break;
			}
		}

		g.drawLine(r.x, r.y + 6, r.right(), r.y + 6);
		
		g.drawLine(r.x + r.width /2, r.y, r.x + r.width /2, r.y + 5);
	}
	
	/**
	 * Draw the And Join with down rotation, and two outputs
	 */
	private void drawDown_TwoOutputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + 10, r.bottom(), r.x + 10, r.y + 7);		
		g.drawLine(r.right() - 10, r.bottom(), r.right() - 10, r.y + 7);
	}
	
	/**
	 * Draw the And Join with down rotation, and three outputs
	 */
	private void drawDown_ThreeOutputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + 10, r.bottom(), r.x + 10, r.y + 7);		
		g.drawLine(r.x + 20, r.bottom(), r.x + 20, r.y + 7);
		g.drawLine(r.x + 30, r.bottom(), r.x + 30, r.y + 7);
	}
	
	/**
	 * Draw the And Join with down rotation, and four outputs
	 */
	private void drawDown_FourOutputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + 5, r.bottom(), r.x + 5, r.y + 7);		
		g.drawLine(r.x + 15, r.bottom(), r.x + 15, r.y + 7);
		g.drawLine(r.x + 25, r.bottom(), r.x + 25, r.y + 7);
		g.drawLine(r.x + 35, r.bottom(), r.x + 35, r.y + 7);
	}
	
	/**
	 * Draw the And Join with down rotation, and five outputs
	 */
	private void drawDown_FiveOutputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + 1, r.bottom(), r.x + 1, r.y + 7);		
		g.drawLine(r.x + 10, r.bottom(), r.x + 10, r.y + 7);
		g.drawLine(r.x + 20, r.bottom(), r.x + 20, r.y + 7);
		g.drawLine(r.x + 30, r.bottom(), r.x + 30, r.y + 7);
		g.drawLine(r.x + 38, r.bottom(), r.x + 38, r.y + 7);
	}
}