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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;
import org.isistan.flabot.executionstatemapping.model.semantic.State;
import org.isistan.flabot.executionstatemapping.model.semantic.StateContainer;
import org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition;
import org.isistan.flabot.launcher.filter.filtermodel.LogFilter;
import org.isistan.flabot.mapping.mappingmodel.PatternMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.StateContainerImpl#getStates <em>States</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.StateContainerImpl#getInicialStates <em>Inicial States</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.StateContainerImpl#getFinalStates <em>Final States</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.StateContainerImpl#getPreFilters <em>Pre Filters</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.StateContainerImpl#getTransitionConditions <em>Transition Conditions</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.StateContainerImpl#getDefaultState <em>Default State</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.StateContainerImpl#getExceptionState <em>Exception State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateContainerImpl extends TreeStructuredElementImpl implements StateContainer
{
	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
        protected EList<State> states;

	/**
	 * The cached value of the '{@link #getInicialStates() <em>Inicial States</em>}' reference list.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getInicialStates()
	 * @generated
	 * @ordered
	 */
        protected EList<State> inicialStates;

	/**
	 * The cached value of the '{@link #getFinalStates() <em>Final States</em>}' reference list.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getFinalStates()
	 * @generated
	 * @ordered
	 */
        protected EList<State> finalStates;

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
	 * The cached value of the '{@link #getTransitionConditions() <em>Transition Conditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitionConditions()
	 * @generated
	 * @ordered
	 */
	protected EList<TransitionCondition> transitionConditions;

	/**
	 * The default value of the '{@link #getDefaultState() <em>Default State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultState()
	 * @generated
	 * @ordered
	 */
	protected static final ExecutionStateValue DEFAULT_STATE_EDEFAULT = ExecutionStateValue.NOT_EXECUTED;

	/**
	 * The cached value of the '{@link #getDefaultState() <em>Default State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultState()
	 * @generated
	 * @ordered
	 */
	protected ExecutionStateValue defaultState = DEFAULT_STATE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        protected StateContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
								protected EClass eStaticClass() {
		return SemanticPackage.Literals.STATE_CONTAINER;
	}


	public String getPredicateName() {
		return "";
	}

	
	public void setPredicateName(String newPredicateName) {
	}

	/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EList<State> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList<State>(State.class, this, SemanticPackage.STATE_CONTAINER__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EList<State> getInicialStates() {
		if (inicialStates == null) {
			inicialStates = new EObjectResolvingEList<State>(State.class, this, SemanticPackage.STATE_CONTAINER__INICIAL_STATES);
		}
		return inicialStates;
	}

	/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EList<State> getFinalStates() {
		if (finalStates == null) {
			finalStates = new EObjectResolvingEList<State>(State.class, this, SemanticPackage.STATE_CONTAINER__FINAL_STATES);
		}
		return finalStates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExecutionCondition> getPreFilters() {
		if (preFilters == null) {
			preFilters = new EObjectResolvingEList<ExecutionCondition>(ExecutionCondition.class, this, SemanticPackage.STATE_CONTAINER__PRE_FILTERS);
		}
		return preFilters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TransitionCondition> getTransitionConditions() {
		if (transitionConditions == null) {
			transitionConditions = new EObjectContainmentEList<TransitionCondition>(TransitionCondition.class, this, SemanticPackage.STATE_CONTAINER__TRANSITION_CONDITIONS);
		}
		return transitionConditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionStateValue getDefaultState() {
		return defaultState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultState(ExecutionStateValue newDefaultState) {
		ExecutionStateValue oldDefaultState = defaultState;
		defaultState = newDefaultState == null ? DEFAULT_STATE_EDEFAULT : newDefaultState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.STATE_CONTAINER__DEFAULT_STATE, oldDefaultState, defaultState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.STATE_CONTAINER__EXCEPTION_STATE, oldExceptionState, exceptionState));
	}


	/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SemanticPackage.STATE_CONTAINER__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
			case SemanticPackage.STATE_CONTAINER__TRANSITION_CONDITIONS:
				return ((InternalEList<?>)getTransitionConditions()).basicRemove(otherEnd, msgs);
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
			case SemanticPackage.STATE_CONTAINER__STATES:
				return getStates();
			case SemanticPackage.STATE_CONTAINER__INICIAL_STATES:
				return getInicialStates();
			case SemanticPackage.STATE_CONTAINER__FINAL_STATES:
				return getFinalStates();
			case SemanticPackage.STATE_CONTAINER__PRE_FILTERS:
				return getPreFilters();
			case SemanticPackage.STATE_CONTAINER__TRANSITION_CONDITIONS:
				return getTransitionConditions();
			case SemanticPackage.STATE_CONTAINER__DEFAULT_STATE:
				return getDefaultState();
			case SemanticPackage.STATE_CONTAINER__EXCEPTION_STATE:
				return getExceptionState();
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
			case SemanticPackage.STATE_CONTAINER__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends State>)newValue);
				return;
			case SemanticPackage.STATE_CONTAINER__INICIAL_STATES:
				getInicialStates().clear();
				getInicialStates().addAll((Collection<? extends State>)newValue);
				return;
			case SemanticPackage.STATE_CONTAINER__FINAL_STATES:
				getFinalStates().clear();
				getFinalStates().addAll((Collection<? extends State>)newValue);
				return;
			case SemanticPackage.STATE_CONTAINER__PRE_FILTERS:
				getPreFilters().clear();
				getPreFilters().addAll((Collection<? extends ExecutionCondition>)newValue);
				return;
			case SemanticPackage.STATE_CONTAINER__TRANSITION_CONDITIONS:
				getTransitionConditions().clear();
				getTransitionConditions().addAll((Collection<? extends TransitionCondition>)newValue);
				return;
			case SemanticPackage.STATE_CONTAINER__DEFAULT_STATE:
				setDefaultState((ExecutionStateValue)newValue);
				return;
			case SemanticPackage.STATE_CONTAINER__EXCEPTION_STATE:
				setExceptionState((ExecutionStateValue)newValue);
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
			case SemanticPackage.STATE_CONTAINER__STATES:
				getStates().clear();
				return;
			case SemanticPackage.STATE_CONTAINER__INICIAL_STATES:
				getInicialStates().clear();
				return;
			case SemanticPackage.STATE_CONTAINER__FINAL_STATES:
				getFinalStates().clear();
				return;
			case SemanticPackage.STATE_CONTAINER__PRE_FILTERS:
				getPreFilters().clear();
				return;
			case SemanticPackage.STATE_CONTAINER__TRANSITION_CONDITIONS:
				getTransitionConditions().clear();
				return;
			case SemanticPackage.STATE_CONTAINER__DEFAULT_STATE:
				setDefaultState(DEFAULT_STATE_EDEFAULT);
				return;
			case SemanticPackage.STATE_CONTAINER__EXCEPTION_STATE:
				setExceptionState(EXCEPTION_STATE_EDEFAULT);
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
			case SemanticPackage.STATE_CONTAINER__STATES:
				return states != null && !states.isEmpty();
			case SemanticPackage.STATE_CONTAINER__INICIAL_STATES:
				return inicialStates != null && !inicialStates.isEmpty();
			case SemanticPackage.STATE_CONTAINER__FINAL_STATES:
				return finalStates != null && !finalStates.isEmpty();
			case SemanticPackage.STATE_CONTAINER__PRE_FILTERS:
				return preFilters != null && !preFilters.isEmpty();
			case SemanticPackage.STATE_CONTAINER__TRANSITION_CONDITIONS:
				return transitionConditions != null && !transitionConditions.isEmpty();
			case SemanticPackage.STATE_CONTAINER__DEFAULT_STATE:
				return defaultState != DEFAULT_STATE_EDEFAULT;
			case SemanticPackage.STATE_CONTAINER__EXCEPTION_STATE:
				return exceptionState != EXCEPTION_STATE_EDEFAULT;
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
		result.append(" (defaultState: ");
		result.append(defaultState);
		result.append(", exceptionState: ");
		result.append(exceptionState);
		result.append(')');
		return result.toString();
	}
            
    public boolean passesMapping(PatternMapping[] patternMappings)
    {
    	for(ExecutionCondition mec : getPreFilters())
    	{
    		for(PatternMapping patternMapping : patternMappings)
    		{
    			if (!mec.passesMapping(patternMapping))
    			{
    				return false;
    			}
    		}
    	}
    	
    	for(TransitionCondition tc : getTransitionConditions())
    	{
    		for(PatternMapping patternMapping : patternMappings)
    		{
    			if (tc.getExecutionCondition() != null && !tc.getExecutionCondition().passesMapping(patternMapping))
    			{
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    public void checkMapping(PatternMapping patternMapping)
    {
    	for(ExecutionCondition condition : getPreFilters())
    	{
   			condition.checkMapping(patternMapping);
    	}
    	
    	for(TransitionCondition tc : getTransitionConditions())
    	{
    		if (tc.getExecutionCondition() != null)
			{        			
    			tc.getExecutionCondition().checkMapping(patternMapping);
			}
    	}
    }
    
	public void checkFilter(LogFilter logFilter)
	{    		
		for(ExecutionCondition executionCondition : getPreFilters())
    	{
			executionCondition.checkFilter(logFilter);
    	}    		
		
		for(TransitionCondition tc : getTransitionConditions())
    	{
    		if (tc.getExecutionCondition() != null)
			{        			
    			tc.getExecutionCondition().checkFilter(logFilter);
			}
    	}
	}
	
} //StateContainerImpl