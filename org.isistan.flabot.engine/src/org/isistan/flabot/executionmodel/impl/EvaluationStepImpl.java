/**
 * <copyright>
 * </copyright>
 *
 * $Id: EvaluationStepImpl.java,v 1.2 2006/03/22 03:28:55 franco Exp $
 */
package org.isistan.flabot.executionmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.executionmodel.EvaluationStep;
import org.isistan.flabot.executionmodel.ExecutionmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Evaluation Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.EvaluationStepImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.EvaluationStepImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.EvaluationStepImpl#getCurrentFamily <em>Current Family</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.EvaluationStepImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EvaluationStepImpl extends EObjectImpl implements EvaluationStep {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected SimplePathNode source = null;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected SimplePathNode target = null;

	/**
	 * The default value of the '{@link #getCurrentFamily() <em>Current Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentFamily()
	 * @generated
	 * @ordered
	 */
	protected static final String CURRENT_FAMILY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCurrentFamily() <em>Current Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentFamily()
	 * @generated
	 * @ordered
	 */
	protected String currentFamily = CURRENT_FAMILY_EDEFAULT;

	/**
	 * The default value of the '{@link #getCondition() <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected static final String CONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected String condition = CONDITION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EvaluationStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExecutionmodelPackage.eINSTANCE.getEvaluationStep();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode getSource() {
		if (source != null && source.eIsProxy()) {
			SimplePathNode oldSource = source;
			source = (SimplePathNode)eResolveProxy((InternalEObject)source);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionmodelPackage.EVALUATION_STEP__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(SimplePathNode newSource) {
		SimplePathNode oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EVALUATION_STEP__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode getTarget() {
		if (target != null && target.eIsProxy()) {
			SimplePathNode oldTarget = target;
			target = (SimplePathNode)eResolveProxy((InternalEObject)target);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionmodelPackage.EVALUATION_STEP__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(SimplePathNode newTarget) {
		SimplePathNode oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EVALUATION_STEP__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCurrentFamily() {
		return currentFamily;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentFamily(String newCurrentFamily) {
		String oldCurrentFamily = currentFamily;
		currentFamily = newCurrentFamily;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EVALUATION_STEP__CURRENT_FAMILY, oldCurrentFamily, currentFamily));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(String newCondition) {
		String oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EVALUATION_STEP__CONDITION, oldCondition, condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionmodelPackage.EVALUATION_STEP__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case ExecutionmodelPackage.EVALUATION_STEP__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case ExecutionmodelPackage.EVALUATION_STEP__CURRENT_FAMILY:
				return getCurrentFamily();
			case ExecutionmodelPackage.EVALUATION_STEP__CONDITION:
				return getCondition();
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
			case ExecutionmodelPackage.EVALUATION_STEP__SOURCE:
				setSource((SimplePathNode)newValue);
				return;
			case ExecutionmodelPackage.EVALUATION_STEP__TARGET:
				setTarget((SimplePathNode)newValue);
				return;
			case ExecutionmodelPackage.EVALUATION_STEP__CURRENT_FAMILY:
				setCurrentFamily((String)newValue);
				return;
			case ExecutionmodelPackage.EVALUATION_STEP__CONDITION:
				setCondition((String)newValue);
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
			case ExecutionmodelPackage.EVALUATION_STEP__SOURCE:
				setSource((SimplePathNode)null);
				return;
			case ExecutionmodelPackage.EVALUATION_STEP__TARGET:
				setTarget((SimplePathNode)null);
				return;
			case ExecutionmodelPackage.EVALUATION_STEP__CURRENT_FAMILY:
				setCurrentFamily(CURRENT_FAMILY_EDEFAULT);
				return;
			case ExecutionmodelPackage.EVALUATION_STEP__CONDITION:
				setCondition(CONDITION_EDEFAULT);
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
			case ExecutionmodelPackage.EVALUATION_STEP__SOURCE:
				return source != null;
			case ExecutionmodelPackage.EVALUATION_STEP__TARGET:
				return target != null;
			case ExecutionmodelPackage.EVALUATION_STEP__CURRENT_FAMILY:
				return CURRENT_FAMILY_EDEFAULT == null ? currentFamily != null : !CURRENT_FAMILY_EDEFAULT.equals(currentFamily);
			case ExecutionmodelPackage.EVALUATION_STEP__CONDITION:
				return CONDITION_EDEFAULT == null ? condition != null : !CONDITION_EDEFAULT.equals(condition);
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
		result.append(" (currentFamily: ");
		result.append(currentFamily);
		result.append(", condition: ");
		result.append(condition);
		result.append(')');
		return result.toString();
	}

} //EvaluationStepImpl
