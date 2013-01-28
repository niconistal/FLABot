/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exception Evaluation Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.ExceptionEvaluationCondition#isCheckAnyException <em>Check Any Exception</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getExceptionEvaluationCondition()
 * @model
 * @generated
 */
public interface ExceptionEvaluationCondition extends EvaluationCondition {
	/**
	 * Returns the value of the '<em><b>Check Any Exception</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Check Any Exception</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Check Any Exception</em>' attribute.
	 * @see #setCheckAnyException(boolean)
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getExceptionEvaluationCondition_CheckAnyException()
	 * @model
	 * @generated
	 */
	boolean isCheckAnyException();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.ExceptionEvaluationCondition#isCheckAnyException <em>Check Any Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Check Any Exception</em>' attribute.
	 * @see #isCheckAnyException()
	 * @generated
	 */
	void setCheckAnyException(boolean value);

} // ExceptionEvaluationCondition
