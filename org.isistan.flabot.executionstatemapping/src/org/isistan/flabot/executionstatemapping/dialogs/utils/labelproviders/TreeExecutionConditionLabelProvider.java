package org.isistan.flabot.executionstatemapping.dialogs.utils.labelproviders;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeType;
import org.isistan.flabot.executionstatemapping.utils.ExecutionConditionUtils;

/**
 * @author $Author: franco $
 * 
 */
public class TreeExecutionConditionLabelProvider extends LabelProvider 
{
	private Map<ImageDescriptor, Image> imageCache = new HashMap<ImageDescriptor, Image>(7);

	/*
	 * @see ILabelProvider#getImage(Object)
	 */
	@SuppressWarnings("restriction") //$NON-NLS-1$
	@Override
	public Image getImage(Object element) 
	{
		ImageDescriptor descriptor = null;
		TreeType type = ((TreeStructuredElement)element).getType();
		if (type == TreeType.EXECUTION_CONDITION_TYPE)
		{
			descriptor = ImageDescriptor.createFromFile(ExecutionConditionPlugin.class, "icons/condition_method.gif"); //$NON-NLS-1$
		}
		else if (type == TreeType.CLASS_TYPE)
		{
			descriptor = JavaPluginImages.DESC_OBJS_CLASS;
		}
		else if (type == TreeType.PACKAGE_TYPE)
		{
			descriptor = JavaPluginImages.DESC_OBJS_PACKAGE;
		}
		else if (type == TreeType.PACKAGE_ROOT_TYPE)
		{
			descriptor = JavaPluginImages.DESC_OBJS_PACKFRAG_ROOT;
		}
		else if (type == TreeType.PROJECT_TYPE)
		{
			descriptor = JavaPluginImages.DESC_OBJS_LOGICAL_PACKAGE;
		}
		else if (type == TreeType.CONTAINER_TYPE)
		{
			descriptor = ImageDescriptor.createFromFile(ExecutionConditionPlugin.class, "icons/folder.gif"); //$NON-NLS-1$
		}
		else if (type == TreeType.FOLDER_GENERAL_EXECUTION_CONDITION_TYPE
				|| type == TreeType.FOLDER_STATE_DIAGRAM_TYPE)
		{
			descriptor = ImageDescriptor.createFromFile(ExecutionConditionPlugin.class, "icons/folder.gif"); //$NON-NLS-1$
		}
		else if (type == TreeType.STATE_DIAGRAM_TYPE)
		{
			descriptor = ImageDescriptor.createFromFile(ExecutionConditionPlugin.class, "icons/stateeditor.gif"); //$NON-NLS-1$
		}
		
		// obtain the cached image corresponding to the descriptor
		Image image = imageCache.get(descriptor);
		if (image == null && descriptor != null) 
		{			
			image = descriptor.createImage();
			imageCache.put(descriptor, image);
		}
		return image;
	}

	/*
	 * @see ILabelProvider#getText(Object)
	 */
	@Override
	public String getText(Object element) 
	{		
		TreeStructuredElement treeElement = (TreeStructuredElement) element;
		String name = treeElement.getName();
		if (treeElement.getType() == TreeType.EXECUTION_CONDITION_TYPE)
		{
			if ( ((ExecutionCondition)treeElement).isMethodExecutionCondition() )
			{
				ExecutionCondition methodExecutionCondition = (ExecutionCondition) treeElement;
				if (methodExecutionCondition.getPatternMapping() != null)
				{
					String methodName = ExecutionConditionUtils.getEscapedNameFromPattern(methodExecutionCondition.getPatternMapping().getBehaviorPattern());
					int index = methodName.indexOf("#"); //$NON-NLS-1$
					if (index >= 0)
					{
						methodName = methodName.substring(index+1, methodName.length());
					}
					name += " : " + methodName; 					 //$NON-NLS-1$
				}
			}
		}
		else if (treeElement.getType() == TreeType.CLASS_TYPE)
		{
			name = ExecutionConditionUtils.getClassNameFromPattern(name);
		}
		else if (treeElement.getType() == TreeType.PACKAGE_TYPE)
		{
			name = ExecutionConditionUtils.getEscapedNameFromPattern(name);
		}			
		return name;
	}
	
	@Override
	public void dispose() 
	{
		for (Iterator<Image> i = imageCache.values().iterator(); i.hasNext();) 
		{
			i.next().dispose();
		}
		imageCache.clear();
	}
}