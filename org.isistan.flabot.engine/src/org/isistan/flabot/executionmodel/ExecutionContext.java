/** * $Id: ExecutionContext.java,v 1.12 2006/04/11 04:21:27 apersson Exp $ * $Author: apersson $ */package org.isistan.flabot.executionmodel;

import org.eclipse.emf.common.util.EMap;import org.eclipse.emf.ecore.EObject;import org.isistan.flabot.coremodel.ComponentRole;import org.isistan.flabot.coremodel.SimplePathNode;/**
 * @model
 */
public interface ExecutionContext extends EObject{
		public static final int enabled_Step = 1; 	public static final int not_enabled_Step = 0;  	
	/**
	 * 
	 * @model default="0" 
	 */
	String getCurrentStep();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getCurrentStep <em>Current Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Step</em>' attribute.
	 * @see #getCurrentStep()
	 * @generated
	 */
	void setCurrentStep(String value);

	/**
	 * 
	 * @model 
	 */
	String getCurrentScenario();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getCurrentScenario <em>Current Scenario</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Scenario</em>' attribute.
	 * @see #getCurrentScenario()
	 * @generated
	 */
	void setCurrentScenario(String value);

	/**
	 * 
	 * @model 
	 */
	String getCurrentState();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getCurrentState <em>Current State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current State</em>' attribute.
	 * @see #getCurrentState()
	 * @generated
	 */
	void setCurrentState(String value);

	/**
	 * 
	 * @model 
	 */
	String getDependencies();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getDependencies <em>Dependencies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependencies</em>' attribute.
	 * @see #getDependencies()
	 * @generated
	 */
	void setDependencies(String value);

	/**
	 * 
	 * @model default="'Family'"
	 */
	String getCurrentFamily();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getCurrentFamily <em>Current Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Family</em>' attribute.
	 * @see #getCurrentFamily()
	 * @generated
	 */
	void setCurrentFamily(String value);

	/**
	 * 
	 * @model default="Family"
	 */
	String getFamily();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getFamily <em>Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Family</em>' attribute.
	 * @see #getFamily()
	 * @generated
	 */
	void setFamily(String value);

	/**
	 * 
	 * @model default="[]"
	 */
	String getCurrentTypeDependency();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getCurrentTypeDependency <em>Current Type Dependency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Type Dependency</em>' attribute.
	 * @see #getCurrentTypeDependency()
	 * @generated
	 */
	void setCurrentTypeDependency(String value);

	/**
	 * 
	 * @model 
	 */
	SimplePathNode getCurrentResponsibility();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getCurrentResponsibility <em>Current Responsibility</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Responsibility</em>' reference.
	 * @see #getCurrentResponsibility()
	 * @generated
	 */
	void setCurrentResponsibility(SimplePathNode value);

	/**
	 * 
	 * @model 
	 */
	SimplePathNode getPreResponsibility();
		
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getPreResponsibility <em>Pre Responsibility</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pre Responsibility</em>' reference.
	 * @see #getPreResponsibility()
	 * @generated
	 */
	void setPreResponsibility(SimplePathNode value);

	/**
	 * 
	 * @model default="[]"
	 */
	String	getCurrentDependency();


	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getCurrentDependency <em>Current Dependency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Dependency</em>' attribute.
	 * @see #getCurrentDependency()
	 * @generated
	 */
	void setCurrentDependency(String value);

	/**
	 * 
	 * @model default="DEFAULT_DEPENDENCY"
	 */
	String	getCurrentAnalizeDependency();


	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getCurrentAnalizeDependency <em>Current Analize Dependency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Analize Dependency</em>' attribute.
	 * @see #getCurrentAnalizeDependency()
	 * @generated
	 */
	void setCurrentAnalizeDependency(String value);

	/**
	 * 
	 * @model default="Event"
	 */
	String getEvent();
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getEvent <em>Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' attribute.
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(String value);

	void cloneExecutionContext(ExecutionContext context);
	
	/**
	 * 
	 * @model default=""
	 */
	String getPrologKnowledge();


	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getPrologKnowledge <em>Prolog Knowledge</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prolog Knowledge</em>' attribute.
	 * @see #getPrologKnowledge()
	 * @generated
	 */
	void setPrologKnowledge(String value);

	/**	 * 	 * @model	 */		String getCurrentLogicModule();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getCurrentLogicModule <em>Current Logic Module</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Logic Module</em>' attribute.
	 * @see #getCurrentLogicModule()
	 * @generated
	 */
	void setCurrentLogicModule(String value);

	/**	 * 	 * @model	 */		SimplePathNode getResponsibilityToExecute();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getResponsibilityToExecute <em>Responsibility To Execute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Responsibility To Execute</em>' reference.
	 * @see #getResponsibilityToExecute()
	 * @generated
	 */
	void setResponsibilityToExecute(SimplePathNode value);

	/**	 * 	 * @model	 */		String getMappingFamily();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getMappingFamily <em>Mapping Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Family</em>' attribute.
	 * @see #getMappingFamily()
	 * @generated
	 */
	void setMappingFamily(String value);

	/**	 * 	 * @model	 */		String getLastMappingFamily();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getLastMappingFamily <em>Last Mapping Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Mapping Family</em>' attribute.
	 * @see #getLastMappingFamily()
	 * @generated
	 */
	void setLastMappingFamily(String value);

	/**	 * 	 * @model	 */		SimplePathNode getStubNode();	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getStubNode <em>Stub Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stub Node</em>' reference.
	 * @see #getStubNode()
	 * @generated
	 */
	void setStubNode(SimplePathNode value);

	/**	 * 	 * @model	 */		SimplePathNode getStartNodeToStub();	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getStartNodeToStub <em>Start Node To Stub</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Node To Stub</em>' reference.
	 * @see #getStartNodeToStub()
	 * @generated
	 */
	void setStartNodeToStub(SimplePathNode value);

	/**	 * 	 * @model	 */		SimplePathNode getEndNodeToStub();	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getEndNodeToStub <em>End Node To Stub</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Node To Stub</em>' reference.
	 * @see #getEndNodeToStub()
	 * @generated
	 */
	void setEndNodeToStub(SimplePathNode value);

	/**	 * 	 * @model	 */		SimplePathNode getResponsibilityToStub();	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getResponsibilityToStub <em>Responsibility To Stub</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Responsibility To Stub</em>' reference.
	 * @see #getResponsibilityToStub()
	 * @generated
	 */
	void setResponsibilityToStub(SimplePathNode value);

	/**	 * 	 * @model	 */		SimplePathNode getPreResponsibilityToStub();
		/**	 * 	 * @model	 */		SimplePathNode getResponsibilityToJoin();	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getResponsibilityToJoin <em>Responsibility To Join</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Responsibility To Join</em>' reference.
	 * @see #getResponsibilityToJoin()
	 * @generated
	 */
	void setResponsibilityToJoin(SimplePathNode value);

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getPreResponsibilityToStub <em>Pre Responsibility To Stub</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pre Responsibility To Stub</em>' reference.
	 * @see #getPreResponsibilityToStub()
	 * @generated
	 */
	void setPreResponsibilityToStub(SimplePathNode value);

	/**	 * 	 * @model	 */		SimplePathNode getPreResponsibilityToJoin();	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getPreResponsibilityToJoin <em>Pre Responsibility To Join</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pre Responsibility To Join</em>' reference.
	 * @see #getPreResponsibilityToJoin()
	 * @generated
	 */
	void setPreResponsibilityToJoin(SimplePathNode value);

	/**	 * 	 * @model	 */		String getStopStep();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getStopStep <em>Stop Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop Step</em>' attribute.
	 * @see #getStopStep()
	 * @generated
	 */
	void setStopStep(String value);

	/**	 * 	 * @model	 */		ComponentRole getInstanceComponentToSource();	

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getInstanceComponentToSource <em>Instance Component To Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Component To Source</em>' reference.
	 * @see #getInstanceComponentToSource()
	 * @generated
	 */
	void setInstanceComponentToSource(ComponentRole value);

	/**	 * 	 * @model	 */		ComponentRole getInstanceComponentToTarget();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getInstanceComponentToTarget <em>Instance Component To Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Component To Target</em>' reference.
	 * @see #getInstanceComponentToTarget()
	 * @generated
	 */
	void setInstanceComponentToTarget(ComponentRole value);

	/**	 * @model keyType="String" valueType="String"	 * 	 */		EMap getBranchJoin();		/**	 * 	 * @model default=1	 */	int getEnabled ();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionContext#getEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #getEnabled()
	 * @generated
	 */
	void setEnabled(int value);

}
