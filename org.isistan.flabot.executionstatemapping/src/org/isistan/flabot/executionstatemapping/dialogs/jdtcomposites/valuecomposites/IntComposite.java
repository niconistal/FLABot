package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites;

import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.isistan.flabot.executionstatemapping.messages.Messages;

public class IntComposite extends TextComposite {
	
	public IntComposite(Composite parent, int style)
	{
		super(parent, style);
	}
	
	private boolean isInt()
	{
		try
		{
			Integer.parseInt(getText());
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
		if (errors.size()==0 && !isInt())
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.valuecomposites.IntComposite.notInt")); //$NON-NLS-1$
		}
		return errors;
	}
	
}
