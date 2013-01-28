/**
 * $Id: ControlViewLabelProvider.java,v 1.11 2006/03/21 03:18:12 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.controlview;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.edit.ucmeditor.editparts.DependencyToColorFactory;
import org.isistan.flabot.engine.EnginePlugin;
import org.isistan.flabot.engine.messages.Messages;
import org.isistan.flabot.executionmodel.Dependency;
import org.isistan.flabot.executionmodel.ExecutionStep;

/**
 * @author $Author: franco $
 *
 */
public class ControlViewLabelProvider extends LabelProvider implements IColorProvider {	
	
	private Map<ImageDescriptor, Image> imageCache = new HashMap<ImageDescriptor, Image>(4);
	    
	boolean isSource = true;
	
	/*
	 * @see ILabelProvider#getImage(Object)
	 */
	@Override
	public Image getImage(Object element) {
		ImageDescriptor descriptor = null;
		if (element instanceof ExecutionStep) {
			isSource = true;
			descriptor = ImageDescriptor.createFromFile(EnginePlugin.class, "icons/step.gif"); //$NON-NLS-1$
		}
		if (element instanceof SimplePathNode) {
			if (isSource)
				descriptor = ImageDescriptor.createFromFile(EnginePlugin.class, "icons/source.gif"); //$NON-NLS-1$
			else
				descriptor = ImageDescriptor.createFromFile(EnginePlugin.class, "icons/target.gif"); //$NON-NLS-1$
			isSource = !isSource;
		}
		if (element instanceof Dependency) {
			descriptor = ImageDescriptor.createFromFile(EnginePlugin.class, "icons/dependency.gif"); //$NON-NLS-1$
		}

		//obtain the cached image corresponding to the descriptor
		Image image = imageCache.get(descriptor);
		if (image == null && descriptor != null) {
			image = descriptor.createImage();
			imageCache.put(descriptor, image);
		}
		return image;
	}

	/*
	 * @see ILabelProvider#getText(Object)
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof List) {
			return Messages.getString("org.isistan.flabot.edit.controlview.ControlViewLabelProvider.steps"); //$NON-NLS-1$
		}
		if (element instanceof ExecutionStep) {
			ExecutionStep step = (ExecutionStep) element;
			return Messages.getString("org.isistan.flabot.edit.controlview.ControlViewLabelProvider.step") + step.getSource().getName() + " -> " + step.getTarget().getName(); //$NON-NLS-1$ //$NON-NLS-2$
		}
		if (element instanceof SimplePathNode) {
			return ((SimplePathNode)element).getName();
		}
		if (element instanceof Dependency) {
			return ((Dependency)element).getType();
		} 
		
		return ""; //$NON-NLS-1$
	}

	@Override
	public void dispose() {
		for (Iterator i = imageCache.values().iterator(); i.hasNext();) {
			((Image) i.next()).dispose();
		}
		imageCache.clear();
	}
	
	public Color getForeground(Object element) {
		if (element instanceof ExecutionStep) {
			ExecutionStep step = (ExecutionStep) element;
			return DependencyToColorFactory.getColor(step.getDependency().getType());
		}
		
		return null;
	}
	
	public Color getBackground(Object o) {
		return null;
	}
}