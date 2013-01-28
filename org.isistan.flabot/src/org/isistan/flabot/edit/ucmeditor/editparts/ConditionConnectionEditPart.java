/**
 * $Id: ConditionConnectionEditPart.java,v 1.1 2006/03/09 21:37:25 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.editparts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.edit.editor.editparts.ConnectionEditPart;
import org.isistan.flabot.edit.editor.figures.BendpointLocator;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;

/**
 * This edit part is used in the Map View to show the responsibilities nodes with an ellipse around it.
 * 
 * @author $Author: franco $
 *
 */
public class ConditionConnectionEditPart extends ConnectionEditPart {
	
	private static final Font DEFAULT_FONT = new Font(Display.getCurrent(), "Verdana", 7 , SWT.NONE);	 //$NON-NLS-1$
	
	private Label name = new Label();
	
	public ConditionConnectionEditPart() {
		name.setFont(DEFAULT_FONT);
	}
	
	/**
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		int type = notification.getEventType();
		int featureId = notification.getFeatureID(CoremodelPackage.class);
		switch(featureId) {
			case CoremodelPackage.CONDITION__NAME:
				switch(type) {
					case Notification.SET:
						updateName((PolylineConnection) getFigure());
						refreshBendpoints(getConnectionFigure());
				}
				break;
		}
	}	
	
	protected Condition getSemanticModel() {
		return (Condition) getCastedModel().getSemanticModel();
	}
	
	@Override
	protected IFigure createFigure() {
		PolylineConnection connection = (PolylineConnection) new PolylineConnection();
		VisualModel visual = (VisualModel) getModel();
		connection.setLineStyle(visual.getLineStyle());
		connection.setLineWidth(visual.getLineWidth());
		connection.setBackgroundColor(Util.getSWRColor(Display.getCurrent(), visual.getBackgroundColor()));
		connection.setForegroundColor(Util.getSWRColor(Display.getCurrent(), visual.getForegroundColor()));
		connection.setOpaque(false);
				
		PolylineDecoration targetDecoration=new PolylineDecoration();
		targetDecoration.setLineWidth(visual.getLineWidth());
		connection.setTargetDecoration(targetDecoration);	
		
		updateName(connection);
		return connection;		
	}	
	
	private void updateName(PolylineConnection connection) {
		// workaround for bug 0000613: an empty label is never added to the connection
		Condition condition = getSemanticModel();
		name.setForegroundColor(ColorConstants.black);
		if (condition != null) {
			name.setText(condition.getName());
			if (name.getParent() == null)
				connection.add(name, new BendpointLocator(connection));
		} else {
			if (name.getParent() != null)
				connection.remove(name);
		}		
	}
}
