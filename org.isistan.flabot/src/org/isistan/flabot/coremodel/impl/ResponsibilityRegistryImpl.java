/**
 * <copyright>
 * </copyright>
 *
 * $Id: ResponsibilityRegistryImpl.java,v 1.6 2006/02/01 00:26:58 mblech Exp $
 */
package org.isistan.flabot.coremodel.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.Registrable;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityRegistry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Responsibility Registry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ResponsibilityRegistryImpl#getResponsibilityBasedRegistry <em>Responsibility Based Registry</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ResponsibilityRegistryImpl#getComponentBasedRegistry <em>Component Based Registry</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ResponsibilityRegistryImpl#getRoleBasedRegistry <em>Role Based Registry</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResponsibilityRegistryImpl extends EObjectImpl implements ResponsibilityRegistry {
	/**
	 * The cached value of the '{@link #getResponsibilityBasedRegistry() <em>Responsibility Based Registry</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponsibilityBasedRegistry()
	 * @generated
	 * @ordered
	 */
	protected EMap responsibilityBasedRegistry;

	/**
	 * The cached value of the '{@link #getComponentBasedRegistry() <em>Component Based Registry</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentBasedRegistry()
	 * @generated
	 * @ordered
	 */
	protected EMap componentBasedRegistry;

	/**
	 * The cached value of the '{@link #getRoleBasedRegistry() <em>Role Based Registry</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleBasedRegistry()
	 * @generated
	 * @ordered
	 */
	protected EMap roleBasedRegistry;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResponsibilityRegistryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.RESPONSIBILITY_REGISTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getResponsibilityBasedRegistry() {
		if (responsibilityBasedRegistry == null) {
			responsibilityBasedRegistry = new EcoreEMap(CoremodelPackage.Literals.RESPONSIBILITY_TO_REGISTRABLE_MAP_ENTRY, ResponsibilityToRegistrableMapEntryImpl.class, this, CoremodelPackage.RESPONSIBILITY_REGISTRY__RESPONSIBILITY_BASED_REGISTRY);
		}
		return responsibilityBasedRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getComponentBasedRegistry() {
		if (componentBasedRegistry == null) {
			componentBasedRegistry = new EcoreEMap(CoremodelPackage.Literals.COMPONENT_TO_MAP_MAP_ENTRY, ComponentToMapMapEntryImpl.class, this, CoremodelPackage.RESPONSIBILITY_REGISTRY__COMPONENT_BASED_REGISTRY);
		}
		return componentBasedRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getRoleBasedRegistry() {
		if (roleBasedRegistry == null) {
			roleBasedRegistry = new EcoreEMap(CoremodelPackage.Literals.ROLE_TO_MAP_MAP_ENTRY, RoleToMapMapEntryImpl.class, this, CoremodelPackage.RESPONSIBILITY_REGISTRY__ROLE_BASED_REGISTRY);
		}
		return roleBasedRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CoremodelPackage.RESPONSIBILITY_REGISTRY__RESPONSIBILITY_BASED_REGISTRY:
				return ((InternalEList)getResponsibilityBasedRegistry()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.RESPONSIBILITY_REGISTRY__COMPONENT_BASED_REGISTRY:
				return ((InternalEList)getComponentBasedRegistry()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.RESPONSIBILITY_REGISTRY__ROLE_BASED_REGISTRY:
				return ((InternalEList)getRoleBasedRegistry()).basicRemove(otherEnd, msgs);
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
			case CoremodelPackage.RESPONSIBILITY_REGISTRY__RESPONSIBILITY_BASED_REGISTRY:
				if (coreType) return getResponsibilityBasedRegistry();
				else return getResponsibilityBasedRegistry().map();
			case CoremodelPackage.RESPONSIBILITY_REGISTRY__COMPONENT_BASED_REGISTRY:
				if (coreType) return getComponentBasedRegistry();
				else return getComponentBasedRegistry().map();
			case CoremodelPackage.RESPONSIBILITY_REGISTRY__ROLE_BASED_REGISTRY:
				if (coreType) return getRoleBasedRegistry();
				else return getRoleBasedRegistry().map();
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
			case CoremodelPackage.RESPONSIBILITY_REGISTRY__RESPONSIBILITY_BASED_REGISTRY:
				((EStructuralFeature.Setting)getResponsibilityBasedRegistry()).set(newValue);
				return;
			case CoremodelPackage.RESPONSIBILITY_REGISTRY__COMPONENT_BASED_REGISTRY:
				((EStructuralFeature.Setting)getComponentBasedRegistry()).set(newValue);
				return;
			case CoremodelPackage.RESPONSIBILITY_REGISTRY__ROLE_BASED_REGISTRY:
				((EStructuralFeature.Setting)getRoleBasedRegistry()).set(newValue);
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
			case CoremodelPackage.RESPONSIBILITY_REGISTRY__RESPONSIBILITY_BASED_REGISTRY:
				getResponsibilityBasedRegistry().clear();
				return;
			case CoremodelPackage.RESPONSIBILITY_REGISTRY__COMPONENT_BASED_REGISTRY:
				getComponentBasedRegistry().clear();
				return;
			case CoremodelPackage.RESPONSIBILITY_REGISTRY__ROLE_BASED_REGISTRY:
				getRoleBasedRegistry().clear();
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
			case CoremodelPackage.RESPONSIBILITY_REGISTRY__RESPONSIBILITY_BASED_REGISTRY:
				return responsibilityBasedRegistry != null && !responsibilityBasedRegistry.isEmpty();
			case CoremodelPackage.RESPONSIBILITY_REGISTRY__COMPONENT_BASED_REGISTRY:
				return componentBasedRegistry != null && !componentBasedRegistry.isEmpty();
			case CoremodelPackage.RESPONSIBILITY_REGISTRY__ROLE_BASED_REGISTRY:
				return roleBasedRegistry != null && !roleBasedRegistry.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.coremodel.ResponsibilityRegistry#register(org.isistan.flabot.coremodel.Responsibility, org.isistan.flabot.coremodel.ComponentModel, org.isistan.flabot.coremodel.ComponentRole, org.isistan.flabot.coremodel.Registrable)
	 */
	public Registrable register(Responsibility responsibility, ComponentModel component, ComponentRole role, Registrable registrable) {
		if (responsibility == null)
			throw new IllegalArgumentException("can't register anything with responsibility=null"); //$NON-NLS-1$
		EMap responsibilityBasedRegistry = null;
		if (component != null && role != null) {
			// use a component-role-responsibility specific registry
			EMap componentBasedRegistry = (EMap) getRoleBasedRegistry().get(role);
			if (componentBasedRegistry == null) {
				componentBasedRegistry = new BasicEMap();
				getRoleBasedRegistry().put(role, componentBasedRegistry);
			}
			responsibilityBasedRegistry = (EMap) componentBasedRegistry.get(component);
			if (responsibilityBasedRegistry == null) {
				responsibilityBasedRegistry = new BasicEMap();
				componentBasedRegistry.put(component, responsibilityBasedRegistry);
			}
		}
		else if (component != null) {
			// use a component-responsibility specific registry
			responsibilityBasedRegistry = (EMap) getComponentBasedRegistry().get(component);
			if (responsibilityBasedRegistry == null) {
				responsibilityBasedRegistry = new BasicEMap();
				getComponentBasedRegistry().put(component, responsibilityBasedRegistry);
			}
		}
		else {
			// use the general responsibility based registry
			responsibilityBasedRegistry = getResponsibilityBasedRegistry();
		}
		Registrable oldRegistrable = (Registrable)
			responsibilityBasedRegistry.get(responsibility);
		if (oldRegistrable != null)
			oldRegistrable.unregistered(this, responsibility, component, role);
		if (registrable != null) {
			responsibilityBasedRegistry.put(responsibility, registrable);
			registrable.registered(this, responsibility, component, role);
		}
		else {
			responsibilityBasedRegistry.removeKey(responsibility);
		}
		return oldRegistrable;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.coremodel.ResponsibilityRegistry#get(org.isistan.flabot.coremodel.Responsibility, org.isistan.flabot.coremodel.ComponentModel, org.isistan.flabot.coremodel.ComponentRole)
	 */
	public Registrable get(Responsibility responsibility, ComponentModel component, ComponentRole role) {
		if (responsibility == null)
			throw new IllegalArgumentException("can't get a registered entry for a responsibility=null"); //$NON-NLS-1$

		EMap responsibilityBasedRegistry = null;
		if (component != null && role != null) {
			EMap componentBasedRegistry = (EMap) getRoleBasedRegistry().get(role);
			if(componentBasedRegistry==null) {
				return null;
			}
			responsibilityBasedRegistry = (EMap) componentBasedRegistry.get(component);
		}
		else if (component != null) {
			responsibilityBasedRegistry = (EMap)
				getComponentBasedRegistry().get(component);
		}
		else {
			responsibilityBasedRegistry = getResponsibilityBasedRegistry();
		}
		if (responsibilityBasedRegistry != null) {
			return (Registrable) responsibilityBasedRegistry.get(responsibility);
		} else {
			return null;
		}
	}

	public List getAllRegistrables() {
		List registrables = new LinkedList();
		// collect all responsibility-component-role registrables
		for (Iterator iter = getRoleBasedRegistry().values().iterator(); iter.hasNext();) {
			EMap componentBasedRegistry = (EMap) iter.next();
			for (Iterator iterator = componentBasedRegistry.values().iterator(); iterator
					.hasNext();) {
				EMap responsibilityBasedRegistry = (EMap) iterator.next();
				for (Iterator iterator2 = responsibilityBasedRegistry.values().iterator(); iterator2
						.hasNext();) {
					Registrable registrable = (Registrable) iterator2.next();
					registrables.add(registrable);
				}
			}
		}
		// collect all responsibility-component registrables
		EMap componentBasedRegistry = (EMap) getComponentBasedRegistry();
		for (Iterator iterator = componentBasedRegistry.values().iterator(); iterator
				.hasNext();) {
			EMap responsibilityBasedRegistry = (EMap) iterator.next();
			for (Iterator iterator2 = responsibilityBasedRegistry.values().iterator(); iterator2
					.hasNext();) {
				Registrable registrable = (Registrable) iterator2.next();
				registrables.add(registrable);
			}
		}
		// collect all responsibility registrables
		EMap responsibilityBasedRegistry = (EMap) getResponsibilityBasedRegistry();
		for (Iterator iterator2 = responsibilityBasedRegistry.values().iterator(); iterator2
				.hasNext();) {
			Registrable registrable = (Registrable) iterator2.next();
			registrables.add(registrable);
		}
		return registrables;
	}

} //ResponsibilityRegistryImpl
