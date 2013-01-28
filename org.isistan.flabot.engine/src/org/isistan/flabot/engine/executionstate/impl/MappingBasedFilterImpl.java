/**
 * <copyright>
 * </copyright>
 *
 * $Id: MappingBasedFilterImpl.java,v 1.9 2006/04/10 21:55:02 franco Exp $
 */
package org.isistan.flabot.engine.executionstate.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;
import org.isistan.flabot.engine.executionstate.MappingBasedFilter;
import org.isistan.flabot.launcher.filter.filtermodel.LogFilter;
import org.isistan.flabot.mapping.mappingmodel.Mapping;
import org.isistan.flabot.trace.config.ConfigPackage;
import org.isistan.flabot.trace.config.Context;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Based Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.engine.executionstate.impl.MappingBasedFilterImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.isistan.flabot.engine.executionstate.impl.MappingBasedFilterImpl#getMapping <em>Mapping</em>}</li>
 *   <li>{@link org.isistan.flabot.engine.executionstate.impl.MappingBasedFilterImpl#getLogFilter <em>Log Filter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MappingBasedFilterImpl extends EObjectImpl implements MappingBasedFilter {
	/**
	 * The cached value of the '{@link #getMapping() <em>Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapping()
	 * @generated
	 * @ordered
	 */
	protected Mapping mapping = null;

	/**
	 * The cached value of the '{@link #getLogFilter() <em>Log Filter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogFilter()
	 * @generated
	 * @ordered
	 */
	protected LogFilter logFilter = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingBasedFilterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionstatePackage.eINSTANCE.getMappingBasedFilter();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context getContext() {
		if (eContainerFeatureID != ExecutionstatePackage.MAPPING_BASED_FILTER__CONTEXT) return null;
		return (Context)eContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(Context newContext) {
		if (newContext != eContainer || (eContainerFeatureID != ExecutionstatePackage.MAPPING_BASED_FILTER__CONTEXT && newContext != null)) {
			if (EcoreUtil.isAncestor(this, newContext))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eContainer != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContext != null)
				msgs = ((InternalEObject)newContext).eInverseAdd(this, ConfigPackage.CONTEXT__FILTER, Context.class, msgs);
			msgs = eBasicSetContainer((InternalEObject)newContext, ExecutionstatePackage.MAPPING_BASED_FILTER__CONTEXT, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionstatePackage.MAPPING_BASED_FILTER__CONTEXT, newContext, newContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping getMapping() {
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMapping(Mapping newMapping, NotificationChain msgs) {
		Mapping oldMapping = mapping;
		mapping = newMapping;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExecutionstatePackage.MAPPING_BASED_FILTER__MAPPING, oldMapping, newMapping);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapping(Mapping newMapping) {
		if (newMapping != mapping) {
			NotificationChain msgs = null;
			if (mapping != null)
				msgs = ((InternalEObject)mapping).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExecutionstatePackage.MAPPING_BASED_FILTER__MAPPING, null, msgs);
			if (newMapping != null)
				msgs = ((InternalEObject)newMapping).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExecutionstatePackage.MAPPING_BASED_FILTER__MAPPING, null, msgs);
			msgs = basicSetMapping(newMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionstatePackage.MAPPING_BASED_FILTER__MAPPING, newMapping, newMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogFilter getLogFilter() {
		return logFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLogFilter(LogFilter newLogFilter, NotificationChain msgs) {
		LogFilter oldLogFilter = logFilter;
		logFilter = newLogFilter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExecutionstatePackage.MAPPING_BASED_FILTER__LOG_FILTER, oldLogFilter, newLogFilter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogFilter(LogFilter newLogFilter) {
		if (newLogFilter != logFilter) {
			NotificationChain msgs = null;
			if (logFilter != null)
				msgs = ((InternalEObject)logFilter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExecutionstatePackage.MAPPING_BASED_FILTER__LOG_FILTER, null, msgs);
			if (newLogFilter != null)
				msgs = ((InternalEObject)newLogFilter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExecutionstatePackage.MAPPING_BASED_FILTER__LOG_FILTER, null, msgs);
			msgs = basicSetLogFilter(newLogFilter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionstatePackage.MAPPING_BASED_FILTER__LOG_FILTER, newLogFilter, newLogFilter));
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
				case ExecutionstatePackage.MAPPING_BASED_FILTER__CONTEXT:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExecutionstatePackage.MAPPING_BASED_FILTER__CONTEXT, msgs);
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
				case ExecutionstatePackage.MAPPING_BASED_FILTER__CONTEXT:
					return eBasicSetContainer(null, ExecutionstatePackage.MAPPING_BASED_FILTER__CONTEXT, msgs);
				case ExecutionstatePackage.MAPPING_BASED_FILTER__MAPPING:
					return basicSetMapping(null, msgs);
				case ExecutionstatePackage.MAPPING_BASED_FILTER__LOG_FILTER:
					return basicSetLogFilter(null, msgs);
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
				case ExecutionstatePackage.MAPPING_BASED_FILTER__CONTEXT:
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
	@Override
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionstatePackage.MAPPING_BASED_FILTER__CONTEXT:
				return getContext();
			case ExecutionstatePackage.MAPPING_BASED_FILTER__MAPPING:
				return getMapping();
			case ExecutionstatePackage.MAPPING_BASED_FILTER__LOG_FILTER:
				return getLogFilter();
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
			case ExecutionstatePackage.MAPPING_BASED_FILTER__CONTEXT:
				setContext((Context)newValue);
				return;
			case ExecutionstatePackage.MAPPING_BASED_FILTER__MAPPING:
				setMapping((Mapping)newValue);
				return;
			case ExecutionstatePackage.MAPPING_BASED_FILTER__LOG_FILTER:
				setLogFilter((LogFilter)newValue);
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
			case ExecutionstatePackage.MAPPING_BASED_FILTER__CONTEXT:
				setContext((Context)null);
				return;
			case ExecutionstatePackage.MAPPING_BASED_FILTER__MAPPING:
				setMapping((Mapping)null);
				return;
			case ExecutionstatePackage.MAPPING_BASED_FILTER__LOG_FILTER:
				setLogFilter((LogFilter)null);
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
			case ExecutionstatePackage.MAPPING_BASED_FILTER__CONTEXT:
				return getContext() != null;
			case ExecutionstatePackage.MAPPING_BASED_FILTER__MAPPING:
				return mapping != null;
			case ExecutionstatePackage.MAPPING_BASED_FILTER__LOG_FILTER:
				return logFilter != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //MappingBasedFilterImpl
