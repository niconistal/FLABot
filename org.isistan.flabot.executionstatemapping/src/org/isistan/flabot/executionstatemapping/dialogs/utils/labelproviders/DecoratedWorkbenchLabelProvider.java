package org.isistan.flabot.executionstatemapping.dialogs.utils.labelproviders;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;

public class DecoratedWorkbenchLabelProvider extends WorkbenchLabelProvider
{

	private static DecoratedWorkbenchLabelProvider decoratedWorkbenchLabelProvider;

	public static DecoratedWorkbenchLabelProvider getDecoratedWorkbenchLabelProvider()
	{
		if (decoratedWorkbenchLabelProvider == null)
			decoratedWorkbenchLabelProvider = new DecoratedWorkbenchLabelProvider();

		return decoratedWorkbenchLabelProvider;
	}

	@Override
	protected String decorateText(String input, Object element)
	{
		if (((IJavaElement) element).getElementType() == IJavaElement.METHOD)
		{
			try
			{
				return input
						+ " : " //$NON-NLS-1$
						+ Signature.toString(((IMethod) element)
								.getReturnType());
			} catch (JavaModelException e)
			{
				ExecutionConditionPlugin.getDefault().getLogger().error(
						"Error en DecoratedWorkbenchLabelProvider", e); //$NON-NLS-1$
			}
		}
		return input;
	}

}
