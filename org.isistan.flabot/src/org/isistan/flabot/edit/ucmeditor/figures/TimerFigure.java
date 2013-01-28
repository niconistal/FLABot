package org.isistan.flabot.edit.ucmeditor.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * 
 * @author $Author: Martin Villalba $
 *
 */
public class TimerFigure extends ThreeConnectionFigure{//PathPointFigure{//ThreeConnectionFigure  {

	public static final Dimension defaultsize = new Dimension(20,20);
	
	public static Display getDisplay() {
	      Display display = Display.getCurrent();
	      //may be null if outside the UI thread
	      if (display == null)
	         display = Display.getDefault();
	      return display;		
	   }
	
	/**
	 * Instantiates an instance of ResponsibilityNodeFigure
	 * 
	 * @param parent the paret of the figure
	 * @param fC the foreground color of the path point
	 */
	public TimerFigure(String rotation, IFigure parent, RGB fC) {
		super(rotation, fC,parent);		
		setLocalParent(parent);
		setOpaque(true);
	}
	
	public void setBounds(Rectangle p) {
		super.setBounds(p);
		// workaround for bug 0000613: an empty label is never added to the connection
		if (name.getText().length() > 0) {
			int midPoint = this.getLocation().x  + getSize().width / 2 - (name.getTextBounds().width / 2);
			name.setBounds(new Rectangle(midPoint, getLocation().y - 15 , name.getTextBounds().width, name.getTextBounds().height));
		}
	}	
	
	/**
	 * Draw the timer figure.
	 */
	public void outlineShape(Graphics graphics) {
		graphics.setLineWidth(2);		
		
		Rectangle r = getBounds().getCopy();
		
//		r.setSize(20, 20);
//		
//		if ((rotation.equals(UP)) || (rotation.equals(DOWN)))
//			setTranslateHorizontal(graphics, r);
//		else
//			setTranslateVertical(graphics, r);
//		
//		graphics.drawOval(r);
//		
//		graphics.drawLine(r.x + r.width /2, r.y, r.x + r.width /2, r.y + r.height /2);
//		graphics.drawLine(r.x + r.width /2, r.y + r.height /2, r.x + r.width - 5, r.y + r.height /2);
		
		if (rotation.equals(LEFT))	
			drawLeft(graphics,r);
		else if (rotation.equals(RIGHT))
			drawRight(graphics,r);
		else if (rotation.equals(UP))
			drawUp(graphics,r);
		else if (rotation.equals(DOWN))
			drawDown(graphics,r);		
		
	}
	
	/**
	 * Draw the Or Fork with right rotation
	 */
	private void setTranslateVertical(Graphics graphics, Rectangle r) {
		r.translate(0, 10);
		
		if (rotation.equals(RIGHT))
			graphics.drawLine(r.x + r.width, r.y, r.x + r.width, r.y + r.height);
		else
			graphics.drawLine(r.x, r.y, r.x, r.y + r.height);
	}
	
	/**
	 * set the translation of the rectangle
	 */
	private void setTranslateHorizontal(Graphics graphics, Rectangle r) {
		r.translate(10, 0);	
		if (rotation.equals(UP))
			graphics.drawLine(r.x, r.y, r.x + r.width, r.y);
		else
			graphics.drawLine(r.x, r.y + r.height, r.x + r.width, r.y + r.height);
	}
	
	/**
	 * Draw the Timer with right rotation
	 */
	private void drawRight(Graphics graphics, Rectangle r) {
		r.setSize(20, 20);
		graphics.drawLine(r.x,r.y, r.x, r.y + r.height);
		
		graphics.drawOval(r);
		
		graphics.drawLine(r.x + r.width /2, r.y, r.x + r.width /2, r.y + r.height /2);
		graphics.drawLine(r.x + r.width /2, r.y + r.height /2, r.x + r.width - 5, r.y + r.height /2);
		
		r.translate(0,20);
		graphics.drawLine(r.x,r.y, r.x, r.y + (r.height /2));
		
		graphics.drawLine(r.x + r.width /2, r.y, r.x + ((r.width /4)*3), r.y + r.height /2);
		graphics.drawLine(r.x +((r.width /4)*3), r.y + r.height /2, r.x + ((r.width /4)*3), r.y);
		graphics.drawLine(r.x + ((r.width /4)*3), r.y, r.x + r.width, r.y + r.height /2);	
		
	}
	
	/**
	 * Draw the Timer with left rotation
	 */
	private void drawLeft(Graphics graphics, Rectangle r) {
		r.setSize(20, 20);
		graphics.drawLine(r.x + r.width,r.y, r.x + r.width, r.y + r.height);
		
		graphics.drawOval(r);
		
		graphics.drawLine(r.x + r.width /2, r.y, r.x + r.width /2, r.y + r.height /2);
		graphics.drawLine(r.x + r.width /2, r.y + r.height /2, r.x + r.width - 5, r.y + r.height /2);
		
		r.translate(0,20);
		graphics.drawLine(r.x + r.width,r.y, r.x + r.width, r.y + (r.height /2));
		
		graphics.drawLine(r.x + r.width /2, r.y, r.x + r.width /4, r.y + r.height /2);
		graphics.drawLine(r.x + r.width /4, r.y + r.height /2, r.x + r.width /4, r.y);
		graphics.drawLine(r.x + r.width /4, r.y, r.x, r.y + r.height /2);		
	}
	
	/**
	 * Draw the Timer with up rotation
	 */
	private void drawUp(Graphics graphics, Rectangle r) {
		r.setSize(20, 20);
		graphics.drawLine(r.x,r.y + r.height, r.x + r.width, r.y + r.height);
		
		graphics.drawOval(r);
		
		graphics.drawLine(r.x + r.width /2, r.y, r.x + r.width /2, r.y + r.height /2);
		graphics.drawLine(r.x + r.width /2, r.y + r.height /2, r.x + r.width - 5, r.y + r.height /2);
		
		r.translate(20,0);
		graphics.drawLine(r.x,r.y + r.height, r.x + (r.width /2), r.y + r.height);
		
		graphics.drawLine(r.x, r.y + r.height / 2, r.x + r.width /2, r.y + r.height / 4);
		graphics.drawLine(r.x + r.width /2, r.y +r.height / 4, r.x, r.y + r.height /4);
		graphics.drawLine(r.x, r.y + r.height /4, r.x + r.width /2, r.y);			
	}
	
	/**
	 * Draw the Timer with down rotation
	 */
	private void drawDown(Graphics graphics, Rectangle r) {
		r.setSize(20, 20);
		graphics.drawLine(r.x,r.y, r.x + r.width, r.y);
		
		graphics.drawOval(r);
		
		graphics.drawLine(r.x + r.width /2, r.y, r.x + r.width /2, r.y + r.height /2);
		graphics.drawLine(r.x + r.width /2, r.y + r.height /2, r.x + r.width - 5, r.y + r.height /2);
		
		r.translate(20,0);
		graphics.drawLine(r.x,r.y, r.x + (r.width /2), r.y);
		
		graphics.drawLine(r.x, r.y + r.height / 2, r.x + r.width /2, r.y + ((r.height / 4)*3));
		graphics.drawLine(r.x + r.width /2,  r.y + ((r.height / 4)*3), r.x,  r.y + ((r.height / 4)*3));
		graphics.drawLine(r.x,  r.y + ((r.height / 4)*3), r.x + r.width /2, r.y + r.height);				
	}
	
	/**
	 * Sets the responsibility figure name
	 * 
	 * @param text the new name
	 */
	public void setTimerName(String text) {
		name.setText(text);
		updateName(name);
	}
}
