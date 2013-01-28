/**
 * <copyright>
 * </copyright>
 *
 * $Id: ComponentRoleImpl.java,v 1.9 2006/03/11 00:15:38 dacostae Exp $
 */
package org.isistan.flabot.coremodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.NamedElementModel;
import org.isistan.flabot.coremodel.Note;
import org.isistan.flabot.coremodel.NoteElementModel;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.util.EObjectIdGenerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ComponentRoleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ComponentRoleImpl#getNotes <em>Notes</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ComponentRoleImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ComponentRoleImpl#getMap <em>Map</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ComponentRoleImpl#getAbstractInfo <em>Abstract Info</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ComponentRoleImpl#getComponentType <em>Component Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentRoleImpl extends ExtensibleElementImpl implements ComponentRole {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNotes() <em>Notes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotes()
	 * @generated
	 * @ordered
	 */
	protected EList notes;

	/**
	 * The cached value of the '{@link #getComponent() <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponent()
	 * @generated
	 * @ordered
	 */
	protected ComponentModel component;

	/**
	 * The default value of the '{@link #getAbstractInfo() <em>Abstract Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractInfo()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String ABSTRACT_INFO_EDEFAULT = ComponentRole.standardComponent;

	/**
	 * The cached value of the '{@link #getAbstractInfo() <em>Abstract Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractInfo()
	 * @generated
	 * @ordered
	 */
	protected String abstractInfo = ABSTRACT_INFO_EDEFAULT;

	/**
	 * The default value of the '{@link #getComponentType() <em>Component Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentType()
	 * @generated
	 * @ordered
	 */
	protected static final int COMPONENT_TYPE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getComponentType() <em>Component Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentType()
	 * @generated
	 * @ordered
	 */
	protected int componentType = COMPONENT_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentRoleImpl() {
		super();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.COMPONENT_ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.COMPONENT_ROLE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getNotes() {
		if (notes == null) {
			notes = new EObjectResolvingEList(Note.class, this, CoremodelPackage.COMPONENT_ROLE__NOTES);
		}
		return notes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentModel getComponent() {
		if (component != null && component.eIsProxy()) {
			InternalEObject oldComponent = (InternalEObject)component;
			component = (ComponentModel)eResolveProxy(oldComponent);
			if (component != oldComponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoremodelPackage.COMPONENT_ROLE__COMPONENT, oldComponent, component));
			}
		}
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentModel basicGetComponent() {
		return component;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.coremodel.ComponentRole#setComponent(org.isistan.flabot.coremodel.ComponentModel)
	 */
	public void setComponent(ComponentModel newComponent) {
		ComponentModel oldComponent = component;
		setComponentGen(newComponent);
		if (oldComponent != null)
			oldComponent.eAdapters().remove(this);
		if (newComponent != null)
			newComponent.eAdapters().add(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentGen(ComponentModel newComponent) {
		ComponentModel oldComponent = component;
		component = newComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.COMPONENT_ROLE__COMPONENT, oldComponent, component));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCaseMap getMap() {
		if (eContainerFeatureID() != CoremodelPackage.COMPONENT_ROLE__MAP) return null;
		return (UseCaseMap)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMap(UseCaseMap newMap, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMap, CoremodelPackage.COMPONENT_ROLE__MAP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMap(UseCaseMap newMap) {
		if (newMap != eInternalContainer() || (eContainerFeatureID() != CoremodelPackage.COMPONENT_ROLE__MAP && newMap != null)) {
			if (EcoreUtil.isAncestor(this, newMap))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMap != null)
				msgs = ((InternalEObject)newMap).eInverseAdd(this, CoremodelPackage.USE_CASE_MAP__COMPONENT_ROLES, UseCaseMap.class, msgs);
			msgs = basicSetMap(newMap, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.COMPONENT_ROLE__MAP, newMap, newMap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAbstractInfo() {
		return abstractInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstractInfo(String newAbstractInfo) {
		String oldAbstractInfo = abstractInfo;
		abstractInfo = newAbstractInfo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.COMPONENT_ROLE__ABSTRACT_INFO, oldAbstractInfo, abstractInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getComponentType() {
		return componentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentType(int newComponentType) {
		int oldComponentType = componentType;
		componentType = newComponentType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.COMPONENT_ROLE__COMPONENT_TYPE, oldComponentType, componentType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CoremodelPackage.COMPONENT_ROLE__MAP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMap((UseCaseMap)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CoremodelPackage.COMPONENT_ROLE__MAP:
				return basicSetMap(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case CoremodelPackage.COMPONENT_ROLE__MAP:
				return eInternalContainer().eInverseRemove(this, CoremodelPackage.USE_CASE_MAP__COMPONENT_ROLES, UseCaseMap.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CoremodelPackage.COMPONENT_ROLE__NAME:
				return getName();
			case CoremodelPackage.COMPONENT_ROLE__NOTES:
				return getNotes();
			case CoremodelPackage.COMPONENT_ROLE__COMPONENT:
				if (resolve) return getComponent();
				return basicGetComponent();
			case CoremodelPackage.COMPONENT_ROLE__MAP:
				return getMap();
			case CoremodelPackage.COMPONENT_ROLE__ABSTRACT_INFO:
				return getAbstractInfo();
			case CoremodelPackage.COMPONENT_ROLE__COMPONENT_TYPE:
				return new Integer(getComponentType());
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
			case CoremodelPackage.COMPONENT_ROLE__NAME:
				setName((String)newValue);
				return;
			case CoremodelPackage.COMPONENT_ROLE__NOTES:
				getNotes().clear();
				getNotes().addAll((Collection)newValue);
				return;
			case CoremodelPackage.COMPONENT_ROLE__COMPONENT:
				setComponent((ComponentModel)newValue);
				return;
			case CoremodelPackage.COMPONENT_ROLE__MAP:
				setMap((UseCaseMap)newValue);
				return;
			case CoremodelPackage.COMPONENT_ROLE__ABSTRACT_INFO:
				setAbstractInfo((String)newValue);
				return;
			case CoremodelPackage.COMPONENT_ROLE__COMPONENT_TYPE:
				setComponentType(((Integer)newValue).intValue());
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
			case CoremodelPackage.COMPONENT_ROLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CoremodelPackage.COMPONENT_ROLE__NOTES:
				getNotes().clear();
				return;
			case CoremodelPackage.COMPONENT_ROLE__COMPONENT:
				setComponent((ComponentModel)null);
				return;
			case CoremodelPackage.COMPONENT_ROLE__MAP:
				setMap((UseCaseMap)null);
				return;
			case CoremodelPackage.COMPONENT_ROLE__ABSTRACT_INFO:
				setAbstractInfo(ABSTRACT_INFO_EDEFAULT);
				return;
			case CoremodelPackage.COMPONENT_ROLE__COMPONENT_TYPE:
				setComponentType(COMPONENT_TYPE_EDEFAULT);
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
			case CoremodelPackage.COMPONENT_ROLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CoremodelPackage.COMPONENT_ROLE__NOTES:
				return notes != null && !notes.isEmpty();
			case CoremodelPackage.COMPONENT_ROLE__COMPONENT:
				return component != null;
			case CoremodelPackage.COMPONENT_ROLE__MAP:
				return getMap() != null;
			case CoremodelPackage.COMPONENT_ROLE__ABSTRACT_INFO:
				return ABSTRACT_INFO_EDEFAULT == null ? abstractInfo != null : !ABSTRACT_INFO_EDEFAULT.equals(abstractInfo);
			case CoremodelPackage.COMPONENT_ROLE__COMPONENT_TYPE:
				return componentType != COMPONENT_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == NamedElementModel.class) {
			switch (derivedFeatureID) {
				case CoremodelPackage.COMPONENT_ROLE__NAME: return CoremodelPackage.NAMED_ELEMENT_MODEL__NAME;
				default: return -1;
			}
		}
		if (baseClass == NoteElementModel.class) {
			switch (derivedFeatureID) {
				case CoremodelPackage.COMPONENT_ROLE__NOTES: return CoremodelPackage.NOTE_ELEMENT_MODEL__NOTES;
				default: return -1;
			}
		}
		if (baseClass == Adapter.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == NamedElementModel.class) {
			switch (baseFeatureID) {
				case CoremodelPackage.NAMED_ELEMENT_MODEL__NAME: return CoremodelPackage.COMPONENT_ROLE__NAME;
				default: return -1;
			}
		}
		if (baseClass == NoteElementModel.class) {
			switch (baseFeatureID) {
				case CoremodelPackage.NOTE_ELEMENT_MODEL__NOTES: return CoremodelPackage.COMPONENT_ROLE__NOTES;
				default: return -1;
			}
		}
		if (baseClass == Adapter.class) {
			switch (baseFeatureID) {
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
		result.append(" (name: ");
		result.append(name);
		result.append(", abstractInfo: ");
		result.append(abstractInfo);
		result.append(", componentType: ");
		result.append(componentType);
		result.append(')');
		return result.toString();
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.coremodel.ComponentRole#getFullName()
	 */
	public String getFullName() {
		String componentName = null;
		String roleName = null;
		ComponentModel component = getComponent();
		if (component != null) {
			if (component.getName() != null &&
					!component.getName().trim().equals("")) //$NON-NLS-1$
				componentName = component.getName();
		}
		if (this.getName()!=null && !this.getName().trim().equals("")) //$NON-NLS-1$
			roleName = this.getName();
		StringBuffer fullName = new StringBuffer();
		if (roleName != null)
			fullName.append(roleName);
		if (componentName != null) {
			fullName.append(": "); //$NON-NLS-1$
			fullName.append(componentName);
		}
		return fullName.toString();
	}

	
	/**
	 * Adapter implementation
	 */
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void notifyChanged(Notification notification) {
		//forward all notifications
		if (eNotificationRequired())
			eNotify(notification);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#getTarget()
	 */
	public Notifier getTarget() {
		return getComponent();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#setTarget(org.eclipse.emf.common.notify.Notifier)
	 */
	public void setTarget(Notifier newTarget) {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
	 */
	public boolean isAdapterForType(Object type) {
		return ComponentModel.class.isAssignableFrom((Class)type);
	}
	
	public String getID() {
		return EObjectIdGenerator.getGeneratedEMFID(this);
	}
} //ComponentRoleImpl
