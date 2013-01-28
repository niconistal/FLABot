/**
 * $Id: ConnectionToConnectionAnchor.java,v 1.2 2005/12/22 22:37:47 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.figures;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchorBase;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;

/**
 * ConnectionToConnectionAnchor
 * -	Anchor used for those connections that can have connections
 * 
 * @author $Author: franco $
 *
 */
public class ConnectionToConnectionAnchor extends ConnectionAnchorBase {
	Connection connection;
	
	/**
	 * Instantiates an instance of ConnectionToConnectionAnchor
	 * @param connection the connection that used this anchor
	 */
	public ConnectionToConnectionAnchor(Connection connection) {
		this.connection = connection;				
	}
	
	/**
	 * Returns the reference point for this anchor in absolute coordinates.
	 * @return The reference Point
	 */
	public Point getReferencePoint() {
		return  new ChopboxAnchor(connection).getReferencePoint(); 
	}
	
	/**
	 * Calculates the middle point of the connection
	 * @return the middle point of the connection
	 */
	public Point getLocation(Point p) {
		Point p0 = Point.SINGLETON;
		Point p1, p2;
		int middle = connection.getPoints().size() / 2;
		if (connection.getPoints().size() % 2 == 0)
			p1 = connection.getPoints().getPoint(middle-1);
		else
			p1 = connection.getPoints().getPoint(middle);
		
		p2 = connection.getPoints().getPoint(middle);
		connection.translateToAbsolute(p1);
		connection.translateToAbsolute(p2);
		p0.x = (p2.x - p1.x) / 2 + p1.x;
		p0.y = (p2.y - p1.y) / 2 + p1.y;
		return p0;		
	}
	
	/**
	 * @return the connection figure
	 */
	public IFigure getOwner()  { 
		return connection;
	}
}