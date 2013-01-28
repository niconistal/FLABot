/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.prolog.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologCodeFactory;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologPackage;
import org.isistan.flabot.executionstatemapping.model.prolog.TagProvider;
import org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.AndExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.ConditionValue;
import org.isistan.flabot.executionstatemapping.model.semantic.ExceptionEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue;
import org.isistan.flabot.executionstatemapping.model.semantic.FieldEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.FinalState;
import org.isistan.flabot.executionstatemapping.model.semantic.OrExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.ParameterEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ReturnedValueEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ScopeEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ScopeFilterType;
import org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration;
import org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.SingleExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.State;
import org.isistan.flabot.executionstatemapping.model.semantic.StateContainer;
import org.isistan.flabot.executionstatemapping.model.semantic.StateType;
import org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Code Factory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PrologCodeFactoryImpl extends EObjectImpl implements PrologCodeFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrologCodeFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PrologPackage.Literals.PROLOG_CODE_FACTORY;
	}

	protected String appendPrologCheckNot(String prologCode, AbstractExpression expression)
	{	
		if (expression.isIsNot())
			return "not(".concat(prologCode).concat(")");
		else
			return prologCode;
	}
	
	private void makePrologRule(StringBuilder prologBuilder, String head, String[] bodyParts)
	{
		prologBuilder.append(head);
		if(bodyParts.length>0)
		{
			prologBuilder.append(":-");
			for(String bodypart : bodyParts)
			{
				prologBuilder.append(bodypart);
				prologBuilder.append(",");
			}
			prologBuilder.deleteCharAt(prologBuilder.length()-1);
		}
		prologBuilder.append(".\n");
	}
	
	public String visit(AndExpression expression) {
		StringBuilder prologBuilder =  new StringBuilder();
		if (expression.getPredicateName()==null)
		{
			expression.setPredicateFunctor("expression", "(Tag)");
			
			String[] bodyparts=new String[ expression.getExpressionList().size()];
			int index = 0;
			for(AbstractExpression child : expression.getExpressionList())
			{
				prologBuilder.append(child.accept(this));
				bodyparts[index++] = appendPrologCheckNot(child.getPredicateName(),expression);
			}
			
			makePrologRule(prologBuilder, expression.getPredicateName(),bodyparts);
		}
		return prologBuilder.toString();
	}
	
	public String visit(OrExpression expression) {
		StringBuilder prologBuilder =  new StringBuilder();
		if (expression.getPredicateName()==null)
		{
			expression.setPredicateFunctor("expression","(Tag)");

			for(AbstractExpression child : expression.getExpressionList())
			{
				prologBuilder.append(child.accept(this));

				String[] bodyparts = new String[] { appendPrologCheckNot( child.getPredicateName(),expression) };				
				makePrologRule(prologBuilder, expression.getPredicateName(),bodyparts);
			}
		}
		return prologBuilder.toString();
	}

	public String visit(SingleExpression expression) {
		StringBuilder prologBuilder =  new StringBuilder();
		if (expression.getPredicateName()==null)
		{
			if (expression.getExecutionCondition() != null)
			{
				expression.setPredicateFunctor("expression", "(Tag)");
				
				prologBuilder.append( getPrologCode(expression.getExecutionCondition()));
				
				String[] bodyParts = new String[] { appendPrologCheckNot(expression.getExecutionCondition().getPredicateName(), expression) };				
				makePrologRule(prologBuilder, expression.getPredicateName(), bodyParts);
			}
		}
		return prologBuilder.toString();
	}

	public List<String> getExceptionConditionPrologCode(ExceptionEvaluationCondition exceptionCondition) {
		List<String> bodyParts=new ArrayList<String>();
		if (exceptionCondition != null)
		{
			if (exceptionCondition.isCheckAnyException())
			{
				bodyParts.add("isExitError(Tag)");
			}
			else
			{
				bodyParts.add("exceptionThrown(Tag, TagException)");
				StringBuilder prologBuilder = new StringBuilder();
				String stringTagName = appendToString(prologBuilder, "TagException");
				appendEqualCheck(prologBuilder, stringTagName, exceptionCondition.getValue());
				bodyParts.add(prologBuilder.toString());
			}
		}
		return bodyParts;
	}
	
	public String getParameterEvaluationConditionPrologCode(ParameterEvaluationCondition evaluationCondition, String tagSufixName) 
	{
		String element = "Arg".concat(tagSufixName);
		
		StringBuilder prologBuilder = new StringBuilder();
		if (evaluationCondition.getParameterPosition() != -1)
		{
			//Specific Method Condition
			prologBuilder.append("elemetAt(Arguments,");
			prologBuilder.append(evaluationCondition.getParameterPosition());
			prologBuilder.append(",");
			prologBuilder.append(element);
			prologBuilder.append("),");
		}
		else
		{
			//General method condition
			prologBuilder.append("member(");
			prologBuilder.append(element);			
			prologBuilder.append(",Arguments),");			
		}
		prologBuilder.append(getPrologSyntax(evaluationCondition.getCondition(), element, evaluationCondition.getValue()));		
		
		if (evaluationCondition.getFieldEvaluationConditions().size() > 0)
		{
			String fieldsListName = "ArgumentFields".concat(tagSufixName);
			
			prologBuilder.append(",snapshotFields(");
			prologBuilder.append(element);
			prologBuilder.append(",");
			prologBuilder.append(fieldsListName);
			prologBuilder.append("),");			
			
			int index=0;
			for(FieldEvaluationCondition fieldEvaluationCondition : evaluationCondition.getFieldEvaluationConditions())
			{
				prologBuilder.append( getFieldEvaluationConditionPrologCode(fieldEvaluationCondition, fieldsListName, tagSufixName.concat("Field").concat(String.valueOf(index++))) );
				prologBuilder.append(",");
			}
			prologBuilder.deleteCharAt(prologBuilder.length() - 1);
		}
		return prologBuilder.toString();
	}

	public String getFieldEvaluationConditionPrologCode(FieldEvaluationCondition evaluationCondition, String filedListName, String prefixName)
	{
		String elementName = "FieldName".concat(prefixName);
		String elementValue = "FieldValue".concat(prefixName);
		
		StringBuilder prologBuilder = new StringBuilder();
		prologBuilder.append("member(field(");
		prologBuilder.append(elementName);
		prologBuilder.append(",");
		prologBuilder.append(elementValue);
		prologBuilder.append("),");
		prologBuilder.append(filedListName);
		prologBuilder.append("),");
		
		//if name is null, the condition is for any fields that matches the condition
		if (evaluationCondition.getFieldName() != null && !evaluationCondition.getFieldName().trim().equals(""))
		{
			prologBuilder.append("stringContains(");
			prologBuilder.append(elementName);
			prologBuilder.append(",'#");
			prologBuilder.append(evaluationCondition.getFieldName());
			prologBuilder.append(":'),");
		}		
		prologBuilder.append(getPrologSyntaxForFields(evaluationCondition.getCondition(), elementName, elementValue, evaluationCondition.getValue()));
		
		return prologBuilder.toString();
	}

	public String getReturnedValueEvaluationConditionPrologCode(ReturnedValueEvaluationCondition evaluationCondition) {
		StringBuilder prolog =  new StringBuilder();
		prolog.append(getPrologSyntax(evaluationCondition.getCondition(), "ReturnValue", evaluationCondition.getValue()));
		return prolog.toString();
	}

	public String getScopeEvaluationConditionPrologCode(ScopeEvaluationCondition evaluationCondition, String listTagName) {
		return "scopeAcceptsSnapshot(Scope,".concat(listTagName).concat(")");
	}
	
	private List<String> getMethodMatchingBodyParts(ExecutionCondition executionCondition)
	{
		List<String> bodyParts = new ArrayList<String>();
		if (executionCondition.getPatternMapping() != null)
		{
			//Method mapping specific prolog code
			bodyParts.add("behavior(Tag,BehaviorTag)");
			bodyParts.add("behaviorDescriptor(BehaviorTag,BehaviorDescriptor)");
			bodyParts.add("regexMatch(BehaviorDescriptor,'".concat(executionCondition.getPatternMapping().getBehaviorPattern()).concat("')"));
		}
		return bodyParts;
	}
	
	private List<String> getInternalMethodCallMethodMatchingBodyParts(ExecutionCondition executionCondition)
	{
		List<String> bodyParts = new ArrayList<String>();
		if (executionCondition.getPatternMapping() != null)
		{
			//Method mapping specific prolog code
			bodyParts.add("targetBehavior(Tag,BehaviorTag)");
			bodyParts.add("behaviorDescriptor(BehaviorTag,BehaviorDescriptor)");
			bodyParts.add("regexMatch(BehaviorDescriptor,'".concat(executionCondition.getPatternMapping().getBehaviorPattern()).concat("')"));
		}
		return bodyParts;
	}
	
	public String getPrologCode(ExecutionCondition executionCondition) {
		StringBuilder prologBuilder =  new StringBuilder();
		if (executionCondition != null && executionCondition.getPredicateName()==null)
		{
			executionCondition.setPredicateFunctor("executionCondition", "(Tag)");
			List<String> bodyParts=new ArrayList<String>();
			
			bodyParts.addAll(getMethodMatchingBodyParts(executionCondition));
			if(executionCondition.getScope() != null)
			{
				bodyParts.add("preScope(Scope)");
			}
			bodyParts.addAll(getExceptionConditionPrologCode(executionCondition.getException()));
			if (executionCondition.getInstanceOfClass() != null)
			{
				bodyParts.add("executionInstanceSnapshot(Tag,SnapshotInstance)");
				bodyParts.add("snapshotObject(SnapshotInstance,SnapshotInstanceObject)");
				bodyParts.add("objectClass(SnapshotInstanceObject,SnapshotInstanceClass)");
				bodyParts.add("classDescriptor(SnapshotInstanceClass,SnapshotInstanceDescriptor)");
				bodyParts.add("stringContains(SnapshotInstanceDescriptor,'".concat(executionCondition.getInstanceOfClass()).concat("')"));
			}			
			bodyParts.addAll(getArgumentsBodyParts(executionCondition));
			bodyParts.addAll(getFieldsBodyParts(executionCondition, "executionInstanceSnapshot"));	
			bodyParts.addAll(getReturnValueBodyParts(executionCondition));					
			bodyParts.addAll(getInternalMethodCallsBodyParts(executionCondition,executionCondition.getPredicateName(),prologBuilder));
			
			makePrologRule(prologBuilder, executionCondition.getPredicateName(), bodyParts.toArray(new String[bodyParts.size()]));
		}
		
		return prologBuilder.toString();
	}

	protected List<String> getArgumentsBodyParts(ExecutionCondition executionCondition)
	{		
		List<String> bodyParts=new ArrayList<String>();
		boolean useScope = (executionCondition.getScope() != null && executionCondition.getScope().hasScopeFilter(ScopeFilterType.ARGUMENTS_SCOPE));		
		if (executionCondition.getParameters().size() > 0 || useScope)
		{
			bodyParts.add("arguments(Tag,Arguments)");
			
			if (useScope)
			{
				bodyParts.add( getScopeEvaluationConditionPrologCode(executionCondition.getScope(), "Arguments") );
			}
			
			int index = 0;
			for(ParameterEvaluationCondition parameterEvaluationCondition : executionCondition.getParameters())
			{
				bodyParts.add( getParameterEvaluationConditionPrologCode(parameterEvaluationCondition, String.valueOf(index++)) );
			}
		}
		return  bodyParts;
	}
	
	protected List<String> getFieldsBodyParts(ExecutionCondition executionCondition, String tagSnapshotName)
	{
		List<String> bodyparts=new ArrayList<String>();
		boolean useScope = (executionCondition.getScope() != null && executionCondition.getScope().hasScopeFilter(ScopeFilterType.FIELDS_SCOPE));
		if (executionCondition.getFields().size() > 0 || useScope)
		{
			bodyparts.add(tagSnapshotName.concat("(Tag, SnapshotFields)"));
			bodyparts.add("snapshotFields(SnapshotFields,Fields)");
			if (useScope)
			{
				bodyparts.add( getScopeEvaluationConditionPrologCode(executionCondition.getScope(), "Fields") );
			}
			
			int index=0;
			for(FieldEvaluationCondition fieldEvaluationCondition : executionCondition.getFields())
			{
				bodyparts.add( getFieldEvaluationConditionPrologCode(fieldEvaluationCondition, "Fields", String.valueOf(index++)) );
			}
		}
		return bodyparts;
	}
	
	protected List<String> getReturnValueBodyParts(ExecutionCondition executionCondition)
	{
		List<String> bodyparts=new ArrayList<String>();
		boolean useScope = (executionCondition.getScope() != null && executionCondition.getScope().hasScopeFilter(ScopeFilterType.RETURNVALUE_SCOPE));
		if (executionCondition.getReturnedValue() != null || useScope)
		{		
			bodyparts.add("returnValue(Tag,ReturnValue)");
			if (useScope)
			{
				bodyparts.add( getScopeEvaluationConditionPrologCode(executionCondition.getScope(), "ReturnValue") );			
			}
			
			if (executionCondition.getReturnedValue() != null)
			{
				bodyparts.add( getReturnedValueEvaluationConditionPrologCode(executionCondition.getReturnedValue()) );
			}
		}
		return bodyparts;
	}
	
	private List<String> getInternalMethodCallsBodyParts(ExecutionCondition executionCondition, String predicateName, StringBuilder prologBuilder)
	{
		List<String> bodyparts=new ArrayList<String>();
		if (executionCondition.getInternalMethodCalls().size() > 0)
		{
			String internalPredicateName = predicateName.substring(0, predicateName.indexOf('('));
			
			bodyparts.add("internalEventList(Tag,InternalEventTagList)");
			
			String internalEventTagName = internalPredicateName.concat("InternalEvent"); 
			int index = 0;			
			for(ExecutionCondition internalMethod : executionCondition.getInternalMethodCalls())
			{				
				internalEventTagName = internalEventTagName.concat(String.valueOf(index++));
				bodyparts.add(internalEventTagName.concat("(Tag,InternalEventTagList)"));
					
				List<String> auxBodyParts=new ArrayList<String>();
				auxBodyParts.add("member(Tag,InternalEventTagList)");
				auxBodyParts.addAll(getInternalMethodCallMethodMatchingBodyParts(internalMethod));
				auxBodyParts.addAll(getArgumentsBodyParts(internalMethod));
				auxBodyParts.addAll(getFieldsBodyParts(internalMethod, "targetInstance"));	
				auxBodyParts.addAll(getReturnValueBodyParts(internalMethod));
				
				makePrologRule(prologBuilder, internalEventTagName.concat("(Tag,InternalEventTagList)"), auxBodyParts.toArray(new String[auxBodyParts.size()]));
			}
		}
		return bodyparts;
	}
	
	private void appendExceptionStatePrologCode(StringBuilder prologBuilder, ExecutionStateValue exceptionState, TagProvider tagProvider)
	{
		if (exceptionState != ExecutionStateValue.NONE)
    	{
			makePrologRule(prologBuilder, tagProvider.getExecutionStateCommonTag(exceptionState), 
    								new String[] {"executionTag(T)", "isExitError(T)"});    			
    	}
	}
	
	private void appendDefaultStatePrologCode(StringBuilder prologBuilder, ExecutionStateValue defaultState, TagProvider tagProvider)
	{
		if (defaultState != ExecutionStateValue.NONE)
    	{
			makePrologRule(prologBuilder, tagProvider.getExecutionStateCommonTag(defaultState), new String[]{});
    	}
	}
	
	private void appendPreFiltersPrologCode(List<ExecutionCondition> preFiltersList, StringBuilder prologBuilder, TagProvider tagProvider)
	{
		if (preFiltersList.size() > 0)
		{	
			StringBuilder preFiltersProlog = new StringBuilder();
			preFiltersProlog.append(tagProvider.getPreFilterInitialTag());
			preFiltersProlog.append("\n");
			for(ExecutionCondition executionCondition : preFiltersList)
			{										
				prologBuilder.append( getPrologCode(executionCondition) );
				
				makePrologRule(preFiltersProlog, tagProvider.getPreFilterCommonTag(), 
        									new String[] {executionCondition.getPredicateName()});
			}
			prologBuilder.append(preFiltersProlog);
		}
	}
	
	private void makePrologForState(State actualState, List<ExecutionCondition> visitedEvents, List<ExecutionCondition> pathEvents, StringBuilder actualProlog, TagProvider tagProvider)
    {
    	if(actualState.getStateType()==StateType.FINAL)
    	{
    		StringBuilder builder=new StringBuilder();
    		int index = 0; String tagName;
    		for(ExecutionCondition pathEvent:pathEvents)
    		{
    			if (pathEvent != null)
    			{
	    			tagName = "Tag".concat(String.valueOf(index++));
	    			builder.append("executionTag(");
	    			builder.append(tagName);
	    			builder.append("),");
	    			builder.append(pathEvent.getPredicateName().replaceFirst("Tag", tagName));
	    			builder.append(",");
    			}
    		}
    		if (builder.length() > 0)
    		{
    			builder.deleteCharAt(builder.length()-1);
    		}
    		
			makePrologRule(actualProlog, tagProvider.getExecutionStateCommonTag(((FinalState)actualState).getExecutionState()), 
								new String[] {builder.toString()});    			
    	}
    	else
    	{
    		for(TransitionCondition transitionCondition : actualState.getSourceTransitionConditions())
    		{
    			ExecutionCondition executionCondition = transitionCondition.getExecutionCondition();
    			if(!visitedEvents.contains(executionCondition))
    			{
    				actualProlog.append( getPrologCode(executionCondition) );
    				visitedEvents.add(executionCondition);
    			}
    			pathEvents.add(executionCondition);
    			makePrologForState(transitionCondition.getTargetState(), visitedEvents, pathEvents, actualProlog, tagProvider);
    			pathEvents.remove(executionCondition);
    		}
    	}
    }
	
	public String getPrologCode(StateContainer stateContainer, TagProvider tagProvider) {
		List<ExecutionCondition> visitedEvents=new ArrayList<ExecutionCondition>();
    	List<ExecutionCondition> pathEvents=new ArrayList<ExecutionCondition>();
    	StringBuilder prologBuilder=new StringBuilder();
    	appendPreFiltersPrologCode(stateContainer.getPreFilters(),prologBuilder, tagProvider);
    	appendExceptionStatePrologCode(prologBuilder, stateContainer.getExceptionState(), tagProvider);
    	
    	//Diagram backtracking prolog
    	for(State initialState: stateContainer.getInicialStates())
    	{
    		makePrologForState(initialState, visitedEvents, pathEvents, prologBuilder, tagProvider);
    	}
    	
    	appendDefaultStatePrologCode(prologBuilder, stateContainer.getDefaultState(), tagProvider);
    	
    	return prologBuilder.toString();
	}

	public String getPrologCode(SimpleExecutionConditionConfiguration simpleExecutionConditionConfiguration, TagProvider tagProvider) {
		StringBuilder prologBuilder = new StringBuilder();
    	appendPreFiltersPrologCode(simpleExecutionConditionConfiguration.getPreFilters(), prologBuilder, tagProvider);
    	
    	if (simpleExecutionConditionConfiguration.isUseDefaultConfiguration())
    	{
    		makePrologRule(prologBuilder, tagProvider.getExecutionStateCommonTag(ExecutionStateValue.FAULTY), 
    								new String[] {"executionTag(Tag)", "isExitError(Tag)"});
    		
    		makePrologRule(prologBuilder, tagProvider.getExecutionStateCommonTag(ExecutionStateValue.EXECUTED), 
    								new String[] {"executionTag(_)"});
    		
    		makePrologRule(prologBuilder, tagProvider.getExecutionStateCommonTag(ExecutionStateValue.NOT_EXECUTED), 
									new String[] {});
    	}
    	else
    	{
	    	appendExceptionStatePrologCode(prologBuilder, simpleExecutionConditionConfiguration.getExceptionState(), tagProvider);
	    	
	    	for(SimpleExpressionExecutionCondition simpleExpression : simpleExecutionConditionConfiguration.getSimpleExpressionExecutionConditions())
	    	{
	    		if (simpleExpression.getExpression() != null)
	    		{
	    			prologBuilder.append(simpleExpression.getExpression().accept(this));
	    			
	        		makePrologRule(prologBuilder, tagProvider.getExecutionStateCommonTag(simpleExpression.getExecutionState()),
	        						new String[] {"executionTag(Tag)", simpleExpression.getExpression().getPredicateName()});    			
	    		}
	    	}
	    	
	    	appendDefaultStatePrologCode(prologBuilder, simpleExecutionConditionConfiguration.getExecutionConditionNotVerifiedState(), tagProvider);
    	}
    	
    	return prologBuilder.toString();
	}

	public String getPrologSyntax(ConditionValue conditionValue, String argumentNameVariableName, String valueToCheck)
	{
		StringBuilder prolog =  new StringBuilder();
		switch(conditionValue.getValue())		
		{
			case ConditionValue.EQUAL_VALUE:
			{
				String valueName = appendToString(prolog, argumentNameVariableName);
				appendEqualCheck(prolog, valueName, valueToCheck);
				return prolog.toString();
			}
			case ConditionValue.NOT_EQUAL_VALUE:
			{
				String valueName =  appendToString(prolog, argumentNameVariableName);
				prolog.append("not(");
				appendEqualCheck(prolog, valueName, valueToCheck);
				prolog.append(")");
				return prolog.toString();
			}
			case ConditionValue.LOWER_VALUE:
			{
				String valueName = appendToString(prolog, argumentNameVariableName);				
				appendLowerCheck(prolog, valueName, valueToCheck);
				return prolog.toString();
			}
			case ConditionValue.LOWER_EQUAL_VALUE:
			{
				String valueName = appendToString(prolog, argumentNameVariableName);				
				appendLowerEqualCheck(prolog, valueName, valueToCheck);
				return prolog.toString();
			}	
			case ConditionValue.GREATER_VALUE:
			{
				String valueName = appendToString(prolog, argumentNameVariableName);				
				appendGreaterCheck(prolog, valueName, valueToCheck);
				return prolog.toString();
			}
			case ConditionValue.GREATER_EQUAL_VALUE:
			{
				String valueName = appendToString(prolog, argumentNameVariableName);				
				appendGreaterEqualCheck(prolog, valueName, valueToCheck);
				return prolog.toString();
			}			
			case ConditionValue.CONTAINS_VALUE:
			{
				String valueName = appendToString(prolog, argumentNameVariableName);
				appendContainsCheck(prolog, valueName, valueToCheck);
				return prolog.toString();
			}
			case ConditionValue.NOT_CONTAINS_VALUE:
			{
				String valueName =  appendToString(prolog, argumentNameVariableName);
				prolog.append("not(");
				appendContainsCheck(prolog, valueName, valueToCheck);
				prolog.append(")");
				return prolog.toString();
			}
			case ConditionValue.IS_NULL_VALUE:
			{
				appendNullCheck(prolog, argumentNameVariableName);
				return prolog.toString();
			}
			case ConditionValue.NOT_NULL_VALUE:
			{
				prolog.append("not(");
				appendNullCheck(prolog, argumentNameVariableName);
				prolog.append(")");
				return prolog.toString();
			}
			case ConditionValue.IS_CLASS_VALUE:
			{
				appendClassOfCheck(prolog, argumentNameVariableName, valueToCheck);
				return prolog.toString();
			}
			case ConditionValue.NOT_IS_CLASS_VALUE:
			{
				prolog.append("not(");
				appendClassOfCheck(prolog, argumentNameVariableName, valueToCheck);
				prolog.append(")");
				return prolog.toString();
			}
		}
		return "";
	}
	
	public String getPrologSyntaxForFields(ConditionValue conditionValue, String fieldNameVariableName, String fieldValueVariableName, String valueToCheck)
	{
		StringBuilder prolog =  new StringBuilder();
		switch(conditionValue.getValue())
		{
			case ConditionValue.EQUAL_VALUE:
			{
				appendEqualCheck(prolog, fieldValueVariableName, valueToCheck);
				return prolog.toString();
			}
			case ConditionValue.NOT_EQUAL_VALUE:
			{
				prolog.append("not(");
				appendEqualCheck(prolog, fieldValueVariableName, valueToCheck);
				prolog.append(")");
				return prolog.toString();
			}
			case ConditionValue.LOWER_VALUE:
			{			
				appendLowerCheck(prolog, fieldValueVariableName, valueToCheck);
				return prolog.toString();
			}
			case ConditionValue.LOWER_EQUAL_VALUE:
			{
				appendLowerEqualCheck(prolog, fieldValueVariableName, valueToCheck);
				return prolog.toString();
			}	
			case ConditionValue.GREATER_VALUE:
			{
				appendGreaterCheck(prolog, fieldValueVariableName, valueToCheck);
				return prolog.toString();
			}
			case ConditionValue.GREATER_EQUAL_VALUE:
			{
				appendGreaterEqualCheck(prolog, fieldValueVariableName, valueToCheck);
				return prolog.toString();
			}
			case ConditionValue.CONTAINS_VALUE:
			{
				appendContainsCheck(prolog, fieldValueVariableName, valueToCheck);
				return prolog.toString();
			}
			case ConditionValue.NOT_CONTAINS_VALUE:
			{
				prolog.append("not(");
				appendContainsCheck(prolog, fieldValueVariableName, valueToCheck);
				prolog.append(")");
				return prolog.toString();
			}
			case ConditionValue.IS_NULL_VALUE:
			{
				appendFieldNullCheck(prolog, fieldValueVariableName);
				return prolog.toString();
			}
			case ConditionValue.NOT_NULL_VALUE:
			{
				prolog.append("not(");
				appendFieldNullCheck(prolog, fieldValueVariableName);
				prolog.append(")");
				return prolog.toString();
			}
			case ConditionValue.IS_CLASS_VALUE:
			{
				appendFieldClassOfCheck(prolog,fieldValueVariableName, valueToCheck);
				return prolog.toString();
			}
			case ConditionValue.NOT_IS_CLASS_VALUE:
			{
				prolog.append("not(");
				appendFieldClassOfCheck(prolog,fieldValueVariableName, valueToCheck);
				prolog.append(")");
				return prolog.toString();
			}
		}
		return "";
	}
	
	private void appendFieldNullCheck(StringBuilder prolog, String fieldValueVariableName)
	{
		prolog.append("stringsEqual(");
		prolog.append(fieldValueVariableName);
		prolog.append(", 'null')");
	}
	
	private void appendFieldClassOfCheck(StringBuilder prolog, String fieldValueVariableName, String valueToCheck)
	{
		prolog.append("stringContains(");
		prolog.append(fieldValueVariableName);
		prolog.append(",'");
		prolog.append(valueToCheck);
		prolog.append("')");
	}
	
	private void appendNullCheck(StringBuilder prolog, String argumentNameVariableName)
	{
		prolog.append("snapshotIsNull(");
		prolog.append(argumentNameVariableName);
		prolog.append(")");
	}
	
	private void appendEqualCheck(StringBuilder prolog, String argumentValueVariableValue, String valueToCheck)
	{		
		appendCheck("stringsEqual", prolog, argumentValueVariableValue, valueToCheck);
	}	
	
	private void appendGreaterCheck(StringBuilder prolog, String argumentValueVariableValue, String valueToCheck)
	{		
		appendCheck("stringsGreater", prolog, argumentValueVariableValue, valueToCheck);
	}
	
	private void appendGreaterEqualCheck(StringBuilder prolog, String argumentValueVariableValue, String valueToCheck)
	{		
		appendCheck("stringsGreaterEqual", prolog, argumentValueVariableValue, valueToCheck);
	}
	
	private void appendLowerCheck(StringBuilder prolog, String argumentValueVariableValue, String valueToCheck)
	{		
		appendCheck("stringsLower", prolog, argumentValueVariableValue, valueToCheck);
	}
	
	private void appendLowerEqualCheck(StringBuilder prolog, String argumentValueVariableValue, String valueToCheck)
	{		
		appendCheck("stringsLowerEqual", prolog, argumentValueVariableValue, valueToCheck);
	}
	
	private void appendContainsCheck(StringBuilder prolog, String argumentValueVariableValue, String valueToCheck)
	{		
		appendCheck("stringContains", prolog, argumentValueVariableValue, valueToCheck);
	}
	
	private void appendCheck(String checkString, StringBuilder prolog, String argumentValueVariableValue, String valueToCheck)
	{		
		prolog.append(checkString);
		prolog.append("(");
		prolog.append(argumentValueVariableValue);
		prolog.append(",'");
		prolog.append(valueToCheck);
		prolog.append("')");
	}
	
	private String appendToString(StringBuilder prolog, String argumentNameVariableName)
	{
		String stringCheckName = "String".concat(argumentNameVariableName);
		prolog.append("snapshotToString(");
		prolog.append(argumentNameVariableName);
		prolog.append(",");
		prolog.append(stringCheckName);
		prolog.append("),");
		return stringCheckName;
	}
	
	private void appendClassOfCheck(StringBuilder prolog, String argumentNameVariableName, String valueToCheck)
	{
		String objectSnapshotName = "ObjectSnapshot".concat(argumentNameVariableName);
		String objectClassName = "ObjectClass".concat(argumentNameVariableName);
		String classDescriptorName = "ClassDescriptor".concat(argumentNameVariableName);
		
		prolog.append("snapshotObject(");
		prolog.append(argumentNameVariableName);
		prolog.append(",");
		prolog.append(objectSnapshotName);
		prolog.append("),");
		prolog.append("objectClass(");
		prolog.append(objectSnapshotName);
		prolog.append(",");
		prolog.append(objectClassName);
		prolog.append("),");
		prolog.append("classDescriptor(");
		prolog.append(objectClassName);
		prolog.append(",");
		prolog.append(classDescriptorName);
		prolog.append("),");
		prolog.append("stringContains(");
		prolog.append(classDescriptorName);
		prolog.append(",'");
		prolog.append(valueToCheck);
		prolog.append("')");
	}
	
} //PrologCodeFactoryImpl
