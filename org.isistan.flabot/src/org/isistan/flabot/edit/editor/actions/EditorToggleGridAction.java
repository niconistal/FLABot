/**
 * $Id: EditorToggleGridAction.java,v 1.6 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.actions;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class EditorToggleGridAction extends Action {
	
	private GraphicalViewer diagramViewer;
	
	public EditorToggleGridAction(GraphicalViewer diagramViewer) {
		setText(Messages.getString("org.isistan.flabot.edit.editor.actions.EditorToggleGridAction.text")); //$NON-NLS-1$
		this.diagramViewer = diagramViewer;
		setToolTipText(Messages.getString("org.isistan.flabot.edit.editor.actions.EditorToggleGridAction.toolTipText")); //$NON-NLS-1$
		setId(GEFActionConstants.TOGGLE_GRID_VISIBILITY);
		setImageDescriptor(ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/grid.gif")); //$NON-NLS-1$
		setChecked((Boolean)diagramViewer.getProperty(SnapToGrid.PROPERTY_GRID_ENABLED));		
	}
	
	public void run() {
		boolean val = (Boolean)diagramViewer.getProperty(SnapToGrid.PROPERTY_GRID_ENABLED);
		setChecked(!val);
		diagramViewer.setProperty(SnapToGrid.PROPERTY_GRID_VISIBLE, new Boolean(!val));
		diagramViewer.setProperty(SnapToGrid.PROPERTY_GRID_ENABLED, new Boolean(!val));
	}
}