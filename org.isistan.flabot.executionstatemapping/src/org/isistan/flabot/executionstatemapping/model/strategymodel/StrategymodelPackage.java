/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.strategymodel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.StrategymodelFactory
 * @model kind="package"
 * @generated
 */
public interface StrategymodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "strategymodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/isistan/flabot/executionstatemapping/strategymodel.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.isistan.flabot.executionstatemapping.model.strategymodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StrategymodelPackage eINSTANCE = org.isistan.flabot.executionstatemapping.model.strategymodel.impl.StrategymodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.strategymodel.impl.StateDiagramTraceInferenceStrategyImpl <em>State Diagram Trace Inference Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.impl.StateDiagramTraceInferenceStrategyImpl
	 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.impl.StrategymodelPackageImpl#getStateDiagramTraceInferenceStrategy()
	 * @generated
	 */
	int STATE_DIAGRAM_TRACE_INFERENCE_STRATEGY = 0;

	/**
	 * The feature id for the '<em><b>State Determination Strategy</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY = ExecutionstatePackage.TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY;

	/**
	 * The feature id for the '<em><b>State Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM_TRACE_INFERENCE_STRATEGY__STATE_CONTAINER = ExecutionstatePackage.TRACE_INFERENCE_STRATEGY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>State Diagram Trace Inference Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM_TRACE_INFERENCE_STRATEGY_FEATURE_COUNT = ExecutionstatePackage.TRACE_INFERENCE_STRATEGY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.strategymodel.impl.SimpleExecutionConditionTraceInferenceStrategyImpl <em>Simple Execution Condition Trace Inference Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.impl.SimpleExecutionConditionTraceInferenceStrategyImpl
	 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.impl.StrategymodelPackageImpl#getSimpleExecutionConditionTraceInferenceStrategy()
	 * @generated
	 */
	int SIMPLE_EXECUTION_CONDITION_TRACE_INFERENCE_STRATEGY = 1;

	/**
	 * The feature id for the '<em><b>State Determination Strategy</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXECUTION_CONDITION_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY = ExecutionstatePackage.TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY;

	/**
	 * The feature id for the '<em><b>Simple Execution Condition Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXECUTION_CONDITION_TRACE_INFERENCE_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION = ExecutionstatePackage.TRACE_INFERENCE_STRATEGY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Execution Condition Trace Inference Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXECUTION_CONDITION_TRACE_INFERENCE_STRATEGY_FEATURE_COUNT = ExecutionstatePackage.TRACE_INFERENCE_STRATEGY_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.strategymodel.impl.ExecutionConditionGeneralLogFilterStrategyImpl <em>Execution Condition General Log Filter Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.impl.ExecutionConditionGeneralLogFilterStrategyImpl
	 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.impl.StrategymodelPackageImpl#getExecutionConditionGeneralLogFilterStrategy()
	 * @generated
	 */
	int EXECUTION_CONDITION_GENERAL_LOG_FILTER_STRATEGY = 2;

	/**
	 * The feature id for the '<em><b>Simple Execution Condition Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONDITION_GENERAL_LOG_FILTER_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION = ExecutionstatePackage.GENERAL_LOG_FILTER_STRATEGY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Execution Condition General Log Filter Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONDITION_GENERAL_LOG_FILTER_STRATEGY_FEATURE_COUNT = ExecutionstatePackage.GENERAL_LOG_FILTER_STRATEGY_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.strategymodel.StateDiagramTraceInferenceStrategy <em>State Diagram Trace Inference Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Diagram Trace Inference Strategy</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.StateDiagramTraceInferenceStrategy
	 * @generated
	 */
	EClass getStateDiagramTraceInferenceStrategy();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionstatemapping.model.strategymodel.StateDiagramTraceInferenceStrategy#getStateContainer <em>State Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State Container</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.StateDiagramTraceInferenceStrategy#getStateContainer()
	 * @see #getStateDiagramTraceInferenceStrategy()
	 * @generated
	 */
	EReference getStateDiagramTraceInferenceStrategy_StateContainer();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.strategymodel.SimpleExecutionConditionTraceInferenceStrategy <em>Simple Execution Condition Trace Inference Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Execution Condition Trace Inference Strategy</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.SimpleExecutionConditionTraceInferenceStrategy
	 * @generated
	 */
	EClass getSimpleExecutionConditionTraceInferenceStrategy();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.executionstatemapping.model.strategymodel.SimpleExecutionConditionTraceInferenceStrategy#getSimpleExecutionConditionConfiguration <em>Simple Execution Condition Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simple Execution Condition Configuration</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.SimpleExecutionConditionTraceInferenceStrategy#getSimpleExecutionConditionConfiguration()
	 * @see #getSimpleExecutionConditionTraceInferenceStrategy()
	 * @generated
	 */
	EReference getSimpleExecutionConditionTraceInferenceStrategy_SimpleExecutionConditionConfiguration();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.strategymodel.ExecutionConditionGeneralLogFilterStrategy <em>Execution Condition General Log Filter Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Condition General Log Filter Strategy</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.ExecutionConditionGeneralLogFilterStrategy
	 * @generated
	 */
	EClass getExecutionConditionGeneralLogFilterStrategy();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.executionstatemapping.model.strategymodel.ExecutionConditionGeneralLogFilterStrategy#getSimpleExecutionConditionConfiguration <em>Simple Execution Condition Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simple Execution Condition Configuration</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.ExecutionConditionGeneralLogFilterStrategy#getSimpleExecutionConditionConfiguration()
	 * @see #getExecutionConditionGeneralLogFilterStrategy()
	 * @generated
	 */
	EReference getExecutionConditionGeneralLogFilterStrategy_SimpleExecutionConditionConfiguration();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StrategymodelFactory getStrategymodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.strategymodel.impl.StateDiagramTraceInferenceStrategyImpl <em>State Diagram Trace Inference Strategy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.impl.StateDiagramTraceInferenceStrategyImpl
		 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.impl.StrategymodelPackageImpl#getStateDiagramTraceInferenceStrategy()
		 * @generated
		 */
		EClass STATE_DIAGRAM_TRACE_INFERENCE_STRATEGY = eINSTANCE.getStateDiagramTraceInferenceStrategy();

		/**
		 * The meta object literal for the '<em><b>State Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_DIAGRAM_TRACE_INFERENCE_STRATEGY__STATE_CONTAINER = eINSTANCE.getStateDiagramTraceInferenceStrategy_StateContainer();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.strategymodel.impl.SimpleExecutionConditionTraceInferenceStrategyImpl <em>Simple Execution Condition Trace Inference Strategy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.impl.SimpleExecutionConditionTraceInferenceStrategyImpl
		 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.impl.StrategymodelPackageImpl#getSimpleExecutionConditionTraceInferenceStrategy()
		 * @generated
		 */
		EClass SIMPLE_EXECUTION_CONDITION_TRACE_INFERENCE_STRATEGY = eINSTANCE.getSimpleExecutionConditionTraceInferenceStrategy();

		/**
		 * The meta object literal for the '<em><b>Simple Execution Condition Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_EXECUTION_CONDITION_TRACE_INFERENCE_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION = eINSTANCE.getSimpleExecutionConditionTraceInferenceStrategy_SimpleExecutionConditionConfiguration();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.strategymodel.impl.ExecutionConditionGeneralLogFilterStrategyImpl <em>Execution Condition General Log Filter Strategy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.impl.ExecutionConditionGeneralLogFilterStrategyImpl
		 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.impl.StrategymodelPackageImpl#getExecutionConditionGeneralLogFilterStrategy()
		 * @generated
		 */
		EClass EXECUTION_CONDITION_GENERAL_LOG_FILTER_STRATEGY = eINSTANCE.getExecutionConditionGeneralLogFilterStrategy();

		/**
		 * The meta object literal for the '<em><b>Simple Execution Condition Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_CONDITION_GENERAL_LOG_FILTER_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION = eINSTANCE.getExecutionConditionGeneralLogFilterStrategy_SimpleExecutionConditionConfiguration();

	}

} //StrategymodelPackage
