/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.isistan.flabot.launcher.filter.filtermodel.LogFilter;
import org.isistan.flabot.mapping.mappingmodel.PatternMapping;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Execution Condition Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration#getSimpleExpressionExecutionConditions <em>Simple Expression Execution Conditions</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration#getExecutionConditionNotVerifiedState <em>Execution Condition Not Verified State</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration#getExceptionState <em>Exception State</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration#getPreFilters <em>Pre Filters</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration#isUseDefaultConfiguration <em>Use Default Configuration</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration#isUseCustomConfiguration <em>Use Custom Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getSimpleExecutionConditionConfiguration()
 * @model
 * @generated
 */
public interface SimpleExecutionConditionConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Simple Expression Execution Conditions</b></em>' containment reference list.
	 * The list contents are of type {@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Expression Execution Conditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Expression Execution Conditions</em>' containment reference list.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getSimpleExecutionConditionConfiguration_SimpleExpressionExecutionConditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<SimpleExpressionExecutionCondition> getSimpleExpressionExecutionConditions();

	/**
	 * Returns the value of the '<em><b>Execution Condition Not Verified State</b></em>' attribute.
	 * The default value is <code>"NONE"</code>.
	 * The literals are from the enumeration {@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution Condition Not Verified State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Condition Not Verified State</em>' attribute.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue
	 * @see #setExecutionConditionNotVerifiedState(ExecutionStateValue)
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getSimpleExecutionConditionConfiguration_ExecutionConditionNotVerifiedState()
	 * @model default="NONE"
	 * @generated
	 */
	ExecutionStateValue getExecutionConditionNotVerifiedState();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration#getExecutionConditionNotVerifiedState <em>Execution Condition Not Verified State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution Condition Not Verified State</em>' attribute.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue
	 * @see #getExecutionConditionNotVerifiedState()
	 * @generated
	 */
	void setExecutionConditionNotVerifiedState(ExecutionStateValue value);

	/**
	 * Returns the value of the '<em><b>Exception State</b></em>' attribute.
	 * The default value is <code>"NONE"</code>.
	 * The literals are from the enumeration {@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception State</em>' attribute.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue
	 * @see #setExceptionState(ExecutionStateValue)
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getSimpleExecutionConditionConfiguration_ExceptionState()
	 * @model default="NONE"
	 * @generated
	 */
	ExecutionStateValue getExceptionState();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration#getExceptionState <em>Exception State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception State</em>' attribute.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue
	 * @see #getExceptionState()
	 * @generated
	 */
	void setExceptionState(ExecutionStateValue value);

	/**
	 * Returns the value of the '<em><b>Pre Filters</b></em>' reference list.
	 * The list contents are of type {@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre Filters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre Filters</em>' reference list.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getSimpleExecutionConditionConfiguration_PreFilters()
	 * @model
	 * @generated
	 */
	EList<ExecutionCondition> getPreFilters();

	/**
	 * Returns the value of the '<em><b>Use Default Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Default Configuration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Default Configuration</em>' attribute.
	 * @see #setUseDefaultConfiguration(boolean)
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getSimpleExecutionConditionConfiguration_UseDefaultConfiguration()
	 * @model
	 * @generated
	 */
	boolean isUseDefaultConfiguration();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration#isUseDefaultConfiguration <em>Use Default Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Default Configuration</em>' attribute.
	 * @see #isUseDefaultConfiguration()
	 * @generated
	 */
	void setUseDefaultConfiguration(boolean value);

	/**
	 * Returns the value of the '<em><b>Use Custom Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Custom Configuration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Custom Configuration</em>' attribute.
	 * @see #setUseCustomConfiguration(boolean)
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getSimpleExecutionConditionConfiguration_UseCustomConfiguration()
	 * @model
	 * @generated
	 */
	boolean isUseCustomConfiguration();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration#isUseCustomConfiguration <em>Use Custom Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Custom Configuration</em>' attribute.
	 * @see #isUseCustomConfiguration()
	 * @generated
	 */
	void setUseCustomConfiguration(boolean value);
	
	void resetProlog();
	
	void checkFilter(LogFilter logFilter);
	
	void checkMapping(PatternMapping patternMapping);

} // SimpleExecutionConditionConfiguration
