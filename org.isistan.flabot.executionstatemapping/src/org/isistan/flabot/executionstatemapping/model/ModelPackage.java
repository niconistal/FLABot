/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.executionstatemapping.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/isistan/flabot/executionstatemapping/model.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.isistan.flabot.executionstatemapping.model.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = org.isistan.flabot.executionstatemapping.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.impl.ExecutionStateMappingFileModelImpl <em>Execution State Mapping File Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.impl.ExecutionStateMappingFileModelImpl
	 * @see org.isistan.flabot.executionstatemapping.model.impl.ModelPackageImpl#getExecutionStateMappingFileModel()
	 * @generated
	 */
	int EXECUTION_STATE_MAPPING_FILE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>State Containers Tree</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE_MAPPING_FILE_MODEL__STATE_CONTAINERS_TREE = 0;

	/**
	 * The feature id for the '<em><b>Method Execution Conditions Tree</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE_MAPPING_FILE_MODEL__METHOD_EXECUTION_CONDITIONS_TREE = 1;

	/**
	 * The feature id for the '<em><b>General Execution Conditions Tree</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE_MAPPING_FILE_MODEL__GENERAL_EXECUTION_CONDITIONS_TREE = 2;

	/**
	 * The feature id for the '<em><b>State Diagrams List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE_MAPPING_FILE_MODEL__STATE_DIAGRAMS_LIST = 3;

	/**
	 * The number of structural features of the '<em>Execution State Mapping File Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE_MAPPING_FILE_MODEL_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel <em>Execution State Mapping File Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution State Mapping File Model</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel
	 * @generated
	 */
	EClass getExecutionStateMappingFileModel();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel#getStateContainersTree <em>State Containers Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>State Containers Tree</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel#getStateContainersTree()
	 * @see #getExecutionStateMappingFileModel()
	 * @generated
	 */
	EReference getExecutionStateMappingFileModel_StateContainersTree();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel#getMethodExecutionConditionsTree <em>Method Execution Conditions Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Method Execution Conditions Tree</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel#getMethodExecutionConditionsTree()
	 * @see #getExecutionStateMappingFileModel()
	 * @generated
	 */
	EReference getExecutionStateMappingFileModel_MethodExecutionConditionsTree();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel#getGeneralExecutionConditionsTree <em>General Execution Conditions Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>General Execution Conditions Tree</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel#getGeneralExecutionConditionsTree()
	 * @see #getExecutionStateMappingFileModel()
	 * @generated
	 */
	EReference getExecutionStateMappingFileModel_GeneralExecutionConditionsTree();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel#getStateDiagramsList <em>State Diagrams List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>State Diagrams List</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel#getStateDiagramsList()
	 * @see #getExecutionStateMappingFileModel()
	 * @generated
	 */
	EReference getExecutionStateMappingFileModel_StateDiagramsList();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.impl.ExecutionStateMappingFileModelImpl <em>Execution State Mapping File Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.impl.ExecutionStateMappingFileModelImpl
		 * @see org.isistan.flabot.executionstatemapping.model.impl.ModelPackageImpl#getExecutionStateMappingFileModel()
		 * @generated
		 */
		EClass EXECUTION_STATE_MAPPING_FILE_MODEL = eINSTANCE.getExecutionStateMappingFileModel();

		/**
		 * The meta object literal for the '<em><b>State Containers Tree</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_STATE_MAPPING_FILE_MODEL__STATE_CONTAINERS_TREE = eINSTANCE.getExecutionStateMappingFileModel_StateContainersTree();

		/**
		 * The meta object literal for the '<em><b>Method Execution Conditions Tree</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_STATE_MAPPING_FILE_MODEL__METHOD_EXECUTION_CONDITIONS_TREE = eINSTANCE.getExecutionStateMappingFileModel_MethodExecutionConditionsTree();

		/**
		 * The meta object literal for the '<em><b>General Execution Conditions Tree</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_STATE_MAPPING_FILE_MODEL__GENERAL_EXECUTION_CONDITIONS_TREE = eINSTANCE.getExecutionStateMappingFileModel_GeneralExecutionConditionsTree();

		/**
		 * The meta object literal for the '<em><b>State Diagrams List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_STATE_MAPPING_FILE_MODEL__STATE_DIAGRAMS_LIST = eINSTANCE.getExecutionStateMappingFileModel_StateDiagramsList();

	}

} //ModelPackage
