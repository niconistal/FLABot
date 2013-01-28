/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.prolog;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.executionstatemapping.model.prolog.PrologPackage
 * @generated
 */
public interface PrologFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PrologFactory eINSTANCE = org.isistan.flabot.executionstatemapping.model.prolog.impl.PrologFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Code Factory</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Code Factory</em>'.
	 * @generated
	 */
	PrologCodeFactory createPrologCodeFactory();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PrologPackage getPrologPackage();

} //PrologFactory
