/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExecutionmodelSwitch.java,v 1.19 2006/07/04 12:42:19 mblech Exp $
 */
package org.isistan.flabot.executionmodel.util;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.isistan.flabot.executionmodel.*;

import org.isistan.flabot.executionmodel.Dependency;
import org.isistan.flabot.executionmodel.EvaluationStep;
import org.isistan.flabot.executionmodel.ExecutionContext;
import org.isistan.flabot.executionmodel.ExecutionInfo;
import org.isistan.flabot.executionmodel.ExecutionInfoManager;
import org.isistan.flabot.executionmodel.ExecutionStep;
import org.isistan.flabot.executionmodel.ExecutionmodelPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.executionmodel.ExecutionmodelPackage
 * @generated
 */
public class ExecutionmodelSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExecutionmodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionmodelSwitch() {
		if (modelPackage == null) {
			modelPackage = ExecutionmodelPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ExecutionmodelPackage.EXECUTION_INFO: {
				ExecutionInfo executionInfo = (ExecutionInfo)theEObject;
				Object result = caseExecutionInfo(executionInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionmodelPackage.EXECUTION_INFO_MANAGER: {
				ExecutionInfoManager executionInfoManager = (ExecutionInfoManager)theEObject;
				Object result = caseExecutionInfoManager(executionInfoManager);
				if (result == null) result = caseAdapter(executionInfoManager);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionmodelPackage.EXECUTION_STEP: {
				ExecutionStep executionStep = (ExecutionStep)theEObject;
				Object result = caseExecutionStep(executionStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionmodelPackage.RESPONSIBILITY_NODE_TO_EXECUTION_STATE_MAP_ENTRY: {
				Map.Entry responsibilityNodeToExecutionStateMapEntry = (Map.Entry)theEObject;
				Object result = caseResponsibilityNodeToExecutionStateMapEntry(responsibilityNodeToExecutionStateMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionmodelPackage.DEPENDENCY: {
				Dependency dependency = (Dependency)theEObject;
				Object result = caseDependency(dependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionmodelPackage.EXECUTION_CONTEXT: {
				ExecutionContext executionContext = (ExecutionContext)theEObject;
				Object result = caseExecutionContext(executionContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionmodelPackage.ESTRING_TO_EOBJECT_MAP_ENTRY: {
				Map.Entry eStringToEObjectMapEntry = (Map.Entry)theEObject;
				Object result = caseEStringToEObjectMapEntry(eStringToEObjectMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionmodelPackage.ESTRING_TO_EJAVA_OBJECT_MAP_ENTRY: {
				Map.Entry eStringToEJavaObjectMapEntry = (Map.Entry)theEObject;
				Object result = caseEStringToEJavaObjectMapEntry(eStringToEJavaObjectMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionmodelPackage.SIMPLE_PATH_NODE_TO_EXECUTION_STATE_MAP_ENTRY: {
				Map.Entry simplePathNodeToExecutionStateMapEntry = (Map.Entry)theEObject;
				Object result = caseSimplePathNodeToExecutionStateMapEntry(simplePathNodeToExecutionStateMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionmodelPackage.EVALUATION_STEP: {
				EvaluationStep evaluationStep = (EvaluationStep)theEObject;
				Object result = caseEvaluationStep(evaluationStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Execution Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Execution Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExecutionInfo(ExecutionInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Execution Info Manager</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Execution Info Manager</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExecutionInfoManager(ExecutionInfoManager object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Execution Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Execution Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExecutionStep(ExecutionStep object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Responsibility Node To Execution State Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Responsibility Node To Execution State Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseResponsibilityNodeToExecutionStateMapEntry(Map.Entry object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDependency(Dependency object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Adapter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Adapter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAdapter(Adapter object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Execution Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Execution Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExecutionContext(ExecutionContext object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EString To EObject Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EString To EObject Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEStringToEObjectMapEntry(Map.Entry object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EString To EJava Object Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EString To EJava Object Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEStringToEJavaObjectMapEntry(Map.Entry object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Simple Path Node To Execution State Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Simple Path Node To Execution State Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSimplePathNodeToExecutionStateMapEntry(Map.Entry object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Evaluation Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Evaluation Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEvaluationStep(EvaluationStep object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //ExecutionmodelSwitch
