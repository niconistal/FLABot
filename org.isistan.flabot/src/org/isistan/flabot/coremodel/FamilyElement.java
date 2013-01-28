/** * $Id: FamilyElement.java,v 1.2 2005/12/22 23:48:41 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.coremodel;

/**
 * Represents a State of a family to be used in mapping dependencies
 * @author $Author: dacostae $
 * @model
 */
public interface FamilyElement extends NamedElementModel{
	
	/**
	 * The Secenario of the family
	 * @model
	 */
	UseCaseMap getUseCaseMap();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.coremodel.FamilyElement#getUseCaseMap <em>Use Case Map</em>}' reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Use Case Map</em>' reference.	 * @see #getUseCaseMap()	 * @generated	 */
	void setUseCaseMap(UseCaseMap value);

	/**
	 * The Functional Component of the family
	 * @model
	 */
	ComponentRole getFunctionalComponent();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.coremodel.FamilyElement#getFunctionalComponent <em>Functional Component</em>}' reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Functional Component</em>' reference.	 * @see #getFunctionalComponent()	 * @generated	 */
	void setFunctionalComponent(ComponentRole value);

	/**
	 * The Architectural Component of the family
	 * @model
	 */
	ComponentRole getArchitecturalComponent ();

	/**	 * Sets the value of the '{@link org.isistan.flabot.coremodel.FamilyElement#getArchitecturalComponent <em>Architectural Component</em>}' reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Architectural Component</em>' reference.	 * @see #getArchitecturalComponent()	 * @generated	 */
	void setArchitecturalComponent(ComponentRole value);

}