/**
 * <copyright>
 * </copyright>
 *
 * $Id: TraceInferenceStrategyImpl.java,v 1.2 2006/02/03 21:03:07 dacostae Exp $
 */
package org.isistan.flabot.engine.executionstate.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;
import org.isistan.flabot.engine.executionstate.TraceBasedStateDeterminationStrategy;
import org.isistan.flabot.engine.executionstate.TraceInferenceStrategy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Inference Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.engine.executionstate.impl.TraceInferenceStrategyImpl#getStateDeterminationStrategy <em>State Determination Strategy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TraceInferenceStrategyImpl extends EObjectImpl implements TraceInferenceStrategy {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceInferenceStrategyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionstatePackage.eINSTANCE.getTraceInferenceStrategy();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceBasedStateDeterminationStrategy getStateDeterminationStrategy() {
		if (eContainerFeatureID != ExecutionstatePackage.TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY) return null;
		return (TraceBasedStateDeterminationStrategy)eContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateDeterminationStrategy(TraceBasedStateDeterminationStrategy newStateDeterminationStrategy) {
		if (newStateDeterminationStrategy != eContainer || (eContainerFeatureID != ExecutionstatePackage.TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY && newStateDeterminationStrategy != null)) {
			if (EcoreUtil.isAncestor(this, newStateDeterminationStrategy))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eContainer != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newStateDeterminationStrategy != null)
				msgs = ((InternalEObject)newStateDeterminationStrategy).eInverseAdd(this, ExecutionstatePackage.TRACE_BASED_STATE_DETERMINATION_STRATEGY__TRACE_INFERENCE_STRATEGY, TraceBasedStateDeterminationStrategy.class, msgs);
			msgs = eBasicSetContainer((InternalEObject)newStateDeterminationStrategy, ExecutionstatePackage.TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionstatePackage.TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY, newStateDeterminationStrategy, newStateDeterminationStrategy));
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
				case ExecutionstatePackage.TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExecutionstatePackage.TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY, msgs);
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
				case ExecutionstatePackage.TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
					return eBasicSetContainer(null, ExecutionstatePackage.TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY, msgs);
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
				case ExecutionstatePackage.TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
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
			case ExecutionstatePackage.TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
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
			case ExecutionstatePackage.TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
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
			case ExecutionstatePackage.TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
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
			case ExecutionstatePackage.TRACE_INFERENCE_STRATEGY__STATE_DETERMINATION_STRATEGY:
				return getStateDeterminationStrategy() != null;
		}
		return eDynamicIsSet(eFeature);
	}

	public void checkMapping(Responsibility responsibility)
	{
		//No check needed
	}
	
	public void checkFilter(Responsibility responsibility)
	{
		//No check needed
	}
	
} //TraceInferenceStrategyImpl
