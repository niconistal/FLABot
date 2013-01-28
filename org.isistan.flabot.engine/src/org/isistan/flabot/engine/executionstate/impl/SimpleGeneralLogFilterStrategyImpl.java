/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.engine.executionstate.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;
import org.isistan.flabot.engine.executionstate.SimpleGeneralLogFilterStrategy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple General Log Filter Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.engine.executionstate.impl.SimpleGeneralLogFilterStrategyImpl#getPrologCodeText <em>Prolog Code Text</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleGeneralLogFilterStrategyImpl extends EObjectImpl implements SimpleGeneralLogFilterStrategy {
	/**
	 * The default value of the '{@link #getPrologCodeText() <em>Prolog Code Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrologCodeText()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String PROLOG_CODE_TEXT_EDEFAULT = "generalPreFilter.\ngeneralPreFilterAccepts(Tag).";

	/**
	 * The cached value of the '{@link #getPrologCodeText() <em>Prolog Code Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrologCodeText()
	 * @generated
	 * @ordered
	 */
	protected String prologCodeText = PROLOG_CODE_TEXT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleGeneralLogFilterStrategyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExecutionstatePackage.eINSTANCE.getSimpleGeneralLogFilterStrategy();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrologCodeText() {
		return prologCodeText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrologCodeText(String newPrologCodeText) {
		String oldPrologCodeText = prologCodeText;
		prologCodeText = newPrologCodeText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionstatePackage.SIMPLE_GENERAL_LOG_FILTER_STRATEGY__PROLOG_CODE_TEXT, oldPrologCodeText, prologCodeText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionstatePackage.SIMPLE_GENERAL_LOG_FILTER_STRATEGY__PROLOG_CODE_TEXT:
				return getPrologCodeText();
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
			case ExecutionstatePackage.SIMPLE_GENERAL_LOG_FILTER_STRATEGY__PROLOG_CODE_TEXT:
				setPrologCodeText((String)newValue);
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
			case ExecutionstatePackage.SIMPLE_GENERAL_LOG_FILTER_STRATEGY__PROLOG_CODE_TEXT:
				setPrologCodeText(PROLOG_CODE_TEXT_EDEFAULT);
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
			case ExecutionstatePackage.SIMPLE_GENERAL_LOG_FILTER_STRATEGY__PROLOG_CODE_TEXT:
				return PROLOG_CODE_TEXT_EDEFAULT == null ? prologCodeText != null : !PROLOG_CODE_TEXT_EDEFAULT.equals(prologCodeText);
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
		result.append(" (prologCodeText: ");
		result.append(prologCodeText);
		result.append(')');
		return result.toString();
	}
	
	public String getPrologCode()
	{
		String prolog = getPrologCodeText();
		if (prolog == null || prologCodeText.trim().length() == 0)
		{
			prolog = PROLOG_CODE_TEXT_EDEFAULT;
		}		
		return prolog;
	}

	public void resetProlog()
	{
		//Do nothing
	}

} //SimpleGeneralLogFilterStrategyImpl
