package org.isistan.flabot.executionstatemapping.dialogs.utils.labelproviders;

import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.swt.graphics.Image;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.utils.ExecutionConditionUtils;

public class InternalMethodCallsLabelProvider extends ExecutionLabelProvider {	
	
	@SuppressWarnings("restriction") //$NON-NLS-1$
	@Override
	public Image getImage(Object element) 
	{
		ExecutionCondition generalExecutionCondition = (ExecutionCondition) element;
		if (generalExecutionCondition.isMethodExecutionCondition())
		{
			IMethod imethod = ExecutionConditionUtils.getIMethod(generalExecutionCondition);
			if (imethod != null)
			{
				return DecoratedWorkbenchLabelProvider.getDecoratedWorkbenchLabelProvider().getImage(imethod);
			}
		}
		return JavaPluginImages.get(JavaPluginImages.IMG_MISC_PUBLIC);
	}
}
