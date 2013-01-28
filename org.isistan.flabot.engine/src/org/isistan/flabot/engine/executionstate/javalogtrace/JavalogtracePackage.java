/**
 * <copyright>
 * </copyright>
 *
 * $Id: JavalogtracePackage.java,v 1.2 2006/02/14 22:18:47 franco Exp $
 */
package org.isistan.flabot.engine.executionstate.javalogtrace;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;

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
 * @see org.isistan.flabot.engine.executionstate.javalogtrace.JavalogtraceFactory
 * @model kind="package"
 * @generated
 */
public interface JavalogtracePackage extends EPackage{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "javalogtrace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/isistan/flabot/engine/executionstate/javalogtrace.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.isistan.flabot.engine.executionstate.javalogtrace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JavalogtracePackage eINSTANCE = org.isistan.flabot.engine.executionstate.javalogtrace.impl.JavalogtracePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.isistan.flabot.engine.executionstate.javalogtrace.impl.JavalogTraceInferenceStrategyImpl <em>Javalog Trace Inference Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.engine.executionstate.javalogtrace.impl.JavalogTraceInferenceStrategyImpl
	 * @see org.isistan.flabot.engine.executionstate.javalogtrace.impl.JavalogtracePackageImpl#getJavalogTraceInferenceStrategy()
	 * @generated
	 */
	int JAVALOG_TRACE_INFERENCE_STRATEGY = 0;

	/**
	 * The feature id for the '<em><b>State Determination Strategy</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVALOG_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY = ExecutionstatePackage.TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY;

	/**
	 * The feature id for the '<em><b>Prolog Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVALOG_TRACE_INFERENCE_STRATEGY__PROLOG_CODE = ExecutionstatePackage.TRACE_INFERENCE_STRATEGY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>Javalog Trace Inference Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVALOG_TRACE_INFERENCE_STRATEGY_FEATURE_COUNT = ExecutionstatePackage.TRACE_INFERENCE_STRATEGY_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.engine.executionstate.javalogtrace.JavalogTraceInferenceStrategy <em>Javalog Trace Inference Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Javalog Trace Inference Strategy</em>'.
	 * @see org.isistan.flabot.engine.executionstate.javalogtrace.JavalogTraceInferenceStrategy
	 * @generated
	 */
	EClass getJavalogTraceInferenceStrategy();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.engine.executionstate.javalogtrace.JavalogTraceInferenceStrategy#getPrologCode <em>Prolog Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prolog Code</em>'.
	 * @see org.isistan.flabot.engine.executionstate.javalogtrace.JavalogTraceInferenceStrategy#getPrologCode()
	 * @see #getJavalogTraceInferenceStrategy()
	 * @generated
	 */
	EAttribute getJavalogTraceInferenceStrategy_PrologCode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JavalogtraceFactory getJavalogtraceFactory();

} //JavalogtracePackage
