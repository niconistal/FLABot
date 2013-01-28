/**
 * $Id: Diagram.java,v 1.9 2005/12/21 20:14:03 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.edit.editormodel;

import org.eclipse.emf.common.util.EList;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.NamedElementModel;

/**
 * Diagram:
 * -	Abstract model for all diagrams in flabot to extend from.
 * -	Holds visual models (children) and notes (by contention), and other visual properties such as grid.
 * 
 * 
 * @author $Author: dacostae $
 * @model abstract="true"
 */
public interface Diagram extends NamedElementModel{
	
	/**
	 * @model type="VisualModel" containment="true" opposite="diagram"
	 */
	EList getChildren();
	
	/**
	 * @model type="org.isistan.flabot.coremodel.Note" containment="true"
	 */
	EList getNotes();

	/**
	 * @model
	 */
	CoreModel getCoreModel();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.Diagram#getCoreModel <em>Core Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Core Model</em>' reference.
	 * @see #getCoreModel()
	 * @generated
	 */
	void setCoreModel(CoreModel value);

	/**
	 * @model opposite="diagrams"
	 */
	Folder getFolder();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.Diagram#getFolder <em>Folder</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Folder</em>' reference.
	 * @see #getFolder()
	 * @generated
	 */
	void setFolder(Folder value);

	/**
	 * @model default="false"
	 */
	Boolean getGridEnabled();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.Diagram#getGridEnabled <em>Grid Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grid Enabled</em>' attribute.
	 * @see #getGridEnabled()
	 * @generated
	 */
	void setGridEnabled(Boolean value);

	/**
	 * @model default="false"
	 */
	Boolean getSnapToGeometryEnabled();
	/**
	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.Diagram#getSnapToGeometryEnabled <em>Snap To Geometry Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snap To Geometry Enabled</em>' attribute.
	 * @see #getSnapToGeometryEnabled()
	 * @generated
	 */
	void setSnapToGeometryEnabled(Boolean value);

}