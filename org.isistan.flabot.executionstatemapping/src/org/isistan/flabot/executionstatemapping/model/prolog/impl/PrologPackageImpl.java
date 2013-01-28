/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.prolog.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.executionstatemapping.model.ModelPackage;
import org.isistan.flabot.executionstatemapping.model.impl.ModelPackageImpl;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologCodeFactory;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologElement;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologFactory;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologPackage;
import org.isistan.flabot.executionstatemapping.model.prolog.TagProvider;
import org.isistan.flabot.executionstatemapping.model.prolog.VisitedExpressionProlog;
import org.isistan.flabot.executionstatemapping.model.prolog.VisitorExpressionProlog;
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
public class PrologPackageImpl extends EPackageImpl implements PrologPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass prologElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tagProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass prologCodeFactoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visitedExpressionPrologEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visitorExpressionPrologEClass = null;

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
	 * @see org.isistan.flabot.executionstatemapping.model.prolog.PrologPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PrologPackageImpl() {
		super(eNS_URI, PrologFactory.eINSTANCE);
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
	public static PrologPackage init() {
		if (isInited) return (PrologPackage)EPackage.Registry.INSTANCE.getEPackage(PrologPackage.eNS_URI);

		// Obtain or create and register package
		PrologPackageImpl thePrologPackage = (PrologPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof PrologPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new PrologPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EditormodelPackage.eINSTANCE.eClass();
		CoremodelPackage.eINSTANCE.eClass();
		MappingmodelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
		VisualPackageImpl theVisualPackage = (VisualPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(VisualPackage.eNS_URI) instanceof VisualPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(VisualPackage.eNS_URI) : VisualPackage.eINSTANCE);
		SemanticPackageImpl theSemanticPackage = (SemanticPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI) instanceof SemanticPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI) : SemanticPackage.eINSTANCE);

		// Create package meta-data objects
		thePrologPackage.createPackageContents();
		theModelPackage.createPackageContents();
		theVisualPackage.createPackageContents();
		theSemanticPackage.createPackageContents();

		// Initialize created meta-data
		thePrologPackage.initializePackageContents();
		theModelPackage.initializePackageContents();
		theVisualPackage.initializePackageContents();
		theSemanticPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePrologPackage.freeze();

		return thePrologPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrologElement() {
		return prologElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrologElement_PredicateName() {
		return (EAttribute)prologElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTagProvider() {
		return tagProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrologCodeFactory() {
		return prologCodeFactoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisitedExpressionProlog() {
		return visitedExpressionPrologEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisitorExpressionProlog() {
		return visitorExpressionPrologEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrologFactory getPrologFactory() {
		return (PrologFactory)getEFactoryInstance();
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
		prologElementEClass = createEClass(PROLOG_ELEMENT);
		createEAttribute(prologElementEClass, PROLOG_ELEMENT__PREDICATE_NAME);

		tagProviderEClass = createEClass(TAG_PROVIDER);

		prologCodeFactoryEClass = createEClass(PROLOG_CODE_FACTORY);

		visitedExpressionPrologEClass = createEClass(VISITED_EXPRESSION_PROLOG);

		visitorExpressionPrologEClass = createEClass(VISITOR_EXPRESSION_PROLOG);
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
		SemanticPackage theSemanticPackage = (SemanticPackage)EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		prologCodeFactoryEClass.getESuperTypes().add(this.getVisitorExpressionProlog());

		// Initialize classes and features; add operations and parameters
		initEClass(prologElementEClass, PrologElement.class, "PrologElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrologElement_PredicateName(), ecorePackage.getEString(), "predicateName", null, 0, 1, PrologElement.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(prologElementEClass, null, "setPredicateFunctor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "functor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "parameters", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(prologElementEClass, null, "resetPredicateName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tagProviderEClass, TagProvider.class, "TagProvider", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(tagProviderEClass, ecorePackage.getEString(), "getPreFilterInitialTag", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(tagProviderEClass, ecorePackage.getEString(), "getPreFilterCommonTag", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(tagProviderEClass, ecorePackage.getEString(), "getExecutionStateCommonTag", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSemanticPackage.getExecutionStateValue(), "executionState", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(prologCodeFactoryEClass, PrologCodeFactory.class, "PrologCodeFactory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(prologCodeFactoryEClass, ecorePackage.getEString(), "getPrologCode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSemanticPackage.getStateContainer(), "stateContainer", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTagProvider(), "tagProvider", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(prologCodeFactoryEClass, ecorePackage.getEString(), "getPrologCode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSemanticPackage.getSimpleExecutionConditionConfiguration(), "simpleExecutionConditionConfiguration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTagProvider(), "tagProvider", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(visitedExpressionPrologEClass, VisitedExpressionProlog.class, "VisitedExpressionProlog", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(visitedExpressionPrologEClass, ecorePackage.getEString(), "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVisitorExpressionProlog(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(visitorExpressionPrologEClass, VisitorExpressionProlog.class, "VisitorExpressionProlog", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(visitorExpressionPrologEClass, ecorePackage.getEString(), "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSemanticPackage.getAndExpression(), "expression", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(visitorExpressionPrologEClass, ecorePackage.getEString(), "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSemanticPackage.getOrExpression(), "expression", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(visitorExpressionPrologEClass, ecorePackage.getEString(), "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSemanticPackage.getSingleExpression(), "expression", 0, 1, IS_UNIQUE, IS_ORDERED);
	}

} //PrologPackageImpl
