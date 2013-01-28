/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExecutionstatePackage.java,v 1.13 2006/07/04 12:42:19 mblech Exp $
 */
package org.isistan.flabot.engine.executionstate;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.trace.config.ConfigPackage;

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
 * @see org.isistan.flabot.engine.executionstate.ExecutionstateFactory
 * @model kind="package"
 * @generated
 */
public interface ExecutionstatePackage extends EPackage{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "executionstate";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/isistan/flabot/engine/executionstate.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.isistan.flabot.engine.executionstate";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExecutionstatePackage eINSTANCE = org.isistan.flabot.engine.executionstate.impl.ExecutionstatePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.isistan.flabot.engine.executionstate.impl.MappingBasedFilterImpl <em>Mapping Based Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.engine.executionstate.impl.MappingBasedFilterImpl
	 * @see org.isistan.flabot.engine.executionstate.impl.ExecutionstatePackageImpl#getMappingBasedFilter()
	 * @generated
	 */
	int MAPPING_BASED_FILTER = 4;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BASED_FILTER__CONTEXT = ConfigPackage.FILTER__CONTEXT;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BASED_FILTER__MAPPING = ConfigPackage.FILTER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Log Filter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BASED_FILTER__LOG_FILTER = ConfigPackage.FILTER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the the '<em>Mapping Based Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BASED_FILTER_FEATURE_COUNT = ConfigPackage.FILTER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.engine.executionstate.impl.BasicMappingBasedFilterImpl <em>Basic Mapping Based Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.engine.executionstate.impl.BasicMappingBasedFilterImpl
	 * @see org.isistan.flabot.engine.executionstate.impl.ExecutionstatePackageImpl#getBasicMappingBasedFilter()
	 * @generated
	 */
	int BASIC_MAPPING_BASED_FILTER = 0;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MAPPING_BASED_FILTER__CONTEXT = MAPPING_BASED_FILTER__CONTEXT;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MAPPING_BASED_FILTER__MAPPING = MAPPING_BASED_FILTER__MAPPING;
	
	/**
	 * The feature id for the '<em><b>Log Filter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MAPPING_BASED_FILTER__LOG_FILTER = MAPPING_BASED_FILTER__LOG_FILTER;

	/**
	 * The number of structural features of the the '<em>Basic Mapping Based Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MAPPING_BASED_FILTER_FEATURE_COUNT = MAPPING_BASED_FILTER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.engine.executionstate.impl.DiagnosticImpl <em>Diagnostic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.engine.executionstate.impl.DiagnosticImpl
	 * @see org.isistan.flabot.engine.executionstate.impl.ExecutionstatePackageImpl#getDiagnostic()
	 * @generated
	 */
	int DIAGNOSTIC = 1;

	/**
	 * The feature id for the '<em><b>Diagnostician</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC__DIAGNOSTICIAN = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Additional Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC__ADDITIONAL_DATA = 2;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC__STATE = 3;

	/**
	 * The number of structural features of the the '<em>Diagnostic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.engine.executionstate.impl.StateDeterminationStrategyImpl <em>State Determination Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.engine.executionstate.impl.StateDeterminationStrategyImpl
	 * @see org.isistan.flabot.engine.executionstate.impl.ExecutionstatePackageImpl#getStateDeterminationStrategy()
	 * @generated
	 */
	int STATE_DETERMINATION_STRATEGY = 6;

	/**
	 * The feature id for the '<em><b>Responsibility</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DETERMINATION_STRATEGY__RESPONSIBILITY = CoremodelPackage.REGISTRABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>State Determination Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DETERMINATION_STRATEGY_FEATURE_COUNT = CoremodelPackage.REGISTRABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.engine.executionstate.impl.ManualStateDeterminationStrategyImpl <em>Manual State Determination Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.engine.executionstate.impl.ManualStateDeterminationStrategyImpl
	 * @see org.isistan.flabot.engine.executionstate.impl.ExecutionstatePackageImpl#getManualStateDeterminationStrategy()
	 * @generated
	 */
	int MANUAL_STATE_DETERMINATION_STRATEGY = 2;

	/**
	 * The feature id for the '<em><b>Responsibility</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_STATE_DETERMINATION_STRATEGY__RESPONSIBILITY = STATE_DETERMINATION_STRATEGY__RESPONSIBILITY;

	/**
	 * The number of structural features of the the '<em>Manual State Determination Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_STATE_DETERMINATION_STRATEGY_FEATURE_COUNT = STATE_DETERMINATION_STRATEGY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.engine.executionstate.impl.TraceInferenceStrategyImpl <em>Trace Inference Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.engine.executionstate.impl.TraceInferenceStrategyImpl
	 * @see org.isistan.flabot.engine.executionstate.impl.ExecutionstatePackageImpl#getTraceInferenceStrategy()
	 * @generated
	 */
	int TRACE_INFERENCE_STRATEGY = 9;

	/**
	 * The feature id for the '<em><b>State Determination Strategy</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY = 0;

	/**
	 * The number of structural features of the the '<em>Trace Inference Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_INFERENCE_STRATEGY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.engine.executionstate.impl.ManualTraceInferenceStrategyImpl <em>Manual Trace Inference Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.engine.executionstate.impl.ManualTraceInferenceStrategyImpl
	 * @see org.isistan.flabot.engine.executionstate.impl.ExecutionstatePackageImpl#getManualTraceInferenceStrategy()
	 * @generated
	 */
	int MANUAL_TRACE_INFERENCE_STRATEGY = 3;

	/**
	 * The feature id for the '<em><b>State Determination Strategy</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY = TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY;

	/**
	 * The number of structural features of the the '<em>Manual Trace Inference Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TRACE_INFERENCE_STRATEGY_FEATURE_COUNT = TRACE_INFERENCE_STRATEGY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.engine.executionstate.impl.SimpleTraceInferenceStrategyImpl <em>Simple Trace Inference Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.engine.executionstate.impl.SimpleTraceInferenceStrategyImpl
	 * @see org.isistan.flabot.engine.executionstate.impl.ExecutionstatePackageImpl#getSimpleTraceInferenceStrategy()
	 * @generated
	 */
	int SIMPLE_TRACE_INFERENCE_STRATEGY = 5;

	/**
	 * The feature id for the '<em><b>State Determination Strategy</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY = TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY;

	/**
	 * The number of structural features of the the '<em>Simple Trace Inference Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TRACE_INFERENCE_STRATEGY_FEATURE_COUNT = TRACE_INFERENCE_STRATEGY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.engine.executionstate.impl.StateDeterminationStrategyRegistryImpl <em>State Determination Strategy Registry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.engine.executionstate.impl.StateDeterminationStrategyRegistryImpl
	 * @see org.isistan.flabot.engine.executionstate.impl.ExecutionstatePackageImpl#getStateDeterminationStrategyRegistry()
	 * @generated
	 */
	int STATE_DETERMINATION_STRATEGY_REGISTRY = 7;

	/**
	 * The feature id for the '<em><b>Registry</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DETERMINATION_STRATEGY_REGISTRY__REGISTRY = 0;

	/**
	 * The number of structural features of the the '<em>State Determination Strategy Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DETERMINATION_STRATEGY_REGISTRY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.engine.executionstate.impl.TraceBasedStateDeterminationStrategyImpl <em>Trace Based State Determination Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.engine.executionstate.impl.TraceBasedStateDeterminationStrategyImpl
	 * @see org.isistan.flabot.engine.executionstate.impl.ExecutionstatePackageImpl#getTraceBasedStateDeterminationStrategy()
	 * @generated
	 */
	int TRACE_BASED_STATE_DETERMINATION_STRATEGY = 8;

	/**
	 * The feature id for the '<em><b>Responsibility</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_BASED_STATE_DETERMINATION_STRATEGY__RESPONSIBILITY = STATE_DETERMINATION_STRATEGY__RESPONSIBILITY;

	/**
	 * The feature id for the '<em><b>Trace Inference Strategy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_BASED_STATE_DETERMINATION_STRATEGY__TRACE_INFERENCE_STRATEGY = STATE_DETERMINATION_STRATEGY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>Trace Based State Determination Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_BASED_STATE_DETERMINATION_STRATEGY_FEATURE_COUNT = STATE_DETERMINATION_STRATEGY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.engine.executionstate.impl.ResponsibilityToStateDeterminationStrategyMapEntryImpl <em>Responsibility To State Determination Strategy Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.engine.executionstate.impl.ResponsibilityToStateDeterminationStrategyMapEntryImpl
	 * @see org.isistan.flabot.engine.executionstate.impl.ExecutionstatePackageImpl#getResponsibilityToStateDeterminationStrategyMapEntry()
	 * @generated
	 */
	int RESPONSIBILITY_TO_STATE_DETERMINATION_STRATEGY_MAP_ENTRY = 10;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_TO_STATE_DETERMINATION_STRATEGY_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_TO_STATE_DETERMINATION_STRATEGY_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the the '<em>Responsibility To State Determination Strategy Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_TO_STATE_DETERMINATION_STRATEGY_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.engine.executionstate.impl.EStringToEJavaObjectMapEntryImpl <em>EString To EJava Object Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.engine.executionstate.impl.EStringToEJavaObjectMapEntryImpl
	 * @see org.isistan.flabot.engine.executionstate.impl.ExecutionstatePackageImpl#getEStringToEJavaObjectMapEntry()
	 * @generated
	 */
	int ESTRING_TO_EJAVA_OBJECT_MAP_ENTRY = 11;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EJAVA_OBJECT_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EJAVA_OBJECT_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the the '<em>EString To EJava Object Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EJAVA_OBJECT_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.engine.executionstate.impl.StateFromMappingStateDeterminationStrategyImpl <em>State From Mapping State Determination Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.engine.executionstate.impl.StateFromMappingStateDeterminationStrategyImpl
	 * @see org.isistan.flabot.engine.executionstate.impl.ExecutionstatePackageImpl#getStateFromMappingStateDeterminationStrategy()
	 * @generated
	 */
	int STATE_FROM_MAPPING_STATE_DETERMINATION_STRATEGY = 12;

	/**
	 * The feature id for the '<em><b>Responsibility</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FROM_MAPPING_STATE_DETERMINATION_STRATEGY__RESPONSIBILITY = STATE_DETERMINATION_STRATEGY__RESPONSIBILITY;

	/**
	 * The number of structural features of the the '<em>State From Mapping State Determination Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FROM_MAPPING_STATE_DETERMINATION_STRATEGY_FEATURE_COUNT = STATE_DETERMINATION_STRATEGY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.engine.executionstate.impl.OrFilterImpl <em>Or Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.engine.executionstate.impl.OrFilterImpl
	 * @see org.isistan.flabot.engine.executionstate.impl.ExecutionstatePackageImpl#getOrFilter()
	 * @generated
	 */
	int OR_FILTER = 13;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FILTER__CONTEXT = ConfigPackage.FILTER__CONTEXT;

	/**
	 * The feature id for the '<em><b>Combined Filters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FILTER__COMBINED_FILTERS = ConfigPackage.FILTER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>Or Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FILTER_FEATURE_COUNT = ConfigPackage.FILTER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.engine.executionstate.PrologProviderStrategy <em>Prolog Provider Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.engine.executionstate.PrologProviderStrategy
	 * @see org.isistan.flabot.engine.executionstate.impl.ExecutionstatePackageImpl#getPrologProviderStrategy()
	 * @generated
	 */
	int PROLOG_PROVIDER_STRATEGY = 14;

	/**
	 * The number of structural features of the the '<em>Prolog Provider Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROLOG_PROVIDER_STRATEGY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.engine.executionstate.impl.SimplePrologProviderStrategyImpl <em>Simple Prolog Provider Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.engine.executionstate.impl.SimplePrologProviderStrategyImpl
	 * @see org.isistan.flabot.engine.executionstate.impl.ExecutionstatePackageImpl#getSimplePrologProviderStrategy()
	 * @generated
	 */
	int SIMPLE_PROLOG_PROVIDER_STRATEGY = 15;

	/**
	 * The number of structural features of the the '<em>Simple Prolog Provider Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PROLOG_PROVIDER_STRATEGY_FEATURE_COUNT = PROLOG_PROVIDER_STRATEGY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.engine.executionstate.GeneralLogFilterStrategy <em>General Log Filter Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.engine.executionstate.GeneralLogFilterStrategy
	 * @see org.isistan.flabot.engine.executionstate.impl.ExecutionstatePackageImpl#getGeneralLogFilterStrategy()
	 * @generated
	 */
	int GENERAL_LOG_FILTER_STRATEGY = 16;

	/**
	 * The number of structural features of the the '<em>General Log Filter Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_LOG_FILTER_STRATEGY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.engine.executionstate.impl.SimpleGeneralLogFilterStrategyImpl <em>Simple General Log Filter Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.engine.executionstate.impl.SimpleGeneralLogFilterStrategyImpl
	 * @see org.isistan.flabot.engine.executionstate.impl.ExecutionstatePackageImpl#getSimpleGeneralLogFilterStrategy()
	 * @generated
	 */
	int SIMPLE_GENERAL_LOG_FILTER_STRATEGY = 17;

	/**
	 * The feature id for the '<em><b>Prolog Code Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_GENERAL_LOG_FILTER_STRATEGY__PROLOG_CODE_TEXT = GENERAL_LOG_FILTER_STRATEGY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>Simple General Log Filter Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_GENERAL_LOG_FILTER_STRATEGY_FEATURE_COUNT = GENERAL_LOG_FILTER_STRATEGY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.engine.executionstate.ExecutionState <em>Execution State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.engine.executionstate.ExecutionState
	 * @see org.isistan.flabot.engine.executionstate.impl.ExecutionstatePackageImpl#getExecutionState()
	 * @generated
	 */
	int EXECUTION_STATE = 18;


	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.engine.executionstate.BasicMappingBasedFilter <em>Basic Mapping Based Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Mapping Based Filter</em>'.
	 * @see org.isistan.flabot.engine.executionstate.BasicMappingBasedFilter
	 * @generated
	 */
	EClass getBasicMappingBasedFilter();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.engine.executionstate.Diagnostic <em>Diagnostic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagnostic</em>'.
	 * @see org.isistan.flabot.engine.executionstate.Diagnostic
	 * @generated
	 */
	EClass getDiagnostic();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.engine.executionstate.Diagnostic#getDiagnostician <em>Diagnostician</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Diagnostician</em>'.
	 * @see org.isistan.flabot.engine.executionstate.Diagnostic#getDiagnostician()
	 * @see #getDiagnostic()
	 * @generated
	 */
	EReference getDiagnostic_Diagnostician();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.engine.executionstate.Diagnostic#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.isistan.flabot.engine.executionstate.Diagnostic#getDescription()
	 * @see #getDiagnostic()
	 * @generated
	 */
	EAttribute getDiagnostic_Description();

	/**
	 * Returns the meta object for the map '{@link org.isistan.flabot.engine.executionstate.Diagnostic#getAdditionalData <em>Additional Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Additional Data</em>'.
	 * @see org.isistan.flabot.engine.executionstate.Diagnostic#getAdditionalData()
	 * @see #getDiagnostic()
	 * @generated
	 */
	EReference getDiagnostic_AdditionalData();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.engine.executionstate.Diagnostic#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.isistan.flabot.engine.executionstate.Diagnostic#getState()
	 * @see #getDiagnostic()
	 * @generated
	 */
	EAttribute getDiagnostic_State();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.engine.executionstate.ManualStateDeterminationStrategy <em>Manual State Determination Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Manual State Determination Strategy</em>'.
	 * @see org.isistan.flabot.engine.executionstate.ManualStateDeterminationStrategy
	 * @generated
	 */
	EClass getManualStateDeterminationStrategy();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.engine.executionstate.ManualTraceInferenceStrategy <em>Manual Trace Inference Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Manual Trace Inference Strategy</em>'.
	 * @see org.isistan.flabot.engine.executionstate.ManualTraceInferenceStrategy
	 * @generated
	 */
	EClass getManualTraceInferenceStrategy();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.engine.executionstate.MappingBasedFilter <em>Mapping Based Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Based Filter</em>'.
	 * @see org.isistan.flabot.engine.executionstate.MappingBasedFilter
	 * @generated
	 */
	EClass getMappingBasedFilter();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.engine.executionstate.MappingBasedFilter#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping</em>'.
	 * @see org.isistan.flabot.engine.executionstate.MappingBasedFilter#getMapping()
	 * @see #getMappingBasedFilter()
	 * @generated
	 */
	EReference getMappingBasedFilter_Mapping();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.engine.executionstate.MappingBasedFilter#getLogFilter <em>Log Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Log Filter</em>'.
	 * @see org.isistan.flabot.engine.executionstate.MappingBasedFilter#getLogFilter()
	 * @see #getMappingBasedFilter()
	 * @generated
	 */
	EReference getMappingBasedFilter_LogFilter();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.engine.executionstate.SimpleTraceInferenceStrategy <em>Simple Trace Inference Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Trace Inference Strategy</em>'.
	 * @see org.isistan.flabot.engine.executionstate.SimpleTraceInferenceStrategy
	 * @generated
	 */
	EClass getSimpleTraceInferenceStrategy();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.engine.executionstate.StateDeterminationStrategy <em>State Determination Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Determination Strategy</em>'.
	 * @see org.isistan.flabot.engine.executionstate.StateDeterminationStrategy
	 * @generated
	 */
	EClass getStateDeterminationStrategy();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.engine.executionstate.StateDeterminationStrategy#getResponsibility <em>Responsibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Responsibility</em>'.
	 * @see org.isistan.flabot.engine.executionstate.StateDeterminationStrategy#getResponsibility()
	 * @see #getStateDeterminationStrategy()
	 * @generated
	 */
	EReference getStateDeterminationStrategy_Responsibility();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.engine.executionstate.StateDeterminationStrategyRegistry <em>State Determination Strategy Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Determination Strategy Registry</em>'.
	 * @see org.isistan.flabot.engine.executionstate.StateDeterminationStrategyRegistry
	 * @generated
	 */
	EClass getStateDeterminationStrategyRegistry();

	/**
	 * Returns the meta object for the map '{@link org.isistan.flabot.engine.executionstate.StateDeterminationStrategyRegistry#getRegistry <em>Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Registry</em>'.
	 * @see org.isistan.flabot.engine.executionstate.StateDeterminationStrategyRegistry#getRegistry()
	 * @see #getStateDeterminationStrategyRegistry()
	 * @generated
	 */
	EReference getStateDeterminationStrategyRegistry_Registry();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.engine.executionstate.TraceBasedStateDeterminationStrategy <em>Trace Based State Determination Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Based State Determination Strategy</em>'.
	 * @see org.isistan.flabot.engine.executionstate.TraceBasedStateDeterminationStrategy
	 * @generated
	 */
	EClass getTraceBasedStateDeterminationStrategy();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.engine.executionstate.TraceBasedStateDeterminationStrategy#getTraceInferenceStrategy <em>Trace Inference Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Trace Inference Strategy</em>'.
	 * @see org.isistan.flabot.engine.executionstate.TraceBasedStateDeterminationStrategy#getTraceInferenceStrategy()
	 * @see #getTraceBasedStateDeterminationStrategy()
	 * @generated
	 */
	EReference getTraceBasedStateDeterminationStrategy_TraceInferenceStrategy();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.engine.executionstate.TraceInferenceStrategy <em>Trace Inference Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Inference Strategy</em>'.
	 * @see org.isistan.flabot.engine.executionstate.TraceInferenceStrategy
	 * @generated
	 */
	EClass getTraceInferenceStrategy();

	/**
	 * Returns the meta object for the container reference '{@link org.isistan.flabot.engine.executionstate.TraceInferenceStrategy#getStateDeterminationStrategy <em>State Determination Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>State Determination Strategy</em>'.
	 * @see org.isistan.flabot.engine.executionstate.TraceInferenceStrategy#getStateDeterminationStrategy()
	 * @see #getTraceInferenceStrategy()
	 * @generated
	 */
	EReference getTraceInferenceStrategy_StateDeterminationStrategy();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Responsibility To State Determination Strategy Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Responsibility To State Determination Strategy Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="org.isistan.flabot.coremodel.Responsibility"
	 *        valueType="org.isistan.flabot.engine.executionstate.StateDeterminationStrategy"
	 * @generated
	 */
	EClass getResponsibilityToStateDeterminationStrategyMapEntry();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getResponsibilityToStateDeterminationStrategyMapEntry()
	 * @generated
	 */
	EReference getResponsibilityToStateDeterminationStrategyMapEntry_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getResponsibilityToStateDeterminationStrategyMapEntry()
	 * @generated
	 */
	EReference getResponsibilityToStateDeterminationStrategyMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EString To EJava Object Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EString To EJava Object Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="java.lang.String"
	 *        valueType="java.lang.Object"
	 * @generated
	 */
	EClass getEStringToEJavaObjectMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToEJavaObjectMapEntry()
	 * @generated
	 */
	EAttribute getEStringToEJavaObjectMapEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToEJavaObjectMapEntry()
	 * @generated
	 */
	EAttribute getEStringToEJavaObjectMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.engine.executionstate.StateFromMappingStateDeterminationStrategy <em>State From Mapping State Determination Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State From Mapping State Determination Strategy</em>'.
	 * @see org.isistan.flabot.engine.executionstate.StateFromMappingStateDeterminationStrategy
	 * @generated
	 */
	EClass getStateFromMappingStateDeterminationStrategy();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.engine.executionstate.OrFilter <em>Or Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Filter</em>'.
	 * @see org.isistan.flabot.engine.executionstate.OrFilter
	 * @generated
	 */
	EClass getOrFilter();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.engine.executionstate.OrFilter#getCombinedFilters <em>Combined Filters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Combined Filters</em>'.
	 * @see org.isistan.flabot.engine.executionstate.OrFilter#getCombinedFilters()
	 * @see #getOrFilter()
	 * @generated
	 */
	EReference getOrFilter_CombinedFilters();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.engine.executionstate.PrologProviderStrategy <em>Prolog Provider Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prolog Provider Strategy</em>'.
	 * @see org.isistan.flabot.engine.executionstate.PrologProviderStrategy
	 * @generated
	 */
	EClass getPrologProviderStrategy();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.engine.executionstate.SimplePrologProviderStrategy <em>Simple Prolog Provider Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Prolog Provider Strategy</em>'.
	 * @see org.isistan.flabot.engine.executionstate.SimplePrologProviderStrategy
	 * @generated
	 */
	EClass getSimplePrologProviderStrategy();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.engine.executionstate.GeneralLogFilterStrategy <em>General Log Filter Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>General Log Filter Strategy</em>'.
	 * @see org.isistan.flabot.engine.executionstate.GeneralLogFilterStrategy
	 * @generated
	 */
	EClass getGeneralLogFilterStrategy();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.engine.executionstate.SimpleGeneralLogFilterStrategy <em>Simple General Log Filter Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple General Log Filter Strategy</em>'.
	 * @see org.isistan.flabot.engine.executionstate.SimpleGeneralLogFilterStrategy
	 * @generated
	 */
	EClass getSimpleGeneralLogFilterStrategy();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.engine.executionstate.SimpleGeneralLogFilterStrategy#getPrologCodeText <em>Prolog Code Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prolog Code Text</em>'.
	 * @see org.isistan.flabot.engine.executionstate.SimpleGeneralLogFilterStrategy#getPrologCodeText()
	 * @see #getSimpleGeneralLogFilterStrategy()
	 * @generated
	 */
	EAttribute getSimpleGeneralLogFilterStrategy_PrologCodeText();

	/**
	 * Returns the meta object for enum '{@link org.isistan.flabot.engine.executionstate.ExecutionState <em>Execution State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Execution State</em>'.
	 * @see org.isistan.flabot.engine.executionstate.ExecutionState
	 * @generated
	 */
	EEnum getExecutionState();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExecutionstateFactory getExecutionstateFactory();

} //ExecutionstatePackage
