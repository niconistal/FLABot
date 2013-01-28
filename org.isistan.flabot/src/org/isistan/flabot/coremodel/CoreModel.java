/** * $Id: CoreModel.java,v 1.20 2006/04/11 23:31:51 franco Exp $ * $Author: franco $ */package org.isistan.flabot.coremodel;

import org.eclipse.emf.common.util.EList;import org.eclipse.emf.ecore.EObject;import org.isistan.flabot.edit.editormodel.FlabotFileModel;/**
 * CoreModel
 * -	Is a container for all semantic elements: Components, UseCaseMaps, Relationships, Responsibilities, etc.
 * 
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ResponsibilityGeneral ConditionEventGeneral'"
 */
public interface CoreModel extends EObject{
	/**
	 * @model opposite="coreModel"
	 */
	FlabotFileModel getFile();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.coremodel.CoreModel#getFile <em>File</em>}' container reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>File</em>' container reference.	 * @see #getFile()	 * @generated	 */
	void setFile(FlabotFileModel value);

	/**
	 * 
	 * @model type="ComponentModel" containment="true" opposite="coreModel"
	 */
	EList getComponents();
	
	/**
	 * @model type="Responsibility" containment="true" opposite="coreModel"
	 */
	EList getResponsibilities();
	
	/**
	 * @model type="UseCaseMap" containment="true" opposite="coreModel"
	 */
	EList getUseCaseMaps();
	
	/**
	 * @model type="InterfaceLink" containment="true"
	 */
	EList getInterfaceLinks();
	
	/**
	 * @model type="Relationship" containment="true"
	 */
	EList getRelationships();
	
	/**
	 * @model type="Stereotype" containment="true"
	 */
	EList getStereotypes();
	
	/**
	 * @model type="Family" containment="true"
	 */
	EList getFamilies();			/**	 * @model type="UseCaseMap"	 */	EList getArchitecturalUseCaseMaps();		/**	 * @model type="UseCaseMap"	 */	EList getFunctionalUseCaseMaps();		/**	 * @model type="ConditionEvent" containment="true"	 */	EList getEvents();		/**	 * @model type="StubNode"	 */	EList getStubs();		/**	 * Returns the value of the '<em><b>Dynamic Stubs</b></em>' containment reference list.	 * The list contents are of type {@link org.isistan.flabot.coremodel.DynamicStubNode}.	 * @return the value of the '<em>Dynamic Stubs</em>' containment reference list.	 * @see org.isistan.flabot.coremodel.CoremodelPackage#getCoreModel_DynamicStubs()	 * @model type="org.isistan.flabot.coremodel.DynamicStubNode" containment="true"	 * @generated	 */	EList getDynamicStubs();	/**	 * Returns the value of the '<em><b>Conditioned Stubs</b></em>' containment reference list.	 * The list contents are of type {@link org.isistan.flabot.coremodel.ConditionedStub}.	 * <!-- begin-user-doc -->	 * <p>	 * If the meaning of the '<em>Conditioned Stubs</em>' containment reference list isn't clear,	 * there really should be more of a description here...	 * </p>	 * <!-- end-user-doc -->	 * @return the value of the '<em>Conditioned Stubs</em>' containment reference list.	 * @see org.isistan.flabot.coremodel.CoremodelPackage#getCoreModel_ConditionedStubs()	 * @model type="org.isistan.flabot.coremodel.ConditionedStub" containment="true"	 * @generated	 */	EList getConditionedStubs();	/**	 * @model type="TimerNode"	 */	EList getTimers();		public EList getConditionEvents();		
}