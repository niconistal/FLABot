/**

import org.eclipse.emf.common.notify.Adapter;
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
	@Deprecated
	
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