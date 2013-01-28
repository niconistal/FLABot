package org.isistan.flabot.executionstatemapping.dialogs;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.combocontentproviders.ComboExecutionStateProvider;
import org.isistan.flabot.executionstatemapping.dialogs.logicalexpressionbuilder.ExpressionGUIBuilder;
import org.isistan.flabot.executionstatemapping.dialogs.logicalexpressionbuilder.LogicalExpressionGUI;
import org.isistan.flabot.executionstatemapping.dialogs.logicalexpressionbuilder.SingleExpressionGUI;
import org.isistan.flabot.executionstatemapping.dialogs.utils.filter.ViewFilterProvider;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologFactory;
import org.isistan.flabot.executionstatemapping.model.prolog.impl.ResponsibilityTagProviderImpl;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticFactory;
import org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration;
import org.isistan.flabot.executionstatemapping.model.semantic.SimpleExpressionExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.SingleExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.impl.AbstractExpressionImpl;
import org.isistan.flabot.executionstatemapping.model.semantic.impl.ExecutionConditionImpl;

public class LogicalExpressionBuilder extends AbstractExecutionConditionDialog implements Observer {

	private ScrolledComposite scrollPanelCondicion = null;

	private Composite panelCondicion = null;

	private Button buttonInsert = null;

	private Button buttonDelete = null;

	private LogicalExpressionGUI expressionGUI;  //  @jve:decl-index=0:

	private LogicalExpressionGUI selectedExpression;

	private SimpleExpressionExecutionCondition expressionEvent;
	
	private Composite logicalPanel = null;
	
	private Combo comboRole;

	private ViewFilterProvider[] selectExecutionConditionFilters = null;
	
	private ViewFilterProvider[] newExecutionConditionFilters = null;
	
	public LogicalExpressionBuilder(String title, SimpleExpressionExecutionCondition expressionEvent, ViewFilterProvider[] selectExecutionConditionFilters, ViewFilterProvider[] newExecutionConditionFilters) {
		this.expressionEvent=expressionEvent;
		this.selectExecutionConditionFilters = selectExecutionConditionFilters;
		this.newExecutionConditionFilters = newExecutionConditionFilters;
		createSShell();	
		sShell.setText(title);
	}
	
	@Override
	protected void processOkEvent()
	{
		expressionEvent.setExpression(expressionGUI.getExecutionConditionExpression());
		expressionEvent.setName(textName.getText());
		expressionEvent.setExecutionState(getExecutionState());
	}
	
	
	@Override
	protected String getPrologCode()
	{
		SimpleExecutionConditionConfiguration simpleConfiguration=SemanticFactory.eINSTANCE.createSimpleExecutionConditionConfiguration();
		AbstractExpressionImpl.predicateExpressionNumber=0;
		ExecutionConditionImpl.predicateExpressionNumber=0;
		expressionEvent.setExpression(expressionGUI.getExecutionConditionExpression());
		expressionEvent.setName(textName.getText());
		expressionEvent.setExecutionState(getExecutionState());
		simpleConfiguration.getSimpleExpressionExecutionConditions().add(expressionEvent);
		for(ExecutionCondition executionCondition : simpleConfiguration.getPreFilters())
    		executionCondition.resetPredicateName();
		for(SimpleExpressionExecutionCondition simpleExpressionExecutionCondition : simpleConfiguration.getSimpleExpressionExecutionConditions())
		{
			if (simpleExpressionExecutionCondition.getExpression() != null)
			{
				simpleExpressionExecutionCondition.getExpression().resetPredicateName();
			}
		}
		return PrologFactory.eINSTANCE.createPrologCodeFactory().getPrologCode(simpleConfiguration, new ResponsibilityTagProviderImpl());
	}
	
	public List<String> getErrors()
	{
		List<String> errors=new ArrayList<String>();
		if(textName.getText().length()==0)
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.LogicalExpressionBuilder.fieldNoname")); //$NON-NLS-1$
			errors.add(""); //$NON-NLS-1$
		}
		int nullCount=expressionGUI.getErrors().size();
		if(nullCount!=0)
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.LogicalExpressionBuilder.emptyExecutions", nullCount)); //$NON-NLS-1$
			errors.add(""); //$NON-NLS-1$
		}
		return errors;
	}
	
	@Override
	protected void processCancelEvent()
	{
		expressionEvent=null;
	}
	
	private ExecutionStateValue getExecutionState()
	{
		return (ExecutionStateValue)comboRole.getData(String.valueOf(comboRole.getSelectionIndex()));
	}
	
	@Override
	protected void createAditionalComposites()
	{
		GridData gridData14 = new GridData();
		gridData14.horizontalAlignment = GridData.FILL;
		gridData14.grabExcessHorizontalSpace = true;
		gridData14.verticalAlignment = GridData.CENTER;
		GridData gridData111 = new GridData();
		gridData111.horizontalAlignment = GridData.BEGINNING;
		gridData111.grabExcessHorizontalSpace = true;
		GridData gridData121 = new GridData();
		GridLayout gridLayout61 = new GridLayout();
		gridLayout61.numColumns = 4;
		
		Composite compositeExecutionState = new Composite(sShell, SWT.NONE);
		compositeExecutionState.setLayout(gridLayout61);
		compositeExecutionState.setLayoutData(gridData14);
		Label labelDescription  = new Label(compositeExecutionState, SWT.NONE);
		labelDescription.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.LogicalExpressionBuilder.executionState")); //$NON-NLS-1$
		labelDescription.setLayoutData(gridData121);
		comboRole=new Combo(compositeExecutionState,SWT.READ_ONLY|SWT.BORDER);
		comboRole.setBackground(ColorConstants.white);
		ComboExecutionStateProvider contentProvider=new ComboExecutionStateProvider();
		contentProvider.fillCombo(comboRole,expressionEvent);
		comboRole.setLayoutData(gridData111);
		
		buttonInsert = new Button(compositeExecutionState, SWT.NONE);
		buttonInsert.setImage(ImageDescriptor.createFromFile(
				ExecutionConditionPlugin.class, "icons/add.gif").createImage()); //$NON-NLS-1$
		GridData buttonGridData=new GridData();
		buttonGridData.heightHint=32;
		buttonGridData.widthHint=32;
		buttonGridData.verticalAlignment=SWT.BEGINNING;
		buttonGridData.horizontalAlignment=SWT.BEGINNING;
		buttonInsert.setLayoutData(buttonGridData);
		buttonInsert.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(selectedExpression!=null)
				{
					LogicalExpressionGUI aux=selectedExpression.addChild();
					if (aux!=null)
						expressionGUI=aux;
				}
				panelCondicion.pack();
				scrollPanelCondicion.setMinSize(scrollPanelCondicion.computeSize(expressionGUI.getExpressionWidth(),expressionGUI.getExpressionHigth()));
				panelCondicion.layout();

			}
		});
		
		buttonDelete = new Button(compositeExecutionState, SWT.NONE);
		buttonDelete.setImage(ImageDescriptor.createFromFile(
				ExecutionConditionPlugin.class, "icons/delete.gif").createImage()); //$NON-NLS-1$
		buttonDelete.setLayoutData(buttonGridData);
		buttonDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(selectedExpression!=null)
				{
					
					LogicalExpressionGUI aux=selectedExpression.delete();
					if (aux!=null)
						expressionGUI=aux;
				}
				panelCondicion.pack();
				panelCondicion.layout();
				scrollPanelCondicion.setMinSize(scrollPanelCondicion.computeSize(expressionGUI.getExpressionWidth() ,expressionGUI.getExpressionHigth()));
			}
		});
	}
	
	@Override
	protected  void createCompositeContent()
	{
		GridData gridData61 = new GridData();
		gridData61.horizontalAlignment = GridData.FILL;
		gridData61.grabExcessHorizontalSpace = true;
		gridData61.grabExcessVerticalSpace = true;
		gridData61.verticalAlignment = GridData.FILL;
		mainComposite.setLayoutData(gridData61);
		mainComposite.setLayout(new GridLayout());
		
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace=true;
		gridData.grabExcessVerticalSpace=true;
		gridData.horizontalAlignment=SWT.FILL;
		gridData.verticalAlignment=SWT.FILL;
		GridLayout gridLayout = new GridLayout();
		gridLayout.marginHeight=0;
		gridLayout.marginWidth=0;
		gridLayout.verticalSpacing=0;
		logicalPanel=  new Composite(mainComposite, SWT.NONE);
		logicalPanel.setLayoutData(gridData);
		logicalPanel.setLayout(gridLayout);
		createPanelCondicion();
	}
	
	public SimpleExpressionExecutionCondition showDialog() 
	{
		try
		{
			if (expressionEvent==null)
			{
				createSimpleExpression();
			}
			else
			{
				ExpressionGUIBuilder expressionGUIBuilder= new ExpressionGUIBuilder(panelCondicion,this);
				expressionGUIBuilder.setSelectExecutionConditionFilters(selectExecutionConditionFilters);
				expressionGUIBuilder.setNewExecutionConditionFilters(newExecutionConditionFilters);
				textName.setText(expressionEvent.getName());
				expressionGUI=expressionGUIBuilder.makeGUIExpression(expressionEvent.getExpression());
				expressionGUI.setSelected(true);
				selectedExpression=expressionGUI;
			}	
			sShell.setMinimumSize(new Point(400, 400));
			sShell.pack();

			// Centra la pantalla
			Display display = sShell.getDisplay();
			Rectangle r = display.getClientArea();
			int centerX = r.width / 2 - sShell.getSize().x / 2;
			int centerY = r.height / 2 - sShell.getSize().y / 2;
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
		return expressionEvent;
	}

	/**
	 * This method initializes panelCondicion
	 *
	 */
	private void createPanelCondicion() {
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.horizontalSpacing = 0;
		gridLayout1.marginHeight = 10;
		gridLayout1.marginWidth = 10;
		gridLayout1.verticalSpacing=4;
		gridLayout1.horizontalSpacing=0;
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.heightHint = -1;
		gridData.grabExcessVerticalSpace = true;

		scrollPanelCondicion = new ScrolledComposite(logicalPanel, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		panelCondicion =new Composite(scrollPanelCondicion,SWT.NONE);
		scrollPanelCondicion.setContent(panelCondicion);
		scrollPanelCondicion.setSize(scrollPanelCondicion.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		scrollPanelCondicion.setExpandHorizontal(true);
		scrollPanelCondicion.setExpandVertical(true);

		panelCondicion.setLayout(gridLayout1);
		scrollPanelCondicion.setLayoutData(gridData);
		scrollPanelCondicion.setMinSize(scrollPanelCondicion.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		scrollPanelCondicion.setLayout(new FillLayout());
	}
	
	public void update(Observable o, Object arg)
	{
		if(selectedExpression!=null)
		{
			selectedExpression.setSelected(false);
		}
		selectedExpression=(LogicalExpressionGUI)arg;
		selectedExpression.setSelected(true);
		panelCondicion.layout();
		panelCondicion.pack();
	}

	private void createSimpleExpression()
	{
		expressionEvent=SemanticFactory.eINSTANCE.createSimpleExpressionExecutionCondition();
		SingleExpression singleExpression=SemanticFactory.eINSTANCE.createSingleExpression();
		expressionGUI=new SingleExpressionGUI(null,panelCondicion,selectExecutionConditionFilters,newExecutionConditionFilters);
		expressionEvent.setExpression(singleExpression);
		expressionGUI.setObserver(this);
		expressionGUI.notifyObservers();
		panelCondicion.layout();
	}	
	
}