/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.executionstatemapping.model.ModelPackage;
import org.isistan.flabot.executionstatemapping.model.impl.ModelPackageImpl;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologPackage;
import org.isistan.flabot.executionstatemapping.model.prolog.impl.PrologPackageImpl;
import org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.AndExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.BlockExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.ConditionValue;
import org.isistan.flabot.executionstatemapping.model.semantic.EvaluationCondition;
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
import org.isistan.flabot.executionstatemapping.model.semantic.VisitedExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.VisitorExpression;
import org.isistan.flabot.executionstatemapping.model.visual.VisualPackage;
import org.isistan.flabot.executionstatemapping.model.visual.impl.VisualPackageImpl;
import org.isistan.flabot.mapping.mappingmodel.MappingmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SemanticPackageImpl extends EPackageImpl implements SemanticPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evaluationConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exceptionEvaluationConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scopeEvaluationConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fieldEvaluationConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEvaluationConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass returnedValueEvaluationConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass finalStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transitionConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eStringToTreeStructuredElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass treeStructuredElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappedTreeStructuredElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singleExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleExpressionExecutionConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visitedExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visitorExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleExecutionConditionConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum conditionValueEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum treeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum stateTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eventTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum executionStateValueEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum scopeFilterTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SemanticPackageImpl() {
		super(eNS_URI, SemanticFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SemanticPackage init() {
		if (isInited) return (SemanticPackage)EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI);

		// Obtain or create and register package
		SemanticPackageImpl theSemanticPackage = (SemanticPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof SemanticPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new SemanticPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EditormodelPackage.eINSTANCE.eClass();
		CoremodelPackage.eINSTANCE.eClass();
		MappingmodelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
		VisualPackageImpl theVisualPackage = (VisualPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(VisualPackage.eNS_URI) instanceof VisualPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(VisualPackage.eNS_URI) : VisualPackage.eINSTANCE);
		PrologPackageImpl thePrologPackage = (PrologPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PrologPackage.eNS_URI) instanceof PrologPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PrologPackage.eNS_URI) : PrologPackage.eINSTANCE);

		// Create package meta-data objects
		theSemanticPackage.createPackageContents();
		theModelPackage.createPackageContents();
		theVisualPackage.createPackageContents();
		thePrologPackage.createPackageContents();

		// Initialize created meta-data
		theSemanticPackage.initializePackageContents();
		theModelPackage.initializePackageContents();
		theVisualPackage.initializePackageContents();
		thePrologPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSemanticPackage.freeze();

		return theSemanticPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutionCondition() {
		return executionConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionCondition_Fields() {
		return (EReference)executionConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionCondition_Parameters() {
		return (EReference)executionConditionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionCondition_ReturnedValue() {
		return (EReference)executionConditionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionCondition_InternalMethodCalls() {
		return (EReference)executionConditionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionCondition_Scope() {
		return (EReference)executionConditionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionCondition_Exception() {
		return (EReference)executionConditionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionCondition_PatternMapping() {
		return (EReference)executionConditionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionCondition_InstanceOfClass() {
		return (EAttribute)executionConditionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvaluationCondition() {
		return evaluationConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvaluationCondition_Value() {
		return (EAttribute)evaluationConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvaluationCondition_Condition() {
		return (EAttribute)evaluationConditionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExceptionEvaluationCondition() {
		return exceptionEvaluationConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExceptionEvaluationCondition_CheckAnyException() {
		return (EAttribute)exceptionEvaluationConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScopeEvaluationCondition() {
		return scopeEvaluationConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFieldEvaluationCondition() {
		return fieldEvaluationConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFieldEvaluationCondition_FieldName() {
		return (EAttribute)fieldEvaluationConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterEvaluationCondition() {
		return parameterEvaluationConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterEvaluationCondition_ParameterPosition() {
		return (EAttribute)parameterEvaluationConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterEvaluationCondition_FieldEvaluationConditions() {
		return (EReference)parameterEvaluationConditionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReturnedValueEvaluationCondition() {
		return returnedValueEvaluationConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateContainer() {
		return stateContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateContainer_States() {
		return (EReference)stateContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateContainer_InicialStates() {
		return (EReference)stateContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateContainer_FinalStates() {
		return (EReference)stateContainerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateContainer_PreFilters() {
		return (EReference)stateContainerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateContainer_TransitionConditions() {
		return (EReference)stateContainerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStateContainer_DefaultState() {
		return (EAttribute)stateContainerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStateContainer_ExceptionState() {
		return (EAttribute)stateContainerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getState() {
		return stateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getState_SourceTransitionConditions() {
		return (EReference)stateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getState_TargetTransitionConditions() {
		return (EReference)stateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getState_StateType() {
		return (EAttribute)stateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFinalState() {
		return finalStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFinalState_ExecutionState() {
		return (EAttribute)finalStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransitionCondition() {
		return transitionConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransitionCondition_SourceState() {
		return (EReference)transitionConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransitionCondition_TargetState() {
		return (EReference)transitionConditionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransitionCondition_ExecutionCondition() {
		return (EReference)transitionConditionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEStringToTreeStructuredElement() {
		return eStringToTreeStructuredElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEStringToTreeStructuredElement_Key() {
		return (EAttribute)eStringToTreeStructuredElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEStringToTreeStructuredElement_Value() {
		return (EReference)eStringToTreeStructuredElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTreeStructuredElement() {
		return treeStructuredElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTreeStructuredElement_TreeStructuredElements() {
		return (EReference)treeStructuredElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTreeStructuredElement_Parent() {
		return (EReference)treeStructuredElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTreeStructuredElement_Type() {
		return (EAttribute)treeStructuredElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTreeStructuredElement_PersistentList() {
		return (EReference)treeStructuredElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappedTreeStructuredElement() {
		return mappedTreeStructuredElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappedTreeStructuredElement_TreeStructuredElementMap() {
		return (EReference)mappedTreeStructuredElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractExpression() {
		return abstractExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractExpression_EventType() {
		return (EAttribute)abstractExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractExpression_ParentExpression() {
		return (EReference)abstractExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractExpression_IsNot() {
		return (EAttribute)abstractExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockExpression() {
		return blockExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockExpression_ExpressionList() {
		return (EReference)blockExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAndExpression() {
		return andExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrExpression() {
		return orExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingleExpression() {
		return singleExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleExpression_ExecutionCondition() {
		return (EReference)singleExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleExpressionExecutionCondition() {
		return simpleExpressionExecutionConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleExpressionExecutionCondition_ExecutionState() {
		return (EAttribute)simpleExpressionExecutionConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleExpressionExecutionCondition_Expression() {
		return (EReference)simpleExpressionExecutionConditionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotedElement() {
		return notedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNotedElement_Notes() {
		return (EReference)notedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisitedExpression() {
		return visitedExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisitorExpression() {
		return visitorExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleExecutionConditionConfiguration() {
		return simpleExecutionConditionConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleExecutionConditionConfiguration_SimpleExpressionExecutionConditions() {
		return (EReference)simpleExecutionConditionConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleExecutionConditionConfiguration_ExecutionConditionNotVerifiedState() {
		return (EAttribute)simpleExecutionConditionConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleExecutionConditionConfiguration_ExceptionState() {
		return (EAttribute)simpleExecutionConditionConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleExecutionConditionConfiguration_PreFilters() {
		return (EReference)simpleExecutionConditionConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleExecutionConditionConfiguration_UseDefaultConfiguration() {
		return (EAttribute)simpleExecutionConditionConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleExecutionConditionConfiguration_UseCustomConfiguration() {
		return (EAttribute)simpleExecutionConditionConfigurationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConditionValue() {
		return conditionValueEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTreeType() {
		return treeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getStateType() {
		return stateTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEventType() {
		return eventTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getExecutionStateValue() {
		return executionStateValueEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getScopeFilterType() {
		return scopeFilterTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticFactory getSemanticFactory() {
		return (SemanticFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		executionConditionEClass = createEClass(EXECUTION_CONDITION);
		createEReference(executionConditionEClass, EXECUTION_CONDITION__FIELDS);
		createEReference(executionConditionEClass, EXECUTION_CONDITION__PARAMETERS);
		createEReference(executionConditionEClass, EXECUTION_CONDITION__RETURNED_VALUE);
		createEReference(executionConditionEClass, EXECUTION_CONDITION__INTERNAL_METHOD_CALLS);
		createEReference(executionConditionEClass, EXECUTION_CONDITION__SCOPE);
		createEReference(executionConditionEClass, EXECUTION_CONDITION__EXCEPTION);
		createEReference(executionConditionEClass, EXECUTION_CONDITION__PATTERN_MAPPING);
		createEAttribute(executionConditionEClass, EXECUTION_CONDITION__INSTANCE_OF_CLASS);

		evaluationConditionEClass = createEClass(EVALUATION_CONDITION);
		createEAttribute(evaluationConditionEClass, EVALUATION_CONDITION__VALUE);
		createEAttribute(evaluationConditionEClass, EVALUATION_CONDITION__CONDITION);

		exceptionEvaluationConditionEClass = createEClass(EXCEPTION_EVALUATION_CONDITION);
		createEAttribute(exceptionEvaluationConditionEClass, EXCEPTION_EVALUATION_CONDITION__CHECK_ANY_EXCEPTION);

		scopeEvaluationConditionEClass = createEClass(SCOPE_EVALUATION_CONDITION);

		fieldEvaluationConditionEClass = createEClass(FIELD_EVALUATION_CONDITION);
		createEAttribute(fieldEvaluationConditionEClass, FIELD_EVALUATION_CONDITION__FIELD_NAME);

		parameterEvaluationConditionEClass = createEClass(PARAMETER_EVALUATION_CONDITION);
		createEAttribute(parameterEvaluationConditionEClass, PARAMETER_EVALUATION_CONDITION__PARAMETER_POSITION);
		createEReference(parameterEvaluationConditionEClass, PARAMETER_EVALUATION_CONDITION__FIELD_EVALUATION_CONDITIONS);

		returnedValueEvaluationConditionEClass = createEClass(RETURNED_VALUE_EVALUATION_CONDITION);

		stateContainerEClass = createEClass(STATE_CONTAINER);
		createEReference(stateContainerEClass, STATE_CONTAINER__STATES);
		createEReference(stateContainerEClass, STATE_CONTAINER__INICIAL_STATES);
		createEReference(stateContainerEClass, STATE_CONTAINER__FINAL_STATES);
		createEReference(stateContainerEClass, STATE_CONTAINER__PRE_FILTERS);
		createEReference(stateContainerEClass, STATE_CONTAINER__TRANSITION_CONDITIONS);
		createEAttribute(stateContainerEClass, STATE_CONTAINER__DEFAULT_STATE);
		createEAttribute(stateContainerEClass, STATE_CONTAINER__EXCEPTION_STATE);

		stateEClass = createEClass(STATE);
		createEReference(stateEClass, STATE__SOURCE_TRANSITION_CONDITIONS);
		createEReference(stateEClass, STATE__TARGET_TRANSITION_CONDITIONS);
		createEAttribute(stateEClass, STATE__STATE_TYPE);

		finalStateEClass = createEClass(FINAL_STATE);
		createEAttribute(finalStateEClass, FINAL_STATE__EXECUTION_STATE);

		transitionConditionEClass = createEClass(TRANSITION_CONDITION);
		createEReference(transitionConditionEClass, TRANSITION_CONDITION__SOURCE_STATE);
		createEReference(transitionConditionEClass, TRANSITION_CONDITION__TARGET_STATE);
		createEReference(transitionConditionEClass, TRANSITION_CONDITION__EXECUTION_CONDITION);

		eStringToTreeStructuredElementEClass = createEClass(ESTRING_TO_TREE_STRUCTURED_ELEMENT);
		createEAttribute(eStringToTreeStructuredElementEClass, ESTRING_TO_TREE_STRUCTURED_ELEMENT__KEY);
		createEReference(eStringToTreeStructuredElementEClass, ESTRING_TO_TREE_STRUCTURED_ELEMENT__VALUE);

		treeStructuredElementEClass = createEClass(TREE_STRUCTURED_ELEMENT);
		createEReference(treeStructuredElementEClass, TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENTS);
		createEReference(treeStructuredElementEClass, TREE_STRUCTURED_ELEMENT__PARENT);
		createEAttribute(treeStructuredElementEClass, TREE_STRUCTURED_ELEMENT__TYPE);
		createEReference(treeStructuredElementEClass, TREE_STRUCTURED_ELEMENT__PERSISTENT_LIST);

		mappedTreeStructuredElementEClass = createEClass(MAPPED_TREE_STRUCTURED_ELEMENT);
		createEReference(mappedTreeStructuredElementEClass, MAPPED_TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENT_MAP);

		abstractExpressionEClass = createEClass(ABSTRACT_EXPRESSION);
		createEAttribute(abstractExpressionEClass, ABSTRACT_EXPRESSION__EVENT_TYPE);
		createEReference(abstractExpressionEClass, ABSTRACT_EXPRESSION__PARENT_EXPRESSION);
		createEAttribute(abstractExpressionEClass, ABSTRACT_EXPRESSION__IS_NOT);

		blockExpressionEClass = createEClass(BLOCK_EXPRESSION);
		createEReference(blockExpressionEClass, BLOCK_EXPRESSION__EXPRESSION_LIST);

		andExpressionEClass = createEClass(AND_EXPRESSION);

		orExpressionEClass = createEClass(OR_EXPRESSION);

		singleExpressionEClass = createEClass(SINGLE_EXPRESSION);
		createEReference(singleExpressionEClass, SINGLE_EXPRESSION__EXECUTION_CONDITION);

		simpleExpressionExecutionConditionEClass = createEClass(SIMPLE_EXPRESSION_EXECUTION_CONDITION);
		createEAttribute(simpleExpressionExecutionConditionEClass, SIMPLE_EXPRESSION_EXECUTION_CONDITION__EXECUTION_STATE);
		createEReference(simpleExpressionExecutionConditionEClass, SIMPLE_EXPRESSION_EXECUTION_CONDITION__EXPRESSION);

		notedElementEClass = createEClass(NOTED_ELEMENT);
		createEReference(notedElementEClass, NOTED_ELEMENT__NOTES);

		visitedExpressionEClass = createEClass(VISITED_EXPRESSION);

		visitorExpressionEClass = createEClass(VISITOR_EXPRESSION);

		simpleExecutionConditionConfigurationEClass = createEClass(SIMPLE_EXECUTION_CONDITION_CONFIGURATION);
		createEReference(simpleExecutionConditionConfigurationEClass, SIMPLE_EXECUTION_CONDITION_CONFIGURATION__SIMPLE_EXPRESSION_EXECUTION_CONDITIONS);
		createEAttribute(simpleExecutionConditionConfigurationEClass, SIMPLE_EXECUTION_CONDITION_CONFIGURATION__EXECUTION_CONDITION_NOT_VERIFIED_STATE);
		createEAttribute(simpleExecutionConditionConfigurationEClass, SIMPLE_EXECUTION_CONDITION_CONFIGURATION__EXCEPTION_STATE);
		createEReference(simpleExecutionConditionConfigurationEClass, SIMPLE_EXECUTION_CONDITION_CONFIGURATION__PRE_FILTERS);
		createEAttribute(simpleExecutionConditionConfigurationEClass, SIMPLE_EXECUTION_CONDITION_CONFIGURATION__USE_DEFAULT_CONFIGURATION);
		createEAttribute(simpleExecutionConditionConfigurationEClass, SIMPLE_EXECUTION_CONDITION_CONFIGURATION__USE_CUSTOM_CONFIGURATION);

		// Create enums
		conditionValueEEnum = createEEnum(CONDITION_VALUE);
		treeTypeEEnum = createEEnum(TREE_TYPE);
		stateTypeEEnum = createEEnum(STATE_TYPE);
		eventTypeEEnum = createEEnum(EVENT_TYPE);
		executionStateValueEEnum = createEEnum(EXECUTION_STATE_VALUE);
		scopeFilterTypeEEnum = createEEnum(SCOPE_FILTER_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		PrologPackage thePrologPackage = (PrologPackage)EPackage.Registry.INSTANCE.getEPackage(PrologPackage.eNS_URI);
		MappingmodelPackage theMappingmodelPackage = (MappingmodelPackage)EPackage.Registry.INSTANCE.getEPackage(MappingmodelPackage.eNS_URI);
		CoremodelPackage theCoremodelPackage = (CoremodelPackage)EPackage.Registry.INSTANCE.getEPackage(CoremodelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		executionConditionEClass.getESuperTypes().add(this.getTreeStructuredElement());
		executionConditionEClass.getESuperTypes().add(thePrologPackage.getPrologElement());
		exceptionEvaluationConditionEClass.getESuperTypes().add(this.getEvaluationCondition());
		scopeEvaluationConditionEClass.getESuperTypes().add(this.getEvaluationCondition());
		fieldEvaluationConditionEClass.getESuperTypes().add(this.getEvaluationCondition());
		parameterEvaluationConditionEClass.getESuperTypes().add(this.getEvaluationCondition());
		returnedValueEvaluationConditionEClass.getESuperTypes().add(this.getEvaluationCondition());
		stateContainerEClass.getESuperTypes().add(this.getTreeStructuredElement());
		stateEClass.getESuperTypes().add(this.getNamedElement());
		stateEClass.getESuperTypes().add(this.getNotedElement());
		finalStateEClass.getESuperTypes().add(this.getState());
		transitionConditionEClass.getESuperTypes().add(this.getNotedElement());
		treeStructuredElementEClass.getESuperTypes().add(this.getNamedElement());
		mappedTreeStructuredElementEClass.getESuperTypes().add(this.getTreeStructuredElement());
		abstractExpressionEClass.getESuperTypes().add(thePrologPackage.getPrologElement());
		abstractExpressionEClass.getESuperTypes().add(this.getVisitedExpression());
		abstractExpressionEClass.getESuperTypes().add(thePrologPackage.getVisitedExpressionProlog());
		blockExpressionEClass.getESuperTypes().add(this.getAbstractExpression());
		andExpressionEClass.getESuperTypes().add(this.getBlockExpression());
		orExpressionEClass.getESuperTypes().add(this.getBlockExpression());
		singleExpressionEClass.getESuperTypes().add(this.getAbstractExpression());
		simpleExpressionExecutionConditionEClass.getESuperTypes().add(this.getNamedElement());

		// Initialize classes and features; add operations and parameters
		initEClass(namedElementEClass, NamedElement.class, "NamedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", "", 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(executionConditionEClass, ExecutionCondition.class, "ExecutionCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutionCondition_Fields(), this.getFieldEvaluationCondition(), null, "fields", null, 0, -1, ExecutionCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionCondition_Parameters(), this.getParameterEvaluationCondition(), null, "parameters", null, 0, -1, ExecutionCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionCondition_ReturnedValue(), this.getReturnedValueEvaluationCondition(), null, "returnedValue", null, 0, 1, ExecutionCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionCondition_InternalMethodCalls(), this.getExecutionCondition(), null, "internalMethodCalls", null, 0, -1, ExecutionCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionCondition_Scope(), this.getScopeEvaluationCondition(), null, "scope", null, 0, 1, ExecutionCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionCondition_Exception(), this.getExceptionEvaluationCondition(), null, "exception", null, 0, 1, ExecutionCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionCondition_PatternMapping(), theMappingmodelPackage.getPatternMapping(), null, "patternMapping", null, 0, 1, ExecutionCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionCondition_InstanceOfClass(), ecorePackage.getEString(), "instanceOfClass", null, 0, 1, ExecutionCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(evaluationConditionEClass, EvaluationCondition.class, "EvaluationCondition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEvaluationCondition_Value(), ecorePackage.getEString(), "value", null, 0, 1, EvaluationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvaluationCondition_Condition(), this.getConditionValue(), "condition", null, 0, 1, EvaluationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exceptionEvaluationConditionEClass, ExceptionEvaluationCondition.class, "ExceptionEvaluationCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExceptionEvaluationCondition_CheckAnyException(), ecorePackage.getEBoolean(), "checkAnyException", null, 0, 1, ExceptionEvaluationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scopeEvaluationConditionEClass, ScopeEvaluationCondition.class, "ScopeEvaluationCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fieldEvaluationConditionEClass, FieldEvaluationCondition.class, "FieldEvaluationCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFieldEvaluationCondition_FieldName(), ecorePackage.getEString(), "fieldName", null, 0, 1, FieldEvaluationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEvaluationConditionEClass, ParameterEvaluationCondition.class, "ParameterEvaluationCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameterEvaluationCondition_ParameterPosition(), ecorePackage.getEInt(), "parameterPosition", null, 0, 1, ParameterEvaluationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameterEvaluationCondition_FieldEvaluationConditions(), this.getFieldEvaluationCondition(), null, "fieldEvaluationConditions", null, 0, -1, ParameterEvaluationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(returnedValueEvaluationConditionEClass, ReturnedValueEvaluationCondition.class, "ReturnedValueEvaluationCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stateContainerEClass, StateContainer.class, "StateContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateContainer_States(), this.getState(), null, "states", null, 0, -1, StateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateContainer_InicialStates(), this.getState(), null, "inicialStates", null, 0, -1, StateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateContainer_FinalStates(), this.getState(), null, "finalStates", null, 0, -1, StateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateContainer_PreFilters(), this.getExecutionCondition(), null, "preFilters", null, 0, -1, StateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateContainer_TransitionConditions(), this.getTransitionCondition(), null, "transitionConditions", null, 0, -1, StateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStateContainer_DefaultState(), this.getExecutionStateValue(), "defaultState", "NotExecuted", 0, 1, StateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStateContainer_ExceptionState(), this.getExecutionStateValue(), "exceptionState", "NONE", 0, 1, StateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getState_SourceTransitionConditions(), this.getTransitionCondition(), this.getTransitionCondition_SourceState(), "sourceTransitionConditions", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getState_TargetTransitionConditions(), this.getTransitionCondition(), this.getTransitionCondition_TargetState(), "targetTransitionConditions", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getState_StateType(), this.getStateType(), "stateType", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(finalStateEClass, FinalState.class, "FinalState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFinalState_ExecutionState(), this.getExecutionStateValue(), "executionState", null, 0, 1, FinalState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transitionConditionEClass, TransitionCondition.class, "TransitionCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransitionCondition_SourceState(), this.getState(), this.getState_SourceTransitionConditions(), "sourceState", null, 0, 1, TransitionCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransitionCondition_TargetState(), this.getState(), this.getState_TargetTransitionConditions(), "targetState", null, 0, 1, TransitionCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransitionCondition_ExecutionCondition(), this.getExecutionCondition(), null, "executionCondition", null, 0, 1, TransitionCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eStringToTreeStructuredElementEClass, Map.Entry.class, "EStringToTreeStructuredElement", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEStringToTreeStructuredElement_Key(), ecorePackage.getEString(), "key", "", 0, 1, Map.Entry.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEStringToTreeStructuredElement_Value(), this.getTreeStructuredElement(), null, "value", null, 0, 1, Map.Entry.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(treeStructuredElementEClass, TreeStructuredElement.class, "TreeStructuredElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTreeStructuredElement_TreeStructuredElements(), this.getTreeStructuredElement(), this.getTreeStructuredElement_Parent(), "treeStructuredElements", null, 0, -1, TreeStructuredElement.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTreeStructuredElement_Parent(), this.getTreeStructuredElement(), this.getTreeStructuredElement_TreeStructuredElements(), "parent", null, 0, 1, TreeStructuredElement.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTreeStructuredElement_Type(), this.getTreeType(), "type", null, 0, 1, TreeStructuredElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTreeStructuredElement_PersistentList(), this.getTreeStructuredElement(), null, "persistentList", null, 0, -1, TreeStructuredElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappedTreeStructuredElementEClass, MappedTreeStructuredElement.class, "MappedTreeStructuredElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappedTreeStructuredElement_TreeStructuredElementMap(), this.getEStringToTreeStructuredElement(), null, "treeStructuredElementMap", null, 0, -1, MappedTreeStructuredElement.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractExpressionEClass, AbstractExpression.class, "AbstractExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractExpression_EventType(), this.getEventType(), "eventType", null, 0, 1, AbstractExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractExpression_ParentExpression(), this.getAbstractExpression(), null, "parentExpression", null, 0, 1, AbstractExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractExpression_IsNot(), ecorePackage.getEBoolean(), "isNot", null, 0, 1, AbstractExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(blockExpressionEClass, BlockExpression.class, "BlockExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlockExpression_ExpressionList(), this.getAbstractExpression(), null, "expressionList", null, 0, -1, BlockExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(andExpressionEClass, AndExpression.class, "AndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orExpressionEClass, OrExpression.class, "OrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(singleExpressionEClass, SingleExpression.class, "SingleExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSingleExpression_ExecutionCondition(), this.getExecutionCondition(), null, "executionCondition", null, 0, 1, SingleExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleExpressionExecutionConditionEClass, SimpleExpressionExecutionCondition.class, "SimpleExpressionExecutionCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimpleExpressionExecutionCondition_ExecutionState(), this.getExecutionStateValue(), "executionState", null, 0, 1, SimpleExpressionExecutionCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimpleExpressionExecutionCondition_Expression(), this.getAbstractExpression(), null, "expression", null, 0, 1, SimpleExpressionExecutionCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(notedElementEClass, NotedElement.class, "NotedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNotedElement_Notes(), theCoremodelPackage.getNote(), null, "notes", null, 0, -1, NotedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(visitedExpressionEClass, VisitedExpression.class, "VisitedExpression", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(visitedExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVisitorExpression(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(visitorExpressionEClass, VisitorExpression.class, "VisitorExpression", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(visitorExpressionEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAndExpression(), "expression", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(visitorExpressionEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOrExpression(), "expression", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(visitorExpressionEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSingleExpression(), "expression", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(simpleExecutionConditionConfigurationEClass, SimpleExecutionConditionConfiguration.class, "SimpleExecutionConditionConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimpleExecutionConditionConfiguration_SimpleExpressionExecutionConditions(), this.getSimpleExpressionExecutionCondition(), null, "simpleExpressionExecutionConditions", null, 0, -1, SimpleExecutionConditionConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleExecutionConditionConfiguration_ExecutionConditionNotVerifiedState(), this.getExecutionStateValue(), "executionConditionNotVerifiedState", "NONE", 0, 1, SimpleExecutionConditionConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleExecutionConditionConfiguration_ExceptionState(), this.getExecutionStateValue(), "exceptionState", "NONE", 0, 1, SimpleExecutionConditionConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimpleExecutionConditionConfiguration_PreFilters(), this.getExecutionCondition(), null, "preFilters", null, 0, -1, SimpleExecutionConditionConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleExecutionConditionConfiguration_UseDefaultConfiguration(), ecorePackage.getEBoolean(), "useDefaultConfiguration", null, 0, 1, SimpleExecutionConditionConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleExecutionConditionConfiguration_UseCustomConfiguration(), ecorePackage.getEBoolean(), "useCustomConfiguration", null, 0, 1, SimpleExecutionConditionConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(conditionValueEEnum, ConditionValue.class, "ConditionValue");
		addEEnumLiteral(conditionValueEEnum, ConditionValue.EQUAL);
		addEEnumLiteral(conditionValueEEnum, ConditionValue.NOT_EQUAL);
		addEEnumLiteral(conditionValueEEnum, ConditionValue.GREATER);
		addEEnumLiteral(conditionValueEEnum, ConditionValue.GREATER_EQUAL);
		addEEnumLiteral(conditionValueEEnum, ConditionValue.LOWER);
		addEEnumLiteral(conditionValueEEnum, ConditionValue.LOWER_EQUAL);
		addEEnumLiteral(conditionValueEEnum, ConditionValue.IS_NULL);
		addEEnumLiteral(conditionValueEEnum, ConditionValue.NOT_NULL);
		addEEnumLiteral(conditionValueEEnum, ConditionValue.CONTAINS);
		addEEnumLiteral(conditionValueEEnum, ConditionValue.NOT_CONTAINS);
		addEEnumLiteral(conditionValueEEnum, ConditionValue.IS_CLASS);
		addEEnumLiteral(conditionValueEEnum, ConditionValue.NOT_IS_CLASS);

		initEEnum(treeTypeEEnum, TreeType.class, "TreeType");
		addEEnumLiteral(treeTypeEEnum, TreeType.CONTAINER_TYPE);
		addEEnumLiteral(treeTypeEEnum, TreeType.PROJECT_TYPE);
		addEEnumLiteral(treeTypeEEnum, TreeType.PACKAGE_ROOT_TYPE);
		addEEnumLiteral(treeTypeEEnum, TreeType.PACKAGE_TYPE);
		addEEnumLiteral(treeTypeEEnum, TreeType.CLASS_TYPE);
		addEEnumLiteral(treeTypeEEnum, TreeType.EXECUTION_CONDITION_TYPE);
		addEEnumLiteral(treeTypeEEnum, TreeType.STATE_DIAGRAM_TYPE);
		addEEnumLiteral(treeTypeEEnum, TreeType.FOLDER_STATE_DIAGRAM_TYPE);
		addEEnumLiteral(treeTypeEEnum, TreeType.FOLDER_GENERAL_EXECUTION_CONDITION_TYPE);

		initEEnum(stateTypeEEnum, StateType.class, "StateType");
		addEEnumLiteral(stateTypeEEnum, StateType.INITIAL);
		addEEnumLiteral(stateTypeEEnum, StateType.NORMAL);
		addEEnumLiteral(stateTypeEEnum, StateType.FINAL);

		initEEnum(eventTypeEEnum, EventType.class, "EventType");
		addEEnumLiteral(eventTypeEEnum, EventType.AND_EVENT);
		addEEnumLiteral(eventTypeEEnum, EventType.OR_EVENT);
		addEEnumLiteral(eventTypeEEnum, EventType.SINGLE_EVENT);

		initEEnum(executionStateValueEEnum, ExecutionStateValue.class, "ExecutionStateValue");
		addEEnumLiteral(executionStateValueEEnum, ExecutionStateValue.FAULTY);
		addEEnumLiteral(executionStateValueEEnum, ExecutionStateValue.EXECUTED);
		addEEnumLiteral(executionStateValueEEnum, ExecutionStateValue.NOT_EXECUTED);
		addEEnumLiteral(executionStateValueEEnum, ExecutionStateValue.NONE);

		initEEnum(scopeFilterTypeEEnum, ScopeFilterType.class, "ScopeFilterType");
		addEEnumLiteral(scopeFilterTypeEEnum, ScopeFilterType.ARGUMENTS_SCOPE);
		addEEnumLiteral(scopeFilterTypeEEnum, ScopeFilterType.FIELDS_SCOPE);
		addEEnumLiteral(scopeFilterTypeEEnum, ScopeFilterType.RETURNVALUE_SCOPE);
	}

} //SemanticPackageImpl
