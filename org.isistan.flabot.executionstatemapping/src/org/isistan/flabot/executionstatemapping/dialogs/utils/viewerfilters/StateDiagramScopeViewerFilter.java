package org.isistan.flabot.executionstatemapping.dialogs.utils.viewerfilters;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.isistan.flabot.executionstatemapping.model.semantic.StateContainer;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeType;
import org.isistan.flabot.mapping.mappingmodel.PatternMapping;

public class StateDiagramScopeViewerFilter extends ViewerFilter 
{
	private PatternMapping[] scopePatternMapping;
	
	public StateDiagramScopeViewerFilter(PatternMapping[] scopePatternMapping)
	{
		this.scopePatternMapping = scopePatternMapping;
	}	
	
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element)
	{
		TreeStructuredElement treeElement = (TreeStructuredElement) element;
		if (treeElement.getType()== TreeType.STATE_DIAGRAM_TYPE)
		{
			return checkScope( (StateContainer) treeElement);
		}
		return true;
	}
	
	private boolean checkScope(StateContainer stateContainer)
	{
		return stateContainer.passesMapping(scopePatternMapping);
	}
}