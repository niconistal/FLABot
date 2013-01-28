/**
 * <copyright>
 * </copyright>
 *
 * $Id: MappingmodelFactoryImpl.java,v 1.1 2006/02/23 00:06:34 dacostae Exp $
 */
package org.isistan.flabot.mapping.mappingmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.isistan.flabot.mapping.mappingmodel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MappingmodelFactoryImpl extends EFactoryImpl implements MappingmodelFactory {
	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingmodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MappingmodelPackage.PATTERN_MAPPING: return createPatternMapping();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternMapping createPatternMapping() {
		PatternMappingImpl patternMapping = new PatternMappingImpl();
		return patternMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingmodelPackage getMappingmodelPackage() {
		return (MappingmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MappingmodelPackage getPackage() {
		return MappingmodelPackage.eINSTANCE;
	}

} //MappingmodelFactoryImpl
