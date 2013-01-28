/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.visual.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.executionstatemapping.model.ModelPackage;
import org.isistan.flabot.executionstatemapping.model.impl.ModelPackageImpl;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologPackage;
import org.isistan.flabot.executionstatemapping.model.prolog.impl.PrologPackageImpl;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;
import org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl;
import org.isistan.flabot.executionstatemapping.model.visual.StateDiagram;
import org.isistan.flabot.executionstatemapping.model.visual.VisualFactory;
import org.isistan.flabot.executionstatemapping.model.visual.VisualPackage;
import org.isistan.flabot.mapping.mappingmodel.MappingmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VisualPackageImpl extends EPackageImpl implements VisualPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateDiagramEClass = null;
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
	 * @see org.isistan.flabot.executionstatemapping.model.visual.VisualPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private VisualPackageImpl() {
		super(eNS_URI, VisualFactory.eINSTANCE);
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
	public static VisualPackage init() {
		if (isInited) return (VisualPackage)EPackage.Registry.INSTANCE.getEPackage(VisualPackage.eNS_URI);

		// Obtain or create and register package
		VisualPackageImpl theVisualPackage = (VisualPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof VisualPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new VisualPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EditormodelPackage.eINSTANCE.eClass();
		CoremodelPackage.eINSTANCE.eClass();
		MappingmodelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
		SemanticPackageImpl theSemanticPackage = (SemanticPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI) instanceof SemanticPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI) : SemanticPackage.eINSTANCE);
		PrologPackageImpl thePrologPackage = (PrologPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PrologPackage.eNS_URI) instanceof PrologPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PrologPackage.eNS_URI) : PrologPackage.eINSTANCE);

		// Create package meta-data objects
		theVisualPackage.createPackageContents();
		theModelPackage.createPackageContents();
		theSemanticPackage.createPackageContents();
		thePrologPackage.createPackageContents();

		// Initialize created meta-data
		theVisualPackage.initializePackageContents();
		theModelPackage.initializePackageContents();
		theSemanticPackage.initializePackageContents();
		thePrologPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theVisualPackage.freeze();

		return theVisualPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateDiagram() {
		return stateDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateDiagram_SemanticModel() {
		return (EReference)stateDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisualFactory getVisualFactory() {
		return (VisualFactory)getEFactoryInstance();
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
		stateDiagramEClass = createEClass(STATE_DIAGRAM);
		createEReference(stateDiagramEClass, STATE_DIAGRAM__SEMANTIC_MODEL);
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
		EditormodelPackage theEditormodelPackage = (EditormodelPackage)EPackage.Registry.INSTANCE.getEPackage(EditormodelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		stateDiagramEClass.getESuperTypes().add(theEditormodelPackage.getDiagram());

		// Initialize classes and features; add operations and parameters
		initEClass(stateDiagramEClass, StateDiagram.class, "StateDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateDiagram_SemanticModel(), ecorePackage.getEObject(), null, "semanticModel", null, 0, 1, StateDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //VisualPackageImpl
