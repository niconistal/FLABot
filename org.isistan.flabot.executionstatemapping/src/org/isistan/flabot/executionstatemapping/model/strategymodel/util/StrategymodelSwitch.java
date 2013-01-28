/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.strategymodel.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.isistan.flabot.engine.executionstate.GeneralLogFilterStrategy;
import org.isistan.flabot.engine.executionstate.PrologProviderStrategy;
import org.isistan.flabot.engine.executionstate.TraceInferenceStrategy;
import org.isistan.flabot.executionstatemapping.model.strategymodel.ExecutionConditionGeneralLogFilterStrategy;
import org.isistan.flabot.executionstatemapping.model.strategymodel.SimpleExecutionConditionTraceInferenceStrategy;
import org.isistan.flabot.executionstatemapping.model.strategymodel.StateDiagramTraceInferenceStrategy;
import org.isistan.flabot.executionstatemapping.model.strategymodel.StrategymodelPackage;

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
 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.StrategymodelPackage
 * @generated
 */
public class StrategymodelSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StrategymodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrategymodelSwitch() {
		if (modelPackage == null) {
			modelPackage = StrategymodelPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case StrategymodelPackage.STATE_DIAGRAM_TRACE_INFERENCE_STRATEGY: {
				StateDiagramTraceInferenceStrategy stateDiagramTraceInferenceStrategy = (StateDiagramTraceInferenceStrategy)theEObject;
				T result = caseStateDiagramTraceInferenceStrategy(stateDiagramTraceInferenceStrategy);
				if (result == null) result = caseTraceInferenceStrategy(stateDiagramTraceInferenceStrategy);
				if (result == null) result = casePrologProviderStrategy(stateDiagramTraceInferenceStrategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StrategymodelPackage.SIMPLE_EXECUTION_CONDITION_TRACE_INFERENCE_STRATEGY: {
				SimpleExecutionConditionTraceInferenceStrategy simpleExecutionConditionTraceInferenceStrategy = (SimpleExecutionConditionTraceInferenceStrategy)theEObject;
				T result = caseSimpleExecutionConditionTraceInferenceStrategy(simpleExecutionConditionTraceInferenceStrategy);
				if (result == null) result = caseTraceInferenceStrategy(simpleExecutionConditionTraceInferenceStrategy);
				if (result == null) result = casePrologProviderStrategy(simpleExecutionConditionTraceInferenceStrategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StrategymodelPackage.EXECUTION_CONDITION_GENERAL_LOG_FILTER_STRATEGY: {
				ExecutionConditionGeneralLogFilterStrategy executionConditionGeneralLogFilterStrategy = (ExecutionConditionGeneralLogFilterStrategy)theEObject;
				T result = caseExecutionConditionGeneralLogFilterStrategy(executionConditionGeneralLogFilterStrategy);
				if (result == null) result = caseGeneralLogFilterStrategy(executionConditionGeneralLogFilterStrategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Diagram Trace Inference Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Diagram Trace Inference Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateDiagramTraceInferenceStrategy(StateDiagramTraceInferenceStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Execution Condition Trace Inference Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Execution Condition Trace Inference Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleExecutionConditionTraceInferenceStrategy(SimpleExecutionConditionTraceInferenceStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Condition General Log Filter Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Condition General Log Filter Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutionConditionGeneralLogFilterStrategy(ExecutionConditionGeneralLogFilterStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace Inference Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace Inference Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceInferenceStrategy(TraceInferenceStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Prolog Provider Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Prolog Provider Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrologProviderStrategy(PrologProviderStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>General Log Filter Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>General Log Filter Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeneralLogFilterStrategy(GeneralLogFilterStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //StrategymodelSwitch
