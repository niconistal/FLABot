/**
 * <copyright>
 * </copyright>
 *
 * $Id: CoremodelPackageImpl.java,v 1.90 2006/04/11 23:31:50 franco Exp $
 */
package org.isistan.flabot.coremodel.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.isistan.flabot.coremodel.BehavioralFeatureModel;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.coremodel.ConditionedStub;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.DirectionArrowNode;
import org.isistan.flabot.coremodel.DynamicStubNode;
import org.isistan.flabot.coremodel.ExtensibleElement;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.coremodel.FamilyElement;
import org.isistan.flabot.coremodel.FeatureModel;
import org.isistan.flabot.coremodel.ForkCondition;
import org.isistan.flabot.coremodel.ForkNode;
import org.isistan.flabot.coremodel.InterfaceLink;
import org.isistan.flabot.coremodel.InterfaceModel;
import org.isistan.flabot.coremodel.InterfacePrologCode;
import org.isistan.flabot.coremodel.JoinNode;
import org.isistan.flabot.coremodel.NamedElementModel;
import org.isistan.flabot.coremodel.Note;
import org.isistan.flabot.coremodel.NoteElementModel;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.PathNode;
import org.isistan.flabot.coremodel.PortModel;
import org.isistan.flabot.coremodel.Property;
import org.isistan.flabot.coremodel.PropertyElementModel;
import org.isistan.flabot.coremodel.Registrable;
import org.isistan.flabot.coremodel.Relationship;
import org.isistan.flabot.coremodel.RelationshipDirection;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.ResponsibilityRegistry;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.Stereotype;
import org.isistan.flabot.coremodel.StereotypedElementModel;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.coremodel.TimerNode;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.coremodel.util.CoremodelValidator;
import org.isistan.flabot.edit.componentmodel.ComponentmodelPackage;
import org.isistan.flabot.edit.componentmodel.impl.ComponentmodelPackageImpl;
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
public class CoremodelPackageImpl extends EPackageImpl implements CoremodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behavioralFeatureModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass responsibilityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass useCaseMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyElementModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentRoleEClass = null;

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
	private EClass forkNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simplePathNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stereotypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stereotypedElementModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass responsibilityNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass noteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass noteElementModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass familyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass familyElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfacePrologCodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass joinNodeEClass = null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timerNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directionArrowNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionedStubEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dynamicStubNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass registrableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass responsibilityRegistryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass responsibilityToRegistrableMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentToMapMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleToMapMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stubNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forkConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensibleElementEClass = null;

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
	private EClass conditionEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionEventToConditionEventMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum relationshipDirectionEEnum = null;

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
	 * @see org.isistan.flabot.coremodel.CoremodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CoremodelPackageImpl() {
		super(eNS_URI, CoremodelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CoremodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CoremodelPackage init() {
		if (isInited) return (CoremodelPackage)EPackage.Registry.INSTANCE.getEPackage(CoremodelPackage.eNS_URI);

		// Obtain or create and register package
		CoremodelPackageImpl theCoremodelPackage = (CoremodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CoremodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CoremodelPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		EditormodelPackageImpl theEditormodelPackage = (EditormodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EditormodelPackage.eNS_URI) instanceof EditormodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EditormodelPackage.eNS_URI) : EditormodelPackage.eINSTANCE);
		ComponentmodelPackageImpl theComponentmodelPackage = (ComponentmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ComponentmodelPackage.eNS_URI) instanceof ComponentmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ComponentmodelPackage.eNS_URI) : ComponentmodelPackage.eINSTANCE);
		UcmmodelPackageImpl theUcmmodelPackage = (UcmmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UcmmodelPackage.eNS_URI) instanceof UcmmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UcmmodelPackage.eNS_URI) : UcmmodelPackage.eINSTANCE);

		// Create package meta-data objects
		theCoremodelPackage.createPackageContents();
		theEditormodelPackage.createPackageContents();
		theComponentmodelPackage.createPackageContents();
		theUcmmodelPackage.createPackageContents();

		// Initialize created meta-data
		theCoremodelPackage.initializePackageContents();
		theEditormodelPackage.initializePackageContents();
		theComponentmodelPackage.initializePackageContents();
		theUcmmodelPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theCoremodelPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return CoremodelValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theCoremodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CoremodelPackage.eNS_URI, theCoremodelPackage);
		return theCoremodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehavioralFeatureModel() {
		return behavioralFeatureModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentModel() {
		return componentModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentModel_Features() {
		return (EReference)componentModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentModel_OwnedPorts() {
		return (EReference)componentModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentModel_CoreModel() {
		return (EReference)componentModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreModel() {
		return coreModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreModel_Components() {
		return (EReference)coreModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreModel_Responsibilities() {
		return (EReference)coreModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreModel_UseCaseMaps() {
		return (EReference)coreModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreModel_InterfaceLinks() {
		return (EReference)coreModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreModel_Relationships() {
		return (EReference)coreModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreModel_Stereotypes() {
		return (EReference)coreModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreModel_File() {
		return (EReference)coreModelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreModel_Families() {
		return (EReference)coreModelEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreModel_ArchitecturalUseCaseMaps() {
		return (EReference)coreModelEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreModel_FunctionalUseCaseMaps() {
		return (EReference)coreModelEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreModel_Events() {
		return (EReference)coreModelEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreModel_Stubs() {
		return (EReference)coreModelEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreModel_DynamicStubs() {
		return (EReference)coreModelEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreModel_ConditionedStubs() {
		return (EReference)coreModelEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureModel() {
		return featureModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureModel_Components() {
		return (EReference)featureModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfaceModel() {
		return interfaceModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceModel_Port() {
		return (EReference)interfaceModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElementModel() {
		return namedElementModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElementModel_Name() {
		return (EAttribute)namedElementModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortModel() {
		return portModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortModel_Provideds() {
		return (EReference)portModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortModel_Requireds() {
		return (EReference)portModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortModel_Component() {
		return (EReference)portModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResponsibility() {
		return responsibilityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResponsibility_Description() {
		return (EAttribute)responsibilityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponsibility_Preconditions() {
		return (EReference)responsibilityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponsibility_Postconditions() {
		return (EReference)responsibilityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponsibility_CoreModel() {
		return (EReference)responsibilityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUseCaseMap() {
		return useCaseMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseCaseMap_Paths() {
		return (EReference)useCaseMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseCaseMap_ComponentRoles() {
		return (EReference)useCaseMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseCaseMap_CoreModel() {
		return (EReference)useCaseMapEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUseCaseMap_Description() {
		return (EAttribute)useCaseMapEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUseCaseMap_LevelInfo() {
		return (EAttribute)useCaseMapEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPath() {
		return pathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPath_Nodes() {
		return (EReference)pathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPath_EndNodes() {
		return (EReference)pathEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPath_StartNodes() {
		return (EReference)pathEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPathNode() {
		return pathNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPathNode_Path() {
		return (EReference)pathNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPathNode_Previous() {
		return (EReference)pathNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPathNode_Next() {
		return (EReference)pathNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfaceLink() {
		return interfaceLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceLink_Source() {
		return (EReference)interfaceLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceLink_Target() {
		return (EReference)interfaceLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyElementModel() {
		return propertyElementModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyElementModel_Properties() {
		return (EReference)propertyElementModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Name() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Value() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationship() {
		return relationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationship_Source() {
		return (EReference)relationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationship_Target() {
		return (EReference)relationshipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationship_Direction() {
		return (EAttribute)relationshipEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentRole() {
		return componentRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentRole_Component() {
		return (EReference)componentRoleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentRole_Map() {
		return (EReference)componentRoleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentRole_AbstractInfo() {
		return (EAttribute)componentRoleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentRole_ComponentType() {
		return (EAttribute)componentRoleEClass.getEStructuralFeatures().get(3);
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
	public EClass getForkNode() {
		return forkNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForkNode_ForkType() {
		return (EAttribute)forkNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForkNode_Conditions() {
		return (EReference)forkNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimplePathNode() {
		return simplePathNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimplePathNode_Map() {
		return (EReference)simplePathNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStereotype() {
		return stereotypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStereotypedElementModel() {
		return stereotypedElementModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStereotypedElementModel_Stereotype() {
		return (EReference)stereotypedElementModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResponsibilityNode() {
		return responsibilityNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponsibilityNode_Responsibility() {
		return (EReference)responsibilityNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponsibilityNode_Role() {
		return (EReference)responsibilityNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResponsibilityNode_InputsCount() {
		return (EAttribute)responsibilityNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResponsibilityNode_OutputsCount() {
		return (EAttribute)responsibilityNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCondition() {
		return conditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCondition_Value() {
		return (EAttribute)conditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCondition_UseCaseMap() {
		return (EReference)conditionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCondition_Event() {
		return (EReference)conditionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCondition_Family() {
		return (EReference)conditionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCondition_SourceResponsibility() {
		return (EReference)conditionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCondition_Type() {
		return (EAttribute)conditionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCondition_DependencyResponsibility() {
		return (EReference)conditionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNote() {
		return noteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNote_Note() {
		return (EAttribute)noteEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNote_Targets() {
		return (EReference)noteEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNoteElementModel() {
		return noteElementModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNoteElementModel_Notes() {
		return (EReference)noteElementModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFamily() {
		return familyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFamily_FamilyElement() {
		return (EReference)familyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFamily_AssociatedResponsibilities() {
		return (EReference)familyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFamily_ArchitecturalUseCaseMaps() {
		return (EReference)familyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFamily_FunctionalUseCaseMaps() {
		return (EReference)familyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFamily_Events() {
		return (EReference)familyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFamilyElement() {
		return familyElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFamilyElement_UseCaseMap() {
		return (EReference)familyElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFamilyElement_FunctionalComponent() {
		return (EReference)familyElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFamilyElement_ArchitecturalComponent() {
		return (EReference)familyElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfacePrologCode() {
		return interfacePrologCodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJoinNode() {
		return joinNodeEClass;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimerNode() {
		return timerNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimerNode_TimerName() {
		return (EAttribute)timerNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimerNode_TimerDescription() {
		return (EAttribute)timerNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoinNode_JoinType() {
		return (EAttribute)joinNodeEClass.getEStructuralFeatures().get(0);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimerNode_TimerType() {
		return (EAttribute)timerNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimerNode_TimerTimeOut() {
		return (EAttribute)timerNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimerNode_TimerTimeOutUnity() {
		return (EAttribute)timerNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDirectionArrowNode() {
		return directionArrowNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionedStub() {
		return conditionedStubEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionedStub_Stub() {
		return (EReference)conditionedStubEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionedStub_ResponsibilityNode() {
		return (EReference)conditionedStubEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDynamicStubNode() {
		return dynamicStubNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDynamicStubNode_ConditionedStubs() {
		return (EReference)dynamicStubNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegistrable() {
		return registrableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResponsibilityRegistry() {
		return responsibilityRegistryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponsibilityRegistry_ResponsibilityBasedRegistry() {
		return (EReference)responsibilityRegistryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponsibilityRegistry_ComponentBasedRegistry() {
		return (EReference)responsibilityRegistryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponsibilityRegistry_RoleBasedRegistry() {
		return (EReference)responsibilityRegistryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResponsibilityToRegistrableMapEntry() {
		return responsibilityToRegistrableMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponsibilityToRegistrableMapEntry_Key() {
		return (EReference)responsibilityToRegistrableMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponsibilityToRegistrableMapEntry_Value() {
		return (EReference)responsibilityToRegistrableMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentToMapMapEntry() {
		return componentToMapMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentToMapMapEntry_Key() {
		return (EReference)componentToMapMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentToMapMapEntry_Value() {
		return (EReference)componentToMapMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoleToMapMapEntry() {
		return roleToMapMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoleToMapMapEntry_Key() {
		return (EReference)roleToMapMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoleToMapMapEntry_Value() {
		return (EReference)roleToMapMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStubNode() {
		return stubNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStubNode_StartPointReference() {
		return (EReference)stubNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStubNode_EndPointReference() {
		return (EReference)stubNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStubNode_ReferencedMap() {
		return (EReference)stubNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStubNode_Family() {
		return (EReference)stubNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForkCondition() {
		return forkConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForkCondition_Condition() {
		return (EAttribute)forkConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtensibleElement() {
		return extensibleElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensibleElement_ExtendedData() {
		return (EReference)extensibleElementEClass.getEStructuralFeatures().get(0);
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
	public EClass getConditionEvent() {
		return conditionEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConditionEvent_ConditionEvent() {
		return (EAttribute)conditionEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConditionEvent_Description() {
		return (EAttribute)conditionEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionEvent_AssociatedConditions() {
		return (EReference)conditionEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionEventToConditionEventMapEntry() {
		return conditionEventToConditionEventMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionEventToConditionEventMapEntry_Key() {
		return (EReference)conditionEventToConditionEventMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionEventToConditionEventMapEntry_Value() {
		return (EReference)conditionEventToConditionEventMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRelationshipDirection() {
		return relationshipDirectionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoremodelFactory getCoremodelFactory() {
		return (CoremodelFactory)getEFactoryInstance();
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
		behavioralFeatureModelEClass = createEClass(BEHAVIORAL_FEATURE_MODEL);

		componentModelEClass = createEClass(COMPONENT_MODEL);
		createEReference(componentModelEClass, COMPONENT_MODEL__FEATURES);
		createEReference(componentModelEClass, COMPONENT_MODEL__OWNED_PORTS);
		createEReference(componentModelEClass, COMPONENT_MODEL__CORE_MODEL);

		coreModelEClass = createEClass(CORE_MODEL);
		createEReference(coreModelEClass, CORE_MODEL__COMPONENTS);
		createEReference(coreModelEClass, CORE_MODEL__RESPONSIBILITIES);
		createEReference(coreModelEClass, CORE_MODEL__USE_CASE_MAPS);
		createEReference(coreModelEClass, CORE_MODEL__INTERFACE_LINKS);
		createEReference(coreModelEClass, CORE_MODEL__RELATIONSHIPS);
		createEReference(coreModelEClass, CORE_MODEL__STEREOTYPES);
		createEReference(coreModelEClass, CORE_MODEL__FILE);
		createEReference(coreModelEClass, CORE_MODEL__FAMILIES);
		createEReference(coreModelEClass, CORE_MODEL__ARCHITECTURAL_USE_CASE_MAPS);
		createEReference(coreModelEClass, CORE_MODEL__FUNCTIONAL_USE_CASE_MAPS);
		createEReference(coreModelEClass, CORE_MODEL__EVENTS);
		createEReference(coreModelEClass, CORE_MODEL__STUBS);
		createEReference(coreModelEClass, CORE_MODEL__DYNAMIC_STUBS);
		createEReference(coreModelEClass, CORE_MODEL__CONDITIONED_STUBS);

		featureModelEClass = createEClass(FEATURE_MODEL);
		createEReference(featureModelEClass, FEATURE_MODEL__COMPONENTS);

		interfaceModelEClass = createEClass(INTERFACE_MODEL);
		createEReference(interfaceModelEClass, INTERFACE_MODEL__PORT);

		namedElementModelEClass = createEClass(NAMED_ELEMENT_MODEL);
		createEAttribute(namedElementModelEClass, NAMED_ELEMENT_MODEL__NAME);

		portModelEClass = createEClass(PORT_MODEL);
		createEReference(portModelEClass, PORT_MODEL__PROVIDEDS);
		createEReference(portModelEClass, PORT_MODEL__REQUIREDS);
		createEReference(portModelEClass, PORT_MODEL__COMPONENT);

		responsibilityEClass = createEClass(RESPONSIBILITY);
		createEAttribute(responsibilityEClass, RESPONSIBILITY__DESCRIPTION);
		createEReference(responsibilityEClass, RESPONSIBILITY__PRECONDITIONS);
		createEReference(responsibilityEClass, RESPONSIBILITY__POSTCONDITIONS);
		createEReference(responsibilityEClass, RESPONSIBILITY__CORE_MODEL);

		useCaseMapEClass = createEClass(USE_CASE_MAP);
		createEReference(useCaseMapEClass, USE_CASE_MAP__PATHS);
		createEReference(useCaseMapEClass, USE_CASE_MAP__COMPONENT_ROLES);
		createEReference(useCaseMapEClass, USE_CASE_MAP__CORE_MODEL);
		createEAttribute(useCaseMapEClass, USE_CASE_MAP__DESCRIPTION);
		createEAttribute(useCaseMapEClass, USE_CASE_MAP__LEVEL_INFO);

		pathEClass = createEClass(PATH);
		createEReference(pathEClass, PATH__NODES);
		createEReference(pathEClass, PATH__END_NODES);
		createEReference(pathEClass, PATH__START_NODES);

		pathNodeEClass = createEClass(PATH_NODE);
		createEReference(pathNodeEClass, PATH_NODE__PATH);
		createEReference(pathNodeEClass, PATH_NODE__PREVIOUS);
		createEReference(pathNodeEClass, PATH_NODE__NEXT);

		interfaceLinkEClass = createEClass(INTERFACE_LINK);
		createEReference(interfaceLinkEClass, INTERFACE_LINK__SOURCE);
		createEReference(interfaceLinkEClass, INTERFACE_LINK__TARGET);

		propertyElementModelEClass = createEClass(PROPERTY_ELEMENT_MODEL);
		createEReference(propertyElementModelEClass, PROPERTY_ELEMENT_MODEL__PROPERTIES);

		propertyEClass = createEClass(PROPERTY);
		createEAttribute(propertyEClass, PROPERTY__NAME);
		createEAttribute(propertyEClass, PROPERTY__VALUE);

		relationshipEClass = createEClass(RELATIONSHIP);
		createEReference(relationshipEClass, RELATIONSHIP__SOURCE);
		createEReference(relationshipEClass, RELATIONSHIP__TARGET);
		createEAttribute(relationshipEClass, RELATIONSHIP__DIRECTION);

		componentRoleEClass = createEClass(COMPONENT_ROLE);
		createEReference(componentRoleEClass, COMPONENT_ROLE__COMPONENT);
		createEReference(componentRoleEClass, COMPONENT_ROLE__MAP);
		createEAttribute(componentRoleEClass, COMPONENT_ROLE__ABSTRACT_INFO);
		createEAttribute(componentRoleEClass, COMPONENT_ROLE__COMPONENT_TYPE);

		adapterEClass = createEClass(ADAPTER);

		forkNodeEClass = createEClass(FORK_NODE);
		createEAttribute(forkNodeEClass, FORK_NODE__FORK_TYPE);
		createEReference(forkNodeEClass, FORK_NODE__CONDITIONS);

		simplePathNodeEClass = createEClass(SIMPLE_PATH_NODE);
		createEReference(simplePathNodeEClass, SIMPLE_PATH_NODE__MAP);

		stereotypeEClass = createEClass(STEREOTYPE);

		stereotypedElementModelEClass = createEClass(STEREOTYPED_ELEMENT_MODEL);
		createEReference(stereotypedElementModelEClass, STEREOTYPED_ELEMENT_MODEL__STEREOTYPE);

		responsibilityNodeEClass = createEClass(RESPONSIBILITY_NODE);
		createEReference(responsibilityNodeEClass, RESPONSIBILITY_NODE__RESPONSIBILITY);
		createEReference(responsibilityNodeEClass, RESPONSIBILITY_NODE__ROLE);
		createEAttribute(responsibilityNodeEClass, RESPONSIBILITY_NODE__INPUTS_COUNT);
		createEAttribute(responsibilityNodeEClass, RESPONSIBILITY_NODE__OUTPUTS_COUNT);

		conditionEClass = createEClass(CONDITION);
		createEAttribute(conditionEClass, CONDITION__VALUE);
		createEReference(conditionEClass, CONDITION__USE_CASE_MAP);
		createEReference(conditionEClass, CONDITION__EVENT);
		createEReference(conditionEClass, CONDITION__FAMILY);
		createEReference(conditionEClass, CONDITION__SOURCE_RESPONSIBILITY);
		createEAttribute(conditionEClass, CONDITION__TYPE);
		createEReference(conditionEClass, CONDITION__DEPENDENCY_RESPONSIBILITY);

		noteEClass = createEClass(NOTE);
		createEAttribute(noteEClass, NOTE__NOTE);
		createEReference(noteEClass, NOTE__TARGETS);

		noteElementModelEClass = createEClass(NOTE_ELEMENT_MODEL);
		createEReference(noteElementModelEClass, NOTE_ELEMENT_MODEL__NOTES);

		familyEClass = createEClass(FAMILY);
		createEReference(familyEClass, FAMILY__FAMILY_ELEMENT);
		createEReference(familyEClass, FAMILY__ASSOCIATED_RESPONSIBILITIES);
		createEReference(familyEClass, FAMILY__ARCHITECTURAL_USE_CASE_MAPS);
		createEReference(familyEClass, FAMILY__FUNCTIONAL_USE_CASE_MAPS);
		createEReference(familyEClass, FAMILY__EVENTS);

		familyElementEClass = createEClass(FAMILY_ELEMENT);
		createEReference(familyElementEClass, FAMILY_ELEMENT__USE_CASE_MAP);
		createEReference(familyElementEClass, FAMILY_ELEMENT__FUNCTIONAL_COMPONENT);
		createEReference(familyElementEClass, FAMILY_ELEMENT__ARCHITECTURAL_COMPONENT);

		interfacePrologCodeEClass = createEClass(INTERFACE_PROLOG_CODE);

		joinNodeEClass = createEClass(JOIN_NODE);
		createEAttribute(joinNodeEClass, JOIN_NODE__JOIN_TYPE);

		registrableEClass = createEClass(REGISTRABLE);

		responsibilityRegistryEClass = createEClass(RESPONSIBILITY_REGISTRY);
		createEReference(responsibilityRegistryEClass, RESPONSIBILITY_REGISTRY__RESPONSIBILITY_BASED_REGISTRY);
		createEReference(responsibilityRegistryEClass, RESPONSIBILITY_REGISTRY__COMPONENT_BASED_REGISTRY);
		createEReference(responsibilityRegistryEClass, RESPONSIBILITY_REGISTRY__ROLE_BASED_REGISTRY);

		responsibilityToRegistrableMapEntryEClass = createEClass(RESPONSIBILITY_TO_REGISTRABLE_MAP_ENTRY);
		createEReference(responsibilityToRegistrableMapEntryEClass, RESPONSIBILITY_TO_REGISTRABLE_MAP_ENTRY__KEY);
		createEReference(responsibilityToRegistrableMapEntryEClass, RESPONSIBILITY_TO_REGISTRABLE_MAP_ENTRY__VALUE);

		componentToMapMapEntryEClass = createEClass(COMPONENT_TO_MAP_MAP_ENTRY);
		createEReference(componentToMapMapEntryEClass, COMPONENT_TO_MAP_MAP_ENTRY__KEY);
		createEReference(componentToMapMapEntryEClass, COMPONENT_TO_MAP_MAP_ENTRY__VALUE);

		roleToMapMapEntryEClass = createEClass(ROLE_TO_MAP_MAP_ENTRY);
		createEReference(roleToMapMapEntryEClass, ROLE_TO_MAP_MAP_ENTRY__KEY);
		createEReference(roleToMapMapEntryEClass, ROLE_TO_MAP_MAP_ENTRY__VALUE);

		stubNodeEClass = createEClass(STUB_NODE);
		createEReference(stubNodeEClass, STUB_NODE__START_POINT_REFERENCE);
		createEReference(stubNodeEClass, STUB_NODE__END_POINT_REFERENCE);
		createEReference(stubNodeEClass, STUB_NODE__REFERENCED_MAP);
		createEReference(stubNodeEClass, STUB_NODE__FAMILY);

		forkConditionEClass = createEClass(FORK_CONDITION);
		createEAttribute(forkConditionEClass, FORK_CONDITION__CONDITION);

		extensibleElementEClass = createEClass(EXTENSIBLE_ELEMENT);
		createEReference(extensibleElementEClass, EXTENSIBLE_ELEMENT__EXTENDED_DATA);

		eStringToEObjectMapEntryEClass = createEClass(ESTRING_TO_EOBJECT_MAP_ENTRY);
		createEAttribute(eStringToEObjectMapEntryEClass, ESTRING_TO_EOBJECT_MAP_ENTRY__KEY);
		createEReference(eStringToEObjectMapEntryEClass, ESTRING_TO_EOBJECT_MAP_ENTRY__VALUE);

		conditionEventEClass = createEClass(CONDITION_EVENT);
		createEAttribute(conditionEventEClass, CONDITION_EVENT__CONDITION_EVENT);
		createEAttribute(conditionEventEClass, CONDITION_EVENT__DESCRIPTION);
		createEReference(conditionEventEClass, CONDITION_EVENT__ASSOCIATED_CONDITIONS);

		conditionEventToConditionEventMapEntryEClass = createEClass(CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY);
		createEReference(conditionEventToConditionEventMapEntryEClass, CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY__KEY);
		createEReference(conditionEventToConditionEventMapEntryEClass, CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY__VALUE);

		timerNodeEClass = createEClass(TIMER_NODE);
		createEAttribute(timerNodeEClass, TIMER_NODE__TIMER_NAME);
		createEAttribute(timerNodeEClass, TIMER_NODE__TIMER_DESCRIPTION);
		createEAttribute(timerNodeEClass, TIMER_NODE__TIMER_TYPE);
		createEAttribute(timerNodeEClass, TIMER_NODE__TIMER_TIME_OUT);
		createEAttribute(timerNodeEClass, TIMER_NODE__TIMER_TIME_OUT_UNITY);

		directionArrowNodeEClass = createEClass(DIRECTION_ARROW_NODE);

		conditionedStubEClass = createEClass(CONDITIONED_STUB);
		createEReference(conditionedStubEClass, CONDITIONED_STUB__STUB);
		createEReference(conditionedStubEClass, CONDITIONED_STUB__RESPONSIBILITY_NODE);

		dynamicStubNodeEClass = createEClass(DYNAMIC_STUB_NODE);
		createEReference(dynamicStubNodeEClass, DYNAMIC_STUB_NODE__CONDITIONED_STUBS);

		// Create enums
		relationshipDirectionEEnum = createEEnum(RELATIONSHIP_DIRECTION);
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

		// Add supertypes to classes
		behavioralFeatureModelEClass.getESuperTypes().add(this.getFeatureModel());
		componentModelEClass.getESuperTypes().add(this.getExtensibleElement());
		componentModelEClass.getESuperTypes().add(this.getNamedElementModel());
		componentModelEClass.getESuperTypes().add(this.getPropertyElementModel());
		componentModelEClass.getESuperTypes().add(this.getStereotypedElementModel());
		componentModelEClass.getESuperTypes().add(this.getNoteElementModel());
		componentModelEClass.getESuperTypes().add(this.getAdapter());
		featureModelEClass.getESuperTypes().add(this.getNamedElementModel());
		featureModelEClass.getESuperTypes().add(this.getExtensibleElement());
		interfaceModelEClass.getESuperTypes().add(this.getNamedElementModel());
		portModelEClass.getESuperTypes().add(this.getNamedElementModel());
		portModelEClass.getESuperTypes().add(this.getPropertyElementModel());
		responsibilityEClass.getESuperTypes().add(this.getBehavioralFeatureModel());
		useCaseMapEClass.getESuperTypes().add(this.getNamedElementModel());
		pathEClass.getESuperTypes().add(this.getNamedElementModel());
		pathNodeEClass.getESuperTypes().add(this.getNoteElementModel());
		pathNodeEClass.getESuperTypes().add(this.getInterfacePrologCode());
		pathNodeEClass.getESuperTypes().add(this.getExtensibleElement());
		interfaceLinkEClass.getESuperTypes().add(this.getNamedElementModel());
		interfaceLinkEClass.getESuperTypes().add(this.getNoteElementModel());
		relationshipEClass.getESuperTypes().add(this.getNamedElementModel());
		relationshipEClass.getESuperTypes().add(this.getPropertyElementModel());
		relationshipEClass.getESuperTypes().add(this.getStereotypedElementModel());
		relationshipEClass.getESuperTypes().add(this.getNoteElementModel());
		componentRoleEClass.getESuperTypes().add(this.getExtensibleElement());
		componentRoleEClass.getESuperTypes().add(this.getNamedElementModel());
		componentRoleEClass.getESuperTypes().add(this.getNoteElementModel());
		componentRoleEClass.getESuperTypes().add(this.getAdapter());
		forkNodeEClass.getESuperTypes().add(this.getResponsibilityNode());
		forkNodeEClass.getESuperTypes().add(this.getNamedElementModel());
		simplePathNodeEClass.getESuperTypes().add(this.getPathNode());
		simplePathNodeEClass.getESuperTypes().add(this.getNamedElementModel());
		stereotypeEClass.getESuperTypes().add(this.getNamedElementModel());
		responsibilityNodeEClass.getESuperTypes().add(this.getSimplePathNode());
		responsibilityNodeEClass.getESuperTypes().add(this.getAdapter());
		conditionEClass.getESuperTypes().add(this.getNamedElementModel());
		conditionEClass.getESuperTypes().add(this.getInterfacePrologCode());
		familyEClass.getESuperTypes().add(this.getNamedElementModel());
		familyElementEClass.getESuperTypes().add(this.getNamedElementModel());
		joinNodeEClass.getESuperTypes().add(this.getResponsibilityNode());
		joinNodeEClass.getESuperTypes().add(this.getNamedElementModel());
		stubNodeEClass.getESuperTypes().add(this.getSimplePathNode());
		stubNodeEClass.getESuperTypes().add(this.getNamedElementModel());
		forkConditionEClass.getESuperTypes().add(this.getNamedElementModel());
		conditionEventEClass.getESuperTypes().add(this.getNamedElementModel());
		conditionEventEClass.getESuperTypes().add(this.getExtensibleElement());
		timerNodeEClass.getESuperTypes().add(this.getResponsibilityNode());
		timerNodeEClass.getESuperTypes().add(this.getNamedElementModel());
		directionArrowNodeEClass.getESuperTypes().add(this.getSimplePathNode());
		directionArrowNodeEClass.getESuperTypes().add(this.getNamedElementModel());
		conditionedStubEClass.getESuperTypes().add(this.getNamedElementModel());
		dynamicStubNodeEClass.getESuperTypes().add(this.getSimplePathNode());

		// Initialize classes and features; add operations and parameters
		initEClass(behavioralFeatureModelEClass, BehavioralFeatureModel.class, "BehavioralFeatureModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(componentModelEClass, ComponentModel.class, "ComponentModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentModel_Features(), this.getFeatureModel(), this.getFeatureModel_Components(), "features", null, 0, -1, ComponentModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentModel_OwnedPorts(), this.getPortModel(), this.getPortModel_Component(), "ownedPorts", null, 0, -1, ComponentModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentModel_CoreModel(), this.getCoreModel(), this.getCoreModel_Components(), "coreModel", null, 0, 1, ComponentModel.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(coreModelEClass, CoreModel.class, "CoreModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCoreModel_Components(), this.getComponentModel(), this.getComponentModel_CoreModel(), "components", null, 0, -1, CoreModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCoreModel_Responsibilities(), this.getResponsibility(), this.getResponsibility_CoreModel(), "responsibilities", null, 0, -1, CoreModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCoreModel_UseCaseMaps(), this.getUseCaseMap(), this.getUseCaseMap_CoreModel(), "useCaseMaps", null, 0, -1, CoreModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCoreModel_InterfaceLinks(), this.getInterfaceLink(), null, "interfaceLinks", null, 0, -1, CoreModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCoreModel_Relationships(), this.getRelationship(), null, "relationships", null, 0, -1, CoreModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCoreModel_Stereotypes(), this.getStereotype(), null, "stereotypes", null, 0, -1, CoreModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCoreModel_File(), theEditormodelPackage.getFlabotFileModel(), theEditormodelPackage.getFlabotFileModel_CoreModel(), "file", null, 0, 1, CoreModel.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCoreModel_Families(), this.getFamily(), null, "families", null, 0, -1, CoreModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCoreModel_ArchitecturalUseCaseMaps(), this.getUseCaseMap(), null, "architecturalUseCaseMaps", null, 0, -1, CoreModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCoreModel_FunctionalUseCaseMaps(), this.getUseCaseMap(), null, "functionalUseCaseMaps", null, 0, -1, CoreModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCoreModel_Events(), this.getConditionEvent(), null, "events", null, 0, -1, CoreModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCoreModel_Stubs(), this.getStubNode(), null, "stubs", null, 0, -1, CoreModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCoreModel_DynamicStubs(), this.getDynamicStubNode(), null, "dynamicStubs", null, 0, -1, CoreModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCoreModel_ConditionedStubs(), this.getConditionedStub(), null, "conditionedStubs", null, 0, -1, CoreModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureModelEClass, FeatureModel.class, "FeatureModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeatureModel_Components(), this.getComponentModel(), this.getComponentModel_Features(), "components", null, 0, -1, FeatureModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceModelEClass, InterfaceModel.class, "InterfaceModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterfaceModel_Port(), this.getPortModel(), null, "port", null, 0, 1, InterfaceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedElementModelEClass, NamedElementModel.class, "NamedElementModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElementModel_Name(), ecorePackage.getEString(), "name", "", 0, 1, NamedElementModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(portModelEClass, PortModel.class, "PortModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPortModel_Provideds(), this.getInterfaceModel(), null, "provideds", null, 0, -1, PortModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPortModel_Requireds(), this.getInterfaceModel(), null, "requireds", null, 0, -1, PortModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPortModel_Component(), this.getComponentModel(), this.getComponentModel_OwnedPorts(), "component", null, 0, 1, PortModel.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(responsibilityEClass, Responsibility.class, "Responsibility", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResponsibility_Description(), ecorePackage.getEString(), "description", "", 0, 1, Responsibility.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResponsibility_Preconditions(), this.getCondition(), null, "preconditions", null, 0, -1, Responsibility.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResponsibility_Postconditions(), this.getCondition(), null, "postconditions", null, 0, -1, Responsibility.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResponsibility_CoreModel(), this.getCoreModel(), this.getCoreModel_Responsibilities(), "coreModel", null, 0, 1, Responsibility.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(useCaseMapEClass, UseCaseMap.class, "UseCaseMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUseCaseMap_Paths(), this.getPath(), null, "paths", null, 0, -1, UseCaseMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseCaseMap_ComponentRoles(), this.getComponentRole(), this.getComponentRole_Map(), "componentRoles", null, 0, -1, UseCaseMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseCaseMap_CoreModel(), this.getCoreModel(), this.getCoreModel_UseCaseMaps(), "coreModel", null, 0, 1, UseCaseMap.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUseCaseMap_Description(), ecorePackage.getEString(), "description", "", 0, 1, UseCaseMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUseCaseMap_LevelInfo(), ecorePackage.getEString(), "levelInfo", null, 0, 1, UseCaseMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pathEClass, Path.class, "Path", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPath_Nodes(), this.getPathNode(), this.getPathNode_Path(), "nodes", null, 0, -1, Path.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPath_EndNodes(), this.getPathNode(), null, "endNodes", null, 0, -1, Path.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPath_StartNodes(), this.getPathNode(), null, "startNodes", null, 0, -1, Path.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pathNodeEClass, PathNode.class, "PathNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPathNode_Path(), this.getPath(), this.getPath_Nodes(), "path", null, 0, 1, PathNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPathNode_Previous(), this.getPathNode(), this.getPathNode_Next(), "previous", null, 0, -1, PathNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPathNode_Next(), this.getPathNode(), this.getPathNode_Previous(), "next", null, 0, -1, PathNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceLinkEClass, InterfaceLink.class, "InterfaceLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterfaceLink_Source(), this.getInterfaceModel(), null, "source", null, 0, 1, InterfaceLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceLink_Target(), this.getInterfaceModel(), null, "target", null, 0, 1, InterfaceLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyElementModelEClass, PropertyElementModel.class, "PropertyElementModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyElementModel_Properties(), this.getProperty(), null, "properties", null, 0, -1, PropertyElementModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProperty_Name(), ecorePackage.getEString(), "name", "", 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_Value(), ecorePackage.getEString(), "value", "", 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationshipEClass, Relationship.class, "Relationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationship_Source(), this.getComponentModel(), null, "source", null, 0, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationship_Target(), this.getComponentModel(), null, "target", null, 0, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationship_Direction(), this.getRelationshipDirection(), "direction", null, 0, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentRoleEClass, ComponentRole.class, "ComponentRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentRole_Component(), this.getComponentModel(), null, "component", null, 0, 1, ComponentRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentRole_Map(), this.getUseCaseMap(), this.getUseCaseMap_ComponentRoles(), "map", null, 0, 1, ComponentRole.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentRole_AbstractInfo(), ecorePackage.getEString(), "abstractInfo", null, 0, 1, ComponentRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentRole_ComponentType(), ecorePackage.getEInt(), "componentType", null, 0, 1, ComponentRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adapterEClass, Adapter.class, "Adapter", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(forkNodeEClass, ForkNode.class, "ForkNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getForkNode_ForkType(), ecorePackage.getEInt(), "forkType", "0", 0, 1, ForkNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForkNode_Conditions(), this.getForkCondition(), null, "conditions", null, 0, -1, ForkNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simplePathNodeEClass, SimplePathNode.class, "SimplePathNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimplePathNode_Map(), this.getUseCaseMap(), null, "map", null, 0, 1, SimplePathNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stereotypeEClass, Stereotype.class, "Stereotype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stereotypedElementModelEClass, StereotypedElementModel.class, "StereotypedElementModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStereotypedElementModel_Stereotype(), this.getStereotype(), null, "stereotype", null, 0, 1, StereotypedElementModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(responsibilityNodeEClass, ResponsibilityNode.class, "ResponsibilityNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResponsibilityNode_Responsibility(), this.getResponsibility(), null, "responsibility", null, 0, 1, ResponsibilityNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResponsibilityNode_Role(), this.getComponentRole(), null, "role", null, 0, 1, ResponsibilityNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResponsibilityNode_InputsCount(), ecorePackage.getEInt(), "inputsCount", "1", 0, 1, ResponsibilityNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResponsibilityNode_OutputsCount(), ecorePackage.getEInt(), "outputsCount", "1", 0, 1, ResponsibilityNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionEClass, Condition.class, "Condition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCondition_Value(), ecorePackage.getEString(), "value", "", 0, 1, Condition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCondition_UseCaseMap(), this.getUseCaseMap(), null, "useCaseMap", null, 0, 1, Condition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCondition_Event(), this.getConditionEvent(), null, "event", null, 0, 1, Condition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCondition_Family(), this.getFamily(), null, "family", null, 0, 1, Condition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCondition_SourceResponsibility(), this.getResponsibilityNode(), null, "sourceResponsibility", null, 0, 1, Condition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCondition_Type(), ecorePackage.getEString(), "type", "precondition", 0, 1, Condition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCondition_DependencyResponsibility(), this.getResponsibilityNode(), null, "dependencyResponsibility", null, 0, 1, Condition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(noteEClass, Note.class, "Note", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNote_Note(), ecorePackage.getEString(), "note", "", 0, 1, Note.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNote_Targets(), this.getNoteElementModel(), null, "targets", null, 0, -1, Note.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(noteElementModelEClass, NoteElementModel.class, "NoteElementModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNoteElementModel_Notes(), this.getNote(), null, "notes", null, 0, -1, NoteElementModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(familyEClass, Family.class, "Family", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFamily_FamilyElement(), this.getFamilyElement(), null, "familyElement", null, 0, -1, Family.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFamily_AssociatedResponsibilities(), this.getSimplePathNode(), null, "associatedResponsibilities", null, 0, -1, Family.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFamily_ArchitecturalUseCaseMaps(), this.getUseCaseMap(), null, "architecturalUseCaseMaps", null, 0, -1, Family.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFamily_FunctionalUseCaseMaps(), this.getUseCaseMap(), null, "functionalUseCaseMaps", null, 0, -1, Family.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFamily_Events(), this.getConditionEventToConditionEventMapEntry(), null, "events", null, 0, -1, Family.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(familyElementEClass, FamilyElement.class, "FamilyElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFamilyElement_UseCaseMap(), this.getUseCaseMap(), null, "useCaseMap", null, 0, 1, FamilyElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFamilyElement_FunctionalComponent(), this.getComponentRole(), null, "functionalComponent", null, 0, 1, FamilyElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFamilyElement_ArchitecturalComponent(), this.getComponentRole(), null, "architecturalComponent", null, 0, 1, FamilyElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfacePrologCodeEClass, InterfacePrologCode.class, "InterfacePrologCode", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(joinNodeEClass, JoinNode.class, "JoinNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJoinNode_JoinType(), ecorePackage.getEInt(), "joinType", "0", 0, 1, JoinNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(registrableEClass, Registrable.class, "Registrable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(responsibilityRegistryEClass, ResponsibilityRegistry.class, "ResponsibilityRegistry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResponsibilityRegistry_ResponsibilityBasedRegistry(), this.getResponsibilityToRegistrableMapEntry(), null, "responsibilityBasedRegistry", null, 0, -1, ResponsibilityRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResponsibilityRegistry_ComponentBasedRegistry(), this.getComponentToMapMapEntry(), null, "componentBasedRegistry", null, 0, -1, ResponsibilityRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResponsibilityRegistry_RoleBasedRegistry(), this.getRoleToMapMapEntry(), null, "roleBasedRegistry", null, 0, -1, ResponsibilityRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(responsibilityToRegistrableMapEntryEClass, Map.Entry.class, "ResponsibilityToRegistrableMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResponsibilityToRegistrableMapEntry_Key(), this.getResponsibility(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResponsibilityToRegistrableMapEntry_Value(), this.getRegistrable(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentToMapMapEntryEClass, Map.Entry.class, "ComponentToMapMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentToMapMapEntry_Key(), this.getComponentModel(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentToMapMapEntry_Value(), this.getResponsibilityToRegistrableMapEntry(), null, "value", null, 0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleToMapMapEntryEClass, Map.Entry.class, "RoleToMapMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoleToMapMapEntry_Key(), this.getComponentRole(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoleToMapMapEntry_Value(), this.getComponentToMapMapEntry(), null, "value", null, 0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stubNodeEClass, StubNode.class, "StubNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStubNode_StartPointReference(), this.getSimplePathNode(), null, "startPointReference", null, 0, 1, StubNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStubNode_EndPointReference(), this.getSimplePathNode(), null, "endPointReference", null, 0, 1, StubNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStubNode_ReferencedMap(), this.getUseCaseMap(), null, "referencedMap", null, 0, 1, StubNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStubNode_Family(), this.getFamily(), null, "family", null, 0, 1, StubNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forkConditionEClass, ForkCondition.class, "ForkCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getForkCondition_Condition(), ecorePackage.getEString(), "condition", "", 0, 1, ForkCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extensibleElementEClass, ExtensibleElement.class, "ExtensibleElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtensibleElement_ExtendedData(), this.getEStringToEObjectMapEntry(), null, "extendedData", null, 0, -1, ExtensibleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eStringToEObjectMapEntryEClass, Map.Entry.class, "EStringToEObjectMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEStringToEObjectMapEntry_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEStringToEObjectMapEntry_Value(), ecorePackage.getEObject(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionEventEClass, ConditionEvent.class, "ConditionEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConditionEvent_ConditionEvent(), ecorePackage.getEString(), "conditionEvent", "", 0, 1, ConditionEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConditionEvent_Description(), ecorePackage.getEString(), "description", "", 0, 1, ConditionEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionEvent_AssociatedConditions(), this.getCondition(), null, "associatedConditions", null, 0, -1, ConditionEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionEventToConditionEventMapEntryEClass, Map.Entry.class, "ConditionEventToConditionEventMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConditionEventToConditionEventMapEntry_Key(), this.getConditionEvent(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionEventToConditionEventMapEntry_Value(), this.getConditionEvent(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timerNodeEClass, TimerNode.class, "TimerNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimerNode_TimerName(), ecorePackage.getEString(), "timerName", "", 0, 1, TimerNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimerNode_TimerDescription(), ecorePackage.getEString(), "timerDescription", "", 0, 1, TimerNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimerNode_TimerType(), ecorePackage.getEInt(), "timerType", "0", 0, 1, TimerNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimerNode_TimerTimeOut(), ecorePackage.getEInt(), "timerTimeOut", "0", 0, 1, TimerNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimerNode_TimerTimeOutUnity(), ecorePackage.getEString(), "timerTimeOutUnity", "Hours", 0, 1, TimerNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(directionArrowNodeEClass, DirectionArrowNode.class, "DirectionArrowNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conditionedStubEClass, ConditionedStub.class, "ConditionedStub", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConditionedStub_Stub(), this.getStubNode(), null, "stub", null, 0, 1, ConditionedStub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionedStub_ResponsibilityNode(), this.getResponsibilityNode(), null, "responsibilityNode", null, 0, 1, ConditionedStub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dynamicStubNodeEClass, DynamicStubNode.class, "DynamicStubNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDynamicStubNode_ConditionedStubs(), this.getConditionedStub(), null, "conditionedStubs", null, 0, -1, DynamicStubNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(relationshipDirectionEEnum, RelationshipDirection.class, "RelationshipDirection");
		addEEnumLiteral(relationshipDirectionEEnum, RelationshipDirection.UNSPECIFIED_LITERAL);
		addEEnumLiteral(relationshipDirectionEEnum, RelationshipDirection.SOURCE_LITERAL);
		addEEnumLiteral(relationshipDirectionEEnum, RelationshipDirection.TARGET_LITERAL);
		addEEnumLiteral(relationshipDirectionEEnum, RelationshipDirection.BIDIRECTIONAL_LITERAL);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";		
		addAnnotation
		  (coreModelEClass, 
		   source, 
		   new String[] {
			 "constraints", "ResponsibilityGeneral ConditionEventGeneral"
		   });		
		addAnnotation
		  (useCaseMapEClass, 
		   source, 
		   new String[] {
			 "constraints", "UseCaseMapGeneral"
		   });		
		addAnnotation
		  (interfaceLinkEClass, 
		   source, 
		   new String[] {
			 "constraints", "InterfacesMustHaveSameName"
		   });		
		addAnnotation
		  (responsibilityNodeEClass, 
		   source, 
		   new String[] {
			 "constraints", "ResponsibilityNodeGeneral"
		   });		
		addAnnotation
		  (conditionEClass, 
		   source, 
		   new String[] {
			 "constraints", "ConditionMappingHasCorrectFamily"
		   });		
		addAnnotation
		  (familyEClass, 
		   source, 
		   new String[] {
			 "constraints", "FamilyHasAllComponent"
		   });
	}

} //CoremodelPackageImpl
