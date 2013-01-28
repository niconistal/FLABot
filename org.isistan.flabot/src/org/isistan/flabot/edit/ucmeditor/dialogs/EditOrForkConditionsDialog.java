/**
 * $Id: EditOrForkConditionsDialog.java,v 1.5 2006/04/01 03:44:31 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.dialogs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.ForkCondition;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.DefualtValidatorSorter;
import org.isistan.flabot.util.SorterToTable;

/**
 * Dialog that's used to edit the or fork properties
 *  
 * @author $Author: franco $
 *
 */
public class EditOrForkConditionsDialog extends Dialog {

	/**
	 * the dialog's shell
	 */
	private Shell shell = null;  //  @jve:decl-index=0:visual-constraint="10,9"
	
	int exitValue = SWT.CANCEL;
	
	private Text orForkName = null;
	private Table conditionTable = null;	
	private int activeConditionPosition = 0;
	
	private Text activeConditionName = null;
	private Text activeConditionCondition = null;	
	
	private String name = ""; //$NON-NLS-1$
	private Map modifiedConditions = new HashMap();	
	
	private ForkCondition activeCondition = null;	
	
	public EditOrForkConditionsDialog(Shell parent) {
		super(parent, 0);
	}
	
	/**
	 * Creates and open a dialog for editing or fork properties.
	 * 
	 * @param forkName the name of the or fork
	 * @param conditions the list of or fork conditions
	 * @return the exit value (SWT.OK/SWT.CANCEL)
	 */
	public int open(final String forkName, final List conditions) {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditOrForkConditionsDialog.dialogTitle")); //$NON-NLS-1$
		shell.setLayout(new GridLayout(1, false));
		
		shell.addShellListener(new org.eclipse.swt.events.ShellAdapter() {				
			public void shellClosed(org.eclipse.swt.events.ShellEvent e) {
				handleCancel();
			}
		});	
		
		Group dependencyGroup = new Group(shell, SWT.NONE);
		dependencyGroup.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditOrForkConditionsDialog.propertiesGroup")); //$NON-NLS-1$
		
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		dependencyGroup.setLayout(layout);
		
		dependencyGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		name = forkName;
		createOrForkName(dependencyGroup, forkName);
		
		Group pathGroup = new Group(dependencyGroup, SWT.NONE);
		pathGroup.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditOrForkConditionsDialog.conditionProperties")); //$NON-NLS-1$
		layout = new GridLayout(3, false);
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		dependencyGroup.setLayout(layout);
		
		pathGroup.setLayout(layout);
		
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;
		pathGroup.setLayoutData(gd);
		
		createConditionsTable(pathGroup, conditions);
		
		gd = new GridData(GridData.FILL_BOTH | GridData.VERTICAL_ALIGN_BEGINNING);
		gd.widthHint = 0;
		Label separator = new Label(pathGroup, SWT.NONE);
		separator.setLayoutData(gd);
		separator.setBackground(ColorConstants.black);		
		
		createConditionProperties(pathGroup);
		
		if (conditionTable.getItemCount() > 0) {
			conditionTable.select(0);
			updateCondition();
		}
		
		// buttons composite (ok and cancel)	
		Composite buttonsComposite = new Composite(shell, SWT.NONE);
		buttonsComposite.setLayout(new RowLayout());
		buttonsComposite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
		
		Button buttonOK = new Button(buttonsComposite, SWT.NONE);
		buttonOK.setText(Messages.getString("org.isistan.flabot.edit.editor.okButton")); //$NON-NLS-1$
		buttonOK.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {					
				name = orForkName.getText();
				checkChangedCondition(activeCondition);
				exitValue = SWT.OK;				
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
		
		return exitValue;
	}
	
	private void handleCancel() {
		exitValue = SWT.CANCEL;
		shell.dispose();
	}
	
		
	/**
	 * Creates a text box for the or fork name
	 * 
	 * @param parent the composite parent
	 * @param name the name of the or fork
	 */
	private void createOrForkName(Composite parent, String name) {
		// Or Fork Name
		final Label label = new Label(parent, SWT.NONE);
		label.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditOrForkConditionsDialog.orForkName"));  //$NON-NLS-1$
		
		orForkName = new Text(parent, SWT.BORDER);
		orForkName.setText(name);
		orForkName.setLayoutData(new GridData(
					GridData.VERTICAL_ALIGN_BEGINNING |
					GridData.FILL_HORIZONTAL));
	}
	
	/**
	 * Checks if the properties of the active conditions have changed compared with the real condition.
	 * 
	 * @param realCondition the old fork condition
	 */
	private void checkChangedCondition(ForkCondition realCondition) {
		if (realCondition!= null && (!realCondition.getName().equals(activeConditionName.getText()) ||
			!realCondition.getCondition().equals(activeConditionCondition.getText()) )) {
			ForkCondition newForkCondition = CoremodelFactory.eINSTANCE.createForkCondition();
			newForkCondition.setName(activeConditionName.getText());
			newForkCondition.setCondition(activeConditionCondition.getText());
			modifiedConditions.put(realCondition, newForkCondition);
		}
		
	}
	
	/**
	 * Returns the current condition. Checks with a hash table if the real condition was modified, in that case returns the modified one, if not returns the same condition.
	 * 
	 * @param condition the condition to check for changes
	 * @return the condition to show
	 */
	private ForkCondition getShowCondition(ForkCondition condition) {
		ForkCondition retCondition = (ForkCondition) modifiedConditions.get(condition);
		if (retCondition == null)
			return condition;
		return retCondition;
	}
		
	/**
	 * Updates the text boxs with the name and condition properties of the selected condition.
	 * 
	 * @param condition the selected condition
	 */
	private void updateConditionProperties(ForkCondition condition) {
		activeConditionName.setText(condition.getName());
		activeConditionCondition.setText(condition.getCondition());
	}
	
	public void createConditionsTable(Composite parent, List conditions) {
		Composite c = new Composite(parent, 0);
		c.setLayout(new GridLayout(1, false));		
		c.setLayoutData(new GridData(GridData.FILL_BOTH));	
				
		conditionTable = new Table(c, SWT.BORDER | SWT.MULTI
				| SWT.FULL_SELECTION);		
		GridData gd = new GridData(GridData.FILL_BOTH | GridData.VERTICAL_ALIGN_BEGINNING);
		gd.widthHint = 100;
		gd.heightHint = 100;
		conditionTable.setLayoutData(gd);	
		conditionTable.setHeaderVisible(true);
		
		final TableColumn tc1 = new TableColumn(conditionTable, SWT.LEFT);
		final SorterToTable sorter = new SorterToTable(conditionTable, new DefualtValidatorSorter(false,1));
		tc1.addListener(SWT.Selection, new Listener() {
			   public void handleEvent(Event e) {
				   sorter.setColumn(tc1);
				   sorter.reverseDirection();
				   sorter.order();
			   }
			        });
		tc1.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditOrForkConditionsDialog.conditionColumn")); //$NON-NLS-1$
		tc1.setWidth(115);
		
		conditionTable.addListener(SWT.Selection, new Listener() {
		    	public void handleEvent(Event e) {
		    		updateCondition();
		    	}
		});
		
		for(Iterator iter=conditions.iterator(); iter.hasNext();) {
			final ForkCondition condition = (ForkCondition) iter.next();
			final TableItem item = new TableItem(conditionTable, SWT.NONE);
		    item.setText(new String[] { condition.getName()});
		    item.setData(condition);
		}	
	}
	
	private void updateCondition() {
		TableItem[] items = conditionTable.getSelection();
		if (items.length == 1)	{		    		
			checkChangedCondition(activeCondition);
			ForkCondition condition = (ForkCondition) items[0].getData(); 
			activeCondition = condition;
			activeConditionPosition = conditionTable.getSelectionIndex();
			updateConditionProperties(getShowCondition(activeCondition));
		}
	}
	
	

	/***
	 * Creates two text boxs, one for the condition name and one for the condition properties. 
	 * 
	 * @param parent the composite parent
	 */
	private void createConditionProperties(Composite parent) {
		Composite c = new Composite(parent, 0);
		c.setLayout(new GridLayout(2, false));		
		c.setLayoutData(new GridData(GridData.FILL_BOTH));	
		
		final Label label1 = new Label(c, SWT.NONE);
		label1.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditOrForkConditionsDialog.conditionName")); //$NON-NLS-1$
		
		activeConditionName = new Text(c, SWT.BORDER);
		activeConditionName.setLayoutData(new GridData(
					GridData.VERTICAL_ALIGN_BEGINNING |
					GridData.FILL_HORIZONTAL));
		

		activeConditionName.addListener(SWT.Modify, new Listener() {
	    	public void handleEvent(Event event) {
	    		conditionTable.getItem(activeConditionPosition).setText(activeConditionName.getText());
			}
		});
		
		final Label label2 = new Label(c, SWT.NONE);
		label2.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditOrForkConditionsDialog.condition"));  //$NON-NLS-1$
		label2.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
		
		activeConditionCondition = new Text(c, SWT.MULTI | SWT.BORDER 
    			| SWT.V_SCROLL);
		GridData gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING |GridData.FILL_HORIZONTAL);
		gd.widthHint = 180;
		gd.heightHint = 100;
		activeConditionCondition.setLayoutData(gd);
		
		if (activeCondition != null)
			updateConditionProperties(getShowCondition(activeCondition));
	}
	
	public Map getModifyForkConditionsMap() {
		return modifiedConditions;
	}
	
	public String getNewName() {
		return name;
	}
}