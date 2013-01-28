/** * $Id: TagTreeModel.java,v 1.5 2006/02/22 23:56:52 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.trace;

import java.awt.event.WindowAdapter;import java.awt.event.WindowEvent;import java.util.ArrayList;import java.util.Collections;import java.util.Comparator;import java.util.Iterator;import java.util.List;import javax.swing.JFrame;import javax.swing.JScrollPane;import javax.swing.JTree;import javax.swing.event.TreeModelListener;import javax.swing.tree.TreeModel;import javax.swing.tree.TreePath;import org.eclipse.emf.common.util.EMap;import org.isistan.flabot.trace.log.Tag;/** * Tree model for showing log tags in a JTree * @author dacostae * */public class TagTreeModel implements TreeModel {		/**	 * For sorting numeric keys in the tag children	 * @author mblech	 */	public static class NumberKeyComparator implements Comparator {		public int compare(Object o1, Object o2) {			if (o1 instanceof String && o2 instanceof String) {				try {					int value1 = Integer.parseInt((String) o1);					int value2 = Integer.parseInt((String) o2);					return value1 - value2;				}				catch (NumberFormatException nfe) {}			}			if (o1 instanceof Comparable && o2 instanceof Comparable) {				return ((Comparable)o1).compareTo((Comparable)o2);			}			return 0;		}	}	/**	 * Wrapper	 */
	public static interface Wrapper {
		
	}
		/**	 * Wrapper for properties	 */
	public static class PropertyWrapper implements Wrapper {
		private String value;
		private String key;

		public PropertyWrapper(String key, String value) {
			this.key=key;
			this.value=value;
		}
		
		@Override		public String toString() {
			return key + "=" + value;
		}		public String getKey() {			return key;		}		public String getValue() {			return value;		}
	}
		/**	 * Wrapper for tags	 */
	public static class TagWrapper implements Wrapper {
		
		private Tag tag;
		private Wrapper[] children=null;
		private String key;
		public TagWrapper(String key, Tag tag) {
			this.key=key;
			this.tag=tag;
		}

		public Wrapper[] getChildren() {
			if(children!=null)
				return children;
			
			EMap tags=tag.getTags();
			EMap properties=tag.getProperties();
			children=new Wrapper[properties.size() + tags.size()];			List sortedTagKeys = new ArrayList(tags.keySet()); 			Collections.sort(sortedTagKeys, new NumberKeyComparator());
			Iterator tagsIterator= sortedTagKeys.iterator();
			Iterator propertiesIterator=properties.keySet().iterator();
			for(int i=0; i<properties.size(); i++) {
				String key=(String) propertiesIterator.next();
				children[i]=new PropertyWrapper(key, (String)properties.get(key));
			}
			for(int i=properties.size(); i<children.length; i++) {
				String key=(String) tagsIterator.next();				Tag tag = (Tag) tags.get(key);				String descriptor = createTagDescriptor(key, tag);
				children[i]=new TagWrapper(descriptor, tag);
			}
			return children;
		}
		
		@Override		public String toString() {
			return key;
		}		public String getKey() {			return key;		}		public Tag getTag() {			return tag;		}
	}
	
	
	private TagWrapper root;		/**	 * Create a new instance of TagTreeModel for the given root tag	 * @param root	 */
	public TagTreeModel(String rootName, Tag root) {		this.root=new TagWrapper(rootName, root);		
	}
		/**	 * 	 * @param key	 * @param tag	 * @return	 */
	public static String createTagDescriptor(String key, Tag tag) {		StringBuffer descriptor = new StringBuffer(key);		// TODO Auto-generated method stub		return descriptor.toString();	}	public Object getRoot() {
		return root;
	}

	public Object getChild(Object parent, int index) {
		return ((TagWrapper)parent).getChildren()[index];
	}

	public int getChildCount(Object parent) {
		return ((TagWrapper)parent).getChildren().length;
	}

	public boolean isLeaf(Object node) {
		return (node instanceof PropertyWrapper);
	}

	public void valueForPathChanged(TreePath path, Object newValue) {
		// TODO Auto-generated method stub

	}

	public int getIndexOfChild(Object parent, Object child) {
		Wrapper[] children=((TagWrapper)parent).getChildren();
		for (int i = 0; i < children.length; i++) {
			if(children[i]==child)
				return i;
		}
		return -1;
	}

	public void addTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub

	}

	public void removeTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub

	}
	/**	 * Utility method for showing a dialog with the given root tag	 * @param title the title	 * @param tag the root tag of the log	 */
	public static void show(String title, String rootName, Tag tag) {		class CloseListener extends WindowAdapter {
			private JFrame frame;

			public CloseListener(JFrame frame) {
				this.frame=frame;
			}

			@Override			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
				
			}

			@Override			public void windowClosed(WindowEvent e) {
				frame.setVisible(false);
				
			}
		}
		JFrame frame=new JFrame();
		
		frame.setSize(600,400);
		frame.setLocation(0,0);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setTitle(title);
		frame.setAlwaysOnTop(true);
		JTree tree=new JTree(new TagTreeModel(rootName, tag));
		frame.getContentPane().add(new JScrollPane(tree));
		frame.addWindowListener(new CloseListener(frame));

		frame.setVisible(true);
	}
}
