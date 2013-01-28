/** * $Id: TagUtil.java,v 1.4 2006/02/22 00:48:51 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.launcher.trace;

import java.util.ArrayList;import java.util.List;import org.isistan.flabot.trace.log.LogFactory;import org.isistan.flabot.trace.log.Tag;import org.isistan.flabot.trace.log.tagquery.TagQueryUtil.TraceGeneratorConstants;/** * Tag management utility methods * @author dacostae * */public class TagUtil {

	/**
	 * Creates a collection without any association
	 * @return
	 */
	public static Tag createCollection() {
		Tag collection=createTag();
		collection.setProperty(TraceGeneratorConstants.COLLECTION_SIZE_PARAMETER, "0");
		return collection;
	}

	/**
	 * Creates a collection as a child
	 * @return
	 */
	public static Tag createChildCollection(Tag parent, String collectionKey, boolean contained) {
		Tag collection=createCollection();
		setRelationship(parent, collection, collectionKey, contained);
		return collection;
	}

	
	/**
	 * Gets a collection inside given tag, creates it if necessary and indicated
	 * @param tag
	 * @return
	 */
	public static Tag getCollection(Tag parent, String collectionKey, boolean create, boolean contained) {
		Tag collection=(Tag) parent.getTags().get(collectionKey);
		if(collection==null && create){
			collection=createChildCollection(parent, collectionKey, contained);
		}

		return collection;
	}
	
	
	/**
	 * Registers a tag in a collection
	 * @param eventsCollection
	 * @param event
	 */
	public static void addToCollection(Tag collection, Tag item, boolean contained) {
		String oldCount=collection.getProperty(TraceGeneratorConstants.COLLECTION_SIZE_PARAMETER);
		String newCount=Integer.toString(Integer.parseInt(oldCount)+1);
		collection.setProperty(TraceGeneratorConstants.COLLECTION_SIZE_PARAMETER, newCount);
		setRelationship(collection, item, oldCount, contained);
	}
	

	/**
	 * Creates and Registers a new tag in a collection
	 * @param eventsCollection
	 * @param event
	 */
	public static Tag createInCollection(Tag collection, boolean contained) {
		Tag item=createTag();
		addToCollection(collection, item, contained);
		return item;
	}
	
	/**
	 * Establishes the relationship between tags by reference or by contention
	 * @param parent
	 * @param child
	 * @param key
	 * @param contained
	 */
	private static void setRelationship(Tag parent, Tag child, String childKey, boolean contained) {
		if(contained) {
			child.setParent(childKey, parent);
		} else {
			parent.getTags().put(childKey, child);
		}		
	}
	
	/**
	 * Returns a tag with the given id, creates it if necessary and indicated
	 * @param rootTag
	 * @return
	 */
	public static Tag getTag(Tag parent, String childKey, boolean create, boolean contained) {
		Tag child=(Tag)parent.getTags().get(childKey);
		if(child==null && create) {
			child=createChildTag(parent, childKey, contained);
		}
		return child;
	}
	
	/**
	 * Adds a child tag
	 * @param parent
	 * @param child
	 * @param childKey
	 * @param contained
	 */
	public static void addChildTag(Tag parent, Tag child, String childKey, boolean contained) {
		setRelationship(parent, child, childKey, contained);
	}
	
	/**
	 * Returns a tag as child with the given id, creates it if necessary
	 * @param rootTag
	 * @return
	 */
	public static Tag createChildTag(Tag parent, String childKey, boolean contained) {
		Tag child=createTag();
		setRelationship(parent, child, childKey, contained);
		return child;
	}
	
	/**
	 * Creates a tag without any association
	 */
	public static Tag createTag() {
		return LogFactory.eINSTANCE.createTag();
	}
}
