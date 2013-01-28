/**
 * <copyright>
 * </copyright>
 *
 * $Id: ContextImpl.java,v 1.2 2006/02/03 21:03:04 dacostae Exp $
 */
package org.isistan.flabot.trace.config.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.trace.config.ConfigPackage;
import org.isistan.flabot.trace.config.Context;
import org.isistan.flabot.trace.config.Filter;
import org.isistan.flabot.trace.config.TraceConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.trace.config.impl.ContextImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.isistan.flabot.trace.config.impl.ContextImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.isistan.flabot.trace.config.impl.ContextImpl#getFilter <em>Filter</em>}</li>
 *   <li>{@link org.isistan.flabot.trace.config.impl.ContextImpl#getTraceConfiguration <em>Trace Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContextImpl extends EObjectImpl implements Context {
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
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EMap parameters = null;

	/**
	 * The cached value of the '{@link #getFilter() <em>Filter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilter()
	 * @generated
	 * @ordered
	 */
	protected Filter filter = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.eINSTANCE.getContext();
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.CONTEXT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getParameters() {
		if (parameters == null) {
			parameters = new EcoreEMap(EcorePackage.eINSTANCE.getEStringToStringMapEntry(), EStringToStringMapEntryImpl.class, this, ConfigPackage.CONTEXT__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Filter getFilter() {
		return filter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFilter(Filter newFilter, NotificationChain msgs) {
		Filter oldFilter = filter;
		filter = newFilter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigPackage.CONTEXT__FILTER, oldFilter, newFilter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilter(Filter newFilter) {
		if (newFilter != filter) {
			NotificationChain msgs = null;
			if (filter != null)
				msgs = ((InternalEObject)filter).eInverseRemove(this, ConfigPackage.FILTER__CONTEXT, Filter.class, msgs);
			if (newFilter != null)
				msgs = ((InternalEObject)newFilter).eInverseAdd(this, ConfigPackage.FILTER__CONTEXT, Filter.class, msgs);
			msgs = basicSetFilter(newFilter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.CONTEXT__FILTER, newFilter, newFilter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceConfiguration getTraceConfiguration() {
		if (eContainerFeatureID != ConfigPackage.CONTEXT__TRACE_CONFIGURATION) return null;
		return (TraceConfiguration)eContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraceConfiguration(TraceConfiguration newTraceConfiguration) {
		if (newTraceConfiguration != eContainer || (eContainerFeatureID != ConfigPackage.CONTEXT__TRACE_CONFIGURATION && newTraceConfiguration != null)) {
			if (EcoreUtil.isAncestor(this, newTraceConfiguration))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eContainer != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTraceConfiguration != null)
				msgs = ((InternalEObject)newTraceConfiguration).eInverseAdd(this, ConfigPackage.TRACE_CONFIGURATION__CONTEXTS, TraceConfiguration.class, msgs);
			msgs = eBasicSetContainer((InternalEObject)newTraceConfiguration, ConfigPackage.CONTEXT__TRACE_CONFIGURATION, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.CONTEXT__TRACE_CONFIGURATION, newTraceConfiguration, newTraceConfiguration));
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
				case ConfigPackage.CONTEXT__FILTER:
					if (filter != null)
						msgs = ((InternalEObject)filter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.CONTEXT__FILTER, null, msgs);
					return basicSetFilter((Filter)otherEnd, msgs);
				case ConfigPackage.CONTEXT__TRACE_CONFIGURATION:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ConfigPackage.CONTEXT__TRACE_CONFIGURATION, msgs);
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
				case ConfigPackage.CONTEXT__PARAMETERS:
					return ((InternalEList)getParameters()).basicRemove(otherEnd, msgs);
				case ConfigPackage.CONTEXT__FILTER:
					return basicSetFilter(null, msgs);
				case ConfigPackage.CONTEXT__TRACE_CONFIGURATION:
					return eBasicSetContainer(null, ConfigPackage.CONTEXT__TRACE_CONFIGURATION, msgs);
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
				case ConfigPackage.CONTEXT__TRACE_CONFIGURATION:
					return eContainer.eInverseRemove(this, ConfigPackage.TRACE_CONFIGURATION__CONTEXTS, TraceConfiguration.class, msgs);
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
			case ConfigPackage.CONTEXT__NAME:
				return getName();
			case ConfigPackage.CONTEXT__PARAMETERS:
				return getParameters();
			case ConfigPackage.CONTEXT__FILTER:
				return getFilter();
			case ConfigPackage.CONTEXT__TRACE_CONFIGURATION:
				return getTraceConfiguration();
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
			case ConfigPackage.CONTEXT__NAME:
				setName((String)newValue);
				return;
			case ConfigPackage.CONTEXT__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection)newValue);
				return;
			case ConfigPackage.CONTEXT__FILTER:
				setFilter((Filter)newValue);
				return;
			case ConfigPackage.CONTEXT__TRACE_CONFIGURATION:
				setTraceConfiguration((TraceConfiguration)newValue);
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
			case ConfigPackage.CONTEXT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConfigPackage.CONTEXT__PARAMETERS:
				getParameters().clear();
				return;
			case ConfigPackage.CONTEXT__FILTER:
				setFilter((Filter)null);
				return;
			case ConfigPackage.CONTEXT__TRACE_CONFIGURATION:
				setTraceConfiguration((TraceConfiguration)null);
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
			case ConfigPackage.CONTEXT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConfigPackage.CONTEXT__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case ConfigPackage.CONTEXT__FILTER:
				return filter != null;
			case ConfigPackage.CONTEXT__TRACE_CONFIGURATION:
				return getTraceConfiguration() != null;
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

	/**
	 * finds the parameter with the given name and returns its value. if
	 * no parameter with the given name is found, returns null
	 */
	public String getParameter(String parameterName) {
		return (String) getParameters().get(parameterName);
	}
	
	/**
	 * set the value for the parameter with the given name
	 * if the parameter doesn't exist, a new one is created
	 */
	public String setParameter(String parameterName, String newValue) {
		return (String) getParameters().put(parameterName, newValue);
	}

} //ContextImpl
