/**
 * $Id: TagTreeViewSorter.java,v 1.3 2006/03/21 03:18:12 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.correlation.dialog.swt;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.engine.executionstate.correlation.dialog.swt.TagTreeModel.TagWrapper;
import org.isistan.flabot.engine.executionstate.correlation.dialog.swt.TagTreeModel.Wrapper;
import org.isistan.flabot.trace.log.Tag;
import org.isistan.flabot.trace.log.tagquery.TagQueryUtil;

/**
 * @author $Author: franco $
 *
 */
public class TagTreeViewSorter extends ViewerSorter {
	
	private Comparator<TagWrapper> comparator;
		
	public int compare(Viewer viewer, Object e1, Object e2) {
		Wrapper w1 = (Wrapper) e1;
		Wrapper w2 = (Wrapper) e2;
		   
		if (w1.getParent() == null && w2.getParent() == null && comparator != null)
			return comparator.compare((TagWrapper) w1, (TagWrapper) w2);
		return 0;
	}

	public void setComparator(Comparator<TagWrapper> comparator) {
		this.comparator = comparator;
	}
		
	
	/**
	 * The general comparator for the columns
	 * 
	 * @author franco
	 *
	 */
	public static abstract class TagWrapperComparator implements Comparator<TagWrapper> {
		
		protected boolean reverseOrder = true;
		
		private TreeColumn column;									
		private Image ascending = ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/ascendingOrder.gif").createImage();		 //$NON-NLS-1$
		private Image descending = ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/descendingOrder.gif").createImage(); //$NON-NLS-1$
		
		public void setColumn(TreeColumn column) {
			this.column = column;		
		}
		
		private void removeOtherImages() {
			Tree tree = column.getParent();
			for (int i=0; i < tree.getColumnCount(); i++){
				tree.getColumn(i).setImage(null);
			}
		}
		
		public void reverseOrder() {
			reverseOrder = !reverseOrder;
		}
		
		public int compare(TagWrapper tw1, TagWrapper tw2) {
			removeOtherImages();
			if (reverseOrder)
				column.setImage(ascending);
			else
				column.setImage(descending);
			
			return doCompare(tw1, tw2);
		}
		
		public abstract int doCompare(TagWrapper tw1, TagWrapper tw2);
		
	}
	
	/**
	 * The comparator for the tag column
	 * 
	 * @author franco
	 *
	 */	
	public static class TagComparator extends TagWrapperComparator {
				
		public int doCompare(TagWrapper tw1, TagWrapper tw2) {
			Integer v1 = new Integer(tw1.getKey());
			Integer v2 = new Integer(tw2.getKey());			
			if (reverseOrder)
				return v2.compareTo(v1);
			else
				return v1.compareTo(v2);
		}
	}
	   
	/**
	 * The comparator for the instance column
	 * 
	 * @author franco
	 *
	 */	
	public static class InstanceComparator extends TagWrapperComparator {
		
		public int doCompare(TagWrapper tw1, TagWrapper tw2) {
			Collator collator = Collator.getInstance(Locale.getDefault());
			if (reverseOrder)	
				return collator.compare(getInstance(tw2.getTag()), getInstance(tw1.getTag()));
			else
				return collator.compare(getInstance(tw1.getTag()), getInstance(tw2.getTag()));
		}
		
		private String getInstance(Tag t) {
			TagQueryUtil tqu = TagQueryUtil.INSTANCE;
			Tag objectSnapshotTag = tqu.getExecutionInstanceSnapshot(t);
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
	}
	
}