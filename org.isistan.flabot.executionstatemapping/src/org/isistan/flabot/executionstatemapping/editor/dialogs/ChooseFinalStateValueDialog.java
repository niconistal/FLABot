package org.isistan.flabot.executionstatemapping.editor.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue;

public class ChooseFinalStateValueDialog extends Dialog {
	ExecutionStateValue executionStateValue;	
	
	/**
	 * the dialog's shell
	 */
	private Shell shell = null; // @jve:decl-index=0:visual-constraint="10,9"

	public ChooseFinalStateValueDialog(Shell parent) {
		super(parent, 0);
	}

	/**
	 * Makes the dialog visible.
	 * 
	 * @return
	 */
	public ExecutionStateValue open(String title, ExecutionStateValue oldValue) {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(Messages.getString("org.isistan.flabot.executionmapping.editor.dialogs.ChooseFinalStateValueDialog.finalStateCreation")); //$NON-NLS-1$
		shell.setLayout(new GridLayout(1, true));

		shell.addShellListener(new org.eclipse.swt.events.ShellAdapter() {
			@Override
			public void shellClosed(org.eclipse.swt.events.ShellEvent e) {
				handleCancel();
			}
		});

		Group renameGroup = new Group(shell, SWT.NONE);
		renameGroup.setText(title);
		renameGroup.setLayout(new GridLayout(2, false));
		renameGroup.setLayoutData(new GridData(GridData.FILL_BOTH));

		Label label = new Label(renameGroup, SWT.NULL);
		label.setText(Messages.getString("org.isistan.flabot.executionmapping.editor.dialogs.ChooseFinalStateValueDialog.finalStateValue")); //$NON-NLS-1$

		final Combo combo = new Combo(renameGroup, SWT.SINGLE | SWT.READ_ONLY);
		GridData gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING
				| GridData.FILL_HORIZONTAL);
		combo.setLayoutData(gd);
		
		int selectedIndex = 0;
		for(ExecutionStateValue value : ExecutionStateValue.getExecutionValues())
		{
			if (value.equals(oldValue))
				selectedIndex = combo.getItemCount();
			
			combo.add(value.getInternacionalizedName());
			combo.setData(String.valueOf(combo.getItemCount()-1), value);
		}		
		combo.select(selectedIndex);		

		// buttons composite (ok and cancel)
		Composite buttonsComposite = new Composite(shell, SWT.NONE);
		buttonsComposite.setLayout(new RowLayout());
		buttonsComposite.setLayoutData(new GridData(
				GridData.HORIZONTAL_ALIGN_CENTER));

		Button buttonOK = new Button(buttonsComposite, SWT.NONE);
		buttonOK.setText(Messages.getString("org.isistan.flabot.executionmapping.editor.dialogs.ChooseFinalStateValueDialog.okButton"));  //$NON-NLS-1$
		buttonOK.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				executionStateValue = (ExecutionStateValue) combo.getData(String.valueOf(combo.getSelectionIndex()));
				shell.dispose();
			}
		});
		
		Button buttonCancel = new Button(buttonsComposite, SWT.NONE);
		buttonCancel.setText(Messages.getString("org.isistan.flabot.executionmapping.editor.dialogs.ChooseFinalStateValueDialog.cancelButton"));  //$NON-NLS-1$
		buttonCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleCancel();
			}
		});

		shell.pack();
		Display display = getParent().getDisplay();
		Rectangle r = display.getClientArea();
		int centerX = r.width / 2 - shell.getSize().x / 2;
		int centerY = r.height / 2 - shell.getSize().y / 2;
		shell.setLocation(centerX, centerY);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		return executionStateValue;
	}
	
	private void handleCancel()
	{
		executionStateValue = null;
		shell.dispose();
	}
}