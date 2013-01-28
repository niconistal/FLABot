/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.coremodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditioned Stub</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.ConditionedStub#getStub <em>Stub</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.ConditionedStub#getResponsibilityNode <em>Responsibility Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.isistan.flabot.coremodel.CoremodelPackage#getConditionedStub()
 * @model
 * @generated
 */
public interface ConditionedStub extends NamedElementModel {
	/**
	 * Returns the value of the '<em><b>Stub</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stub</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stub</em>' containment reference.
	 * @see #setStub(StubNode)
	 * @see org.isistan.flabot.coremodel.CoremodelPackage#getConditionedStub_Stub()
	 * @model containment="true"
	 * @generated
	 */
	StubNode getStub();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.ConditionedStub#getStub <em>Stub</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stub</em>' containment reference.
	 * @see #getStub()
	 * @generated
	 */
	void setStub(StubNode value);

	/**
	 * Returns the value of the '<em><b>Responsibility Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Responsibility Node</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Responsibility Node</em>' containment reference.
	 * @see #setResponsibilityNode(ResponsibilityNode)
	 * @see org.isistan.flabot.coremodel.CoremodelPackage#getConditionedStub_ResponsibilityNode()
	 * @model containment="true"
	 * @generated
	 */
	ResponsibilityNode getResponsibilityNode();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.ConditionedStub#getResponsibilityNode <em>Responsibility Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Responsibility Node</em>' containment reference.
	 * @see #getResponsibilityNode()
	 * @generated
	 */
	void setResponsibilityNode(ResponsibilityNode value);

} // ConditionedStub
