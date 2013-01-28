/**
 * <copyright>
 * </copyright>
 *
 * $Id: MappingmodelPackageImpl.java,v 1.4 2006/03/14 00:59:15 dacostae Exp $
 */
package org.isistan.flabot.mapping.mappingmodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.isistan.flabot.coremodel.impl.CoremodelPackageImpl;
import org.isistan.flabot.edit.componentmodel.impl.ComponentmodelPackageImpl;
import org.isistan.flabot.edit.editormodel.impl.EditormodelPackageImpl;
import org.isistan.flabot.edit.ucmmodel.impl.UcmmodelPackageImpl;
import org.isistan.flabot.mapping.mappingmodel.Mapping;
import org.isistan.flabot.mapping.mappingmodel.MappingmodelFactory;
import org.isistan.flabot.mapping.mappingmodel.MappingmodelPackage;
import org.isistan.flabot.mapping.mappingmodel.PatternMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MappingmodelPackageImpl extends EPackageImpl implements MappingmodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternMappingEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.isistan.flabot.mapping.mappingmodel.MappingmodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MappingmodelPackageImpl() {
		super(eNS_URI, MappingmodelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MappingmodelPackage init() {
		if (isInited) return (MappingmodelPackage)EPackage.Registry.INSTANCE.getEPackage(MappingmodelPackage.eNS_URI);

		// Obtain or create and register package
		MappingmodelPackageImpl theMappingmodelPackage = (MappingmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof MappingmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new MappingmodelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EditormodelPackageImpl.init();
		ComponentmodelPackageImpl.init();
		UcmmodelPackageImpl.init();
		CoremodelPackageImpl.init();
		EditormodelPackageImpl.init();
		ComponentmodelPackageImpl.init();
		UcmmodelPackageImpl.init();
		CoremodelPackageImpl.init();

		// Create package meta-data objects
		theMappingmodelPackage.createPackageContents();

		// Initialize created meta-data
		theMappingmodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMappingmodelPackage.freeze();

		return theMappingmodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapping() {
		return mappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternMapping() {
		return patternMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPatternMapping_PackagePattern() {
		return (EAttribute)patternMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPatternMapping_BehaviorPattern() {
		return (EAttribute)patternMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPatternMapping_ClassPattern() {
		return (EAttribute)patternMappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPatternMapping_JavaFilePattern() {
		return (EAttribute)patternMappingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingmodelFactory getMappingmodelFactory() {
		return (MappingmodelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		mappingEClass = createEClass(MAPPING);

		patternMappingEClass = createEClass(PATTERN_MAPPING);
		createEAttribute(patternMappingEClass, PATTERN_MAPPING__PACKAGE_PATTERN);
		createEAttribute(patternMappingEClass, PATTERN_MAPPING__BEHAVIOR_PATTERN);
		createEAttribute(patternMappingEClass, PATTERN_MAPPING__CLASS_PATTERN);
		createEAttribute(patternMappingEClass, PATTERN_MAPPING__JAVA_FILE_PATTERN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Add supertypes to classes
		patternMappingEClass.getESuperTypes().add(this.getMapping());

		// Initialize classes and features; add operations and parameters
		initEClass(mappingEClass, Mapping.class, "Mapping", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(patternMappingEClass, PatternMapping.class, "PatternMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPatternMapping_PackagePattern(), ecorePackage.getEString(), "packagePattern", null, 0, 1, PatternMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPatternMapping_BehaviorPattern(), ecorePackage.getEString(), "behaviorPattern", null, 0, 1, PatternMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPatternMapping_ClassPattern(), ecorePackage.getEString(), "classPattern", null, 0, 1, PatternMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPatternMapping_JavaFilePattern(), ecorePackage.getEString(), "javaFilePattern", null, 0, 1, PatternMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //MappingmodelPackageImpl
