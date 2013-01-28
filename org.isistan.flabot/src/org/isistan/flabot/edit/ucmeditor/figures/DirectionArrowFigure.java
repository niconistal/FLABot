package org.isistan.flabot.edit.ucmeditor.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.RGB;

public class DirectionArrowFigure extends PathPointFigure{

	
	public static final String TOP = "Top";
	public static final String TOP_RIGHT = "Top_Right";
	public static final String RIGHT = "Right";
	public static final String BOTTOM_RIGHT = "Bottom_Right";
	public static final String BOTTOM = "Bottom";
	public static final String BOTTOM_LEFT = "Bottom_Left";
	public static final String LEFT = "Left";
	public static final String TOP_LEFT = "Top_Left";
	
	public static Dimension defaultSize = new Dimension(20,20); 
	
	private String rotation;
	
	public DirectionArrowFigure(String rotation, RGB fC)
	{
		super(fC);
		this.rotation = rotation;
	}
	
	/**
	 * Draw the path point
	 */
	@Override
	public void outlineShape(Graphics graphics) {
		Rectangle r = getBounds().getCopy();
		r.setSize(20,20);
		graphics.setLineWidth(2);
		
		if (this.rotation.equals(TOP))
			drawTopArrow(graphics, r);
		
		if (this.rotation.equals(TOP_RIGHT))
			drawTopRightArrow(graphics, r);
		
		if (this.rotation.equals(RIGHT))
			drawRightArrow(graphics, r);
		
		if (this.rotation.equals(BOTTOM_RIGHT))
			drawBottomRightArrow(graphics, r);
		
		if (this.rotation.equals(BOTTOM))
			drawBottomArrow(graphics, r);
		
		if (this.rotation.equals(BOTTOM_LEFT))
			drawBottomLeftArrow(graphics, r);
		
		if (this.rotation.equals(LEFT))
			drawLeftArrow(graphics, r);
		
		if (this.rotation.equals(TOP_LEFT))
			drawTopLeftArrow(graphics, r);
		
	}
	
	private void drawTopArrow(Graphics graphics, Rectangle r)
	{
//		graphics.drawLine(r.x, r.y + r.height, r.x + r.width / 2, r.y + r.height / 2);
//		graphics.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + r.height);
		
		graphics.drawLine(r.x + r.width / 2 - 7, r.y + r.height / 2 + 7, r.x + r.width / 2, r.y + r.height / 2);
		graphics.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width / 2 + 7, r.y + r.height / 2 + 7);
	}
	
	private void drawBottomArrow(Graphics graphics, Rectangle r)
	{
//		graphics.drawLine(r.x, r.y, r.x + r.width / 2, r.y + r.height / 2);
//		graphics.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y);
		
		graphics.drawLine(r.x + r.width / 2 - 7, r.y + r.height / 2 - 7, r.x + r.width / 2, r.y + r.height / 2);
		graphics.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width / 2 + 7, r.y + r.height / 2 - 7);
	}
	
	private void drawRightArrow(Graphics graphics, Rectangle r)
	{
//		graphics.drawLine(r.x, r.y, r.x + r.width / 2, r.y + r.height / 2);
//		graphics.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x, r.y + r.height);
		
		graphics.drawLine(r.x + r.width / 2 - 7, r.y + r.height / 2 - 7, r.x + r.width / 2, r.y + r.height / 2);
		graphics.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width / 2 - 7, r.y + r.height / 2 + 7);
	}
	
	private void drawLeftArrow(Graphics graphics, Rectangle r)
	{
//		graphics.drawLine(r.x + r.width, r.y, r.x + r.width / 2, r.y + r.height / 2);
//		graphics.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + r.height);
		
		graphics.drawLine(r.x + r.width / 2 + 7, r.y + r.height / 2 - 7, r.x + r.width / 2, r.y + r.height / 2);
		graphics.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width / 2 + 7, r.y + r.height / 2 + 7);
	}
	 
	private void drawTopRightArrow(Graphics graphics, Rectangle r)
	{
//		graphics.drawLine(r.x + r.width, r.y, r.x + r.width / 4, r.y);
//		graphics.drawLine(r.x + r.width, r.y, r.x + r.width, r.y + r.height * 3 / 4);
		graphics.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x, r.y + r.height / 2);
		graphics.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width / 2, r.y + r.height);
	}
	
	private void drawTopLeftArrow(Graphics graphics, Rectangle r)
	{
//		graphics.drawLine(r.x, r.y, r.x + r.width * 3 / 4, r.y);
//		graphics.drawLine(r.x, r.y, r.x, r.y + r.height * 3 / 4);
		graphics.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + r.height / 2);
		graphics.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width / 2, r.y + r.height);
	}
	
	private void drawBottomRightArrow(Graphics graphics, Rectangle r)
	{
//		graphics.drawLine(r.x + r.width, r.y + r.height, r.x + r.width, r.y + r.height / 4);
//		graphics.drawLine(r.x + r.width, r.y + r.height, r.x + r.width / 4, r.y + r.height);
		graphics.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x, r.y + r.height / 2);
		graphics.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width / 2, r.y);
	}
	
	private void drawBottomLeftArrow(Graphics graphics, Rectangle r)
	{
//		graphics.drawLine(r.x, r.y + r.height, r.x + r.width * 3 / 4, r.y + r.height);
//		graphics.drawLine(r.x, r.y + r.height, r.x, r.y + r.height / 4);
		graphics.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width, r.y + r.height / 2);
		graphics.drawLine(r.x + r.width / 2, r.y + r.height / 2, r.x + r.width / 2, r.y);
	}
	
	public String getRotation()
	{
		return rotation;
	}
	
	public void setRotation(String rotation)
	{
		this.rotation = rotation;
	}
}
