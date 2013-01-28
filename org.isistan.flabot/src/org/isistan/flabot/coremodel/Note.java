/** * $Id: Note.java,v 1.5 2006/01/27 00:09:14 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.coremodel;

import org.eclipse.emf.common.util.EList;import org.eclipse.emf.ecore.EObject;/**
 * @model
 */
public interface Note extends EObject{
	
	/**
	 * @model default=""
	 */
	String getNote();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.coremodel.Note#getNote <em>Note</em>}' attribute.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Note</em>' attribute.	 * @see #getNote()	 * @generated	 */
	void setNote(String value);

	/**
	 * @model type="NoteElementModel"
	 */
	EList getTargets();
}