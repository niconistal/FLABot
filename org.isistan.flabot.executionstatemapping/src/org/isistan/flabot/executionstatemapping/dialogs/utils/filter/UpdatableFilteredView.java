package org.isistan.flabot.executionstatemapping.dialogs.utils.filter;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;

public interface UpdatableFilteredView 
{
	
	 void updateFilter(ViewerFilter viewFilter);
	 
	 void updateContent(ViewerComparator viewerComparator, ILabelProvider labelProvider, ITreeContentProvider contentProvider, Object input);
	 
}
