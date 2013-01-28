package org.isistan.flabot.executionstatemapping.editor.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.isistan.flabot.executionstatemapping.messages.Messages;

public class FinalStateFigure extends StateFigure {
	
	private static final Font NameDefaulFont = new Font(Display.getCurrent(), "Verdana", 7 , SWT.ITALIC); //$NON-NLS-1$
	
	public String finalStateText = Messages.getString("org.isistan.flabot.executionmapping.editor.figures.FinalStateFigure.final"); //$NON-NLS-1$
	
	/**
	 * Instantiates an instance of ComponentFigure
	 * 
	 * @param bC the background color of the component
	 * @param fC the foreground color of the component
	 * @param lS the line style of the component
	 */
	public FinalStateFigure(RGB bC, RGB fC, int lS) {		
		super(bC, fC,lS);
	}		
		
	public void setFinalStateText(String finalState)
	{
		finalStateText = finalState;
		repaint();
	}
	
	/**
	 * Draw the component figure.
	 */
	@Override
	protected void outlineShape(Graphics graphics) 
	{		
		super.outlineShape(graphics);				
		
		Rectangle f = Rectangle.SINGLETON;
		Rectangle r = getBounds();
		f.x = r.x + 3 + lineWidth / 2;
		f.y = r.y + 3 + lineWidth / 2;
		f.width = r.width - lineWidth - 6-3;
		f.height = r.height - lineWidth - 6;
		graphics.drawRoundRectangle(f, corner.width, corner.height);				
		
		Font oldFont = graphics.getFont();
		graphics.setFont(NameDefaulFont);
		graphics.drawText(finalStateText, r.x + 8, r.y + 5);
		graphics.setFont(oldFont);		
	}
	
	@Override
	public Shape cloneShape() {
		FinalStateFigure clone = new FinalStateFigure(getBackgroundColor().getRGB()
				, getForegroundColor().getRGB(), getLineStyle());
		clone.setText(nameLabel.getText());
		clone.setSize(getMinimumSize());
		clone.setFinalStateText(finalStateText);
		return clone;
	}
}