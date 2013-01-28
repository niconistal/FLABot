/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic;

import org.eclipse.emf.common.util.EList;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologElement;
import org.isistan.flabot.launcher.filter.filtermodel.LogFilter;
import org.isistan.flabot.mapping.mappingmodel.PatternMapping;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>General Execution Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getFields <em>Fields</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getReturnedValue <em>Returned Value</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getInternalMethodCalls <em>Internal Method Calls</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getScope <em>Scope</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getException <em>Exception</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getPatternMapping <em>Pattern Mapping</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getInstanceOfClass <em>Instance Of Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getExecutionCondition()
 * @model
 * @generated
 */
public interface ExecutionCondition extends TreeStructuredElement, PrologElement {
	/**
	 * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
	 * The list contents are of type {@link org.isistan.flabot.executionstatemapping.model.semantic.FieldEvaluationCondition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fields</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fields</em>' containment reference list.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getExecutionCondition_Fields()
	 * @model containment="true"
	 * @generated
	 */
	EList<FieldEvaluationCondition> getFields();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.isistan.flabot.executionstatemapping.model.semantic.ParameterEvaluationCondition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getExecutionCondition_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterEvaluationCondition> getParameters();

	/**
	 * Returns the value of the '<em><b>Returned Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Returned Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Returned Value</em>' containment reference.
	 * @see #setReturnedValue(ReturnedValueEvaluationCondition)
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getExecutionCondition_ReturnedValue()
	 * @model containment="true"
	 * @generated
	 */
	ReturnedValueEvaluationCondition getReturnedValue();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getReturnedValue <em>Returned Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Returned Value</em>' containment reference.
	 * @see #getReturnedValue()
	 * @generated
	 */
	void setReturnedValue(ReturnedValueEvaluationCondition value);

	/**
	 * Returns the value of the '<em><b>Internal Method Calls</b></em>' containment reference list.
	 * The list contents are of type {@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Method Calls</em>' containment reference list.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getExecutionCondition_InternalMethodCalls()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExecutionCondition> getInternalMethodCalls();
	
	/**
	 * Returns the value of the '<em><b>Scope</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope</em>' containment reference.
	 * @see #setScope(ScopeEvaluationCondition)
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getExecutionCondition_Scope()
	 * @model containment="true"
	 * @generated
	 */
	ScopeEvaluationCondition getScope();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getScope <em>Scope</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' containment reference.
	 * @see #getScope()
	 * @generated
	 */
	void setScope(ScopeEvaluationCondition value);

	/**
	 * Returns the value of the '<em><b>Exception</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception</em>' containment reference.
	 * @see #setException(ExceptionEvaluationCondition)
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getExecutionCondition_Exception()
	 * @model containment="true"
	 * @generated
	 */
	ExceptionEvaluationCondition getException();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getException <em>Exception</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception</em>' containment reference.
	 * @see #getException()
	 * @generated
	 */
	void setException(ExceptionEvaluationCondition value);

	/**
	 * Returns the value of the '<em><b>Pattern Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern Mapping</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern Mapping</em>' containment reference.
	 * @see #setPatternMapping(PatternMapping)
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getExecutionCondition_PatternMapping()
	 * @model containment="true"
	 * @generated
	 */
	PatternMapping getPatternMapping();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getPatternMapping <em>Pattern Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern Mapping</em>' containment reference.
	 * @see #getPatternMapping()
	 * @generated
	 */
	void setPatternMapping(PatternMapping value);

	/**
	 * Returns the value of the '<em><b>Instance Of Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Of Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Of Class</em>' attribute.
	 * @see #setInstanceOfClass(String)
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getExecutionCondition_InstanceOfClass()
	 * @model
	 * @generated
	 */
	String getInstanceOfClass();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getInstanceOfClass <em>Instance Of Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Of Class</em>' attribute.
	 * @see #getInstanceOfClass()
	 * @generated
	 */
	void setInstanceOfClass(String value);

	boolean isMethodExecutionCondition();

	void checkFilter(LogFilter logFilter);		
	
	boolean passesMapping(PatternMapping patternMapping);
	
	void checkMapping(PatternMapping patternMapping);

} // GeneralExecutionCondition
