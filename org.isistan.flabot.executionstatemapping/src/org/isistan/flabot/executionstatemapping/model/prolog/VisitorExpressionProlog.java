/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.prolog;

import org.eclipse.emf.ecore.EObject;

import org.isistan.flabot.executionstatemapping.model.semantic.AndExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.OrExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.SingleExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visitor Expression Prolog</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.isistan.flabot.executionstatemapping.model.prolog.PrologPackage#getVisitorExpressionProlog()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface VisitorExpressionProlog extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String visit(AndExpression expression);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String visit(OrExpression expression);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String visit(SingleExpression expression);

} // VisitorExpressionProlog
