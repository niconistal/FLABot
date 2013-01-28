/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.coremodel.Note;
import org.isistan.flabot.executionstatemapping.model.semantic.NotedElement;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;
import org.isistan.flabot.executionstatemapping.model.semantic.State;
import org.isistan.flabot.executionstatemapping.model.semantic.StateType;
import org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.StateImpl#getNotes <em>Notes</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.StateImpl#getSourceTransitionConditions <em>Source Transition Conditions</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.StateImpl#getTargetTransitionConditions <em>Target Transition Conditions</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.StateImpl#getStateType <em>State Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateImpl extends NamedElementImpl implements State
{
	/**
	 * The cached value of the '{@link #getNotes() <em>Notes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotes()
	 * @generated
	 * @ordered
	 */
	protected EList<Note> notes;

	protected static final String NAME_EDEFAULT = "NoNameState";
	
	/**
	 * The cached value of the '{@link #getSourceTransitionConditions() <em>Source Transition Conditions</em>}' reference list.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getSourceTransitionConditions()
	 * @generated
	 * @ordered
	 */
        protected EList<TransitionCondition> sourceTransitionConditions;

	/**
	 * The cached value of the '{@link #getTargetTransitionConditions() <em>Target Transition Conditions</em>}' reference list.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getTargetTransitionConditions()
	 * @generated
	 * @ordered
	 */
        protected EList<TransitionCondition> targetTransitionConditions;

	/**
	 * The default value of the '{@link #getStateType() <em>State Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateType()
	 * @generated
	 * @ordered
	 */
	protected static final StateType STATE_TYPE_EDEFAULT = StateType.INITIAL;

	/**
	 * The cached value of the '{@link #getStateType() <em>State Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateType()
	 * @generated
	 * @ordered
	 */
	protected StateType stateType = STATE_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        protected StateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        protected EClass eStaticClass() {
		return SemanticPackage.Literals.STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Note> getNotes() {
		if (notes == null) {
			notes = new EObjectResolvingEList<Note>(Note.class, this, SemanticPackage.STATE__NOTES);
		}
		return notes;
	}

	/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EList<TransitionCondition> getSourceTransitionConditions() {
		if (sourceTransitionConditions == null) {
			sourceTransitionConditions = new EObjectWithInverseResolvingEList<TransitionCondition>(TransitionCondition.class, this, SemanticPackage.STATE__SOURCE_TRANSITION_CONDITIONS, SemanticPackage.TRANSITION_CONDITION__SOURCE_STATE);
		}
		return sourceTransitionConditions;
	}

	/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EList<TransitionCondition> getTargetTransitionConditions() {
		if (targetTransitionConditions == null) {
			targetTransitionConditions = new EObjectWithInverseResolvingEList<TransitionCondition>(TransitionCondition.class, this, SemanticPackage.STATE__TARGET_TRANSITION_CONDITIONS, SemanticPackage.TRANSITION_CONDITION__TARGET_STATE);
		}
		return targetTransitionConditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateType getStateType() {
		return stateType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateType(StateType newStateType) {
		StateType oldStateType = stateType;
		stateType = newStateType == null ? STATE_TYPE_EDEFAULT : newStateType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.STATE__STATE_TYPE, oldStateType, stateType));
	}

	/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @SuppressWarnings("unchecked")
		@Override
								public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SemanticPackage.STATE__SOURCE_TRANSITION_CONDITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSourceTransitionConditions()).basicAdd(otherEnd, msgs);
			case SemanticPackage.STATE__TARGET_TRANSITION_CONDITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTargetTransitionConditions()).basicAdd(otherEnd, msgs);
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
			case SemanticPackage.STATE__SOURCE_TRANSITION_CONDITIONS:
				return ((InternalEList<?>)getSourceTransitionConditions()).basicRemove(otherEnd, msgs);
			case SemanticPackage.STATE__TARGET_TRANSITION_CONDITIONS:
				return ((InternalEList<?>)getTargetTransitionConditions()).basicRemove(otherEnd, msgs);
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
			case SemanticPackage.STATE__NOTES:
				return getNotes();
			case SemanticPackage.STATE__SOURCE_TRANSITION_CONDITIONS:
				return getSourceTransitionConditions();
			case SemanticPackage.STATE__TARGET_TRANSITION_CONDITIONS:
				return getTargetTransitionConditions();
			case SemanticPackage.STATE__STATE_TYPE:
				return getStateType();
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
			case SemanticPackage.STATE__NOTES:
				getNotes().clear();
				getNotes().addAll((Collection<? extends Note>)newValue);
				return;
			case SemanticPackage.STATE__SOURCE_TRANSITION_CONDITIONS:
				getSourceTransitionConditions().clear();
				getSourceTransitionConditions().addAll((Collection<? extends TransitionCondition>)newValue);
				return;
			case SemanticPackage.STATE__TARGET_TRANSITION_CONDITIONS:
				getTargetTransitionConditions().clear();
				getTargetTransitionConditions().addAll((Collection<? extends TransitionCondition>)newValue);
				return;
			case SemanticPackage.STATE__STATE_TYPE:
				setStateType((StateType)newValue);
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
			case SemanticPackage.STATE__NOTES:
				getNotes().clear();
				return;
			case SemanticPackage.STATE__SOURCE_TRANSITION_CONDITIONS:
				getSourceTransitionConditions().clear();
				return;
			case SemanticPackage.STATE__TARGET_TRANSITION_CONDITIONS:
				getTargetTransitionConditions().clear();
				return;
			case SemanticPackage.STATE__STATE_TYPE:
				setStateType(STATE_TYPE_EDEFAULT);
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
			case SemanticPackage.STATE__NOTES:
				return notes != null && !notes.isEmpty();
			case SemanticPackage.STATE__SOURCE_TRANSITION_CONDITIONS:
				return sourceTransitionConditions != null && !sourceTransitionConditions.isEmpty();
			case SemanticPackage.STATE__TARGET_TRANSITION_CONDITIONS:
				return targetTransitionConditions != null && !targetTransitionConditions.isEmpty();
			case SemanticPackage.STATE__STATE_TYPE:
				return stateType != STATE_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == NotedElement.class) {
			switch (derivedFeatureID) {
				case SemanticPackage.STATE__NOTES: return SemanticPackage.NOTED_ELEMENT__NOTES;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == NotedElement.class) {
			switch (baseFeatureID) {
				case SemanticPackage.NOTED_ELEMENT__NOTES: return SemanticPackage.STATE__NOTES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (stateType: ");
		result.append(stateType);
		result.append(')');
		return result.toString();
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
	
} //StateImpl