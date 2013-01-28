/**
 * <copyright>
 * </copyright>
 * $Id: CoremodelSwitch.java,v 1.88 2006/04/11 23:31:51 franco Exp $
 */
package org.isistan.flabot.coremodel.util;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EClass;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.coremodel.CoremodelPackage
 * @generated
 */
public class CoremodelSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CoremodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoremodelSwitch() {
		if (modelPackage == null) {
			modelPackage = CoremodelPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CoremodelPackage.BEHAVIORAL_FEATURE_MODEL: {
				BehavioralFeatureModel behavioralFeatureModel = (BehavioralFeatureModel)theEObject;
				Object result = caseBehavioralFeatureModel(behavioralFeatureModel);
				if (result == null) result = caseFeatureModel(behavioralFeatureModel);
				if (result == null) result = caseNamedElementModel(behavioralFeatureModel);
				if (result == null) result = caseExtensibleElement(behavioralFeatureModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.COMPONENT_MODEL: {
				ComponentModel componentModel = (ComponentModel)theEObject;
				Object result = caseComponentModel(componentModel);
				if (result == null) result = caseExtensibleElement(componentModel);
				if (result == null) result = caseNamedElementModel(componentModel);
				if (result == null) result = casePropertyElementModel(componentModel);
				if (result == null) result = caseStereotypedElementModel(componentModel);
				if (result == null) result = caseNoteElementModel(componentModel);
				if (result == null) result = caseAdapter(componentModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.CORE_MODEL: {
				CoreModel coreModel = (CoreModel)theEObject;
				Object result = caseCoreModel(coreModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.FEATURE_MODEL: {
				FeatureModel featureModel = (FeatureModel)theEObject;
				Object result = caseFeatureModel(featureModel);
				if (result == null) result = caseNamedElementModel(featureModel);
				if (result == null) result = caseExtensibleElement(featureModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.INTERFACE_MODEL: {
				InterfaceModel interfaceModel = (InterfaceModel)theEObject;
				Object result = caseInterfaceModel(interfaceModel);
				if (result == null) result = caseNamedElementModel(interfaceModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.NAMED_ELEMENT_MODEL: {
				NamedElementModel namedElementModel = (NamedElementModel)theEObject;
				Object result = caseNamedElementModel(namedElementModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.PORT_MODEL: {
				PortModel portModel = (PortModel)theEObject;
				Object result = casePortModel(portModel);
				if (result == null) result = caseNamedElementModel(portModel);
				if (result == null) result = casePropertyElementModel(portModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.RESPONSIBILITY: {
				Responsibility responsibility = (Responsibility)theEObject;
				Object result = caseResponsibility(responsibility);
				if (result == null) result = caseBehavioralFeatureModel(responsibility);
				if (result == null) result = caseFeatureModel(responsibility);
				if (result == null) result = caseNamedElementModel(responsibility);
				if (result == null) result = caseExtensibleElement(responsibility);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.USE_CASE_MAP: {
				UseCaseMap useCaseMap = (UseCaseMap)theEObject;
				Object result = caseUseCaseMap(useCaseMap);
				if (result == null) result = caseNamedElementModel(useCaseMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.PATH: {
				Path path = (Path)theEObject;
				Object result = casePath(path);
				if (result == null) result = caseNamedElementModel(path);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.PATH_NODE: {
				PathNode pathNode = (PathNode)theEObject;
				Object result = casePathNode(pathNode);
				if (result == null) result = caseNoteElementModel(pathNode);
				if (result == null) result = caseInterfacePrologCode(pathNode);
				if (result == null) result = caseExtensibleElement(pathNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.INTERFACE_LINK: {
				InterfaceLink interfaceLink = (InterfaceLink)theEObject;
				Object result = caseInterfaceLink(interfaceLink);
				if (result == null) result = caseNamedElementModel(interfaceLink);
				if (result == null) result = caseNoteElementModel(interfaceLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.PROPERTY_ELEMENT_MODEL: {
				PropertyElementModel propertyElementModel = (PropertyElementModel)theEObject;
				Object result = casePropertyElementModel(propertyElementModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.PROPERTY: {
				Property property = (Property)theEObject;
				Object result = caseProperty(property);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.RELATIONSHIP: {
				Relationship relationship = (Relationship)theEObject;
				Object result = caseRelationship(relationship);
				if (result == null) result = caseNamedElementModel(relationship);
				if (result == null) result = casePropertyElementModel(relationship);
				if (result == null) result = caseStereotypedElementModel(relationship);
				if (result == null) result = caseNoteElementModel(relationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.COMPONENT_ROLE: {
				ComponentRole componentRole = (ComponentRole)theEObject;
				Object result = caseComponentRole(componentRole);
				if (result == null) result = caseExtensibleElement(componentRole);
				if (result == null) result = caseNamedElementModel(componentRole);
				if (result == null) result = caseNoteElementModel(componentRole);
				if (result == null) result = caseAdapter(componentRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.FORK_NODE: {
				ForkNode forkNode = (ForkNode)theEObject;
				Object result = caseForkNode(forkNode);
				if (result == null) result = caseResponsibilityNode(forkNode);
				if (result == null) result = caseSimplePathNode(forkNode);
				if (result == null) result = caseAdapter(forkNode);
				if (result == null) result = casePathNode(forkNode);
				if (result == null) result = caseNamedElementModel(forkNode);
				if (result == null) result = caseNoteElementModel(forkNode);
				if (result == null) result = caseInterfacePrologCode(forkNode);
				if (result == null) result = caseExtensibleElement(forkNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.SIMPLE_PATH_NODE: {
				SimplePathNode simplePathNode = (SimplePathNode)theEObject;
				Object result = caseSimplePathNode(simplePathNode);
				if (result == null) result = casePathNode(simplePathNode);
				if (result == null) result = caseNamedElementModel(simplePathNode);
				if (result == null) result = caseNoteElementModel(simplePathNode);
				if (result == null) result = caseInterfacePrologCode(simplePathNode);
				if (result == null) result = caseExtensibleElement(simplePathNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.STEREOTYPE: {
				Stereotype stereotype = (Stereotype)theEObject;
				Object result = caseStereotype(stereotype);
				if (result == null) result = caseNamedElementModel(stereotype);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.STEREOTYPED_ELEMENT_MODEL: {
				StereotypedElementModel stereotypedElementModel = (StereotypedElementModel)theEObject;
				Object result = caseStereotypedElementModel(stereotypedElementModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.RESPONSIBILITY_NODE: {
				ResponsibilityNode responsibilityNode = (ResponsibilityNode)theEObject;
				Object result = caseResponsibilityNode(responsibilityNode);
				if (result == null) result = caseSimplePathNode(responsibilityNode);
				if (result == null) result = caseAdapter(responsibilityNode);
				if (result == null) result = casePathNode(responsibilityNode);
				if (result == null) result = caseNamedElementModel(responsibilityNode);
				if (result == null) result = caseNoteElementModel(responsibilityNode);
				if (result == null) result = caseInterfacePrologCode(responsibilityNode);
				if (result == null) result = caseExtensibleElement(responsibilityNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.CONDITION: {
				Condition condition = (Condition)theEObject;
				Object result = caseCondition(condition);
				if (result == null) result = caseNamedElementModel(condition);
				if (result == null) result = caseInterfacePrologCode(condition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.NOTE: {
				Note note = (Note)theEObject;
				Object result = caseNote(note);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.NOTE_ELEMENT_MODEL: {
				NoteElementModel noteElementModel = (NoteElementModel)theEObject;
				Object result = caseNoteElementModel(noteElementModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.FAMILY: {
				Family family = (Family)theEObject;
				Object result = caseFamily(family);
				if (result == null) result = caseNamedElementModel(family);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.FAMILY_ELEMENT: {
				FamilyElement familyElement = (FamilyElement)theEObject;
				Object result = caseFamilyElement(familyElement);
				if (result == null) result = caseNamedElementModel(familyElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.JOIN_NODE: {
				JoinNode joinNode = (JoinNode)theEObject;
				Object result = caseJoinNode(joinNode);
				if (result == null) result = caseResponsibilityNode(joinNode);
				if (result == null) result = caseSimplePathNode(joinNode);
				if (result == null) result = caseAdapter(joinNode);
				if (result == null) result = casePathNode(joinNode);
				if (result == null) result = caseNamedElementModel(joinNode);
				if (result == null) result = caseNoteElementModel(joinNode);
				if (result == null) result = caseInterfacePrologCode(joinNode);
				if (result == null) result = caseExtensibleElement(joinNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.REGISTRABLE: {
				Registrable registrable = (Registrable)theEObject;
				Object result = caseRegistrable(registrable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.RESPONSIBILITY_REGISTRY: {
				ResponsibilityRegistry responsibilityRegistry = (ResponsibilityRegistry)theEObject;
				Object result = caseResponsibilityRegistry(responsibilityRegistry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.RESPONSIBILITY_TO_REGISTRABLE_MAP_ENTRY: {
				Map.Entry responsibilityToRegistrableMapEntry = (Map.Entry)theEObject;
				Object result = caseResponsibilityToRegistrableMapEntry(responsibilityToRegistrableMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.COMPONENT_TO_MAP_MAP_ENTRY: {
				Map.Entry componentToMapMapEntry = (Map.Entry)theEObject;
				Object result = caseComponentToMapMapEntry(componentToMapMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.ROLE_TO_MAP_MAP_ENTRY: {
				Map.Entry roleToMapMapEntry = (Map.Entry)theEObject;
				Object result = caseRoleToMapMapEntry(roleToMapMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.STUB_NODE: {
				StubNode stubNode = (StubNode)theEObject;
				Object result = caseStubNode(stubNode);
				if (result == null) result = caseSimplePathNode(stubNode);
				if (result == null) result = casePathNode(stubNode);
				if (result == null) result = caseNamedElementModel(stubNode);
				if (result == null) result = caseNoteElementModel(stubNode);
				if (result == null) result = caseInterfacePrologCode(stubNode);
				if (result == null) result = caseExtensibleElement(stubNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.FORK_CONDITION: {
				ForkCondition forkCondition = (ForkCondition)theEObject;
				Object result = caseForkCondition(forkCondition);
				if (result == null) result = caseNamedElementModel(forkCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.EXTENSIBLE_ELEMENT: {
				ExtensibleElement extensibleElement = (ExtensibleElement)theEObject;
				Object result = caseExtensibleElement(extensibleElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.ESTRING_TO_EOBJECT_MAP_ENTRY: {
				Map.Entry eStringToEObjectMapEntry = (Map.Entry)theEObject;
				Object result = caseEStringToEObjectMapEntry(eStringToEObjectMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.CONDITION_EVENT: {
				ConditionEvent conditionEvent = (ConditionEvent)theEObject;
				Object result = caseConditionEvent(conditionEvent);
				if (result == null) result = caseNamedElementModel(conditionEvent);
				if (result == null) result = caseExtensibleElement(conditionEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY: {
				Map.Entry conditionEventToConditionEventMapEntry = (Map.Entry)theEObject;
				Object result = caseConditionEventToConditionEventMapEntry(conditionEventToConditionEventMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.TIMER_NODE: {
				TimerNode timerNode = (TimerNode)theEObject;
				Object result = caseTimerNode(timerNode);
				if (result == null) result = caseResponsibilityNode(timerNode);
				if (result == null) result = caseSimplePathNode(timerNode);
				if (result == null) result = caseAdapter(timerNode);
				if (result == null) result = casePathNode(timerNode);
				if (result == null) result = caseNamedElementModel(timerNode);
				if (result == null) result = caseNoteElementModel(timerNode);
				if (result == null) result = caseInterfacePrologCode(timerNode);
				if (result == null) result = caseExtensibleElement(timerNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.DIRECTION_ARROW_NODE: {
				DirectionArrowNode directionArrowNode = (DirectionArrowNode)theEObject;
				Object result = caseDirectionArrowNode(directionArrowNode);
				if (result == null) result = caseSimplePathNode(directionArrowNode);
				if (result == null) result = casePathNode(directionArrowNode);
				if (result == null) result = caseNamedElementModel(directionArrowNode);
				if (result == null) result = caseNoteElementModel(directionArrowNode);
				if (result == null) result = caseInterfacePrologCode(directionArrowNode);
				if (result == null) result = caseExtensibleElement(directionArrowNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.CONDITIONED_STUB: {
				ConditionedStub conditionedStub = (ConditionedStub)theEObject;
				Object result = caseConditionedStub(conditionedStub);
				if (result == null) result = caseNamedElementModel(conditionedStub);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CoremodelPackage.DYNAMIC_STUB_NODE: {
				DynamicStubNode dynamicStubNode = (DynamicStubNode)theEObject;
				Object result = caseDynamicStubNode(dynamicStubNode);
				if (result == null) result = caseSimplePathNode(dynamicStubNode);
				if (result == null) result = casePathNode(dynamicStubNode);
				if (result == null) result = caseNamedElementModel(dynamicStubNode);
				if (result == null) result = caseNoteElementModel(dynamicStubNode);
				if (result == null) result = caseInterfacePrologCode(dynamicStubNode);
				if (result == null) result = caseExtensibleElement(dynamicStubNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Behavioral Feature Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behavioral Feature Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBehavioralFeatureModel(BehavioralFeatureModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseComponentModel(ComponentModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Core Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Core Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCoreModel(CoreModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFeatureModel(FeatureModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseInterfaceModel(InterfaceModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNamedElementModel(NamedElementModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePortModel(PortModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Responsibility</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Responsibility</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseResponsibility(Responsibility object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Use Case Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Use Case Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUseCaseMap(UseCaseMap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Path</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePath(Path object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Path Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePathNode(PathNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseInterfaceLink(InterfaceLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Element Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Element Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePropertyElementModel(PropertyElementModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRelationship(Relationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseComponentRole(ComponentRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Adapter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Adapter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAdapter(Adapter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fork Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fork Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseForkNode(ForkNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Path Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Path Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSimplePathNode(SimplePathNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stereotype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stereotype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStereotype(Stereotype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stereotyped Element Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stereotyped Element Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStereotypedElementModel(StereotypedElementModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Responsibility Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Responsibility Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseResponsibilityNode(ResponsibilityNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCondition(Condition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Note</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Note</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNote(Note object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Note Element Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Note Element Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNoteElementModel(NoteElementModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Family</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Family</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFamily(Family object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Family Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Family Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFamilyElement(FamilyElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Prolog Code</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Prolog Code</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseInterfacePrologCode(InterfacePrologCode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Join Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Join Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJoinNode(JoinNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Registrable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Registrable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRegistrable(Registrable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Responsibility Registry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Responsibility Registry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseResponsibilityRegistry(ResponsibilityRegistry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Responsibility To Registrable Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Responsibility To Registrable Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseResponsibilityToRegistrableMapEntry(Map.Entry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component To Map Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component To Map Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseComponentToMapMapEntry(Map.Entry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Role To Map Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Role To Map Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRoleToMapMapEntry(Map.Entry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stub Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stub Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStubNode(StubNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fork Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fork Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseForkCondition(ForkCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extensible Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extensible Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExtensibleElement(ExtensibleElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EString To EObject Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EString To EObject Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEStringToEObjectMapEntry(Map.Entry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConditionEvent(ConditionEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition Event To Condition Event Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition Event To Condition Event Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConditionEventToConditionEventMapEntry(Map.Entry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Timer Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Timer Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTimerNode(TimerNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Direction Arrow Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Direction Arrow Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDirectionArrowNode(DirectionArrowNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditioned Stub</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditioned Stub</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConditionedStub(ConditionedStub object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Stub Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Stub Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDynamicStubNode(DynamicStubNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //CoremodelSwitch
