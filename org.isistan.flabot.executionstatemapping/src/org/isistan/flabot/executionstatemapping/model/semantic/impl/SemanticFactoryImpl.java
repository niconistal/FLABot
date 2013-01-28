/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.isistan.flabot.executionstatemapping.model.semantic.AndExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.ConditionValue;
import org.isistan.flabot.executionstatemapping.model.semantic.EventType;
import org.isistan.flabot.executionstatemapping.model.semantic.ExceptionEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue;
import org.isistan.flabot.executionstatemapping.model.semantic.FieldEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.FinalState;
import org.isistan.flabot.executionstatemapping.model.semantic.MappedTreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.NamedElement;
import org.isistan.flabot.executionstatemapping.model.semantic.NotedElement;
import org.isistan.flabot.executionstatemapping.model.semantic.OrExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.ParameterEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ReturnedValueEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ScopeEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ScopeFilterType;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticFactory;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;
import org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration;
import org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.SingleExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.State;
import org.isistan.flabot.executionstatemapping.model.semantic.StateContainer;
import org.isistan.flabot.executionstatemapping.model.semantic.StateType;
import org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SemanticFactoryImpl extends EFactoryImpl implements SemanticFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SemanticFactory init() {
		try {
			SemanticFactory theSemanticFactory = (SemanticFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/isistan/flabot/executionstatemapping/model.ecore#//semantic"); 
			if (theSemanticFactory != null) {
				return theSemanticFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SemanticFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SemanticPackage.NAMED_ELEMENT: return createNamedElement();
			case SemanticPackage.EXECUTION_CONDITION: return createExecutionCondition();
			case SemanticPackage.EXCEPTION_EVALUATION_CONDITION: return createExceptionEvaluationCondition();
			case SemanticPackage.SCOPE_EVALUATION_CONDITION: return createScopeEvaluationCondition();
			case SemanticPackage.FIELD_EVALUATION_CONDITION: return createFieldEvaluationCondition();
			case SemanticPackage.PARAMETER_EVALUATION_CONDITION: return createParameterEvaluationCondition();
			case SemanticPackage.RETURNED_VALUE_EVALUATION_CONDITION: return createReturnedValueEvaluationCondition();
			case SemanticPackage.STATE_CONTAINER: return createStateContainer();
			case SemanticPackage.STATE: return createState();
			case SemanticPackage.FINAL_STATE: return createFinalState();
			case SemanticPackage.TRANSITION_CONDITION: return createTransitionCondition();
			case SemanticPackage.ESTRING_TO_TREE_STRUCTURED_ELEMENT: return (EObject)createEStringToTreeStructuredElement();
			case SemanticPackage.TREE_STRUCTURED_ELEMENT: return createTreeStructuredElement();
			case SemanticPackage.MAPPED_TREE_STRUCTURED_ELEMENT: return createMappedTreeStructuredElement();
			case SemanticPackage.AND_EXPRESSION: return createAndExpression();
			case SemanticPackage.OR_EXPRESSION: return createOrExpression();
			case SemanticPackage.SINGLE_EXPRESSION: return createSingleExpression();
			case SemanticPackage.SIMPLE_EXPRESSION_EXECUTION_CONDITION: return createSimpleExpressionExecutionCondition();
			case SemanticPackage.NOTED_ELEMENT: return createNotedElement();
			case SemanticPackage.SIMPLE_EXECUTION_CONDITION_CONFIGURATION: return createSimpleExecutionConditionConfiguration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SemanticPackage.CONDITION_VALUE:
				return createConditionValueFromString(eDataType, initialValue);
			case SemanticPackage.TREE_TYPE:
				return createTreeTypeFromString(eDataType, initialValue);
			case SemanticPackage.STATE_TYPE:
				return createStateTypeFromString(eDataType, initialValue);
			case SemanticPackage.EVENT_TYPE:
				return createEventTypeFromString(eDataType, initialValue);
			case SemanticPackage.EXECUTION_STATE_VALUE:
				return createExecutionStateValueFromString(eDataType, initialValue);
			case SemanticPackage.SCOPE_FILTER_TYPE:
				return createScopeFilterTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SemanticPackage.CONDITION_VALUE:
				return convertConditionValueToString(eDataType, instanceValue);
			case SemanticPackage.TREE_TYPE:
				return convertTreeTypeToString(eDataType, instanceValue);
			case SemanticPackage.STATE_TYPE:
				return convertStateTypeToString(eDataType, instanceValue);
			case SemanticPackage.EVENT_TYPE:
				return convertEventTypeToString(eDataType, instanceValue);
			case SemanticPackage.EXECUTION_STATE_VALUE:
				return convertExecutionStateValueToString(eDataType, instanceValue);
			case SemanticPackage.SCOPE_FILTER_TYPE:
				return convertScopeFilterTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement createNamedElement() {
		NamedElementImpl namedElement = new NamedElementImpl();
		return namedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionCondition createExecutionConditionGen() {
		ExecutionConditionImpl executionCondition = new ExecutionConditionImpl();
		return executionCondition;
	}

	public ExecutionCondition createExecutionCondition() {
		ExecutionCondition generalExecutionCondition = createExecutionConditionGen();
		generalExecutionCondition.setType(TreeType.EXECUTION_CONDITION_TYPE);
		return generalExecutionCondition;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExceptionEvaluationCondition createExceptionEvaluationCondition() {
		ExceptionEvaluationConditionImpl exceptionEvaluationCondition = new ExceptionEvaluationConditionImpl();
		return exceptionEvaluationCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopeEvaluationCondition createScopeEvaluationCondition() {
		ScopeEvaluationConditionImpl scopeEvaluationCondition = new ScopeEvaluationConditionImpl();
		return scopeEvaluationCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FieldEvaluationCondition createFieldEvaluationCondition() {
		FieldEvaluationConditionImpl fieldEvaluationCondition = new FieldEvaluationConditionImpl();
		return fieldEvaluationCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterEvaluationCondition createParameterEvaluationCondition() {
		ParameterEvaluationConditionImpl parameterEvaluationCondition = new ParameterEvaluationConditionImpl();
		return parameterEvaluationCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReturnedValueEvaluationCondition createReturnedValueEvaluationCondition() {
		ReturnedValueEvaluationConditionImpl returnedValueEvaluationCondition = new ReturnedValueEvaluationConditionImpl();
		return returnedValueEvaluationCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateContainer createStateContainerGen() {
		StateContainerImpl stateContainer = new StateContainerImpl();
		return stateContainer;
	}
	
	public StateContainer createStateContainer() {
		StateContainer stateContainer = createStateContainerGen();
		stateContainer.setType(TreeType.STATE_DIAGRAM_TYPE);
		return stateContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State createState() {
		StateImpl state = new StateImpl();
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FinalState createFinalState() {
		FinalStateImpl finalState = new FinalStateImpl();
		return finalState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionCondition createTransitionCondition() {
		TransitionConditionImpl transitionCondition = new TransitionConditionImpl();
		return transitionCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, TreeStructuredElement> createEStringToTreeStructuredElement() {
		EStringToTreeStructuredElementImpl eStringToTreeStructuredElement = new EStringToTreeStructuredElementImpl();
		return eStringToTreeStructuredElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeStructuredElement createTreeStructuredElement() {
		TreeStructuredElementImpl treeStructuredElement = new TreeStructuredElementImpl();
		return treeStructuredElement;
	}
	
	public TreeStructuredElement createTreeStructuredElement(TreeType treeType) {
		TreeStructuredElementImpl treeStructuredElement = new TreeStructuredElementImpl(treeType);
		return treeStructuredElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappedTreeStructuredElement createMappedTreeStructuredElement() {
		MappedTreeStructuredElementImpl mappedTreeStructuredElement = new MappedTreeStructuredElementImpl();
		return mappedTreeStructuredElement;
	}
	
	public MappedTreeStructuredElement createMappedTreeStructuredElement(TreeType treeType) {
		MappedTreeStructuredElementImpl mappedTreeStructuredElement = new MappedTreeStructuredElementImpl(treeType);
		return mappedTreeStructuredElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AndExpression createAndExpression() {
		AndExpressionImpl andExpression = new AndExpressionImpl();
		return andExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrExpression createOrExpression() {
		OrExpressionImpl orExpression = new OrExpressionImpl();
		return orExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SingleExpression createSingleExpression() {
		SingleExpressionImpl singleExpression = new SingleExpressionImpl();
		return singleExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleExpressionExecutionCondition createSimpleExpressionExecutionCondition() {
		SimpleExpressionExecutionConditionImpl simpleExpressionExecutionCondition = new SimpleExpressionExecutionConditionImpl();
		return simpleExpressionExecutionCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotedElement createNotedElement() {
		NotedElementImpl notedElement = new NotedElementImpl();
		return notedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleExecutionConditionConfiguration createSimpleExecutionConditionConfiguration() {
		SimpleExecutionConditionConfigurationImpl simpleExecutionConditionConfiguration = new SimpleExecutionConditionConfigurationImpl();
		return simpleExecutionConditionConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionValue createConditionValueFromString(EDataType eDataType, String initialValue) {
		ConditionValue result = ConditionValue.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConditionValueToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeType createTreeTypeFromString(EDataType eDataType, String initialValue) {
		TreeType result = TreeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTreeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateType createStateTypeFromString(EDataType eDataType, String initialValue) {
		StateType result = StateType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStateTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventType createEventTypeFromString(EDataType eDataType, String initialValue) {
		EventType result = EventType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEventTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionStateValue createExecutionStateValueFromString(EDataType eDataType, String initialValue) {
		ExecutionStateValue result = ExecutionStateValue.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExecutionStateValueToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopeFilterType createScopeFilterTypeFromString(EDataType eDataType, String initialValue) {
		ScopeFilterType result = ScopeFilterType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertScopeFilterTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticPackage getSemanticPackage() {
		return (SemanticPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SemanticPackage getPackage() {
		return SemanticPackage.eINSTANCE;
	}

} //SemanticFactoryImpl
