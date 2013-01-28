/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Execution Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition#getExecutionState <em>Execution State</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getSimpleExpressionExecutionCondition()
 * @model
 * @generated
 */
public interface SimpleExpressionExecutionCondition extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Execution State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution State</em>' attribute.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue
	 * @see #setExecutionState(ExecutionStateValue)
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getSimpleExpressionExecutionCondition_ExecutionState()
	 * @model
	 * @generated
	 */
	ExecutionStateValue getExecutionState();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition#getExecutionState <em>Execution State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution State</em>' attribute.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue
	 * @see #getExecutionState()
	 * @generated
	 */
	void setExecutionState(ExecutionStateValue value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(AbstractExpression)
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getSimpleExpressionExecutionCondition_Expression()
	 * @model containment="true"
	 * @generated
	 */
	AbstractExpression getExpression();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(AbstractExpression value);

} // EventExecutionCondition
