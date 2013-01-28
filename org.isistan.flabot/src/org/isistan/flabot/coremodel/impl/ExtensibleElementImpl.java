/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExtensibleElementImpl.java,v 1.4 2006/03/24 00:33:58 dacostae Exp $
 */
package org.isistan.flabot.coremodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.ExtensibleElement;
import org.isistan.flabot.coremodel.ExtensibleElementUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extensible Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ExtensibleElementImpl#getExtendedData <em>Extended Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensibleElementImpl extends EObjectImpl implements ExtensibleElement {
	/**
	 * The cached value of the '{@link #getExtendedData() <em>Extended Data</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedData()
	 * @generated
	 * @ordered
	 */
	protected EMap extendedData;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtensibleElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.EXTENSIBLE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getExtendedData() {
		if (extendedData == null) {
			extendedData = new EcoreEMap(CoremodelPackage.Literals.ESTRING_TO_EOBJECT_MAP_ENTRY, EStringToEObjectMapEntryImpl.class, this, CoremodelPackage.EXTENSIBLE_ELEMENT__EXTENDED_DATA);
		}
		return extendedData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CoremodelPackage.EXTENSIBLE_ELEMENT__EXTENDED_DATA:
				return ((InternalEList)getExtendedData()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CoremodelPackage.EXTENSIBLE_ELEMENT__EXTENDED_DATA:
				if (coreType) return getExtendedData();
				else return getExtendedData().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CoremodelPackage.EXTENSIBLE_ELEMENT__EXTENDED_DATA:
				((EStructuralFeature.Setting)getExtendedData()).set(newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case CoremodelPackage.EXTENSIBLE_ELEMENT__EXTENDED_DATA:
				getExtendedData().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CoremodelPackage.EXTENSIBLE_ELEMENT__EXTENDED_DATA:
				return extendedData != null && !extendedData.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public EObject getExtendedData(String pluginId, String elementId) {
		return ExtensibleElementUtil.getExtendedData(this, pluginId, elementId);
	}

	public EObject putExtendedData(String pluginId, String elementId, EObject element) {
		return ExtensibleElementUtil.putExtendedData(this, pluginId, elementId, element);
	}
} //ExtensibleElementImpl
