/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Expression Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.SingleExpression#getExecutionCondition <em>Execution Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getSingleExpression()
 * @model
 * @generated
 */
public interface SingleExpression extends AbstractExpression {
	/**
	 * Returns the value of the '<em><b>Execution Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Condition</em>' reference.
	 * @see #setExecutionCondition(ExecutionCondition)
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getSingleExpression_ExecutionCondition()
	 * @model
	 * @generated
	 */
	ExecutionCondition getExecutionCondition();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.SingleExpression#getExecutionCondition <em>Execution Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution Condition</em>' reference.
	 * @see #getExecutionCondition()
	 * @generated
	 */
	void setExecutionCondition(ExecutionCondition value);

} // SingleExpressionEvent
