/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.executionstatemapping.model.semantic.FieldEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ParameterEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Evaluation Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.ParameterEvaluationConditionImpl#getParameterPosition <em>Parameter Position</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.ParameterEvaluationConditionImpl#getFieldEvaluationConditions <em>Field Evaluation Conditions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterEvaluationConditionImpl extends EvaluationConditionImpl implements ParameterEvaluationCondition 
{
	/**
	 * The default value of the '{@link #getParameterPosition() <em>Parameter Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterPosition()
	 * @generated
	 * @ordered
	 */
	protected static final int PARAMETER_POSITION_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getParameterPosition() <em>Parameter Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterPosition()
	 * @generated
	 * @ordered
	 */
	protected int parameterPosition = PARAMETER_POSITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFieldEvaluationConditions() <em>Field Evaluation Conditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldEvaluationConditions()
	 * @generated
	 * @ordered
	 */
	protected EList<FieldEvaluationCondition> fieldEvaluationConditions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterEvaluationConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticPackage.Literals.PARAMETER_EVALUATION_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getParameterPosition() {
		return parameterPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterPosition(int newParameterPosition) {
		int oldParameterPosition = parameterPosition;
		parameterPosition = newParameterPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.PARAMETER_EVALUATION_CONDITION__PARAMETER_POSITION, oldParameterPosition, parameterPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FieldEvaluationCondition> getFieldEvaluationConditions() {
		if (fieldEvaluationConditions == null) {
			fieldEvaluationConditions = new EObjectContainmentEList<FieldEvaluationCondition>(FieldEvaluationCondition.class, this, SemanticPackage.PARAMETER_EVALUATION_CONDITION__FIELD_EVALUATION_CONDITIONS);
		}
		return fieldEvaluationConditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SemanticPackage.PARAMETER_EVALUATION_CONDITION__FIELD_EVALUATION_CONDITIONS:
				return ((InternalEList<?>)getFieldEvaluationConditions()).basicRemove(otherEnd, msgs);
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
			case SemanticPackage.PARAMETER_EVALUATION_CONDITION__PARAMETER_POSITION:
				return new Integer(getParameterPosition());
			case SemanticPackage.PARAMETER_EVALUATION_CONDITION__FIELD_EVALUATION_CONDITIONS:
				return getFieldEvaluationConditions();
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
			case SemanticPackage.PARAMETER_EVALUATION_CONDITION__PARAMETER_POSITION:
				setParameterPosition(((Integer)newValue).intValue());
				return;
			case SemanticPackage.PARAMETER_EVALUATION_CONDITION__FIELD_EVALUATION_CONDITIONS:
				getFieldEvaluationConditions().clear();
				getFieldEvaluationConditions().addAll((Collection<? extends FieldEvaluationCondition>)newValue);
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
			case SemanticPackage.PARAMETER_EVALUATION_CONDITION__PARAMETER_POSITION:
				setParameterPosition(PARAMETER_POSITION_EDEFAULT);
				return;
			case SemanticPackage.PARAMETER_EVALUATION_CONDITION__FIELD_EVALUATION_CONDITIONS:
				getFieldEvaluationConditions().clear();
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
			case SemanticPackage.PARAMETER_EVALUATION_CONDITION__PARAMETER_POSITION:
				return parameterPosition != PARAMETER_POSITION_EDEFAULT;
			case SemanticPackage.PARAMETER_EVALUATION_CONDITION__FIELD_EVALUATION_CONDITIONS:
				return fieldEvaluationConditions != null && !fieldEvaluationConditions.isEmpty();
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
		result.append(" (parameterPosition: ");
		result.append(parameterPosition);
		result.append(')');
		return result.toString();
	}

} //ParameterEvaluationConditionImpl