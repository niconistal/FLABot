/**
 * $Id: ComponentDragListener.java,v 1.5 2006/03/21 01:51:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.multipage.dnd;

import java.util.List;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.editparts.AbstractTreeEditPart;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.edit.outline.ComponentTreeEditPart;

/**
 * @author $Author: franco $
 *
 */
public class ComponentDragListener extends AbstractTransferDragSourceListener {
		
	public ComponentDragListener(EditPartViewer viewer) {
		super(viewer, TextTransfer.getInstance());		
	}
	
	private boolean isValidSelection(List list) {
		if (list.size() != 1) return false;
		
		if (list.get(0) instanceof ComponentTreeEditPart)				
			return true;

		return false;		
	}
	
	public String getID(){
		List l = getViewer().getSelectedEditParts();
		ComponentModel component = (ComponentModel)((AbstractTreeEditPart)l.get(0)).getModel();
		return component.getID();
	}		

	public void dragSetData(DragSourceEvent e) {
		String id = getID();
		if (id.equals("")) id = " "; //$NON-NLS-1$ //$NON-NLS-2$
		e.data = new String(id);
	}
	
	public void dragStart(DragSourceEvent e) {
		if (isValidSelection(getViewer().getSelectedEditParts())) {
			e.data = new String("ComponentDrag"); //$NON-NLS-1$
			dragSetData(e);
			return;
		}
		e.doit = false;
	}
}