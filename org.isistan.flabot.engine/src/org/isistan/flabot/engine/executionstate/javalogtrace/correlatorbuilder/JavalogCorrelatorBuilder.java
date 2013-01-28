/**
 * 
 */
package org.isistan.flabot.engine.executionstate.javalogtrace.correlatorbuilder;

import org.isistan.flabot.engine.executionstate.correlation.Correlator;

import JavaLog.PlList;

/**
 * Create a correlator using the given javalog descriptor PlList
 * @author mblech
 *
 */
public interface JavalogCorrelatorBuilder {
	
	public JavalogCorrelatorBuilder INSTANCE = new DefaultJavalogCorrelatorBuilder();
	
	/**
	 * Correlator id constants
	 */
	public static final String AND_COMPOSITE = "and";
	public static final String TIMESTAMP_DELTA = "timestampDelta";
	public static final String SAME_THREAD = "sameThread";
	public static final String CALL_STACK_DISTANCE = "callStackDistance";
	public static final String SAME_INSTANCE = "sameInstance";
	public static final String LAST_EXECUTION = "lastExecution";
	
	/**
	 * Build a correlator using the given descriptor PlList
	 * @param descriptor a PlList containing the correlator type id and
	 * its specific parameters
	 * @return a correlator
	 */
	public Correlator buildCorrelator(PlList descriptor);

}
