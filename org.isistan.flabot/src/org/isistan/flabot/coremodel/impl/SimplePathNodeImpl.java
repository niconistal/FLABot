/**
 * <copyright>
 * </copyright>
 *
 * $Id: SimplePathNodeImpl.java,v 1.13 2006/02/23 00:05:13 dacostae Exp $
 */
package org.isistan.flabot.coremodel.impl;

import java.util.Collection;
import java.util.Vector;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.ExtensibleElementUtil;
import org.isistan.flabot.coremodel.NamedElementModel;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.util.EObjectIdGenerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Path Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.SimplePathNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.SimplePathNodeImpl#getMap <em>Map</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimplePathNodeImpl extends PathNodeImpl implements SimplePathNode {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMap() <em>Map</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMap()
	 * @generated
	 * @ordered
	 */
	protected UseCaseMap map;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimplePathNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.SIMPLE_PATH_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.SIMPLE_PATH_NODE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCaseMap getMap() {
		if (map != null && map.eIsProxy()) {
			InternalEObject oldMap = (InternalEObject)map;
			map = (UseCaseMap)eResolveProxy(oldMap);
			if (map != oldMap) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoremodelPackage.SIMPLE_PATH_NODE__MAP, oldMap, map));
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMap(UseCaseMap newMap) {
		UseCaseMap oldMap = map;
		map = newMap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.SIMPLE_PATH_NODE__MAP, oldMap, map));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CoremodelPackage.SIMPLE_PATH_NODE__NAME:
				return getName();
			case CoremodelPackage.SIMPLE_PATH_NODE__MAP:
				if (resolve) return getMap();
				return basicGetMap();
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
			case CoremodelPackage.SIMPLE_PATH_NODE__NAME:
				setName((String)newValue);
				return;
			case CoremodelPackage.SIMPLE_PATH_NODE__MAP:
				setMap((UseCaseMap)newValue);
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
			case CoremodelPackage.SIMPLE_PATH_NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CoremodelPackage.SIMPLE_PATH_NODE__MAP:
				setMap((UseCaseMap)null);
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
			case CoremodelPackage.SIMPLE_PATH_NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CoremodelPackage.SIMPLE_PATH_NODE__MAP:
				return map != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == NamedElementModel.class) {
			switch (derivedFeatureID) {
				case CoremodelPackage.SIMPLE_PATH_NODE__NAME: return CoremodelPackage.NAMED_ELEMENT_MODEL__NAME;
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
		if (baseClass == NamedElementModel.class) {
			switch (baseFeatureID) {
				case CoremodelPackage.NAMED_ELEMENT_MODEL__NAME: return CoremodelPackage.SIMPLE_PATH_NODE__NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.coremodel.impl.PathNodeImpl#getPreviousMax()
	 */
	@Override
	protected int getPreviousMax() {
		return 1;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.coremodel.impl.PathNodeImpl#getPreviousMin()
	 */
	@Override
	protected int getPreviousMin() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.coremodel.impl.PathNodeImpl#getNextMax()
	 */
	@Override
	protected int getNextMax() {
		return 1;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.coremodel.impl.PathNodeImpl#getNextMin()
	 */
	@Override
	protected int getNextMin() {
		return 0;
	}
	
	public String getID() {
		return EObjectIdGenerator.getGeneratedEMFID(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	
	public Vector getPrologCode(Object value) {
		return new Vector();
	} 
		
	public EObject getExtendedData(String pluginId, String elementId) {
		return ExtensibleElementUtil.getExtendedData(this, pluginId, elementId);
	}

	public EObject putExtendedData(String pluginId, String elementId, EObject element) {
		return ExtensibleElementUtil.putExtendedData(this, pluginId, elementId, element);
	}
} //SimplePathNodeImpl
