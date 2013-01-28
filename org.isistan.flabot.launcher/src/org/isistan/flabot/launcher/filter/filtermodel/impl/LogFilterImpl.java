/**
 * <copyright>
 * </copyright>
 *
 * $Id: LogFilterImpl.java,v 1.1 2006/02/27 21:57:55 dacostae Exp $
 */
package org.isistan.flabot.launcher.filter.filtermodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.isistan.flabot.gauge.Gauge.Type;
import org.isistan.flabot.launcher.filter.filtermodel.FiltermodelPackage;
import org.isistan.flabot.launcher.filter.filtermodel.LogFilter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Log Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.launcher.filter.filtermodel.impl.LogFilterImpl#getGaugeTypes <em>Gauge Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LogFilterImpl extends EObjectImpl implements LogFilter {
	/**
	 * The default value of the '{@link #getGaugeTypes() <em>Gauge Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGaugeTypes()
	 * @generated
	 * @ordered
	 */
	protected static final int GAUGE_TYPES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getGaugeTypes() <em>Gauge Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGaugeTypes()
	 * @generated
	 * @ordered
	 */
	protected int gaugeTypes = GAUGE_TYPES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LogFilterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return FiltermodelPackage.eINSTANCE.getLogFilter();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getGaugeTypes() {
		return gaugeTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGaugeTypes(int newGaugeTypes) {
		int oldGaugeTypes = gaugeTypes;
		gaugeTypes = newGaugeTypes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FiltermodelPackage.LOG_FILTER__GAUGE_TYPES, oldGaugeTypes, gaugeTypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case FiltermodelPackage.LOG_FILTER__GAUGE_TYPES:
				return new Integer(getGaugeTypes());
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
			case FiltermodelPackage.LOG_FILTER__GAUGE_TYPES:
				setGaugeTypes(((Integer)newValue).intValue());
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
			case FiltermodelPackage.LOG_FILTER__GAUGE_TYPES:
				setGaugeTypes(GAUGE_TYPES_EDEFAULT);
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
			case FiltermodelPackage.LOG_FILTER__GAUGE_TYPES:
				return gaugeTypes != GAUGE_TYPES_EDEFAULT;
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
		result.append(" (gaugeTypes: ");
		result.append(gaugeTypes);
		result.append(')');
		return result.toString();
	}

	public boolean isGaugeType(Type gaugeType) {
		int flag=1<<gaugeType.getOrdinal();
		int bool=getGaugeTypes() & flag;
		return bool!=0;
		
	}

	public void setGaugeType(Type gaugeType, boolean log) {
		if(log) {
			if(!isGaugeType(gaugeType)) {
				int flag=1<<gaugeType.getOrdinal();
				int gaugeTypes=getGaugeTypes() | flag;
				setGaugeTypes(gaugeTypes);
			}
		} else {
			if(isGaugeType(gaugeType)) {
				int flag=1<<gaugeType.getOrdinal();
				gaugeTypes=getGaugeTypes() ^ flag;
				setGaugeTypes(gaugeTypes);
			}
		}
	}

} //LogFilterImpl
