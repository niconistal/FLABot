/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.strategymodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;
import org.isistan.flabot.executionstatemapping.model.ModelPackage;
import org.isistan.flabot.executionstatemapping.model.impl.ModelPackageImpl;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologPackage;
import org.isistan.flabot.executionstatemapping.model.prolog.impl.PrologPackageImpl;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;
import org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl;
import org.isistan.flabot.executionstatemapping.model.strategymodel.ExecutionConditionGeneralLogFilterStrategy;
import org.isistan.flabot.executionstatemapping.model.strategymodel.SimpleExecutionConditionTraceInferenceStrategy;
import org.isistan.flabot.executionstatemapping.model.strategymodel.StateDiagramTraceInferenceStrategy;
import org.isistan.flabot.executionstatemapping.model.strategymodel.StrategymodelFactory;
import org.isistan.flabot.executionstatemapping.model.strategymodel.StrategymodelPackage;
import org.isistan.flabot.executionstatemapping.model.visual.VisualPackage;
import org.isistan.flabot.executionstatemapping.model.visual.impl.VisualPackageImpl;
import org.isistan.flabot.launcher.filter.filtermodel.FiltermodelPackage;
import org.isistan.flabot.mapping.mappingmodel.MappingmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StrategymodelPackageImpl extends EPackageImpl implements StrategymodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateDiagramTraceInferenceStrategyEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleExecutionConditionTraceInferenceStrategyEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionConditionGeneralLogFilterStrategyEClass = null;
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
	 * @see org.isistan.flabot.executionstatemapping.model.strategymodel.StrategymodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StrategymodelPackageImpl() {
		super(eNS_URI, StrategymodelFactory.eINSTANCE);
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
	public static StrategymodelPackage init() {
		if (isInited) return (StrategymodelPackage)EPackage.Registry.INSTANCE.getEPackage(StrategymodelPackage.eNS_URI);

		// Obtain or create and register package
		StrategymodelPackageImpl theStrategymodelPackage = (StrategymodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof StrategymodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new StrategymodelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ExecutionstatePackage.eINSTANCE.eClass();
		EditormodelPackage.eINSTANCE.eClass();
		CoremodelPackage.eINSTANCE.eClass();
		FiltermodelPackage.eINSTANCE.eClass();
		MappingmodelPackage.eINSTANCE.eClass();
		//ConfigPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
		VisualPackageImpl theVisualPackage = (VisualPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(VisualPackage.eNS_URI) instanceof VisualPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(VisualPackage.eNS_URI) : VisualPackage.eINSTANCE);
		SemanticPackageImpl theSemanticPackage = (SemanticPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI) instanceof SemanticPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI) : SemanticPackage.eINSTANCE);
		PrologPackageImpl thePackage = (PrologPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PrologPackage.eNS_URI) instanceof PrologPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PrologPackage.eNS_URI) : PrologPackage.eINSTANCE);

		// Create package meta-data objects
		theStrategymodelPackage.createPackageContents();
		theModelPackage.createPackageContents();
		theVisualPackage.createPackageContents();
		theSemanticPackage.createPackageContents();
		thePackage.createPackageContents();

		// Initialize created meta-data
		theStrategymodelPackage.initializePackageContents();
		theModelPackage.initializePackageContents();
		theVisualPackage.initializePackageContents();
		theSemanticPackage.initializePackageContents();
		thePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theStrategymodelPackage.freeze();

		return theStrategymodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateDiagramTraceInferenceStrategy() {
		return stateDiagramTraceInferenceStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateDiagramTraceInferenceStrategy_StateContainer() {
		return (EReference)stateDiagramTraceInferenceStrategyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleExecutionConditionTraceInferenceStrategy() {
		return simpleExecutionConditionTraceInferenceStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleExecutionConditionTraceInferenceStrategy_SimpleExecutionConditionConfiguration() {
		return (EReference)simpleExecutionConditionTraceInferenceStrategyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutionConditionGeneralLogFilterStrategy() {
		return executionConditionGeneralLogFilterStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionConditionGeneralLogFilterStrategy_SimpleExecutionConditionConfiguration() {
		return (EReference)executionConditionGeneralLogFilterStrategyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrategymodelFactory getStrategymodelFactory() {
		return (StrategymodelFactory)getEFactoryInstance();
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
		stateDiagramTraceInferenceStrategyEClass = createEClass(STATE_DIAGRAM_TRACE_INFERENCE_STRATEGY);
		createEReference(stateDiagramTraceInferenceStrategyEClass, STATE_DIAGRAM_TRACE_INFERENCE_STRATEGY__STATE_CONTAINER);

		simpleExecutionConditionTraceInferenceStrategyEClass = createEClass(SIMPLE_EXECUTION_CONDITION_TRACE_INFERENCE_STRATEGY);
		createEReference(simpleExecutionConditionTraceInferenceStrategyEClass, SIMPLE_EXECUTION_CONDITION_TRACE_INFERENCE_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION);

		executionConditionGeneralLogFilterStrategyEClass = createEClass(EXECUTION_CONDITION_GENERAL_LOG_FILTER_STRATEGY);
		createEReference(executionConditionGeneralLogFilterStrategyEClass, EXECUTION_CONDITION_GENERAL_LOG_FILTER_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION);
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
		ExecutionstatePackage theExecutionstatePackage = (ExecutionstatePackage)EPackage.Registry.INSTANCE.getEPackage(ExecutionstatePackage.eNS_URI);
		SemanticPackage theSemanticPackage = (SemanticPackage)EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		stateDiagramTraceInferenceStrategyEClass.getESuperTypes().add(theExecutionstatePackage.getTraceInferenceStrategy());
		stateDiagramTraceInferenceStrategyEClass.getESuperTypes().add(theExecutionstatePackage.getPrologProviderStrategy());
		simpleExecutionConditionTraceInferenceStrategyEClass.getESuperTypes().add(theExecutionstatePackage.getTraceInferenceStrategy());
		simpleExecutionConditionTraceInferenceStrategyEClass.getESuperTypes().add(theExecutionstatePackage.getPrologProviderStrategy());
		executionConditionGeneralLogFilterStrategyEClass.getESuperTypes().add(theExecutionstatePackage.getGeneralLogFilterStrategy());

		// Initialize classes and features; add operations and parameters
		initEClass(stateDiagramTraceInferenceStrategyEClass, StateDiagramTraceInferenceStrategy.class, "StateDiagramTraceInferenceStrategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateDiagramTraceInferenceStrategy_StateContainer(), theSemanticPackage.getStateContainer(), null, "stateContainer", null, 0, 1, StateDiagramTraceInferenceStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleExecutionConditionTraceInferenceStrategyEClass, SimpleExecutionConditionTraceInferenceStrategy.class, "SimpleExecutionConditionTraceInferenceStrategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimpleExecutionConditionTraceInferenceStrategy_SimpleExecutionConditionConfiguration(), theSemanticPackage.getSimpleExecutionConditionConfiguration(), null, "simpleExecutionConditionConfiguration", null, 0, 1, SimpleExecutionConditionTraceInferenceStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(executionConditionGeneralLogFilterStrategyEClass, ExecutionConditionGeneralLogFilterStrategy.class, "ExecutionConditionGeneralLogFilterStrategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutionConditionGeneralLogFilterStrategy_SimpleExecutionConditionConfiguration(), theSemanticPackage.getSimpleExecutionConditionConfiguration(), null, "simpleExecutionConditionConfiguration", null, 0, 1, ExecutionConditionGeneralLogFilterStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //StrategymodelPackageImpl
