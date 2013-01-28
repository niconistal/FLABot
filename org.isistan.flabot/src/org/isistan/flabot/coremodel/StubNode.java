package org.isistan.flabot.coremodel;

/**
 * Represents a sutb node
 * @author $Author: franco $
 * @model
 */

public interface StubNode extends SimplePathNode, NamedElementModel{

	/**
	 * The Family associated with the map if it is Architectural Level
	 * @model
	 */	
	Family getFamily();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.StubNode#getFamily <em>Family</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Family</em>' reference.
	 * @see #getFamily()
	 * @generated
	 */
	void setFamily(Family value);

	/**
	 * The Start Point Reference
	 * @model
	 */	
	SimplePathNode getStartPointReference ();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.StubNode#getStartPointReference <em>Start Point Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Point Reference</em>' reference.
	 * @see #getStartPointReference()
	 * @generated
	 */
	void setStartPointReference(SimplePathNode value);

	/**
	 * The End Point Reference
	 * @model
	 */
	
	SimplePathNode getEndPointReference ();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.StubNode#getEndPointReference <em>End Point Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Point Reference</em>' reference.
	 * @see #getEndPointReference()
	 * @generated
	 */
	void setEndPointReference(SimplePathNode value);

	/**
	 * @model
	 */
	UseCaseMap getReferencedMap();
	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.StubNode#getReferencedMap <em>Referenced Map</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Map</em>' reference.
	 * @see #getReferencedMap()
	 * @generated
	 */
	void setReferencedMap(UseCaseMap value);

}
