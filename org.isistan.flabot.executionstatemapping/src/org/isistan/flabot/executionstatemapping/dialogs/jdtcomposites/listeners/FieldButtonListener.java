package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.listeners;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.TableItem;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.JDTComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites.FieldComposite;

public class FieldButtonListener implements SelectionListener{

	private JDTComposite jdtComposite;
	private FieldComposite fieldComposite;
	private TableItem tableItem;
	
	public FieldButtonListener(JDTComposite jdtComposite, TableItem tableItem, FieldComposite fieldComposite)
	{
		this.fieldComposite=fieldComposite;
		this.tableItem=tableItem;
		this.jdtComposite=jdtComposite;
	}
	
	public void widgetDefaultSelected(SelectionEvent e) {
	}

	public void widgetSelected(SelectionEvent e) {
		jdtComposite.fieldClickAction(tableItem, fieldComposite);		
	}

}