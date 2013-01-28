/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic;

import org.isistan.flabot.executionstatemapping.model.prolog.PrologElement;
import org.isistan.flabot.executionstatemapping.model.prolog.VisitedExpressionProlog;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Expression Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression#getEventType <em>Event Type</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression#getParentExpression <em>Parent Expression</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression#isIsNot <em>Is Not</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getAbstractExpression()
 * @model abstract="true"
 * @generated
 */
public interface AbstractExpression extends PrologElement, VisitedExpression, VisitedExpressionProlog {
	/**
	 * Returns the value of the '<em><b>Event Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.isistan.flabot.executionstatemapping.model.semantic.EventType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Type</em>' attribute.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.EventType
	 * @see #setEventType(EventType)
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getAbstractExpression_EventType()
	 * @model
	 * @generated
	 */
	EventType getEventType();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression#getEventType <em>Event Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Type</em>' attribute.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.EventType
	 * @see #getEventType()
	 * @generated
	 */
	void setEventType(EventType value);

	/**
	 * Returns the value of the '<em><b>Parent Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Expression</em>' reference.
	 * @see #setParentExpression(AbstractExpression)
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getAbstractExpression_ParentExpression()
	 * @model
	 * @generated
	 */
	AbstractExpression getParentExpression();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression#getParentExpression <em>Parent Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Expression</em>' reference.
	 * @see #getParentExpression()
	 * @generated
	 */
	void setParentExpression(AbstractExpression value);

	/**
	 * Returns the value of the '<em><b>Is Not</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Not</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Not</em>' attribute.
	 * @see #setIsNot(boolean)
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getAbstractExpression_IsNot()
	 * @model
	 * @generated
	 */
	boolean isIsNot();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression#isIsNot <em>Is Not</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Not</em>' attribute.
	 * @see #isIsNot()
	 * @generated
	 */
	void setIsNot(boolean value);

} // AbstractExpressionEvent
