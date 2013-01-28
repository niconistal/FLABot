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
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.engine.executionstate.javalogtrace.impl.JavalogTraceInferenceStrategyImpl;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologFactory;
import org.isistan.flabot.executionstatemapping.model.prolog.impl.EventTagProviderImpl;
import org.isistan.flabot.executionstatemapping.model.prolog.impl.ResponsibilityTagProviderImpl;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue;
import org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration;
import org.isistan.flabot.executionstatemapping.model.strategymodel.SimpleExecutionConditionTraceInferenceStrategy;
import org.isistan.flabot.executionstatemapping.model.strategymodel.StrategymodelPackage;
import org.isistan.flabot.executionstatemapping.model.strategymodel.util.MappingChecker;
import org.isistan.flabot.launcher.filter.LogFilterManager;
import org.isistan.flabot.launcher.filter.filtermodel.FiltermodelFactory;
import org.isistan.flabot.launcher.filter.filtermodel.LogFilter;
import org.isistan.flabot.mapping.MappingManager;
import org.isistan.flabot.mapping.mappingmodel.MappingmodelFactory;
import org.isistan.flabot.mapping.mappingmodel.PatternMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Execution Condition Trace Inference Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.strategymodel.impl.SimpleExecutionConditionTraceInferenceStrategyImpl#getSimpleExecutionConditionConfiguration <em>Simple Execution Condition Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleExecutionConditionTraceInferenceStrategyImpl extends JavalogTraceInferenceStrategyImpl implements SimpleExecutionConditionTraceInferenceStrategy {
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
	 * The default value of the '{@link #getExceptionState() <em>Exception State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptionState()
	 * @generated NOT
	 * @ordered
	 */
	protected static final ExecutionStateValue EXCEPTION_STATE_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleExecutionConditionTraceInferenceStrategyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StrategymodelPackage.Literals.SIMPLE_EXECUTION_CONDITION_TRACE_INFERENCE_STRATEGY;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StrategymodelPackage.SIMPLE_EXECUTION_CONDITION_TRACE_INFERENCE_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION, oldSimpleExecutionConditionConfiguration, newSimpleExecutionConditionConfiguration);
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
				msgs = ((InternalEObject)simpleExecutionConditionConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StrategymodelPackage.SIMPLE_EXECUTION_CONDITION_TRACE_INFERENCE_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION, null, msgs);
			if (newSimpleExecutionConditionConfiguration != null)
				msgs = ((InternalEObject)newSimpleExecutionConditionConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StrategymodelPackage.SIMPLE_EXECUTION_CONDITION_TRACE_INFERENCE_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION, null, msgs);
			msgs = basicSetSimpleExecutionConditionConfiguration(newSimpleExecutionConditionConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrategymodelPackage.SIMPLE_EXECUTION_CONDITION_TRACE_INFERENCE_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION, newSimpleExecutionConditionConfiguration, newSimpleExecutionConditionConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StrategymodelPackage.SIMPLE_EXECUTION_CONDITION_TRACE_INFERENCE_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION:
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
			case StrategymodelPackage.SIMPLE_EXECUTION_CONDITION_TRACE_INFERENCE_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION:
				return getSimpleExecutionConditionConfiguration();
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
			case StrategymodelPackage.SIMPLE_EXECUTION_CONDITION_TRACE_INFERENCE_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION:
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
			case StrategymodelPackage.SIMPLE_EXECUTION_CONDITION_TRACE_INFERENCE_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION:
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
			case StrategymodelPackage.SIMPLE_EXECUTION_CONDITION_TRACE_INFERENCE_STRATEGY__SIMPLE_EXECUTION_CONDITION_CONFIGURATION:
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
	
	@Override
	public String getPrologCode()
	{
		if (getSimpleExecutionConditionConfiguration() != null)
		{
			resetProlog();
			
			String prolog = PrologFactory.eINSTANCE.createPrologCodeFactory().getPrologCode(getSimpleExecutionConditionConfiguration(), new ResponsibilityTagProviderImpl()); 
			return prolog;
		}
		return "";
	}
	
	public String getPrologCode(ConditionEvent conditionEvent)
	{
		if (getSimpleExecutionConditionConfiguration() != null)
		{
			return PrologFactory.eINSTANCE.createPrologCodeFactory().getPrologCode(getSimpleExecutionConditionConfiguration(), new EventTagProviderImpl(conditionEvent.getName()));
		}
		return "";	
	}
	
	@Override
	public void checkMapping(Responsibility responsibility)
	{
		PatternMapping responsibilityMapping = (PatternMapping)MappingManager.getMapping(responsibility);		
		if (responsibilityMapping == null)
		{
			responsibilityMapping = MappingmodelFactory.eINSTANCE.createPatternMapping();
			MappingManager.setMapping(responsibility, responsibilityMapping);
		}
			
		if (getSimpleExecutionConditionConfiguration() != null)
		{			
			getSimpleExecutionConditionConfiguration().checkMapping((PatternMapping)responsibilityMapping);
		}
		
		MappingChecker.checkComponentMapping(responsibility, responsibilityMapping);
	}
	
	@Override
	public void checkFilter(Responsibility responsibility)
	{
		LogFilter logFilter = LogFilterManager.getLogFilter(responsibility);		
		if (logFilter == null)
		{
			logFilter = FiltermodelFactory.eINSTANCE.createLogFilter();
			LogFilterManager.setLogFilter(responsibility, logFilter);
		}
		
		if (getSimpleExecutionConditionConfiguration() != null)
		{			
			getSimpleExecutionConditionConfiguration().checkFilter(logFilter);
		}
	}
	
	public void resetProlog()
	{
		if (getSimpleExecutionConditionConfiguration() != null)
		{
			getSimpleExecutionConditionConfiguration().resetProlog();
		}
	}
	
} //SimpleExecutionConditionTraceInferenceStrategyImpl