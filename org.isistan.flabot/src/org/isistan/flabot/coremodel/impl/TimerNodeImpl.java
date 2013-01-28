/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.coremodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.TimerNode;
import org.isistan.flabot.coremodel.UseCaseMap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Timer Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.TimerNodeImpl#getTimerName <em>Timer Name</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.TimerNodeImpl#getTimerDescription <em>Timer Description</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.TimerNodeImpl#getTimerType <em>Timer Type</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.TimerNodeImpl#getTimerTimeOut <em>Timer Time Out</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.TimerNodeImpl#getTimerTimeOutUnity <em>Timer Time Out Unity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimerNodeImpl extends ResponsibilityNodeImpl implements TimerNode {
	/**
	 * The default value of the '{@link #getTimerName() <em>Timer Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimerName()
	 * @generated
	 * @ordered
	 */
	protected static final String TIMER_NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getTimerName() <em>Timer Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimerName()
	 * @generated
	 * @ordered
	 */
	protected String timerName = TIMER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimerDescription() <em>Timer Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimerDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String TIMER_DESCRIPTION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getTimerDescription() <em>Timer Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimerDescription()
	 * @generated
	 * @ordered
	 */
	protected String timerDescription = TIMER_DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimerType() <em>Timer Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimerType()
	 * @generated
	 * @ordered
	 */
	protected static final int TIMER_TYPE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTimerType() <em>Timer Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimerType()
	 * @generated
	 * @ordered
	 */
	protected int timerType = TIMER_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimerTimeOut() <em>Timer Time Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimerTimeOut()
	 * @generated
	 * @ordered
	 */
	protected static final int TIMER_TIME_OUT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTimerTimeOut() <em>Timer Time Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimerTimeOut()
	 * @generated
	 * @ordered
	 */
	protected int timerTimeOut = TIMER_TIME_OUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimerTimeOutUnity() <em>Timer Time Out Unity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimerTimeOutUnity()
	 * @generated
	 * @ordered
	 */
	protected static final String TIMER_TIME_OUT_UNITY_EDEFAULT = "Hours";

	/**
	 * The cached value of the '{@link #getTimerTimeOutUnity() <em>Timer Time Out Unity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimerTimeOutUnity()
	 * @generated
	 * @ordered
	 */
	protected String timerTimeOutUnity = TIMER_TIME_OUT_UNITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimerNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.TIMER_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTimerName() {
		return timerName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimerName(String newTimerName) {
		String oldTimerName = timerName;
		timerName = newTimerName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.TIMER_NODE__TIMER_NAME, oldTimerName, timerName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTimerDescription() {
		return timerDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimerDescription(String newTimerDescription) {
		String oldTimerDescription = timerDescription;
		timerDescription = newTimerDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.TIMER_NODE__TIMER_DESCRIPTION, oldTimerDescription, timerDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTimerType() {
		return timerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimerType(int newTimerType) {
		int oldTimerType = timerType;
		timerType = newTimerType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.TIMER_NODE__TIMER_TYPE, oldTimerType, timerType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTimerTimeOut() {
		return timerTimeOut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimerTimeOut(int newTimerTimeOut) {
		int oldTimerTimeOut = timerTimeOut;
		timerTimeOut = newTimerTimeOut;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.TIMER_NODE__TIMER_TIME_OUT, oldTimerTimeOut, timerTimeOut));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTimerTimeOutUnity() {
		return timerTimeOutUnity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimerTimeOutUnity(String newTimerTimeOutUnity) {
		String oldTimerTimeOutUnity = timerTimeOutUnity;
		timerTimeOutUnity = newTimerTimeOutUnity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.TIMER_NODE__TIMER_TIME_OUT_UNITY, oldTimerTimeOutUnity, timerTimeOutUnity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CoremodelPackage.TIMER_NODE__TIMER_NAME:
				return getTimerName();
			case CoremodelPackage.TIMER_NODE__TIMER_DESCRIPTION:
				return getTimerDescription();
			case CoremodelPackage.TIMER_NODE__TIMER_TYPE:
				return new Integer(getTimerType());
			case CoremodelPackage.TIMER_NODE__TIMER_TIME_OUT:
				return new Integer(getTimerTimeOut());
			case CoremodelPackage.TIMER_NODE__TIMER_TIME_OUT_UNITY:
				return getTimerTimeOutUnity();
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
			case CoremodelPackage.TIMER_NODE__TIMER_NAME:
				setTimerName((String)newValue);
				return;
			case CoremodelPackage.TIMER_NODE__TIMER_DESCRIPTION:
				setTimerDescription((String)newValue);
				return;
			case CoremodelPackage.TIMER_NODE__TIMER_TYPE:
				setTimerType(((Integer)newValue).intValue());
				return;
			case CoremodelPackage.TIMER_NODE__TIMER_TIME_OUT:
				setTimerTimeOut(((Integer)newValue).intValue());
				return;
			case CoremodelPackage.TIMER_NODE__TIMER_TIME_OUT_UNITY:
				setTimerTimeOutUnity((String)newValue);
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
			case CoremodelPackage.TIMER_NODE__TIMER_NAME:
				setTimerName(TIMER_NAME_EDEFAULT);
				return;
			case CoremodelPackage.TIMER_NODE__TIMER_DESCRIPTION:
				setTimerDescription(TIMER_DESCRIPTION_EDEFAULT);
				return;
			case CoremodelPackage.TIMER_NODE__TIMER_TYPE:
				setTimerType(TIMER_TYPE_EDEFAULT);
				return;
			case CoremodelPackage.TIMER_NODE__TIMER_TIME_OUT:
				setTimerTimeOut(TIMER_TIME_OUT_EDEFAULT);
				return;
			case CoremodelPackage.TIMER_NODE__TIMER_TIME_OUT_UNITY:
				setTimerTimeOutUnity(TIMER_TIME_OUT_UNITY_EDEFAULT);
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
			case CoremodelPackage.TIMER_NODE__TIMER_NAME:
				return TIMER_NAME_EDEFAULT == null ? timerName != null : !TIMER_NAME_EDEFAULT.equals(timerName);
			case CoremodelPackage.TIMER_NODE__TIMER_DESCRIPTION:
				return TIMER_DESCRIPTION_EDEFAULT == null ? timerDescription != null : !TIMER_DESCRIPTION_EDEFAULT.equals(timerDescription);
			case CoremodelPackage.TIMER_NODE__TIMER_TYPE:
				return timerType != TIMER_TYPE_EDEFAULT;
			case CoremodelPackage.TIMER_NODE__TIMER_TIME_OUT:
				return timerTimeOut != TIMER_TIME_OUT_EDEFAULT;
			case CoremodelPackage.TIMER_NODE__TIMER_TIME_OUT_UNITY:
				return TIMER_TIME_OUT_UNITY_EDEFAULT == null ? timerTimeOutUnity != null : !TIMER_TIME_OUT_UNITY_EDEFAULT.equals(timerTimeOutUnity);
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (timerName: ");
		result.append(timerName);
		result.append(", timerDescription: ");
		result.append(timerDescription);
		result.append(", timerType: ");
		result.append(timerType);
		result.append(", timerTimeOut: ");
		result.append(timerTimeOut);
		result.append(", timerTimeOutUnity: ");
		result.append(timerTimeOutUnity);
		result.append(')');
		return result.toString();
	}

} //TimerNodeImpl
