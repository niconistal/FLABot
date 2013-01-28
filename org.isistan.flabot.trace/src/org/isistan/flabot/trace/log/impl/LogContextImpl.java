/**
 * <copyright>
 * </copyright>
 *
 * $Id: LogContextImpl.java,v 1.2 2006/02/03 21:03:04 dacostae Exp $
 */
package org.isistan.flabot.trace.log.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.isistan.flabot.trace.log.LogContext;
import org.isistan.flabot.trace.log.LogPackage;
import org.isistan.flabot.trace.log.Tag;
import org.isistan.flabot.trace.log.TraceLog;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.trace.log.impl.LogContextImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.isistan.flabot.trace.log.impl.LogContextImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.isistan.flabot.trace.log.impl.LogContextImpl#getLog <em>Log</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LogContextImpl extends EObjectImpl implements LogContext {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

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
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected EList tags = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LogContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.eINSTANCE.getLogContext();
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
			eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.LOG_CONTEXT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTags() {
		if (tags == null) {
			tags = new EObjectResolvingEList(Tag.class, this, LogPackage.LOG_CONTEXT__TAGS);
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceLog getLog() {
		if (eContainerFeatureID != LogPackage.LOG_CONTEXT__LOG) return null;
		return (TraceLog)eContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLog(TraceLog newLog) {
		if (newLog != eContainer || (eContainerFeatureID != LogPackage.LOG_CONTEXT__LOG && newLog != null)) {
			if (EcoreUtil.isAncestor(this, newLog))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eContainer != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLog != null)
				msgs = ((InternalEObject)newLog).eInverseAdd(this, LogPackage.TRACE_LOG__CONTEXTS, TraceLog.class, msgs);
			msgs = eBasicSetContainer((InternalEObject)newLog, LogPackage.LOG_CONTEXT__LOG, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.LOG_CONTEXT__LOG, newLog, newLog));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case LogPackage.LOG_CONTEXT__LOG:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, LogPackage.LOG_CONTEXT__LOG, msgs);
				default:
					return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
			}
		}
		if (eContainer != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case LogPackage.LOG_CONTEXT__LOG:
					return eBasicSetContainer(null, LogPackage.LOG_CONTEXT__LOG, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case LogPackage.LOG_CONTEXT__LOG:
					return eContainer.eInverseRemove(this, LogPackage.TRACE_LOG__CONTEXTS, TraceLog.class, msgs);
				default:
					return eDynamicBasicRemoveFromContainer(msgs);
			}
		}
		return eContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case LogPackage.LOG_CONTEXT__NAME:
				return getName();
			case LogPackage.LOG_CONTEXT__TAGS:
				return getTags();
			case LogPackage.LOG_CONTEXT__LOG:
				return getLog();
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
			case LogPackage.LOG_CONTEXT__NAME:
				setName((String)newValue);
				return;
			case LogPackage.LOG_CONTEXT__TAGS:
				getTags().clear();
				getTags().addAll((Collection)newValue);
				return;
			case LogPackage.LOG_CONTEXT__LOG:
				setLog((TraceLog)newValue);
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
			case LogPackage.LOG_CONTEXT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case LogPackage.LOG_CONTEXT__TAGS:
				getTags().clear();
				return;
			case LogPackage.LOG_CONTEXT__LOG:
				setLog((TraceLog)null);
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
			case LogPackage.LOG_CONTEXT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case LogPackage.LOG_CONTEXT__TAGS:
				return tags != null && !tags.isEmpty();
			case LogPackage.LOG_CONTEXT__LOG:
				return getLog() != null;
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //LogContextImpl
