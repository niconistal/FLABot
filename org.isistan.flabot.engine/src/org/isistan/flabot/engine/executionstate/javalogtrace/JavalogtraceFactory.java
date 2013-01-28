/**
 * <copyright>
 * </copyright>
 *
 * $Id: JavalogtraceFactory.java,v 1.1 2006/02/11 01:55:06 mblech Exp $
 */
package org.isistan.flabot.engine.executionstate.javalogtrace;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.engine.executionstate.javalogtrace.JavalogtracePackage
 * @generated
 */
public interface JavalogtraceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JavalogtraceFactory eINSTANCE = new org.isistan.flabot.engine.executionstate.javalogtrace.impl.JavalogtraceFactoryImpl();

	/**
	 * Returns a new object of class '<em>Javalog Trace Inference Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Javalog Trace Inference Strategy</em>'.
	 * @generated
	 */
	JavalogTraceInferenceStrategy createJavalogTraceInferenceStrategy();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	JavalogtracePackage getJavalogtracePackage();

} //JavalogtraceFactory
