/**
 * $Id: TagTreeModel.java,v 1.2 2006/03/21 03:18:12 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.correlation.dialog.swt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EMap;
import org.isistan.flabot.trace.TagTreeModel.NumberKeyComparator;
import org.isistan.flabot.trace.log.Tag;

/**
 * @author $Author: franco $
 *
 */
public class TagTreeModel {

	List<Tag> tags;
	
	Wrapper[] children;
	
	/**
	 * Create a new instance of TagTreeModel for the given root tag
	 * @param root
	 */
	public TagTreeModel(List<Tag> tags) {
		this.tags = tags;		
	}
	
	
	public  Wrapper[] getChildren() {
		if (children != null)
			return children;
		
		Wrapper[] children = new Wrapper[tags.size()];
		int index = 0;
		for(Iterator iter=tags.iterator(); iter.hasNext();) {
			Tag tag = (Tag) iter.next();
			children[index] = new TagWrapper(null, String.valueOf(index), tag);
			index++;
		}		
		return children;
	}	
	
	/**
	 * Wrapper for tags and properties
	 */
	public static interface Wrapper {	
		
		Wrapper getParent();
		
		Wrapper[] getChildren();
	}
	
	/**
	 * Wrapper for properties
	 */
	public static class PropertyWrapper implements Wrapper {
		private static final Wrapper[] EMPTY = new Wrapper[] {};		
		
		private Wrapper parent;
		private String value;
		private String key;

		public PropertyWrapper(Wrapper parent, String key, String value) {
			this.parent=parent;
			this.key=key;
			this.value=value;
		}
		
		@Override
		public String toString() {
			return key + " -> " + value; //$NON-NLS-1$
		}

		public String getKey() {
			return key;
		}

		public String getValue() {
			return value;
		}
		
		public Wrapper getParent() {
			return parent;
		}
		
		public Wrapper[] getChildren() {
			return EMPTY;
		}
	}
	
	/**
	 * Wrapper for tags
	 */
	public static class TagWrapper implements Wrapper {
		
		private Wrapper parent;
		
		private Tag tag;		
		private String key;
		private Wrapper[] children=null;
		
		public TagWrapper(Wrapper parent, String key, Tag tag) {
			this.parent=parent;
			this.key=key;
			this.tag=tag;
		}

		public Wrapper[] getChildren() {
			if(children!=null)
				return children;
			
			EMap tags=tag.getTags();
			EMap properties=tag.getProperties();
			children=new Wrapper[properties.size() + tags.size()];
			List sortedTagKeys = new ArrayList(tags.keySet()); 
			Collections.sort(sortedTagKeys, new NumberKeyComparator());
			
			Iterator propertiesIterator=properties.keySet().iterator();
			for(int i=0; i<properties.size(); i++) {
				String key=(String) propertiesIterator.next();
				children[i]=new PropertyWrapper(this, key, (String)properties.get(key));
			}
			
			Iterator tagsIterator= sortedTagKeys.iterator();
			for(int i=properties.size(); i<children.length; i++) {
				String key=(String) tagsIterator.next();
				Tag tag = (Tag) tags.get(key);
				String descriptor = createTagDescriptor(key, tag);
				children[i]=new TagWrapper(this, descriptor, tag);
			}
			return children;
		}
		
		private String createTagDescriptor(String key, Tag tag) {
			StringBuffer descriptor = new StringBuffer(key);
			return descriptor.toString();
		}		
		
		@Override
		public String toString() {
			return key;
		}

		public String getKey() {
			return key;
		}

		public Tag getTag() {
			return tag;
		}
		
		public Wrapper getParent() {
			return parent;
		}		
	}	
}