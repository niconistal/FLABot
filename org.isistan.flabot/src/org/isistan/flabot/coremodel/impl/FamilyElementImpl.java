/**
 * <copyright>
 * </copyright>
 *
 * $Id: FamilyElementImpl.java,v 1.3 2005/11/28 22:21:22 apersson Exp $
 */
package org.isistan.flabot.coremodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.FamilyElement;
import org.isistan.flabot.coremodel.UseCaseMap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Family Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.FamilyElementImpl#getUseCaseMap <em>Use Case Map</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.FamilyElementImpl#getFunctionalComponent <em>Functional Component</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.FamilyElementImpl#getArchitecturalComponent <em>Architectural Component</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FamilyElementImpl extends NamedElementModelImpl implements FamilyElement {
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
	 * The cached value of the '{@link #getFunctionalComponent() <em>Functional Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionalComponent()
	 * @generated
	 * @ordered
	 */
	protected ComponentRole functionalComponent;

	/**
	 * The cached value of the '{@link #getArchitecturalComponent() <em>Architectural Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArchitecturalComponent()
	 * @generated
	 * @ordered
	 */
	protected ComponentRole architecturalComponent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FamilyElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.FAMILY_ELEMENT;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoremodelPackage.FAMILY_ELEMENT__USE_CASE_MAP, oldUseCaseMap, useCaseMap));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.FAMILY_ELEMENT__USE_CASE_MAP, oldUseCaseMap, useCaseMap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentRole getFunctionalComponent() {
		if (functionalComponent != null && functionalComponent.eIsProxy()) {
			InternalEObject oldFunctionalComponent = (InternalEObject)functionalComponent;
			functionalComponent = (ComponentRole)eResolveProxy(oldFunctionalComponent);
			if (functionalComponent != oldFunctionalComponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoremodelPackage.FAMILY_ELEMENT__FUNCTIONAL_COMPONENT, oldFunctionalComponent, functionalComponent));
			}
		}
		return functionalComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentRole basicGetFunctionalComponent() {
		return functionalComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionalComponent(ComponentRole newFunctionalComponent) {
		ComponentRole oldFunctionalComponent = functionalComponent;
		functionalComponent = newFunctionalComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.FAMILY_ELEMENT__FUNCTIONAL_COMPONENT, oldFunctionalComponent, functionalComponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentRole getArchitecturalComponent() {
		if (architecturalComponent != null && architecturalComponent.eIsProxy()) {
			InternalEObject oldArchitecturalComponent = (InternalEObject)architecturalComponent;
			architecturalComponent = (ComponentRole)eResolveProxy(oldArchitecturalComponent);
			if (architecturalComponent != oldArchitecturalComponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoremodelPackage.FAMILY_ELEMENT__ARCHITECTURAL_COMPONENT, oldArchitecturalComponent, architecturalComponent));
			}
		}
		return architecturalComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentRole basicGetArchitecturalComponent() {
		return architecturalComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArchitecturalComponent(ComponentRole newArchitecturalComponent) {
		ComponentRole oldArchitecturalComponent = architecturalComponent;
		architecturalComponent = newArchitecturalComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.FAMILY_ELEMENT__ARCHITECTURAL_COMPONENT, oldArchitecturalComponent, architecturalComponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CoremodelPackage.FAMILY_ELEMENT__USE_CASE_MAP:
				if (resolve) return getUseCaseMap();
				return basicGetUseCaseMap();
			case CoremodelPackage.FAMILY_ELEMENT__FUNCTIONAL_COMPONENT:
				if (resolve) return getFunctionalComponent();
				return basicGetFunctionalComponent();
			case CoremodelPackage.FAMILY_ELEMENT__ARCHITECTURAL_COMPONENT:
				if (resolve) return getArchitecturalComponent();
				return basicGetArchitecturalComponent();
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
			case CoremodelPackage.FAMILY_ELEMENT__USE_CASE_MAP:
				setUseCaseMap((UseCaseMap)newValue);
				return;
			case CoremodelPackage.FAMILY_ELEMENT__FUNCTIONAL_COMPONENT:
				setFunctionalComponent((ComponentRole)newValue);
				return;
			case CoremodelPackage.FAMILY_ELEMENT__ARCHITECTURAL_COMPONENT:
				setArchitecturalComponent((ComponentRole)newValue);
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
			case CoremodelPackage.FAMILY_ELEMENT__USE_CASE_MAP:
				setUseCaseMap((UseCaseMap)null);
				return;
			case CoremodelPackage.FAMILY_ELEMENT__FUNCTIONAL_COMPONENT:
				setFunctionalComponent((ComponentRole)null);
				return;
			case CoremodelPackage.FAMILY_ELEMENT__ARCHITECTURAL_COMPONENT:
				setArchitecturalComponent((ComponentRole)null);
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
			case CoremodelPackage.FAMILY_ELEMENT__USE_CASE_MAP:
				return useCaseMap != null;
			case CoremodelPackage.FAMILY_ELEMENT__FUNCTIONAL_COMPONENT:
				return functionalComponent != null;
			case CoremodelPackage.FAMILY_ELEMENT__ARCHITECTURAL_COMPONENT:
				return architecturalComponent != null;
		}
		return super.eIsSet(featureID);
	}

} //FamilyElementImpl
