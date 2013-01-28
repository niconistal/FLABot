/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scope Evaluation Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getScopeEvaluationCondition()
 * @model
 * @generated
 */
public interface ScopeEvaluationCondition extends EvaluationCondition {
		
	void addScopeFilter(ScopeFilterType scopeFilter);
	
	boolean hasScopeFilter(ScopeFilterType scopeFilter);
	
} // ScopeEvaluationCondition
