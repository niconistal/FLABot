/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visited Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getVisitedExpression()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface VisitedExpression extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void accept(VisitorExpression visitor);

} // VisitedExpression
