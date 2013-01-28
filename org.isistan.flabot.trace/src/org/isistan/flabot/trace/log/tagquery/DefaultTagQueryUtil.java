/**
 * 
 */
package org.isistan.flabot.trace.log.tagquery;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.isistan.flabot.gauge.Event;
import org.isistan.flabot.gauge.Gauge;
import org.isistan.flabot.javamodel.Util;
import org.isistan.flabot.trace.log.Tag;

/**
 * Default implementation of TagQueryUtil
 * @author mblech
 *
 */
public class DefaultTagQueryUtil implements TagQueryUtil {

	/* (non-Javadoc)
	 * @see org.isistan.flabot.trace.log.tagquery.TagQueryUtil#getBehavior(org.isistan.flabot.trace.log.Tag)
	 */
	public Tag getBehavior(Tag executionTag) {
		if (executionTag == null)
			return null;
		String behaviorTagKey = Gauge.AttributeName.BEHAVIOR.getName();
		Tag behaviorTag = (Tag) executionTag.getTags().get(behaviorTagKey); 
		return behaviorTag;
	}

	public List<Tag> getInternalEvents(Tag executionTag) {
		if (executionTag == null)
			return null;
		List<Tag> internalEvents = getList(executionTag, TraceGeneratorConstants.INTERNAL_EVENTS_TAG); 
		return internalEvents;
	}	
	
	public List<Tag> getList(Tag parentTag, String listKey) {
		if (parentTag == null)
			return null;
		if (listKey == null)
			return null;
		Tag listTag = (Tag) parentTag.getTags().get(listKey);
		if (listTag == null)
			return null;
		int size = Integer.parseInt(listTag.getProperty(TraceGeneratorConstants.COLLECTION_SIZE_PARAMETER));
		List<Tag> list = new ArrayList<Tag>(size);
		for (int i=0; i<size; i++) {
			Tag tag = (Tag) listTag.getTags().get(String.valueOf(i));
			list.add(tag);
		}
		return list;
	}

	public String getBehaviorDescriptor(Tag behaviorTag) {
		if (behaviorTag == null)
			return null;
		StringBuffer behaviorDescriptor = new StringBuffer();
		// class descriptor
		String classDescriptor = getClassDescriptor(getDeclaringClass(behaviorTag));
		if (classDescriptor == null)
			return null;
		behaviorDescriptor.append(classDescriptor);
		
		// behavior delimiter
		behaviorDescriptor.append(Util.MEMBER_DELIMITER);
		
		// behavior name
		String behaviorName = getName(behaviorTag);
		if (behaviorName == null)
			return null;
		behaviorDescriptor.append(behaviorName);
		
		// behavior arguments
		behaviorDescriptor.append('(');		
		List<Tag> parameterTypeTags = getParameterTypes(behaviorTag);
		int count = 0;
		for (Tag parameterTypeTag: parameterTypeTags) {
			if (count > 0)
				behaviorDescriptor.append(',');
			String parameterTypeDescriptor = getClassDescriptor(parameterTypeTag);
			if (parameterTypeDescriptor == null)
				return null;
			behaviorDescriptor.append(parameterTypeDescriptor);
			count++;
		}
		behaviorDescriptor.append(')');
		
		// return type
		Tag returnTypeTag = getReturnType(behaviorTag);
		String returnTypeDescriptor = getClassDescriptor(returnTypeTag);
		if (returnTypeDescriptor != null) {
			behaviorDescriptor.append(Util.TYPE_DELIMITER);
			behaviorDescriptor.append(returnTypeDescriptor);
		}
		
		return behaviorDescriptor.toString();
	}
	
	public Tag getReturnType(Tag behaviorTag) {
		return (Tag) behaviorTag.getTags().get(MetadataConstants.TYPE_TAG);
	}

	public List<Tag> getParameterTypes(Tag behaviorTag) {
		if (behaviorTag == null)
			return null;
		List<Tag> parameterTypeTags = TagQueryUtil.INSTANCE.getList(behaviorTag, MetadataConstants.PARAMETER_TYPES_TAG);
		return parameterTypeTags;
	}

	public String getName(Tag behaviorTag) {
		if (behaviorTag == null)
			return null;
		String behaviorName = behaviorTag.getProperty(MetadataConstants.NAME_PARAMETER);
		return behaviorName;
	}

	public Tag getDeclaringClass(Tag featureTag) {
		if (featureTag == null)
			return null;
		Tag declaringClassTag = (Tag) featureTag.getTags().get(MetadataConstants.DECLARING_CLASS_TAG);
		return declaringClassTag;
	}

	public String getClassDescriptor(Tag classTag) {
		return getName(classTag);
	}

	public Tag getTargetBehavior(Tag executionTag) {
		if (executionTag == null)
			return null;
		Tag targetBehaviorTag = (Tag) executionTag.getTags().get(Gauge.AttributeName.TARGET_BEHAVIOR.getName());
		return targetBehaviorTag;
	}
	
	public Tag getTargetInstance(Tag executionTag) {
		if (executionTag == null)
			return null;
		Tag targetBehaviorTag = (Tag) executionTag.getTags().get(Gauge.AttributeName.TARGET_INSTANCE.getName());
		return targetBehaviorTag;
	}
	
	public Long getTimestamp(Tag executionTag) {
		if (executionTag == null)
			return null;
		String timeString = executionTag.getProperty(TraceGeneratorConstants.TIMESTAMP_PARAMETER_NAME);
		if (timeString == null)
			return null;
		return new Long(timeString);
	}

	public Tag getExecutionInstanceSnapshot(Tag executionTag) {
		if (executionTag == null)
			return null;
		Tag instanceTag = (Tag) executionTag.getTags().get(Event.AttributeName.INSTANCE.getName());
		return instanceTag;
	}

	public String getToString(Tag objectSnapshotTag) {
		if (objectSnapshotTag == null)
			return null;
		String string = objectSnapshotTag.getProperty(SnapshotConstants.STRING_PARAMETER);
		return string;
	}

	public Tag getObject(Tag objectSnapshotTag) {
		if (objectSnapshotTag == null)
			return null;
		Tag objectTag = (Tag) objectSnapshotTag.getTags().get(TraceGeneratorConstants.OBJECT_TAG);
		return objectTag;
	}

	public String getObjectId(Tag objectTag) {
		if (objectTag == null)
			return null;
		String objectId = objectTag.getProperty(ObjectConstants.ID_PARAMETER);
		return objectId;
	}

	public Tag getObjectClass(Tag objectTag) {
		if (objectTag == null)
			return null;
		Tag classTag = (Tag) objectTag.getTags().get(ObjectConstants.CLASS_TAG);
		return classTag;
	}

	public String getObjectDescriptor(Tag objectTag) {
		Tag classTag = getObjectClass(objectTag);
		String classDescriptor = getClassDescriptor(classTag);
		if (classDescriptor == null)
			return null;
		String objectId = getObjectId(objectTag);
		if (objectId == null)
			return null;
		return classDescriptor + objectId;
	}

	public Tag getThread(Tag executionTag) {
		// TODO find a better way to do this
		// search up in the containment hierarchy for the thread
		EObject eObject = executionTag;
		while (eObject != null) {
			if (eObject instanceof Tag) {
				Tag tag = (Tag) eObject;
				if (isThread(tag))
					return tag;
			}
			eObject = eObject.eContainer();
		}
		return null;
	}

	public boolean isThread(Tag tag) {
		// TODO find a better way to do this
		if (tag == null)
			return false;
		Set keySet = tag.getProperties().keySet();
		if (keySet.size() != 2)
			return false;
		if (!keySet.contains(TraceGeneratorConstants.THREADS_ID_PARAMETER))
			return false;
		if (!keySet.contains(TraceGeneratorConstants.THREADS_NAME_PARAMETER))
			return false;
		return true;
	}

	public List<Tag> getArguments(Tag executionTag) {
		String argumentsKey = Event.AttributeName.ARGUMENTS.getName();
		List<Tag> arguments = getList(executionTag, argumentsKey);
		return arguments;
	}

	public Tag getReturnValue(Tag executionTag) {
		String returnValueKey = Event.AttributeName.VALUE.getName();
		Tag returnValue = (Tag) executionTag.getTags().get(returnValueKey);
		return returnValue;
	}
	
	public Tag getExceptionThrown(Tag executionTag) {
		String exceptionKey = Event.AttributeName.THROWN.getName();
		Tag exception = (Tag) executionTag.getTags().get(exceptionKey);
		return exception;
	}

	public Tag getFieldsTag(Tag snapshotTag) {
		if (snapshotTag == null)
			return null;
		Tag fieldsTag = (Tag) snapshotTag.getTags().get(SnapshotConstants.FIELDS_TAG);
		return fieldsTag;
	}

	public boolean isNull(Tag snapshotTag) {
		if (snapshotTag == null)
			return false;
		String nullKey = SnapshotConstants.NULL_PARAMETER;
		String value = snapshotTag.getProperty(nullKey);
		return Boolean.valueOf(value).booleanValue();
	}

}
