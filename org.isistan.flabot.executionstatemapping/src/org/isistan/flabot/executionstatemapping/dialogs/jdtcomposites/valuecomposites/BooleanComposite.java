package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.isistan.flabot.executionstatemapping.messages.Messages;

public class BooleanComposite extends ValueComposite {
	protected CCombo comboRole;
	public BooleanComposite(Composite parent,int style)
	{
		super(parent,style);
	}
	
	@Override
	protected void createComposite() {
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.verticalAlignment = GridData.FILL;
		comboRole = new CCombo(this, SWT.READ_ONLY); // @jve
		comboRole.setBackground(ColorConstants.white);
		comboRole.setLayoutData(gridData);
		GridLayout layout=new GridLayout();
		layout.marginHeight=0;
		layout.marginWidth=0;
		this.setLayout(layout);
		comboRole.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.valuecomposites.BooleanComposite.trueUpper")); //$NON-NLS-1$
		comboRole.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.valuecomposites.BooleanComposite.falseUpper")); //$NON-NLS-1$
		comboRole.select(0);
	}
	
	@Override
	public void setText(String text)
	{
		String lowerCaseString=text.toLowerCase();
		if (lowerCaseString==Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.valuecomposites.BooleanComposite.true")) //$NON-NLS-1$
			comboRole.select(0);
		else if (lowerCaseString==Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.valuecomposites.BooleanComposite.false")) //$NON-NLS-1$
			comboRole.select(1);	
	}
	
	@Override
	public String getText()
	{
		return comboRole.getSelectionIndex()==0?Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.valuecomposites.BooleanComposite.true"):Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.valuecomposites.BooleanComposite.false"); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	public List<String> getErrors()
	{
		return new ArrayList<String>();
	}
	
	//@override
	@Override
	public void setEnabled(boolean state)
	{
		comboRole.setEnabled(state);
		super.setEnabled(state);
	}

}
