/**
 * $Id: EventDialog.java,v 1.11 2006/04/11 01:31:18 franco Exp $
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
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.edit.editor.dialogs.StandardEditionDialog;
import org.isistan.flabot.edit.ucmeditor.commands.model.AddConditionEventToCoreModelCommand;
import org.isistan.flabot.edit.ucmeditor.commands.model.DeleteConditionEventFromCoreModelCommand;
import org.isistan.flabot.edit.ucmeditor.commands.model.ModifyConditionEventCommand;
import org.isistan.flabot.edit.ucmeditor.dialogs.event.ConditionEventEditionItem;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.DefualtValidatorSorter;
import org.isistan.flabot.util.SorterToTable;
import org.isistan.flabot.util.problems.log.LoggerMessageAccumulator;

/**
 * @author $Author: franco $
 *
 */
public class EventDialog extends Dialog {
	/**
	 * the dialog's shell
	 */
	private Shell shell = null;  //  @jve:decl-index=0:visual-constraint="10,9"

	private CoreModel coreModel;
	
	private List newConditionEvents = new ArrayList();
	private Map modifyConditionEvents = new HashMap();
	private List removeConditionEvents = new ArrayList();
	
	private int exitValue = SWT.CANCEL; 
	
	private Button editBtn;
	private Button removeBtn;
	
	public EventDialog(Shell parent) {
		super(parent, 0);
	}
		
	private void createShell() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EventDialog.title")); //$NON-NLS-1$
		shell.setLayout(new GridLayout(1, true));				
		
		shell.addShellListener(new org.eclipse.swt.events.ShellAdapter() {				
			public void shellClosed(org.eclipse.swt.events.ShellEvent e) {
				handleCancel();
			}
		});
	}
	
	private Table createTableGroup(Composite parent, List conditionEvents) {		
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
		
		fillTable(table, conditionEvents);
		
		createModificationButtons(parent, table);
		
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
	
	private void createModificationButtons(Composite parent, final Table table) {
		table.addListener( SWT.MouseDoubleClick, new Listener() {
			public void handleEvent(Event event) {
				handleEdit(table);
			}			
		});	
		
		final Button newBtn = new Button(parent, SWT.NONE);
		newBtn.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
		newBtn.setText(Messages.getString("org.isistan.flabot.edit.editor.addButton")); //$NON-NLS-1$
		newBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {											
				ConditionEvent newConditionEvent = CoremodelFactory.eINSTANCE.createConditionEvent();
				
				StandardEditionDialog<ConditionEvent> f=getEditionDialog();
				Command command = f.open(newConditionEvent);
				if (command != null) {
					command.execute();
					final TableItem item = new TableItem(table, SWT.NONE);
				    item.setText(new String[]{newConditionEvent.getName(), newConditionEvent.getDescription()}); //$NON-NLS-1$
				    item.setData(newConditionEvent);
				    
				    newConditionEvents.add(newConditionEvent);					
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
				handleEdit(table);
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
					ConditionEvent eventToDelete = (ConditionEvent) item.getData();
					
					if (newConditionEvents.contains(eventToDelete))
						newConditionEvents.remove(eventToDelete);
					else {
						removeConditionEvents.add(eventToDelete);
						modifyConditionEvents.remove(eventToDelete);
					}						
		        }
				table.remove(table.getSelectionIndices());
				
				editBtn.setEnabled(false);
				removeBtn.setEnabled(false);
		    }
		});
	}
	
	private void handleEdit(Table table) {
		TableItem[] items = table.getSelection();
		if (items.length == 1) {
			ConditionEvent oldEvent = (ConditionEvent) items[0].getData();
			ConditionEvent modifyEvent = (ConditionEvent) modifyConditionEvents.get(oldEvent);
			if (modifyEvent == null)
				modifyEvent = CoremodelFactory.eINSTANCE.createConditionEvent(oldEvent);
			
			StandardEditionDialog<ConditionEvent> f=getEditionDialog();
			Command command = f.open(modifyEvent);
			if (command != null) {
				command.execute();
				items[0].setText(new String[]{modifyEvent.getName(), modifyEvent.getDescription()});
				
				if (newConditionEvents.contains(oldEvent)) {
					newConditionEvents.remove(oldEvent);
					newConditionEvents.add(modifyEvent);
			  		items[0].setData(modifyEvent);
			  	} else
			  		modifyConditionEvents.put(oldEvent, modifyEvent);
			}
		}
	}
	
	private void crateFinalButtons() {
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
	
	private StandardEditionDialog<ConditionEvent> getEditionDialog() {
		StandardEditionDialog<ConditionEvent> f =
			new StandardEditionDialog<ConditionEvent>(
					shell,
					Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EventDialog.tabTitle"), //$NON-NLS-1$
					Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EventDialog.commandTabLabel"), //$NON-NLS-1$
					ConditionEventEditionItem.LOADER.getEditionItems(
							new LoggerMessageAccumulator()));
		return f;
	}
	
	public Command open(CoreModel coreModel, List conditionEvents) {	
		this.coreModel = coreModel; 
		
		createShell();
		
		Group respGroup = new Group(shell, SWT.NONE);
		respGroup.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EventDialog.group")); //$NON-NLS-1$
		respGroup.setLayout(new GridLayout(2, false));		
		respGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		createTableGroup(respGroup, conditionEvents);
		crateFinalButtons();		
		return show();
	}
	
	private void handleCancel() {
		exitValue = SWT.CANCEL;
		shell.dispose();
	}
	
	private void handleOk() {
		exitValue = SWT.OK;
		shell.dispose();
	}
	
	private void fillTable(Table table, List responsibilities) {
		for (Iterator iter = responsibilities.iterator(); iter.hasNext();) {
			ConditionEvent m = (ConditionEvent) iter.next(); 
			final TableItem item = new TableItem(table, SWT.NONE);
		    item.setText(new String[] { m.getName(), m.getDescription()}); //$NON-NLS-1$
		    item.setData(m);
		}
	}		
	
	public Command getCommand() {
		if (exitValue == SWT.OK) {
			CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EventDialog.compoundCommandLabel")); //$NON-NLS-1$			
			for (Iterator iter = removeConditionEvents.iterator(); iter.hasNext();)
				commands.add( new DeleteConditionEventFromCoreModelCommand(coreModel, (ConditionEvent) iter.next()));

			for (Iterator iter = newConditionEvents.iterator(); iter.hasNext();)
				commands.add( new AddConditionEventToCoreModelCommand(coreModel, (ConditionEvent) iter.next()));
						
			for (Iterator iter = modifyConditionEvents.keySet().iterator(); iter.hasNext();) {
				ConditionEvent event = (ConditionEvent) iter.next();
				commands.add( new ModifyConditionEventCommand(event, (ConditionEvent) modifyConditionEvents.get(event)));
			}
			
			if(commands.size() == 0)
				return null;
			
			return commands;
		}
		
		return null;
	}
}