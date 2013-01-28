/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConfigFactory.java,v 1.2 2006/01/31 22:19:57 dacostae Exp $
 */
package org.isistan.flabot.trace.config;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.trace.config.ConfigPackage
 * @generated
 */
public interface ConfigFactory extends EFactory{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConfigFactory eINSTANCE = new org.isistan.flabot.trace.config.impl.ConfigFactoryImpl();

	/**
	 * Returns a new object of class '<em>Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Context</em>'.
	 * @generated
	 */
	Context createContext();

	/**
	 * Returns a new object of class '<em>Trace Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace Configuration</em>'.
	 * @generated
	 */
	TraceConfiguration createTraceConfiguration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ConfigPackage getConfigPackage();

} //ConfigFactory
