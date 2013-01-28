/**
 * <copyright>
 * </copyright>
 *
 * $Id: StateFromMappingStateDeterminationStrategyImpl.java,v 1.3 2006/04/13 01:45:45 apersson Exp $
 */
package org.isistan.flabot.engine.executionstate.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.ResponsibilityRegistry;
import org.isistan.flabot.engine.Loader;
import org.isistan.flabot.engine.executionstate.Diagnostic;
import org.isistan.flabot.engine.executionstate.ExecutionState;
import org.isistan.flabot.engine.executionstate.ExecutionstateFactory;
import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;
import org.isistan.flabot.engine.executionstate.StateDeterminationException;
import org.isistan.flabot.engine.executionstate.StateFromMappingStateDeterminationStrategy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State From Mapping State Determination Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class StateFromMappingStateDeterminationStrategyImpl extends StateDeterminationStrategyImpl implements StateFromMappingStateDeterminationStrategy {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateFromMappingStateDeterminationStrategyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExecutionstatePackage.eINSTANCE.getStateFromMappingStateDeterminationStrategy();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionstatePackage.STATE_FROM_MAPPING_STATE_DETERMINATION_STRATEGY__RESPONSIBILITY:
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
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionstatePackage.STATE_FROM_MAPPING_STATE_DETERMINATION_STRATEGY__RESPONSIBILITY:
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
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionstatePackage.STATE_FROM_MAPPING_STATE_DETERMINATION_STRATEGY__RESPONSIBILITY:
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
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionstatePackage.STATE_FROM_MAPPING_STATE_DETERMINATION_STRATEGY__RESPONSIBILITY:
				return responsibility != null;
		}
		return eDynamicIsSet(eFeature);
	}

	public Diagnostic getState(ResponsibilityNode node, Map engineContext, Loader loader) throws StateDeterminationException {
		Diagnostic diagnostic = ExecutionstateFactory.eINSTANCE.createDiagnostic();
		diagnostic.setDiagnostician(this);
	//	diagnostic.setDescription(mapping.id);
		ExecutionState stateFromMappingState = ExecutionState.STATE_FROM_MAPPING_LITERAL;
		diagnostic.setState(stateFromMappingState);
		return diagnostic;
	}

	public void registered(ResponsibilityRegistry registry, Responsibility responsibility, ComponentModel component, ComponentRole role) {
		// TODO Auto-generated method stub
		
	}

	public void unregistered(ResponsibilityRegistry registry, Responsibility responsibility, ComponentModel component, ComponentRole role) {
		// TODO Auto-generated method stub
		
	}

} //StateFromMappingStateDeterminationStrategyImpl
