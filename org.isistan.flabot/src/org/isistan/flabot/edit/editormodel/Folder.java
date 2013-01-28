/** * $Id: Folder.java,v 1.6 2006/01/27 00:09:20 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.edit.editormodel;

import org.eclipse.emf.common.util.EList;import org.eclipse.emf.ecore.EObject;/**
 * Model for all folders in flabot.
 * @author $Author: mblech $
 * @model
 */
public interface Folder extends EObject{
	
	/**
	 * @model default=""
	 */
	String getName();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.Folder#getName <em>Name</em>}' attribute.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Name</em>' attribute.	 * @see #getName()	 * @generated	 */
	void setName(String value);

	/**
	 * @model type="Folder" containment="true"
	 */
	EList getFolders();
	
	/**
	 * @model opposite="folders"
	 */
	Folder getParent();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.Folder#getParent <em>Parent</em>}' container reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Parent</em>' container reference.	 * @see #getParent()	 * @generated	 */
	void setParent(Folder value);

	/**
	 * @model type="Diagram" opposite="folder"
	 */
	EList getDiagrams();
	
	/**
	 * Get the file where this folder is contained
	 * @model
	 */
	FlabotFileModel getFileModel();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.Folder#getFileModel <em>File Model</em>}' reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>File Model</em>' reference.	 * @see #getFileModel()	 * @generated	 */
	void setFileModel(FlabotFileModel value);

}