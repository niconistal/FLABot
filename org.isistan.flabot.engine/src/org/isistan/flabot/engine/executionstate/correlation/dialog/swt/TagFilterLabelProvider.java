/**
 * $Id: TagFilterLabelProvider.java,v 1.3 2006/03/21 03:18:12 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.correlation.dialog.swt;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.isistan.flabot.engine.EnginePlugin;
import org.isistan.flabot.engine.executionstate.correlation.dialog.swt.TagTreeModel.PropertyWrapper;
import org.isistan.flabot.engine.executionstate.correlation.dialog.swt.TagTreeModel.TagWrapper;
import org.isistan.flabot.trace.log.Tag;
import org.isistan.flabot.trace.log.tagquery.TagQueryUtil;

/**
 * @author franco
 *
 */
public class TagFilterLabelProvider implements ITableLabelProvider {
	
	private Map<ImageDescriptor, Image> imagesMap = new HashMap<ImageDescriptor, Image>(2);
	
	
	/**
	 * Gets the image for the specified column
	 * 
	 * @param arg0 the wrapper tag or property
	 * @param arg1 the column
	 * @return Image
	 */
	public Image getColumnImage(Object arg0, int arg1) {
		ImageDescriptor imageDescriptor =  null;
		if (arg0 instanceof TagWrapper && arg1 == 0) {
			imageDescriptor = ImageDescriptor.createFromFile(EnginePlugin.class, "icons/tag.gif"); //$NON-NLS-1$
		}      
		if (arg0 instanceof PropertyWrapper && arg1 == 0) {
			imageDescriptor = ImageDescriptor.createFromFile(EnginePlugin.class, "icons/property.gif"); //$NON-NLS-1$
		}
		
		Image image = imagesMap.get(imageDescriptor);
		if (image == null && imageDescriptor != null) {
			image = imageDescriptor.createImage();
			imagesMap.put(imageDescriptor, image);
		}  
		return image;
	}

	/**
	 * Gets the text for the specified column
	 * 
	 * @param arg0 the wrapper tag or property
	 * @param arg1
	 *            	
	 * @return String
	*/
	public String getColumnText(Object arg0, int arg1) {
		if (arg0 instanceof PropertyWrapper) {
			String text = ""; //$NON-NLS-1$
			if (arg1 == 0)
				text = ((PropertyWrapper) arg0).toString();
			
			return text;
		}
	  
		TagWrapper tw = (TagWrapper) arg0;	  
		TagQueryUtil tqu = TagQueryUtil.INSTANCE;
		switch (arg1) {
    		case 0:
    			//Tag info
    			return tw.getKey();
    		case 1:  {
    			//TimeStamp info
    			Long tm = tqu.getTimestamp(tw.getTag());
    			String text = ""; //$NON-NLS-1$
    			if (tm != null)
    				text = tm.toString();
    			return text;
    		}
    		case 2: {
    			//Method info
    			Tag executionTag = tqu.getBehavior(tw.getTag());
    			String text = ""; //$NON-NLS-1$
    			if (executionTag != null) {
    				Tag returnTypeTag = tqu.getReturnType(executionTag);
    				text = tqu.getName(executionTag) + ": " + tqu.getName(returnTypeTag); //$NON-NLS-1$
    			}
    			return text;  
    		}
    		case 3: {
    			//Intance info
    			Tag objectSnapshotTag = tqu.getExecutionInstanceSnapshot(tw.getTag());
    			Tag objectTag = tqu.getObject(objectSnapshotTag);
    			String objectSnapshotDescriptor = tqu.getObjectDescriptor(objectTag);
    			String text = ""; //$NON-NLS-1$
    			if (objectSnapshotDescriptor != null) {
    				int index = objectSnapshotDescriptor.lastIndexOf(".") + 1; //$NON-NLS-1$
    				if (index < 0) index = 0;    				
    				text = objectSnapshotDescriptor.substring(index, objectSnapshotDescriptor.length()); 
    			}    			
    			return text;
    		}    		
    		case 4:
    			//Thread info
    			Tag threadTag =tqu.getThread(tw.getTag());
    			return tqu.getName(threadTag);
    		default:
    			return ""; //$NON-NLS-1$
		}
	}
  
	/**
	 * Adds a listener
	 * 
	 * @param arg0 the listener
	 */
	public void addListener(ILabelProviderListener arg0) {
		// Do nothing
	}

	/**
	 * Dispose any created resources
	 */
	public void dispose() {
		// Dispose the images
		for (Iterator i = imagesMap.values().iterator(); i.hasNext();) {
			((Image) i.next()).dispose();
		}
		imagesMap.clear();
	}

	/**
	 * Returns whether the specified property, if changed, would affect the
	 * label
	 * 
	 * @param arg0 the wrapper
	 * @param arg1 the property
	 * @return boolean
	 */
	public boolean isLabelProperty(Object arg0, String arg1) {
		return false;
	}

	/**
	 * Removes the specified listener
	 * 
	 * @param arg0 the listener
	 */
	public void removeListener(ILabelProviderListener arg0) {
		// Do nothing
	}
}