/**
 * $Id: StubFigure.java,v 1.5 2006/03/21 02:34:08 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * StubFigure
 * -	Figure used for stub nodes.
 * 
 * @author $Author: franco $
 *
 */
public class StubFigure extends PathPointFigure {			
	
	NodeVisualModel model;
	
	protected Label in = new Label();
	protected Label out = new Label();
	
	/**
	 * Instantiates an instance of StubFigure
	 * 
	 * @param fC the foreground color of the path point
	 */
	public StubFigure(RGB fC, IFigure parent, NodeVisualModel model) {
		super(fC);
		setBackgroundColor(new Color(Display.getCurrent(), fC));
		this.model = model;
		setLocalParent(parent);
		
		in.setBackgroundColor(ColorConstants.buttonLightest);
		in.setOpaque(false);
		updateName(in);
		out.setBackgroundColor(ColorConstants.buttonLightest);
		out.setOpaque(false);
		updateName(out);
	}
	
	/**
	 * Sets the name of in point
	 * 
	 * @param name the new name
	 */
	public void setInText(String text) {
		in.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.figures.StubFigure.in") + text); //$NON-NLS-1$
		updateName(in);
	}
	
	/**
	 * Sets the name of out point
	 * 
	 * @param name the new name
	 */
	public void setOutText(String text) {
		out.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.figures.StubFigure.out") + text); //$NON-NLS-1$
		updateName(out);
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
		
		
	/*	if (model != null) {
		ConnectionVisualModel c = (ConnectionVisualModel) model.getTargetConnections().get(0);
		NodeVisualModel visual = c.getSource();
		// workaround for bug 0000613: an empty label is never added to the connection
		if (in != null && in.getText().length() > 0) {
			int midPoint = (visual.getAbsoluteLocation().getX() + 7 -  in.getTextBounds().width / 2);
			in.setBounds(new Rectangle(midPoint, visual.getAbsoluteLocation().getY() - 25, in.getTextBounds().width, in.getTextBounds().height));
		}
		
		c = (ConnectionVisualModel) model.getSourceConnections().get(0);
		visual = c.getTarget();
		// workaround for bug 0000613: an empty label is never added to the connection
		if (out != null && out.getText().length() > 0) {
			int midPoint = (visual.getAbsoluteLocation().getX() + 7 -  out.getTextBounds().width / 2);
			out.setBounds(new Rectangle(midPoint, visual.getAbsoluteLocation().getY() - 25, out.getTextBounds().width, out.getTextBounds().height));
		}
		}*/

		// workaround for bug 0000613: an empty label is never added to the connection		
		if (in != null && in.getText().length() > 0) {
			int midPoint = getLocation().x  + getSize().width / 2 - (in.getTextBounds().width / 2);
			in.setBounds(new Rectangle(midPoint, getLocation().y + getSize().height + 1 , in.getTextBounds().width, in.getTextBounds().height));
		}
		
		if (out != null && out.getText().length() > 0) {
			int midPoint = getLocation().x  + getSize().width / 2 - (out.getTextBounds().width / 2);
			out.setBounds(new Rectangle(midPoint, getLocation().y + getSize().height + 15 , out.getTextBounds().width, out.getTextBounds().height));
		}
	}
	
	/**
	 * Draw the stub node
	 */
	public void outlineShape(Graphics graphics) {
		
		int middle = getBounds().width / 2;
		PointList polygon = new PointList();		
		polygon.addPoint(getLocation().x, getLocation().y + middle);
		polygon.addPoint(getLocation().x + middle, getLocation().y);
		polygon.addPoint(getLocation().x + middle, getLocation().y);
		polygon.addPoint(getLocation().x + getSize().width - 1, getLocation().y + middle);		
		polygon.addPoint(getLocation().x + getSize().width, getLocation().y + middle);
		polygon.addPoint(getLocation().x + middle, getLocation().y + getSize().height);		
		polygon.addPoint(getLocation().x + middle + 1, getLocation().y + getSize().height);
		polygon.addPoint(getLocation().x, getLocation().y + middle);		
		graphics.drawPolygon(polygon);
		graphics.fillPolygon(polygon);
	}
	
	/**
	 * Removes all the labels added from its parent
	 */
	public void clear() {
		super.clear();
		clear(in);
		clear(out);
	}
}