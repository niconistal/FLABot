/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage
 * @generated
 */
public interface SemanticFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SemanticFactory eINSTANCE = org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Exception Evaluation Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exception Evaluation Condition</em>'.
	 * @generated
	 */
	ExceptionEvaluationCondition createExceptionEvaluationCondition();

	/**
	 * Returns a new object of class '<em>Scope Evaluation Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scope Evaluation Condition</em>'.
	 * @generated
	 */
	ScopeEvaluationCondition createScopeEvaluationCondition();

	/**
	 * Returns a new object of class '<em>Field Evaluation Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Field Evaluation Condition</em>'.
	 * @generated
	 */
	FieldEvaluationCondition createFieldEvaluationCondition();

	/**
	 * Returns a new object of class '<em>Parameter Evaluation Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Evaluation Condition</em>'.
	 * @generated
	 */
	ParameterEvaluationCondition createParameterEvaluationCondition();

	/**
	 * Returns a new object of class '<em>Returned Value Evaluation Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Returned Value Evaluation Condition</em>'.
	 * @generated
	 */
	ReturnedValueEvaluationCondition createReturnedValueEvaluationCondition();
	
	/**
	 * Returns a new object of class '<em>State Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Container</em>'.
	 * @generated
	 */
	StateContainer createStateContainer();

	/**
	 * Returns a new object of class '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State</em>'.
	 * @generated
	 */
	State createState();

	/**
	 * Returns a new object of class '<em>Final State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Final State</em>'.
	 * @generated
	 */
	FinalState createFinalState();

	/**
	 * Returns a new object of class '<em>Transition Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition Condition</em>'.
	 * @generated
	 */
	TransitionCondition createTransitionCondition();

	/**
	 * Returns a new object of class '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Element</em>'.
	 * @generated
	 */
	NamedElement createNamedElement();

	/**
	 * Returns a new object of class '<em>Execution Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Condition</em>'.
	 * @generated
	 */
	ExecutionCondition createExecutionCondition();

	/**
	 * Returns a new object of class '<em>Tree Structured Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tree Structured Element</em>'.
	 * @generated
	 */
	TreeStructuredElement createTreeStructuredElement();
		
	TreeStructuredElement createTreeStructuredElement(TreeType treeType);

	/**
	 * Returns a new object of class '<em>Mapped Tree Structured Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapped Tree Structured Element</em>'.
	 * @generated
	 */
	MappedTreeStructuredElement createMappedTreeStructuredElement();
	
	/**
	 * Returns a new object of class '<em>And Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And Expression</em>'.
	 * @generated
	 */
	AndExpression createAndExpression();

	/**
	 * Returns a new object of class '<em>Or Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or Expression</em>'.
	 * @generated
	 */
	OrExpression createOrExpression();

	/**
	 * Returns a new object of class '<em>Single Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Single Expression</em>'.
	 * @generated
	 */
	SingleExpression createSingleExpression();

	/**
	 * Returns a new object of class '<em>Simple Expression Execution Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Expression Execution Condition</em>'.
	 * @generated
	 */
	SimpleExpressionExecutionCondition createSimpleExpressionExecutionCondition();

	/**
	 * Returns a new object of class '<em>Noted Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Noted Element</em>'.
	 * @generated
	 */
	NotedElement createNotedElement();

	/**
	 * Returns a new object of class '<em>Simple Execution Condition Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Execution Condition Configuration</em>'.
	 * @generated
	 */
	SimpleExecutionConditionConfiguration createSimpleExecutionConditionConfiguration();

	MappedTreeStructuredElement createMappedTreeStructuredElement(TreeType treeType);

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SemanticPackage getSemanticPackage();

} //SemanticFactory
