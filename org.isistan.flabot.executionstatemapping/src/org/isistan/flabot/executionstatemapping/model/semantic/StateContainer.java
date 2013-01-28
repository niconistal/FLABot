package org.isistan.flabot.executionstatemapping.model.semantic;

import org.eclipse.emf.common.util.EList;
import org.isistan.flabot.launcher.filter.filtermodel.LogFilter;
import org.isistan.flabot.mapping.mappingmodel.PatternMapping;

/**
 * @model
 */
public interface StateContainer extends TreeStructuredElement {    
    
	/**
     * @model type="State" containment="true"
     */
    EList<State> getStates();
    
    /**
     * @model type="State"
     */
    EList<State> getInicialStates();
    
    /**
     * @model type="State"
     */
    EList<State> getFinalStates();

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
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getStateContainer_PreFilters()
	 * @model
	 * @generated
	 */
	EList<ExecutionCondition> getPreFilters();

				/**
	 * Returns the value of the '<em><b>Transition Conditions</b></em>' containment reference list.
	 * The list contents are of type {@link org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transition Conditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transition Conditions</em>' containment reference list.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getStateContainer_TransitionConditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<TransitionCondition> getTransitionConditions();

	/**
	 * Returns the value of the '<em><b>Default State</b></em>' attribute.
	 * The default value is <code>"NotExecuted"</code>.
	 * The literals are from the enumeration {@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default State</em>' attribute.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue
	 * @see #setDefaultState(ExecutionStateValue)
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getStateContainer_DefaultState()
	 * @model default="NotExecuted"
	 * @generated
	 */
	ExecutionStateValue getDefaultState();

				/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.StateContainer#getDefaultState <em>Default State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default State</em>' attribute.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue
	 * @see #getDefaultState()
	 * @generated
	 */
	void setDefaultState(ExecutionStateValue value);

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
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getStateContainer_ExceptionState()
	 * @model default="NONE"
	 * @generated
	 */
	ExecutionStateValue getExceptionState();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.StateContainer#getExceptionState <em>Exception State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception State</em>' attribute.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue
	 * @see #getExceptionState()
	 * @generated
	 */
	void setExceptionState(ExecutionStateValue value);

	boolean passesMapping(PatternMapping[] patternMapping);
	
	void checkMapping(PatternMapping patterMapping);
	
	void checkFilter(LogFilter logFilter);
}