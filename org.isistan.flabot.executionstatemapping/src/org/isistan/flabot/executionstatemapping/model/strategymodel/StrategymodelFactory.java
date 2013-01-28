/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.strategymodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.StrategymodelPackage
 * @generated
 */
public interface StrategymodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StrategymodelFactory eINSTANCE = org.isistan.flabot.executionstatemapping.model.strategymodel.impl.StrategymodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>State Diagram Trace Inference Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Diagram Trace Inference Strategy</em>'.
	 * @generated
	 */
	StateDiagramTraceInferenceStrategy createStateDiagramTraceInferenceStrategy();

	/**
	 * Returns a new object of class '<em>Simple Execution Condition Trace Inference Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Execution Condition Trace Inference Strategy</em>'.
	 * @generated
	 */
	SimpleExecutionConditionTraceInferenceStrategy createSimpleExecutionConditionTraceInferenceStrategy();

	/**
	 * Returns a new object of class '<em>Execution Condition General Log Filter Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Condition General Log Filter Strategy</em>'.
	 * @generated
	 */
	ExecutionConditionGeneralLogFilterStrategy createExecutionConditionGeneralLogFilterStrategy();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StrategymodelPackage getStrategymodelPackage();

} //StrategymodelFactory
