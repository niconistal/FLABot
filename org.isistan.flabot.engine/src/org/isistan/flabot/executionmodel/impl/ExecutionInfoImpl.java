/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExecutionInfoImpl.java,v 1.12 2006/03/29 00:55:37 franco Exp $
 */
package org.isistan.flabot.executionmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.engine.executionstate.Diagnostic;
import org.isistan.flabot.executionmodel.Dependency;
import org.isistan.flabot.executionmodel.EvaluationStep;
import org.isistan.flabot.executionmodel.ExecutionContext;
import org.isistan.flabot.executionmodel.ExecutionInfo;
import org.isistan.flabot.executionmodel.ExecutionStep;
import org.isistan.flabot.executionmodel.ExecutionmodelFactory;
import org.isistan.flabot.executionmodel.ExecutionmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionInfoImpl#getExecutionSteps <em>Execution Steps</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionInfoImpl extends EObjectImpl implements ExecutionInfo {
	/**
	 * The cached value of the '{@link #getExecutionSteps() <em>Execution Steps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionSteps()
	 * @generated
	 * @ordered
	 */
	protected EList executionSteps = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionmodelPackage.eINSTANCE.getExecutionInfo();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getExecutionSteps() {
		if (executionSteps == null) {
			executionSteps = new EObjectContainmentEList(ExecutionStep.class, this, ExecutionmodelPackage.EXECUTION_INFO__EXECUTION_STEPS);
		}
		return executionSteps;
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
				case ExecutionmodelPackage.EXECUTION_INFO__EXECUTION_STEPS:
					return ((InternalEList)getExecutionSteps()).basicRemove(otherEnd, msgs);
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
			case ExecutionmodelPackage.EXECUTION_INFO__EXECUTION_STEPS:
				return getExecutionSteps();
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
			case ExecutionmodelPackage.EXECUTION_INFO__EXECUTION_STEPS:
				getExecutionSteps().clear();
				getExecutionSteps().addAll((Collection)newValue);
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
			case ExecutionmodelPackage.EXECUTION_INFO__EXECUTION_STEPS:
				getExecutionSteps().clear();
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
			case ExecutionmodelPackage.EXECUTION_INFO__EXECUTION_STEPS:
				return executionSteps != null && !executionSteps.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ExecutionStep addExecutionStep(ExecutionContext context, Diagnostic diagnosticToSource, Diagnostic diagnosticToTarget) {
		ExecutionStep step = ExecutionmodelFactory.eINSTANCE.createExecutionStep();
		Dependency dependency = ExecutionmodelFactory.eINSTANCE.createDependency();
		if (context.getCurrentTypeDependency()!=null){
			dependency.setEvent(context.getEvent());
			dependency.setType(context.getCurrentTypeDependency());
			step.setDependency(dependency);
			step.setSource(context.getCurrentResponsibility());
			step.setTarget(context.getPreResponsibility());
			step.setDiagnosticToSource(diagnosticToSource);
			step.setDiagnosticToTarget(diagnosticToTarget);
			step.setInstanceComponentToSource(context.getInstanceComponentToSource());
			step.setInstanceComponentToTarget(context.getInstanceComponentToTarget());
			step.setEnabled(context.getEnabled());
		}
		if (executionSteps == null) {
			executionSteps = new EObjectContainmentEList(ExecutionStep.class, this, ExecutionmodelPackage.EXECUTION_INFO__EXECUTION_STEPS);
		}
		ExecutionContext currentContext = ExecutionmodelFactory.eINSTANCE.createExecutionContext();
		currentContext.cloneExecutionContext(context);
		currentContext.setCurrentStep(String.valueOf(Integer.parseInt(context.getCurrentStep())+1));
		step.setExecutionContext(currentContext);
		this.executionSteps.add(step);
		return step;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getStepsCount() {
		return getExecutionSteps().size();
	}

	public void backToStep(ExecutionStep step) {
		int index = executionSteps.indexOf(step);
		for (int i=executionSteps.size()-1; i > index; i--){
			executionSteps.remove(i);
		}
		eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_INFO__BACK_TO_STEP, null, step));
	}
	
	public void startEvaluatingNode(EvaluationStep step) {
		eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_INFO__START_EVALUATING_NODE, null, step));
	}
	
	public void finishEvaluatingNode(EvaluationStep step) {
		eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_INFO__FINISH_EVALUATING_NODE, step, null));
	}
	
	public void resetExecutionInfo() {
		eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_INFO__RESET, null, null));
	}
	
} //ExecutionInfoImpl
