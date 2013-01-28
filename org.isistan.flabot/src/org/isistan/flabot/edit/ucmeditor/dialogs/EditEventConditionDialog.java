package org.isistan.flabot.edit.ucmeditor.dialogs;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
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
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.edit.ucmeditor.commands.model.AddConditionToResponsibilityCommand;
import org.isistan.flabot.edit.ucmeditor.commands.model.ModifyConditionCommand;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.SorterToTable;
import org.isistan.flabot.util.ValidatorSorterTable;

public class EditEventConditionDialog extends Dialog {
	
	private Shell shell = null;
	private Table eventTable; 
	private multiHashtable auxiliarTableToEvent = new multiHashtable();
	private Hashtable combosTableToEvent = new Hashtable(); 
	private Hashtable editorsTableToEvent = new Hashtable();
	protected int exitValue = SWT.CANCEL;	
	private Vector newConditions = new Vector();
	
	private Hashtable modifyConditions = new Hashtable();	
	private List conditions;
	private Hashtable finishModifyConditions = new Hashtable();
	private ResponsibilityNode responsibility;
	
	public EditEventConditionDialog(Shell parent) {
		super(parent, 0);
	}
	
	public Command open(List conditions, ResponsibilityNode responsibility) {
		this.conditions = conditions;
		this.responsibility = responsibility;
		for (int i=0; i < conditions.size(); i++){
			modifyConditions.put(conditions.get(i),CoremodelFactory.eINSTANCE.createCondition((Condition)conditions.get(i)));
		}		
		initEditEvent();
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
	
	public void initEditEvent (){		
		createShell();	
		
		for (int i=0; i<conditions.size(); i++) {
			 Condition condition = (Condition) conditions.get(i);
			 for (int j = 0; j < eventTable.getItems().length; j++) {
				TableItem item = eventTable.getItems()[j];
				if (item.getData().equals(condition.getDependencyResponsibility())){
					TableEditor editor = (TableEditor)editorsTableToEvent.get(item);
					CCombo combo = ((CCombo)editor.getEditor());
					for (int k = 0; k < combo.getItemCount(); k++) {
						if((Integer)auxiliarTableToEvent.get(combo,condition.getEvent())==k){
							combo.select(k);
							break;
						}
					}
				}
			}
		}
	}
	
	private void createShell() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditConditionEventDialog.editEvent")); //$NON-NLS-1$
		shell.setLayout(new GridLayout(1, true));
		
		shell.addShellListener(new org.eclipse.swt.events.ShellAdapter() {				
			public void shellClosed(org.eclipse.swt.events.ShellEvent e) {
				handleCancel();
			}
		});		
		
		createEvents(shell);
	}
	
	private Command getCommand() {
		if (exitValue == SWT.OK){
			CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.editor.editparts.ConditionEditPart.setConditionEventCommandLabel")); //$NON-NLS-1$
			Condition key, value;
            for (Enumeration e=modifyConditions.keys(); e.hasMoreElements();) {
            	key = (Condition)e.nextElement();
                value = (Condition)modifyConditions.get(key);
                Command command = new ModifyConditionCommand(key,value);
                commands.add(command);
             }
			for (int i = 0; i < newConditions.size(); i++) {
				Condition condition = (Condition) newConditions.get(i);
				Command command = new AddConditionToResponsibilityCommand(responsibility.getResponsibility(),condition,true);
				commands.add(command);
			}			
			if (commands.size() == 0) return null;
			return commands;
		}
		return null;	
	}
	
	private void createEvents(Shell shell) {
		Composite respGroup = new Composite(shell, SWT.NONE);
			
		respGroup.setLayout(new GridLayout(1, false));		
		respGroup.setLayoutData(new GridData(GridData.FILL_BOTH));

		createEvents(respGroup);
		
		updateEventTableToAdd();
		
	}
	
	private List getEvents(Vector architecturalMaps) {
		Vector currentEvents = new Vector();
		for (int i = 0; i < eventTable.getItemCount(); i++) {
			currentEvents.add((ConditionEvent)eventTable.getItem(i).getData());
		}
		Vector result = new Vector();
		EList events;
		for (int i=0; i<architecturalMaps.size();i++){
			UseCaseMap useCaseMap = (UseCaseMap) architecturalMaps.get(i);
			if (useCaseMap.getComponentRoles().size()>0){
				ComponentRole role = (ComponentRole)useCaseMap.getComponentRoles().get(0);
				events = role.getMap().getCoreModel().getEvents();
				for (int j=0; j<events.size();j++){
					if (!currentEvents.contains(events.get(j))){
						result.add(events.get(j));
					}
				}
				break;
			}
		}
		return result;
	}
	
	private void updateEventTableToAdd() {
		Vector architecturalMaps = new Vector();
		architecturalMaps.add(responsibility.getRole().getMap());
		List events = getEvents(architecturalMaps);
		Vector allEvents = new Vector();
		for (int i=0; i<architecturalMaps.size();i++){
			UseCaseMap useCaseMap = (UseCaseMap) architecturalMaps.get(i);
			if (useCaseMap.getComponentRoles().size()>0){
				ComponentRole role = (ComponentRole)useCaseMap.getComponentRoles().get(0);
				allEvents.addAll(role.getMap().getCoreModel().getEvents());
				break;
			}
		}
		Vector previous = new Vector();
		for (int i=0; i<responsibility.uGetPrevious().size(); i++) {
            SimplePathNode prev = getPrevious((SimplePathNode)responsibility.uGetPrevious().get(i));
			if (prev!=null){
            	previous.add(prev);
            }
		}	
		for (int i=0; i<previous.size(); i++) {
            setComboBoxToEvents(eventTable,(SimplePathNode) previous.get(i),allEvents);
		}	
	}
	
	public SimplePathNode getPrevious (SimplePathNode node){
		if (node instanceof ResponsibilityNode || node instanceof StubNode){
			return (node);
		}	
		else
			if (node.uGetPrevious().size() > 0){
				return getPrevious ((SimplePathNode)node.uGetPrevious().get(0));
			}
			else {
				return null;
			}
	}
	
	private void setComboBoxToEvents(Table table, SimplePathNode value, List events){
		final TableItem item = new TableItem(table, SWT.NONE);
	    item.setText(new String[] { value.getName(), value.getMap().getName()});
	    item.setData(value);
	   	TableEditor editor = new TableEditor(table);
	   	final CCombo comboRole = new CCombo(table, SWT.READ_ONLY);
	   	GridData gd = new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL);
		gd.widthHint = 200;
		comboRole.setLayoutData(gd);          	
	   	int k = -1;
	   	for (int j=0; j < events.size(); j++) {
			ConditionEvent c = (ConditionEvent)events.get(j);
			comboRole.add(c.getName());
			comboRole.setData(String.valueOf(j), c);		
			auxiliarTableToEvent.put(comboRole,c,new Integer(j));
			if (value.equals(c)){
				k = j;
			}
		}
	   	if (k!=-1)
	   		comboRole.select(k);
	   	else
	   		comboRole.select(comboRole.getItemCount()-1);
	   	editor.grabHorizontal = true;
	    editor.setEditor(comboRole, item, 2);
	    editorsTableToEvent.put(item,editor);
	    combosTableToEvent.put(item,comboRole);
	}
	
	private void createEvents(Composite Group) {
		Group respGroup = new Group(Group, SWT.NONE);
		respGroup.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditConditionEventDialog.eventTitle")); //$NON-NLS-1$
		respGroup.setLayout(new GridLayout(2, false));		
		respGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		eventTable = new Table(respGroup, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);
		
		final GridData gd = new GridData(GridData.FILL_BOTH);
		gd.widthHint = 500;
		gd.heightHint = 100; 
		gd.verticalSpan = 3;
		eventTable.setLayoutData(gd);
		eventTable.setHeaderVisible(true);
		
		final TableColumn tc1 = new TableColumn(eventTable, SWT.LEFT);
		tc1.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditResponsibilityDialog.responsibilityName")); //$NON-NLS-1$
		tc1.setWidth(130);				
		final TableColumn tc2 = new TableColumn(eventTable, SWT.LEFT);
		tc2.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.properties.MapPropertySource.mapName")); //$NON-NLS-1$
		tc2.setWidth(170);
		final TableColumn tc3 = new TableColumn(eventTable, SWT.LEFT);
		tc3.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditDependencyDialog.conditionEvent")); //$NON-NLS-1$
		tc3.setWidth(215);
		final SorterToTable sorter = new SorterToTable(eventTable, new Validator(true,2,combosTableToEvent,editorsTableToEvent));
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
		tc3.addListener(SWT.Selection, new Listener() {
			   public void handleEvent(Event e) {
				   sorter.setColumn(tc3);
				   sorter.reverseDirection();
				   sorter.order();
			   }
		});
		
	    // buttons composite (ok and cancel)	
		Composite buttonsComposite = new Composite(shell, SWT.NONE);
		buttonsComposite.setLayout(new RowLayout());
		buttonsComposite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
	
		Button buttonOK = new Button(buttonsComposite, SWT.NONE);
		buttonOK.setText(Messages.getString("org.isistan.flabot.edit.editor.okButton")); //$NON-NLS-1$
		buttonOK.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				exitValue = SWT.OK;
				setConditions();
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
		
			
	}
	protected void setConditions() {
		for (int i=0; i < eventTable.getItemCount(); i++){
			TableItem item = eventTable.getItems()[i];
			ResponsibilityNode node = (ResponsibilityNode) item.getData();
			boolean existisCondition = false;
			int j=0;
			for (j = 0; j < conditions.size(); j++) {
				if (((Condition)conditions.get(j)).getDependencyResponsibility().equals(node)){
					existisCondition = true;
					break;
				}
			}
			if (existisCondition){
				Condition condition = (Condition)conditions.get(j);
				Condition modifyCondition = (Condition)modifyConditions.get(condition);
				TableEditor editor = (TableEditor)editorsTableToEvent.get(item);
				CCombo combo = ((CCombo)editor.getEditor());
				modifyCondition.setEvent((ConditionEvent)combo.getData(String.valueOf(combo.getSelectionIndex())));
				String dependency = 
					modifyCondition.getType() + 
				"( "  + modifyCondition.getName() + //$NON-NLS-1$
				", "  + modifyCondition.getDependencyResponsibility().getName() + //$NON-NLS-1$
				", "  + modifyCondition.getUseCaseMap().getName() + //$NON-NLS-1$
				", "  + modifyCondition.getEvent().getName() + //$NON-NLS-1$
				" )."; //$NON-NLS-1$
				modifyCondition.setValue(dependency);
				finishModifyConditions.put(condition,modifyCondition);
			}
			else{
				Condition condition = CoremodelFactory.eINSTANCE.createCondition();
				condition.setDependencyResponsibility(node);
				TableEditor editor = (TableEditor)editorsTableToEvent.get(item);
				CCombo combo = ((CCombo)editor.getEditor());
				condition.setEvent((ConditionEvent)combo.getData(String.valueOf(combo.getSelectionIndex())));
				condition.setSourceResponsibility(responsibility);
				condition.setType(Condition.previousEvent);
				condition.setUseCaseMap(node.getMap());
				condition.setName(Condition.previousEvent);
				String dependency = 
				       condition.getType() + 
				"( "  + condition.getName() + //$NON-NLS-1$
				", "  + condition.getDependencyResponsibility().getName() + //$NON-NLS-1$
				", "  + condition.getUseCaseMap().getName() + //$NON-NLS-1$
				", "  + condition.getEvent().getName() + //$NON-NLS-1$
				" )."; //$NON-NLS-1$
				condition.setValue(dependency);
				newConditions.add(condition);
			}
				
		}
		
	}

	private void handleCancel() {
		exitValue = SWT.CANCEL;
		shell.dispose();
	}
	
	public Vector getNewConditions(){
		return newConditions;
	}
	
	public Hashtable getModifyConditions(){
		return finishModifyConditions;
	}
	
class Validator implements ValidatorSorterTable {
		
		private boolean checkBox;
		private int values;
		private CCombo combo;
		private TableEditor editor;
		private Hashtable combosTable; 
		private Hashtable editorsTable;

		public Validator (boolean checkBox, int values, Hashtable combosTable, Hashtable editorsTable){
			this.checkBox = checkBox;
			this.values = values;
			this.combosTable = combosTable;
			this.editorsTable = editorsTable;
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
			 return false;
		}
		
		public void setCountValues (int values){
			this.values = values;
		}
		
		public void setExistsCheckBox (boolean check){
			this.checkBox = check;
		}
		
		public void setObejct (Object object){

		}

		public String getText(TableItem item, int column) {
			if (column==2){
				return ((CCombo)combosTable.get(item)).getText();
			}
			else{
				return item.getText(column);
			}
		}

		public void setValuesToItem(Table table, TableItem item, String[] values, Object valueData, TableItem newitem) {
			item.setText(values);
            item.setData(valueData);
            Object key;
            Object value;
            Hashtable newCombosTable = new Hashtable();
            for (Enumeration e=combosTable.keys(); e.hasMoreElements();) {
                key = (Object)e.nextElement();
                value = (Object)combosTable.get(key);
                if (!value.equals(combo)){
                	newCombosTable.put(key,value);
                }
            }
            editor = new TableEditor(table);
            combosTable = newCombosTable;
            editor.grabHorizontal = true;
            editor.setEditor(combo, item, 2);
            combosTable.put(item,combo);
            editorsTable.put(item,editor);           
		}

		public void setObejctItem(TableItem item) {
			combo = (CCombo) combosTable.get(item);	
		}

		public void initOrder() {}
	}

private class multiHashtable {
	
	private Hashtable map= new Hashtable();
	
	public multiHashtable(){}
	
	public void put(Object key1, Object key2, Object value){
		Vector key;
		Vector list=null;
		for (Enumeration e=map.keys(); e.hasMoreElements();) {
            key = (Vector)e.nextElement();
            if (key.get(0).equals(key1)&&key.get(1).equals(key2)){        
           	 list = key;
           	 break;
            }
		}
		if (list==null){
			list = new Vector();
		}
		list.clear();
		list.add(0,key1);
		list.add(1,key2);
		map.put(list,value);
	}
	
	public Object get(Object key1, Object key2){
		Vector key;
		for (Enumeration e=map.keys(); e.hasMoreElements();) {
             key = (Vector)e.nextElement();
             if (key.get(0).equals(key1)&&key.get(1).equals(key2))
            	 return map.get(key);
		}
		return null;
	}		
	}	
}
