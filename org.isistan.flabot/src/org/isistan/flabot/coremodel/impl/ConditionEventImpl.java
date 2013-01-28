/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConditionEventImpl.java,v 1.2 2006/02/28 22:58:06 franco Exp $
 */
package org.isistan.flabot.coremodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.ExtensibleElementUtil;

import org.isistan.flabot.coremodel.ExtensibleElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ConditionEventImpl#getExtendedData <em>Extended Data</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ConditionEventImpl#getConditionEvent <em>Condition Event</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ConditionEventImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ConditionEventImpl#getAssociatedConditions <em>Associated Conditions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionEventImpl extends NamedElementModelImpl implements ConditionEvent {
	/**
	 * The cached value of the '{@link #getExtendedData() <em>Extended Data</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedData()
	 * @generated
	 * @ordered
	 */
	protected EMap extendedData;

	/**
	 * The default value of the '{@link #getConditionEvent() <em>Condition Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionEvent()
	 * @generated
	 * @ordered
	 */
	protected static final String CONDITION_EVENT_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getConditionEvent() <em>Condition Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionEvent()
	 * @generated
	 * @ordered
	 */
	protected String conditionEvent = CONDITION_EVENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = "";

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
	 * The cached value of the '{@link #getAssociatedConditions() <em>Associated Conditions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedConditions()
	 * @generated
	 * @ordered
	 */
	protected EList associatedConditions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.CONDITION_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getExtendedData() {
		if (extendedData == null) {
			extendedData = new EcoreEMap(CoremodelPackage.Literals.ESTRING_TO_EOBJECT_MAP_ENTRY, EStringToEObjectMapEntryImpl.class, this, CoremodelPackage.CONDITION_EVENT__EXTENDED_DATA);
		}
		return extendedData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConditionEvent() {
		return conditionEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditionEvent(String newConditionEvent) {
		String oldConditionEvent = conditionEvent;
		conditionEvent = newConditionEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.CONDITION_EVENT__CONDITION_EVENT, oldConditionEvent, conditionEvent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.CONDITION_EVENT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAssociatedConditions() {
		if (associatedConditions == null) {
			associatedConditions = new EObjectResolvingEList(Condition.class, this, CoremodelPackage.CONDITION_EVENT__ASSOCIATED_CONDITIONS);
		}
		return associatedConditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CoremodelPackage.CONDITION_EVENT__EXTENDED_DATA:
				return ((InternalEList)getExtendedData()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CoremodelPackage.CONDITION_EVENT__EXTENDED_DATA:
				if (coreType) return getExtendedData();
				else return getExtendedData().map();
			case CoremodelPackage.CONDITION_EVENT__CONDITION_EVENT:
				return getConditionEvent();
			case CoremodelPackage.CONDITION_EVENT__DESCRIPTION:
				return getDescription();
			case CoremodelPackage.CONDITION_EVENT__ASSOCIATED_CONDITIONS:
				return getAssociatedConditions();
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
			case CoremodelPackage.CONDITION_EVENT__EXTENDED_DATA:
				((EStructuralFeature.Setting)getExtendedData()).set(newValue);
				return;
			case CoremodelPackage.CONDITION_EVENT__CONDITION_EVENT:
				setConditionEvent((String)newValue);
				return;
			case CoremodelPackage.CONDITION_EVENT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CoremodelPackage.CONDITION_EVENT__ASSOCIATED_CONDITIONS:
				getAssociatedConditions().clear();
				getAssociatedConditions().addAll((Collection)newValue);
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
			case CoremodelPackage.CONDITION_EVENT__EXTENDED_DATA:
				getExtendedData().clear();
				return;
			case CoremodelPackage.CONDITION_EVENT__CONDITION_EVENT:
				setConditionEvent(CONDITION_EVENT_EDEFAULT);
				return;
			case CoremodelPackage.CONDITION_EVENT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CoremodelPackage.CONDITION_EVENT__ASSOCIATED_CONDITIONS:
				getAssociatedConditions().clear();
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
			case CoremodelPackage.CONDITION_EVENT__EXTENDED_DATA:
				return extendedData != null && !extendedData.isEmpty();
			case CoremodelPackage.CONDITION_EVENT__CONDITION_EVENT:
				return CONDITION_EVENT_EDEFAULT == null ? conditionEvent != null : !CONDITION_EVENT_EDEFAULT.equals(conditionEvent);
			case CoremodelPackage.CONDITION_EVENT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CoremodelPackage.CONDITION_EVENT__ASSOCIATED_CONDITIONS:
				return associatedConditions != null && !associatedConditions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == ExtensibleElement.class) {
			switch (derivedFeatureID) {
				case CoremodelPackage.CONDITION_EVENT__EXTENDED_DATA: return CoremodelPackage.EXTENSIBLE_ELEMENT__EXTENDED_DATA;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
		if (baseClass == ExtensibleElement.class) {
			switch (baseFeatureID) {
				case CoremodelPackage.EXTENSIBLE_ELEMENT__EXTENDED_DATA: return CoremodelPackage.CONDITION_EVENT__EXTENDED_DATA;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (conditionEvent: ");
		result.append(conditionEvent);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}
	
	public EObject getExtendedData(String pluginId, String elementId) {
		return ExtensibleElementUtil.getExtendedData(this, pluginId, elementId);
	}

	public EObject putExtendedData(String pluginId, String elementId, EObject element) {
		return ExtensibleElementUtil.putExtendedData(this, pluginId, elementId, element);
	}

} //ConditionEventImpl
