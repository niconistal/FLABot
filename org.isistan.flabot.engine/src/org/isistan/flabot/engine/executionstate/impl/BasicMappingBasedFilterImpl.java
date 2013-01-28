/**
 * <copyright>
 * </copyright>
 *
 * $Id: BasicMappingBasedFilterImpl.java,v 1.16 2006/03/27 23:53:01 dacostae Exp $
 */
package org.isistan.flabot.engine.executionstate.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.isistan.flabot.engine.executionstate.BasicMappingBasedFilter;
import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;
import org.isistan.flabot.gauge.Gauge;
import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JPackage;
import org.isistan.flabot.launcher.filter.filtermodel.FiltermodelFactory;
import org.isistan.flabot.launcher.filter.filtermodel.LogFilter;
import org.isistan.flabot.mapping.mappingmodel.Mapping;
import org.isistan.flabot.trace.config.ConfigPackage;
import org.isistan.flabot.trace.config.Context;
import org.isistan.flabot.util.TriState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Mapping Based Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class BasicMappingBasedFilterImpl extends MappingBasedFilterImpl implements BasicMappingBasedFilter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasicMappingBasedFilterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionstatePackage.eINSTANCE.getBasicMappingBasedFilter();
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
				case ExecutionstatePackage.BASIC_MAPPING_BASED_FILTER__CONTEXT:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExecutionstatePackage.BASIC_MAPPING_BASED_FILTER__CONTEXT, msgs);
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
				case ExecutionstatePackage.BASIC_MAPPING_BASED_FILTER__CONTEXT:
					return eBasicSetContainer(null, ExecutionstatePackage.BASIC_MAPPING_BASED_FILTER__CONTEXT, msgs);
				case ExecutionstatePackage.BASIC_MAPPING_BASED_FILTER__MAPPING:
					return basicSetMapping(null, msgs);
				case ExecutionstatePackage.BASIC_MAPPING_BASED_FILTER__LOG_FILTER:
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
				case ExecutionstatePackage.BASIC_MAPPING_BASED_FILTER__CONTEXT:
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
			case ExecutionstatePackage.BASIC_MAPPING_BASED_FILTER__CONTEXT:
				return getContext();
			case ExecutionstatePackage.BASIC_MAPPING_BASED_FILTER__MAPPING:
				return getMapping();
			case ExecutionstatePackage.BASIC_MAPPING_BASED_FILTER__LOG_FILTER:
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
			case ExecutionstatePackage.BASIC_MAPPING_BASED_FILTER__CONTEXT:
				setContext((Context)newValue);
				return;
			case ExecutionstatePackage.BASIC_MAPPING_BASED_FILTER__MAPPING:
				setMapping((Mapping)newValue);
				return;
			case ExecutionstatePackage.BASIC_MAPPING_BASED_FILTER__LOG_FILTER:
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
			case ExecutionstatePackage.BASIC_MAPPING_BASED_FILTER__CONTEXT:
				setContext((Context)null);
				return;
			case ExecutionstatePackage.BASIC_MAPPING_BASED_FILTER__MAPPING:
				setMapping((Mapping)null);
				return;
			case ExecutionstatePackage.BASIC_MAPPING_BASED_FILTER__LOG_FILTER:
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
			case ExecutionstatePackage.BASIC_MAPPING_BASED_FILTER__CONTEXT:
				return getContext() != null;
			case ExecutionstatePackage.BASIC_MAPPING_BASED_FILTER__MAPPING:
				return mapping != null;
			case ExecutionstatePackage.BASIC_MAPPING_BASED_FILTER__LOG_FILTER:
				return logFilter != null;
		}
		return eDynamicIsSet(eFeature);
	}

	private static LogFilter defaultLogFilter=FiltermodelFactory.eINSTANCE.createLogFilter();
	public boolean passes(Gauge gauge) {
		LogFilter logFilter=getLogFilter();
		if(logFilter==null) 
			logFilter=defaultLogFilter;
		
		return logFilter.isGaugeType(gauge.getType());
	}

	public boolean passes(JBehavior jBehavior) {
		Mapping mapping=getMapping();
		return mapping.passes(jBehavior);
	}
	
	public TriState passes(JClass jClass) {
		Mapping mapping=getMapping();
		return mapping.passes(jClass);
	}

	public TriState passes(JPackage jPackage) {
		Mapping mapping=getMapping();
		return mapping.passes(jPackage);
	}

} //BasicMappingBasedFilterImpl
