package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableItem;
import org.isistan.flabot.executionstatemapping.dialogs.common.ActivatedElement;
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

public class ITypeParametersReturnValueComposite extends ITypeBasedJDTComposite implements ActivatedElement{
		
	private IMethod methodData;
	
	public ITypeParametersReturnValueComposite(Composite parentComposite, int style)
	{
		super(parentComposite,style);		
	}
	
	public void setIMethod(IMethod methodData)
	{
		this.methodData=methodData;
		cantSelected = 0;
	}	
	
	public void activate()
	{
	}
	
	public int getItemCount()
	{
		return cantSelected;
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
				if(itemErrors!=null)
				{
					boolean isParameter = (Boolean)checkBox.getData();
					for(String s:itemErrors)
					{
						if (isParameter)
						{
							s = Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.ITypeParametersReturnValueComposite.parameterError", position, s); //$NON-NLS-1$
						}
						else
						{
							s = Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.ITypeParametersReturnValueComposite.returnValueError", position, s); //$NON-NLS-1$							
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
	protected void createColumns() {
		createColumn(jdtTable, "", SWT.CENTER, 20); //$NON-NLS-1$
		createColumn(jdtTable, Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.ITypeParametersReturnValueComposite.parameterName"), SWT.CENTER, 160); //$NON-NLS-1$
		createColumn(jdtTable, Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.ITypeParametersReturnValueComposite.condition"), SWT.CENTER, 120); //$NON-NLS-1$
		createColumn(jdtTable, Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.ITypeParametersReturnValueComposite.value"), SWT.CENTER, 140); //$NON-NLS-1$
		createColumn(jdtTable, Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.ITypeParametersReturnValueComposite.fields"), SWT.CENTER, 50); //$NON-NLS-1$
	}	
	
	public void fillTable(ExecutionCondition executionCondition)throws JavaModelException
	{		
		clearAllTable();
		
		int methodsCount;
		String[] parametersTypes = null;
		String[] parametersNames = null;
		methodsCount = methodData.getNumberOfParameters();
		parametersTypes = methodData.getParameterTypes();
		parametersNames = methodData.getParameterNames();
		for (int i = 0; i < methodsCount; i++)
		{
			addTableItem(parametersTypes[i],parametersNames[i], getParameterEvaluationCondition(i, executionCondition),true,i);
		}
		
		if (!Signature.toString(methodData.getReturnType()).equals("void")) //$NON-NLS-1$
		{		
			showReturnedValue(executionCondition);
		}
	}
	
	private void addTableItem(final String type,final String name, EvaluationCondition evaluationCondition, boolean isParameter,final int position) {
		TableItem item = new TableItem(jdtTable, SWT.NONE); // @jve
		ConditionValue conditionValue =(evaluationCondition != null)?evaluationCondition.getCondition(): null;
		item.setData(TYPE_DATA_KEY, type);
		
		Button checkButton=createCheckButton(item);
		checkButton.setData(isParameter);
		
		Label labelName =createLabelName(item);
		labelName.setText(name + " : " + Signature.toString(type)); // Arreglar //$NON-NLS-1$
		labelName.setData(name);
		
		ValueComposite compositeValue = createCompositeValue(item,conditionValue);

		CCombo combo=createComboBox(item, conditionValue,compositeValue);// @jve
		
		//Si es un parametro y ademas es del tipo Clase, se pueden especificar sus fields
		FieldComposite fieldComposite = null;
		if (isParameter && (Signature.getTypeSignatureKind(type) == Signature.CLASS_TYPE_SIGNATURE))
		{
			fieldComposite = (FieldComposite) createFieldComposite(item);
		}
		
		// Agrego los datos de la condition de evaluacion
		if (evaluationCondition != null)
		{
			checkButton.setSelection(true);
			if (evaluationCondition.getValue() != null)
			{
				compositeValue.setText(evaluationCondition.getValue());
			}
			if (fieldComposite != null)
			{
				fieldComposite.setEvaluationConditions(((ParameterEvaluationCondition)evaluationCondition).getFieldEvaluationConditions());
			}
			
			setItemSelected(item,true);
		}
		else
			setItemSelected(item,false);
		compositeValue=updateCompositeValue(combo);
	}
			
	@Override
	protected IMember getIMember()
	{
		return methodData.getDeclaringType();
	}
	
	public void showReturnedValue(ExecutionCondition executionCondition) throws JavaModelException {
		TableItem ti = new TableItem(jdtTable, SWT.NONE);// @jve
		ti.setBackground(new Color(Display.getDefault(), 255, 255, 255));
		addTableItem(methodData.getReturnType(),Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.ITypeParametersReturnValueComposite.returnedValue"), executionCondition.getReturnedValue(),false,-1); //$NON-NLS-1$
	}	
	
	private EvaluationCondition getParameterEvaluationCondition(int pos, ExecutionCondition executionCondition)
	{
		for(ParameterEvaluationCondition evaluationCondition : executionCondition.getParameters())
			if (evaluationCondition.getParameterPosition()==pos)
				return evaluationCondition;
		return null;			
	}
	
	public void fillExecutionCondition(ExecutionCondition newExecutionCondition)
	{
		int position = 0;
		for(TableItem ti : jdtTable.getItems())
		{
			Button checkBox=(Button)ti.getData(CHECK_BUTTON);
			if(checkBox!=null && checkBox.getSelection())
			{
				boolean isParameter = (Boolean)checkBox.getData();
				EvaluationCondition evaluationCondition;
				if(isParameter)
				{
					evaluationCondition = SemanticFactory.eINSTANCE.createParameterEvaluationCondition();
					((ParameterEvaluationCondition)evaluationCondition).setParameterPosition(position);
					
					FieldComposite fieldComposite = ((FieldComposite)ti.getData(COMPOSITE_FIELDS));
					if (fieldComposite != null)
					{
					
						List<FieldEvaluationCondition> fieldsEvaluations=fieldComposite.getEvaluationConditions();
						if (fieldsEvaluations!=null)
						{
							((ParameterEvaluationCondition)evaluationCondition).getFieldEvaluationConditions().addAll(fieldsEvaluations);
						}						
					}
					newExecutionCondition.getParameters().add((ParameterEvaluationCondition)evaluationCondition);
				}
				else
				{
					evaluationCondition = SemanticFactory.eINSTANCE.createReturnedValueEvaluationCondition();
					newExecutionCondition.setReturnedValue((ReturnedValueEvaluationCondition)evaluationCondition);
				}
				CCombo comboRole=(CCombo)ti.getData(COMBO_ROLE);
				evaluationCondition.setCondition((ConditionValue)comboRole.getData(String.valueOf(comboRole.getSelectionIndex())));
				evaluationCondition.setValue(((ValueComposite)ti.getData(COMPOSITE_VALUE)).getText());
			}
			position++;
		}
	}	
}