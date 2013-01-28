/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.BlockExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block Expression Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.BlockExpressionImpl#getExpressionList <em>Expression List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class BlockExpressionImpl extends AbstractExpressionImpl implements BlockExpression {
	/**
	 * The cached value of the '{@link #getExpressionList() <em>Expression List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionList()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractExpression> expressionList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticPackage.Literals.BLOCK_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractExpression> getExpressionList() {
		if (expressionList == null) {
			expressionList = new EObjectContainmentEList<AbstractExpression>(AbstractExpression.class, this, SemanticPackage.BLOCK_EXPRESSION__EXPRESSION_LIST);
		}
		return expressionList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SemanticPackage.BLOCK_EXPRESSION__EXPRESSION_LIST:
				return ((InternalEList<?>)getExpressionList()).basicRemove(otherEnd, msgs);
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
			case SemanticPackage.BLOCK_EXPRESSION__EXPRESSION_LIST:
				return getExpressionList();
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
			case SemanticPackage.BLOCK_EXPRESSION__EXPRESSION_LIST:
				getExpressionList().clear();
				getExpressionList().addAll((Collection<? extends AbstractExpression>)newValue);
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
			case SemanticPackage.BLOCK_EXPRESSION__EXPRESSION_LIST:
				getExpressionList().clear();
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
			case SemanticPackage.BLOCK_EXPRESSION__EXPRESSION_LIST:
				return expressionList != null && !expressionList.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public void resetPredicateName()
	{
		predicateName=null;
		for(AbstractExpression pe :getExpressionList())
		{
			pe.resetPredicateName();
		}
	}	
	
} //BlockExpressionEventImpl
