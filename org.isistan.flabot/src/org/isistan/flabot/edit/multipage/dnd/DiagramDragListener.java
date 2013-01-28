/**

import java.util.List;
	
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