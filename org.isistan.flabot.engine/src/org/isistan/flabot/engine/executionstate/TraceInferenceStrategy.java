/**
 * $Id: TraceInferenceStrategy.java,v 1.4 2006/03/15 02:37:00 mblech Exp $
 * $Author: mblech $
 */
package org.isistan.flabot.engine.executionstate;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.mapping.mappingmodel.Mapping;

/**
 * A trace inference strategy determines the execution state of a
 * responsibility node using the trace log provided by its associated
 * TraceBasedStateDeterminationStrategy.
 * @author $Author: mblech $
 * @model abstract="true"
 */
public interface TraceInferenceStrategy extends EObject {

	/**
	 * Infer the execution state of the given responsibility node using
	 * the log provided by the LogBasedStateDeterminationStrategy
	 * @param node the node whose execution state must be determined
	 * @param engineContext the engine's context parameters
	 * @return the inferred execution state and diagnostic for the given node
	 * @throws TraceLogManagerException when there's an error trying to find the current log
	 * @throws StateDeterminationException when an internal error occurs
	 */
	Diagnostic getState(ResponsibilityNode node, Map engineContext) throws TraceLogManagerException, StateDeterminationException;
	
	/**
	 * Get this TraceInferenceStrategy's associated
	 * TraceBasedDeterminationStrategy
	 * @return
	 * @model opposite="traceInferenceStrategy"
	 */
	TraceBasedStateDeterminationStrategy getStateDeterminationStrategy();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.engine.executionstate.TraceInferenceStrategy#getStateDeterminationStrategy <em>State Determination Strategy</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Determination Strategy</em>' container reference.
	 * @see #getStateDeterminationStrategy()
	 * @generated
	 */
	void setStateDeterminationStrategy(TraceBasedStateDeterminationStrategy value);

	
	void checkMapping(Responsibility responsibility);
	
	void checkFilter(Responsibility responsibility);
}
