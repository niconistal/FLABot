/**
 * <copyright>
 * </copyright>
 *
 * $Id: ResponsibilityNodeToExecutionStateMapEntryImpl.java,v 1.2 2006/02/03 21:03:06 dacostae Exp $
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
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.engine.executionstate.ExecutionState;
import org.isistan.flabot.executionmodel.ExecutionmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Responsibility Node To Execution State Map Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ResponsibilityNodeToExecutionStateMapEntryImpl#getTypedKey <em>Key</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ResponsibilityNodeToExecutionStateMapEntryImpl#getTypedValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResponsibilityNodeToExecutionStateMapEntryImpl extends EObjectImpl implements BasicEMap.Entry {
	/**
	 * The cached value of the '{@link #getTypedKey() <em>Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedKey()
	 * @generated
	 * @ordered
	 */
	protected ResponsibilityNode key = null;

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
	protected ResponsibilityNodeToExecutionStateMapEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionmodelPackage.eINSTANCE.getResponsibilityNodeToExecutionStateMapEntry();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponsibilityNode getTypedKey() {
		if (key != null && key.eIsProxy()) {
			ResponsibilityNode oldKey = key;
			key = (ResponsibilityNode)eResolveProxy((InternalEObject)key);
			if (key != oldKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionmodelPackage.RESPONSIBILITY_NODE_TO_EXECUTION_STATE_MAP_ENTRY__KEY, oldKey, key));
			}
		}
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponsibilityNode basicGetTypedKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypedKey(ResponsibilityNode newKey) {
		ResponsibilityNode oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.RESPONSIBILITY_NODE_TO_EXECUTION_STATE_MAP_ENTRY__KEY, oldKey, key));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.RESPONSIBILITY_NODE_TO_EXECUTION_STATE_MAP_ENTRY__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionmodelPackage.RESPONSIBILITY_NODE_TO_EXECUTION_STATE_MAP_ENTRY__KEY:
				if (resolve) return getTypedKey();
				return basicGetTypedKey();
			case ExecutionmodelPackage.RESPONSIBILITY_NODE_TO_EXECUTION_STATE_MAP_ENTRY__VALUE:
				return getTypedValue();
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
			case ExecutionmodelPackage.RESPONSIBILITY_NODE_TO_EXECUTION_STATE_MAP_ENTRY__KEY:
				setTypedKey((ResponsibilityNode)newValue);
				return;
			case ExecutionmodelPackage.RESPONSIBILITY_NODE_TO_EXECUTION_STATE_MAP_ENTRY__VALUE:
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
	@Override
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionmodelPackage.RESPONSIBILITY_NODE_TO_EXECUTION_STATE_MAP_ENTRY__KEY:
				setTypedKey((ResponsibilityNode)null);
				return;
			case ExecutionmodelPackage.RESPONSIBILITY_NODE_TO_EXECUTION_STATE_MAP_ENTRY__VALUE:
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
	@Override
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionmodelPackage.RESPONSIBILITY_NODE_TO_EXECUTION_STATE_MAP_ENTRY__KEY:
				return key != null;
			case ExecutionmodelPackage.RESPONSIBILITY_NODE_TO_EXECUTION_STATE_MAP_ENTRY__VALUE:
				return value != VALUE_EDEFAULT;
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
		setTypedKey((ResponsibilityNode)key);
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

} //ResponsibilityNodeToExecutionStateMapEntryImpl
