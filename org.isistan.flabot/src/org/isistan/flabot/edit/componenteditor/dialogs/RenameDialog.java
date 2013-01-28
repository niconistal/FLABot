/**
 * $Id: RenameDialog.java,v 1.16 2006/03/17 02:31:50 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.dialogs;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.messages.Messages;

/**
 * This dialog is used when it is necessary to name/rename some value.
 * 
 * 
 * @author $Author: franco $
 *
 */
public class RenameDialog extends Dialog {
	String name;
	
	/**
	 * the dialog's shell
	 */
	private Shell shell = null;  //  @jve:decl-index=0:visual-constraint="10,9"
	
	public RenameDialog(Shell parent) {
		super(parent, 0);
	}


	/** 
	 * Makes the dialog visible.
	 * 
	 * @return
	 */
	public String open(String title, String rename, String oldValue) {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.RenameDialog.title")); //$NON-NLS-1$
		shell.setLayout(new GridLayout(1, true));
		
		shell.addShellListener(new org.eclipse.swt.events.ShellAdapter() {				
			public void shellClosed(org.eclipse.swt.events.ShellEvent e) {
				handleCancel();
			}
		});
		
		Group renameGroup = new Group(shell, SWT.NONE);
		renameGroup.setText(title);
		renameGroup.setLayout(new GridLayout(2, false));		
		renameGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label label = new Label(renameGroup, SWT.NULL);
		label.setText(rename);
		
		final Text text = new Text(renameGroup, SWT.SINGLE | SWT.BORDER);
		GridData gd = new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL);
		gd.widthHint = 200;
		text.setLayoutData(gd);
		text.setText(oldValue);
		text.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				name = new String(text.getText());
			}
		});
		
		// buttons composite (ok and cancel)	
		Composite buttonsComposite = new Composite(shell, SWT.NONE);
		buttonsComposite.setLayout(new RowLayout());
		buttonsComposite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
		
		Button buttonOK = new Button(buttonsComposite, SWT.NONE);
		buttonOK.setText(Messages.getString("org.isistan.flabot.edit.editor.okButton")); //$NON-NLS-1$
		buttonOK.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (name == null || name.trim().equals("")) { //$NON-NLS-1$
					MessageDialog.openError(shell, Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.RenameDialog.title"), //$NON-NLS-1$
							Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.RenameDialog.invalidName")); //$NON-NLS-1$
					return;
				}
				shell.dispose();
			}
		});
		Button buttonCancel = new Button(buttonsComposite, SWT.NONE);
		buttonCancel.setText(Messages.getString("org.isistan.flabot.edit.editor.cancelButton")); //$NON-NLS-1$
		buttonCancel.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleCancel();
			}
		});				

		shell.pack();
		Display display = getParent().getDisplay();		
		Rectangle r = display.getClientArea();
		int centerX = r.width/2 - shell.getSize().x / 2;
		int centerY = r.height/2 - shell.getSize().y / 2;
		shell.setLocation(centerX, centerY);		
		shell.open();		
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		return name;
	}
	
	private void handleCancel() {
		name = null;
		shell.dispose();
	}
}