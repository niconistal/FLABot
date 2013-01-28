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
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.AndExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.BlockExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue;
import org.isistan.flabot.executionstatemapping.model.semantic.OrExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;
import org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration;
import org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.SingleExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.VisitorExpression;
import org.isistan.flabot.launcher.filter.filtermodel.LogFilter;
import org.isistan.flabot.mapping.mappingmodel.PatternMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Execution Condition Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.SimpleExecutionConditionConfigurationImpl#getSimpleExpressionExecutionConditions <em>Simple Expression Execution Conditions</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.SimpleExecutionConditionConfigurationImpl#getExecutionConditionNotVerifiedState <em>Execution Condition Not Verified State</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.SimpleExecutionConditionConfigurationImpl#getExceptionState <em>Exception State</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.SimpleExecutionConditionConfigurationImpl#getPreFilters <em>Pre Filters</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.SimpleExecutionConditionConfigurationImpl#isUseDefaultConfiguration <em>Use Default Configuration</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.SimpleExecutionConditionConfigurationImpl#isUseCustomConfiguration <em>Use Custom Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleExecutionConditionConfigurationImpl extends EObjectImpl implements SimpleExecutionConditionConfiguration {
	/**
	 * The cached value of the '{@link #getSimpleExpressionExecutionConditions() <em>Simple Expression Execution Conditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleExpressionExecutionConditions()
	 * @generated
	 * @ordered
	 */
	protected EList<SimpleExpressionExecutionCondition> simpleExpressionExecutionConditions;

	/**
	 * The default value of the '{@link #getExecutionConditionNotVerifiedState() <em>Execution Condition Not Verified State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionConditionNotVerifiedState()
	 * @generated
	 * @ordered
	 */
	protected static final ExecutionStateValue EXECUTION_CONDITION_NOT_VERIFIED_STATE_EDEFAULT = ExecutionStateValue.NONE;

	/**
	 * The cached value of the '{@link #getExecutionConditionNotVerifiedState() <em>Execution Condition Not Verified State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionConditionNotVerifiedState()
	 * @generated
	 * @ordered
	 */
	protected ExecutionStateValue executionConditionNotVerifiedState = EXECUTION_CONDITION_NOT_VERIFIED_STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExceptionState() <em>Exception State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptionState()
	 * @generated
	 * @ordered
	 */
	protected static final ExecutionStateValue EXCEPTION_STATE_EDEFAULT = ExecutionStateValue.NONE;

	/**
	 * The cached value of the '{@link #getExceptionState() <em>Exception State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptionState()
	 * @generated
	 * @ordered
	 */
	protected ExecutionStateValue exceptionState = EXCEPTION_STATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPreFilters() <em>Pre Filters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreFilters()
	 * @generated
	 * @ordered
	 */
	protected EList<ExecutionCondition> preFilters;

	/**
	 * The default value of the '{@link #isUseDefaultConfiguration() <em>Use Default Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseDefaultConfiguration()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_DEFAULT_CONFIGURATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUseDefaultConfiguration() <em>Use Default Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseDefaultConfiguration()
	 * @generated
	 * @ordered
	 */
	protected boolean useDefaultConfiguration = USE_DEFAULT_CONFIGURATION_EDEFAULT;

	/**
	 * The default value of the '{@link #isUseCustomConfiguration() <em>Use Custom Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseCustomConfiguration()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_CUSTOM_CONFIGURATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUseCustomConfiguration() <em>Use Custom Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseCustomConfiguration()
	 * @generated
	 * @ordered
	 */
	protected boolean useCustomConfiguration = USE_CUSTOM_CONFIGURATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleExecutionConditionConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticPackage.Literals.SIMPLE_EXECUTION_CONDITION_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SimpleExpressionExecutionCondition> getSimpleExpressionExecutionConditions() {
		if (simpleExpressionExecutionConditions == null) {
			simpleExpressionExecutionConditions = new EObjectContainmentEList<SimpleExpressionExecutionCondition>(SimpleExpressionExecutionCondition.class, this, SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__SIMPLE_EXPRESSION_EXECUTION_CONDITIONS);
		}
		return simpleExpressionExecutionConditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionStateValue getExecutionConditionNotVerifiedState() {
		return executionConditionNotVerifiedState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutionConditionNotVerifiedState(ExecutionStateValue newExecutionConditionNotVerifiedState) {
		ExecutionStateValue oldExecutionConditionNotVerifiedState = executionConditionNotVerifiedState;
		executionConditionNotVerifiedState = newExecutionConditionNotVerifiedState == null ? EXECUTION_CONDITION_NOT_VERIFIED_STATE_EDEFAULT : newExecutionConditionNotVerifiedState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__EXECUTION_CONDITION_NOT_VERIFIED_STATE, oldExecutionConditionNotVerifiedState, executionConditionNotVerifiedState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionStateValue getExceptionState() {
		return exceptionState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExceptionState(ExecutionStateValue newExceptionState) {
		ExecutionStateValue oldExceptionState = exceptionState;
		exceptionState = newExceptionState == null ? EXCEPTION_STATE_EDEFAULT : newExceptionState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__EXCEPTION_STATE, oldExceptionState, exceptionState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExecutionCondition> getPreFilters() {
		if (preFilters == null) {
			preFilters = new EObjectResolvingEList<ExecutionCondition>(ExecutionCondition.class, this, SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__PRE_FILTERS);
		}
		return preFilters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseDefaultConfiguration() {
		return useDefaultConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseDefaultConfiguration(boolean newUseDefaultConfiguration) {
		boolean oldUseDefaultConfiguration = useDefaultConfiguration;
		useDefaultConfiguration = newUseDefaultConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__USE_DEFAULT_CONFIGURATION, oldUseDefaultConfiguration, useDefaultConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseCustomConfiguration() {
		return useCustomConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseCustomConfiguration(boolean newUseCustomConfiguration) {
		boolean oldUseCustomConfiguration = useCustomConfiguration;
		useCustomConfiguration = newUseCustomConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__USE_CUSTOM_CONFIGURATION, oldUseCustomConfiguration, useCustomConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__SIMPLE_EXPRESSION_EXECUTION_CONDITIONS:
				return ((InternalEList<?>)getSimpleExpressionExecutionConditions()).basicRemove(otherEnd, msgs);
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
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__SIMPLE_EXPRESSION_EXECUTION_CONDITIONS:
				return getSimpleExpressionExecutionConditions();
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__EXECUTION_CONDITION_NOT_VERIFIED_STATE:
				return getExecutionConditionNotVerifiedState();
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__EXCEPTION_STATE:
				return getExceptionState();
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__PRE_FILTERS:
				return getPreFilters();
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__USE_DEFAULT_CONFIGURATION:
				return isUseDefaultConfiguration() ? Boolean.TRUE : Boolean.FALSE;
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__USE_CUSTOM_CONFIGURATION:
				return isUseCustomConfiguration() ? Boolean.TRUE : Boolean.FALSE;
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
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__SIMPLE_EXPRESSION_EXECUTION_CONDITIONS:
				getSimpleExpressionExecutionConditions().clear();
				getSimpleExpressionExecutionConditions().addAll((Collection<? extends SimpleExpressionExecutionCondition>)newValue);
				return;
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__EXECUTION_CONDITION_NOT_VERIFIED_STATE:
				setExecutionConditionNotVerifiedState((ExecutionStateValue)newValue);
				return;
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__EXCEPTION_STATE:
				setExceptionState((ExecutionStateValue)newValue);
				return;
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__PRE_FILTERS:
				getPreFilters().clear();
				getPreFilters().addAll((Collection<? extends ExecutionCondition>)newValue);
				return;
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__USE_DEFAULT_CONFIGURATION:
				setUseDefaultConfiguration(((Boolean)newValue).booleanValue());
				return;
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__USE_CUSTOM_CONFIGURATION:
				setUseCustomConfiguration(((Boolean)newValue).booleanValue());
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
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__SIMPLE_EXPRESSION_EXECUTION_CONDITIONS:
				getSimpleExpressionExecutionConditions().clear();
				return;
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__EXECUTION_CONDITION_NOT_VERIFIED_STATE:
				setExecutionConditionNotVerifiedState(EXECUTION_CONDITION_NOT_VERIFIED_STATE_EDEFAULT);
				return;
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__EXCEPTION_STATE:
				setExceptionState(EXCEPTION_STATE_EDEFAULT);
				return;
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__PRE_FILTERS:
				getPreFilters().clear();
				return;
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__USE_DEFAULT_CONFIGURATION:
				setUseDefaultConfiguration(USE_DEFAULT_CONFIGURATION_EDEFAULT);
				return;
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__USE_CUSTOM_CONFIGURATION:
				setUseCustomConfiguration(USE_CUSTOM_CONFIGURATION_EDEFAULT);
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
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__SIMPLE_EXPRESSION_EXECUTION_CONDITIONS:
				return simpleExpressionExecutionConditions != null && !simpleExpressionExecutionConditions.isEmpty();
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__EXECUTION_CONDITION_NOT_VERIFIED_STATE:
				return executionConditionNotVerifiedState != EXECUTION_CONDITION_NOT_VERIFIED_STATE_EDEFAULT;
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__EXCEPTION_STATE:
				return exceptionState != EXCEPTION_STATE_EDEFAULT;
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__PRE_FILTERS:
				return preFilters != null && !preFilters.isEmpty();
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__USE_DEFAULT_CONFIGURATION:
				return useDefaultConfiguration != USE_DEFAULT_CONFIGURATION_EDEFAULT;
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION__USE_CUSTOM_CONFIGURATION:
				return useCustomConfiguration != USE_CUSTOM_CONFIGURATION_EDEFAULT;
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
		result.append(" (executionConditionNotVerifiedState: ");
		result.append(executionConditionNotVerifiedState);
		result.append(", exceptionState: ");
		result.append(exceptionState);
		result.append(", useDefaultConfiguration: ");
		result.append(useDefaultConfiguration);
		result.append(", useCustomConfiguration: ");
		result.append(useCustomConfiguration);
		result.append(')');
		return result.toString();
	}
	
	public void resetProlog()
	{
			for(ExecutionCondition executionCondition : getPreFilters())
			{
	    		executionCondition.resetPredicateName();
			}
			
			for(SimpleExpressionExecutionCondition simpleExpressionExecutionCondition : getSimpleExpressionExecutionConditions())
			{
				if (simpleExpressionExecutionCondition.getExpression() != null)
				{
					simpleExpressionExecutionCondition.getExpression().resetPredicateName();
				}
			}
	}
	
	public void checkMapping(PatternMapping patternMapping)
    {
    	for(ExecutionCondition condition : getPreFilters())
    	{
   			condition.checkMapping(patternMapping);
    	}
    
    	MappingExpressionChecker mappingExpressionChecker = new MappingExpressionChecker(patternMapping);
    	for(SimpleExpressionExecutionCondition simpleExpression : getSimpleExpressionExecutionConditions())
    	{
    		if (simpleExpression.getExpression() != null)
			{    
    			simpleExpression.getExpression().accept(mappingExpressionChecker);
			}
    	}
    }
	
	public void checkFilter(LogFilter logFilter)
    {
    	for(ExecutionCondition condition : getPreFilters())
    	{
   			condition.checkFilter(logFilter);
    	}
    
    	FilterExpressionChecker filterExpressionChecker = new FilterExpressionChecker(logFilter);
    	for(SimpleExpressionExecutionCondition simpleExpression : getSimpleExpressionExecutionConditions())
    	{
    		if (simpleExpression.getExpression() != null)
			{    
    			simpleExpression.getExpression().accept(filterExpressionChecker);
			}
    	}
    }
	
	class MappingExpressionChecker implements VisitorExpression 
	{
		private PatternMapping patternMapping;
		
		public MappingExpressionChecker(PatternMapping patternMapping)
		{
			this.patternMapping = patternMapping;
		}
		
		public void visitBlock(BlockExpression expression)
		{
			for(AbstractExpression e : expression.getExpressionList())
			{
				e.accept(this);
			}
		}
		
		public void visit(AndExpression expression) {
			visitBlock(expression);			
		}

		public void visit(OrExpression expression) {
			visitBlock(expression);			
		}

		public void visit(SingleExpression expression) {
			if (expression.getExecutionCondition() != null)
			{
				expression.getExecutionCondition().checkMapping(patternMapping);
			}
		}
	}
	
	class FilterExpressionChecker implements VisitorExpression 
	{
		private LogFilter logFilter;
		
		public FilterExpressionChecker(LogFilter logFilter)
		{
			this.logFilter = logFilter;
		}
		
		public void visitBlock(BlockExpression expression)
		{
			for(AbstractExpression e : expression.getExpressionList())
			{
				e.accept(this);
			}
		}
		
		public void visit(AndExpression expression) {
			visitBlock(expression);			
		}

		public void visit(OrExpression expression) {
			visitBlock(expression);			
		}

		public void visit(SingleExpression expression) {
			if (expression.getExecutionCondition() != null)
			{
				expression.getExecutionCondition().checkFilter(logFilter);
			}
		}
	}

} //SimpleExecutionConditionConfigurationImpl
