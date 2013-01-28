/**
 * 
 */
package org.isistan.flabot.engine.executionstate;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * Represents a state determination diagnostic
 * @author mblech
 * @model
 */
public interface Diagnostic extends EObject {

	/**
	 * Get the state determination strategy that created this diagnostic
	 * @return
	 * @model
	 */
	StateDeterminationStrategy getDiagnostician();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.engine.executionstate.Diagnostic#getDiagnostician <em>Diagnostician</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagnostician</em>' reference.
	 * @see #getDiagnostician()
	 * @generated
	 */
	void setDiagnostician(StateDeterminationStrategy value);

	/**
	 * Get the diagnostic description
	 * @return
	 * @model
	 */
	String getDescription();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.engine.executionstate.Diagnostic#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Get the additional data provided by the state determination strategy
	 * @return
	 * @model keyType="String" valueType="Object"
	 */
	EMap getAdditionalData();
	
	/**
	 * Get the state that was determined
	 * @return
	 * @model
	 */
	ExecutionState getState();
	/**
	 * Sets the value of the '{@link org.isistan.flabot.engine.executionstate.Diagnostic#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.isistan.flabot.engine.executionstate.ExecutionState
	 * @see #getState()
	 * @generated
	 */
	void setState(ExecutionState value);

}
