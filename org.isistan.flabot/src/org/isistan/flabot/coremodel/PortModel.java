/** * $Id: PortModel.java,v 1.10 2006/01/25 21:14:09 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.coremodel;

import org.eclipse.emf.common.util.EList;import org.isistan.flabot.messages.Messages;/**
 * PortModel
 * -	Represents a container for a group of component’s interfaces.
 * -	Holds interfaces in two lists: provided and required.
 * 
 * @model
 */
public interface PortModel extends NamedElementModel, PropertyElementModel{
	static final String DEFAULT_NAME = Messages.getString("org.isistan.flabot.coremodel.PortModel.defaultName"); //$NON-NLS-1$

	/**
	 * @model type="InterfaceModel" containment="true"
	 */
	EList getProvideds();
	
	/**
	 * @model type="InterfaceModel" containment="true"
	 */
	EList getRequireds();

	/**
	 * @model opposite="ownedPorts"
	 */
	ComponentModel getComponent();
	/**	 * Sets the value of the '{@link org.isistan.flabot.coremodel.PortModel#getComponent <em>Component</em>}' container reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Component</em>' container reference.	 * @see #getComponent()	 * @generated	 */
	void setComponent(ComponentModel value);

}
