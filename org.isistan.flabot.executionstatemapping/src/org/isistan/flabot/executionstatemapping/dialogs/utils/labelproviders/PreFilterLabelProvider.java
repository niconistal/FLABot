package org.isistan.flabot.executionstatemapping.dialogs.utils.labelproviders;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;

public class PreFilterLabelProvider extends ExecutionLabelProvider
{
	private Image image;

	@Override
	public Image getImage(Object element) {
		if (image == null)
		{
			image = ImageDescriptor.createFromFile(
					ExecutionConditionPlugin.class, "icons/prefilter.gif").createImage(); //$NON-NLS-1$
		}
		return image;
	}
	
	@Override
	public void dispose() 
	{
		if (image != null)
		{
			image.dispose();
		}
	}
}