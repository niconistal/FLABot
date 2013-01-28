package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.isistan.flabot.executionstatemapping.dialogs.utils.errors.Validator;

public abstract class ValueComposite extends Composite implements Validator {
	
	protected static final Font defaultFont= new Font(Display.getDefault(), "Tahoma", 8, SWT.BOLD); //$NON-NLS-1$
	protected boolean isEnabled;
	
	public ValueComposite(Composite parent, int style)
	{
		super(parent,style);
		createComposite();
	}

	
	protected abstract void createComposite();
	public abstract void setText(String text);
	public abstract String getText();
}
