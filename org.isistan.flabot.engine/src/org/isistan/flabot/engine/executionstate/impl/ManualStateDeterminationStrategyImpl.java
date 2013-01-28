/**
 * <copyright>
 * </copyright>
 *
 * $Id: ManualStateDeterminationStrategyImpl.java,v 1.15 2006/03/22 03:28:54 franco Exp $
 */
package org.isistan.flabot.engine.executionstate.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.Workbench;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.ResponsibilityRegistry;
import org.isistan.flabot.engine.Loader;
import org.isistan.flabot.engine.dialogs.ResponsibilityExecutionStateDialog;
import org.isistan.flabot.engine.executionstate.Diagnostic;
import org.isistan.flabot.engine.executionstate.ExecutionState;
import org.isistan.flabot.engine.executionstate.ExecutionstateFactory;
import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;
import org.isistan.flabot.engine.executionstate.ManualStateDeterminationStrategy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Manual State Determination Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ManualStateDeterminationStrategyImpl extends StateDeterminationStrategyImpl implements ManualStateDeterminationStrategy {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ManualStateDeterminationStrategyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionstatePackage.eINSTANCE.getManualStateDeterminationStrategy();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionstatePackage.MANUAL_STATE_DETERMINATION_STRATEGY__RESPONSIBILITY:
				if (resolve) return getResponsibility();
				return basicGetResponsibility();
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
			case ExecutionstatePackage.MANUAL_STATE_DETERMINATION_STRATEGY__RESPONSIBILITY:
				setResponsibility((Responsibility)newValue);
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
			case ExecutionstatePackage.MANUAL_STATE_DETERMINATION_STRATEGY__RESPONSIBILITY:
				setResponsibility((Responsibility)null);
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
			case ExecutionstatePackage.MANUAL_STATE_DETERMINATION_STRATEGY__RESPONSIBILITY:
				return responsibility != null;
		}
		return eDynamicIsSet(eFeature);
	}

	private class GetStateRunnable implements Runnable {
		private ResponsibilityNode node;
		private Map engineContext;
		private ExecutionState executionState;
		
		public GetStateRunnable(ResponsibilityNode node, Map engineContext) {
			this.node = node;
			this.engineContext = engineContext;
		}
		
		public void run() {
			//Opens a dialog so the user can select a state
			ResponsibilityExecutionStateDialog aDialog  = new ResponsibilityExecutionStateDialog(new Shell());
			aDialog.setExecutionInfo(node, engineContext);			
			executionState = aDialog.getSelectedExecutionState(ExecutionState.NOT_EXECUTED_LITERAL);
		}
		
		public ExecutionState getExecutionState() {
			return executionState;
		}
		
	}

	public Diagnostic getState(ResponsibilityNode node,
			Map engineContext, Loader loader) {
		GetStateRunnable getStateRunnable = new GetStateRunnable(node, engineContext);
		Workbench.getInstance().getDisplay().syncExec(getStateRunnable);
		ExecutionState state = getStateRunnable.getExecutionState();
		Diagnostic diagnostic = ExecutionstateFactory.eINSTANCE.createDiagnostic();
		diagnostic.setState(state);
		diagnostic.setDiagnostician(this);
		diagnostic.setDescription("User-selected execution state.");
		return diagnostic;
	}

	public void registered(ResponsibilityRegistry registry, Responsibility responsibility, ComponentModel component, ComponentRole role) {
		// do nothing because this strategy needs no initialization
	}

	public void unregistered(ResponsibilityRegistry registry, Responsibility responsibility, ComponentModel component, ComponentRole role) {
		// do nothing because this strategy needs no initialization
	}
	
} //ManualStateDeterminationStrategyImpl
