/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Expression Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.BlockExpression#getExpressionList <em>Expression List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getBlockExpression()
 * @model abstract="true"
 * @generated
 */
public interface BlockExpression extends AbstractExpression {
	/**
	 * Returns the value of the '<em><b>Expression List</b></em>' containment reference list.
	 * The list contents are of type {@link org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression List</em>' containment reference list.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getBlockExpression_ExpressionList()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractExpression> getExpressionList();

} // BlockExpressionEvent
