/** * $Id: ExecutionInfoManager.java,v 1.2 2006/02/03 21:03:09 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.executionmodel;

import org.eclipse.emf.common.notify.Adapter;import org.eclipse.emf.common.util.EList;import org.eclipse.emf.ecore.EObject;import org.isistan.flabot.edit.editormodel.FlabotFileModel;/**
 * @model
 */
public interface ExecutionInfoManager extends EObject, Adapter {

	/**
	 * Get the file for this execution state manager
	 * @return
	 * @model
	 */
	FlabotFileModel getFileModel();
	
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionInfoManager#getFileModel <em>File Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Model</em>' reference.
	 * @see #getFileModel()
	 * @generated
	 */
	void setFileModel(FlabotFileModel value);

	/**
	 * @model type="ExecutionInfo" containment="true"
	 * @deprecated
	 */
	@Deprecated	EList getExecutions();
	
	/**
	 * 
	 * @model containment="true"
	 */
	ExecutionInfo getCurrentExecution();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionInfoManager#getCurrentExecution <em>Current Execution</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Execution</em>' containment reference.
	 * @see #getCurrentExecution()
	 * @generated
	 */
	void setCurrentExecution(ExecutionInfo value);

	void addExecution ();

}
