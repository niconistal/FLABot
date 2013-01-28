package org.isistan.flabot.executionstatemapping.dialogs.utils;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.views.navigator.ResourceComparator;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;
import org.isistan.flabot.executionstatemapping.dialogs.utils.filter.FilteredElementTreeSelectionDialog;
import org.isistan.flabot.executionstatemapping.dialogs.utils.filter.UpdatableFilteredView;
import org.isistan.flabot.executionstatemapping.dialogs.utils.filter.ViewFilterProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.filter.ViewFilterProviderAdapter;
import org.isistan.flabot.executionstatemapping.dialogs.utils.labelproviders.DecoratedWorkbenchLabelProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.viewerfilters.ClassViewerFilter;
import org.isistan.flabot.executionstatemapping.messages.Messages;

public class DialogUtils {
	
	private static final Status STATUS_OK = new Status(IStatus.OK,
			ExecutionConditionPlugin.PLUGIN_ID, IStatus.OK, "", null); //$NON-NLS-1$

	private static final Status STATUS_ERROR = new Status(IStatus.ERROR,
			ExecutionConditionPlugin.PLUGIN_ID, IStatus.ERROR,
			Messages.getString("org.isistan.flabot.executionmapping.dialogs.utils.DialogUtils.mustSelectClass"), null); //$NON-NLS-1$
	
	public static IType showSelectClassFromWorkspaceDialog()
	{
		
		ViewFilterProvider[] viewFilterProviders = new ViewFilterProvider[1];		
		viewFilterProviders[0] = new ViewFilterProviderAdapter()
		{			
			@Override
			public String getTextName()
			{
				return Messages.getString("org.isistan.flabot.executionmapping.dialogs.utils.DialogUtils.classFilter"); //$NON-NLS-1$
			}
			
			@Override
			public void filterChanged(final UpdatableFilteredView updatableView)
			{
				BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
					public void run() 
					{					
						updatableView.updateFilter(new ClassViewerFilter());
					}
				});			
			}
		};
		
		return (IType) DialogUtils.getSelectedTreeElement(Messages.getString("org.isistan.flabot.executionmapping.dialogs.utils.DialogUtils.classSelection"), Messages.getString("org.isistan.flabot.executionmapping.dialogs.utils.DialogUtils.selectClass"),  //$NON-NLS-1$ //$NON-NLS-2$
				new DecoratedWorkbenchLabelProvider(), 
				new WorkbenchContentProvider(), JavaCore.create(ResourcesPlugin.getWorkspace().getRoot()), 
				new ISelectionStatusValidator() {
					public IStatus validate(Object[] selection) {
						try
						{
						if (selection != null && selection.length == 1) {
							if (((IJavaElement)selection[0]).getElementType() == IJavaElement.TYPE && (((IType)selection[0])).isClass())
								return STATUS_OK;
	
						}
						} catch(JavaModelException e)
						{							
						}
						return STATUS_ERROR;
					}
			}, 
			viewFilterProviders, new ResourceComparator(ResourceComparator.NAME));
	}

	@SuppressWarnings("unchecked") //$NON-NLS-1$
	public static <T> T getSelectedListElement(String title, String message, ILabelProvider labelProvider ,T[] elements)
	{
		T selection = null;
		try
		{
			Shell shell = Display.getCurrent().getActiveShell();			
			
			ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, labelProvider);
			dialog.setElements(elements);
			dialog.setTitle(title);
			dialog.setMessage(message);
			dialog.setHelpAvailable(false);
			dialog.setMultipleSelection(false);

			if (dialog.open() == Window.OK)
			{
				Object[] result = dialog.getResult();
				if (result.length == 1)
				{
					selection = (T) result[0];
				}
			}

		} catch (Exception e)
		{
			ExecutionConditionPlugin
					.getDefault()
					.getLogger()
					.error(
							"Error en seleccion de metodos para la vista ExecutionCondition", //$NON-NLS-1$
							e);
		}
		return selection;
	}
	
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	public static <T> T getSelectedTreeElement(String title, String message, ILabelProvider labelProvider , ITreeContentProvider treeContentProvider, T input, ISelectionStatusValidator validator, ViewFilterProvider[] viewFilterProviders, ViewerComparator comparator)
	{
		T selection = null;
		try
		{
			Shell shell = Display.getCurrent().getActiveShell();			
			
			FilteredElementTreeSelectionDialog dialog = new FilteredElementTreeSelectionDialog(shell, labelProvider, treeContentProvider);
			dialog.setInput(input);
			dialog.setTitle(title);
			dialog.setMessage(message);
			dialog.setHelpAvailable(false);
			dialog.setValidator(validator);
			if (comparator != null)
			{			
				dialog.setComparator(comparator);
			}
			if (viewFilterProviders != null)
			{
				dialog.setFilterItems(viewFilterProviders);
			}
			
			if (dialog.open() == Window.OK)
			{
				Object[] result = dialog.getResult();
				if (result.length == 1)
				{
					selection = (T) result[0];
				}
			}

		} catch (Exception e)
		{
			ExecutionConditionPlugin
					.getDefault()
					.getLogger()
					.error(
							"Error en seleccion de metodos para la vista ExecutionCondition", //$NON-NLS-1$
							e);
		}
		return selection;
	}
	
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	public static <T> T getSelectedTreeElement(String title, String message, ILabelProvider labelProvider , ITreeContentProvider treeContentProvider, T[] input, ISelectionStatusValidator validator, ViewFilterProvider[] viewFilterProviders, ViewerComparator comparator)
	{
		T selection = null;
		try
		{
			Shell shell = Display.getCurrent().getActiveShell();			
			
			FilteredElementTreeSelectionDialog dialog = new FilteredElementTreeSelectionDialog(shell, labelProvider, treeContentProvider);
			dialog.setInput(input);
			dialog.setTitle(title);
			dialog.setMessage(message);
			dialog.setHelpAvailable(false);
			dialog.setValidator(validator);
			if (comparator != null)
			{			
				dialog.setComparator(comparator);
			}
			if (viewFilterProviders != null)
			{
				dialog.setFilterItems(viewFilterProviders);
			}
			
			if (dialog.open() == Window.OK)
			{
				Object[] result = dialog.getResult();
				if (result.length == 1)
				{
					selection = (T) result[0];
				}
			}

		} catch (Exception e)
		{
			ExecutionConditionPlugin
					.getDefault()
					.getLogger()
					.error(
							"Error en seleccion de metodos para la vista ExecutionCondition", //$NON-NLS-1$
							e);
		}
		return selection;
	}
}