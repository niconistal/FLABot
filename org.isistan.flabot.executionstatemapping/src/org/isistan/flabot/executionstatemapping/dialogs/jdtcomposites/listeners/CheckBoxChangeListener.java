package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.listeners;

import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableItem;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.JDTComposite;

public class CheckBoxChangeListener implements SelectionListener{

	private JDTComposite jdtComposite;
	private TableItem tableItem;
	private Button checkButton;
	
	public CheckBoxChangeListener(JDTComposite jdtComposite, TableItem tableItem,Button checkButton)
	{
		this.jdtComposite=jdtComposite;
		this.tableItem=tableItem;
		this.checkButton=checkButton;
	}
	
	public void widgetDefaultSelected(SelectionEvent e) {
	}

	public void widgetSelected(SelectionEvent e) {
		jdtComposite.checkButtonAction(tableItem,checkButton);
		jdtComposite.updateCompositeValue((CCombo)tableItem.getData(JDTComposite.COMBO_ROLE));
	}

}
