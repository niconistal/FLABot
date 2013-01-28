/**
 * $Id: ControlViewContentProvider.java,v 1.7 2006/03/21 03:18:12 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.controlview;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.isistan.flabot.executionmodel.ExecutionInfo;
import org.isistan.flabot.executionmodel.ExecutionStep;

/**
 * @author $Author: franco $
 *
 */
public class ControlViewContentProvider implements ITreeContentProvider {
	
	private static Object[] EMPTY_ARRAY = new Object[0];
	
	protected ExecutionInfo root;
	
	/*
	 * @see IContentProvider#dispose()
	 */
	public void dispose() {}

	/**
	* Notifies this content provider that the given viewer's input
	* has been switched to a different element.
	* <p>
	* A typical use for this method is registering the content provider as a listener
	* to changes on the new input (using model-specific means), and deregistering the viewer 
	* from the old input. In response to these change notifications, the content provider
	* propagates the changes to the viewer.
	* </p>
	*
	* @param viewer the viewer
	* @param oldInput the old input element, or <code>null</code> if the viewer
	*   did not previously have an input
	* @param newInput the new input element, or <code>null</code> if the viewer
	*   does not have an input
	*/
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if(newInput != null)
			root = (ExecutionInfo) newInput;
	}	

	/*
	 * @see ITreeContentProvider#getChildren(Object)
	 */
	@SuppressWarnings("deprecation") //$NON-NLS-1$
	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof ExecutionInfo) {
			return ((ExecutionInfo)parentElement).getExecutionSteps().toArray();
		}
		if(parentElement instanceof ExecutionStep) {
			ExecutionStep step = (ExecutionStep)parentElement;
			if (!step.getDependency().getType().equals("[]")) //$NON-NLS-1$
				return new Object[]{step.getSource(), step.getTarget(), step.getDependency()};
			else
				return new Object[]{step.getSource(), step.getTarget()};
		}
		return EMPTY_ARRAY;
	}
	
	/*
	 * @see ITreeContentProvider#getParent(Object)
	 */
	public Object getParent(Object element) {
		if(element instanceof ExecutionStep)
			return root;
		return null;
	}

	/*
	 * @see ITreeContentProvider#hasChildren(Object)
	 */
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

	/*
	 * @see IStructuredContentProvider#getElements(Object)
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}
}
