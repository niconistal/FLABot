/**
 * $Id: PathCreationTool.java,v 1.1 2005/11/15 21:43:43 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.tools.CreationTool;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.swt.events.MouseEvent;

/**
 * @author $Author: franco $
 *
 */
public class PathCreationTool extends CreationTool {
		
	/**
	 * Called when a mouse double-click occurs.  When the user is creating a path,
	 * the last node is deselected and can start a new path.
	 * @param button which button was double-clicked
	 * @return <code>true</code> if the event was handled
	 * @see #mouseDoubleClick(MouseEvent, EditPartViewer)
	 */
	protected boolean handleDoubleClick(int button) {
		getCurrentViewer().deselectAll();
		deactivate();
		setState(STATE_TERMINAL);
		PaletteViewer pallete = getDomain().getPaletteViewer();
		pallete.setActiveTool(pallete.getPaletteRoot().getDefaultEntry());
		return true;		
	}
}