/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;
import org.isistan.flabot.executionstatemapping.model.semantic.State;
import org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.TransitionConditionImpl#getSourceState <em>Source State</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.TransitionConditionImpl#getTargetState <em>Target State</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.TransitionConditionImpl#getExecutionCondition <em>Execution Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionConditionImpl extends NotedElementImpl implements TransitionCondition
{
	/**
	 * The cached value of the '{@link #getSourceState() <em>Source State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceState()
	 * @generated
	 * @ordered
	 */
	protected State sourceState;
	/**
	 * The cached value of the '{@link #getTargetState() <em>Target State</em>}' reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getTargetState()
	 * @generated
	 * @ordered
	 */
        protected State targetState;

	/**
	 * The cached value of the '{@link #getExecutionCondition() <em>Execution Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionCondition()
	 * @generated
	 * @ordered
	 */
	protected ExecutionCondition executionCondition;
	/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        protected TransitionConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
								protected EClass eStaticClass() {
		return SemanticPackage.Literals.TRANSITION_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public State getSourceState() {
		if (sourceState != null && sourceState.eIsProxy()) {
			InternalEObject oldSourceState = (InternalEObject)sourceState;
			sourceState = (State)eResolveProxy(oldSourceState);
			if (sourceState != oldSourceState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SemanticPackage.TRANSITION_CONDITION__SOURCE_STATE, oldSourceState, sourceState));
			}
		}
		return sourceState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetSourceState() {
		return sourceState;
	}

	/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public NotificationChain basicSetSourceState(State newSourceState, NotificationChain msgs) {
		State oldSourceState = sourceState;
		sourceState = newSourceState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SemanticPackage.TRANSITION_CONDITION__SOURCE_STATE, oldSourceState, newSourceState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setSourceState(State newSourceState) {
		if (newSourceState != sourceState) {
			NotificationChain msgs = null;
			if (sourceState != null)
				msgs = ((InternalEObject)sourceState).eInverseRemove(this, SemanticPackage.STATE__SOURCE_TRANSITION_CONDITIONS, State.class, msgs);
			if (newSourceState != null)
				msgs = ((InternalEObject)newSourceState).eInverseAdd(this, SemanticPackage.STATE__SOURCE_TRANSITION_CONDITIONS, State.class, msgs);
			msgs = basicSetSourceState(newSourceState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.TRANSITION_CONDITION__SOURCE_STATE, newSourceState, newSourceState));
	}

	/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public State getTargetState() {
		if (targetState != null && targetState.eIsProxy()) {
			InternalEObject oldTargetState = (InternalEObject)targetState;
			targetState = (State)eResolveProxy(oldTargetState);
			if (targetState != oldTargetState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SemanticPackage.TRANSITION_CONDITION__TARGET_STATE, oldTargetState, targetState));
			}
		}
		return targetState;
	}

	/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public State basicGetTargetState() {
		return targetState;
	}

	/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public NotificationChain basicSetTargetState(State newTargetState, NotificationChain msgs) {
		State oldTargetState = targetState;
		targetState = newTargetState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SemanticPackage.TRANSITION_CONDITION__TARGET_STATE, oldTargetState, newTargetState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setTargetState(State newTargetState) {
		if (newTargetState != targetState) {
			NotificationChain msgs = null;
			if (targetState != null)
				msgs = ((InternalEObject)targetState).eInverseRemove(this, SemanticPackage.STATE__TARGET_TRANSITION_CONDITIONS, State.class, msgs);
			if (newTargetState != null)
				msgs = ((InternalEObject)newTargetState).eInverseAdd(this, SemanticPackage.STATE__TARGET_TRANSITION_CONDITIONS, State.class, msgs);
			msgs = basicSetTargetState(newTargetState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.TRANSITION_CONDITION__TARGET_STATE, newTargetState, newTargetState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionCondition getExecutionCondition() {
		if (executionCondition != null && executionCondition.eIsProxy()) {
			InternalEObject oldExecutionCondition = (InternalEObject)executionCondition;
			executionCondition = (ExecutionCondition)eResolveProxy(oldExecutionCondition);
			if (executionCondition != oldExecutionCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SemanticPackage.TRANSITION_CONDITION__EXECUTION_CONDITION, oldExecutionCondition, executionCondition));
			}
		}
		return executionCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionCondition basicGetExecutionCondition() {
		return executionCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutionCondition(ExecutionCondition newExecutionCondition) {
		ExecutionCondition oldExecutionCondition = executionCondition;
		executionCondition = newExecutionCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.TRANSITION_CONDITION__EXECUTION_CONDITION, oldExecutionCondition, executionCondition));
	}

	/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
								public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SemanticPackage.TRANSITION_CONDITION__SOURCE_STATE:
				if (sourceState != null)
					msgs = ((InternalEObject)sourceState).eInverseRemove(this, SemanticPackage.STATE__SOURCE_TRANSITION_CONDITIONS, State.class, msgs);
				return basicSetSourceState((State)otherEnd, msgs);
			case SemanticPackage.TRANSITION_CONDITION__TARGET_STATE:
				if (targetState != null)
					msgs = ((InternalEObject)targetState).eInverseRemove(this, SemanticPackage.STATE__TARGET_TRANSITION_CONDITIONS, State.class, msgs);
				return basicSetTargetState((State)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
								public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SemanticPackage.TRANSITION_CONDITION__SOURCE_STATE:
				return basicSetSourceState(null, msgs);
			case SemanticPackage.TRANSITION_CONDITION__TARGET_STATE:
				return basicSetTargetState(null, msgs);
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
			case SemanticPackage.TRANSITION_CONDITION__SOURCE_STATE:
				if (resolve) return getSourceState();
				return basicGetSourceState();
			case SemanticPackage.TRANSITION_CONDITION__TARGET_STATE:
				if (resolve) return getTargetState();
				return basicGetTargetState();
			case SemanticPackage.TRANSITION_CONDITION__EXECUTION_CONDITION:
				if (resolve) return getExecutionCondition();
				return basicGetExecutionCondition();
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
			case SemanticPackage.TRANSITION_CONDITION__SOURCE_STATE:
				setSourceState((State)newValue);
				return;
			case SemanticPackage.TRANSITION_CONDITION__TARGET_STATE:
				setTargetState((State)newValue);
				return;
			case SemanticPackage.TRANSITION_CONDITION__EXECUTION_CONDITION:
				setExecutionCondition((ExecutionCondition)newValue);
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
			case SemanticPackage.TRANSITION_CONDITION__SOURCE_STATE:
				setSourceState((State)null);
				return;
			case SemanticPackage.TRANSITION_CONDITION__TARGET_STATE:
				setTargetState((State)null);
				return;
			case SemanticPackage.TRANSITION_CONDITION__EXECUTION_CONDITION:
				setExecutionCondition((ExecutionCondition)null);
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
			case SemanticPackage.TRANSITION_CONDITION__SOURCE_STATE:
				return sourceState != null;
			case SemanticPackage.TRANSITION_CONDITION__TARGET_STATE:
				return targetState != null;
			case SemanticPackage.TRANSITION_CONDITION__EXECUTION_CONDITION:
				return executionCondition != null;
		}
		return super.eIsSet(featureID);
	}

} //TransitionConditionImpl