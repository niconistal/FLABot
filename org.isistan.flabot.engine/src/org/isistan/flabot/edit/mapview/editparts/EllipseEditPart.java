/**
 * $Id: EllipseEditPart.java,v 1.4 2006/03/29 20:21:58 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.mapview.editparts;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.widgets.Display;
import org.isistan.flabot.edit.editor.editparts.ConnectedEditPart;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.mapview.figure.EllipseFigure;

/**
 * Respresents the connections between the ellipses used in the Map View.
 * 
 * @author $Author: franco $
 *
 */
public class EllipseEditPart extends ConnectedEditPart {
	
	@Override
	protected void createEditPolicies() {
		//Do nothing
	}
	
	@Override
	protected IFigure createFigure() {		
		EllipseFigure figure = new EllipseFigure();
		VisualModel visual = (VisualModel) getModel();
		figure.setLineStyle(visual.getLineStyle());
		figure.setLineWidth(visual.getLineWidth());
		figure.setBackgroundColor(Util.getSWRColor(Display.getCurrent(), visual.getBackgroundColor()));
		figure.setForegroundColor(Util.getSWRColor(Display.getCurrent(), visual.getForegroundColor()));			
		return figure;		
	}
	
	/**
	 * Returns the connection anchor of an ellipse
	 * 
	 * @return the connection anchor of an ellipse
	 */
	@Override
	protected ConnectionAnchor getConnectionAnchor() {			
		if (anchor == null)
			anchor = new EllipseAnchor(getFigure());
		return anchor;
	}
}