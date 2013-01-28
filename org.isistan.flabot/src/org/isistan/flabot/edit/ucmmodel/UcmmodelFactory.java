/**
 * <copyright>
 * </copyright>
 *
 * $Id: UcmmodelFactory.java,v 1.7 2005/10/06 17:57:25 franco Exp $
 */
package org.isistan.flabot.edit.ucmmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.edit.ucmmodel.UcmmodelPackage
 * @generated
 */
public interface UcmmodelFactory extends EFactory{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UcmmodelFactory eINSTANCE = new org.isistan.flabot.edit.ucmmodel.impl.UcmmodelFactoryImpl();

	/**
	 * Returns a new object of class '<em>UCM Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UCM Diagram</em>'.
	 * @generated
	 */
	UCMDiagram createUCMDiagram();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UcmmodelPackage getUcmmodelPackage();

} //UcmmodelFactory
