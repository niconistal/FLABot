/**

import java.util.HashMap;
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
	private Gauge gauge;
	

	/**
	 * Creates a gauge manager for the given gauge
	 * @param gauge
	 */
	public GaugeManager(Gauge gauge) {
		this.gauge=gauge;
	}

	/**
	 * Creates a On Behavior Entry Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void onBehaviorEntry(JObject instance, JObject[] arguments, long executionId) {
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
	public void onBehaviorExit(JObject instance, JObject[] arguments, JObject value, long executionId) {
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
	public void onBehaviorError(JObject instance, JObject[] arguments, JThrowable thrown, long executionId) {
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
		if(!enabled) return;
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
		if(!enabled) return;
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
		if(!enabled) return;
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
		if(!enabled) return;
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
		if(!enabled) return;
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
		if(!enabled) return;
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
		if(!enabled) return;
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
		if(!enabled) return;
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
		if(!enabled) return;
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
		if(!enabled) return;
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
		if(!enabled) return;
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
		if(!enabled) return;
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
		if(!enabled) return;
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
		if(!enabled) return;
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
		if(!enabled) return;
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
		if(!enabled) return;
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
		if(!enabled) return;
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
		if(!enabled) return;
		attributes.put(Event.AttributeName.INSTANCE, instance);
		attributes.put(Event.AttributeName.ARGUMENTS, arguments);
		attributes.put(Event.AttributeName.THROWN, thrown);
		notify(createEvent(attributes, executionId));			
	}

	/**

	/**
	 * Reports the event to all registered Gauge Consumers 
	 * @param event
	 */
	protected void notify(Event event) {
		for(int i=0; i<gaugeConsumers.length; i++) {
			try {
				gaugeConsumer.report(event);
			} catch (Throwable e) {
				System.out.println(e.getClass().getName() + ": Gauge consumer report error :" + e.getMessage());
				e.printStackTrace();
			}	
		}
