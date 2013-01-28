/**

import java.util.HashMap;
	private boolean dirty=false;
	private MetadataHandler metadata;
	private Tag threads;
	private Tag objects;
	private Map<Thread, Tag> currents=new HashMap<Thread, Tag>();
	private ObjectTagCreator objectTagCreator;
	private ObjectSnapshotTagCreator snapshotTagCreator;
	private Tag rootTag; 
	public TraceGenerator(Tag rootTag, ObjectTagCreator objectTagCreator, ObjectSnapshotTagCreator snapshotTagCreator) {
		this.metadata=new MetadataHandler(TagUtil.createChildTag(rootTag, TraceGeneratorConstants.METADATA_TAG, true));
		this.objectTagCreator=objectTagCreator;
		this.snapshotTagCreator=snapshotTagCreator;

		threads=TagUtil.createChildCollection(rootTag, TraceGeneratorConstants.THREADS_TAG, true);
		objects=TagUtil.createChildTag(rootTag, TraceGeneratorConstants.OBJECTS_TAG, true);
	}
	public void reset() {
	
	public Tag report(Event event) {
		Gauge gauge=event.getGague();
		Tag current=getCurrent();
		Gauge.Type type=gauge.getType();
		if(isInitiator(type)) {
			Tag eventTag=createEventTag(event, current);
			setCurrent(eventTag);
			return eventTag;
		} else if(isTerminator(type)) {
			appendEventData(event, current);
			setCurrent(current.getParent().getParent());
			return current;
		} else /*if(isAtomic(type))*/ {
			return createEventTag(event, current);
		}
		
	}
	
	/**
	 * Determines if a tag type initiates a tag that can contain internal events
	 * @param type
	 * @return
	 */
	private boolean isInitiator(Gauge.Type type) {
		return
				type==Gauge.Type.ON_BEHAVIOR_ENTRY ||
				type==Gauge.Type.BEFORE_ARRAY_CREATION ||
				type==Gauge.Type.BEFORE_CAST ||
				type==Gauge.Type.BEFORE_CONSTRUCTOR_CALL ||
				type==Gauge.Type.BEFORE_CREATION ||
				type==Gauge.Type.BEFORE_METHOD_CALL;
	}
	
	/**
	 * Determines if a tag type terminates a tag that can contain internal events
	 * @param type
	 * @return
	 */
	private boolean isTerminator(Gauge.Type type) {
		return
				type==Gauge.Type.ON_BEHAVIOR_ERROR ||
				type==Gauge.Type.ON_BEHAVIOR_EXIT ||
				type==Gauge.Type.AFTER_ARRAY_CREATION ||
				type==Gauge.Type.AFTER_CAST ||
				type==Gauge.Type.AFTER_CONSTRUCTOR_CALL ||
				type==Gauge.Type.AFTER_CREATION ||
				type==Gauge.Type.AFTER_METHOD_CALL ||
				type==Gauge.Type.ON_ARRAY_CREATION_ERROR ||
				type==Gauge.Type.ON_CAST_ERROR ||
				type==Gauge.Type.ON_CREATION_ERROR ||
				type==Gauge.Type.ON_METHOD_CALL_ERROR;
	}

	
	/**
	 * Creates a internal event tag inside the current tag
	 * @param event
	 * @param current
	 * @return
	 */
	private Tag createEventTag(Event event, Tag current) {
		Tag internalEvents=TagUtil.getCollection(current, TraceGeneratorConstants.INTERNAL_EVENTS_TAG, true, true);
		Tag eventTag=TagUtil.createInCollection(internalEvents, true);
		fillData(event, eventTag);
		return eventTag;
	}
	
	/**
	 * Fills the tag data
	 * @param event
	 * @param eventTag
	 */
	private void fillData(Event event, Tag eventTag) {
		eventTag.setProperty(TraceGeneratorConstants.EVENT_TYPE_PARAMETER_NAME, event.getGague().getType().getName());

		fillGaugeData(event.getGague(), eventTag);
		fillEventData(event, eventTag, false);
	}

	private void fillEventData(Event event, Tag eventTag, boolean completing) {
		if(!completing) {
		}
			eventTag.setProperty(TraceGeneratorConstants.EXIT_TIMESTAMP_PARAMETER_NAME, Long.toString(event.getTimeStamp()));
				eventTag.setRuntimeObject(Event.AttributeName.INSTANCE, Event.AttributeName.INSTANCE);
		}
		
		if(event.hasAttribute(Event.AttributeName.ARGUMENTS)) {

	private void fillInstanceData(JObject instance, Tag parent, String key) {
	
	private Tag getObjectSnapshotTag(JObject object) {
		if(snapshotTagCreator==null) {
			return null;
		}
		return snapshotTagCreator.create(object, metadata);
	}
	
	private Tag getObjectTag(JObject object) {
			Tag objectTag=(Tag)objects.getRuntimeObject(object);
			if(objectTag==null) {
				objectTag=objectTagCreator.create(object, metadata);
				TagUtil.addChildTag(objects, objectTag, objectKey, true);
				objects.setRuntimeObject(object, objectTag);
			}
			return objectTag;
		}
	}
	
	private void fillGaugeData(Gauge gauge, Tag eventTag) {

		JBehavior behavior=(JBehavior)gauge.getAttribute(Gauge.AttributeName.BEHAVIOR);
		if(behavior!=null) {
			Tag behaviorTag=metadata.getMember(behavior);
			eventTag.getTags().put(Gauge.AttributeName.BEHAVIOR.getName(), behaviorTag);
		}
		
		JBehavior targetBehavior=(JBehavior)gauge.getAttribute(Gauge.AttributeName.TARGET_BEHAVIOR);
		if(targetBehavior!=null) {
			Tag targetBehaviorTag=metadata.getMember(targetBehavior);
			eventTag.getTags().put(Gauge.AttributeName.TARGET_BEHAVIOR.getName(), targetBehaviorTag);
		}

		JClass targetClass=(JClass)gauge.getAttribute(Gauge.AttributeName.TARGET_CLASS);
		if(targetClass!=null) {
			Tag targetClassTag=metadata.getClass(targetClass);
			eventTag.getTags().put(Gauge.AttributeName.TARGET_CLASS.getName(), targetClassTag);
		}
		
		JField targetField=(JField)gauge.getAttribute(Gauge.AttributeName.TARGET_FIELD);
		if(targetField!=null) {
			Tag targetFieldTag=metadata.getMember(targetField);
			eventTag.getTags().put(Gauge.AttributeName.TARGET_FIELD.getName(), targetFieldTag);
		}
	}
	/**
	 * Appends data to an existing event tag
	 * @param event
	 * @param current
	 */
	private void appendEventData(Event event, Tag eventTag) {
		eventTag.setProperty(TraceGeneratorConstants.EXIT_EVENT_TYPE_PARAMETER_NAME, event.getGague().getType().getName());
		fillEventData(event, eventTag, false);
	}
	
	/**
	 * Returns the current event tag of the current thread
	 * @return
	 */
	private Tag getCurrent() {
		synchronized(currents) {
			Thread thread=Thread.currentThread();
			Tag current=currents.get(thread);
			if(current==null) {
				Tag threadTag=TagUtil.createInCollection(threads, true);
				threadTag.setProperty(TraceGeneratorConstants.THREADS_NAME_PARAMETER, thread.getName());
				threadTag.setProperty(TraceGeneratorConstants.THREADS_ID_PARAMETER, Long.toString(thread.getId()));
				threads.setRuntimeObject(thread, threadTag);
				current=threadTag;
				currents.put(thread, current);
			}
			return current;
		}
	}
	
	/**
	 * Sets the current event tag of the current thread
	 */
	private void setCurrent(Tag current) {
		Thread thread=Thread.currentThread();
		currents.put(thread, current);
	}

}	