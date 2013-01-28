/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExecutionstateFactory.java,v 1.7 2006/07/04 12:42:19 mblech Exp $
 */
package org.isistan.flabot.engine.executionstate;


import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.engine.executionstate.ExecutionstatePackage
 * @generated
 */
public interface ExecutionstateFactory extends EFactory{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExecutionstateFactory eINSTANCE = new org.isistan.flabot.engine.executionstate.impl.ExecutionstateFactoryImpl();

	/**
	 * Returns a new object of class '<em>State Determination Strategy Registry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Determination Strategy Registry</em>'.
	 * @generated
	 */
	StateDeterminationStrategyRegistry createStateDeterminationStrategyRegistry();

	/**
	 * Returns a new object of class '<em>Manual State Determination Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Manual State Determination Strategy</em>'.
	 * @generated
	 */
	ManualStateDeterminationStrategy createManualStateDeterminationStrategy();

	/**
	 * Returns a new object of class '<em>Trace Based State Determination Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace Based State Determination Strategy</em>'.
	 * @generated
	 */
	TraceBasedStateDeterminationStrategy createTraceBasedStateDeterminationStrategy();

	/**
	 * Returns a new object of class '<em>State From Mapping State Determination Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State From Mapping State Determination Strategy</em>'.
	 * @generated
	 */
	StateFromMappingStateDeterminationStrategy createStateFromMappingStateDeterminationStrategy();

	/**
	 * Returns a new object of class '<em>Or Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or Filter</em>'.
	 * @generated
	 */
	OrFilter createOrFilter();

	/**
	 * Returns a new object of class '<em>Simple Prolog Provider Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Prolog Provider Strategy</em>'.
	 * @generated
	 */
	SimplePrologProviderStrategy createSimplePrologProviderStrategy();

	/**
	 * Returns a new object of class '<em>Simple General Log Filter Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple General Log Filter Strategy</em>'.
	 * @generated
	 */
	SimpleGeneralLogFilterStrategy createSimpleGeneralLogFilterStrategy();

	/**
	 * Returns a new object of class '<em>Manual Trace Inference Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Manual Trace Inference Strategy</em>'.
	 * @generated
	 */
	ManualTraceInferenceStrategy createManualTraceInferenceStrategy();

	/**
	 * Returns a new object of class '<em>Simple Trace Inference Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Trace Inference Strategy</em>'.
	 * @generated
	 */
	SimpleTraceInferenceStrategy createSimpleTraceInferenceStrategy();

	/**
	 * Returns a new object of class '<em>Diagnostic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Diagnostic</em>'.
	 * @generated
	 */
	Diagnostic createDiagnostic();

	/**
	 * Returns a new object of class '<em>Basic Mapping Based Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Basic Mapping Based Filter</em>'.
	 * @generated
	 */
	BasicMappingBasedFilter createBasicMappingBasedFilter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExecutionstatePackage getExecutionstatePackage();

} //ExecutionstateFactory
