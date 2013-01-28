package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites.ValueComposite;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.ConditionValue;
import org.isistan.flabot.executionstatemapping.model.semantic.FieldEvaluationCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticFactory;

public class GeneralFieldComposite extends GeneralJDTComposite implements FieldBehavior{
	
	public GeneralFieldComposite(Composite parentComposite, int style)
	{
		super(parentComposite,style);
	}
	
	public void activate()
	{		
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
				if(itemErrors.size()!=0)
				{
					for (String s:itemErrors)
					{
						s=Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.GeneralFieldComposite.errorLine", position, s); //$NON-NLS-1$
						errors.add(s);
					}
				}
			}
			position++;
		}	
		return errors;
	}
	
	@Override
	protected void createColumns() {
		createColumn(jdtTable, "", SWT.CENTER, 20); //$NON-NLS-1$
		createColumn(jdtTable, Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.GeneralFieldComposite.fieldName"), SWT.CENTER, 160); //$NON-NLS-1$
		createColumn(jdtTable, Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.GeneralFieldComposite.condition"), SWT.CENTER, 120); //$NON-NLS-1$
		createColumn(jdtTable, Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.GeneralFieldComposite.value"), SWT.CENTER, 140); //$NON-NLS-1$
	}
	
	public void fillTable(List<FieldEvaluationCondition> evaluationCondition)
	{
		int total = evaluationCondition.size();
		for(int i=total -1; i >= 0; i--)
		{		
			createItem(evaluationCondition.get(i));
		}		
	}
	
	@Override
	public void addTableItem()
	{
		createItem(null);
	}
	
	private void createItem(FieldEvaluationCondition evaluationCondition)
	{		
		ConditionValue conditionValue = (evaluationCondition != null)? evaluationCondition.getCondition():null;

		TableItem item = new TableItem(jdtTable, SWT.NONE,0); // @jve
		
		createCheckButton(item);
		
		Text textParameterName=createTextName(item);
		textParameterName.setText(""); //$NON-NLS-1$
		
		ValueComposite compositeValue = createCompositeValue(item,conditionValue);	
		
		CCombo combo=createComboBox(item,conditionValue,compositeValue);// @jve
		
		
		//setItemSelected(item,false);
		// Agrego los datos de la condition de evaluacion
		if (evaluationCondition != null)
		{
			if (evaluationCondition.getValue() != null)
			{
				compositeValue.setText(evaluationCondition.getValue());
			}
			if(evaluationCondition.getFieldName() != null)
			{
				textParameterName.setText(evaluationCondition.getFieldName());
			}
		}
		updateCompositeValue(combo);
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
				positions.add(position);
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
			}
			jdtTable.remove(pos);
		}
		jdtTable.pack();
		jdtTable.getParent().layout();
	}
	
	
	
	public List<FieldEvaluationCondition> getFieldsEvaluationConditions()
	{
		List<FieldEvaluationCondition> fieldsConditions=new ArrayList<FieldEvaluationCondition>();		
		for(TableItem ti : jdtTable.getItems())
		{
			Button checkBox=(Button)ti.getData(CHECK_BUTTON);
			if(checkBox!=null)
			{
				FieldEvaluationCondition evaluationCondition=SemanticFactory.eINSTANCE.createFieldEvaluationCondition();
				CCombo conditionValue=(CCombo)ti.getData(COMBO_ROLE);
				evaluationCondition.setCondition((ConditionValue)conditionValue.getData(String.valueOf(conditionValue.getSelectionIndex())));
				evaluationCondition.setValue(((ValueComposite)ti.getData(COMPOSITE_VALUE)).getText());						
				
				String fieldName = ((Text)ti.getData(LABEL_NAME)).getText();
				if (fieldName != null && fieldName.trim().length() == 0)
				{
					fieldName = null;
				}				
				evaluationCondition.setFieldName(fieldName);
				fieldsConditions.add(evaluationCondition);
			}
		}
		return fieldsConditions;
	}
	
	
}
