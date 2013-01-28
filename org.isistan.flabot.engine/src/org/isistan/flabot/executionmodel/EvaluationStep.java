/**
 * $Id: EvaluationStep.java,v 1.1 2006/03/17 00:28:33 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.executionmodel;

import org.eclipse.emf.ecore.EObject;
import org.isistan.flabot.coremodel.SimplePathNode;

/**
 * @model
 */
public interface EvaluationStep extends EObject{

	/**
	 * 
	 * @model
	 */
	SimplePathNode getSource();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.EvaluationStep#getSource <em>Source</em>}' reference.
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
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.EvaluationStep#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(SimplePathNode value);

	/**
	 * 
	 * @model
	 */
	String getCurrentFamily();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.EvaluationStep#getCurrentFamily <em>Current Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Family</em>' attribute.
	 * @see #getCurrentFamily()
	 * @generated
	 */
	void setCurrentFamily(String value);

	/**
	 * 
	 * @model
	 */
	String getCondition();
	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionmodel.EvaluationStep#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(String value);

}