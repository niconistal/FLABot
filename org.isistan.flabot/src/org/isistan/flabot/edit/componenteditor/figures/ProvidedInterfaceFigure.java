/**
 * $Id: ProvidedInterfaceFigure.java,v 1.3 2005/12/22 22:37:47 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * ProvidedInterfaceFigure
 * -	The figure used for provided interfaces
 * 
 *  @author $Author: franco $
 */
public class ProvidedInterfaceFigure extends InterfaceFigure
{

	/**
	 * Instantiates an instance of ProvidedInterfaceFigure
	 */
	public ProvidedInterfaceFigure() {
		anchor.setOffsetV(7);
	}
	
	/**
	 * Draw the provided interface.
	 */
	protected void paintFigure(Graphics graphics) {
		graphics.setForegroundColor(ColorConstants.black);
		graphics.setBackgroundColor(ColorConstants.black);
		
		Rectangle r = getBounds().getCopy();
		r.crop(new Insets(2,0,2,0));
		
		int x1 = 0;		
		if (getSide().equals(PortFigure.LEFT_SIDE))
			x1 = r.x;
		else if (getSide().equals(PortFigure.RIGHT_SIDE))
			x1 = r.x + r.width - 12;
		
		graphics.setLineWidth(2);
		Rectangle oval = new Rectangle(x1, (r.y+r.height/2) - 4 , 8, 8);
		graphics.drawOval(oval);
		graphics.fillOval(oval);
		graphics.drawLine(r.x + 5, (r.y + r.height/2) , r.x + 30 , (r.y + r.height/2));
	}
	
	/**
	 * Set the side of the interface figure in the component, and updates the connection anchor according to this side.
	 * @param side the side of the interface figure
	 */
	public void setSide(String side) {
		super.setSide(side);
		
		if (side.equals(PortFigure.LEFT_SIDE)) {
			anchor.setOffsetH(5);
		} else if (side.equals(PortFigure.RIGHT_SIDE)) {
			anchor.setOffsetH(30);
		}
	}
}