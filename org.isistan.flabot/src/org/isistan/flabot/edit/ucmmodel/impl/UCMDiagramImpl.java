/**
 * <copyright>
 * </copyright>
 *
 * $Id: UCMDiagramImpl.java,v 1.17 2006/03/21 01:51:58 franco Exp $
 */
package org.isistan.flabot.edit.ucmmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.Folder;
import org.isistan.flabot.edit.editormodel.impl.DiagramImpl;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.edit.ucmmodel.UcmmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UCM Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.edit.ucmmodel.impl.UCMDiagramImpl#getMap <em>Map</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UCMDiagramImpl extends DiagramImpl implements UCMDiagram {
	/**
	 * The cached value of the '{@link #getMap() <em>Map</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMap()
	 * @generated
	 * @ordered
	 */
	protected UseCaseMap map = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UCMDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UcmmodelPackage.eINSTANCE.getUCMDiagram();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCaseMap getMap() {
		if (map != null && map.eIsProxy()) {
			UseCaseMap oldMap = map;
			map = (UseCaseMap)eResolveProxy((InternalEObject)map);
			if (map != oldMap) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UcmmodelPackage.UCM_DIAGRAM__MAP, oldMap, map));
			}
		}
		return map;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCaseMap basicGetMap() {
		return map;
	}

	public void setMapGen (UseCaseMap newMap){
		UseCaseMap oldMap = map;
		map = newMap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UcmmodelPackage.UCM_DIAGRAM__MAP, oldMap, map));
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMap(UseCaseMap newMap) {
		UseCaseMap oldMap = map;
		setMapGen(newMap);
		if (oldMap != null)
			oldMap.eAdapters().remove(this);
		if (newMap != null)
			newMap.eAdapters().add(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case UcmmodelPackage.UCM_DIAGRAM__CHILDREN:
					return ((InternalEList)getChildren()).basicAdd(otherEnd, msgs);
				case UcmmodelPackage.UCM_DIAGRAM__FOLDER:
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
				case UcmmodelPackage.UCM_DIAGRAM__NOTES:
					return ((InternalEList)getNotes()).basicRemove(otherEnd, msgs);
				case UcmmodelPackage.UCM_DIAGRAM__CHILDREN:
					return ((InternalEList)getChildren()).basicRemove(otherEnd, msgs);
				case UcmmodelPackage.UCM_DIAGRAM__FOLDER:
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
			case UcmmodelPackage.UCM_DIAGRAM__NAME:
				return getName();
			case UcmmodelPackage.UCM_DIAGRAM__CORE_MODEL:
				if (resolve) return getCoreModel();
				return basicGetCoreModel();
			case UcmmodelPackage.UCM_DIAGRAM__NOTES:
				return getNotes();
			case UcmmodelPackage.UCM_DIAGRAM__CHILDREN:
				return getChildren();
			case UcmmodelPackage.UCM_DIAGRAM__FOLDER:
				if (resolve) return getFolder();
				return basicGetFolder();
			case UcmmodelPackage.UCM_DIAGRAM__GRID_ENABLED:
				return getGridEnabled();
			case UcmmodelPackage.UCM_DIAGRAM__SNAP_TO_GEOMETRY_ENABLED:
				return getSnapToGeometryEnabled();
			case UcmmodelPackage.UCM_DIAGRAM__MAP:
				if (resolve) return getMap();
				return basicGetMap();
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
			case UcmmodelPackage.UCM_DIAGRAM__NAME:
				setName((String)newValue);
				return;
			case UcmmodelPackage.UCM_DIAGRAM__CORE_MODEL:
				setCoreModel((CoreModel)newValue);
				return;
			case UcmmodelPackage.UCM_DIAGRAM__NOTES:
				getNotes().clear();
				getNotes().addAll((Collection)newValue);
				return;
			case UcmmodelPackage.UCM_DIAGRAM__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection)newValue);
				return;
			case UcmmodelPackage.UCM_DIAGRAM__FOLDER:
				setFolder((Folder)newValue);
				return;
			case UcmmodelPackage.UCM_DIAGRAM__GRID_ENABLED:
				setGridEnabled((Boolean)newValue);
				return;
			case UcmmodelPackage.UCM_DIAGRAM__SNAP_TO_GEOMETRY_ENABLED:
				setSnapToGeometryEnabled((Boolean)newValue);
				return;
			case UcmmodelPackage.UCM_DIAGRAM__MAP:
				setMap((UseCaseMap)newValue);
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
			case UcmmodelPackage.UCM_DIAGRAM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UcmmodelPackage.UCM_DIAGRAM__CORE_MODEL:
				setCoreModel((CoreModel)null);
				return;
			case UcmmodelPackage.UCM_DIAGRAM__NOTES:
				getNotes().clear();
				return;
			case UcmmodelPackage.UCM_DIAGRAM__CHILDREN:
				getChildren().clear();
				return;
			case UcmmodelPackage.UCM_DIAGRAM__FOLDER:
				setFolder((Folder)null);
				return;
			case UcmmodelPackage.UCM_DIAGRAM__GRID_ENABLED:
				setGridEnabled(GRID_ENABLED_EDEFAULT);
				return;
			case UcmmodelPackage.UCM_DIAGRAM__SNAP_TO_GEOMETRY_ENABLED:
				setSnapToGeometryEnabled(SNAP_TO_GEOMETRY_ENABLED_EDEFAULT);
				return;
			case UcmmodelPackage.UCM_DIAGRAM__MAP:
				setMap((UseCaseMap)null);
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
			case UcmmodelPackage.UCM_DIAGRAM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UcmmodelPackage.UCM_DIAGRAM__CORE_MODEL:
				return coreModel != null;
			case UcmmodelPackage.UCM_DIAGRAM__NOTES:
				return notes != null && !notes.isEmpty();
			case UcmmodelPackage.UCM_DIAGRAM__CHILDREN:
				return children != null && !children.isEmpty();
			case UcmmodelPackage.UCM_DIAGRAM__FOLDER:
				return folder != null;
			case UcmmodelPackage.UCM_DIAGRAM__GRID_ENABLED:
				return GRID_ENABLED_EDEFAULT == null ? gridEnabled != null : !GRID_ENABLED_EDEFAULT.equals(gridEnabled);
			case UcmmodelPackage.UCM_DIAGRAM__SNAP_TO_GEOMETRY_ENABLED:
				return SNAP_TO_GEOMETRY_ENABLED_EDEFAULT == null ? snapToGeometryEnabled != null : !SNAP_TO_GEOMETRY_ENABLED_EDEFAULT.equals(snapToGeometryEnabled);
			case UcmmodelPackage.UCM_DIAGRAM__MAP:
				return map != null;
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * Adapter implementation
	 */

	public void notifyChanged(Notification notification) {
		if (eNotificationRequired())
			eNotify(notification);
	}

	public Notifier getTarget() {
		return getMap();
	}

	public void setTarget(Notifier newTarget) {
		// do nothing
	}

	public boolean isAdapterForType(Object type) {
		return Notifier.class.isAssignableFrom((Class)type);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
		if (getMap() != null)
			return getMap().getName();
		return super.getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setName(String newName) {
		if (getMap() != null)
			getMap().setName(newName);
		super.setName(newName);
	}
	

} //UCMDiagramImpl
