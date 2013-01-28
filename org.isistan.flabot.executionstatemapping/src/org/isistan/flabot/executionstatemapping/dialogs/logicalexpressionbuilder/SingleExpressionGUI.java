package org.isistan.flabot.executionstatemapping.dialogs.logicalexpressionbuilder;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.internal.Workbench;
import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;
import org.isistan.flabot.executionstatemapping.InterfacePluginExecutionStateMapping;
import org.isistan.flabot.executionstatemapping.dialogs.common.AggregableElement;
import org.isistan.flabot.executionstatemapping.dialogs.common.CommonExecutionConditionMenuButtonOptions;
import org.isistan.flabot.executionstatemapping.dialogs.common.ExecutionConditionEditorBuilder;
import org.isistan.flabot.executionstatemapping.dialogs.common.MenuSubItem;
import org.isistan.flabot.executionstatemapping.dialogs.utils.filter.ViewFilterProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.labelproviders.ExecutionLabelProvider;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel;
import org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticFactory;
import org.isistan.flabot.executionstatemapping.model.semantic.SingleExpression;

public class SingleExpressionGUI extends LogicalExpressionGUI implements AggregableElement<ExecutionCondition> {
	
	private Text labelCondicion;
	
	private Button buttonInsert;
	
	private ExecutionCondition executionCondition;
	
	private SelectionListener buttonAttributeListener;
	
	private ExecutionLabelProvider labelProvider = new ExecutionLabelProvider();
	
	private MouseListener mouseListener;
		
	public SingleExpressionGUI(LogicalExpressionGUI parentExpression,Composite externalComposite, ViewFilterProvider[] selectExecutionConditionFilters, ViewFilterProvider[] newExecutionConditionFilters)
	{
		super(parentExpression,externalComposite,selectExecutionConditionFilters,newExecutionConditionFilters);
	}
			
	public List<String> getErrors()
	{
		List<String> errors=new ArrayList<String>();
		if(executionCondition==null)
			errors.add(""); //$NON-NLS-1$
		return errors;
	}

	@Override
	protected void createCompleteGUIExpression(Composite externalComposite) 
	{	
		createCompositeAttributes(externalComposite);

		expressionComposite=new Composite(externalComposite, SWT.NONE);
		createPartialGUIExpression();
	}
	
	@Override
	protected void createPartialGUIExpression()
	{	GridData gridData = new GridData();
		//gridData.heightHint=16;
		gridData.grabExcessHorizontalSpace=true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.marginHeight = 0;
		gridLayout1.marginWidth = 0;
		gridLayout1.numColumns=2;
		gridLayout1.horizontalSpacing=0;
		
		expressionComposite.setLayout(gridLayout1);
		expressionComposite.setLayoutData(gridData);
		
	    labelCondicion = new Text(expressionComposite,  SWT.BORDER);
	    GridData gridDataLabel = new GridData();
		gridDataLabel.widthHint=300;
		gridDataLabel.grabExcessHorizontalSpace=true;
		gridDataLabel.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;		
	    labelCondicion.setLayoutData(gridDataLabel);
		labelCondicion.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
		mouseListener=new MouseListener(){
			public void mouseDoubleClick(MouseEvent event){}
			public void mouseUp(MouseEvent event){}
			public void mouseDown(MouseEvent event)
			{
				if(parentExpression!=null)
					parentExpression.notifyObservers();
			}
		};
		
		labelCondicion.addMouseListener(new MouseListener(){
			public void mouseDoubleClick(MouseEvent event){}
			public void mouseUp(MouseEvent event){}
			public void mouseDown(MouseEvent event)
			{
				notifyObservers();
			}
		});
		
		compositeAttributes.addMouseListener(mouseListener);
		labelAttributes.addMouseListener(mouseListener);
		
		final Menu menu=createMenuAttributes();
		buttonAttributeListener=new SelectionAdapter() 
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				Rectangle rect = buttonAttributes.getBounds();
				Point pt = new Point(rect.x, rect.y + rect.height);
			    pt = buttonAttributes.getParent().toDisplay(pt);
			    menu.setLocation(pt.x, pt.y);
			    menu.setVisible(true);
			}};
		
		buttonAttributes.addSelectionListener(buttonAttributeListener);		
		buttonAttributes.setMenu(menu);
		
		GridData gridData2 = new GridData();
		//gridData2.heightHint=16;
		buttonInsert=new Button(expressionComposite,SWT.CENTER);
		buttonInsert.setLayoutData(gridData2);
		buttonInsert.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.logicalexpressionbuilder.SingleExpressionGUI.chooseButton")); //$NON-NLS-1$
		
		final ExecutionStateMappingFileModel executionStateMappingFileModel = InterfacePluginExecutionStateMapping.getFileModel(getEditor());
		
		MenuSubItem[] additionalMenuItems = new MenuSubItem[1];		
		additionalMenuItems[0] = new MenuSubItem(Messages.getString("org.isistan.flabot.executionmapping.dialogs.logicalexpressionbuilder.SingleExpressionGUI.editCondition"),  //$NON-NLS-1$
				new SelectionAdapter() 
				{
					@Override
					public void widgetSelected(SelectionEvent e) 
					{
						BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
							public void run() {
								if (executionCondition != null)
								{						
									Command command = ExecutionConditionEditorBuilder.showEditExecutionConditionDialog(executionCondition, executionStateMappingFileModel);
									if (command != null)
									{
										command.execute();
									}
								}
							}
						});
					}
				});	
		
		CommonExecutionConditionMenuButtonOptions buttonMenu = new CommonExecutionConditionMenuButtonOptions(buttonInsert, executionStateMappingFileModel);
		buttonMenu.appendAdditionalOptions(additionalMenuItems);		
		buttonMenu.appendPoolSelectionOption(this, selectExecutionConditionFilters);
		buttonMenu.appendNewMethodExecutionConditoionOption(this, newExecutionConditionFilters);
		buttonMenu.appendNewGeneralExecutionConditoionOption(this);			
		
		selectionableElement=labelCondicion;
	}
	
	public ExecutionCondition getSelectedElement()
	{
		return executionCondition;
	}
	
	@Override
	public void reDrawGUIExpression(Composite externalComposite)
	{
		this.externalComposite=externalComposite;
		createCompleteGUIExpression(externalComposite);
		showAttributesText();
		showExecutionCondition();
	}
	
	@Override
	protected void changeChildsConnector()
	{
		//Do nothing
	}
	
	@Override
	public LogicalExpressionGUI addChild() 
	{
		buttonAttributes.setVisible(false);
		buttonAttributes.removeSelectionListener(buttonAttributeListener);
		compositeAttributes.removeMouseListener(mouseListener);
		labelAttributes.removeMouseListener(mouseListener);
		labelCondicion.dispose();
		buttonInsert.dispose();
		BlockExpressionGUI blockExpressionGUI=new BlockExpressionGUI(parentExpression,expressionComposite,compositeAttributes,selectExecutionConditionFilters,newExecutionConditionFilters);
		blockExpressionGUI.setObserver(guiObserver);  
		blockExpressionGUI.setNegated(isNegated);
		isNegated=false;
		
		blockExpressionGUI.getLogicalExpressionGUIList().add(this);
		createCompleteGUIExpression(blockExpressionGUI.expressionComposite);
		setSelected(isSelected);
		setLogicalConnector(null);//No tiene conector logico por ser el primero del blockComposite
		showExecutionCondition();
		
		blockExpressionGUI.addChild();
		blockExpressionGUI.setLogicalConnector(getLogicalConnector());
		blockExpressionGUI.setChildsConnector();
		
		boolean rootExpression=(parentExpression==null);
		if (!rootExpression)
			((BlockExpressionGUI)parentExpression).updateChild(this,blockExpressionGUI);
		this.parentExpression=blockExpressionGUI;
		if(blockExpressionGUI.parentExpression!=null)
			((BlockExpressionGUI)blockExpressionGUI.parentExpression).setChildsConnector();
		return rootExpression?blockExpressionGUI:null;
	}
	
	public void addElement(ExecutionCondition executionCondition)
	{
		this.executionCondition=executionCondition;
		showExecutionCondition();
	}
		
	protected void showExecutionCondition()
	{
		if (executionCondition!=null)
		{
			labelCondicion.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.logicalexpressionbuilder.SingleExpressionGUI.filter")+ labelProvider.getText(executionCondition)); //$NON-NLS-1$
		}
	}
	
	@Override
	public AbstractExpression getExecutionConditionExpression()
	{
		SingleExpression singleEvent=SemanticFactory.eINSTANCE.createSingleExpression();
		singleEvent.setIsNot(isNegated);
		singleEvent.setExecutionCondition(executionCondition);
		return singleEvent;
	}
	
	@Override
	public String toString()
	{
		return	(isNegated?"NOT ":"")+((executionCondition==null)?"NULL":executionCondition.getName()); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	@Override
	public void dispose()
	{
		compositeAttributes.dispose();
		expressionComposite.dispose();
	}
	
	@Override
	public LogicalExpressionGUI delete()
	{
		if(parentExpression!=null)
		{
			return ((BlockExpressionGUI)parentExpression).deleteChild(this);
		}
		return null;
	}	
	
    @Override
	public boolean permitLogicalConnector()
    {
    	return false;
    }
   
    @SuppressWarnings("restriction") //$NON-NLS-1$
	private FlabotMultiPageEditor getEditor()
	{
		return (FlabotMultiPageEditor) Workbench.getInstance().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
	}
}