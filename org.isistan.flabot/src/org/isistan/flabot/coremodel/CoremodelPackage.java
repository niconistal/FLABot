/**
 * <copyright>
 * </copyright>
 *
 * $Id: CoremodelPackage.java,v 1.60 2006/04/11 04:21:25 apersson Exp $
 */
package org.isistan.flabot.coremodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.coremodel.CoremodelFactory
 * @model kind="package"
 * @generated
 */
public interface CoremodelPackage extends EPackage{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "coremodel"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/isistan/flabot/coremodel.ecore"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.isistan.flabot.coremodel"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CoremodelPackage eINSTANCE = org.isistan.flabot.coremodel.impl.CoremodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.NamedElementModelImpl <em>Named Element Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.NamedElementModelImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getNamedElementModel()
	 * @generated
	 */
	int NAMED_ELEMENT_MODEL = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_MODEL__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_MODEL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.FeatureModelImpl <em>Feature Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.FeatureModelImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getFeatureModel()
	 * @generated
	 */
	int FEATURE_MODEL = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODEL__NAME = NAMED_ELEMENT_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODEL__EXTENDED_DATA = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Components</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODEL__COMPONENTS = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Feature Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODEL_FEATURE_COUNT = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.BehavioralFeatureModelImpl <em>Behavioral Feature Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.BehavioralFeatureModelImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getBehavioralFeatureModel()
	 * @generated
	 */
	int BEHAVIORAL_FEATURE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIORAL_FEATURE_MODEL__NAME = FEATURE_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIORAL_FEATURE_MODEL__EXTENDED_DATA = FEATURE_MODEL__EXTENDED_DATA;

	/**
	 * The feature id for the '<em><b>Components</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIORAL_FEATURE_MODEL__COMPONENTS = FEATURE_MODEL__COMPONENTS;

	/**
	 * The number of structural features of the '<em>Behavioral Feature Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIORAL_FEATURE_MODEL_FEATURE_COUNT = FEATURE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.ComponentModelImpl <em>Component Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.ComponentModelImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getComponentModel()
	 * @generated
	 */
	int COMPONENT_MODEL = 1;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.CoreModelImpl <em>Core Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.CoreModelImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getCoreModel()
	 * @generated
	 */
	int CORE_MODEL = 2;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.InterfaceModelImpl <em>Interface Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.InterfaceModelImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getInterfaceModel()
	 * @generated
	 */
	int INTERFACE_MODEL = 4;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.PortModelImpl <em>Port Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.PortModelImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getPortModel()
	 * @generated
	 */
	int PORT_MODEL = 6;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.ResponsibilityImpl <em>Responsibility</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.ResponsibilityImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getResponsibility()
	 * @generated
	 */
	int RESPONSIBILITY = 7;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.UseCaseMapImpl <em>Use Case Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.UseCaseMapImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getUseCaseMap()
	 * @generated
	 */
	int USE_CASE_MAP = 8;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.PathImpl <em>Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.PathImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getPath()
	 * @generated
	 */
	int PATH = 9;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.PathNodeImpl <em>Path Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.PathNodeImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getPathNode()
	 * @generated
	 */
	int PATH_NODE = 10;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.InterfaceLinkImpl <em>Interface Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.InterfaceLinkImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getInterfaceLink()
	 * @generated
	 */
	int INTERFACE_LINK = 11;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.PropertyElementModelImpl <em>Property Element Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.PropertyElementModelImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getPropertyElementModel()
	 * @generated
	 */
	int PROPERTY_ELEMENT_MODEL = 12;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.PropertyImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 13;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.RelationshipImpl <em>Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.RelationshipImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getRelationship()
	 * @generated
	 */
	int RELATIONSHIP = 14;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.ComponentRoleImpl <em>Component Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.ComponentRoleImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getComponentRole()
	 * @generated
	 */
	int COMPONENT_ROLE = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.common.notify.Adapter <em>Adapter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.notify.Adapter
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getAdapter()
	 * @generated
	 */
	int ADAPTER = 16;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.ForkNodeImpl <em>Fork Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.ForkNodeImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getForkNode()
	 * @generated
	 */
	int FORK_NODE = 17;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.SimplePathNodeImpl <em>Simple Path Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.SimplePathNodeImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getSimplePathNode()
	 * @generated
	 */
	int SIMPLE_PATH_NODE = 18;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.StereotypeImpl <em>Stereotype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.StereotypeImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getStereotype()
	 * @generated
	 */
	int STEREOTYPE = 19;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.StereotypedElementModelImpl <em>Stereotyped Element Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.StereotypedElementModelImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getStereotypedElementModel()
	 * @generated
	 */
	int STEREOTYPED_ELEMENT_MODEL = 20;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.ResponsibilityNodeImpl <em>Responsibility Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.ResponsibilityNodeImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getResponsibilityNode()
	 * @generated
	 */
	int RESPONSIBILITY_NODE = 21;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.ConditionImpl <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.ConditionImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 22;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.NoteImpl <em>Note</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.NoteImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getNote()
	 * @generated
	 */
	int NOTE = 23;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.NoteElementModelImpl <em>Note Element Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.NoteElementModelImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getNoteElementModel()
	 * @generated
	 */
	int NOTE_ELEMENT_MODEL = 24;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.FamilyImpl <em>Family</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.FamilyImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getFamily()
	 * @generated
	 */
	int FAMILY = 25;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.FamilyElementImpl <em>Family Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.FamilyElementImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getFamilyElement()
	 * @generated
	 */
	int FAMILY_ELEMENT = 26;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.InterfacePrologCode <em>Interface Prolog Code</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.InterfacePrologCode
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getInterfacePrologCode()
	 * @generated
	 */
	int INTERFACE_PROLOG_CODE = 27;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.JoinNodeImpl <em>Join Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.JoinNodeImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getJoinNode()
	 * @generated
	 */
	int JOIN_NODE = 28;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.Registrable <em>Registrable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.Registrable
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getRegistrable()
	 * @generated
	 */
	int REGISTRABLE = 29;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.ResponsibilityRegistryImpl <em>Responsibility Registry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.ResponsibilityRegistryImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getResponsibilityRegistry()
	 * @generated
	 */
	int RESPONSIBILITY_REGISTRY = 30;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.ResponsibilityToRegistrableMapEntryImpl <em>Responsibility To Registrable Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.ResponsibilityToRegistrableMapEntryImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getResponsibilityToRegistrableMapEntry()
	 * @generated
	 */
	int RESPONSIBILITY_TO_REGISTRABLE_MAP_ENTRY = 31;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.ComponentToMapMapEntryImpl <em>Component To Map Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.ComponentToMapMapEntryImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getComponentToMapMapEntry()
	 * @generated
	 */
	int COMPONENT_TO_MAP_MAP_ENTRY = 32;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.RoleToMapMapEntryImpl <em>Role To Map Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.RoleToMapMapEntryImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getRoleToMapMapEntry()
	 * @generated
	 */
	int ROLE_TO_MAP_MAP_ENTRY = 33;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.StubNodeImpl <em>Stub Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.StubNodeImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getStubNode()
	 * @generated
	 */
	int STUB_NODE = 34;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.ForkConditionImpl <em>Fork Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.ForkConditionImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getForkCondition()
	 * @generated
	 */
	int FORK_CONDITION = 35;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.ExtensibleElementImpl <em>Extensible Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.ExtensibleElementImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getExtensibleElement()
	 * @generated
	 */
	int EXTENSIBLE_ELEMENT = 36;
	
	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.TimerNodeImpl <em>Timer Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.TimerNodeImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getTimerNode()
	 * @generated
	 */
	int TIMER_NODE = 40;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSIBLE_ELEMENT__EXTENDED_DATA = 0;

	/**
	 * The number of structural features of the '<em>Extensible Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSIBLE_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_MODEL__EXTENDED_DATA = EXTENSIBLE_ELEMENT__EXTENDED_DATA;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_MODEL__NAME = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_MODEL__PROPERTIES = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_MODEL__STEREOTYPE = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_MODEL__NOTES = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_MODEL__FEATURES = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Owned Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_MODEL__OWNED_PORTS = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Core Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_MODEL__CORE_MODEL = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Component Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_MODEL_FEATURE_COUNT = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__COMPONENTS = 0;

	/**
	 * The feature id for the '<em><b>Responsibilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__RESPONSIBILITIES = 1;

	/**
	 * The feature id for the '<em><b>Use Case Maps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__USE_CASE_MAPS = 2;

	/**
	 * The feature id for the '<em><b>Interface Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__INTERFACE_LINKS = 3;

	/**
	 * The feature id for the '<em><b>Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__RELATIONSHIPS = 4;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__STEREOTYPES = 5;

	/**
	 * The feature id for the '<em><b>File</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__FILE = 6;

	/**
	 * The feature id for the '<em><b>Families</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__FAMILIES = 7;

	/**
	 * The feature id for the '<em><b>Architectural Use Case Maps</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__ARCHITECTURAL_USE_CASE_MAPS = 8;

	/**
	 * The feature id for the '<em><b>Functional Use Case Maps</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__FUNCTIONAL_USE_CASE_MAPS = 9;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__EVENTS = 10;

	/**
	 * The feature id for the '<em><b>Stubs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__STUBS = 11;

	/**
	 * The feature id for the '<em><b>Dynamic Stubs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__DYNAMIC_STUBS = 12;

	/**
	 * The feature id for the '<em><b>Conditioned Stubs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__CONDITIONED_STUBS = 13;

	/**
	 * The number of structural features of the '<em>Core Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL_FEATURE_COUNT = 14;
	
	/**
	 * The feature id for the '<em><b>Timers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	int CORE_MODEL__TIMERS = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_MODEL__NAME = NAMED_ELEMENT_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_MODEL__PORT = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Interface Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_MODEL_FEATURE_COUNT = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_MODEL__NAME = NAMED_ELEMENT_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_MODEL__PROPERTIES = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Provideds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_MODEL__PROVIDEDS = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Requireds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_MODEL__REQUIREDS = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Component</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_MODEL__COMPONENT = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Port Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_MODEL_FEATURE_COUNT = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY__NAME = BEHAVIORAL_FEATURE_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY__EXTENDED_DATA = BEHAVIORAL_FEATURE_MODEL__EXTENDED_DATA;

	/**
	 * The feature id for the '<em><b>Components</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY__COMPONENTS = BEHAVIORAL_FEATURE_MODEL__COMPONENTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY__DESCRIPTION = BEHAVIORAL_FEATURE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Preconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY__PRECONDITIONS = BEHAVIORAL_FEATURE_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Postconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY__POSTCONDITIONS = BEHAVIORAL_FEATURE_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Core Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY__CORE_MODEL = BEHAVIORAL_FEATURE_MODEL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Responsibility</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_FEATURE_COUNT = BEHAVIORAL_FEATURE_MODEL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_MAP__NAME = NAMED_ELEMENT_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Paths</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_MAP__PATHS = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Component Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_MAP__COMPONENT_ROLES = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Core Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_MAP__CORE_MODEL = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_MAP__DESCRIPTION = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Level Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_MAP__LEVEL_INFO = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Use Case Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_MAP_FEATURE_COUNT = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 5;


	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH__NAME = NAMED_ELEMENT_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH__NODES = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH__END_NODES = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Start Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH__START_NODES = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_FEATURE_COUNT = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE_ELEMENT_MODEL__NOTES = 0;

	/**
	 * The number of structural features of the '<em>Note Element Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE_ELEMENT_MODEL_FEATURE_COUNT = 1;


	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NODE__NOTES = NOTE_ELEMENT_MODEL__NOTES;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NODE__EXTENDED_DATA = NOTE_ELEMENT_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NODE__PATH = NOTE_ELEMENT_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Previous</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NODE__PREVIOUS = NOTE_ELEMENT_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NODE__NEXT = NOTE_ELEMENT_MODEL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Path Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NODE_FEATURE_COUNT = NOTE_ELEMENT_MODEL_FEATURE_COUNT + 4;


	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_LINK__NAME = NAMED_ELEMENT_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_LINK__NOTES = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_LINK__SOURCE = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_LINK__TARGET = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Interface Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_LINK_FEATURE_COUNT = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ELEMENT_MODEL__PROPERTIES = 0;

	/**
	 * The number of structural features of the '<em>Property Element Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ELEMENT_MODEL_FEATURE_COUNT = 1;


	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = 2;


	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__NAME = NAMED_ELEMENT_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__PROPERTIES = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__STEREOTYPE = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__NOTES = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__SOURCE = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__TARGET = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__DIRECTION = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP_FEATURE_COUNT = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 6;


	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ROLE__EXTENDED_DATA = EXTENSIBLE_ELEMENT__EXTENDED_DATA;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ROLE__NAME = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ROLE__NOTES = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ROLE__COMPONENT = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Map</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ROLE__MAP = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Abstract Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ROLE__ABSTRACT_INFO = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Component Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ROLE__COMPONENT_TYPE = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Component Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ROLE_FEATURE_COUNT = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Adapter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_FEATURE_COUNT = 0;


	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PATH_NODE__NOTES = PATH_NODE__NOTES;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PATH_NODE__EXTENDED_DATA = PATH_NODE__EXTENDED_DATA;

	/**
	 * The feature id for the '<em><b>Path</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PATH_NODE__PATH = PATH_NODE__PATH;

	/**
	 * The feature id for the '<em><b>Previous</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PATH_NODE__PREVIOUS = PATH_NODE__PREVIOUS;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PATH_NODE__NEXT = PATH_NODE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PATH_NODE__NAME = PATH_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Map</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PATH_NODE__MAP = PATH_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Simple Path Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PATH_NODE_FEATURE_COUNT = PATH_NODE_FEATURE_COUNT + 2;


	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_NODE__NOTES = SIMPLE_PATH_NODE__NOTES;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_NODE__EXTENDED_DATA = SIMPLE_PATH_NODE__EXTENDED_DATA;

	/**
	 * The feature id for the '<em><b>Path</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_NODE__PATH = SIMPLE_PATH_NODE__PATH;

	/**
	 * The feature id for the '<em><b>Previous</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_NODE__PREVIOUS = SIMPLE_PATH_NODE__PREVIOUS;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_NODE__NEXT = SIMPLE_PATH_NODE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_NODE__NAME = SIMPLE_PATH_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Map</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_NODE__MAP = SIMPLE_PATH_NODE__MAP;

	/**
	 * The feature id for the '<em><b>Responsibility</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_NODE__RESPONSIBILITY = SIMPLE_PATH_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_NODE__ROLE = SIMPLE_PATH_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Inputs Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_NODE__INPUTS_COUNT = SIMPLE_PATH_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Outputs Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_NODE__OUTPUTS_COUNT = SIMPLE_PATH_NODE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Responsibility Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_NODE_FEATURE_COUNT = SIMPLE_PATH_NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_NODE__NOTES = RESPONSIBILITY_NODE__NOTES;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_NODE__EXTENDED_DATA = RESPONSIBILITY_NODE__EXTENDED_DATA;

	/**
	 * The feature id for the '<em><b>Path</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_NODE__PATH = RESPONSIBILITY_NODE__PATH;

	/**
	 * The feature id for the '<em><b>Previous</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_NODE__PREVIOUS = RESPONSIBILITY_NODE__PREVIOUS;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_NODE__NEXT = RESPONSIBILITY_NODE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_NODE__NAME = RESPONSIBILITY_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Map</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_NODE__MAP = RESPONSIBILITY_NODE__MAP;

	/**
	 * The feature id for the '<em><b>Responsibility</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_NODE__RESPONSIBILITY = RESPONSIBILITY_NODE__RESPONSIBILITY;

	/**
	 * The feature id for the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_NODE__ROLE = RESPONSIBILITY_NODE__ROLE;

	/**
	 * The feature id for the '<em><b>Inputs Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_NODE__INPUTS_COUNT = RESPONSIBILITY_NODE__INPUTS_COUNT;

	/**
	 * The feature id for the '<em><b>Outputs Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_NODE__OUTPUTS_COUNT = RESPONSIBILITY_NODE__OUTPUTS_COUNT;

	/**
	 * The feature id for the '<em><b>Fork Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_NODE__FORK_TYPE = RESPONSIBILITY_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_NODE__CONDITIONS = RESPONSIBILITY_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Fork Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_NODE_FEATURE_COUNT = RESPONSIBILITY_NODE_FEATURE_COUNT + 2;


	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__NAME = NAMED_ELEMENT_MODEL__NAME;

	/**
	 * The number of structural features of the '<em>Stereotype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FEATURE_COUNT = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPED_ELEMENT_MODEL__STEREOTYPE = 0;

	/**
	 * The number of structural features of the '<em>Stereotyped Element Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPED_ELEMENT_MODEL_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__NAME = NAMED_ELEMENT_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__VALUE = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Use Case Map</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__USE_CASE_MAP = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__EVENT = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Family</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__FAMILY = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Source Responsibility</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__SOURCE_RESPONSIBILITY = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__TYPE = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Dependency Responsibility</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__DEPENDENCY_RESPONSIBILITY = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE__NOTE = 0;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE__TARGETS = 1;

	/**
	 * The number of structural features of the '<em>Note</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAMILY__NAME = NAMED_ELEMENT_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Family Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAMILY__FAMILY_ELEMENT = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Associated Responsibilities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAMILY__ASSOCIATED_RESPONSIBILITIES = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Architectural Use Case Maps</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAMILY__ARCHITECTURAL_USE_CASE_MAPS = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Functional Use Case Maps</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAMILY__FUNCTIONAL_USE_CASE_MAPS = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Events</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAMILY__EVENTS = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Family</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAMILY_FEATURE_COUNT = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 5;


	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAMILY_ELEMENT__NAME = NAMED_ELEMENT_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Use Case Map</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAMILY_ELEMENT__USE_CASE_MAP = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Functional Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAMILY_ELEMENT__FUNCTIONAL_COMPONENT = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Architectural Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAMILY_ELEMENT__ARCHITECTURAL_COMPONENT = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Family Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAMILY_ELEMENT_FEATURE_COUNT = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 3;


	/**
	 * The number of structural features of the '<em>Interface Prolog Code</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PROLOG_CODE_FEATURE_COUNT = 0;


	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_NODE__NOTES = RESPONSIBILITY_NODE__NOTES;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_NODE__EXTENDED_DATA = RESPONSIBILITY_NODE__EXTENDED_DATA;

	/**
	 * The feature id for the '<em><b>Path</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_NODE__PATH = RESPONSIBILITY_NODE__PATH;

	/**
	 * The feature id for the '<em><b>Previous</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_NODE__PREVIOUS = RESPONSIBILITY_NODE__PREVIOUS;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_NODE__NEXT = RESPONSIBILITY_NODE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_NODE__NAME = RESPONSIBILITY_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Map</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_NODE__MAP = RESPONSIBILITY_NODE__MAP;

	/**
	 * The feature id for the '<em><b>Responsibility</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_NODE__RESPONSIBILITY = RESPONSIBILITY_NODE__RESPONSIBILITY;

	/**
	 * The feature id for the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_NODE__ROLE = RESPONSIBILITY_NODE__ROLE;

	/**
	 * The feature id for the '<em><b>Inputs Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_NODE__INPUTS_COUNT = RESPONSIBILITY_NODE__INPUTS_COUNT;

	/**
	 * The feature id for the '<em><b>Outputs Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_NODE__OUTPUTS_COUNT = RESPONSIBILITY_NODE__OUTPUTS_COUNT;

	/**
	 * The feature id for the '<em><b>Join Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_NODE__JOIN_TYPE = RESPONSIBILITY_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Join Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_NODE_FEATURE_COUNT = RESPONSIBILITY_NODE_FEATURE_COUNT + 1;
	
	/**
	 * The number of structural features of the '<em>Registrable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTRABLE_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Responsibility Based Registry</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_REGISTRY__RESPONSIBILITY_BASED_REGISTRY = 0;

	/**
	 * The feature id for the '<em><b>Component Based Registry</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_REGISTRY__COMPONENT_BASED_REGISTRY = 1;

	/**
	 * The feature id for the '<em><b>Role Based Registry</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_REGISTRY__ROLE_BASED_REGISTRY = 2;

	/**
	 * The number of structural features of the '<em>Responsibility Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_REGISTRY_FEATURE_COUNT = 3;


	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_TO_REGISTRABLE_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_TO_REGISTRABLE_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Responsibility To Registrable Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_TO_REGISTRABLE_MAP_ENTRY_FEATURE_COUNT = 2;


	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TO_MAP_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TO_MAP_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Component To Map Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TO_MAP_MAP_ENTRY_FEATURE_COUNT = 2;


	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_TO_MAP_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_TO_MAP_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Role To Map Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_TO_MAP_MAP_ENTRY_FEATURE_COUNT = 2;


	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUB_NODE__NOTES = SIMPLE_PATH_NODE__NOTES;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUB_NODE__EXTENDED_DATA = SIMPLE_PATH_NODE__EXTENDED_DATA;

	/**
	 * The feature id for the '<em><b>Path</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUB_NODE__PATH = SIMPLE_PATH_NODE__PATH;

	/**
	 * The feature id for the '<em><b>Previous</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUB_NODE__PREVIOUS = SIMPLE_PATH_NODE__PREVIOUS;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUB_NODE__NEXT = SIMPLE_PATH_NODE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUB_NODE__NAME = SIMPLE_PATH_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Map</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUB_NODE__MAP = SIMPLE_PATH_NODE__MAP;

	/**
	 * The feature id for the '<em><b>Start Point Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUB_NODE__START_POINT_REFERENCE = SIMPLE_PATH_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Point Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUB_NODE__END_POINT_REFERENCE = SIMPLE_PATH_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referenced Map</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUB_NODE__REFERENCED_MAP = SIMPLE_PATH_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Family</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUB_NODE__FAMILY = SIMPLE_PATH_NODE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Stub Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUB_NODE_FEATURE_COUNT = SIMPLE_PATH_NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_CONDITION__NAME = NAMED_ELEMENT_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_CONDITION__CONDITION = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Fork Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_CONDITION_FEATURE_COUNT = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.EStringToEObjectMapEntryImpl <em>EString To EObject Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.EStringToEObjectMapEntryImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getEStringToEObjectMapEntry()
	 * @generated
	 */
	int ESTRING_TO_EOBJECT_MAP_ENTRY = 37;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EOBJECT_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EOBJECT_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EString To EObject Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EOBJECT_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.ConditionEventImpl <em>Condition Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.ConditionEventImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getConditionEvent()
	 * @generated
	 */
	int CONDITION_EVENT = 38;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EVENT__NAME = NAMED_ELEMENT_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EVENT__EXTENDED_DATA = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EVENT__CONDITION_EVENT = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EVENT__DESCRIPTION = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Associated Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EVENT__ASSOCIATED_CONDITIONS = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Condition Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EVENT_FEATURE_COUNT = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.ConditionEventToConditionEventMapEntryImpl <em>Condition Event To Condition Event Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.ConditionEventToConditionEventMapEntryImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getConditionEventToConditionEventMapEntry()
	 * @generated
	 */
	int CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY = 39;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Condition Event To Condition Event Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_NODE__NOTES = RESPONSIBILITY_NODE__NOTES;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_NODE__EXTENDED_DATA = RESPONSIBILITY_NODE__EXTENDED_DATA;

	/**
	 * The feature id for the '<em><b>Path</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_NODE__PATH = RESPONSIBILITY_NODE__PATH;

	/**
	 * The feature id for the '<em><b>Previous</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_NODE__PREVIOUS = RESPONSIBILITY_NODE__PREVIOUS;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_NODE__NEXT = RESPONSIBILITY_NODE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_NODE__NAME = RESPONSIBILITY_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Map</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_NODE__MAP = RESPONSIBILITY_NODE__MAP;

	/**
	 * The feature id for the '<em><b>Responsibility</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_NODE__RESPONSIBILITY = RESPONSIBILITY_NODE__RESPONSIBILITY;

	/**
	 * The feature id for the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_NODE__ROLE = RESPONSIBILITY_NODE__ROLE;

	/**
	 * The feature id for the '<em><b>Inputs Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_NODE__INPUTS_COUNT = RESPONSIBILITY_NODE__INPUTS_COUNT;

	/**
	 * The feature id for the '<em><b>Outputs Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_NODE__OUTPUTS_COUNT = RESPONSIBILITY_NODE__OUTPUTS_COUNT;

	/**
	 * The feature id for the '<em><b>Timer Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_NODE__TIMER_NAME = RESPONSIBILITY_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Timer Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_NODE__TIMER_DESCRIPTION = RESPONSIBILITY_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Timer Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_NODE__TIMER_TYPE = RESPONSIBILITY_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Timer Time Out</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_NODE__TIMER_TIME_OUT = RESPONSIBILITY_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Timer Time Out Unity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_NODE__TIMER_TIME_OUT_UNITY = RESPONSIBILITY_NODE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Timer Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_NODE_FEATURE_COUNT = RESPONSIBILITY_NODE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.DirectionArrowNodeImpl <em>Direction Arrow Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.DirectionArrowNodeImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getDirectionArrowNode()
	 * @generated
	 */
	int DIRECTION_ARROW_NODE = 41;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_ARROW_NODE__NOTES = SIMPLE_PATH_NODE__NOTES;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_ARROW_NODE__EXTENDED_DATA = SIMPLE_PATH_NODE__EXTENDED_DATA;

	/**
	 * The feature id for the '<em><b>Path</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_ARROW_NODE__PATH = SIMPLE_PATH_NODE__PATH;

	/**
	 * The feature id for the '<em><b>Previous</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_ARROW_NODE__PREVIOUS = SIMPLE_PATH_NODE__PREVIOUS;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_ARROW_NODE__NEXT = SIMPLE_PATH_NODE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_ARROW_NODE__NAME = SIMPLE_PATH_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Map</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_ARROW_NODE__MAP = SIMPLE_PATH_NODE__MAP;

	/**
	 * The number of structural features of the '<em>Direction Arrow Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_ARROW_NODE_FEATURE_COUNT = SIMPLE_PATH_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.ConditionedStubImpl <em>Conditioned Stub</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.ConditionedStubImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getConditionedStub()
	 * @generated
	 */
	int CONDITIONED_STUB = 42;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONED_STUB__NAME = NAMED_ELEMENT_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Stub</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONED_STUB__STUB = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Responsibility Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONED_STUB__RESPONSIBILITY_NODE = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Conditioned Stub</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONED_STUB_FEATURE_COUNT = NAMED_ELEMENT_MODEL_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.impl.DynamicStubNodeImpl <em>Dynamic Stub Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.impl.DynamicStubNodeImpl
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getDynamicStubNode()
	 * @generated
	 */
	int DYNAMIC_STUB_NODE = 43;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_STUB_NODE__NOTES = SIMPLE_PATH_NODE__NOTES;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_STUB_NODE__EXTENDED_DATA = SIMPLE_PATH_NODE__EXTENDED_DATA;

	/**
	 * The feature id for the '<em><b>Path</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_STUB_NODE__PATH = SIMPLE_PATH_NODE__PATH;

	/**
	 * The feature id for the '<em><b>Previous</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_STUB_NODE__PREVIOUS = SIMPLE_PATH_NODE__PREVIOUS;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_STUB_NODE__NEXT = SIMPLE_PATH_NODE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_STUB_NODE__NAME = SIMPLE_PATH_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Map</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_STUB_NODE__MAP = SIMPLE_PATH_NODE__MAP;

	/**
	 * The feature id for the '<em><b>Conditioned Stubs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_STUB_NODE__CONDITIONED_STUBS = SIMPLE_PATH_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dynamic Stub Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_STUB_NODE_FEATURE_COUNT = SIMPLE_PATH_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.coremodel.RelationshipDirection <em>Relationship Direction</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.coremodel.RelationshipDirection
	 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getRelationshipDirection()
	 * @generated
	 */
	int RELATIONSHIP_DIRECTION = 44;


	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.BehavioralFeatureModel <em>Behavioral Feature Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavioral Feature Model</em>'.
	 * @see org.isistan.flabot.coremodel.BehavioralFeatureModel
	 * @generated
	 */
	EClass getBehavioralFeatureModel();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.ComponentModel <em>Component Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Model</em>'.
	 * @see org.isistan.flabot.coremodel.ComponentModel
	 * @generated
	 */
	EClass getComponentModel();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.coremodel.ComponentModel#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Features</em>'.
	 * @see org.isistan.flabot.coremodel.ComponentModel#getFeatures()
	 * @see #getComponentModel()
	 * @generated
	 */
	EReference getComponentModel_Features();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.coremodel.ComponentModel#getOwnedPorts <em>Owned Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Ports</em>'.
	 * @see org.isistan.flabot.coremodel.ComponentModel#getOwnedPorts()
	 * @see #getComponentModel()
	 * @generated
	 */
	EReference getComponentModel_OwnedPorts();

	/**
	 * Returns the meta object for the container reference '{@link org.isistan.flabot.coremodel.ComponentModel#getCoreModel <em>Core Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Core Model</em>'.
	 * @see org.isistan.flabot.coremodel.ComponentModel#getCoreModel()
	 * @see #getComponentModel()
	 * @generated
	 */
	EReference getComponentModel_CoreModel();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.CoreModel <em>Core Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Model</em>'.
	 * @see org.isistan.flabot.coremodel.CoreModel
	 * @generated
	 */
	EClass getCoreModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.coremodel.CoreModel#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see org.isistan.flabot.coremodel.CoreModel#getComponents()
	 * @see #getCoreModel()
	 * @generated
	 */
	EReference getCoreModel_Components();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.coremodel.CoreModel#getResponsibilities <em>Responsibilities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Responsibilities</em>'.
	 * @see org.isistan.flabot.coremodel.CoreModel#getResponsibilities()
	 * @see #getCoreModel()
	 * @generated
	 */
	EReference getCoreModel_Responsibilities();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.coremodel.CoreModel#getUseCaseMaps <em>Use Case Maps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Use Case Maps</em>'.
	 * @see org.isistan.flabot.coremodel.CoreModel#getUseCaseMaps()
	 * @see #getCoreModel()
	 * @generated
	 */
	EReference getCoreModel_UseCaseMaps();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.coremodel.CoreModel#getInterfaceLinks <em>Interface Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Interface Links</em>'.
	 * @see org.isistan.flabot.coremodel.CoreModel#getInterfaceLinks()
	 * @see #getCoreModel()
	 * @generated
	 */
	EReference getCoreModel_InterfaceLinks();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.coremodel.CoreModel#getRelationships <em>Relationships</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Relationships</em>'.
	 * @see org.isistan.flabot.coremodel.CoreModel#getRelationships()
	 * @see #getCoreModel()
	 * @generated
	 */
	EReference getCoreModel_Relationships();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.coremodel.CoreModel#getStereotypes <em>Stereotypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stereotypes</em>'.
	 * @see org.isistan.flabot.coremodel.CoreModel#getStereotypes()
	 * @see #getCoreModel()
	 * @generated
	 */
	EReference getCoreModel_Stereotypes();

	/**
	 * Returns the meta object for the container reference '{@link org.isistan.flabot.coremodel.CoreModel#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>File</em>'.
	 * @see org.isistan.flabot.coremodel.CoreModel#getFile()
	 * @see #getCoreModel()
	 * @generated
	 */
	EReference getCoreModel_File();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.coremodel.CoreModel#getFamilies <em>Families</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Families</em>'.
	 * @see org.isistan.flabot.coremodel.CoreModel#getFamilies()
	 * @see #getCoreModel()
	 * @generated
	 */
	EReference getCoreModel_Families();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.coremodel.CoreModel#getArchitecturalUseCaseMaps <em>Architectural Use Case Maps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Architectural Use Case Maps</em>'.
	 * @see org.isistan.flabot.coremodel.CoreModel#getArchitecturalUseCaseMaps()
	 * @see #getCoreModel()
	 * @generated
	 */
	EReference getCoreModel_ArchitecturalUseCaseMaps();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.coremodel.CoreModel#getFunctionalUseCaseMaps <em>Functional Use Case Maps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Functional Use Case Maps</em>'.
	 * @see org.isistan.flabot.coremodel.CoreModel#getFunctionalUseCaseMaps()
	 * @see #getCoreModel()
	 * @generated
	 */
	EReference getCoreModel_FunctionalUseCaseMaps();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.coremodel.CoreModel#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Events</em>'.
	 * @see org.isistan.flabot.coremodel.CoreModel#getEvents()
	 * @see #getCoreModel()
	 * @generated
	 */
	EReference getCoreModel_Events();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.coremodel.CoreModel#getStubs <em>Stubs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Stubs</em>'.
	 * @see org.isistan.flabot.coremodel.CoreModel#getStubs()
	 * @see #getCoreModel()
	 * @generated
	 */
	EReference getCoreModel_Stubs();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.coremodel.CoreModel#getDynamicStubs <em>Dynamic Stubs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dynamic Stubs</em>'.
	 * @see org.isistan.flabot.coremodel.CoreModel#getDynamicStubs()
	 * @see #getCoreModel()
	 * @generated
	 */
	EReference getCoreModel_DynamicStubs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.coremodel.CoreModel#getConditionedStubs <em>Conditioned Stubs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conditioned Stubs</em>'.
	 * @see org.isistan.flabot.coremodel.CoreModel#getConditionedStubs()
	 * @see #getCoreModel()
	 * @generated
	 */
	EReference getCoreModel_ConditionedStubs();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.FeatureModel <em>Feature Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Model</em>'.
	 * @see org.isistan.flabot.coremodel.FeatureModel
	 * @generated
	 */
	EClass getFeatureModel();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.coremodel.FeatureModel#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Components</em>'.
	 * @see org.isistan.flabot.coremodel.FeatureModel#getComponents()
	 * @see #getFeatureModel()
	 * @generated
	 */
	EReference getFeatureModel_Components();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.InterfaceModel <em>Interface Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Model</em>'.
	 * @see org.isistan.flabot.coremodel.InterfaceModel
	 * @generated
	 */
	EClass getInterfaceModel();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.coremodel.InterfaceModel#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see org.isistan.flabot.coremodel.InterfaceModel#getPort()
	 * @see #getInterfaceModel()
	 * @generated
	 */
	EReference getInterfaceModel_Port();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.NamedElementModel <em>Named Element Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element Model</em>'.
	 * @see org.isistan.flabot.coremodel.NamedElementModel
	 * @generated
	 */
	EClass getNamedElementModel();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.NamedElementModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.isistan.flabot.coremodel.NamedElementModel#getName()
	 * @see #getNamedElementModel()
	 * @generated
	 */
	EAttribute getNamedElementModel_Name();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.PortModel <em>Port Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Model</em>'.
	 * @see org.isistan.flabot.coremodel.PortModel
	 * @generated
	 */
	EClass getPortModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.coremodel.PortModel#getProvideds <em>Provideds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Provideds</em>'.
	 * @see org.isistan.flabot.coremodel.PortModel#getProvideds()
	 * @see #getPortModel()
	 * @generated
	 */
	EReference getPortModel_Provideds();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.coremodel.PortModel#getRequireds <em>Requireds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Requireds</em>'.
	 * @see org.isistan.flabot.coremodel.PortModel#getRequireds()
	 * @see #getPortModel()
	 * @generated
	 */
	EReference getPortModel_Requireds();

	/**
	 * Returns the meta object for the container reference '{@link org.isistan.flabot.coremodel.PortModel#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Component</em>'.
	 * @see org.isistan.flabot.coremodel.PortModel#getComponent()
	 * @see #getPortModel()
	 * @generated
	 */
	EReference getPortModel_Component();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.Responsibility <em>Responsibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Responsibility</em>'.
	 * @see org.isistan.flabot.coremodel.Responsibility
	 * @generated
	 */
	EClass getResponsibility();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.Responsibility#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.isistan.flabot.coremodel.Responsibility#getDescription()
	 * @see #getResponsibility()
	 * @generated
	 */
	EAttribute getResponsibility_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.coremodel.Responsibility#getPreconditions <em>Preconditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Preconditions</em>'.
	 * @see org.isistan.flabot.coremodel.Responsibility#getPreconditions()
	 * @see #getResponsibility()
	 * @generated
	 */
	EReference getResponsibility_Preconditions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.coremodel.Responsibility#getPostconditions <em>Postconditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Postconditions</em>'.
	 * @see org.isistan.flabot.coremodel.Responsibility#getPostconditions()
	 * @see #getResponsibility()
	 * @generated
	 */
	EReference getResponsibility_Postconditions();

	/**
	 * Returns the meta object for the container reference '{@link org.isistan.flabot.coremodel.Responsibility#getCoreModel <em>Core Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Core Model</em>'.
	 * @see org.isistan.flabot.coremodel.Responsibility#getCoreModel()
	 * @see #getResponsibility()
	 * @generated
	 */
	EReference getResponsibility_CoreModel();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.UseCaseMap <em>Use Case Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Case Map</em>'.
	 * @see org.isistan.flabot.coremodel.UseCaseMap
	 * @generated
	 */
	EClass getUseCaseMap();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.coremodel.UseCaseMap#getPaths <em>Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Paths</em>'.
	 * @see org.isistan.flabot.coremodel.UseCaseMap#getPaths()
	 * @see #getUseCaseMap()
	 * @generated
	 */
	EReference getUseCaseMap_Paths();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.coremodel.UseCaseMap#getComponentRoles <em>Component Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Component Roles</em>'.
	 * @see org.isistan.flabot.coremodel.UseCaseMap#getComponentRoles()
	 * @see #getUseCaseMap()
	 * @generated
	 */
	EReference getUseCaseMap_ComponentRoles();

	/**
	 * Returns the meta object for the container reference '{@link org.isistan.flabot.coremodel.UseCaseMap#getCoreModel <em>Core Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Core Model</em>'.
	 * @see org.isistan.flabot.coremodel.UseCaseMap#getCoreModel()
	 * @see #getUseCaseMap()
	 * @generated
	 */
	EReference getUseCaseMap_CoreModel();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.UseCaseMap#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.isistan.flabot.coremodel.UseCaseMap#getDescription()
	 * @see #getUseCaseMap()
	 * @generated
	 */
	EAttribute getUseCaseMap_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.UseCaseMap#getLevelInfo <em>Level Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level Info</em>'.
	 * @see org.isistan.flabot.coremodel.UseCaseMap#getLevelInfo()
	 * @see #getUseCaseMap()
	 * @generated
	 */
	EAttribute getUseCaseMap_LevelInfo();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.Path <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path</em>'.
	 * @see org.isistan.flabot.coremodel.Path
	 * @generated
	 */
	EClass getPath();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.coremodel.Path#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.isistan.flabot.coremodel.Path#getNodes()
	 * @see #getPath()
	 * @generated
	 */
	EReference getPath_Nodes();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.coremodel.Path#getEndNodes <em>End Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>End Nodes</em>'.
	 * @see org.isistan.flabot.coremodel.Path#getEndNodes()
	 * @see #getPath()
	 * @generated
	 */
	EReference getPath_EndNodes();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.coremodel.Path#getStartNodes <em>Start Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Start Nodes</em>'.
	 * @see org.isistan.flabot.coremodel.Path#getStartNodes()
	 * @see #getPath()
	 * @generated
	 */
	EReference getPath_StartNodes();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.PathNode <em>Path Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Node</em>'.
	 * @see org.isistan.flabot.coremodel.PathNode
	 * @generated
	 */
	EClass getPathNode();

	/**
	 * Returns the meta object for the container reference '{@link org.isistan.flabot.coremodel.PathNode#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Path</em>'.
	 * @see org.isistan.flabot.coremodel.PathNode#getPath()
	 * @see #getPathNode()
	 * @generated
	 */
	EReference getPathNode_Path();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.coremodel.PathNode#getPrevious <em>Previous</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Previous</em>'.
	 * @see org.isistan.flabot.coremodel.PathNode#getPrevious()
	 * @see #getPathNode()
	 * @generated NOT
	 */
	@SuppressWarnings("deprecation") EReference getPathNode_Previous(); //$NON-NLS-1$

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.coremodel.PathNode#getNext <em>Next</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Next</em>'.
	 * @see org.isistan.flabot.coremodel.PathNode#getNext()
	 * @see #getPathNode()
	 * @generated NOT
	 */
	@SuppressWarnings("deprecation") EReference getPathNode_Next(); //$NON-NLS-1$

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.InterfaceLink <em>Interface Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Link</em>'.
	 * @see org.isistan.flabot.coremodel.InterfaceLink
	 * @generated
	 */
	EClass getInterfaceLink();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.coremodel.InterfaceLink#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.isistan.flabot.coremodel.InterfaceLink#getSource()
	 * @see #getInterfaceLink()
	 * @generated
	 */
	EReference getInterfaceLink_Source();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.coremodel.InterfaceLink#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.isistan.flabot.coremodel.InterfaceLink#getTarget()
	 * @see #getInterfaceLink()
	 * @generated
	 */
	EReference getInterfaceLink_Target();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.PropertyElementModel <em>Property Element Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Element Model</em>'.
	 * @see org.isistan.flabot.coremodel.PropertyElementModel
	 * @generated
	 */
	EClass getPropertyElementModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.coremodel.PropertyElementModel#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.isistan.flabot.coremodel.PropertyElementModel#getProperties()
	 * @see #getPropertyElementModel()
	 * @generated
	 */
	EReference getPropertyElementModel_Properties();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.isistan.flabot.coremodel.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.Property#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.isistan.flabot.coremodel.Property#getName()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.Property#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.isistan.flabot.coremodel.Property#getValue()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Value();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.Relationship <em>Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relationship</em>'.
	 * @see org.isistan.flabot.coremodel.Relationship
	 * @generated
	 */
	EClass getRelationship();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.coremodel.Relationship#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.isistan.flabot.coremodel.Relationship#getSource()
	 * @see #getRelationship()
	 * @generated
	 */
	EReference getRelationship_Source();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.coremodel.Relationship#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.isistan.flabot.coremodel.Relationship#getTarget()
	 * @see #getRelationship()
	 * @generated
	 */
	EReference getRelationship_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.Relationship#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.isistan.flabot.coremodel.Relationship#getDirection()
	 * @see #getRelationship()
	 * @generated
	 */
	EAttribute getRelationship_Direction();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.ComponentRole <em>Component Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Role</em>'.
	 * @see org.isistan.flabot.coremodel.ComponentRole
	 * @generated
	 */
	EClass getComponentRole();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.coremodel.ComponentRole#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component</em>'.
	 * @see org.isistan.flabot.coremodel.ComponentRole#getComponent()
	 * @see #getComponentRole()
	 * @generated
	 */
	EReference getComponentRole_Component();

	/**
	 * Returns the meta object for the container reference '{@link org.isistan.flabot.coremodel.ComponentRole#getMap <em>Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Map</em>'.
	 * @see org.isistan.flabot.coremodel.ComponentRole#getMap()
	 * @see #getComponentRole()
	 * @generated
	 */
	EReference getComponentRole_Map();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.ComponentRole#getAbstractInfo <em>Abstract Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract Info</em>'.
	 * @see org.isistan.flabot.coremodel.ComponentRole#getAbstractInfo()
	 * @see #getComponentRole()
	 * @generated
	 */
	EAttribute getComponentRole_AbstractInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.ComponentRole#getComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Component Type</em>'.
	 * @see org.isistan.flabot.coremodel.ComponentRole#getComponentType()
	 * @see #getComponentRole()
	 * @generated
	 */
	EAttribute getComponentRole_ComponentType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.common.notify.Adapter <em>Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adapter</em>'.
	 * @see org.eclipse.emf.common.notify.Adapter
	 * @model instanceClass="org.eclipse.emf.common.notify.Adapter"
	 * @generated
	 */
	EClass getAdapter();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.ForkNode <em>Fork Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fork Node</em>'.
	 * @see org.isistan.flabot.coremodel.ForkNode
	 * @generated
	 */
	EClass getForkNode();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.ForkNode#getForkType <em>Fork Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fork Type</em>'.
	 * @see org.isistan.flabot.coremodel.ForkNode#getForkType()
	 * @see #getForkNode()
	 * @generated
	 */
	EAttribute getForkNode_ForkType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.coremodel.ForkNode#getConditions <em>Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conditions</em>'.
	 * @see org.isistan.flabot.coremodel.ForkNode#getConditions()
	 * @see #getForkNode()
	 * @generated
	 */
	EReference getForkNode_Conditions();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.SimplePathNode <em>Simple Path Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Path Node</em>'.
	 * @see org.isistan.flabot.coremodel.SimplePathNode
	 * @generated
	 */
	EClass getSimplePathNode();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.coremodel.SimplePathNode#getMap <em>Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Map</em>'.
	 * @see org.isistan.flabot.coremodel.SimplePathNode#getMap()
	 * @see #getSimplePathNode()
	 * @generated
	 */
	EReference getSimplePathNode_Map();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.Stereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotype</em>'.
	 * @see org.isistan.flabot.coremodel.Stereotype
	 * @generated
	 */
	EClass getStereotype();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.StereotypedElementModel <em>Stereotyped Element Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotyped Element Model</em>'.
	 * @see org.isistan.flabot.coremodel.StereotypedElementModel
	 * @generated
	 */
	EClass getStereotypedElementModel();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.coremodel.StereotypedElementModel#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Stereotype</em>'.
	 * @see org.isistan.flabot.coremodel.StereotypedElementModel#getStereotype()
	 * @see #getStereotypedElementModel()
	 * @generated
	 */
	EReference getStereotypedElementModel_Stereotype();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.ResponsibilityNode <em>Responsibility Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Responsibility Node</em>'.
	 * @see org.isistan.flabot.coremodel.ResponsibilityNode
	 * @generated
	 */
	EClass getResponsibilityNode();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.coremodel.ResponsibilityNode#getResponsibility <em>Responsibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Responsibility</em>'.
	 * @see org.isistan.flabot.coremodel.ResponsibilityNode#getResponsibility()
	 * @see #getResponsibilityNode()
	 * @generated
	 */
	EReference getResponsibilityNode_Responsibility();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.coremodel.ResponsibilityNode#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Role</em>'.
	 * @see org.isistan.flabot.coremodel.ResponsibilityNode#getRole()
	 * @see #getResponsibilityNode()
	 * @generated
	 */
	EReference getResponsibilityNode_Role();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.ResponsibilityNode#getInputsCount <em>Inputs Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inputs Count</em>'.
	 * @see org.isistan.flabot.coremodel.ResponsibilityNode#getInputsCount()
	 * @see #getResponsibilityNode()
	 * @generated
	 */
	EAttribute getResponsibilityNode_InputsCount();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.ResponsibilityNode#getOutputsCount <em>Outputs Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Outputs Count</em>'.
	 * @see org.isistan.flabot.coremodel.ResponsibilityNode#getOutputsCount()
	 * @see #getResponsibilityNode()
	 * @generated
	 */
	EAttribute getResponsibilityNode_OutputsCount();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see org.isistan.flabot.coremodel.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.Condition#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.isistan.flabot.coremodel.Condition#getValue()
	 * @see #getCondition()
	 * @generated
	 */
	EAttribute getCondition_Value();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.coremodel.Condition#getUseCaseMap <em>Use Case Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Use Case Map</em>'.
	 * @see org.isistan.flabot.coremodel.Condition#getUseCaseMap()
	 * @see #getCondition()
	 * @generated
	 */
	EReference getCondition_UseCaseMap();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.coremodel.Condition#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event</em>'.
	 * @see org.isistan.flabot.coremodel.Condition#getEvent()
	 * @see #getCondition()
	 * @generated
	 */
	EReference getCondition_Event();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.coremodel.Condition#getFamily <em>Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Family</em>'.
	 * @see org.isistan.flabot.coremodel.Condition#getFamily()
	 * @see #getCondition()
	 * @generated
	 */
	EReference getCondition_Family();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.coremodel.Condition#getSourceResponsibility <em>Source Responsibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Responsibility</em>'.
	 * @see org.isistan.flabot.coremodel.Condition#getSourceResponsibility()
	 * @see #getCondition()
	 * @generated
	 */
	EReference getCondition_SourceResponsibility();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.Condition#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.isistan.flabot.coremodel.Condition#getType()
	 * @see #getCondition()
	 * @generated
	 */
	EAttribute getCondition_Type();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.coremodel.Condition#getDependencyResponsibility <em>Dependency Responsibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dependency Responsibility</em>'.
	 * @see org.isistan.flabot.coremodel.Condition#getDependencyResponsibility()
	 * @see #getCondition()
	 * @generated
	 */
	EReference getCondition_DependencyResponsibility();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.Note <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Note</em>'.
	 * @see org.isistan.flabot.coremodel.Note
	 * @generated
	 */
	EClass getNote();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.Note#getNote <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Note</em>'.
	 * @see org.isistan.flabot.coremodel.Note#getNote()
	 * @see #getNote()
	 * @generated
	 */
	EAttribute getNote_Note();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.coremodel.Note#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Targets</em>'.
	 * @see org.isistan.flabot.coremodel.Note#getTargets()
	 * @see #getNote()
	 * @generated
	 */
	EReference getNote_Targets();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.NoteElementModel <em>Note Element Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Note Element Model</em>'.
	 * @see org.isistan.flabot.coremodel.NoteElementModel
	 * @generated
	 */
	EClass getNoteElementModel();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.coremodel.NoteElementModel#getNotes <em>Notes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Notes</em>'.
	 * @see org.isistan.flabot.coremodel.NoteElementModel#getNotes()
	 * @see #getNoteElementModel()
	 * @generated
	 */
	EReference getNoteElementModel_Notes();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.Family <em>Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Family</em>'.
	 * @see org.isistan.flabot.coremodel.Family
	 * @generated
	 */
	EClass getFamily();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.coremodel.Family#getFamilyElement <em>Family Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Family Element</em>'.
	 * @see org.isistan.flabot.coremodel.Family#getFamilyElement()
	 * @see #getFamily()
	 * @generated
	 */
	EReference getFamily_FamilyElement();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.coremodel.Family#getAssociatedResponsibilities <em>Associated Responsibilities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Associated Responsibilities</em>'.
	 * @see org.isistan.flabot.coremodel.Family#getAssociatedResponsibilities()
	 * @see #getFamily()
	 * @generated
	 */
	EReference getFamily_AssociatedResponsibilities();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.coremodel.Family#getArchitecturalUseCaseMaps <em>Architectural Use Case Maps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Architectural Use Case Maps</em>'.
	 * @see org.isistan.flabot.coremodel.Family#getArchitecturalUseCaseMaps()
	 * @see #getFamily()
	 * @generated
	 */
	EReference getFamily_ArchitecturalUseCaseMaps();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.coremodel.Family#getFunctionalUseCaseMaps <em>Functional Use Case Maps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Functional Use Case Maps</em>'.
	 * @see org.isistan.flabot.coremodel.Family#getFunctionalUseCaseMaps()
	 * @see #getFamily()
	 * @generated
	 */
	EReference getFamily_FunctionalUseCaseMaps();

	/**
	 * Returns the meta object for the map '{@link org.isistan.flabot.coremodel.Family#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Events</em>'.
	 * @see org.isistan.flabot.coremodel.Family#getEvents()
	 * @see #getFamily()
	 * @generated
	 */
	EReference getFamily_Events();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.FamilyElement <em>Family Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Family Element</em>'.
	 * @see org.isistan.flabot.coremodel.FamilyElement
	 * @generated
	 */
	EClass getFamilyElement();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.coremodel.FamilyElement#getUseCaseMap <em>Use Case Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Use Case Map</em>'.
	 * @see org.isistan.flabot.coremodel.FamilyElement#getUseCaseMap()
	 * @see #getFamilyElement()
	 * @generated
	 */
	EReference getFamilyElement_UseCaseMap();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.coremodel.FamilyElement#getFunctionalComponent <em>Functional Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Functional Component</em>'.
	 * @see org.isistan.flabot.coremodel.FamilyElement#getFunctionalComponent()
	 * @see #getFamilyElement()
	 * @generated
	 */
	EReference getFamilyElement_FunctionalComponent();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.coremodel.FamilyElement#getArchitecturalComponent <em>Architectural Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Architectural Component</em>'.
	 * @see org.isistan.flabot.coremodel.FamilyElement#getArchitecturalComponent()
	 * @see #getFamilyElement()
	 * @generated
	 */
	EReference getFamilyElement_ArchitecturalComponent();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.InterfacePrologCode <em>Interface Prolog Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Prolog Code</em>'.
	 * @see org.isistan.flabot.coremodel.InterfacePrologCode
	 * @model instanceClass="org.isistan.flabot.coremodel.InterfacePrologCode"
	 * @generated
	 */
	EClass getInterfacePrologCode();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.JoinNode <em>Join Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Join Node</em>'.
	 * @see org.isistan.flabot.coremodel.JoinNode
	 * @generated
	 */
	EClass getJoinNode();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.JoinNode#getJoinType <em>Join Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Join Type</em>'.
	 * @see org.isistan.flabot.coremodel.JoinNode#getJoinType()
	 * @see #getJoinNode()
	 * @generated
	 */
	EAttribute getJoinNode_JoinType();
	
	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.TimerNode <em>Timer Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timer Node</em>'.
	 * @see org.isistan.flabot.coremodel.TimerNode
	 * @generated
	 */
	EClass getTimerNode();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.TimerNode#getTimerName <em>Timer Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timer Name</em>'.
	 * @see org.isistan.flabot.coremodel.TimerNode#getTimerName()
	 * @see #getTimerNode()
	 * @generated
	 */
	EAttribute getTimerNode_TimerName();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.TimerNode#getTimerDescription <em>Timer Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timer Description</em>'.
	 * @see org.isistan.flabot.coremodel.TimerNode#getTimerDescription()
	 * @see #getTimerNode()
	 * @generated
	 */
	EAttribute getTimerNode_TimerDescription();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.TimerNode#getTimerType <em>Timer Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timer Type</em>'.
	 * @see org.isistan.flabot.coremodel.TimerNode#getTimerType()
	 * @see #getTimerNode()
	 * @generated
	 */
	EAttribute getTimerNode_TimerType();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.TimerNode#getTimerTimeOut <em>Timer Time Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timer Time Out</em>'.
	 * @see org.isistan.flabot.coremodel.TimerNode#getTimerTimeOut()
	 * @see #getTimerNode()
	 * @generated
	 */
	EAttribute getTimerNode_TimerTimeOut();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.TimerNode#getTimerTimeOutUnity <em>Timer Time Out Unity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timer Time Out Unity</em>'.
	 * @see org.isistan.flabot.coremodel.TimerNode#getTimerTimeOutUnity()
	 * @see #getTimerNode()
	 * @generated
	 */
	EAttribute getTimerNode_TimerTimeOutUnity();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.DirectionArrowNode <em>Direction Arrow Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Direction Arrow Node</em>'.
	 * @see org.isistan.flabot.coremodel.DirectionArrowNode
	 * @generated
	 */
	EClass getDirectionArrowNode();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.ConditionedStub <em>Conditioned Stub</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditioned Stub</em>'.
	 * @see org.isistan.flabot.coremodel.ConditionedStub
	 * @generated
	 */
	EClass getConditionedStub();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.coremodel.ConditionedStub#getStub <em>Stub</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Stub</em>'.
	 * @see org.isistan.flabot.coremodel.ConditionedStub#getStub()
	 * @see #getConditionedStub()
	 * @generated
	 */
	EReference getConditionedStub_Stub();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.coremodel.ConditionedStub#getResponsibilityNode <em>Responsibility Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Responsibility Node</em>'.
	 * @see org.isistan.flabot.coremodel.ConditionedStub#getResponsibilityNode()
	 * @see #getConditionedStub()
	 * @generated
	 */
	EReference getConditionedStub_ResponsibilityNode();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.DynamicStubNode <em>Dynamic Stub Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Stub Node</em>'.
	 * @see org.isistan.flabot.coremodel.DynamicStubNode
	 * @generated
	 */
	EClass getDynamicStubNode();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.coremodel.DynamicStubNode#getConditionedStubs <em>Conditioned Stubs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Conditioned Stubs</em>'.
	 * @see org.isistan.flabot.coremodel.DynamicStubNode#getConditionedStubs()
	 * @see #getDynamicStubNode()
	 * @generated
	 */
	EReference getDynamicStubNode_ConditionedStubs();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.Registrable <em>Registrable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Registrable</em>'.
	 * @see org.isistan.flabot.coremodel.Registrable
	 * @generated
	 */
	EClass getRegistrable();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.ResponsibilityRegistry <em>Responsibility Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Responsibility Registry</em>'.
	 * @see org.isistan.flabot.coremodel.ResponsibilityRegistry
	 * @generated
	 */
	EClass getResponsibilityRegistry();

	/**
	 * Returns the meta object for the map '{@link org.isistan.flabot.coremodel.ResponsibilityRegistry#getResponsibilityBasedRegistry <em>Responsibility Based Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Responsibility Based Registry</em>'.
	 * @see org.isistan.flabot.coremodel.ResponsibilityRegistry#getResponsibilityBasedRegistry()
	 * @see #getResponsibilityRegistry()
	 * @generated
	 */
	EReference getResponsibilityRegistry_ResponsibilityBasedRegistry();

	/**
	 * Returns the meta object for the map '{@link org.isistan.flabot.coremodel.ResponsibilityRegistry#getComponentBasedRegistry <em>Component Based Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Component Based Registry</em>'.
	 * @see org.isistan.flabot.coremodel.ResponsibilityRegistry#getComponentBasedRegistry()
	 * @see #getResponsibilityRegistry()
	 * @generated
	 */
	EReference getResponsibilityRegistry_ComponentBasedRegistry();

	/**
	 * Returns the meta object for the map '{@link org.isistan.flabot.coremodel.ResponsibilityRegistry#getRoleBasedRegistry <em>Role Based Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Role Based Registry</em>'.
	 * @see org.isistan.flabot.coremodel.ResponsibilityRegistry#getRoleBasedRegistry()
	 * @see #getResponsibilityRegistry()
	 * @generated
	 */
	EReference getResponsibilityRegistry_RoleBasedRegistry();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Responsibility To Registrable Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Responsibility To Registrable Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="org.isistan.flabot.coremodel.Responsibility"
	 *        valueType="org.isistan.flabot.coremodel.Registrable" valueContainment="true"
	 * @generated
	 */
	EClass getResponsibilityToRegistrableMapEntry();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getResponsibilityToRegistrableMapEntry()
	 * @generated
	 */
	EReference getResponsibilityToRegistrableMapEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getResponsibilityToRegistrableMapEntry()
	 * @generated
	 */
	EReference getResponsibilityToRegistrableMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Component To Map Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component To Map Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="org.isistan.flabot.coremodel.ComponentModel"
	 *        valueMapType="org.isistan.flabot.coremodel.ResponsibilityToRegistrableMapEntry"
	 * @generated
	 */
	EClass getComponentToMapMapEntry();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getComponentToMapMapEntry()
	 * @generated
	 */
	EReference getComponentToMapMapEntry_Key();

	/**
	 * Returns the meta object for the map '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getComponentToMapMapEntry()
	 * @generated
	 */
	EReference getComponentToMapMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Role To Map Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role To Map Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="org.isistan.flabot.coremodel.ComponentRole"
	 *        valueMapType="org.isistan.flabot.coremodel.ComponentToMapMapEntry"
	 * @generated
	 */
	EClass getRoleToMapMapEntry();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getRoleToMapMapEntry()
	 * @generated
	 */
	EReference getRoleToMapMapEntry_Key();

	/**
	 * Returns the meta object for the map '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getRoleToMapMapEntry()
	 * @generated
	 */
	EReference getRoleToMapMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.StubNode <em>Stub Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stub Node</em>'.
	 * @see org.isistan.flabot.coremodel.StubNode
	 * @generated
	 */
	EClass getStubNode();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.coremodel.StubNode#getStartPointReference <em>Start Point Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Start Point Reference</em>'.
	 * @see org.isistan.flabot.coremodel.StubNode#getStartPointReference()
	 * @see #getStubNode()
	 * @generated
	 */
	EReference getStubNode_StartPointReference();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.coremodel.StubNode#getEndPointReference <em>End Point Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End Point Reference</em>'.
	 * @see org.isistan.flabot.coremodel.StubNode#getEndPointReference()
	 * @see #getStubNode()
	 * @generated
	 */
	EReference getStubNode_EndPointReference();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.coremodel.StubNode#getReferencedMap <em>Referenced Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Map</em>'.
	 * @see org.isistan.flabot.coremodel.StubNode#getReferencedMap()
	 * @see #getStubNode()
	 * @generated
	 */
	EReference getStubNode_ReferencedMap();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.coremodel.StubNode#getFamily <em>Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Family</em>'.
	 * @see org.isistan.flabot.coremodel.StubNode#getFamily()
	 * @see #getStubNode()
	 * @generated
	 */
	EReference getStubNode_Family();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.ForkCondition <em>Fork Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fork Condition</em>'.
	 * @see org.isistan.flabot.coremodel.ForkCondition
	 * @generated
	 */
	EClass getForkCondition();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.ForkCondition#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see org.isistan.flabot.coremodel.ForkCondition#getCondition()
	 * @see #getForkCondition()
	 * @generated
	 */
	EAttribute getForkCondition_Condition();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.ExtensibleElement <em>Extensible Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extensible Element</em>'.
	 * @see org.isistan.flabot.coremodel.ExtensibleElement
	 * @generated
	 */
	EClass getExtensibleElement();

	/**
	 * Returns the meta object for the map '{@link org.isistan.flabot.coremodel.ExtensibleElement#getExtendedData <em>Extended Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Extended Data</em>'.
	 * @see org.isistan.flabot.coremodel.ExtensibleElement#getExtendedData()
	 * @see #getExtensibleElement()
	 * @generated
	 */
	@SuppressWarnings("deprecation") EReference getExtensibleElement_ExtendedData();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EString To EObject Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EString To EObject Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueType="org.eclipse.emf.ecore.EObject" valueContainment="true"
	 * @generated
	 */
	EClass getEStringToEObjectMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToEObjectMapEntry()
	 * @generated
	 */
	EAttribute getEStringToEObjectMapEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToEObjectMapEntry()
	 * @generated
	 */
	EReference getEStringToEObjectMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.coremodel.ConditionEvent <em>Condition Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition Event</em>'.
	 * @see org.isistan.flabot.coremodel.ConditionEvent
	 * @generated
	 */
	EClass getConditionEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.ConditionEvent#getConditionEvent <em>Condition Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition Event</em>'.
	 * @see org.isistan.flabot.coremodel.ConditionEvent#getConditionEvent()
	 * @see #getConditionEvent()
	 * @generated
	 */
	EAttribute getConditionEvent_ConditionEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.coremodel.ConditionEvent#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.isistan.flabot.coremodel.ConditionEvent#getDescription()
	 * @see #getConditionEvent()
	 * @generated
	 */
	EAttribute getConditionEvent_Description();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.coremodel.ConditionEvent#getAssociatedConditions <em>Associated Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Associated Conditions</em>'.
	 * @see org.isistan.flabot.coremodel.ConditionEvent#getAssociatedConditions()
	 * @see #getConditionEvent()
	 * @generated
	 */
	EReference getConditionEvent_AssociatedConditions();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Condition Event To Condition Event Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition Event To Condition Event Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="org.isistan.flabot.coremodel.ConditionEvent"
	 *        valueType="org.isistan.flabot.coremodel.ConditionEvent"
	 * @generated
	 */
	EClass getConditionEventToConditionEventMapEntry();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getConditionEventToConditionEventMapEntry()
	 * @generated
	 */
	EReference getConditionEventToConditionEventMapEntry_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getConditionEventToConditionEventMapEntry()
	 * @generated
	 */
	EReference getConditionEventToConditionEventMapEntry_Value();

	/**
	 * Returns the meta object for enum '{@link org.isistan.flabot.coremodel.RelationshipDirection <em>Relationship Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Relationship Direction</em>'.
	 * @see org.isistan.flabot.coremodel.RelationshipDirection
	 * @generated
	 */
	EEnum getRelationshipDirection();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CoremodelFactory getCoremodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.BehavioralFeatureModelImpl <em>Behavioral Feature Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.BehavioralFeatureModelImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getBehavioralFeatureModel()
		 * @generated
		 */
		EClass BEHAVIORAL_FEATURE_MODEL = eINSTANCE.getBehavioralFeatureModel();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.ComponentModelImpl <em>Component Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.ComponentModelImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getComponentModel()
		 * @generated
		 */
		EClass COMPONENT_MODEL = eINSTANCE.getComponentModel();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_MODEL__FEATURES = eINSTANCE.getComponentModel_Features();

		/**
		 * The meta object literal for the '<em><b>Owned Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_MODEL__OWNED_PORTS = eINSTANCE.getComponentModel_OwnedPorts();

		/**
		 * The meta object literal for the '<em><b>Core Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_MODEL__CORE_MODEL = eINSTANCE.getComponentModel_CoreModel();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.CoreModelImpl <em>Core Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.CoreModelImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getCoreModel()
		 * @generated
		 */
		EClass CORE_MODEL = eINSTANCE.getCoreModel();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_MODEL__COMPONENTS = eINSTANCE.getCoreModel_Components();

		/**
		 * The meta object literal for the '<em><b>Responsibilities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_MODEL__RESPONSIBILITIES = eINSTANCE.getCoreModel_Responsibilities();

		/**
		 * The meta object literal for the '<em><b>Use Case Maps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_MODEL__USE_CASE_MAPS = eINSTANCE.getCoreModel_UseCaseMaps();

		/**
		 * The meta object literal for the '<em><b>Interface Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_MODEL__INTERFACE_LINKS = eINSTANCE.getCoreModel_InterfaceLinks();

		/**
		 * The meta object literal for the '<em><b>Relationships</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_MODEL__RELATIONSHIPS = eINSTANCE.getCoreModel_Relationships();

		/**
		 * The meta object literal for the '<em><b>Stereotypes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_MODEL__STEREOTYPES = eINSTANCE.getCoreModel_Stereotypes();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_MODEL__FILE = eINSTANCE.getCoreModel_File();

		/**
		 * The meta object literal for the '<em><b>Families</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_MODEL__FAMILIES = eINSTANCE.getCoreModel_Families();

		/**
		 * The meta object literal for the '<em><b>Architectural Use Case Maps</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_MODEL__ARCHITECTURAL_USE_CASE_MAPS = eINSTANCE.getCoreModel_ArchitecturalUseCaseMaps();

		/**
		 * The meta object literal for the '<em><b>Functional Use Case Maps</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_MODEL__FUNCTIONAL_USE_CASE_MAPS = eINSTANCE.getCoreModel_FunctionalUseCaseMaps();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_MODEL__EVENTS = eINSTANCE.getCoreModel_Events();

		/**
		 * The meta object literal for the '<em><b>Stubs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_MODEL__STUBS = eINSTANCE.getCoreModel_Stubs();

		/**
		 * The meta object literal for the '<em><b>Dynamic Stubs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_MODEL__DYNAMIC_STUBS = eINSTANCE.getCoreModel_DynamicStubs();

		/**
		 * The meta object literal for the '<em><b>Conditioned Stubs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_MODEL__CONDITIONED_STUBS = eINSTANCE.getCoreModel_ConditionedStubs();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.FeatureModelImpl <em>Feature Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.FeatureModelImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getFeatureModel()
		 * @generated
		 */
		EClass FEATURE_MODEL = eINSTANCE.getFeatureModel();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_MODEL__COMPONENTS = eINSTANCE.getFeatureModel_Components();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.InterfaceModelImpl <em>Interface Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.InterfaceModelImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getInterfaceModel()
		 * @generated
		 */
		EClass INTERFACE_MODEL = eINSTANCE.getInterfaceModel();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_MODEL__PORT = eINSTANCE.getInterfaceModel_Port();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.NamedElementModelImpl <em>Named Element Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.NamedElementModelImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getNamedElementModel()
		 * @generated
		 */
		EClass NAMED_ELEMENT_MODEL = eINSTANCE.getNamedElementModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT_MODEL__NAME = eINSTANCE.getNamedElementModel_Name();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.PortModelImpl <em>Port Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.PortModelImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getPortModel()
		 * @generated
		 */
		EClass PORT_MODEL = eINSTANCE.getPortModel();

		/**
		 * The meta object literal for the '<em><b>Provideds</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_MODEL__PROVIDEDS = eINSTANCE.getPortModel_Provideds();

		/**
		 * The meta object literal for the '<em><b>Requireds</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_MODEL__REQUIREDS = eINSTANCE.getPortModel_Requireds();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_MODEL__COMPONENT = eINSTANCE.getPortModel_Component();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.ResponsibilityImpl <em>Responsibility</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.ResponsibilityImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getResponsibility()
		 * @generated
		 */
		EClass RESPONSIBILITY = eINSTANCE.getResponsibility();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESPONSIBILITY__DESCRIPTION = eINSTANCE.getResponsibility_Description();

		/**
		 * The meta object literal for the '<em><b>Preconditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSIBILITY__PRECONDITIONS = eINSTANCE.getResponsibility_Preconditions();

		/**
		 * The meta object literal for the '<em><b>Postconditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSIBILITY__POSTCONDITIONS = eINSTANCE.getResponsibility_Postconditions();

		/**
		 * The meta object literal for the '<em><b>Core Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSIBILITY__CORE_MODEL = eINSTANCE.getResponsibility_CoreModel();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.UseCaseMapImpl <em>Use Case Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.UseCaseMapImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getUseCaseMap()
		 * @generated
		 */
		EClass USE_CASE_MAP = eINSTANCE.getUseCaseMap();

		/**
		 * The meta object literal for the '<em><b>Paths</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_MAP__PATHS = eINSTANCE.getUseCaseMap_Paths();

		/**
		 * The meta object literal for the '<em><b>Component Roles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_MAP__COMPONENT_ROLES = eINSTANCE.getUseCaseMap_ComponentRoles();

		/**
		 * The meta object literal for the '<em><b>Core Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_MAP__CORE_MODEL = eINSTANCE.getUseCaseMap_CoreModel();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_CASE_MAP__DESCRIPTION = eINSTANCE.getUseCaseMap_Description();

		/**
		 * The meta object literal for the '<em><b>Level Info</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_CASE_MAP__LEVEL_INFO = eINSTANCE.getUseCaseMap_LevelInfo();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.PathImpl <em>Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.PathImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getPath()
		 * @generated
		 */
		EClass PATH = eINSTANCE.getPath();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH__NODES = eINSTANCE.getPath_Nodes();

		/**
		 * The meta object literal for the '<em><b>End Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH__END_NODES = eINSTANCE.getPath_EndNodes();

		/**
		 * The meta object literal for the '<em><b>Start Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH__START_NODES = eINSTANCE.getPath_StartNodes();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.PathNodeImpl <em>Path Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.PathNodeImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getPathNode()
		 * @generated
		 */
		EClass PATH_NODE = eINSTANCE.getPathNode();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_NODE__PATH = eINSTANCE.getPathNode_Path();

		/**
		 * The meta object literal for the '<em><b>Previous</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_NODE__PREVIOUS = eINSTANCE.getPathNode_Previous();

		/**
		 * The meta object literal for the '<em><b>Next</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_NODE__NEXT = eINSTANCE.getPathNode_Next();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.InterfaceLinkImpl <em>Interface Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.InterfaceLinkImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getInterfaceLink()
		 * @generated
		 */
		EClass INTERFACE_LINK = eINSTANCE.getInterfaceLink();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_LINK__SOURCE = eINSTANCE.getInterfaceLink_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_LINK__TARGET = eINSTANCE.getInterfaceLink_Target();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.PropertyElementModelImpl <em>Property Element Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.PropertyElementModelImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getPropertyElementModel()
		 * @generated
		 */
		EClass PROPERTY_ELEMENT_MODEL = eINSTANCE.getPropertyElementModel();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_ELEMENT_MODEL__PROPERTIES = eINSTANCE.getPropertyElementModel_Properties();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.PropertyImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__VALUE = eINSTANCE.getProperty_Value();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.RelationshipImpl <em>Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.RelationshipImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getRelationship()
		 * @generated
		 */
		EClass RELATIONSHIP = eINSTANCE.getRelationship();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONSHIP__SOURCE = eINSTANCE.getRelationship_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONSHIP__TARGET = eINSTANCE.getRelationship_Target();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATIONSHIP__DIRECTION = eINSTANCE.getRelationship_Direction();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.ComponentRoleImpl <em>Component Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.ComponentRoleImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getComponentRole()
		 * @generated
		 */
		EClass COMPONENT_ROLE = eINSTANCE.getComponentRole();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_ROLE__COMPONENT = eINSTANCE.getComponentRole_Component();

		/**
		 * The meta object literal for the '<em><b>Map</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_ROLE__MAP = eINSTANCE.getComponentRole_Map();

		/**
		 * The meta object literal for the '<em><b>Abstract Info</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_ROLE__ABSTRACT_INFO = eINSTANCE.getComponentRole_AbstractInfo();

		/**
		 * The meta object literal for the '<em><b>Component Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_ROLE__COMPONENT_TYPE = eINSTANCE.getComponentRole_ComponentType();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.common.notify.Adapter <em>Adapter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.notify.Adapter
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getAdapter()
		 * @generated
		 */
		EClass ADAPTER = eINSTANCE.getAdapter();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.ForkNodeImpl <em>Fork Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.ForkNodeImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getForkNode()
		 * @generated
		 */
		EClass FORK_NODE = eINSTANCE.getForkNode();

		/**
		 * The meta object literal for the '<em><b>Fork Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORK_NODE__FORK_TYPE = eINSTANCE.getForkNode_ForkType();

		/**
		 * The meta object literal for the '<em><b>Conditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORK_NODE__CONDITIONS = eINSTANCE.getForkNode_Conditions();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.SimplePathNodeImpl <em>Simple Path Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.SimplePathNodeImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getSimplePathNode()
		 * @generated
		 */
		EClass SIMPLE_PATH_NODE = eINSTANCE.getSimplePathNode();

		/**
		 * The meta object literal for the '<em><b>Map</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_PATH_NODE__MAP = eINSTANCE.getSimplePathNode_Map();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.StereotypeImpl <em>Stereotype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.StereotypeImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getStereotype()
		 * @generated
		 */
		EClass STEREOTYPE = eINSTANCE.getStereotype();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.StereotypedElementModelImpl <em>Stereotyped Element Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.StereotypedElementModelImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getStereotypedElementModel()
		 * @generated
		 */
		EClass STEREOTYPED_ELEMENT_MODEL = eINSTANCE.getStereotypedElementModel();

		/**
		 * The meta object literal for the '<em><b>Stereotype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEREOTYPED_ELEMENT_MODEL__STEREOTYPE = eINSTANCE.getStereotypedElementModel_Stereotype();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.ResponsibilityNodeImpl <em>Responsibility Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.ResponsibilityNodeImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getResponsibilityNode()
		 * @generated
		 */
		EClass RESPONSIBILITY_NODE = eINSTANCE.getResponsibilityNode();

		/**
		 * The meta object literal for the '<em><b>Responsibility</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSIBILITY_NODE__RESPONSIBILITY = eINSTANCE.getResponsibilityNode_Responsibility();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSIBILITY_NODE__ROLE = eINSTANCE.getResponsibilityNode_Role();

		/**
		 * The meta object literal for the '<em><b>Inputs Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESPONSIBILITY_NODE__INPUTS_COUNT = eINSTANCE.getResponsibilityNode_InputsCount();

		/**
		 * The meta object literal for the '<em><b>Outputs Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESPONSIBILITY_NODE__OUTPUTS_COUNT = eINSTANCE.getResponsibilityNode_OutputsCount();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.ConditionImpl <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.ConditionImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION__VALUE = eINSTANCE.getCondition_Value();

		/**
		 * The meta object literal for the '<em><b>Use Case Map</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION__USE_CASE_MAP = eINSTANCE.getCondition_UseCaseMap();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION__EVENT = eINSTANCE.getCondition_Event();

		/**
		 * The meta object literal for the '<em><b>Family</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION__FAMILY = eINSTANCE.getCondition_Family();

		/**
		 * The meta object literal for the '<em><b>Source Responsibility</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION__SOURCE_RESPONSIBILITY = eINSTANCE.getCondition_SourceResponsibility();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION__TYPE = eINSTANCE.getCondition_Type();

		/**
		 * The meta object literal for the '<em><b>Dependency Responsibility</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION__DEPENDENCY_RESPONSIBILITY = eINSTANCE.getCondition_DependencyResponsibility();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.NoteImpl <em>Note</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.NoteImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getNote()
		 * @generated
		 */
		EClass NOTE = eINSTANCE.getNote();

		/**
		 * The meta object literal for the '<em><b>Note</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTE__NOTE = eINSTANCE.getNote_Note();

		/**
		 * The meta object literal for the '<em><b>Targets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOTE__TARGETS = eINSTANCE.getNote_Targets();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.NoteElementModelImpl <em>Note Element Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.NoteElementModelImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getNoteElementModel()
		 * @generated
		 */
		EClass NOTE_ELEMENT_MODEL = eINSTANCE.getNoteElementModel();

		/**
		 * The meta object literal for the '<em><b>Notes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOTE_ELEMENT_MODEL__NOTES = eINSTANCE.getNoteElementModel_Notes();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.FamilyImpl <em>Family</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.FamilyImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getFamily()
		 * @generated
		 */
		EClass FAMILY = eINSTANCE.getFamily();

		/**
		 * The meta object literal for the '<em><b>Family Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAMILY__FAMILY_ELEMENT = eINSTANCE.getFamily_FamilyElement();

		/**
		 * The meta object literal for the '<em><b>Associated Responsibilities</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAMILY__ASSOCIATED_RESPONSIBILITIES = eINSTANCE.getFamily_AssociatedResponsibilities();

		/**
		 * The meta object literal for the '<em><b>Architectural Use Case Maps</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAMILY__ARCHITECTURAL_USE_CASE_MAPS = eINSTANCE.getFamily_ArchitecturalUseCaseMaps();

		/**
		 * The meta object literal for the '<em><b>Functional Use Case Maps</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAMILY__FUNCTIONAL_USE_CASE_MAPS = eINSTANCE.getFamily_FunctionalUseCaseMaps();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAMILY__EVENTS = eINSTANCE.getFamily_Events();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.FamilyElementImpl <em>Family Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.FamilyElementImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getFamilyElement()
		 * @generated
		 */
		EClass FAMILY_ELEMENT = eINSTANCE.getFamilyElement();

		/**
		 * The meta object literal for the '<em><b>Use Case Map</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAMILY_ELEMENT__USE_CASE_MAP = eINSTANCE.getFamilyElement_UseCaseMap();

		/**
		 * The meta object literal for the '<em><b>Functional Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAMILY_ELEMENT__FUNCTIONAL_COMPONENT = eINSTANCE.getFamilyElement_FunctionalComponent();

		/**
		 * The meta object literal for the '<em><b>Architectural Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAMILY_ELEMENT__ARCHITECTURAL_COMPONENT = eINSTANCE.getFamilyElement_ArchitecturalComponent();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.InterfacePrologCode <em>Interface Prolog Code</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.InterfacePrologCode
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getInterfacePrologCode()
		 * @generated
		 */
		EClass INTERFACE_PROLOG_CODE = eINSTANCE.getInterfacePrologCode();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.JoinNodeImpl <em>Join Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.JoinNodeImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getJoinNode()
		 * @generated
		 */
		EClass JOIN_NODE = eINSTANCE.getJoinNode();

		/**
		 * The meta object literal for the '<em><b>Join Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOIN_NODE__JOIN_TYPE = eINSTANCE.getJoinNode_JoinType();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.Registrable <em>Registrable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.Registrable
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getRegistrable()
		 * @generated
		 */
		EClass REGISTRABLE = eINSTANCE.getRegistrable();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.ResponsibilityRegistryImpl <em>Responsibility Registry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.ResponsibilityRegistryImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getResponsibilityRegistry()
		 * @generated
		 */
		EClass RESPONSIBILITY_REGISTRY = eINSTANCE.getResponsibilityRegistry();

		/**
		 * The meta object literal for the '<em><b>Responsibility Based Registry</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSIBILITY_REGISTRY__RESPONSIBILITY_BASED_REGISTRY = eINSTANCE.getResponsibilityRegistry_ResponsibilityBasedRegistry();

		/**
		 * The meta object literal for the '<em><b>Component Based Registry</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSIBILITY_REGISTRY__COMPONENT_BASED_REGISTRY = eINSTANCE.getResponsibilityRegistry_ComponentBasedRegistry();

		/**
		 * The meta object literal for the '<em><b>Role Based Registry</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSIBILITY_REGISTRY__ROLE_BASED_REGISTRY = eINSTANCE.getResponsibilityRegistry_RoleBasedRegistry();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.ResponsibilityToRegistrableMapEntryImpl <em>Responsibility To Registrable Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.ResponsibilityToRegistrableMapEntryImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getResponsibilityToRegistrableMapEntry()
		 * @generated
		 */
		EClass RESPONSIBILITY_TO_REGISTRABLE_MAP_ENTRY = eINSTANCE.getResponsibilityToRegistrableMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSIBILITY_TO_REGISTRABLE_MAP_ENTRY__KEY = eINSTANCE.getResponsibilityToRegistrableMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSIBILITY_TO_REGISTRABLE_MAP_ENTRY__VALUE = eINSTANCE.getResponsibilityToRegistrableMapEntry_Value();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.ComponentToMapMapEntryImpl <em>Component To Map Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.ComponentToMapMapEntryImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getComponentToMapMapEntry()
		 * @generated
		 */
		EClass COMPONENT_TO_MAP_MAP_ENTRY = eINSTANCE.getComponentToMapMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_TO_MAP_MAP_ENTRY__KEY = eINSTANCE.getComponentToMapMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_TO_MAP_MAP_ENTRY__VALUE = eINSTANCE.getComponentToMapMapEntry_Value();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.RoleToMapMapEntryImpl <em>Role To Map Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.RoleToMapMapEntryImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getRoleToMapMapEntry()
		 * @generated
		 */
		EClass ROLE_TO_MAP_MAP_ENTRY = eINSTANCE.getRoleToMapMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE_TO_MAP_MAP_ENTRY__KEY = eINSTANCE.getRoleToMapMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE_TO_MAP_MAP_ENTRY__VALUE = eINSTANCE.getRoleToMapMapEntry_Value();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.StubNodeImpl <em>Stub Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.StubNodeImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getStubNode()
		 * @generated
		 */
		EClass STUB_NODE = eINSTANCE.getStubNode();

		/**
		 * The meta object literal for the '<em><b>Start Point Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STUB_NODE__START_POINT_REFERENCE = eINSTANCE.getStubNode_StartPointReference();

		/**
		 * The meta object literal for the '<em><b>End Point Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STUB_NODE__END_POINT_REFERENCE = eINSTANCE.getStubNode_EndPointReference();

		/**
		 * The meta object literal for the '<em><b>Referenced Map</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STUB_NODE__REFERENCED_MAP = eINSTANCE.getStubNode_ReferencedMap();

		/**
		 * The meta object literal for the '<em><b>Family</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STUB_NODE__FAMILY = eINSTANCE.getStubNode_Family();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.ForkConditionImpl <em>Fork Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.ForkConditionImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getForkCondition()
		 * @generated
		 */
		EClass FORK_CONDITION = eINSTANCE.getForkCondition();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORK_CONDITION__CONDITION = eINSTANCE.getForkCondition_Condition();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.ExtensibleElementImpl <em>Extensible Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.ExtensibleElementImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getExtensibleElement()
		 * @generated
		 */
		EClass EXTENSIBLE_ELEMENT = eINSTANCE.getExtensibleElement();

		/**
		 * The meta object literal for the '<em><b>Extended Data</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSIBLE_ELEMENT__EXTENDED_DATA = eINSTANCE.getExtensibleElement_ExtendedData();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.EStringToEObjectMapEntryImpl <em>EString To EObject Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.EStringToEObjectMapEntryImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getEStringToEObjectMapEntry()
		 * @generated
		 */
		EClass ESTRING_TO_EOBJECT_MAP_ENTRY = eINSTANCE.getEStringToEObjectMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_EOBJECT_MAP_ENTRY__KEY = eINSTANCE.getEStringToEObjectMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESTRING_TO_EOBJECT_MAP_ENTRY__VALUE = eINSTANCE.getEStringToEObjectMapEntry_Value();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.ConditionEventImpl <em>Condition Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.ConditionEventImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getConditionEvent()
		 * @generated
		 */
		EClass CONDITION_EVENT = eINSTANCE.getConditionEvent();

		/**
		 * The meta object literal for the '<em><b>Condition Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION_EVENT__CONDITION_EVENT = eINSTANCE.getConditionEvent_ConditionEvent();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION_EVENT__DESCRIPTION = eINSTANCE.getConditionEvent_Description();

		/**
		 * The meta object literal for the '<em><b>Associated Conditions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION_EVENT__ASSOCIATED_CONDITIONS = eINSTANCE.getConditionEvent_AssociatedConditions();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.ConditionEventToConditionEventMapEntryImpl <em>Condition Event To Condition Event Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.ConditionEventToConditionEventMapEntryImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getConditionEventToConditionEventMapEntry()
		 * @generated
		 */
		EClass CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY = eINSTANCE.getConditionEventToConditionEventMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY__KEY = eINSTANCE.getConditionEventToConditionEventMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY__VALUE = eINSTANCE.getConditionEventToConditionEventMapEntry_Value();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.TimerNodeImpl <em>Timer Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.TimerNodeImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getTimerNode()
		 * @generated
		 */
		EClass TIMER_NODE = eINSTANCE.getTimerNode();

		/**
		 * The meta object literal for the '<em><b>Timer Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMER_NODE__TIMER_NAME = eINSTANCE.getTimerNode_TimerName();

		/**
		 * The meta object literal for the '<em><b>Timer Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMER_NODE__TIMER_DESCRIPTION = eINSTANCE.getTimerNode_TimerDescription();

		/**
		 * The meta object literal for the '<em><b>Timer Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMER_NODE__TIMER_TYPE = eINSTANCE.getTimerNode_TimerType();

		/**
		 * The meta object literal for the '<em><b>Timer Time Out</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMER_NODE__TIMER_TIME_OUT = eINSTANCE.getTimerNode_TimerTimeOut();

		/**
		 * The meta object literal for the '<em><b>Timer Time Out Unity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMER_NODE__TIMER_TIME_OUT_UNITY = eINSTANCE.getTimerNode_TimerTimeOutUnity();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.DirectionArrowNodeImpl <em>Direction Arrow Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.DirectionArrowNodeImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getDirectionArrowNode()
		 * @generated
		 */
		EClass DIRECTION_ARROW_NODE = eINSTANCE.getDirectionArrowNode();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.ConditionedStubImpl <em>Conditioned Stub</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.ConditionedStubImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getConditionedStub()
		 * @generated
		 */
		EClass CONDITIONED_STUB = eINSTANCE.getConditionedStub();

		/**
		 * The meta object literal for the '<em><b>Stub</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONED_STUB__STUB = eINSTANCE.getConditionedStub_Stub();

		/**
		 * The meta object literal for the '<em><b>Responsibility Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONED_STUB__RESPONSIBILITY_NODE = eINSTANCE.getConditionedStub_ResponsibilityNode();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.impl.DynamicStubNodeImpl <em>Dynamic Stub Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.impl.DynamicStubNodeImpl
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getDynamicStubNode()
		 * @generated
		 */
		EClass DYNAMIC_STUB_NODE = eINSTANCE.getDynamicStubNode();

		/**
		 * The meta object literal for the '<em><b>Conditioned Stubs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_STUB_NODE__CONDITIONED_STUBS = eINSTANCE.getDynamicStubNode_ConditionedStubs();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.coremodel.RelationshipDirection <em>Relationship Direction</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.coremodel.RelationshipDirection
		 * @see org.isistan.flabot.coremodel.impl.CoremodelPackageImpl#getRelationshipDirection()
		 * @generated
		 */
		EEnum RELATIONSHIP_DIRECTION = eINSTANCE.getRelationshipDirection();

	}

} //CoremodelPackage
