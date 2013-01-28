/** * $Id: Responsibility.java,v 1.8 2006/02/03 04:42:26 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.coremodel;

import org.eclipse.emf.common.util.EList;/**
 * Responsibility
 * -	A responsibility is a kind of behavioural feature.
 * -	Contains a description and a set of pre and post conditions.
 * 
 * @model
 */
public interface Responsibility extends BehavioralFeatureModel{
	/**
	 * @model default=""
	 */	
	String getDescription();
	/**	 * Sets the value of the '{@link org.isistan.flabot.coremodel.Responsibility#getDescription <em>Description</em>}' attribute.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Description</em>' attribute.	 * @see #getDescription()	 * @generated	 */
	void setDescription(String value);

	/**
	 * @model type="Condition" containment="true"
	 */
	EList getPreconditions();
	
	/**
	 * @model type="Condition" containment="true"
	 */
	EList getPostconditions();		/**	 * Get the core model for this responsibility	 * @model opposite="responsibilities"	 */	CoreModel getCoreModel();

	/**	 * Sets the value of the '{@link org.isistan.flabot.coremodel.Responsibility#getCoreModel <em>Core Model</em>}' container reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Core Model</em>' container reference.	 * @see #getCoreModel()	 * @generated	 */
	void setCoreModel(CoreModel value);

}
