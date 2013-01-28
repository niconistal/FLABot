/**
 * $Id: WorkspaceViewer.java,v 1.5 2006/03/16 02:55:26 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.mapping.editor;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * @author $Author: dacostae $
 *
 */
public class WorkspaceViewer extends TreeViewer {

	private WorkspaceViewerContentProvider contentProvider;
	
	private WorkspaceViewerLabelProvider labelProvider;

	public WorkspaceViewer(Composite parent, WorkspaceViewerContentProvider contentProvider, boolean showPackageNames) {
		super(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		this.contentProvider=contentProvider;
		labelProvider = new WorkspaceViewerLabelProvider(
				JavaElementLabelProvider.SHOW_PARAMETERS | JavaElementLabelProvider.SHOW_OVERLAY_ICONS | JavaElementLabelProvider.SHOW_RETURN_TYPE
				| (showPackageNames? JavaElementLabelProvider.SHOW_QUALIFIED: 0));
		this.setLabelProvider(labelProvider);
		this.setContentProvider(contentProvider);
		
		this.setSorter(new ViewerSorter() {
			 @Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				 return labelProvider.getText(e1).compareTo(labelProvider.getText(e2));
			 }
		});
		
	}
	
	public void setDefaultContentInput() {
		this.setContentInput(JavaCore.create(ResourcesPlugin.getWorkspace().getRoot()));
	}
	
	public void setContentInput(Object input) {
		super.setInput(input);
		this.expandToLevel(1);

	}
	
	public Object[] getSelectedElements(SelectionFilter leafFilter) {
		StructuredSelection selection=(StructuredSelection)this.getSelection();
		Object[] elements=selection.toArray();
		
		List<Object> mappeableElements=new LinkedList<Object>();
		for (Object element : elements) {
			if(element!=null) {
				addLeafElements(element, leafFilter, element, mappeableElements);
			}
		}
		return mappeableElements.toArray(new Object[mappeableElements.size()]);
	}


	private void addLeafElements(Object primaryElement, SelectionFilter leafFilter, Object parent, List<Object> mappeableElements) {
		if(leafFilter.isSelectable(primaryElement, parent)) {
			mappeableElements.add(parent);
		}
		if(leafFilter.propagatesSelection(primaryElement, parent)) {
			Object[] children=contentProvider.getChildren(parent);
			for (Object child : children) {
				addLeafElements(primaryElement, leafFilter, child, mappeableElements);
			}
		}
	}
	
	public interface SelectionFilter {
		public boolean isSelectable(Object primaryElement, Object element);
		public boolean propagatesSelection(Object primaryElement, Object element);
	}
}