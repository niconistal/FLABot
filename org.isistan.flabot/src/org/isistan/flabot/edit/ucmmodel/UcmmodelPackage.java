/**
 * <copyright>
 * </copyright>
 *
 * $Id: UcmmodelPackage.java,v 1.17 2005/12/06 20:53:42 franco Exp $
 */
package org.isistan.flabot.edit.ucmmodel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.isistan.flabot.edit.ucmmodel.UcmmodelFactory
 * @model kind="package"
 * @generated
 */
public interface UcmmodelPackage extends EPackage{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ucmmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/isistan/flabot/edit/ucmmodel.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.isistan.flabot.edit.ucmmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UcmmodelPackage eINSTANCE = org.isistan.flabot.edit.ucmmodel.impl.UcmmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.isistan.flabot.edit.ucmmodel.impl.UCMDiagramImpl <em>UCM Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.edit.ucmmodel.impl.UCMDiagramImpl
	 * @see org.isistan.flabot.edit.ucmmodel.impl.UcmmodelPackageImpl#getUCMDiagram()
	 * @generated
	 */
	int UCM_DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCM_DIAGRAM__NAME = EditormodelPackage.DIAGRAM__NAME;

	/**
	 * The feature id for the '<em><b>Core Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCM_DIAGRAM__CORE_MODEL = EditormodelPackage.DIAGRAM__CORE_MODEL;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCM_DIAGRAM__NOTES = EditormodelPackage.DIAGRAM__NOTES;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCM_DIAGRAM__CHILDREN = EditormodelPackage.DIAGRAM__CHILDREN;

	/**
	 * The feature id for the '<em><b>Folder</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCM_DIAGRAM__FOLDER = EditormodelPackage.DIAGRAM__FOLDER;

	/**
	 * The feature id for the '<em><b>Grid Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCM_DIAGRAM__GRID_ENABLED = EditormodelPackage.DIAGRAM__GRID_ENABLED;

	/**
	 * The feature id for the '<em><b>Snap To Geometry Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCM_DIAGRAM__SNAP_TO_GEOMETRY_ENABLED = EditormodelPackage.DIAGRAM__SNAP_TO_GEOMETRY_ENABLED;

	/**
	 * The feature id for the '<em><b>Map</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCM_DIAGRAM__MAP = EditormodelPackage.DIAGRAM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>UCM Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCM_DIAGRAM_FEATURE_COUNT = EditormodelPackage.DIAGRAM_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.emf.common.notify.Adapter <em>Adapter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.notify.Adapter
	 * @see org.isistan.flabot.edit.ucmmodel.impl.UcmmodelPackageImpl#getAdapter()
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
	 * The meta object id for the '<em>Notifier</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.notify.Notifier
	 * @see org.isistan.flabot.edit.ucmmodel.impl.UcmmodelPackageImpl#getNotifier()
	 * @generated
	 */
	int NOTIFIER = 2;


	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.edit.ucmmodel.UCMDiagram <em>UCM Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UCM Diagram</em>'.
	 * @see org.isistan.flabot.edit.ucmmodel.UCMDiagram
	 * @generated
	 */
	EClass getUCMDiagram();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.edit.ucmmodel.UCMDiagram#getMap <em>Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Map</em>'.
	 * @see org.isistan.flabot.edit.ucmmodel.UCMDiagram#getMap()
	 * @see #getUCMDiagram()
	 * @generated
	 */
	EReference getUCMDiagram_Map();

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
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.notify.Notifier <em>Notifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Notifier</em>'.
	 * @see org.eclipse.emf.common.notify.Notifier
	 * @model instanceClass="org.eclipse.emf.common.notify.Notifier"
	 * @generated
	 */
	EDataType getNotifier();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UcmmodelFactory getUcmmodelFactory();

} //UcmmodelPackage
