package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.combocontentproviders;

import org.eclipse.swt.custom.CCombo;
import org.isistan.flabot.executionstatemapping.model.semantic.ConditionValue;

public class ComboBooleanVarProvider implements ComboContentProvider {

	public void fillCombo(CCombo comboRole,ConditionValue selectedConditionValue) {
		comboRole.setData("0",ConditionValue.EQUAL); //$NON-NLS-1$
		comboRole.add(ComboConstants.EQUAL);
		comboRole.setData("1",ConditionValue.NOT_EQUAL); //$NON-NLS-1$
		comboRole.add(ComboConstants.NOT_EQUAL);
		if(selectedConditionValue!=null)
			comboRole.select((selectedConditionValue.getValue()==ConditionValue.EQUAL_VALUE)?0:1);
		else
			comboRole.select(0);
	}

}
