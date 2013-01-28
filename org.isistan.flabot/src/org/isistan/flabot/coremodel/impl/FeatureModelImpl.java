/**
 * <copyright>
 * </copyright>
 *
 * $Id: FeatureModelImpl.java,v 1.8 2006/03/27 22:46:29 franco Exp $
 */
package org.isistan.flabot.coremodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.ExtensibleElement;
import org.isistan.flabot.coremodel.ExtensibleElementUtil;
import org.isistan.flabot.coremodel.FeatureModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.FeatureModelImpl#getExtendedData <em>Extended Data</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.FeatureModelImpl#getComponents <em>Components</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureModelImpl extends NamedElementModelImpl implements FeatureModel {
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
	 * The cached value of the '{@link #getComponents() <em>Components</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponents()
	 * @generated
	 * @ordered
	 */
	protected EList components;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.FEATURE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getExtendedData() {
		if (extendedData == null) {
			extendedData = new EcoreEMap(CoremodelPackage.Literals.ESTRING_TO_EOBJECT_MAP_ENTRY, EStringToEObjectMapEntryImpl.class, this, CoremodelPackage.FEATURE_MODEL__EXTENDED_DATA);
		}
		return extendedData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getComponents() {
		if (components == null) {
			components = new EObjectWithInverseResolvingEList.ManyInverse(ComponentModel.class, this, CoremodelPackage.FEATURE_MODEL__COMPONENTS, CoremodelPackage.COMPONENT_MODEL__FEATURES);
		}
		return components;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CoremodelPackage.FEATURE_MODEL__COMPONENTS:
				return ((InternalEList)getComponents()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CoremodelPackage.FEATURE_MODEL__EXTENDED_DATA:
				return ((InternalEList)getExtendedData()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.FEATURE_MODEL__COMPONENTS:
				return ((InternalEList)getComponents()).basicRemove(otherEnd, msgs);
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
			case CoremodelPackage.FEATURE_MODEL__EXTENDED_DATA:
				if (coreType) return getExtendedData();
				else return getExtendedData().map();
			case CoremodelPackage.FEATURE_MODEL__COMPONENTS:
				return getComponents();
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
			case CoremodelPackage.FEATURE_MODEL__EXTENDED_DATA:
				((EStructuralFeature.Setting)getExtendedData()).set(newValue);
				return;
			case CoremodelPackage.FEATURE_MODEL__COMPONENTS:
				getComponents().clear();
				getComponents().addAll((Collection)newValue);
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
			case CoremodelPackage.FEATURE_MODEL__EXTENDED_DATA:
				getExtendedData().clear();
				return;
			case CoremodelPackage.FEATURE_MODEL__COMPONENTS:
				getComponents().clear();
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
			case CoremodelPackage.FEATURE_MODEL__EXTENDED_DATA:
				return extendedData != null && !extendedData.isEmpty();
			case CoremodelPackage.FEATURE_MODEL__COMPONENTS:
				return components != null && !components.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == ExtensibleElement.class) {
			switch (derivedFeatureID) {
				case CoremodelPackage.FEATURE_MODEL__EXTENDED_DATA: return CoremodelPackage.EXTENSIBLE_ELEMENT__EXTENDED_DATA;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
		if (baseClass == ExtensibleElement.class) {
			switch (baseFeatureID) {
				case CoremodelPackage.EXTENSIBLE_ELEMENT__EXTENDED_DATA: return CoremodelPackage.FEATURE_MODEL__EXTENDED_DATA;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	public EObject getExtendedData(String pluginId, String elementId) {
		return ExtensibleElementUtil.getExtendedData(this, pluginId, elementId);
	}

	public EObject putExtendedData(String pluginId, String elementId, EObject element) {
		return ExtensibleElementUtil.putExtendedData(this, pluginId, elementId, element);
	}

} //FeatureModelImpl
