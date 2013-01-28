/**
 * $Id: SimplePathNode.java,v 1.3 2006/02/08 20:08:17 apersson Exp $
 * $Author: apersson $
 */
package org.isistan.flabot.coremodel;

/**
 * This class represents simple path nodes. These can have only one predecessor
 * and one successor
 * @author $Author: apersson $
 * @model
 */
public interface SimplePathNode extends PathNode, NamedElementModel{
	
	/**
	 * The Use Case Map associated with this node
	 * @model
	 */
	UseCaseMap getMap();
	

	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.SimplePathNode#getMap <em>Map</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map</em>' reference.
	 * @see #getMap()
	 * @generated
	 */
	void setMap(UseCaseMap value);

}
