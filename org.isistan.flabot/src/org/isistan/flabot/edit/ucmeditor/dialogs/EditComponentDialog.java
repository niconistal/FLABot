package org.isistan.flabot.edit.ucmeditor.dialogs;

import org.eclipse.jface.dialogs.MessageDialog;
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
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.TimerNode;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.messages.Messages;

/**
 * 
 * @author $Author: Martin Villalba $
 *
 */
public class EditComponentDialog extends Dialog {

	/**
	 * the dialog's shell
	 */
	private Shell shell = null;  //  @jve:decl-index=0:visual-constraint="10,9"
	
	ComponentModel component;
	
	private Text componentName = null;
	
	public EditComponentDialog(Shell parent, ComponentModel componentModel) {
		super(parent, 0);
		this.component = componentModel;
	}
	
	/**
	 * Creates and open a dialog for editing timer properties.
	 * 
	 * @param useCaseMaps the list of core model use case maps
	 * @param actualMap the actual use case map
	 * @return the modified stub
	 */
	public ComponentModel open() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditComponentDialog.dialogTitle")); //$NON-NLS-1$
		shell.setLayout(new GridLayout(1, false));
		
		shell.addShellListener(new org.eclipse.swt.events.ShellAdapter() {				
			public void shellClosed(org.eclipse.swt.events.ShellEvent e) {
				handleCancel();
			}
		});	
		
		Group dependencyGroup = new Group(shell, SWT.NONE);
		//dependencyGroup.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditTimerDialog.timerPropertiesGroup")); //$NON-NLS-1$
		
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		dependencyGroup.setLayout(layout);
		
		dependencyGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
				
		createComponentName(dependencyGroup);
		//createUseCaseMaps(dependencyGroup, useCaseMaps, families, actualMap, stub.getReferencedMap());
		
		// buttons composite (ok and cancel)	
		Composite buttonsComposite = new Composite(shell, SWT.NONE);
		buttonsComposite.setLayout(new RowLayout());
		buttonsComposite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
		
		Button buttonOK = new Button(buttonsComposite, SWT.NONE);
		buttonOK.setText(Messages.getString("org.isistan.flabot.edit.editor.okButton")); //$NON-NLS-1$
		buttonOK.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				String errorMessage = isValidEnd();
				if (!errorMessage.equals("")) { //$NON-NLS-1$
					MessageDialog dlg = new MessageDialog(
							shell,
				            Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditComponentDialog.incompleteMessageTitle"), //$NON-NLS-1$
				            null,
				            Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditComponentDialog.incompleteMessageDescription")+errorMessage+" ", //$NON-NLS-1$ //$NON-NLS-2$
				            MessageDialog.ERROR,
				            new String[]{Messages.getString("org.isistan.flabot.edit.editor.okButton")}, //$NON-NLS-1$           
				            0);
					dlg.open();
				} else {
					setComponent();
					shell.dispose();
				}
			}
		});
		
		Button buttonCancel = new Button(buttonsComposite, SWT.NONE);
		buttonCancel.setText(Messages.getString("org.isistan.flabot.edit.editor.cancelButton")); //$NON-NLS-1$
		buttonCancel.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleCancel();
			}
		});				

		//shell.pack();
		shell.setSize(400, 115);
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
		return component;
	}
	
	private void handleCancel() {
		component = null;
        shell.dispose();
	}
	
	/**timer
	 * Creates a text box for the component name
	 * 
	 * @param parent the composite parent
	 */
	private void createComponentName(Composite parent) {
		// Stub Name
		final Label label = new Label(parent, SWT.NONE);
		label.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditComponentDialog.timerName"));  //$NON-NLS-1$
		
		componentName = new Text(parent, SWT.BORDER);
		componentName.setText(component.getName());
		componentName.setLayoutData(new GridData(
					GridData.VERTICAL_ALIGN_BEGINNING |
					GridData.FILL_HORIZONTAL));
	}
	
	/**
	 * Sets the values for the copied timer.
	 *
	 */
	private void setComponent(){		
		component.setName(componentName.getText());		
	}
	
	
	/**
	 * Verifies that all the data needed for this component is completed.
	 * @return a string with error messages, otherwise an empty string
	 */
	private String isValidEnd() {
		String valuesIncomplete = ""; //$NON-NLS-1$
		if (componentName.getText().equals("")){ //$NON-NLS-1$
			valuesIncomplete += "\n - ";
			valuesIncomplete += Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditComponentDialog.errorTimerName"); //$NON-NLS-1$ //$NON-NLS-2$
		}
				
		return valuesIncomplete;
	}

}
