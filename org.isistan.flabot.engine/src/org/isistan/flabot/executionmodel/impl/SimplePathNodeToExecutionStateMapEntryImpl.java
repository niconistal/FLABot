/**
 * <copyright>
 * </copyright>
 *
 * $Id: SimplePathNodeToExecutionStateMapEntryImpl.java,v 1.2 2006/02/14 22:18:47 franco Exp $
 */
package org.isistan.flabot.executionmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.engine.executionstate.ExecutionState;
import org.isistan.flabot.executionmodel.ExecutionmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Path Node To Execution State Map Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.SimplePathNodeToExecutionStateMapEntryImpl#getTypedKey <em>Key</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.SimplePathNodeToExecutionStateMapEntryImpl#getTypedValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimplePathNodeToExecutionStateMapEntryImpl extends EObjectImpl implements BasicEMap.Entry {
	/**
	 * The cached value of the '{@link #getTypedKey() <em>Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedKey()
	 * @generated
	 * @ordered
	 */
	protected SimplePathNode key = null;

	/**
	 * The default value of the '{@link #getTypedValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedValue()
	 * @generated
	 * @ordered
	 */
	protected static final ExecutionState VALUE_EDEFAULT = ExecutionState.EXECUTED_LITERAL;

	/**
	 * The cached value of the '{@link #getTypedValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedValue()
	 * @generated
	 * @ordered
	 */
	protected ExecutionState value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimplePathNodeToExecutionStateMapEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExecutionmodelPackage.eINSTANCE.getSimplePathNodeToExecutionStateMapEntry();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode getTypedKey() {
		if (key != null && key.eIsProxy()) {
			SimplePathNode oldKey = key;
			key = (SimplePathNode)eResolveProxy((InternalEObject)key);
			if (key != oldKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionmodelPackage.SIMPLE_PATH_NODE_TO_EXECUTION_STATE_MAP_ENTRY__KEY, oldKey, key));
			}
		}
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode basicGetTypedKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypedKey(SimplePathNode newKey) {
		SimplePathNode oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.SIMPLE_PATH_NODE_TO_EXECUTION_STATE_MAP_ENTRY__KEY, oldKey, key));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionState getTypedValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypedValue(ExecutionState newValue) {
		ExecutionState oldValue = value;
		value = newValue == null ? VALUE_EDEFAULT : newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.SIMPLE_PATH_NODE_TO_EXECUTION_STATE_MAP_ENTRY__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionmodelPackage.SIMPLE_PATH_NODE_TO_EXECUTION_STATE_MAP_ENTRY__KEY:
				if (resolve) return getTypedKey();
				return basicGetTypedKey();
			case ExecutionmodelPackage.SIMPLE_PATH_NODE_TO_EXECUTION_STATE_MAP_ENTRY__VALUE:
				return getTypedValue();
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
			case ExecutionmodelPackage.SIMPLE_PATH_NODE_TO_EXECUTION_STATE_MAP_ENTRY__KEY:
				setTypedKey((SimplePathNode)newValue);
				return;
			case ExecutionmodelPackage.SIMPLE_PATH_NODE_TO_EXECUTION_STATE_MAP_ENTRY__VALUE:
				setTypedValue((ExecutionState)newValue);
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
			case ExecutionmodelPackage.SIMPLE_PATH_NODE_TO_EXECUTION_STATE_MAP_ENTRY__KEY:
				setTypedKey((SimplePathNode)null);
				return;
			case ExecutionmodelPackage.SIMPLE_PATH_NODE_TO_EXECUTION_STATE_MAP_ENTRY__VALUE:
				setTypedValue(VALUE_EDEFAULT);
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
			case ExecutionmodelPackage.SIMPLE_PATH_NODE_TO_EXECUTION_STATE_MAP_ENTRY__KEY:
				return key != null;
			case ExecutionmodelPackage.SIMPLE_PATH_NODE_TO_EXECUTION_STATE_MAP_ENTRY__VALUE:
				return value != VALUE_EDEFAULT;
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (value: ");
		result.append(value);
		result.append(')');
		return result.toString();
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
		setTypedKey((SimplePathNode)key);
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
		setTypedValue((ExecutionState)value);
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

} //SimplePathNodeToExecutionStateMapEntryImpl
