/**
 * $Id: UseCaseMapDialog.java,v 1.4 2006/03/17 02:31:50 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.dialogs;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

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
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.SorterToTable;
import org.isistan.flabot.util.ValidatorSorterTable;

/**
 * @author $Author: franco $
 *
 */
public class UseCaseMapDialog extends Dialog {
	
	/**
	 * the dialog's shell
	 */
	protected Shell shell = null;  //  @jve:decl-index=0:visual-constraint="10,9"
		
	protected Vector active = new Vector();
	
	protected int exitValue = SWT.CANCEL;
	protected Table table = null;
	protected SorterToTable sorter = null;
	
	public UseCaseMapDialog(Shell parent) {
		super(parent, 0);
	}	
	
	public int open(List coreuseCaseMaps, List selecteduseCaseMaps, boolean individualCheck) {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.UseCaseMapDialog.title")); //$NON-NLS-1$
		shell.setLayout(new GridLayout(1, true));		
		
		shell.addShellListener(new org.eclipse.swt.events.ShellAdapter() {				
			public void shellClosed(org.eclipse.swt.events.ShellEvent e) {
				handleCancel();
			}
		});
		
		Group respGroup = new Group(shell, SWT.NONE);
		respGroup.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.UseCaseMapDialog.group")); //$NON-NLS-1$
		respGroup.setLayout(new GridLayout(1, false));		
		respGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		createuseCaseMapTable(
				respGroup,
				coreuseCaseMaps, selecteduseCaseMaps,
		        individualCheck);
				
		createSearchGroup(respGroup);		
		createButtons();
		
		return open();
	}
	
	protected int open() {
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
	
	protected void createButtons() {
		// buttons composite (ok and cancel)	
		Composite buttonsComposite = new Composite(shell, SWT.NONE);
		buttonsComposite.setLayout(new RowLayout());
		buttonsComposite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
		
		Button buttonOK = new Button(buttonsComposite, SWT.NONE);
		buttonOK.setText(Messages.getString("org.isistan.flabot.edit.editor.okButton")); //$NON-NLS-1$
		buttonOK.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleOK();
			}
		});
		Button buttonCancel = new Button(buttonsComposite, SWT.NONE);
		buttonCancel.setText(Messages.getString("org.isistan.flabot.edit.editor.cancelButton")); //$NON-NLS-1$
		buttonCancel.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleCancel();
			}
		});
	}	
	
	protected void handleCancel() {
		exitValue = SWT.CANCEL;
		active = null;
		shell.dispose();
	}
	
	protected void handleOK() {
		active.clear();
		for (int i=0; i < table.getItems().length; i++){
			if (table.getItems()[i].getChecked()){
				active.add(table.getItems()[i].getData());
			}
		}
		exitValue = SWT.OK;
		shell.dispose();
	}

	protected void createuseCaseMapTable(
			Composite parent,
			List coreuseCaseMaps, List selecteduseCaseMaps,
	        boolean individualCheck) {

		
		int check = SWT.NONE;
		if (individualCheck) 
			check = SWT.CHECK;
		
		table = new Table(parent, SWT.BORDER | check | SWT.MULTI
				| SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		
		GridData gd = new GridData(GridData.FILL_BOTH | GridData.VERTICAL_ALIGN_BEGINNING);
		gd.verticalSpan = 3;
		gd.widthHint = 400;
		gd.heightHint = 200;
		table.setLayoutData(gd);			
		final TableColumn tc1 = new TableColumn(table, SWT.LEFT);		
		final TableColumn tc2 = new TableColumn(table, SWT.LEFT);
		sorter = new SorterToTable(table, new Validator(false, null, 2));	
		tc1.addListener(SWT.Selection, new Listener() {
			   public void handleEvent(Event e) {
				   sorter.setColumn(tc1);
				   sorter.reverseDirection();
				   sorter.order();
			   }
			        });
		tc2.addListener(SWT.Selection, new Listener() {
			   public void handleEvent(Event e) {
				   sorter.setColumn(tc2);
				   sorter.reverseDirection();
				   sorter.order();
			   }
			        });
		tc1.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.ResponsibilityDialog.responsibilityName")); //$NON-NLS-1$
		tc2.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.ResponsibilityDialog.responsibilityDescription")); //$NON-NLS-1$
		tc1.setWidth(220);
		tc2.setWidth(180);
		
		fillTable(table, coreuseCaseMaps, selecteduseCaseMaps);				
	}
	
	protected void createSearchGroup(Composite parent) {
		Composite searchGroup = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2,true);
		layout.marginWidth = 0;
		searchGroup.setLayout(layout);		
		searchGroup.setLayoutData(new GridData());
		
		final Text input = new Text(searchGroup, SWT.SINGLE | SWT.BORDER);
		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.widthHint = 100;
		input.setLayoutData(gd);
		
		final Button searchBtn = new Button(searchGroup, SWT.NONE);
		searchBtn.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
		searchBtn.setText(Messages.getString("org.isistan.flabot.edit.editor.searchButton")); //$NON-NLS-1$
		searchBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				TableItem[] tia = table.getItems();
				
		        for (int i = 0; i < tia.length; i++) {
		          if (tia[i].getText().toLowerCase().indexOf(input.getText().toLowerCase()) >= 0)
		            tia[i].setBackground(ColorConstants.lightBlue);
		          else
		        	tia[i].setBackground(ColorConstants.white);
		      }
		    }
		});
	}
	
	protected void fillTable(Table table, List coreData, List selecteduseCaseMaps) {
		for (Iterator iter = coreData.iterator(); iter.hasNext();) {
			UseCaseMap m = (UseCaseMap) iter.next(); 
			if (!selecteduseCaseMaps.contains(m)){
				final TableItem item = new TableItem(table, SWT.NONE);
			    item.setText(new String[] { m.getName(), m.getDescription()});
			    item.setData(m);
			}
		}
	}	
	
	public Vector getSelectedUseCaseMap() {
		return active;
	}
	
	public class Validator implements ValidatorSorterTable {
		
		private boolean checkBox;
		private List componentsResp;
		private int values;

		public Validator (boolean checkBox, List componentsResp, int values){
			this.checkBox = checkBox;
			this.componentsResp = componentsResp;
			this.values = values;
		}
		
		public String[] getValues(TableItem item) {
			String[] result = new String[values];
			for (int i=0; i < values; i++){
				  result[i] = item.getText(i);
			  }
			return result;
		}

		public boolean existsCheckBox() {
			return checkBox;
		}

		public boolean validateCheckBox(TableItem item) {
			 if (componentsResp.contains(item.getData()))
			    return true;
			 return false;
		}
		
		public void setCountValues (int values){
			this.values = values;
		}
		
		public void setExistsCheckBox (boolean check){
			this.checkBox = check;
		}
		
		public void setObejct (Object object){
			this.componentsResp = (List)object;
		}

		public String getText(TableItem item, int column) {
			return item.getText(column);
		}

		public void setValuesToItem(Table table, TableItem item, String[] values, Object valueData, TableItem newitem) {
			item.setText(values);
	        item.setData(valueData);			
		}

		public void setObejctItem(TableItem item) {}

		public void initOrder() {}
		
	}
}