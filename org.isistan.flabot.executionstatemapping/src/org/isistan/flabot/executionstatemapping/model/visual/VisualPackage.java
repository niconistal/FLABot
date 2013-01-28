/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.visual;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;

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
 * @see org.isistan.flabot.executionstatemapping.model.visual.VisualFactory
 * @model kind="package"
 * @generated
 */
public interface VisualPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "visual";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/isistan/flabot/executionstatemapping/model.ecore#//visual";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.isistan.flabot.executionstatemapping.model.visual";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VisualPackage eINSTANCE = org.isistan.flabot.executionstatemapping.model.visual.impl.VisualPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.visual.impl.StateDiagramImpl <em>State Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.visual.impl.StateDiagramImpl
	 * @see org.isistan.flabot.executionstatemapping.model.visual.impl.VisualPackageImpl#getStateDiagram()
	 * @generated
	 */
	int STATE_DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__NAME = EditormodelPackage.DIAGRAM__NAME;

	/**
	 * The feature id for the '<em><b>Core Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__CORE_MODEL = EditormodelPackage.DIAGRAM__CORE_MODEL;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__NOTES = EditormodelPackage.DIAGRAM__NOTES;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__CHILDREN = EditormodelPackage.DIAGRAM__CHILDREN;

	/**
	 * The feature id for the '<em><b>Folder</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__FOLDER = EditormodelPackage.DIAGRAM__FOLDER;

	/**
	 * The feature id for the '<em><b>Grid Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__GRID_ENABLED = EditormodelPackage.DIAGRAM__GRID_ENABLED;

	/**
	 * The feature id for the '<em><b>Snap To Geometry Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__SNAP_TO_GEOMETRY_ENABLED = EditormodelPackage.DIAGRAM__SNAP_TO_GEOMETRY_ENABLED;

	/**
	 * The feature id for the '<em><b>Semantic Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__SEMANTIC_MODEL = EditormodelPackage.DIAGRAM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>State Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM_FEATURE_COUNT = EditormodelPackage.DIAGRAM_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.visual.StateDiagram <em>State Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Diagram</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.visual.StateDiagram
	 * @generated
	 */
	EClass getStateDiagram();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionstatemapping.model.visual.StateDiagram#getSemanticModel <em>Semantic Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Semantic Model</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.visual.StateDiagram#getSemanticModel()
	 * @see #getStateDiagram()
	 * @generated
	 */
	EReference getStateDiagram_SemanticModel();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VisualFactory getVisualFactory();

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
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.visual.impl.StateDiagramImpl <em>State Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.visual.impl.StateDiagramImpl
		 * @see org.isistan.flabot.executionstatemapping.model.visual.impl.VisualPackageImpl#getStateDiagram()
		 * @generated
		 */
		EClass STATE_DIAGRAM = eINSTANCE.getStateDiagram();

		/**
		 * The meta object literal for the '<em><b>Semantic Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_DIAGRAM__SEMANTIC_MODEL = eINSTANCE.getStateDiagram_SemanticModel();

	}

} //VisualPackage
