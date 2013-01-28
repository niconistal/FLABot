/**
 * <copyright>
 * </copyright>
 *
 * $Id: TraceLogImpl.java,v 1.2 2006/02/03 21:03:04 dacostae Exp $
 */
package org.isistan.flabot.trace.log.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.trace.log.LogContext;
import org.isistan.flabot.trace.log.LogPackage;
import org.isistan.flabot.trace.log.Tag;
import org.isistan.flabot.trace.log.TraceLog;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Log</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.trace.log.impl.TraceLogImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.isistan.flabot.trace.log.impl.TraceLogImpl#getContexts <em>Contexts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceLogImpl extends EObjectImpl implements TraceLog {
	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected EList tags = null;

	/**
	 * The cached value of the '{@link #getContexts() <em>Contexts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContexts()
	 * @generated
	 * @ordered
	 */
	protected EList contexts = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceLogImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.eINSTANCE.getTraceLog();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTags() {
		if (tags == null) {
			tags = new EObjectContainmentEList(Tag.class, this, LogPackage.TRACE_LOG__TAGS);
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getContexts() {
		if (contexts == null) {
			contexts = new EObjectContainmentWithInverseEList(LogContext.class, this, LogPackage.TRACE_LOG__CONTEXTS, LogPackage.LOG_CONTEXT__LOG);
		}
		return contexts;
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
				case LogPackage.TRACE_LOG__CONTEXTS:
					return ((InternalEList)getContexts()).basicAdd(otherEnd, msgs);
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
				case LogPackage.TRACE_LOG__TAGS:
					return ((InternalEList)getTags()).basicRemove(otherEnd, msgs);
				case LogPackage.TRACE_LOG__CONTEXTS:
					return ((InternalEList)getContexts()).basicRemove(otherEnd, msgs);
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
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case LogPackage.TRACE_LOG__TAGS:
				return getTags();
			case LogPackage.TRACE_LOG__CONTEXTS:
				return getContexts();
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
			case LogPackage.TRACE_LOG__TAGS:
				getTags().clear();
				getTags().addAll((Collection)newValue);
				return;
			case LogPackage.TRACE_LOG__CONTEXTS:
				getContexts().clear();
				getContexts().addAll((Collection)newValue);
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
			case LogPackage.TRACE_LOG__TAGS:
				getTags().clear();
				return;
			case LogPackage.TRACE_LOG__CONTEXTS:
				getContexts().clear();
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
			case LogPackage.TRACE_LOG__TAGS:
				return tags != null && !tags.isEmpty();
			case LogPackage.TRACE_LOG__CONTEXTS:
				return contexts != null && !contexts.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

} //TraceLogImpl
