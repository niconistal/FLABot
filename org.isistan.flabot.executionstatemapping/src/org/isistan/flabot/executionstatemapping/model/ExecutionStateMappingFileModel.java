/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.isistan.flabot.executionstatemapping.model.semantic.MappedTreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.visual.StateDiagram;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution State Mapping File Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel#getStateContainersTree <em>State Containers Tree</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel#getMethodExecutionConditionsTree <em>Method Execution Conditions Tree</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel#getGeneralExecutionConditionsTree <em>General Execution Conditions Tree</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel#getStateDiagramsList <em>State Diagrams List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.isistan.flabot.executionstatemapping.model.ModelPackage#getExecutionStateMappingFileModel()
 * @model
 * @generated
 */
public interface ExecutionStateMappingFileModel extends EObject {
	/**
	 * Returns the value of the '<em><b>State Containers Tree</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Containers Tree</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Containers Tree</em>' containment reference.
	 * @see #setStateContainersTree(TreeStructuredElement)
	 * @see org.isistan.flabot.executionstatemapping.model.ModelPackage#getExecutionStateMappingFileModel_StateContainersTree()
	 * @model containment="true"
	 * @generated
	 */
	TreeStructuredElement getStateContainersTree();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel#getStateContainersTree <em>State Containers Tree</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Containers Tree</em>' containment reference.
	 * @see #getStateContainersTree()
	 * @generated
	 */
	void setStateContainersTree(TreeStructuredElement value);

	/**
	 * Returns the value of the '<em><b>Method Execution Conditions Tree</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method Execution Conditions Tree</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method Execution Conditions Tree</em>' containment reference.
	 * @see #setMethodExecutionConditionsTree(MappedTreeStructuredElement)
	 * @see org.isistan.flabot.executionstatemapping.model.ModelPackage#getExecutionStateMappingFileModel_MethodExecutionConditionsTree()
	 * @model containment="true"
	 * @generated
	 */
	MappedTreeStructuredElement getMethodExecutionConditionsTree();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel#getMethodExecutionConditionsTree <em>Method Execution Conditions Tree</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method Execution Conditions Tree</em>' containment reference.
	 * @see #getMethodExecutionConditionsTree()
	 * @generated
	 */
	void setMethodExecutionConditionsTree(MappedTreeStructuredElement value);

	/**
	 * Returns the value of the '<em><b>General Execution Conditions Tree</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>General Execution Conditions Tree</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>General Execution Conditions Tree</em>' containment reference.
	 * @see #setGeneralExecutionConditionsTree(TreeStructuredElement)
	 * @see org.isistan.flabot.executionstatemapping.model.ModelPackage#getExecutionStateMappingFileModel_GeneralExecutionConditionsTree()
	 * @model containment="true"
	 * @generated
	 */
	TreeStructuredElement getGeneralExecutionConditionsTree();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel#getGeneralExecutionConditionsTree <em>General Execution Conditions Tree</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>General Execution Conditions Tree</em>' containment reference.
	 * @see #getGeneralExecutionConditionsTree()
	 * @generated
	 */
	void setGeneralExecutionConditionsTree(TreeStructuredElement value);

	/**
	 * Returns the value of the '<em><b>State Diagrams List</b></em>' containment reference list.
	 * The list contents are of type {@link org.isistan.flabot.executionstatemapping.model.visual.StateDiagram}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Diagrams List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Diagrams List</em>' containment reference list.
	 * @see org.isistan.flabot.executionstatemapping.model.ModelPackage#getExecutionStateMappingFileModel_StateDiagramsList()
	 * @model containment="true"
	 * @generated
	 */
	EList<StateDiagram> getStateDiagramsList();

} // ExecutionStateMappingFileModel
