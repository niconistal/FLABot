/**
 * <copyright>
 * </copyright>
 *
 * $Id: MappingmodelFactory.java,v 1.2 2006/03/11 00:15:45 dacostae Exp $
 */
package org.isistan.flabot.mapping.mappingmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.mapping.mappingmodel.MappingmodelPackage
 * @generated
 */
public interface MappingmodelFactory extends EFactory{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MappingmodelFactory eINSTANCE = new org.isistan.flabot.mapping.mappingmodel.impl.MappingmodelFactoryImpl();

	/**
	 * Returns a new object of class '<em>Pattern Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern Mapping</em>'.
	 * @generated
	 */
	PatternMapping createPatternMapping();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MappingmodelPackage getMappingmodelPackage();

} //MappingmodelFactory
