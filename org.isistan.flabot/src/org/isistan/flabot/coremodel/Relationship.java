/** * $Id: Relationship.java,v 1.7 2005/12/22 23:48:41 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.coremodel;

/**
 * @model
 */
public interface Relationship extends NamedElementModel, PropertyElementModel, StereotypedElementModel, NoteElementModel{	public interface s {};
	/**
	 * Direction of the relationship
	 * @model
	 * @return
	 */
	RelationshipDirection getDirection();
	
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.coremodel.Relationship#getDirection <em>Direction</em>}' attribute.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Direction</em>' attribute.	 * @see org.isistan.flabot.coremodel.RelationshipDirection	 * @see #getDirection()	 * @generated	 */
	void setDirection(RelationshipDirection value);

	/**
	 * @model
	 */
	ComponentModel getSource();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.coremodel.Relationship#getSource <em>Source</em>}' reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Source</em>' reference.	 * @see #getSource()	 * @generated	 */
	void setSource(ComponentModel value);

	/**
	 * @model
	 */
	ComponentModel getTarget();
	/**	 * Sets the value of the '{@link org.isistan.flabot.coremodel.Relationship#getTarget <em>Target</em>}' reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Target</em>' reference.	 * @see #getTarget()	 * @generated	 */
	void setTarget(ComponentModel value);

}