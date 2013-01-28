package org.isistan.flabot.executionstatemapping.dialogs.strategy;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.internal.Workbench;
import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;
import org.isistan.flabot.engine.executionstate.TraceInferenceStrategy;
import org.isistan.flabot.executionstatemapping.InterfacePluginExecutionStateMapping;
import org.isistan.flabot.executionstatemapping.dialogs.ScrollableItemDialog;
import org.isistan.flabot.executionstatemapping.dialogs.ShowPrologDialog;
import org.isistan.flabot.executionstatemapping.dialogs.utils.DialogUtils;
import org.isistan.flabot.executionstatemapping.dialogs.utils.contentproviders.TreeExecutionConditionContentProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.errors.ItemErrorProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.filter.ViewFilterProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.labelproviders.TreeExecutionConditionLabelProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.validators.StateDiagramSelectionValidator;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologFactory;
import org.isistan.flabot.executionstatemapping.model.prolog.TagProvider;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration;
import org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.StateContainer;
import org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.impl.ExecutionConditionImpl;
import org.isistan.flabot.executionstatemapping.model.strategymodel.SimpleExecutionConditionTraceInferenceStrategy;
import org.isistan.flabot.executionstatemapping.model.strategymodel.StateDiagramTraceInferenceStrategy;
import org.isistan.flabot.executionstatemapping.model.strategymodel.StrategymodelFactory;
import org.isistan.flabot.util.edition.EditionItemStatus;
import org.isistan.flabot.util.edition.SingleEditionItemStatus;

public class CompositeTabStrategy {

	private SimpleExecutionConditionTraceInferenceStrategy simpleStrategy;
	
	private Button executionConditionConfig;
				
	private Button stateDiagramConfig;	
		
	private Text stateFileText;
	
	private boolean forceSelection;
	
	private ViewFilterProvider[] selectStateDiagramFilters = null;
	
	private ViewFilterProvider[] selectExecutionConditionFilters = null;

	private ViewFilterProvider[] newExecutionConditionFilters = null;

	private TagProvider tagProvider;
		
	public CompositeTabStrategy(boolean forceSelection, ViewFilterProvider[] selectExecutionConditionFilters, ViewFilterProvider[] newExecutionConditionFilters, ViewFilterProvider[] selectStateDiagramFilters, TagProvider tagProvider)
	{
		this.forceSelection = forceSelection;
		this.selectExecutionConditionFilters = selectExecutionConditionFilters;
		this.newExecutionConditionFilters = newExecutionConditionFilters;
		this.selectStateDiagramFilters = selectStateDiagramFilters;
		this.tagProvider = tagProvider;
	}
	
	public void build(Composite c, TraceInferenceStrategy traceStrategy) 
	{
		c.setLayout(new GridLayout(1, false));			
		createControls(c);
		
		if (traceStrategy != null) 
		{
			if (traceStrategy instanceof StateDiagramTraceInferenceStrategy)
			{
				setStateDiagramStrategy((StateDiagramTraceInferenceStrategy)traceStrategy);
			}
			else if (traceStrategy instanceof SimpleExecutionConditionTraceInferenceStrategy)
			{
				setSimpleExecutionConditionTraceInferenceStrategy((SimpleExecutionConditionTraceInferenceStrategy)traceStrategy);
			}
		}
		else
		{
			stateDiagramConfig.setSelection(true);
		}
		
		checkEnabled();		
		c.pack();
	}
	
	private void createControls(Composite c)
	{		
		Composite composite = new Composite(c, SWT.NONE);
		composite.setLayout(new GridLayout(3, false));
		GridData gridDataControl = new GridData(GridData.FILL_HORIZONTAL);
		gridDataControl.heightHint =310;
		gridDataControl.grabExcessHorizontalSpace =true;
		composite.setLayoutData(gridDataControl);		
		
		//State diagram configuration
		stateDiagramConfig = new Button(composite, SWT.RADIO);
		stateDiagramConfig.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeTabStrategy.stateConfigurationStrategy")); //$NON-NLS-1$
		GridData gd2 = new GridData();
		gd2.horizontalSpan = 3;
		gd2.horizontalIndent = 0;
		stateDiagramConfig.setLayoutData(gd2);		
		final List<Control> stateControlList = createStateDiagramFileSection(composite);
		stateDiagramConfig.setData(stateControlList);
		
		//Execution condition configuration
		executionConditionConfig = new Button(composite, SWT.RADIO);
		executionConditionConfig.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeTabStrategy.simpleStrategy")); //$NON-NLS-1$
		GridData gd1 = new GridData();		
		gd1.horizontalSpan = 3;
		gd1.horizontalIndent = 0;
		executionConditionConfig.setLayoutData(gd1);		
		final List<Control> executionControlList = createExecutionConditionSection(composite);		
		executionConditionConfig.setData(executionControlList);
		
		SelectionListener selectionListener = new SelectionAdapter() 
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				checkEnabled();
			}
		};
		
		executionConditionConfig.addSelectionListener(selectionListener);		
		stateDiagramConfig.addSelectionListener(selectionListener);
		
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = SWT.END;
		gridData1.horizontalSpan = 3;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.verticalIndent = 10;
		
		Button buttonShowPrologCode= new Button(composite, SWT.NONE);
		buttonShowPrologCode.setLayoutData(gridData1);
		buttonShowPrologCode.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeTabStrategy.showProlog")); //$NON-NLS-1$
		buttonShowPrologCode.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				EditionItemStatus status = validateTabStrategy(); 				
				if(status != EditionItemStatus.DEFAULT_OK)
				{
					List<String> errors = new ArrayList<String>();
					errors.add(status.getDescription());					
					ScrollableItemDialog errorDialog=new ScrollableItemDialog(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeTabStrategy.errors"),Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeTabStrategy.checkErrors")); //$NON-NLS-1$ //$NON-NLS-2$
					errorDialog.showDialog(errors,new ItemErrorProvider());
				}
				else
				{						
					ExecutionConditionImpl.predicateExpressionNumber=0;
					
					String prologCode=getPrologCode();
					prologCode = prologCode.replace(":-", ":-\n\t"); //$NON-NLS-1$ //$NON-NLS-2$
					prologCode = prologCode.replace("),", "),\n\t"); //$NON-NLS-1$ //$NON-NLS-2$
					prologCode = prologCode.replace(").", ").\n"); //$NON-NLS-1$ //$NON-NLS-2$
					
					ShowPrologDialog prologCodeDialog=new ShowPrologDialog(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeTabStrategy.prologCode"),Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeTabStrategy.prologCodeVisualization")); //$NON-NLS-1$ //$NON-NLS-2$
					prologCodeDialog.showDialog(prologCode);
				}
			}
		});
	}
	
	private String getPrologCode()
	{
		String prologCode = ""; //$NON-NLS-1$
		if (executionConditionConfig.getSelection())
		{
			SimpleExecutionConditionConfiguration configuration=simpleStrategy.getSimpleExecutionConditionConfiguration();
			if (configuration != null)
			{
				for(ExecutionCondition executionCondition : configuration.getPreFilters())
				{
		    		executionCondition.resetPredicateName();
				}
				for(SimpleExpressionExecutionCondition simpleExpressionExecutionCondition : configuration.getSimpleExpressionExecutionConditions())
				{
					if (simpleExpressionExecutionCondition.getExpression() != null)
					{
						simpleExpressionExecutionCondition.getExpression().resetPredicateName();
					}
				}
				prologCode = PrologFactory.eINSTANCE.createPrologCodeFactory().getPrologCode(configuration, tagProvider);
			}
		}
		else if (stateDiagramConfig.getSelection())
		{
			StateContainer stateContainer=(StateContainer)stateFileText.getData();
			for(ExecutionCondition executionCondition : stateContainer.getPreFilters())
			{
	    		executionCondition.resetPredicateName();
			}
	    	
	    	for(TransitionCondition tc : stateContainer.getTransitionConditions())
	    	{
	    		if (tc.getExecutionCondition() != null)
				{
	    			tc.getExecutionCondition().resetPredicateName();
				}
	    	}
			prologCode = PrologFactory.eINSTANCE.createPrologCodeFactory().getPrologCode(stateContainer, tagProvider);
		}
		return prologCode;
	}
	
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	private void checkEnabled()
	{
		setEnabledControls((List<Control>)executionConditionConfig.getData(), executionConditionConfig.getSelection());
		setEnabledControls((List<Control>)stateDiagramConfig.getData(), stateDiagramConfig.getSelection());			
	}
	
	protected List<Control> createStateDiagramFileSection(Composite groupMain) 
	{
		List<Control> controlList = new ArrayList<Control>();
		
		final Composite group = new Group(groupMain, SWT.None);
		group.setLayout(new GridLayout(3, false));
		GridData gd0 = new GridData(GridData.FILL_HORIZONTAL);
		gd0.horizontalSpan = 3;
		gd0.horizontalIndent = 5;
		group.setLayoutData(gd0);
			
		Label label = new Label(group, SWT.NULL);
		label.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeTabStrategy.stateDiagram")); //$NON-NLS-1$
		
		stateFileText = new Text(group, SWT.BORDER);
		stateFileText.setEnabled(false);
		stateFileText.setEditable(false);
		stateFileText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		final Button button = new Button(group, SWT.NONE);
		button.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeTabStrategy.chooseButton")); //$NON-NLS-1$
		button.addSelectionListener(new SelectionAdapter() 
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				browseStateDiagramSelection();			
			}
		});
		
		controlList.add(label);
		controlList.add(stateFileText);
		controlList.add(button);
		
		return controlList;
	}
	
	protected List<Control> createExecutionConditionSection(Composite groupMain) 
	{		
		//Main Composite layout configuration
		Composite group = new Group(groupMain, SWT.None);	
		group.setLayout(new GridLayout(1, false));
		GridData gd0 = new GridData(GridData.FILL_HORIZONTAL);
		gd0.horizontalSpan = 3;
		gd0.horizontalIndent = 5;
		group.setLayoutData(gd0);		
		
		final Button button = new Button(group, SWT.NULL);
		button.setEnabled(false);
		button.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeTabStrategy.editStrategy")); //$NON-NLS-1$
		button.addSelectionListener(new SelectionAdapter() 
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				browseSimpleExecutionConfiguration();		
			}
		});		
		
		List<Control> mainControlList = new ArrayList<Control>();
		mainControlList.add(button);
		return mainControlList;
	}
		
	private void setEnabledControls(List<Control> controlList, boolean enabled)
	{
		for(Control c : controlList)
		{
			c.setEnabled(enabled);
		}
	}
	
	private void browseSimpleExecutionConfiguration()
	{
		SimpleExecutionConditionConfiguration configuration = null;
		if (simpleStrategy != null)
		{
			configuration = simpleStrategy.getSimpleExecutionConditionConfiguration();
		}
		else
		{
			simpleStrategy = StrategymodelFactory.eINSTANCE.createSimpleExecutionConditionTraceInferenceStrategy();
		}
		
		CompositeStrategy dialog = new CompositeStrategy( InterfacePluginExecutionStateMapping.getFileModel(getEditor()), forceSelection, tagProvider);				
		dialog.setSelectExecutionConditionFilters(selectExecutionConditionFilters);
		dialog.setNewExecutionConditionFilters(newExecutionConditionFilters);				
		
		SimpleExecutionConditionConfiguration simpleConfiguration = dialog.showDialog(configuration);
		if (simpleConfiguration != null)
		{
			simpleStrategy.setSimpleExecutionConditionConfiguration(simpleConfiguration);
		}
	}
	
	@SuppressWarnings("restriction") //$NON-NLS-1$
	private void browseStateDiagramSelection() 
	{
		TreeStructuredElement treeStructuredElement = InterfacePluginExecutionStateMapping.getFileModel(((FlabotMultiPageEditor) Workbench.getInstance().getActiveWorkbenchWindow().getActivePage().getActiveEditor())).getStateContainersTree();
				
		StateContainer selectedStateContainer =(StateContainer) DialogUtils
		.getSelectedTreeElement(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeTabStrategy.stateSelection"), //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeTabStrategy.selectDiagram"), //$NON-NLS-1$
				new TreeExecutionConditionLabelProvider(), new TreeExecutionConditionContentProvider(), treeStructuredElement, new StateDiagramSelectionValidator(), selectStateDiagramFilters, null);
		
		if (selectedStateContainer != null) 
		{ 
			stateFileText.setText(selectedStateContainer.getName());
			stateFileText.setData(selectedStateContainer);				
		}
	}
	
	private void setStateDiagramStrategy(StateDiagramTraceInferenceStrategy strategy)
	{
		stateDiagramConfig.setSelection(true);
		if (strategy.getStateContainer() != null)
		{
			stateFileText.setText(strategy.getStateContainer().getName());
			stateFileText.setData(strategy.getStateContainer());
		}
	}
	
	private void setSimpleExecutionConditionTraceInferenceStrategy(SimpleExecutionConditionTraceInferenceStrategy strategy)
	{
		simpleStrategy = strategy;
		executionConditionConfig.setSelection(true);
	}
	
	private TraceInferenceStrategy createStateDiagramStrategy()
	{
		StateDiagramTraceInferenceStrategy strategy = StrategymodelFactory.eINSTANCE.createStateDiagramTraceInferenceStrategy();		
		strategy.setStateContainer((StateContainer)stateFileText.getData());
		return strategy;
	}
		
	private TraceInferenceStrategy createSimpleStrategy()
	{
		return simpleStrategy;
	}
	
	public TraceInferenceStrategy createStrategy()
	{
		TraceInferenceStrategy traceInferenceStrategy = null;
		if (executionConditionConfig.getSelection())
		{
			traceInferenceStrategy = createSimpleStrategy();
		}
		else if (stateDiagramConfig.getSelection())
		{			
			traceInferenceStrategy = createStateDiagramStrategy();
		}
		return traceInferenceStrategy;
	}

	public EditionItemStatus validateTabStrategy() 
	{	
		if(stateDiagramConfig.getSelection())
		{
			if(stateFileText.getText().length()==0)
			{
				return new SingleEditionItemStatus(EditionItemStatus.Type.ERROR, Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeTabStrategy.noSelectedDiagram")); //$NON-NLS-1$
			}
		}
		else if (executionConditionConfig.getSelection())
		{
			if(simpleStrategy == null)
			{
				 return new SingleEditionItemStatus(EditionItemStatus.Type.ERROR, Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeTabStrategy.simpleConfigurationError"));				 //$NON-NLS-1$
			}
		}
		return EditionItemStatus.DEFAULT_OK;
	}
	
	@SuppressWarnings("restriction") //$NON-NLS-1$
	private FlabotMultiPageEditor getEditor()
	{
		return (FlabotMultiPageEditor) Workbench.getInstance().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
	}
}