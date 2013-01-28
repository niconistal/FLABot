/**
 * $Id: EditorSnapGeometryAction.java,v 1.6 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.actions;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.Action;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class EditorSnapGeometryAction extends Action {
	
	private GraphicalViewer diagramViewer;
	
	public EditorSnapGeometryAction(GraphicalViewer diagramViewer) {
		super(Messages.getString("org.isistan.flabot.edit.editor.actions.EditorSnapGeometryAction.text"), AS_CHECK_BOX); //$NON-NLS-1$
		this.diagramViewer = diagramViewer;
		setToolTipText(Messages.getString("org.isistan.flabot.edit.editor.actions.EditorSnapGeometryAction.toolTipText")); //$NON-NLS-1$
		setId(GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY);
		setChecked((Boolean)diagramViewer.getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED));
	}

	public void run() {
		Boolean val = (Boolean)diagramViewer.getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED);
		setChecked(!val);
		diagramViewer.setProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED, 
				new Boolean(!val));
	}
}