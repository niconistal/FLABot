/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.isistan.flabot.executionstatemapping.model.prolog.VisitorExpressionProlog;
import org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.EventType;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;
import org.isistan.flabot.executionstatemapping.model.semantic.VisitorExpression;



/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Expression Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.AbstractExpressionImpl#getPredicateName <em>Predicate Name</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.AbstractExpressionImpl#getEventType <em>Event Type</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.AbstractExpressionImpl#getParentExpression <em>Parent Expression</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.AbstractExpressionImpl#isIsNot <em>Is Not</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractExpressionImpl extends EObjectImpl implements AbstractExpression {
	
	public static int predicateExpressionNumber = 0;
	
	/**
	 * The default value of the '{@link #getPredicateName() <em>Predicate Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredicateName()
	 * @generated
	 * @ordered
	 */
	protected static final String PREDICATE_NAME_EDEFAULT = null;

	protected  String predicateName = null;

	/**
	 * The default value of the '{@link #getEventType() <em>Event Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventType()
	 * @generated
	 * @ordered
	 */
	protected static final EventType EVENT_TYPE_EDEFAULT = EventType.AND_EVENT;
	/**
	 * The cached value of the '{@link #getEventType() <em>Event Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventType()
	 * @generated
	 * @ordered
	 */
	protected EventType eventType = EVENT_TYPE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getParentExpression() <em>Parent Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentExpression()
	 * @generated
	 * @ordered
	 */
	protected AbstractExpression parentExpression;

	/**
	 * The default value of the '{@link #isIsNot() <em>Is Not</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsNot()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_NOT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsNot() <em>Is Not</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsNot()
	 * @generated
	 * @ordered
	 */
	protected boolean isNot = IS_NOT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticPackage.Literals.ABSTRACT_EXPRESSION;
	}

	public String getPredicateName() {
		return predicateName;
	}

	public void setPredicateName(String newPredicateName) {
		predicateName=newPredicateName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventType getEventType() {
		return eventType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventType(EventType newEventType) {
		EventType oldEventType = eventType;
		eventType = newEventType == null ? EVENT_TYPE_EDEFAULT : newEventType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.ABSTRACT_EXPRESSION__EVENT_TYPE, oldEventType, eventType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractExpression getParentExpression() {
		if (parentExpression != null && parentExpression.eIsProxy()) {
			InternalEObject oldParentExpression = (InternalEObject)parentExpression;
			parentExpression = (AbstractExpression)eResolveProxy(oldParentExpression);
			if (parentExpression != oldParentExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SemanticPackage.ABSTRACT_EXPRESSION__PARENT_EXPRESSION, oldParentExpression, parentExpression));
			}
		}
		return parentExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractExpression basicGetParentExpression() {
		return parentExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentExpression(AbstractExpression newParentExpression) {
		AbstractExpression oldParentExpression = parentExpression;
		parentExpression = newParentExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.ABSTRACT_EXPRESSION__PARENT_EXPRESSION, oldParentExpression, parentExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsNot() {
		return isNot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsNot(boolean newIsNot) {
		boolean oldIsNot = isNot;
		isNot = newIsNot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.ABSTRACT_EXPRESSION__IS_NOT, oldIsNot, isNot));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public abstract String accept(VisitorExpressionProlog visitor);
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public abstract void accept(VisitorExpression visitor);
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setPredicateFunctor(String functor, String parameters) {
		predicateName=functor+(predicateExpressionNumber++)+parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public abstract void resetPredicateName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SemanticPackage.ABSTRACT_EXPRESSION__PREDICATE_NAME:
				return getPredicateName();
			case SemanticPackage.ABSTRACT_EXPRESSION__EVENT_TYPE:
				return getEventType();
			case SemanticPackage.ABSTRACT_EXPRESSION__PARENT_EXPRESSION:
				if (resolve) return getParentExpression();
				return basicGetParentExpression();
			case SemanticPackage.ABSTRACT_EXPRESSION__IS_NOT:
				return isIsNot() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SemanticPackage.ABSTRACT_EXPRESSION__EVENT_TYPE:
				setEventType((EventType)newValue);
				return;
			case SemanticPackage.ABSTRACT_EXPRESSION__PARENT_EXPRESSION:
				setParentExpression((AbstractExpression)newValue);
				return;
			case SemanticPackage.ABSTRACT_EXPRESSION__IS_NOT:
				setIsNot(((Boolean)newValue).booleanValue());
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SemanticPackage.ABSTRACT_EXPRESSION__EVENT_TYPE:
				setEventType(EVENT_TYPE_EDEFAULT);
				return;
			case SemanticPackage.ABSTRACT_EXPRESSION__PARENT_EXPRESSION:
				setParentExpression((AbstractExpression)null);
				return;
			case SemanticPackage.ABSTRACT_EXPRESSION__IS_NOT:
				setIsNot(IS_NOT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SemanticPackage.ABSTRACT_EXPRESSION__PREDICATE_NAME:
				return PREDICATE_NAME_EDEFAULT == null ? predicateName != null : !PREDICATE_NAME_EDEFAULT.equals(predicateName);
			case SemanticPackage.ABSTRACT_EXPRESSION__EVENT_TYPE:
				return eventType != EVENT_TYPE_EDEFAULT;
			case SemanticPackage.ABSTRACT_EXPRESSION__PARENT_EXPRESSION:
				return parentExpression != null;
			case SemanticPackage.ABSTRACT_EXPRESSION__IS_NOT:
				return isNot != IS_NOT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (predicateName: ");
		result.append(predicateName);
		result.append(", eventType: ");
		result.append(eventType);
		result.append(", isNot: ");
		result.append(isNot);
		result.append(')');
		return result.toString();
	}

} //AbstractExpressionEventImpl
