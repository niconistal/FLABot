/** * $Id: InterfaceModel.java,v 1.9 2006/01/27 00:09:14 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.coremodel;

import org.isistan.flabot.messages.Messages;/**
 * InterfaceModel
 * -	Represents a component’s provided or required interface.
 * 
 * @model
 */
public interface InterfaceModel extends NamedElementModel{
	static final String DEFAULT_NAME = Messages.getString("org.isistan.flabot.coremodel.InterfaceModel.defaultName"); //$NON-NLS-1$
	/**
	 * @model
	 */
	PortModel getPort();
	/**	 * Sets the value of the '{@link org.isistan.flabot.coremodel.InterfaceModel#getPort <em>Port</em>}' reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Port</em>' reference.	 * @see #getPort()	 * @generated	 */
	void setPort(PortModel value);

}
