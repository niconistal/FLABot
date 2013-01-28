/**
 * $Id: ConditionEvent.java,v 1.1 2006/02/24 23:26:25 apersson Exp $
 * $Author: apersson $
 */

package org.isistan.flabot.coremodel;

import org.eclipse.emf.common.util.EList;

/**
 * Represents a conditions event
 * @author $Author: apersson $
 * @model
 */

public interface ConditionEvent extends NamedElementModel, ExtensibleElement{

	/**
	 * The condition of event 
	 * @model default=""
	 */
	
	String getConditionEvent();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.ConditionEvent#getConditionEvent <em>Condition Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition Event</em>' attribute.
	 * @see #getConditionEvent()
	 * @generated
	 */
	void setConditionEvent(String value);

	/**
	 * @model default=""
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.ConditionEvent#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * @model type="Condition"
	 */
	EList getAssociatedConditions();

}
