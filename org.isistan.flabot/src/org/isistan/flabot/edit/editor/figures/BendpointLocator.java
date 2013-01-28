/**
 * $Id: BendpointLocator.java,v 1.2 2005/12/23 01:26:06 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.figures;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.geometry.Point;

/**
 * BendpointLocator
 * -	Repositions a {@link Figure} attached to a {@link Connection} when the Connection is
 * 		moved.  Provides for alignment at the start (source), middle, or end (target) of the
 * 		Connection.
 */
public class BendpointLocator extends ConnectionLocator 
{

	/**
	 * Constructs a BendpointLocator with associated Connection <i>c</i>.
	 * @param c the connection associated with the locator        
	 */
	public BendpointLocator(Connection c) {
		super(c);
	}

	/**
	 * Returns the point of reference associated with this locator. 
	 * @return the reference point
	 */
	protected Point getReferencePoint() {
		Connection conn = getConnection();
		Point p = Point.SINGLETON;
		Point p1, p2;
		int middle = conn.getPoints().size() / 2;
		if (conn.getPoints().size() % 2 == 0)
			p1 = conn.getPoints().getPoint(middle-1);
		else
			p1 = conn.getPoints().getPoint(middle);
		
		p2 = conn.getPoints().getPoint(middle);
		conn.translateToAbsolute(p1);
		conn.translateToAbsolute(p2);
		p.x = (p2.x - p1.x) / 2 + p1.x;
		p.y = (p2.y - p1.y) / 2 + p1.y;
		return p;
	}
}