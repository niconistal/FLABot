/** * $Id: StereotypedElementModel.java,v 1.6 2006/01/27 00:09:14 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.coremodel;

import org.eclipse.emf.ecore.EObject;/**
 * @model
 */
public interface StereotypedElementModel extends EObject{
	/**
	 * @model
	 */
	Stereotype getStereotype();
	/**	 * Sets the value of the '{@link org.isistan.flabot.coremodel.StereotypedElementModel#getStereotype <em>Stereotype</em>}' reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Stereotype</em>' reference.	 * @see #getStereotype()	 * @generated	 */
	void setStereotype(Stereotype value);

}
