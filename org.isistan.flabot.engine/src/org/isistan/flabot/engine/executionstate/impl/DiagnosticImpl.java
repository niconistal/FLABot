/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagnosticImpl.java,v 1.2 2006/03/22 03:28:54 franco Exp $
 */
package org.isistan.flabot.engine.executionstate.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.engine.executionstate.Diagnostic;
import org.isistan.flabot.engine.executionstate.ExecutionState;
import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;
import org.isistan.flabot.engine.executionstate.StateDeterminationStrategy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagnostic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.engine.executionstate.impl.DiagnosticImpl#getDiagnostician <em>Diagnostician</em>}</li>
 *   <li>{@link org.isistan.flabot.engine.executionstate.impl.DiagnosticImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.isistan.flabot.engine.executionstate.impl.DiagnosticImpl#getAdditionalData <em>Additional Data</em>}</li>
 *   <li>{@link org.isistan.flabot.engine.executionstate.impl.DiagnosticImpl#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiagnosticImpl extends EObjectImpl implements Diagnostic {
	/**
	 * The cached value of the '{@link #getDiagnostician() <em>Diagnostician</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagnostician()
	 * @generated
	 * @ordered
	 */
	protected StateDeterminationStrategy diagnostician = null;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAdditionalData() <em>Additional Data</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionalData()
	 * @generated
	 * @ordered
	 */
	protected EMap additionalData = null;

	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final ExecutionState STATE_EDEFAULT = ExecutionState.EXECUTED_LITERAL;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected ExecutionState state = STATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagnosticImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExecutionstatePackage.eINSTANCE.getDiagnostic();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateDeterminationStrategy getDiagnostician() {
		if (diagnostician != null && diagnostician.eIsProxy()) {
			StateDeterminationStrategy oldDiagnostician = diagnostician;
			diagnostician = (StateDeterminationStrategy)eResolveProxy((InternalEObject)diagnostician);
			if (diagnostician != oldDiagnostician) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionstatePackage.DIAGNOSTIC__DIAGNOSTICIAN, oldDiagnostician, diagnostician));
			}
		}
		return diagnostician;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateDeterminationStrategy basicGetDiagnostician() {
		return diagnostician;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagnostician(StateDeterminationStrategy newDiagnostician) {
		StateDeterminationStrategy oldDiagnostician = diagnostician;
		diagnostician = newDiagnostician;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionstatePackage.DIAGNOSTIC__DIAGNOSTICIAN, oldDiagnostician, diagnostician));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionstatePackage.DIAGNOSTIC__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getAdditionalData() {
		if (additionalData == null) {
			additionalData = new EcoreEMap(ExecutionstatePackage.eINSTANCE.getEStringToEJavaObjectMapEntry(), EStringToEJavaObjectMapEntryImpl.class, this, ExecutionstatePackage.DIAGNOSTIC__ADDITIONAL_DATA);
		}
		return additionalData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionState getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(ExecutionState newState) {
		ExecutionState oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionstatePackage.DIAGNOSTIC__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ExecutionstatePackage.DIAGNOSTIC__ADDITIONAL_DATA:
					return ((InternalEList)getAdditionalData()).basicRemove(otherEnd, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionstatePackage.DIAGNOSTIC__DIAGNOSTICIAN:
				if (resolve) return getDiagnostician();
				return basicGetDiagnostician();
			case ExecutionstatePackage.DIAGNOSTIC__DESCRIPTION:
				return getDescription();
			case ExecutionstatePackage.DIAGNOSTIC__ADDITIONAL_DATA:
				return getAdditionalData();
			case ExecutionstatePackage.DIAGNOSTIC__STATE:
				return getState();
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
			case ExecutionstatePackage.DIAGNOSTIC__DIAGNOSTICIAN:
				setDiagnostician((StateDeterminationStrategy)newValue);
				return;
			case ExecutionstatePackage.DIAGNOSTIC__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ExecutionstatePackage.DIAGNOSTIC__ADDITIONAL_DATA:
				getAdditionalData().clear();
				getAdditionalData().addAll((Collection)newValue);
				return;
			case ExecutionstatePackage.DIAGNOSTIC__STATE:
				setState((ExecutionState)newValue);
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
			case ExecutionstatePackage.DIAGNOSTIC__DIAGNOSTICIAN:
				setDiagnostician((StateDeterminationStrategy)null);
				return;
			case ExecutionstatePackage.DIAGNOSTIC__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ExecutionstatePackage.DIAGNOSTIC__ADDITIONAL_DATA:
				getAdditionalData().clear();
				return;
			case ExecutionstatePackage.DIAGNOSTIC__STATE:
				setState(STATE_EDEFAULT);
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
			case ExecutionstatePackage.DIAGNOSTIC__DIAGNOSTICIAN:
				return diagnostician != null;
			case ExecutionstatePackage.DIAGNOSTIC__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ExecutionstatePackage.DIAGNOSTIC__ADDITIONAL_DATA:
				return additionalData != null && !additionalData.isEmpty();
			case ExecutionstatePackage.DIAGNOSTIC__STATE:
				return state != STATE_EDEFAULT;
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
		result.append(" (description: ");
		result.append(description);
		result.append(", state: ");
		result.append(state);
		result.append(')');
		return result.toString();
	}

} //DiagnosticImpl
