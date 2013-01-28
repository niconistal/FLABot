/**
 * <copyright>
 * </copyright>
 *
 * $Id: FiltermodelFactoryImpl.java,v 1.1 2006/02/27 21:57:55 dacostae Exp $
 */
package org.isistan.flabot.launcher.filter.filtermodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.isistan.flabot.gauge.Gauge;
import org.isistan.flabot.launcher.filter.filtermodel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FiltermodelFactoryImpl extends EFactoryImpl implements FiltermodelFactory {
	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FiltermodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FiltermodelPackage.LOG_FILTER: return createLogFilter();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LogFilter createLogFilter() {
		LogFilterImpl logFilter = new LogFilterImpl();
		logFilter.setGaugeType(Gauge.Type.ON_BEHAVIOR_ENTRY, true);
		logFilter.setGaugeType(Gauge.Type.ON_BEHAVIOR_EXIT, true);
		logFilter.setGaugeType(Gauge.Type.ON_BEHAVIOR_ERROR, true);
		return logFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FiltermodelPackage getFiltermodelPackage() {
		return (FiltermodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FiltermodelPackage getPackage() {
		return FiltermodelPackage.eINSTANCE;
	}

} //FiltermodelFactoryImpl
