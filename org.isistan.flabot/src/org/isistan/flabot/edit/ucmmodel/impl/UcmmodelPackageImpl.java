/**
 * <copyright>
 * </copyright>
 *
 * $Id: UcmmodelPackageImpl.java,v 1.31 2006/03/04 01:02:22 apersson Exp $
 */
package org.isistan.flabot.edit.ucmmodel.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.impl.CoremodelPackageImpl;
import org.isistan.flabot.edit.componentmodel.ComponentmodelPackage;
import org.isistan.flabot.edit.componentmodel.impl.ComponentmodelPackageImpl;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.impl.EditormodelPackageImpl;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.edit.ucmmodel.UcmmodelFactory;
import org.isistan.flabot.edit.ucmmodel.UcmmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UcmmodelPackageImpl extends EPackageImpl implements UcmmodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ucmDiagramEClass = null;

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
	private EDataType notifierEDataType = null;

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
	 * @see org.isistan.flabot.edit.ucmmodel.UcmmodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UcmmodelPackageImpl() {
		super(eNS_URI, UcmmodelFactory.eINSTANCE);
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
	public static UcmmodelPackage init() {
		if (isInited) return (UcmmodelPackage)EPackage.Registry.INSTANCE.getEPackage(UcmmodelPackage.eNS_URI);

		// Obtain or create and register package
		UcmmodelPackageImpl theUcmmodelPackage = (UcmmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof UcmmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new UcmmodelPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		EditormodelPackageImpl theEditormodelPackage = (EditormodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EditormodelPackage.eNS_URI) instanceof EditormodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EditormodelPackage.eNS_URI) : EditormodelPackage.eINSTANCE);
		ComponentmodelPackageImpl theComponentmodelPackage = (ComponentmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ComponentmodelPackage.eNS_URI) instanceof ComponentmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ComponentmodelPackage.eNS_URI) : ComponentmodelPackage.eINSTANCE);
		CoremodelPackageImpl theCoremodelPackage = (CoremodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CoremodelPackage.eNS_URI) instanceof CoremodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CoremodelPackage.eNS_URI) : CoremodelPackage.eINSTANCE);

		// Create package meta-data objects
		theUcmmodelPackage.createPackageContents();
		theEditormodelPackage.createPackageContents();
		theComponentmodelPackage.createPackageContents();
		theCoremodelPackage.createPackageContents();

		// Initialize created meta-data
		theUcmmodelPackage.initializePackageContents();
		theEditormodelPackage.initializePackageContents();
		theComponentmodelPackage.initializePackageContents();
		theCoremodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUcmmodelPackage.freeze();

		return theUcmmodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUCMDiagram() {
		return ucmDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUCMDiagram_Map() {
		return (EReference)ucmDiagramEClass.getEStructuralFeatures().get(0);
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
	public EDataType getNotifier() {
		return notifierEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UcmmodelFactory getUcmmodelFactory() {
		return (UcmmodelFactory)getEFactoryInstance();
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
		ucmDiagramEClass = createEClass(UCM_DIAGRAM);
		createEReference(ucmDiagramEClass, UCM_DIAGRAM__MAP);

		adapterEClass = createEClass(ADAPTER);

		// Create data types
		notifierEDataType = createEDataType(NOTIFIER);
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

		// Add supertypes to classes
		ucmDiagramEClass.getESuperTypes().add(theEditormodelPackage.getDiagram());
		ucmDiagramEClass.getESuperTypes().add(this.getAdapter());

		// Initialize classes and features; add operations and parameters
		initEClass(ucmDiagramEClass, UCMDiagram.class, "UCMDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUCMDiagram_Map(), theCoremodelPackage.getUseCaseMap(), null, "map", null, 0, 1, UCMDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adapterEClass, Adapter.class, "Adapter", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		// Initialize data types
		initEDataType(notifierEDataType, Notifier.class, "Notifier", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //UcmmodelPackageImpl
