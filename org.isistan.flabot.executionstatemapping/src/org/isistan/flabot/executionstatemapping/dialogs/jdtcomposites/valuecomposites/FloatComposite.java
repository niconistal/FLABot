package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites;

import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.isistan.flabot.executionstatemapping.messages.Messages;

public class FloatComposite extends TextComposite {
	
	public FloatComposite(Composite parent, int style)
	{
		super(parent, style);
	}
	
	private boolean isFloat()
	{
		try
		{
			Float.parseFloat(getText());
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
		if (errors.size()==0 && !isFloat())
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.valuecomposites.FloatComposite.notFloat")); //$NON-NLS-1$
		}
		return errors;
	}
	
}
