/**
 * <copyright>
 * </copyright>
 *
 * $Id: JavalogTraceInferenceStrategyImpl.java,v 1.17 2006/05/03 02:44:51 mblech Exp $
 */
package org.isistan.flabot.engine.executionstate.javalogtrace.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.swt.widgets.Shell;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.engine.EnginePlugin;
import org.isistan.flabot.engine.InterfaceContextInfo;
import org.isistan.flabot.engine.dialogs.ResponsibilityExecutionStateDialog;
import org.isistan.flabot.engine.executionstate.Diagnostic;
import org.isistan.flabot.engine.executionstate.ExecutionState;
import org.isistan.flabot.engine.executionstate.ExecutionstateFactory;
import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;
import org.isistan.flabot.engine.executionstate.StateDeterminationException;
import org.isistan.flabot.engine.executionstate.TraceBasedStateDeterminationStrategy;
import org.isistan.flabot.engine.executionstate.TraceLogManagerException;
import org.isistan.flabot.engine.executionstate.impl.TraceInferenceStrategyImpl;
import org.isistan.flabot.engine.executionstate.javalogtrace.DefaultLogQueryPredicates;
import org.isistan.flabot.engine.executionstate.javalogtrace.JavalogTraceInferenceStrategy;
import org.isistan.flabot.engine.executionstate.javalogtrace.JavalogtracePackage;
import org.isistan.flabot.engine.executionstate.javalogtrace.LogQueryPredicates;
import org.isistan.flabot.engine.executionstate.javalogtrace.TraceInferenceJavalogEngine;
import org.isistan.flabot.engine.executionstate.javalogtrace.TraceInferenceJavalogEngineLocator;
import org.isistan.flabot.mapping.mappingmodel.Mapping;
import org.isistan.flabot.trace.log.Tag;
import org.isistan.flabot.util.javalog.JavalogUtil;
import org.isistan.flabot.util.locator.ComponentLocatorException;

import JavaLog.LogicKnowledge;
import JavaLog.PlClause;
import JavaLog.PlException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Javalog Trace Inference Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.engine.executionstate.javalogtrace.impl.JavalogTraceInferenceStrategyImpl#getPrologCode <em>Prolog Code</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavalogTraceInferenceStrategyImpl extends TraceInferenceStrategyImpl implements JavalogTraceInferenceStrategy {
	/**
	 * @author usuario
	 *
	 */
	public class AcceptAllMapping {

	}

	/**
	 * The default value of the '{@link #getPrologCode() <em>Prolog Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrologCode()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String PROLOG_CODE_EDEFAULT =
		"executionState(\'Faulty\') :-\n\texecutionTag(T), isExitError(T).\n\n" +
		"executionState(\'Executed\') :-\n\texecutionTag(_).\n\n" +
		"executionState(\'NotExecuted\').";

	/**
	 * The cached value of the '{@link #getPrologCode() <em>Prolog Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrologCode()
	 * @generated
	 * @ordered
	 */
	protected String prologCode = PROLOG_CODE_EDEFAULT;

	private TraceInferenceJavalogEngine oldEngine;

	private LogicKnowledge knowledge;

	private LogQueryPredicates logQueryPredicates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavalogTraceInferenceStrategyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return JavalogtracePackage.eINSTANCE.getJavalogTraceInferenceStrategy();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrologCode() {
		return prologCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrologCode(String newPrologCode) {
		String oldPrologCode = prologCode;
		prologCode = newPrologCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavalogtracePackage.JAVALOG_TRACE_INFERENCE_STRATEGY__PROLOG_CODE, oldPrologCode, prologCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case JavalogtracePackage.JAVALOG_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, JavalogtracePackage.JAVALOG_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY, msgs);
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case JavalogtracePackage.JAVALOG_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
					return eBasicSetContainer(null, JavalogtracePackage.JAVALOG_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY, msgs);
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
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case JavalogtracePackage.JAVALOG_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
					return eContainer.eInverseRemove(this, ExecutionstatePackage.TRACE_BASED_STATE_DETERMINATION_STRATEGY__TRACE_INFERENCE_STRATEGY, TraceBasedStateDeterminationStrategy.class, msgs);
				default:
					return eDynamicBasicRemoveFromContainer(msgs);
			}
		}
		return eContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case JavalogtracePackage.JAVALOG_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
				return getStateDeterminationStrategy();
			case JavalogtracePackage.JAVALOG_TRACE_INFERENCE_STRATEGY__PROLOG_CODE:
				return getPrologCode();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case JavalogtracePackage.JAVALOG_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
				setStateDeterminationStrategy((TraceBasedStateDeterminationStrategy)newValue);
				return;
			case JavalogtracePackage.JAVALOG_TRACE_INFERENCE_STRATEGY__PROLOG_CODE:
				setPrologCode((String)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case JavalogtracePackage.JAVALOG_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
				setStateDeterminationStrategy((TraceBasedStateDeterminationStrategy)null);
				return;
			case JavalogtracePackage.JAVALOG_TRACE_INFERENCE_STRATEGY__PROLOG_CODE:
				setPrologCode(PROLOG_CODE_EDEFAULT);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case JavalogtracePackage.JAVALOG_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
				return getStateDeterminationStrategy() != null;
			case JavalogtracePackage.JAVALOG_TRACE_INFERENCE_STRATEGY__PROLOG_CODE:
				return PROLOG_CODE_EDEFAULT == null ? prologCode != null : !PROLOG_CODE_EDEFAULT.equals(prologCode);
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (prologCode: ");
		result.append(prologCode);
		result.append(')');
		return result.toString();
	}

	public Diagnostic getState(ResponsibilityNode node, Map engineContext) throws StateDeterminationException, TraceLogManagerException {
		try {
			// extract the responsibility id parameter
			String responsibilityId = JavalogUtil.INSTANCE.escapePrologString(node.getID());
			if (responsibilityId == null)
				responsibilityId = "";
			
			// extract the previous responsibility id parameter
			String preResponsibilityId =
				(String) engineContext.get(InterfaceContextInfo.PRE_RESPONSIBILITY);
			if (preResponsibilityId == null)
				preResponsibilityId = "";
			
			// extract the event parameter
			String eventId = (String) engineContext.get(InterfaceContextInfo.EVENT);
			
			// show tags before state determination TODO remove this, it's for debugging purposes only
			List<Tag> tagListBefore = getStateDeterminationStrategy().getAllTags();
		/*	TagFilterDialogManager.INSTANCE.filterTags(
					"Unfiltered tags for responsibility: " + node.getName(),
					tagListBefore, Collections.<Tag>emptyList());*/

			String stateString = queryState(node, responsibilityId,
					preResponsibilityId, eventId);
			
			// show tags after state determination TODO remove this, it's for debugging purposes only
			List<Tag> tagListAfter = getStateDeterminationStrategy().getLastTags();
/*			TagFilterDialogManager.INSTANCE.filterTags(
					"Analyzed tags for responsibility: " + node.getName(),
					tagListAfter, Collections.<Tag>emptyList());*/
			
			if (stateString == null)
				throw new StateDeterminationException(
				"Couldn't determine state because the prolog query returned null");

			ExecutionState state = ExecutionState.get(stateString);
			if (state == null)
				throw new StateDeterminationException(
						"Couldn't determine state because the prolog query returned an " +
						"unknown state string: \"" + stateString + "\"");
			// execution state converted
			
			Diagnostic diagnostic = ExecutionstateFactory.eINSTANCE.createDiagnostic();
			diagnostic.setState(state);
			diagnostic.setDiagnostician(this.getStateDeterminationStrategy());
			diagnostic.setDescription("State determined using the javalog-based trace inference strategy");
			
			List<Tag> tags = getStateDeterminationStrategy().getLastTags();
			diagnostic.getAdditionalData().put(TraceBasedStateDeterminationStrategy.ANALYZED_TAGS_KEY, tags);
			
			ResponsibilityExecutionStateDialog dialog = new ResponsibilityExecutionStateDialog(new Shell());
			
			dialog.setExecutionInfo(node, engineContext);
			dialog.setDiagnosticInfo(diagnostic, tagListBefore, tagListAfter);
			diagnostic.setState( dialog.run(diagnostic.getState()) );	
			
			return diagnostic;
			
		} catch (ComponentLocatorException e) {
			throw new StateDeterminationException(
					"Exception trying to locate the TraceInferenceJavalogEngine",
					e);
		} catch (PlException e) {
			throw new StateDeterminationException(
					"Exception querying the javalog engine for the execution state",
					e);
		}
	}
	
	/**
	 * Execute the prolog query to obtain the execution state
	 * @param node the responsibility node
	 * @param responsibilityId the current responsibility id
	 * @param preResponsibilityId the previous responsibility id
	 * @param eventId the event id
	 * @return the result of the prolog state query (a String)
	 * @throws ComponentLocatorException
	 * @throws TraceLogManagerException
	 * @throws PlException
	 * @throws StateDeterminationException
	 */
	private String queryState(ResponsibilityNode node, String responsibilityId, String preResponsibilityId, String eventId) throws ComponentLocatorException, TraceLogManagerException, PlException{
		// get the javalog engine
		TraceInferenceJavalogEngine engine = getEngine();
		
		// enable this strategy's knowledge
		knowledge.enable();
		
		// retract the cached tags
		engine.executeQuery("retract(cachedCorrelatedTags('" + responsibilityId + "', _)).");
		
		// overwrite the responsibility's current scope
		engine.executeQuery("retract(scope('" + responsibilityId + "', _)).");
		Mapping currentScope = getStateDeterminationStrategy().getCurrentScope();
		if (currentScope == null) {
			engine.getBrain()
				.answerQuery("assert(scope('" + responsibilityId + "', null)).");
		}
		else {
			engine.getBrain()
				.answerQuery("assert(scope('" + responsibilityId + "', $0)).",
						new Object[]{currentScope});
		}
		
		// query the engine
		Object stateAtom =
			engine.executeQuery("executionState($0, $1, $2, $3, State).",
					new Object[]{getLogQueryPredicates(engine),
						responsibilityId, preResponsibilityId, eventId},
					"State");
		
		// diable this strategy's knowledge
		knowledge.disable();
		
		// transform query result to an ExecutionState instance
		if (stateAtom == null)
			return null;
		
		return JavalogUtil.INSTANCE.escapePrologString(stateAtom.toString());
	}

	/**
	 * Get the log query predicates
	 * @return
	 */
	private LogQueryPredicates getLogQueryPredicates(TraceInferenceJavalogEngine engine) {
		if (logQueryPredicates == null || logQueryPredicates.getEngine() != engine) {
			logQueryPredicates = new DefaultLogQueryPredicates(
					EnginePlugin.getDefault().getWorkbench().getDisplay(),
					this, engine);
		}
		return logQueryPredicates;
	}

	/**
	 * Locate the engine, initialize it and the logic knowledge, and then return it
	 * @return the engine
	 * @throws ComponentLocatorException
	 * @throws TraceLogManagerException
	 * @throws PlException
	 * @throws StateDeterminationException 
	 */
	private TraceInferenceJavalogEngine getEngine() throws ComponentLocatorException, TraceLogManagerException, PlException {
		// locate the engine
		TraceInferenceJavalogEngine engine = (TraceInferenceJavalogEngine)
			FlabotPlugin.getDefault().getComponentLocatorManager().getComponent(
					TraceInferenceJavalogEngineLocator.LOCATOR_ID,
					Collections.singletonMap(
							TraceInferenceJavalogEngineLocator.PARAMETER_TRACE_LOG,
							getStateDeterminationStrategy().getCurrentLog()
							)
					);
		if (oldEngine == null)
			oldEngine = engine;
		
		// add this strategy's prolog code as a logic knowledge
		if (knowledge == null || oldEngine != engine) {
			knowledge = new LogicKnowledge(engine.getBrain(), "");
			// add prolog code clause by clause
			String prologCode = getPrologCode();
			List<String> prologClauses = JavalogUtil.INSTANCE.splitClauses(prologCode);
			for (String prologClauseString: prologClauses) {
				PlClause clause = JavalogUtil.INSTANCE.mkClause(engine.getBrain().parser().eQuery(prologClauseString));
				if (clause == null)
					throw new PlException("Error parsing prolog clause:\n\"" + prologClauseString + "\"");
				knowledge.add(clause);
			}
			
			engine.getBrain().addKnowledge(knowledge);
			oldEngine = engine;
		}
		return engine;
	}

} //JavalogTraceInferenceStrategyImpl
