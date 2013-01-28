/**
 * <copyright>
 * </copyright>
 *
 * $Id: ResponsibilityImpl.java,v 1.8 2006/03/24 00:33:58 dacostae Exp $
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
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.Responsibility;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Responsibility</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ResponsibilityImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ResponsibilityImpl#getPreconditions <em>Preconditions</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ResponsibilityImpl#getPostconditions <em>Postconditions</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ResponsibilityImpl#getCoreModel <em>Core Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResponsibilityImpl extends BehavioralFeatureModelImpl implements Responsibility {
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
	 * The cached value of the '{@link #getPreconditions() <em>Preconditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreconditions()
	 * @generated
	 * @ordered
	 */
	protected EList preconditions;

	/**
	 * The cached value of the '{@link #getPostconditions() <em>Postconditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostconditions()
	 * @generated
	 * @ordered
	 */
	protected EList postconditions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResponsibilityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.RESPONSIBILITY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.RESPONSIBILITY__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPreconditions() {
		if (preconditions == null) {
			preconditions = new EObjectContainmentEList(Condition.class, this, CoremodelPackage.RESPONSIBILITY__PRECONDITIONS);
		}
		return preconditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPostconditions() {
		if (postconditions == null) {
			postconditions = new EObjectContainmentEList(Condition.class, this, CoremodelPackage.RESPONSIBILITY__POSTCONDITIONS);
		}
		return postconditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreModel getCoreModel() {
		if (eContainerFeatureID() != CoremodelPackage.RESPONSIBILITY__CORE_MODEL) return null;
		return (CoreModel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCoreModel(CoreModel newCoreModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCoreModel, CoremodelPackage.RESPONSIBILITY__CORE_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoreModel(CoreModel newCoreModel) {
		if (newCoreModel != eInternalContainer() || (eContainerFeatureID() != CoremodelPackage.RESPONSIBILITY__CORE_MODEL && newCoreModel != null)) {
			if (EcoreUtil.isAncestor(this, newCoreModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCoreModel != null)
				msgs = ((InternalEObject)newCoreModel).eInverseAdd(this, CoremodelPackage.CORE_MODEL__RESPONSIBILITIES, CoreModel.class, msgs);
			msgs = basicSetCoreModel(newCoreModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.RESPONSIBILITY__CORE_MODEL, newCoreModel, newCoreModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CoremodelPackage.RESPONSIBILITY__CORE_MODEL:
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
			case CoremodelPackage.RESPONSIBILITY__PRECONDITIONS:
				return ((InternalEList)getPreconditions()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.RESPONSIBILITY__POSTCONDITIONS:
				return ((InternalEList)getPostconditions()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.RESPONSIBILITY__CORE_MODEL:
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
			case CoremodelPackage.RESPONSIBILITY__CORE_MODEL:
				return eInternalContainer().eInverseRemove(this, CoremodelPackage.CORE_MODEL__RESPONSIBILITIES, CoreModel.class, msgs);
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
			case CoremodelPackage.RESPONSIBILITY__DESCRIPTION:
				return getDescription();
			case CoremodelPackage.RESPONSIBILITY__PRECONDITIONS:
				return getPreconditions();
			case CoremodelPackage.RESPONSIBILITY__POSTCONDITIONS:
				return getPostconditions();
			case CoremodelPackage.RESPONSIBILITY__CORE_MODEL:
				return getCoreModel();
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
			case CoremodelPackage.RESPONSIBILITY__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CoremodelPackage.RESPONSIBILITY__PRECONDITIONS:
				getPreconditions().clear();
				getPreconditions().addAll((Collection)newValue);
				return;
			case CoremodelPackage.RESPONSIBILITY__POSTCONDITIONS:
				getPostconditions().clear();
				getPostconditions().addAll((Collection)newValue);
				return;
			case CoremodelPackage.RESPONSIBILITY__CORE_MODEL:
				setCoreModel((CoreModel)newValue);
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
			case CoremodelPackage.RESPONSIBILITY__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CoremodelPackage.RESPONSIBILITY__PRECONDITIONS:
				getPreconditions().clear();
				return;
			case CoremodelPackage.RESPONSIBILITY__POSTCONDITIONS:
				getPostconditions().clear();
				return;
			case CoremodelPackage.RESPONSIBILITY__CORE_MODEL:
				setCoreModel((CoreModel)null);
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
			case CoremodelPackage.RESPONSIBILITY__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CoremodelPackage.RESPONSIBILITY__PRECONDITIONS:
				return preconditions != null && !preconditions.isEmpty();
			case CoremodelPackage.RESPONSIBILITY__POSTCONDITIONS:
				return postconditions != null && !postconditions.isEmpty();
			case CoremodelPackage.RESPONSIBILITY__CORE_MODEL:
				return getCoreModel() != null;
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
		result.append(')');
		return result.toString();
	}

} //ResponsibilityImpl
