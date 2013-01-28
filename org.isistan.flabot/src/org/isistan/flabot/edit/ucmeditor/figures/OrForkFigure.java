/**
 * $Id: OrForkFigure.java,v 1.14 2006/02/10 20:32:20 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.figures;

import java.util.Iterator;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.swt.graphics.RGB;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;

/**
 * OrForkFigure
 * -	The figure used for Or Forks
 * 
 *  @author $Author: franco $
 */
public class OrForkFigure extends ThreeConnectionFigure implements HandleBounds {
	
	NodeVisualModel model;
	Label[] conditions;
	
	private int nodeOutputsCount = 2;
	/**
	 * Instantiates an instance of OrForkFigure
	 * 
	 * @param roration the fork rotation
	 * @param fC the foreground color of the fork
	 */
	public OrForkFigure(String rotation, RGB fc, IFigure parent, NodeVisualModel model, int nodeOutputsCount) {		
		super(rotation, fc, parent);
		this.model = model;
		this.parent = parent;
		this.nodeOutputsCount = nodeOutputsCount;
		conditions = new Label[nodeOutputsCount];
		
		for (int i=0; i<conditions.length;i++) {
			conditions[i] = new Label();
			conditions[i].setBackgroundColor(ColorConstants.buttonLightest);
			conditions[i].setOpaque(false);
			updateName(conditions[i]);			
		}
	}

	/**
	 * Draw the Or Fork
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
		// Draw the right terminal
		g.drawLine(r.x, r.y + r.height / 2, r.x + r.width / 2, r.y + r.height / 2);		
	}
	
	/**
	 * Draw the Or Fork with right rotation, and two outputs
	 */
	private void drawRight_TwoOutputs(Graphics g, Rectangle r) {
		// Draw the 2 left terminals
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + 10);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.bottom() - 10);
	
	}
	
	/**
	 * Draw the Or Fork with right rotation, and three outputs
	 */
	private void drawRight_ThreeOutputs(Graphics g, Rectangle r) {
		// Draw the 2 left terminals
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + 10);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + 20);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + 30);
	}
	
	/**
	 * Draw the Or Fork with right rotation, and four outputs
	 */
	private void drawRight_FourOutputs(Graphics g, Rectangle r) {
		// Draw the 2 left terminals
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + 5);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + 15);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + 25);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + 35);
	}
	
	/**
	 * Draw the Or Fork with right rotation, and five outputs
	 */
	private void drawRight_FiveOutputs(Graphics g, Rectangle r) {
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
		
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + r.height / 2);		
	}
	
	/**
	 * Draw the Or Fork with left rotation, and two outputs
	 */
	private void drawLeft_TwoOutputs(Graphics g, Rectangle r) {
		g.drawLine(r.x, r.y + 10, r.x + r.width / 2, r.y + r.height / 2);
		g.drawLine(r.x, r.bottom() - 10, r.x + r.width / 2, r.y + r.height / 2);
	}
	
	/**
	 * Draw the Or Fork with left rotation, and three outputs
	 */
	private void drawLeft_ThreeOutputs(Graphics g, Rectangle r) {
		g.drawLine(r.x, r.y + 10, r.x + r.width / 2, r.y + r.height / 2);
		g.drawLine(r.x, r.y + 20, r.x + r.width / 2, r.y + r.height / 2);
		g.drawLine(r.x, r.y + 30, r.x + r.width / 2, r.y + r.height / 2);
	}
	
	/**
	 * Draw the Or Fork with left rotation, and four outputs
	 */
	private void drawLeft_FourOutputs(Graphics g, Rectangle r) {
		g.drawLine(r.x, r.y + 5, r.x + r.width / 2, r.y + r.height / 2);
		g.drawLine(r.x, r.y + 15, r.x + r.width / 2, r.y + r.height / 2);
		g.drawLine(r.x, r.y + 25, r.x + r.width / 2, r.y + r.height / 2);
		g.drawLine(r.x, r.y + 35, r.x + r.width / 2, r.y + r.height / 2);
	}
	
	/**
	 * Draw the Or Fork with left rotation, and five outputs
	 */
	private void drawLeft_FiveOutputs(Graphics g, Rectangle r) {
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
		
		g.drawLine(r.x + r.width / 2, r.bottom(), r.x + r.width / 2, r.y + r.height / 2);		
	}
	
	/**
	 * Draw the Or Fork with up rotation, and two outputs
	 */
	private void drawUp_TwoOutputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 10, r.y);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.right() - 10, r.y);
	}
	
	/**
	 * Draw the Or Fork with up rotation, and three outputs
	 */
	private void drawUp_ThreeOutputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 10, r.y);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 20, r.y);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 30, r.y);
	}
	
	/**
	 * Draw the Or Fork with up rotation, and four outputs
	 */
	private void drawUp_FourOutputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 5, r.y);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 15, r.y);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 25, r.y);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 35, r.y);
	}
	
	/**
	 * Draw the Or Fork with up rotation, and five outputs
	 */
	private void drawUp_FiveOutputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 0, r.y);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 10, r.y);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 20, r.y);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 30, r.y);
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 40, r.y);
	}
	
	public void setConditionText(int nro, String text) {
		if (nro < 0 || nro >= conditions.length) 
			return;
		conditions[nro].setText(text);
		updateName(conditions[nro]);
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
	
	/**
	 * Draw the Or Fork with down rotation
	 */
	private void drawDown(Graphics g, Rectangle r) {
//		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 10, r.bottom());
//		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.right() - 10, r.bottom());
		
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
		
		g.drawLine(r.x + r.width / 2, r.y, r.x + r.width / 2, r.y + r.height / 2);		
	}
	
	/**
	 * Draw the Or Fork with down rotation, and two outputs
	 */
	private void drawDown_TwoOutputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 10, r.bottom());
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.right() - 10, r.bottom());
	}
	
	/**
	 * Draw the Or Fork with down rotation, and three outputs
	 */
	private void drawDown_ThreeOutputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 10, r.bottom());
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 20, r.bottom());
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 30, r.bottom());		
	}
	
	/**
	 * Draw the Or Fork with down rotation, and four outputs
	 */
	private void drawDown_FourOutputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 5, r.bottom());
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 15, r.bottom());
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 25, r.bottom());
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 35, r.bottom());
	}
	
	/**
	 * Draw the Or Fork with down rotation, and five outputs
	 */
	private void drawDown_FiveOutputs(Graphics g, Rectangle r) {
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 0, r.bottom());
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 10, r.bottom());
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 20, r.bottom());
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 30, r.bottom());
		g.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + 40, r.bottom());
	}
		
	public void setBounds(Rectangle bounds) {
		super.setBounds(bounds);
		
		if (model != null)  {
			int nro = 0;
			for (Iterator iter=model.getSourceConnections().iterator(); iter.hasNext() && nro < conditions.length;) {
				ConnectionVisualModel c = (ConnectionVisualModel) iter.next();
				NodeVisualModel visual = c.getTarget();
				// workaround for bug 0000613: an empty label is never added to the connection
				if (conditions[nro] != null && conditions[nro].getText().length() > 0) {
					int midPoint = (visual.getAbsoluteLocation().getX() + 7 -  conditions[nro].getTextBounds().width / 2);
					conditions[nro].setBounds(new Rectangle(midPoint, visual.getAbsoluteLocation().getY() - 25, conditions[nro].getTextBounds().width, conditions[nro].getTextBounds().height));
				}
				nro++;
			}
		}
	}
	
	/**
	 * Sets the responsibility figure name
	 * 
	 * @param text the new name
	 */
	public void setResponsibilityName(String text) {
		//Do not want to show the responsibility name fork nodes
	}	
	
	public void clear() {
		super.clear();
		for (int i=0; i<conditions.length;i++)
			clear(conditions[i]);
	}
}