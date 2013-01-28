/**
 * <copyright>
 * </copyright>
 *
 * $Id: TraceBasedStateDeterminationStrategyImpl.java,v 1.34 2006/04/13 05:26:52 mblech Exp $
 */
package org.isistan.flabot.engine.executionstate.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.ResponsibilityRegistry;
import org.isistan.flabot.engine.InterfaceContextInfo;
import org.isistan.flabot.engine.Loader;
import org.isistan.flabot.engine.executionstate.BasicMappingBasedFilter;
import org.isistan.flabot.engine.executionstate.ContextCreationException;
import org.isistan.flabot.engine.executionstate.Diagnostic;
import org.isistan.flabot.engine.executionstate.ExecutionstateFactory;
import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;
import org.isistan.flabot.engine.executionstate.StateDeterminationException;
import org.isistan.flabot.engine.executionstate.TraceBasedStateDeterminationStrategy;
import org.isistan.flabot.engine.executionstate.TraceInferenceStrategy;
import org.isistan.flabot.engine.executionstate.TraceLogManagerException;
import org.isistan.flabot.engine.executionstate.correlation.Correlator;
import org.isistan.flabot.engine.executionstate.correlation.dialog.TagFilterDialogManager;
import org.isistan.flabot.engine.executionstate.tagfilter.AndCompositeFilter;
import org.isistan.flabot.engine.executionstate.tagfilter.ComponentScopeTagFilter;
import org.isistan.flabot.engine.executionstate.tagfilter.TagFilter;
import org.isistan.flabot.launcher.filter.LogFilterManager;
import org.isistan.flabot.launcher.filter.filtermodel.LogFilter;
import org.isistan.flabot.mapping.MappingManager;
import org.isistan.flabot.mapping.mappingmodel.Mapping;
import org.isistan.flabot.mapping.mappingmodel.ScopeAwareMappingCreator;
import org.isistan.flabot.trace.config.ConfigFactory;
import org.isistan.flabot.trace.config.Context;
import org.isistan.flabot.trace.log.LogContext;
import org.isistan.flabot.trace.log.Tag;
import org.isistan.flabot.trace.log.TraceLog;
import org.isistan.flabot.util.EObjectIdGenerator;
import org.isistan.flabot.util.ObjectBoolean;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Based State Determination Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.engine.executionstate.impl.TraceBasedStateDeterminationStrategyImpl#getTraceInferenceStrategy <em>Trace Inference Strategy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceBasedStateDeterminationStrategyImpl extends StateDeterminationStrategyImpl implements TraceBasedStateDeterminationStrategy {
	/**
	 * The cached value of the '{@link #getTraceInferenceStrategy() <em>Trace Inference Strategy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceInferenceStrategy()
	 * @generated
	 * @ordered
	 */
	protected TraceInferenceStrategy traceInferenceStrategy = null;
	private List<Tag> lastTags;
	private Loader currentLoader;
	private ResponsibilityNode currentNode;
	private ComponentRole currentInstance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceBasedStateDeterminationStrategyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionstatePackage.eINSTANCE.getTraceBasedStateDeterminationStrategy();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceInferenceStrategy getTraceInferenceStrategy() {
		return traceInferenceStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTraceInferenceStrategy(TraceInferenceStrategy newTraceInferenceStrategy, NotificationChain msgs) {
		TraceInferenceStrategy oldTraceInferenceStrategy = traceInferenceStrategy;
		traceInferenceStrategy = newTraceInferenceStrategy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExecutionstatePackage.TRACE_BASED_STATE_DETERMINATION_STRATEGY__TRACE_INFERENCE_STRATEGY, oldTraceInferenceStrategy, newTraceInferenceStrategy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraceInferenceStrategy(TraceInferenceStrategy newTraceInferenceStrategy) {
		if (newTraceInferenceStrategy != traceInferenceStrategy) {
			NotificationChain msgs = null;
			if (traceInferenceStrategy != null)
				msgs = ((InternalEObject)traceInferenceStrategy).eInverseRemove(this, ExecutionstatePackage.TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY, TraceInferenceStrategy.class, msgs);
			if (newTraceInferenceStrategy != null)
				msgs = ((InternalEObject)newTraceInferenceStrategy).eInverseAdd(this, ExecutionstatePackage.TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY, TraceInferenceStrategy.class, msgs);
			msgs = basicSetTraceInferenceStrategy(newTraceInferenceStrategy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionstatePackage.TRACE_BASED_STATE_DETERMINATION_STRATEGY__TRACE_INFERENCE_STRATEGY, newTraceInferenceStrategy, newTraceInferenceStrategy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ExecutionstatePackage.TRACE_BASED_STATE_DETERMINATION_STRATEGY__TRACE_INFERENCE_STRATEGY:
					if (traceInferenceStrategy != null)
						msgs = ((InternalEObject)traceInferenceStrategy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExecutionstatePackage.TRACE_BASED_STATE_DETERMINATION_STRATEGY__TRACE_INFERENCE_STRATEGY, null, msgs);
					return basicSetTraceInferenceStrategy((TraceInferenceStrategy)otherEnd, msgs);
				default:
					return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
			}
		}
		if (eContainer != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ExecutionstatePackage.TRACE_BASED_STATE_DETERMINATION_STRATEGY__TRACE_INFERENCE_STRATEGY:
					return basicSetTraceInferenceStrategy(null, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionstatePackage.TRACE_BASED_STATE_DETERMINATION_STRATEGY__RESPONSIBILITY:
				if (resolve) return getResponsibility();
				return basicGetResponsibility();
			case ExecutionstatePackage.TRACE_BASED_STATE_DETERMINATION_STRATEGY__TRACE_INFERENCE_STRATEGY:
				return getTraceInferenceStrategy();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionstatePackage.TRACE_BASED_STATE_DETERMINATION_STRATEGY__RESPONSIBILITY:
				setResponsibility((Responsibility)newValue);
				return;
			case ExecutionstatePackage.TRACE_BASED_STATE_DETERMINATION_STRATEGY__TRACE_INFERENCE_STRATEGY:
				setTraceInferenceStrategy((TraceInferenceStrategy)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionstatePackage.TRACE_BASED_STATE_DETERMINATION_STRATEGY__RESPONSIBILITY:
				setResponsibility((Responsibility)null);
				return;
			case ExecutionstatePackage.TRACE_BASED_STATE_DETERMINATION_STRATEGY__TRACE_INFERENCE_STRATEGY:
				setTraceInferenceStrategy((TraceInferenceStrategy)null);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionstatePackage.TRACE_BASED_STATE_DETERMINATION_STRATEGY__RESPONSIBILITY:
				return responsibility != null;
			case ExecutionstatePackage.TRACE_BASED_STATE_DETERMINATION_STRATEGY__TRACE_INFERENCE_STRATEGY:
				return traceInferenceStrategy != null;
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * Delegate the actual state determination to the trace inference strategy
	 * @throws StateDeterminationException 
	 * @throws TraceLogManagerException 
	 */
	public Diagnostic getState(ResponsibilityNode node,
			Map engineContext, Loader loader) throws StateDeterminationException {
		this.currentLoader = loader;
		this.currentNode = node;
		this.currentInstance = (ComponentRole) engineContext.get(InterfaceContextInfo.INSTANCE);
		if (currentInstance == null)
			throw new StateDeterminationException("The given component instance can't be null");
		try {
			return getTraceInferenceStrategy().getState(node, engineContext);
		} catch (TraceLogManagerException e) {
			throw new StateDeterminationException(e);
		}
	}

	public List<Tag> getTags(TagFilter filter) {
		List<Tag> logTags = getAllTags();
		List<Tag> filteredTags = filterTags(logTags, filter);
		this.lastTags = filteredTags;
		return filteredTags;
	}

	/**
	 * @param tags
	 * @param filter
	 * @return
	 */
	private List<Tag> filterTags(List<Tag> tags, TagFilter filter) {
		if (filter == null)
			return tags;
		List<Tag> filteredTags = new LinkedList<Tag>();
		for (Tag tag: tags) {
			if (filter.accepts(tag))
				filteredTags.add(tag);
		}
		return filteredTags;
	}

	/**
	 * Combine the component scope filter with the provided custom filter
	 * @param filter
	 * @return
	 */
	private TagFilter combineScopeFilter(TagFilter filter) {
		TagFilter scopeFilter = getScopeFilter();
		if (scopeFilter == null)
			return filter;
		if (filter == null || filter instanceof org.isistan.flabot.engine.executionstate.tagfilter.AcceptAllFilter)
			return scopeFilter;
		List<TagFilter> filters = new ArrayList<TagFilter>(2);
		filters.add(scopeFilter);
		filters.add(filter);
		return new AndCompositeFilter(filters);
	}
	
	public TagFilter getScopeFilter() {
		Mapping mapping = getCurrentScope();
		if (mapping == null)
			return null;
		TagFilter scopeFilter = new ComponentScopeTagFilter(mapping);
		return scopeFilter;
	}
	
	public Mapping getCurrentScope() {
		if (currentInstance == null)
			throw new IllegalArgumentException("Current instance can't be null");
		ComponentModel component = currentInstance.getComponent();
		if (component == null)
			throw new IllegalArgumentException("Current instance's component can't be null");
		Mapping mapping = MappingManager.getMapping(component);
		return mapping;
	}

	/**
	 * @return
	 * @throws TraceLogManagerException
	 * @throws ContextCreationException 
	 */
	@SuppressWarnings("unchecked")
	public List<Tag> getAllTags() {
		TraceLog log = currentLoader.getTraceLog();
		if (log == null)
			return Collections.emptyList();
		List<Tag> logTags = Collections.<Tag>emptyList();
		String contextName = getContextName();
		for (Iterator iter = log.getContexts().iterator(); iter.hasNext();) {
			LogContext logContext = (LogContext) iter.next();
			if (contextName.equals(logContext.getName())) {
				logTags = logContext.getTags();
				break;
			}
		}
		TagFilter scopeFilter = getScopeFilter();
		List<Tag> filteredTags = filterTags(logTags, scopeFilter);
		return filteredTags;
	}

	public void registered(ResponsibilityRegistry registry, Responsibility responsibility, ComponentModel component, ComponentRole role) {
	}

	public void unregistered(ResponsibilityRegistry registry, Responsibility responsibility, ComponentModel component, ComponentRole role) {
	}

	public String getContextName() {
		return EObjectIdGenerator.getGeneratedEMFID(this);
	}
	
	public Context getContext() throws ContextCreationException {
		Context context = ConfigFactory.eINSTANCE.createContext();
		context.setName(getContextName());
		Responsibility responsibility= getCurrentResponsibility();
		BasicMappingBasedFilter filter = ExecutionstateFactory.eINSTANCE.createBasicMappingBasedFilter();
		Mapping mapping=MappingManager.getMapping(responsibility);
		if(mapping==null) {
			throw new ContextCreationException("Mapping not present for responsibility " + responsibility.getName());
		}
		LogFilter logFilter = LogFilterManager.getLogFilter(responsibility);
		if(logFilter==null) {
			throw new ContextCreationException("Log filter not present for responsibility " + responsibility.getName());
		}
		mapping=ScopeAwareMappingCreator.create(
				ScopeAwareMappingCreator.getScopes(
						(ComponentModel[]) responsibility.getComponents().toArray(new ComponentModel[responsibility.getComponents().size()])),
				mapping, new ObjectBoolean());
		if(mapping==null) {
			throw new ContextCreationException("Scope aware mapping couldn't be built for responsibility " + responsibility.getName());
		}
		
		filter.setMapping(mapping);
		filter.setLogFilter((LogFilter) EcoreUtil.copy(logFilter));
		
		context.setFilter(filter);
		return context;
	}
	
	private Responsibility getCurrentResponsibility() {
		if (currentNode != null)
			return currentNode.getResponsibility();
		return getResponsibility();
	}

	public List<Tag> getCorrelatedTags(List<Tag> tags, TagFilter filter, List<Tag> correlationTags, Correlator correlator) {
		List<Tag> originalTags = filterTags(tags, getScopeFilter());
		if (originalTags == null || originalTags.isEmpty())
			// the original tag list is empty, there's nothing to correlate
			return originalTags;
		List<Tag> correlatedTags = Collections.<Tag>emptyList();
		if (correlationTags != null && !correlationTags.isEmpty()) {
			Set<Tag> tagSet = new HashSet<Tag>();
			for (Tag correlationTag: correlationTags) {
				tagSet.addAll((correlator.correlate(originalTags, correlationTag)));
			}
			correlatedTags = new ArrayList<Tag>(tagSet);
		}
		correlatedTags = filterTags(correlatedTags, filter);
		// let the user refine the correlated tags
		correlatedTags = TagFilterDialogManager.INSTANCE.filterTags(
				"Select execution tags for responsibility " + this.getCurrentResponsibility().getName(),
				originalTags, correlatedTags, false);
		this.lastTags = correlatedTags;
		return correlatedTags;
	}

	public List<Tag> getLastTags() {
		return lastTags;
	}

	public TraceLog getCurrentLog() {
		return currentLoader.getTraceLog();
	}
	
	@Override
	public void checkMapping()
	{
		if (getTraceInferenceStrategy() != null)
		{
			getTraceInferenceStrategy().checkMapping(getResponsibility());
		}
	}
	
	@Override
	public void checkFilter()
	{
		if (getTraceInferenceStrategy() != null)
		{
			getTraceInferenceStrategy().checkFilter(getResponsibility());
		}
	}

} //TraceBasedStateDeterminationStrategyImpl
