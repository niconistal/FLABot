package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.executionstatemapping.messages.Messages;

public abstract class TextComposite extends ValueComposite {

	private Text valueText; 
	
	public TextComposite(Composite parent, int style)
	{
		super(parent, style);
	}
	
	@Override
	protected void createComposite()
	{
		GridLayout gdl = new GridLayout();
		gdl.horizontalSpacing = 0;
		gdl.verticalSpacing = 0;
		gdl.marginWidth =0;
		gdl.marginHeight =0;
		this.setLayout(gdl);		
		valueText=new Text(this, SWT.None);
		valueText.setText(""); //$NON-NLS-1$
		valueText.setBackground(ColorConstants.white);						
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.grabExcessHorizontalSpace = true;
		valueText.setLayoutData(gd);
	}
	
	@Override
	public void setText(String text)
	{
		valueText.setText(text);
	}
	
	@Override
	public String getText()
	{
		return valueText.getText();
	}
	
	
	public List<String> getErrors()
	{
		List<String> errors=new ArrayList<String>();
		if (valueText.isEnabled() &&  getText().length()==0)
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.valuecomposites.TextComposite.valueEmpty")); //$NON-NLS-1$
		}
		return errors;
	}
	
	//@override
	@Override
	public void setEnabled(boolean state)
	{
		valueText.setEnabled(state);
		valueText.setBackground(state?ColorConstants.white:ColorConstants.lightGray);
		//super.setEnabled(state);
	}
	
	
}
