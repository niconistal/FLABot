/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExecutionStepImpl.java,v 1.11 2006/03/22 03:28:55 franco Exp $
 */
package org.isistan.flabot.executionmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.engine.executionstate.Diagnostic;
import org.isistan.flabot.engine.executionstate.ExecutionState;
import org.isistan.flabot.executionmodel.Dependency;
import org.isistan.flabot.executionmodel.ExecutionContext;
import org.isistan.flabot.executionmodel.ExecutionStep;
import org.isistan.flabot.executionmodel.ExecutionmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionStepImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionStepImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionStepImpl#getDependency <em>Dependency</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionStepImpl#getInstanceComponentToSource <em>Instance Component To Source</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionStepImpl#getInstanceComponentToTarget <em>Instance Component To Target</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionStepImpl#getDiagnosticToSource <em>Diagnostic To Source</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionStepImpl#getDiagnosticToTarget <em>Diagnostic To Target</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionStepImpl#getFinalState <em>Final State</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionStepImpl#getExecutionContext <em>Execution Context</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionStepImpl#getEnabled <em>Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionStepImpl extends EObjectImpl implements ExecutionStep {
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
	 * The cached value of the '{@link #getDependency() <em>Dependency</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependency()
	 * @generated
	 * @ordered
	 */
	protected Dependency dependency = null;

	/**
	 * The cached value of the '{@link #getInstanceComponentToSource() <em>Instance Component To Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceComponentToSource()
	 * @generated
	 * @ordered
	 */
	protected ComponentRole instanceComponentToSource = null;

	/**
	 * The cached value of the '{@link #getInstanceComponentToTarget() <em>Instance Component To Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceComponentToTarget()
	 * @generated
	 * @ordered
	 */
	protected ComponentRole instanceComponentToTarget = null;

	/**
	 * The cached value of the '{@link #getDiagnosticToSource() <em>Diagnostic To Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagnosticToSource()
	 * @generated
	 * @ordered
	 */
	protected Diagnostic diagnosticToSource = null;

	/**
	 * The cached value of the '{@link #getDiagnosticToTarget() <em>Diagnostic To Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagnosticToTarget()
	 * @generated
	 * @ordered
	 */
	protected Diagnostic diagnosticToTarget = null;

	/**
	 * The default value of the '{@link #getFinalState() <em>Final State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinalState()
	 * @generated
	 * @ordered
	 */
	protected static final ExecutionState FINAL_STATE_EDEFAULT = ExecutionState.EXECUTED_LITERAL;

	/**
	 * The cached value of the '{@link #getFinalState() <em>Final State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinalState()
	 * @generated
	 * @ordered
	 */
	protected ExecutionState finalState = FINAL_STATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExecutionContext() <em>Execution Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionContext()
	 * @generated
	 * @ordered
	 */
	protected ExecutionContext executionContext = null;

	/**
	 * The default value of the '{@link #getEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final int ENABLED_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnabled()
	 * @generated
	 * @ordered
	 */
	protected int enabled = ENABLED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionmodelPackage.eINSTANCE.getExecutionStep();
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionmodelPackage.EXECUTION_STEP__SOURCE, oldSource, source));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_STEP__SOURCE, oldSource, source));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionmodelPackage.EXECUTION_STEP__TARGET, oldTarget, target));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_STEP__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dependency getDependency() {
		return dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependency(Dependency newDependency, NotificationChain msgs) {
		Dependency oldDependency = dependency;
		dependency = newDependency;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_STEP__DEPENDENCY, oldDependency, newDependency);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependency(Dependency newDependency) {
		if (newDependency != dependency) {
			NotificationChain msgs = null;
			if (dependency != null)
				msgs = ((InternalEObject)dependency).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExecutionmodelPackage.EXECUTION_STEP__DEPENDENCY, null, msgs);
			if (newDependency != null)
				msgs = ((InternalEObject)newDependency).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExecutionmodelPackage.EXECUTION_STEP__DEPENDENCY, null, msgs);
			msgs = basicSetDependency(newDependency, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_STEP__DEPENDENCY, newDependency, newDependency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentRole getInstanceComponentToSource() {
		if (instanceComponentToSource != null && instanceComponentToSource.eIsProxy()) {
			ComponentRole oldInstanceComponentToSource = instanceComponentToSource;
			instanceComponentToSource = (ComponentRole)eResolveProxy((InternalEObject)instanceComponentToSource);
			if (instanceComponentToSource != oldInstanceComponentToSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionmodelPackage.EXECUTION_STEP__INSTANCE_COMPONENT_TO_SOURCE, oldInstanceComponentToSource, instanceComponentToSource));
			}
		}
		return instanceComponentToSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentRole basicGetInstanceComponentToSource() {
		return instanceComponentToSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceComponentToSource(ComponentRole newInstanceComponentToSource) {
		ComponentRole oldInstanceComponentToSource = instanceComponentToSource;
		instanceComponentToSource = newInstanceComponentToSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_STEP__INSTANCE_COMPONENT_TO_SOURCE, oldInstanceComponentToSource, instanceComponentToSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentRole getInstanceComponentToTarget() {
		if (instanceComponentToTarget != null && instanceComponentToTarget.eIsProxy()) {
			ComponentRole oldInstanceComponentToTarget = instanceComponentToTarget;
			instanceComponentToTarget = (ComponentRole)eResolveProxy((InternalEObject)instanceComponentToTarget);
			if (instanceComponentToTarget != oldInstanceComponentToTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionmodelPackage.EXECUTION_STEP__INSTANCE_COMPONENT_TO_TARGET, oldInstanceComponentToTarget, instanceComponentToTarget));
			}
		}
		return instanceComponentToTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentRole basicGetInstanceComponentToTarget() {
		return instanceComponentToTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceComponentToTarget(ComponentRole newInstanceComponentToTarget) {
		ComponentRole oldInstanceComponentToTarget = instanceComponentToTarget;
		instanceComponentToTarget = newInstanceComponentToTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_STEP__INSTANCE_COMPONENT_TO_TARGET, oldInstanceComponentToTarget, instanceComponentToTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagnostic getDiagnosticToSource() {
		if (diagnosticToSource != null && diagnosticToSource.eIsProxy()) {
			Diagnostic oldDiagnosticToSource = diagnosticToSource;
			diagnosticToSource = (Diagnostic)eResolveProxy((InternalEObject)diagnosticToSource);
			if (diagnosticToSource != oldDiagnosticToSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionmodelPackage.EXECUTION_STEP__DIAGNOSTIC_TO_SOURCE, oldDiagnosticToSource, diagnosticToSource));
			}
		}
		return diagnosticToSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagnostic basicGetDiagnosticToSource() {
		return diagnosticToSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagnosticToSource(Diagnostic newDiagnosticToSource) {
		Diagnostic oldDiagnosticToSource = diagnosticToSource;
		diagnosticToSource = newDiagnosticToSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_STEP__DIAGNOSTIC_TO_SOURCE, oldDiagnosticToSource, diagnosticToSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagnostic getDiagnosticToTarget() {
		if (diagnosticToTarget != null && diagnosticToTarget.eIsProxy()) {
			Diagnostic oldDiagnosticToTarget = diagnosticToTarget;
			diagnosticToTarget = (Diagnostic)eResolveProxy((InternalEObject)diagnosticToTarget);
			if (diagnosticToTarget != oldDiagnosticToTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionmodelPackage.EXECUTION_STEP__DIAGNOSTIC_TO_TARGET, oldDiagnosticToTarget, diagnosticToTarget));
			}
		}
		return diagnosticToTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagnostic basicGetDiagnosticToTarget() {
		return diagnosticToTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagnosticToTarget(Diagnostic newDiagnosticToTarget) {
		Diagnostic oldDiagnosticToTarget = diagnosticToTarget;
		diagnosticToTarget = newDiagnosticToTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_STEP__DIAGNOSTIC_TO_TARGET, oldDiagnosticToTarget, diagnosticToTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionState getFinalState() {
		return finalState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinalState(ExecutionState newFinalState) {
		ExecutionState oldFinalState = finalState;
		finalState = newFinalState == null ? FINAL_STATE_EDEFAULT : newFinalState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_STEP__FINAL_STATE, oldFinalState, finalState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionContext getExecutionContext() {
		return executionContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExecutionContext(ExecutionContext newExecutionContext, NotificationChain msgs) {
		ExecutionContext oldExecutionContext = executionContext;
		executionContext = newExecutionContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_STEP__EXECUTION_CONTEXT, oldExecutionContext, newExecutionContext);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutionContext(ExecutionContext newExecutionContext) {
		if (newExecutionContext != executionContext) {
			NotificationChain msgs = null;
			if (executionContext != null)
				msgs = ((InternalEObject)executionContext).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExecutionmodelPackage.EXECUTION_STEP__EXECUTION_CONTEXT, null, msgs);
			if (newExecutionContext != null)
				msgs = ((InternalEObject)newExecutionContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExecutionmodelPackage.EXECUTION_STEP__EXECUTION_CONTEXT, null, msgs);
			msgs = basicSetExecutionContext(newExecutionContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_STEP__EXECUTION_CONTEXT, newExecutionContext, newExecutionContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEnabled() {
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabled(int newEnabled) {
		int oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_STEP__ENABLED, oldEnabled, enabled));
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
				case ExecutionmodelPackage.EXECUTION_STEP__DEPENDENCY:
					return basicSetDependency(null, msgs);
				case ExecutionmodelPackage.EXECUTION_STEP__EXECUTION_CONTEXT:
					return basicSetExecutionContext(null, msgs);
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
			case ExecutionmodelPackage.EXECUTION_STEP__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case ExecutionmodelPackage.EXECUTION_STEP__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case ExecutionmodelPackage.EXECUTION_STEP__DEPENDENCY:
				return getDependency();
			case ExecutionmodelPackage.EXECUTION_STEP__INSTANCE_COMPONENT_TO_SOURCE:
				if (resolve) return getInstanceComponentToSource();
				return basicGetInstanceComponentToSource();
			case ExecutionmodelPackage.EXECUTION_STEP__INSTANCE_COMPONENT_TO_TARGET:
				if (resolve) return getInstanceComponentToTarget();
				return basicGetInstanceComponentToTarget();
			case ExecutionmodelPackage.EXECUTION_STEP__DIAGNOSTIC_TO_SOURCE:
				if (resolve) return getDiagnosticToSource();
				return basicGetDiagnosticToSource();
			case ExecutionmodelPackage.EXECUTION_STEP__DIAGNOSTIC_TO_TARGET:
				if (resolve) return getDiagnosticToTarget();
				return basicGetDiagnosticToTarget();
			case ExecutionmodelPackage.EXECUTION_STEP__FINAL_STATE:
				return getFinalState();
			case ExecutionmodelPackage.EXECUTION_STEP__EXECUTION_CONTEXT:
				return getExecutionContext();
			case ExecutionmodelPackage.EXECUTION_STEP__ENABLED:
				return new Integer(getEnabled());
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
			case ExecutionmodelPackage.EXECUTION_STEP__SOURCE:
				setSource((SimplePathNode)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_STEP__TARGET:
				setTarget((SimplePathNode)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_STEP__DEPENDENCY:
				setDependency((Dependency)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_STEP__INSTANCE_COMPONENT_TO_SOURCE:
				setInstanceComponentToSource((ComponentRole)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_STEP__INSTANCE_COMPONENT_TO_TARGET:
				setInstanceComponentToTarget((ComponentRole)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_STEP__DIAGNOSTIC_TO_SOURCE:
				setDiagnosticToSource((Diagnostic)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_STEP__DIAGNOSTIC_TO_TARGET:
				setDiagnosticToTarget((Diagnostic)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_STEP__FINAL_STATE:
				setFinalState((ExecutionState)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_STEP__EXECUTION_CONTEXT:
				setExecutionContext((ExecutionContext)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_STEP__ENABLED:
				setEnabled(((Integer)newValue).intValue());
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
			case ExecutionmodelPackage.EXECUTION_STEP__SOURCE:
				setSource((SimplePathNode)null);
				return;
			case ExecutionmodelPackage.EXECUTION_STEP__TARGET:
				setTarget((SimplePathNode)null);
				return;
			case ExecutionmodelPackage.EXECUTION_STEP__DEPENDENCY:
				setDependency((Dependency)null);
				return;
			case ExecutionmodelPackage.EXECUTION_STEP__INSTANCE_COMPONENT_TO_SOURCE:
				setInstanceComponentToSource((ComponentRole)null);
				return;
			case ExecutionmodelPackage.EXECUTION_STEP__INSTANCE_COMPONENT_TO_TARGET:
				setInstanceComponentToTarget((ComponentRole)null);
				return;
			case ExecutionmodelPackage.EXECUTION_STEP__DIAGNOSTIC_TO_SOURCE:
				setDiagnosticToSource((Diagnostic)null);
				return;
			case ExecutionmodelPackage.EXECUTION_STEP__DIAGNOSTIC_TO_TARGET:
				setDiagnosticToTarget((Diagnostic)null);
				return;
			case ExecutionmodelPackage.EXECUTION_STEP__FINAL_STATE:
				setFinalState(FINAL_STATE_EDEFAULT);
				return;
			case ExecutionmodelPackage.EXECUTION_STEP__EXECUTION_CONTEXT:
				setExecutionContext((ExecutionContext)null);
				return;
			case ExecutionmodelPackage.EXECUTION_STEP__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
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
			case ExecutionmodelPackage.EXECUTION_STEP__SOURCE:
				return source != null;
			case ExecutionmodelPackage.EXECUTION_STEP__TARGET:
				return target != null;
			case ExecutionmodelPackage.EXECUTION_STEP__DEPENDENCY:
				return dependency != null;
			case ExecutionmodelPackage.EXECUTION_STEP__INSTANCE_COMPONENT_TO_SOURCE:
				return instanceComponentToSource != null;
			case ExecutionmodelPackage.EXECUTION_STEP__INSTANCE_COMPONENT_TO_TARGET:
				return instanceComponentToTarget != null;
			case ExecutionmodelPackage.EXECUTION_STEP__DIAGNOSTIC_TO_SOURCE:
				return diagnosticToSource != null;
			case ExecutionmodelPackage.EXECUTION_STEP__DIAGNOSTIC_TO_TARGET:
				return diagnosticToTarget != null;
			case ExecutionmodelPackage.EXECUTION_STEP__FINAL_STATE:
				return finalState != FINAL_STATE_EDEFAULT;
			case ExecutionmodelPackage.EXECUTION_STEP__EXECUTION_CONTEXT:
				return executionContext != null;
			case ExecutionmodelPackage.EXECUTION_STEP__ENABLED:
				return enabled != ENABLED_EDEFAULT;
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
		result.append(" (finalState: ");
		result.append(finalState);
		result.append(", enabled: ");
		result.append(enabled);
		result.append(')');
		return result.toString();
	}

	public void setDependency(Object value) {
		// TODO Auto-generated method stub
		
	}


} //ExecutionStepImpl
