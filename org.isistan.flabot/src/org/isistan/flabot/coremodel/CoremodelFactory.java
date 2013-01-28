/**
 * <copyright>
 * </copyright>
 *
 * $Id: CoremodelFactory.java,v 1.29 2006/04/12 02:24:57 apersson Exp $
 */
package org.isistan.flabot.coremodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.coremodel.CoremodelPackage
 * @generated
 */
public interface CoremodelFactory extends EFactory{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CoremodelFactory eINSTANCE = org.isistan.flabot.coremodel.impl.CoremodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Behavioral Feature Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavioral Feature Model</em>'.
	 * @generated
	 */
	BehavioralFeatureModel createBehavioralFeatureModel();

	/**
	 * Returns a new object of class '<em>Component Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Model</em>'.
	 * @generated
	 */
	ComponentModel createComponentModel();

	/**
	 * Returns a new object of class '<em>Component Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Model</em>'.
	 * @generated NOT
	 */
	ComponentModel createComponentModel(ComponentModel componentModel);

	/**
	 * Returns a new object of class '<em>Core Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Core Model</em>'.
	 * @generated
	 */
	CoreModel createCoreModel();

	/**
	 * Returns a new object of class '<em>Feature Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Model</em>'.
	 * @generated
	 */
	FeatureModel createFeatureModel();

	/**
	 * Returns a new object of class '<em>Interface Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Model</em>'.
	 * @generated
	 */
	InterfaceModel createInterfaceModel();

	/**
	 * Returns a new object of class '<em>Interface Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Model</em>'.
	 * @generated NOT
	 */
	InterfaceModel createInterfaceModel(InterfaceModel copyInterfaceModel);

	/**
	 * Returns a new object of class '<em>Named Element Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Element Model</em>'.
	 * @generated
	 */
	NamedElementModel createNamedElementModel();

	/**
	 * Returns a new object of class '<em>Port Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Model</em>'.
	 * @generated
	 */
	PortModel createPortModel();

	/**
	 * Returns a new object of class '<em>Port Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Model</em>'.
	 * @generated NOT
	 */
	PortModel createPortModel(PortModel copyPortModel);

	/**
	 * Returns a new object of class '<em>Responsibility</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Responsibility</em>'.
	 * @generated
	 */
	Responsibility createResponsibility();

	/**
	 * Returns a new object of class '<em>Use Case Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Use Case Map</em>'.
	 * @generated
	 */
	UseCaseMap createUseCaseMap();

	/**
	 * Returns a new object of class '<em>Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Path</em>'.
	 * @generated
	 */
	Path createPath();

	/**
	 * Returns a new object of class '<em>Interface Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Link</em>'.
	 * @generated
	 */
	InterfaceLink createInterfaceLink();

	/**
	 * Returns a new object of class '<em>Property Element Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Element Model</em>'.
	 * @generated
	 */
	PropertyElementModel createPropertyElementModel();

	/**
	 * Returns a new object of class '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property</em>'.
	 * @generated
	 */
	Property createProperty();

	/**
	 * Returns a new object of class '<em>Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relationship</em>'.
	 * @generated
	 */
	Relationship createRelationship();

	/**
	 * Returns a new object of class '<em>Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relationship</em>'.
	 * @generated NOT
	 */
	Relationship createRelationship(Relationship copyRelationship);

	/**
	 * Returns a new object of class '<em>Component Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Role</em>'.
	 * @generated
	 */
	ComponentRole createComponentRole();

	/**
	 * Returns a new object of class '<em>Fork Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fork Node</em>'.
	 * @generated
	 */
	ForkNode createForkNode();

	/**
	 * Returns a new object of class '<em>Component Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Role</em>'.
	 * @generated NOT
	 */
	ComponentRole createComponentRole(ComponentRole copy);

	/**
	 * Returns a new object of class '<em>Fork Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fork Node</em>'.
	 * @generated NOT
	 */
	ForkNode createForkNode(Responsibility r, int type, int outputsCount);

	/**
	 * Returns a new object of class '<em>Simple Path Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Path Node</em>'.
	 * @generated
	 */
	SimplePathNode createSimplePathNode();

	/**
	 * Returns a new object of class '<em>Stereotype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stereotype</em>'.
	 * @generated
	 */
	Stereotype createStereotype();

	/**
	 * Returns a new object of class '<em>Stereotyped Element Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stereotyped Element Model</em>'.
	 * @generated
	 */
	StereotypedElementModel createStereotypedElementModel();

	/**
	 * Returns a new object of class '<em>Responsibility Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Responsibility Node</em>'.
	 * @generated
	 */
	ResponsibilityNode createResponsibilityNode();

	/**
	 * Returns a new object of class '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition</em>'.
	 * @generated
	 */
	Condition createCondition();

	/**
	 * Returns a new object of class '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition</em>'.
	 * @generated NOT
	 */
	Condition createCondition(Condition copyConditon);

	/**
	 * Returns a new object of class '<em>Note</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Note</em>'.
	 * @generated
	 */
	Note createNote();

	/**
	 * Returns a new object of class '<em>Note</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Note</em>'.
	 * @generated NOT
	 */
	Note createNote(Note copyNote);

	/**
	 * Returns a new object of class '<em>Note Element Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Note Element Model</em>'.
	 * @generated
	 */
	NoteElementModel createNoteElementModel();

	/**
	 * Returns a new object of class '<em>Family</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Family</em>'.
	 * @generated
	 */
	Family createFamily();

	/**
	 * Returns a new object of class '<em>Family</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Family</em>'.
	 * @generated NOT
	 */
	Family createFamily(Family copyFamily);

	/**
	 * Returns a new object of class '<em>Family Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Family Element</em>'.
	 * @generated
	 */
	FamilyElement createFamilyElement();

	/**
	 * Returns a new object of class '<em>Join Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Join Node</em>'.
	 * @generated
	 */
	JoinNode createJoinNode();
	
	/**
	 * Returns a new object of class '<em>Timer Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timer Node</em>'.
	 * @generated
	 */
	TimerNode createTimerNode();
	
	/**
	 * Returns a new object of class '<em>Direction Arrow Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Direction Arrow Node</em>'.
	 * @generated
	 */
	DirectionArrowNode createDirectionArrowNode();

	/**
	 * Returns a new object of class '<em>Conditioned Stub</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conditioned Stub</em>'.
	 * @generated
	 */
	ConditionedStub createConditionedStub();
	
	/**
	 * Returns a new object of class '<em>Dynamic Stub Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic Stub Node</em>'.
	 * @generated
	 */
	DynamicStubNode createDynamicStubNode();
	
	/**
	 * Returns a new object of class '<em>Dynamic Stub Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic Stub Node</em>'.
	 * @generated NOT
	 */
	DynamicStubNode createDynamicStubNode(DynamicStubNode dynamicStubNode);
	
	/**
	 * Returns a new object of class '<em>Join Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Join Node</em>'.
	 * @generated NOT
	 */
	JoinNode createJoinNode(Responsibility resp, int type);

	/**
	 * Returns a new object of class '<em>Timer Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timer Node</em>'.
	 * @generated NOT
	 */
	TimerNode createTimerNode(Responsibility resp, int type);
	
	/**
	 * Returns a new object of class '<em>Timer Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timer Node</em>'.
	 * @generated NOT
	 */
	TimerNode createTimerNode(TimerNode timer);
	
	/**
	 * Returns a new object of class '<em>Timer Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timer Node</em>'.
	 * @generated NOT
	 */
	TimerNode createTimerNode(int timerType);
	
	/**
	 * Returns a new object of class '<em>Responsibility Registry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Responsibility Registry</em>'.
	 * @generated
	 */
	ResponsibilityRegistry createResponsibilityRegistry();

	/**
	 * Returns a new object of class '<em>Stub Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stub Node</em>'.
	 * @generated
	 */
	StubNode createStubNode();

	/**
	 * Returns a new object of class '<em>Fork Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fork Condition</em>'.
	 * @generated
	 */
	ForkCondition createForkCondition();

	/**
	 * Returns a new object of class '<em>Extensible Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extensible Element</em>'.
	 * @generated
	 */
	ExtensibleElement createExtensibleElement();

	/**
	 * Returns a new object of class '<em>Condition Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition Event</em>'.
	 * @generated
	 */
	ConditionEvent createConditionEvent();

	/**
	 * Returns a new object of class '<em>Condition Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition Event</em>'.
	 * @generated NOT
	 */
	ConditionEvent createConditionEvent(ConditionEvent conditionEvent);

	/**
	 * Returns a new object of class '<em>Stub Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stub Node</em>'.
	 * @generated NOT
	 */
	StubNode createStubNode(StubNode stubNode);

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CoremodelPackage getCoremodelPackage();

} //CoremodelFactory
