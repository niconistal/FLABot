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

import org.isistan.flabot.executionstatemapping.model.semantic.ExceptionEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exception Evaluation Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.ExceptionEvaluationConditionImpl#isCheckAnyException <em>Check Any Exception</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExceptionEvaluationConditionImpl extends EvaluationConditionImpl implements ExceptionEvaluationCondition {
	/**
	 * The default value of the '{@link #isCheckAnyException() <em>Check Any Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCheckAnyException()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHECK_ANY_EXCEPTION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCheckAnyException() <em>Check Any Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCheckAnyException()
	 * @generated
	 * @ordered
	 */
	protected boolean checkAnyException = CHECK_ANY_EXCEPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExceptionEvaluationConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticPackage.Literals.EXCEPTION_EVALUATION_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCheckAnyException() {
		return checkAnyException;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCheckAnyException(boolean newCheckAnyException) {
		boolean oldCheckAnyException = checkAnyException;
		checkAnyException = newCheckAnyException;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.EXCEPTION_EVALUATION_CONDITION__CHECK_ANY_EXCEPTION, oldCheckAnyException, checkAnyException));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SemanticPackage.EXCEPTION_EVALUATION_CONDITION__CHECK_ANY_EXCEPTION:
				return isCheckAnyException() ? Boolean.TRUE : Boolean.FALSE;
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
			case SemanticPackage.EXCEPTION_EVALUATION_CONDITION__CHECK_ANY_EXCEPTION:
				setCheckAnyException(((Boolean)newValue).booleanValue());
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
			case SemanticPackage.EXCEPTION_EVALUATION_CONDITION__CHECK_ANY_EXCEPTION:
				setCheckAnyException(CHECK_ANY_EXCEPTION_EDEFAULT);
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
			case SemanticPackage.EXCEPTION_EVALUATION_CONDITION__CHECK_ANY_EXCEPTION:
				return checkAnyException != CHECK_ANY_EXCEPTION_EDEFAULT;
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
		result.append(" (checkAnyException: ");
		result.append(checkAnyException);
		result.append(')');
		return result.toString();
	}

} //ExceptionEvaluationConditionImpl
