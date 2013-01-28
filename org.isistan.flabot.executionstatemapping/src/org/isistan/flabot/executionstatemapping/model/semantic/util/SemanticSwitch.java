/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic.util;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologElement;
import org.isistan.flabot.executionstatemapping.model.prolog.VisitedExpressionProlog;
import org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.AndExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.BlockExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.EvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ExceptionEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.FieldEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.FinalState;
import org.isistan.flabot.executionstatemapping.model.semantic.MappedTreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.NamedElement;
import org.isistan.flabot.executionstatemapping.model.semantic.NotedElement;
import org.isistan.flabot.executionstatemapping.model.semantic.OrExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.ParameterEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ReturnedValueEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ScopeEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;
import org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration;
import org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.SingleExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.State;
import org.isistan.flabot.executionstatemapping.model.semantic.StateContainer;
import org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.VisitedExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.VisitorExpression;

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
 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage
 * @generated
 */
public class SemanticSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SemanticPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticSwitch() {
		if (modelPackage == null) {
			modelPackage = SemanticPackage.eINSTANCE;
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
			case SemanticPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.EXECUTION_CONDITION: {
				ExecutionCondition executionCondition = (ExecutionCondition)theEObject;
				T result = caseExecutionCondition(executionCondition);
				if (result == null) result = caseTreeStructuredElement(executionCondition);
				if (result == null) result = casePrologElement(executionCondition);
				if (result == null) result = caseNamedElement(executionCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.EVALUATION_CONDITION: {
				EvaluationCondition evaluationCondition = (EvaluationCondition)theEObject;
				T result = caseEvaluationCondition(evaluationCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.EXCEPTION_EVALUATION_CONDITION: {
				ExceptionEvaluationCondition exceptionEvaluationCondition = (ExceptionEvaluationCondition)theEObject;
				T result = caseExceptionEvaluationCondition(exceptionEvaluationCondition);
				if (result == null) result = caseEvaluationCondition(exceptionEvaluationCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.SCOPE_EVALUATION_CONDITION: {
				ScopeEvaluationCondition scopeEvaluationCondition = (ScopeEvaluationCondition)theEObject;
				T result = caseScopeEvaluationCondition(scopeEvaluationCondition);
				if (result == null) result = caseEvaluationCondition(scopeEvaluationCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.FIELD_EVALUATION_CONDITION: {
				FieldEvaluationCondition fieldEvaluationCondition = (FieldEvaluationCondition)theEObject;
				T result = caseFieldEvaluationCondition(fieldEvaluationCondition);
				if (result == null) result = caseEvaluationCondition(fieldEvaluationCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.PARAMETER_EVALUATION_CONDITION: {
				ParameterEvaluationCondition parameterEvaluationCondition = (ParameterEvaluationCondition)theEObject;
				T result = caseParameterEvaluationCondition(parameterEvaluationCondition);
				if (result == null) result = caseEvaluationCondition(parameterEvaluationCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.RETURNED_VALUE_EVALUATION_CONDITION: {
				ReturnedValueEvaluationCondition returnedValueEvaluationCondition = (ReturnedValueEvaluationCondition)theEObject;
				T result = caseReturnedValueEvaluationCondition(returnedValueEvaluationCondition);
				if (result == null) result = caseEvaluationCondition(returnedValueEvaluationCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.STATE_CONTAINER: {
				StateContainer stateContainer = (StateContainer)theEObject;
				T result = caseStateContainer(stateContainer);
				if (result == null) result = caseTreeStructuredElement(stateContainer);
				if (result == null) result = caseNamedElement(stateContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.STATE: {
				State state = (State)theEObject;
				T result = caseState(state);
				if (result == null) result = caseNamedElement(state);
				if (result == null) result = caseNotedElement(state);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.FINAL_STATE: {
				FinalState finalState = (FinalState)theEObject;
				T result = caseFinalState(finalState);
				if (result == null) result = caseState(finalState);
				if (result == null) result = caseNamedElement(finalState);
				if (result == null) result = caseNotedElement(finalState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.TRANSITION_CONDITION: {
				TransitionCondition transitionCondition = (TransitionCondition)theEObject;
				T result = caseTransitionCondition(transitionCondition);
				if (result == null) result = caseNotedElement(transitionCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.ESTRING_TO_TREE_STRUCTURED_ELEMENT: {
				@SuppressWarnings("unchecked") Map.Entry<String, TreeStructuredElement> eStringToTreeStructuredElement = (Map.Entry<String, TreeStructuredElement>)theEObject;
				T result = caseEStringToTreeStructuredElement(eStringToTreeStructuredElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.TREE_STRUCTURED_ELEMENT: {
				TreeStructuredElement treeStructuredElement = (TreeStructuredElement)theEObject;
				T result = caseTreeStructuredElement(treeStructuredElement);
				if (result == null) result = caseNamedElement(treeStructuredElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.MAPPED_TREE_STRUCTURED_ELEMENT: {
				MappedTreeStructuredElement mappedTreeStructuredElement = (MappedTreeStructuredElement)theEObject;
				T result = caseMappedTreeStructuredElement(mappedTreeStructuredElement);
				if (result == null) result = caseTreeStructuredElement(mappedTreeStructuredElement);
				if (result == null) result = caseNamedElement(mappedTreeStructuredElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.ABSTRACT_EXPRESSION: {
				AbstractExpression abstractExpression = (AbstractExpression)theEObject;
				T result = caseAbstractExpression(abstractExpression);
				if (result == null) result = casePrologElement(abstractExpression);
				if (result == null) result = caseVisitedExpression(abstractExpression);
				if (result == null) result = caseVisitedExpressionProlog(abstractExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.BLOCK_EXPRESSION: {
				BlockExpression blockExpression = (BlockExpression)theEObject;
				T result = caseBlockExpression(blockExpression);
				if (result == null) result = caseAbstractExpression(blockExpression);
				if (result == null) result = casePrologElement(blockExpression);
				if (result == null) result = caseVisitedExpression(blockExpression);
				if (result == null) result = caseVisitedExpressionProlog(blockExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.AND_EXPRESSION: {
				AndExpression andExpression = (AndExpression)theEObject;
				T result = caseAndExpression(andExpression);
				if (result == null) result = caseBlockExpression(andExpression);
				if (result == null) result = caseAbstractExpression(andExpression);
				if (result == null) result = casePrologElement(andExpression);
				if (result == null) result = caseVisitedExpression(andExpression);
				if (result == null) result = caseVisitedExpressionProlog(andExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.OR_EXPRESSION: {
				OrExpression orExpression = (OrExpression)theEObject;
				T result = caseOrExpression(orExpression);
				if (result == null) result = caseBlockExpression(orExpression);
				if (result == null) result = caseAbstractExpression(orExpression);
				if (result == null) result = casePrologElement(orExpression);
				if (result == null) result = caseVisitedExpression(orExpression);
				if (result == null) result = caseVisitedExpressionProlog(orExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.SINGLE_EXPRESSION: {
				SingleExpression singleExpression = (SingleExpression)theEObject;
				T result = caseSingleExpression(singleExpression);
				if (result == null) result = caseAbstractExpression(singleExpression);
				if (result == null) result = casePrologElement(singleExpression);
				if (result == null) result = caseVisitedExpression(singleExpression);
				if (result == null) result = caseVisitedExpressionProlog(singleExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.SIMPLE_EXPRESSION_EXECUTION_CONDITION: {
				SimpleExpressionExecutionCondition simpleExpressionExecutionCondition = (SimpleExpressionExecutionCondition)theEObject;
				T result = caseSimpleExpressionExecutionCondition(simpleExpressionExecutionCondition);
				if (result == null) result = caseNamedElement(simpleExpressionExecutionCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.NOTED_ELEMENT: {
				NotedElement notedElement = (NotedElement)theEObject;
				T result = caseNotedElement(notedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.VISITED_EXPRESSION: {
				VisitedExpression visitedExpression = (VisitedExpression)theEObject;
				T result = caseVisitedExpression(visitedExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.VISITOR_EXPRESSION: {
				VisitorExpression visitorExpression = (VisitorExpression)theEObject;
				T result = caseVisitorExpression(visitorExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION: {
				SimpleExecutionConditionConfiguration simpleExecutionConditionConfiguration = (SimpleExecutionConditionConfiguration)theEObject;
				T result = caseSimpleExecutionConditionConfiguration(simpleExecutionConditionConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Evaluation Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Evaluation Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvaluationCondition(EvaluationCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exception Evaluation Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exception Evaluation Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExceptionEvaluationCondition(ExceptionEvaluationCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scope Evaluation Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scope Evaluation Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScopeEvaluationCondition(ScopeEvaluationCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Field Evaluation Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Field Evaluation Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFieldEvaluationCondition(FieldEvaluationCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Evaluation Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Evaluation Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterEvaluationCondition(ParameterEvaluationCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Returned Value Evaluation Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Returned Value Evaluation Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReturnedValueEvaluationCondition(ReturnedValueEvaluationCondition object) {
		return null;
	}	

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateContainer(StateContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseState(State object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Final State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Final State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFinalState(FinalState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transition Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transition Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransitionCondition(TransitionCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutionCondition(ExecutionCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EString To Tree Structured Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EString To Tree Structured Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEStringToTreeStructuredElement(Map.Entry<String, TreeStructuredElement> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tree Structured Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tree Structured Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTreeStructuredElement(TreeStructuredElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapped Tree Structured Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapped Tree Structured Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappedTreeStructuredElement(MappedTreeStructuredElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractExpression(AbstractExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockExpression(BlockExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAndExpression(AndExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrExpression(OrExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Single Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Single Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSingleExpression(SingleExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrologElement(PrologElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visited Expression Prolog</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visited Expression Prolog</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitedExpressionProlog(VisitedExpressionProlog object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Expression Execution Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Expression Execution Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleExpressionExecutionCondition(SimpleExpressionExecutionCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Noted Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Noted Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotedElement(NotedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visited Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visited Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitedExpression(VisitedExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitor Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitor Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitorExpression(VisitorExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Execution Condition Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Execution Condition Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleExecutionConditionConfiguration(SimpleExecutionConditionConfiguration object) {
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

} //SemanticSwitch
