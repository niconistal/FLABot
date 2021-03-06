/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.strategymodel;

import org.isistan.flabot.engine.executionstate.GeneralLogFilterStrategy;
import org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Condition General Log Filter Strategy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.strategymodel.ExecutionConditionGeneralLogFilterStrategy#getSimpleExecutionConditionConfiguration <em>Simple Execution Condition Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.StrategymodelPackage#getExecutionConditionGeneralLogFilterStrategy()
 * @model
 * @generated
 */
public interface ExecutionConditionGeneralLogFilterStrategy extends GeneralLogFilterStrategy {
	/**
	 * Returns the value of the '<em><b>Simple Execution Condition Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Execution Condition Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Execution Condition Configuration</em>' containment reference.
	 * @see #setSimpleExecutionConditionConfiguration(SimpleExecutionConditionConfiguration)
	 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.StrategymodelPackage#getExecutionConditionGeneralLogFilterStrategy_SimpleExecutionConditionConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	SimpleExecutionConditionConfiguration getSimpleExecutionConditionConfiguration();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.strategymodel.ExecutionConditionGeneralLogFilterStrategy#getSimpleExecutionConditionConfiguration <em>Simple Execution Condition Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Execution Condition Configuration</em>' containment reference.
	 * @see #getSimpleExecutionConditionConfiguration()
	 * @generated
	 */
	void setSimpleExecutionConditionConfiguration(SimpleExecutionConditionConfiguration value);

} // ExecutionConditionGeneralLogFilterStrategy
