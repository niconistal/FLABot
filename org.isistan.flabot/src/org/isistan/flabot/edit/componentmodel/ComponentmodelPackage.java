/**
 * <copyright>
 * </copyright>
 *
 * $Id: ComponentmodelPackage.java,v 1.19 2005/12/06 20:53:43 franco Exp $
 */
package org.isistan.flabot.edit.componentmodel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
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
 * @see org.isistan.flabot.edit.componentmodel.ComponentmodelFactory
 * @model kind="package"
 * @generated
 */
public interface ComponentmodelPackage extends EPackage{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "componentmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/isistan/flabot/edit/componentmodel.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.isistan.flabot.edit.componentmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComponentmodelPackage eINSTANCE = org.isistan.flabot.edit.componentmodel.impl.ComponentmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.isistan.flabot.edit.componentmodel.impl.ComponentDiagramImpl <em>Component Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.edit.componentmodel.impl.ComponentDiagramImpl
	 * @see org.isistan.flabot.edit.componentmodel.impl.ComponentmodelPackageImpl#getComponentDiagram()
	 * @generated
	 */
	int COMPONENT_DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__NAME = EditormodelPackage.DIAGRAM__NAME;

	/**
	 * The feature id for the '<em><b>Core Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__CORE_MODEL = EditormodelPackage.DIAGRAM__CORE_MODEL;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__NOTES = EditormodelPackage.DIAGRAM__NOTES;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__CHILDREN = EditormodelPackage.DIAGRAM__CHILDREN;

	/**
	 * The feature id for the '<em><b>Folder</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__FOLDER = EditormodelPackage.DIAGRAM__FOLDER;

	/**
	 * The feature id for the '<em><b>Grid Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__GRID_ENABLED = EditormodelPackage.DIAGRAM__GRID_ENABLED;

	/**
	 * The feature id for the '<em><b>Snap To Geometry Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__SNAP_TO_GEOMETRY_ENABLED = EditormodelPackage.DIAGRAM__SNAP_TO_GEOMETRY_ENABLED;

	/**
	 * The number of structural features of the '<em>Component Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM_FEATURE_COUNT = EditormodelPackage.DIAGRAM_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.emf.common.notify.Adapter <em>Adapter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.notify.Adapter
	 * @see org.isistan.flabot.edit.componentmodel.impl.ComponentmodelPackageImpl#getAdapter()
	 * @generated
	 */
	int ADAPTER = 1;

	/**
	 * The number of structural features of the '<em>Adapter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_FEATURE_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.edit.componentmodel.ComponentDiagram <em>Component Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Diagram</em>'.
	 * @see org.isistan.flabot.edit.componentmodel.ComponentDiagram
	 * @generated
	 */
	EClass getComponentDiagram();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.common.notify.Adapter <em>Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adapter</em>'.
	 * @see org.eclipse.emf.common.notify.Adapter
	 * @model instanceClass="org.eclipse.emf.common.notify.Adapter"
	 * @generated
	 */
	EClass getAdapter();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ComponentmodelFactory getComponentmodelFactory();

} //ComponentmodelPackage
