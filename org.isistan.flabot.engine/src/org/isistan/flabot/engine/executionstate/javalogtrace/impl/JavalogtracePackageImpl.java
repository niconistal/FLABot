/**
 * <copyright>
 * </copyright>
 *
 * $Id: JavalogtracePackageImpl.java,v 1.6 2006/03/22 03:28:55 franco Exp $
 */
package org.isistan.flabot.engine.executionstate.javalogtrace.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.isistan.flabot.coremodel.impl.CoremodelPackageImpl;
import org.isistan.flabot.edit.componentmodel.impl.ComponentmodelPackageImpl;
import org.isistan.flabot.edit.editormodel.impl.EditormodelPackageImpl;
import org.isistan.flabot.edit.ucmmodel.impl.UcmmodelPackageImpl;
import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;
import org.isistan.flabot.engine.executionstate.impl.ExecutionstatePackageImpl;
import org.isistan.flabot.engine.executionstate.javalogtrace.JavalogTraceInferenceStrategy;
import org.isistan.flabot.engine.executionstate.javalogtrace.JavalogtraceFactory;
import org.isistan.flabot.engine.executionstate.javalogtrace.JavalogtracePackage;
import org.isistan.flabot.executionmodel.ExecutionmodelPackage;
import org.isistan.flabot.executionmodel.impl.ExecutionmodelPackageImpl;
import org.isistan.flabot.launcher.filter.filtermodel.impl.FiltermodelPackageImpl;
import org.isistan.flabot.mapping.mappingmodel.impl.MappingmodelPackageImpl;
import org.isistan.flabot.trace.config.impl.ConfigPackageImpl;
import org.isistan.flabot.trace.log.impl.LogPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JavalogtracePackageImpl extends EPackageImpl implements JavalogtracePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javalogTraceInferenceStrategyEClass = null;

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
	 * @see org.isistan.flabot.engine.executionstate.javalogtrace.JavalogtracePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private JavalogtracePackageImpl() {
		super(eNS_URI, JavalogtraceFactory.eINSTANCE);
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
	public static JavalogtracePackage init() {
		if (isInited) return (JavalogtracePackage)EPackage.Registry.INSTANCE.getEPackage(JavalogtracePackage.eNS_URI);

		// Obtain or create and register package
		JavalogtracePackageImpl theJavalogtracePackage = (JavalogtracePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof JavalogtracePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new JavalogtracePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EditormodelPackageImpl.init();
		ComponentmodelPackageImpl.init();
		UcmmodelPackageImpl.init();
		CoremodelPackageImpl.init();
		ConfigPackageImpl.init();
		LogPackageImpl.init();
		MappingmodelPackageImpl.init();
		FiltermodelPackageImpl.init();
		EditormodelPackageImpl.init();
		ComponentmodelPackageImpl.init();
		UcmmodelPackageImpl.init();
		CoremodelPackageImpl.init();
		FiltermodelPackageImpl.init();
		ConfigPackageImpl.init();
		LogPackageImpl.init();
		MappingmodelPackageImpl.init();

		// Obtain or create and register interdependencies
		ExecutionmodelPackageImpl theExecutionmodelPackage = (ExecutionmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExecutionmodelPackage.eNS_URI) instanceof ExecutionmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExecutionmodelPackage.eNS_URI) : ExecutionmodelPackage.eINSTANCE);
		ExecutionstatePackageImpl theExecutionstatePackage = (ExecutionstatePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExecutionstatePackage.eNS_URI) instanceof ExecutionstatePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExecutionstatePackage.eNS_URI) : ExecutionstatePackage.eINSTANCE);

		// Create package meta-data objects
		theJavalogtracePackage.createPackageContents();
		theExecutionmodelPackage.createPackageContents();
		theExecutionstatePackage.createPackageContents();

		// Initialize created meta-data
		theJavalogtracePackage.initializePackageContents();
		theExecutionmodelPackage.initializePackageContents();
		theExecutionstatePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJavalogtracePackage.freeze();

		return theJavalogtracePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavalogTraceInferenceStrategy() {
		return javalogTraceInferenceStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavalogTraceInferenceStrategy_PrologCode() {
		return (EAttribute)javalogTraceInferenceStrategyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavalogtraceFactory getJavalogtraceFactory() {
		return (JavalogtraceFactory)getEFactoryInstance();
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
		javalogTraceInferenceStrategyEClass = createEClass(JAVALOG_TRACE_INFERENCE_STRATEGY);
		createEAttribute(javalogTraceInferenceStrategyEClass, JAVALOG_TRACE_INFERENCE_STRATEGY__PROLOG_CODE);
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

		// Obtain other dependent packages
		ExecutionstatePackageImpl theExecutionstatePackage = (ExecutionstatePackageImpl)EPackage.Registry.INSTANCE.getEPackage(ExecutionstatePackage.eNS_URI);

		// Add supertypes to classes
		javalogTraceInferenceStrategyEClass.getESuperTypes().add(theExecutionstatePackage.getTraceInferenceStrategy());

		// Initialize classes and features; add operations and parameters
		initEClass(javalogTraceInferenceStrategyEClass, JavalogTraceInferenceStrategy.class, "JavalogTraceInferenceStrategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavalogTraceInferenceStrategy_PrologCode(), ecorePackage.getEString(), "prologCode", "executionState('Faulty') :- executionTag(T), isExitError(T). executionState('Executed') :- executionTag(_). executionState('NotExecuted').", 0, 1, JavalogTraceInferenceStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //JavalogtracePackageImpl
