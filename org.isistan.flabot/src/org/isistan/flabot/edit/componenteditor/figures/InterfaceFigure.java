/**
 * $Id: InterfaceFigure.java,v 1.4 2005/12/22 22:37:47 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.figures;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.handles.HandleBounds;
import org.isistan.flabot.edit.editor.figures.FixedConnectionAnchor;

/**
 * InterfaceFigure
 * -	The figure used for interfaces
 * 
 *  @author $Author: franco $
 */
abstract public class InterfaceFigure extends Figure implements HandleBounds
{
	public static final Dimension defaultsize = new Dimension(40,15);
	
	protected FixedConnectionAnchor anchor = new FixedConnectionAnchor(this);	
	private String side = PortFigure.LEFT_SIDE;
	
	/**
	 * HandleBounds interface
	 * @return the handle bounds of the component
	 */
	public Rectangle getHandleBounds() {
		return getBounds().getCropped(new Insets(2,0,2,0));
	}
	
	/**
	 * Set the side of the interface figure in the component
	 * @param side the side of the interface figure
	 */
	public void setSide(String side) {
		this.side = side;
	}
	
	/**
	 * @return the side of the interface figure in the component
	 */
	public String getSide() {
		return side;
	}
	
	/**
	 * Interface figure uses local coordinates, this means its
	 * children are placed relative to this Figure's top-left corner.
	 * @return <code>true</code> if this Figure uses local coordinates
	 */
	protected boolean useLocalCoordinates(){return true;}
	
	/**
	 * @return the connection anchor of the interface figure
	 */
	public ConnectionAnchor getConnectionAnchor() {
		return anchor;
	}
	
	protected abstract void paintFigure(Graphics graphics);
}