/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic.impl;

import org.eclipse.emf.ecore.EClass;
import org.isistan.flabot.executionstatemapping.model.semantic.ScopeEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ScopeFilterType;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scope Evaluation Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ScopeEvaluationConditionImpl extends EvaluationConditionImpl implements ScopeEvaluationCondition {
	
	private static String SCOPE_SEPARATOR = "|";	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScopeEvaluationConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticPackage.Literals.SCOPE_EVALUATION_CONDITION;
	}

	public void addScopeFilter(ScopeFilterType scopeFilter)
	{
		if (getValue() != null && getValue().indexOf(scopeFilter.getLiteral()) >= 0)
			return;
		
		if (getValue() == null)
		{
			setValue("");
		}
		if (getValue().length() > 0)
		{
			setValue(getValue() + SCOPE_SEPARATOR); 
		}
		setValue(getValue() + scopeFilter.getLiteral());
	}
	
	public boolean hasScopeFilter(ScopeFilterType scopeFilter)
	{
		if (getValue() != null)
		{
			return (getValue().indexOf(scopeFilter.getLiteral()) >= 0);
		}
		return false;
	}
	
} //ScopeEvaluationConditionImpl
