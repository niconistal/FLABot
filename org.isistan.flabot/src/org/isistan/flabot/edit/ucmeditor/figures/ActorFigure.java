package org.isistan.flabot.edit.ucmeditor.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.RGB;
import org.isistan.flabot.edit.editor.figures.ComponentFigure;

public class ActorFigure extends ComponentFigure {

	/**
	 * Instantiates an instance of ActorFigure
	 * 
	 * @param bC the background color of the component
	 * @param fC the foreground color of the component
	 * @param lS the line style of the component
	 */
	public ActorFigure(RGB bC, RGB fC, int lS) {		
		super(bC, fC, lS);
	}
	
	/**
	 * Draw the actor figure.
	 */
	@Override
	protected void outlineShape(Graphics graphics) {
		Rectangle rect = getHandleBounds().getCopy();
		
		graphics.setLineStyle(getLineStyle());
		
		//Draw the border line
		graphics.setLineWidth(getLineWidth() * 3);			
		Rectangle border = new Rectangle(rect.x, rect.y, rect.width-1, rect.height-1);
		graphics.drawRectangle(border);		
		graphics.fillRectangle(border);
		
		//Draw the left-bottom figure
		graphics.setLineWidth(getLineWidth() * 2);
		Rectangle r0 = new Rectangle(rect.x + rect.width - 25, rect.y + 10, 11, 15);
		Rectangle actor = new Rectangle(r0.x + r0.width / 3, r0.y, 5, 5);

		graphics.drawOval(actor);
		
		Rectangle actorBody = new Rectangle(r0.x, r0.y + 5, 12, 5);
	
		graphics.drawLine(actorBody.x + (actorBody.width / 2), actorBody.y, actorBody.x + (actorBody.width / 2), actorBody.y + actorBody.height);
		graphics.drawLine(actorBody.x, actorBody.y + (actorBody.height / 2) + 1, actorBody.x + actorBody.width, actorBody.y + (actorBody.height / 2) + 1);
		
		actorBody.translate(0, 5);
		graphics.drawLine(actorBody.x + (actorBody.width / 2), actorBody.y, actorBody.x, actorBody.y + actorBody.height - 1);
		graphics.drawLine(actorBody.x + (actorBody.width / 2), actorBody.y, actorBody.x + actorBody.width, actorBody.y + actorBody.height - 1);
		
		updateNameBounds();
		Font oldFont = graphics.getFont();
		graphics.setFont(NameDefaulFont);		
		graphics.drawText(nameLabel.getText(), nameLabel.getBounds().x, nameLabel.getBounds().y);
		graphics.setFont(oldFont);
	}
}
