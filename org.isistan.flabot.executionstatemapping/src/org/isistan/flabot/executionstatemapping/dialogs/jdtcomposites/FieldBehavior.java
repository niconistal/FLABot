package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites;

import java.util.List;
import org.isistan.flabot.executionstatemapping.model.semantic.FieldEvaluationCondition;

public interface FieldBehavior 
{	
	public void fillTable(List<FieldEvaluationCondition> evaluationConditions);
	
	public List<FieldEvaluationCondition> getFieldsEvaluationConditions();
	
	public void activate();
	
	public int getItemCount();
}