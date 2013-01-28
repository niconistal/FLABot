package org.isistan.flabot.executionstatemapping.model.semantic;

import org.eclipse.emf.common.util.EList;

/**
 * @model
 */
public interface State extends NamedElement, NotedElement {
    /**
     * @model
     */
    String getName();
    
	/**
     * @model type="TransitionCondition" opposite="sourceState"	containment="true"
     */
    EList<TransitionCondition> getSourceTransitionConditions();
    
    /**
     * @model type="TransitionCondition" opposite="targetState"	
     */
    EList<TransitionCondition> getTargetTransitionConditions();

				/**
	 * Returns the value of the '<em><b>State Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.isistan.flabot.executionstatemapping.model.semantic.StateType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Type</em>' attribute.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.StateType
	 * @see #setStateType(StateType)
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getState_StateType()
	 * @model
	 * @generated
	 */
	StateType getStateType();

				/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.State#getStateType <em>State Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Type</em>' attribute.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.StateType
	 * @see #getStateType()
	 * @generated
	 */
	void setStateType(StateType value);

}
