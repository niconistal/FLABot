/**
 * $Id: FamilyDialog.java,v 1.13 2006/04/11 01:31:18 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.dialogs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
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
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.edit.ucmeditor.commands.model.AddFamilyToCoreModelCommand;
import org.isistan.flabot.edit.ucmeditor.commands.model.DeleteFamilyCommand;
import org.isistan.flabot.edit.ucmeditor.commands.model.ModifyFamilyCommand;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.DefualtValidatorSorter;
import org.isistan.flabot.util.SorterToTable;

/**
 * @author $Author: franco $
 *
 */
public class FamilyDialog extends Dialog {
	/**
	 * the dialog's shell
	 */
	private Shell shell = null;  //  @jve:decl-index=0:visual-constraint="10,9"

	private CoreModel coreModel;
	
	private List newFamilies = new ArrayList();
	private Map modifyFamilies = new HashMap();
	private List removeFamilies = new ArrayList();

	private int exitValue = SWT.CANCEL;
	
	private Button editBtn;
	private Button removeBtn;
	
	public FamilyDialog(Shell parent) {
		super(parent, 0);
	}
	
	private void createFinalButtons() {
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
	}
	
	private Table createTableGroup(Composite parent, List families, List architecturalUseCaseMaps, List functionalUseCaseMaps) {
		final Table table = new Table(parent, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);
		GridData gd = new GridData(GridData.FILL_BOTH | GridData.VERTICAL_ALIGN_BEGINNING);
		gd.verticalSpan = 3;
		gd.widthHint = 400;
		gd.heightHint = 200;
		table.setLayoutData(gd);		
		table.setHeaderVisible(true);
		table.addListener( SWT.Selection, new Listener() {
	        public void handleEvent(Event event) {
	          TableItem[] items = table.getSelection();
        	  editBtn.setEnabled(items.length == 1);
        	  removeBtn.setEnabled(items.length >= 1);
	        }			
		});		
		
		final TableColumn tc0 = new TableColumn(table, SWT.LEFT);
		final TableColumn tc1 = new TableColumn(table, SWT.CENTER);
		final SorterToTable sorter = new SorterToTable(table, new DefualtValidatorSorter(false,2));
		tc0.addListener(SWT.Selection, new Listener() {
			   public void handleEvent(Event e) {
				   sorter.setColumn(tc0);
				   sorter.reverseDirection();
				   sorter.order();
			   }
		});
		tc1.addListener(SWT.Selection, new Listener() {
			   public void handleEvent(Event e) {
				   sorter.setColumn(tc1);
				   sorter.reverseDirection();
				   sorter.order();
			   }
		});
		tc0.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.FamilyDialog.name")); //$NON-NLS-1$
		tc1.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.FamilyDialog.description")); //$NON-NLS-1$
		tc0.setWidth(200);
		tc1.setWidth(215);
		fillTable(table, families);
		
		createModificationButtons(parent, table, architecturalUseCaseMaps, functionalUseCaseMaps);		
		
		Composite searchGroup = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2,true);
		layout.marginWidth = 0;
		searchGroup.setLayout(layout);		
		searchGroup.setLayoutData(new GridData());
		
		final Text input = new Text(searchGroup, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.widthHint = 100;
		input.setLayoutData(gd);
		
		final Button searchBtn = new Button(searchGroup, SWT.PUSH);
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
		
		return table;
	}
	
	private void createShell() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.FamilyDialog.title")); //$NON-NLS-1$
		shell.setLayout(new GridLayout(1, true));				
		
		shell.addShellListener(new org.eclipse.swt.events.ShellAdapter() {				
			public void shellClosed(org.eclipse.swt.events.ShellEvent e) {
				handleCancel();
			}
		});
	}	
	
	public Command open(CoreModel coreModel, List architecturalUseCaseMaps, List functionalUseCaseMaps, List families) {		
		this.coreModel = coreModel;
		
		createShell();
		
		Group respGroup = new Group(shell, SWT.NONE);
		respGroup.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.FamilyDialog.group")); //$NON-NLS-1$
		respGroup.setLayout(new GridLayout(2, false));		
		respGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		createTableGroup(respGroup, families, architecturalUseCaseMaps, functionalUseCaseMaps);		
		createFinalButtons();						
		
		return show();
	}
		
	private Command show() {
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
	    
	    return getCommand();   
	}	
	
	private void createModificationButtons(Composite parent, final Table table, final List architecturalUseCaseMaps, final List functionalUseCaseMaps) {
		
		table.addListener( SWT.MouseDoubleClick, new Listener() {
			public void handleEvent(Event event) {
				handleEdit(table, architecturalUseCaseMaps, functionalUseCaseMaps);
			}			
		});	
		
		final Button newBtn = new Button(parent, SWT.NONE);
		newBtn.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
		newBtn.setText(Messages.getString("org.isistan.flabot.edit.editor.addButton")); //$NON-NLS-1$
		newBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {			
				Family newFamily = CoremodelFactory.eINSTANCE.createFamily();
				
				FamilyManagerDialog managerdialog = new FamilyManagerDialog(shell);
				Command command = managerdialog.open(newFamily, architecturalUseCaseMaps, functionalUseCaseMaps);		
				if (command != null) {
					command.execute();
					final TableItem item = new TableItem(table, SWT.NONE);
				    item.setText(new String[]{newFamily.getName(), ""}); //$NON-NLS-1$
				    item.setData(newFamily);				    
				    
				    newFamilies.add(newFamily);
				}
		    }
		});
		
		editBtn = new Button(parent, SWT.NONE);
		editBtn.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
		editBtn.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.FamilyDialog.edit")); //$NON-NLS-1$
		editBtn.setEnabled(false);
		editBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleEdit(table, architecturalUseCaseMaps, functionalUseCaseMaps);
		    }
		});
		
		removeBtn = new Button(parent, SWT.NONE);
		removeBtn.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
		removeBtn.setText(Messages.getString("org.isistan.flabot.edit.editor.removeButton")); //$NON-NLS-1$
		removeBtn.setEnabled(false);
		removeBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				TableItem[] items = table.getSelection();
				if(items.length==0) {
					return;
				}

				for (TableItem item : items) {
					Family familyToDelete = (Family) item.getData();
					
					if (newFamilies.contains(familyToDelete))
						newFamilies.remove(familyToDelete);
					else {
						removeFamilies.add(familyToDelete);
						modifyFamilies.remove(familyToDelete);
					}						
		        }
				table.remove(table.getSelectionIndices());
				
				editBtn.setEnabled(false);
				removeBtn.setEnabled(false);
		    }
		});
	}
	
	private void handleCancel() {
		exitValue = SWT.CANCEL;
		shell.dispose();
	}
	
	private void handleOk() {
		exitValue = SWT.OK;
		shell.dispose();
	}
	
	private void handleEdit(Table table, List architecturalUseCaseMaps, List functionalUseCaseMaps) {
		TableItem[] items = table.getSelection();
		if (items.length == 1) {
			Family oldFamily = (Family) items[0].getData();
													
			Family modifyFamily = (Family) modifyFamilies.get(oldFamily);
			if (modifyFamily == null)
				modifyFamily = CoremodelFactory.eINSTANCE.createFamily(oldFamily);
			
			FamilyManagerDialog familyManagerDialog = new FamilyManagerDialog(shell);
			Command command = familyManagerDialog.open(modifyFamily, architecturalUseCaseMaps, functionalUseCaseMaps);				
			if (command != null){
				command.execute();
				items[0].setText(new String[]{modifyFamily.getName(), ""}); //$NON-NLS-1$
				
				if (newFamilies.contains(oldFamily)) {
					newFamilies.remove(oldFamily);
					newFamilies.add(modifyFamily);
			  		items[0].setData(modifyFamily);
			  	} else
			  		modifyFamilies.put(oldFamily, modifyFamily);
			}
		}
	}
	
	private void fillTable(Table table, List responsibilities) {
		for (Iterator iter = responsibilities.iterator(); iter.hasNext();) {
			Family m = (Family) iter.next(); 
			final TableItem item = new TableItem(table, SWT.NONE);
		    item.setText(new String[] { m.getName(), ""}); //$NON-NLS-1$
		    item.setData(m);
		}
	}		
			
	public Command getCommand() {
		if (exitValue == SWT.OK) {
			CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.FamilyDialog.compoundCommandLabel")); //$NON-NLS-1$		
			for (Iterator iter = removeFamilies.iterator(); iter.hasNext();)
				commands.add( new DeleteFamilyCommand(coreModel, (Family) iter.next()));

			for (Iterator iter = newFamilies.iterator(); iter.hasNext();)
				commands.add( new AddFamilyToCoreModelCommand(coreModel, (Family) iter.next()));
								
			for (Iterator iter = modifyFamilies.keySet().iterator(); iter.hasNext();) {
				Family family = (Family) iter.next();
				commands.add( new ModifyFamilyCommand(family, (Family) modifyFamilies.get(family)));
			}
			
			if(commands.size() == 0)
				return null;
			
			return commands;
		}
		
		return null;		
	}
}