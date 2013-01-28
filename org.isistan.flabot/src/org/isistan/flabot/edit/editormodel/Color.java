/** * $Id: Color.java,v 1.7 2006/01/27 00:09:20 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.edit.editormodel;

import org.eclipse.emf.ecore.EObject;/**
 * Color storing Red Green and Blue
 * @author $Author: mblech $
 * @model
 */
public interface Color extends EObject{
	
	/**
	 * The red of this color
	 * @model
	 */
	int getRed();

	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.Color#getRed <em>Red</em>}' attribute.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Red</em>' attribute.	 * @see #getRed()	 * @generated	 */
	void setRed(int value);

	/**
	 * The green of this color
	 * @model
	 */
	int getGreen();

	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.Color#getGreen <em>Green</em>}' attribute.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Green</em>' attribute.	 * @see #getGreen()	 * @generated	 */
	void setGreen(int value);

	/**
	 * The blue of this color
	 * @model
	 */
	int getBlue();
	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.Color#getBlue <em>Blue</em>}' attribute.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Blue</em>' attribute.	 * @see #getBlue()	 * @generated	 */
	void setBlue(int value);

	Color clone();
}
