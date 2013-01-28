/**
 * $Id: ComponentFigure.java,v 1.14 2006/03/21 01:51:58 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.figures;

import java.util.Iterator;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * ComponentFigure
 * -	The figure used for components in the ucm diagrams
 * 
 *  @author $Author: franco $
 */
public class ComponentFigure extends Shape implements HandleBounds, CloneableShape, DirectEditableFigure {

	public static final Dimension defaultsize = new Dimension(100,60);
	
	protected static final Font NameDefaulFont = new Font(Display.getCurrent(), "Verdana", 9 , SWT.BOLD); //$NON-NLS-1$
	
	protected Label nameLabel = new Label(""); //$NON-NLS-1$
	
	private String name; // workaround for bug 0000613
	
	/**
	 * Instantiates an instance of ComponentFigure
	 * 
	 * @param bC the background color of the component
	 * @param fC the foreground color of the component
	 * @param lS the line style of the component
	 */
	public ComponentFigure(RGB bC, RGB fC, int lS) {		
		nameLabel.setFont(NameDefaulFont);

		setBackgroundColor(new Color(Display.getCurrent(), bC));
		setForegroundColor(new Color(Display.getCurrent(), fC));
		setLineStyle(lS);
		
		setLayoutManager(new XYLayout());			
		setOpaque(true);
	}
	
	/**
	 * DirectEditableFigure interface
	 * 
	 * Sets the name of the component
	 */
	public void setText(String name) {
		this.name = name; // workaround for bug 0000613
		nameLabel.setText(new String(name.trim()));
		updateNameBounds();
		repaint();
	}
	
	protected void updateNameBounds() {
		if (name != null && !name.trim().equals("")) { // workaround for bug 0000613 //$NON-NLS-1$
			Rectangle roriginal = getBounds().getCopy();
			nameLabel.setBounds(new Rectangle(roriginal.x + roriginal.width / 2 - nameLabel.getTextBounds().width / 2 , roriginal.y + 35 , nameLabel.getTextBounds().width, nameLabel.getTextBounds().height));
		}
	}
	
	/**
	 * DirectEditableFigure interface
	 * 
	 * @return the name of the component
	 */
	public String getText() {
		return nameLabel.getText();
	}
		
	/**
	 * Draw the component figure.
	 */
	protected void outlineShape(Graphics graphics) {
		Rectangle rect = getHandleBounds().getCopy();
		
		graphics.setLineStyle(getLineStyle());
		
		//Draw the border line
		graphics.setLineWidth(getLineWidth() * 3);			
		Rectangle border = new Rectangle(rect.x, rect.y, rect.width-1, rect.height-1);
		graphics.drawRectangle(border);		
		graphics.fillRectangle(border);
		
		//Draw the left-bottom figure

		//Main rectangle
		graphics.setLineWidth(getLineWidth());
		Rectangle r0 = new Rectangle(rect.x + rect.width - 25, rect.y + 10, 12, 14);
		graphics.drawRectangle(r0);
		graphics.fillRectangle(r0.x + 1, r0.y + 1, r0.width-1, r0.height-1);
		
		//Little rectangles
		Rectangle r1 = new Rectangle(rect.x + rect.width - 27, rect.y + 12, 6, 4);	
		graphics.drawRectangle(r1);
		graphics.fillRectangle(r1.x + 1, r1.y + 1, r1.width-1, r1.height-1);
		
		Rectangle r2 = new Rectangle(rect.x + rect.width - 27, rect.y + 18, 6, 4);
		graphics.drawRectangle(r2);	
		graphics.fillRectangle(r2.x + 1, r2.y + 1, r2.width-1, r2.height-1);
		
		updateNameBounds();
		Font oldFont = graphics.getFont();
		graphics.setFont(NameDefaulFont);		
		graphics.drawText(nameLabel.getText(), nameLabel.getBounds().x, nameLabel.getBounds().y);
		graphics.setFont(oldFont);
	}
	
	protected void fillShape(Graphics graphics) {
		//Do nothing
	}
	
	/**
	 * HandleBounds interface
	 * 
	 * @return the handle bounds of the component
	 */	
	public Rectangle getHandleBounds() {
		return getBounds().getCropped(new Insets(1,1,1,1));
	}
	
	public void setBounds(Rectangle r) {
		super.setBounds(r);		
		for (Iterator iter=getChildren().iterator(); iter.hasNext();) {
			Figure figure = (Figure) iter.next();
			figure.setBounds(figure.getBounds());
		}
	}
	
	/**
	 * CloneableShape interface
	 * 
	 * @return a clone of the component figure
	 */
	public Shape cloneShape() {
		ComponentFigure clone = new ComponentFigure(getBackgroundColor().getRGB()
				, getForegroundColor().getRGB(), getLineStyle());
		clone.setText(nameLabel.getText());
		clone.setSize(getMinimumSize());
		return clone;
	}
	
	/**
	 * @return the minimum dimension of the component figure
	 */
	public Dimension getMinimumSize(int wHint, int hHint) {
		Rectangle r = nameLabel.getBounds();
		return new Dimension(r.width + 10, r.height + 10).union(defaultsize);
	}
	
	/**
	 * Port figure do not use local coordinates, this means its
	 * children are not placed relative to this Figure's top-left corner.
	 * 
	 * @return <code>true</code> if this Figure uses local coordinates
	 */
	protected boolean useLocalCoordinates(){return false;}
}