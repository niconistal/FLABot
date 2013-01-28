/** * $Id: Util.java,v 1.3 2005/12/22 23:48:40 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.edit.editormodel;


public class Util {
	
	//Point
	
	public static Point getPoint(int x, int y) {
		Point modelPoint=EditormodelFactory.eINSTANCE.createPoint();
		modelPoint.setX(x);
		modelPoint.setY(y);
		return modelPoint;
	}
	

	public static Point getPoint(org.eclipse.draw2d.geometry.Point point) {
		return getPoint(point.x, point.y);
	}

	public static org.eclipse.draw2d.geometry.Point getDraw2DPoint(Point point) {
		return new org.eclipse.draw2d.geometry.Point(point.getX(), point.getY());
	}

	//Dimension
	public static Dimension getDimension(int width, int height) {
		Dimension modelDimension=EditormodelFactory.eINSTANCE.createDimension();
		modelDimension.setWidth(width);
		modelDimension.setHeight(height);
		return modelDimension;
	}
	

	public static Dimension getDimension(org.eclipse.draw2d.geometry.Dimension dimension) {
		return getDimension(dimension.width, dimension.height);
	}

	public static org.eclipse.draw2d.geometry.Dimension getDraw2DDimension(Dimension dimension) {
		return new org.eclipse.draw2d.geometry.Dimension(dimension.getWidth(), dimension.getHeight());
	}

	//Color
	public static Color getColor(int red, int green, int blue) {
		Color modelColor=EditormodelFactory.eINSTANCE.createColor();
		modelColor.setRed(red);
		modelColor.setGreen(green);
		modelColor.setBlue(blue);
		return modelColor;
	}
	
	public static Color getColor(org.eclipse.swt.graphics.RGB rgb) {
		Color modelColor=EditormodelFactory.eINSTANCE.createColor();
		modelColor.setRed(rgb.red);
		modelColor.setGreen(rgb.green);
		modelColor.setBlue(rgb.blue);
		return modelColor;
	}

	public static Color getColor(org.eclipse.swt.graphics.Color color) {
		return getColor(color.getRed(), color.getGreen(), color.getBlue());
	}
	
	public static org.eclipse.swt.graphics.Color getSWRColor(org.eclipse.swt.widgets.Display display, Color color) {
		return new org.eclipse.swt.graphics.Color(display, color.getRed(), color.getGreen(), color.getBlue());
	}
	
	public static org.eclipse.swt.graphics.RGB getSWTRGB(Color color) {
		return new org.eclipse.swt.graphics.RGB(color.getRed(), color.getGreen(), color.getBlue());
	}
	
	
	//Other
	
	public static org.eclipse.draw2d.geometry.Rectangle getDraw2DRectangle(Point point, Dimension dimension) {
		return new org.eclipse.draw2d.geometry.Rectangle(
				point.getX(),
				point.getY(),
				dimension.getWidth(),
				dimension.getHeight()
				);
	}
}
