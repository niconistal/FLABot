/**
 * <copyright>
 * </copyright>
 *
 * $Id: FiltermodelPackage.java,v 1.1 2006/02/27 21:57:55 dacostae Exp $
 */
package org.isistan.flabot.launcher.filter.filtermodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.launcher.filter.filtermodel.FiltermodelFactory
 * @model kind="package"
 * @generated
 */
public interface FiltermodelPackage extends EPackage{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "filtermodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/isistan/flabot/launcher/filter/filtermodel.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.isistan.flabot.launcher.filter.filtermodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FiltermodelPackage eINSTANCE = org.isistan.flabot.launcher.filter.filtermodel.impl.FiltermodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.isistan.flabot.launcher.filter.filtermodel.impl.LogFilterImpl <em>Log Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.launcher.filter.filtermodel.impl.LogFilterImpl
	 * @see org.isistan.flabot.launcher.filter.filtermodel.impl.FiltermodelPackageImpl#getLogFilter()
	 * @generated
	 */
	int LOG_FILTER = 0;

	/**
	 * The feature id for the '<em><b>Gauge Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_FILTER__GAUGE_TYPES = 0;

	/**
	 * The number of structural features of the the '<em>Log Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_FILTER_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.launcher.filter.filtermodel.LogFilter <em>Log Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Log Filter</em>'.
	 * @see org.isistan.flabot.launcher.filter.filtermodel.LogFilter
	 * @generated
	 */
	EClass getLogFilter();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.launcher.filter.filtermodel.LogFilter#getGaugeTypes <em>Gauge Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gauge Types</em>'.
	 * @see org.isistan.flabot.launcher.filter.filtermodel.LogFilter#getGaugeTypes()
	 * @see #getLogFilter()
	 * @generated
	 */
	EAttribute getLogFilter_GaugeTypes();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FiltermodelFactory getFiltermodelFactory();

} //FiltermodelPackage
