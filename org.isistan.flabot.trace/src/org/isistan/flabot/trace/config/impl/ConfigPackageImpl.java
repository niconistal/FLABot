/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConfigPackageImpl.java,v 1.6 2006/03/29 21:21:28 dacostae Exp $
 */
package org.isistan.flabot.trace.config.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.isistan.flabot.gauge.GaugeFilter;

import org.isistan.flabot.trace.config.ConfigFactory;
import org.isistan.flabot.trace.config.ConfigPackage;
import org.isistan.flabot.trace.config.Context;
import org.isistan.flabot.trace.config.Filter;
import org.isistan.flabot.trace.config.TraceConfiguration;
import org.isistan.flabot.trace.log.LogPackage;
import org.isistan.flabot.trace.log.impl.LogPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigPackageImpl extends EPackageImpl implements ConfigPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filter_1EClass = null;

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
	 * @see org.isistan.flabot.trace.config.ConfigPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ConfigPackageImpl() {
		super(eNS_URI, ConfigFactory.eINSTANCE);
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
	public static ConfigPackage init() {
		if (isInited) return (ConfigPackage)EPackage.Registry.INSTANCE.getEPackage(ConfigPackage.eNS_URI);

		// Obtain or create and register package
		ConfigPackageImpl theConfigPackage = (ConfigPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ConfigPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ConfigPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		LogPackageImpl theLogPackage = (LogPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LogPackage.eNS_URI) instanceof LogPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LogPackage.eNS_URI) : LogPackage.eINSTANCE);

		// Create package meta-data objects
		theConfigPackage.createPackageContents();
		theLogPackage.createPackageContents();

		// Initialize created meta-data
		theConfigPackage.initializePackageContents();
		theLogPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theConfigPackage.freeze();

		return theConfigPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContext() {
		return contextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContext_Name() {
		return (EAttribute)contextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContext_Parameters() {
		return (EReference)contextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContext_Filter() {
		return (EReference)contextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContext_TraceConfiguration() {
		return (EReference)contextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceConfiguration() {
		return traceConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceConfiguration_Contexts() {
		return (EReference)traceConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceConfiguration_OutputFileName() {
		return (EAttribute)traceConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceConfiguration_StartCollecting() {
		return (EAttribute)traceConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFilter() {
		return filterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFilter_Context() {
		return (EReference)filterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFilter_1() {
		return filter_1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigFactory getConfigFactory() {
		return (ConfigFactory)getEFactoryInstance();
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
		contextEClass = createEClass(CONTEXT);
		createEAttribute(contextEClass, CONTEXT__NAME);
		createEReference(contextEClass, CONTEXT__PARAMETERS);
		createEReference(contextEClass, CONTEXT__FILTER);
		createEReference(contextEClass, CONTEXT__TRACE_CONFIGURATION);

		traceConfigurationEClass = createEClass(TRACE_CONFIGURATION);
		createEReference(traceConfigurationEClass, TRACE_CONFIGURATION__CONTEXTS);
		createEAttribute(traceConfigurationEClass, TRACE_CONFIGURATION__OUTPUT_FILE_NAME);
		createEAttribute(traceConfigurationEClass, TRACE_CONFIGURATION__START_COLLECTING);

		filterEClass = createEClass(FILTER);
		createEReference(filterEClass, FILTER__CONTEXT);

		filter_1EClass = createEClass(FILTER_1);
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
		filterEClass.getESuperTypes().add(this.getFilter_1());

		// Initialize classes and features; add operations and parameters
		initEClass(contextEClass, Context.class, "Context", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContext_Name(), ecorePackage.getEString(), "name", null, 0, 1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContext_Parameters(), ecorePackage.getEStringToStringMapEntry(), null, "parameters", null, 0, -1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContext_Filter(), this.getFilter(), this.getFilter_Context(), "filter", null, 0, 1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContext_TraceConfiguration(), this.getTraceConfiguration(), this.getTraceConfiguration_Contexts(), "traceConfiguration", null, 0, 1, Context.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(traceConfigurationEClass, TraceConfiguration.class, "TraceConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTraceConfiguration_Contexts(), this.getContext(), this.getContext_TraceConfiguration(), "contexts", null, 0, -1, TraceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceConfiguration_OutputFileName(), ecorePackage.getEString(), "outputFileName", "traceOutput.tracelog", 0, 1, TraceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceConfiguration_StartCollecting(), ecorePackage.getEBooleanObject(), "startCollecting", null, 0, 1, TraceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(filterEClass, Filter.class, "Filter", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFilter_Context(), this.getContext(), this.getContext_Filter(), "context", null, 0, 1, Filter.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(filter_1EClass, GaugeFilter.class, "Filter_1", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ConfigPackageImpl
