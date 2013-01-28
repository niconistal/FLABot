package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.listeners;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.TableItem;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.JDTComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites.ValueComposite;

public class ClassOfListener implements SelectionListener {

	private JDTComposite jdtComposite;
	private TableItem tableItem;
	private ValueComposite valueComposite;
	private boolean fromHierarchy;
	
	public ClassOfListener(JDTComposite jdtComposite, TableItem tableItem,ValueComposite valueComposite,boolean fromHierarchy)
	{
		this.jdtComposite=jdtComposite;
		this.tableItem=tableItem;
		this.valueComposite=valueComposite;
		this.fromHierarchy=fromHierarchy;
	}
	
	public void widgetDefaultSelected(SelectionEvent e) {
	}

	public void widgetSelected(SelectionEvent e) {
		jdtComposite.classOfAction(tableItem,valueComposite,fromHierarchy);
	}

}
