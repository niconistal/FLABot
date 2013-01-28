/** * $Id: GaugeManager.java,v 1.9 2006/03/08 00:21:07 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.gauge;

import java.util.HashMap;import java.util.Map;import org.isistan.flabot.javamodel.JBooleanPrimitive;import org.isistan.flabot.javamodel.JIntPrimitive;import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.JThrowable;/**
 * This class is notified via method calls inserted in the bytecode
 * and builds Events that are notified to all interested gauge consumers.
 * It is accesed from arbitrary code using the Gague manager pool, with the
 * and id inserted into the bytecode.
 * @author $Author: dacostae $
 *
 */
public abstract class GaugeManager {
	/**
	 * Gauge this gauge manager is for
	 */
	private Gauge gauge;		/**	 * True if this gauge manager is enabled	 */	private boolean enabled=true;		/**	 * True if this gauge manager is disabled	 */	private boolean disposed=false;
	

	/**
	 * Creates a gauge manager for the given gauge
	 * @param gauge
	 */
	public GaugeManager(Gauge gauge) {
		this.gauge=gauge;
	}
	/**	 * Returns the gauge	 * @return	 */	public Gauge getGauge() {		return gauge;	}		/**	 * Obtains the gauge consumers this manager should notify	 */	public abstract GaugeConsumer[] getGaugeConsumers();	
	/**
	 * Creates a On Behavior Entry Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void onBehaviorEntry(JObject instance, JObject[] arguments, long executionId) {		if(!enabled) return;		Map<Event.AttributeName, Object> attributes=new HashMap<Event.AttributeName, Object>();
		attributes.put(Event.AttributeName.INSTANCE, instance);
		attributes.put(Event.AttributeName.ARGUMENTS, arguments);
		notify(createEvent(attributes, executionId));			
	}

	/**
	 * Creates an On Behavior Exit Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void onBehaviorExit(JObject instance, JObject[] arguments, JObject value, long executionId) {		if(!enabled) return;		Map<Event.AttributeName, Object> attributes=new HashMap<Event.AttributeName, Object>();
		attributes.put(Event.AttributeName.INSTANCE, instance);
		attributes.put(Event.AttributeName.ARGUMENTS, arguments);
		attributes.put(Event.AttributeName.VALUE, value);
		notify(createEvent(attributes, executionId));			
	}

	/**
	 * Creates an On Behavior Error Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void onBehaviorError(JObject instance, JObject[] arguments, JThrowable thrown, long executionId) {		if(!enabled) return;		Map<Event.AttributeName, Object> attributes=new HashMap<Event.AttributeName, Object>();
		attributes.put(Event.AttributeName.INSTANCE, instance);
		attributes.put(Event.AttributeName.ARGUMENTS, arguments);
		attributes.put(Event.AttributeName.THROWN, thrown);
		notify(createEvent(attributes, executionId));			
	}	
	/**
	 * Creates a Before Cast Event with the given arguments and notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void beforeCast(JObject instance, JObject targetInstance, long executionId) {
		if(!enabled) return;		Map<Event.AttributeName, Object> attributes=new HashMap<Event.AttributeName, Object>();
		attributes.put(Event.AttributeName.INSTANCE, instance);
		attributes.put(Event.AttributeName.TARGET_INSTANCE, targetInstance);
		notify(createEvent(attributes, executionId));			
	}

	/**
	 * Creates an After Cast Event with the given arguments and notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void afterCast(JObject instance, JObject targetInstance, long executionId) {
		if(!enabled) return;		Map<Event.AttributeName, Object> attributes=new HashMap<Event.AttributeName, Object>();
		attributes.put(Event.AttributeName.INSTANCE, instance);
		attributes.put(Event.AttributeName.TARGET_INSTANCE, targetInstance);
		notify(createEvent(attributes, executionId));			
	}


	/**
	 * Creates an On Cast Error Event with the given arguments and notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void onCastError(JObject instance, JObject targetInstance, JThrowable thrown, long executionId) {
		if(!enabled) return;		Map<Event.AttributeName, Object> attributes=new HashMap<Event.AttributeName, Object>();
		attributes.put(Event.AttributeName.INSTANCE, instance);
		attributes.put(Event.AttributeName.TARGET_INSTANCE, targetInstance);
		attributes.put(Event.AttributeName.THROWN, thrown);
		notify(createEvent(attributes, executionId));			
	}


	/**
	 * Creates a Before Constructor Call Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void beforeConstructorCall(JObject[] arguments, long executionId) {
		if(!enabled) return;		Map<Event.AttributeName, Object> attributes=new HashMap<Event.AttributeName, Object>();
		attributes.put(Event.AttributeName.ARGUMENTS, arguments);
		notify(createEvent(attributes, executionId));			
	}

	/**
	 * Creates an After Constructor Call Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void afterConstructorCall(JObject instance, JObject[] arguments, long executionId) {
		if(!enabled) return;		Map<Event.AttributeName, Object> attributes=new HashMap<Event.AttributeName, Object>();
		attributes.put(Event.AttributeName.INSTANCE, instance);
		attributes.put(Event.AttributeName.ARGUMENTS, arguments);
		notify(createEvent(attributes, executionId));			
	}

	/**
	 * Creates an On Field Read Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void onFieldRead(JObject instance, JObject targetInstance, JObject value, long executionId) {
		if(!enabled) return;		Map<Event.AttributeName, Object> attributes=new HashMap<Event.AttributeName, Object>();
		attributes.put(Event.AttributeName.INSTANCE, instance);
		attributes.put(Event.AttributeName.TARGET_INSTANCE, targetInstance);
		attributes.put(Event.AttributeName.VALUE, value);
		notify(createEvent(attributes, executionId));			
	}
	

	/**
	 * Creates an On Field Write Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void onFieldWrite(JObject instance, JObject targetInstance, JObject value, JObject oldValue, long executionId) {
		if(!enabled) return;		Map<Event.AttributeName, Object> attributes=new HashMap<Event.AttributeName, Object>();
		attributes.put(Event.AttributeName.INSTANCE, instance);
		attributes.put(Event.AttributeName.TARGET_INSTANCE, targetInstance);
		attributes.put(Event.AttributeName.VALUE, value);
		attributes.put(Event.AttributeName.OLD_VALUE, oldValue);
		notify(createEvent(attributes, executionId));			
	}
	

	/**
	 * Creates an On Catch Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void onCatch(JObject instance, JThrowable thrown, long executionId) {
		if(!enabled) return;		Map<Event.AttributeName, Object> attributes=new HashMap<Event.AttributeName, Object>();
		attributes.put(Event.AttributeName.INSTANCE, instance);
		attributes.put(Event.AttributeName.THROWN, thrown);
		notify(createEvent(attributes, executionId));			
	}
	
	/**
	 * Creates an On instanceof Check Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void onInstanceofCheck(JObject instance, JObject targetInstance, JBooleanPrimitive value, long executionId) {
		if(!enabled) return;		Map<Event.AttributeName, Object> attributes=new HashMap<Event.AttributeName, Object>();
		attributes.put(Event.AttributeName.INSTANCE, instance);
		attributes.put(Event.AttributeName.TARGET_INSTANCE, targetInstance);
		attributes.put(Event.AttributeName.VALUE, value);
		notify(createEvent(attributes, executionId));			
	}

	/**
	 * Creates a Before Method Call Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void beforeMethodCall(JObject instance, JObject targetInstance, JObject[] arguments, long executionId) {
		if(!enabled) return;		Map<Event.AttributeName, Object> attributes=new HashMap<Event.AttributeName, Object>();
		attributes.put(Event.AttributeName.INSTANCE, instance);
		attributes.put(Event.AttributeName.TARGET_INSTANCE, targetInstance);
		attributes.put(Event.AttributeName.ARGUMENTS, arguments);
		notify(createEvent(attributes, executionId));			
	}

	/**
	 * Creates an After Method Call Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void afterMethodCall(JObject instance, JObject targetInstance, JObject[] arguments, JObject value, long executionId) {
		if(!enabled) return;		Map<Event.AttributeName, Object> attributes=new HashMap<Event.AttributeName, Object>();
		attributes.put(Event.AttributeName.INSTANCE, instance);
		attributes.put(Event.AttributeName.TARGET_INSTANCE, targetInstance);
		attributes.put(Event.AttributeName.ARGUMENTS, arguments);
		attributes.put(Event.AttributeName.VALUE, value);
		notify(createEvent(attributes, executionId));			
	}

	/**
	 * Creates an On Method Call Error Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void onMethodCallError(JObject instance, JObject targetInstance, JObject[] arguments, JThrowable thrown, long executionId) {
		if(!enabled) return;		Map<Event.AttributeName, Object> attributes=new HashMap<Event.AttributeName, Object>();
		attributes.put(Event.AttributeName.INSTANCE, instance);
		attributes.put(Event.AttributeName.TARGET_INSTANCE, targetInstance);
		attributes.put(Event.AttributeName.ARGUMENTS, arguments);
		attributes.put(Event.AttributeName.THROWN, thrown);
		notify(createEvent(attributes, executionId));			
	}

	
	/**
	 * Creates a Before Array Creation Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void beforeArrayCreation(JObject instance, JIntPrimitive[] arguments, long executionId) {
		if(!enabled) return;		Map<Event.AttributeName, Object> attributes=new HashMap<Event.AttributeName, Object>();
		attributes.put(Event.AttributeName.INSTANCE, instance);
		attributes.put(Event.AttributeName.ARGUMENTS, arguments);
		notify(createEvent(attributes, executionId));			
	}

	/**
	 * Creates an After Array Creation Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void afterArrayCreation(JObject instance, JIntPrimitive[] arguments, JObject value, long executionId) {
		if(!enabled) return;		Map<Event.AttributeName, Object> attributes=new HashMap<Event.AttributeName, Object>();
		attributes.put(Event.AttributeName.INSTANCE, instance);
		attributes.put(Event.AttributeName.ARGUMENTS, arguments);
		attributes.put(Event.AttributeName.VALUE, value);
		notify(createEvent(attributes, executionId));			
	}

	/**
	 * Creates an On Array Creation Error Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void onArrayCreationError(JObject instance, JIntPrimitive[] arguments, JThrowable thrown, long executionId) {
		if(!enabled) return;		Map<Event.AttributeName, Object> attributes=new HashMap<Event.AttributeName, Object>();
		attributes.put(Event.AttributeName.INSTANCE, instance);
		attributes.put(Event.AttributeName.ARGUMENTS, arguments);
		attributes.put(Event.AttributeName.THROWN, thrown);
		notify(createEvent(attributes, executionId));			
	}
	
	/**
	 * Creates a Before Creation Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void beforeCreation(JObject instance, JObject[] arguments, long executionId) {
		if(!enabled) return;		Map<Event.AttributeName, Object> attributes=new HashMap<Event.AttributeName, Object>();
		attributes.put(Event.AttributeName.INSTANCE, instance);
		attributes.put(Event.AttributeName.ARGUMENTS, arguments);
		notify(createEvent(attributes, executionId));			
	}

	/**
	 * Creates an After Creation Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void afterCreation(JObject instance, JObject[] arguments, JObject value, long executionId) {
		if(!enabled) return;		Map<Event.AttributeName, Object> attributes=new HashMap<Event.AttributeName, Object>();
		attributes.put(Event.AttributeName.INSTANCE, instance);
		attributes.put(Event.AttributeName.ARGUMENTS, arguments);
		attributes.put(Event.AttributeName.VALUE, value);
		notify(createEvent(attributes, executionId));			
	}

	/**
	 * Creates an On Creation Error Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void onCreationError(JObject instance, JObject[] arguments, JThrowable thrown, long executionId) {
		if(!enabled) return;		Map<Event.AttributeName, Object> attributes=new HashMap<Event.AttributeName, Object>();
		attributes.put(Event.AttributeName.INSTANCE, instance);
		attributes.put(Event.AttributeName.ARGUMENTS, arguments);
		attributes.put(Event.AttributeName.THROWN, thrown);
		notify(createEvent(attributes, executionId));			
	}

	/**	 * Calculates Event timestamp and and execution id and creates a new event	 */	private Event createEvent(Map<Event.AttributeName, Object> attributes, long executionId) {		return createEvent(System.currentTimeMillis(), executionId, attributes);	}		/**	 * Generates the event	 */	public abstract Event createEvent(long timeStamp, long executionId, Map<Event.AttributeName, Object> attributes);

	/**
	 * Reports the event to all registered Gauge Consumers 
	 * @param event
	 */
	protected void notify(Event event) {		GaugeConsumer[] gaugeConsumers=getGaugeConsumers();
		for(int i=0; i<gaugeConsumers.length; i++) {			GaugeConsumer gaugeConsumer=gaugeConsumers[i];
			try {
				gaugeConsumer.report(event);
			} catch (Throwable e) {
				System.out.println(e.getClass().getName() + ": Gauge consumer report error :" + e.getMessage());
				e.printStackTrace();
			}	
		}
	}	/**	 * Disables/Enables this GaugeManager	 *	 */	public void setEnabled(boolean enabled) {		if(disposed) {			throw new IllegalStateException("Gauge manager is disposed, cannot change enabled state");		}		this.enabled=enabled;	}		/**	 * Disposes this gauge manager, also sets enabled to false	 *	 */	public void dispose() {		disposed=true;		enabled=false;	}		/**	 * Returns whether this gauge manager is enabled 	 * @return	 */	public boolean isEnabled() {		return enabled;	}		/**	 * Returns whether this gauge manager was disposed 	 * @return	 */	public boolean isDisposed() {		return disposed;	}}
