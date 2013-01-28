/** * $Id: InterfaceLink.java,v 1.6 2005/12/22 23:48:41 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.coremodel;

/**
 * InterfaceLink
 * -	Represents a directed connection between a pair of interfaces (Source and Target).
 * 
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='InterfacesMustHaveSameName'"
 */
public interface InterfaceLink extends NamedElementModel, NoteElementModel {
	
	/**
	 * @model
	 */
	InterfaceModel getSource();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.coremodel.InterfaceLink#getSource <em>Source</em>}' reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Source</em>' reference.	 * @see #getSource()	 * @generated	 */
	void setSource(InterfaceModel value);

	/**
	 * @model
	 */
	InterfaceModel getTarget();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.coremodel.InterfaceLink#getTarget <em>Target</em>}' reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Target</em>' reference.	 * @see #getTarget()	 * @generated	 */
	void setTarget(InterfaceModel value);

}
