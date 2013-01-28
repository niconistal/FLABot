package org.isistan.flabot.executionstatemapping.model.semantic;

import org.eclipse.emf.common.util.EList;
/**
 * @model
 */
public interface ParameterEvaluationCondition extends EvaluationCondition {

	/**
	 * Returns the value of the '<em><b>Parameter Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Position</em>' attribute.
	 * @see #setParameterPosition(int)
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getParameterEvaluationCondition_ParameterPosition()
	 * @model
	 * @generated
	 */
	int getParameterPosition();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.ParameterEvaluationCondition#getParameterPosition <em>Parameter Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Position</em>' attribute.
	 * @see #getParameterPosition()
	 * @generated
	 */
	void setParameterPosition(int value);

	/**
	 * Returns the value of the '<em><b>Field Evaluation Conditions</b></em>' containment reference list.
	 * The list contents are of type {@link org.isistan.flabot.executionstatemapping.model.semantic.FieldEvaluationCondition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field Evaluation Conditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field Evaluation Conditions</em>' containment reference list.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getParameterEvaluationCondition_FieldEvaluationConditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<FieldEvaluationCondition> getFieldEvaluationConditions();

}
