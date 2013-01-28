/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExecutionmodelPackageImpl.java,v 1.24 2006/04/11 04:21:27 apersson Exp $
 */
package org.isistan.flabot.executionmodel.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.impl.CoremodelPackageImpl;
import org.isistan.flabot.edit.componentmodel.impl.ComponentmodelPackageImpl;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.impl.EditormodelPackageImpl;
import org.isistan.flabot.edit.ucmmodel.impl.UcmmodelPackageImpl;
import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;
import org.isistan.flabot.engine.executionstate.impl.ExecutionstatePackageImpl;
import org.isistan.flabot.engine.executionstate.javalogtrace.JavalogtracePackage;
import org.isistan.flabot.engine.executionstate.javalogtrace.impl.JavalogtracePackageImpl;
import org.isistan.flabot.executionmodel.Dependency;
import org.isistan.flabot.executionmodel.EvaluationStep;
import org.isistan.flabot.executionmodel.ExecutionContext;
import org.isistan.flabot.executionmodel.ExecutionInfo;
import org.isistan.flabot.executionmodel.ExecutionInfoManager;
import org.isistan.flabot.executionmodel.ExecutionStep;
import org.isistan.flabot.executionmodel.ExecutionmodelFactory;
import org.isistan.flabot.executionmodel.ExecutionmodelPackage;
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
public class ExecutionmodelPackageImpl extends EPackageImpl implements ExecutionmodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionInfoManagerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass responsibilityNodeToExecutionStateMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adapterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eStringToEObjectMapEntryEClass = null;

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
	private EClass simplePathNodeToExecutionStateMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evaluationStepEClass = null;

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
	 * @see org.isistan.flabot.executionmodel.ExecutionmodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExecutionmodelPackageImpl() {
		super(eNS_URI, ExecutionmodelFactory.eINSTANCE);
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
	public static ExecutionmodelPackage init() {
		if (isInited) return (ExecutionmodelPackage)EPackage.Registry.INSTANCE.getEPackage(ExecutionmodelPackage.eNS_URI);

		// Obtain or create and register package
		ExecutionmodelPackageImpl theExecutionmodelPackage = (ExecutionmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ExecutionmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ExecutionmodelPackageImpl());

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
		JavalogtracePackageImpl theJavalogtracePackage = (JavalogtracePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(JavalogtracePackage.eNS_URI) instanceof JavalogtracePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(JavalogtracePackage.eNS_URI) : JavalogtracePackage.eINSTANCE);
		ExecutionstatePackageImpl theExecutionstatePackage = (ExecutionstatePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExecutionstatePackage.eNS_URI) instanceof ExecutionstatePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExecutionstatePackage.eNS_URI) : ExecutionstatePackage.eINSTANCE);

		// Create package meta-data objects
		theExecutionmodelPackage.createPackageContents();
		theJavalogtracePackage.createPackageContents();
		theExecutionstatePackage.createPackageContents();

		// Initialize created meta-data
		theExecutionmodelPackage.initializePackageContents();
		theJavalogtracePackage.initializePackageContents();
		theExecutionstatePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExecutionmodelPackage.freeze();

		return theExecutionmodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutionInfo() {
		return executionInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionInfo_ExecutionSteps() {
		return (EReference)executionInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutionInfoManager() {
		return executionInfoManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionInfoManager_Executions() {
		return (EReference)executionInfoManagerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionInfoManager_CurrentExecution() {
		return (EReference)executionInfoManagerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionInfoManager_FileModel() {
		return (EReference)executionInfoManagerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutionStep() {
		return executionStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionStep_Source() {
		return (EReference)executionStepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionStep_Target() {
		return (EReference)executionStepEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionStep_Dependency() {
		return (EReference)executionStepEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionStep_InstanceComponentToSource() {
		return (EReference)executionStepEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionStep_InstanceComponentToTarget() {
		return (EReference)executionStepEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionStep_DiagnosticToSource() {
		return (EReference)executionStepEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionStep_DiagnosticToTarget() {
		return (EReference)executionStepEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionStep_FinalState() {
		return (EAttribute)executionStepEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionStep_ExecutionContext() {
		return (EReference)executionStepEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionStep_Enabled() {
		return (EAttribute)executionStepEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResponsibilityNodeToExecutionStateMapEntry() {
		return responsibilityNodeToExecutionStateMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponsibilityNodeToExecutionStateMapEntry_Key() {
		return (EReference)responsibilityNodeToExecutionStateMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResponsibilityNodeToExecutionStateMapEntry_Value() {
		return (EAttribute)responsibilityNodeToExecutionStateMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependency() {
		return dependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependency_Event() {
		return (EAttribute)dependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependency_Type() {
		return (EAttribute)dependencyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdapter() {
		return adapterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutionContext() {
		return executionContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionContext_CurrentResponsibility() {
		return (EReference)executionContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionContext_PreResponsibility() {
		return (EReference)executionContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionContext_CurrentStep() {
		return (EAttribute)executionContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionContext_CurrentScenario() {
		return (EAttribute)executionContextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionContext_CurrentState() {
		return (EAttribute)executionContextEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionContext_Dependencies() {
		return (EAttribute)executionContextEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionContext_CurrentFamily() {
		return (EAttribute)executionContextEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionContext_Family() {
		return (EAttribute)executionContextEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionContext_CurrentTypeDependency() {
		return (EAttribute)executionContextEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionContext_CurrentDependency() {
		return (EAttribute)executionContextEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionContext_CurrentAnalizeDependency() {
		return (EAttribute)executionContextEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionContext_Event() {
		return (EAttribute)executionContextEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionContext_PrologKnowledge() {
		return (EAttribute)executionContextEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionContext_CurrentLogicModule() {
		return (EAttribute)executionContextEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionContext_ResponsibilityToExecute() {
		return (EReference)executionContextEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionContext_MappingFamily() {
		return (EAttribute)executionContextEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionContext_LastMappingFamily() {
		return (EAttribute)executionContextEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionContext_StubNode() {
		return (EReference)executionContextEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionContext_StartNodeToStub() {
		return (EReference)executionContextEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionContext_EndNodeToStub() {
		return (EReference)executionContextEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionContext_ResponsibilityToStub() {
		return (EReference)executionContextEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionContext_PreResponsibilityToStub() {
		return (EReference)executionContextEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionContext_StopStep() {
		return (EAttribute)executionContextEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionContext_InstanceComponentToSource() {
		return (EReference)executionContextEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionContext_InstanceComponentToTarget() {
		return (EReference)executionContextEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionContext_ResponsibilityToJoin() {
		return (EReference)executionContextEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionContext_PreResponsibilityToJoin() {
		return (EReference)executionContextEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionContext_BranchJoin() {
		return (EReference)executionContextEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionContext_Enabled() {
		return (EAttribute)executionContextEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEStringToEObjectMapEntry() {
		return eStringToEObjectMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEStringToEObjectMapEntry_Key() {
		return (EAttribute)eStringToEObjectMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEStringToEObjectMapEntry_Value() {
		return (EReference)eStringToEObjectMapEntryEClass.getEStructuralFeatures().get(1);
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
	public EClass getSimplePathNodeToExecutionStateMapEntry() {
		return simplePathNodeToExecutionStateMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimplePathNodeToExecutionStateMapEntry_Key() {
		return (EReference)simplePathNodeToExecutionStateMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimplePathNodeToExecutionStateMapEntry_Value() {
		return (EAttribute)simplePathNodeToExecutionStateMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvaluationStep() {
		return evaluationStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvaluationStep_Source() {
		return (EReference)evaluationStepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvaluationStep_Target() {
		return (EReference)evaluationStepEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvaluationStep_CurrentFamily() {
		return (EAttribute)evaluationStepEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvaluationStep_Condition() {
		return (EAttribute)evaluationStepEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionmodelFactory getExecutionmodelFactory() {
		return (ExecutionmodelFactory)getEFactoryInstance();
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
		executionInfoEClass = createEClass(EXECUTION_INFO);
		createEReference(executionInfoEClass, EXECUTION_INFO__EXECUTION_STEPS);

		executionInfoManagerEClass = createEClass(EXECUTION_INFO_MANAGER);
		createEReference(executionInfoManagerEClass, EXECUTION_INFO_MANAGER__EXECUTIONS);
		createEReference(executionInfoManagerEClass, EXECUTION_INFO_MANAGER__CURRENT_EXECUTION);
		createEReference(executionInfoManagerEClass, EXECUTION_INFO_MANAGER__FILE_MODEL);

		executionStepEClass = createEClass(EXECUTION_STEP);
		createEReference(executionStepEClass, EXECUTION_STEP__SOURCE);
		createEReference(executionStepEClass, EXECUTION_STEP__TARGET);
		createEReference(executionStepEClass, EXECUTION_STEP__DEPENDENCY);
		createEReference(executionStepEClass, EXECUTION_STEP__INSTANCE_COMPONENT_TO_SOURCE);
		createEReference(executionStepEClass, EXECUTION_STEP__INSTANCE_COMPONENT_TO_TARGET);
		createEReference(executionStepEClass, EXECUTION_STEP__DIAGNOSTIC_TO_SOURCE);
		createEReference(executionStepEClass, EXECUTION_STEP__DIAGNOSTIC_TO_TARGET);
		createEAttribute(executionStepEClass, EXECUTION_STEP__FINAL_STATE);
		createEReference(executionStepEClass, EXECUTION_STEP__EXECUTION_CONTEXT);
		createEAttribute(executionStepEClass, EXECUTION_STEP__ENABLED);

		responsibilityNodeToExecutionStateMapEntryEClass = createEClass(RESPONSIBILITY_NODE_TO_EXECUTION_STATE_MAP_ENTRY);
		createEReference(responsibilityNodeToExecutionStateMapEntryEClass, RESPONSIBILITY_NODE_TO_EXECUTION_STATE_MAP_ENTRY__KEY);
		createEAttribute(responsibilityNodeToExecutionStateMapEntryEClass, RESPONSIBILITY_NODE_TO_EXECUTION_STATE_MAP_ENTRY__VALUE);

		dependencyEClass = createEClass(DEPENDENCY);
		createEAttribute(dependencyEClass, DEPENDENCY__EVENT);
		createEAttribute(dependencyEClass, DEPENDENCY__TYPE);

		adapterEClass = createEClass(ADAPTER);

		executionContextEClass = createEClass(EXECUTION_CONTEXT);
		createEReference(executionContextEClass, EXECUTION_CONTEXT__CURRENT_RESPONSIBILITY);
		createEReference(executionContextEClass, EXECUTION_CONTEXT__PRE_RESPONSIBILITY);
		createEAttribute(executionContextEClass, EXECUTION_CONTEXT__CURRENT_STEP);
		createEAttribute(executionContextEClass, EXECUTION_CONTEXT__CURRENT_SCENARIO);
		createEAttribute(executionContextEClass, EXECUTION_CONTEXT__CURRENT_STATE);
		createEAttribute(executionContextEClass, EXECUTION_CONTEXT__DEPENDENCIES);
		createEAttribute(executionContextEClass, EXECUTION_CONTEXT__CURRENT_FAMILY);
		createEAttribute(executionContextEClass, EXECUTION_CONTEXT__FAMILY);
		createEAttribute(executionContextEClass, EXECUTION_CONTEXT__CURRENT_TYPE_DEPENDENCY);
		createEAttribute(executionContextEClass, EXECUTION_CONTEXT__CURRENT_DEPENDENCY);
		createEAttribute(executionContextEClass, EXECUTION_CONTEXT__CURRENT_ANALIZE_DEPENDENCY);
		createEAttribute(executionContextEClass, EXECUTION_CONTEXT__EVENT);
		createEAttribute(executionContextEClass, EXECUTION_CONTEXT__PROLOG_KNOWLEDGE);
		createEAttribute(executionContextEClass, EXECUTION_CONTEXT__CURRENT_LOGIC_MODULE);
		createEReference(executionContextEClass, EXECUTION_CONTEXT__RESPONSIBILITY_TO_EXECUTE);
		createEAttribute(executionContextEClass, EXECUTION_CONTEXT__MAPPING_FAMILY);
		createEAttribute(executionContextEClass, EXECUTION_CONTEXT__LAST_MAPPING_FAMILY);
		createEReference(executionContextEClass, EXECUTION_CONTEXT__STUB_NODE);
		createEReference(executionContextEClass, EXECUTION_CONTEXT__START_NODE_TO_STUB);
		createEReference(executionContextEClass, EXECUTION_CONTEXT__END_NODE_TO_STUB);
		createEReference(executionContextEClass, EXECUTION_CONTEXT__RESPONSIBILITY_TO_STUB);
		createEReference(executionContextEClass, EXECUTION_CONTEXT__PRE_RESPONSIBILITY_TO_STUB);
		createEAttribute(executionContextEClass, EXECUTION_CONTEXT__STOP_STEP);
		createEReference(executionContextEClass, EXECUTION_CONTEXT__INSTANCE_COMPONENT_TO_SOURCE);
		createEReference(executionContextEClass, EXECUTION_CONTEXT__INSTANCE_COMPONENT_TO_TARGET);
		createEReference(executionContextEClass, EXECUTION_CONTEXT__RESPONSIBILITY_TO_JOIN);
		createEReference(executionContextEClass, EXECUTION_CONTEXT__PRE_RESPONSIBILITY_TO_JOIN);
		createEReference(executionContextEClass, EXECUTION_CONTEXT__BRANCH_JOIN);
		createEAttribute(executionContextEClass, EXECUTION_CONTEXT__ENABLED);

		eStringToEObjectMapEntryEClass = createEClass(ESTRING_TO_EOBJECT_MAP_ENTRY);
		createEAttribute(eStringToEObjectMapEntryEClass, ESTRING_TO_EOBJECT_MAP_ENTRY__KEY);
		createEReference(eStringToEObjectMapEntryEClass, ESTRING_TO_EOBJECT_MAP_ENTRY__VALUE);

		eStringToEJavaObjectMapEntryEClass = createEClass(ESTRING_TO_EJAVA_OBJECT_MAP_ENTRY);
		createEAttribute(eStringToEJavaObjectMapEntryEClass, ESTRING_TO_EJAVA_OBJECT_MAP_ENTRY__KEY);
		createEAttribute(eStringToEJavaObjectMapEntryEClass, ESTRING_TO_EJAVA_OBJECT_MAP_ENTRY__VALUE);

		simplePathNodeToExecutionStateMapEntryEClass = createEClass(SIMPLE_PATH_NODE_TO_EXECUTION_STATE_MAP_ENTRY);
		createEReference(simplePathNodeToExecutionStateMapEntryEClass, SIMPLE_PATH_NODE_TO_EXECUTION_STATE_MAP_ENTRY__KEY);
		createEAttribute(simplePathNodeToExecutionStateMapEntryEClass, SIMPLE_PATH_NODE_TO_EXECUTION_STATE_MAP_ENTRY__VALUE);

		evaluationStepEClass = createEClass(EVALUATION_STEP);
		createEReference(evaluationStepEClass, EVALUATION_STEP__SOURCE);
		createEReference(evaluationStepEClass, EVALUATION_STEP__TARGET);
		createEAttribute(evaluationStepEClass, EVALUATION_STEP__CURRENT_FAMILY);
		createEAttribute(evaluationStepEClass, EVALUATION_STEP__CONDITION);
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
		EditormodelPackageImpl theEditormodelPackage = (EditormodelPackageImpl)EPackage.Registry.INSTANCE.getEPackage(EditormodelPackage.eNS_URI);
		CoremodelPackageImpl theCoremodelPackage = (CoremodelPackageImpl)EPackage.Registry.INSTANCE.getEPackage(CoremodelPackage.eNS_URI);
		ExecutionstatePackageImpl theExecutionstatePackage = (ExecutionstatePackageImpl)EPackage.Registry.INSTANCE.getEPackage(ExecutionstatePackage.eNS_URI);

		// Add supertypes to classes
		executionInfoManagerEClass.getESuperTypes().add(this.getAdapter());

		// Initialize classes and features; add operations and parameters
		initEClass(executionInfoEClass, ExecutionInfo.class, "ExecutionInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutionInfo_ExecutionSteps(), this.getExecutionStep(), null, "executionSteps", null, 0, -1, ExecutionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(executionInfoManagerEClass, ExecutionInfoManager.class, "ExecutionInfoManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutionInfoManager_Executions(), this.getExecutionInfo(), null, "executions", null, 0, -1, ExecutionInfoManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionInfoManager_CurrentExecution(), this.getExecutionInfo(), null, "currentExecution", null, 0, 1, ExecutionInfoManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionInfoManager_FileModel(), theEditormodelPackage.getFlabotFileModel(), null, "fileModel", null, 0, 1, ExecutionInfoManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(executionStepEClass, ExecutionStep.class, "ExecutionStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutionStep_Source(), theCoremodelPackage.getSimplePathNode(), null, "source", null, 0, 1, ExecutionStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionStep_Target(), theCoremodelPackage.getSimplePathNode(), null, "target", null, 0, 1, ExecutionStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionStep_Dependency(), this.getDependency(), null, "dependency", null, 0, 1, ExecutionStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionStep_InstanceComponentToSource(), theCoremodelPackage.getComponentRole(), null, "instanceComponentToSource", null, 0, 1, ExecutionStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionStep_InstanceComponentToTarget(), theCoremodelPackage.getComponentRole(), null, "instanceComponentToTarget", null, 0, 1, ExecutionStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionStep_DiagnosticToSource(), theExecutionstatePackage.getDiagnostic(), null, "diagnosticToSource", null, 0, 1, ExecutionStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionStep_DiagnosticToTarget(), theExecutionstatePackage.getDiagnostic(), null, "diagnosticToTarget", null, 0, 1, ExecutionStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionStep_FinalState(), theExecutionstatePackage.getExecutionState(), "finalState", null, 0, 1, ExecutionStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionStep_ExecutionContext(), this.getExecutionContext(), null, "executionContext", null, 0, 1, ExecutionStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionStep_Enabled(), ecorePackage.getEInt(), "enabled", null, 0, 1, ExecutionStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(responsibilityNodeToExecutionStateMapEntryEClass, Map.Entry.class, "ResponsibilityNodeToExecutionStateMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResponsibilityNodeToExecutionStateMapEntry_Key(), theCoremodelPackage.getResponsibilityNode(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResponsibilityNodeToExecutionStateMapEntry_Value(), theExecutionstatePackage.getExecutionState(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dependencyEClass, Dependency.class, "Dependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDependency_Event(), ecorePackage.getEJavaObject(), "event", null, 0, 1, Dependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDependency_Type(), ecorePackage.getEString(), "type", null, 0, 1, Dependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adapterEClass, Adapter.class, "Adapter", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(executionContextEClass, ExecutionContext.class, "ExecutionContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutionContext_CurrentResponsibility(), theCoremodelPackage.getSimplePathNode(), null, "currentResponsibility", null, 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionContext_PreResponsibility(), theCoremodelPackage.getSimplePathNode(), null, "preResponsibility", null, 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionContext_CurrentStep(), ecorePackage.getEString(), "currentStep", "0", 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionContext_CurrentScenario(), ecorePackage.getEString(), "currentScenario", null, 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionContext_CurrentState(), ecorePackage.getEString(), "currentState", null, 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionContext_Dependencies(), ecorePackage.getEString(), "dependencies", null, 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionContext_CurrentFamily(), ecorePackage.getEString(), "currentFamily", "'Family'", 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionContext_Family(), ecorePackage.getEString(), "family", "Family", 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionContext_CurrentTypeDependency(), ecorePackage.getEString(), "currentTypeDependency", "[]", 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionContext_CurrentDependency(), ecorePackage.getEString(), "currentDependency", "[]", 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionContext_CurrentAnalizeDependency(), ecorePackage.getEString(), "currentAnalizeDependency", "DEFAULT_DEPENDENCY", 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionContext_Event(), ecorePackage.getEString(), "event", "Event", 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionContext_PrologKnowledge(), ecorePackage.getEString(), "prologKnowledge", "", 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionContext_CurrentLogicModule(), ecorePackage.getEString(), "currentLogicModule", null, 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionContext_ResponsibilityToExecute(), theCoremodelPackage.getSimplePathNode(), null, "responsibilityToExecute", null, 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionContext_MappingFamily(), ecorePackage.getEString(), "mappingFamily", null, 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionContext_LastMappingFamily(), ecorePackage.getEString(), "lastMappingFamily", null, 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionContext_StubNode(), theCoremodelPackage.getSimplePathNode(), null, "stubNode", null, 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionContext_StartNodeToStub(), theCoremodelPackage.getSimplePathNode(), null, "startNodeToStub", null, 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionContext_EndNodeToStub(), theCoremodelPackage.getSimplePathNode(), null, "endNodeToStub", null, 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionContext_ResponsibilityToStub(), theCoremodelPackage.getSimplePathNode(), null, "responsibilityToStub", null, 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionContext_PreResponsibilityToStub(), theCoremodelPackage.getSimplePathNode(), null, "preResponsibilityToStub", null, 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionContext_StopStep(), ecorePackage.getEString(), "stopStep", null, 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionContext_InstanceComponentToSource(), theCoremodelPackage.getComponentRole(), null, "instanceComponentToSource", null, 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionContext_InstanceComponentToTarget(), theCoremodelPackage.getComponentRole(), null, "instanceComponentToTarget", null, 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionContext_ResponsibilityToJoin(), theCoremodelPackage.getSimplePathNode(), null, "responsibilityToJoin", null, 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionContext_PreResponsibilityToJoin(), theCoremodelPackage.getSimplePathNode(), null, "preResponsibilityToJoin", null, 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionContext_BranchJoin(), ecorePackage.getEStringToStringMapEntry(), null, "branchJoin", null, 0, -1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionContext_Enabled(), ecorePackage.getEInt(), "enabled", null, 0, 1, ExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eStringToEObjectMapEntryEClass, Map.Entry.class, "EStringToEObjectMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEStringToEObjectMapEntry_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEStringToEObjectMapEntry_Value(), ecorePackage.getEObject(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eStringToEJavaObjectMapEntryEClass, Map.Entry.class, "EStringToEJavaObjectMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEStringToEJavaObjectMapEntry_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEStringToEJavaObjectMapEntry_Value(), ecorePackage.getEJavaObject(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simplePathNodeToExecutionStateMapEntryEClass, Map.Entry.class, "SimplePathNodeToExecutionStateMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimplePathNodeToExecutionStateMapEntry_Key(), theCoremodelPackage.getSimplePathNode(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimplePathNodeToExecutionStateMapEntry_Value(), theExecutionstatePackage.getExecutionState(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(evaluationStepEClass, EvaluationStep.class, "EvaluationStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEvaluationStep_Source(), theCoremodelPackage.getSimplePathNode(), null, "source", null, 0, 1, EvaluationStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvaluationStep_Target(), theCoremodelPackage.getSimplePathNode(), null, "target", null, 0, 1, EvaluationStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvaluationStep_CurrentFamily(), ecorePackage.getEString(), "currentFamily", null, 0, 1, EvaluationStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvaluationStep_Condition(), ecorePackage.getEString(), "condition", null, 0, 1, EvaluationStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ExecutionmodelPackageImpl
