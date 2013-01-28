/**
 * $Id: PortDragListener.java,v 1.3 2006/03/21 01:51:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.multipage.dnd;

import java.util.List;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.editparts.AbstractTreeEditPart;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.isistan.flabot.coremodel.PortModel;
import org.isistan.flabot.edit.outline.PortTreeEditPart;

/**
 * @author $Author: franco $
 *
 */
public class PortDragListener extends AbstractTransferDragSourceListener {
	
	public PortDragListener(EditPartViewer viewer) {
		super(viewer, TextTransfer.getInstance());
	}
	
	private boolean isValidSelection(List list) {
		if (list.size() != 1) return false;
		
		if (list.get(0) instanceof PortTreeEditPart)				
			return true;

		return false;		
	}
	
	public String getID(){
		List l = getViewer().getSelectedEditParts();
		PortModel port = (PortModel)((AbstractTreeEditPart)l.get(0)).getModel();
		return port.getComponent().getID() + " " + port.getID(); //$NON-NLS-1$
	}
	
	public void dragSetData(DragSourceEvent e) {
		String id = getID();
		if (id.equals("")) id = " "; //$NON-NLS-1$ //$NON-NLS-2$
		e.data = new String(id);
	}
	
	public void dragStart(DragSourceEvent e) {
		if (isValidSelection(getViewer().getSelectedEditParts()))
			return;
		e.doit = false;
	}
}