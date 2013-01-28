/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic;




/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visitor Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getVisitorExpression()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface VisitorExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void visit(AndExpression expression);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void visit(OrExpression expression);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void visit(SingleExpression expression);

} // VisitorExpression
