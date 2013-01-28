/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConfigAdapterFactory.java,v 1.7 2006/03/29 21:21:28 dacostae Exp $
 */
package org.isistan.flabot.trace.config.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.isistan.flabot.gauge.GaugeFilter;

import org.isistan.flabot.trace.config.*;

import org.isistan.flabot.trace.config.ConfigPackage;
import org.isistan.flabot.trace.config.Context;
import org.isistan.flabot.trace.config.Filter;
import org.isistan.flabot.trace.config.TraceConfiguration;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.trace.config.ConfigPackage
 * @generated
 */
public class ConfigAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ConfigPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ConfigPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigSwitch modelSwitch =
		new ConfigSwitch() {
			public Object caseContext(Context object) {
				return createContextAdapter();
			}
			public Object caseTraceConfiguration(TraceConfiguration object) {
				return createTraceConfigurationAdapter();
			}
			public Object caseFilter(Filter object) {
				return createFilterAdapter();
			}
			public Object caseFilter_1(GaugeFilter object) {
				return createFilter_1Adapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.trace.config.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.trace.config.Context
	 * @generated
	 */
	public Adapter createContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.trace.config.TraceConfiguration <em>Trace Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.trace.config.TraceConfiguration
	 * @generated
	 */
	public Adapter createTraceConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.trace.config.Filter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.trace.config.Filter
	 * @generated
	 */
	public Adapter createFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.gauge.GaugeFilter <em>Filter 1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.gauge.GaugeFilter
	 * @generated
	 */
	public Adapter createFilter_1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ConfigAdapterFactory
