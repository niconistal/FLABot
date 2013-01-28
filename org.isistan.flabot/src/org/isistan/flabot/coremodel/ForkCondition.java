/**
 * $Id: ForkCondition.java,v 1.1 2006/02/09 01:10:07 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.coremodel;

/**
 * Represents a condition of an Or Fork
 * @author $Author: franco $
 * @model
 */
public interface ForkCondition extends NamedElementModel{
	/**
	 * @model default=""
	 */
	String getCondition();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.ForkCondition#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(String value);

}
