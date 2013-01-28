/**
 * $Id: ComponentBoxAnchor.java,v 1.2 2005/12/22 22:37:47 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.figures;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.handles.HandleBounds;

/**
 * ComponentBoxAnchor
 * -	The anchor used with figures that implements the HandleBounds interface.
 * 
 * @author $Author: franco $
 *
 */
public class ComponentBoxAnchor extends ChopboxAnchor {
	
	/**
	 * Instantiates an instance of ComponentBoxAnchor
	 * @param figure the figure that used this anchor
	 */
	public ComponentBoxAnchor(HandleBounds figure) {
		super(figure);
	}
	
	/**
	 * Returns the bounds of this ChopboxAnchor's owner.
	 * The boounds of the figue are obtained by the getHandleBounds() method. 
	 */
	protected Rectangle getBox() {
		return ((HandleBounds)getOwner()).getHandleBounds();
	}
}