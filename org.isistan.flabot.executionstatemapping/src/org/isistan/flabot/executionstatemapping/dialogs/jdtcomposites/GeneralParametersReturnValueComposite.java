package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites.FieldComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites.ValueComposite;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.ConditionValue;
import org.isistan.flabot.executionstatemapping.model.semantic.EvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.FieldEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ParameterEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.ReturnedValueEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticFactory;

public class GeneralParametersReturnValueComposite extends GeneralJDTComposite
{
	protected boolean hasReturnValue=false;
	
	public GeneralParametersReturnValueComposite(Composite parentComposite, int style)
	{
		super(parentComposite,style);
	}

	@Override
	protected void createColumns() 
	{
		createColumn(jdtTable, "", SWT.CENTER, 20); //$NON-NLS-1$
		createColumn(jdtTable, Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.GeneralParametersReturnValueComposite.parameterName"), SWT.CENTER, 160); //$NON-NLS-1$
		createColumn(jdtTable, Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.GeneralParametersReturnValueComposite.condition"), SWT.CENTER, 120); //$NON-NLS-1$
		createColumn(jdtTable, Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.GeneralParametersReturnValueComposite.value"), SWT.CENTER, 140); //$NON-NLS-1$
		createColumn(jdtTable, Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.GeneralParametersReturnValueComposite.fields"), SWT.CENTER, 50); //$NON-NLS-1$
	}
	
	public List<String> getErrors()
	{
		List<String> errors=new ArrayList<String>();
		int position = 1;
		for(TableItem ti : jdtTable.getItems())
		{
			Button checkBox=(Button)ti.getData(CHECK_BUTTON);
			if(checkBox!=null)
			{
				ValueComposite value=(ValueComposite)ti.getData(COMPOSITE_VALUE);
				List<String> itemErrors=value.getErrors();
				if(itemErrors!=null)
				{
					boolean isParameter = (Boolean)checkBox.getData();
					for(String s:itemErrors)
					{
						if (isParameter)
						{
							s = Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.GeneralParametersReturnValueComposite.parameterError", position, s); //$NON-NLS-1$
						}
						else
						{
							s = Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.GeneralParametersReturnValueComposite.returnValueError", position, s); //$NON-NLS-1$
						}
						errors.add(s);
					}
				}
			}
			position++;
		}	
		return errors;
	}
	
	@Override
	protected void removeSelectedItems()
	{
		int position = 0;
		List<Integer> positions=new ArrayList<Integer>();
		for(TableItem ti : jdtTable.getItems())
		{
			Button checkBox=(Button)ti.getData(CHECK_BUTTON);
			if(checkBox!=null && checkBox.getSelection())
			{
				boolean isParameter = (Boolean)checkBox.getData();
				if(!isParameter)
				{
					positions.add(position-1);
					hasReturnValue=false;
				}
				positions.add(position);
			}
			position++;
		}
		for (int i=positions.size()-1;i>=0;i--)
		{
			int pos=positions.get(i);
			TableItem item=jdtTable.getItem(pos);
			if(item.getData(CHECK_BUTTON)!=null)
			{
				((Control)item.getData(CHECK_BUTTON)).dispose();
				((Control)item.getData(LABEL_NAME)).dispose();
				((Control)item.getData(COMPOSITE_VALUE)).dispose();
				((Control)item.getData(COMBO_ROLE)).getParent().dispose();
				((Control)item.getData(COMBO_ROLE)).dispose();
				Control fieldComposite=(Control)item.getData(COMPOSITE_FIELDS);
				if(fieldComposite!=null)	
					fieldComposite.dispose();
			}
			jdtTable.remove(pos);
		}
		jdtTable.pack();
		jdtTable.getParent().layout();
	}
	
	public void fillTable(ExecutionCondition executionCondition)throws JavaModelException
	{
		int total = executionCondition.getParameters().size();
		for(int i=total -1; i >= 0; i--)
		{		
			createItem(executionCondition.getParameters().get(i),true);
		}
		
		if (executionCondition.getReturnedValue()!=null)
		{
			showReturnedValue(executionCondition.getReturnedValue());
		}
	}
	
	public void showReturnedValue(ReturnedValueEvaluationCondition evaluationCondition)
	{
		hasReturnValue=true;
		TableItem ti = new TableItem(jdtTable, SWT.NONE,jdtTable.getItemCount());// @jve
		ti.setBackground(new Color(Display.getDefault(), 255, 255, 255));
		createItem(evaluationCondition,false);
	}
	
	@Override
	public void addTableItem()
	{
		if (!hasReturnValue)
		{
			final Menu menu = new Menu(addButton);
	    	
	    	MenuItem menuItem = new MenuItem(menu, SWT.PUSH);
			menuItem.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.GeneralParametersReturnValueComposite.parameter")); //$NON-NLS-1$
			menuItem.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					createItem(null,true);
					jdtTable.pack();
					jdtTable.getParent().layout();
				}
			});
				    	
	    	menuItem = new MenuItem(menu, SWT.PUSH);
	    	menuItem.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.GeneralParametersReturnValueComposite.returnValue")); //$NON-NLS-1$
	    	menuItem.addSelectionListener(new SelectionAdapter() {
	    		@Override
				public void widgetSelected(SelectionEvent e) {
	    			showReturnedValue(null);
	    			jdtTable.pack();
	    			jdtTable.getParent().layout();
	    		}
	    	});
	    	
	    	Rectangle rect = addButton.getBounds();
			Point pt = new Point(rect.x, rect.y + rect.height);
		    pt = addButton.getParent().toDisplay(pt);
		    menu.setLocation(pt.x, pt.y);
		    menu.setVisible(true);
		}
		else
		{
			createItem(null,true);
		}		
	}
	
	private void createItem(EvaluationCondition evaluationCondition, boolean isParameter)
	{
		int itemPosition=isParameter?0:jdtTable.getItemCount();
		String itemName=(isParameter)?Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.GeneralParametersReturnValueComposite.parameter"):Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.GeneralParametersReturnValueComposite.returnValue"); //$NON-NLS-1$ //$NON-NLS-2$
		ConditionValue conditionValue =(evaluationCondition != null)? evaluationCondition.getCondition():null;
		
		TableItem item = new TableItem(jdtTable, SWT.NONE,itemPosition); // @jve
		
		Button checkButton=createCheckButton(item);
		checkButton.setData(isParameter);
		
		Text textParameterName=createTextName(item);
		textParameterName.setText(itemName);
		textParameterName.setData(itemName);
		textParameterName.setEnabled(false);
		
		ValueComposite compositeValue = createCompositeValue(item,conditionValue);	
		
		CCombo combo=createComboBox(item,conditionValue,compositeValue);// @jve
		
		FieldComposite fieldComposite = null;
		if (isParameter)
		{
			fieldComposite = (FieldComposite) createFieldComposite(item);
		}
		
		// Agrego los datos de la condition de evaluacion
		if (evaluationCondition != null)
		{
			if (evaluationCondition.getValue() != null)
			{
				compositeValue.setText(evaluationCondition.getValue());
			}
			if (fieldComposite != null)
			{
				fieldComposite.setEvaluationConditions(((ParameterEvaluationCondition)evaluationCondition).getFieldEvaluationConditions());
			}
		}
		updateCompositeValue(combo);
		
		jdtTable.redraw();
		jdtTable.update();	
		
	}
	
	public void fillExecutionCondition(ExecutionCondition newExecutionCondition)
	{
		for(TableItem ti : jdtTable.getItems())
		{
			Button checkBox=(Button)ti.getData(CHECK_BUTTON);
			if(checkBox!=null)
			{
				boolean isParameter = (Boolean)checkBox.getData();
				EvaluationCondition evaluationCondition;
				if(isParameter)
				{
					evaluationCondition = SemanticFactory.eINSTANCE.createParameterEvaluationCondition();
					((ParameterEvaluationCondition)evaluationCondition).setParameterPosition(-1);
					
					List<FieldEvaluationCondition> fieldsEvaluations=((FieldComposite)ti.getData(COMPOSITE_FIELDS)).getEvaluationConditions();
					if (fieldsEvaluations!=null)
					{
						((ParameterEvaluationCondition)evaluationCondition).getFieldEvaluationConditions().addAll(fieldsEvaluations);
					}
					newExecutionCondition.getParameters().add((ParameterEvaluationCondition)evaluationCondition);
				}
				else
				{
					evaluationCondition = SemanticFactory.eINSTANCE.createReturnedValueEvaluationCondition();
					newExecutionCondition.setReturnedValue((ReturnedValueEvaluationCondition)evaluationCondition);
				}
				CCombo conditionValue=(CCombo)ti.getData(COMBO_ROLE);
				evaluationCondition.setCondition((ConditionValue)conditionValue.getData(String.valueOf(conditionValue.getSelectionIndex())));
				evaluationCondition.setValue(((ValueComposite)ti.getData(COMPOSITE_VALUE)).getText());
			}
		}
	}	
	
}