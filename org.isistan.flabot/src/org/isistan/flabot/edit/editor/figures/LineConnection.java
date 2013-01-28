/**
 * $Id: LineConnection.java,v 1.2 2005/12/23 01:26:06 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.figures;

import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.Shape;
import org.eclipse.swt.graphics.Color;

/**
 * LineConnection
 * -	The figure used for interface connections and relationships
 * 
 *  @author $Author: franco $
 */
public class LineConnection extends PolylineConnection implements CloneableShape {
	
	/**
	 * Instantiates an instance of LineConnection
	 *   
	 * @param lS the line style of the connection
	 * @param lW the line width of the connection
	 * @param fC the foreground color of the connection
	 */
	public LineConnection(int lineStyle, int lineWidth, Color fc) {
		super();
		setLineStyle(lineStyle);
		setLineWidth(lineWidth);
		setForegroundColor(fc);
	}
	
	/**
	 * CloneableShape interface
	 * 
	 * @return a clone of the connection figure
	 */
	public Shape cloneShape() {
		LineConnection clone = new LineConnection(getLineStyle(), getLineWidth(), getForegroundColor());
		clone.setForegroundColor(getForegroundColor());
		return clone;
	}
}