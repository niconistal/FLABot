/**
 * $Id: ResponsibilityNodeFigure.java,v 1.27 2006/02/21 20:08:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.RGB;

/**
 * ResponsibilityNodeFigure
 * -	Figure used for responsibilities nodes.
 * 
 * @author $Author: franco $
 *
 */
public class ResponsibilityNodeFigure extends PathPointFigure {
		
	/**
	 * Instantiates an instance of ResponsibilityNodeFigure
	 * 
	 * @param parent the paret of the figure
	 * @param fC the foreground color of the path point
	 */
	public ResponsibilityNodeFigure(IFigure parent, RGB fC) {
		super(fC);		
		setLocalParent(parent);
		setOpaque(true);
	}
	
	/**
	 * Instantiates an instance of ResponsibilityNodeFigure
	 * 
	 * @param fC the foreground color of the path point
	 */
	protected ResponsibilityNodeFigure(RGB fC) {
		super(fC);
	}
	
	/**
	 * Sets the responsibility figure name
	 * 
	 * @param text the new name
	 */
	public void setResponsibilityName(String text) {
		name.setText(text);
		updateName(name);
	}	
	
	public void setBounds(Rectangle p) {
		super.setBounds(p);
		// workaround for bug 0000613: an empty label is never added to the connection
		if (name.getText().length() > 0) {
			int midPoint = this.getLocation().x  + getSize().width / 2 - (name.getTextBounds().width / 2);
			name.setBounds(new Rectangle(midPoint, getLocation().y - 15 , name.getTextBounds().width, name.getTextBounds().height));
		}
	}
	
	private void drawCross(Graphics graphics, int x, int y, int size) {
		graphics.drawLine(x       , y,
			      		  x + size, y + size);
		graphics.drawLine(x       , y + size,
			              x + size, y);
	}
	
	
	/**
	 * Draw the responsibility figure.
	 */
	public void outlineShape(Graphics graphics) {
		graphics.setLineWidth(2);		
		drawCross(graphics, getLocation().x, getLocation().y , defaultsize.width);
	}
}