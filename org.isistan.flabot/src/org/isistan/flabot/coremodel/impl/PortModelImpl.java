/**
 * <copyright>
 * </copyright>
 *
 * $Id: PortModelImpl.java,v 1.7 2005/11/28 22:21:22 apersson Exp $
 */
package org.isistan.flabot.coremodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.InterfaceModel;
import org.isistan.flabot.coremodel.PortModel;
import org.isistan.flabot.coremodel.Property;
import org.isistan.flabot.coremodel.PropertyElementModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.PortModelImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.PortModelImpl#getProvideds <em>Provideds</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.PortModelImpl#getRequireds <em>Requireds</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.PortModelImpl#getComponent <em>Component</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PortModelImpl extends NamedElementModelImpl implements PortModel {
	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList properties;

	/**
	 * The cached value of the '{@link #getProvideds() <em>Provideds</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvideds()
	 * @generated
	 * @ordered
	 */
	protected EList provideds;

	/**
	 * The cached value of the '{@link #getRequireds() <em>Requireds</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequireds()
	 * @generated
	 * @ordered
	 */
	protected EList requireds;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.PORT_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList(Property.class, this, CoremodelPackage.PORT_MODEL__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getProvideds() {
		if (provideds == null) {
			provideds = new EObjectContainmentEList(InterfaceModel.class, this, CoremodelPackage.PORT_MODEL__PROVIDEDS);
		}
		return provideds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getRequireds() {
		if (requireds == null) {
			requireds = new EObjectContainmentEList(InterfaceModel.class, this, CoremodelPackage.PORT_MODEL__REQUIREDS);
		}
		return requireds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentModel getComponent() {
		if (eContainerFeatureID() != CoremodelPackage.PORT_MODEL__COMPONENT) return null;
		return (ComponentModel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponent(ComponentModel newComponent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newComponent, CoremodelPackage.PORT_MODEL__COMPONENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponent(ComponentModel newComponent) {
		if (newComponent != eInternalContainer() || (eContainerFeatureID() != CoremodelPackage.PORT_MODEL__COMPONENT && newComponent != null)) {
			if (EcoreUtil.isAncestor(this, newComponent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newComponent != null)
				msgs = ((InternalEObject)newComponent).eInverseAdd(this, CoremodelPackage.COMPONENT_MODEL__OWNED_PORTS, ComponentModel.class, msgs);
			msgs = basicSetComponent(newComponent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.PORT_MODEL__COMPONENT, newComponent, newComponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CoremodelPackage.PORT_MODEL__COMPONENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetComponent((ComponentModel)otherEnd, msgs);
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
			case CoremodelPackage.PORT_MODEL__PROPERTIES:
				return ((InternalEList)getProperties()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.PORT_MODEL__PROVIDEDS:
				return ((InternalEList)getProvideds()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.PORT_MODEL__REQUIREDS:
				return ((InternalEList)getRequireds()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.PORT_MODEL__COMPONENT:
				return basicSetComponent(null, msgs);
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
			case CoremodelPackage.PORT_MODEL__COMPONENT:
				return eInternalContainer().eInverseRemove(this, CoremodelPackage.COMPONENT_MODEL__OWNED_PORTS, ComponentModel.class, msgs);
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
			case CoremodelPackage.PORT_MODEL__PROPERTIES:
				return getProperties();
			case CoremodelPackage.PORT_MODEL__PROVIDEDS:
				return getProvideds();
			case CoremodelPackage.PORT_MODEL__REQUIREDS:
				return getRequireds();
			case CoremodelPackage.PORT_MODEL__COMPONENT:
				return getComponent();
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
			case CoremodelPackage.PORT_MODEL__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection)newValue);
				return;
			case CoremodelPackage.PORT_MODEL__PROVIDEDS:
				getProvideds().clear();
				getProvideds().addAll((Collection)newValue);
				return;
			case CoremodelPackage.PORT_MODEL__REQUIREDS:
				getRequireds().clear();
				getRequireds().addAll((Collection)newValue);
				return;
			case CoremodelPackage.PORT_MODEL__COMPONENT:
				setComponent((ComponentModel)newValue);
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
			case CoremodelPackage.PORT_MODEL__PROPERTIES:
				getProperties().clear();
				return;
			case CoremodelPackage.PORT_MODEL__PROVIDEDS:
				getProvideds().clear();
				return;
			case CoremodelPackage.PORT_MODEL__REQUIREDS:
				getRequireds().clear();
				return;
			case CoremodelPackage.PORT_MODEL__COMPONENT:
				setComponent((ComponentModel)null);
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
			case CoremodelPackage.PORT_MODEL__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case CoremodelPackage.PORT_MODEL__PROVIDEDS:
				return provideds != null && !provideds.isEmpty();
			case CoremodelPackage.PORT_MODEL__REQUIREDS:
				return requireds != null && !requireds.isEmpty();
			case CoremodelPackage.PORT_MODEL__COMPONENT:
				return getComponent() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == PropertyElementModel.class) {
			switch (derivedFeatureID) {
				case CoremodelPackage.PORT_MODEL__PROPERTIES: return CoremodelPackage.PROPERTY_ELEMENT_MODEL__PROPERTIES;
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
		if (baseClass == PropertyElementModel.class) {
			switch (baseFeatureID) {
				case CoremodelPackage.PROPERTY_ELEMENT_MODEL__PROPERTIES: return CoremodelPackage.PORT_MODEL__PROPERTIES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //PortModelImpl
