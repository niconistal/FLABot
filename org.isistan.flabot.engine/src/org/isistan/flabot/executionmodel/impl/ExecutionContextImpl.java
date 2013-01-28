/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExecutionContextImpl.java,v 1.16 2006/04/11 04:21:27 apersson Exp $
 */
package org.isistan.flabot.executionmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.engine.RuntimeManager;
import org.isistan.flabot.executionmodel.ExecutionContext;
import org.isistan.flabot.executionmodel.ExecutionmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getCurrentResponsibility <em>Current Responsibility</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getPreResponsibility <em>Pre Responsibility</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getCurrentStep <em>Current Step</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getCurrentScenario <em>Current Scenario</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getCurrentState <em>Current State</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getCurrentFamily <em>Current Family</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getFamily <em>Family</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getCurrentTypeDependency <em>Current Type Dependency</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getCurrentDependency <em>Current Dependency</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getCurrentAnalizeDependency <em>Current Analize Dependency</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getPrologKnowledge <em>Prolog Knowledge</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getCurrentLogicModule <em>Current Logic Module</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getResponsibilityToExecute <em>Responsibility To Execute</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getMappingFamily <em>Mapping Family</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getLastMappingFamily <em>Last Mapping Family</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getStubNode <em>Stub Node</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getStartNodeToStub <em>Start Node To Stub</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getEndNodeToStub <em>End Node To Stub</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getResponsibilityToStub <em>Responsibility To Stub</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getPreResponsibilityToStub <em>Pre Responsibility To Stub</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getStopStep <em>Stop Step</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getInstanceComponentToSource <em>Instance Component To Source</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getInstanceComponentToTarget <em>Instance Component To Target</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getResponsibilityToJoin <em>Responsibility To Join</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getPreResponsibilityToJoin <em>Pre Responsibility To Join</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getBranchJoin <em>Branch Join</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionContextImpl#getEnabled <em>Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionContextImpl extends EObjectImpl implements ExecutionContext {
	/**
	 * The cached value of the '{@link #getCurrentResponsibility() <em>Current Responsibility</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentResponsibility()
	 * @generated
	 * @ordered
	 */
	protected SimplePathNode currentResponsibility = null;

	/**
	 * The cached value of the '{@link #getPreResponsibility() <em>Pre Responsibility</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreResponsibility()
	 * @generated
	 * @ordered
	 */
	protected SimplePathNode preResponsibility = null;

	/**
	 * The default value of the '{@link #getCurrentStep() <em>Current Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentStep()
	 * @generated
	 * @ordered
	 */
	protected static final String CURRENT_STEP_EDEFAULT = "0";

	/**
	 * The cached value of the '{@link #getCurrentStep() <em>Current Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentStep()
	 * @generated
	 * @ordered
	 */
	protected String currentStep = CURRENT_STEP_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentScenario() <em>Current Scenario</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentScenario()
	 * @generated
	 * @ordered
	 */
	protected static final String CURRENT_SCENARIO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCurrentScenario() <em>Current Scenario</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentScenario()
	 * @generated
	 * @ordered
	 */
	protected String currentScenario = CURRENT_SCENARIO_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentState() <em>Current State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentState()
	 * @generated
	 * @ordered
	 */
	protected static final String CURRENT_STATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCurrentState() <em>Current State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentState()
	 * @generated
	 * @ordered
	 */
	protected String currentState = CURRENT_STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDependencies() <em>Dependencies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected static final String DEPENDENCIES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected String dependencies = DEPENDENCIES_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentFamily() <em>Current Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentFamily()
	 * @generated NOT
	 * @ordered
	 */
	public static final String CURRENT_FAMILY_EDEFAULT = "'Family'";

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
	 * The default value of the '{@link #getFamily() <em>Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFamily()
	 * @generated
	 * @ordered
	 */
	protected static final String FAMILY_EDEFAULT = "Family";

	/**
	 * The cached value of the '{@link #getFamily() <em>Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFamily()
	 * @generated
	 * @ordered
	 */
	protected String family = FAMILY_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentTypeDependency() <em>Current Type Dependency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentTypeDependency()
	 * @generated
	 * @ordered
	 */
	protected static final String CURRENT_TYPE_DEPENDENCY_EDEFAULT = "[]";

	/**
	 * The cached value of the '{@link #getCurrentTypeDependency() <em>Current Type Dependency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentTypeDependency()
	 * @generated
	 * @ordered
	 */
	protected String currentTypeDependency = CURRENT_TYPE_DEPENDENCY_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentDependency() <em>Current Dependency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentDependency()
	 * @generated
	 * @ordered
	 */
	protected static final String CURRENT_DEPENDENCY_EDEFAULT = "[]";

	/**
	 * The cached value of the '{@link #getCurrentDependency() <em>Current Dependency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentDependency()
	 * @generated
	 * @ordered
	 */
	protected String currentDependency = CURRENT_DEPENDENCY_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentAnalizeDependency() <em>Current Analize Dependency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentAnalizeDependency()
	 * @generated
	 * @ordered
	 */
	protected static final String CURRENT_ANALIZE_DEPENDENCY_EDEFAULT = "DEFAULT_DEPENDENCY";

	/**
	 * The cached value of the '{@link #getCurrentAnalizeDependency() <em>Current Analize Dependency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentAnalizeDependency()
	 * @generated
	 * @ordered
	 */
	protected String currentAnalizeDependency = CURRENT_ANALIZE_DEPENDENCY_EDEFAULT;

	/**
	 * The default value of the '{@link #getEvent() <em>Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvent()
	 * @generated
	 * @ordered
	 */
	protected static final String EVENT_EDEFAULT = "Event";

	/**
	 * The cached value of the '{@link #getEvent() <em>Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvent()
	 * @generated
	 * @ordered
	 */
	protected String event = EVENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrologKnowledge() <em>Prolog Knowledge</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrologKnowledge()
	 * @generated
	 * @ordered
	 */
	protected static final String PROLOG_KNOWLEDGE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getPrologKnowledge() <em>Prolog Knowledge</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrologKnowledge()
	 * @generated
	 * @ordered
	 */
	protected String prologKnowledge = PROLOG_KNOWLEDGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentLogicModule() <em>Current Logic Module</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentLogicModule()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String CURRENT_LOGIC_MODULE_EDEFAULT = RuntimeManager.LogicModuleGeneral;

	/**
	 * The cached value of the '{@link #getCurrentLogicModule() <em>Current Logic Module</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentLogicModule()
	 * @generated
	 * @ordered
	 */
	protected String currentLogicModule = CURRENT_LOGIC_MODULE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResponsibilityToExecute() <em>Responsibility To Execute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponsibilityToExecute()
	 * @generated NOT
	 * @ordered
	 */
	protected SimplePathNode responsibilityToExecute = preResponsibility;

	/**
	 * The default value of the '{@link #getMappingFamily() <em>Mapping Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingFamily()
	 * @generated
	 * @ordered
	 */
	protected static final String MAPPING_FAMILY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMappingFamily() <em>Mapping Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingFamily()
	 * @generated
	 * @ordered
	 */
	protected String mappingFamily = MAPPING_FAMILY_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastMappingFamily() <em>Last Mapping Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastMappingFamily()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_MAPPING_FAMILY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastMappingFamily() <em>Last Mapping Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastMappingFamily()
	 * @generated
	 * @ordered
	 */
	protected String lastMappingFamily = LAST_MAPPING_FAMILY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStubNode() <em>Stub Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStubNode()
	 * @generated
	 * @ordered
	 */
	protected SimplePathNode stubNode = null;

	/**
	 * The cached value of the '{@link #getStartNodeToStub() <em>Start Node To Stub</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartNodeToStub()
	 * @generated
	 * @ordered
	 */
	protected SimplePathNode startNodeToStub = null;

	/**
	 * The cached value of the '{@link #getEndNodeToStub() <em>End Node To Stub</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndNodeToStub()
	 * @generated
	 * @ordered
	 */
	protected SimplePathNode endNodeToStub = null;

	/**
	 * The cached value of the '{@link #getResponsibilityToStub() <em>Responsibility To Stub</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponsibilityToStub()
	 * @generated
	 * @ordered
	 */
	protected SimplePathNode responsibilityToStub = null;

	/**
	 * The cached value of the '{@link #getPreResponsibilityToStub() <em>Pre Responsibility To Stub</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreResponsibilityToStub()
	 * @generated
	 * @ordered
	 */
	protected SimplePathNode preResponsibilityToStub = null;

	/**
	 * The default value of the '{@link #getStopStep() <em>Stop Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopStep()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String STOP_STEP_EDEFAULT = "RUN";

	/**
	 * The cached value of the '{@link #getStopStep() <em>Stop Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopStep()
	 * @generated
	 * @ordered
	 */
	protected String stopStep = STOP_STEP_EDEFAULT;

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
	 * The cached value of the '{@link #getResponsibilityToJoin() <em>Responsibility To Join</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponsibilityToJoin()
	 * @generated
	 * @ordered
	 */
	protected SimplePathNode responsibilityToJoin = null;

	/**
	 * The cached value of the '{@link #getPreResponsibilityToJoin() <em>Pre Responsibility To Join</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreResponsibilityToJoin()
	 * @generated
	 * @ordered
	 */
	protected SimplePathNode preResponsibilityToJoin = null;

	/**
	 * The cached value of the '{@link #getBranchJoin() <em>Branch Join</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranchJoin()
	 * @generated
	 * @ordered
	 */
	protected EMap branchJoin = null;

	/**
	 * The default value of the '{@link #getEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnabled()
	 * @generated NOT
	 * @ordered
	 */
	protected static final int ENABLED_EDEFAULT = ExecutionContext.enabled_Step;

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
	protected ExecutionContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionmodelPackage.eINSTANCE.getExecutionContext();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode getCurrentResponsibility() {
		if (currentResponsibility != null && currentResponsibility.eIsProxy()) {
			SimplePathNode oldCurrentResponsibility = currentResponsibility;
			currentResponsibility = (SimplePathNode)eResolveProxy((InternalEObject)currentResponsibility);
			if (currentResponsibility != oldCurrentResponsibility) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_RESPONSIBILITY, oldCurrentResponsibility, currentResponsibility));
			}
		}
		return currentResponsibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode basicGetCurrentResponsibility() {
		return currentResponsibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentResponsibility(SimplePathNode newCurrentResponsibility) {
		SimplePathNode oldCurrentResponsibility = currentResponsibility;
		currentResponsibility = newCurrentResponsibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_RESPONSIBILITY, oldCurrentResponsibility, currentResponsibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode getPreResponsibility() {
		if (preResponsibility != null && preResponsibility.eIsProxy()) {
			SimplePathNode oldPreResponsibility = preResponsibility;
			preResponsibility = (SimplePathNode)eResolveProxy((InternalEObject)preResponsibility);
			if (preResponsibility != oldPreResponsibility) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionmodelPackage.EXECUTION_CONTEXT__PRE_RESPONSIBILITY, oldPreResponsibility, preResponsibility));
			}
		}
		return preResponsibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode basicGetPreResponsibility() {
		return preResponsibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreResponsibility(SimplePathNode newPreResponsibility) {
		SimplePathNode oldPreResponsibility = preResponsibility;
		preResponsibility = newPreResponsibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__PRE_RESPONSIBILITY, oldPreResponsibility, preResponsibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCurrentStep() {
		return currentStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentStep(String newCurrentStep) {
		String oldCurrentStep = currentStep;
		currentStep = newCurrentStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_STEP, oldCurrentStep, currentStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCurrentScenario() {
		return currentScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentScenario(String newCurrentScenario) {
		String oldCurrentScenario = currentScenario;
		currentScenario = newCurrentScenario;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_SCENARIO, oldCurrentScenario, currentScenario));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCurrentState() {
		return currentState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentState(String newCurrentState) {
		String oldCurrentState = currentState;
		currentState = newCurrentState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_STATE, oldCurrentState, currentState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDependencies() {
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependencies(String newDependencies) {
		String oldDependencies = dependencies;
		dependencies = newDependencies;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__DEPENDENCIES, oldDependencies, dependencies));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_FAMILY, oldCurrentFamily, currentFamily));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFamily() {
		return family;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFamily(String newFamily) {
		String oldFamily = family;
		family = newFamily;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__FAMILY, oldFamily, family));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCurrentTypeDependency() {
		return currentTypeDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentTypeDependency(String newCurrentTypeDependency) {
		String oldCurrentTypeDependency = currentTypeDependency;
		currentTypeDependency = newCurrentTypeDependency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_TYPE_DEPENDENCY, oldCurrentTypeDependency, currentTypeDependency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCurrentDependency() {
		return currentDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentDependency(String newCurrentDependency) {
		String oldCurrentDependency = currentDependency;
		currentDependency = newCurrentDependency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_DEPENDENCY, oldCurrentDependency, currentDependency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCurrentAnalizeDependency() {
		return currentAnalizeDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentAnalizeDependency(String newCurrentAnalizeDependency) {
		String oldCurrentAnalizeDependency = currentAnalizeDependency;
		currentAnalizeDependency = newCurrentAnalizeDependency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_ANALIZE_DEPENDENCY, oldCurrentAnalizeDependency, currentAnalizeDependency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEvent() {
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvent(String newEvent) {
		String oldEvent = event;
		event = newEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__EVENT, oldEvent, event));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrologKnowledge() {
		return prologKnowledge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrologKnowledge(String newPrologKnowledge) {
		String oldPrologKnowledge = prologKnowledge;
		prologKnowledge = newPrologKnowledge;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__PROLOG_KNOWLEDGE, oldPrologKnowledge, prologKnowledge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCurrentLogicModule() {
		return currentLogicModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentLogicModule(String newCurrentLogicModule) {
		String oldCurrentLogicModule = currentLogicModule;
		currentLogicModule = newCurrentLogicModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_LOGIC_MODULE, oldCurrentLogicModule, currentLogicModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SimplePathNode getResponsibilityToExecute() {
		if (responsibilityToExecute != null && responsibilityToExecute.eIsProxy()) {
			SimplePathNode oldResponsibilityToExecute = responsibilityToExecute;
			responsibilityToExecute = (SimplePathNode)eResolveProxy((InternalEObject)responsibilityToExecute);
			if (responsibilityToExecute != oldResponsibilityToExecute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionmodelPackage.EXECUTION_CONTEXT__RESPONSIBILITY_TO_EXECUTE, oldResponsibilityToExecute, responsibilityToExecute));
			}
		}
		if (responsibilityToExecute!=null)
			return responsibilityToExecute;
		else return getPreResponsibility();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode basicGetResponsibilityToExecute() {
		return responsibilityToExecute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponsibilityToExecute(SimplePathNode newResponsibilityToExecute) {
		SimplePathNode oldResponsibilityToExecute = responsibilityToExecute;
		responsibilityToExecute = newResponsibilityToExecute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__RESPONSIBILITY_TO_EXECUTE, oldResponsibilityToExecute, responsibilityToExecute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMappingFamily() {
		return mappingFamily;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingFamily(String newMappingFamily) {
		String oldMappingFamily = mappingFamily;
		mappingFamily = newMappingFamily;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__MAPPING_FAMILY, oldMappingFamily, mappingFamily));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastMappingFamily() {
		return lastMappingFamily;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastMappingFamily(String newLastMappingFamily) {
		String oldLastMappingFamily = lastMappingFamily;
		lastMappingFamily = newLastMappingFamily;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__LAST_MAPPING_FAMILY, oldLastMappingFamily, lastMappingFamily));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode getStubNode() {
		if (stubNode != null && stubNode.eIsProxy()) {
			SimplePathNode oldStubNode = stubNode;
			stubNode = (SimplePathNode)eResolveProxy((InternalEObject)stubNode);
			if (stubNode != oldStubNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionmodelPackage.EXECUTION_CONTEXT__STUB_NODE, oldStubNode, stubNode));
			}
		}
		return stubNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode basicGetStubNode() {
		return stubNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStubNode(SimplePathNode newStubNode) {
		SimplePathNode oldStubNode = stubNode;
		stubNode = newStubNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__STUB_NODE, oldStubNode, stubNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode getStartNodeToStub() {
		if (startNodeToStub != null && startNodeToStub.eIsProxy()) {
			SimplePathNode oldStartNodeToStub = startNodeToStub;
			startNodeToStub = (SimplePathNode)eResolveProxy((InternalEObject)startNodeToStub);
			if (startNodeToStub != oldStartNodeToStub) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionmodelPackage.EXECUTION_CONTEXT__START_NODE_TO_STUB, oldStartNodeToStub, startNodeToStub));
			}
		}
		return startNodeToStub;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode basicGetStartNodeToStub() {
		return startNodeToStub;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartNodeToStub(SimplePathNode newStartNodeToStub) {
		SimplePathNode oldStartNodeToStub = startNodeToStub;
		startNodeToStub = newStartNodeToStub;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__START_NODE_TO_STUB, oldStartNodeToStub, startNodeToStub));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode getEndNodeToStub() {
		if (endNodeToStub != null && endNodeToStub.eIsProxy()) {
			SimplePathNode oldEndNodeToStub = endNodeToStub;
			endNodeToStub = (SimplePathNode)eResolveProxy((InternalEObject)endNodeToStub);
			if (endNodeToStub != oldEndNodeToStub) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionmodelPackage.EXECUTION_CONTEXT__END_NODE_TO_STUB, oldEndNodeToStub, endNodeToStub));
			}
		}
		return endNodeToStub;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode basicGetEndNodeToStub() {
		return endNodeToStub;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndNodeToStub(SimplePathNode newEndNodeToStub) {
		SimplePathNode oldEndNodeToStub = endNodeToStub;
		endNodeToStub = newEndNodeToStub;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__END_NODE_TO_STUB, oldEndNodeToStub, endNodeToStub));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode getResponsibilityToStub() {
		if (responsibilityToStub != null && responsibilityToStub.eIsProxy()) {
			SimplePathNode oldResponsibilityToStub = responsibilityToStub;
			responsibilityToStub = (SimplePathNode)eResolveProxy((InternalEObject)responsibilityToStub);
			if (responsibilityToStub != oldResponsibilityToStub) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionmodelPackage.EXECUTION_CONTEXT__RESPONSIBILITY_TO_STUB, oldResponsibilityToStub, responsibilityToStub));
			}
		}
		return responsibilityToStub;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode basicGetResponsibilityToStub() {
		return responsibilityToStub;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponsibilityToStub(SimplePathNode newResponsibilityToStub) {
		SimplePathNode oldResponsibilityToStub = responsibilityToStub;
		responsibilityToStub = newResponsibilityToStub;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__RESPONSIBILITY_TO_STUB, oldResponsibilityToStub, responsibilityToStub));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode getPreResponsibilityToStub() {
		if (preResponsibilityToStub != null && preResponsibilityToStub.eIsProxy()) {
			SimplePathNode oldPreResponsibilityToStub = preResponsibilityToStub;
			preResponsibilityToStub = (SimplePathNode)eResolveProxy((InternalEObject)preResponsibilityToStub);
			if (preResponsibilityToStub != oldPreResponsibilityToStub) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionmodelPackage.EXECUTION_CONTEXT__PRE_RESPONSIBILITY_TO_STUB, oldPreResponsibilityToStub, preResponsibilityToStub));
			}
		}
		return preResponsibilityToStub;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode basicGetPreResponsibilityToStub() {
		return preResponsibilityToStub;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreResponsibilityToStub(SimplePathNode newPreResponsibilityToStub) {
		SimplePathNode oldPreResponsibilityToStub = preResponsibilityToStub;
		preResponsibilityToStub = newPreResponsibilityToStub;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__PRE_RESPONSIBILITY_TO_STUB, oldPreResponsibilityToStub, preResponsibilityToStub));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStopStep() {
		return stopStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStopStep(String newStopStep) {
		String oldStopStep = stopStep;
		stopStep = newStopStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__STOP_STEP, oldStopStep, stopStep));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionmodelPackage.EXECUTION_CONTEXT__INSTANCE_COMPONENT_TO_SOURCE, oldInstanceComponentToSource, instanceComponentToSource));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__INSTANCE_COMPONENT_TO_SOURCE, oldInstanceComponentToSource, instanceComponentToSource));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionmodelPackage.EXECUTION_CONTEXT__INSTANCE_COMPONENT_TO_TARGET, oldInstanceComponentToTarget, instanceComponentToTarget));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__INSTANCE_COMPONENT_TO_TARGET, oldInstanceComponentToTarget, instanceComponentToTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode getResponsibilityToJoin() {
		if (responsibilityToJoin != null && responsibilityToJoin.eIsProxy()) {
			SimplePathNode oldResponsibilityToJoin = responsibilityToJoin;
			responsibilityToJoin = (SimplePathNode)eResolveProxy((InternalEObject)responsibilityToJoin);
			if (responsibilityToJoin != oldResponsibilityToJoin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionmodelPackage.EXECUTION_CONTEXT__RESPONSIBILITY_TO_JOIN, oldResponsibilityToJoin, responsibilityToJoin));
			}
		}
		return responsibilityToJoin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode basicGetResponsibilityToJoin() {
		return responsibilityToJoin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponsibilityToJoin(SimplePathNode newResponsibilityToJoin) {
		SimplePathNode oldResponsibilityToJoin = responsibilityToJoin;
		responsibilityToJoin = newResponsibilityToJoin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__RESPONSIBILITY_TO_JOIN, oldResponsibilityToJoin, responsibilityToJoin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode getPreResponsibilityToJoin() {
		if (preResponsibilityToJoin != null && preResponsibilityToJoin.eIsProxy()) {
			SimplePathNode oldPreResponsibilityToJoin = preResponsibilityToJoin;
			preResponsibilityToJoin = (SimplePathNode)eResolveProxy((InternalEObject)preResponsibilityToJoin);
			if (preResponsibilityToJoin != oldPreResponsibilityToJoin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionmodelPackage.EXECUTION_CONTEXT__PRE_RESPONSIBILITY_TO_JOIN, oldPreResponsibilityToJoin, preResponsibilityToJoin));
			}
		}
		return preResponsibilityToJoin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode basicGetPreResponsibilityToJoin() {
		return preResponsibilityToJoin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreResponsibilityToJoin(SimplePathNode newPreResponsibilityToJoin) {
		SimplePathNode oldPreResponsibilityToJoin = preResponsibilityToJoin;
		preResponsibilityToJoin = newPreResponsibilityToJoin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__PRE_RESPONSIBILITY_TO_JOIN, oldPreResponsibilityToJoin, preResponsibilityToJoin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getBranchJoin() {
		if (branchJoin == null) {
			branchJoin = new EcoreEMap(EcorePackage.eINSTANCE.getEStringToStringMapEntry(), EStringToStringMapEntryImpl.class, this, ExecutionmodelPackage.EXECUTION_CONTEXT__BRANCH_JOIN);
		}
		return branchJoin;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_CONTEXT__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ExecutionmodelPackage.EXECUTION_CONTEXT__BRANCH_JOIN:
					return ((InternalEList)getBranchJoin()).basicRemove(otherEnd, msgs);
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
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_RESPONSIBILITY:
				if (resolve) return getCurrentResponsibility();
				return basicGetCurrentResponsibility();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__PRE_RESPONSIBILITY:
				if (resolve) return getPreResponsibility();
				return basicGetPreResponsibility();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_STEP:
				return getCurrentStep();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_SCENARIO:
				return getCurrentScenario();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_STATE:
				return getCurrentState();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__DEPENDENCIES:
				return getDependencies();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_FAMILY:
				return getCurrentFamily();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__FAMILY:
				return getFamily();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_TYPE_DEPENDENCY:
				return getCurrentTypeDependency();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_DEPENDENCY:
				return getCurrentDependency();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_ANALIZE_DEPENDENCY:
				return getCurrentAnalizeDependency();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__EVENT:
				return getEvent();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__PROLOG_KNOWLEDGE:
				return getPrologKnowledge();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_LOGIC_MODULE:
				return getCurrentLogicModule();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__RESPONSIBILITY_TO_EXECUTE:
				if (resolve) return getResponsibilityToExecute();
				return basicGetResponsibilityToExecute();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__MAPPING_FAMILY:
				return getMappingFamily();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__LAST_MAPPING_FAMILY:
				return getLastMappingFamily();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__STUB_NODE:
				if (resolve) return getStubNode();
				return basicGetStubNode();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__START_NODE_TO_STUB:
				if (resolve) return getStartNodeToStub();
				return basicGetStartNodeToStub();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__END_NODE_TO_STUB:
				if (resolve) return getEndNodeToStub();
				return basicGetEndNodeToStub();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__RESPONSIBILITY_TO_STUB:
				if (resolve) return getResponsibilityToStub();
				return basicGetResponsibilityToStub();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__PRE_RESPONSIBILITY_TO_STUB:
				if (resolve) return getPreResponsibilityToStub();
				return basicGetPreResponsibilityToStub();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__STOP_STEP:
				return getStopStep();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__INSTANCE_COMPONENT_TO_SOURCE:
				if (resolve) return getInstanceComponentToSource();
				return basicGetInstanceComponentToSource();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__INSTANCE_COMPONENT_TO_TARGET:
				if (resolve) return getInstanceComponentToTarget();
				return basicGetInstanceComponentToTarget();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__RESPONSIBILITY_TO_JOIN:
				if (resolve) return getResponsibilityToJoin();
				return basicGetResponsibilityToJoin();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__PRE_RESPONSIBILITY_TO_JOIN:
				if (resolve) return getPreResponsibilityToJoin();
				return basicGetPreResponsibilityToJoin();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__BRANCH_JOIN:
				return getBranchJoin();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__ENABLED:
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
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_RESPONSIBILITY:
				setCurrentResponsibility((SimplePathNode)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__PRE_RESPONSIBILITY:
				setPreResponsibility((SimplePathNode)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_STEP:
				setCurrentStep((String)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_SCENARIO:
				setCurrentScenario((String)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_STATE:
				setCurrentState((String)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__DEPENDENCIES:
				setDependencies((String)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_FAMILY:
				setCurrentFamily((String)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__FAMILY:
				setFamily((String)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_TYPE_DEPENDENCY:
				setCurrentTypeDependency((String)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_DEPENDENCY:
				setCurrentDependency((String)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_ANALIZE_DEPENDENCY:
				setCurrentAnalizeDependency((String)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__EVENT:
				setEvent((String)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__PROLOG_KNOWLEDGE:
				setPrologKnowledge((String)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_LOGIC_MODULE:
				setCurrentLogicModule((String)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__RESPONSIBILITY_TO_EXECUTE:
				setResponsibilityToExecute((SimplePathNode)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__MAPPING_FAMILY:
				setMappingFamily((String)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__LAST_MAPPING_FAMILY:
				setLastMappingFamily((String)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__STUB_NODE:
				setStubNode((SimplePathNode)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__START_NODE_TO_STUB:
				setStartNodeToStub((SimplePathNode)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__END_NODE_TO_STUB:
				setEndNodeToStub((SimplePathNode)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__RESPONSIBILITY_TO_STUB:
				setResponsibilityToStub((SimplePathNode)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__PRE_RESPONSIBILITY_TO_STUB:
				setPreResponsibilityToStub((SimplePathNode)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__STOP_STEP:
				setStopStep((String)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__INSTANCE_COMPONENT_TO_SOURCE:
				setInstanceComponentToSource((ComponentRole)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__INSTANCE_COMPONENT_TO_TARGET:
				setInstanceComponentToTarget((ComponentRole)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__RESPONSIBILITY_TO_JOIN:
				setResponsibilityToJoin((SimplePathNode)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__PRE_RESPONSIBILITY_TO_JOIN:
				setPreResponsibilityToJoin((SimplePathNode)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__BRANCH_JOIN:
				getBranchJoin().clear();
				getBranchJoin().addAll((Collection)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__ENABLED:
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
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_RESPONSIBILITY:
				setCurrentResponsibility((SimplePathNode)null);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__PRE_RESPONSIBILITY:
				setPreResponsibility((SimplePathNode)null);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_STEP:
				setCurrentStep(CURRENT_STEP_EDEFAULT);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_SCENARIO:
				setCurrentScenario(CURRENT_SCENARIO_EDEFAULT);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_STATE:
				setCurrentState(CURRENT_STATE_EDEFAULT);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__DEPENDENCIES:
				setDependencies(DEPENDENCIES_EDEFAULT);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_FAMILY:
				setCurrentFamily(CURRENT_FAMILY_EDEFAULT);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__FAMILY:
				setFamily(FAMILY_EDEFAULT);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_TYPE_DEPENDENCY:
				setCurrentTypeDependency(CURRENT_TYPE_DEPENDENCY_EDEFAULT);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_DEPENDENCY:
				setCurrentDependency(CURRENT_DEPENDENCY_EDEFAULT);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_ANALIZE_DEPENDENCY:
				setCurrentAnalizeDependency(CURRENT_ANALIZE_DEPENDENCY_EDEFAULT);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__EVENT:
				setEvent(EVENT_EDEFAULT);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__PROLOG_KNOWLEDGE:
				setPrologKnowledge(PROLOG_KNOWLEDGE_EDEFAULT);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_LOGIC_MODULE:
				setCurrentLogicModule(CURRENT_LOGIC_MODULE_EDEFAULT);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__RESPONSIBILITY_TO_EXECUTE:
				setResponsibilityToExecute((SimplePathNode)null);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__MAPPING_FAMILY:
				setMappingFamily(MAPPING_FAMILY_EDEFAULT);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__LAST_MAPPING_FAMILY:
				setLastMappingFamily(LAST_MAPPING_FAMILY_EDEFAULT);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__STUB_NODE:
				setStubNode((SimplePathNode)null);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__START_NODE_TO_STUB:
				setStartNodeToStub((SimplePathNode)null);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__END_NODE_TO_STUB:
				setEndNodeToStub((SimplePathNode)null);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__RESPONSIBILITY_TO_STUB:
				setResponsibilityToStub((SimplePathNode)null);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__PRE_RESPONSIBILITY_TO_STUB:
				setPreResponsibilityToStub((SimplePathNode)null);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__STOP_STEP:
				setStopStep(STOP_STEP_EDEFAULT);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__INSTANCE_COMPONENT_TO_SOURCE:
				setInstanceComponentToSource((ComponentRole)null);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__INSTANCE_COMPONENT_TO_TARGET:
				setInstanceComponentToTarget((ComponentRole)null);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__RESPONSIBILITY_TO_JOIN:
				setResponsibilityToJoin((SimplePathNode)null);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__PRE_RESPONSIBILITY_TO_JOIN:
				setPreResponsibilityToJoin((SimplePathNode)null);
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__BRANCH_JOIN:
				getBranchJoin().clear();
				return;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__ENABLED:
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
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_RESPONSIBILITY:
				return currentResponsibility != null;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__PRE_RESPONSIBILITY:
				return preResponsibility != null;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_STEP:
				return CURRENT_STEP_EDEFAULT == null ? currentStep != null : !CURRENT_STEP_EDEFAULT.equals(currentStep);
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_SCENARIO:
				return CURRENT_SCENARIO_EDEFAULT == null ? currentScenario != null : !CURRENT_SCENARIO_EDEFAULT.equals(currentScenario);
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_STATE:
				return CURRENT_STATE_EDEFAULT == null ? currentState != null : !CURRENT_STATE_EDEFAULT.equals(currentState);
			case ExecutionmodelPackage.EXECUTION_CONTEXT__DEPENDENCIES:
				return DEPENDENCIES_EDEFAULT == null ? dependencies != null : !DEPENDENCIES_EDEFAULT.equals(dependencies);
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_FAMILY:
				return CURRENT_FAMILY_EDEFAULT == null ? currentFamily != null : !CURRENT_FAMILY_EDEFAULT.equals(currentFamily);
			case ExecutionmodelPackage.EXECUTION_CONTEXT__FAMILY:
				return FAMILY_EDEFAULT == null ? family != null : !FAMILY_EDEFAULT.equals(family);
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_TYPE_DEPENDENCY:
				return CURRENT_TYPE_DEPENDENCY_EDEFAULT == null ? currentTypeDependency != null : !CURRENT_TYPE_DEPENDENCY_EDEFAULT.equals(currentTypeDependency);
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_DEPENDENCY:
				return CURRENT_DEPENDENCY_EDEFAULT == null ? currentDependency != null : !CURRENT_DEPENDENCY_EDEFAULT.equals(currentDependency);
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_ANALIZE_DEPENDENCY:
				return CURRENT_ANALIZE_DEPENDENCY_EDEFAULT == null ? currentAnalizeDependency != null : !CURRENT_ANALIZE_DEPENDENCY_EDEFAULT.equals(currentAnalizeDependency);
			case ExecutionmodelPackage.EXECUTION_CONTEXT__EVENT:
				return EVENT_EDEFAULT == null ? event != null : !EVENT_EDEFAULT.equals(event);
			case ExecutionmodelPackage.EXECUTION_CONTEXT__PROLOG_KNOWLEDGE:
				return PROLOG_KNOWLEDGE_EDEFAULT == null ? prologKnowledge != null : !PROLOG_KNOWLEDGE_EDEFAULT.equals(prologKnowledge);
			case ExecutionmodelPackage.EXECUTION_CONTEXT__CURRENT_LOGIC_MODULE:
				return CURRENT_LOGIC_MODULE_EDEFAULT == null ? currentLogicModule != null : !CURRENT_LOGIC_MODULE_EDEFAULT.equals(currentLogicModule);
			case ExecutionmodelPackage.EXECUTION_CONTEXT__RESPONSIBILITY_TO_EXECUTE:
				return responsibilityToExecute != null;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__MAPPING_FAMILY:
				return MAPPING_FAMILY_EDEFAULT == null ? mappingFamily != null : !MAPPING_FAMILY_EDEFAULT.equals(mappingFamily);
			case ExecutionmodelPackage.EXECUTION_CONTEXT__LAST_MAPPING_FAMILY:
				return LAST_MAPPING_FAMILY_EDEFAULT == null ? lastMappingFamily != null : !LAST_MAPPING_FAMILY_EDEFAULT.equals(lastMappingFamily);
			case ExecutionmodelPackage.EXECUTION_CONTEXT__STUB_NODE:
				return stubNode != null;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__START_NODE_TO_STUB:
				return startNodeToStub != null;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__END_NODE_TO_STUB:
				return endNodeToStub != null;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__RESPONSIBILITY_TO_STUB:
				return responsibilityToStub != null;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__PRE_RESPONSIBILITY_TO_STUB:
				return preResponsibilityToStub != null;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__STOP_STEP:
				return STOP_STEP_EDEFAULT == null ? stopStep != null : !STOP_STEP_EDEFAULT.equals(stopStep);
			case ExecutionmodelPackage.EXECUTION_CONTEXT__INSTANCE_COMPONENT_TO_SOURCE:
				return instanceComponentToSource != null;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__INSTANCE_COMPONENT_TO_TARGET:
				return instanceComponentToTarget != null;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__RESPONSIBILITY_TO_JOIN:
				return responsibilityToJoin != null;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__PRE_RESPONSIBILITY_TO_JOIN:
				return preResponsibilityToJoin != null;
			case ExecutionmodelPackage.EXECUTION_CONTEXT__BRANCH_JOIN:
				return branchJoin != null && !branchJoin.isEmpty();
			case ExecutionmodelPackage.EXECUTION_CONTEXT__ENABLED:
				return enabled != ENABLED_EDEFAULT;
		}
		return eDynamicIsSet(eFeature);
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
		result.append(" (currentStep: ");
		result.append(currentStep);
		result.append(", currentScenario: ");
		result.append(currentScenario);
		result.append(", currentState: ");
		result.append(currentState);
		result.append(", dependencies: ");
		result.append(dependencies);
		result.append(", currentFamily: ");
		result.append(currentFamily);
		result.append(", family: ");
		result.append(family);
		result.append(", currentTypeDependency: ");
		result.append(currentTypeDependency);
		result.append(", currentDependency: ");
		result.append(currentDependency);
		result.append(", currentAnalizeDependency: ");
		result.append(currentAnalizeDependency);
		result.append(", event: ");
		result.append(event);
		result.append(", prologKnowledge: ");
		result.append(prologKnowledge);
		result.append(", currentLogicModule: ");
		result.append(currentLogicModule);
		result.append(", mappingFamily: ");
		result.append(mappingFamily);
		result.append(", lastMappingFamily: ");
		result.append(lastMappingFamily);
		result.append(", stopStep: ");
		result.append(stopStep);
		result.append(", enabled: ");
		result.append(enabled);
		result.append(')');
		return result.toString();
	}

	public void cloneExecutionContext(ExecutionContext context) {
		setCurrentAnalizeDependency(context.getCurrentAnalizeDependency());
		setCurrentDependency(context.getCurrentDependency());
		setCurrentFamily(context.getCurrentFamily());
		setCurrentResponsibility(context.getCurrentResponsibility());
		setCurrentScenario(context.getCurrentScenario());
		setCurrentState(context.getCurrentState());
		setCurrentStep(context.getCurrentStep());
		setCurrentTypeDependency(context.getCurrentTypeDependency());
		setDependencies(context.getDependencies());
		setEvent(context.getEvent());
		setFamily(context.getFamily());
		setCurrentLogicModule(context.getCurrentLogicModule());
		setPreResponsibility(context.getPreResponsibility());
		setEnabled(context.getEnabled());
		branchJoin = context.getBranchJoin();
	}

} //ExecutionContextImpl
