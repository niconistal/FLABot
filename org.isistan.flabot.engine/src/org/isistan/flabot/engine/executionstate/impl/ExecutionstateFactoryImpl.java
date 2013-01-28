/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExecutionstateFactoryImpl.java,v 1.19 2006/07/04 12:42:19 mblech Exp $
 */
package org.isistan.flabot.engine.executionstate.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.isistan.flabot.engine.executionstate.*;

import org.isistan.flabot.engine.executionstate.BasicMappingBasedFilter;
import org.isistan.flabot.engine.executionstate.Diagnostic;
import org.isistan.flabot.engine.executionstate.ExecutionState;
import org.isistan.flabot.engine.executionstate.ExecutionstateFactory;
import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;
import org.isistan.flabot.engine.executionstate.ManualStateDeterminationStrategy;
import org.isistan.flabot.engine.executionstate.ManualTraceInferenceStrategy;
import org.isistan.flabot.engine.executionstate.SimpleTraceInferenceStrategy;
import org.isistan.flabot.engine.executionstate.StateDeterminationStrategyRegistry;
import org.isistan.flabot.engine.executionstate.StateFromMappingStateDeterminationStrategy;
import org.isistan.flabot.engine.executionstate.TraceBasedStateDeterminationStrategy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExecutionstateFactoryImpl extends EFactoryImpl implements ExecutionstateFactory {
	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionstateFactoryImpl() {
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
			case ExecutionstatePackage.BASIC_MAPPING_BASED_FILTER: return createBasicMappingBasedFilter();
			case ExecutionstatePackage.DIAGNOSTIC: return createDiagnostic();
			case ExecutionstatePackage.MANUAL_STATE_DETERMINATION_STRATEGY: return createManualStateDeterminationStrategy();
			case ExecutionstatePackage.MANUAL_TRACE_INFERENCE_STRATEGY: return createManualTraceInferenceStrategy();
			case ExecutionstatePackage.SIMPLE_TRACE_INFERENCE_STRATEGY: return createSimpleTraceInferenceStrategy();
			case ExecutionstatePackage.STATE_DETERMINATION_STRATEGY_REGISTRY: return createStateDeterminationStrategyRegistry();
			case ExecutionstatePackage.TRACE_BASED_STATE_DETERMINATION_STRATEGY: return createTraceBasedStateDeterminationStrategy();
			case ExecutionstatePackage.RESPONSIBILITY_TO_STATE_DETERMINATION_STRATEGY_MAP_ENTRY: return (EObject)createResponsibilityToStateDeterminationStrategyMapEntry();
			case ExecutionstatePackage.ESTRING_TO_EJAVA_OBJECT_MAP_ENTRY: return (EObject)createEStringToEJavaObjectMapEntry();
			case ExecutionstatePackage.STATE_FROM_MAPPING_STATE_DETERMINATION_STRATEGY: return createStateFromMappingStateDeterminationStrategy();
			case ExecutionstatePackage.OR_FILTER: return createOrFilter();
			case ExecutionstatePackage.SIMPLE_PROLOG_PROVIDER_STRATEGY: return createSimplePrologProviderStrategy();
			case ExecutionstatePackage.SIMPLE_GENERAL_LOG_FILTER_STRATEGY: return createSimpleGeneralLogFilterStrategy();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ExecutionstatePackage.EXECUTION_STATE: {
				ExecutionState result = ExecutionState.get(initialValue);
				if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
				return result;
			}
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ExecutionstatePackage.EXECUTION_STATE:
				return instanceValue == null ? null : instanceValue.toString();
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry createResponsibilityToStateDeterminationStrategyMapEntry() {
		ResponsibilityToStateDeterminationStrategyMapEntryImpl responsibilityToStateDeterminationStrategyMapEntry = new ResponsibilityToStateDeterminationStrategyMapEntryImpl();
		return responsibilityToStateDeterminationStrategyMapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateDeterminationStrategyRegistry createStateDeterminationStrategyRegistry() {
		StateDeterminationStrategyRegistryImpl stateDeterminationStrategyRegistry = new StateDeterminationStrategyRegistryImpl();
		return stateDeterminationStrategyRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManualStateDeterminationStrategy createManualStateDeterminationStrategy() {
		ManualStateDeterminationStrategyImpl manualStateDeterminationStrategy = new ManualStateDeterminationStrategyImpl();
		return manualStateDeterminationStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceBasedStateDeterminationStrategy createTraceBasedStateDeterminationStrategy() {
		TraceBasedStateDeterminationStrategyImpl traceBasedStateDeterminationStrategy = new TraceBasedStateDeterminationStrategyImpl();
		return traceBasedStateDeterminationStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManualTraceInferenceStrategy createManualTraceInferenceStrategy() {
		ManualTraceInferenceStrategyImpl manualTraceInferenceStrategy = new ManualTraceInferenceStrategyImpl();
		return manualTraceInferenceStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleTraceInferenceStrategy createSimpleTraceInferenceStrategy() {
		SimpleTraceInferenceStrategyImpl simpleTraceInferenceStrategy = new SimpleTraceInferenceStrategyImpl();
		return simpleTraceInferenceStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagnostic createDiagnostic() {
		DiagnosticImpl diagnostic = new DiagnosticImpl();
		return diagnostic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry createEStringToEJavaObjectMapEntry() {
		EStringToEJavaObjectMapEntryImpl eStringToEJavaObjectMapEntry = new EStringToEJavaObjectMapEntryImpl();
		return eStringToEJavaObjectMapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateFromMappingStateDeterminationStrategy createStateFromMappingStateDeterminationStrategy() {
		StateFromMappingStateDeterminationStrategyImpl stateFromMappingStateDeterminationStrategy = new StateFromMappingStateDeterminationStrategyImpl();
		return stateFromMappingStateDeterminationStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrFilter createOrFilter() {
		OrFilterImpl orFilter = new OrFilterImpl();
		return orFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePrologProviderStrategy createSimplePrologProviderStrategy() {
		SimplePrologProviderStrategyImpl simplePrologProviderStrategy = new SimplePrologProviderStrategyImpl();
		return simplePrologProviderStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleGeneralLogFilterStrategy createSimpleGeneralLogFilterStrategy() {
		SimpleGeneralLogFilterStrategyImpl simpleGeneralLogFilterStrategy = new SimpleGeneralLogFilterStrategyImpl();
		return simpleGeneralLogFilterStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicMappingBasedFilter createBasicMappingBasedFilter() {
		BasicMappingBasedFilterImpl basicMappingBasedFilter = new BasicMappingBasedFilterImpl();
		return basicMappingBasedFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionstatePackage getExecutionstatePackage() {
		return (ExecutionstatePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExecutionstatePackage getPackage() {
		return ExecutionstatePackage.eINSTANCE;
	}

} //ExecutionstateFactoryImpl
