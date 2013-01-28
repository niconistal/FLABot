/**

import org.eclipse.emf.common.util.EList;
 * Model for all folders in flabot.
 * @author $Author: mblech $
 * @model
 */
public interface Folder extends EObject{
	
	/**
	 * @model default=""
	 */
	String getName();
	
	/**
	 * <!-- end-user-doc -->
	void setName(String value);

	/**
	 * @model type="Folder" containment="true"
	 */
	EList getFolders();
	
	/**
	 * @model opposite="folders"
	 */
	Folder getParent();
	
	/**
	 * <!-- end-user-doc -->
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
	
	/**
	 * <!-- end-user-doc -->
	void setFileModel(FlabotFileModel value);

}