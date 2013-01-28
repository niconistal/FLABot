package org.isistan.flabot.executionstatemapping.dialogs.common;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.swt.widgets.Composite;
import org.isistan.flabot.engine.executionstate.dialogs.ChangeNotifier;
import org.isistan.flabot.executionstatemapping.dialogs.utils.filter.ViewFilterProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.labelproviders.PreFilterLabelProvider;
import org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;

public class PreFilterManagerComposite implements ListElementEventProvider<ExecutionCondition>, AggregableElement<ExecutionCondition> 
{			
	private ListElementsComposite<ExecutionCondition> preFilterComposite;
	
	private ExecutionStateMappingFileModel executionStateMappingFileModel;
	
	private ChangeNotifier changeNotifier;
	
	public PreFilterManagerComposite(Composite composite, int style, ExecutionStateMappingFileModel executionStateMappingFileModel,ViewFilterProvider[] selectExecutionConditionFilters, ViewFilterProvider[] newMethodExecutionConditionFilters)
	{
		preFilterComposite = new ListElementsComposite<ExecutionCondition>(composite, style,  new PreFilterLabelProvider(), this);
		
		CommonExecutionConditionMenuButtonOptions buttonMenu = new CommonExecutionConditionMenuButtonOptions(preFilterComposite.getAddButton(), executionStateMappingFileModel);
		buttonMenu.appendPoolSelectionOption(preFilterComposite, selectExecutionConditionFilters);
		buttonMenu.appendNewMethodExecutionConditoionOption(preFilterComposite, newMethodExecutionConditionFilters);
		buttonMenu.appendNewGeneralExecutionConditoionOption(preFilterComposite);		
	}
		
	public void setElements(List<ExecutionCondition> elements)
	{
		preFilterComposite.setElements(elements);
		preFilterComposite.activate();
	}
	
	public void setChangeNotifier(ChangeNotifier changeNotifier)
	{
		this.changeNotifier = changeNotifier;
	}
	
	public void addElement(ExecutionCondition element)
	{
		preFilterComposite.addElement(element);
		if (changeNotifier != null)
		{
			changeNotifier.onChange();
		}
	}
	
	public List<ExecutionCondition> getElements()
	{
		return preFilterComposite.getElements();
	}
	
	public ExecutionCondition onAddElement() 
	{		
		return null;
	}
	
	public ExecutionCondition onEditElement(ExecutionCondition element) 
	{
		Command command = ExecutionConditionEditorBuilder.showEditExecutionConditionDialog(element, executionStateMappingFileModel);
		if (command != null)
		{
			command.execute();
		}
		return element;
	}
	
	public void onRemoveElement(ExecutionCondition element) 
	{
		if (changeNotifier != null)
		{
			changeNotifier.onChange();
		}
	}
}