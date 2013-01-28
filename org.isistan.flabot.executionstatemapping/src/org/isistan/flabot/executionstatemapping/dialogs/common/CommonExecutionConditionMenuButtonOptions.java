package org.isistan.flabot.executionstatemapping.dialogs.common;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.isistan.flabot.executionstatemapping.commands.executioncondition.ManageMethodExecutionConditionCommand;
import org.isistan.flabot.executionstatemapping.commands.executioncondition.ManagePersistentTreeElementCommand;
import org.isistan.flabot.executionstatemapping.dialogs.utils.DialogUtils;
import org.isistan.flabot.executionstatemapping.dialogs.utils.contentproviders.TreeExecutionConditionContentProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.filter.ViewFilterProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.labelproviders.TreeExecutionConditionLabelProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.validators.ExecutionConditionSelectionValidator;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement;

public class CommonExecutionConditionMenuButtonOptions {
	
	private ExecutionStateMappingFileModel executionStateMappingFileModel;
	
	private Menu menu;
	
	public CommonExecutionConditionMenuButtonOptions(final Button button, ExecutionStateMappingFileModel executionStateMappingFileModel)
	{
		this.executionStateMappingFileModel = executionStateMappingFileModel;
		
		menu = new Menu(button);
		
		button.addSelectionListener(new SelectionAdapter() 
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				Rectangle rect = button.getBounds();
				Point pt = new Point(rect.x, rect.y + rect.height);
			    pt = button.getParent().toDisplay(pt);			    
			    menu.setLocation(pt.x, pt.y);
			    menu.setVisible(true);			    
			}
		});
		
		button.setMenu(menu);
	}
	
	public void appendAdditionalOptions(MenuSubItem[] additionalMenuOptions)
	{
		for(MenuSubItem item : additionalMenuOptions)
		{
			MenuItem menuSubItem = new MenuItem(menu, SWT.PUSH);
			menuSubItem.setText(item.getTextName());
			menuSubItem.addSelectionListener(item.getSelectionListener());				
		}
	}
	
	public void appendPoolSelectionOption(final AggregableElement<ExecutionCondition> aggregableElement, final ViewFilterProvider[] viewFilterProviders)
	{		
		MenuItem menuItem = new MenuItem(menu, SWT.PUSH);
		menuItem.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.common.CommonExecutionConditionMenuButtonOptions.selectFromPool"));  //$NON-NLS-1$
		menuItem.addSelectionListener(new SelectionAdapter()
		{
			@Override
			@SuppressWarnings("restriction") //$NON-NLS-1$
			public void widgetSelected(SelectionEvent e) 
			{				
				TreeStructuredElement[] treeRoot = new TreeStructuredElement[] {executionStateMappingFileModel.getMethodExecutionConditionsTree(), executionStateMappingFileModel.getGeneralExecutionConditionsTree()};
								
				ExecutionCondition newExecutionCondition =(ExecutionCondition) DialogUtils
				.getSelectedTreeElement(Messages.getString("org.isistan.flabot.executionmapping.dialogs.common.CommonExecutionConditionMenuButtonOptions.executionConditionSelection"), //$NON-NLS-1$
						Messages.getString("org.isistan.flabot.executionmapping.dialogs.common.CommonExecutionConditionMenuButtonOptions.selectExecutionCondition"), //$NON-NLS-1$
						new TreeExecutionConditionLabelProvider(), new TreeExecutionConditionContentProvider(), treeRoot, new ExecutionConditionSelectionValidator(), viewFilterProviders, null);
				aggregableElement.addElement(newExecutionCondition);
			}
		});		
	}
	
	public void appendNewMethodExecutionConditoionOption(final AggregableElement<ExecutionCondition> aggregableElement, final ViewFilterProvider[] viewFilterProviders)
	{
		MenuItem menuItem = new MenuItem(menu, SWT.PUSH);
		menuItem.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.common.CommonExecutionConditionMenuButtonOptions.newMethodCondition")); //$NON-NLS-1$
		menuItem.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{				 					
				ManageMethodExecutionConditionCommand command = ExecutionConditionEditorBuilder.showNewMethodExecutionConditionDialog(viewFilterProviders, executionStateMappingFileModel);
				if (command != null)
				{					
					command.execute();
		
					aggregableElement.addElement((ExecutionCondition)command.getNewTreeStructuredElement());
				}
			}
		});	
	}
	
	public void appendNewGeneralExecutionConditoionOption(final AggregableElement<ExecutionCondition> aggregableElement)
	{
		MenuItem menuItem = new MenuItem(menu, SWT.PUSH);
		menuItem.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.common.CommonExecutionConditionMenuButtonOptions.newGeneralCondition")); //$NON-NLS-1$
		menuItem.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{				 
				ManagePersistentTreeElementCommand command = ExecutionConditionEditorBuilder.showNewGeneralExecutionConditionDialog(executionStateMappingFileModel);
				if (command != null)
				{					
					command.execute();
		
					aggregableElement.addElement((ExecutionCondition)command.getNewTreeStructuredElement());
				}
			}
		});	
	}	
}