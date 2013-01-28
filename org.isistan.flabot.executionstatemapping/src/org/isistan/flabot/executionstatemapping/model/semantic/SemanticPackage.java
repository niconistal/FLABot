/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticFactory
 * @model kind="package"
 * @generated
 */
public interface SemanticPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "semantic";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/isistan/flabot/executionstatemapping/model.ecore#//semantic";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.isistan.flabot.executionstatemapping.model.semantic";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SemanticPackage eINSTANCE = org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.NamedElementImpl
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 0;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.TreeStructuredElementImpl <em>Tree Structured Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.TreeStructuredElementImpl
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getTreeStructuredElement()
	 * @generated
	 */
	int TREE_STRUCTURED_ELEMENT = 13;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.MappedTreeStructuredElementImpl <em>Mapped Tree Structured Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.MappedTreeStructuredElementImpl
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getMappedTreeStructuredElement()
	 * @generated
	 */
	int MAPPED_TREE_STRUCTURED_ELEMENT = 14;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.EvaluationConditionImpl <em>Evaluation Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.EvaluationConditionImpl
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getEvaluationCondition()
	 * @generated
	 */
	int EVALUATION_CONDITION = 2;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.FieldEvaluationConditionImpl <em>Field Evaluation Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.FieldEvaluationConditionImpl
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getFieldEvaluationCondition()
	 * @generated
	 */
	int FIELD_EVALUATION_CONDITION = 5;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.ParameterEvaluationConditionImpl <em>Parameter Evaluation Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.ParameterEvaluationConditionImpl
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getParameterEvaluationCondition()
	 * @generated
	 */
	int PARAMETER_EVALUATION_CONDITION = 6;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.ReturnedValueEvaluationConditionImpl <em>Returned Value Evaluation Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.ReturnedValueEvaluationConditionImpl
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getReturnedValueEvaluationCondition()
	 * @generated
	 */
	int RETURNED_VALUE_EVALUATION_CONDITION = 7;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.StateContainerImpl <em>State Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.StateContainerImpl
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getStateContainer()
	 * @generated
	 */
	int STATE_CONTAINER = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.StateImpl
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getState()
	 * @generated
	 */
	int STATE = 9;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.TransitionConditionImpl <em>Transition Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.TransitionConditionImpl
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getTransitionCondition()
	 * @generated
	 */
	int TRANSITION_CONDITION = 11;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.EStringToTreeStructuredElementImpl <em>EString To Tree Structured Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.EStringToTreeStructuredElementImpl
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getEStringToTreeStructuredElement()
	 * @generated
	 */
	int ESTRING_TO_TREE_STRUCTURED_ELEMENT = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_STRUCTURED_ELEMENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Tree Structured Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_STRUCTURED_ELEMENT__PARENT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_STRUCTURED_ELEMENT__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Persistent List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_STRUCTURED_ELEMENT__PERSISTENT_LIST = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Tree Structured Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_STRUCTURED_ELEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.ExecutionConditionImpl <em>Execution Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.ExecutionConditionImpl
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getExecutionCondition()
	 * @generated
	 */
	int EXECUTION_CONDITION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONDITION__NAME = TREE_STRUCTURED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Tree Structured Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONDITION__TREE_STRUCTURED_ELEMENTS = TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONDITION__PARENT = TREE_STRUCTURED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONDITION__TYPE = TREE_STRUCTURED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Persistent List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONDITION__PERSISTENT_LIST = TREE_STRUCTURED_ELEMENT__PERSISTENT_LIST;

	/**
	 * The feature id for the '<em><b>Predicate Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONDITION__PREDICATE_NAME = TREE_STRUCTURED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONDITION__FIELDS = TREE_STRUCTURED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONDITION__PARAMETERS = TREE_STRUCTURED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Returned Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONDITION__RETURNED_VALUE = TREE_STRUCTURED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Internal Method Calls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONDITION__INTERNAL_METHOD_CALLS = TREE_STRUCTURED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONDITION__SCOPE = TREE_STRUCTURED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONDITION__EXCEPTION = TREE_STRUCTURED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Pattern Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONDITION__PATTERN_MAPPING = TREE_STRUCTURED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Instance Of Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONDITION__INSTANCE_OF_CLASS = TREE_STRUCTURED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Execution Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONDITION_FEATURE_COUNT = TREE_STRUCTURED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_CONDITION__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_CONDITION__CONDITION = 1;

	/**
	 * The number of structural features of the '<em>Evaluation Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_CONDITION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.ExceptionEvaluationConditionImpl <em>Exception Evaluation Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.ExceptionEvaluationConditionImpl
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getExceptionEvaluationCondition()
	 * @generated
	 */
	int EXCEPTION_EVALUATION_CONDITION = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_EVALUATION_CONDITION__VALUE = EVALUATION_CONDITION__VALUE;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_EVALUATION_CONDITION__CONDITION = EVALUATION_CONDITION__CONDITION;

	/**
	 * The feature id for the '<em><b>Check Any Exception</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_EVALUATION_CONDITION__CHECK_ANY_EXCEPTION = EVALUATION_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Exception Evaluation Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_EVALUATION_CONDITION_FEATURE_COUNT = EVALUATION_CONDITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.FinalStateImpl <em>Final State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.FinalStateImpl
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getFinalState()
	 * @generated
	 */
	int FINAL_STATE = 10;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.AbstractExpressionImpl <em>Abstract Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.AbstractExpressionImpl
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getAbstractExpression()
	 * @generated
	 */
	int ABSTRACT_EXPRESSION = 15;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.BlockExpressionImpl <em>Block Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.BlockExpressionImpl
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getBlockExpression()
	 * @generated
	 */
	int BLOCK_EXPRESSION = 16;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.AndExpressionImpl <em>And Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.AndExpressionImpl
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getAndExpression()
	 * @generated
	 */
	int AND_EXPRESSION = 17;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.OrExpressionImpl <em>Or Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.OrExpressionImpl
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getOrExpression()
	 * @generated
	 */
	int OR_EXPRESSION = 18;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.SingleExpressionImpl <em>Single Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SingleExpressionImpl
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getSingleExpression()
	 * @generated
	 */
	int SINGLE_EXPRESSION = 19;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.ScopeEvaluationConditionImpl <em>Scope Evaluation Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.ScopeEvaluationConditionImpl
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getScopeEvaluationCondition()
	 * @generated
	 */
	int SCOPE_EVALUATION_CONDITION = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_EVALUATION_CONDITION__VALUE = EVALUATION_CONDITION__VALUE;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_EVALUATION_CONDITION__CONDITION = EVALUATION_CONDITION__CONDITION;

	/**
	 * The number of structural features of the '<em>Scope Evaluation Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_EVALUATION_CONDITION_FEATURE_COUNT = EVALUATION_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_EVALUATION_CONDITION__VALUE = EVALUATION_CONDITION__VALUE;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_EVALUATION_CONDITION__CONDITION = EVALUATION_CONDITION__CONDITION;

	/**
	 * The feature id for the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_EVALUATION_CONDITION__FIELD_NAME = EVALUATION_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Field Evaluation Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_EVALUATION_CONDITION_FEATURE_COUNT = EVALUATION_CONDITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_EVALUATION_CONDITION__VALUE = EVALUATION_CONDITION__VALUE;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_EVALUATION_CONDITION__CONDITION = EVALUATION_CONDITION__CONDITION;

	/**
	 * The feature id for the '<em><b>Parameter Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_EVALUATION_CONDITION__PARAMETER_POSITION = EVALUATION_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Field Evaluation Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_EVALUATION_CONDITION__FIELD_EVALUATION_CONDITIONS = EVALUATION_CONDITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parameter Evaluation Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_EVALUATION_CONDITION_FEATURE_COUNT = EVALUATION_CONDITION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURNED_VALUE_EVALUATION_CONDITION__VALUE = EVALUATION_CONDITION__VALUE;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURNED_VALUE_EVALUATION_CONDITION__CONDITION = EVALUATION_CONDITION__CONDITION;

	/**
	 * The number of structural features of the '<em>Returned Value Evaluation Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURNED_VALUE_EVALUATION_CONDITION_FEATURE_COUNT = EVALUATION_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_CONTAINER__NAME = TREE_STRUCTURED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Tree Structured Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_CONTAINER__TREE_STRUCTURED_ELEMENTS = TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_CONTAINER__PARENT = TREE_STRUCTURED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_CONTAINER__TYPE = TREE_STRUCTURED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Persistent List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_CONTAINER__PERSISTENT_LIST = TREE_STRUCTURED_ELEMENT__PERSISTENT_LIST;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_CONTAINER__STATES = TREE_STRUCTURED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inicial States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_CONTAINER__INICIAL_STATES = TREE_STRUCTURED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Final States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_CONTAINER__FINAL_STATES = TREE_STRUCTURED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Pre Filters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_CONTAINER__PRE_FILTERS = TREE_STRUCTURED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Transition Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_CONTAINER__TRANSITION_CONDITIONS = TREE_STRUCTURED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Default State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_CONTAINER__DEFAULT_STATE = TREE_STRUCTURED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Exception State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_CONTAINER__EXCEPTION_STATE = TREE_STRUCTURED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>State Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_CONTAINER_FEATURE_COUNT = TREE_STRUCTURED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NOTES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Transition Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__SOURCE_TRANSITION_CONDITIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Transition Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__TARGET_TRANSITION_CONDITIONS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>State Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__STATE_TYPE = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__NAME = STATE__NAME;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__NOTES = STATE__NOTES;

	/**
	 * The feature id for the '<em><b>Source Transition Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__SOURCE_TRANSITION_CONDITIONS = STATE__SOURCE_TRANSITION_CONDITIONS;

	/**
	 * The feature id for the '<em><b>Target Transition Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__TARGET_TRANSITION_CONDITIONS = STATE__TARGET_TRANSITION_CONDITIONS;

	/**
	 * The feature id for the '<em><b>State Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__STATE_TYPE = STATE__STATE_TYPE;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__EXECUTION_STATE = STATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Final State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.NotedElementImpl <em>Noted Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.NotedElementImpl
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getNotedElement()
	 * @generated
	 */
	int NOTED_ELEMENT = 21;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTED_ELEMENT__NOTES = 0;

	/**
	 * The number of structural features of the '<em>Noted Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_CONDITION__NOTES = NOTED_ELEMENT__NOTES;

	/**
	 * The feature id for the '<em><b>Source State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_CONDITION__SOURCE_STATE = NOTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_CONDITION__TARGET_STATE = NOTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Execution Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_CONDITION__EXECUTION_CONDITION = NOTED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Transition Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_CONDITION_FEATURE_COUNT = NOTED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_TREE_STRUCTURED_ELEMENT__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_TREE_STRUCTURED_ELEMENT__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EString To Tree Structured Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_TREE_STRUCTURED_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_TREE_STRUCTURED_ELEMENT__NAME = TREE_STRUCTURED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Tree Structured Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENTS = TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_TREE_STRUCTURED_ELEMENT__PARENT = TREE_STRUCTURED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_TREE_STRUCTURED_ELEMENT__TYPE = TREE_STRUCTURED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Persistent List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_TREE_STRUCTURED_ELEMENT__PERSISTENT_LIST = TREE_STRUCTURED_ELEMENT__PERSISTENT_LIST;

	/**
	 * The feature id for the '<em><b>Tree Structured Element Map</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENT_MAP = TREE_STRUCTURED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mapped Tree Structured Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_TREE_STRUCTURED_ELEMENT_FEATURE_COUNT = TREE_STRUCTURED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Predicate Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_EXPRESSION__PREDICATE_NAME = PrologPackage.PROLOG_ELEMENT__PREDICATE_NAME;

	/**
	 * The feature id for the '<em><b>Event Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_EXPRESSION__EVENT_TYPE = PrologPackage.PROLOG_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_EXPRESSION__PARENT_EXPRESSION = PrologPackage.PROLOG_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Not</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_EXPRESSION__IS_NOT = PrologPackage.PROLOG_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Abstract Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_EXPRESSION_FEATURE_COUNT = PrologPackage.PROLOG_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Predicate Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXPRESSION__PREDICATE_NAME = ABSTRACT_EXPRESSION__PREDICATE_NAME;

	/**
	 * The feature id for the '<em><b>Event Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXPRESSION__EVENT_TYPE = ABSTRACT_EXPRESSION__EVENT_TYPE;

	/**
	 * The feature id for the '<em><b>Parent Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXPRESSION__PARENT_EXPRESSION = ABSTRACT_EXPRESSION__PARENT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Is Not</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXPRESSION__IS_NOT = ABSTRACT_EXPRESSION__IS_NOT;

	/**
	 * The feature id for the '<em><b>Expression List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXPRESSION__EXPRESSION_LIST = ABSTRACT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXPRESSION_FEATURE_COUNT = ABSTRACT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Predicate Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION__PREDICATE_NAME = BLOCK_EXPRESSION__PREDICATE_NAME;

	/**
	 * The feature id for the '<em><b>Event Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION__EVENT_TYPE = BLOCK_EXPRESSION__EVENT_TYPE;

	/**
	 * The feature id for the '<em><b>Parent Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION__PARENT_EXPRESSION = BLOCK_EXPRESSION__PARENT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Is Not</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION__IS_NOT = BLOCK_EXPRESSION__IS_NOT;

	/**
	 * The feature id for the '<em><b>Expression List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION__EXPRESSION_LIST = BLOCK_EXPRESSION__EXPRESSION_LIST;

	/**
	 * The number of structural features of the '<em>And Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION_FEATURE_COUNT = BLOCK_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Predicate Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION__PREDICATE_NAME = BLOCK_EXPRESSION__PREDICATE_NAME;

	/**
	 * The feature id for the '<em><b>Event Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION__EVENT_TYPE = BLOCK_EXPRESSION__EVENT_TYPE;

	/**
	 * The feature id for the '<em><b>Parent Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION__PARENT_EXPRESSION = BLOCK_EXPRESSION__PARENT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Is Not</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION__IS_NOT = BLOCK_EXPRESSION__IS_NOT;

	/**
	 * The feature id for the '<em><b>Expression List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION__EXPRESSION_LIST = BLOCK_EXPRESSION__EXPRESSION_LIST;

	/**
	 * The number of structural features of the '<em>Or Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION_FEATURE_COUNT = BLOCK_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Predicate Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_EXPRESSION__PREDICATE_NAME = ABSTRACT_EXPRESSION__PREDICATE_NAME;

	/**
	 * The feature id for the '<em><b>Event Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_EXPRESSION__EVENT_TYPE = ABSTRACT_EXPRESSION__EVENT_TYPE;

	/**
	 * The feature id for the '<em><b>Parent Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_EXPRESSION__PARENT_EXPRESSION = ABSTRACT_EXPRESSION__PARENT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Is Not</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_EXPRESSION__IS_NOT = ABSTRACT_EXPRESSION__IS_NOT;

	/**
	 * The feature id for the '<em><b>Execution Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_EXPRESSION__EXECUTION_CONDITION = ABSTRACT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Single Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_EXPRESSION_FEATURE_COUNT = ABSTRACT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.SimpleExpressionExecutionConditionImpl <em>Simple Expression Execution Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SimpleExpressionExecutionConditionImpl
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getSimpleExpressionExecutionCondition()
	 * @generated
	 */
	int SIMPLE_EXPRESSION_EXECUTION_CONDITION = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXPRESSION_EXECUTION_CONDITION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXPRESSION_EXECUTION_CONDITION__EXECUTION_STATE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXPRESSION_EXECUTION_CONDITION__EXPRESSION = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Simple Expression Execution Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXPRESSION_EXECUTION_CONDITION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.VisitedExpression <em>Visited Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.VisitedExpression
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getVisitedExpression()
	 * @generated
	 */
	int VISITED_EXPRESSION = 22;

	/**
	 * The number of structural features of the '<em>Visited Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITED_EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.VisitorExpression <em>Visitor Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.VisitorExpression
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getVisitorExpression()
	 * @generated
	 */
	int VISITOR_EXPRESSION = 23;

	/**
	 * The number of structural features of the '<em>Visitor Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITOR_EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.SimpleExecutionConditionConfigurationImpl <em>Simple Execution Condition Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SimpleExecutionConditionConfigurationImpl
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getSimpleExecutionConditionConfiguration()
	 * @generated
	 */
	int SIMPLE_EXECUTION_CONDITION_CONFIGURATION = 24;

	/**
	 * The feature id for the '<em><b>Simple Expression Execution Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXECUTION_CONDITION_CONFIGURATION__SIMPLE_EXPRESSION_EXECUTION_CONDITIONS = 0;

	/**
	 * The feature id for the '<em><b>Execution Condition Not Verified State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXECUTION_CONDITION_CONFIGURATION__EXECUTION_CONDITION_NOT_VERIFIED_STATE = 1;

	/**
	 * The feature id for the '<em><b>Exception State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXECUTION_CONDITION_CONFIGURATION__EXCEPTION_STATE = 2;

	/**
	 * The feature id for the '<em><b>Pre Filters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXECUTION_CONDITION_CONFIGURATION__PRE_FILTERS = 3;

	/**
	 * The feature id for the '<em><b>Use Default Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXECUTION_CONDITION_CONFIGURATION__USE_DEFAULT_CONFIGURATION = 4;

	/**
	 * The feature id for the '<em><b>Use Custom Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXECUTION_CONDITION_CONFIGURATION__USE_CUSTOM_CONFIGURATION = 5;

	/**
	 * The number of structural features of the '<em>Simple Execution Condition Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXECUTION_CONDITION_CONFIGURATION_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.ConditionValue <em>Condition Value</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ConditionValue
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getConditionValue()
	 * @generated
	 */
	int CONDITION_VALUE = 25;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.TreeType <em>Tree Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.TreeType
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getTreeType()
	 * @generated
	 */
	int TREE_TYPE = 26;


	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.StateType <em>State Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.StateType
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getStateType()
	 * @generated
	 */
	int STATE_TYPE = 27;


	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.EventType <em>Event Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.EventType
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getEventType()
	 * @generated
	 */
	int EVENT_TYPE = 28;


	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue <em>Execution State Value</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getExecutionStateValue()
	 * @generated
	 */
	int EXECUTION_STATE_VALUE = 29;


	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.ScopeFilterType <em>Scope Filter Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ScopeFilterType
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getScopeFilterType()
	 * @generated
	 */
	int SCOPE_FILTER_TYPE = 30;


	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.EvaluationCondition <em>Evaluation Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evaluation Condition</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.EvaluationCondition
	 * @generated
	 */
	EClass getEvaluationCondition();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionstatemapping.model.semantic.EvaluationCondition#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.EvaluationCondition#getValue()
	 * @see #getEvaluationCondition()
	 * @generated
	 */
	EAttribute getEvaluationCondition_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionstatemapping.model.semantic.EvaluationCondition#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.EvaluationCondition#getCondition()
	 * @see #getEvaluationCondition()
	 * @generated
	 */
	EAttribute getEvaluationCondition_Condition();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.ExceptionEvaluationCondition <em>Exception Evaluation Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exception Evaluation Condition</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExceptionEvaluationCondition
	 * @generated
	 */
	EClass getExceptionEvaluationCondition();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionstatemapping.model.semantic.ExceptionEvaluationCondition#isCheckAnyException <em>Check Any Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Check Any Exception</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExceptionEvaluationCondition#isCheckAnyException()
	 * @see #getExceptionEvaluationCondition()
	 * @generated
	 */
	EAttribute getExceptionEvaluationCondition_CheckAnyException();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.ScopeEvaluationCondition <em>Scope Evaluation Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scope Evaluation Condition</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ScopeEvaluationCondition
	 * @generated
	 */
	EClass getScopeEvaluationCondition();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.FieldEvaluationCondition <em>Field Evaluation Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field Evaluation Condition</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.FieldEvaluationCondition
	 * @generated
	 */
	EClass getFieldEvaluationCondition();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionstatemapping.model.semantic.FieldEvaluationCondition#getFieldName <em>Field Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field Name</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.FieldEvaluationCondition#getFieldName()
	 * @see #getFieldEvaluationCondition()
	 * @generated
	 */
	EAttribute getFieldEvaluationCondition_FieldName();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.ParameterEvaluationCondition <em>Parameter Evaluation Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Evaluation Condition</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ParameterEvaluationCondition
	 * @generated
	 */
	EClass getParameterEvaluationCondition();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionstatemapping.model.semantic.ParameterEvaluationCondition#getParameterPosition <em>Parameter Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter Position</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ParameterEvaluationCondition#getParameterPosition()
	 * @see #getParameterEvaluationCondition()
	 * @generated
	 */
	EAttribute getParameterEvaluationCondition_ParameterPosition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.executionstatemapping.model.semantic.ParameterEvaluationCondition#getFieldEvaluationConditions <em>Field Evaluation Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Field Evaluation Conditions</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ParameterEvaluationCondition#getFieldEvaluationConditions()
	 * @see #getParameterEvaluationCondition()
	 * @generated
	 */
	EReference getParameterEvaluationCondition_FieldEvaluationConditions();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.ReturnedValueEvaluationCondition <em>Returned Value Evaluation Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Returned Value Evaluation Condition</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ReturnedValueEvaluationCondition
	 * @generated
	 */
	EClass getReturnedValueEvaluationCondition();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.StateContainer <em>State Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Container</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.StateContainer
	 * @generated
	 */
	EClass getStateContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.executionstatemapping.model.semantic.StateContainer#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.StateContainer#getStates()
	 * @see #getStateContainer()
	 * @generated
	 */
	EReference getStateContainer_States();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.executionstatemapping.model.semantic.StateContainer#getInicialStates <em>Inicial States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inicial States</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.StateContainer#getInicialStates()
	 * @see #getStateContainer()
	 * @generated
	 */
	EReference getStateContainer_InicialStates();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.executionstatemapping.model.semantic.StateContainer#getFinalStates <em>Final States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Final States</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.StateContainer#getFinalStates()
	 * @see #getStateContainer()
	 * @generated
	 */
	EReference getStateContainer_FinalStates();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.executionstatemapping.model.semantic.StateContainer#getPreFilters <em>Pre Filters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Pre Filters</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.StateContainer#getPreFilters()
	 * @see #getStateContainer()
	 * @generated
	 */
	EReference getStateContainer_PreFilters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.executionstatemapping.model.semantic.StateContainer#getTransitionConditions <em>Transition Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transition Conditions</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.StateContainer#getTransitionConditions()
	 * @see #getStateContainer()
	 * @generated
	 */
	EReference getStateContainer_TransitionConditions();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionstatemapping.model.semantic.StateContainer#getDefaultState <em>Default State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default State</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.StateContainer#getDefaultState()
	 * @see #getStateContainer()
	 * @generated
	 */
	EAttribute getStateContainer_DefaultState();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionstatemapping.model.semantic.StateContainer#getExceptionState <em>Exception State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exception State</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.StateContainer#getExceptionState()
	 * @see #getStateContainer()
	 * @generated
	 */
	EAttribute getStateContainer_ExceptionState();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.executionstatemapping.model.semantic.State#getSourceTransitionConditions <em>Source Transition Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source Transition Conditions</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.State#getSourceTransitionConditions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_SourceTransitionConditions();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.executionstatemapping.model.semantic.State#getTargetTransitionConditions <em>Target Transition Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Transition Conditions</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.State#getTargetTransitionConditions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_TargetTransitionConditions();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionstatemapping.model.semantic.State#getStateType <em>State Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State Type</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.State#getStateType()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_StateType();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.FinalState <em>Final State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Final State</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.FinalState
	 * @generated
	 */
	EClass getFinalState();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionstatemapping.model.semantic.FinalState#getExecutionState <em>Execution State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Execution State</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.FinalState#getExecutionState()
	 * @see #getFinalState()
	 * @generated
	 */
	EAttribute getFinalState_ExecutionState();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition <em>Transition Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition Condition</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition
	 * @generated
	 */
	EClass getTransitionCondition();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition#getSourceState <em>Source State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source State</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition#getSourceState()
	 * @see #getTransitionCondition()
	 * @generated
	 */
	EReference getTransitionCondition_SourceState();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition#getTargetState <em>Target State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target State</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition#getTargetState()
	 * @see #getTransitionCondition()
	 * @generated
	 */
	EReference getTransitionCondition_TargetState();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition#getExecutionCondition <em>Execution Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Execution Condition</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition#getExecutionCondition()
	 * @see #getTransitionCondition()
	 * @generated
	 */
	EReference getTransitionCondition_ExecutionCondition();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionstatemapping.model.semantic.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition <em>Execution Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Condition</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition
	 * @generated
	 */
	EClass getExecutionCondition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fields</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getFields()
	 * @see #getExecutionCondition()
	 * @generated
	 */
	EReference getExecutionCondition_Fields();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getParameters()
	 * @see #getExecutionCondition()
	 * @generated
	 */
	EReference getExecutionCondition_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getReturnedValue <em>Returned Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Returned Value</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getReturnedValue()
	 * @see #getExecutionCondition()
	 * @generated
	 */
	EReference getExecutionCondition_ReturnedValue();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getInternalMethodCalls <em>Internal Method Calls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Internal Method Calls</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getInternalMethodCalls()
	 * @see #getExecutionCondition()
	 * @generated
	 */
	EReference getExecutionCondition_InternalMethodCalls();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scope</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getScope()
	 * @see #getExecutionCondition()
	 * @generated
	 */
	EReference getExecutionCondition_Scope();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exception</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getException()
	 * @see #getExecutionCondition()
	 * @generated
	 */
	EReference getExecutionCondition_Exception();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getPatternMapping <em>Pattern Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pattern Mapping</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getPatternMapping()
	 * @see #getExecutionCondition()
	 * @generated
	 */
	EReference getExecutionCondition_PatternMapping();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getInstanceOfClass <em>Instance Of Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Of Class</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition#getInstanceOfClass()
	 * @see #getExecutionCondition()
	 * @generated
	 */
	EAttribute getExecutionCondition_InstanceOfClass();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EString To Tree Structured Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EString To Tree Structured Element</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDefault="" keyDataType="org.eclipse.emf.ecore.EString" keyTransient="true"
	 *        valueType="org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement" valueTransient="true"
	 * @generated
	 */
	EClass getEStringToTreeStructuredElement();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToTreeStructuredElement()
	 * @generated
	 */
	EAttribute getEStringToTreeStructuredElement_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToTreeStructuredElement()
	 * @generated
	 */
	EReference getEStringToTreeStructuredElement_Value();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement <em>Tree Structured Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tree Structured Element</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement
	 * @generated
	 */
	EClass getTreeStructuredElement();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement#getTreeStructuredElements <em>Tree Structured Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tree Structured Elements</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement#getTreeStructuredElements()
	 * @see #getTreeStructuredElement()
	 * @generated
	 */
	EReference getTreeStructuredElement_TreeStructuredElements();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement#getParent()
	 * @see #getTreeStructuredElement()
	 * @generated
	 */
	EReference getTreeStructuredElement_Parent();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement#getType()
	 * @see #getTreeStructuredElement()
	 * @generated
	 */
	EAttribute getTreeStructuredElement_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement#getPersistentList <em>Persistent List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Persistent List</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement#getPersistentList()
	 * @see #getTreeStructuredElement()
	 * @generated
	 */
	EReference getTreeStructuredElement_PersistentList();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.MappedTreeStructuredElement <em>Mapped Tree Structured Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapped Tree Structured Element</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.MappedTreeStructuredElement
	 * @generated
	 */
	EClass getMappedTreeStructuredElement();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.executionstatemapping.model.semantic.MappedTreeStructuredElement#getTreeStructuredElementMap <em>Tree Structured Element Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tree Structured Element Map</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.MappedTreeStructuredElement#getTreeStructuredElementMap()
	 * @see #getMappedTreeStructuredElement()
	 * @generated
	 */
	EReference getMappedTreeStructuredElement_TreeStructuredElementMap();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression <em>Abstract Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Expression</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression
	 * @generated
	 */
	EClass getAbstractExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression#getEventType <em>Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event Type</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression#getEventType()
	 * @see #getAbstractExpression()
	 * @generated
	 */
	EAttribute getAbstractExpression_EventType();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression#getParentExpression <em>Parent Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Expression</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression#getParentExpression()
	 * @see #getAbstractExpression()
	 * @generated
	 */
	EReference getAbstractExpression_ParentExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression#isIsNot <em>Is Not</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Not</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression#isIsNot()
	 * @see #getAbstractExpression()
	 * @generated
	 */
	EAttribute getAbstractExpression_IsNot();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.BlockExpression <em>Block Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Expression</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.BlockExpression
	 * @generated
	 */
	EClass getBlockExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.executionstatemapping.model.semantic.BlockExpression#getExpressionList <em>Expression List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expression List</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.BlockExpression#getExpressionList()
	 * @see #getBlockExpression()
	 * @generated
	 */
	EReference getBlockExpression_ExpressionList();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.AndExpression <em>And Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Expression</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.AndExpression
	 * @generated
	 */
	EClass getAndExpression();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.OrExpression <em>Or Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Expression</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.OrExpression
	 * @generated
	 */
	EClass getOrExpression();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.SingleExpression <em>Single Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Expression</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SingleExpression
	 * @generated
	 */
	EClass getSingleExpression();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.executionstatemapping.model.semantic.SingleExpression#getExecutionCondition <em>Execution Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Execution Condition</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SingleExpression#getExecutionCondition()
	 * @see #getSingleExpression()
	 * @generated
	 */
	EReference getSingleExpression_ExecutionCondition();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition <em>Simple Expression Execution Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Expression Execution Condition</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition
	 * @generated
	 */
	EClass getSimpleExpressionExecutionCondition();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition#getExecutionState <em>Execution State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Execution State</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition#getExecutionState()
	 * @see #getSimpleExpressionExecutionCondition()
	 * @generated
	 */
	EAttribute getSimpleExpressionExecutionCondition_ExecutionState();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition#getExpression()
	 * @see #getSimpleExpressionExecutionCondition()
	 * @generated
	 */
	EReference getSimpleExpressionExecutionCondition_Expression();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.NotedElement <em>Noted Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Noted Element</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.NotedElement
	 * @generated
	 */
	EClass getNotedElement();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.executionstatemapping.model.semantic.NotedElement#getNotes <em>Notes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Notes</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.NotedElement#getNotes()
	 * @see #getNotedElement()
	 * @generated
	 */
	EReference getNotedElement_Notes();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.VisitedExpression <em>Visited Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visited Expression</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.VisitedExpression
	 * @generated
	 */
	EClass getVisitedExpression();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.VisitorExpression <em>Visitor Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitor Expression</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.VisitorExpression
	 * @generated
	 */
	EClass getVisitorExpression();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration <em>Simple Execution Condition Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Execution Condition Configuration</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration
	 * @generated
	 */
	EClass getSimpleExecutionConditionConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration#getSimpleExpressionExecutionConditions <em>Simple Expression Execution Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Simple Expression Execution Conditions</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration#getSimpleExpressionExecutionConditions()
	 * @see #getSimpleExecutionConditionConfiguration()
	 * @generated
	 */
	EReference getSimpleExecutionConditionConfiguration_SimpleExpressionExecutionConditions();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration#getExecutionConditionNotVerifiedState <em>Execution Condition Not Verified State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Execution Condition Not Verified State</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration#getExecutionConditionNotVerifiedState()
	 * @see #getSimpleExecutionConditionConfiguration()
	 * @generated
	 */
	EAttribute getSimpleExecutionConditionConfiguration_ExecutionConditionNotVerifiedState();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration#getExceptionState <em>Exception State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exception State</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration#getExceptionState()
	 * @see #getSimpleExecutionConditionConfiguration()
	 * @generated
	 */
	EAttribute getSimpleExecutionConditionConfiguration_ExceptionState();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration#getPreFilters <em>Pre Filters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Pre Filters</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration#getPreFilters()
	 * @see #getSimpleExecutionConditionConfiguration()
	 * @generated
	 */
	EReference getSimpleExecutionConditionConfiguration_PreFilters();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration#isUseDefaultConfiguration <em>Use Default Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Default Configuration</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration#isUseDefaultConfiguration()
	 * @see #getSimpleExecutionConditionConfiguration()
	 * @generated
	 */
	EAttribute getSimpleExecutionConditionConfiguration_UseDefaultConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration#isUseCustomConfiguration <em>Use Custom Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Custom Configuration</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration#isUseCustomConfiguration()
	 * @see #getSimpleExecutionConditionConfiguration()
	 * @generated
	 */
	EAttribute getSimpleExecutionConditionConfiguration_UseCustomConfiguration();

	/**
	 * Returns the meta object for enum '{@link org.isistan.flabot.executionstatemapping.model.semantic.ConditionValue <em>Condition Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Condition Value</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ConditionValue
	 * @generated
	 */
	EEnum getConditionValue();

	/**
	 * Returns the meta object for enum '{@link org.isistan.flabot.executionstatemapping.model.semantic.TreeType <em>Tree Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Tree Type</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.TreeType
	 * @generated
	 */
	EEnum getTreeType();

	/**
	 * Returns the meta object for enum '{@link org.isistan.flabot.executionstatemapping.model.semantic.StateType <em>State Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>State Type</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.StateType
	 * @generated
	 */
	EEnum getStateType();

	/**
	 * Returns the meta object for enum '{@link org.isistan.flabot.executionstatemapping.model.semantic.EventType <em>Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Event Type</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.EventType
	 * @generated
	 */
	EEnum getEventType();

	/**
	 * Returns the meta object for enum '{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue <em>Execution State Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Execution State Value</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue
	 * @generated
	 */
	EEnum getExecutionStateValue();

	/**
	 * Returns the meta object for enum '{@link org.isistan.flabot.executionstatemapping.model.semantic.ScopeFilterType <em>Scope Filter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Scope Filter Type</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.ScopeFilterType
	 * @generated
	 */
	EEnum getScopeFilterType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SemanticFactory getSemanticFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.EvaluationConditionImpl <em>Evaluation Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.EvaluationConditionImpl
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getEvaluationCondition()
		 * @generated
		 */
		EClass EVALUATION_CONDITION = eINSTANCE.getEvaluationCondition();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVALUATION_CONDITION__VALUE = eINSTANCE.getEvaluationCondition_Value();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVALUATION_CONDITION__CONDITION = eINSTANCE.getEvaluationCondition_Condition();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.ExceptionEvaluationConditionImpl <em>Exception Evaluation Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.ExceptionEvaluationConditionImpl
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getExceptionEvaluationCondition()
		 * @generated
		 */
		EClass EXCEPTION_EVALUATION_CONDITION = eINSTANCE.getExceptionEvaluationCondition();

		/**
		 * The meta object literal for the '<em><b>Check Any Exception</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXCEPTION_EVALUATION_CONDITION__CHECK_ANY_EXCEPTION = eINSTANCE.getExceptionEvaluationCondition_CheckAnyException();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.ScopeEvaluationConditionImpl <em>Scope Evaluation Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.ScopeEvaluationConditionImpl
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getScopeEvaluationCondition()
		 * @generated
		 */
		EClass SCOPE_EVALUATION_CONDITION = eINSTANCE.getScopeEvaluationCondition();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.FieldEvaluationConditionImpl <em>Field Evaluation Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.FieldEvaluationConditionImpl
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getFieldEvaluationCondition()
		 * @generated
		 */
		EClass FIELD_EVALUATION_CONDITION = eINSTANCE.getFieldEvaluationCondition();

		/**
		 * The meta object literal for the '<em><b>Field Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD_EVALUATION_CONDITION__FIELD_NAME = eINSTANCE.getFieldEvaluationCondition_FieldName();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.ParameterEvaluationConditionImpl <em>Parameter Evaluation Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.ParameterEvaluationConditionImpl
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getParameterEvaluationCondition()
		 * @generated
		 */
		EClass PARAMETER_EVALUATION_CONDITION = eINSTANCE.getParameterEvaluationCondition();

		/**
		 * The meta object literal for the '<em><b>Parameter Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_EVALUATION_CONDITION__PARAMETER_POSITION = eINSTANCE.getParameterEvaluationCondition_ParameterPosition();

		/**
		 * The meta object literal for the '<em><b>Field Evaluation Conditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_EVALUATION_CONDITION__FIELD_EVALUATION_CONDITIONS = eINSTANCE.getParameterEvaluationCondition_FieldEvaluationConditions();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.ReturnedValueEvaluationConditionImpl <em>Returned Value Evaluation Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.ReturnedValueEvaluationConditionImpl
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getReturnedValueEvaluationCondition()
		 * @generated
		 */
		EClass RETURNED_VALUE_EVALUATION_CONDITION = eINSTANCE.getReturnedValueEvaluationCondition();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.StateContainerImpl <em>State Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.StateContainerImpl
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getStateContainer()
		 * @generated
		 */
		EClass STATE_CONTAINER = eINSTANCE.getStateContainer();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_CONTAINER__STATES = eINSTANCE.getStateContainer_States();

		/**
		 * The meta object literal for the '<em><b>Inicial States</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_CONTAINER__INICIAL_STATES = eINSTANCE.getStateContainer_InicialStates();

		/**
		 * The meta object literal for the '<em><b>Final States</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_CONTAINER__FINAL_STATES = eINSTANCE.getStateContainer_FinalStates();

		/**
		 * The meta object literal for the '<em><b>Pre Filters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_CONTAINER__PRE_FILTERS = eINSTANCE.getStateContainer_PreFilters();

		/**
		 * The meta object literal for the '<em><b>Transition Conditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_CONTAINER__TRANSITION_CONDITIONS = eINSTANCE.getStateContainer_TransitionConditions();

		/**
		 * The meta object literal for the '<em><b>Default State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_CONTAINER__DEFAULT_STATE = eINSTANCE.getStateContainer_DefaultState();

		/**
		 * The meta object literal for the '<em><b>Exception State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_CONTAINER__EXCEPTION_STATE = eINSTANCE.getStateContainer_ExceptionState();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.StateImpl
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Source Transition Conditions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__SOURCE_TRANSITION_CONDITIONS = eINSTANCE.getState_SourceTransitionConditions();

		/**
		 * The meta object literal for the '<em><b>Target Transition Conditions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__TARGET_TRANSITION_CONDITIONS = eINSTANCE.getState_TargetTransitionConditions();

		/**
		 * The meta object literal for the '<em><b>State Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__STATE_TYPE = eINSTANCE.getState_StateType();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.FinalStateImpl <em>Final State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.FinalStateImpl
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getFinalState()
		 * @generated
		 */
		EClass FINAL_STATE = eINSTANCE.getFinalState();

		/**
		 * The meta object literal for the '<em><b>Execution State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FINAL_STATE__EXECUTION_STATE = eINSTANCE.getFinalState_ExecutionState();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.TransitionConditionImpl <em>Transition Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.TransitionConditionImpl
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getTransitionCondition()
		 * @generated
		 */
		EClass TRANSITION_CONDITION = eINSTANCE.getTransitionCondition();

		/**
		 * The meta object literal for the '<em><b>Source State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION_CONDITION__SOURCE_STATE = eINSTANCE.getTransitionCondition_SourceState();

		/**
		 * The meta object literal for the '<em><b>Target State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION_CONDITION__TARGET_STATE = eINSTANCE.getTransitionCondition_TargetState();

		/**
		 * The meta object literal for the '<em><b>Execution Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION_CONDITION__EXECUTION_CONDITION = eINSTANCE.getTransitionCondition_ExecutionCondition();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.NamedElementImpl
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.ExecutionConditionImpl <em>Execution Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.ExecutionConditionImpl
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getExecutionCondition()
		 * @generated
		 */
		EClass EXECUTION_CONDITION = eINSTANCE.getExecutionCondition();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_CONDITION__FIELDS = eINSTANCE.getExecutionCondition_Fields();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_CONDITION__PARAMETERS = eINSTANCE.getExecutionCondition_Parameters();

		/**
		 * The meta object literal for the '<em><b>Returned Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_CONDITION__RETURNED_VALUE = eINSTANCE.getExecutionCondition_ReturnedValue();

		/**
		 * The meta object literal for the '<em><b>Internal Method Calls</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_CONDITION__INTERNAL_METHOD_CALLS = eINSTANCE.getExecutionCondition_InternalMethodCalls();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_CONDITION__SCOPE = eINSTANCE.getExecutionCondition_Scope();

		/**
		 * The meta object literal for the '<em><b>Exception</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_CONDITION__EXCEPTION = eINSTANCE.getExecutionCondition_Exception();

		/**
		 * The meta object literal for the '<em><b>Pattern Mapping</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_CONDITION__PATTERN_MAPPING = eINSTANCE.getExecutionCondition_PatternMapping();

		/**
		 * The meta object literal for the '<em><b>Instance Of Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_CONDITION__INSTANCE_OF_CLASS = eINSTANCE.getExecutionCondition_InstanceOfClass();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.EStringToTreeStructuredElementImpl <em>EString To Tree Structured Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.EStringToTreeStructuredElementImpl
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getEStringToTreeStructuredElement()
		 * @generated
		 */
		EClass ESTRING_TO_TREE_STRUCTURED_ELEMENT = eINSTANCE.getEStringToTreeStructuredElement();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_TREE_STRUCTURED_ELEMENT__KEY = eINSTANCE.getEStringToTreeStructuredElement_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESTRING_TO_TREE_STRUCTURED_ELEMENT__VALUE = eINSTANCE.getEStringToTreeStructuredElement_Value();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.TreeStructuredElementImpl <em>Tree Structured Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.TreeStructuredElementImpl
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getTreeStructuredElement()
		 * @generated
		 */
		EClass TREE_STRUCTURED_ELEMENT = eINSTANCE.getTreeStructuredElement();

		/**
		 * The meta object literal for the '<em><b>Tree Structured Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENTS = eINSTANCE.getTreeStructuredElement_TreeStructuredElements();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_STRUCTURED_ELEMENT__PARENT = eINSTANCE.getTreeStructuredElement_Parent();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_STRUCTURED_ELEMENT__TYPE = eINSTANCE.getTreeStructuredElement_Type();

		/**
		 * The meta object literal for the '<em><b>Persistent List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_STRUCTURED_ELEMENT__PERSISTENT_LIST = eINSTANCE.getTreeStructuredElement_PersistentList();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.MappedTreeStructuredElementImpl <em>Mapped Tree Structured Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.MappedTreeStructuredElementImpl
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getMappedTreeStructuredElement()
		 * @generated
		 */
		EClass MAPPED_TREE_STRUCTURED_ELEMENT = eINSTANCE.getMappedTreeStructuredElement();

		/**
		 * The meta object literal for the '<em><b>Tree Structured Element Map</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENT_MAP = eINSTANCE.getMappedTreeStructuredElement_TreeStructuredElementMap();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.AbstractExpressionImpl <em>Abstract Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.AbstractExpressionImpl
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getAbstractExpression()
		 * @generated
		 */
		EClass ABSTRACT_EXPRESSION = eINSTANCE.getAbstractExpression();

		/**
		 * The meta object literal for the '<em><b>Event Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_EXPRESSION__EVENT_TYPE = eINSTANCE.getAbstractExpression_EventType();

		/**
		 * The meta object literal for the '<em><b>Parent Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_EXPRESSION__PARENT_EXPRESSION = eINSTANCE.getAbstractExpression_ParentExpression();

		/**
		 * The meta object literal for the '<em><b>Is Not</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_EXPRESSION__IS_NOT = eINSTANCE.getAbstractExpression_IsNot();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.BlockExpressionImpl <em>Block Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.BlockExpressionImpl
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getBlockExpression()
		 * @generated
		 */
		EClass BLOCK_EXPRESSION = eINSTANCE.getBlockExpression();

		/**
		 * The meta object literal for the '<em><b>Expression List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_EXPRESSION__EXPRESSION_LIST = eINSTANCE.getBlockExpression_ExpressionList();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.AndExpressionImpl <em>And Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.AndExpressionImpl
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getAndExpression()
		 * @generated
		 */
		EClass AND_EXPRESSION = eINSTANCE.getAndExpression();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.OrExpressionImpl <em>Or Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.OrExpressionImpl
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getOrExpression()
		 * @generated
		 */
		EClass OR_EXPRESSION = eINSTANCE.getOrExpression();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.SingleExpressionImpl <em>Single Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SingleExpressionImpl
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getSingleExpression()
		 * @generated
		 */
		EClass SINGLE_EXPRESSION = eINSTANCE.getSingleExpression();

		/**
		 * The meta object literal for the '<em><b>Execution Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINGLE_EXPRESSION__EXECUTION_CONDITION = eINSTANCE.getSingleExpression_ExecutionCondition();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.SimpleExpressionExecutionConditionImpl <em>Simple Expression Execution Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SimpleExpressionExecutionConditionImpl
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getSimpleExpressionExecutionCondition()
		 * @generated
		 */
		EClass SIMPLE_EXPRESSION_EXECUTION_CONDITION = eINSTANCE.getSimpleExpressionExecutionCondition();

		/**
		 * The meta object literal for the '<em><b>Execution State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_EXPRESSION_EXECUTION_CONDITION__EXECUTION_STATE = eINSTANCE.getSimpleExpressionExecutionCondition_ExecutionState();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_EXPRESSION_EXECUTION_CONDITION__EXPRESSION = eINSTANCE.getSimpleExpressionExecutionCondition_Expression();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.NotedElementImpl <em>Noted Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.NotedElementImpl
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getNotedElement()
		 * @generated
		 */
		EClass NOTED_ELEMENT = eINSTANCE.getNotedElement();

		/**
		 * The meta object literal for the '<em><b>Notes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOTED_ELEMENT__NOTES = eINSTANCE.getNotedElement_Notes();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.VisitedExpression <em>Visited Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.VisitedExpression
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getVisitedExpression()
		 * @generated
		 */
		EClass VISITED_EXPRESSION = eINSTANCE.getVisitedExpression();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.VisitorExpression <em>Visitor Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.VisitorExpression
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getVisitorExpression()
		 * @generated
		 */
		EClass VISITOR_EXPRESSION = eINSTANCE.getVisitorExpression();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.SimpleExecutionConditionConfigurationImpl <em>Simple Execution Condition Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SimpleExecutionConditionConfigurationImpl
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getSimpleExecutionConditionConfiguration()
		 * @generated
		 */
		EClass SIMPLE_EXECUTION_CONDITION_CONFIGURATION = eINSTANCE.getSimpleExecutionConditionConfiguration();

		/**
		 * The meta object literal for the '<em><b>Simple Expression Execution Conditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_EXECUTION_CONDITION_CONFIGURATION__SIMPLE_EXPRESSION_EXECUTION_CONDITIONS = eINSTANCE.getSimpleExecutionConditionConfiguration_SimpleExpressionExecutionConditions();

		/**
		 * The meta object literal for the '<em><b>Execution Condition Not Verified State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_EXECUTION_CONDITION_CONFIGURATION__EXECUTION_CONDITION_NOT_VERIFIED_STATE = eINSTANCE.getSimpleExecutionConditionConfiguration_ExecutionConditionNotVerifiedState();

		/**
		 * The meta object literal for the '<em><b>Exception State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_EXECUTION_CONDITION_CONFIGURATION__EXCEPTION_STATE = eINSTANCE.getSimpleExecutionConditionConfiguration_ExceptionState();

		/**
		 * The meta object literal for the '<em><b>Pre Filters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_EXECUTION_CONDITION_CONFIGURATION__PRE_FILTERS = eINSTANCE.getSimpleExecutionConditionConfiguration_PreFilters();

		/**
		 * The meta object literal for the '<em><b>Use Default Configuration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_EXECUTION_CONDITION_CONFIGURATION__USE_DEFAULT_CONFIGURATION = eINSTANCE.getSimpleExecutionConditionConfiguration_UseDefaultConfiguration();

		/**
		 * The meta object literal for the '<em><b>Use Custom Configuration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_EXECUTION_CONDITION_CONFIGURATION__USE_CUSTOM_CONFIGURATION = eINSTANCE.getSimpleExecutionConditionConfiguration_UseCustomConfiguration();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.ConditionValue <em>Condition Value</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.ConditionValue
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getConditionValue()
		 * @generated
		 */
		EEnum CONDITION_VALUE = eINSTANCE.getConditionValue();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.TreeType <em>Tree Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.TreeType
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getTreeType()
		 * @generated
		 */
		EEnum TREE_TYPE = eINSTANCE.getTreeType();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.StateType <em>State Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.StateType
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getStateType()
		 * @generated
		 */
		EEnum STATE_TYPE = eINSTANCE.getStateType();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.EventType <em>Event Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.EventType
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getEventType()
		 * @generated
		 */
		EEnum EVENT_TYPE = eINSTANCE.getEventType();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue <em>Execution State Value</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getExecutionStateValue()
		 * @generated
		 */
		EEnum EXECUTION_STATE_VALUE = eINSTANCE.getExecutionStateValue();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.semantic.ScopeFilterType <em>Scope Filter Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.ScopeFilterType
		 * @see org.isistan.flabot.executionstatemapping.model.semantic.impl.SemanticPackageImpl#getScopeFilterType()
		 * @generated
		 */
		EEnum SCOPE_FILTER_TYPE = eINSTANCE.getScopeFilterType();

	}

} //SemanticPackage
