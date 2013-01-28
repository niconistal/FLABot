package org.isistan.flabot.executionstatemapping.utils.jdt;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;

public class BinaryClassSearchRequestor extends SearchRequestor
{
	protected IType javaElement = null;
	
	public IType getFoundJavaElemet()
	{
		return javaElement;
	}
	
	@Override
	public void acceptSearchMatch(SearchMatch match) throws CoreException
	{
		javaElement = (IType) match.getElement();		
	}

	public void search(final String className)
	{
		//Creates a monitor to search the method's internal method calls
		IRunnableWithProgress process = new IRunnableWithProgress()
		{
			public void run(IProgressMonitor monitor)
			{
				try
				{
					SearchPattern pattern = SearchPattern.createPattern(className,
							IJavaSearchConstants.CLASS_AND_INTERFACE,
							IJavaSearchConstants.DECLARATIONS,
							SearchPattern.R_PATTERN_MATCH);
					IJavaSearchScope scope = SearchEngine.createWorkspaceScope();
		
					SearchEngine searchEngine = new SearchEngine();
					searchEngine.search(pattern, new SearchParticipant[]
					{ SearchEngine.getDefaultSearchParticipant() }, scope, BinaryClassSearchRequestor.this, monitor);
		
				}
				catch (CoreException e)
				{			
				}
				catch (OperationCanceledException e)
				{			
				}
			}
		};
		
		//Shows a progress monitor while searching
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
		try
		{
			dialog.run(true, true, process);
		}
		catch(InvocationTargetException e)
		{
			ExecutionConditionPlugin.getDefault().getLogger().error(
					e.getMessage() + e.getStackTrace());
		}
		catch(InterruptedException e)
		{
			ExecutionConditionPlugin.getDefault().getLogger().error(
					e.getMessage() + e.getStackTrace());
		}		
	}
}