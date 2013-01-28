/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExecutionstatePackageImpl.java,v 1.22 2006/07/04 12:42:19 mblech Exp $
 */
package org.isistan.flabot.engine.executionstate.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.impl.CoremodelPackageImpl;
import org.isistan.flabot.edit.componentmodel.impl.ComponentmodelPackageImpl;
import org.isistan.flabot.edit.editormodel.impl.EditormodelPackageImpl;
import org.isistan.flabot.edit.ucmmodel.impl.UcmmodelPackageImpl;
import org.isistan.flabot.engine.executionstate.BasicMappingBasedFilter;
import org.isistan.flabot.engine.executionstate.Diagnostic;
import org.isistan.flabot.engine.executionstate.ExecutionState;
import org.isistan.flabot.engine.executionstate.ExecutionstateFactory;
import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;
import org.isistan.flabot.engine.executionstate.GeneralLogFilterStrategy;
import org.isistan.flabot.engine.executionstate.ManualStateDeterminationStrategy;
import org.isistan.flabot.engine.executionstate.ManualTraceInferenceStrategy;
import org.isistan.flabot.engine.executionstate.MappingBasedFilter;
import org.isistan.flabot.engine.executionstate.OrFilter;
import org.isistan.flabot.engine.executionstate.PrologProviderStrategy;
import org.isistan.flabot.engine.executionstate.SimpleGeneralLogFilterStrategy;
import org.isistan.flabot.engine.executionstate.SimplePrologProviderStrategy;
import org.isistan.flabot.engine.executionstate.SimpleTraceInferenceStrategy;
import org.isistan.flabot.engine.executionstate.StateDeterminationStrategy;
import org.isistan.flabot.engine.executionstate.StateDeterminationStrategyRegistry;
import org.isistan.flabot.engine.executionstate.StateFromMappingStateDeterminationStrategy;
import org.isistan.flabot.engine.executionstate.TraceBasedStateDeterminationStrategy;
import org.isistan.flabot.engine.executionstate.TraceInferenceStrategy;
import org.isistan.flabot.engine.executionstate.javalogtrace.JavalogtracePackage;
import org.isistan.flabot.engine.executionstate.javalogtrace.impl.JavalogtracePackageImpl;
import org.isistan.flabot.executionmodel.ExecutionmodelPackage;
import org.isistan.flabot.executionmodel.impl.ExecutionmodelPackageImpl;
import org.isistan.flabot.launcher.filter.filtermodel.FiltermodelPackage;
import org.isistan.flabot.launcher.filter.filtermodel.impl.FiltermodelPackageImpl;
import org.isistan.flabot.mapping.mappingmodel.MappingmodelPackage;
import org.isistan.flabot.mapping.mappingmodel.impl.MappingmodelPackageImpl;
import org.isistan.flabot.trace.config.ConfigPackage;
import org.isistan.flabot.trace.config.impl.ConfigPackageImpl;
import org.isistan.flabot.trace.log.impl.LogPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExecutionstatePackageImpl extends EPackageImpl implements ExecutionstatePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicMappingBasedFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagnosticEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass manualStateDeterminationStrategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass manualTraceInferenceStrategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingBasedFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleTraceInferenceStrategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateDeterminationStrategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateDeterminationStrategyRegistryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceBasedStateDeterminationStrategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceInferenceStrategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass responsibilityToStateDeterminationStrategyMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eStringToEJavaObjectMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateFromMappingStateDeterminationStrategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass prologProviderStrategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simplePrologProviderStrategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generalLogFilterStrategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleGeneralLogFilterStrategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum executionStateEEnum = null;

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
	 * @see org.isistan.flabot.engine.executionstate.ExecutionstatePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExecutionstatePackageImpl() {
		super(eNS_URI, ExecutionstateFactory.eINSTANCE);
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
	public static ExecutionstatePackage init() {
		if (isInited) return (ExecutionstatePackage)EPackage.Registry.INSTANCE.getEPackage(ExecutionstatePackage.eNS_URI);

		// Obtain or create and register package
		ExecutionstatePackageImpl theExecutionstatePackage = (ExecutionstatePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ExecutionstatePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ExecutionstatePackageImpl());

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
		
		// Obtain or create and register interdependencies
		JavalogtracePackageImpl theJavalogtracePackage = (JavalogtracePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(JavalogtracePackage.eNS_URI) instanceof JavalogtracePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(JavalogtracePackage.eNS_URI) : JavalogtracePackage.eINSTANCE);
		ExecutionmodelPackageImpl theExecutionmodelPackage = (ExecutionmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExecutionmodelPackage.eNS_URI) instanceof ExecutionmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExecutionmodelPackage.eNS_URI) : ExecutionmodelPackage.eINSTANCE);

		// Create package meta-data objects
		theExecutionstatePackage.createPackageContents();
		theJavalogtracePackage.createPackageContents();
		theExecutionmodelPackage.createPackageContents();
		// Initialize created meta-data
		theExecutionstatePackage.initializePackageContents();
		theJavalogtracePackage.initializePackageContents();
		theExecutionmodelPackage.initializePackageContents();
		
		// Mark meta-data to indicate it can't be changed
		theExecutionstatePackage.freeze();

		return theExecutionstatePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicMappingBasedFilter() {
		return basicMappingBasedFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiagnostic() {
		return diagnosticEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiagnostic_Diagnostician() {
		return (EReference)diagnosticEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiagnostic_Description() {
		return (EAttribute)diagnosticEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiagnostic_AdditionalData() {
		return (EReference)diagnosticEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiagnostic_State() {
		return (EAttribute)diagnosticEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getManualStateDeterminationStrategy() {
		return manualStateDeterminationStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getManualTraceInferenceStrategy() {
		return manualTraceInferenceStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingBasedFilter() {
		return mappingBasedFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingBasedFilter_Mapping() {
		return (EReference)mappingBasedFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingBasedFilter_LogFilter() {
		return (EReference)mappingBasedFilterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleTraceInferenceStrategy() {
		return simpleTraceInferenceStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateDeterminationStrategy() {
		return stateDeterminationStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateDeterminationStrategy_Responsibility() {
		return (EReference)stateDeterminationStrategyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateDeterminationStrategyRegistry() {
		return stateDeterminationStrategyRegistryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateDeterminationStrategyRegistry_Registry() {
		return (EReference)stateDeterminationStrategyRegistryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceBasedStateDeterminationStrategy() {
		return traceBasedStateDeterminationStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceBasedStateDeterminationStrategy_TraceInferenceStrategy() {
		return (EReference)traceBasedStateDeterminationStrategyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceInferenceStrategy() {
		return traceInferenceStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceInferenceStrategy_StateDeterminationStrategy() {
		return (EReference)traceInferenceStrategyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResponsibilityToStateDeterminationStrategyMapEntry() {
		return responsibilityToStateDeterminationStrategyMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponsibilityToStateDeterminationStrategyMapEntry_Key() {
		return (EReference)responsibilityToStateDeterminationStrategyMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponsibilityToStateDeterminationStrategyMapEntry_Value() {
		return (EReference)responsibilityToStateDeterminationStrategyMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEStringToEJavaObjectMapEntry() {
		return eStringToEJavaObjectMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEStringToEJavaObjectMapEntry_Key() {
		return (EAttribute)eStringToEJavaObjectMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEStringToEJavaObjectMapEntry_Value() {
		return (EAttribute)eStringToEJavaObjectMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateFromMappingStateDeterminationStrategy() {
		return stateFromMappingStateDeterminationStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrFilter() {
		return orFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOrFilter_CombinedFilters() {
		return (EReference)orFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrologProviderStrategy() {
		return prologProviderStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimplePrologProviderStrategy() {
		return simplePrologProviderStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneralLogFilterStrategy() {
		return generalLogFilterStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleGeneralLogFilterStrategy() {
		return simpleGeneralLogFilterStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleGeneralLogFilterStrategy_PrologCodeText() {
		return (EAttribute)simpleGeneralLogFilterStrategyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getExecutionState() {
		return executionStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionstateFactory getExecutionstateFactory() {
		return (ExecutionstateFactory)getEFactoryInstance();
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
		basicMappingBasedFilterEClass = createEClass(BASIC_MAPPING_BASED_FILTER);

		diagnosticEClass = createEClass(DIAGNOSTIC);
		createEReference(diagnosticEClass, DIAGNOSTIC__DIAGNOSTICIAN);
		createEAttribute(diagnosticEClass, DIAGNOSTIC__DESCRIPTION);
		createEReference(diagnosticEClass, DIAGNOSTIC__ADDITIONAL_DATA);
		createEAttribute(diagnosticEClass, DIAGNOSTIC__STATE);

		manualStateDeterminationStrategyEClass = createEClass(MANUAL_STATE_DETERMINATION_STRATEGY);

		manualTraceInferenceStrategyEClass = createEClass(MANUAL_TRACE_INFERENCE_STRATEGY);

		mappingBasedFilterEClass = createEClass(MAPPING_BASED_FILTER);
		createEReference(mappingBasedFilterEClass, MAPPING_BASED_FILTER__MAPPING);
		createEReference(mappingBasedFilterEClass, MAPPING_BASED_FILTER__LOG_FILTER);

		simpleTraceInferenceStrategyEClass = createEClass(SIMPLE_TRACE_INFERENCE_STRATEGY);

		stateDeterminationStrategyEClass = createEClass(STATE_DETERMINATION_STRATEGY);
		createEReference(stateDeterminationStrategyEClass, STATE_DETERMINATION_STRATEGY__RESPONSIBILITY);

		stateDeterminationStrategyRegistryEClass = createEClass(STATE_DETERMINATION_STRATEGY_REGISTRY);
		createEReference(stateDeterminationStrategyRegistryEClass, STATE_DETERMINATION_STRATEGY_REGISTRY__REGISTRY);

		traceBasedStateDeterminationStrategyEClass = createEClass(TRACE_BASED_STATE_DETERMINATION_STRATEGY);
		createEReference(traceBasedStateDeterminationStrategyEClass, TRACE_BASED_STATE_DETERMINATION_STRATEGY__TRACE_INFERENCE_STRATEGY);

		traceInferenceStrategyEClass = createEClass(TRACE_INFERENCE_STRATEGY);
		createEReference(traceInferenceStrategyEClass, TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY);

		responsibilityToStateDeterminationStrategyMapEntryEClass = createEClass(RESPONSIBILITY_TO_STATE_DETERMINATION_STRATEGY_MAP_ENTRY);
		createEReference(responsibilityToStateDeterminationStrategyMapEntryEClass, RESPONSIBILITY_TO_STATE_DETERMINATION_STRATEGY_MAP_ENTRY__KEY);
		createEReference(responsibilityToStateDeterminationStrategyMapEntryEClass, RESPONSIBILITY_TO_STATE_DETERMINATION_STRATEGY_MAP_ENTRY__VALUE);

		eStringToEJavaObjectMapEntryEClass = createEClass(ESTRING_TO_EJAVA_OBJECT_MAP_ENTRY);
		createEAttribute(eStringToEJavaObjectMapEntryEClass, ESTRING_TO_EJAVA_OBJECT_MAP_ENTRY__KEY);
		createEAttribute(eStringToEJavaObjectMapEntryEClass, ESTRING_TO_EJAVA_OBJECT_MAP_ENTRY__VALUE);

		stateFromMappingStateDeterminationStrategyEClass = createEClass(STATE_FROM_MAPPING_STATE_DETERMINATION_STRATEGY);

		orFilterEClass = createEClass(OR_FILTER);
		createEReference(orFilterEClass, OR_FILTER__COMBINED_FILTERS);

		prologProviderStrategyEClass = createEClass(PROLOG_PROVIDER_STRATEGY);

		simplePrologProviderStrategyEClass = createEClass(SIMPLE_PROLOG_PROVIDER_STRATEGY);

		generalLogFilterStrategyEClass = createEClass(GENERAL_LOG_FILTER_STRATEGY);

		simpleGeneralLogFilterStrategyEClass = createEClass(SIMPLE_GENERAL_LOG_FILTER_STRATEGY);
		createEAttribute(simpleGeneralLogFilterStrategyEClass, SIMPLE_GENERAL_LOG_FILTER_STRATEGY__PROLOG_CODE_TEXT);

		// Create enums
		executionStateEEnum = createEEnum(EXECUTION_STATE);
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
		ConfigPackageImpl theConfigPackage = (ConfigPackageImpl)EPackage.Registry.INSTANCE.getEPackage(ConfigPackage.eNS_URI);
		MappingmodelPackageImpl theMappingmodelPackage = (MappingmodelPackageImpl)EPackage.Registry.INSTANCE.getEPackage(MappingmodelPackage.eNS_URI);
		FiltermodelPackageImpl theFiltermodelPackage = (FiltermodelPackageImpl)EPackage.Registry.INSTANCE.getEPackage(FiltermodelPackage.eNS_URI);
		CoremodelPackageImpl theCoremodelPackage = (CoremodelPackageImpl)EPackage.Registry.INSTANCE.getEPackage(CoremodelPackage.eNS_URI);

		// Add supertypes to classes
		basicMappingBasedFilterEClass.getESuperTypes().add(this.getMappingBasedFilter());
		manualStateDeterminationStrategyEClass.getESuperTypes().add(this.getStateDeterminationStrategy());
		manualTraceInferenceStrategyEClass.getESuperTypes().add(this.getTraceInferenceStrategy());
		mappingBasedFilterEClass.getESuperTypes().add(theConfigPackage.getFilter());
		simpleTraceInferenceStrategyEClass.getESuperTypes().add(this.getTraceInferenceStrategy());
		stateDeterminationStrategyEClass.getESuperTypes().add(theCoremodelPackage.getRegistrable());
		traceBasedStateDeterminationStrategyEClass.getESuperTypes().add(this.getStateDeterminationStrategy());
		stateFromMappingStateDeterminationStrategyEClass.getESuperTypes().add(this.getStateDeterminationStrategy());
		orFilterEClass.getESuperTypes().add(theConfigPackage.getFilter());
		simplePrologProviderStrategyEClass.getESuperTypes().add(this.getPrologProviderStrategy());
		simpleGeneralLogFilterStrategyEClass.getESuperTypes().add(this.getGeneralLogFilterStrategy());

		// Initialize classes and features; add operations and parameters
		initEClass(basicMappingBasedFilterEClass, BasicMappingBasedFilter.class, "BasicMappingBasedFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(diagnosticEClass, Diagnostic.class, "Diagnostic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDiagnostic_Diagnostician(), this.getStateDeterminationStrategy(), null, "diagnostician", null, 0, 1, Diagnostic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagnostic_Description(), ecorePackage.getEString(), "description", null, 0, 1, Diagnostic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiagnostic_AdditionalData(), this.getEStringToEJavaObjectMapEntry(), null, "additionalData", null, 0, -1, Diagnostic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagnostic_State(), this.getExecutionState(), "state", null, 0, 1, Diagnostic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(manualStateDeterminationStrategyEClass, ManualStateDeterminationStrategy.class, "ManualStateDeterminationStrategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(manualTraceInferenceStrategyEClass, ManualTraceInferenceStrategy.class, "ManualTraceInferenceStrategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingBasedFilterEClass, MappingBasedFilter.class, "MappingBasedFilter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingBasedFilter_Mapping(), theMappingmodelPackage.getMapping(), null, "mapping", null, 0, 1, MappingBasedFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingBasedFilter_LogFilter(), theFiltermodelPackage.getLogFilter(), null, "logFilter", null, 0, 1, MappingBasedFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleTraceInferenceStrategyEClass, SimpleTraceInferenceStrategy.class, "SimpleTraceInferenceStrategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stateDeterminationStrategyEClass, StateDeterminationStrategy.class, "StateDeterminationStrategy", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateDeterminationStrategy_Responsibility(), theCoremodelPackage.getResponsibility(), null, "responsibility", null, 0, 1, StateDeterminationStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateDeterminationStrategyRegistryEClass, StateDeterminationStrategyRegistry.class, "StateDeterminationStrategyRegistry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateDeterminationStrategyRegistry_Registry(), this.getResponsibilityToStateDeterminationStrategyMapEntry(), null, "registry", null, 0, -1, StateDeterminationStrategyRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(traceBasedStateDeterminationStrategyEClass, TraceBasedStateDeterminationStrategy.class, "TraceBasedStateDeterminationStrategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTraceBasedStateDeterminationStrategy_TraceInferenceStrategy(), this.getTraceInferenceStrategy(), this.getTraceInferenceStrategy_StateDeterminationStrategy(), "traceInferenceStrategy", null, 0, 1, TraceBasedStateDeterminationStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(traceInferenceStrategyEClass, TraceInferenceStrategy.class, "TraceInferenceStrategy", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTraceInferenceStrategy_StateDeterminationStrategy(), this.getTraceBasedStateDeterminationStrategy(), this.getTraceBasedStateDeterminationStrategy_TraceInferenceStrategy(), "stateDeterminationStrategy", null, 0, 1, TraceInferenceStrategy.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(responsibilityToStateDeterminationStrategyMapEntryEClass, Map.Entry.class, "ResponsibilityToStateDeterminationStrategyMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResponsibilityToStateDeterminationStrategyMapEntry_Key(), theCoremodelPackage.getResponsibility(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResponsibilityToStateDeterminationStrategyMapEntry_Value(), this.getStateDeterminationStrategy(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eStringToEJavaObjectMapEntryEClass, Map.Entry.class, "EStringToEJavaObjectMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEStringToEJavaObjectMapEntry_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEStringToEJavaObjectMapEntry_Value(), ecorePackage.getEJavaObject(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateFromMappingStateDeterminationStrategyEClass, StateFromMappingStateDeterminationStrategy.class, "StateFromMappingStateDeterminationStrategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orFilterEClass, OrFilter.class, "OrFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOrFilter_CombinedFilters(), theConfigPackage.getFilter(), null, "combinedFilters", null, 0, -1, OrFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(prologProviderStrategyEClass, PrologProviderStrategy.class, "PrologProviderStrategy", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(simplePrologProviderStrategyEClass, SimplePrologProviderStrategy.class, "SimplePrologProviderStrategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(generalLogFilterStrategyEClass, GeneralLogFilterStrategy.class, "GeneralLogFilterStrategy", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(simpleGeneralLogFilterStrategyEClass, SimpleGeneralLogFilterStrategy.class, "SimpleGeneralLogFilterStrategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimpleGeneralLogFilterStrategy_PrologCodeText(), ecorePackage.getEString(), "prologCodeText", null, 0, 1, SimpleGeneralLogFilterStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(executionStateEEnum, ExecutionState.class, "ExecutionState");
		addEEnumLiteral(executionStateEEnum, ExecutionState.EXECUTED_LITERAL);
		addEEnumLiteral(executionStateEEnum, ExecutionState.FAULTY_LITERAL);
		addEEnumLiteral(executionStateEEnum, ExecutionState.NOT_EXECUTED_LITERAL);
		addEEnumLiteral(executionStateEEnum, ExecutionState.NO_ACTION_STATE_LITERAL);
		addEEnumLiteral(executionStateEEnum, ExecutionState.FAULTY_CURRENT_LITERAL);
		addEEnumLiteral(executionStateEEnum, ExecutionState.FAULTY_CONSTRAIN_LITERAL);
		addEEnumLiteral(executionStateEEnum, ExecutionState.FAULTY_PREVIOUS_LITERAL);
		addEEnumLiteral(executionStateEEnum, ExecutionState.FAULTY_PRECONDITION_LITERAL);
		addEEnumLiteral(executionStateEEnum, ExecutionState.FAULTY_PATH_LITERAL);
		addEEnumLiteral(executionStateEEnum, ExecutionState.FAULTY_NEXT_LEVELS_LITERAL);
		addEEnumLiteral(executionStateEEnum, ExecutionState.FAULTY_CONSTRAINT_START_LITERAL);
		addEEnumLiteral(executionStateEEnum, ExecutionState.PROBABLY_FAULTY_LITERAL);
		addEEnumLiteral(executionStateEEnum, ExecutionState.UNCERTAIN_LITERAL);
		addEEnumLiteral(executionStateEEnum, ExecutionState.MULTIPLE_ERRORS_LITERAL);
		addEEnumLiteral(executionStateEEnum, ExecutionState.STATE_FROM_MAPPING_LITERAL);

		// Create resource
		createResource(eNS_URI);
	}

} //ExecutionstatePackageImpl
