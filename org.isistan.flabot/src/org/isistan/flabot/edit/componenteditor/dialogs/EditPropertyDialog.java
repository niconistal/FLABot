/**
 * $Id: EditPropertyDialog.java,v 1.13 2006/03/17 02:31:50 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.dialogs;

import java.util.Map;

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

public class EditPropertyDialog extends Dialog {

	String oldName = new String(); 
	
	String[] data = new String[2]; 

	/**
	 * the dialog's shell
	 */
	private Shell shell = null;  //  @jve:decl-index=0:visual-constraint="10,9"		
	
	/**
	 * @param parent
	 */
	public EditPropertyDialog(Shell parent) {
		super(parent, 0);
		data[0] = ""; //$NON-NLS-1$
		data[1] = ""; //$NON-NLS-1$
		this.oldName = new String();
	}

	/**
	 * @param parent
	 * @param style
	 */
	public EditPropertyDialog(Shell parent, String[] data) {
		super(parent);
		this.data = data;
		this.oldName = new String(data[0]);
	}

	/**
	 * Makes the dialog visible.
	 * 
	 * @return
	 */
	public String[] open(final Map properties) {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialog.EditPropertyDialog.title")); //$NON-NLS-1$
		shell.setLayout(new GridLayout(1, true));		
		
		shell.addShellListener(new org.eclipse.swt.events.ShellAdapter() {				
			public void shellClosed(org.eclipse.swt.events.ShellEvent e) {
				handleCancel();
			}
		});
		
		Group propertyGroup = new Group(shell, SWT.NONE);
		propertyGroup.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialog.EditPropertyDialog.group")); //$NON-NLS-1$
		
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		
		propertyGroup.setLayout(layout);		
		propertyGroup.setLayoutData(new GridData(GridData.FILL_BOTH));		
		
		final Label name = new Label(propertyGroup, SWT.NULL);
		name.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialog.EditPropertyDialog.propertyName")); //$NON-NLS-1$
		
		final Text nametext = new Text(propertyGroup, SWT.SINGLE | SWT.BORDER);
		GridData gd = new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL);
		gd.widthHint = 150;		
		nametext.setLayoutData(gd);
		nametext.setText(data[0]);
		nametext.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				data[0]= nametext.getText();
			}
		});
    
		final Label value = new Label(propertyGroup, SWT.NULL);
		value.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialog.EditPropertyDialog.propertyValue")); //$NON-NLS-1$
    
		final Text valuetext = new Text(propertyGroup, SWT.SINGLE | SWT.BORDER);			
		gd = new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL);
		gd.widthHint = 150;		
		valuetext.setLayoutData(gd);		
		valuetext.setText(data[1]);
		valuetext.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				data[1]= valuetext.getText();
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
				handleOk(properties);
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
		
		return data;
	}
	
	private void handleCancel() {
		data[0] = null;
		data[1] = null;
		shell.dispose();
	}
	
	private void handleOk(Map properties) {
		if (data[0] == null || data[0].equals("")) { //$NON-NLS-1$
			MessageDialog.openError(shell, Messages.getString("org.isistan.flabot.edit.componenteditor.dialog.EditPropertyDialog.title"), //$NON-NLS-1$
					Messages.getString("org.isistan.flabot.edit.componenteditor.dialog.EditPropertyDialog.propertyMustHaveName")); //$NON-NLS-1$
			return;
		}
		if(!data[0].equals(oldName) && properties.get(data[0]) != null) {
			MessageDialog.openError(shell, Messages.getString("org.isistan.flabot.edit.componenteditor.dialog.EditPropertyDialog.title"), //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.edit.componenteditor.dialog.EditPropertyDialog.propertyNameCannotBeRepeated")); //$NON-NLS-1$
			return;
		}		
		shell.dispose();
	}
}