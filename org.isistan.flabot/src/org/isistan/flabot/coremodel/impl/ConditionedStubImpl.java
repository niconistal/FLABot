/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.coremodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.isistan.flabot.coremodel.ConditionedStub;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.StubNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditioned Stub</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ConditionedStubImpl#getStub <em>Stub</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ConditionedStubImpl#getResponsibilityNode <em>Responsibility Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionedStubImpl extends NamedElementModelImpl implements ConditionedStub {
	/**
	 * The cached value of the '{@link #getStub() <em>Stub</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStub()
	 * @generated
	 * @ordered
	 */
	protected StubNode stub;

	/**
	 * The cached value of the '{@link #getResponsibilityNode() <em>Responsibility Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponsibilityNode()
	 * @generated
	 * @ordered
	 */
	protected ResponsibilityNode responsibilityNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionedStubImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.CONDITIONED_STUB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StubNode getStub() {
		return stub;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStub(StubNode newStub, NotificationChain msgs) {
		StubNode oldStub = stub;
		stub = newStub;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CoremodelPackage.CONDITIONED_STUB__STUB, oldStub, newStub);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStub(StubNode newStub) {
		if (newStub != stub) {
			NotificationChain msgs = null;
			if (stub != null)
				msgs = ((InternalEObject)stub).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CoremodelPackage.CONDITIONED_STUB__STUB, null, msgs);
			if (newStub != null)
				msgs = ((InternalEObject)newStub).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CoremodelPackage.CONDITIONED_STUB__STUB, null, msgs);
			msgs = basicSetStub(newStub, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.CONDITIONED_STUB__STUB, newStub, newStub));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponsibilityNode getResponsibilityNode() {
		return responsibilityNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResponsibilityNode(ResponsibilityNode newResponsibilityNode, NotificationChain msgs) {
		ResponsibilityNode oldResponsibilityNode = responsibilityNode;
		responsibilityNode = newResponsibilityNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CoremodelPackage.CONDITIONED_STUB__RESPONSIBILITY_NODE, oldResponsibilityNode, newResponsibilityNode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponsibilityNode(ResponsibilityNode newResponsibilityNode) {
		if (newResponsibilityNode != responsibilityNode) {
			NotificationChain msgs = null;
			if (responsibilityNode != null)
				msgs = ((InternalEObject)responsibilityNode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CoremodelPackage.CONDITIONED_STUB__RESPONSIBILITY_NODE, null, msgs);
			if (newResponsibilityNode != null)
				msgs = ((InternalEObject)newResponsibilityNode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CoremodelPackage.CONDITIONED_STUB__RESPONSIBILITY_NODE, null, msgs);
			msgs = basicSetResponsibilityNode(newResponsibilityNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.CONDITIONED_STUB__RESPONSIBILITY_NODE, newResponsibilityNode, newResponsibilityNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CoremodelPackage.CONDITIONED_STUB__STUB:
				return basicSetStub(null, msgs);
			case CoremodelPackage.CONDITIONED_STUB__RESPONSIBILITY_NODE:
				return basicSetResponsibilityNode(null, msgs);
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
			case CoremodelPackage.CONDITIONED_STUB__STUB:
				return getStub();
			case CoremodelPackage.CONDITIONED_STUB__RESPONSIBILITY_NODE:
				return getResponsibilityNode();
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
			case CoremodelPackage.CONDITIONED_STUB__STUB:
				setStub((StubNode)newValue);
				return;
			case CoremodelPackage.CONDITIONED_STUB__RESPONSIBILITY_NODE:
				setResponsibilityNode((ResponsibilityNode)newValue);
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
			case CoremodelPackage.CONDITIONED_STUB__STUB:
				setStub((StubNode)null);
				return;
			case CoremodelPackage.CONDITIONED_STUB__RESPONSIBILITY_NODE:
				setResponsibilityNode((ResponsibilityNode)null);
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
			case CoremodelPackage.CONDITIONED_STUB__STUB:
				return stub != null;
			case CoremodelPackage.CONDITIONED_STUB__RESPONSIBILITY_NODE:
				return responsibilityNode != null;
		}
		return super.eIsSet(featureID);
	}

} //ConditionedStubImpl
