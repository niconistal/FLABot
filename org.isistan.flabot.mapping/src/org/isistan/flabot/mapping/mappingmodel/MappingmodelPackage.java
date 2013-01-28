/**
 * <copyright>
 * </copyright>
 *
 * $Id: MappingmodelPackage.java,v 1.3 2006/03/14 00:59:15 dacostae Exp $
 */
package org.isistan.flabot.mapping.mappingmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.mapping.mappingmodel.MappingmodelFactory
 * @model kind="package"
 * @generated
 */
public interface MappingmodelPackage extends EPackage{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mappingmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/isistan/flabot/mapping/mappingmodel.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.isistan.flabot.mapping.mappingmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MappingmodelPackage eINSTANCE = org.isistan.flabot.mapping.mappingmodel.impl.MappingmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.isistan.flabot.mapping.mappingmodel.Mapping <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.mapping.mappingmodel.Mapping
	 * @see org.isistan.flabot.mapping.mappingmodel.impl.MappingmodelPackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 0;

	/**
	 * The number of structural features of the the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.mapping.mappingmodel.impl.PatternMappingImpl <em>Pattern Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.mapping.mappingmodel.impl.PatternMappingImpl
	 * @see org.isistan.flabot.mapping.mappingmodel.impl.MappingmodelPackageImpl#getPatternMapping()
	 * @generated
	 */
	int PATTERN_MAPPING = 1;

	/**
	 * The feature id for the '<em><b>Package Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_MAPPING__PACKAGE_PATTERN = MAPPING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Behavior Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_MAPPING__BEHAVIOR_PATTERN = MAPPING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Class Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_MAPPING__CLASS_PATTERN = MAPPING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Java File Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_MAPPING__JAVA_FILE_PATTERN = MAPPING_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the the '<em>Pattern Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_MAPPING_FEATURE_COUNT = MAPPING_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.mapping.mappingmodel.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see org.isistan.flabot.mapping.mappingmodel.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.mapping.mappingmodel.PatternMapping <em>Pattern Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Mapping</em>'.
	 * @see org.isistan.flabot.mapping.mappingmodel.PatternMapping
	 * @generated
	 */
	EClass getPatternMapping();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.mapping.mappingmodel.PatternMapping#getPackagePattern <em>Package Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Pattern</em>'.
	 * @see org.isistan.flabot.mapping.mappingmodel.PatternMapping#getPackagePattern()
	 * @see #getPatternMapping()
	 * @generated
	 */
	EAttribute getPatternMapping_PackagePattern();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.mapping.mappingmodel.PatternMapping#getBehaviorPattern <em>Behavior Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Behavior Pattern</em>'.
	 * @see org.isistan.flabot.mapping.mappingmodel.PatternMapping#getBehaviorPattern()
	 * @see #getPatternMapping()
	 * @generated
	 */
	EAttribute getPatternMapping_BehaviorPattern();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.mapping.mappingmodel.PatternMapping#getClassPattern <em>Class Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Pattern</em>'.
	 * @see org.isistan.flabot.mapping.mappingmodel.PatternMapping#getClassPattern()
	 * @see #getPatternMapping()
	 * @generated
	 */
	EAttribute getPatternMapping_ClassPattern();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.mapping.mappingmodel.PatternMapping#getJavaFilePattern <em>Java File Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Java File Pattern</em>'.
	 * @see org.isistan.flabot.mapping.mappingmodel.PatternMapping#getJavaFilePattern()
	 * @see #getPatternMapping()
	 * @generated
	 */
	EAttribute getPatternMapping_JavaFilePattern();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MappingmodelFactory getMappingmodelFactory();

} //MappingmodelPackage
