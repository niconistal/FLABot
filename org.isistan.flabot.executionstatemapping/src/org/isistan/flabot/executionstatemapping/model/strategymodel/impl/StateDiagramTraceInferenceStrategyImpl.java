/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.strategymodel.impl;

import org.eclipse.emf.common.notify.Notification;
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
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.StateContainer;
import org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition;
import org.isistan.flabot.executionstatemapping.model.strategymodel.StateDiagramTraceInferenceStrategy;
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
 * An implementation of the model object '<em><b>Execution Condition Trace Based State Determination Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.strategymodel.impl.StateDiagramTraceInferenceStrategyImpl#getStateContainer <em>State Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateDiagramTraceInferenceStrategyImpl extends JavalogTraceInferenceStrategyImpl implements StateDiagramTraceInferenceStrategy {
	/**
	 * The cached value of the '{@link #getStateContainer() <em>State Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateContainer()
	 * @generated
	 * @ordered
	 */
	protected StateContainer stateContainer;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateDiagramTraceInferenceStrategyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StrategymodelPackage.Literals.STATE_DIAGRAM_TRACE_INFERENCE_STRATEGY;
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateContainer getStateContainer() {
		if (stateContainer != null && stateContainer.eIsProxy()) {
			InternalEObject oldStateContainer = (InternalEObject)stateContainer;
			stateContainer = (StateContainer)eResolveProxy(oldStateContainer);
			if (stateContainer != oldStateContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StrategymodelPackage.STATE_DIAGRAM_TRACE_INFERENCE_STRATEGY__STATE_CONTAINER, oldStateContainer, stateContainer));
			}
		}
		return stateContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateContainer basicGetStateContainer() {
		return stateContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateContainer(StateContainer newStateContainer) {
		StateContainer oldStateContainer = stateContainer;
		stateContainer = newStateContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrategymodelPackage.STATE_DIAGRAM_TRACE_INFERENCE_STRATEGY__STATE_CONTAINER, oldStateContainer, stateContainer));
	}	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StrategymodelPackage.STATE_DIAGRAM_TRACE_INFERENCE_STRATEGY__STATE_CONTAINER:
				if (resolve) return getStateContainer();
				return basicGetStateContainer();
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
			case StrategymodelPackage.STATE_DIAGRAM_TRACE_INFERENCE_STRATEGY__STATE_CONTAINER:
				setStateContainer((StateContainer)newValue);
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
			case StrategymodelPackage.STATE_DIAGRAM_TRACE_INFERENCE_STRATEGY__STATE_CONTAINER:
				setStateContainer((StateContainer)null);
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
			case StrategymodelPackage.STATE_DIAGRAM_TRACE_INFERENCE_STRATEGY__STATE_CONTAINER:
				return stateContainer != null;
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
	public void checkMapping(Responsibility responsibility)
	{
		PatternMapping responsibilityMapping = (PatternMapping)MappingManager.getMapping(responsibility);
		if (responsibilityMapping == null)
		{
			responsibilityMapping = MappingmodelFactory.eINSTANCE.createPatternMapping();
			MappingManager.setMapping(responsibility, responsibilityMapping);
		}		
		
		if (getStateContainer() != null)
		{			
			getStateContainer().checkMapping(responsibilityMapping);
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
				
		if (getStateContainer() != null)
		{			
			getStateContainer().checkFilter(logFilter);
		}
	}
	
	public void resetProlog()
	{
		if (getStateContainer() != null)
		{
			for(ExecutionCondition executionCondition : getStateContainer().getPreFilters())
			{
	    		executionCondition.resetPredicateName();
			}
	    	
	    	for(TransitionCondition tc : getStateContainer().getTransitionConditions())
	    	{
	    		if (tc.getExecutionCondition() != null)
				{
	    			tc.getExecutionCondition().resetPredicateName();
				}
	    	}
		}
	}

	@Override
	public String getPrologCode()
	{
		if (getStateContainer() != null)
		{
			resetProlog();
			
			return PrologFactory.eINSTANCE.createPrologCodeFactory().getPrologCode(getStateContainer(), new ResponsibilityTagProviderImpl()); 
		}
		return "";
	}

	public String getPrologCode(ConditionEvent conditionEvent)
	{
		if (getStateContainer() != null)
		{	
			return PrologFactory.eINSTANCE.createPrologCodeFactory().getPrologCode(getStateContainer(), new EventTagProviderImpl(conditionEvent.getName())); 
		}
		return "";
	}
	
} //ExecutionConditionTraceBasedStateDeterminationStrategyImpl
