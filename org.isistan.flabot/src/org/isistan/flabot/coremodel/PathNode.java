/** * $Id: PathNode.java,v 1.12 2006/02/23 00:05:12 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.coremodel;

import org.eclipse.emf.common.util.EList;/**
 * PathNode
 * -	Is the common abstract Path Node for all kind of nodes: Responsibility, Simple, Join and Fork.
 * -	Holds references the next and previous of nodes in the path, this is a list because fork and join path nodes can have more than one.
 * 
 * @model abstract="true"
 */
public interface PathNode extends NoteElementModel, InterfacePrologCode, ExtensibleElement {
	/**
	 * @model opposite="nodes"
	 */
	Path getPath();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.coremodel.PathNode#getPath <em>Path</em>}' container reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Path</em>' container reference.	 * @see #getPath()	 * @generated	 */
	void setPath(Path value);

	/**
	 * Get the node's predecessors.
	 * Access to this list is deprecated, please use
	 * the unmodifiable version instead. To add or remove elements, use
	 * addPrevious and removePrevious.
	 * @model type="PathNode" opposite="next"
	 * @deprecated
	 */
	EList getPrevious();
	
	/**
	 * Unmodifiable version of the getPrevious method. Returns a list that 
	 * has the same contents but can't be modified.
	 * @return
	 */
	EList uGetPrevious();
	
	/**
	 * Add a new previous to the node
	 * @param previous the new previous to be added
	 * @return whether the node was actually added or not
	 */
	boolean addPrevious(PathNode previous);
	
	/**
	 * Remove a previous from the node
	 * @param previous the previous to be removed
	 * @return whether tne node was actually removed or not
	 */
	boolean removePrevious(PathNode previous);
	
	/**
	 * Get the node's successors. 
	 * Access to this list is deprecated, please use
	 * the unmodifiable version instead. To add or remove elements, use
	 * addNext and removeNext.
	 * @model type="PathNode" opposite="previous"
	 * @deprecated
	 */
	EList getNext();
	
	/**
	 * Unmodifiable version of the getNext method. Returns a list that 
	 * has the same contents but can't be modified.
	 * @return
	 */
	EList uGetNext();
	
	/**
	 * Add a next to the node. 
	 * @param next the next to be added
	 * @return whether the node was actually added or not
	 * 
	 */
	boolean addNext(PathNode next);
	
	/**
	 * Remove a next from the node
	 * @param next the node to be removed
	 * @return whether the node was actually removed or not
	 */
	boolean removeNext(PathNode next);

	/**
	 * Whether this node is a start node or not
	 */
	boolean isStart();
	
	/**
	 * Whether this node is an end node or not
	 */
	boolean isEnd();

}
