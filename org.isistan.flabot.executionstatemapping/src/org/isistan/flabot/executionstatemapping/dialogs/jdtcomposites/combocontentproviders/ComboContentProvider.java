package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.combocontentproviders;

import org.eclipse.swt.custom.CCombo;
import org.isistan.flabot.executionstatemapping.model.semantic.ConditionValue;

public interface ComboContentProvider{

	public void fillCombo(CCombo comboRole,ConditionValue selectedConditionValue);
	
}
