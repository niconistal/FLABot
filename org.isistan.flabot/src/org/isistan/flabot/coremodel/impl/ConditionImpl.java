/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConditionImpl.java,v 1.17 2006/04/12 02:24:57 apersson Exp $
 */
package org.isistan.flabot.coremodel.impl;

import java.io.IOException;
import java.util.Vector;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.UseCaseMap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ConditionImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ConditionImpl#getUseCaseMap <em>Use Case Map</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ConditionImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ConditionImpl#getFamily <em>Family</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ConditionImpl#getSourceResponsibility <em>Source Responsibility</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ConditionImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ConditionImpl#getDependencyResponsibility <em>Dependency Responsibility</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionImpl extends NamedElementModelImpl implements Condition {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUseCaseMap() <em>Use Case Map</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseCaseMap()
	 * @generated
	 * @ordered
	 */
	protected UseCaseMap useCaseMap;

	/**
	 * The cached value of the '{@link #getEvent() <em>Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvent()
	 * @generated
	 * @ordered
	 */
	protected ConditionEvent event;

	/**
	 * The cached value of the '{@link #getFamily() <em>Family</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFamily()
	 * @generated
	 * @ordered
	 */
	protected Family family;

	/**
	 * The cached value of the '{@link #getSourceResponsibility() <em>Source Responsibility</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceResponsibility()
	 * @generated
	 * @ordered
	 */
	protected ResponsibilityNode sourceResponsibility;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = "precondition";

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDependencyResponsibility() <em>Dependency Responsibility</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencyResponsibility()
	 * @generated
	 * @ordered
	 */
	protected ResponsibilityNode dependencyResponsibility;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.CONDITION__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCaseMap getUseCaseMap() {
		if (useCaseMap != null && useCaseMap.eIsProxy()) {
			InternalEObject oldUseCaseMap = (InternalEObject)useCaseMap;
			useCaseMap = (UseCaseMap)eResolveProxy(oldUseCaseMap);
			if (useCaseMap != oldUseCaseMap) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoremodelPackage.CONDITION__USE_CASE_MAP, oldUseCaseMap, useCaseMap));
			}
		}
		return useCaseMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCaseMap basicGetUseCaseMap() {
		return useCaseMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseCaseMap(UseCaseMap newUseCaseMap) {
		UseCaseMap oldUseCaseMap = useCaseMap;
		useCaseMap = newUseCaseMap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.CONDITION__USE_CASE_MAP, oldUseCaseMap, useCaseMap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionEvent getEvent() {
		if (event != null && event.eIsProxy()) {
			InternalEObject oldEvent = (InternalEObject)event;
			event = (ConditionEvent)eResolveProxy(oldEvent);
			if (event != oldEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoremodelPackage.CONDITION__EVENT, oldEvent, event));
			}
		}
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionEvent basicGetEvent() {
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvent(ConditionEvent newEvent) {
		ConditionEvent oldEvent = event;
		event = newEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.CONDITION__EVENT, oldEvent, event));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Family getFamily() {
		if (family != null && family.eIsProxy()) {
			InternalEObject oldFamily = (InternalEObject)family;
			family = (Family)eResolveProxy(oldFamily);
			if (family != oldFamily) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoremodelPackage.CONDITION__FAMILY, oldFamily, family));
			}
		}
		return family;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Family basicGetFamily() {
		return family;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFamily(Family newFamily) {
		Family oldFamily = family;
		family = newFamily;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.CONDITION__FAMILY, oldFamily, family));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponsibilityNode getSourceResponsibility() {
		if (sourceResponsibility != null && sourceResponsibility.eIsProxy()) {
			InternalEObject oldSourceResponsibility = (InternalEObject)sourceResponsibility;
			sourceResponsibility = (ResponsibilityNode)eResolveProxy(oldSourceResponsibility);
			if (sourceResponsibility != oldSourceResponsibility) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoremodelPackage.CONDITION__SOURCE_RESPONSIBILITY, oldSourceResponsibility, sourceResponsibility));
			}
		}
		return sourceResponsibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponsibilityNode basicGetSourceResponsibility() {
		return sourceResponsibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceResponsibility(ResponsibilityNode newSourceResponsibility) {
		ResponsibilityNode oldSourceResponsibility = sourceResponsibility;
		sourceResponsibility = newSourceResponsibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.CONDITION__SOURCE_RESPONSIBILITY, oldSourceResponsibility, sourceResponsibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.CONDITION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponsibilityNode getDependencyResponsibility() {
		if (dependencyResponsibility != null && dependencyResponsibility.eIsProxy()) {
			InternalEObject oldDependencyResponsibility = (InternalEObject)dependencyResponsibility;
			dependencyResponsibility = (ResponsibilityNode)eResolveProxy(oldDependencyResponsibility);
			if (dependencyResponsibility != oldDependencyResponsibility) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoremodelPackage.CONDITION__DEPENDENCY_RESPONSIBILITY, oldDependencyResponsibility, dependencyResponsibility));
			}
		}
		return dependencyResponsibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponsibilityNode basicGetDependencyResponsibility() {
		return dependencyResponsibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependencyResponsibility(ResponsibilityNode newDependencyResponsibility) {
		ResponsibilityNode oldDependencyResponsibility = dependencyResponsibility;
		dependencyResponsibility = newDependencyResponsibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.CONDITION__DEPENDENCY_RESPONSIBILITY, oldDependencyResponsibility, dependencyResponsibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CoremodelPackage.CONDITION__VALUE:
				return getValue();
			case CoremodelPackage.CONDITION__USE_CASE_MAP:
				if (resolve) return getUseCaseMap();
				return basicGetUseCaseMap();
			case CoremodelPackage.CONDITION__EVENT:
				if (resolve) return getEvent();
				return basicGetEvent();
			case CoremodelPackage.CONDITION__FAMILY:
				if (resolve) return getFamily();
				return basicGetFamily();
			case CoremodelPackage.CONDITION__SOURCE_RESPONSIBILITY:
				if (resolve) return getSourceResponsibility();
				return basicGetSourceResponsibility();
			case CoremodelPackage.CONDITION__TYPE:
				return getType();
			case CoremodelPackage.CONDITION__DEPENDENCY_RESPONSIBILITY:
				if (resolve) return getDependencyResponsibility();
				return basicGetDependencyResponsibility();
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
			case CoremodelPackage.CONDITION__VALUE:
				setValue((String)newValue);
				return;
			case CoremodelPackage.CONDITION__USE_CASE_MAP:
				setUseCaseMap((UseCaseMap)newValue);
				return;
			case CoremodelPackage.CONDITION__EVENT:
				setEvent((ConditionEvent)newValue);
				return;
			case CoremodelPackage.CONDITION__FAMILY:
				setFamily((Family)newValue);
				return;
			case CoremodelPackage.CONDITION__SOURCE_RESPONSIBILITY:
				setSourceResponsibility((ResponsibilityNode)newValue);
				return;
			case CoremodelPackage.CONDITION__TYPE:
				setType((String)newValue);
				return;
			case CoremodelPackage.CONDITION__DEPENDENCY_RESPONSIBILITY:
				setDependencyResponsibility((ResponsibilityNode)newValue);
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
			case CoremodelPackage.CONDITION__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case CoremodelPackage.CONDITION__USE_CASE_MAP:
				setUseCaseMap((UseCaseMap)null);
				return;
			case CoremodelPackage.CONDITION__EVENT:
				setEvent((ConditionEvent)null);
				return;
			case CoremodelPackage.CONDITION__FAMILY:
				setFamily((Family)null);
				return;
			case CoremodelPackage.CONDITION__SOURCE_RESPONSIBILITY:
				setSourceResponsibility((ResponsibilityNode)null);
				return;
			case CoremodelPackage.CONDITION__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case CoremodelPackage.CONDITION__DEPENDENCY_RESPONSIBILITY:
				setDependencyResponsibility((ResponsibilityNode)null);
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
			case CoremodelPackage.CONDITION__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case CoremodelPackage.CONDITION__USE_CASE_MAP:
				return useCaseMap != null;
			case CoremodelPackage.CONDITION__EVENT:
				return event != null;
			case CoremodelPackage.CONDITION__FAMILY:
				return family != null;
			case CoremodelPackage.CONDITION__SOURCE_RESPONSIBILITY:
				return sourceResponsibility != null;
			case CoremodelPackage.CONDITION__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case CoremodelPackage.CONDITION__DEPENDENCY_RESPONSIBILITY:
				return dependencyResponsibility != null;
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
		result.append(" (value: ");
		result.append(value);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws IOException 
	 * @throws PlException 
	 * @generated NOT
	 */
	public Vector getPrologCode(Object value) {
		Vector prologCode = new Vector();
		ResponsibilityNode responsibility = (ResponsibilityNode)value;
		String preconditionHead;
	    if (!getType().equals(Condition.previousEvent)){
			preconditionHead = 
		    	"assert(" + //$NON-NLS-1$
		    	this.type +
		    	"(" + //$NON-NLS-1$
		    	responsibility.getID() +
		    	"," + responsibility.getMap().getID() + //$NON-NLS-1$
		    	"," + dependencyResponsibility.getID() + //$NON-NLS-1$
		    	"," + dependencyResponsibility.getMap().getID() + //$NON-NLS-1$
		    	"," + event.getID() +  //$NON-NLS-1$
		    	"))."; //$NON-NLS-1$		    
	    }
	    else{
	    	preconditionHead = 
	    		"assert(previousEvent(" +
	    		responsibility.getID() +
	    		"," + responsibility.getRole().getID() +
	    		"," + dependencyResponsibility.getID() +
	    		"," + event.getID() +
	    		")).";
	    }
	    prologCode.add(preconditionHead);
	    return prologCode;
	}

} //ConditionImpl
