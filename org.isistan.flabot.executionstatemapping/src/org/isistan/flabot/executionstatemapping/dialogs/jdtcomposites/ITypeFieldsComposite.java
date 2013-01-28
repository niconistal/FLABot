package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableItem;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;
import org.isistan.flabot.executionstatemapping.dialogs.common.ActivatedElement;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites.ValueComposite;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.ConditionValue;
import org.isistan.flabot.executionstatemapping.model.semantic.EvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.FieldEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticFactory;

public class ITypeFieldsComposite extends ITypeBasedJDTComposite implements FieldBehavior, ActivatedElement{
	
	private IType containerClass;
	
	private boolean activated = false;
	
	private List<FieldEvaluationCondition> initialElements;
	
	public ITypeFieldsComposite(Composite parentComposite, int style)
	{
		super(parentComposite,style);	
	}
	
	public void setContainerClass(IType containerClass)
	{
		this.containerClass=containerClass;
		activated = false;
		cantSelected = 0;
	}
	
	public int getItemCount()
	{
		return activated?cantSelected:initialElements.size();
	}
	
	public void activate()
	{
		if (!activated && containerClass != null)
		{			
			final Display display = Display.getDefault();
			
			//Creates a monitor to search the Hierarchy fields
			IRunnableWithProgress process = new IRunnableWithProgress()
			{
				
				private void executeAsyncClear()
				{
					display.asyncExec( new Runnable()
					{
						public void run()
						{
							clearAllTable();
						}
					});
				}				
				
				private void executeAsyncAdd(final IField f)
				{
					display.asyncExec( new Runnable()
					{
						public void run()
						{		
							try
							{
								addTableItem(f, f.getTypeSignature(), f.getElementName(),getFieldEvaluationCondition( f.getElementName(),initialElements));
							}
							catch(JavaModelException e)
							{
								ExecutionConditionPlugin.getDefault().getLogger().error(
										e.getMessage() + e.getStackTrace());
							}
						}
					});
				}
				
				public void run(IProgressMonitor monitor)
				{
					try
					{
						executeAsyncClear();
						
						//Adds the fields of the container class
						for (IField f :containerClass.getFields())
						{
							executeAsyncAdd(f);
						}
						
						ITypeHierarchy typeHierarchy = containerClass.newSupertypeHierarchy(monitor);
						IType[] superClassesTypes = typeHierarchy.getAllSuperclasses(containerClass);
						for (IType superClass :superClassesTypes)
						{
							for (IField f :superClass.getFields())
							{
								executeAsyncAdd(f);
							}	
						}
					}
					catch(JavaModelException e)
					{
						ExecutionConditionPlugin.getDefault().getLogger().error(
									e.getMessage() + e.getStackTrace());
					}
				}
			};
				
			//Shows a progress monitor while searching
			ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
			try
			{
				dialog.run(true, false, process);
			}
			catch(InvocationTargetException e)
			{
				ExecutionConditionPlugin.getDefault().getLogger().error(
						e.getMessage() + e.getStackTrace());
			}
			catch(InterruptedException e)
			{
				ExecutionConditionPlugin.getDefault().getLogger().error(
						e.getMessage() + e.getStackTrace());
			}
			activated = true;
		}
	}
	
	public List<String> getErrors()
	{
		List<String> errors=new ArrayList<String>();
		int position = 1;
		for(TableItem ti : jdtTable.getItems())
		{
			Button checkBox=(Button)ti.getData(CHECK_BUTTON);
			if(checkBox!=null && checkBox.getSelection())
			{
				ValueComposite value=(ValueComposite)ti.getData(COMPOSITE_VALUE);
				List<String> itemErrors=value.getErrors();
				if(itemErrors.size()!=0)
				{
					for (String s:itemErrors)
					{
						s=Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.ITypeFieldsComposite.errorField", position, s); //$NON-NLS-1$
						errors.add(s);
					}
				}
			}
			position++;
		}	
		return errors;
	}
	
	public void fillTable(List<FieldEvaluationCondition> initialElements)
	{
		this.initialElements = initialElements;	
	}
	
	private EvaluationCondition getFieldEvaluationCondition(String name, List<FieldEvaluationCondition> evaluationConditions)
	{
		for(FieldEvaluationCondition evaluationCondition : evaluationConditions)
		{
			if (evaluationCondition.getFieldName().equals(name))
			{
				return evaluationCondition;
			}
		}
		return null;			
	}
	
	@Override
	protected void createColumns() 
	{
		createColumn(jdtTable, "", SWT.CENTER, 20); //$NON-NLS-1$
		createColumn(jdtTable, Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.ITypeFieldsComposite.fieldName"), SWT.CENTER, 200); //$NON-NLS-1$
		createColumn(jdtTable, Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.ITypeFieldsComposite.condition"), SWT.CENTER, 120); //$NON-NLS-1$
		createColumn(jdtTable, Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.ITypeFieldsComposite.value"), SWT.CENTER, 150); //$NON-NLS-1$
	}
	
	private void addTableItem(IField iField, String type, String name, EvaluationCondition evaluationCondition)
	{
		TableItem item = new TableItem(jdtTable, SWT.NONE); // @jve
		ConditionValue conditionValue =(evaluationCondition != null)?evaluationCondition.getCondition(): null;
		item.setData(TYPE_DATA_KEY, type);
		
		Button checkButton=createCheckButton(item);
			
		Label labelName =createLabelName(item);
		labelName.setText(name + " : " +  Signature.toString(type)); //$NON-NLS-1$
		labelName.setData(name);

		ValueComposite compositeValue = createCompositeValue(item,conditionValue);
		
		CCombo combo=createComboBox(item, conditionValue,compositeValue);// @jve

		// Agrego los datos de la condition de evaluacion
		if (evaluationCondition != null)
		{
			checkButton.setSelection(true);
			if (evaluationCondition.getValue() != null)
			{
				compositeValue.setText(evaluationCondition.getValue());
			}
			setItemSelected(item,true);
		}
		else
		{
			setItemSelected(item, false);
		}
		
		compositeValue=updateCompositeValue(combo);		
	}
	
	@Override
	protected IMember getIMember()
	{
		return containerClass;
	}
	
	public List<FieldEvaluationCondition> getFieldsEvaluationConditions()
	{
		if(!activated)
		{
			return initialElements;
		}
		
		List<FieldEvaluationCondition> fieldsConditions=new ArrayList<FieldEvaluationCondition>();	
		for(TableItem ti : jdtTable.getItems())
		{
			Button checkBox=(Button)ti.getData(CHECK_BUTTON);
			if(checkBox!=null && checkBox.getSelection())
			{
				FieldEvaluationCondition evaluationCondition=SemanticFactory.eINSTANCE.createFieldEvaluationCondition();
				evaluationCondition.setFieldName((String) ((Label)ti.getData(LABEL_NAME)).getData());
				CCombo conditionValue=(CCombo)ti.getData(COMBO_ROLE);
				evaluationCondition.setCondition((ConditionValue)conditionValue.getData(String.valueOf(conditionValue.getSelectionIndex())));
				evaluationCondition.setValue(((ValueComposite)ti.getData(COMPOSITE_VALUE)).getText());
				fieldsConditions.add(evaluationCondition);
			}
		}
		return fieldsConditions;
	}
}