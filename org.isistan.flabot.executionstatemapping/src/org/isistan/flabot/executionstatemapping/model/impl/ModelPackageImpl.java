/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel;
import org.isistan.flabot.executionstatemapping.model.ModelFactory;
import org.isistan.flabot.executionstatemapping.model.ModelPackage;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologPackage;
import org.isistan.flabot.executionstatemapping.model.prolog.impl.PrologPackageImpl;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;
import org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl;
import org.isistan.flabot.executionstatemapping.model.visual.VisualPackage;
import org.isistan.flabot.executionstatemapping.model.visual.impl.VisualPackageImpl;
import org.isistan.flabot.mapping.mappingmodel.MappingmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl implements ModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionStateMappingFileModelEClass = null;

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
	 * @see org.isistan.flabot.executionstatemapping.model.ModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelPackageImpl() {
		super(eNS_URI, ModelFactory.eINSTANCE);
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
	public static ModelPackage init() {
		if (isInited) return (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Obtain or create and register package
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EditormodelPackage.eINSTANCE.eClass();
		CoremodelPackage.eINSTANCE.eClass();
		MappingmodelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		VisualPackageImpl theVisualPackage = (VisualPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(VisualPackage.eNS_URI) instanceof VisualPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(VisualPackage.eNS_URI) : VisualPackage.eINSTANCE);
		SemanticPackageImpl theSemanticPackage = (SemanticPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI) instanceof SemanticPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI) : SemanticPackage.eINSTANCE);
		PrologPackageImpl thePrologPackage = (PrologPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PrologPackage.eNS_URI) instanceof PrologPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PrologPackage.eNS_URI) : PrologPackage.eINSTANCE);

		// Create package meta-data objects
		theModelPackage.createPackageContents();
		theVisualPackage.createPackageContents();
		theSemanticPackage.createPackageContents();
		thePrologPackage.createPackageContents();

		// Initialize created meta-data
		theModelPackage.initializePackageContents();
		theVisualPackage.initializePackageContents();
		theSemanticPackage.initializePackageContents();
		thePrologPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelPackage.freeze();

		return theModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutionStateMappingFileModel() {
		return executionStateMappingFileModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionStateMappingFileModel_StateContainersTree() {
		return (EReference)executionStateMappingFileModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionStateMappingFileModel_MethodExecutionConditionsTree() {
		return (EReference)executionStateMappingFileModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionStateMappingFileModel_GeneralExecutionConditionsTree() {
		return (EReference)executionStateMappingFileModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionStateMappingFileModel_StateDiagramsList() {
		return (EReference)executionStateMappingFileModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactory getModelFactory() {
		return (ModelFactory)getEFactoryInstance();
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
		executionStateMappingFileModelEClass = createEClass(EXECUTION_STATE_MAPPING_FILE_MODEL);
		createEReference(executionStateMappingFileModelEClass, EXECUTION_STATE_MAPPING_FILE_MODEL__STATE_CONTAINERS_TREE);
		createEReference(executionStateMappingFileModelEClass, EXECUTION_STATE_MAPPING_FILE_MODEL__METHOD_EXECUTION_CONDITIONS_TREE);
		createEReference(executionStateMappingFileModelEClass, EXECUTION_STATE_MAPPING_FILE_MODEL__GENERAL_EXECUTION_CONDITIONS_TREE);
		createEReference(executionStateMappingFileModelEClass, EXECUTION_STATE_MAPPING_FILE_MODEL__STATE_DIAGRAMS_LIST);
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
		VisualPackage theVisualPackage = (VisualPackage)EPackage.Registry.INSTANCE.getEPackage(VisualPackage.eNS_URI);
		SemanticPackage theSemanticPackage = (SemanticPackage)EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI);
		PrologPackage thePrologPackage = (PrologPackage)EPackage.Registry.INSTANCE.getEPackage(PrologPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theVisualPackage);
		getESubpackages().add(theSemanticPackage);
		getESubpackages().add(thePrologPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(executionStateMappingFileModelEClass, ExecutionStateMappingFileModel.class, "ExecutionStateMappingFileModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutionStateMappingFileModel_StateContainersTree(), theSemanticPackage.getTreeStructuredElement(), null, "stateContainersTree", null, 0, 1, ExecutionStateMappingFileModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionStateMappingFileModel_MethodExecutionConditionsTree(), theSemanticPackage.getMappedTreeStructuredElement(), null, "methodExecutionConditionsTree", null, 0, 1, ExecutionStateMappingFileModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionStateMappingFileModel_GeneralExecutionConditionsTree(), theSemanticPackage.getTreeStructuredElement(), null, "generalExecutionConditionsTree", null, 0, 1, ExecutionStateMappingFileModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionStateMappingFileModel_StateDiagramsList(), theVisualPackage.getStateDiagram(), null, "stateDiagramsList", null, 0, -1, ExecutionStateMappingFileModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ModelPackageImpl
