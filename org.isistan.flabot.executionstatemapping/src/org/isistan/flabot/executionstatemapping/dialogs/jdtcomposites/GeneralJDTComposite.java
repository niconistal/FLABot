package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites;

import java.util.List;

import org.eclipse.jdt.core.IType;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.executionstatemapping.dialogs.ParameterFieldsProperties;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites.FieldComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites.ValueComposite;
import org.isistan.flabot.executionstatemapping.dialogs.utils.DialogUtils;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.FieldEvaluationCondition;

public abstract class GeneralJDTComposite extends JDTComposite {

	private int cantChecked=0;
	
	protected Button addButton;
	
	protected Button removeButton;

	public GeneralJDTComposite(Composite parentComposite, int style)
	{
		super(parentComposite,style);
	}
	
	protected abstract void addTableItem();
	protected abstract void removeSelectedItems(); 
	
	@Override
	protected void fillComposite()
	{
		createTable();
		createColumns();
	}
	
	public int getItemCount()
	{
		return jdtTable.getItemCount();
	}
	
	protected Text createTextName(TableItem tableItem)
	{
		TableEditor textNameEditor = new TableEditor(jdtTable); // @jve
		Text textParameterName = new Text(jdtTable, SWT.None); // @jve
		textParameterName.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		textNameEditor.grabHorizontal = true;
		textNameEditor.setEditor(textParameterName, tableItem, LABEL_NAME_POS);
		tableItem.setData(LABEL_NAME,textParameterName);
		return textParameterName;
	}
	
	@Override
	public void checkButtonAction(TableItem tableItem,Button checkButton)
	{
		if(checkButton.getSelection())
			cantChecked++;
		else
			cantChecked--;
		removeButton.setEnabled(cantChecked!=0);
	}
	
	protected void createTable()
	{	 
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.verticalAlignment = GridData.FILL;
		
		Composite internalComposite = new Composite(this, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		internalComposite.setLayoutData(gridData);
		internalComposite.setLayout(gridLayout);
		
		jdtTable = new Table(internalComposite, SWT.BORDER |SWT.V_SCROLL);
	    jdtTable.setHeaderVisible(true);
		jdtTable.setLinesVisible(true);
		jdtTable.setLayoutData(gridData);
		createButtons(internalComposite);
	}
	
	private void createButtons(Composite internalComposite)
	{
		Composite c = new Composite(internalComposite, SWT.None);
		c.setLayout(new GridLayout());
		GridData gridData = new GridData();
		gridData.verticalAlignment = SWT.TOP;
		c.setLayoutData(gridData);
		
		addButton = new Button(c, SWT.None);
		addButton.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.GeneralJDTComposite.buttonAdd")); //$NON-NLS-1$
		addButton.setLayoutData(new GridData(GridData.FILL_BOTH));		
		addButton.addSelectionListener(new SelectionAdapter() 
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				addTableItem();
				jdtTable.pack();
				jdtTable.getParent().layout();
			}
		});	

		removeButton = new Button(c, SWT.None);
		removeButton.setEnabled(false);
		removeButton.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.GeneralJDTComposite.buttonRemove")); //$NON-NLS-1$
		removeButton.setLayoutData(new GridData(GridData.FILL_BOTH));
		removeButton.addSelectionListener(new SelectionAdapter() 
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				removeSelectedItems();
			}
		});	
	}
	
	@Override
	public void fieldClickAction(TableItem tableItem, FieldComposite fieldComposite)
	{
		 ParameterFieldsProperties dialog=new ParameterFieldsProperties(null);						
		 List<FieldEvaluationCondition> parametersFields=fieldComposite.getEvaluationConditions();
		 parametersFields=dialog.showDialog(parametersFields);
		 fieldComposite.setEvaluationConditions(parametersFields);
	}
	
	@Override
	public void classOfAction( TableItem tableItem, ValueComposite valueComposite,boolean fromHirarchy)
	{
		if(!fromHirarchy)
		{
			IType selectedIType=DialogUtils.showSelectClassFromWorkspaceDialog();			
			if (selectedIType != null)
			{
				valueComposite.setText(selectedIType.getFullyQualifiedName());
			}
		}
	}
}