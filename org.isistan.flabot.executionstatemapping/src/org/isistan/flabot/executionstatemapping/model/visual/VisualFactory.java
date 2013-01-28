/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.visual;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.executionstatemapping.model.visual.VisualPackage
 * @generated
 */
public interface VisualFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VisualFactory eINSTANCE = org.isistan.flabot.executionstatemapping.model.visual.impl.VisualFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>State Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Diagram</em>'.
	 * @generated
	 */
	StateDiagram createStateDiagram();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	VisualPackage getVisualPackage();

} //VisualFactory
