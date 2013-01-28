/**
 * 
 */
package org.isistan.flabot.executionstatemapping.model.semantic;

import org.eclipse.emf.ecore.EObject;

/**
 * @model
 */
public interface EvaluationCondition extends EObject {
	/**
	 * @model
	 */
	String getValue();


	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.EvaluationCondition#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * @model
	 */
	ConditionValue getCondition();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.EvaluationCondition#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ConditionValue
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(ConditionValue value);
	


}
