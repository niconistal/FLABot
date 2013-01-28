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
import org.isistan.flabot.executionstatemapping.model.prolog.VisitorExpressionProlog;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;
import org.isistan.flabot.executionstatemapping.model.semantic.SingleExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.VisitorExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.SingleExpressionImpl#getExecutionCondition <em>Execution Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SingleExpressionImpl extends AbstractExpressionImpl implements SingleExpression {
	/**
	 * The cached value of the '{@link #getExecutionCondition() <em>Execution Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionCondition()
	 * @generated
	 * @ordered
	 */
	protected ExecutionCondition executionCondition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SingleExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticPackage.Literals.SINGLE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionCondition getExecutionCondition() {
		if (executionCondition != null && executionCondition.eIsProxy()) {
			InternalEObject oldExecutionCondition = (InternalEObject)executionCondition;
			executionCondition = (ExecutionCondition)eResolveProxy(oldExecutionCondition);
			if (executionCondition != oldExecutionCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SemanticPackage.SINGLE_EXPRESSION__EXECUTION_CONDITION, oldExecutionCondition, executionCondition));
			}
		}
		return executionCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionCondition basicGetExecutionCondition() {
		return executionCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutionCondition(ExecutionCondition newExecutionCondition) {
		ExecutionCondition oldExecutionCondition = executionCondition;
		executionCondition = newExecutionCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.SINGLE_EXPRESSION__EXECUTION_CONDITION, oldExecutionCondition, executionCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SemanticPackage.SINGLE_EXPRESSION__EXECUTION_CONDITION:
				if (resolve) return getExecutionCondition();
				return basicGetExecutionCondition();
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
			case SemanticPackage.SINGLE_EXPRESSION__EXECUTION_CONDITION:
				setExecutionCondition((ExecutionCondition)newValue);
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
			case SemanticPackage.SINGLE_EXPRESSION__EXECUTION_CONDITION:
				setExecutionCondition((ExecutionCondition)null);
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
			case SemanticPackage.SINGLE_EXPRESSION__EXECUTION_CONDITION:
				return executionCondition != null;
		}
		return super.eIsSet(featureID);
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
	
	@Override
	public void resetPredicateName()
	{
		predicateName=null;
		if (getExecutionCondition() != null)
		{
			getExecutionCondition().resetPredicateName();
		}
	}

} //SingleExpressionImpl
