/**
 * <copyright>
 * </copyright>
 *
 * $Id: ResponsibilityToStateDeterminationStrategyMapEntryImpl.java,v 1.4 2006/04/10 21:55:02 franco Exp $
 */
package org.isistan.flabot.engine.executionstate.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;
import org.isistan.flabot.engine.executionstate.StateDeterminationStrategy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Responsibility To State Determination Strategy Map Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.engine.executionstate.impl.ResponsibilityToStateDeterminationStrategyMapEntryImpl#getTypedKey <em>Key</em>}</li>
 *   <li>{@link org.isistan.flabot.engine.executionstate.impl.ResponsibilityToStateDeterminationStrategyMapEntryImpl#getTypedValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResponsibilityToStateDeterminationStrategyMapEntryImpl extends EObjectImpl implements BasicEMap.Entry {
	/**
	 * The cached value of the '{@link #getTypedKey() <em>Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedKey()
	 * @generated
	 * @ordered
	 */
	protected Responsibility key = null;

	/**
	 * The cached value of the '{@link #getTypedValue() <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedValue()
	 * @generated
	 * @ordered
	 */
	protected StateDeterminationStrategy value = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResponsibilityToStateDeterminationStrategyMapEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionstatePackage.eINSTANCE.getResponsibilityToStateDeterminationStrategyMapEntry();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Responsibility getTypedKey() {
		if (key != null && key.eIsProxy()) {
			Responsibility oldKey = key;
			key = (Responsibility)eResolveProxy((InternalEObject)key);
			if (key != oldKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionstatePackage.RESPONSIBILITY_TO_STATE_DETERMINATION_STRATEGY_MAP_ENTRY__KEY, oldKey, key));
			}
		}
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Responsibility basicGetTypedKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypedKey(Responsibility newKey) {
		Responsibility oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionstatePackage.RESPONSIBILITY_TO_STATE_DETERMINATION_STRATEGY_MAP_ENTRY__KEY, oldKey, key));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateDeterminationStrategy getTypedValue() {
		if (value != null && value.eIsProxy()) {
			StateDeterminationStrategy oldValue = value;
			value = (StateDeterminationStrategy)eResolveProxy((InternalEObject)value);
			if (value != oldValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionstatePackage.RESPONSIBILITY_TO_STATE_DETERMINATION_STRATEGY_MAP_ENTRY__VALUE, oldValue, value));
			}
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateDeterminationStrategy basicGetTypedValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypedValue(StateDeterminationStrategy newValue) {
		StateDeterminationStrategy oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionstatePackage.RESPONSIBILITY_TO_STATE_DETERMINATION_STRATEGY_MAP_ENTRY__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionstatePackage.RESPONSIBILITY_TO_STATE_DETERMINATION_STRATEGY_MAP_ENTRY__KEY:
				if (resolve) return getTypedKey();
				return basicGetTypedKey();
			case ExecutionstatePackage.RESPONSIBILITY_TO_STATE_DETERMINATION_STRATEGY_MAP_ENTRY__VALUE:
				if (resolve) return getTypedValue();
				return basicGetTypedValue();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionstatePackage.RESPONSIBILITY_TO_STATE_DETERMINATION_STRATEGY_MAP_ENTRY__KEY:
				setTypedKey((Responsibility)newValue);
				return;
			case ExecutionstatePackage.RESPONSIBILITY_TO_STATE_DETERMINATION_STRATEGY_MAP_ENTRY__VALUE:
				setTypedValue((StateDeterminationStrategy)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionstatePackage.RESPONSIBILITY_TO_STATE_DETERMINATION_STRATEGY_MAP_ENTRY__KEY:
				setTypedKey((Responsibility)null);
				return;
			case ExecutionstatePackage.RESPONSIBILITY_TO_STATE_DETERMINATION_STRATEGY_MAP_ENTRY__VALUE:
				setTypedValue((StateDeterminationStrategy)null);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionstatePackage.RESPONSIBILITY_TO_STATE_DETERMINATION_STRATEGY_MAP_ENTRY__KEY:
				return key != null;
			case ExecutionstatePackage.RESPONSIBILITY_TO_STATE_DETERMINATION_STRATEGY_MAP_ENTRY__VALUE:
				return value != null;
		}
		return eDynamicIsSet(eFeature);
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
		setTypedKey((Responsibility)key);
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
		setTypedValue((StateDeterminationStrategy)value);
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

} //ResponsibilityToStateDeterminationStrategyMapEntryImpl
