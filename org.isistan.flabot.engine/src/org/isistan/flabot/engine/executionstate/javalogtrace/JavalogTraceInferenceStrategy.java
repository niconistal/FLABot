/**
 * 
 */
package org.isistan.flabot.engine.executionstate.javalogtrace;

import org.isistan.flabot.engine.executionstate.TraceInferenceStrategy;

/**
 * Trace inference strategy that uses javalog to analyze the trace log
 * 
 * @author mblech
 * @model
 */
public interface JavalogTraceInferenceStrategy extends TraceInferenceStrategy{

	/**
	 * The prolog code used by this javalog trace inference strategy
	 * @model default="executionState('Faulty') :- executionTag(T), isExitError(T). executionState('Executed') :- executionTag(_). executionState('NotExecuted')."
	 */
	String getPrologCode();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.engine.executionstate.javalogtrace.JavalogTraceInferenceStrategy#getPrologCode <em>Prolog Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prolog Code</em>' attribute.
	 * @see #getPrologCode()
	 * @generated
	 */
	void setPrologCode(String value);

}
