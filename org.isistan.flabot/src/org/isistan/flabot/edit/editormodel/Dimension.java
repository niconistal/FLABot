/** * $Id: Dimension.java,v 1.6 2006/01/27 00:09:20 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.edit.editormodel;


import org.eclipse.emf.ecore.EObject;/**
 * Dimension storing an integer witdh and height
 * @author $Author: mblech $
 * @model
 */
public interface Dimension extends EObject{
	
	/**
	 * The width of this dimension
	 * @model
	 */
	int getWidth();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.Dimension#getWidth <em>Width</em>}' attribute.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Width</em>' attribute.	 * @see #getWidth()	 * @generated	 */
	void setWidth(int value);

	/**
	 * The height of this dimension
	 * @model
	 */
	int getHeight();
	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.Dimension#getHeight <em>Height</em>}' attribute.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Height</em>' attribute.	 * @see #getHeight()	 * @generated	 */
	void setHeight(int value);

	public Dimension clone();

}
