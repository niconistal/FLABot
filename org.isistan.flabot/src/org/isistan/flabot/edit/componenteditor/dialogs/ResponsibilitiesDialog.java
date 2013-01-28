/**
 * $Id: ResponsibilitiesDialog.java,v 1.9 2006/04/04 03:32:16 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.dialogs;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
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
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.edit.componenteditor.commands.model.AddResponsibilityToCoreCommand;
import org.isistan.flabot.edit.componenteditor.dialogs.responsibility.ResponsibilityEditionItem;
import org.isistan.flabot.edit.editor.dialogs.StandardEditionDialog;
import org.isistan.flabot.edit.ucmeditor.commands.model.DeleteResponsibilityCommand;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.SorterToTable;
import org.isistan.flabot.util.ValidatorSorterTable;
import org.isistan.flabot.util.problems.log.LoggerMessageAccumulator;

/**
 * @author $Author: franco $
 *
 */
public class ResponsibilitiesDialog extends Dialog {
	
	/**
	 * the dialog's shell
	 */
	protected Shell shell = null;  //  @jve:decl-index=0:visual-constraint="10,9"
		
	protected SorterToTable sorter;


	protected Table table = null;
	

	private CommandStack commandStack;

	private CoreModel coreModel;
	
	private Button editResp;
	private Button removeResp;
	
	private Image image;
	
	public ResponsibilitiesDialog(Shell parent, CommandStack commandStack) {
		super(parent, 0);
		this.commandStack=commandStack;
		
		ImageDescriptor descriptor=ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/responsibility.gif"); //$NON-NLS-1$
		image=descriptor.createImage();

	}	
	
	protected void open() {
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
	}	

	protected void createResponsibilityTable(
			Composite parent,
			List coreResponsibilities) {

		
		int check = SWT.NONE;
		
		table = new Table(parent, SWT.BORDER | check | SWT.MULTI
				| SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		
		GridData gd = new GridData(GridData.FILL_BOTH | GridData.VERTICAL_ALIGN_BEGINNING);
		gd.verticalSpan = 3;
		gd.widthHint = 400;
		gd.heightHint = 200;
		table.setLayoutData(gd);	
		table.addListener( SWT.Selection, new Listener() {
	        public void handleEvent(Event event) {
	          TableItem[] items = table.getSelection();
        	  editResp.setEnabled(items.length == 1);
        	  removeResp.setEnabled(items.length >= 1);
	        }			
		});		
		final TableColumn tc1 = new TableColumn(table, SWT.LEFT);		
		final TableColumn tc2 = new TableColumn(table, SWT.LEFT);
		sorter = new SorterToTable(table, new Validator(2));	
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
		
		fillTable(table, coreResponsibilities);				
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
	
	
	public class Validator implements ValidatorSorterTable {
		
		private int values;

		public Validator (int values){
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
			return false;
		}

		public boolean validateCheckBox(TableItem item) {
			 return true;
		}
		
		public void setCountValues (int values){
			this.values = values;
		}
		
		public void setExistsCheckBox (boolean check){
		}
		
		public void setObejct (Object object){
		}

		public String getText(TableItem item, int column) {
			return item.getText(column);
		}

		public void setValuesToItem(Table table, TableItem item, String[] values, Object valueData, TableItem newitem) {
			item.setText(values);
	        item.setData(valueData);
	        item.setImage(newitem.getImage());
		}

		public void setObejctItem(TableItem item) {}

		public void initOrder() {}
		
	}
	

	
	public void open(CoreModel coreModel, List coreResponsibilities) {
		this.coreModel=coreModel;
		
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.ResponsibilityDialogComponent.title")); //$NON-NLS-1$
		shell.setLayout(new GridLayout(1, true));						
		
		Group respGroup = new Group(shell, SWT.NONE);
		respGroup.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.ResponsibilityDialogComponent.group")); //$NON-NLS-1$
		respGroup.setLayout(new GridLayout(2, false));		
		respGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		createResponsibilityTable(
				respGroup,
				coreResponsibilities);
		
		createModificationOptions(respGroup);
		
		createSearchGroup(respGroup);		
		createButtons();
		
		open();
	}
	
	protected void fillTable(Table table, List coreData) {
		for (Iterator iter = coreData.iterator(); iter.hasNext();) {
			Responsibility m = (Responsibility) iter.next(); 
			final TableItem item = new TableItem(table, SWT.NONE);
		    item.setText(new String[] { m.getName(), m.getDescription()});
		    item.setData(m);
		    item.setImage(image);
		}
	}	
	
	protected void createModificationOptions(Composite parent) {
		
		table.addListener( SWT.MouseDoubleClick, new Listener() {
			public void handleEvent(Event event) {
				handleEdit();
			}			
		});	
		
		final Button addResp = new Button(parent, SWT.NONE);
		addResp.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
		addResp.setText(Messages.getString("org.isistan.flabot.edit.editor.addButton")); //$NON-NLS-1$
		addResp.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleAdd();		
			}
		});
		
		editResp = new Button(parent, SWT.NONE);
		editResp.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
		editResp.setText(Messages.getString("org.isistan.flabot.edit.editor.editButton")); //$NON-NLS-1$
		editResp.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleEdit();						          	          							
			}
		});
		editResp.setEnabled(false);
	
		removeResp = new Button(parent, SWT.NONE);
		removeResp.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
		removeResp.setText(Messages.getString("org.isistan.flabot.edit.editor.removeButton")); //$NON-NLS-1$
		removeResp.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleRemove();        	          							
			}
		});
		removeResp.setEnabled(false);
	}	
	
	private StandardEditionDialog<Responsibility> getEditionDialog() {

		StandardEditionDialog<Responsibility> f =
			new StandardEditionDialog<Responsibility>(
					shell,
					Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditResponsibilityDialog.title"),//$NON-NLS-1$
					Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.ResponsibilitiesDialog.commandName"), //$NON-NLS-1$
					ResponsibilityEditionItem.LOADER.getEditionItems(
							new LoggerMessageAccumulator()));
		return f;
	}
	
	protected void handleAdd() {
		StandardEditionDialog<Responsibility> f=getEditionDialog();
		
		Responsibility resp=CoremodelFactory.eINSTANCE.createResponsibility();
		Command addCommand=new AddResponsibilityToCoreCommand(coreModel, resp);
		commandStack.execute(addCommand);
		
		Command editCommand=f.open(resp);
		if (editCommand == null) {
			commandStack.undo();
		} else {
			editCommand.execute();
			final TableItem item = new TableItem(table, SWT.NONE);
			item.setText(new String[] {resp.getName(), resp.getDescription()});
			item.setData(resp);
		    item.setImage(image);
			if(sorter.isSorted()) {
				sorter.order();
			}
		}
	}
	
	protected void handleRemove() {
		TableItem[] items = table.getSelection();
		if(items.length==0) {
			return;
		}
		CompoundCommand compund=new CompoundCommand(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.ResponsibilitiesDialog.tabCommandLabel")); //$NON-NLS-1$
		for (TableItem item : items) {
			Responsibility resp = (Responsibility)item.getData();      	  
			Command command=new DeleteResponsibilityCommand(resp.getCoreModel(), resp);
			compund.add(command);
		}

		commandStack.execute(compund);
		table.remove(table.getSelectionIndices());
		
		editResp.setEnabled(false);
		removeResp.setEnabled(false);
	}
	
	protected void handleEdit() {
		TableItem[] items = table.getSelection();
		if (items.length == 1) {
			TableItem item=items[0];
			Responsibility resp = (Responsibility)item.getData();
			StandardEditionDialog<Responsibility> f=getEditionDialog();
			Command command = f.open(resp);
			if (command != null) {
				commandStack.execute(command);
				item.setText(new String[] {resp.getName(), resp.getDescription()});
				if(sorter.isSorted()) {
					sorter.order();
				}
			}
		}
	}
	
	protected void handleOK() {
		shell.dispose();
	}
	
}