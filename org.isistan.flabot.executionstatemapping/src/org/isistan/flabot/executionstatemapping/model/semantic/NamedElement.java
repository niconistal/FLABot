package org.isistan.flabot.executionstatemapping.model.semantic;

import org.eclipse.emf.ecore.EObject;

/**
 * @model
 */
public interface NamedElement extends EObject
{
	
	/**
	 * @model default=""
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.NamedElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

}
