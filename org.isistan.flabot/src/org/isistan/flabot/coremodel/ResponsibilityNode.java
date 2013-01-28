/**
 * $Id: ResponsibilityNode.java,v 1.19 2006/03/29 01:53:05 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.coremodel;

import org.eclipse.emf.common.notify.Adapter;

/**
 * Represents a path node that is linked to a responsibility
 * @author $Author: franco $
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ResponsibilityNodeGeneral'"
 */
public interface ResponsibilityNode extends SimplePathNode, Adapter {
		
	/**
	 * The responsibility associated with this responsibility node
	 * @model
	 */
	Responsibility getResponsibility();
		
	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.ResponsibilityNode#getResponsibility <em>Responsibility</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Responsibility</em>' reference.
	 * @see #getResponsibility()
	 * @generated
	 */
	void setResponsibility(Responsibility value);

	/**
	 * The specific component role that this node's responsibility refers
	 * to.
	 * @model
	 */
	ComponentRole getRole();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.ResponsibilityNode#getRole <em>Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' reference.
	 * @see #getRole()
	 * @generated
	 */
	void setRole(ComponentRole value);

	/**
	 * Returns the value of the '<em><b>Inputs Count</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs Count</em>' attribute.
	 * @see #setInputsCount(int)
	 * @see org.isistan.flabot.coremodel.CoremodelPackage#getResponsibilityNode_InputsCount()
	 * @model default="1"
	 * @generated
	 */
	int getInputsCount();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.ResponsibilityNode#getInputsCount <em>Inputs Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inputs Count</em>' attribute.
	 * @see #getInputsCount()
	 * @generated
	 */
	void setInputsCount(int value);

	/**
	 * Returns the value of the '<em><b>Outputs Count</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs Count</em>' attribute.
	 * @see #setOutputsCount(int)
	 * @see org.isistan.flabot.coremodel.CoremodelPackage#getResponsibilityNode_OutputsCount()
	 * @model default="1"
	 * @generated
	 */
	int getOutputsCount();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.ResponsibilityNode#getOutputsCount <em>Outputs Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outputs Count</em>' attribute.
	 * @see #getOutputsCount()
	 * @generated
	 */
	void setOutputsCount(int value);

}