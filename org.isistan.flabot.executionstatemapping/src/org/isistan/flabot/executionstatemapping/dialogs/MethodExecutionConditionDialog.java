package org.isistan.flabot.executionstatemapping.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;
import org.isistan.flabot.executionstatemapping.dialogs.common.ActivatedElement;
import org.isistan.flabot.executionstatemapping.dialogs.common.ListElementEventProvider;
import org.isistan.flabot.executionstatemapping.dialogs.common.ListElementsComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.ExceptionFilterComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.ITypeFieldsComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.ITypeParametersReturnValueComposite;
import org.isistan.flabot.executionstatemapping.dialogs.utils.DialogUtils;
import org.isistan.flabot.executionstatemapping.dialogs.utils.filter.UpdatableFilteredView;
import org.isistan.flabot.executionstatemapping.dialogs.utils.filter.ViewFilterProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.filter.ViewFilterProviderAdapter;
import org.isistan.flabot.executionstatemapping.dialogs.utils.labelproviders.DecoratedWorkbenchLabelProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.labelproviders.InternalMethodCallsLabelProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.viewerfilters.MethodClassViewerFilter;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologCodeFactory;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologFactory;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticFactory;
import org.isistan.flabot.executionstatemapping.model.semantic.impl.ExecutionConditionImpl;
import org.isistan.flabot.executionstatemapping.utils.ExecutionConditionUtils;
import org.isistan.flabot.executionstatemapping.utils.jdt.InternalMethodCallsSearcher;
import org.isistan.flabot.javamodel.CompositeMirrorBuilder;
import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.JObject;
import org.isistan.flabot.javamodel.ObjectMirrorBuilder;
import org.isistan.flabot.javamodel.jdt.BehaviorBuilder;
import org.isistan.flabot.javamodel.jdt.ConstructorBuilder;
import org.isistan.flabot.javamodel.jdt.MethodBuilder;
import org.isistan.flabot.mapping.builder.PatternMappingBuilder;
import org.isistan.flabot.mapping.mappingmodel.PatternMapping;

public class MethodExecutionConditionDialog extends AbstractExecutionConditionDialog {
	
	private TabFolder tabsComposite;
	
	protected ExecutionCondition actualExecutionCondition;
	
	protected ExecutionCondition returnedExecutionCondition;
	
	private IMethod methodData;
	
	private Composite compositeMethod;
	
	private Label label;

	private Label labelMethodFigure;

	private Label labelMethodSignature;

	private Label labelClassFigure;
	
	private Label labelClassSignature;	
	
	private ITypeParametersReturnValueComposite parametersComposite;
	
	private ITypeFieldsComposite fieldsComposite;
	
	private InternalMethodCallsProvider internalMethodCallsProvider;
	
	private ExceptionFilterComposite exceptionFilterComposite;
	
	private ListElementsComposite<ExecutionCondition> internalMethodCallsComposite;	
	
	private boolean showInternalMethodCalls = true;
	
	private String content;
	
	private ViewFilterProvider[] viewFilters;
	
	public MethodExecutionConditionDialog(IMethod methodData, String content)
	{
		this(methodData, content, true);	
	}
	
	private MethodExecutionConditionDialog(IMethod methodData, String content, boolean showInternalMethodCalls) {
		this.methodData = methodData;
		this.showInternalMethodCalls = showInternalMethodCalls;
		this.content=content;
		super.createSShell();
		sShell.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.MethodExecutionConditionDialog.editor", content)); //$NON-NLS-1$
	}
	
	public void setMethodSelectionFilters(ViewFilterProvider[] viewFilters)
	{
		this.viewFilters = viewFilters;	
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
		if(methodData == null)
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.MethodExecutionConditionDialog.mustSelectMethod")); //$NON-NLS-1$
			errors.add(""); //$NON-NLS-1$
			return errors;
		}
		if(textName.getText().length()==0)
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.MethodExecutionConditionDialog.noName", content)); //$NON-NLS-1$
			errors.add(""); //$NON-NLS-1$
		}
		int selectedItems=parametersComposite.getItemCount()+fieldsComposite.getItemCount();
		if (showInternalMethodCalls)
		{
			selectedItems += internalMethodCallsComposite.getElements().size();
			selectedItems += exceptionFilterComposite.getItemCount();
		}
		if(selectedItems==0)
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.MethodExecutionConditionDialog.isEmpty", content)); //$NON-NLS-1$
			errors.add(""); //$NON-NLS-1$
		}
		List<String>aux=parametersComposite.getErrors();
		if(aux.size()>0)
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.MethodExecutionConditionDialog.parametersErrors")); //$NON-NLS-1$
			errors.add(""); //$NON-NLS-1$
			errors.addAll(aux);
			errors.add(""); //$NON-NLS-1$
		}
		aux=fieldsComposite.getErrors();
		if(aux.size()>0)
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.MethodExecutionConditionDialog.fieldsErrors")); //$NON-NLS-1$
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
	

	public ExecutionCondition showDialog(ExecutionCondition executionCondition)
	{
		return showDialog(executionCondition, 0);
	}
    
	private ExecutionCondition showDialog(ExecutionCondition executionCondition, int diference) 
	{
		try
		{	
			this.actualExecutionCondition = executionCondition;
			if (actualExecutionCondition==null)
			{
				actualExecutionCondition = SemanticFactory.eINSTANCE.createExecutionCondition();
			}			
			
			textName.setText(actualExecutionCondition.getName());
			if (methodData != null)
			{			
				updateIMethod(methodData, actualExecutionCondition);
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
			while (!sShell.isDisposed()) 
			{
				if (!display.readAndDispatch())
				{
					display.sleep();
				}
			}
		} 
		catch (Exception e) 
		{
			ExecutionConditionPlugin.getDefault().getLogger().error(
					e.getMessage() + e.getStackTrace());
		}
		return returnedExecutionCondition;
	}
	
	private void updateIMethod(IMethod methodData, ExecutionCondition executionCondition)
	{
		this.methodData = methodData;
		
		if (showInternalMethodCalls)
		{
			internalMethodCallsProvider.resetElements();
			internalMethodCallsComposite.resetElements();
			exceptionFilterComposite.resetComposite();
		}
		tabsComposite.setSelection(0);
		
		//Method data
		labelMethodFigure.setImage(DecoratedWorkbenchLabelProvider
				.getDecoratedWorkbenchLabelProvider().getImage(methodData));

		labelMethodSignature.setText(DecoratedWorkbenchLabelProvider				
				.getDecoratedWorkbenchLabelProvider().getText(methodData));		

		//Package/Class data
	    labelClassSignature.setText( methodData.getDeclaringType().getFullyQualifiedName('$'));
	    
	    labelClassFigure.setImage(DecoratedWorkbenchLabelProvider
				.getDecoratedWorkbenchLabelProvider().getImage(methodData.getDeclaringType()));
	    
	    labelMethodSignature.getParent().layout();	    
	    
	    //Fill Parameters and return value
	    parametersComposite.setIMethod(methodData);
	    try 
	    {
			parametersComposite.fillTable(executionCondition);
		} 
	    catch (JavaModelException e) 
		{
			e.printStackTrace();
		}
	    
	    //Fill Fields
		fieldsComposite.setContainerClass((IType)methodData.getParent());	    
	    fieldsComposite.fillTable(executionCondition.getFields());
		
	    //Fill Internal Method Calls
	    if (showInternalMethodCalls)
		{				
			internalMethodCallsComposite.setElements(executionCondition.getInternalMethodCalls());
	    	exceptionFilterComposite.fillComposite(executionCondition);
	    }
	}
	
	public IMethod getIMethod()
	{
		return methodData;
	}	
	
	@Override
	protected void createAditionalComposites()
	{		
		GridLayout gridLayout41 = new GridLayout();
		gridLayout41.numColumns = 4;
		gridLayout41.horizontalSpacing = 5;
		compositeMethod = new Composite(sShell, SWT.NONE);
		compositeMethod.setLayout(gridLayout41);
		GridData gridData15 = new GridData();
		gridData15.horizontalAlignment = GridData.FILL;
		gridData15.grabExcessVerticalSpace = false;
		gridData15.widthHint = 150;
		gridData15.grabExcessHorizontalSpace = true;
		compositeMethod.setLayoutData(gridData15);
					
		createMethodNameComposite();
		createClassNameComposite();				
	}
	
	public void createClassNameComposite()
	{
		//Class Name Composite		
		GridData gridData71 = new GridData();
		gridData71.horizontalAlignment = GridData.END;
		gridData71.widthHint = 20;
		gridData71.grabExcessHorizontalSpace = false;
		GridData gridData131 = new GridData();
		gridData131.widthHint = 45;
		label = new Label(compositeMethod, SWT.NONE);
		label.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.MethodExecutionConditionDialog.class")); //$NON-NLS-1$
		label.setLayoutData(gridData131);
		labelClassFigure = new Label(compositeMethod, SWT.NONE);
		labelClassFigure.setText(""); //$NON-NLS-1$
		labelClassFigure.setLayoutData(gridData71);		
		labelClassSignature = new Label(compositeMethod, SWT.NONE);
		labelClassSignature.setText(""); //$NON-NLS-1$
		GridData gridData91 = new GridData();
		gridData91.horizontalSpan = 2;
		labelClassSignature.setLayoutData(gridData91);
		
	}
	
	public void createMethodNameComposite()
	{
		//Method Name Composite
		GridData gridData71 = new GridData();
		gridData71.horizontalAlignment = GridData.END;
		gridData71.widthHint = 20;
		gridData71.grabExcessHorizontalSpace = false;
		label = new Label(compositeMethod, SWT.NONE);
		label.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.MethodExecutionConditionDialog.method")); //$NON-NLS-1$
		label.setLayoutData(new GridData());
		labelMethodFigure = new Label(compositeMethod, SWT.NONE);
		labelMethodFigure.setText(""); //$NON-NLS-1$
		labelMethodFigure.setLayoutData(gridData71);
		labelMethodSignature = new Label(compositeMethod, SWT.NONE);
		labelMethodSignature.setText(""); //$NON-NLS-1$
		GridData labelGridData = new GridData();
		if (!showInternalMethodCalls)
		{
			labelGridData.horizontalSpan = 2;
		}
		labelMethodSignature.setLayoutData(labelGridData);
		
		if (showInternalMethodCalls)
		{
			Button button = new Button(compositeMethod, SWT.NONE);
			button.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.MethodExecutionConditionDialog.chooseButton")); //$NON-NLS-1$
			button.addSelectionListener(new SelectionAdapter()
			{
				@Override
				public void widgetSelected(SelectionEvent e) 
				{
					if (viewFilters == null)
					{
						viewFilters = new ViewFilterProvider[1];
						viewFilters[0] = new ViewFilterProviderAdapter()
						{
							@Override
							public void filterChanged(
									UpdatableFilteredView updatableView) 
							{
								updatableView.updateFilter(new MethodClassViewerFilter());							
							}
	
							@Override
							public String getTextName() {
								return ""; //$NON-NLS-1$
							}						
						};
					}
					
					IMethod newIMethod = ExecutionConditionUtils.getSelectedMethod(ExecutionConditionUtils.getJavaModelForWorkspace(), viewFilters);
					if (newIMethod != null)
					{
						if (actualExecutionCondition == null)
						{
							actualExecutionCondition = SemanticFactory.eINSTANCE.createExecutionCondition();
						}
						updateIMethod(newIMethod, actualExecutionCondition);
					}
				}			
			});
			
			GridData gridData132 = new GridData();
			gridData132.horizontalAlignment = SWT.BEGINNING;
			gridData132.widthHint = 25;
			gridData132.heightHint = 25;
			button.setLayoutData(gridData132);
		}
	}

	/**
	 * This method initializes tabFolder
	 * 
	 */
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
		tabItem0.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.MethodExecutionConditionDialog.parametersAndReturnValue")); //$NON-NLS-1$
		tabItem0.setControl(createCompositeProperties());
		tabItem0.setData(parametersComposite);
		
		TabItem tabItem1 = new TabItem(tabsComposite, SWT.NONE);		
		tabItem1.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.MethodExecutionConditionDialog.fields")); //$NON-NLS-1$
		tabItem1.setControl(createCompositeFields());
		tabItem1.setData(fieldsComposite);
	    
		if (showInternalMethodCalls)
		{
			TabItem tabItem2 = new TabItem(tabsComposite, SWT.NONE);
			tabItem2.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.MethodExecutionConditionDialog.exception")); //$NON-NLS-1$
		    tabItem2.setControl(createExceptionComposite());
		    tabItem2.setData(exceptionFilterComposite);
		    
			TabItem tabItem3 = new TabItem(tabsComposite, SWT.NONE);
			tabItem3.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.MethodExecutionConditionDialog.internalMethodCalls")); //$NON-NLS-1$
			tabItem3.setControl(createCompositeInternalMethodCalls());
			tabItem3.setData(internalMethodCallsComposite);
		}
		
		tabsComposite.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				TabItem[] tabItems = tabsComposite.getSelection();
				if (tabItems.length == 1)
				{
					((ActivatedElement)tabItems[0].getData()).activate();
				}
			}
		});		
	}
	
	/**
	 * This method initializes composite2
	 * 
	 */
	private Composite createCompositeProperties() {
		Composite compositeProperties = new Composite(tabsComposite, SWT.BORDER);
		compositeProperties.setLayout(new GridLayout());		
		GridData gridData6 = new GridData();
		gridData6.grabExcessHorizontalSpace = true;
		gridData6.verticalAlignment = GridData.FILL;
		gridData6.horizontalAlignment = GridData.FILL;
		gridData6.grabExcessVerticalSpace = true;
		parametersComposite = new ITypeParametersReturnValueComposite(compositeProperties, SWT.NONE);
		parametersComposite.setLayout(new GridLayout());
		parametersComposite.setLayoutData(gridData6);
		return compositeProperties;
	}
	
	/**
	 * This method initializes composite21	
	 *
	 */
	private Composite createCompositeFields() {
		Composite compositeFields = new Composite(tabsComposite, SWT.BORDER);
		compositeFields.setLayout(new GridLayout());		
		GridData gridData61 = new GridData();
		gridData61.horizontalAlignment = GridData.FILL;
		gridData61.grabExcessHorizontalSpace = true;
		gridData61.grabExcessVerticalSpace = true;
		gridData61.verticalAlignment = GridData.FILL;
		fieldsComposite = new ITypeFieldsComposite(compositeFields, SWT.NONE);		
		fieldsComposite.setLayoutData(gridData61);
		fieldsComposite.setLayout(new GridLayout());		
		return compositeFields;
	}
		
	private Composite createCompositeInternalMethodCalls() {
		Composite compositeInternalMethodCalls = new Composite(tabsComposite, SWT.BORDER);
		compositeInternalMethodCalls.setLayout(new GridLayout());		
		internalMethodCallsProvider = new InternalMethodCallsProvider();		
		internalMethodCallsComposite = new ListElementsComposite<ExecutionCondition>(compositeInternalMethodCalls, SWT.None, new InternalMethodCallsLabelProvider(), internalMethodCallsProvider);		
		return compositeInternalMethodCalls;
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
		newExecutionCondition.setPatternMapping(getPatternMapping());		
		newExecutionCondition.setInstanceOfClass(null);
		parametersComposite.fillExecutionCondition(newExecutionCondition);
		newExecutionCondition.getFields().addAll(fieldsComposite.getFieldsEvaluationConditions());
		if(showInternalMethodCalls)
		{
			newExecutionCondition.getInternalMethodCalls().addAll(internalMethodCallsComposite.getElements());
			newExecutionCondition.setException(exceptionFilterComposite.getNewExceptionEvaluationCondition());
		}
		return newExecutionCondition;
	}

	@SuppressWarnings("unchecked") //$NON-NLS-1$
	private PatternMapping getPatternMapping()
	{
		CompositeMirrorBuilder<JBehavior> behaviorBuilder=new CompositeMirrorBuilder<JBehavior>(
				new ObjectMirrorBuilder[] {
						new MethodBuilder(),
						new ConstructorBuilder()
				}, new BehaviorBuilder()
			);
		return (PatternMapping) PatternMappingBuilder.getInstance().buildMapping(new JObject[] {behaviorBuilder.build(methodData)});
	}
	
	private class InternalMethodCallsProvider implements ListElementEventProvider<ExecutionCondition>
	{
		private IMethod[] internalMethodCallsList;
		
		final ILabelProvider labelProvider = new JavaElementLabelProvider();
		
		private void fillInternalMethodCallsList()
		{
			if (internalMethodCallsList == null && methodData != null)
			{
				InternalMethodCallsSearcher searcher = new InternalMethodCallsSearcher();
				searcher.search(methodData);
				internalMethodCallsList = searcher.getResult();
			}
		}
		
		public void resetElements()
		{
			internalMethodCallsList = null;
		}
		
		private ExecutionCondition editInternalMethodCallsMethod(IMethod imethod, ExecutionCondition executionCondition)
		{				
			MethodExecutionConditionDialog internalMethodCallsDialog = new MethodExecutionConditionDialog(imethod, Messages.getString("org.isistan.flabot.executionmapping.dialogs.MethodExecutionConditionDialog.internalMethodCall"), false); //$NON-NLS-1$
			return internalMethodCallsDialog.showDialog(executionCondition, 25);
		}
		
		private IMethod getCorrectIMethodFor(ExecutionCondition executionCondition)
		{
			return ExecutionConditionUtils.getIMethod(executionCondition);
		}
		
		public ExecutionCondition onAddElement() {
			fillInternalMethodCallsList();
			
			IMethod selectedIMethod = DialogUtils
					.getSelectedListElement(Messages.getString("org.isistan.flabot.executionmapping.dialogs.MethodExecutionConditionDialog.internalMethodCallSelection"), //$NON-NLS-1$
							Messages.getString("org.isistan.flabot.executionmapping.dialogs.MethodExecutionConditionDialog.selectMethod"), //$NON-NLS-1$
							labelProvider, internalMethodCallsList);
			
			if (selectedIMethod != null)
			{
				return editInternalMethodCallsMethod(selectedIMethod, null);
			}				
			return null;
		}

		public ExecutionCondition onEditElement(
				ExecutionCondition element) {
			fillInternalMethodCallsList();
			
			IMethod imethod = getCorrectIMethodFor(element);
			if (imethod != null)
			{
				return editInternalMethodCallsMethod(imethod, element);
			}
			else
			{
				String methodName = ""; //$NON-NLS-1$
				if (element.getPatternMapping() != null)
				{
					methodName = element.getPatternMapping().getBehaviorPattern();
					if (methodName != null)
					{
						methodName = ExecutionConditionUtils.getEscapedNameFromPattern(methodName);
					}
				}
				MessageDialog.openError(Display.getCurrent().getActiveShell(), Messages.getString("org.isistan.flabot.executionmapping.dialogs.MethodExecutionConditionDialog.errorMethodMapped"), Messages.getString("org.isistan.flabot.executionmapping.dialogs.MethodExecutionConditionDialog.mappingLost", methodName)); //$NON-NLS-1$ //$NON-NLS-2$
			}
			return null;
		}

		public void onRemoveElement(ExecutionCondition element) {}
		
	}
}