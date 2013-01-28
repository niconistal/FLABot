/**
 * 
 */
package org.isistan.flabot.trace.log.tagquery;

import java.util.List;

import org.isistan.flabot.trace.log.Tag;

/**
 * This interface has the utility methods necessary to query log tags
 * @author mblech
 *
 */
public interface TagQueryUtil {
	
	/**
	 * Holds trace generator constants
	 * @author mblech
	 *
	 */
	public static interface TraceGeneratorConstants {

		public static final String COLLECTION_SIZE_PARAMETER = "count";
		public static final String METADATA_TAG="metadata";
		public static final String OBJECTS_TAG="objects";
		public static final String OBJECT_TAG="object";
		public static final String INTERNAL_EVENTS_TAG="internalEvents";
		public static final String EXCEPTION_THROWN_TAG="thrown";
		public static final String THREADS_TAG="threads";
		public static final String THREADS_ID_PARAMETER="id";
		public static final String THREADS_NAME_PARAMETER="name";
		public static final String EVENT_TYPE_PARAMETER_NAME="eventType";
		public static final String EXIT_EVENT_TYPE_PARAMETER_NAME="exitEventType";
		public static final String TIMESTAMP_PARAMETER_NAME="timeStamp";
		public static final String EXIT_TIMESTAMP_PARAMETER_NAME="exitTimeStamp";
		public static final String EXECUTON_ID_PARAMETER_NAME="executionId";
		public static final String NULL_OBJECT_KEY = "null";
		
	}
	
	/**
	 * Holds metadata constants
	 * @author mblech
	 *
	 */
	public static interface MetadataConstants {

		public static final String COMPLETE_PARAMETER = "complete";
		public static final String NAME_PARAMETER = "name";
		public static final String MODIFIERS_PARAMETER = "modifiers";
		public static final String ARRAY_PARAMETER = "array";
		public static final String PRIMITIVE_PARAMETER = "primitive";
		public static final String TYPE_TAG = "type";
		public static final String DECLARING_CLASS_TAG = "declaringClass";
		public static final String SUPERCLASS_TAG = "superclass";
		public static final String SUPERINTERFACES_TAG = "superinterfaces";
		public static final String COMPONENT_TYPE_TAG = "componentType";
		public static final String ENCLOSING_CLASS_TAG = "enclosingClass";
		public static final String FIELDS_TAG = "fields";
		public static final String INNER_CLASSES_TAG = "innerClasses";
		public static final String CONSTRUCTORS_TAG = "constructors";
		public static final String EXCEPTION_TYPES_TAG = "exceptionTypes";
		public static final String PARAMETER_TYPES_TAG = "parameterTypes";
		public static final String METHODS_TAG = "methods";
		
	}
	
	/**
	 * Holds object snapshot constants
	 * @author mblech
	 *
	 */
	public static interface SnapshotConstants {

		public static final String STRING_PARAMETER="string";
		public static final String FIELDS_TAG="fields";
		//	public static final String FIELD_VALUE_PARAMETER="value";
		//	public static final String FIELD_DESCRIPTOR_PARAMETER="descriptor";
		//	public static final String FIELD_TAG="field";
		public static final String NULL_PARAMETER="null";
		
	}
	
	/**
	 * Holds object constants
	 * @author mblech
	 *
	 */
	public static interface ObjectConstants {

		public static final String ID_PARAMETER="id";
		public static final String HASH_CODE_PARAMETER="hashCode";
		public static final String SYSTEM_HASH_CODE_PARAMETER="systemHashCode";
		public static final String CLASS_TAG="class";
		public static final String FINAL_FIELDS_TAG="finalFields";
		
	}

	/**
	 * Holds the instance of TagUtil
	 */
	public static final TagQueryUtil INSTANCE = new DefaultTagQueryUtil();
	
	/**
	 * Construct a list from the contained tag that has the given key
	 * @param parentTag
	 * @param listKey
	 * @return
	 */
	public List<Tag> getList(Tag parentTag, String listKey);

	/**
	 * Get the behavior where the given execution tag is executed
	 * @param executionTag
	 * @return
	 */
	Tag getBehavior(Tag executionTag);

	/**
	 * Get the internal events contained by the given execution tag
	 * @param executionTag
	 * @return
	 */
	List<Tag> getInternalEvents(Tag executionTag);

	/**
	 * Get the behavior descriptor for the given behavior tag
	 * @param behaviorTag
	 * @return
	 */
	String getBehaviorDescriptor(Tag behaviorTag);
	
	/**
	 * Get the return type tag for the given behavior tag
	 * @param behaviorTag
	 * @return
	 */
	Tag getReturnType(Tag behaviorTag);
	
	/**
	 * Get the list of parameter type tags for the given behavior
	 * @param behaviorTag
	 * @return
	 */
	List<Tag> getParameterTypes(Tag behaviorTag);
	
	/**
	 * Get the name for the given tag
	 * @param tag
	 * @return
	 */
	String getName(Tag tag);
	
	/**
	 * Get the declaring class for the given feature tag (behavior or field)
	 * @param featureTag
	 * @return
	 */
	Tag getDeclaringClass(Tag featureTag);
	
	/**
	 * Get the class descriptor for the given class tag
	 * @param classTag
	 * @return
	 */
	String getClassDescriptor(Tag classTag);

	/**
	 * Get the target behavior for the given execution tag
	 * @param executionTag 
	 * @return
	 */
	Tag getTargetBehavior(Tag executionTag);
	
	Tag getTargetInstance(Tag executionTag);
	
	/**
	 * Get the (entry) timestamp for the given execution tag
	 * @param executionTag
	 * @return
	 */
	Long getTimestamp(Tag executionTag);
	
	/**
	 * Get the object snapshot tag for the instance of the given execution tag
	 * @param executionTag
	 * @return
	 */
	Tag getExecutionInstanceSnapshot(Tag executionTag);
	
	/**
	 * Get the toString() value of the given object snapshot tag
	 * @param objectSnapshotTag
	 * @return
	 */
	String getToString(Tag objectSnapshotTag);
	
	/**
	 * Get the object tag for the given object snapshot tag 
	 * @param objectSnapshotTag
	 * @return
	 */
	Tag getObject(Tag objectSnapshotTag);
	
	/**
	 * Get the unique id for the given object tag
	 * @param objectTag
	 * @return
	 */
	String getObjectId(Tag objectTag);
	
	/**
	 * Get the class tag for the given object tag
	 * @param objectTag
	 * @return
	 */
	Tag getObjectClass(Tag objectTag);
	
	/**
	 * Get the object descriptor for the given object tag (class descriptor
	 * + id)
	 * @param objectTag
	 * @return
	 */
	String getObjectDescriptor(Tag objectTag);
	
	/**
	 * Get the thread tag for the given execution tag
	 * @param executionTag
	 * @return
	 */
	Tag getThread(Tag executionTag);

	/**
	 * Check if the given tag is a thread tag
	 * @param tag
	 * @return
	 */
	boolean isThread(Tag tag);

	/**
	 * Get the list of argument snapshots for the given execution tag
	 * @param executionTag
	 * @return
	 */
	List<Tag> getArguments(Tag executionTag);

	/**
	 * Get the return value for the given execution tag
	 * @param executionTag
	 * @return
	 */
	Tag getReturnValue(Tag executionTag);

	/**
	 * Get the fields tag for the given snapshot tag. The fields tag
	 * is a tag that has all the snapshot's fields in key-value properties
	 * @param snapshotTag the snapshot tag
	 * @return the tag that contains the field values in key-value properties
	 */
	Tag getFieldsTag(Tag snapshotTag);

	
	Tag getExceptionThrown(Tag executionTag);
	
	/**
	 * Check if the given snapshot is a null reference's snapshot
	 * @param snapshotTag
	 * @return
	 */
	public boolean isNull(Tag snapshotTag);
}
