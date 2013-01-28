/**
 * $Id: EllipseFigure.java,v 1.1 2006/03/29 20:21:58 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.mapview.figure;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

/**
 * @author $Author: franco $
 *
 */
public class EllipseFigure extends Ellipse {
	
	private static final Font defaultFont = new Font(Display.getCurrent(), "Verdana", 9 , SWT.BOLD); //$NON-NLS-1$
	
	private Label label = new Label();
	
	public EllipseFigure() {
		label.setFont(defaultFont);		
	}
	
	public void setText(String text) {
		label.setText(text);
	}
	
	/**
	 * Outlines the ellipse.
	 * @see org.eclipse.draw2d.Shape#outlineShape(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void outlineShape(Graphics graphics) {	
		graphics.drawOval(getBounds().x + 1, getBounds().y + 1, getBounds().width - 2, getBounds().height - 2);
		Font oldfont = graphics.getFont();
		graphics.setFont(defaultFont);
		graphics.drawString(label.getText(), (getBounds().x + getBounds().width / 2) - (label.getTextBounds().width / 2), (getBounds().y + getBounds().height / 2) - (label.getTextBounds().height / 2));
		graphics.setFont(oldfont);
	}
}