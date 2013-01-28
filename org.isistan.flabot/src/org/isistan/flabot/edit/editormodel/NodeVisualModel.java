/** * $Id: NodeVisualModel.java,v 1.10 2006/02/21 00:46:20 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.editormodel;

import org.eclipse.emf.common.util.EList;/**
 * NodeVisualModel
 * -	Abstract model for all Node Visual Models in flabot to extend from.
 * -	Extends VisualModel.
 * -	Represents a visual model that can have connections to other visual models thought ConnectionVisualModels.
 * 
 * @author $Author: franco $
 * @model
 */
public interface NodeVisualModel extends VisualModel {
	/**
	 * @model default=""
	 */
	String getRotation();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.NodeVisualModel#getRotation <em>Rotation</em>}' attribute.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Rotation</em>' attribute.	 * @see #getRotation()	 * @generated	 */
	void setRotation(String value);

	/**
	 * @model type="ConnectionVisualModel" opposite="source" containment="true"
	 */
	EList getSourceConnections();
	
	/**
	 * @model type="ConnectionVisualModel" opposite="target"
	 */
	EList getTargetConnections();		/**
	 * Get this visual model's absolute location, that is the sum of its
	 * parent's absolute location and its relative location
	 * @return
	 */
	Point getAbsoluteLocation();
}
