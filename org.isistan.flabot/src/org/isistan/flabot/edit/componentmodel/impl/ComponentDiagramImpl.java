/**
 * <copyright>
 * </copyright>
 *
 * $Id: ComponentDiagramImpl.java,v 1.16 2005/12/06 20:53:43 franco Exp $
 */
package org.isistan.flabot.edit.componentmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.edit.componentmodel.ComponentDiagram;
import org.isistan.flabot.edit.componentmodel.ComponentmodelPackage;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.Folder;
import org.isistan.flabot.edit.editormodel.impl.DiagramImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ComponentDiagramImpl extends DiagramImpl implements ComponentDiagram {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ComponentmodelPackage.eINSTANCE.getComponentDiagram();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ComponentmodelPackage.COMPONENT_DIAGRAM__CHILDREN:
					return ((InternalEList)getChildren()).basicAdd(otherEnd, msgs);
				case ComponentmodelPackage.COMPONENT_DIAGRAM__FOLDER:
					if (folder != null)
						msgs = ((InternalEObject)folder).eInverseRemove(this, EditormodelPackage.FOLDER__DIAGRAMS, Folder.class, msgs);
					return basicSetFolder((Folder)otherEnd, msgs);
				default:
					return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
			}
		}
		if (eContainer != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ComponentmodelPackage.COMPONENT_DIAGRAM__NOTES:
					return ((InternalEList)getNotes()).basicRemove(otherEnd, msgs);
				case ComponentmodelPackage.COMPONENT_DIAGRAM__CHILDREN:
					return ((InternalEList)getChildren()).basicRemove(otherEnd, msgs);
				case ComponentmodelPackage.COMPONENT_DIAGRAM__FOLDER:
					return basicSetFolder(null, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ComponentmodelPackage.COMPONENT_DIAGRAM__NAME:
				return getName();
			case ComponentmodelPackage.COMPONENT_DIAGRAM__CORE_MODEL:
				if (resolve) return getCoreModel();
				return basicGetCoreModel();
			case ComponentmodelPackage.COMPONENT_DIAGRAM__NOTES:
				return getNotes();
			case ComponentmodelPackage.COMPONENT_DIAGRAM__CHILDREN:
				return getChildren();
			case ComponentmodelPackage.COMPONENT_DIAGRAM__FOLDER:
				if (resolve) return getFolder();
				return basicGetFolder();
			case ComponentmodelPackage.COMPONENT_DIAGRAM__GRID_ENABLED:
				return getGridEnabled();
			case ComponentmodelPackage.COMPONENT_DIAGRAM__SNAP_TO_GEOMETRY_ENABLED:
				return getSnapToGeometryEnabled();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ComponentmodelPackage.COMPONENT_DIAGRAM__NAME:
				setName((String)newValue);
				return;
			case ComponentmodelPackage.COMPONENT_DIAGRAM__CORE_MODEL:
				setCoreModel((CoreModel)newValue);
				return;
			case ComponentmodelPackage.COMPONENT_DIAGRAM__NOTES:
				getNotes().clear();
				getNotes().addAll((Collection)newValue);
				return;
			case ComponentmodelPackage.COMPONENT_DIAGRAM__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection)newValue);
				return;
			case ComponentmodelPackage.COMPONENT_DIAGRAM__FOLDER:
				setFolder((Folder)newValue);
				return;
			case ComponentmodelPackage.COMPONENT_DIAGRAM__GRID_ENABLED:
				setGridEnabled((Boolean)newValue);
				return;
			case ComponentmodelPackage.COMPONENT_DIAGRAM__SNAP_TO_GEOMETRY_ENABLED:
				setSnapToGeometryEnabled((Boolean)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ComponentmodelPackage.COMPONENT_DIAGRAM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ComponentmodelPackage.COMPONENT_DIAGRAM__CORE_MODEL:
				setCoreModel((CoreModel)null);
				return;
			case ComponentmodelPackage.COMPONENT_DIAGRAM__NOTES:
				getNotes().clear();
				return;
			case ComponentmodelPackage.COMPONENT_DIAGRAM__CHILDREN:
				getChildren().clear();
				return;
			case ComponentmodelPackage.COMPONENT_DIAGRAM__FOLDER:
				setFolder((Folder)null);
				return;
			case ComponentmodelPackage.COMPONENT_DIAGRAM__GRID_ENABLED:
				setGridEnabled(GRID_ENABLED_EDEFAULT);
				return;
			case ComponentmodelPackage.COMPONENT_DIAGRAM__SNAP_TO_GEOMETRY_ENABLED:
				setSnapToGeometryEnabled(SNAP_TO_GEOMETRY_ENABLED_EDEFAULT);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ComponentmodelPackage.COMPONENT_DIAGRAM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ComponentmodelPackage.COMPONENT_DIAGRAM__CORE_MODEL:
				return coreModel != null;
			case ComponentmodelPackage.COMPONENT_DIAGRAM__NOTES:
				return notes != null && !notes.isEmpty();
			case ComponentmodelPackage.COMPONENT_DIAGRAM__CHILDREN:
				return children != null && !children.isEmpty();
			case ComponentmodelPackage.COMPONENT_DIAGRAM__FOLDER:
				return folder != null;
			case ComponentmodelPackage.COMPONENT_DIAGRAM__GRID_ENABLED:
				return GRID_ENABLED_EDEFAULT == null ? gridEnabled != null : !GRID_ENABLED_EDEFAULT.equals(gridEnabled);
			case ComponentmodelPackage.COMPONENT_DIAGRAM__SNAP_TO_GEOMETRY_ENABLED:
				return SNAP_TO_GEOMETRY_ENABLED_EDEFAULT == null ? snapToGeometryEnabled != null : !SNAP_TO_GEOMETRY_ENABLED_EDEFAULT.equals(snapToGeometryEnabled);
		}
		return eDynamicIsSet(eFeature);
	}

} //ComponentDiagramImpl
