package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites;

import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.isistan.flabot.executionstatemapping.messages.Messages;

public class LongComposite extends TextComposite {
	
	public LongComposite(Composite parent, int style)
	{
		super(parent, style);
	}
	
	private boolean isLong()
	{
		try
		{
			Long.parseLong(getText());
			return true;
		}catch(NumberFormatException e)
		{
			return false;
		}
		
	}
	public List<String> getError()
	{
		List<String> errors=super.getErrors();
		if (errors.size()==0 && !isLong())
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.valuecomposites.LongComposite.notLong")); //$NON-NLS-1$
		}
		return errors;
	}
	
}
