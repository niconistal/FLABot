package org.isistan.flabot.edit.ucmeditor.dialogs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
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
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.ConditionedStub;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.DynamicStubNode;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.edit.editor.dialogs.ResponsibilitySelectionDialog;
import org.isistan.flabot.edit.editor.dialogs.StandardEditionDialog;
import org.isistan.flabot.edit.ucmeditor.commands.model.AddConditionedStubToDynamicStubCommand;
import org.isistan.flabot.edit.ucmeditor.commands.model.DeleteConditionedStubFromDynamicStubCommand;
import org.isistan.flabot.edit.ucmeditor.commands.model.ModifyConditionedStub;
import org.isistan.flabot.edit.ucmeditor.commands.model.ModifyDynamicStubCommand;
import org.isistan.flabot.edit.ucmeditor.dialogs.responsibilitynode.ConditionedStubResponsibilityNodeEditionItem;
import org.isistan.flabot.edit.ucmeditor.dialogs.responsibilitynode.ResponsibilityEditionItem;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.DefualtValidatorSorter;
import org.isistan.flabot.util.SorterToTable;
import org.isistan.flabot.util.edition.DataAdapter;
import org.isistan.flabot.util.edition.tab.EditionTabItem;
import org.isistan.flabot.util.edition.tab.EditionTabItemContainerImpl;
import org.isistan.flabot.util.problems.MessageAccumulator;
import org.isistan.flabot.util.problems.log.LoggerMessageAccumulator;

public class EditDynamicStubDialog extends Dialog{
	/**
	 * the dialog's shell
	 */
	private Shell shell = null;  //  @jve:decl-index=0:visual-constraint="10,9"

	private CoreModel coreModel;
	private DynamicStubNode dynamicStubNode;
	private DynamicStubNode originalDynamicStub;
	private UCMDiagram diagram; 
	private CommandStack commandStack;
	private CompoundCommand commands;
	
	protected List newConditionedStubs = new ArrayList();	
	protected HashMap modifyConditionedStubs = new HashMap();
	protected List removeConditionedStubs = new ArrayList();
	
	private int exitValue = SWT.CANCEL;
	
	private Button editBtn;
	private Button editResponsibilityBtn;
	private Button removeBtn;
	private Button buttonOK;
	private Text dynamicStubName = null;
	
	public EditDynamicStubDialog(Shell parent, DynamicStubNode dynamicStubNode, CommandStack commandStack) {
		super(parent, 0);
		
		this.dynamicStubNode = CoremodelFactory.eINSTANCE.createDynamicStubNode(dynamicStubNode);
		this.shell = parent;
		this.commandStack = commandStack;
		this.originalDynamicStub = dynamicStubNode;
		commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditDynamicStubAction.commandLabel"));  //$NON-NLS-1$
	}
	
	private void createFinalButtons() {
		// buttons composite (ok and cancel)	
		Composite buttonsComposite = new Composite(shell, SWT.NONE);
		buttonsComposite.setLayout(new RowLayout());
		buttonsComposite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
		
		buttonOK = new Button(buttonsComposite, SWT.NONE);		
		buttonOK.setText(Messages.getString("org.isistan.flabot.edit.editor.okButton")); //$NON-NLS-1$
		buttonOK.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleOk();
			}
		});
		if (dynamicStubNode.getConditionedStubs().size() == 0)
			buttonOK.setEnabled(false);
		
		Button buttonCancel = new Button(buttonsComposite, SWT.NONE);
		buttonCancel.setText(Messages.getString("org.isistan.flabot.edit.editor.cancelButton")); //$NON-NLS-1$
		buttonCancel.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleCancel();
			}
		});
	}
	
	private Table createTableGroup(Composite parent, List conditionedStubs) {
		final Table table = new Table(parent, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);
		GridData gd = new GridData(GridData.FILL_BOTH | GridData.VERTICAL_ALIGN_BEGINNING);
		gd.verticalSpan = 4;
		gd.widthHint = 600;
		gd.heightHint = 200;
		table.setLayoutData(gd);		
		table.setHeaderVisible(true);
		table.addListener( SWT.Selection, new Listener() {
	        public void handleEvent(Event event) {
	          TableItem[] items = table.getSelection();
        	  editBtn.setEnabled(items.length == 1);
        	  editResponsibilityBtn.setEnabled(items.length == 1);
        	  removeBtn.setEnabled(items.length >= 1);
	        }			
		});		
		
		final TableColumn tc0 = new TableColumn(table, SWT.LEFT);
		final TableColumn tc1 = new TableColumn(table, SWT.CENTER);
		final TableColumn tc2 = new TableColumn(table, SWT.CENTER);
		final SorterToTable sorter = new SorterToTable(table, new DefualtValidatorSorter(false,3));
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
		tc2.addListener(SWT.Selection, new Listener() {
			   public void handleEvent(Event e) {
				   sorter.setColumn(tc2);
				   sorter.reverseDirection();
				   sorter.order();
			   }
		});
		tc0.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.DynamicStubManagerDialog.name")); //$NON-NLS-1$
		tc1.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.DynamicStubManagerDialog.StartNode")); //$NON-NLS-1$
		tc2.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.DynamicStubManagerDialog.EndNode")); //$NON-NLS-1$
		tc0.setWidth(200);
		tc1.setWidth(200);
		tc2.setWidth(200);
		fillTable(table, conditionedStubs);
		
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
	
	public Command open(UCMDiagram diagram, DynamicStubNode dynamicStubNode) {		
		this.coreModel = diagram.getCoreModel();
		this.diagram = diagram;
		
		createShell();
		
		Group dependencyGroup = new Group(shell, SWT.NONE);
		dependencyGroup.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.DynamicStubManagerDialog.dynamicStubPropertiesGroup")); //$NON-NLS-1$
		
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		dependencyGroup.setLayout(layout);
		
		dependencyGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
				
		createDynamicStubName(dependencyGroup);
		
		Group respGroup = new Group(shell, SWT.NONE);
		respGroup.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.DynamicStubsManagerDialog.group")); //$NON-NLS-1$
		respGroup.setLayout(new GridLayout(2, false));		
		respGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		createTableGroup(respGroup, dynamicStubNode.getConditionedStubs());		
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
	
	/**
	 * Creates a text box for the dynamic stub name
	 * 
	 * @param parent the composite parent
	 */
	private void createDynamicStubName(Composite parent) {
		// Stub Name
//		final Label label = new Label(parent, SWT.NONE);
//		label.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.DynamicStubManagerDialog.dynamicStubNameName"));  //$NON-NLS-1$
		
		dynamicStubName = new Text(parent, SWT.BORDER);
		dynamicStubName.setText(dynamicStubNode.getName());
		dynamicStubName.setLayoutData(new GridData(
					GridData.VERTICAL_ALIGN_BEGINNING |
					GridData.FILL_HORIZONTAL));
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
				StubNode newStub = CoremodelFactory.eINSTANCE.createStubNode();
				
				ResponsibilitySelectionDialog dialog = new ResponsibilitySelectionDialog(Display.getCurrent().getActiveShell(), commandStack, coreModel);		
				Responsibility selectedResponsibility =	dialog.openSingleWithAddNew(
						Display.getCurrent().getActiveShell(),
						Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.DynamicStubManagerDialog.responsibilitySelectionDialogName"), //$NON-NLS-1$
						Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.DynamicStubManagerDialog.responsibilitySelectionDialogDescription"), //$NON-NLS-1$
						coreModel.getResponsibilities(),
						null,
						null
						);
				
				if (selectedResponsibility != null)
				{
					EditStubDialog stubDialog = new EditStubDialog(shell, newStub);
					StubNode stubNode = stubDialog.open(diagram.getCoreModel().getUseCaseMaps(), diagram.getMap(), diagram.getCoreModel().getFamilies());		
					if (stubNode != null) {
						//command.execute();
					    
						stubNode.setMap(dynamicStubNode.getMap());
					    ConditionedStub newConditionedStub = CoremodelFactory.eINSTANCE.createConditionedStub();
					    newConditionedStub.setStub(stubNode);
					    newConditionedStub.setName(stubNode.getName());
					    
					    //newConditionedStub.setResponsibility(selectedResponsibility);
					    ResponsibilityNode responsibilityNode = CoremodelFactory.eINSTANCE.createResponsibilityNode();
					    responsibilityNode.setName(selectedResponsibility.getName());
					    responsibilityNode.setResponsibility(selectedResponsibility);
					    responsibilityNode.setMap(dynamicStubNode.getMap());
					    newConditionedStub.setResponsibilityNode(responsibilityNode);
					    
	
						final TableItem item = new TableItem(table, SWT.NONE);
					    item.setText(new String[]{newConditionedStub.getName(), newConditionedStub.getStub().getStartPointReference().getName(), newConditionedStub.getStub().getEndPointReference().getName()}); //$NON-NLS-1$
					    item.setData(newConditionedStub);		
					    //dynamicStubNode.getConditionedStubs().add(newConditionedStub);
					    newConditionedStubs.add(newConditionedStub);
					    
					    if (! buttonOK.getEnabled())
					    	buttonOK.setEnabled(true);
					}
				}
		    }
		});
		
		editBtn = new Button(parent, SWT.NONE);
		editBtn.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
		editBtn.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.DynamicStubManagerDialog.edit")); //$NON-NLS-1$
		editBtn.setEnabled(false);
		editBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleEdit(table);
		    }
		});
		
		editResponsibilityBtn = new Button(parent, SWT.NONE);
		editResponsibilityBtn.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
		editResponsibilityBtn.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.DynamicStubManagerDialog.editResponsibility")); //$NON-NLS-1$
		editResponsibilityBtn.setEnabled(false);
		editResponsibilityBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleEditResponsibility(table);
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
					ConditionedStub conditionedStubToDelete = (ConditionedStub) item.getData();
					
					removeConditionedStub(conditionedStubToDelete, newConditionedStubs, removeConditionedStubs, modifyConditionedStubs);
					//dynamicStubNode.getConditionedStubs().remove(conditionedStubToDelete);
		        }
				table.remove(table.getSelectionIndices());
				
				editBtn.setEnabled(false);
				editResponsibilityBtn.setEnabled(false);
				removeBtn.setEnabled(false);
				if (dynamicStubNode.getConditionedStubs().size() == 0)
					buttonOK.setEnabled(false);
		    }
		});
	}
	
	private void removeConditionedStub(ConditionedStub stubToDelete, List newConditionedStubs, List removeConditionedStubs, Map modifyConditionedStubs) {
		if (newConditionedStubs.contains(stubToDelete))
			newConditionedStubs.remove(stubToDelete);
		else {
			removeConditionedStubs.add(stubToDelete);
			modifyConditionedStubs.remove(stubToDelete);
		}						
	}
	
	private void modifyCondition(TableItem item, ConditionedStub oldConditionedStub, ConditionedStub newConditionedStub, List newConditionedStubs, Map modifyConditionedStubs) {
		if (newConditionedStubs.contains(oldConditionedStub)) {
			newConditionedStubs.remove(oldConditionedStub);
			newConditionedStubs.add(newConditionedStub);
	  		item.setData(newConditionedStub);
	  	} else
	  		modifyConditionedStubs.put(oldConditionedStub, newConditionedStub);
	}
	
	private ConditionedStub getModifyConditionedStub(ConditionedStub conditionedStub) {
			return (ConditionedStub) modifyConditionedStubs.get(conditionedStub);
	}
	
	private void handleCancel() {
		exitValue = SWT.CANCEL;
		shell.dispose();
	}
	
	private void handleOk() {
		exitValue = SWT.OK;
		dynamicStubNode.setName(dynamicStubName.getText());
		shell.dispose();
	}
	
	private void handleEdit(Table table) {
		TableItem[] items = table.getSelection();
		if (items.length == 1) {
			ConditionedStub conditionedStub = (ConditionedStub) items[0].getData();
			ConditionedStub modifiedConditionedStub = getModifyConditionedStub(conditionedStub);
			if (modifiedConditionedStub == null)
				modifiedConditionedStub = (ConditionedStub) EcoreUtil.copy(conditionedStub);
			
			EditStubDialog stubDialog = new EditStubDialog(shell, modifiedConditionedStub.getStub());
						
			StubNode stubNode = stubDialog.open(diagram.getCoreModel().getUseCaseMaps(), diagram.getMap(), diagram.getCoreModel().getFamilies());
			if (stubNode != null)
			{
				modifiedConditionedStub.setName(stubNode.getName());
				if (stubNode != null){
					items[0].setText(new String[]{modifiedConditionedStub.getName(), modifiedConditionedStub.getStub().getStartPointReference().getName(), modifiedConditionedStub.getStub().getEndPointReference().getName() }); //$NON-NLS-1$
					
					//coreModel.getStubs().remove(modifiedConditionedStub.getStub());
					modifiedConditionedStub.setStub(stubNode);
					items[0].setData(modifiedConditionedStub);
					
					modifyCondition(items[0], conditionedStub, modifiedConditionedStub, newConditionedStubs, modifyConditionedStubs);
				}
			}
		}
	}
	
	private void fillTable(Table table, List conditionedStubs) {
		for (Iterator iter = conditionedStubs.iterator(); iter.hasNext();) {
			ConditionedStub m = (ConditionedStub) iter.next(); 
			final TableItem item = new TableItem(table, SWT.NONE);
		    item.setText(new String[] { m.getName(), m.getStub().getStartPointReference().getName(), m.getStub().getEndPointReference().getName() }); //$NON-NLS-1$
		    item.setData(m);
		}
	}		
			
	public Command getCommand() {
		if (exitValue == SWT.OK) {
				
				for (Iterator iter = removeConditionedStubs.iterator(); iter.hasNext();) {
					ConditionedStub c = (ConditionedStub) iter.next();
					commands.add( new DeleteConditionedStubFromDynamicStubCommand(c, originalDynamicStub, coreModel));
				}

				for (Iterator iter = newConditionedStubs.iterator(); iter.hasNext();) {
					ConditionedStub c = (ConditionedStub) iter.next(); 
					commands.add( new AddConditionedStubToDynamicStubCommand(c, originalDynamicStub, coreModel));
				}
				
				for (Iterator iter = modifyConditionedStubs.keySet().iterator(); iter.hasNext();) {
					ConditionedStub conditionedStub = (ConditionedStub) iter.next();
					commands.add(new ModifyConditionedStub(conditionedStub, (ConditionedStub)modifyConditionedStubs.get(conditionedStub)));
				}						
			
			commands.add( new ModifyDynamicStubCommand(originalDynamicStub, dynamicStubNode, coreModel));
			return commands;
		}
		
		return null;		
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
	
	protected void handleEditResponsibility(Table table) {
		TableItem[] items = table.getSelection();
		if (items.length == 1) {
			TableItem item=items[0];
			ConditionedStub conditionedStub = (ConditionedStub)item.getData();
			Responsibility resp = (Responsibility)conditionedStub.getResponsibilityNode().getResponsibility();
//			StandardEditionDialog<Responsibility> f=getEditionDialog();
			Command respCommand = openEditResponsibilityDialog(conditionedStub);//f.open(resp);
			if (respCommand != null) {
				commands.add(respCommand);
				//item.setText(new String[] {resp.getName(), resp.getDescription()});
			}
		}
	}
	
	private Command openEditResponsibilityDialog(ConditionedStub conditionedStub)
	{
		MessageAccumulator messageAccumulator=
			new LoggerMessageAccumulator();
		
		DataAdapter<ResponsibilityNode, ResponsibilityNode> conditionedStubToResponsibilityAdapter=
			new DataAdapter<ResponsibilityNode, ResponsibilityNode>() {

				public ResponsibilityNode adapt(ResponsibilityNode data) {
					return data;
				}
			
		};
		EditionTabItem<ResponsibilityNode> semanticEditionItem=
			new EditionTabItemContainerImpl(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditResponsibilityNodeAction.semanticTabName"), //$NON-NLS-1$
					Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditResponsibilityNodeAction.semanticCommandLabel"), //$NON-NLS-1$
					conditionedStubToResponsibilityAdapter,
					ConditionedStubResponsibilityNodeEditionItem.LOADER.getEditionItems(
							messageAccumulator));
		
//		EditionTabItem<NodeVisualModel> visualEditionItem=
//			new EditionTabItemContainerImpl(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditResponsibilityNodeAction.visualTabName"), //$NON-NLS-1$
//					Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditResponsibilityNodeAction.visualCommandLabel"), //$NON-NLS-1$
//					new IdentityDataAdapter<NodeVisualModel>(),
//					ResponsibilityNodeVisualEditionItem.LOADER.getEditionItems(
//							messageAccumulator));
		
		StandardEditionDialog<ResponsibilityNode> dialog =
			new StandardEditionDialog<ResponsibilityNode>(
					Display.getCurrent().getActiveShell(),
					Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditResponsibilityNodeDialog.title"), //$NON-NLS-1$
					Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditResponsibilityNodeAction.dialogCommandLabel"), //$NON-NLS-1$
					new EditionTabItem[] {
						semanticEditionItem});
		
		return dialog.open(conditionedStub.getResponsibilityNode());
	}
}
