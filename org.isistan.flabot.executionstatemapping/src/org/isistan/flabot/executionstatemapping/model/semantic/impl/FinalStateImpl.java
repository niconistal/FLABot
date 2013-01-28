/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue;
import org.isistan.flabot.executionstatemapping.model.semantic.FinalState;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Final State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.FinalStateImpl#getExecutionState <em>Execution State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FinalStateImpl extends StateImpl implements FinalState {
	/**
	 * The default value of the '{@link #getExecutionState() <em>Execution State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionState()
	 * @generated
	 * @ordered
	 */
	protected static final ExecutionStateValue EXECUTION_STATE_EDEFAULT = ExecutionStateValue.FAULTY;

	/**
	 * The cached value of the '{@link #getExecutionState() <em>Execution State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionState()
	 * @generated
	 * @ordered
	 */
	protected ExecutionStateValue executionState = EXECUTION_STATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FinalStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticPackage.Literals.FINAL_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionStateValue getExecutionState() {
		return executionState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutionState(ExecutionStateValue newExecutionState) {
		ExecutionStateValue oldExecutionState = executionState;
		executionState = newExecutionState == null ? EXECUTION_STATE_EDEFAULT : newExecutionState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.FINAL_STATE__EXECUTION_STATE, oldExecutionState, executionState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SemanticPackage.FINAL_STATE__EXECUTION_STATE:
				return getExecutionState();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SemanticPackage.FINAL_STATE__EXECUTION_STATE:
				setExecutionState((ExecutionStateValue)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SemanticPackage.FINAL_STATE__EXECUTION_STATE:
				setExecutionState(EXECUTION_STATE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SemanticPackage.FINAL_STATE__EXECUTION_STATE:
				return executionState != EXECUTION_STATE_EDEFAULT;
		}
		return super.eIsSet(featureID);
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
		result.append(" (executionState: ");
		result.append(executionState);
		result.append(')');
		return result.toString();
	}

} //FinalStateImpl
