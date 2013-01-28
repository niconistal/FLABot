package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;
import org.isistan.flabot.executionstatemapping.dialogs.common.ActivatedElement;
import org.isistan.flabot.executionstatemapping.dialogs.utils.DialogUtils;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.ExceptionEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticFactory;
import org.isistan.flabot.executionstatemapping.utils.jdt.BinaryClassSearchRequestor;

public class ExceptionFilterComposite extends Composite implements ActivatedElement {
	
	private Button buttonCheckAnyException;
	
	private Button buttonCheckSpecificException;
	
	private Text textExceptionClass;
	
	private Button buttonExceptionClassSelection;
	
	private IType[] hierarchyTypes;
	
	private IType exceptionType;
	
	public ExceptionFilterComposite(Composite parent, int type)
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
	
	public void activate()
	{
		
	}
	
	public int getItemCount()
	{
		int index = 0;
		if (buttonCheckAnyException.getSelection()) index++;
		if (buttonCheckSpecificException.getSelection()) index++;
		return index;
	}
	
	public void resetComposite()
	{
		buttonCheckAnyException.setSelection(false);
		buttonCheckSpecificException.setSelection(false);
		updateControls();
	}
	
	public List<String> getErrors()
	{
		List<String> errors=new ArrayList<String>();
		if (buttonCheckSpecificException.getSelection() && textExceptionClass.getText().trim().equals("")) //$NON-NLS-1$
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.ExceptionFilterComposite.exceptionsError")); //$NON-NLS-1$
			errors.add(""); //$NON-NLS-1$
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.ExceptionFilterComposite.misssingExceptionClass")); //$NON-NLS-1$
			errors.add(""); //$NON-NLS-1$
		}
		return errors;
	}
	
	private void createControls(Composite parent)
	{
		Group c = new Group(parent, SWT.CHECK);
		c.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.ExceptionFilterComposite.exceptionVerification")); //$NON-NLS-1$
		c.setLayout(new GridLayout());
		GridData gridData4 = new GridData(GridData.FILL_HORIZONTAL);
		c.setLayoutData(gridData4);
		
		buttonCheckAnyException = new Button(c, SWT.CHECK);
		buttonCheckAnyException.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.ExceptionFilterComposite.ifExceptionIsThrown")); //$NON-NLS-1$
		GridData gridData0 = new GridData();
		gridData0.horizontalIndent = 20;
		gridData0.verticalIndent = 5;
		buttonCheckAnyException.setLayoutData(gridData0);
		buttonCheckAnyException.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				buttonCheckSpecificException.setSelection(false);
				updateControls();
			}
		});
		
		buttonCheckSpecificException = new Button(c, SWT.CHECK);
		buttonCheckSpecificException.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.ExceptionFilterComposite.ifExceptionOfClassIsThrown")); //$NON-NLS-1$
		GridData gridData3= new GridData();
		gridData3.horizontalIndent = 20;
		gridData3.verticalIndent = 5;
		buttonCheckSpecificException.setLayoutData(gridData3);
		buttonCheckSpecificException.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				buttonCheckAnyException.setSelection(false);
				updateControls();
			}
		});
		
		Composite composite = new Composite(c, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		
		textExceptionClass = new Text(composite, SWT.BORDER);
		GridData gridDataText = new GridData();
		gridDataText.widthHint = 350;
		gridDataText.horizontalIndent = 50;
		textExceptionClass.setLayoutData(gridDataText);
		textExceptionClass.setEnabled(false);
		
		buttonExceptionClassSelection = new Button(composite, SWT.READ_ONLY);	
		buttonExceptionClassSelection.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.ExceptionFilterComposite.chooseButton")); //$NON-NLS-1$
		buttonExceptionClassSelection.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				openExceptionClassSelection();
			}
		});
		buttonExceptionClassSelection.setEnabled(false);
		GridData gridDataButton = new GridData();
		gridDataButton.widthHint = 25;
		buttonExceptionClassSelection.setLayoutData(gridDataButton);
	}
		
	private void openExceptionClassSelection()
	{
		if (exceptionType == null)
		{
			BinaryClassSearchRequestor binarySearchRequestor = new BinaryClassSearchRequestor();
			binarySearchRequestor.search("java.lang.Exception"); //$NON-NLS-1$
			exceptionType = binarySearchRequestor.getFoundJavaElemet();
		}
		
		if (hierarchyTypes == null)
		{
			IRunnableWithProgress process = new IRunnableWithProgress()
			{
				public void run(IProgressMonitor monitor)
				{		
					try
					{	
						if (exceptionType !=  null)
						{
							ITypeHierarchy typeHierarchy = exceptionType.newTypeHierarchy(monitor);
							hierarchyTypes = typeHierarchy.getAllSubtypes(exceptionType);
						
							if (hierarchyTypes != null)
							{
								IType[] completeHierarchyTypes=new IType[hierarchyTypes.length+1];
								for(int i=0;i<hierarchyTypes.length;i++)
								{
									completeHierarchyTypes[i]=hierarchyTypes[i];
								}
								completeHierarchyTypes[hierarchyTypes.length]=exceptionType;
								hierarchyTypes = completeHierarchyTypes;
							}
						}
					}
					catch(JavaModelException ex)
					{	
						ExecutionConditionPlugin.getDefault().getLogger().error(
								ex.getMessage() + ex.getStackTrace());
					}
				}
			};
			
			//Shows a progress monitor while searching
			ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
			try
			{
				dialog.run(true, true, process);
			}
			catch(InvocationTargetException e)
			{
				ExecutionConditionPlugin.getDefault().getLogger().error(
						e.getMessage() + e.getStackTrace());
			}
			catch(InterruptedException e)
			{
				hierarchyTypes = null;
			}
		}
		if (hierarchyTypes != null)
		{
			IType selectedIType = DialogUtils.getSelectedListElement(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.ExceptionFilterComposite.exceptionClass"), Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.ExceptionFilterComposite.selectClass"), new JavaElementLabelProvider(), hierarchyTypes); //$NON-NLS-1$ //$NON-NLS-2$
			if (selectedIType != null)
			{
				textExceptionClass.setText(selectedIType.getFullyQualifiedName());
			}
		}
	}
	
	private void updateControls()
	{
		textExceptionClass.setEnabled(buttonCheckSpecificException.getSelection());
		buttonExceptionClassSelection.setEnabled(buttonCheckSpecificException.getSelection());
	}
	
	public void fillComposite(ExecutionCondition executionCondition)
	{
		ExceptionEvaluationCondition exceptionEvaluation = executionCondition.getException();
		if (exceptionEvaluation != null)
		{
			buttonCheckAnyException.setSelection(exceptionEvaluation.isCheckAnyException());
			if (!exceptionEvaluation.isCheckAnyException())
			{
				buttonCheckSpecificException.setSelection(true);
				textExceptionClass.setText(exceptionEvaluation.getValue());
			}
			updateControls();
		}
	}
	
	public ExceptionEvaluationCondition getNewExceptionEvaluationCondition()
	{
		if (buttonCheckAnyException.getSelection() || buttonCheckSpecificException.getSelection())
		{
			ExceptionEvaluationCondition exceptionEvaluation = SemanticFactory.eINSTANCE.createExceptionEvaluationCondition();
			exceptionEvaluation.setCheckAnyException(buttonCheckAnyException.getSelection());
			if (buttonCheckSpecificException.getSelection())
			{
				exceptionEvaluation.setValue(textExceptionClass.getText());
			}
			return exceptionEvaluation;
		}		
		return null;
	}
}
