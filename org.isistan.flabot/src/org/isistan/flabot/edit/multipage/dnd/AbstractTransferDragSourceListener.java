/**
 * $Id: AbstractTransferDragSourceListener.java,v 1.1 2005/11/02 21:32:44 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.multipage.dnd;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.jface.util.TransferDragSourceListener;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;

/**
 * @author $Author: franco $
 *
 */

/**
 * An abstract implementation of <code>TransferDragSourceListener</code>
 * associated with an {@link EditPartViewer}
 */
public abstract class AbstractTransferDragSourceListener
	implements TransferDragSourceListener
{

private EditPartViewer viewer;
private Transfer transfer;

/**
 * Constructs an AbstractTransferDragSourceListener for the given EditPartViewer.
 * @param viewer the EditPartViewer
 */
public AbstractTransferDragSourceListener(EditPartViewer viewer) {
	setViewer(viewer);
}

/**
 * Constructs an AbstractTransferDragSourceListener with the specified EditPartViewer and
 * Transfer.
 * @param viewer the EditPartViewer
 * @param xfer the Transfer
 */
public AbstractTransferDragSourceListener(EditPartViewer viewer, Transfer xfer) {
	setViewer(viewer);
	setTransfer(xfer);
}

/** 
 * @see org.eclipse.swt.dnd.DragSourceListener#dragFinished(DragSourceEvent)
 */
public void dragFinished(DragSourceEvent event) { }

/**
 * @see org.eclipse.swt.dnd.DragSourceListener#dragStart(DragSourceEvent)
 */
public void dragStart(DragSourceEvent event) { }

/**
 * @see TransferDragSourceListener#getTransfer()
 */
public Transfer getTransfer() {
	return transfer;
}

/**
 * Returns the <code>EditPartViewer</code>.
 * @return the EditPartViewer
 */
protected EditPartViewer getViewer() {
	return viewer;
}

/**
 * Sets the <code>Transfer</code> for this listener.
 * @param xfer the Transfer
 */
protected void setTransfer(Transfer xfer) {
	transfer = xfer;
}

/**
 * Sets the EditPartViewer for this listener.
 * @param viewer the EditPartViewer
 */
protected void setViewer(EditPartViewer viewer) {
	this.viewer = viewer;
}
}