package org.isistan.flabot.executionstatemapping.model.semantic;


/**
 * @model 
 */
public interface TransitionCondition extends NotedElement {
    /**
     * @model opposite="sourceTransitionConditions"
     */
    State getSourceState();
    
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition#getSourceState <em>Source State</em>}' reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source State</em>' reference.
	 * @see #getSourceState()
	 * @generated
	 */
        void setSourceState(State value);

    /**
     * @model opposite="targetTransitionConditions"
     */
    State getTargetState();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition#getTargetState <em>Target State</em>}' reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target State</em>' reference.
	 * @see #getTargetState()
	 * @generated
	 */
        void setTargetState(State value);

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
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getTransitionCondition_ExecutionCondition()
	 * @model
	 * @generated
	 */
	ExecutionCondition getExecutionCondition();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition#getExecutionCondition <em>Execution Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution Condition</em>' reference.
	 * @see #getExecutionCondition()
	 * @generated
	 */
	void setExecutionCondition(ExecutionCondition value);
      

}
