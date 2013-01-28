/**
 * <copyright>
 * </copyright>
 *
 * $Id: UseCaseMapImpl.java,v 1.10 2006/01/25 00:39:38 dacostae Exp $
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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.UseCaseMap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Use Case Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.UseCaseMapImpl#getPaths <em>Paths</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.UseCaseMapImpl#getComponentRoles <em>Component Roles</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.UseCaseMapImpl#getCoreModel <em>Core Model</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.UseCaseMapImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.UseCaseMapImpl#getLevelInfo <em>Level Info</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UseCaseMapImpl extends NamedElementModelImpl implements UseCaseMap {
	/**
	 * The cached value of the '{@link #getPaths() <em>Paths</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaths()
	 * @generated
	 * @ordered
	 */
	protected EList paths;

	/**
	 * The cached value of the '{@link #getComponentRoles() <em>Component Roles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentRoles()
	 * @generated
	 * @ordered
	 */
	protected EList componentRoles;

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
	 * The default value of the '{@link #getLevelInfo() <em>Level Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevelInfo()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String LEVEL_INFO_EDEFAULT = UseCaseMap.functionalLevel;

	/**
	 * The cached value of the '{@link #getLevelInfo() <em>Level Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevelInfo()
	 * @generated
	 * @ordered
	 */
	protected String levelInfo = LEVEL_INFO_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UseCaseMapImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.USE_CASE_MAP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPaths() {
		if (paths == null) {
			paths = new EObjectContainmentEList(Path.class, this, CoremodelPackage.USE_CASE_MAP__PATHS);
		}
		return paths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getComponentRoles() {
		if (componentRoles == null) {
			componentRoles = new EObjectContainmentWithInverseEList(ComponentRole.class, this, CoremodelPackage.USE_CASE_MAP__COMPONENT_ROLES, CoremodelPackage.COMPONENT_ROLE__MAP);
		}
		return componentRoles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreModel getCoreModel() {
		if (eContainerFeatureID() != CoremodelPackage.USE_CASE_MAP__CORE_MODEL) return null;
		return (CoreModel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCoreModel(CoreModel newCoreModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCoreModel, CoremodelPackage.USE_CASE_MAP__CORE_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoreModel(CoreModel newCoreModel) {
		if (newCoreModel != eInternalContainer() || (eContainerFeatureID() != CoremodelPackage.USE_CASE_MAP__CORE_MODEL && newCoreModel != null)) {
			if (EcoreUtil.isAncestor(this, newCoreModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCoreModel != null)
				msgs = ((InternalEObject)newCoreModel).eInverseAdd(this, CoremodelPackage.CORE_MODEL__USE_CASE_MAPS, CoreModel.class, msgs);
			msgs = basicSetCoreModel(newCoreModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.USE_CASE_MAP__CORE_MODEL, newCoreModel, newCoreModel));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.USE_CASE_MAP__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLevelInfo() {
		return levelInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLevelInfo(String newLevelInfo) {
		String oldLevelInfo = levelInfo;
		levelInfo = newLevelInfo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.USE_CASE_MAP__LEVEL_INFO, oldLevelInfo, levelInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CoremodelPackage.USE_CASE_MAP__COMPONENT_ROLES:
				return ((InternalEList)getComponentRoles()).basicAdd(otherEnd, msgs);
			case CoremodelPackage.USE_CASE_MAP__CORE_MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCoreModel((CoreModel)otherEnd, msgs);
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
			case CoremodelPackage.USE_CASE_MAP__PATHS:
				return ((InternalEList)getPaths()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.USE_CASE_MAP__COMPONENT_ROLES:
				return ((InternalEList)getComponentRoles()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.USE_CASE_MAP__CORE_MODEL:
				return basicSetCoreModel(null, msgs);
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
			case CoremodelPackage.USE_CASE_MAP__CORE_MODEL:
				return eInternalContainer().eInverseRemove(this, CoremodelPackage.CORE_MODEL__USE_CASE_MAPS, CoreModel.class, msgs);
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
			case CoremodelPackage.USE_CASE_MAP__PATHS:
				return getPaths();
			case CoremodelPackage.USE_CASE_MAP__COMPONENT_ROLES:
				return getComponentRoles();
			case CoremodelPackage.USE_CASE_MAP__CORE_MODEL:
				return getCoreModel();
			case CoremodelPackage.USE_CASE_MAP__DESCRIPTION:
				return getDescription();
			case CoremodelPackage.USE_CASE_MAP__LEVEL_INFO:
				return getLevelInfo();
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
			case CoremodelPackage.USE_CASE_MAP__PATHS:
				getPaths().clear();
				getPaths().addAll((Collection)newValue);
				return;
			case CoremodelPackage.USE_CASE_MAP__COMPONENT_ROLES:
				getComponentRoles().clear();
				getComponentRoles().addAll((Collection)newValue);
				return;
			case CoremodelPackage.USE_CASE_MAP__CORE_MODEL:
				setCoreModel((CoreModel)newValue);
				return;
			case CoremodelPackage.USE_CASE_MAP__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CoremodelPackage.USE_CASE_MAP__LEVEL_INFO:
				setLevelInfo((String)newValue);
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
			case CoremodelPackage.USE_CASE_MAP__PATHS:
				getPaths().clear();
				return;
			case CoremodelPackage.USE_CASE_MAP__COMPONENT_ROLES:
				getComponentRoles().clear();
				return;
			case CoremodelPackage.USE_CASE_MAP__CORE_MODEL:
				setCoreModel((CoreModel)null);
				return;
			case CoremodelPackage.USE_CASE_MAP__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CoremodelPackage.USE_CASE_MAP__LEVEL_INFO:
				setLevelInfo(LEVEL_INFO_EDEFAULT);
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
			case CoremodelPackage.USE_CASE_MAP__PATHS:
				return paths != null && !paths.isEmpty();
			case CoremodelPackage.USE_CASE_MAP__COMPONENT_ROLES:
				return componentRoles != null && !componentRoles.isEmpty();
			case CoremodelPackage.USE_CASE_MAP__CORE_MODEL:
				return getCoreModel() != null;
			case CoremodelPackage.USE_CASE_MAP__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CoremodelPackage.USE_CASE_MAP__LEVEL_INFO:
				return LEVEL_INFO_EDEFAULT == null ? levelInfo != null : !LEVEL_INFO_EDEFAULT.equals(levelInfo);
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
		result.append(" (description: ");
		result.append(description);
		result.append(", levelInfo: ");
		result.append(levelInfo);
		result.append(')');
		return result.toString();
	}

} //UseCaseMapImpl
