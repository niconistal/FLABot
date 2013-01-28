/**
 * $Id: JoinNode.java,v 1.3 2006/01/25 01:27:42 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.coremodel;

import org.isistan.flabot.messages.Messages;

/**
 * Represents a fork node. Redefines the number of "previous" that the node
 * can have to 2.
 * @author $Author: dacostae $
 * @model
 */
public interface JoinNode extends ResponsibilityNode, NamedElementModel{
	public static final int AND_JOIN_TYPE = 0;
	public static final int OR_JOIN_TYPE = 1;
	
	public static final int TWO_INPUTS = 2;
	public static final int THREE_INPUTS = 3;
	public static final int FOUR_INPUTS = 4;
	public static final int FIVE_INPUTS = 5;
	public static final String NAME = Messages.getString("org.isistan.flabot.coremodel.JoinNode.name"); //$NON-NLS-1$

	/**
	 * Get what type of join is this instance
	 * @return
	 * @model default="0"
	 */
	int getJoinType();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.JoinNode#getJoinType <em>Join Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Join Type</em>' attribute.
	 * @see #getJoinType()
	 * @generated
	 */
	void setJoinType(int value);

}
