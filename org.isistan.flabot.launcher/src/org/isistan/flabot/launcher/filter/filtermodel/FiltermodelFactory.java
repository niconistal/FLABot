/**
 * <copyright>
 * </copyright>
 *
 * $Id: FiltermodelFactory.java,v 1.1 2006/02/27 21:57:55 dacostae Exp $
 */
package org.isistan.flabot.launcher.filter.filtermodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.launcher.filter.filtermodel.FiltermodelPackage
 * @generated
 */
public interface FiltermodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FiltermodelFactory eINSTANCE = new org.isistan.flabot.launcher.filter.filtermodel.impl.FiltermodelFactoryImpl();

	/**
	 * Returns a new object of class '<em>Log Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Log Filter</em>'.
	 * @generated
	 */
	LogFilter createLogFilter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FiltermodelPackage getFiltermodelPackage();

} //FiltermodelFactory
