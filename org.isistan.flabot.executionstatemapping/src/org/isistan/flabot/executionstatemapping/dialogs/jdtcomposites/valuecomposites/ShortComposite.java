package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites;

import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.isistan.flabot.executionstatemapping.messages.Messages;

public class ShortComposite extends TextComposite {
	
	public ShortComposite(Composite parent, int style)
	{
		super(parent, style);
	}
	
	private boolean isShort()
	{
		try
		{
			Short.parseShort(getText());
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
		if (errors.size()==0 && !isShort())
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.valuecomposites.ShortComposite.valueNotShort")); //$NON-NLS-1$
		}
		return errors;
	}
	
}
