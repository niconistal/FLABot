package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.combocontentproviders;

import org.eclipse.swt.custom.CCombo;
import org.isistan.flabot.executionstatemapping.model.semantic.ConditionValue;

public class ComboNumericVarProvider implements ComboContentProvider {

	
	public void fillCombo(CCombo comboRole,ConditionValue selectedConditionValue) {
		
		comboRole.setData("0",ConditionValue.EQUAL); //$NON-NLS-1$
		comboRole.add(ComboConstants.EQUAL);
		comboRole.setData("1",ConditionValue.NOT_EQUAL); //$NON-NLS-1$
		comboRole.add(ComboConstants.NOT_EQUAL);
		comboRole.setData("2",ConditionValue.GREATER); //$NON-NLS-1$
		comboRole.add(ComboConstants.GREATER);
		comboRole.setData("3",ConditionValue.GREATER_EQUAL); //$NON-NLS-1$
		comboRole.add(ComboConstants.GREATER_EQUAL);
		comboRole.setData("4",ConditionValue.LOWER); //$NON-NLS-1$
		comboRole.add(ComboConstants.LOWER);
		comboRole.setData("5",ConditionValue.LOWER_EQUAL); //$NON-NLS-1$
		comboRole.add(ComboConstants.LOWER_EQUAL);
		if(selectedConditionValue!=null)
		{
			switch(selectedConditionValue.getValue())
			{
				case ConditionValue.EQUAL_VALUE: comboRole.select(0); break;
				case ConditionValue.NOT_EQUAL_VALUE:comboRole.select(1);break;
				case ConditionValue.GREATER_VALUE:comboRole.select(2);break;
				case ConditionValue.GREATER_EQUAL_VALUE:comboRole.select(3);break;
				case ConditionValue.LOWER_VALUE:comboRole.select(4);break;
				case ConditionValue.LOWER_EQUAL_VALUE:comboRole.select(5);break;
			}
		}
		else
			comboRole.select(0);
	}
	

}
