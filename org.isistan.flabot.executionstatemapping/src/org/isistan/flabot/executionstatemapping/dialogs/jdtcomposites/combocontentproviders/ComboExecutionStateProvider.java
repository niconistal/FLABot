package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.combocontentproviders;

import org.eclipse.swt.widgets.Combo;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue;
import org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition;

public class ComboExecutionStateProvider{

	public void fillCombo(Combo comboRole,SimpleExpressionExecutionCondition expressionEvent) {
		for(ExecutionStateValue value : ExecutionStateValue.getExecutionValues())
		{
			comboRole.add(value.getInternacionalizedName());
			comboRole.setData(String.valueOf(comboRole.getItemCount()-1), value);
		}		
		comboRole.select(0);	
				
		if(expressionEvent!=null)
		{
			setExecutiontate(comboRole,expressionEvent);
		}
	}
	
	private void setExecutiontate(Combo comboRole,SimpleExpressionExecutionCondition expressionEvent)
	{
		for(int i=0; i<comboRole.getItemCount(); i++)
		{
			if ( ((ExecutionStateValue)comboRole.getData(String.valueOf(i))) == expressionEvent.getExecutionState() )
			{
				comboRole.select(i);
				break;
			}
		}
	}
}