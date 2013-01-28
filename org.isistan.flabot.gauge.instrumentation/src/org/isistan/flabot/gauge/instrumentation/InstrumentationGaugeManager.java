package org.isistan.flabot.gauge.instrumentation;

import java.util.Iterator;
import java.util.Map;

import org.isistan.flabot.gauge.Event;
import org.isistan.flabot.gauge.GaugeFilter;
import org.isistan.flabot.gauge.Gauge;
import org.isistan.flabot.gauge.GaugeConsumer;
import org.isistan.flabot.gauge.GaugeManager;
import org.isistan.flabot.gauge.Event.AttributeName;
import org.isistan.flabot.gauge.instrumentation.StrategyInstrumentor.GaugeConsumerFilterResult;
import org.isistan.flabot.gauge.instrumentation.runtime.ExecutionStackPool;
import org.isistan.flabot.gauge.instrumentation.runtime.NotifyingState;
import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JPackage;
import org.isistan.flabot.util.TriState;

public class InstrumentationGaugeManager extends GaugeManager {

	private GaugeConsumer[] definitiveGaugeConsumers=null;
	private GaugeConsumerFilterResult gaugeConsumers;
	private JPackage jPackage;
	private JClass jClass;
	private JBehavior jBehavior;
	private boolean isPrimitiveValueType;
	private boolean[] arePrimitiveParameterTypes;
	
	/**
	 * Creates a gauge manager for the given gauge that notifies given gaugeConsumers
	 * @param gauge
	 * @param isPrimitiveParameterTypes 
	 * @param isPrimitiveValueType 
	 * @param gaugeFilteredGaugeConsumers 
	 * @param behaviorFilteredGaugeConsumers 
	 * @param packageFilteredGaugeConsumers 
	 */
	InstrumentationGaugeManager(Gauge gauge, GaugeConsumerFilterResult gaugeConsumers,
			JPackage jPackage, JClass jClass, JBehavior jBehavior, boolean isPrimitiveValueType, boolean[] arePrimitiveParameterTypes) {
		super(gauge);
		this.gaugeConsumers=gaugeConsumers;
		this.jPackage=jPackage;
		this.jClass=jClass;
		this.jBehavior=jBehavior;
		this.isPrimitiveValueType=isPrimitiveValueType;
		this.arePrimitiveParameterTypes=arePrimitiveParameterTypes;
	}
	
	@Override
	public synchronized GaugeConsumer[] getGaugeConsumers() {
		if(definitiveGaugeConsumers!=null) {
			return definitiveGaugeConsumers;
		}
		
		return filterGaugeConsumers();
	}

	private GaugeConsumer[] filterGaugeConsumers() {
		if(gaugeConsumers.allConfirmed()) {
			definitiveGaugeConsumers=gaugeConsumers.getConfirmed().toArray(new GaugeConsumer[gaugeConsumers.getConfirmed().size()]);
			return definitiveGaugeConsumers;
		}
		
		for (Iterator<GaugeConsumer> iter = gaugeConsumers.getPossible().iterator(); iter.hasNext();) {
			GaugeConsumer possibleGaugeConsumer = iter.next();
			TriState isGC=isGaugeConsumer(possibleGaugeConsumer);
			if(isGC==TriState.TRUE) {
				iter.remove();
				gaugeConsumers.getConfirmed().add(possibleGaugeConsumer);
			} else if(isGC==TriState.FALSE) {
				iter.remove();
			}			
		}
		GaugeConsumer[] gaugeConsumersArray=gaugeConsumers.getConfirmed().toArray(new GaugeConsumer[gaugeConsumers.getConfirmed().size()]);
		if(gaugeConsumers.allConfirmed()) {
			definitiveGaugeConsumers=gaugeConsumersArray;
		}
		if(gaugeConsumers.isEmpty()) {
			dispose();
		}

		return gaugeConsumersArray;
	}

	private TriState isGaugeConsumer(GaugeConsumer possibleGaugeConsumer) {
		try {
			GaugeFilter filter = possibleGaugeConsumer.getFilter();
			//gauge passes?
			if(filter.passes(getGauge())) {
				TriState passes=filter.passes(jPackage);
				if(passes==TriState.UNDEFINED) {
					passes=filter.passes(jClass);
					if(passes==TriState.UNDEFINED) {
						//behavior passes?
						return TriState.fromBoolean(filter.passes(jBehavior));
					} else { //definitive class TRUE or FALSE
						return passes;
					}
				} else { //definitive package TRUE or FALSE
					return passes;
				}
			} else { //not interesting gauge
				return TriState.FALSE;
			}
		} catch (ClassCircularityError e) {
			return TriState.UNDEFINED;
		}
	}

	@Override
	public Event createEvent(long timeStamp, long executionId, Map<AttributeName, Object> attributes) {
		return new InstrumentationEvent(timeStamp, executionId, this.getGauge(), attributes);
	}
	
	
	/**
	 * Creates a On Behavior Entry Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void onBehaviorEntry(Object instance, Object[] arguments) {
		if(!isEnabled()) return;
		onBehaviorEntry(
				JavaModelCreator.createObject(instance),
				JavaModelCreator.createArray(arePrimitiveParameterTypes, arguments),
				ExecutionStackPool.getExecutionStack().peek());			
	}

	/**
	 * Creates an On Behavior Exit Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void onBehaviorExit(Object instance, Object[] arguments, Object value) {
		if(!isEnabled()) return;
		onBehaviorExit(
				JavaModelCreator.createObject(instance),
				JavaModelCreator.createArray(arePrimitiveParameterTypes, arguments),
				JavaModelCreator.create(isPrimitiveValueType, value),
				ExecutionStackPool.getExecutionStack().peek());	
	}

	/**
	 * Creates an On Behavior Error Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void onBehaviorError(Object instance, Object[] arguments, Throwable thrown) {
		if(!isEnabled()) return;
		onBehaviorError(
				JavaModelCreator.createObject(instance),
				JavaModelCreator.createArray(arePrimitiveParameterTypes, arguments),
				JavaModelCreator.createThrowable(thrown),
				ExecutionStackPool.getExecutionStack().peek());	
	}	
	/**
	 * Creates a Before Cast Event with the given arguments and notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void beforeCast(Object instance, Object targetInstance) {
		if(!isEnabled()) return;
		beforeCast(
				JavaModelCreator.createObject(instance),
				JavaModelCreator.createObject(targetInstance),
				ExecutionStackPool.getExecutionStack().peek());			
	}

	/**
	 * Creates an After Cast Event with the given arguments and notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void afterCast(Object instance, Object targetInstance) {
		if(!isEnabled()) return;
		afterCast(
				JavaModelCreator.createObject(instance),
				JavaModelCreator.createObject(targetInstance),
				ExecutionStackPool.getExecutionStack().peek());				
	}


	/**
	 * Creates an On Cast Error Event with the given arguments and notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void onCastError(Object instance, Object targetInstance, Throwable thrown) {
		if(!isEnabled()) return;
		onCastError(
				JavaModelCreator.createObject(instance),
				JavaModelCreator.createObject(targetInstance),
				JavaModelCreator.createThrowable(thrown),
				ExecutionStackPool.getExecutionStack().peek());		
	}


	/**
	 * Creates a Before Constructor Call Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void beforeConstructorCall(Object[] arguments) {
		if(!isEnabled()) return;
		beforeConstructorCall(
				JavaModelCreator.createArray(arePrimitiveParameterTypes, arguments),
				ExecutionStackPool.getExecutionStack().peek());			
	}

	/**
	 * Creates an After Constructor Call Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void afterConstructorCall(Object instance, Object[] arguments) {
		if(!isEnabled()) return;
		afterConstructorCall(
				JavaModelCreator.createObject(instance),
				JavaModelCreator.createArray(arePrimitiveParameterTypes, arguments),
				ExecutionStackPool.getExecutionStack().peek());		
	}

	/**
	 * Creates an On Field Read Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void onFieldRead(Object instance, Object targetInstance, Object value) {
		if(!isEnabled()) return;
		onFieldRead(
				JavaModelCreator.createObject(instance),
				JavaModelCreator.createObject(targetInstance),
				JavaModelCreator.create(isPrimitiveValueType, value),
				ExecutionStackPool.getExecutionStack().peek());		
	}
	

	/**
	 * Creates an On Field Write Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void onFieldWrite(Object instance, Object targetInstance, Object value, Object oldValue) {
		if(!isEnabled()) return;
		onFieldWrite(
				JavaModelCreator.createObject(instance),
				JavaModelCreator.createObject(targetInstance),
				JavaModelCreator.create(isPrimitiveValueType, value),		
				JavaModelCreator.create(isPrimitiveValueType, oldValue),
				ExecutionStackPool.getExecutionStack().peek());
	}
	

	/**
	 * Creates an On Catch Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void onCatch(Object instance, Throwable thrown) {
		if(!isEnabled()) return;
		onCatch(
				JavaModelCreator.createObject(instance),
				JavaModelCreator.createThrowable(thrown),
				ExecutionStackPool.getExecutionStack().peek());		
	}
	
	/**
	 * Creates an On instanceof Check Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void onInstanceofCheck(Object instance, Object targetInstance, boolean value) {
		if(!isEnabled()) return;
		onInstanceofCheck(
				JavaModelCreator.createObject(instance),
				JavaModelCreator.createObject(targetInstance),
				JavaModelCreator.create(value),
				ExecutionStackPool.getExecutionStack().peek());
	}

	/**
	 * Creates a Before Method Call Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void beforeMethodCall(Object instance, Object targetInstance, Object[] arguments) {
		if(!isEnabled()) return;
		beforeMethodCall(
				JavaModelCreator.createObject(instance),
				JavaModelCreator.createObject(targetInstance),
				JavaModelCreator.createArray(arePrimitiveParameterTypes, arguments),
				ExecutionStackPool.getExecutionStack().peek());
	}

	/**
	 * Creates an After Method Call Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void afterMethodCall(Object instance, Object targetInstance, Object[] arguments, Object value) {
		if(!isEnabled()) return;
		afterMethodCall(
				JavaModelCreator.createObject(instance),
				JavaModelCreator.createObject(targetInstance),
				JavaModelCreator.createArray(arePrimitiveParameterTypes, arguments),
				JavaModelCreator.create(isPrimitiveValueType, value),
				ExecutionStackPool.getExecutionStack().peek());
	}

	/**
	 * Creates an On Method Call Error Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void onMethodCallError(Object instance, Object targetInstance, Object[] arguments, Throwable thrown) {
		if(!isEnabled()) return;
		onMethodCallError(
				JavaModelCreator.createObject(instance),
				JavaModelCreator.createObject(targetInstance),
				JavaModelCreator.createArray(arePrimitiveParameterTypes, arguments),
				JavaModelCreator.createThrowable(thrown),
				ExecutionStackPool.getExecutionStack().peek());
	}

	
	/**
	 * Creates a Before Array Creation Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void beforeArrayCreation(Object instance, Object[] arguments) {
		if(!isEnabled()) return;
		beforeArrayCreation(
				JavaModelCreator.createObject(instance),
				JavaModelCreator.createArrayArguments(arguments),
				ExecutionStackPool.getExecutionStack().peek());					
	}

	/**
	 * Creates an After Array Creation Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void afterArrayCreation(Object instance, Object[] arguments, Object value) {
		if(!isEnabled()) return;
		afterArrayCreation(
				JavaModelCreator.createObject(instance),
				JavaModelCreator.createArrayArguments(arguments),
				JavaModelCreator.createObject(value),
				ExecutionStackPool.getExecutionStack().peek());		
	}

	/**
	 * Creates an On Array Creation Error Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void onArrayCreationError(Object instance, Object[] arguments, Throwable thrown) {
		if(!isEnabled()) return;
		onArrayCreationError(
				JavaModelCreator.createObject(instance),
				JavaModelCreator.createArrayArguments(arguments),
				JavaModelCreator.createThrowable(thrown),
				ExecutionStackPool.getExecutionStack().peek());	
	}
	
	/**
	 * Creates a Before Creation Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void beforeCreation(Object instance, Object[] arguments) {
		if(!isEnabled()) return;
		beforeCreation(
				JavaModelCreator.createObject(instance),
				JavaModelCreator.createArray(arePrimitiveParameterTypes, arguments),
				ExecutionStackPool.getExecutionStack().peek());		
	}

	/**
	 * Creates an After Creation Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void afterCreation(Object instance, Object[] arguments, Object value) {
		if(!isEnabled()) return;
		afterCreation(
				JavaModelCreator.createObject(instance),
				JavaModelCreator.createArray(arePrimitiveParameterTypes, arguments),
				JavaModelCreator.createObject(value),
				ExecutionStackPool.getExecutionStack().peek());
	}

	/**
	 * Creates an On Creation Error Event with the given arguments and
	 * notifies it
	 * @param instance
	 * @param targetInstance
	 */
	public void onCreationError(Object instance, Object[] arguments, Throwable thrown) {
		if(!isEnabled()) return;
		onCreationError(
				JavaModelCreator.createObject(instance),
				JavaModelCreator.createArray(arePrimitiveParameterTypes, arguments),
				JavaModelCreator.createThrowable(thrown),
				ExecutionStackPool.getExecutionStack().peek());
	}
	
	
	/**
	 * Reports the event to all registered Gauge Consumers,
	 * but first checks if this notification was caused by another
	 * and if so it is not actually notified 
	 * @param event
	 */
	@Override
	protected void notify(Event event) {
		if(!NotifyingState.setNotifying(true))
			return;
		super.notify(event);
		
		NotifyingState.setNotifying(false);
	}
}
