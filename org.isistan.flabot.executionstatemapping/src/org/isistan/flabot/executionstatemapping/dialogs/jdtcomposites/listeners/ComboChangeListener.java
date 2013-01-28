package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.listeners;

import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.JDTComposite;

public class ComboChangeListener implements SelectionListener{

	private CCombo comboRole=null;
	private JDTComposite jdtComposite;
	
	public ComboChangeListener( JDTComposite jdtComposite, CCombo comboRole)
	{
		this.comboRole=comboRole;
		this.jdtComposite=jdtComposite;
	}
	
	public void widgetDefaultSelected(SelectionEvent e) {
	}

	public void widgetSelected(SelectionEvent e) {
		jdtComposite.updateCompositeValue(comboRole);
	}

}
