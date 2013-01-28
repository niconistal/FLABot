/** * $Id: ComponentModel.java,v 1.19 2006/03/29 01:53:05 franco Exp $ * $Author: franco $ */package org.isistan.flabot.coremodel;

import org.eclipse.emf.common.notify.Adapter;import org.eclipse.emf.common.util.EList;import org.isistan.flabot.messages.Messages;/** 
/**
 * ComponentModel
 * -	Represents a component.
 * -	Contains a set of features, such as responsibilities, and a set of owned ports containing interfaces.
 * 
 * @model
 */
public interface ComponentModel extends ExtensibleElement, NamedElementModel, PropertyElementModel, StereotypedElementModel, NoteElementModel, Adapter{
	static final String DEFAULT_NAME = Messages.getString("org.isistan.flabot.coremodel.ComponentModel.defaultName"); //$NON-NLS-1$

	/**	 * The features provided by this component
	 * @model type="FeatureModel" opposite="components"
	 */
	EList getFeatures();
		
	/**
	 * @model type="PortModel" containment="true"
	 */
	EList getOwnedPorts();		/**	 * Get the core model for this component	 * @model opposite="components"	 */	CoreModel getCoreModel();	

	/**	 * Sets the value of the '{@link org.isistan.flabot.coremodel.ComponentModel#getCoreModel <em>Core Model</em>}' container reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Core Model</em>' container reference.	 * @see #getCoreModel()	 * @generated	 */
	void setCoreModel(CoreModel value);

	/**	 * Returns the components directly extending this component.	 * @param component	 * @return	 */	ComponentModel[] getSubComponents();		/**	 * Returns the components directly extended by this component.	 * @param component	 * @return	 */	ComponentModel[] getSuperComponents();		/**	 * Returns all the components extending this component.	 * @param component	 * @return	 */	ComponentModel[] getAllSubComponents();		/**	 * Returns all the components extended by this component.	 * @param component	 * @return	 */	ComponentModel[] getAllSuperComponents();
}