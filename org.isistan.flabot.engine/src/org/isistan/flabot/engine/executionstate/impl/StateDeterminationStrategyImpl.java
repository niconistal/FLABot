/**
 * <copyright>
 * </copyright>
 *
 * $Id: StateDeterminationStrategyImpl.java,v 1.5 2006/02/27 22:05:23 dacostae Exp $
 */
package org.isistan.flabot.engine.executionstate.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;
import org.isistan.flabot.engine.executionstate.StateDeterminationStrategy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Determination Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.engine.executionstate.impl.StateDeterminationStrategyImpl#getResponsibility <em>Responsibility</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class StateDeterminationStrategyImpl extends EObjectImpl implements StateDeterminationStrategy {
	/**
	 * The cached value of the '{@link #getResponsibility() <em>Responsibility</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponsibility()
	 * @generated
	 * @ordered
	 */
	protected Responsibility responsibility = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateDeterminationStrategyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionstatePackage.eINSTANCE.getStateDeterminationStrategy();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Responsibility getResponsibility() {
		if (responsibility != null && responsibility.eIsProxy()) {
			Responsibility oldResponsibility = responsibility;
			responsibility = (Responsibility)eResolveProxy((InternalEObject)responsibility);
			if (responsibility != oldResponsibility) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionstatePackage.STATE_DETERMINATION_STRATEGY__RESPONSIBILITY, oldResponsibility, responsibility));
			}
		}
		return responsibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Responsibility basicGetResponsibility() {
		return responsibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponsibility(Responsibility newResponsibility) {
		Responsibility oldResponsibility = responsibility;
		responsibility = newResponsibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionstatePackage.STATE_DETERMINATION_STRATEGY__RESPONSIBILITY, oldResponsibility, responsibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionstatePackage.STATE_DETERMINATION_STRATEGY__RESPONSIBILITY:
				if (resolve) return getResponsibility();
				return basicGetResponsibility();
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
			case ExecutionstatePackage.STATE_DETERMINATION_STRATEGY__RESPONSIBILITY:
				setResponsibility((Responsibility)newValue);
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
			case ExecutionstatePackage.STATE_DETERMINATION_STRATEGY__RESPONSIBILITY:
				setResponsibility((Responsibility)null);
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
			case ExecutionstatePackage.STATE_DETERMINATION_STRATEGY__RESPONSIBILITY:
				return responsibility != null;
		}
		return eDynamicIsSet(eFeature);
	}
	
	public void checkMapping()
	{
		//No check needed
	}
	
	public void checkFilter()
	{
		//Do nothing
	}
} //StateDeterminationStrategyImpl
