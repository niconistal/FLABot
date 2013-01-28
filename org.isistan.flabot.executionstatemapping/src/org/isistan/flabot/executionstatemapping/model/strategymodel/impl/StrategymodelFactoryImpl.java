/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.strategymodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.isistan.flabot.executionstatemapping.model.strategymodel.ExecutionConditionGeneralLogFilterStrategy;
import org.isistan.flabot.executionstatemapping.model.strategymodel.SimpleExecutionConditionTraceInferenceStrategy;
import org.isistan.flabot.executionstatemapping.model.strategymodel.StateDiagramTraceInferenceStrategy;
import org.isistan.flabot.executionstatemapping.model.strategymodel.StrategymodelFactory;
import org.isistan.flabot.executionstatemapping.model.strategymodel.StrategymodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StrategymodelFactoryImpl extends EFactoryImpl implements StrategymodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StrategymodelFactory init() {
		try {
			StrategymodelFactory theStrategymodelFactory = (StrategymodelFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/isistan/flabot/executionstatemapping/strategymodel.ecore"); 
			if (theStrategymodelFactory != null) {
				return theStrategymodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StrategymodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrategymodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case StrategymodelPackage.STATE_DIAGRAM_TRACE_INFERENCE_STRATEGY: return createStateDiagramTraceInferenceStrategy();
			case StrategymodelPackage.SIMPLE_EXECUTION_CONDITION_TRACE_INFERENCE_STRATEGY: return createSimpleExecutionConditionTraceInferenceStrategy();
			case StrategymodelPackage.EXECUTION_CONDITION_GENERAL_LOG_FILTER_STRATEGY: return createExecutionConditionGeneralLogFilterStrategy();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateDiagramTraceInferenceStrategy createStateDiagramTraceInferenceStrategy() {
		StateDiagramTraceInferenceStrategyImpl stateDiagramTraceInferenceStrategy = new StateDiagramTraceInferenceStrategyImpl();
		return stateDiagramTraceInferenceStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleExecutionConditionTraceInferenceStrategy createSimpleExecutionConditionTraceInferenceStrategy() {
		SimpleExecutionConditionTraceInferenceStrategyImpl simpleExecutionConditionTraceInferenceStrategy = new SimpleExecutionConditionTraceInferenceStrategyImpl();
		return simpleExecutionConditionTraceInferenceStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionConditionGeneralLogFilterStrategy createExecutionConditionGeneralLogFilterStrategy() {
		ExecutionConditionGeneralLogFilterStrategyImpl executionConditionGeneralLogFilterStrategy = new ExecutionConditionGeneralLogFilterStrategyImpl();
		return executionConditionGeneralLogFilterStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrategymodelPackage getStrategymodelPackage() {
		return (StrategymodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StrategymodelPackage getPackage() {
		return StrategymodelPackage.eINSTANCE;
	}

} //StrategymodelFactoryImpl
