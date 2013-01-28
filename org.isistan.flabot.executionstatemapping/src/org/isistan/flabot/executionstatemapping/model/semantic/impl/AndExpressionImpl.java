/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic.impl;

import org.eclipse.emf.ecore.EClass;
import org.isistan.flabot.executionstatemapping.model.prolog.VisitorExpressionProlog;
import org.isistan.flabot.executionstatemapping.model.semantic.AndExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;
import org.isistan.flabot.executionstatemapping.model.semantic.VisitorExpression;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>And Expression Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AndExpressionImpl extends BlockExpressionImpl implements AndExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AndExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticPackage.Literals.AND_EXPRESSION;
	}
	
	@Override
	public void accept(VisitorExpression v)
	{
		v.visit(this);
	}
	
	@Override
	public String accept(VisitorExpressionProlog v)
	{
		return v.visit(this);
	}

} //AndExpressionEventImpl
