/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Final State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.FinalState#getExecutionState <em>Execution State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getFinalState()
 * @model
 * @generated
 */
public interface FinalState extends State {
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
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getFinalState_ExecutionState()
	 * @model
	 * @generated
	 */
	ExecutionStateValue getExecutionState();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.FinalState#getExecutionState <em>Execution State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution State</em>' attribute.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue
	 * @see #getExecutionState()
	 * @generated
	 */
	void setExecutionState(ExecutionStateValue value);

} // FinalState
