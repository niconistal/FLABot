package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ScopeEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ScopeFilterType;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticFactory;

public class GeneralScopeFilterComposite extends Composite {
	
	private Button buttonParametersScope;
	
	private Button buttonReturnValueScope;
	
	private Button buttonFieldsScope;
	
	public GeneralScopeFilterComposite(Composite parent, int type)
	{
		super(parent, type);
		createControls(this);
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.verticalAlignment = GridData.FILL;
		this.setLayoutData(gridData);
		this.setLayout(gridLayout);
	}
	
	public int getItemCount()
	{
		int index = 0;
		if (buttonParametersScope.getSelection()) index++;
		if (buttonFieldsScope.getSelection()) index++;
		if (buttonReturnValueScope.getSelection()) index++;
		return index;
	}

	private void createControls(Composite parent)
	{
		Group c = new Group(parent, SWT.CHECK);
		c.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.GeneralScopeFilterComposite.preScope")); //$NON-NLS-1$
		c.setLayout(new GridLayout());
		GridData gridData4 = new GridData(GridData.FILL_HORIZONTAL);
		c.setLayoutData(gridData4);
		
		Label title = new Label(c, SWT.CHECK);
		title.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.GeneralScopeFilterComposite.applyPreScope")); //$NON-NLS-1$
		GridData gridData = new GridData();
		gridData.horizontalIndent = 5;
		gridData.verticalIndent = 5;
		title.setLayoutData(gridData);
		
		buttonParametersScope = new Button(c, SWT.CHECK);
		buttonParametersScope.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.GeneralScopeFilterComposite.parameters")); //$NON-NLS-1$
		GridData gridData0 = new GridData();
		gridData0.horizontalIndent = 20;
		gridData0.verticalIndent = 5;
		buttonParametersScope.setLayoutData(gridData0);
		
		buttonReturnValueScope = new Button(c, SWT.CHECK);
		buttonReturnValueScope.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.GeneralScopeFilterComposite.returnValue")); //$NON-NLS-1$
		GridData gridData3= new GridData();
		gridData3.horizontalIndent = 20;
		gridData3.verticalIndent = 5;
		buttonReturnValueScope.setLayoutData(gridData3);
		
		buttonFieldsScope = new Button(c, SWT.CHECK);
		buttonFieldsScope.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.GeneralScopeFilterComposite.fields")); //$NON-NLS-1$
		GridData gridData1 = new GridData();
		gridData1.horizontalIndent = 20;
		gridData1.verticalIndent = 5;
		buttonFieldsScope.setLayoutData(gridData1);		
	}
	
	public void fillComposite(ExecutionCondition executionCondition)
	{
		ScopeEvaluationCondition scopeFilter = executionCondition.getScope();
		if (scopeFilter != null)
		{
			buttonParametersScope.setSelection(scopeFilter.hasScopeFilter(ScopeFilterType.ARGUMENTS_SCOPE));
			buttonReturnValueScope.setSelection(scopeFilter.hasScopeFilter(ScopeFilterType.RETURNVALUE_SCOPE));
			buttonFieldsScope.setSelection(scopeFilter.hasScopeFilter(ScopeFilterType.FIELDS_SCOPE));
		}
	}
	
	public ScopeEvaluationCondition getNewScopeEvaluationCondition()
	{
		if(buttonParametersScope.getSelection() || buttonFieldsScope.getSelection() || buttonReturnValueScope.getSelection())
		{
			ScopeEvaluationCondition scopeEvaluation = SemanticFactory.eINSTANCE.createScopeEvaluationCondition();
			if (buttonParametersScope.getSelection() )
			{
				scopeEvaluation.addScopeFilter(ScopeFilterType.ARGUMENTS_SCOPE);	
			}
			if (buttonReturnValueScope.getSelection())
			{
				scopeEvaluation.addScopeFilter(ScopeFilterType.RETURNVALUE_SCOPE);
			}
			if (buttonFieldsScope.getSelection())
			{
				scopeEvaluation.addScopeFilter(ScopeFilterType.FIELDS_SCOPE);
			}
			return scopeEvaluation;
		}
		return null;
	}
}
