package org.isistan.flabot.edit.ucmeditor.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * 
 * @author $Author: Martin Villalba $
 *
 */
public class DynamicStubFigure  extends PathPointFigure {			
	
	public static final Dimension defaultsize = new Dimension(20,20);
	NodeVisualModel model;
	
	protected Label in = new Label();
	protected Label out = new Label();
	
	/**
	 * Instantiates an instance of StubFigure
	 * 
	 * @param fC the foreground color of the path point
	 */
	public DynamicStubFigure(RGB fC, IFigure parent, NodeVisualModel model) {
		super(fC);
		setBackgroundColor(new Color(Display.getCurrent(), fC));
		this.model = model;
		setLocalParent(parent);
	}
	
	/**
	 * Sets the local parent of this figure
	 * 
	 * @param parent the new parent
	 */
	public void setLocalParent(IFigure parent){
		super.setLocalParent(parent);
		updateName(in);
		updateName(out);
	}
	
	public void setForegroundColor(Color fg) {
		super.setForegroundColor(fg);
		setBackgroundColor(fg);
	}
	
	public void setBounds(Rectangle p) {
		super.setBounds(p);

		// workaround for bug 0000613: an empty label is never added to the connection		
//		if (in != null && in.getText().length() > 0) {
//			int midPoint = getLocation().x  + getSize().width / 2 - (in.getTextBounds().width / 2);
//			in.setBounds(new Rectangle(midPoint, getLocation().y + getSize().height + 1 , in.getTextBounds().width, in.getTextBounds().height));
//		}
//		
//		if (out != null && out.getText().length() > 0) {
//			int midPoint = getLocation().x  + getSize().width / 2 - (out.getTextBounds().width / 2);
//			out.setBounds(new Rectangle(midPoint, getLocation().y + getSize().height + 15 , out.getTextBounds().width, out.getTextBounds().height));
//		}
	}
	
	/**
	 * Draw the stub node
	 */
	public void outlineShape(Graphics graphics) {
		
		Rectangle r = getBounds().getCopy();
		r.setSize(18,18);
		graphics.setLineWidth(2);
		
		graphics.drawLine(r.x, r.y + r.height / 2, r.x + r.width / 6, r.y + r.height / 3);
		graphics.drawLine(r.x, r.y + r.height / 2, r.x + r.width / 6, r.y + (r.height / 3) * 2);
		
		graphics.drawLine(r.x + r.width / 2, r.y, r.x + r.width / 3, r.y + r.height / 6);
		graphics.drawLine(r.x + r.width / 2, r.y, r.x + (r.width / 3) * 2, r.y + r.height / 6);
		
		graphics.drawLine(r.x + r.width, r.y + r.height / 2, r.x + (r.width / 6) * 5, r.y + r.height / 3);
		graphics.drawLine(r.x + r.width, r.y + r.height / 2, r.x + (r.width / 6) * 5, r.y + (r.height / 3) * 2);
		
		graphics.drawLine(r.x + r.width / 2, r.y + r.height, r.x + r.width / 3, r.y + (r.height / 6 * 5));
		graphics.drawLine(r.x + r.width / 2, r.y + r.height, r.x + (r.width / 3) * 2, r.y + (r.height / 6) * 5);
	}
}
