/**

import org.eclipse.emf.ecore.EObject;
 * @model
 */

public interface Dependency extends EObject {
	
	/**
	 * 
	 * @model
	 */
	
	String getType();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.Dependency#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * 
	 * @model 
	 */
	
	Object getEvent();
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.Dependency#getEvent <em>Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' attribute.
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(Object value);

}