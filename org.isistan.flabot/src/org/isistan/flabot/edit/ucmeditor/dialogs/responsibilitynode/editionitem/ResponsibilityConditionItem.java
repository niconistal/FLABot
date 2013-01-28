package org.isistan.flabot.edit.ucmeditor.dialogs.responsibilitynode.editionitem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.edit.ucmeditor.dialogs.responsibilitynode.ResponsibilityEditionItem;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.DefualtValidatorSorter;
import org.isistan.flabot.util.SorterToTable;
import org.isistan.flabot.util.edition.EditionItemStatus;
import org.isistan.flabot.util.edition.tab.EditionTabItemImpl;

public class ResponsibilityConditionItem extends EditionTabItemImpl<Responsibility>
		implements ResponsibilityEditionItem {

	private Composite mainGroup;
	private Responsibility resposibility;
	
//	protected List newPreConditions = new ArrayList();	
//	protected HashMap modifyPreConditions = new HashMap();
//	protected List removePreConditions = new ArrayList();
//	
//	protected List newPostConditions = new ArrayList();
//	protected HashMap modifyPostConditions = new HashMap();
//	protected List removePostConditions = new ArrayList();
//	
//	private Table preConditionsTable;
//	private Button editPreconditionBtn;
//	private Button removePreconditionBtn;
//	
//	private Table postConditionsTable;
//	
	@Override
	public void initialize(TabFolder tabFolder, TabItem tabItem,
			Responsibility element) {

//		resposibility = element;
//		CoreModel coreModel = this.resposibility.getCoreModel();
//
//		//Creates the group for the conditions
//		createConditions(tabFolder, tabItem, element, coreModel.getUseCaseMaps(), coreModel.getFamilies(), coreModel.getConditionEvents(), element.getPreconditions(), element.getPostconditions());
	}
	
	public void activate() {
		
	}
//	
//	private void createConditions(TabFolder folder, TabItem tabItem, Responsibility actualResp, List useCaseMaps, List families, List events, List preconditions, List postconditions) {
//		mainGroup = new Composite(folder, SWT.NONE);
//
//		tabItem.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditResponsibilityDialog.conditions")); //$NON-NLS-1$
//		tabItem.setToolTipText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditResponsibilityDialog.conditionsToolTipText")); //$NON-NLS-1$
//		
//		mainGroup.setLayout(new GridLayout(1, false));		
//		mainGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
//
//		//Creates pre condition table
//		createPreConditionProperty(mainGroup, actualNode, preconditions);
//		
//		//Creates post condition table
//		createPostConditionProperty(mainGroup, actualNode, preconditions);
//	}
//	
	@Override
	public Control getControl() {
		return mainGroup;
	}
//	
//	private void createConditionTable(final Table table, Button addBtn, Button editBtn, Button removeBtn, final ResponsibilityNode actualNode, final boolean isPreConditionList) {			
//		//Condition name
//		final TableColumn tc1 = new TableColumn(table, SWT.LEFT);
//		tc1.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditResponsibilityDialog.conditionName")); //$NON-NLS-1$
//		tc1.setWidth(180);
//				
//		//Condition value
//		final TableColumn tc2 = new TableColumn(table, SWT.LEFT);
//		tc2.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditResponsibilityDialog.conditionValue")); //$NON-NLS-1$
//		tc2.setWidth(350);
//		
//		final SorterToTable sorter = new SorterToTable(table, new DefualtValidatorSorter(false,2));
//		tc1.addListener(SWT.Selection, new Listener() {
//			public void handleEvent(Event e) {
//				sorter.setColumn(tc1);
//				sorter.reverseDirection();
//				sorter.order();
//			}
//		});
//		tc2.addListener(SWT.Selection, new Listener() {
//			public void handleEvent(Event e) {
//				sorter.setColumn(tc2);
//				sorter.reverseDirection();
//				sorter.order();
//			}
//		});
//	
//		//Add Condition button action
//		addBtn.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//				Condition newCondition = CoremodelFactory.eINSTANCE.createCondition();
//				
//				EditDependencyDialog f = new EditDependencyDialog(mainGroup.getShell());
//				Command command = f.open(getDependecies(newCondition), newCondition, actualNode,hasMapping(table));
//					
//				if (command != null) {
//					command.execute();
//					
//					final TableItem item = new TableItem(table, SWT.NONE);
//					item.setText(new String[]{newCondition.getName(), newCondition.getValue()});
//					item.setData(newCondition);
//					if (isPreConditionList)
//						newPreConditions.add(newCondition);
//					else
//						newPostConditions.add(newCondition);					    
//				}
//			}
//		});
//			
//		//Edit condition button action
//		editBtn.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//				editAction(table, actualNode, isPreConditionList);
//			}
//		});
//		
//		//Double click edition over conditions
//		table.addListener( SWT.MouseDoubleClick, new Listener() {
//			public void handleEvent(Event event) {
//				editAction(table, actualNode, isPreConditionList);
//			}			
//		});	
//
//		//Remove condition button action
//		removeBtn.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//				TableItem[] items = table.getSelection();
//				if(items.length==0) {
//					return;
//				}
//				
//				for (TableItem item : items) {
//					Condition conditionToDelete = (Condition)item.getData();
//					
//					if (isPreConditionList)
//						removeCondition(conditionToDelete, newPreConditions, removePreConditions, modifyPreConditions);
//					else
//						removeCondition(conditionToDelete, newPostConditions, removePostConditions, modifyPostConditions);										
//				}
//				table.remove(table.getSelectionIndices());
//
//				if (isPreConditionList) {
//					editPreconditionBtn.setEnabled(false);
//					removePreconditionBtn.setEnabled(false);
//				} 
//			}
//		});
//	}
//	
//	private void createEventConditionTable(final Table table, Button addBtn, Button removeBtn, final ResponsibilityNode actualNode, final boolean isPreConditionList) {			
//		//Condition name
//		final TableColumn tc1 = new TableColumn(table, SWT.LEFT);
//		tc1.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditResponsibilityDialog.conditionName")); //$NON-NLS-1$
//		tc1.setWidth(180);
//				
//		//Condition value
//		final TableColumn tc2 = new TableColumn(table, SWT.LEFT);
//		tc2.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditResponsibilityDialog.conditionValue")); //$NON-NLS-1$
//		tc2.setWidth(350);
//		
//		final SorterToTable sorter = new SorterToTable(table, new DefualtValidatorSorter(false,2));
//		tc1.addListener(SWT.Selection, new Listener() {
//			public void handleEvent(Event e) {
//				sorter.setColumn(tc1);
//				sorter.reverseDirection();
//				sorter.order();
//			}
//		});
//		tc2.addListener(SWT.Selection, new Listener() {
//			public void handleEvent(Event e) {
//				sorter.setColumn(tc2);
//				sorter.reverseDirection();
//				sorter.order();
//			}
//		});
//	
//		//Add Condition button action
//		addBtn.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//							
//				EditEventConditionDialog f = new EditEventConditionDialog(mainGroup.getShell());
//				Command command = f.open(getEventConditions(actualNode), actualNode);
//				Vector newConditions = f.getNewConditions();	
//				Hashtable modiyfyConditions = f.getModifyConditions();
//				if (command != null) {
//					Condition key, value;
//		            for (Enumeration en=modiyfyConditions.keys(); en.hasMoreElements();) {
//		            	key = (Condition)en.nextElement();
//		                value = (Condition)modiyfyConditions.get(key);
//		                for (int j = 0; j < postConditionsTable.getItems().length; j++) {
//		    				TableItem item = postConditionsTable.getItems()[j];
//		    				if (((Condition)item.getData()).getValue().equals(key.getValue())){
//		    					item.setData(value);
//		    					item.setText(new String[]{value.getName(), value.getValue()});
//		    					modifyPreConditions.put(key,value);
//								break;
//		    				}
//		                }
//		            }
//					for (int i=0; i < newConditions.size(); i++){
//						Condition newCondition = (Condition)newConditions.get(i);
//						final TableItem item = new TableItem(table, SWT.NONE);
//						item.setText(new String[]{newCondition.getName(), newCondition.getValue()});
//						item.setData(newCondition);
//						newPreConditions.add(newCondition);					    
//					}
//				}
//			}
//
//			private List getEventConditions(ResponsibilityNode actualNode) {
//				Vector conditions = new Vector();
//				for (int i = 0; i < actualNode.getResponsibility().getPreconditions().size(); i++) {
//					Condition condition = (Condition)actualNode.getResponsibility().getPreconditions().get(i);
//					if (condition.getType().equals(Condition.previousEvent)){
//						conditions.add(actualNode.getResponsibility().getPreconditions().get(i));
//					}
//				}
//				return conditions;
//			}
//		});	
//		
////		Remove condition button action
//		removeBtn.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//				TableItem[] items = table.getSelection();
//				if(items.length==0) {
//					return;
//				}
//				
//				for (TableItem item : items) {
//					Condition conditionToDelete = (Condition)item.getData();
//					
//					removeEventCondition(conditionToDelete, newPreConditions, removePreConditions, modifyPreConditions);										
//				}
//				table.remove(table.getSelectionIndices());
//			}
//		});
//	}
//	
//	private void removeEventCondition(Condition conditionToDelete, List newConditions, List removeConditions, Map modifyConditions) {
//		if (newConditions.contains(conditionToDelete)){
//			newConditions.remove(conditionToDelete);
//			removeConditions.add(conditionToDelete);
//		}
//		else {
//			removeConditions.add(conditionToDelete);
//			modifyConditions.remove(conditionToDelete);
//		}						
//	}
//	
//	private void removeCondition(Condition conditionToDelete, List newConditions, List removeConditions, Map modifyConditions) {
//		if (newConditions.contains(conditionToDelete))
//			newConditions.remove(conditionToDelete);
//		else {
//			removeConditions.add(conditionToDelete);
//			modifyConditions.remove(conditionToDelete);
//		}						
//	}
//	
//	private void editAction(Table table, ResponsibilityNode actualNode, boolean isPreConditionList) {
//		TableItem[] items = table.getSelection();
//		if (items.length == 1) {
//			Condition condition = (Condition) items[0].getData();
//  					
//			Condition modifyCondition = getModifyCondition(condition, isPreConditionList);
//			if (modifyCondition == null)
//				modifyCondition = (Condition) EcoreUtil.copy(condition);
//			
//			EditDependencyDialog dialog = new EditDependencyDialog(mainGroup.getShell());
//			Vector listMapping = hasMapping(table);
//			listMapping.remove(modifyCondition.getDependencyResponsibility());
//			Command command = dialog.open(getDependecies(modifyCondition), modifyCondition, actualNode,listMapping);
//			
//			if (command != null) {
//				command.execute();
//				items[0].setText(new String[]{modifyCondition.getName(), modifyCondition.getValue()});
//				
//				if(isPreConditionList)
//					modifyCondition(items[0], condition, modifyCondition, newPreConditions, modifyPreConditions);
//				else
//					modifyCondition(items[0], condition, modifyCondition, newPostConditions, modifyPostConditions);
//			}
//		}
//	}
//	
//	private Condition getModifyCondition(Condition condition, boolean isPreConditionbList) {
//		if (isPreConditionbList) 
//			return (Condition) modifyPreConditions.get(condition);
//		else
//			return (Condition) modifyPostConditions.get(condition);
//	}
//	
//	private void modifyCondition(TableItem item, Condition oldCondition, Condition newCondition, List newConditions, Map modifyConditions) {
//		if (newConditions.contains(oldCondition)) {
//	  		newConditions.remove(oldCondition);
//	  		newConditions.add(newCondition);
//	  		item.setData(newCondition);
//	  	} else
//	  		modifyConditions.put(oldCondition, newCondition);
//	}
//	
//	private void createPreConditionProperty(Composite parent, final ResponsibilityNode actualNode, List preconditions) {
//		Group respGroup = new Group(parent, SWT.NONE);
//		respGroup.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditResponsibilityDialog.preconditions")); //$NON-NLS-1$
//		respGroup.setLayout(new GridLayout(2, false));		
//		respGroup.setLayoutData(new GridData(GridData.FILL_BOTH));		
//	    
//		preConditionsTable = new Table(respGroup, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);
//		GridData gd = new GridData(GridData.FILL_BOTH | GridData.VERTICAL_ALIGN_BEGINNING);
//		gd.verticalSpan = 3;
//		gd.widthHint = 260;
//		gd.heightHint = 80;
//		preConditionsTable.setLayoutData(gd);
//		preConditionsTable.setHeaderVisible(true);
//		preConditionsTable.addListener( SWT.Selection, new Listener() {
//	        public void handleEvent(Event event) {
//	          TableItem[] items = preConditionsTable.getSelection();
//        	  editPreconditionBtn.setEnabled(items.length == 1);
//        	  removePreconditionBtn.setEnabled(items.length >= 1);
//	        }			
//		});		
//				
//		final Button addBtn = new Button(respGroup, SWT.NONE);
//		addBtn.setText(Messages.getString("org.isistan.flabot.edit.editor.addButton")); //$NON-NLS-1$
//		gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
//		gd.widthHint = 100;
//		addBtn.setLayoutData(gd);
//		
//		editPreconditionBtn = new Button(respGroup, SWT.NONE);
//		editPreconditionBtn.setText(Messages.getString("org.isistan.flabot.edit.editor.editButton")); //$NON-NLS-1$
//		gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING );
//		gd.widthHint = 100;
//		editPreconditionBtn.setLayoutData(gd);
//		editPreconditionBtn.setEnabled(false);
//		
//		removePreconditionBtn = new Button(respGroup, SWT.NONE);
//		removePreconditionBtn.setText(Messages.getString("org.isistan.flabot.edit.editor.removeButton")); //$NON-NLS-1$
//		gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING );
//		gd.widthHint = 100;
//		removePreconditionBtn.setLayoutData(gd);
//		removePreconditionBtn.setEnabled(false);
//		
//		createConditionTable(preConditionsTable, addBtn, editPreconditionBtn, removePreconditionBtn, actualNode, true);		
//		fillPropertyPreTable(preConditionsTable, preconditions);
//	}
//	
//	private void createPostConditionProperty(Composite parent, ResponsibilityNode actualNode, List preconditions) {
//		Group respGroup = new Group(parent, SWT.NONE);
//		respGroup.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditResponsibilityDialog.posconditions")); //$NON-NLS-1$
//		respGroup.setLayout(new GridLayout(2, false));		
//		respGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
//	    
//		postConditionsTable = new Table(respGroup, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);
//		GridData gd = new GridData(GridData.FILL_BOTH | GridData.VERTICAL_ALIGN_BEGINNING);
//		gd.verticalSpan = 3;
//		gd.widthHint = 260;
//		gd.heightHint = 80;
//		postConditionsTable.setLayoutData(gd);
//		postConditionsTable.setHeaderVisible(true);
//		postConditionsTable.addListener( SWT.Selection, new Listener() {
//	        public void handleEvent(Event event) {
//	          TableItem[] items = preConditionsTable.getSelection();
//	        }			
//		});	
//				
//		final Button addBtn = new Button(respGroup, SWT.NONE);
//		addBtn.setText(Messages.getString("org.isistan.flabot.edit.editor.editButtonEvent")); //$NON-NLS-1$
//		final Button removeBtn = new Button(respGroup, SWT.NONE);
//		removeBtn.setText(Messages.getString("org.isistan.flabot.edit.editor.removeButtonEvent")); //$NON-NLS-1$
//		gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
//		gd.widthHint = 100;
//		addBtn.setLayoutData(gd);
//		removeBtn.setLayoutData(gd);
//		
//		createEventConditionTable(postConditionsTable, addBtn, removeBtn, actualNode, false);		
//		fillPropertyPosTable(postConditionsTable, preconditions);
//	}
//	
//	
//	private void fillPropertyPreTable(Table table, List properties) {	
//		  for (Iterator iter = properties.iterator(); iter.hasNext();) {
//			  Condition condition = (Condition) iter.next(); 
//			  if (!condition.getType().equals(Condition.previousEvent)){
//				  final TableItem item = new TableItem(table, SWT.NONE);
//			  	  item.setText(new String[] { condition.getName(), condition.getValue()});
//			  	  item.setData(condition);
//			  }
//		}
//	}
//	
//	private void fillPropertyPosTable(Table table, List properties) {	
//		  for (Iterator iter = properties.iterator(); iter.hasNext();) {
//			  Condition condition = (Condition) iter.next(); 
//			  if (condition.getType().equals(Condition.previousEvent)){
//				  final TableItem item = new TableItem(table, SWT.NONE);
//			  	  item.setText(new String[] { condition.getName(), condition.getValue()});
//			  	  item.setData(condition);
//			  }
//		}
//	}
//		
//	private Condition getModifiedCondition(Condition c) {
//		Condition modifiedCondition = (Condition) modifyPreConditions.get(c);
//		if (modifiedCondition == null)
//			modifiedCondition = (Condition) modifyPostConditions.get(c);
//		if (modifiedCondition == null)
//			modifiedCondition = c;
//		return modifiedCondition;
//	}
//	
//	private Vector hasMapping(Table table) {
//		Vector resp = new Vector();
//		for(TableItem item :table.getItems()) {
//			Condition condition = (Condition)item.getData();
//			Condition modify = getModifiedCondition(condition);
//			if (modify.getType().equals(Condition.mappingCondition))
//				resp.add(modify.getDependencyResponsibility());				
//		}
//		return resp;
//	}
//	
//	private List<String> getDependecies(Condition c) {
//		List<String> dependencies = new ArrayList<String>();
//		dependencies.add(Condition.preconditionCondition);
//		dependencies.add(Condition.constraintCondition);
//		dependencies.add(Condition.mappingCondition);
//		return dependencies;
//	}
//	
	public Command getCommand() {
		CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.responsibilitynode.editionitem.ConditionEditionItem.tabCommandLabel")); //$NON-NLS-1$
//		
//		for (Iterator iter = removePreConditions.iterator(); iter.hasNext();) {
//			Condition c = (Condition) iter.next();
//			commands.add( new DeleteConditionFromResponsibilityCommand(resposibilityNode.getResponsibility(), c, true));
//		}
//
//		for (Iterator iter = newPreConditions.iterator(); iter.hasNext();) {
//			Condition c = (Condition) iter.next(); 
//			commands.add( new AddConditionToResponsibilityCommand(resposibilityNode.getResponsibility(), c, true));
//		}
//		
//		for (Iterator iter = removePostConditions.iterator(); iter.hasNext();) {
//			Condition c = (Condition) iter.next();
//			commands.add( new DeleteConditionFromResponsibilityCommand(resposibilityNode.getResponsibility(), c, false));
//		}
//		
//		for (Iterator iter = newPostConditions.iterator(); iter.hasNext();) {
//			Condition c = (Condition) iter.next();
//			commands.add( new AddConditionToResponsibilityCommand(resposibilityNode.getResponsibility(), c, false));
//		}
//		
//		for (Iterator iter = modifyPreConditions.keySet().iterator(); iter.hasNext();) {
//			Condition condition = (Condition) iter.next();
//			addModificationCommand(commands, condition, (Condition) modifyPreConditions.get(condition));
//		}						
//		
//		for (Iterator iter = modifyPostConditions.keySet().iterator(); iter.hasNext();) {
//			Condition condition = (Condition) iter.next();
//			addModificationCommand(commands, condition, (Condition) modifyPostConditions.get(condition));
//		}
//		
//		if(commands.size()==0)
//			return null;
//		else
			return commands;
	}
//	
//	private void addAssociatedNodeToFamilyCommand(CompoundCommand commands, Family family, ResponsibilityNode node) {
//		if (family != null)
//			commands.add( new AddAssociatedNodeToFamilyCommand(family, node));
//	}
//	
//	private void deleteAssociatedNodeFromFamilyCommand(CompoundCommand commands, Family family, ResponsibilityNode node) {
//		if (family != null)
//			commands.add( new DeleteAssociatedNodeFromFamilyCommand(family, node));
//	}
//	
//	private void addModificationCommand(CompoundCommand commands, Condition originalCondition, Condition modifyCondition) {
//		commands.add( new DeleteAssociatedConditionFromConditionEventCommand(originalCondition.getEvent(), originalCondition));
//		deleteAssociatedNodeFromFamilyCommand(commands, originalCondition.getFamily(), originalCondition.getSourceResponsibility());
//		commands.add( new ModifyConditionCommand(originalCondition, modifyCondition));
//		addAssociatedNodeToFamilyCommand(commands, modifyCondition.getFamily(), modifyCondition.getSourceResponsibility());
//		commands.add( new AddAssociatedConditionToConditionEventCommand(modifyCondition.getEvent(), originalCondition));
//	}
	
	public boolean canCreateCommand() {
		return true;
	}

	public EditionItemStatus getStatus() {
		return EditionItemStatus.DEFAULT_OK;
	}

	public boolean accepts(Responsibility element) {
		return true;
	}
}
