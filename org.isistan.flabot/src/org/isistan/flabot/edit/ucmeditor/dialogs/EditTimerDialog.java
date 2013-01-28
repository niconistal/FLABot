package org.isistan.flabot.edit.ucmeditor.dialogs;

import java.awt.TextField;
import java.util.Iterator;
import java.util.List;

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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.coremodel.TimerNode;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.messages.Messages;

/**
 * 
 * @author $Author: Martin Villalba $
 *
 */
public class EditTimerDialog extends Dialog {

	/**
	 * the dialog's shell
	 */
	private Shell shell = null;  //  @jve:decl-index=0:visual-constraint="10,9"
	
	TimerNode timer;
	
	private Text timerName = null;
	private Text timerDescription = null;	
	private Text timerTimeOut = null;
	private Combo unity = null;
	
	public EditTimerDialog(Shell parent, TimerNode timerNode) {
		super(parent, 0);
		this.timer = CoremodelFactory.eINSTANCE.createTimerNode(timerNode);
	}
	
	/**
	 * Creates and open a dialog for editing timer properties.
	 * 
	 * @param useCaseMaps the list of core model use case maps
	 * @param actualMap the actual use case map
	 * @return the modified stub
	 */
	public TimerNode open(final UseCaseMap actualMap) {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditTimerDialog.dialogTitle")); //$NON-NLS-1$
		shell.setLayout(new GridLayout(1, false));
		
		shell.addShellListener(new org.eclipse.swt.events.ShellAdapter() {				
			public void shellClosed(org.eclipse.swt.events.ShellEvent e) {
				handleCancel();
			}
		});	
		
		Group dependencyGroup = new Group(shell, SWT.NONE);
		dependencyGroup.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditTimerDialog.timerPropertiesGroup")); //$NON-NLS-1$
		
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		dependencyGroup.setLayout(layout);
		
		dependencyGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
				
		createTimerName(dependencyGroup);
		createTimerDescription(dependencyGroup);
		//createUseCaseMaps(dependencyGroup, useCaseMaps, families, actualMap, stub.getReferencedMap());
		
		GridLayout layoutTime = new GridLayout(3, false);
		Group timeGroup = new Group(dependencyGroup, SWT.NONE);
		timeGroup.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditTimerDialog.timePropertiesGroup")); //$NON-NLS-1$
		timeGroup.setLayout(layoutTime);
		
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;
		timeGroup.setLayoutData(gd);
		
		createTimerTimeOut(timeGroup);
		createTimerTimeOutUnity(timeGroup);
		
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
				            Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditTimerDialog.incompleteMessageTitle"), //$NON-NLS-1$
				            null,
				            Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditTimerDialog.incompleteMessageDescription")+errorMessage+" ", //$NON-NLS-1$ //$NON-NLS-2$
				            MessageDialog.ERROR,
				            new String[]{Messages.getString("org.isistan.flabot.edit.editor.okButton")}, //$NON-NLS-1$           
				            0);
					dlg.open();
				} else {
					setTimer(actualMap);
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
		shell.setSize(500, 240);
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
		return timer;
	}
	
	private void handleCancel() {
		timer = null;
        shell.dispose();
	}
	
	/**
	 * Creates a text box for the timer name
	 * 
	 * @param parent the composite parent
	 */
	private void createTimerName(Composite parent) {
		// Stub Name
		final Label label = new Label(parent, SWT.NONE);
		label.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditTimerDialog.timerName"));  //$NON-NLS-1$
		
		timerName = new Text(parent, SWT.BORDER);
		timerName.setText(timer.getTimerName());
		timerName.setLayoutData(new GridData(
					GridData.VERTICAL_ALIGN_BEGINNING |
					GridData.FILL_HORIZONTAL));
	}
	
	/**
	 * Creates a text box for the timer description
	 * 
	 * @param parent the composite parent
	 */
	private void createTimerDescription(Composite parent) {
		// Stub Name
		final Label label = new Label(parent, SWT.NONE);
		label.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditTimerDialog.description"));  //$NON-NLS-1$
		
		timerDescription = new Text(parent, SWT.BORDER);		
		timerDescription.setText(timer.getTimerDescription());
		timerDescription.setLayoutData(new GridData(
					GridData.VERTICAL_ALIGN_BEGINNING |
					GridData.FILL_HORIZONTAL));
	}
	
	/**
	 * Creates a text box for the time
	 * 
	 * @param parent the composite parent
	 */
	private void createTimerTimeOut(Composite parent) {
		// Stub Name
		final Label label = new Label(parent, SWT.NONE);
		label.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditTimerDialog.time"));  //$NON-NLS-1$
		
		timerTimeOut = new Text(parent, SWT.BORDER);
		timerTimeOut.setText(new Integer(timer.getTimerTimeOut()).toString());
		timerTimeOut.setLayoutData(new GridData(
					GridData.VERTICAL_ALIGN_BEGINNING |
					GridData.FILL_HORIZONTAL));
	}
	
	/**
	 * Creates a combo for the time out unity
	 * 
	 * @param parent the composite parent
	 */
	private void createTimerTimeOutUnity(Composite parent) {
		
		unity = new Combo(parent, SWT.READ_ONLY);
		
		unity.add("Hours", 0);
		unity.add("Minutes", 1);
		unity.add("Seconds", 2);
		
		unity.setText(timer.getTimerTimeOutUnity());
		unity.setLayoutData(new GridData(
					GridData.VERTICAL_ALIGN_BEGINNING |
					GridData.FILL_HORIZONTAL));
	}
	
	/**
	 * Sets the values for the copied timer.
	 *
	 */
	private void setTimer(UseCaseMap actualMap){		
		timer.setTimerName(timerName.getText());
		timer.setTimerDescription(timerDescription.getText());
		timer.setTimerTimeOut(new Integer(timerTimeOut.getText()).intValue());
		timer.setTimerTimeOutUnity(unity.getText());
		timer.setMap(actualMap);
		
	}
	
	
	/**
	 * Verifies that all the data needed for this timer is completed.
	 * @return a string with error messages, otherwise an empty string
	 */
	private String isValidEnd() {
		String valuesIncomplete = ""; //$NON-NLS-1$
		if (timerName.getText().equals("")){ //$NON-NLS-1$
			valuesIncomplete += "\n - ";
			valuesIncomplete += Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditTimerDialog.errorTimerName"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		
		if (timerTimeOut.getText().equals("")){ //$NON-NLS-1$
			valuesIncomplete += "\n - ";
			valuesIncomplete += Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditTimerDialog.errorTimerTimeOut"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		
		if (! validateIntInput()){ //$NON-NLS-1$
			valuesIncomplete += "\n - ";
			valuesIncomplete += Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditTimerDialog.errorTimerTimeOutFormat"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		
		if (timerDescription.getText().equals("")){ //$NON-NLS-1$
			valuesIncomplete += "\n - ";
			valuesIncomplete += Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditTimerDialog.errorTimerDescription"); //$NON-NLS-1$ //$NON-NLS-2$
		}
				
		return valuesIncomplete;
	}
	
	private boolean validateIntInput()
	{
		String string = timerTimeOut.getText();
		char[] chars = new char[string.length()];
        string.getChars(0, chars.length, chars, 0);
        for (int i = 0; i < chars.length; i++) {
          if (!('0' <= chars[i] && chars[i] <= '9')) {
            return false;
          }
        }
        return true;
	}
}
