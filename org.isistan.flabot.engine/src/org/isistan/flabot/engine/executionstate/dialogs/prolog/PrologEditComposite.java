/**
 * $Id: PrologEditComposite.java,v 1.5 2006/04/11 04:24:49 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs.prolog;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.PredefinedCondition;
import org.isistan.flabot.engine.messages.Messages;
import org.isistan.flabot.util.javalog.JavalogUtil;

/**
 * Reusable prolog editor
 * @author mblech
 *
 */
public class PrologEditComposite extends Composite {

	private Map<String, List<PredefinedCondition>> conditions;
	
	private Text prologTextComponent;
	
	public PrologEditComposite(Composite parent, int style, Map<String, List<PredefinedCondition>> conditions) {
		super(parent, style);
		this.setLayout(new GridLayout(2, false));
		this.conditions = conditions;					
		
		prologTextComponent = new Text(parent, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		prologTextComponent.setLayoutData(new GridData(250, 250));
		
		final Button buttonAdd = new Button(parent, SWT.PUSH);
		buttonAdd.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
		buttonAdd.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.PrologEditComposite.addConditionButton")); //$NON-NLS-1$
		buttonAdd.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {				
				RulesEditionDialog f = new RulesEditionDialog(Display.getCurrent().getActiveShell());
				String condition = f.open(getConditions());
				if (condition != null)
					insertCode(condition, f.getRequiredRules());
			}
		});
		
		Button checkPrologButton = new Button(parent, SWT.NONE);
		checkPrologButton.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.PrologEditComposite.checkPrologCodeButton")); //$NON-NLS-1$
		checkPrologButton.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				String diagnostic = validatePrologCode();
				if (diagnostic == null) {
					MessageDialog.openInformation(prologTextComponent.getShell(),
							Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.PrologEditComposite.prologCheckOKMessageTitle"), Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.PrologEditComposite.prologCheckOKMessageDescription")); //$NON-NLS-1$ //$NON-NLS-2$
				}
				else {
					MessageDialog.openError(prologTextComponent.getShell(),
							Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.PrologEditComposite.prologCheckErrorMessageTitle"), diagnostic); //$NON-NLS-1$
				}
			}
		});
		
		this.pack();
	}

	private void insertCode(String text, String[] requiredRules) {				
		StringBuffer sb = new StringBuffer();
		for (String rule :requiredRules) {
			if (getPrologTextComponent().getText().indexOf(rule) < 0)
				sb.append(rule + "\n\n" );
		}
		sb.append(text);
		getPrologTextComponent().insert(sb.toString());
	}
	
	private Map<String, List<PredefinedCondition>> getConditions() {
		return conditions;
	}
	
	/**
	 * @return Returns the prologText.
	 */
	public Text getPrologTextComponent() {
		return prologTextComponent;
	}
	
	/**
	 * Set the text content for the text component. The same as
	 * calling getPrologTextComponent().setText(prologCode).
	 * @param prologCode
	 */
	public void setText(String prologCode) {
		this.getPrologTextComponent().setText(prologCode);
	}
	
	/**
	 * Get the text editor's contents. Same as calling
	 * getPrologTextComponent().getText().
	 * @return
	 */
	public String getText() {
		return this.getPrologTextComponent().getText();
	}

	/**
	 * Insert the given prolog code at the current cursor position
	 * @param prologCode
	 */
	public void insertCode(String prologCode) {
		getPrologTextComponent().insert(prologCode);
	}

	/**
	 * Validate the current prolog code
	 * @return the diagnostic (null if ok)
	 */
	public String validatePrologCode() {
		return JavalogUtil.INSTANCE.validatePrologCode(prologTextComponent.getText());
	}
}