/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Execution Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.SimpleExpressionExecutionConditionImpl#getExecutionState <em>Execution State</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.SimpleExpressionExecutionConditionImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleExpressionExecutionConditionImpl extends NamedElementImpl implements SimpleExpressionExecutionCondition {
	/**
	 * The default value of the '{@link #getExecutionState() <em>Execution State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionState()
	 * @generated
	 * @ordered
	 */
	protected static final ExecutionStateValue EXECUTION_STATE_EDEFAULT = ExecutionStateValue.FAULTY;

	/**
	 * The cached value of the '{@link #getExecutionState() <em>Execution State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionState()
	 * @generated
	 * @ordered
	 */
	protected ExecutionStateValue executionState = EXECUTION_STATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected AbstractExpression expression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleExpressionExecutionConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticPackage.Literals.SIMPLE_EXPRESSION_EXECUTION_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionStateValue getExecutionState() {
		return executionState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutionState(ExecutionStateValue newExecutionState) {
		ExecutionStateValue oldExecutionState = executionState;
		executionState = newExecutionState == null ? EXECUTION_STATE_EDEFAULT : newExecutionState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.SIMPLE_EXPRESSION_EXECUTION_CONDITION__EXECUTION_STATE, oldExecutionState, executionState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractExpression getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpression(AbstractExpression newExpression, NotificationChain msgs) {
		AbstractExpression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SemanticPackage.SIMPLE_EXPRESSION_EXECUTION_CONDITION__EXPRESSION, oldExpression, newExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(AbstractExpression newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SemanticPackage.SIMPLE_EXPRESSION_EXECUTION_CONDITION__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SemanticPackage.SIMPLE_EXPRESSION_EXECUTION_CONDITION__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.SIMPLE_EXPRESSION_EXECUTION_CONDITION__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SemanticPackage.SIMPLE_EXPRESSION_EXECUTION_CONDITION__EXPRESSION:
				return basicSetExpression(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SemanticPackage.SIMPLE_EXPRESSION_EXECUTION_CONDITION__EXECUTION_STATE:
				return getExecutionState();
			case SemanticPackage.SIMPLE_EXPRESSION_EXECUTION_CONDITION__EXPRESSION:
				return getExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SemanticPackage.SIMPLE_EXPRESSION_EXECUTION_CONDITION__EXECUTION_STATE:
				setExecutionState((ExecutionStateValue)newValue);
				return;
			case SemanticPackage.SIMPLE_EXPRESSION_EXECUTION_CONDITION__EXPRESSION:
				setExpression((AbstractExpression)newValue);
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
			case SemanticPackage.SIMPLE_EXPRESSION_EXECUTION_CONDITION__EXECUTION_STATE:
				setExecutionState(EXECUTION_STATE_EDEFAULT);
				return;
			case SemanticPackage.SIMPLE_EXPRESSION_EXECUTION_CONDITION__EXPRESSION:
				setExpression((AbstractExpression)null);
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
			case SemanticPackage.SIMPLE_EXPRESSION_EXECUTION_CONDITION__EXECUTION_STATE:
				return executionState != EXECUTION_STATE_EDEFAULT;
			case SemanticPackage.SIMPLE_EXPRESSION_EXECUTION_CONDITION__EXPRESSION:
				return expression != null;
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
		result.append(" (executionState: ");
		result.append(executionState);
		result.append(')');
		return result.toString();
	}

} //EventExecutionConditionImpl
