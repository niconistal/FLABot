/**
 * $Id: DirectEditableFigure.java,v 1.2 2005/12/23 01:26:06 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.figures;

import org.eclipse.draw2d.IFigure;

/**
 * DirectEditableFigure
 * -	Interface uses for figures than can be DirectEditable
 * 
 * @author $Author: franco $
 *
 */
public interface DirectEditableFigure extends IFigure {

	public void setText(String text);
	
	public String getText();
}
