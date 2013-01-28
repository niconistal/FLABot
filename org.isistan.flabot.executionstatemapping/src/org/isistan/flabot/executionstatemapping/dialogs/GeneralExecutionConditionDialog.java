package org.isistan.flabot.executionstatemapping.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.IType;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;
import org.isistan.flabot.executionstatemapping.dialogs.common.ListElementEventProvider;
import org.isistan.flabot.executionstatemapping.dialogs.common.ListElementsComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.ExceptionFilterComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.GeneralFieldComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.GeneralParametersReturnValueComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.GeneralScopeFilterComposite;
import org.isistan.flabot.executionstatemapping.dialogs.utils.DialogUtils;
import org.isistan.flabot.executionstatemapping.dialogs.utils.labelproviders.InternalMethodCallsLabelProvider;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologCodeFactory;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologFactory;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticFactory;
import org.isistan.flabot.executionstatemapping.model.semantic.impl.ExecutionConditionImpl;

public class GeneralExecutionConditionDialog extends AbstractExecutionConditionDialog {
	
	protected ExceptionFilterComposite exceptionFilterComposite;
	
	protected GeneralScopeFilterComposite scopeFilterComposite=null;
	
	protected GeneralParametersReturnValueComposite parametersComposite=null;
	
	protected GeneralFieldComposite fieldsComposite=null;
	
	private TabFolder tabsComposite;
	
	private ListElementsComposite<ExecutionCondition> internalMethodCallsComposite;
	
	protected ExecutionCondition returnedExecutionCondition;
	
	private boolean showInternalMethodCalls = true;
	
	private String content; 
	
	private Button buttonInstanceOfClass;
	
	private Text textInstanceOfClass;
	
	private Button buttonChooseClass;
	
	public GeneralExecutionConditionDialog(String content)
	{
		this(content,true);	
	}
	
	private GeneralExecutionConditionDialog(String content, boolean showInternalMethodCalls)
	{
		this.showInternalMethodCalls = showInternalMethodCalls;	
		super.createSShell();
		this.content=content;
		sShell.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.GeneralExecutionConditionDialog.editor", content)); //$NON-NLS-1$
	}
	
	public ExecutionCondition showDialog(ExecutionCondition executionCondition) {
		return showDialog(executionCondition, 0);
	}
	
	private ExecutionCondition showDialog(ExecutionCondition executionCondition, int diference) {
		try {
			if (executionCondition==null)
			{
				executionCondition=SemanticFactory.eINSTANCE.createExecutionCondition();
			}
			textName.setText(executionCondition.getName());
			
			if (executionCondition.getInstanceOfClass() != null)
			{
				buttonInstanceOfClass.setSelection(true);
				textInstanceOfClass.setText(executionCondition.getInstanceOfClass());
				updateInstanceOf();
			}
			parametersComposite.fillTable(executionCondition);
			fieldsComposite.fillTable(executionCondition.getFields());
			if(showInternalMethodCalls)
			{	
				internalMethodCallsComposite.setElements(executionCondition.getInternalMethodCalls());
				internalMethodCallsComposite.activate();
				scopeFilterComposite.fillComposite(executionCondition);
				exceptionFilterComposite.fillComposite(executionCondition);
			}

			sShell.setMinimumSize(new Point(200, 400));
			sShell.pack();

			// Centra la pantalla
			Display display = sShell.getDisplay();
			Rectangle r = display.getClientArea();
			int centerX = r.width / 2 - sShell.getSize().x / 2 + diference;
			int centerY = r.height / 2 - sShell.getSize().y / 2 - diference;
			sShell.setLocation(centerX, centerY);
			sShell.open();
			while (!sShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}

		} catch (Exception e) {
			ExecutionConditionPlugin.getDefault().getLogger().error(
					e.getMessage() + e.getStackTrace());
		}
		return returnedExecutionCondition;
	}
	
	@Override
	protected  void createAditionalComposites()
	{
		GridLayout gridLayout41 = new GridLayout();
		gridLayout41.numColumns = 3;
		gridLayout41.horizontalSpacing = 5;
		Composite compositeInstance = new Composite(sShell, SWT.NONE);
		compositeInstance.setLayout(gridLayout41);
		GridData gridData15 = new GridData();		
		//gridData15.horizontalAlignment = GridData.FILL;
		//gridData15.grabExcessVerticalSpace = false;
		//gridData15.widthHint = 150;
		//gridData15.grabExcessHorizontalSpace = true;
		compositeInstance.setLayoutData(gridData15);
		
		buttonInstanceOfClass = new Button(compositeInstance, SWT.CHECK);
		buttonInstanceOfClass.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.GeneralExecutionConditionDialog.checkInstanceOf")); //$NON-NLS-1$
		
		textInstanceOfClass = new Text(compositeInstance, SWT.BORDER);
		GridData gridData16 = new GridData();		
		gridData16.widthHint = 250;
		//gridData15.grabExcessVerticalSpace = false;
		//gridData15.widthHint = 150;
		//gridData15.grabExcessHorizontalSpace = true;
		textInstanceOfClass.setLayoutData(gridData16);
		textInstanceOfClass.setEnabled(false);
		
		buttonChooseClass=new Button(compositeInstance,SWT.CENTER);
		buttonChooseClass.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.GeneralExecutionConditionDialog.chooseButton")); //$NON-NLS-1$
		buttonChooseClass.setEnabled(false);
		
		buttonInstanceOfClass.addSelectionListener(new SelectionAdapter() 
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				updateInstanceOf();
			}
		});
		
		buttonChooseClass.addSelectionListener(new SelectionAdapter() 
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				IType selectedIType=DialogUtils.showSelectClassFromWorkspaceDialog();			
				if (selectedIType != null)
				{
					textInstanceOfClass.setText(selectedIType.getFullyQualifiedName());
				}
			}
		});
	}
	
	private void updateInstanceOf()
	{
		textInstanceOfClass.setEnabled(buttonInstanceOfClass.getSelection());
		buttonChooseClass.setEnabled(buttonInstanceOfClass.getSelection());
	}	
	
	@Override
	protected void processOkEvent()
	{
		returnedExecutionCondition = getNewExecutionCondition();
	}
	
	@Override
	protected String getPrologCode()
	{
		ExecutionCondition executionCondition=getNewExecutionCondition();
		
		ExecutionConditionImpl.predicateExpressionNumber=0;
		executionCondition.resetPredicateName();
		PrologCodeFactory factoryProlog=PrologFactory.eINSTANCE.createPrologCodeFactory();
		return factoryProlog.getPrologCode(executionCondition);
		
	}
	
	
	public List<String> getErrors()
	{
		List<String> errors=new ArrayList<String>();
		if(textName.getText().length()==0)
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.GeneralExecutionConditionDialog.noName", content)); //$NON-NLS-1$
			errors.add(""); //$NON-NLS-1$
		}
		int itemsCount=parametersComposite.getItemCount() + fieldsComposite.getItemCount();
		if(showInternalMethodCalls)
		{
			itemsCount += internalMethodCallsComposite.getElements().size();
			itemsCount += exceptionFilterComposite.getItemCount();
			itemsCount += scopeFilterComposite.getItemCount();
		}		
		if(itemsCount==0 && (!buttonInstanceOfClass.getSelection()))
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.GeneralExecutionConditionDialog.isEmpty", content)); //$NON-NLS-1$
			errors.add(""); //$NON-NLS-1$
		}
		if (buttonInstanceOfClass.getSelection() && textInstanceOfClass.getText().trim().length() == 0)
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.GeneralExecutionConditionDialog.mustEnterClass")); //$NON-NLS-1$
			errors.add(""); //$NON-NLS-1$
		}
		List<String>aux=parametersComposite.getErrors();
		if(aux.size()>0)
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.GeneralExecutionConditionDialog.parametersErrors")); //$NON-NLS-1$
			errors.add(""); //$NON-NLS-1$
			errors.addAll(aux);
			errors.add(""); //$NON-NLS-1$
		}
		aux=fieldsComposite.getErrors();
		if(aux.size()>0)
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.GeneralExecutionConditionDialog.fieldsErrors")); //$NON-NLS-1$
			errors.add(""); //$NON-NLS-1$
			errors.addAll(aux);
			errors.add(""); //$NON-NLS-1$
		}
		if (showInternalMethodCalls)
		{
			errors.addAll(exceptionFilterComposite.getErrors());
		}
		return errors;
	}

	
	@Override
	protected void processCancelEvent()
	{
		returnedExecutionCondition = null;
	}
	
	@Override
	protected void createCompositeContent() {
		GridData gridData2 = new GridData();
		gridData2.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData2.grabExcessVerticalSpace = true;
		gridData2.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData2.grabExcessHorizontalSpace = true;
		
		tabsComposite= new TabFolder(mainComposite, SWT.NONE);
		tabsComposite.setLayoutData(gridData2);
		
		TabItem tabItem0 = new TabItem(tabsComposite, SWT.NONE);
		tabItem0.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.GeneralExecutionConditionDialog.parametAndReturnValue")); //$NON-NLS-1$
		tabItem0.setControl( createParametersComposite());
		
		TabItem tabItem1 = new TabItem(tabsComposite, SWT.NONE);		
		tabItem1.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.GeneralExecutionConditionDialog.fields")); //$NON-NLS-1$
		tabItem1.setControl(createFieldsComposite());
		
		if(showInternalMethodCalls)
		{			
			TabItem tabItem2 = new TabItem(tabsComposite, SWT.NONE);
			tabItem2.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.GeneralExecutionConditionDialog.exception")); //$NON-NLS-1$
		    tabItem2.setControl(createExceptionComposite());
		    
			TabItem tabItem4 = new TabItem(tabsComposite, SWT.NONE);
			tabItem4.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.GeneralExecutionConditionDialog.internalMethodCalls")); //$NON-NLS-1$
			tabItem4.setControl( createInternalMethodCallsComposite());
			tabItem4.addListener(SWT.SELECTED, new Listener()
			{
				public void handleEvent(Event event) {				
					internalMethodCallsComposite.activate();
				}								
			});
			
			TabItem tabItem3 = new TabItem(tabsComposite, SWT.NONE);
			tabItem3.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.GeneralExecutionConditionDialog.scope")); //$NON-NLS-1$
		    tabItem3.setControl(createScopeComposite());		 
		}
		
		sShell.pack();
	}
	
	/**
	 * This method initializes composite4
	 * 
	 */
	private Composite createParametersComposite() {		
		Composite compositeProperties = new Composite(tabsComposite, SWT.BORDER);
		compositeProperties.setLayout(new GridLayout());
		
		GridData gridData6 = new GridData();
		gridData6.grabExcessHorizontalSpace = true;
		gridData6.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData6.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData6.grabExcessVerticalSpace = true;
		
		parametersComposite = new GeneralParametersReturnValueComposite(compositeProperties, SWT.NONE);
		parametersComposite.setLayout(new GridLayout());
		parametersComposite.setLayoutData(gridData6);
		return compositeProperties;
	}

	/**
	 * This method initializes composite
	 *
	 */
	private Composite createFieldsComposite() {
		Composite compositeFields = new Composite(tabsComposite, SWT.BORDER);
		compositeFields.setLayout(new GridLayout());
		
		GridData gridData6 = new GridData();
		gridData6.grabExcessHorizontalSpace = true;
		gridData6.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData6.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData6.grabExcessVerticalSpace = true;
		
		fieldsComposite = new GeneralFieldComposite(compositeFields, SWT.NONE);
		fieldsComposite.setLayout(new GridLayout());
		fieldsComposite.setLayoutData(gridData6);
		return compositeFields;
	}

	
	private Composite createInternalMethodCallsComposite() {
		Composite compositeInternalMethodCalls = new Composite(tabsComposite, SWT.BORDER);
		compositeInternalMethodCalls.setLayout(new GridLayout());
						
		ListElementEventProvider<ExecutionCondition> listElementEventProvider = new ListElementEventProvider<ExecutionCondition>() {
						
			private ExecutionCondition editInternalMethodCallsMethod(ExecutionCondition executionCondition)
			{
				GeneralExecutionConditionDialog internalMethodCallsDialog = new GeneralExecutionConditionDialog(Messages.getString("org.isistan.flabot.executionmapping.dialogs.GeneralExecutionConditionDialog.internalMethodCall"), false); //$NON-NLS-1$
				return internalMethodCallsDialog.showDialog(executionCondition, 25);		
			}
								
			public ExecutionCondition onAddElement() {
				return editInternalMethodCallsMethod(null);
			}

			public ExecutionCondition onEditElement(
					ExecutionCondition element) {
				return editInternalMethodCallsMethod(element);
			}

			public void onRemoveElement(ExecutionCondition element) {}
		};
				
		internalMethodCallsComposite = new ListElementsComposite<ExecutionCondition>(compositeInternalMethodCalls, SWT.None, new InternalMethodCallsLabelProvider(), listElementEventProvider);
		return compositeInternalMethodCalls;
	}
	
	private Composite createScopeComposite()
	{
		scopeFilterComposite=new GeneralScopeFilterComposite(tabsComposite, SWT.NONE);
		return scopeFilterComposite;
	}
	
	private Composite createExceptionComposite()
	{
		exceptionFilterComposite=new ExceptionFilterComposite(tabsComposite, SWT.NONE);
		return exceptionFilterComposite;
	}
	
	protected ExecutionCondition getNewExecutionCondition()
	{
		ExecutionCondition newExecutionCondition=SemanticFactory.eINSTANCE.createExecutionCondition();
		newExecutionCondition.setName(textName.getText());		
		newExecutionCondition.setPatternMapping(null);
		if (buttonInstanceOfClass.getSelection() && textInstanceOfClass.getText().trim().length() > 0)
		{
			newExecutionCondition.setInstanceOfClass(textInstanceOfClass.getText());
		}
		else
		{
			newExecutionCondition.setInstanceOfClass(null);
		}
		parametersComposite.fillExecutionCondition(newExecutionCondition);
		newExecutionCondition.getFields().addAll(fieldsComposite.getFieldsEvaluationConditions());
		if (showInternalMethodCalls)
		{
			List<ExecutionCondition> internalMethodCallsExecutionsConditions = internalMethodCallsComposite.getElements();
			for(ExecutionCondition internalExecutionCondition : internalMethodCallsExecutionsConditions)
			{
				internalExecutionCondition.setPatternMapping(null);
			}
			newExecutionCondition.getInternalMethodCalls().addAll(internalMethodCallsExecutionsConditions);
			newExecutionCondition.setScope(scopeFilterComposite.getNewScopeEvaluationCondition());
			newExecutionCondition.setException(exceptionFilterComposite.getNewExceptionEvaluationCondition());
		}
		return newExecutionCondition;
	}
}