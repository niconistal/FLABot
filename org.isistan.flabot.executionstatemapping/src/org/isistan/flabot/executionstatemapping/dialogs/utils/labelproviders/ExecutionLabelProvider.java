package org.isistan.flabot.executionstatemapping.dialogs.utils.labelproviders;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.NamedElement;
import org.isistan.flabot.executionstatemapping.utils.ExecutionConditionUtils;

public class ExecutionLabelProvider extends LabelProvider
{
	private Image imageGeneralExecutionCondition;
	
	private Image imageMethodExecutionCondition;
	
	
	@Override
	public Image getImage(Object element) {
		ExecutionCondition executionCondition = (ExecutionCondition) element;
		if (executionCondition.isMethodExecutionCondition())
		{
			return getMethodExecutionConditionImage();
		}
				
		return getGeneralExecutionConditionImage();
	}

	protected Image getGeneralExecutionConditionImage()
	{
		if (imageGeneralExecutionCondition == null)
		{
			imageGeneralExecutionCondition = ImageDescriptor.createFromFile(
					ExecutionConditionPlugin.class, "icons/condition_general.gif").createImage(); //$NON-NLS-1$
		
		}
		return imageGeneralExecutionCondition;
	}
	
	protected Image getMethodExecutionConditionImage()
	{
		if (imageMethodExecutionCondition == null)
		{
			imageMethodExecutionCondition = ImageDescriptor.createFromFile(
					ExecutionConditionPlugin.class, "icons/condition_method.gif").createImage(); //$NON-NLS-1$
		
		}
		return imageMethodExecutionCondition;
	}
	
	@Override
	public String getText(Object element) 
	{
		ExecutionCondition executionCondition = (ExecutionCondition) element;
		if (executionCondition.isMethodExecutionCondition())
		{
			if (executionCondition.getPatternMapping() != null && executionCondition.getPatternMapping().getBehaviorPattern() != null)
			{
				return ((NamedElement) element).getName() + " : " + ExecutionConditionUtils.getEscapedNameFromPattern(executionCondition.getPatternMapping().getBehaviorPattern()); //$NON-NLS-1$
			}
		}
		return ((NamedElement) element).getName();
	}

	@Override
	public void dispose() 
	{
		if (imageGeneralExecutionCondition != null)
		{
			imageGeneralExecutionCondition.dispose();
		}
		if (imageMethodExecutionCondition != null)
		{
			imageMethodExecutionCondition.dispose();
		}
	}
}
