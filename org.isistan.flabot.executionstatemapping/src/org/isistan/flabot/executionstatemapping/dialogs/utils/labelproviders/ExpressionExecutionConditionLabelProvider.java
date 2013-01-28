package org.isistan.flabot.executionstatemapping.dialogs.utils.labelproviders;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;
import org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition;

public class ExpressionExecutionConditionLabelProvider extends LabelProvider
{
	private Image imageEventExecutionCondition;
	
	@Override
	public Image getImage(Object element) 
	{			
		return getEventExecutionConditionImage();
	}

	protected Image getEventExecutionConditionImage()
	{
		if (imageEventExecutionCondition == null)
		{
			imageEventExecutionCondition = ImageDescriptor.createFromFile(
					ExecutionConditionPlugin.class, "icons/condition_general.gif").createImage(); //$NON-NLS-1$
		
		}
		return imageEventExecutionCondition;
	}	
	
	@Override
	public String getText(Object element) 
	{		
		SimpleExpressionExecutionCondition simpleExpression = ((SimpleExpressionExecutionCondition) element);		
		return simpleExpression.getName() + " : " + simpleExpression.getExecutionState().getInternacionalizedName(); //$NON-NLS-1$
	}

	@Override
	public void dispose() 
	{
		if (imageEventExecutionCondition != null)
		{
			imageEventExecutionCondition.dispose();
		}
	}
}
