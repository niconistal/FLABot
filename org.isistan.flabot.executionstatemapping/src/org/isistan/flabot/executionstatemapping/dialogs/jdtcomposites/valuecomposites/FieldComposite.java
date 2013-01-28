package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableItem;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.JDTComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.listeners.FieldButtonListener;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.FieldEvaluationCondition;

public class FieldComposite extends ValueComposite {

	private List<FieldEvaluationCondition> fieldEvaluationsConditions;
	private Button buttonFields;
	
	public FieldComposite(Composite parent, TableItem tableItem, JDTComposite jdtParent, int style)
	{
		super(parent,style);
		addListener(jdtParent, tableItem);
	}
	
	@Override
	protected void createComposite() {
		buttonFields = new Button(this, SWT.READ_ONLY);		
		buttonFields.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.valuecomposites.FieldComposite.buttonChoose")); //$NON-NLS-1$
		buttonFields.setEnabled(true);
		
		GridData gridDataButton = new GridData();
		gridDataButton.grabExcessVerticalSpace = true;
		gridDataButton.verticalAlignment = SWT.FILL;
		
		buttonFields.setLayoutData(gridDataButton);

		GridData gridDataButtonFields= new GridData(GridData.FILL_HORIZONTAL);
		gridDataButtonFields.verticalAlignment = GridData.BEGINNING;
		gridDataButtonFields.horizontalAlignment = GridData.CENTER;
		buttonFields.setLayoutData(gridDataButtonFields);
		gridDataButtonFields.grabExcessVerticalSpace=true;
		
		
	}
	
	@Override
	public void setEnabled(boolean enabled)
	{
		buttonFields.setEnabled(enabled);
	}
	
	
	private void addListener(JDTComposite jdtComposite, TableItem tableItem)
	{
		buttonFields.addSelectionListener(new FieldButtonListener(jdtComposite,tableItem,this));		
	}
	

	public void setEvaluationConditions(List<FieldEvaluationCondition> list)
	{
		fieldEvaluationsConditions=list;
		updateButton();
	}
	
	public List<FieldEvaluationCondition> getEvaluationConditions()
	{
		return fieldEvaluationsConditions;
	}
	
	public void updateButton()
	{
		if (fieldEvaluationsConditions != null && fieldEvaluationsConditions.size() > 0)
		{
			buttonFields.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.valuecomposites.FieldComposite.buttonChooseUsed")); //$NON-NLS-1$
		}
		else
		{
			buttonFields.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.valuecomposites.FieldComposite.buttonChoose")); //$NON-NLS-1$
		}
		buttonFields.update();
	}
	
	@Override
	public String getText() {
		return null;
	}

	@Override
	public void setText(String text) {
		
	}

	public List<String> getErrors() {
		return new ArrayList<String>();
	}
	
	public void executeAction()
	{
		
	}

}
