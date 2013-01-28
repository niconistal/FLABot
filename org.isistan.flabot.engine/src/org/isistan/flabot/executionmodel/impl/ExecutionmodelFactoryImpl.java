/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExecutionmodelFactoryImpl.java,v 1.19 2006/07/04 12:42:19 mblech Exp $
 */
package org.isistan.flabot.executionmodel.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.isistan.flabot.executionmodel.*;

import org.isistan.flabot.executionmodel.Dependency;
import org.isistan.flabot.executionmodel.EvaluationStep;
import org.isistan.flabot.executionmodel.ExecutionContext;
import org.isistan.flabot.executionmodel.ExecutionInfo;
import org.isistan.flabot.executionmodel.ExecutionInfoManager;
import org.isistan.flabot.executionmodel.ExecutionStep;
import org.isistan.flabot.executionmodel.ExecutionmodelFactory;
import org.isistan.flabot.executionmodel.ExecutionmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExecutionmodelFactoryImpl extends EFactoryImpl implements ExecutionmodelFactory {
	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionmodelFactoryImpl() {
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
			case ExecutionmodelPackage.EXECUTION_INFO: return createExecutionInfo();
			case ExecutionmodelPackage.EXECUTION_INFO_MANAGER: return createExecutionInfoManager();
			case ExecutionmodelPackage.EXECUTION_STEP: return createExecutionStep();
			case ExecutionmodelPackage.RESPONSIBILITY_NODE_TO_EXECUTION_STATE_MAP_ENTRY: return (EObject)createResponsibilityNodeToExecutionStateMapEntry();
			case ExecutionmodelPackage.DEPENDENCY: return createDependency();
			case ExecutionmodelPackage.EXECUTION_CONTEXT: return createExecutionContext();
			case ExecutionmodelPackage.ESTRING_TO_EOBJECT_MAP_ENTRY: return (EObject)createEStringToEObjectMapEntry();
			case ExecutionmodelPackage.ESTRING_TO_EJAVA_OBJECT_MAP_ENTRY: return (EObject)createEStringToEJavaObjectMapEntry();
			case ExecutionmodelPackage.SIMPLE_PATH_NODE_TO_EXECUTION_STATE_MAP_ENTRY: return (EObject)createSimplePathNodeToExecutionStateMapEntry();
			case ExecutionmodelPackage.EVALUATION_STEP: return createEvaluationStep();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionInfo createExecutionInfo() {
		ExecutionInfoImpl executionInfo = new ExecutionInfoImpl();
		return executionInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionInfoManager createExecutionInfoManager() {
		ExecutionInfoManagerImpl executionInfoManager = new ExecutionInfoManagerImpl();
		return executionInfoManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionStep createExecutionStep() {
		ExecutionStepImpl executionStep = new ExecutionStepImpl();
		return executionStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry createResponsibilityNodeToExecutionStateMapEntry() {
		ResponsibilityNodeToExecutionStateMapEntryImpl responsibilityNodeToExecutionStateMapEntry = new ResponsibilityNodeToExecutionStateMapEntryImpl();
		return responsibilityNodeToExecutionStateMapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dependency createDependency() {
		DependencyImpl dependency = new DependencyImpl();
		return dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionContext createExecutionContext() {
		ExecutionContextImpl executionContext = new ExecutionContextImpl();
		return executionContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry createEStringToEObjectMapEntry() {
		EStringToEObjectMapEntryImpl eStringToEObjectMapEntry = new EStringToEObjectMapEntryImpl();
		return eStringToEObjectMapEntry;
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
	public Map.Entry createSimplePathNodeToExecutionStateMapEntry() {
		SimplePathNodeToExecutionStateMapEntryImpl simplePathNodeToExecutionStateMapEntry = new SimplePathNodeToExecutionStateMapEntryImpl();
		return simplePathNodeToExecutionStateMapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvaluationStep createEvaluationStep() {
		EvaluationStepImpl evaluationStep = new EvaluationStepImpl();
		return evaluationStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionmodelPackage getExecutionmodelPackage() {
		return (ExecutionmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExecutionmodelPackage getPackage() {
		return ExecutionmodelPackage.eINSTANCE;
	}

} //ExecutionmodelFactoryImpl
