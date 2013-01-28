package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.combocontentproviders;

import org.eclipse.swt.custom.CCombo;
import org.isistan.flabot.executionstatemapping.model.semantic.ConditionValue;

public class ComboGeneralVarProvider implements ComboContentProvider {

	public void fillCombo(CCombo comboRole,ConditionValue selectedConditionValue) {
		
		comboRole.setData("0",ConditionValue.NOT_NULL); //$NON-NLS-1$
		comboRole.add(ComboConstants.NOT_NULL);
		comboRole.setData("1",ConditionValue.IS_NULL); //$NON-NLS-1$
		comboRole.add(ComboConstants.IS_NULL);		
		comboRole.setData("2",ConditionValue.IS_CLASS); //$NON-NLS-1$
		comboRole.add(ComboConstants.IS_CLASS);
		comboRole.setData("3",ConditionValue.NOT_IS_CLASS); //$NON-NLS-1$
		comboRole.add(ComboConstants.NOT_CLASS);
		comboRole.setData("4",ConditionValue.CONTAINS); //$NON-NLS-1$
		comboRole.add(ComboConstants.CONTAINS);
		comboRole.setData("5",ConditionValue.NOT_CONTAINS); //$NON-NLS-1$
		comboRole.add(ComboConstants.NOT_CONTAINS);
		comboRole.setData("6",ConditionValue.EQUAL); //$NON-NLS-1$
		comboRole.add(ComboConstants.EQUAL);
		comboRole.setData("7",ConditionValue.NOT_EQUAL); //$NON-NLS-1$
		comboRole.add(ComboConstants.NOT_EQUAL);
		comboRole.setData("8",ConditionValue.GREATER); //$NON-NLS-1$
		comboRole.add(ComboConstants.GREATER);
		comboRole.setData("9",ConditionValue.GREATER_EQUAL); //$NON-NLS-1$
		comboRole.add(ComboConstants.GREATER_EQUAL);
		comboRole.setData("10",ConditionValue.LOWER); //$NON-NLS-1$
		comboRole.add(ComboConstants.LOWER);
		comboRole.setData("11",ConditionValue.LOWER_EQUAL); //$NON-NLS-1$
		comboRole.add(ComboConstants.LOWER_EQUAL);
		
		if(selectedConditionValue!=null)
		{
			switch(selectedConditionValue.getValue())
			{
				case ConditionValue.NOT_NULL_VALUE:comboRole.select(0);break;	
				case ConditionValue.IS_NULL_VALUE: comboRole.select(1); break;				
				case ConditionValue.IS_CLASS_VALUE:comboRole.select(2);break;
				case ConditionValue.NOT_IS_CLASS_VALUE:comboRole.select(3);break;
				case ConditionValue.CONTAINS_VALUE:comboRole.select(4);break;
				case ConditionValue.NOT_CONTAINS_VALUE:comboRole.select(5);break;
				case ConditionValue.EQUAL_VALUE:comboRole.select(6);break;
				case ConditionValue.NOT_EQUAL_VALUE:comboRole.select(7);break;
				case ConditionValue.GREATER_VALUE:comboRole.select(8);break;
				case ConditionValue.GREATER_EQUAL_VALUE:comboRole.select(9);break;
				case ConditionValue.LOWER_VALUE:comboRole.select(10);break;
				case ConditionValue.LOWER_EQUAL_VALUE:comboRole.select(11);break;
			}
		}
		else
			comboRole.select(0);
	}
}
