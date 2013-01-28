/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage
 * @generated
 */
public class SemanticAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SemanticPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SemanticPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SemanticSwitch<Adapter> modelSwitch =
		new SemanticSwitch<Adapter>() {
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseExecutionCondition(ExecutionCondition object) {
				return createExecutionConditionAdapter();
			}
			@Override
			public Adapter caseEvaluationCondition(EvaluationCondition object) {
				return createEvaluationConditionAdapter();
			}
			@Override
			public Adapter caseExceptionEvaluationCondition(ExceptionEvaluationCondition object) {
				return createExceptionEvaluationConditionAdapter();
			}
			@Override
			public Adapter caseScopeEvaluationCondition(ScopeEvaluationCondition object) {
				return createScopeEvaluationConditionAdapter();
			}
			@Override
			public Adapter caseFieldEvaluationCondition(FieldEvaluationCondition object) {
				return createFieldEvaluationConditionAdapter();
			}
			@Override
			public Adapter caseParameterEvaluationCondition(ParameterEvaluationCondition object) {
				return createParameterEvaluationConditionAdapter();
			}
			@Override
			public Adapter caseReturnedValueEvaluationCondition(ReturnedValueEvaluationCondition object) {
				return createReturnedValueEvaluationConditionAdapter();
			}
			@Override
			public Adapter caseStateContainer(StateContainer object) {
				return createStateContainerAdapter();
			}
			@Override
			public Adapter caseState(State object) {
				return createStateAdapter();
			}
			@Override
			public Adapter caseFinalState(FinalState object) {
				return createFinalStateAdapter();
			}
			@Override
			public Adapter caseTransitionCondition(TransitionCondition object) {
				return createTransitionConditionAdapter();
			}
			@Override
			public Adapter caseEStringToTreeStructuredElement(Map.Entry<String, TreeStructuredElement> object) {
				return createEStringToTreeStructuredElementAdapter();
			}
			@Override
			public Adapter caseTreeStructuredElement(TreeStructuredElement object) {
				return createTreeStructuredElementAdapter();
			}
			@Override
			public Adapter caseMappedTreeStructuredElement(MappedTreeStructuredElement object) {
				return createMappedTreeStructuredElementAdapter();
			}
			@Override
			public Adapter caseAbstractExpression(AbstractExpression object) {
				return createAbstractExpressionAdapter();
			}
			@Override
			public Adapter caseBlockExpression(BlockExpression object) {
				return createBlockExpressionAdapter();
			}
			@Override
			public Adapter caseAndExpression(AndExpression object) {
				return createAndExpressionAdapter();
			}
			@Override
			public Adapter caseOrExpression(OrExpression object) {
				return createOrExpressionAdapter();
			}
			@Override
			public Adapter caseSingleExpression(SingleExpression object) {
				return createSingleExpressionAdapter();
			}
			@Override
			public Adapter caseSimpleExpressionExecutionCondition(SimpleExpressionExecutionCondition object) {
				return createSimpleExpressionExecutionConditionAdapter();
			}
			@Override
			public Adapter caseNotedElement(NotedElement object) {
				return createNotedElementAdapter();
			}
			@Override
			public Adapter caseVisitedExpression(VisitedExpression object) {
				return createVisitedExpressionAdapter();
			}
			@Override
			public Adapter caseVisitorExpression(VisitorExpression object) {
				return createVisitorExpressionAdapter();
			}
			@Override
			public Adapter caseSimpleExecutionConditionConfiguration(SimpleExecutionConditionConfiguration object) {
				return createSimpleExecutionConditionConfigurationAdapter();
			}
			@Override
			public Adapter casePrologElement(PrologElement object) {
				return createPrologElementAdapter();
			}
			@Override
			public Adapter caseVisitedExpressionProlog(VisitedExpressionProlog object) {
				return createVisitedExpressionPrologAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.EvaluationCondition <em>Evaluation Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.EvaluationCondition
	 * @generated
	 */
	public Adapter createEvaluationConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.ExceptionEvaluationCondition <em>Exception Evaluation Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExceptionEvaluationCondition
	 * @generated
	 */
	public Adapter createExceptionEvaluationConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.ScopeEvaluationCondition <em>Scope Evaluation Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ScopeEvaluationCondition
	 * @generated
	 */
	public Adapter createScopeEvaluationConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.FieldEvaluationCondition <em>Field Evaluation Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.FieldEvaluationCondition
	 * @generated
	 */
	public Adapter createFieldEvaluationConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.ParameterEvaluationCondition <em>Parameter Evaluation Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ParameterEvaluationCondition
	 * @generated
	 */
	public Adapter createParameterEvaluationConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.ReturnedValueEvaluationCondition <em>Returned Value Evaluation Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ReturnedValueEvaluationCondition
	 * @generated
	 */
	public Adapter createReturnedValueEvaluationConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.StateContainer <em>State Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.StateContainer
	 * @generated
	 */
	public Adapter createStateContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.State
	 * @generated
	 */
	public Adapter createStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.FinalState <em>Final State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.FinalState
	 * @generated
	 */
	public Adapter createFinalStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition <em>Transition Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition
	 * @generated
	 */
	public Adapter createTransitionConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition <em>Execution Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition
	 * @generated
	 */
	public Adapter createExecutionConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>EString To Tree Structured Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createEStringToTreeStructuredElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement <em>Tree Structured Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement
	 * @generated
	 */
	public Adapter createTreeStructuredElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.MappedTreeStructuredElement <em>Mapped Tree Structured Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.MappedTreeStructuredElement
	 * @generated
	 */
	public Adapter createMappedTreeStructuredElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression <em>Abstract Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression
	 * @generated
	 */
	public Adapter createAbstractExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.BlockExpression <em>Block Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.BlockExpression
	 * @generated
	 */
	public Adapter createBlockExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.AndExpression <em>And Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.AndExpression
	 * @generated
	 */
	public Adapter createAndExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.OrExpression <em>Or Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.OrExpression
	 * @generated
	 */
	public Adapter createOrExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.SingleExpression <em>Single Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SingleExpression
	 * @generated
	 */
	public Adapter createSingleExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.prolog.PrologElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.prolog.PrologElement
	 * @generated
	 */
	public Adapter createPrologElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.prolog.VisitedExpressionProlog <em>Visited Expression Prolog</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.prolog.VisitedExpressionProlog
	 * @generated
	 */
	public Adapter createVisitedExpressionPrologAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition <em>Simple Expression Execution Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition
	 * @generated
	 */
	public Adapter createSimpleExpressionExecutionConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.NotedElement <em>Noted Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.NotedElement
	 * @generated
	 */
	public Adapter createNotedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.VisitedExpression <em>Visited Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.VisitedExpression
	 * @generated
	 */
	public Adapter createVisitedExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.VisitorExpression <em>Visitor Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.VisitorExpression
	 * @generated
	 */
	public Adapter createVisitorExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration <em>Simple Execution Condition Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration
	 * @generated
	 */
	public Adapter createSimpleExecutionConditionConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SemanticAdapterFactory
