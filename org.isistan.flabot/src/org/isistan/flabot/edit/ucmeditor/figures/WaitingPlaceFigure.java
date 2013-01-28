package org.isistan.flabot.edit.ucmeditor.figures;

import java.util.Iterator;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;

/**
 * 
 * @author $Author: Martin Villalba $
 *
 */
public class WaitingPlaceFigure extends ThreeConnectionFigure{// extends PathPointFigure{
	
	public static final String LEFT = "Left"; //$NON-NLS-1$
	public static final String RIGHT = "Right"; //$NON-NLS-1$
	public static final String UP = "Up"; //$NON-NLS-1$
	public static final String DOWN = "Down"; //$NON-NLS-1$
	
	/**
	 * Instantiates an instance of OrForkFigure
	 * 
	 * @param roration the fork rotation
	 * @param fC the foreground color of the fork
	 */
	public WaitingPlaceFigure(String rotation, IFigure parent, RGB fC) {		
		//super(fc);
		super(rotation, fC,parent);
		setLocalParent(parent);
		setOpaque(true);
	}

	/**
	 * Draw the Waiting Place
	 */
	public void paintFigure(Graphics g) {		
		Rectangle r = getBounds().getCopy();
		r.translate(0, 0);
		r.setSize(15,15);
		g.drawOval(r);
		
		g.setBackgroundColor(getDisplay().getSystemColor(SWT.COLOR_BLUE));
		g.fillOval(r);	
	}
	
	public static Display getDisplay() {
	      Display display = Display.getCurrent();
	      //may be null if outside the UI thread
	      if (display == null)
	         display = Display.getDefault();
	      return display;		
	   }
	
	protected String rotation = RIGHT;

	/**
	 * Sets the rotation of the figure and updated the size
	 * 
	 * @param r the new rotation
	 */
	@Override
	public void setRotation(String r) {
		if (r.equals("")) //$NON-NLS-1$
			this.rotation = RIGHT;
		else
			this.rotation = r;
		
		if (rotation.equals(LEFT))		
			setSize(20,20);			
		else if (rotation.equals(RIGHT))
			setSize(20,20);
		else if (rotation.equals(UP))
			setSize(20,20);
		else if (rotation.equals(DOWN))
			setSize(20,20);
	}
}
