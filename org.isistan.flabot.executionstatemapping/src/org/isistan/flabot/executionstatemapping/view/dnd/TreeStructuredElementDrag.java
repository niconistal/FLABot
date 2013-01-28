package org.isistan.flabot.executionstatemapping.view.dnd;

import org.eclipse.jface.util.TransferDragSourceListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeType;

public class TreeStructuredElementDrag implements TransferDragSourceListener {
	
	private Viewer viewer;
	
	private Transfer transfer;
	
	public TreeStructuredElementDrag(Viewer viewer) {
		this.viewer = viewer;
		this.transfer = TextTransfer.getInstance();
	}
	
	/**
	 * @see TransferDragSourceListener#getTransfer()
	 */
	public Transfer getTransfer() {
		return transfer;
	}
	
	/** 
	 * @see org.eclipse.swt.dnd.DragSourceListener#dragFinished(DragSourceEvent)
	 */
	public void dragFinished(DragSourceEvent event) { }
	
	public void dragSetData(DragSourceEvent e) {
		e.data = " "; //$NON-NLS-1$
	}
	
	private boolean isValidSelection()
	{
		ISelection selection = viewer.getSelection();
		if (selection != null && selection instanceof StructuredSelection)
		{
			Object object = ((StructuredSelection) selection).getFirstElement();
			if (object instanceof TreeStructuredElement)
			{
				TreeStructuredElement treeElement = (TreeStructuredElement) object;
				boolean valid = false;
				if ( treeElement.getParent() != null &&
					( treeElement.getType() == TreeType.FOLDER_STATE_DIAGRAM_TYPE ||
					  treeElement.getType() == TreeType.FOLDER_GENERAL_EXECUTION_CONDITION_TYPE ||
					  treeElement.getType() == TreeType.STATE_DIAGRAM_TYPE ||
					 (treeElement.getType() == TreeType.EXECUTION_CONDITION_TYPE && !((ExecutionCondition)treeElement).isMethodExecutionCondition())))
				{
					DragTransfer.setTreeStructuredElement(treeElement);
					valid = true;
				}
				else
				{
					DragTransfer.setTreeStructuredElement(null);
				}
				return valid;	
			}
		}
		return false;
	}
	
	public void dragStart(DragSourceEvent e) {
		if (!isValidSelection())
		{
			e.doit = false;
		}
	}
}

class DragTransfer
{
	private static TreeStructuredElement treeStructuredElement;
	
	public static void setTreeStructuredElement(TreeStructuredElement treeStructured)
	{
		treeStructuredElement = treeStructured;
	}
	
	public static TreeStructuredElement getTreeStructuredElement()
	{
		return treeStructuredElement;
	}
}