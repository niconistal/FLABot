/**
 * 
 */
package org.isistan.flabot.engine.executionstate.javalogtrace.correlatorbuilder;

import java.util.LinkedList;
import java.util.List;

import org.isistan.flabot.engine.executionstate.correlation.AndCompositeCorrelator;
import org.isistan.flabot.engine.executionstate.correlation.CallStackDistanceCorrelator;
import org.isistan.flabot.engine.executionstate.correlation.Correlator;
import org.isistan.flabot.engine.executionstate.correlation.LastExecutionCorrelator;
import org.isistan.flabot.engine.executionstate.correlation.SameInstanceCorrelator;
import org.isistan.flabot.engine.executionstate.correlation.SameThreadCorrelator;
import org.isistan.flabot.engine.executionstate.correlation.TimestampDeltaCorrelator;

import JavaLog.PlList;
import JavaLog.PlNumber;

/**
 * Default implementation of JavalogCorrelatorBuilder
 * @author mblech
 *
 */
public class DefaultJavalogCorrelatorBuilder implements
		JavalogCorrelatorBuilder {

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.javalogtrace.correlatorbuilder.JavalogCorrelatorBuilder#buildCorrelator(JavaLog.PlList)
	 */
	public Correlator buildCorrelator(PlList descriptor) {
		if (descriptor == null)
			throw new IllegalArgumentException("Descriptor PlList can't be null");
		if (descriptor.length() == 0)
			throw new IllegalArgumentException("Descriptor PlList can't be empty");
		// extract id and parameters (head and tail)
		String correlatorId = descriptor.car().toString();
		PlList parameters = (PlList) descriptor.cdr();
		// use the id to build the correct correlator
		if (correlatorId.equals(AND_COMPOSITE)) {
			return buildAnd(parameters);
		}
		else if (correlatorId.equals(TIMESTAMP_DELTA)) {
			return buildTimestampDelta(parameters);
		}
		else if (correlatorId.equals(SAME_THREAD)) {
			return buildSameThread(parameters);
		}
		else if (correlatorId.equals(CALL_STACK_DISTANCE)) {
			return buildCallStackDistance(parameters);
		}
		else if (correlatorId.equals(SAME_INSTANCE)) {
			return buildSameInstance(parameters);
		}
		else if (correlatorId.equals(LAST_EXECUTION)) {
			return buildLastExecution(parameters);
		}
		// the id wasn't in the if-else-if chain, then it's a wrong id
		throw new IllegalArgumentException("Wrong correlatorId: " + correlatorId);
	}

	private Correlator buildLastExecution(PlList parameters) {
		if (!parameters.isEmpty())
			throw new IllegalArgumentException("LastExecutionCorrelator doesn't take parameters: " + parameters);
		LastExecutionCorrelator correlator = new LastExecutionCorrelator();
		return correlator;
	}

	private Correlator buildSameInstance(PlList parameters) {
		if (!parameters.isEmpty())
			throw new IllegalArgumentException("SameInstanceCorrelator doesn't take parameters: " + parameters);
		SameInstanceCorrelator correlator = new SameInstanceCorrelator();
		return correlator;
	}

	private Correlator buildCallStackDistance(PlList parameters) {
		if (parameters.length() != 2)
			throw new IllegalArgumentException("Wrong number of parameters for CallStackDistanceCorrelator: " + parameters);
		int min = ((PlNumber) parameters.car()).intValue();
		parameters = (PlList) parameters.cdr();
		int max = ((PlNumber) parameters.car()).intValue();
		CallStackDistanceCorrelator correlator = new CallStackDistanceCorrelator(min, max);
		return correlator;
	}

	/**
	 * Build a same thread correlator
	 * @param parameters
	 * @return
	 */
	private Correlator buildSameThread(PlList parameters) {
		if (!parameters.isEmpty())
			throw new IllegalArgumentException("SameThreadCorrelator doesn't take parameters: " + parameters);
		SameThreadCorrelator correlator = new SameThreadCorrelator();
		return correlator;
	}

	/**
	 * Build a timestamp delta correlator
	 * @param parameters
	 * @return
	 */
	private Correlator buildTimestampDelta(PlList parameters) {
		if (parameters.length() != 2)
			throw new IllegalArgumentException("Wrong number of parameters for TimestamDeltaCorrelator: " + parameters);
		long minDt = (long) ((PlNumber) parameters.car()).intValue();
		parameters = (PlList) parameters.cdr();
		long maxDt = (long) ((PlNumber) parameters.car()).intValue();
		TimestampDeltaCorrelator correlator = new TimestampDeltaCorrelator(minDt, maxDt);
		return correlator;
	}

	/**
	 * Build an AND composite correlator
	 * @param parameters
	 * @return
	 */
	private Correlator buildAnd(PlList parameters) {
		List<Correlator> composedCorrelators = new LinkedList<Correlator>();
		while (!parameters.isEmpty()) {
			PlList descriptor = (PlList) parameters.car();
			Correlator composedCorrelator = buildCorrelator(descriptor);
			composedCorrelators.add(composedCorrelator);
			parameters = (PlList) parameters.cdr();
		}
		AndCompositeCorrelator correlator =
			new AndCompositeCorrelator(composedCorrelators);
		return correlator;
	}

}
