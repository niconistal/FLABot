/**
 * $Id: FlabotFileModel.java,v 1.17 2006/02/23 00:05:13 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.edit.editormodel;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.ExtensibleElement;

/**
 * This model represents the contents of a .flabot file: a core model, a set of
 * diagrams and a set of imported .flabot files
 * 
 * FlabotFileModel
 * -	This model represents the contents of a .flabot file
 * -	Is a simple container for all FLABot elements, such as: a core model, a set of diagrams, a set of imported .flabot files, etc.
 * 
 * @author $Author: dacostae $
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='InterfaceLinkMappedToPathGeneral ComponentUniqueName'"
 */
public interface FlabotFileModel extends ExtensibleElement {
	/**
	 * The core model
	 * 
	 * @model type="CoreModel" containment="true"
	 */
	CoreModel getCoreModel();

	/**
	 * The project id
	 * 
	 * @model default=""
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.FlabotFileModel#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * The project version
	 * 
	 * @model default="0.0.1"
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.FlabotFileModel#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * The project name
	 * 
	 * @model default=""
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.FlabotFileModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * The project provider
	 * 
	 * @model default=""
	 */
	String getProvider();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.FlabotFileModel#getProvider <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider</em>' attribute.
	 * @see #getProvider()
	 * @generated
	 */
	void setProvider(String value);

	/**
	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.FlabotFileModel#getCoreModel <em>Core Model</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Core Model</em>' containment reference.
	 * @see #getCoreModel()
	 * @generated
	 */
	void setCoreModel(CoreModel value);

	/**
	 * A list of all the diagrams in this file
	 * 
	 * @model type="Diagram" containment="true"
	 */
	EList getDiagrams();
	
	/**
	 * Get the list of open diagrams in this flabot file
	 * 
	 * @model type="Diagram" containment="false"
	 */
	EList getOpenDiagrams();

	/**
	 * A list of all the folders in this file
	 * 
	 * @model containment="true"
	 */
	Folder getFolder();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.FlabotFileModel#getFolder <em>Folder</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Folder</em>' containment reference.
	 * @see #getFolder()
	 * @generated
	 */
	void setFolder(Folder value);

	/**
	 * A list of all the imported files
	 * 
	 * @model type="FlabotFileModel" containment="true"
	 */
	EList getImportedFiles();

	/**
	 * Get all the imported files
	 * @return
	 */
	List getAllImportedFiles();
}
