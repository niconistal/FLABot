/**
 * $Id: CloneableShape.java,v 1.2 2005/12/23 01:26:06 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.figures;

import org.eclipse.draw2d.Shape;

/**
 * CloneableShape
 * 
 * @author $Author: franco $
 *
 */
public interface CloneableShape {
	
	/**
	 * Clones a shape.
	 * 
	 * @return the clone shape
	 */
	public Shape cloneShape();

}
