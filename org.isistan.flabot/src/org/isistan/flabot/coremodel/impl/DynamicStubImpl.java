/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.coremodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.isistan.flabot.coremodel.ConditionedStub;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.DynamicStub;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dynamic Stub</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.DynamicStubImpl#getConditionedStubs <em>Conditioned Stubs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DynamicStubImpl extends NamedElementModelImpl implements DynamicStub {
	/**
	 * The cached value of the '{@link #getConditionedStubs() <em>Conditioned Stubs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionedStubs()
	 * @generated
	 * @ordered
	 */
	protected EList conditionedStubs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DynamicStubImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.DYNAMIC_STUB_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getConditionedStubs() {
		if (conditionedStubs == null) {
			conditionedStubs = new EObjectResolvingEList(ConditionedStub.class, this, CoremodelPackage.DYNAMIC_STUB_NODE__CONDITIONED_STUBS);
		}
		return conditionedStubs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CoremodelPackage.DYNAMIC_STUB_NODE__CONDITIONED_STUBS:
				return getConditionedStubs();
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
			case CoremodelPackage.DYNAMIC_STUB_NODE__CONDITIONED_STUBS:
				getConditionedStubs().clear();
				getConditionedStubs().addAll((Collection)newValue);
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
			case CoremodelPackage.DYNAMIC_STUB_NODE__CONDITIONED_STUBS:
				getConditionedStubs().clear();
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
			case CoremodelPackage.DYNAMIC_STUB_NODE__CONDITIONED_STUBS:
				return conditionedStubs != null && !conditionedStubs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DynamicStubImpl
