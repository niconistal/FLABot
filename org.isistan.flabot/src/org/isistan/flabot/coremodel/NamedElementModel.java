/** * $Id: NamedElementModel.java,v 1.7 2006/01/27 00:09:14 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.coremodel;

import org.eclipse.emf.ecore.EObject;/**
 * @model
 */
public interface NamedElementModel extends EObject {
	/**
	 * @model default=""
	 */
	String getName();
	
	/**
	 * 
	 */
	String getID();

	/**	 * Sets the value of the '{@link org.isistan.flabot.coremodel.NamedElementModel#getName <em>Name</em>}' attribute.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Name</em>' attribute.	 * @see #getName()	 * @generated	 */
	void setName(String value);

}