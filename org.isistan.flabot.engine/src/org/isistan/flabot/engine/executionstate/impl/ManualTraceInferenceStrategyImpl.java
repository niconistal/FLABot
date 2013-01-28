/**
 * <copyright>
 * </copyright>
 *
 * $Id: ManualTraceInferenceStrategyImpl.java,v 1.13 2006/03/22 03:28:54 franco Exp $
 */
package org.isistan.flabot.engine.executionstate.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.swt.widgets.Shell;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.engine.dialogs.ResponsibilityExecutionStateDialog;
import org.isistan.flabot.engine.executionstate.Diagnostic;
import org.isistan.flabot.engine.executionstate.ExecutionState;
import org.isistan.flabot.engine.executionstate.ExecutionstateFactory;
import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;
import org.isistan.flabot.engine.executionstate.ManualTraceInferenceStrategy;
import org.isistan.flabot.engine.executionstate.TraceBasedStateDeterminationStrategy;
import org.isistan.flabot.engine.executionstate.TraceLogManagerException;
import org.isistan.flabot.engine.executionstate.tagfilter.AcceptAllFilter;
import org.isistan.flabot.trace.TagTreeModel;
import org.isistan.flabot.trace.log.LogFactory;
import org.isistan.flabot.trace.log.Tag;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Manual Trace Inference Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ManualTraceInferenceStrategyImpl extends TraceInferenceStrategyImpl implements ManualTraceInferenceStrategy {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ManualTraceInferenceStrategyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionstatePackage.eINSTANCE.getManualTraceInferenceStrategy();
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
				case ExecutionstatePackage.MANUAL_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExecutionstatePackage.MANUAL_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY, msgs);
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
				case ExecutionstatePackage.MANUAL_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
					return eBasicSetContainer(null, ExecutionstatePackage.MANUAL_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY, msgs);
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
				case ExecutionstatePackage.MANUAL_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
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
			case ExecutionstatePackage.MANUAL_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
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
			case ExecutionstatePackage.MANUAL_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
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
			case ExecutionstatePackage.MANUAL_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
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
			case ExecutionstatePackage.MANUAL_TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
				return getStateDeterminationStrategy() != null;
		}
		return eDynamicIsSet(eFeature);
	}

	public Diagnostic getState(ResponsibilityNode node, Map engineContext) throws TraceLogManagerException {
		List tags = getStateDeterminationStrategy().getTags(new AcceptAllFilter());
		Shell shell = FlabotPlugin.getDefault().getWorkbench().getDisplay().getActiveShell();
		
		Tag rootTag = LogFactory.eINSTANCE.createTag();
		int i = 0;
		for (Iterator iter = tags.iterator(); iter.hasNext();) {
			Tag tag = (Tag) iter.next();
			rootTag.getTags().put(Integer.toString(i), tag);
			i++;
		}
		
		TagTreeModel.show("<TITLE HERE>", "root", rootTag);
		
		//Opens a dialog so the user can select a state
		ResponsibilityExecutionStateDialog aDialog  = new ResponsibilityExecutionStateDialog(new Shell());
		aDialog.setExecutionInfo(node, engineContext);			
		ExecutionState state = aDialog.getSelectedExecutionState(ExecutionState.NOT_EXECUTED_LITERAL);
		
		Diagnostic diagnostic = ExecutionstateFactory.eINSTANCE.createDiagnostic();
		diagnostic.setDiagnostician(getStateDeterminationStrategy());
		diagnostic.setDescription("State determined manually by the user by seeing the trace log.");
		diagnostic.setState(state);
		diagnostic.getAdditionalData().put(TraceBasedStateDeterminationStrategy.ANALYZED_TAGS_KEY, tags);
		return diagnostic;
	}

} //ManualTraceInferenceStrategyImpl
