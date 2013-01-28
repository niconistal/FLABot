/**
 * $Id: ForkNode.java,v 1.6 2006/02/09 01:10:07 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.coremodel;

import org.eclipse.emf.common.util.EList;
import org.isistan.flabot.messages.Messages;

/**
 * Represents a fork node. Redefines the number of "nexts" that the node
 * can have to 2.
 * @author $Author: franco $
 * @model
 */
public interface ForkNode extends ResponsibilityNode, NamedElementModel {
	public static final int AND_FORK_TYPE = 0;
	public static final int OR_FORK_TYPE = 1;
	public static final String NAME = Messages.getString("org.isistan.flabot.coremodel.ForkNode.name"); //$NON-NLS-1$
	
	public static final int TWO_OUTPUTS = 2;
	public static final int THREE_OUTPUTS = 3;
	public static final int FOUR_OUTPUTS = 4;
	public static final int FIVE_OUTPUTS = 5;
	/**
	 * Get what type of fork is this instance
	 * @return
	 * @model default="0"
	 */
	int getForkType();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.ForkNode#getForkType <em>Fork Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fork Type</em>' attribute.
	 * @see #getForkType()
	 * @generated
	 */
	void setForkType(int value);

	/**
	 * @model type="ForkCondition" containment="true"
	 */
	EList getConditions();
}
