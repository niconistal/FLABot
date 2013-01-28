/**
 * <copyright>
 * </copyright>
 *
 * $Id: JavalogtraceFactoryImpl.java,v 1.10 2006/07/04 12:42:19 mblech Exp $
 */
package org.isistan.flabot.engine.executionstate.javalogtrace.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.isistan.flabot.engine.executionstate.javalogtrace.*;

import org.isistan.flabot.engine.executionstate.javalogtrace.JavalogTraceInferenceStrategy;
import org.isistan.flabot.engine.executionstate.javalogtrace.JavalogtraceFactory;
import org.isistan.flabot.engine.executionstate.javalogtrace.JavalogtracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JavalogtraceFactoryImpl extends EFactoryImpl implements JavalogtraceFactory {
	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavalogtraceFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case JavalogtracePackage.JAVALOG_TRACE_INFERENCE_STRATEGY: return createJavalogTraceInferenceStrategy();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavalogTraceInferenceStrategy createJavalogTraceInferenceStrategy() {
		JavalogTraceInferenceStrategyImpl javalogTraceInferenceStrategy = new JavalogTraceInferenceStrategyImpl();
		return javalogTraceInferenceStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavalogtracePackage getJavalogtracePackage() {
		return (JavalogtracePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static JavalogtracePackage getPackage() {
		return JavalogtracePackage.eINSTANCE;
	}

} //JavalogtraceFactoryImpl
