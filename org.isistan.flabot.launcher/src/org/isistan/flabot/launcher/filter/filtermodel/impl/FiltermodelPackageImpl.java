/**
 * <copyright>
 * </copyright>
 *
 * $Id: FiltermodelPackageImpl.java,v 1.1 2006/02/27 21:57:55 dacostae Exp $
 */
package org.isistan.flabot.launcher.filter.filtermodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.isistan.flabot.coremodel.impl.CoremodelPackageImpl;

import org.isistan.flabot.edit.componentmodel.impl.ComponentmodelPackageImpl;

import org.isistan.flabot.edit.editormodel.impl.EditormodelPackageImpl;

import org.isistan.flabot.edit.ucmmodel.impl.UcmmodelPackageImpl;

import org.isistan.flabot.launcher.filter.filtermodel.FiltermodelFactory;
import org.isistan.flabot.launcher.filter.filtermodel.FiltermodelPackage;
import org.isistan.flabot.launcher.filter.filtermodel.LogFilter;

import org.isistan.flabot.trace.config.impl.ConfigPackageImpl;

import org.isistan.flabot.trace.log.impl.LogPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FiltermodelPackageImpl extends EPackageImpl implements FiltermodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logFilterEClass = null;

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
	 * @see org.isistan.flabot.launcher.filter.filtermodel.FiltermodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FiltermodelPackageImpl() {
		super(eNS_URI, FiltermodelFactory.eINSTANCE);
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
	public static FiltermodelPackage init() {
		if (isInited) return (FiltermodelPackage)EPackage.Registry.INSTANCE.getEPackage(FiltermodelPackage.eNS_URI);

		// Obtain or create and register package
		FiltermodelPackageImpl theFiltermodelPackage = (FiltermodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof FiltermodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new FiltermodelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EditormodelPackageImpl.init();
		ComponentmodelPackageImpl.init();
		UcmmodelPackageImpl.init();
		CoremodelPackageImpl.init();
		ConfigPackageImpl.init();
		LogPackageImpl.init();
		EditormodelPackageImpl.init();
		ComponentmodelPackageImpl.init();
		UcmmodelPackageImpl.init();
		CoremodelPackageImpl.init();
		ConfigPackageImpl.init();
		LogPackageImpl.init();

		// Create package meta-data objects
		theFiltermodelPackage.createPackageContents();

		// Initialize created meta-data
		theFiltermodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFiltermodelPackage.freeze();

		return theFiltermodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogFilter() {
		return logFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogFilter_GaugeTypes() {
		return (EAttribute)logFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FiltermodelFactory getFiltermodelFactory() {
		return (FiltermodelFactory)getEFactoryInstance();
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
		logFilterEClass = createEClass(LOG_FILTER);
		createEAttribute(logFilterEClass, LOG_FILTER__GAUGE_TYPES);
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

		// Initialize classes and features; add operations and parameters
		initEClass(logFilterEClass, LogFilter.class, "LogFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLogFilter_GaugeTypes(), ecorePackage.getEInt(), "gaugeTypes", null, 0, 1, LogFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //FiltermodelPackageImpl
