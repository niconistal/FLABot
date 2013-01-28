package org.isistan.flabot.executionstatemapping.dialogs.utils.contentproviders;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeType;

/**
 * @author $Author: franco $
 * 
 */
public class TreeExecutionConditionContentProvider implements ITreeContentProvider 
{
	/*
	 * @see IContentProvider#dispose()
	 */
	public void dispose() 
	{
	}
	
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) 
	{
	}

	/*
	 * @see ITreeContentProvider#getChildren(Object)
	 */
	@SuppressWarnings("deprecation") //$NON-NLS-1$
	public Object[] getChildren(Object parentElement) 
	{					
		if (parentElement instanceof TreeStructuredElement[])
		{
			return (TreeStructuredElement[]) parentElement;
		}
		else
		{		
			TreeStructuredElement treeElement = ((TreeStructuredElement) parentElement);
			if (treeElement.getType() == TreeType.FOLDER_GENERAL_EXECUTION_CONDITION_TYPE
					|| treeElement.getType() == TreeType.FOLDER_STATE_DIAGRAM_TYPE)
			{
				return treeElement.getPersistentList().toArray();
			}		
			return treeElement.uGetTreeStructuredElements().toArray();
		}
	}
	
	/*
	 * @see ITreeContentProvider#getParent(Object)
	 */
	public Object getParent(Object element) 
	{
		return ((TreeStructuredElement) element).getParent();
	}

	/*
	 * @see ITreeContentProvider#hasChildren(Object)
	 */
	public boolean hasChildren(Object element) 
	{
		return getChildren(element).length > 0;
	}

	/*
	 * @see IStructuredContentProvider#getElements(Object)
	 */
	public Object[] getElements(Object inputElement) 
	{
		return getChildren(inputElement);
	}
}
