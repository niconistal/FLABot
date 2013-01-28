package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites;

import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.isistan.flabot.executionstatemapping.messages.Messages;

public class DoubleComposite extends TextComposite {
	
	public DoubleComposite(Composite parent, int style)
	{
		super(parent, style);
	}
	private boolean isDouble()
	{
		try
		{
			Double.parseDouble(getText());
			return true;
		}catch(NumberFormatException e)
		{
			return false;
		}
		
	}
	@Override
	public List<String> getErrors()
	{
		List<String> errors=super.getErrors();
		if (errors.size()==0 && !isDouble())
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.valuecomposites.DoubleComposite.notNumber")); //$NON-NLS-1$
		}
		return errors;
	}
	
}
