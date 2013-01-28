/** * $Id: ConnectionBendpoint.java,v 1.11 2006/01/27 00:09:20 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.edit.editormodel;

import org.eclipse.emf.ecore.EObject;/**
 * Abstract model for all Connection Bendpoint in flabot to extend from.
 * 
 * ConnectionBendpoint
 * - Represents a bendpoint used to render the line of a Connection Visual Model.
 * 
 * @author $Author: mblech $
 * @model
 */
public interface ConnectionBendpoint extends EObject{
	/**
	 * @model containment="true"
	 */
	Dimension getFirstRelativeDimension();
	

	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.ConnectionBendpoint#getFirstRelativeDimension <em>First Relative Dimension</em>}' containment reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>First Relative Dimension</em>' containment reference.	 * @see #getFirstRelativeDimension()	 * @generated	 */
	void setFirstRelativeDimension(Dimension value);

	/**
	 * @model containment="true"
	 */
	Dimension getSecondRelativeDimension();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.ConnectionBendpoint#getSecondRelativeDimension <em>Second Relative Dimension</em>}' containment reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Second Relative Dimension</em>' containment reference.	 * @see #getSecondRelativeDimension()	 * @generated	 */
	void setSecondRelativeDimension(Dimension value);

	/**
	 * @model default="0.5f" 	   
	 */
	float getWeight();	

	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.ConnectionBendpoint#getWeight <em>Weight</em>}' attribute.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Weight</em>' attribute.	 * @see #getWeight()	 * @generated	 */
	void setWeight(float value);

	ConnectionBendpoint clone();

}