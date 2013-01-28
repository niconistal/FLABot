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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologElement;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologPackage;
import org.isistan.flabot.executionstatemapping.model.semantic.ExceptionEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.FieldEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ParameterEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ReturnedValueEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ScopeEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeType;
import org.isistan.flabot.gauge.Gauge;
import org.isistan.flabot.launcher.filter.filtermodel.LogFilter;
import org.isistan.flabot.mapping.mappingmodel.PatternMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>General Execution Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.ExecutionConditionImpl#getPredicateName <em>Predicate Name</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.ExecutionConditionImpl#getFields <em>Fields</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.ExecutionConditionImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.ExecutionConditionImpl#getReturnedValue <em>Returned Value</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.ExecutionConditionImpl#getInternalMethodCalls <em>Internal Method Calls</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.ExecutionConditionImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.ExecutionConditionImpl#getException <em>Exception</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.ExecutionConditionImpl#getPatternMapping <em>Pattern Mapping</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.ExecutionConditionImpl#getInstanceOfClass <em>Instance Of Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionConditionImpl extends TreeStructuredElementImpl implements ExecutionCondition {
	
	public static int predicateExpressionNumber = 0;
	
	/**
	 * The default value of the '{@link #getPredicateName() <em>Predicate Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredicateName()
	 * @generated
	 * @ordered
	 */
	protected static final String PREDICATE_NAME_EDEFAULT = null;

	protected  String predicateName = null;

	/**
	 * The cached value of the '{@link #getFields() <em>Fields</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFields()
	 * @generated
	 * @ordered
	 */
	protected EList<FieldEvaluationCondition> fields;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterEvaluationCondition> parameters;

	/**
	 * The cached value of the '{@link #getReturnedValue() <em>Returned Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnedValue()
	 * @generated
	 * @ordered
	 */
	protected ReturnedValueEvaluationCondition returnedValue;

	/**
	 * The cached value of the '{@link #getInternalMethodCalls() <em>Internal Method Calls</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalMethodCalls()
	 * @generated
	 * @ordered
	 */
	protected EList<ExecutionCondition> internalMethodCalls;

	/**
	 * The cached value of the '{@link #getScope() <em>Scope</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected ScopeEvaluationCondition scope;

	/**
	 * The cached value of the '{@link #getException() <em>Exception</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getException()
	 * @generated
	 * @ordered
	 */
	protected ExceptionEvaluationCondition exception;

	/**
	 * The cached value of the '{@link #getPatternMapping() <em>Pattern Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatternMapping()
	 * @generated
	 * @ordered
	 */
	protected PatternMapping patternMapping;

	/**
	 * The default value of the '{@link #getInstanceOfClass() <em>Instance Of Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceOfClass()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTANCE_OF_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstanceOfClass() <em>Instance Of Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceOfClass()
	 * @generated
	 * @ordered
	 */
	protected String instanceOfClass = INSTANCE_OF_CLASS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionConditionImpl() {
		super();
	}
	
	protected ExecutionConditionImpl(TreeType treeType) {
		super(treeType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticPackage.Literals.EXECUTION_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getPredicateName() {
		return predicateName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPredicateName(String newPredicateName) {
		this.predicateName = newPredicateName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FieldEvaluationCondition> getFields() {
		if (fields == null) {
			fields = new EObjectContainmentEList<FieldEvaluationCondition>(FieldEvaluationCondition.class, this, SemanticPackage.EXECUTION_CONDITION__FIELDS);
		}
		return fields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterEvaluationCondition> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<ParameterEvaluationCondition>(ParameterEvaluationCondition.class, this, SemanticPackage.EXECUTION_CONDITION__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReturnedValueEvaluationCondition getReturnedValue() {
		return returnedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReturnedValue(ReturnedValueEvaluationCondition newReturnedValue, NotificationChain msgs) {
		ReturnedValueEvaluationCondition oldReturnedValue = returnedValue;
		returnedValue = newReturnedValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SemanticPackage.EXECUTION_CONDITION__RETURNED_VALUE, oldReturnedValue, newReturnedValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturnedValue(ReturnedValueEvaluationCondition newReturnedValue) {
		if (newReturnedValue != returnedValue) {
			NotificationChain msgs = null;
			if (returnedValue != null)
				msgs = ((InternalEObject)returnedValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SemanticPackage.EXECUTION_CONDITION__RETURNED_VALUE, null, msgs);
			if (newReturnedValue != null)
				msgs = ((InternalEObject)newReturnedValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SemanticPackage.EXECUTION_CONDITION__RETURNED_VALUE, null, msgs);
			msgs = basicSetReturnedValue(newReturnedValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.EXECUTION_CONDITION__RETURNED_VALUE, newReturnedValue, newReturnedValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExecutionCondition> getInternalMethodCalls() {
		if (internalMethodCalls == null) {
			internalMethodCalls = new EObjectContainmentEList<ExecutionCondition>(ExecutionCondition.class, this, SemanticPackage.EXECUTION_CONDITION__INTERNAL_METHOD_CALLS);
		}
		return internalMethodCalls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopeEvaluationCondition getScope() {
		return scope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScope(ScopeEvaluationCondition newScope, NotificationChain msgs) {
		ScopeEvaluationCondition oldScope = scope;
		scope = newScope;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SemanticPackage.EXECUTION_CONDITION__SCOPE, oldScope, newScope);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScope(ScopeEvaluationCondition newScope) {
		if (newScope != scope) {
			NotificationChain msgs = null;
			if (scope != null)
				msgs = ((InternalEObject)scope).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SemanticPackage.EXECUTION_CONDITION__SCOPE, null, msgs);
			if (newScope != null)
				msgs = ((InternalEObject)newScope).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SemanticPackage.EXECUTION_CONDITION__SCOPE, null, msgs);
			msgs = basicSetScope(newScope, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.EXECUTION_CONDITION__SCOPE, newScope, newScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExceptionEvaluationCondition getException() {
		return exception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetException(ExceptionEvaluationCondition newException, NotificationChain msgs) {
		ExceptionEvaluationCondition oldException = exception;
		exception = newException;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SemanticPackage.EXECUTION_CONDITION__EXCEPTION, oldException, newException);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setException(ExceptionEvaluationCondition newException) {
		if (newException != exception) {
			NotificationChain msgs = null;
			if (exception != null)
				msgs = ((InternalEObject)exception).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SemanticPackage.EXECUTION_CONDITION__EXCEPTION, null, msgs);
			if (newException != null)
				msgs = ((InternalEObject)newException).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SemanticPackage.EXECUTION_CONDITION__EXCEPTION, null, msgs);
			msgs = basicSetException(newException, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.EXECUTION_CONDITION__EXCEPTION, newException, newException));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternMapping getPatternMapping() {
		return patternMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPatternMapping(PatternMapping newPatternMapping, NotificationChain msgs) {
		PatternMapping oldPatternMapping = patternMapping;
		patternMapping = newPatternMapping;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SemanticPackage.EXECUTION_CONDITION__PATTERN_MAPPING, oldPatternMapping, newPatternMapping);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPatternMapping(PatternMapping newPatternMapping) {
		if (newPatternMapping != patternMapping) {
			NotificationChain msgs = null;
			if (patternMapping != null)
				msgs = ((InternalEObject)patternMapping).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SemanticPackage.EXECUTION_CONDITION__PATTERN_MAPPING, null, msgs);
			if (newPatternMapping != null)
				msgs = ((InternalEObject)newPatternMapping).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SemanticPackage.EXECUTION_CONDITION__PATTERN_MAPPING, null, msgs);
			msgs = basicSetPatternMapping(newPatternMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.EXECUTION_CONDITION__PATTERN_MAPPING, newPatternMapping, newPatternMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstanceOfClass() {
		return instanceOfClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceOfClass(String newInstanceOfClass) {
		String oldInstanceOfClass = instanceOfClass;
		instanceOfClass = newInstanceOfClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.EXECUTION_CONDITION__INSTANCE_OF_CLASS, oldInstanceOfClass, instanceOfClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setPredicateFunctor(String functor, String parameters) {
		predicateName=functor+(predicateExpressionNumber++)+parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SemanticPackage.EXECUTION_CONDITION__FIELDS:
				return ((InternalEList<?>)getFields()).basicRemove(otherEnd, msgs);
			case SemanticPackage.EXECUTION_CONDITION__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case SemanticPackage.EXECUTION_CONDITION__RETURNED_VALUE:
				return basicSetReturnedValue(null, msgs);
			case SemanticPackage.EXECUTION_CONDITION__INTERNAL_METHOD_CALLS:
				return ((InternalEList<?>)getInternalMethodCalls()).basicRemove(otherEnd, msgs);
			case SemanticPackage.EXECUTION_CONDITION__SCOPE:
				return basicSetScope(null, msgs);
			case SemanticPackage.EXECUTION_CONDITION__EXCEPTION:
				return basicSetException(null, msgs);
			case SemanticPackage.EXECUTION_CONDITION__PATTERN_MAPPING:
				return basicSetPatternMapping(null, msgs);
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
			case SemanticPackage.EXECUTION_CONDITION__PREDICATE_NAME:
				return getPredicateName();
			case SemanticPackage.EXECUTION_CONDITION__FIELDS:
				return getFields();
			case SemanticPackage.EXECUTION_CONDITION__PARAMETERS:
				return getParameters();
			case SemanticPackage.EXECUTION_CONDITION__RETURNED_VALUE:
				return getReturnedValue();
			case SemanticPackage.EXECUTION_CONDITION__INTERNAL_METHOD_CALLS:
				return getInternalMethodCalls();
			case SemanticPackage.EXECUTION_CONDITION__SCOPE:
				return getScope();
			case SemanticPackage.EXECUTION_CONDITION__EXCEPTION:
				return getException();
			case SemanticPackage.EXECUTION_CONDITION__PATTERN_MAPPING:
				return getPatternMapping();
			case SemanticPackage.EXECUTION_CONDITION__INSTANCE_OF_CLASS:
				return getInstanceOfClass();
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
			case SemanticPackage.EXECUTION_CONDITION__FIELDS:
				getFields().clear();
				getFields().addAll((Collection<? extends FieldEvaluationCondition>)newValue);
				return;
			case SemanticPackage.EXECUTION_CONDITION__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends ParameterEvaluationCondition>)newValue);
				return;
			case SemanticPackage.EXECUTION_CONDITION__RETURNED_VALUE:
				setReturnedValue((ReturnedValueEvaluationCondition)newValue);
				return;
			case SemanticPackage.EXECUTION_CONDITION__INTERNAL_METHOD_CALLS:
				getInternalMethodCalls().clear();
				getInternalMethodCalls().addAll((Collection<? extends ExecutionCondition>)newValue);
				return;
			case SemanticPackage.EXECUTION_CONDITION__SCOPE:
				setScope((ScopeEvaluationCondition)newValue);
				return;
			case SemanticPackage.EXECUTION_CONDITION__EXCEPTION:
				setException((ExceptionEvaluationCondition)newValue);
				return;
			case SemanticPackage.EXECUTION_CONDITION__PATTERN_MAPPING:
				setPatternMapping((PatternMapping)newValue);
				return;
			case SemanticPackage.EXECUTION_CONDITION__INSTANCE_OF_CLASS:
				setInstanceOfClass((String)newValue);
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
			case SemanticPackage.EXECUTION_CONDITION__FIELDS:
				getFields().clear();
				return;
			case SemanticPackage.EXECUTION_CONDITION__PARAMETERS:
				getParameters().clear();
				return;
			case SemanticPackage.EXECUTION_CONDITION__RETURNED_VALUE:
				setReturnedValue((ReturnedValueEvaluationCondition)null);
				return;
			case SemanticPackage.EXECUTION_CONDITION__INTERNAL_METHOD_CALLS:
				getInternalMethodCalls().clear();
				return;
			case SemanticPackage.EXECUTION_CONDITION__SCOPE:
				setScope((ScopeEvaluationCondition)null);
				return;
			case SemanticPackage.EXECUTION_CONDITION__EXCEPTION:
				setException((ExceptionEvaluationCondition)null);
				return;
			case SemanticPackage.EXECUTION_CONDITION__PATTERN_MAPPING:
				setPatternMapping((PatternMapping)null);
				return;
			case SemanticPackage.EXECUTION_CONDITION__INSTANCE_OF_CLASS:
				setInstanceOfClass(INSTANCE_OF_CLASS_EDEFAULT);
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
			case SemanticPackage.EXECUTION_CONDITION__PREDICATE_NAME:
				return PREDICATE_NAME_EDEFAULT == null ? predicateName != null : !PREDICATE_NAME_EDEFAULT.equals(predicateName);
			case SemanticPackage.EXECUTION_CONDITION__FIELDS:
				return fields != null && !fields.isEmpty();
			case SemanticPackage.EXECUTION_CONDITION__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case SemanticPackage.EXECUTION_CONDITION__RETURNED_VALUE:
				return returnedValue != null;
			case SemanticPackage.EXECUTION_CONDITION__INTERNAL_METHOD_CALLS:
				return internalMethodCalls != null && !internalMethodCalls.isEmpty();
			case SemanticPackage.EXECUTION_CONDITION__SCOPE:
				return scope != null;
			case SemanticPackage.EXECUTION_CONDITION__EXCEPTION:
				return exception != null;
			case SemanticPackage.EXECUTION_CONDITION__PATTERN_MAPPING:
				return patternMapping != null;
			case SemanticPackage.EXECUTION_CONDITION__INSTANCE_OF_CLASS:
				return INSTANCE_OF_CLASS_EDEFAULT == null ? instanceOfClass != null : !INSTANCE_OF_CLASS_EDEFAULT.equals(instanceOfClass);
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
		if (baseClass == PrologElement.class) {
			switch (derivedFeatureID) {
				case SemanticPackage.EXECUTION_CONDITION__PREDICATE_NAME: return PrologPackage.PROLOG_ELEMENT__PREDICATE_NAME;
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
		if (baseClass == PrologElement.class) {
			switch (baseFeatureID) {
				case PrologPackage.PROLOG_ELEMENT__PREDICATE_NAME: return SemanticPackage.EXECUTION_CONDITION__PREDICATE_NAME;
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
		result.append(" (predicateName: ");
		result.append(predicateName);
		result.append(", instanceOfClass: ");
		result.append(instanceOfClass);
		result.append(')');
		return result.toString();
	}

	public void resetPredicateName()
	{
		setPredicateName(null);
	}
	
	public boolean isMethodExecutionCondition()
	{
		return getPatternMapping() != null;
	}
	
	public void checkFilter(LogFilter logFilter)
	{
		if ( (getParameters().size() > 0 || getFields().size() > 0 || getReturnedValue() != null))
		{
			//logFilter.setGaugeType(Gauge.Type.ON_BEHAVIOR_ENTRY, true);
			//logFilter.setGaugeType(Gauge.Type.ON_BEHAVIOR_EXIT, true);
		}
		if ( getInternalMethodCalls().size() > 0)
		{
			logFilter.setGaugeType(Gauge.Type.BEFORE_METHOD_CALL, true);
			logFilter.setGaugeType(Gauge.Type.AFTER_METHOD_CALL, true);
		}
	}
	
	public boolean passesMapping(PatternMapping patternMapping)
	{
		if (isMethodExecutionCondition())
		{
			PatternMapping actualMapping = getPatternMapping();
			if (actualMapping == null || patternMapping == null)
			{
				return false;
			}
			
			return  patternMapping.getJavaFilePattern().contains(actualMapping.getJavaFilePattern()) && 
				patternMapping.getPackagePattern().contains(actualMapping.getPackagePattern()) && 
				patternMapping.getClassPattern().contains(actualMapping.getClassPattern()) && (
						patternMapping.getBehaviorPattern().trim().length() == 0 ||
				patternMapping.getBehaviorPattern().contains(actualMapping.getBehaviorPattern()));
		}		
		return true;
	}
	
	public void checkMapping(PatternMapping patternMapping)
	{
		if (isMethodExecutionCondition())
		{
			PatternMapping actualMapping = getPatternMapping();
			if (actualMapping == null || patternMapping == null)
			{
				return;
			}
			
			String newBehaviorPattern = getCheckedMapping(patternMapping.getBehaviorPattern(), actualMapping.getBehaviorPattern());
			if (newBehaviorPattern != null)
			{
				patternMapping.setBehaviorPattern(newBehaviorPattern);
			}
			
			String newClassPattern = getCheckedMapping(patternMapping.getClassPattern(), actualMapping.getClassPattern());
			if (newClassPattern != null)
			{
				patternMapping.setClassPattern(newClassPattern);
			}
			
			String newPackagePattern = getCheckedMapping(patternMapping.getPackagePattern(), actualMapping.getPackagePattern());
			if (newPackagePattern != null)
			{
				patternMapping.setPackagePattern(newPackagePattern);
			}
			
			String newJavaFilePattern = getCheckedMapping(patternMapping.getJavaFilePattern(), actualMapping.getJavaFilePattern());
			if (newJavaFilePattern != null)
			{
				patternMapping.setJavaFilePattern(newJavaFilePattern);
			}
		}
	}
	
	private String getCheckedMapping(String currentMapping, String mapping)
	{
		if (mapping == null || mapping.trim().length() < 0)
		{
			return null;
		}
		
		if (currentMapping == null || currentMapping.indexOf(mapping) < 0)
		{
			StringBuilder st = new StringBuilder();
			if (currentMapping != null)
			{
				st.append(currentMapping);
				st.append("|");
			}
			st.append(mapping);
			return st.toString();
		}

		return null;
	}
	
} //GeneralExecutionConditionImpl
