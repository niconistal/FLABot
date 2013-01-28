/**
 * $Id: InterfaceDragListener.java,v 1.2 2006/03/21 01:51:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.multipage.dnd;

import java.util.List;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.editparts.AbstractTreeEditPart;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.isistan.flabot.coremodel.InterfaceModel;
import org.isistan.flabot.edit.outline.InterfaceTreeEditPart;

/**
 * @author $Author: franco $
 *
 */
public class InterfaceDragListener extends AbstractTransferDragSourceListener {
	
	public InterfaceDragListener(EditPartViewer viewer) {
		super(viewer, TextTransfer.getInstance());
	}
	
	private boolean isValidSelection(List list) {
		if (list.size() != 1) return false;
		
		if (list.get(0) instanceof InterfaceTreeEditPart)				
			return true;

		return false;		
	}
	
	public String getID(){
		List l = getViewer().getSelectedEditParts();
		InterfaceModel inter = (InterfaceModel)((AbstractTreeEditPart)l.get(0)).getModel();
		return inter.getPort().getComponent().getID() + " " + inter.getPort().getID() + " " + inter.getID(); //$NON-NLS-1$ //$NON-NLS-2$
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