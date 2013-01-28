package org.isistan.flabot.edit.ucmeditor.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.isistan.flabot.edit.editor.figures.ComponentFigure;

public class AgentFigure extends ComponentFigure {

	/**
	 * Instantiates an instance of AgentFigure
	 * 
	 * @param bC the background color of the component
	 * @param fC the foreground color of the component
	 * @param lS the line style of the component
	 */
	public AgentFigure(RGB bC, RGB fC, int lS) {		
		super(bC, fC, lS);
	}
	
	/**
	 * Draw the agent figure.
	 */
	@Override
	protected void outlineShape(Graphics graphics) {
		Rectangle rect = getHandleBounds().getCopy();
		
		graphics.setLineStyle(getLineStyle());
		
		//Draw the border line
		graphics.setLineWidth(getLineWidth() * 5);
		
		graphics.drawLine(rect.x, rect.y, rect.x, rect.y + rect.height);
		graphics.drawLine(rect.x, rect.y, rect.x + rect.width, rect.y);
		graphics.drawLine(rect.x + rect.width, rect.y, rect.x + rect.width, rect.y + rect.height);
		graphics.drawLine(rect.x, rect.y + rect.height, rect.x + rect.width, rect.y + rect.height);
		
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
