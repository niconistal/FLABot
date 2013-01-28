/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConditionEventToConditionEventMapEntryImpl.java,v 1.2 2006/04/11 23:31:50 franco Exp $
 */
package org.isistan.flabot.coremodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.coremodel.CoremodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition Event To Condition Event Map Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ConditionEventToConditionEventMapEntryImpl#getTypedKey <em>Key</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ConditionEventToConditionEventMapEntryImpl#getTypedValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionEventToConditionEventMapEntryImpl extends EObjectImpl implements BasicEMap.Entry {
	/**
	 * The cached value of the '{@link #getTypedKey() <em>Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedKey()
	 * @generated
	 * @ordered
	 */
	protected ConditionEvent key;

	/**
	 * The cached value of the '{@link #getTypedValue() <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedValue()
	 * @generated
	 * @ordered
	 */
	protected ConditionEvent value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionEventToConditionEventMapEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionEvent getTypedKey() {
		if (key != null && key.eIsProxy()) {
			InternalEObject oldKey = (InternalEObject)key;
			key = (ConditionEvent)eResolveProxy(oldKey);
			if (key != oldKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoremodelPackage.CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY__KEY, oldKey, key));
			}
		}
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionEvent basicGetTypedKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypedKey(ConditionEvent newKey) {
		ConditionEvent oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY__KEY, oldKey, key));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionEvent getTypedValue() {
		if (value != null && value.eIsProxy()) {
			InternalEObject oldValue = (InternalEObject)value;
			value = (ConditionEvent)eResolveProxy(oldValue);
			if (value != oldValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoremodelPackage.CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY__VALUE, oldValue, value));
			}
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionEvent basicGetTypedValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypedValue(ConditionEvent newValue) {
		ConditionEvent oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CoremodelPackage.CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY__KEY:
				if (resolve) return getTypedKey();
				return basicGetTypedKey();
			case CoremodelPackage.CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY__VALUE:
				if (resolve) return getTypedValue();
				return basicGetTypedValue();
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
			case CoremodelPackage.CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY__KEY:
				setTypedKey((ConditionEvent)newValue);
				return;
			case CoremodelPackage.CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY__VALUE:
				setTypedValue((ConditionEvent)newValue);
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
			case CoremodelPackage.CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY__KEY:
				setTypedKey((ConditionEvent)null);
				return;
			case CoremodelPackage.CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY__VALUE:
				setTypedValue((ConditionEvent)null);
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
			case CoremodelPackage.CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY__KEY:
				return key != null;
			case CoremodelPackage.CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY__VALUE:
				return value != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected int hash = -1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getHash() {
		if (hash == -1) {
			Object theKey = getKey();
			hash = (theKey == null ? 0 : theKey.hashCode());
		}
		return hash;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHash(int hash) {
		this.hash = hash;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getKey() {
		return getTypedKey();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKey(Object key) {
		setTypedKey((ConditionEvent)key);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getValue() {
		return getTypedValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object setValue(Object value) {
		Object oldValue = getValue();
		setTypedValue((ConditionEvent)value);
		return oldValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getEMap() {
		EObject container = eContainer();
		return container == null ? null : (EMap)container.eGet(eContainmentFeature());
	}

} //ConditionEventToConditionEventMapEntryImpl
