/** * $Id: Property.java,v 1.5 2006/01/27 00:09:14 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.coremodel;

import org.eclipse.emf.ecore.EObject;/**
 * Property
 * -	Represents a key-value pair of string semantically relevant.
 * -	Currently a property can be added only to ComponentModels.
 * 
 * @model
 */
public interface Property extends EObject{

	/**
	 * @model default=""
	 */
	String getName();

	/**	 * Sets the value of the '{@link org.isistan.flabot.coremodel.Property#getName <em>Name</em>}' attribute.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Name</em>' attribute.	 * @see #getName()	 * @generated	 */
	void setName(String value);

	/**
	 * @model default=""
	 */
	String getValue();

	/**	 * Sets the value of the '{@link org.isistan.flabot.coremodel.Property#getValue <em>Value</em>}' attribute.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Value</em>' attribute.	 * @see #getValue()	 * @generated	 */
	void setValue(String value);

}
