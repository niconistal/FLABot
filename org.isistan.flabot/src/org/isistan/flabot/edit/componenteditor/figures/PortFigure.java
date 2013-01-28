/**
 * $Id: PortFigure.java,v 1.7 2006/04/01 02:44:50 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.handles.HandleBounds;

/**
 * PortFigure
 * -	The figure used for ports
 * 
 *  @author $Author: franco $
 */
public class PortFigure extends Figure 
	implements HandleBounds
{
	public static final Dimension defaultsize = new Dimension(40,25);
	public static final String LEFT_SIDE = "Left.Side"; //$NON-NLS-1$
	public static final String RIGHT_SIDE = "Right.Side"; //$NON-NLS-1$

	private String side = LEFT_SIDE;
	
	private boolean validClick = false;

	/**
	 * Instantiates an instance of PortFigure
	 */
	public PortFigure() {
		addMouseListener( new MouseListener.Stub() {
			/**
			 * MouseListener interface
			 */
			public void mousePressed(MouseEvent me) {
				validClick = getHandleBounds().contains(me.getLocation());
			}
		});

		setLayoutManager(new FreeformLayout());	
		setBackgroundColor(ColorConstants.listBackground);
		setOpaque(true);
	}
	
	public boolean wasValidClick() {
		return validClick;
	}
	
	/**
	 * Set the side of the port figure in the component
	 * @param side the side of the port figure
	 */
	public void setSide(String side) {
		this.side = side; 
	}

	/**
	 * @return the side of the port figure in the component
	 */
	public String getSide() {
		return side; 
	}
	
	/**
	 * HandleBounds interface
	 * @return the handle bounds of the component
	 */
	public Rectangle getHandleBounds() {
		if (side == LEFT_SIDE) {
			return getBounds().getCropped(new Insets(0,30,0,0));
		} else if (side == RIGHT_SIDE) {
			return getBounds().getCropped(new Insets(0,0,0,30));
		}	
		return getBounds().getCropped(new Insets(0,0,0,0));
	}

	/**
	 * Returns the preferred size for this port figure.
	 * @return the preferred size
	 */
	public Dimension getPreferredSize(int w, int h) {
		Dimension prefSize = super.getPreferredSize(w, h);
		Dimension defaultSize = new Dimension(200,200);
		prefSize.union(defaultSize);
		return prefSize;
	}

	/**
	 * Draw the port figure.
	 */
	protected void paintFigure(Graphics graphics) {
		graphics.setForegroundColor(ColorConstants.black);
		graphics.setBackgroundColor(ColorConstants.black);
		graphics.drawRectangle(getHandleBounds());
		graphics.fillRectangle(getHandleBounds());
	}

	public void validate() {
		if(isValid()) return;
		super.validate();
	}

	/**
	 * Port figure uses local coordinates, this means its
	 * children are placed relative to this Figure's top-left corner.
	 * @return <code>true</code> if this Figure uses local coordinates
	 */
	protected boolean useLocalCoordinates(){return true;}
}