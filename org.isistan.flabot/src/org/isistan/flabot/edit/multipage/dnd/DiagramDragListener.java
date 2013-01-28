/** * $Id: DiagramDragListener.java,v 1.8 2006/03/21 01:51:57 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.multipage.dnd;

import java.util.List;import org.eclipse.gef.EditPartViewer;import org.eclipse.gef.editparts.AbstractTreeEditPart;import org.eclipse.swt.dnd.DragSourceEvent;import org.eclipse.swt.dnd.TextTransfer;import org.isistan.flabot.edit.editormodel.Diagram;import org.isistan.flabot.edit.outline.DiagramTreeEditPart;public class DiagramDragListener extends AbstractTransferDragSourceListener {
	
	public DiagramDragListener(EditPartViewer viewer) {
		super(viewer, TextTransfer.getInstance());
	}
	
	private boolean isValidSelection(List list) {
		if (list.size() != 1) return false;
		
		if (list.get(0) instanceof DiagramTreeEditPart)				
			return true;

		return false;		
	}
	
	public String getDiagramName(){
		List l = getViewer().getSelectedEditParts();
		Diagram diagram = (Diagram)((AbstractTreeEditPart)l.get(0)).getModel();
		return diagram.getID();
	}
	
	public void dragSetData(DragSourceEvent e) {
		String id = getDiagramName();
		if (id.equals("")) id = " "; //$NON-NLS-1$ //$NON-NLS-2$
		e.data = new String(id);
	}
	
	public void dragStart(DragSourceEvent e) {
		if (isValidSelection(getViewer().getSelectedEditParts()))
			return;
		e.doit = false;
	}
}
