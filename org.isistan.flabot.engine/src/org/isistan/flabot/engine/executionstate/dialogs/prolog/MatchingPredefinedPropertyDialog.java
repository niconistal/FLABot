/**
 * $Id: MatchingPredefinedPropertyDialog.java,v 1.3 2006/04/10 21:55:02 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs.prolog;

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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.PredefinedCondition;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.properties.StringMatchingPredefinedProperty;
import org.isistan.flabot.engine.messages.Messages;

/**
 * @author usuario
 *
 */
public class MatchingPredefinedPropertyDialog extends Dialog {
	
	/**
	 * the dialog's shell
	 */
	private Shell shell = null;  //  @jve:decl-index=0:visual-constraint="10,9"	
	
	protected StringMatchingPredefinedProperty predefinedProperty;
	
	private Text matchingText;
	
	private Button[] matchingTypeButtons = new Button[3];
	
	private Button negativeValue;
	
	/**
	 * @param parent
	 */
	public MatchingPredefinedPropertyDialog(Shell parent) {
		super(parent, 0);
	}
	/**
	 * Makes the dialog visible.
	 * 
	 * @return
	 */
	public PredefinedCondition open(StringMatchingPredefinedProperty predefinedProperty) {
		if (predefinedProperty == null)
			predefinedProperty = new StringMatchingPredefinedProperty(""); //$NON-NLS-1$
		this.predefinedProperty = predefinedProperty;
		
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.MatchingPredefinedPropertyDialog.tabName")); //$NON-NLS-1$
		shell.setLayout(new GridLayout(1, true));		
		
		shell.addShellListener(new org.eclipse.swt.events.ShellAdapter() {				
			public void shellClosed(org.eclipse.swt.events.ShellEvent e) {
				handleCancel();
			}
		});
		
		createMatchingGroup(shell);
		
		// buttons composite (ok and cancel)	
		Composite buttonsComposite = new Composite(shell, SWT.NONE);
		buttonsComposite.setLayout(new RowLayout());
		buttonsComposite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
	
		Button buttonOK = new Button(buttonsComposite, SWT.NONE);
		buttonOK.setText(Messages.getString("org.isistan.flabot.edit.editor.okButton")); //$NON-NLS-1$
		buttonOK.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleOk();
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
		return predefinedProperty;
	}
	
	private void createMatchingGroup(Composite c) {
		Group propertyGroup = new Group(c, SWT.CHECK);
		propertyGroup.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.MatchingPredefinedPropertyDialog.matchingGroup")); //$NON-NLS-1$
		
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		
		propertyGroup.setLayout(layout);		
		propertyGroup.setLayoutData(new GridData(GridData.FILL_BOTH));		
		
		Label matchingLabel = new Label(propertyGroup, SWT.NULL);
		matchingLabel.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));

		matchingLabel.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.MatchingPredefinedPropertyDialog.matchWithLabel"));			 //$NON-NLS-1$
		
		matchingText = new Text(propertyGroup, SWT.BORDER);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.widthHint = 150;
		matchingText.setLayoutData(gd);
		matchingText.setText(predefinedProperty.getFieldValue());
		
		
		Group matchingGroup = new Group(c, SWT.CHECK);
		matchingGroup.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.MatchingPredefinedPropertyDialog.matchingTecnicGroup")); //$NON-NLS-1$
		
		layout = new GridLayout(1, false);
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		
		matchingGroup.setLayout(layout);		
		matchingGroup.setLayoutData(new GridData(GridData.FILL_BOTH));	
		
		matchingTypeButtons[0] = new Button(matchingGroup, SWT.RADIO);
		matchingTypeButtons[0].setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.MatchingPredefinedPropertyDialog.fullMatching")); //$NON-NLS-1$
		matchingTypeButtons[0].setData(StringMatchingPredefinedProperty.FULL_MATCHING);
		matchingTypeButtons[0].setSelection(StringMatchingPredefinedProperty.FULL_MATCHING.equals(predefinedProperty.getMatchingStringType()));
		
		matchingTypeButtons[1] = new Button(matchingGroup, SWT.RADIO);
		matchingTypeButtons[1].setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.MatchingPredefinedPropertyDialog.substringMatching")); //$NON-NLS-1$
		matchingTypeButtons[1].setData(StringMatchingPredefinedProperty.SUBSTRING_MATCHING);
		matchingTypeButtons[1].setSelection(StringMatchingPredefinedProperty.SUBSTRING_MATCHING.equals(predefinedProperty.getMatchingStringType()));
		
		matchingTypeButtons[2] = new Button(matchingGroup, SWT.RADIO);
		matchingTypeButtons[2].setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.MatchingPredefinedPropertyDialog.regularExpresionMatching")); //$NON-NLS-1$
		matchingTypeButtons[2].setData(StringMatchingPredefinedProperty.REGEX_MATCHING);
		matchingTypeButtons[2].setSelection(StringMatchingPredefinedProperty.REGEX_MATCHING.equals(predefinedProperty.getMatchingStringType()));
		
		negativeValue = new Button(c, SWT.CHECK);
		negativeValue.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.MatchingPredefinedPropertyDialog.negativeMatching")); //$NON-NLS-1$
		negativeValue.setSelection(predefinedProperty.isNegative());
	}
	
	private void handleCancel() {
		predefinedProperty = null;
		shell.dispose();		
	}
	
	private void handleOk() {		
		predefinedProperty.setFieldValue(matchingText.getText());
		for (Button button : matchingTypeButtons) {
			if (button.getSelection())
				predefinedProperty.setMatchingStringType((String) button.getData());
		}
		predefinedProperty.setNegative(negativeValue.getSelection());
		shell.dispose();
	}
}