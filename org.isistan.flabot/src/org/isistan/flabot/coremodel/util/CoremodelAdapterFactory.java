/**
 * $Id: CoremodelAdapterFactory.java,v 1.82 2006/04/11 23:31:51 franco Exp $
 */
package org.isistan.flabot.coremodel.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.isistan.flabot.coremodel.*;
import org.isistan.flabot.coremodel.BehavioralFeatureModel;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelPackage;
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
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.ResponsibilityRegistry;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.Stereotype;
import org.isistan.flabot.coremodel.StereotypedElementModel;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.coremodel.UseCaseMap;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.coremodel.CoremodelPackage
 * @generated
 */
public class CoremodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CoremodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoremodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CoremodelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoremodelSwitch modelSwitch =
		new CoremodelSwitch() {
			public Object caseBehavioralFeatureModel(BehavioralFeatureModel object) {
				return createBehavioralFeatureModelAdapter();
			}
			public Object caseComponentModel(ComponentModel object) {
				return createComponentModelAdapter();
			}
			public Object caseCoreModel(CoreModel object) {
				return createCoreModelAdapter();
			}
			public Object caseFeatureModel(FeatureModel object) {
				return createFeatureModelAdapter();
			}
			public Object caseInterfaceModel(InterfaceModel object) {
				return createInterfaceModelAdapter();
			}
			public Object caseNamedElementModel(NamedElementModel object) {
				return createNamedElementModelAdapter();
			}
			public Object casePortModel(PortModel object) {
				return createPortModelAdapter();
			}
			public Object caseResponsibility(Responsibility object) {
				return createResponsibilityAdapter();
			}
			public Object caseUseCaseMap(UseCaseMap object) {
				return createUseCaseMapAdapter();
			}
			public Object casePath(Path object) {
				return createPathAdapter();
			}
			public Object casePathNode(PathNode object) {
				return createPathNodeAdapter();
			}
			public Object caseInterfaceLink(InterfaceLink object) {
				return createInterfaceLinkAdapter();
			}
			public Object casePropertyElementModel(PropertyElementModel object) {
				return createPropertyElementModelAdapter();
			}
			public Object caseProperty(Property object) {
				return createPropertyAdapter();
			}
			public Object caseRelationship(Relationship object) {
				return createRelationshipAdapter();
			}
			public Object caseComponentRole(ComponentRole object) {
				return createComponentRoleAdapter();
			}
			public Object caseAdapter(Adapter object) {
				return createAdapterAdapter();
			}
			public Object caseForkNode(ForkNode object) {
				return createForkNodeAdapter();
			}
			public Object caseSimplePathNode(SimplePathNode object) {
				return createSimplePathNodeAdapter();
			}
			public Object caseStereotype(Stereotype object) {
				return createStereotypeAdapter();
			}
			public Object caseStereotypedElementModel(StereotypedElementModel object) {
				return createStereotypedElementModelAdapter();
			}
			public Object caseResponsibilityNode(ResponsibilityNode object) {
				return createResponsibilityNodeAdapter();
			}
			public Object caseCondition(Condition object) {
				return createConditionAdapter();
			}
			public Object caseNote(Note object) {
				return createNoteAdapter();
			}
			public Object caseNoteElementModel(NoteElementModel object) {
				return createNoteElementModelAdapter();
			}
			public Object caseFamily(Family object) {
				return createFamilyAdapter();
			}
			public Object caseFamilyElement(FamilyElement object) {
				return createFamilyElementAdapter();
			}
			public Object caseInterfacePrologCode(InterfacePrologCode object) {
				return createInterfacePrologCodeAdapter();
			}
			public Object caseJoinNode(JoinNode object) {
				return createJoinNodeAdapter();
			}
			public Object caseRegistrable(Registrable object) {
				return createRegistrableAdapter();
			}
			public Object caseResponsibilityRegistry(ResponsibilityRegistry object) {
				return createResponsibilityRegistryAdapter();
			}
			public Object caseResponsibilityToRegistrableMapEntry(Map.Entry object) {
				return createResponsibilityToRegistrableMapEntryAdapter();
			}
			public Object caseComponentToMapMapEntry(Map.Entry object) {
				return createComponentToMapMapEntryAdapter();
			}
			public Object caseRoleToMapMapEntry(Map.Entry object) {
				return createRoleToMapMapEntryAdapter();
			}
			public Object caseStubNode(StubNode object) {
				return createStubNodeAdapter();
			}
			public Object caseForkCondition(ForkCondition object) {
				return createForkConditionAdapter();
			}
			public Object caseExtensibleElement(ExtensibleElement object) {
				return createExtensibleElementAdapter();
			}
			public Object caseEStringToEObjectMapEntry(Map.Entry object) {
				return createEStringToEObjectMapEntryAdapter();
			}
			public Object caseConditionEvent(ConditionEvent object) {
				return createConditionEventAdapter();
			}
			public Object caseConditionEventToConditionEventMapEntry(Map.Entry object) {
				return createConditionEventToConditionEventMapEntryAdapter();
			}
			public Object caseTimerNode(TimerNode object) {
				return createTimerNodeAdapter();
			}
			public Object caseDirectionArrowNode(DirectionArrowNode object) {
				return createDirectionArrowNodeAdapter();
			}
			public Object caseConditionedStub(ConditionedStub object) {
				return createConditionedStubAdapter();
			}
			public Object caseDynamicStubNode(DynamicStubNode object) {
				return createDynamicStubNodeAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.BehavioralFeatureModel <em>Behavioral Feature Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.BehavioralFeatureModel
	 * @generated
	 */
	public Adapter createBehavioralFeatureModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.ComponentModel <em>Component Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.ComponentModel
	 * @generated
	 */
	public Adapter createComponentModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.CoreModel <em>Core Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.CoreModel
	 * @generated
	 */
	public Adapter createCoreModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.FeatureModel <em>Feature Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.FeatureModel
	 * @generated
	 */
	public Adapter createFeatureModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.InterfaceModel <em>Interface Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.InterfaceModel
	 * @generated
	 */
	public Adapter createInterfaceModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.NamedElementModel <em>Named Element Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.NamedElementModel
	 * @generated
	 */
	public Adapter createNamedElementModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.PortModel <em>Port Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.PortModel
	 * @generated
	 */
	public Adapter createPortModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.Responsibility <em>Responsibility</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.Responsibility
	 * @generated
	 */
	public Adapter createResponsibilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.UseCaseMap <em>Use Case Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.UseCaseMap
	 * @generated
	 */
	public Adapter createUseCaseMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.Path <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.Path
	 * @generated
	 */
	public Adapter createPathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.PathNode <em>Path Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.PathNode
	 * @generated
	 */
	public Adapter createPathNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.InterfaceLink <em>Interface Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.InterfaceLink
	 * @generated
	 */
	public Adapter createInterfaceLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.PropertyElementModel <em>Property Element Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.PropertyElementModel
	 * @generated
	 */
	public Adapter createPropertyElementModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.Property
	 * @generated
	 */
	public Adapter createPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.Relationship <em>Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.Relationship
	 * @generated
	 */
	public Adapter createRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.ComponentRole <em>Component Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.ComponentRole
	 * @generated
	 */
	public Adapter createComponentRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.common.notify.Adapter <em>Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.common.notify.Adapter
	 * @generated
	 */
	public Adapter createAdapterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.ForkNode <em>Fork Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.ForkNode
	 * @generated
	 */
	public Adapter createForkNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.SimplePathNode <em>Simple Path Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.SimplePathNode
	 * @generated
	 */
	public Adapter createSimplePathNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.Stereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.Stereotype
	 * @generated
	 */
	public Adapter createStereotypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.StereotypedElementModel <em>Stereotyped Element Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.StereotypedElementModel
	 * @generated
	 */
	public Adapter createStereotypedElementModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.ResponsibilityNode <em>Responsibility Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.ResponsibilityNode
	 * @generated
	 */
	public Adapter createResponsibilityNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.Condition
	 * @generated
	 */
	public Adapter createConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.Note <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.Note
	 * @generated
	 */
	public Adapter createNoteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.NoteElementModel <em>Note Element Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.NoteElementModel
	 * @generated
	 */
	public Adapter createNoteElementModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.Family <em>Family</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.Family
	 * @generated
	 */
	public Adapter createFamilyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.FamilyElement <em>Family Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.FamilyElement
	 * @generated
	 */
	public Adapter createFamilyElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.InterfacePrologCode <em>Interface Prolog Code</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.InterfacePrologCode
	 * @generated
	 */
	public Adapter createInterfacePrologCodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.JoinNode <em>Join Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.JoinNode
	 * @generated
	 */
	public Adapter createJoinNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.Registrable <em>Registrable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.Registrable
	 * @generated
	 */
	public Adapter createRegistrableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.ResponsibilityRegistry <em>Responsibility Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.ResponsibilityRegistry
	 * @generated
	 */
	public Adapter createResponsibilityRegistryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Responsibility To Registrable Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createResponsibilityToRegistrableMapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Component To Map Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createComponentToMapMapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Role To Map Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createRoleToMapMapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.StubNode <em>Stub Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.StubNode
	 * @generated
	 */
	public Adapter createStubNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.ForkCondition <em>Fork Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.ForkCondition
	 * @generated
	 */
	public Adapter createForkConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.ExtensibleElement <em>Extensible Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.ExtensibleElement
	 * @generated
	 */
	public Adapter createExtensibleElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>EString To EObject Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createEStringToEObjectMapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.ConditionEvent <em>Condition Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.ConditionEvent
	 * @generated
	 */
	public Adapter createConditionEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Condition Event To Condition Event Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createConditionEventToConditionEventMapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.TimerNode <em>Timer Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.TimerNode
	 * @generated
	 */
	public Adapter createTimerNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.DirectionArrowNode <em>Direction Arrow Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.DirectionArrowNode
	 * @generated
	 */
	public Adapter createDirectionArrowNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.ConditionedStub <em>Conditioned Stub</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.ConditionedStub
	 * @generated
	 */
	public Adapter createConditionedStubAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.DynamicStubNode <em>Dynamic Stub Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.DynamicStubNode
	 * @generated
	 */
	public Adapter createDynamicStubNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CoremodelAdapterFactory
