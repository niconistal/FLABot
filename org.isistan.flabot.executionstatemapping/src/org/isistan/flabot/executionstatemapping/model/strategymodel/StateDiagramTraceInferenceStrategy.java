/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.strategymodel;

import org.isistan.flabot.engine.executionstate.PrologProviderStrategy;
import org.isistan.flabot.engine.executionstate.TraceInferenceStrategy;
import org.isistan.flabot.executionstatemapping.model.semantic.StateContainer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Condition Trace Based State Determination Strategy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.strategymodel.StateDiagramTraceInferenceStrategy#getStateContainer <em>State Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.StrategymodelPackage#getStateDiagramTraceInferenceStrategy()
 * @model
 * @generated
 */
public interface StateDiagramTraceInferenceStrategy extends TraceInferenceStrategy, PrologProviderStrategy {
	/**
	 * Returns the value of the '<em><b>State Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Container</em>' reference.
	 * @see #setStateContainer(StateContainer)
	 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.StrategymodelPackage#getStateDiagramTraceInferenceStrategy_StateContainer()
	 * @model
	 * @generated
	 */
	StateContainer getStateContainer();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.strategymodel.StateDiagramTraceInferenceStrategy#getStateContainer <em>State Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Container</em>' reference.
	 * @see #getStateContainer()
	 * @generated
	 */
	void setStateContainer(StateContainer value);
	
	void resetProlog();

} // ExecutionConditionTraceBasedStateDeterminationStrategy
