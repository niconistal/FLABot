package org.isistan.flabot.executionstatemapping.utils.jdt;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;

public class InternalMethodCallsSearcher extends SearchRequestor {

	private List<IMethod> internalMethodCalls = new ArrayList<IMethod>();	
	
	@Override
	public void acceptSearchMatch(SearchMatch match) throws CoreException
	{
		internalMethodCalls.add((IMethod) match.getElement());		
	}

	public IMethod[] getResult()
	{
		IMethod[] methods = new IMethod[internalMethodCalls.size()];
		internalMethodCalls.toArray(methods);
		return methods;
	}
	
	public void search(final IMethod imethod)
	{		
		//Creates a monitor to search the method's internal method calls
		IRunnableWithProgress process = new IRunnableWithProgress()
		{
			public void run(IProgressMonitor monitor)
			{
				try
				{
					SearchEngine searchEngine = new SearchEngine();
					searchEngine.searchDeclarationsOfSentMessages(imethod, InternalMethodCallsSearcher.this, monitor);
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