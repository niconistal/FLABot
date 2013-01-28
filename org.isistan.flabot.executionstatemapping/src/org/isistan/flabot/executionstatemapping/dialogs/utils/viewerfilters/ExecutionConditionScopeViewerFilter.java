package org.isistan.flabot.executionstatemapping.dialogs.utils.viewerfilters;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeType;
import org.isistan.flabot.mapping.mappingmodel.PatternMapping;

public class ExecutionConditionScopeViewerFilter extends ViewerFilter 
{
	private PatternMapping[] scopePatternMapping;
	
	private boolean componentScope;
	
	public ExecutionConditionScopeViewerFilter(PatternMapping[] scopePatternMapping, boolean componentScope)
	{
		this.scopePatternMapping = scopePatternMapping;
		this.componentScope = componentScope;
	}	
	
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element)
	{
		TreeStructuredElement treeElement = (TreeStructuredElement) element;
		if (treeElement.getType()== TreeType.PACKAGE_TYPE)
		{
			return checkPackageMatch(treeElement.getName());
		}
		else if (treeElement.getType()== TreeType.CLASS_TYPE)
		{
			return checkClassMatch(treeElement.getName());
		}
		else if (treeElement.getType()== TreeType.EXECUTION_CONDITION_TYPE)
		{
			ExecutionCondition generalExecutionCondition = (ExecutionCondition) treeElement;
			if (generalExecutionCondition.isMethodExecutionCondition())
			{
				return componentScope || checkMethodMatch( (generalExecutionCondition.getPatternMapping().getBehaviorPattern()));
			}
		}
		return true;
	}
	
	private boolean checkPackageMatch(String pattern)
	{
		for(PatternMapping mapping : scopePatternMapping)
		{
			if (mapping != null && mapping.getPackagePattern() != null && mapping.getPackagePattern().contains(pattern))
			{
				return true;
			}
		}			
		return false;
	}
	
	private boolean checkClassMatch(String pattern)
	{
		for(PatternMapping mapping : scopePatternMapping)
		{
			if (mapping != null && mapping.getClassPattern() != null && mapping.getClassPattern().contains(pattern))
			{
				return true;
			}
		}			
		return false;
	}
	
	private boolean checkMethodMatch(String pattern)
	{
		for(PatternMapping mapping : scopePatternMapping)
		{
			if (mapping != null && mapping.getBehaviorPattern() != null && mapping.getBehaviorPattern().contains(pattern))
			{
				return true;
			}
		}			
		return false;
	}
}