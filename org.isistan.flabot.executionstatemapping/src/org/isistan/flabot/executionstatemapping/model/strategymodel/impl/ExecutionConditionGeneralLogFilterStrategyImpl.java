/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.strategymodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologFactory;
import org.isistan.flabot.executionstatemapping.model.prolog.impl.GeneralLogFilterTagProvider;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration;
import org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.strategymodel.ExecutionConditionGeneralLogFilterStrategy;
import org.isistan.flabot.executionstatemapping.model.strategymodel.StrategymodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Condition General Log Filter Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.strategymodel.impl.ExecutionConditionGeneralLogFilterStrategyImpl#getSimpleExecutionConditionConfiguration <em>Simple Execution Condition Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionConditionGeneralLogFilterStrategyImpl extends EObjectImpl implements ExecutionConditionGeneralLogFilterStrategy {
	/**
	 * The cached value of the '{@link #getSimpleExecutionConditionConfiguration() <em>Simple Execution Condition Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleExecutionConditionConfiguration()
	 * @generated
	 * @ordered
	 */
	protected SimpleExecutionConditionConfiguration simpleExecutionConditionConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionConditionGeneralLogFilterStrategyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StrategymodelPackage.Literals.EXECUTION_CONDITION_GENERAL_LOG_FILTER_STRATEGY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleExecutionConditionConfiguration getSimpleExecutionConditionConfiguration() {
		return simpleExecutionConditionConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimpleExecutionConditionConfiguration(SimpleExecutionConditionConfiguration newSimpleExecutionConditionConfiguration, NotificationChain msgs) {
		SimpleExecutionConditionConfiguration oldSimpleExecutionConditionConfiguration = simpleExecutionConditionConfiguration;
		simpleExecutionConditionConfiguration = newSimpleExecutionConditionConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StrategymodelPackage.EXECUTION_CONDITION_GENERAL_LOG_FILTER_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION, oldSimpleExecutionConditionConfiguration, newSimpleExecutionConditionConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleExecutionConditionConfiguration(SimpleExecutionConditionConfiguration newSimpleExecutionConditionConfiguration) {
		if (newSimpleExecutionConditionConfiguration != simpleExecutionConditionConfiguration) {
			NotificationChain msgs = null;
			if (simpleExecutionConditionConfiguration != null)
				msgs = ((InternalEObject)simpleExecutionConditionConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StrategymodelPackage.EXECUTION_CONDITION_GENERAL_LOG_FILTER_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION, null, msgs);
			if (newSimpleExecutionConditionConfiguration != null)
				msgs = ((InternalEObject)newSimpleExecutionConditionConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StrategymodelPackage.EXECUTION_CONDITION_GENERAL_LOG_FILTER_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION, null, msgs);
			msgs = basicSetSimpleExecutionConditionConfiguration(newSimpleExecutionConditionConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrategymodelPackage.EXECUTION_CONDITION_GENERAL_LOG_FILTER_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION, newSimpleExecutionConditionConfiguration, newSimpleExecutionConditionConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StrategymodelPackage.EXECUTION_CONDITION_GENERAL_LOG_FILTER_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION:
				return basicSetSimpleExecutionConditionConfiguration(null, msgs);
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
			case StrategymodelPackage.EXECUTION_CONDITION_GENERAL_LOG_FILTER_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION:
				return getSimpleExecutionConditionConfiguration();
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
			case StrategymodelPackage.EXECUTION_CONDITION_GENERAL_LOG_FILTER_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION:
				setSimpleExecutionConditionConfiguration((SimpleExecutionConditionConfiguration)newValue);
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
			case StrategymodelPackage.EXECUTION_CONDITION_GENERAL_LOG_FILTER_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION:
				setSimpleExecutionConditionConfiguration((SimpleExecutionConditionConfiguration)null);
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
			case StrategymodelPackage.EXECUTION_CONDITION_GENERAL_LOG_FILTER_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION:
				return simpleExecutionConditionConfiguration != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		return eGet(eDerivedStructuralFeatureID(eFeature), resolve, true);
	}

	@Override
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		eSet(eDerivedStructuralFeatureID(eFeature), newValue);
	}

	@Override
	public void eUnset(EStructuralFeature eFeature) {
		eUnset(eDerivedStructuralFeatureID(eFeature));
	}

	@Override
	public boolean eIsSet(EStructuralFeature eFeature) {
		return eIsSet(eDerivedStructuralFeatureID(eFeature));
	}
	
	public String getPrologCode()
	{
		if (getSimpleExecutionConditionConfiguration() != null)
		{
			resetProlog();
			
			String prolog = PrologFactory.eINSTANCE.createPrologCodeFactory().getPrologCode(getSimpleExecutionConditionConfiguration(), new GeneralLogFilterTagProvider()); 
			return prolog;
		}
		return "";
	}
	
	public void resetProlog()
	{
		if (getSimpleExecutionConditionConfiguration() != null)
		{
			for(ExecutionCondition executionCondition : getSimpleExecutionConditionConfiguration().getPreFilters())
			{
	    		executionCondition.resetPredicateName();
			}
			
			for(SimpleExpressionExecutionCondition simpleExpressionExecutionCondition : getSimpleExecutionConditionConfiguration().getSimpleExpressionExecutionConditions())
			{
				if (simpleExpressionExecutionCondition.getExpression() != null)
				{
					simpleExpressionExecutionCondition.getExpression().resetPredicateName();
				}
			}
		}
	}
	
} //ExecutionConditionGeneralLogFilterStrategyImpl
