/** * $Id: Point.java,v 1.6 2006/01/27 00:09:20 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.edit.editormodel;

import org.eclipse.emf.ecore.EObject;/**
 * Point storing an integer X and Y
 * @author $Author: mblech $
 * @model
 */
public interface Point extends EObject{
	
	/**
	 * The X of this point
	 * @model
	 */
	int getX();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.Point#getX <em>X</em>}' attribute.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>X</em>' attribute.	 * @see #getX()	 * @generated	 */
	void setX(int value);

	/**
	 * The Y of this point
	 * @model
	 */
	int getY();
	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.Point#getY <em>Y</em>}' attribute.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Y</em>' attribute.	 * @see #getY()	 * @generated	 */
	void setY(int value);

	Point clone();

}
