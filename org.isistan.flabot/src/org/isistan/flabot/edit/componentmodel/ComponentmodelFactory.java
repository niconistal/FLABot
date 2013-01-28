/**
 * <copyright>
 * </copyright>
 *
 * $Id: ComponentmodelFactory.java,v 1.8 2005/10/06 17:57:24 franco Exp $
 */
package org.isistan.flabot.edit.componentmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.edit.componentmodel.ComponentmodelPackage
 * @generated
 */
public interface ComponentmodelFactory extends EFactory{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComponentmodelFactory eINSTANCE = new org.isistan.flabot.edit.componentmodel.impl.ComponentmodelFactoryImpl();

	/**
	 * Returns a new object of class '<em>Component Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Diagram</em>'.
	 * @generated
	 */
	ComponentDiagram createComponentDiagram();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ComponentmodelPackage getComponentmodelPackage();

} //ComponentmodelFactory
