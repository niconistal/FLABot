package org.isistan.flabot.executionstatemapping.model.semantic;


/**
 * @model
 */
public interface FieldEvaluationCondition extends EvaluationCondition {

	/**
	 * Returns the value of the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field Name</em>' attribute.
	 * @see #setFieldName(String)
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getFieldEvaluationCondition_FieldName()
	 * @model
	 * @generated
	 */
	String getFieldName();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.FieldEvaluationCondition#getFieldName <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field Name</em>' attribute.
	 * @see #getFieldName()
	 * @generated
	 */
	void setFieldName(String value);

}
