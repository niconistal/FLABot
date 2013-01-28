package org.isistan.flabot.edit.editor.dialogs.consistency;

import java.util.List;

import org.eclipse.jface.viewers.Viewer;
//import org.eclipse.pde.internal.runtime.logview.LogEntry;
//import org.eclipse.pde.internal.runtime.logview.LogViewContentProvider;
import org.eclipse.ui.internal.views.log.LogEntry;
import org.eclipse.ui.internal.views.log.LogViewContentProvider;

public class ConsistencyContentProvider extends LogViewContentProvider {
	
	private List<LogEntry> rootLogList;

	public ConsistencyContentProvider(List<LogEntry> rootLogList) {
		super(null);
		this.rootLogList = rootLogList;
	}
	
	public void dispose() {
	}
	
	public Object[] getChildren(Object element) {
		return ((LogEntry) element).getChildren(element);
	}
	
	public Object[] getElements(Object element) {
		return rootLogList.toArray();
	}
	
	public Object getParent(Object element) {
		return ((LogEntry) element).getParent(element);
	}
	
	public boolean hasChildren(Object element) {
		return ((LogEntry) element).hasChildren();
	}
	
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}
	
	public boolean isDeleted(Object element) {
		return false;
	}
}