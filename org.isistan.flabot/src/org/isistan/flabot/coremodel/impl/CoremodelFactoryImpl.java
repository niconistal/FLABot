/**
 * <copyright>
 * </copyright>
 * $Id: CoremodelFactoryImpl.java,v 1.93 2006/04/12 02:24:57 apersson Exp $
 */
package org.isistan.flabot.coremodel.impl;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.isistan.flabot.coremodel.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.isistan.flabot.coremodel.BehavioralFeatureModel;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.coremodel.ConditionedStub;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.ExtensibleElement;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.coremodel.FamilyElement;
import org.isistan.flabot.coremodel.FeatureModel;
import org.isistan.flabot.coremodel.ForkCondition;
import org.isistan.flabot.coremodel.ForkNode;
import org.isistan.flabot.coremodel.InterfaceLink;
import org.isistan.flabot.coremodel.InterfaceModel;
import org.isistan.flabot.coremodel.JoinNode;
import org.isistan.flabot.coremodel.NamedElementModel;
import org.isistan.flabot.coremodel.Note;
import org.isistan.flabot.coremodel.NoteElementModel;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.PortModel;
import org.isistan.flabot.coremodel.Property;
import org.isistan.flabot.coremodel.PropertyElementModel;
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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CoremodelFactoryImpl extends EFactoryImpl implements CoremodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CoremodelFactory init() {
		try {
			CoremodelFactory theCoremodelFactory = (CoremodelFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/isistan/flabot/coremodel.ecore"); 
			if (theCoremodelFactory != null) {
				return theCoremodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CoremodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoremodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CoremodelPackage.BEHAVIORAL_FEATURE_MODEL: return createBehavioralFeatureModel();
			case CoremodelPackage.COMPONENT_MODEL: return createComponentModel();
			case CoremodelPackage.CORE_MODEL: return createCoreModel();
			case CoremodelPackage.FEATURE_MODEL: return createFeatureModel();
			case CoremodelPackage.INTERFACE_MODEL: return createInterfaceModel();
			case CoremodelPackage.NAMED_ELEMENT_MODEL: return createNamedElementModel();
			case CoremodelPackage.PORT_MODEL: return createPortModel();
			case CoremodelPackage.RESPONSIBILITY: return createResponsibility();
			case CoremodelPackage.USE_CASE_MAP: return createUseCaseMap();
			case CoremodelPackage.PATH: return createPath();
			case CoremodelPackage.INTERFACE_LINK: return createInterfaceLink();
			case CoremodelPackage.PROPERTY_ELEMENT_MODEL: return createPropertyElementModel();
			case CoremodelPackage.PROPERTY: return createProperty();
			case CoremodelPackage.RELATIONSHIP: return createRelationship();
			case CoremodelPackage.COMPONENT_ROLE: return createComponentRole();
			case CoremodelPackage.FORK_NODE: return createForkNode();
			case CoremodelPackage.SIMPLE_PATH_NODE: return createSimplePathNode();
			case CoremodelPackage.STEREOTYPE: return createStereotype();
			case CoremodelPackage.STEREOTYPED_ELEMENT_MODEL: return createStereotypedElementModel();
			case CoremodelPackage.RESPONSIBILITY_NODE: return createResponsibilityNode();
			case CoremodelPackage.CONDITION: return createCondition();
			case CoremodelPackage.NOTE: return createNote();
			case CoremodelPackage.NOTE_ELEMENT_MODEL: return createNoteElementModel();
			case CoremodelPackage.FAMILY: return createFamily();
			case CoremodelPackage.FAMILY_ELEMENT: return createFamilyElement();
			case CoremodelPackage.JOIN_NODE: return createJoinNode();
			case CoremodelPackage.RESPONSIBILITY_REGISTRY: return createResponsibilityRegistry();
			case CoremodelPackage.RESPONSIBILITY_TO_REGISTRABLE_MAP_ENTRY: return (EObject)createResponsibilityToRegistrableMapEntry();
			case CoremodelPackage.COMPONENT_TO_MAP_MAP_ENTRY: return (EObject)createComponentToMapMapEntry();
			case CoremodelPackage.ROLE_TO_MAP_MAP_ENTRY: return (EObject)createRoleToMapMapEntry();
			case CoremodelPackage.STUB_NODE: return createStubNode();
			case CoremodelPackage.FORK_CONDITION: return createForkCondition();
			case CoremodelPackage.EXTENSIBLE_ELEMENT: return createExtensibleElement();
			case CoremodelPackage.ESTRING_TO_EOBJECT_MAP_ENTRY: return (EObject)createEStringToEObjectMapEntry();
			case CoremodelPackage.CONDITION_EVENT: return createConditionEvent();
			case CoremodelPackage.CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY: return (EObject)createConditionEventToConditionEventMapEntry();
			case CoremodelPackage.TIMER_NODE: return createTimerNode();
			case CoremodelPackage.DIRECTION_ARROW_NODE: return createDirectionArrowNode();
			case CoremodelPackage.CONDITIONED_STUB: return createConditionedStub();
			case CoremodelPackage.DYNAMIC_STUB_NODE: return createDynamicStubNode();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CoremodelPackage.RELATIONSHIP_DIRECTION:
				return createRelationshipDirectionFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CoremodelPackage.RELATIONSHIP_DIRECTION:
				return convertRelationshipDirectionToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehavioralFeatureModel createBehavioralFeatureModel() {
		BehavioralFeatureModelImpl behavioralFeatureModel = new BehavioralFeatureModelImpl();
		return behavioralFeatureModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentModel createComponentModelGen() {
		ComponentModelImpl componentModel = new ComponentModelImpl();
		return componentModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ComponentModel createComponentModel() {
		ComponentModel componentModel = createComponentModelGen();
		componentModel.setName("NonameComponent");
		return componentModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ComponentModel createComponentModel(ComponentModel copyComponentModel) {
		if (copyComponentModel == null)
			return createComponentModel();
		
		ComponentModelImpl componentModel = new ComponentModelImpl();
		for(Iterator iter = copyComponentModel.getFeatures().iterator(); iter.hasNext();)
			componentModel.getFeatures().add(iter.next());

		componentModel.setStereotype(copyComponentModel.getStereotype());
		componentModel.setName(copyComponentModel.getName());
		return componentModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreModel createCoreModel() {
		CoreModelImpl coreModel = new CoreModelImpl();
		return coreModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureModel createFeatureModel() {
		FeatureModelImpl featureModel = new FeatureModelImpl();
		return featureModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceModel createInterfaceModelGen() {
		InterfaceModelImpl interfaceModel = new InterfaceModelImpl();
		return interfaceModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public InterfaceModel createInterfaceModel() {
		InterfaceModel interfaceModel = createInterfaceModelGen();
		interfaceModel.setName("NonameInterface");
		return interfaceModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public InterfaceModel createInterfaceModel(InterfaceModel copyInterfaceModel) {
		if (copyInterfaceModel == null)
			return createInterfaceModel();
		
		InterfaceModelImpl interfaceModel = new InterfaceModelImpl();
		interfaceModel.setName(copyInterfaceModel.getName());
		return interfaceModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElementModel createNamedElementModel() {
		NamedElementModelImpl namedElementModel = new NamedElementModelImpl();
		return namedElementModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortModel createPortModelGen() {
		PortModelImpl portModel = new PortModelImpl();
		return portModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PortModel createPortModel() {
		PortModel portModel = createPortModelGen();
		portModel.setName("NonamePort");
		return portModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PortModel createPortModel(PortModel copyPortModel) {
		if (copyPortModel == null)
			return createPortModel();
		
		PortModelImpl portModel = new PortModelImpl();
		portModel.setName(copyPortModel.getName());
		return portModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Responsibility createResponsibility() {
		ResponsibilityImpl responsibility = new ResponsibilityImpl();
		return responsibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCaseMap createUseCaseMap() {
		UseCaseMapImpl useCaseMap = new UseCaseMapImpl();
		return useCaseMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Path createPathGen() {
		PathImpl path = new PathImpl();
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Path createPath() {
		Path path = createPathGen();
		path.setName("NonamePath");
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceLink createInterfaceLink() {
		InterfaceLinkImpl interfaceLink = new InterfaceLinkImpl();
		return interfaceLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyElementModel createPropertyElementModel() {
		PropertyElementModelImpl propertyElementModel = new PropertyElementModelImpl();
		return propertyElementModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relationship createRelationship() {
		RelationshipImpl relationship = new RelationshipImpl();
		return relationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Relationship createRelationship(Relationship copyRelationship) {
		Relationship relationship = createRelationship();
		if (copyRelationship == null)
			return relationship;
		
		relationship.setName(copyRelationship.getName());
		relationship.setStereotype(copyRelationship.getStereotype());
		return relationship;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentRole createComponentRole() {
		ComponentRoleImpl componentRole = new ComponentRoleImpl();
		return componentRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForkNode createForkNode() {
		ForkNodeImpl forkNode = new ForkNodeImpl();
		return forkNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ComponentRole createComponentRole(ComponentRole copyComponent) {
		if (copyComponent == null)
			return createComponentRole();
			
		ComponentRoleImpl componentRole = new ComponentRoleImpl();
		componentRole.setName(copyComponent.getName());
		componentRole.setComponent(copyComponent.getComponent());
		return componentRole;
	}

	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ForkNode createForkNode(Responsibility r, int type, int outputsCount) {
		ForkNode forkNode = createForkNode();
		forkNode.setForkType(type);
		if (type == ForkNode.OR_FORK_TYPE) {
			for (int i=1; i<=outputsCount; i++) {
				ForkCondition c = createForkCondition();
				c.setName("C" + i);
				forkNode.getConditions().add(c);
			}
		}
		
		forkNode.setResponsibility(r);				
		return forkNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode createSimplePathNode() {
		SimplePathNodeImpl simplePathNode = new SimplePathNodeImpl();
		return simplePathNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stereotype createStereotype() {
		StereotypeImpl stereotype = new StereotypeImpl();
		return stereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StereotypedElementModel createStereotypedElementModel() {
		StereotypedElementModelImpl stereotypedElementModel = new StereotypedElementModelImpl();
		return stereotypedElementModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponsibilityNode createResponsibilityNode() {
		ResponsibilityNodeImpl responsibilityNode = new ResponsibilityNodeImpl();
		return responsibilityNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition createCondition() {
		ConditionImpl condition = new ConditionImpl();
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Condition createCondition(Condition copyCondition) {
		Condition condition = (Condition) EcoreUtil.copy(copyCondition); 				
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Note createNote() {
		NoteImpl note = new NoteImpl();
		return note;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Note createNote(Note copyNote) {
		if (copyNote == null)
			return createNote();
		
		NoteImpl note = new NoteImpl();
		note.setNote(copyNote.getNote());
		return note;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NoteElementModel createNoteElementModel() {
		NoteElementModelImpl noteElementModel = new NoteElementModelImpl();
		return noteElementModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Family createFamily() {
		FamilyImpl family = new FamilyImpl();
		return family;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Family createFamily(Family copyFamily) {
		Family family = (Family) EcoreUtil.copy(copyFamily);				
		return family;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FamilyElement createFamilyElement() {
		FamilyElementImpl familyElement = new FamilyElementImpl();
		return familyElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoinNode createJoinNode() {
		JoinNodeImpl joinNode = new JoinNodeImpl();
		return joinNode;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimerNode createTimerNode() {
		TimerNodeImpl timerNode = new TimerNodeImpl();
		return timerNode;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionArrowNode createDirectionArrowNode() {
		DirectionArrowNodeImpl directionArrowNode = new DirectionArrowNodeImpl();
		return directionArrowNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionedStub createConditionedStub() {
		ConditionedStubImpl conditionedStub = new ConditionedStubImpl();
		return conditionedStub;
	}
	
	public ConditionedStub createConditionedStub(ConditionedStub conditionedStubCopy) {
		ConditionedStubImpl conditionedStub = (ConditionedStubImpl) EcoreUtil.copy(conditionedStubCopy);
		return conditionedStub;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DynamicStubNode createDynamicStubNode() {
		DynamicStubNodeImpl dynamicStubNode = new DynamicStubNodeImpl();
		return dynamicStubNode;
	}
	
	public DynamicStubNode createDynamicStubNode(DynamicStubNode copyDynamicStubNode) {
		DynamicStubNode node = new DynamicStubNodeImpl();
		node.setMap(copyDynamicStubNode.getMap());
		node.setName(copyDynamicStubNode.getName());
		node.setPath(copyDynamicStubNode.getPath());
		((DynamicStubNodeImpl)node).eSet(CoremodelPackage.DYNAMIC_STUB_NODE__CONDITIONED_STUBS, copyDynamicStubNode.getConditionedStubs());
		//(DynamicStubNode) EcoreUtil.copy(copyDynamicStubNode);
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationshipDirection createRelationshipDirectionFromString(EDataType eDataType, String initialValue) {
		RelationshipDirection result = RelationshipDirection.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRelationshipDirectionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public JoinNode createJoinNode(Responsibility r, int type) {
		JoinNode joinNode = createJoinNode();
		joinNode.setResponsibility(r);
		joinNode.setJoinType(type);
		return joinNode;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TimerNode createTimerNode(Responsibility r, int type) {
		TimerNode timerNode = createTimerNode();
		timerNode.setResponsibility(r);
		timerNode.setTimerType(type);
		timerNode.setOutputsCount(ForkNode.TWO_OUTPUTS);
		return timerNode;
	}
	
	public TimerNode createTimerNode(TimerNode timer) {
		TimerNode timerNode = createTimerNode();
		timerNode.setResponsibility(timer.getResponsibility());
		timerNode.setName(timer.getName());
		timerNode.setTimerName(timer.getTimerName());
		timerNode.setTimerDescription(timer.getTimerDescription());
		timerNode.setTimerType(timer.getTimerType());
		timerNode.setTimerTimeOut(timer.getTimerTimeOut());
		timerNode.setTimerTimeOutUnity(timer.getTimerTimeOutUnity());
		timerNode.setOutputsCount(ForkNode.TWO_OUTPUTS);
		
		return timerNode;
	}
	
	public TimerNode createTimerNode(int timerType) {
		TimerNode timerNode = createTimerNode();
		timerNode.setTimerType(timerType);
		timerNode.setOutputsCount(ForkNode.TWO_OUTPUTS);
		
		return timerNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponsibilityRegistry createResponsibilityRegistry() {
		ResponsibilityRegistryImpl responsibilityRegistry = new ResponsibilityRegistryImpl();
		return responsibilityRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry createResponsibilityToRegistrableMapEntry() {
		ResponsibilityToRegistrableMapEntryImpl responsibilityToRegistrableMapEntry = new ResponsibilityToRegistrableMapEntryImpl();
		return responsibilityToRegistrableMapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry createComponentToMapMapEntry() {
		ComponentToMapMapEntryImpl componentToMapMapEntry = new ComponentToMapMapEntryImpl();
		return componentToMapMapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry createRoleToMapMapEntry() {
		RoleToMapMapEntryImpl roleToMapMapEntry = new RoleToMapMapEntryImpl();
		return roleToMapMapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StubNode createStubNodeGen() {
		StubNodeImpl stubNode = new StubNodeImpl();
		return stubNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public StubNode createStubNode() {
		StubNode stubNode = createStubNodeGen();
		stubNode.setName("NonameStub");
		return stubNode;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForkCondition createForkCondition() {
		ForkConditionImpl forkCondition = new ForkConditionImpl();
		return forkCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensibleElement createExtensibleElement() {
		ExtensibleElementImpl extensibleElement = new ExtensibleElementImpl();
		return extensibleElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry createEStringToEObjectMapEntry() {
		EStringToEObjectMapEntryImpl eStringToEObjectMapEntry = new EStringToEObjectMapEntryImpl();
		return eStringToEObjectMapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionEvent createConditionEvent() {
		ConditionEventImpl conditionEvent = new ConditionEventImpl();
		return conditionEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry createConditionEventToConditionEventMapEntry() {
		ConditionEventToConditionEventMapEntryImpl conditionEventToConditionEventMapEntry = new ConditionEventToConditionEventMapEntryImpl();
		return conditionEventToConditionEventMapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ConditionEvent createConditionEvent(ConditionEvent copyConditionEvent) {
		ConditionEvent conditionEvent = (ConditionEvent) EcoreUtil.copy(copyConditionEvent);
		/*conditionEvent.setName(copyConditionEvent.getName());
		conditionEvent.setDescription(copyConditionEvent.getDescription());
		conditionEvent.setConditionEvent(copyConditionEvent.getConditionEvent());
		conditionEvent.getExtendedData().addAll(copyConditionEvent.getExtendedData());*/
		return conditionEvent;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public StubNode createStubNode(StubNode copyStubNode) {
		StubNode stubNode =  createStubNode();
		stubNode.setName(copyStubNode.getName());
		//the stub will be inserted in the path node list if this is active
		//stubNode.setPath(copyStubNode.getPath());
		stubNode.setMap(copyStubNode.getMap());
		stubNode.setReferencedMap(copyStubNode.getReferencedMap());
		stubNode.setStartPointReference(copyStubNode.getStartPointReference());
		stubNode.setEndPointReference(copyStubNode.getEndPointReference());
		stubNode.setFamily(copyStubNode.getFamily());
		return stubNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoremodelPackage getCoremodelPackage() {
		return (CoremodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static CoremodelPackage getPackage() {
		return CoremodelPackage.eINSTANCE;
	}

} //CoremodelFactoryImpl
