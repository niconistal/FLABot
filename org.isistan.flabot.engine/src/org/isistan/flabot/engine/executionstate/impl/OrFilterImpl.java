/**
 * <copyright>
 * </copyright>
 *
 * $Id: OrFilterImpl.java,v 1.1 2006/07/04 12:42:19 mblech Exp $
 */
package org.isistan.flabot.engine.executionstate.impl;

import java.util.Collection;
import java.util.List;

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

import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;
import org.isistan.flabot.engine.executionstate.OrFilter;
import org.isistan.flabot.gauge.Gauge;
import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JPackage;

import org.isistan.flabot.trace.config.ConfigPackage;
import org.isistan.flabot.trace.config.Context;
import org.isistan.flabot.trace.config.Filter;
import org.isistan.flabot.util.TriState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Or Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.engine.executionstate.impl.OrFilterImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.isistan.flabot.engine.executionstate.impl.OrFilterImpl#getCombinedFilters <em>Combined Filters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrFilterImpl extends EObjectImpl implements OrFilter {
	/**
	 * The cached value of the '{@link #getCombinedFilters() <em>Combined Filters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCombinedFilters()
	 * @generated
	 * @ordered
	 */
	protected EList combinedFilters = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrFilterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExecutionstatePackage.eINSTANCE.getOrFilter();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context getContext() {
		if (eContainerFeatureID != ExecutionstatePackage.OR_FILTER__CONTEXT) return null;
		return (Context)eContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(Context newContext) {
		if (newContext != eContainer || (eContainerFeatureID != ExecutionstatePackage.OR_FILTER__CONTEXT && newContext != null)) {
			if (EcoreUtil.isAncestor(this, newContext))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eContainer != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContext != null)
				msgs = ((InternalEObject)newContext).eInverseAdd(this, ConfigPackage.CONTEXT__FILTER, Context.class, msgs);
			msgs = eBasicSetContainer((InternalEObject)newContext, ExecutionstatePackage.OR_FILTER__CONTEXT, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionstatePackage.OR_FILTER__CONTEXT, newContext, newContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCombinedFilters() {
		if (combinedFilters == null) {
			combinedFilters = new EObjectResolvingEList(Filter.class, this, ExecutionstatePackage.OR_FILTER__COMBINED_FILTERS);
		}
		return combinedFilters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ExecutionstatePackage.OR_FILTER__CONTEXT:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExecutionstatePackage.OR_FILTER__CONTEXT, msgs);
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ExecutionstatePackage.OR_FILTER__CONTEXT:
					return eBasicSetContainer(null, ExecutionstatePackage.OR_FILTER__CONTEXT, msgs);
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
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case ExecutionstatePackage.OR_FILTER__CONTEXT:
					return eContainer.eInverseRemove(this, ConfigPackage.CONTEXT__FILTER, Context.class, msgs);
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
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionstatePackage.OR_FILTER__CONTEXT:
				return getContext();
			case ExecutionstatePackage.OR_FILTER__COMBINED_FILTERS:
				return getCombinedFilters();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionstatePackage.OR_FILTER__CONTEXT:
				setContext((Context)newValue);
				return;
			case ExecutionstatePackage.OR_FILTER__COMBINED_FILTERS:
				getCombinedFilters().clear();
				getCombinedFilters().addAll((Collection)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionstatePackage.OR_FILTER__CONTEXT:
				setContext((Context)null);
				return;
			case ExecutionstatePackage.OR_FILTER__COMBINED_FILTERS:
				getCombinedFilters().clear();
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionstatePackage.OR_FILTER__CONTEXT:
				return getContext() != null;
			case ExecutionstatePackage.OR_FILTER__COMBINED_FILTERS:
				return combinedFilters != null && !combinedFilters.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

	public boolean passes(Gauge gauge) {
		for (Filter filter: (List<Filter>)getCombinedFilters()) {
			if (filter.passes(gauge))
				return true;
		}
		return false;
	}

	public boolean passes(JBehavior jBehavior) {
		for (Filter filter: (List<Filter>)getCombinedFilters()) {
			if (filter.passes(jBehavior))
				return true;
		}
		return false;
	}

	public TriState passes(JClass jClass) {
		boolean someUndefined = false;
		for (Filter filter: (List<Filter>)getCombinedFilters()) {
			TriState passes = filter.passes(jClass);
			if (passes == TriState.TRUE)
				return TriState.TRUE;
			else if (passes == TriState.UNDEFINED)
				someUndefined = true;
		}
		if (someUndefined)
			return TriState.UNDEFINED;
		else
			return TriState.FALSE;
	}

	public TriState passes(JPackage jPackage) {
		boolean someUndefined = false;
		for (Filter filter: (List<Filter>)getCombinedFilters()) {
			TriState passes = filter.passes(jPackage);
			if (passes == TriState.TRUE)
				return TriState.TRUE;
			else if (passes == TriState.UNDEFINED)
				someUndefined = true;
		}
		if (someUndefined)
			return TriState.UNDEFINED;
		else
			return TriState.FALSE;
	}

} //OrFilterImpl
