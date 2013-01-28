/** * $Id: ExecutionStep.java,v 1.8 2006/03/16 23:56:57 apersson Exp $ * $Author: apersson $ */package org.isistan.flabot.executionmodel;

import org.eclipse.emf.ecore.EObject;import org.isistan.flabot.coremodel.ComponentRole;import org.isistan.flabot.coremodel.SimplePathNode;import org.isistan.flabot.engine.executionstate.Diagnostic;import org.isistan.flabot.engine.executionstate.ExecutionState;/**
 * @model
 */

public interface ExecutionStep extends EObject{
	
	/**
	 * 
	 * @model containment="true"
	 */
	
	ExecutionContext getExecutionContext();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionStep#getExecutionContext <em>Execution Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution Context</em>' containment reference.
	 * @see #getExecutionContext()
	 * @generated
	 */
	void setExecutionContext(ExecutionContext value);

	/**
	 * 
	 * @model containment="true"
	 */
	Dependency getDependency();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionStep#getDependency <em>Dependency</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependency</em>' containment reference.
	 * @see #getDependency()
	 * @generated
	 */
	void setDependency(Dependency value);

	/**
	 * 
	 * @model
	 */
	SimplePathNode getSource();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionStep#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(SimplePathNode value);

	/**
	 * 
	 * @model
	 */
	SimplePathNode getTarget();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionStep#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(SimplePathNode value);

	/**	 * 	 * @model	 */		ComponentRole getInstanceComponentToSource();
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionStep#getInstanceComponentToSource <em>Instance Component To Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Component To Source</em>' reference.
	 * @see #getInstanceComponentToSource()
	 * @generated
	 */
	void setInstanceComponentToSource(ComponentRole value);

	/**	 * 	 * @model	 */		ComponentRole getInstanceComponentToTarget();
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionStep#getInstanceComponentToTarget <em>Instance Component To Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Component To Target</em>' reference.
	 * @see #getInstanceComponentToTarget()
	 * @generated
	 */
	void setInstanceComponentToTarget(ComponentRole value);

	/**	 * 	 * @model	 */	Diagnostic getDiagnosticToSource();		/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionStep#getDiagnosticToSource <em>Diagnostic To Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagnostic To Source</em>' reference.
	 * @see #getDiagnosticToSource()
	 * @generated
	 */
	void setDiagnosticToSource(Diagnostic value);

	/**	 * 	 * @model	 */	Diagnostic getDiagnosticToTarget();		/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionStep#getDiagnosticToTarget <em>Diagnostic To Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagnostic To Target</em>' reference.
	 * @see #getDiagnosticToTarget()
	 * @generated
	 */
	void setDiagnosticToTarget(Diagnostic value);

	/**	 * 	 * @model	 */	ExecutionState getFinalState();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionStep#getFinalState <em>Final State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final State</em>' attribute.
	 * @see org.isistan.flabot.engine.executionstate.ExecutionState
	 * @see #getFinalState()
	 * @generated
	 */
	void setFinalState(ExecutionState value);

	/**	 * 	 * @model	 */
	int getEnabled ();
	

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.ExecutionStep#getEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #getEnabled()
	 * @generated
	 */
	void setEnabled(int value);

}
