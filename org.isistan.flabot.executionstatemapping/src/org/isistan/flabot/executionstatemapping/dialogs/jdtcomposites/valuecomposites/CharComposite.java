package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites;

import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.isistan.flabot.executionstatemapping.messages.Messages;

public class CharComposite extends TextComposite {
	
	public CharComposite(Composite parent, int style)
	{
		super(parent, style);
	}
	
	@Override
	public List<String> getErrors()
	{
		List<String> errors=super.getErrors();
		if (errors.size()==0 && getText().length()>1)
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.valuecomposites.CharComposite.notChar")); //$NON-NLS-1$
		}
		return errors;
	}
	
}
