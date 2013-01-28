/**
 * <copyright>
 * </copyright>
 *
 * $Id: ComponentmodelPackageImpl.java,v 1.31 2006/01/27 19:40:44 dacostae Exp $
 */
package org.isistan.flabot.edit.componentmodel.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.impl.CoremodelPackageImpl;
import org.isistan.flabot.edit.componentmodel.ComponentDiagram;
import org.isistan.flabot.edit.componentmodel.ComponentmodelFactory;
import org.isistan.flabot.edit.componentmodel.ComponentmodelPackage;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.impl.EditormodelPackageImpl;
import org.isistan.flabot.edit.ucmmodel.UcmmodelPackage;
import org.isistan.flabot.edit.ucmmodel.impl.UcmmodelPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComponentmodelPackageImpl extends EPackageImpl implements ComponentmodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adapterEClass = null;

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
	 * @see org.isistan.flabot.edit.componentmodel.ComponentmodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ComponentmodelPackageImpl() {
		super(eNS_URI, ComponentmodelFactory.eINSTANCE);
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
	public static ComponentmodelPackage init() {
		if (isInited) return (ComponentmodelPackage)EPackage.Registry.INSTANCE.getEPackage(ComponentmodelPackage.eNS_URI);

		// Obtain or create and register package
		ComponentmodelPackageImpl theComponentmodelPackage = (ComponentmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ComponentmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ComponentmodelPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		EditormodelPackageImpl theEditormodelPackage = (EditormodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EditormodelPackage.eNS_URI) instanceof EditormodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EditormodelPackage.eNS_URI) : EditormodelPackage.eINSTANCE);
		UcmmodelPackageImpl theUcmmodelPackage = (UcmmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UcmmodelPackage.eNS_URI) instanceof UcmmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UcmmodelPackage.eNS_URI) : UcmmodelPackage.eINSTANCE);
		CoremodelPackageImpl theCoremodelPackage = (CoremodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CoremodelPackage.eNS_URI) instanceof CoremodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CoremodelPackage.eNS_URI) : CoremodelPackage.eINSTANCE);

		// Create package meta-data objects
		theComponentmodelPackage.createPackageContents();
		theEditormodelPackage.createPackageContents();
		theUcmmodelPackage.createPackageContents();
		theCoremodelPackage.createPackageContents();

		// Initialize created meta-data
		theComponentmodelPackage.initializePackageContents();
		theEditormodelPackage.initializePackageContents();
		theUcmmodelPackage.initializePackageContents();
		theCoremodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theComponentmodelPackage.freeze();

		return theComponentmodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentDiagram() {
		return componentDiagramEClass;
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
	public ComponentmodelFactory getComponentmodelFactory() {
		return (ComponentmodelFactory)getEFactoryInstance();
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
		componentDiagramEClass = createEClass(COMPONENT_DIAGRAM);

		adapterEClass = createEClass(ADAPTER);
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

		// Add supertypes to classes
		componentDiagramEClass.getESuperTypes().add(theEditormodelPackage.getDiagram());

		// Initialize classes and features; add operations and parameters
		initEClass(componentDiagramEClass, ComponentDiagram.class, "ComponentDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(adapterEClass, Adapter.class, "Adapter", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ComponentmodelPackageImpl
