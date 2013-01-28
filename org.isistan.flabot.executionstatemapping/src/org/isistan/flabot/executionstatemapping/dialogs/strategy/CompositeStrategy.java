package org.isistan.flabot.executionstatemapping.dialogs.strategy;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;
import org.isistan.flabot.executionstatemapping.dialogs.LogicalExpressionBuilder;
import org.isistan.flabot.executionstatemapping.dialogs.ScrollableItemDialog;
import org.isistan.flabot.executionstatemapping.dialogs.ShowPrologDialog;
import org.isistan.flabot.executionstatemapping.dialogs.common.ListElementEventProvider;
import org.isistan.flabot.executionstatemapping.dialogs.common.ListElementsComposite;
import org.isistan.flabot.executionstatemapping.dialogs.common.PreFilterManagerComposite;
import org.isistan.flabot.executionstatemapping.dialogs.utils.errors.ItemErrorProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.filter.ViewFilterProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.labelproviders.ExpressionExecutionConditionLabelProvider;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologFactory;
import org.isistan.flabot.executionstatemapping.model.prolog.TagProvider;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticFactory;
import org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration;
import org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.impl.ExecutionConditionImpl;
import org.isistan.flabot.util.edition.EditionItemStatus;
import org.isistan.flabot.util.edition.SingleEditionItemStatus;

public class CompositeStrategy {

	private Shell shell;

	private SimpleExecutionConditionConfiguration simpleExecutionConditionConfiguration;

	private PreFilterManagerComposite preFilterManagerDialog;

	private ListElementsComposite<SimpleExpressionExecutionCondition> expressionsComposite;

	private Button buttonShowPrologCode;
	
	private Button buttonDefault;

	private Button buttonCustom;

	private Button buttonNotVerified;

	private Combo comboNotVerified;

	private Button buttonCheckExceptions;

	private Combo comboExceptions;

	private boolean forceSelection = true;

	private ExecutionStateMappingFileModel executionStateMappingFileModel;
	
	private ViewFilterProvider[] selectExecutionConditionFilters = null;

	private ViewFilterProvider[] newExecutionConditionFilters = null;

	private TagProvider tagProvider;
	
	public CompositeStrategy(ExecutionStateMappingFileModel executionStateMappingFileModel,
			 boolean forceSelection, TagProvider tagProvider) {		
		this.executionStateMappingFileModel = executionStateMappingFileModel;
		this.forceSelection = forceSelection;
		this.tagProvider = tagProvider;
	}
	
	public EditionItemStatus getStatus() {
		if (preFilterManagerDialog != null && expressionsComposite != null
				&& preFilterManagerDialog.getElements().size() == 0
				&& expressionsComposite.getElements().size() == 0) {
			return new SingleEditionItemStatus(EditionItemStatus.Type.ERROR,
					Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeStrategy.listEmptyError")); //$NON-NLS-1$
		}
		return EditionItemStatus.DEFAULT_OK;
	}

	public SimpleExecutionConditionConfiguration showDialog(SimpleExecutionConditionConfiguration inicialConfiguration) {
		try 
		{	
			if (inicialConfiguration == null)
			{
				inicialConfiguration = SemanticFactory.eINSTANCE.createSimpleExecutionConditionConfiguration();
			}
			this.simpleExecutionConditionConfiguration = inicialConfiguration;
			
			createSShell(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeStrategy.editSimpleStrategy")); //$NON-NLS-1$

			shell.setMinimumSize(new Point(200, 400));
			shell.pack();
			
			setSimpleExecutionConditionConfiguration();

			// Centra la pantalla
			Display display = shell.getDisplay();
			Rectangle r = display.getClientArea();
			int centerX = r.width / 2 - shell.getSize().x / 2;
			int centerY = r.height / 2 - shell.getSize().y / 2;
			shell.setLocation(centerX, centerY);
			shell.open();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}

		} catch (Exception e) {
			ExecutionConditionPlugin.getDefault().getLogger().error(
					e.getMessage() + e.getStackTrace());
		}
		return simpleExecutionConditionConfiguration;
	}
	

	/**
	 * This method initializes sShell
	 */
	private void createSShell(String title) {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		gridLayout.makeColumnsEqualWidth = true;
		shell = new Shell(Display.getCurrent(), SWT.CLOSE
				| SWT.APPLICATION_MODAL | SWT.TITLE | SWT.MAX);
		shell.setText(title);
		shell.setImage(ImageDescriptor.createFromFile(
				ExecutionConditionPlugin.class, "icons/eclipse32.png") //$NON-NLS-1$
				.createImage());
		shell.setLayout(gridLayout);
		shell.setSize(new Point(527, 352));
		createMainComposite();
		createCompositeButtons();
	}

	private void createMainComposite() {
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.horizontalSpacing = 50;
		gridLayout1.numColumns = 1;
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.horizontalIndent = -1;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		createControls(shell);
	}

	private void createControls(Composite control) {
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.horizontalSpacing = 50;
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.horizontalIndent = -1;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		Group compositePreFilters = new Group(control, SWT.NONE);
		compositePreFilters.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeStrategy.prefiltersConfiguration")); //$NON-NLS-1$
		compositePreFilters.setLayout(gridLayout1);
		compositePreFilters.setLayoutData(gridData);
		createPreFiltersComposite(compositePreFilters);

		GridData gridData2 = new GridData();
		gridData2.grabExcessHorizontalSpace = true;
		gridData2.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData2.horizontalIndent = -1;
		gridData2.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData2.grabExcessVerticalSpace = true;
		Group compositeFilters = new Group(control, SWT.NONE);
		compositeFilters.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeStrategy.conditionConfiguration")); //$NON-NLS-1$
		compositeFilters.setLayout(gridLayout1);
		compositeFilters.setLayoutData(gridData2);
		createExecutionConditionComposite(compositeFilters);
	}

	public void setSelectExecutionConditionFilters(
			ViewFilterProvider[] selectExecutionConditionFilters) {
		this.selectExecutionConditionFilters = selectExecutionConditionFilters;
	}

	public void setNewExecutionConditionFilters(
			ViewFilterProvider[] newExecutionConditionFilters) {
		this.newExecutionConditionFilters = newExecutionConditionFilters;
	}

	private void createPreFiltersComposite(Composite composite) {
		preFilterManagerDialog = new PreFilterManagerComposite(composite,
				SWT.None, executionStateMappingFileModel, selectExecutionConditionFilters,
				newExecutionConditionFilters);		
	}

	private void createExecutionConditionComposite(Composite composite) {
		buttonDefault = new Button(composite, (forceSelection)? SWT.RADIO:SWT.CHECK);
		buttonDefault.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeStrategy.defaultStrategy")); //$NON-NLS-1$

		buttonCustom = new Button(composite, (forceSelection)? SWT.RADIO:SWT.CHECK);
		buttonCustom.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeStrategy.simpleExpressionStrategy")); //$NON-NLS-1$

		createExpressionComposite(composite);
		createCustomConditionsComposite(composite);		

		final List<Control> customControls = new ArrayList<Control>();
		customControls.add(buttonNotVerified);
		customControls.add(buttonCheckExceptions);
		buttonCustom.setData(customControls);

		buttonCustom.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!forceSelection && buttonDefault.getSelection())
				{
					buttonDefault.setSelection(false);
				}
				checkEnabled();
			}
		});
		buttonDefault.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!forceSelection && buttonCustom.getSelection())
				{
					buttonCustom.setSelection(false);
				}
				checkEnabled();
			}
		});
	}

	private void createExpressionComposite(Composite composite)
	{
		ListElementEventProvider<SimpleExpressionExecutionCondition> listElementEventProvider = new ListElementEventProvider<SimpleExpressionExecutionCondition>() {

			public SimpleExpressionExecutionCondition onAddElement() {
				LogicalExpressionBuilder logicaLBuilder = new LogicalExpressionBuilder(
						Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeStrategy.expressionConfiguration"), null, selectExecutionConditionFilters, newExecutionConditionFilters); //$NON-NLS-1$
				return logicaLBuilder.showDialog();
			}

			public SimpleExpressionExecutionCondition onEditElement(
					SimpleExpressionExecutionCondition element) {
				LogicalExpressionBuilder logicaLBuilder = new LogicalExpressionBuilder(
						Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeStrategy.expressionConfiguration"), element, selectExecutionConditionFilters, newExecutionConditionFilters); //$NON-NLS-1$
				return logicaLBuilder.showDialog();
			}

			public void onRemoveElement(
					SimpleExpressionExecutionCondition element) {
			}
		};

		expressionsComposite = new ListElementsComposite<SimpleExpressionExecutionCondition>(
				composite, SWT.None,
				new ExpressionExecutionConditionLabelProvider(),
				listElementEventProvider);		
		expressionsComposite.setEnabled(false);
	}
	
	private void createCustomConditionsComposite(Composite composite)
	{
		Composite groupVerifications = new Composite(composite, SWT.None);
		GridLayout gl1 = new GridLayout(2, false);
		groupVerifications.setLayout(gl1);
		GridData gd2 = new GridData();
		gd2.horizontalSpan = 2;
		gd2.horizontalIndent = 5;
		groupVerifications.setLayoutData(gd2);

		buttonNotVerified = new Button(groupVerifications, SWT.CHECK);
		buttonNotVerified.setEnabled(false);
		buttonNotVerified
				.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeStrategy.ifNoExpressionVerified")); //$NON-NLS-1$
		comboNotVerified = createStatesComboBox(groupVerifications, 0);
		buttonNotVerified.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				comboNotVerified.setEnabled(buttonNotVerified.getSelection());
			}
		});

		buttonCheckExceptions = new Button(groupVerifications, SWT.CHECK);
		buttonCheckExceptions.setEnabled(false);
		buttonCheckExceptions.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeStrategy.ifExceptionThrown")); //$NON-NLS-1$

		comboExceptions = createStatesComboBox(groupVerifications, 2);
		buttonCheckExceptions.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				comboExceptions
						.setEnabled(buttonCheckExceptions.getSelection());
			}
		});
	}
	
	private Combo createStatesComboBox(Composite composite, int defaultSelection) {
		Combo stateCombo = new Combo(composite, SWT.SINGLE | SWT.READ_ONLY);
		int index = 0;
		for (ExecutionStateValue state : ExecutionStateValue
				.getExecutionValues()) {
			stateCombo.add(state.getInternacionalizedName());
			stateCombo.setData(String.valueOf(index++), state);
		}
		stateCombo.select(defaultSelection);
		stateCombo.setEnabled(false);
		return stateCombo;
	}

	@SuppressWarnings("unchecked") //$NON-NLS-1$
	private void checkEnabled() {
		setEnabledControls((List<Control>) buttonCustom.getData(), buttonCustom
				.getSelection());
		comboExceptions.setEnabled(buttonCustom.getSelection()
				&& buttonCheckExceptions.getSelection());
		comboNotVerified.setEnabled(buttonCustom.getSelection()
				&& buttonNotVerified.getSelection());

		if (!buttonCustom.getSelection() && !buttonDefault.getSelection()
				&& forceSelection) 
		{
			buttonDefault.setSelection(true);
		}
		expressionsComposite.setEnabled(buttonCustom.getSelection());
	}

	private void setEnabledControls(List<Control> controlList, boolean enabled) {
		for (Control c : controlList) {
			c.setEnabled(enabled);
		}
	}

	/**
	 * This method initializes composite1
	 * 
	 */
	private void createCompositeButtons() {
		GridData gridData4 = new GridData();
		gridData4.widthHint = 60;
		GridData gridData3 = new GridData();
		gridData3.widthHint = 60;
		
		GridLayout gridLayout2 = new GridLayout();
		gridLayout2.numColumns = 2;
		gridLayout2.makeColumnsEqualWidth=true;
		gridLayout2.marginHeight=1;
		gridLayout2.marginWidth=2;
		gridLayout2.verticalSpacing=0;
		
		GridData gridData1 = new GridData();
		gridData1.grabExcessHorizontalSpace = true;;
		gridData1.horizontalAlignment=SWT.FILL;
		
		Composite compositeButtons = new Composite(shell, SWT.NONE);
		compositeButtons.setLayoutData(gridData1);
		compositeButtons.setLayout(gridLayout2);

		GridData gridData2 = new GridData();
		gridData2.horizontalAlignment = GridData.BEGINNING;
		gridData2.grabExcessHorizontalSpace = true;
		
		GridLayout gridLayout3 = new GridLayout();
		gridLayout3.marginHeight=0;
		gridLayout3.marginWidth=5;
		gridLayout3.verticalSpacing=0;
		
		Composite compositeButtonProlog=new Composite(compositeButtons,SWT.NONE);
		compositeButtonProlog.setLayoutData(gridData2);
		compositeButtonProlog.setLayout(gridLayout3);
		
		GridData gridData11 = new GridData();
		gridData11.grabExcessHorizontalSpace = true;
		gridData11.horizontalAlignment = org.eclipse.swt.layout.GridData.END;
		
		Composite compositeButtonsOkCancel=new Composite(compositeButtons,SWT.FILL);
		compositeButtonsOkCancel.setLayoutData(gridData11);
		compositeButtonsOkCancel.setLayout(gridLayout2);
		
		buttonShowPrologCode= new Button(compositeButtonProlog, SWT.NONE);
		buttonShowPrologCode.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeStrategy.showProlog")); //$NON-NLS-1$
		buttonShowPrologCode.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				List<String> errors=getErrors();
				if(errors.size()!=0)
				{
					ScrollableItemDialog errorDialog=new ScrollableItemDialog(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeStrategy.errors"),Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeStrategy.checkErrors")); //$NON-NLS-1$ //$NON-NLS-2$
					errorDialog.showDialog(errors,new ItemErrorProvider());
				}
				else
				{		
					ExecutionConditionImpl.predicateExpressionNumber=0;
					
					String prologCode=getPrologCode();
					prologCode = prologCode.replace(":-", ":-\n\t"); //$NON-NLS-1$ //$NON-NLS-2$
					prologCode = prologCode.replace("),", "),\n\t"); //$NON-NLS-1$ //$NON-NLS-2$
					prologCode = prologCode.replace(").", ").\n"); //$NON-NLS-1$ //$NON-NLS-2$
					
					ShowPrologDialog prologCodeDialog=new ShowPrologDialog(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeStrategy.prologCode"),Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeStrategy.prologCodeVisualization")); //$NON-NLS-1$ //$NON-NLS-2$
					prologCodeDialog.showDialog(prologCode);
				}
			}
		});
		
		
		Button buttonOK = new Button(compositeButtonsOkCancel, SWT.NONE);
		buttonOK.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeStrategy.okButton")); //$NON-NLS-1$
		buttonOK.setLayoutData(gridData3);
		buttonOK.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				List<String> errors=getErrors();
				if(errors.size()!=0)
				{
					ScrollableItemDialog errorDialog=new ScrollableItemDialog(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeStrategy.errors"),Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeStrategy.checkErros")); //$NON-NLS-1$ //$NON-NLS-2$
					errorDialog.showDialog(errors,new ItemErrorProvider());
				}else
				{
					simpleExecutionConditionConfiguration = getNewStrategy();
					shell.dispose();
				}
			}
		});

		Button buttonCancel = new Button(compositeButtonsOkCancel, SWT.NONE);
		buttonCancel.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeStrategy.cancelButton")); //$NON-NLS-1$
		buttonCancel.setLayoutData(gridData4);
		buttonCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				simpleExecutionConditionConfiguration = null;
				shell.dispose();
			}
		});
	}

	private String getPrologCode()
	{
		String prologCode = ""; //$NON-NLS-1$
		SimpleExecutionConditionConfiguration strategy = getNewStrategy();
		if (strategy != null)
		{
			strategy.resetProlog();
			prologCode = PrologFactory.eINSTANCE.createPrologCodeFactory().getPrologCode(strategy, tagProvider); 
		}		
		return prologCode;
	}
	
	private void setSimpleExecutionConditionConfiguration()
	{
		preFilterManagerDialog.setElements(simpleExecutionConditionConfiguration.getPreFilters());
		
		buttonDefault.setSelection(simpleExecutionConditionConfiguration.isUseDefaultConfiguration());
		if (!simpleExecutionConditionConfiguration.isUseDefaultConfiguration() && !simpleExecutionConditionConfiguration.isUseCustomConfiguration() && forceSelection)
		{
			buttonDefault.setSelection(true);
		}
		else if (simpleExecutionConditionConfiguration.isUseCustomConfiguration())
		{
			buttonCustom.setSelection(true);
			
			expressionsComposite.setElements(simpleExecutionConditionConfiguration
					.getSimpleExpressionExecutionConditions());
			expressionsComposite.activate();			
			
			if (simpleExecutionConditionConfiguration.getExecutionConditionNotVerifiedState() != ExecutionStateValue.NONE)
			{
				buttonNotVerified.setSelection(true);
				selectCombo(comboNotVerified, simpleExecutionConditionConfiguration.getExecutionConditionNotVerifiedState());
			}
			if (simpleExecutionConditionConfiguration.getExceptionState() != ExecutionStateValue.NONE)
			{
				buttonCheckExceptions.setSelection(true);
				selectCombo(comboExceptions, simpleExecutionConditionConfiguration.getExceptionState());
			}
		}
		checkEnabled();
	}
	
	private void selectCombo(Combo combo, ExecutionStateValue value)
	{
		for(int i=0; i<combo.getItemCount(); i++)
		{
			if ( (ExecutionStateValue)combo.getData(String.valueOf(i)) == value)
			{
				combo.select(i);
				break;
			}
		}
	}	
	
	public SimpleExecutionConditionConfiguration getNewStrategy() {
		SimpleExecutionConditionConfiguration newStrategy = SemanticFactory.eINSTANCE
		.createSimpleExecutionConditionConfiguration();
		
		if (preFilterManagerDialog != null) 
		{ 
			newStrategy.getPreFilters().addAll(preFilterManagerDialog.getElements());
		}
		
		newStrategy.setUseDefaultConfiguration(buttonDefault.getSelection());
		newStrategy.setUseCustomConfiguration(buttonCustom.getSelection());
		if (!buttonCustom.getSelection() && !buttonDefault.getSelection() && forceSelection)
		{
			newStrategy.setUseDefaultConfiguration(true);
		}
		else if (buttonCustom.getSelection())
		{
			if (expressionsComposite != null) {
				newStrategy.getSimpleExpressionExecutionConditions().addAll(expressionsComposite.getElements());
			}
			
			ExecutionStateValue notVerifiedState = ExecutionStateValue.NONE;
			if (buttonNotVerified.getSelection())
			{
				notVerifiedState = (ExecutionStateValue) comboNotVerified.getData(String.valueOf(comboNotVerified.getSelectionIndex()));						
			}			
			newStrategy.setExecutionConditionNotVerifiedState(notVerifiedState);
			
			ExecutionStateValue exceptionState = ExecutionStateValue.NONE;
			if (buttonCheckExceptions.getSelection())
			{
				exceptionState = (ExecutionStateValue)comboExceptions.getData(String.valueOf(comboExceptions.getSelectionIndex()));				
			}
			newStrategy.setExceptionState(exceptionState);
		}
		return newStrategy;
	}
	
	private List<String> getErrors()
	{
		List<String> errors=new ArrayList<String>();
		if(buttonCustom.getSelection() && expressionsComposite.getElements().size() == 0)
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeStrategy.mustAddExpression")); //$NON-NLS-1$
			errors.add(""); //$NON-NLS-1$
		}
		if(preFilterManagerDialog.getElements().size() == 0 &&
			!buttonDefault.getSelection() && !buttonCustom.getSelection())
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.CompositeStrategy.mustSpecifyConfiguration")); //$NON-NLS-1$
			errors.add(""); //$NON-NLS-1$
		}
		return errors;
	}
}