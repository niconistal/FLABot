/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExecutionmodelPackage.java,v 1.14 2006/03/29 20:42:16 franco Exp $
 */
package org.isistan.flabot.executionmodel;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.isistan.flabot.executionmodel.ExecutionmodelFactory
 * @model kind="package"
 * @generated
 */
public interface ExecutionmodelPackage extends EPackage{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "executionmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/isistan/flabot/executionmodel.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.isistan.flabot.executionmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExecutionmodelPackage eINSTANCE = org.isistan.flabot.executionmodel.impl.ExecutionmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionmodel.impl.ExecutionInfoImpl <em>Execution Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionmodel.impl.ExecutionInfoImpl
	 * @see org.isistan.flabot.executionmodel.impl.ExecutionmodelPackageImpl#getExecutionInfo()
	 * @generated
	 */
	int EXECUTION_INFO = 0;

	/**
	 * The feature id for the '<em><b>Execution Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_INFO__EXECUTION_STEPS = 0;

	/**
	 * The number of structural features of the the '<em>Execution Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_INFO_FEATURE_COUNT = 1;

	/**
	 * The number of structural features of the the '<em>Execution Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int EXECUTION_INFO__BACK_TO_STEP = EXECUTION_INFO__EXECUTION_STEPS + 5;
	
	
	/**
	 * The number of structural features of the the '<em>Execution Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int EXECUTION_INFO__START_EVALUATING_NODE = EXECUTION_INFO__EXECUTION_STEPS + 6;
	
	/**
	 * The number of structural features of the the '<em>Execution Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int EXECUTION_INFO__FINISH_EVALUATING_NODE = EXECUTION_INFO__EXECUTION_STEPS + 7;
	
	/**
	 * The number of structural features of the the '<em>Execution Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int EXECUTION_INFO__RESET = EXECUTION_INFO__EXECUTION_STEPS + 8;
	
	/**
	 * The meta object id for the '{@link org.eclipse.emf.common.notify.Adapter <em>Adapter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.notify.Adapter
	 * @see org.isistan.flabot.executionmodel.impl.ExecutionmodelPackageImpl#getAdapter()
	 * @generated
	 */
	int ADAPTER = 5;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionmodel.impl.ExecutionInfoManagerImpl <em>Execution Info Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionmodel.impl.ExecutionInfoManagerImpl
	 * @see org.isistan.flabot.executionmodel.impl.ExecutionmodelPackageImpl#getExecutionInfoManager()
	 * @generated
	 */
	int EXECUTION_INFO_MANAGER = 1;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionmodel.impl.ExecutionStepImpl <em>Execution Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionmodel.impl.ExecutionStepImpl
	 * @see org.isistan.flabot.executionmodel.impl.ExecutionmodelPackageImpl#getExecutionStep()
	 * @generated
	 */
	int EXECUTION_STEP = 2;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionmodel.impl.ResponsibilityNodeToExecutionStateMapEntryImpl <em>Responsibility Node To Execution State Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionmodel.impl.ResponsibilityNodeToExecutionStateMapEntryImpl
	 * @see org.isistan.flabot.executionmodel.impl.ExecutionmodelPackageImpl#getResponsibilityNodeToExecutionStateMapEntry()
	 * @generated
	 */
	int RESPONSIBILITY_NODE_TO_EXECUTION_STATE_MAP_ENTRY = 3;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionmodel.impl.DependencyImpl <em>Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionmodel.impl.DependencyImpl
	 * @see org.isistan.flabot.executionmodel.impl.ExecutionmodelPackageImpl#getDependency()
	 * @generated
	 */
	int DEPENDENCY = 4;

	/**
	 * The number of structural features of the the '<em>Adapter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Executions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_INFO_MANAGER__EXECUTIONS = ADAPTER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Current Execution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_INFO_MANAGER__CURRENT_EXECUTION = ADAPTER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>File Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_INFO_MANAGER__FILE_MODEL = ADAPTER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the the '<em>Execution Info Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_INFO_MANAGER_FEATURE_COUNT = ADAPTER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STEP__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STEP__TARGET = 1;

	/**
	 * The feature id for the '<em><b>Dependency</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STEP__DEPENDENCY = 2;

	/**
	 * The feature id for the '<em><b>Instance Component To Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STEP__INSTANCE_COMPONENT_TO_SOURCE = 3;

	/**
	 * The feature id for the '<em><b>Instance Component To Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STEP__INSTANCE_COMPONENT_TO_TARGET = 4;

	/**
	 * The feature id for the '<em><b>Diagnostic To Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STEP__DIAGNOSTIC_TO_SOURCE = 5;

	/**
	 * The feature id for the '<em><b>Diagnostic To Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STEP__DIAGNOSTIC_TO_TARGET = 6;

	/**
	 * The feature id for the '<em><b>Final State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STEP__FINAL_STATE = 7;

	/**
	 * The feature id for the '<em><b>Execution Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STEP__EXECUTION_CONTEXT = 8;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STEP__ENABLED = 9;

	/**
	 * The number of structural features of the the '<em>Execution Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STEP_FEATURE_COUNT = 10;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_NODE_TO_EXECUTION_STATE_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_NODE_TO_EXECUTION_STATE_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the the '<em>Responsibility Node To Execution State Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_NODE_TO_EXECUTION_STATE_MAP_ENTRY_FEATURE_COUNT = 2;


	/**
	 * The feature id for the '<em><b>Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__EVENT = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__TYPE = 1;

	/**
	 * The number of structural features of the the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl <em>Execution Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionmodel.impl.ExecutionContextImpl
	 * @see org.isistan.flabot.executionmodel.impl.ExecutionmodelPackageImpl#getExecutionContext()
	 * @generated
	 */
	int EXECUTION_CONTEXT = 6;

	/**
	 * The feature id for the '<em><b>Current Responsibility</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__CURRENT_RESPONSIBILITY = 0;

	/**
	 * The feature id for the '<em><b>Pre Responsibility</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__PRE_RESPONSIBILITY = 1;

	/**
	 * The feature id for the '<em><b>Current Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__CURRENT_STEP = 2;

	/**
	 * The feature id for the '<em><b>Current Scenario</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__CURRENT_SCENARIO = 3;

	/**
	 * The feature id for the '<em><b>Current State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__CURRENT_STATE = 4;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__DEPENDENCIES = 5;

	/**
	 * The feature id for the '<em><b>Current Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__CURRENT_FAMILY = 6;

	/**
	 * The feature id for the '<em><b>Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__FAMILY = 7;

	/**
	 * The feature id for the '<em><b>Current Type Dependency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__CURRENT_TYPE_DEPENDENCY = 8;

	/**
	 * The feature id for the '<em><b>Current Dependency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__CURRENT_DEPENDENCY = 9;

	/**
	 * The feature id for the '<em><b>Current Analize Dependency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__CURRENT_ANALIZE_DEPENDENCY = 10;

	/**
	 * The feature id for the '<em><b>Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__EVENT = 11;

	/**
	 * The feature id for the '<em><b>Prolog Knowledge</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__PROLOG_KNOWLEDGE = 12;

	/**
	 * The feature id for the '<em><b>Current Logic Module</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__CURRENT_LOGIC_MODULE = 13;

	/**
	 * The feature id for the '<em><b>Responsibility To Execute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__RESPONSIBILITY_TO_EXECUTE = 14;

	/**
	 * The feature id for the '<em><b>Mapping Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__MAPPING_FAMILY = 15;

	/**
	 * The feature id for the '<em><b>Last Mapping Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__LAST_MAPPING_FAMILY = 16;

	/**
	 * The feature id for the '<em><b>Stub Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__STUB_NODE = 17;

	/**
	 * The feature id for the '<em><b>Start Node To Stub</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__START_NODE_TO_STUB = 18;

	/**
	 * The feature id for the '<em><b>End Node To Stub</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__END_NODE_TO_STUB = 19;

	/**
	 * The feature id for the '<em><b>Responsibility To Stub</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__RESPONSIBILITY_TO_STUB = 20;

	/**
	 * The feature id for the '<em><b>Pre Responsibility To Stub</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__PRE_RESPONSIBILITY_TO_STUB = 21;

	/**
	 * The feature id for the '<em><b>Stop Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__STOP_STEP = 22;

	/**
	 * The feature id for the '<em><b>Instance Component To Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__INSTANCE_COMPONENT_TO_SOURCE = 23;

	/**
	 * The feature id for the '<em><b>Instance Component To Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__INSTANCE_COMPONENT_TO_TARGET = 24;

	/**
	 * The feature id for the '<em><b>Responsibility To Join</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__RESPONSIBILITY_TO_JOIN = 25;

	/**
	 * The feature id for the '<em><b>Pre Responsibility To Join</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__PRE_RESPONSIBILITY_TO_JOIN = 26;

	/**
	 * The feature id for the '<em><b>Branch Join</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__BRANCH_JOIN = 27;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__ENABLED = 28;

	/**
	 * The number of structural features of the the '<em>Execution Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT_FEATURE_COUNT = 29;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionmodel.impl.EStringToEObjectMapEntryImpl <em>EString To EObject Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionmodel.impl.EStringToEObjectMapEntryImpl
	 * @see org.isistan.flabot.executionmodel.impl.ExecutionmodelPackageImpl#getEStringToEObjectMapEntry()
	 * @generated
	 */
	int ESTRING_TO_EOBJECT_MAP_ENTRY = 7;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EOBJECT_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EOBJECT_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the the '<em>EString To EObject Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EOBJECT_MAP_ENTRY_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionmodel.impl.EStringToEJavaObjectMapEntryImpl <em>EString To EJava Object Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionmodel.impl.EStringToEJavaObjectMapEntryImpl
	 * @see org.isistan.flabot.executionmodel.impl.ExecutionmodelPackageImpl#getEStringToEJavaObjectMapEntry()
	 * @generated
	 */
	int ESTRING_TO_EJAVA_OBJECT_MAP_ENTRY = 8;

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
	 * The meta object id for the '{@link org.isistan.flabot.executionmodel.impl.SimplePathNodeToExecutionStateMapEntryImpl <em>Simple Path Node To Execution State Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionmodel.impl.SimplePathNodeToExecutionStateMapEntryImpl
	 * @see org.isistan.flabot.executionmodel.impl.ExecutionmodelPackageImpl#getSimplePathNodeToExecutionStateMapEntry()
	 * @generated
	 */
	int SIMPLE_PATH_NODE_TO_EXECUTION_STATE_MAP_ENTRY = 9;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PATH_NODE_TO_EXECUTION_STATE_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PATH_NODE_TO_EXECUTION_STATE_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the the '<em>Simple Path Node To Execution State Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PATH_NODE_TO_EXECUTION_STATE_MAP_ENTRY_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionmodel.impl.EvaluationStepImpl <em>Evaluation Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionmodel.impl.EvaluationStepImpl
	 * @see org.isistan.flabot.executionmodel.impl.ExecutionmodelPackageImpl#getEvaluationStep()
	 * @generated
	 */
	int EVALUATION_STEP = 10;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_STEP__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_STEP__TARGET = 1;

	/**
	 * The feature id for the '<em><b>Current Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_STEP__CURRENT_FAMILY = 2;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_STEP__CONDITION = 3;

	/**
	 * The number of structural features of the the '<em>Evaluation Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_STEP_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionmodel.ExecutionInfo <em>Execution Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Info</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionInfo
	 * @generated
	 */
	EClass getExecutionInfo();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.executionmodel.ExecutionInfo#getExecutionSteps <em>Execution Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Execution Steps</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionInfo#getExecutionSteps()
	 * @see #getExecutionInfo()
	 * @generated
	 */
	@SuppressWarnings("deprecation") EReference getExecutionInfo_ExecutionSteps();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionmodel.ExecutionInfoManager <em>Execution Info Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Info Manager</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionInfoManager
	 * @generated
	 */
	EClass getExecutionInfoManager();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.executionmodel.ExecutionInfoManager#getExecutions <em>Executions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Executions</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionInfoManager#getExecutions()
	 * @see #getExecutionInfoManager()
	 * @generated
	 */
	@SuppressWarnings("deprecation") EReference getExecutionInfoManager_Executions();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.executionmodel.ExecutionInfoManager#getCurrentExecution <em>Current Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Current Execution</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionInfoManager#getCurrentExecution()
	 * @see #getExecutionInfoManager()
	 * @generated
	 */
	EReference getExecutionInfoManager_CurrentExecution();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionmodel.ExecutionInfoManager#getFileModel <em>File Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>File Model</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionInfoManager#getFileModel()
	 * @see #getExecutionInfoManager()
	 * @generated
	 */
	EReference getExecutionInfoManager_FileModel();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionmodel.ExecutionStep <em>Execution Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Step</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionStep
	 * @generated
	 */
	EClass getExecutionStep();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionmodel.ExecutionStep#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionStep#getSource()
	 * @see #getExecutionStep()
	 * @generated
	 */
	EReference getExecutionStep_Source();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionmodel.ExecutionStep#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionStep#getTarget()
	 * @see #getExecutionStep()
	 * @generated
	 */
	EReference getExecutionStep_Target();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.executionmodel.ExecutionStep#getDependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dependency</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionStep#getDependency()
	 * @see #getExecutionStep()
	 * @generated
	 */
	EReference getExecutionStep_Dependency();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionmodel.ExecutionStep#getInstanceComponentToSource <em>Instance Component To Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance Component To Source</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionStep#getInstanceComponentToSource()
	 * @see #getExecutionStep()
	 * @generated
	 */
	EReference getExecutionStep_InstanceComponentToSource();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionmodel.ExecutionStep#getInstanceComponentToTarget <em>Instance Component To Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance Component To Target</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionStep#getInstanceComponentToTarget()
	 * @see #getExecutionStep()
	 * @generated
	 */
	EReference getExecutionStep_InstanceComponentToTarget();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionmodel.ExecutionStep#getDiagnosticToSource <em>Diagnostic To Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Diagnostic To Source</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionStep#getDiagnosticToSource()
	 * @see #getExecutionStep()
	 * @generated
	 */
	EReference getExecutionStep_DiagnosticToSource();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionmodel.ExecutionStep#getDiagnosticToTarget <em>Diagnostic To Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Diagnostic To Target</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionStep#getDiagnosticToTarget()
	 * @see #getExecutionStep()
	 * @generated
	 */
	EReference getExecutionStep_DiagnosticToTarget();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionmodel.ExecutionStep#getFinalState <em>Final State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final State</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionStep#getFinalState()
	 * @see #getExecutionStep()
	 * @generated
	 */
	EAttribute getExecutionStep_FinalState();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.executionmodel.ExecutionStep#getExecutionContext <em>Execution Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Execution Context</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionStep#getExecutionContext()
	 * @see #getExecutionStep()
	 * @generated
	 */
	EReference getExecutionStep_ExecutionContext();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionmodel.ExecutionStep#getEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionStep#getEnabled()
	 * @see #getExecutionStep()
	 * @generated
	 */
	EAttribute getExecutionStep_Enabled();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Responsibility Node To Execution State Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Responsibility Node To Execution State Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="org.isistan.flabot.coremodel.ResponsibilityNode"
	 *        valueType="org.isistan.flabot.engine.executionstate.ExecutionState"
	 * @generated
	 */
	EClass getResponsibilityNodeToExecutionStateMapEntry();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getResponsibilityNodeToExecutionStateMapEntry()
	 * @generated
	 */
	EReference getResponsibilityNodeToExecutionStateMapEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getResponsibilityNodeToExecutionStateMapEntry()
	 * @generated
	 */
	EAttribute getResponsibilityNodeToExecutionStateMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionmodel.Dependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency</em>'.
	 * @see org.isistan.flabot.executionmodel.Dependency
	 * @generated
	 */
	EClass getDependency();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionmodel.Dependency#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event</em>'.
	 * @see org.isistan.flabot.executionmodel.Dependency#getEvent()
	 * @see #getDependency()
	 * @generated
	 */
	EAttribute getDependency_Event();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionmodel.Dependency#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.isistan.flabot.executionmodel.Dependency#getType()
	 * @see #getDependency()
	 * @generated
	 */
	EAttribute getDependency_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.common.notify.Adapter <em>Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adapter</em>'.
	 * @see org.eclipse.emf.common.notify.Adapter
	 * @model instanceClass="org.eclipse.emf.common.notify.Adapter"
	 * @generated
	 */
	EClass getAdapter();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionmodel.ExecutionContext <em>Execution Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Context</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext
	 * @generated
	 */
	EClass getExecutionContext();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionmodel.ExecutionContext#getCurrentResponsibility <em>Current Responsibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current Responsibility</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getCurrentResponsibility()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EReference getExecutionContext_CurrentResponsibility();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionmodel.ExecutionContext#getPreResponsibility <em>Pre Responsibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pre Responsibility</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getPreResponsibility()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EReference getExecutionContext_PreResponsibility();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionmodel.ExecutionContext#getCurrentStep <em>Current Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Step</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getCurrentStep()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EAttribute getExecutionContext_CurrentStep();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionmodel.ExecutionContext#getCurrentScenario <em>Current Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Scenario</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getCurrentScenario()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EAttribute getExecutionContext_CurrentScenario();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionmodel.ExecutionContext#getCurrentState <em>Current State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current State</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getCurrentState()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EAttribute getExecutionContext_CurrentState();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionmodel.ExecutionContext#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dependencies</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getDependencies()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EAttribute getExecutionContext_Dependencies();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionmodel.ExecutionContext#getCurrentFamily <em>Current Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Family</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getCurrentFamily()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EAttribute getExecutionContext_CurrentFamily();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionmodel.ExecutionContext#getFamily <em>Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Family</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getFamily()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EAttribute getExecutionContext_Family();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionmodel.ExecutionContext#getCurrentTypeDependency <em>Current Type Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Type Dependency</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getCurrentTypeDependency()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EAttribute getExecutionContext_CurrentTypeDependency();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionmodel.ExecutionContext#getCurrentDependency <em>Current Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Dependency</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getCurrentDependency()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EAttribute getExecutionContext_CurrentDependency();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionmodel.ExecutionContext#getCurrentAnalizeDependency <em>Current Analize Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Analize Dependency</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getCurrentAnalizeDependency()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EAttribute getExecutionContext_CurrentAnalizeDependency();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionmodel.ExecutionContext#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getEvent()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EAttribute getExecutionContext_Event();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionmodel.ExecutionContext#getPrologKnowledge <em>Prolog Knowledge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prolog Knowledge</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getPrologKnowledge()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EAttribute getExecutionContext_PrologKnowledge();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionmodel.ExecutionContext#getCurrentLogicModule <em>Current Logic Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Logic Module</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getCurrentLogicModule()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EAttribute getExecutionContext_CurrentLogicModule();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionmodel.ExecutionContext#getResponsibilityToExecute <em>Responsibility To Execute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Responsibility To Execute</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getResponsibilityToExecute()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EReference getExecutionContext_ResponsibilityToExecute();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionmodel.ExecutionContext#getMappingFamily <em>Mapping Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mapping Family</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getMappingFamily()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EAttribute getExecutionContext_MappingFamily();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionmodel.ExecutionContext#getLastMappingFamily <em>Last Mapping Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Mapping Family</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getLastMappingFamily()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EAttribute getExecutionContext_LastMappingFamily();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionmodel.ExecutionContext#getStubNode <em>Stub Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Stub Node</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getStubNode()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EReference getExecutionContext_StubNode();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionmodel.ExecutionContext#getStartNodeToStub <em>Start Node To Stub</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Start Node To Stub</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getStartNodeToStub()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EReference getExecutionContext_StartNodeToStub();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionmodel.ExecutionContext#getEndNodeToStub <em>End Node To Stub</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End Node To Stub</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getEndNodeToStub()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EReference getExecutionContext_EndNodeToStub();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionmodel.ExecutionContext#getResponsibilityToStub <em>Responsibility To Stub</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Responsibility To Stub</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getResponsibilityToStub()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EReference getExecutionContext_ResponsibilityToStub();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionmodel.ExecutionContext#getPreResponsibilityToStub <em>Pre Responsibility To Stub</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pre Responsibility To Stub</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getPreResponsibilityToStub()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EReference getExecutionContext_PreResponsibilityToStub();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionmodel.ExecutionContext#getStopStep <em>Stop Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stop Step</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getStopStep()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EAttribute getExecutionContext_StopStep();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionmodel.ExecutionContext#getInstanceComponentToSource <em>Instance Component To Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance Component To Source</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getInstanceComponentToSource()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EReference getExecutionContext_InstanceComponentToSource();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionmodel.ExecutionContext#getInstanceComponentToTarget <em>Instance Component To Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance Component To Target</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getInstanceComponentToTarget()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EReference getExecutionContext_InstanceComponentToTarget();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionmodel.ExecutionContext#getResponsibilityToJoin <em>Responsibility To Join</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Responsibility To Join</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getResponsibilityToJoin()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EReference getExecutionContext_ResponsibilityToJoin();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionmodel.ExecutionContext#getPreResponsibilityToJoin <em>Pre Responsibility To Join</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pre Responsibility To Join</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getPreResponsibilityToJoin()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EReference getExecutionContext_PreResponsibilityToJoin();

	/**
	 * Returns the meta object for the map '{@link org.isistan.flabot.executionmodel.ExecutionContext#getBranchJoin <em>Branch Join</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Branch Join</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getBranchJoin()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EReference getExecutionContext_BranchJoin();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionmodel.ExecutionContext#getEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.isistan.flabot.executionmodel.ExecutionContext#getEnabled()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EAttribute getExecutionContext_Enabled();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EString To EObject Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EString To EObject Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="java.lang.String"
	 *        valueType="org.eclipse.emf.ecore.EObject"
	 * @generated
	 */
	EClass getEStringToEObjectMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToEObjectMapEntry()
	 * @generated
	 */
	EAttribute getEStringToEObjectMapEntry_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToEObjectMapEntry()
	 * @generated
	 */
	EReference getEStringToEObjectMapEntry_Value();

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
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Simple Path Node To Execution State Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Path Node To Execution State Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="org.isistan.flabot.coremodel.SimplePathNode"
	 *        valueType="org.isistan.flabot.engine.executionstate.ExecutionState"
	 * @generated
	 */
	EClass getSimplePathNodeToExecutionStateMapEntry();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getSimplePathNodeToExecutionStateMapEntry()
	 * @generated
	 */
	EReference getSimplePathNodeToExecutionStateMapEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getSimplePathNodeToExecutionStateMapEntry()
	 * @generated
	 */
	EAttribute getSimplePathNodeToExecutionStateMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionmodel.EvaluationStep <em>Evaluation Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evaluation Step</em>'.
	 * @see org.isistan.flabot.executionmodel.EvaluationStep
	 * @generated
	 */
	EClass getEvaluationStep();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionmodel.EvaluationStep#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.isistan.flabot.executionmodel.EvaluationStep#getSource()
	 * @see #getEvaluationStep()
	 * @generated
	 */
	EReference getEvaluationStep_Source();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionmodel.EvaluationStep#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.isistan.flabot.executionmodel.EvaluationStep#getTarget()
	 * @see #getEvaluationStep()
	 * @generated
	 */
	EReference getEvaluationStep_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionmodel.EvaluationStep#getCurrentFamily <em>Current Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Family</em>'.
	 * @see org.isistan.flabot.executionmodel.EvaluationStep#getCurrentFamily()
	 * @see #getEvaluationStep()
	 * @generated
	 */
	EAttribute getEvaluationStep_CurrentFamily();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionmodel.EvaluationStep#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see org.isistan.flabot.executionmodel.EvaluationStep#getCondition()
	 * @see #getEvaluationStep()
	 * @generated
	 */
	EAttribute getEvaluationStep_Condition();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExecutionmodelFactory getExecutionmodelFactory();

} //ExecutionmodelPackage
