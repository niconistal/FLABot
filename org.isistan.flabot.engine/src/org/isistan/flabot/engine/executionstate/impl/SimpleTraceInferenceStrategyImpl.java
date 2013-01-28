/**
 * <copyright>
 * </copyright>
 *
 * $Id: SimpleTraceInferenceStrategyImpl.java,v 1.8 2006/03/15 02:37:00 mblech Exp $
 */
package org.isistan.flabot.engine.executionstate.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.engine.executionstate.Diagnostic;
import org.isistan.flabot.engine.executionstate.ExecutionState;
import org.isistan.flabot.engine.executionstate.ExecutionstateFactory;
import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;
import org.isistan.flabot.engine.executionstate.SimpleTraceInferenceStrategy;
import org.isistan.flabot.engine.executionstate.TraceBasedStateDeterminationStrategy;
import org.isistan.flabot.engine.executionstate.TraceLogManagerException;
import org.isistan.flabot.engine.executionstate.tagfilter.AcceptAllFilter;
import org.isistan.flabot.gauge.Gauge;
import org.isistan.flabot.trace.log.Tag;
import org.isistan.flabot.trace.log.tagquery.TagQueryUtil.TraceGeneratorConstants;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Trace Inference Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SimpleTraceInferenceStrategyImpl extends TraceInferenceStrategyImpl implements SimpleTraceInferenceStrategy {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleTraceInferenceStrategyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionstatePackage.eINSTANCE.getSimpleTraceInferenceStrategy();
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
				case ExecutionstatePackage.SIMPLE_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExecutionstatePackage.SIMPLE_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY, msgs);
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
				case ExecutionstatePackage.SIMPLE_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
					return eBasicSetContainer(null, ExecutionstatePackage.SIMPLE_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY, msgs);
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
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case ExecutionstatePackage.SIMPLE_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
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
	@Override
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionstatePackage.SIMPLE_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
				return getStateDeterminationStrategy();
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
			case ExecutionstatePackage.SIMPLE_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
				setStateDeterminationStrategy((TraceBasedStateDeterminationStrategy)newValue);
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
			case ExecutionstatePackage.SIMPLE_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
				setStateDeterminationStrategy((TraceBasedStateDeterminationStrategy)null);
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
			case ExecutionstatePackage.SIMPLE_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
				return getStateDeterminationStrategy() != null;
		}
		return eDynamicIsSet(eFeature);
	}

	public Diagnostic getState(ResponsibilityNode node, Map engineContext) throws TraceLogManagerException {
		List tags = getStateDeterminationStrategy().getTags(new AcceptAllFilter());
		Diagnostic diagnostic = ExecutionstateFactory.eINSTANCE.createDiagnostic();
		diagnostic.setDiagnostician(getStateDeterminationStrategy());
		diagnostic.setDescription("State determined using the simple trace inference strategy.");
		diagnostic.getAdditionalData().put(TraceBasedStateDeterminationStrategy.ANALYZED_TAGS_KEY, tags);
		if (tags == null || tags.size() == 0) {
			diagnostic.setState(ExecutionState.NOT_EXECUTED_LITERAL);
			return diagnostic;
		}
		for (Iterator iter = tags.iterator(); iter.hasNext();) {
			Tag tag = (Tag) iter.next();
			String eventType = tag.getProperty(TraceGeneratorConstants.EVENT_TYPE_PARAMETER_NAME);
			if (eventType != null && eventType.equals(Gauge.Type.ON_BEHAVIOR_ENTRY)) {
				String exitType = tag.getProperty(TraceGeneratorConstants.EXIT_EVENT_TYPE_PARAMETER_NAME);
				if (exitType == null || exitType.equals(Gauge.Type.ON_BEHAVIOR_ERROR.getName())) {
					diagnostic.setState(ExecutionState.FAULTY_LITERAL);
					return diagnostic;
				}
			}
		}
		diagnostic.setState(ExecutionState.EXECUTED_LITERAL);
		return diagnostic;
	}

} //SimpleTraceInferenceStrategyImpl
