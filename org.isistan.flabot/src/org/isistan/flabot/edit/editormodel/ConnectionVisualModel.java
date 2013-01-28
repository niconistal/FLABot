/** * $Id: ConnectionVisualModel.java,v 1.7 2006/01/27 00:09:20 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.edit.editormodel;

import org.eclipse.emf.common.util.EList;/**
 * ConnectionVisualModel
 * -	Abstract model for all Connection Visual Models in flabot to extend from.
 * -	Extends NodeVisualModel.
 * -	Represents a connection between NodeVisualModels.
 * -	Contains the Connection Bendpoints used to render the line.
 * 
 * @author $Author: mblech $
 * @model
 */
public interface ConnectionVisualModel extends NodeVisualModel {

	/**
	 * @model default=""
	 */
	String getSourceTerminal();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.ConnectionVisualModel#getSourceTerminal <em>Source Terminal</em>}' attribute.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Source Terminal</em>' attribute.	 * @see #getSourceTerminal()	 * @generated	 */
	void setSourceTerminal(String value);

	/**
	 * @model default=""
	 */
	String getTargetTerminal();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.ConnectionVisualModel#getTargetTerminal <em>Target Terminal</em>}' attribute.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Target Terminal</em>' attribute.	 * @see #getTargetTerminal()	 * @generated	 */
	void setTargetTerminal(String value);

	/**
	 * @model opposite="sourceConnections"
	 */
	NodeVisualModel getSource();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.ConnectionVisualModel#getSource <em>Source</em>}' container reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Source</em>' container reference.	 * @see #getSource()	 * @generated	 */
	void setSource(NodeVisualModel value);

	/**
	 * @model opposite="targetConnections"
	 */
	NodeVisualModel getTarget();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.ConnectionVisualModel#getTarget <em>Target</em>}' reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Target</em>' reference.	 * @see #getTarget()	 * @generated	 */
	void setTarget(NodeVisualModel value);

	/**
	 * @model type="ConnectionBendpoint" containment="true"
	 */
	EList getBendpoints();
}
