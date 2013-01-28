/**
 * <copyright>
 * </copyright>
 *
 * $Id: CoremodelValidator.java,v 1.61 2006/04/11 23:31:51 franco Exp $
 */
package org.isistan.flabot.coremodel.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
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
import org.isistan.flabot.coremodel.constraint.ConditionEventGeneralConstraint;
import org.isistan.flabot.coremodel.constraint.ConditionMappingHasCorrectFamilyConstraint;
import org.isistan.flabot.coremodel.constraint.FamilyHasAllComponentConstraint;
import org.isistan.flabot.coremodel.constraint.InterfacesMustHaveSameNameConstraint;
import org.isistan.flabot.coremodel.constraint.ResponsibilityGeneralConstraint;
import org.isistan.flabot.coremodel.constraint.ResponsibilityNodeGeneralConstraint;
import org.isistan.flabot.coremodel.constraint.StubMustHaveFamilyConstraint;
import org.isistan.flabot.coremodel.constraint.UseCaseMapGeneralConstraint;
import org.isistan.flabot.util.consistency.ConsistencyManager;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.coremodel.CoremodelPackage
 * @generated
 */
public class CoremodelValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final CoremodelValidator INSTANCE = new CoremodelValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.isistan.flabot.coremodel";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoremodelValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EPackage getEPackage() {
	  return CoremodelPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map context) {
		switch (classifierID) {
			case CoremodelPackage.BEHAVIORAL_FEATURE_MODEL:
				return validateBehavioralFeatureModel((BehavioralFeatureModel)value, diagnostics, context);
			case CoremodelPackage.COMPONENT_MODEL:
				return validateComponentModel((ComponentModel)value, diagnostics, context);
			case CoremodelPackage.CORE_MODEL:
				return validateCoreModel((CoreModel)value, diagnostics, context);
			case CoremodelPackage.FEATURE_MODEL:
				return validateFeatureModel((FeatureModel)value, diagnostics, context);
			case CoremodelPackage.INTERFACE_MODEL:
				return validateInterfaceModel((InterfaceModel)value, diagnostics, context);
			case CoremodelPackage.NAMED_ELEMENT_MODEL:
				return validateNamedElementModel((NamedElementModel)value, diagnostics, context);
			case CoremodelPackage.PORT_MODEL:
				return validatePortModel((PortModel)value, diagnostics, context);
			case CoremodelPackage.RESPONSIBILITY:
				return validateResponsibility((Responsibility)value, diagnostics, context);
			case CoremodelPackage.USE_CASE_MAP:
				return validateUseCaseMap((UseCaseMap)value, diagnostics, context);
			case CoremodelPackage.PATH:
				return validatePath((Path)value, diagnostics, context);
			case CoremodelPackage.PATH_NODE:
				return validatePathNode((PathNode)value, diagnostics, context);
			case CoremodelPackage.INTERFACE_LINK:
				return validateInterfaceLink((InterfaceLink)value, diagnostics, context);
			case CoremodelPackage.PROPERTY_ELEMENT_MODEL:
				return validatePropertyElementModel((PropertyElementModel)value, diagnostics, context);
			case CoremodelPackage.PROPERTY:
				return validateProperty((Property)value, diagnostics, context);
			case CoremodelPackage.RELATIONSHIP:
				return validateRelationship((Relationship)value, diagnostics, context);
			case CoremodelPackage.COMPONENT_ROLE:
				return validateComponentRole((ComponentRole)value, diagnostics, context);
			case CoremodelPackage.ADAPTER:
				return validateAdapter((Adapter)value, diagnostics, context);
			case CoremodelPackage.FORK_NODE:
				return validateForkNode((ForkNode)value, diagnostics, context);
			case CoremodelPackage.SIMPLE_PATH_NODE:
				return validateSimplePathNode((SimplePathNode)value, diagnostics, context);
			case CoremodelPackage.STEREOTYPE:
				return validateStereotype((Stereotype)value, diagnostics, context);
			case CoremodelPackage.STEREOTYPED_ELEMENT_MODEL:
				return validateStereotypedElementModel((StereotypedElementModel)value, diagnostics, context);
			case CoremodelPackage.RESPONSIBILITY_NODE:
				return validateResponsibilityNode((ResponsibilityNode)value, diagnostics, context);
			case CoremodelPackage.CONDITION:
				return validateCondition((Condition)value, diagnostics, context);
			case CoremodelPackage.NOTE:
				return validateNote((Note)value, diagnostics, context);
			case CoremodelPackage.NOTE_ELEMENT_MODEL:
				return validateNoteElementModel((NoteElementModel)value, diagnostics, context);
			case CoremodelPackage.FAMILY:
				return validateFamily((Family)value, diagnostics, context);
			case CoremodelPackage.FAMILY_ELEMENT:
				return validateFamilyElement((FamilyElement)value, diagnostics, context);
			case CoremodelPackage.INTERFACE_PROLOG_CODE:
				return validateInterfacePrologCode((InterfacePrologCode)value, diagnostics, context);
			case CoremodelPackage.JOIN_NODE:
				return validateJoinNode((JoinNode)value, diagnostics, context);
			case CoremodelPackage.REGISTRABLE:
				return validateRegistrable((Registrable)value, diagnostics, context);
			case CoremodelPackage.RESPONSIBILITY_REGISTRY:
				return validateResponsibilityRegistry((ResponsibilityRegistry)value, diagnostics, context);
			case CoremodelPackage.RESPONSIBILITY_TO_REGISTRABLE_MAP_ENTRY:
				return validateResponsibilityToRegistrableMapEntry((Map.Entry)value, diagnostics, context);
			case CoremodelPackage.COMPONENT_TO_MAP_MAP_ENTRY:
				return validateComponentToMapMapEntry((Map.Entry)value, diagnostics, context);
			case CoremodelPackage.ROLE_TO_MAP_MAP_ENTRY:
				return validateRoleToMapMapEntry((Map.Entry)value, diagnostics, context);
			case CoremodelPackage.STUB_NODE:
				return validateStubNode((StubNode)value, diagnostics, context);
			case CoremodelPackage.FORK_CONDITION:
				return validateForkCondition((ForkCondition)value, diagnostics, context);
			case CoremodelPackage.EXTENSIBLE_ELEMENT:
				return validateExtensibleElement((ExtensibleElement)value, diagnostics, context);
			case CoremodelPackage.ESTRING_TO_EOBJECT_MAP_ENTRY:
				return validateEStringToEObjectMapEntry((Map.Entry)value, diagnostics, context);
			case CoremodelPackage.CONDITION_EVENT:
				return validateConditionEvent((ConditionEvent)value, diagnostics, context);
			case CoremodelPackage.CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY:
				return validateConditionEventToConditionEventMapEntry((Map.Entry)value, diagnostics, context);
			case CoremodelPackage.TIMER_NODE:
				return validateTimerNode((TimerNode)value, diagnostics, context);
			case CoremodelPackage.DIRECTION_ARROW_NODE:
				return validateDirectionArrowNode((DirectionArrowNode)value, diagnostics, context);
			case CoremodelPackage.CONDITIONED_STUB:
				return validateConditionedStub((ConditionedStub)value, diagnostics, context);
			case CoremodelPackage.DYNAMIC_STUB_NODE:
				return validateDynamicStubNode((DynamicStubNode)value, diagnostics, context);
			case CoremodelPackage.RELATIONSHIP_DIRECTION:
				return validateRelationshipDirection((RelationshipDirection)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehavioralFeatureModel(BehavioralFeatureModel behavioralFeatureModel, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(behavioralFeatureModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentModel(ComponentModel componentModel, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(componentModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCoreModel(CoreModel coreModel, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(coreModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(coreModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(coreModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(coreModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(coreModel, diagnostics, context);
		if (result || diagnostics != null) result &= validateCoreModel_ResponsibilityGeneral(coreModel, diagnostics, context);
		if (result || diagnostics != null) result &= validateCoreModel_ConditionEventGeneral(coreModel, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ResponsibilityGeneral constraint of '<em>Core Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateCoreModel_ResponsibilityGeneral(CoreModel coreModel, DiagnosticChain diagnostics, Map context) {
		// Delegate this to the consistency manager
		return ConsistencyManager.INSTANCE.validate(
				ResponsibilityGeneralConstraint.CONSTRAINT_KEY,
				coreModel, diagnostics, context);
	}

	/**
	 * Validates the ConditionEventGeneral constraint of '<em>Core Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateCoreModel_ConditionEventGeneral(CoreModel coreModel, DiagnosticChain diagnostics, Map context) {
		// Delegate this to the consistency manager
		return ConsistencyManager.INSTANCE.validate(
				ConditionEventGeneralConstraint.CONSTRAINT_KEY,
				coreModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureModel(FeatureModel featureModel, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(featureModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInterfaceModel(InterfaceModel interfaceModel, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(interfaceModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElementModel(NamedElementModel namedElementModel, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(namedElementModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePortModel(PortModel portModel, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(portModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResponsibility(Responsibility responsibility, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(responsibility, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUseCaseMap(UseCaseMap useCaseMap, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(useCaseMap, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(useCaseMap, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(useCaseMap, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(useCaseMap, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(useCaseMap, diagnostics, context);
		if (result || diagnostics != null) result &= validateUseCaseMap_UseCaseMapGeneral(useCaseMap, diagnostics, context);
		return result;
	}

	/**
	 * Validates the UseCaseMapGeneral constraint of '<em>Use Case Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateUseCaseMap_UseCaseMapGeneral(UseCaseMap useCaseMap, DiagnosticChain diagnostics, Map context) {
		// Delegate this to the consistency manager
		return ConsistencyManager.INSTANCE.validate(
				UseCaseMapGeneralConstraint.CONSTRAINT_KEY,
				useCaseMap, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePath(Path path, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(path, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePathNode(PathNode pathNode, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(pathNode, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInterfaceLink(InterfaceLink interfaceLink, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(interfaceLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(interfaceLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(interfaceLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(interfaceLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(interfaceLink, diagnostics, context);
		if (result || diagnostics != null) result &= validateInterfaceLink_InterfacesMustHaveSameName(interfaceLink, diagnostics, context);
		return result;
	}

	/**
	 * Validates the InterfacesMustHaveSameName constraint of '<em>Interface Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateInterfaceLink_InterfacesMustHaveSameName(InterfaceLink interfaceLink, DiagnosticChain diagnostics, Map context) {
		// Delegate this to the consistency manager
		return ConsistencyManager.INSTANCE.validate(
				InterfacesMustHaveSameNameConstraint.CONSTRAINT_KEY,
				interfaceLink, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyElementModel(PropertyElementModel propertyElementModel, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(propertyElementModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty(Property property, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(property, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationship(Relationship relationship, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(relationship, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentRole(ComponentRole componentRole, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(componentRole, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateAdapter(Adapter adapter, DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForkNode(ForkNode forkNode, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(forkNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(forkNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(forkNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(forkNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(forkNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateResponsibilityNode_ResponsibilityNodeGeneral(forkNode, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSimplePathNode(SimplePathNode simplePathNode, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(simplePathNode, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStereotype(Stereotype stereotype, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(stereotype, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStereotypedElementModel(StereotypedElementModel stereotypedElementModel, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(stereotypedElementModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResponsibilityNode(ResponsibilityNode responsibilityNode, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(responsibilityNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(responsibilityNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(responsibilityNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(responsibilityNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(responsibilityNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateResponsibilityNode_ResponsibilityNodeGeneral(responsibilityNode, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ResponsibilityNodeGeneral constraint of '<em>Responsibility Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateResponsibilityNode_ResponsibilityNodeGeneral(ResponsibilityNode responsibilityNode, DiagnosticChain diagnostics, Map context) {
		// Delegate this to the consistency manager
		return ConsistencyManager.INSTANCE.validate(
				ResponsibilityNodeGeneralConstraint.CONSTRAINT_KEY,
				responsibilityNode, diagnostics, context);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCondition(Condition condition, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(condition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(condition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(condition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(condition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(condition, diagnostics, context);
		if (result || diagnostics != null) result &= validateCondition_ConditionMappingHasCorrectFamily(condition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ConditionMappingHasCorrectFamily constraint of '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateCondition_ConditionMappingHasCorrectFamily(Condition condition, DiagnosticChain diagnostics, Map context) {
		// Delegate this to the consistency manager
		return ConsistencyManager.INSTANCE.validate(
				ConditionMappingHasCorrectFamilyConstraint.CONSTRAINT_KEY,
				condition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNote(Note note, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(note, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNoteElementModel(NoteElementModel noteElementModel, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(noteElementModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFamily(Family family, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(family, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(family, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(family, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(family, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(family, diagnostics, context);
		if (result || diagnostics != null) result &= validateFamily_FamilyHasAllComponent(family, diagnostics, context);
		return result;
	}

	/**
	 * Validates the FamilyHasAllComponent constraint of '<em>Family</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateFamily_FamilyHasAllComponent(Family family, DiagnosticChain diagnostics, Map context) {
		//Delegate this to the consistency manager
		return ConsistencyManager.INSTANCE.validate(
				FamilyHasAllComponentConstraint.CONSTRAINT_KEY,
				family, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFamilyElement(FamilyElement familyElement, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(familyElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInterfacePrologCode(InterfacePrologCode interfacePrologCode, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint((EObject)interfacePrologCode, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateJoinNode(JoinNode joinNode, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(joinNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(joinNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(joinNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(joinNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(joinNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateResponsibilityNode_ResponsibilityNodeGeneral(joinNode, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRegistrable(Registrable registrable, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(registrable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResponsibilityRegistry(ResponsibilityRegistry responsibilityRegistry, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(responsibilityRegistry, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResponsibilityToRegistrableMapEntry(Map.Entry responsibilityToRegistrableMapEntry, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint((EObject)responsibilityToRegistrableMapEntry, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentToMapMapEntry(Map.Entry componentToMapMapEntry, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint((EObject)componentToMapMapEntry, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRoleToMapMapEntry(Map.Entry roleToMapMapEntry, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint((EObject)roleToMapMapEntry, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateStubNode(StubNode stubNode, DiagnosticChain diagnostics, Map context) {
		return ConsistencyManager.INSTANCE.validate(
				StubMustHaveFamilyConstraint.CONSTRAINT_KEY,
				stubNode, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForkCondition(ForkCondition forkCondition, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(forkCondition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtensibleElement(ExtensibleElement extensibleElement, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(extensibleElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEStringToEObjectMapEntry(Map.Entry eStringToEObjectMapEntry, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint((EObject)eStringToEObjectMapEntry, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionEvent(ConditionEvent conditionEvent, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(conditionEvent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionEventToConditionEventMapEntry(Map.Entry conditionEventToConditionEventMapEntry, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint((EObject)conditionEventToConditionEventMapEntry, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTimerNode(TimerNode timerNode, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(timerNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(timerNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(timerNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(timerNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(timerNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateResponsibilityNode_ResponsibilityNodeGeneral(timerNode, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDirectionArrowNode(DirectionArrowNode directionArrowNode, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(directionArrowNode, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionedStub(ConditionedStub conditionedStub, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(conditionedStub, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDynamicStubNode(DynamicStubNode dynamicStubNode, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(dynamicStubNode, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationshipDirection(RelationshipDirection relationshipDirection, DiagnosticChain diagnostics, Map context) {
		return true;
	}

} //CoremodelValidator
