/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConfigPackage.java,v 1.7 2006/03/29 21:21:28 dacostae Exp $
 */
package org.isistan.flabot.trace.config;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.isistan.flabot.trace.config.ConfigFactory
 * @model kind="package"
 * @generated
 */
public interface ConfigPackage extends EPackage{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "config";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/isistan/flabot/trace/config.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.isistan.flabot.trace.config";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConfigPackage eINSTANCE = org.isistan.flabot.trace.config.impl.ConfigPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.isistan.flabot.trace.config.impl.ContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.trace.config.impl.ContextImpl
	 * @see org.isistan.flabot.trace.config.impl.ConfigPackageImpl#getContext()
	 * @generated
	 */
	int CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__PARAMETERS = 1;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__FILTER = 2;

	/**
	 * The feature id for the '<em><b>Trace Configuration</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__TRACE_CONFIGURATION = 3;

	/**
	 * The number of structural features of the the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.trace.config.impl.TraceConfigurationImpl <em>Trace Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.trace.config.impl.TraceConfigurationImpl
	 * @see org.isistan.flabot.trace.config.impl.ConfigPackageImpl#getTraceConfiguration()
	 * @generated
	 */
	int TRACE_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Contexts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_CONFIGURATION__CONTEXTS = 0;

	/**
	 * The feature id for the '<em><b>Output File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_CONFIGURATION__OUTPUT_FILE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Start Collecting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_CONFIGURATION__START_COLLECTING = 2;

	/**
	 * The number of structural features of the the '<em>Trace Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_CONFIGURATION_FEATURE_COUNT = 3;


	/**
	 * The meta object id for the '{@link org.isistan.flabot.gauge.GaugeFilter <em>Filter 1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.gauge.GaugeFilter
	 * @see org.isistan.flabot.trace.config.impl.ConfigPackageImpl#getFilter_1()
	 * @generated
	 */
	int FILTER_1 = 3;

	/**
	 * The number of structural features of the the '<em>Filter 1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_1_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.trace.config.Filter <em>Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.trace.config.Filter
	 * @see org.isistan.flabot.trace.config.impl.ConfigPackageImpl#getFilter()
	 * @generated
	 */
	int FILTER = 2;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER__CONTEXT = FILTER_1_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_FEATURE_COUNT = FILTER_1_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.trace.config.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see org.isistan.flabot.trace.config.Context
	 * @generated
	 */
	EClass getContext();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.trace.config.Context#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.isistan.flabot.trace.config.Context#getName()
	 * @see #getContext()
	 * @generated
	 */
	EAttribute getContext_Name();

	/**
	 * Returns the meta object for the map '{@link org.isistan.flabot.trace.config.Context#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Parameters</em>'.
	 * @see org.isistan.flabot.trace.config.Context#getParameters()
	 * @see #getContext()
	 * @generated
	 */
	EReference getContext_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.trace.config.Context#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Filter</em>'.
	 * @see org.isistan.flabot.trace.config.Context#getFilter()
	 * @see #getContext()
	 * @generated
	 */
	EReference getContext_Filter();

	/**
	 * Returns the meta object for the container reference '{@link org.isistan.flabot.trace.config.Context#getTraceConfiguration <em>Trace Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Trace Configuration</em>'.
	 * @see org.isistan.flabot.trace.config.Context#getTraceConfiguration()
	 * @see #getContext()
	 * @generated
	 */
	EReference getContext_TraceConfiguration();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.trace.config.TraceConfiguration <em>Trace Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Configuration</em>'.
	 * @see org.isistan.flabot.trace.config.TraceConfiguration
	 * @generated
	 */
	EClass getTraceConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.trace.config.TraceConfiguration#getContexts <em>Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contexts</em>'.
	 * @see org.isistan.flabot.trace.config.TraceConfiguration#getContexts()
	 * @see #getTraceConfiguration()
	 * @generated
	 */
	EReference getTraceConfiguration_Contexts();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.trace.config.TraceConfiguration#getOutputFileName <em>Output File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output File Name</em>'.
	 * @see org.isistan.flabot.trace.config.TraceConfiguration#getOutputFileName()
	 * @see #getTraceConfiguration()
	 * @generated
	 */
	EAttribute getTraceConfiguration_OutputFileName();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.trace.config.TraceConfiguration#getStartCollecting <em>Start Collecting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Collecting</em>'.
	 * @see org.isistan.flabot.trace.config.TraceConfiguration#getStartCollecting()
	 * @see #getTraceConfiguration()
	 * @generated
	 */
	EAttribute getTraceConfiguration_StartCollecting();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.trace.config.Filter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Filter</em>'.
	 * @see org.isistan.flabot.trace.config.Filter
	 * @generated
	 */
	EClass getFilter();

	/**
	 * Returns the meta object for the container reference '{@link org.isistan.flabot.trace.config.Filter#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Context</em>'.
	 * @see org.isistan.flabot.trace.config.Filter#getContext()
	 * @see #getFilter()
	 * @generated
	 */
	EReference getFilter_Context();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.gauge.GaugeFilter <em>Filter 1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Filter 1</em>'.
	 * @see org.isistan.flabot.gauge.GaugeFilter
	 * @model instanceClass="org.isistan.flabot.gauge.GaugeFilter"
	 * @generated
	 */
	EClass getFilter_1();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConfigFactory getConfigFactory();

} //ConfigPackage
