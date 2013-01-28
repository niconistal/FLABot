/**
 * <copyright>
 * </copyright>
 *
 * $Id: StateDeterminationStrategyRegistryImpl.java,v 1.2 2006/02/03 21:03:07 dacostae Exp $
 */
package org.isistan.flabot.engine.executionstate.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;
import org.isistan.flabot.engine.executionstate.StateDeterminationStrategyRegistry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Determination Strategy Registry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.engine.executionstate.impl.StateDeterminationStrategyRegistryImpl#getRegistry <em>Registry</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateDeterminationStrategyRegistryImpl extends EObjectImpl implements StateDeterminationStrategyRegistry {
	/**
	 * The cached value of the '{@link #getRegistry() <em>Registry</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistry()
	 * @generated
	 * @ordered
	 */
	protected EMap registry = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateDeterminationStrategyRegistryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionstatePackage.eINSTANCE.getStateDeterminationStrategyRegistry();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getRegistry() {
		if (registry == null) {
			registry = new EcoreEMap(ExecutionstatePackage.eINSTANCE.getResponsibilityToStateDeterminationStrategyMapEntry(), ResponsibilityToStateDeterminationStrategyMapEntryImpl.class, this, ExecutionstatePackage.STATE_DETERMINATION_STRATEGY_REGISTRY__REGISTRY);
		}
		return registry;
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
				case ExecutionstatePackage.STATE_DETERMINATION_STRATEGY_REGISTRY__REGISTRY:
					return ((InternalEList)getRegistry()).basicRemove(otherEnd, msgs);
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
			case ExecutionstatePackage.STATE_DETERMINATION_STRATEGY_REGISTRY__REGISTRY:
				return getRegistry();
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
			case ExecutionstatePackage.STATE_DETERMINATION_STRATEGY_REGISTRY__REGISTRY:
				getRegistry().clear();
				getRegistry().addAll((Collection)newValue);
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
			case ExecutionstatePackage.STATE_DETERMINATION_STRATEGY_REGISTRY__REGISTRY:
				getRegistry().clear();
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
			case ExecutionstatePackage.STATE_DETERMINATION_STRATEGY_REGISTRY__REGISTRY:
				return registry != null && !registry.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

} //StateDeterminationStrategyRegistryImpl
