package org.isistan.flabot.edit.ucmeditor.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.RGB;
import org.isistan.flabot.edit.editor.figures.ComponentFigure;

public class ObjectFigure extends ComponentFigure {

	/**
	 * Instantiates an instance of ObjectFigure
	 * 
	 * @param bC the background color of the component
	 * @param fC the foreground color of the component
	 * @param lS the line style of the component
	 */
	public ObjectFigure(RGB bC, RGB fC, int lS) {		
		super(bC, fC, lS);
	}
	
	/**
	 * Draw the object figure.
	 */
	@Override
	protected void outlineShape(Graphics graphics) {
		Rectangle rect = getHandleBounds().getCopy();
		
		graphics.setLineStyle(getLineStyle());
		
		//Draw the border line
		graphics.setLineWidth(getLineWidth());			
		Rectangle border = new Rectangle(rect.x, rect.y, rect.width, rect.height);
		graphics.drawRoundRectangle(border, border.width / 4, border.height / 4);
		//graphics.fillRectangle(border);
		
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
}
