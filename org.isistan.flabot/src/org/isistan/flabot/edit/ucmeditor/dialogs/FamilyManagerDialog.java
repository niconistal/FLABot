/**
 * $Id: FamilyManagerDialog.java,v 1.20 2006/05/09 00:50:37 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.edit.ucmeditor.dialogs;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.dialogs.MessageDialog;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.coremodel.FamilyElement;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.PathNode;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.coremodel.impl.ConditionEventToConditionEventMapEntryImpl;
import org.isistan.flabot.edit.ucmeditor.commands.model.ModifyFamilyCommand;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.DefualtValidatorSorter;
import org.isistan.flabot.util.SorterToTable;
import org.isistan.flabot.util.ValidatorSorterTable;

/**
 * @author $Author: dacostae $
 *
 */
public class FamilyManagerDialog extends Dialog {

	/**
	 * the dialog's shell
	 */
	private Shell shell = null;  //  @jve:decl-index=0:visual-constraint="10,9"
	private Table mappedTable;
	private Table architecturalUseCaseMapTable;
	private Table functionalUseCaseMapTable;
	private Table eventTable;
	private Text familyName;

	private multiHashtable auxiliarTable = new multiHashtable();
	private Hashtable combosTable = new Hashtable(); 
	private Hashtable editorsTable = new Hashtable();
	
	private multiHashtable auxiliarTableToEvent = new multiHashtable();
	private Hashtable combosTableToEvent = new Hashtable(); 
	private Hashtable editorsTableToEvent = new Hashtable();	
	
	private Family originalFamily;	
	private Family modifyFamily;
	
	private int exitValue;
	
	public FamilyManagerDialog(Shell parent) {
		super(parent, 0);
	}
	
	public Command open(Family originalFamily, List ArchitecturalUseCaseMaps, List FunctionalUseCaseMaps) {
		this.originalFamily = originalFamily;
		this.modifyFamily = CoremodelFactory.eINSTANCE.createFamily(originalFamily);
		
		initEditFamily(ArchitecturalUseCaseMaps, FunctionalUseCaseMaps, modifyFamily);
		
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
	
	private void createShell() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.FamilyManagerDialog.editFamily")); //$NON-NLS-1$
		shell.setLayout(new GridLayout(1, true));
		
		shell.addShellListener(new org.eclipse.swt.events.ShellAdapter() {				
			public void shellClosed(org.eclipse.swt.events.ShellEvent e) {
				handleCancel();
			}
		});		
	}
	
	private void createUseCaseMaps(Shell shell, final List ArchitecturalUseCaseMaps, List functionalUseCaseMaps) {
		Composite respGroup = new Composite(shell, SWT.NONE);
			
		respGroup.setLayout(new GridLayout(1, false));		
		respGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		createNameFamily(respGroup);
		createArchitecturalUseCaseMaps(respGroup, ArchitecturalUseCaseMaps);
		//functionalUseCaseMaps.addAll(ArchitecturalUseCaseMaps);
		createFunctionalUseCaseMaps(respGroup, functionalUseCaseMaps);
		createMappedComponents(respGroup);
	}
	
	private void createNameFamily(Composite Group) {
		Group respGroup = new Group(Group, SWT.NONE);
		respGroup.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.FamilyManagerDialog.family")); //$NON-NLS-1$
		respGroup.setLayout(new GridLayout(2, false));		
		respGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		final Label label = new Label(respGroup, SWT.NONE);
		label.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.FamilyManagerDialog.familyName"));  //$NON-NLS-1$
		
		familyName = new Text(respGroup, SWT.BORDER);
		familyName.setLayoutData(new GridData(
					GridData.VERTICAL_ALIGN_BEGINNING |
					GridData.FILL_HORIZONTAL));
		
	}

	private void createMappedComponents(Composite Group) {
		Group respGroup = new Group(Group, SWT.NONE);
		respGroup.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.FamilyManagerDialog.componentFamily")); //$NON-NLS-1$
		respGroup.setLayout(new GridLayout(2, false));		
		respGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		mappedTable = new Table(respGroup, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);
		
		final GridData gd = new GridData(GridData.FILL_BOTH);
		gd.widthHint = 500;
		gd.heightHint = 100;
		gd.verticalSpan = 3;
		mappedTable.setLayoutData(gd);
		mappedTable.setHeaderVisible(true);
		
		final TableColumn tc1 = new TableColumn(mappedTable, SWT.LEFT);
		tc1.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.FamilyManagerDialog.baseComponent")); //$NON-NLS-1$
		tc1.setWidth(130);				
		final TableColumn tc2 = new TableColumn(mappedTable, SWT.LEFT);
		tc2.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.properties.RolePropertySource.Abstract_Info")); //$NON-NLS-1$
		tc2.setWidth(170);
		final TableColumn tc3 = new TableColumn(mappedTable, SWT.LEFT);
		tc3.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.FamilyManagerDialog.implementedComponent")); //$NON-NLS-1$
		tc3.setWidth(215);
		final SorterToTable sorter = new SorterToTable(mappedTable, new Validator(true,2,combosTable,editorsTable));
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
		
	}

	private void createArchitecturalUseCaseMaps(Composite parent, final List useCaseMaps) {
		Group respGroup = new Group(parent, SWT.NONE);
		respGroup.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.FamilyManagerDialog.architecturalUseCaseMaps")); //$NON-NLS-1$
		respGroup.setLayout(new GridLayout(2, false));		
		respGroup.setLayoutData(new GridData(GridData.FILL_BOTH));		
	    
		architecturalUseCaseMapTable = new Table(respGroup, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);
		GridData gd = new GridData(GridData.FILL_BOTH | GridData.VERTICAL_ALIGN_BEGINNING);
		gd.verticalSpan = 3;
		gd.widthHint = 260;
		gd.heightHint = 80;
		architecturalUseCaseMapTable.setLayoutData(gd);
		architecturalUseCaseMapTable.setHeaderVisible(true);
				
		final Button addBtn = new Button(respGroup, SWT.NONE);
		addBtn.setText(Messages.getString("org.isistan.flabot.edit.editor.addButton")); //$NON-NLS-1$
		addBtn.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
		addBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				UseCaseMapDialog componentDialog = new UseCaseMapDialog(shell);
				Vector selectedItems = new Vector();
				for (int i = 0; i < architecturalUseCaseMapTable.getItems().length; i++) {
					selectedItems.add(architecturalUseCaseMapTable.getItems()[i].getData());
				}
				int exitValue = componentDialog.open(useCaseMaps,selectedItems,true);
				if (componentDialog.getSelectedUseCaseMap()!=null&&componentDialog.getSelectedUseCaseMap().size()>0&&exitValue==SWT.OK){
					Vector useCaseMaps = validateUseCaseMaps(componentDialog.getSelectedUseCaseMap(),new Vector());
					fillPropertyTable(architecturalUseCaseMapTable,useCaseMaps);
					updateTablesToAddArchitecturalUseCaseMap(useCaseMaps,functionalUseCaseMapTable,mappedTable);
				}
			}
		});
		
		final Button removeBtn = new Button(respGroup, SWT.NONE);
		removeBtn.setText(Messages.getString("org.isistan.flabot.edit.editor.removeButton")); //$NON-NLS-1$
		removeBtn.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
		removeBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				TableItem[] items = architecturalUseCaseMapTable.getSelection();
		          if (items.length == 1){
		        	  updateTablesToRemoveArchitecturalUseCaseMap((UseCaseMap) architecturalUseCaseMapTable.getItem(architecturalUseCaseMapTable.getSelectionIndex()).getData());
		        	  architecturalUseCaseMapTable.remove(architecturalUseCaseMapTable.getSelectionIndex());
		        	  updateEventTableToRemove();
		          }
		          	  
		        }			
		});
		
		createTable(architecturalUseCaseMapTable, addBtn, removeBtn, useCaseMaps);		
	}
	
	protected Vector validateUseCaseMaps(List selectedUseCaseMap, Vector auxiliar) {
		auxiliar.clear();
		auxiliar.addAll(selectedUseCaseMap);
		for(int i=0; i<selectedUseCaseMap.size(); i++){
			UseCaseMap useCaseMap = (UseCaseMap) selectedUseCaseMap.get(i);
			for (int j=0; j<useCaseMap.getPaths().size();j++){
				Path path = (Path)useCaseMap.getPaths().get(j);
				for (int k=0; k<path.getNodes().size();k++){
					PathNode node = (PathNode) path.getNodes().get(k);
					if (node instanceof ResponsibilityNode){
						for (int h=0; h<((ResponsibilityNode)node).getResponsibility().getPreconditions().size();h++){
							Condition condition = (Condition) ((ResponsibilityNode)node).getResponsibility().getPreconditions().get(h);
							if (!condition.getType().equals(Condition.mappingCondition)&&!selectedUseCaseMap.contains(condition.getDependencyResponsibility().getMap())){
								auxiliar.add(condition.getDependencyResponsibility().getMap());
								return validateUseCaseMaps(auxiliar,new Vector());
							}
						}	
					}
					if (node instanceof StubNode){
						if (!selectedUseCaseMap.contains(((StubNode)node).getReferencedMap())){
							auxiliar.add(((StubNode)node).getReferencedMap());
							return validateUseCaseMaps(auxiliar,new Vector());
						}
					}
				}
			}
		}
		return auxiliar;
	}

	protected void updateTablesToRemoveArchitecturalUseCaseMap(UseCaseMap object) {
		for (int i=mappedTable.getItems().length-1; i>=0; i--){
			if(((ComponentRole)mappedTable.getItems()[i].getData()).getMap().equals(object)){
				TableEditor editor = (TableEditor)editorsTable.get(mappedTable.getItems()[i]);
				editor.getEditor().dispose();
				mappedTable.remove(i);		
			}
		}
	}

	private void updateEventTableToAdd() {
		Vector architecturalMaps = new Vector();
		for (int i=0; i<architecturalUseCaseMapTable.getItemCount();i++){
			architecturalMaps.add(architecturalUseCaseMapTable.getItem(i).getData());
		}
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
		for (int i=0; i<events.size(); i++) {
            setComboBoxToEvents(eventTable,(ConditionEvent) events.get(i),allEvents);
		}	
	}
	
	protected void updateEventTableToRemove() {
		Vector currentEvents = new Vector();
		for (int i=0; i<eventTable.getItemCount();i++){
			currentEvents.add(eventTable.getItem(i).getData());
		}
		Vector architecturalMaps = new Vector();
		for (int i=0; i<architecturalUseCaseMapTable.getItemCount();i++){
			architecturalMaps.add(architecturalUseCaseMapTable.getItem(i).getData());
		}
		List events = getEvents(architecturalMaps);
		currentEvents.removeAll(events);
		for (int i=currentEvents.size()-1; i>=0; i--){
				TableEditor editor = (TableEditor)editorsTableToEvent.get(getItemEvent(currentEvents.get(i)));
				editor.getEditor().dispose();
				eventTable.remove(i);		
		}
	
	}
	
	

	private Object getItemEvent(Object object) {
		for(int i=0; i<eventTable.getItemCount();i++){
			TableItem item = eventTable.getItems()[i];
			if (item.getData().equals(object))
				return item;
		}
		return null;
	}

	private void handleCancel() {
		exitValue = SWT.CANCEL;
		shell.dispose();
	}
	
	protected void updateTablesToAddArchitecturalUseCaseMap(List architecturalUseCaseMapTable, Table functionalUseCaseMapTable, Table mappedTable) {
			Vector auxiliarTableToarchitecturalUseCaseMapTable = new Vector();
			Vector auxiliarTableTofunctionalUseCaseMapTable = new Vector();
			for (int i=0; i < architecturalUseCaseMapTable.size(); i++){
				auxiliarTableToarchitecturalUseCaseMapTable.addAll(((UseCaseMap)architecturalUseCaseMapTable.get(i)).getComponentRoles());
			}
			for (int i=0; i < functionalUseCaseMapTable.getItems().length; i++){
				auxiliarTableTofunctionalUseCaseMapTable.addAll(((UseCaseMap)functionalUseCaseMapTable.getItems()[i].getData()).getComponentRoles());
			}
			fillPropertyTable(mappedTable,auxiliarTableToarchitecturalUseCaseMapTable,auxiliarTableTofunctionalUseCaseMapTable,null);
			updateEventTableToAdd();
	}

	private void createFunctionalUseCaseMaps(Composite parent, final List useCaseMaps) {
		Group respGroup = new Group(parent, SWT.NONE);
		respGroup.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.FamilyManagerDialog.functionalUseCaseMaps")); //$NON-NLS-1$
		respGroup.setLayout(new GridLayout(2, false));		
		respGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
	    
		functionalUseCaseMapTable = new Table(respGroup, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);
		GridData gd = new GridData(GridData.FILL_BOTH | GridData.VERTICAL_ALIGN_BEGINNING);
		gd.verticalSpan = 3;
		gd.widthHint = 260;
		gd.heightHint = 80;
		functionalUseCaseMapTable.setLayoutData(gd);
		functionalUseCaseMapTable.setHeaderVisible(true);
				
		final Button addBtn = new Button(respGroup, SWT.NONE);
		addBtn.setText(Messages.getString("org.isistan.flabot.edit.editor.addButton")); //$NON-NLS-1$
		addBtn.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
		addBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				UseCaseMapDialog componentDialog = new UseCaseMapDialog(shell);
				Vector selectedItems = new Vector();
				for (int i = 0; i < functionalUseCaseMapTable.getItems().length; i++) {
					selectedItems.add(functionalUseCaseMapTable.getItems()[i].getData());
				}
				int exitValue = componentDialog.open(useCaseMaps,selectedItems,true);
				if (componentDialog.getSelectedUseCaseMap()!=null&&componentDialog.getSelectedUseCaseMap().size()>0&&exitValue==SWT.OK){
					fillPropertyTable(functionalUseCaseMapTable,componentDialog.getSelectedUseCaseMap());
					for (int i=0; i<componentDialog.getSelectedUseCaseMap().size(); i++)
						updateTablesToAddFunctionalUseCaseMap((UseCaseMap)componentDialog.getSelectedUseCaseMap().get(i));
				}
			}
		});
		
		final Button removeBtn = new Button(respGroup, SWT.NONE);
		removeBtn.setText(Messages.getString("org.isistan.flabot.edit.editor.removeButton")); //$NON-NLS-1$
		removeBtn.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
		removeBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				  TableItem[] items = functionalUseCaseMapTable.getSelection();
		          if (items.length == 1){
		        	  updateTablesToRemoveFunctionalUseCaseMap((UseCaseMap) functionalUseCaseMapTable.getItem(functionalUseCaseMapTable.getSelectionIndex()).getData());
		        	  functionalUseCaseMapTable.remove(functionalUseCaseMapTable.getSelectionIndex());
		          }
		          	  
		        }			
		});
		
		createTable(functionalUseCaseMapTable, addBtn, removeBtn, useCaseMaps);		
	}
	
	protected void updateTablesToAddFunctionalUseCaseMap(UseCaseMap map) {
		for (int i=mappedTable.getItems().length-1; i>=0; i--){
			TableEditor editor = (TableEditor)editorsTable.get(mappedTable.getItems()[i]);
			for (int j=0; j < map.getComponentRoles().size(); j++){
				ComponentRole c = (ComponentRole)map.getComponentRoles().get(j);
				int index = ((CCombo)editor.getEditor()).getItemCount();
				((CCombo)editor.getEditor()).add(c.getFullName());
				((CCombo)editor.getEditor()).setData(String.valueOf(index), c);
				auxiliarTable.put((CCombo)editor.getEditor(),c,new Integer(index));
			}	
		}
		
	}
	
	protected void updateTablesToRemoveFunctionalUseCaseMap(UseCaseMap map) {
		for (int i=mappedTable.getItems().length-1; i>=0; i--){
			TableEditor editor = (TableEditor)editorsTable.get(mappedTable.getItems()[i]);
			for (int j=map.getComponentRoles().size()-1; j >= 0; j--){
				ComponentRole c = (ComponentRole)map.getComponentRoles().get(j);
				Integer index = (Integer)auxiliarTable.get(editor.getEditor(),c);
				if (((CCombo)editor.getEditor()).getSelectionIndex()==index){
					((CCombo)editor.getEditor()).select(0);
				}
				((CCombo)editor.getEditor()).remove(index);
				((CCombo)editor.getEditor()).redraw();
			}	
		}
		
	}

	private void fillPropertyTable(Table table, List properties) {	
		  for (Iterator iter = properties.iterator(); iter.hasNext();) {
			  UseCaseMap useCaseMap = (UseCaseMap) iter.next(); 
			  final TableItem item = new TableItem(table, SWT.NONE);
			  item.setText(new String[] { useCaseMap.getName(), useCaseMap.getDescription()});
			  item.setData(useCaseMap);
		}
	}
	
	
	
	private void createTable(final Table table, final Button addBtn, final Button removeBtn, final List conditions) {			
		  final TableColumn tc1 = new TableColumn(table, SWT.LEFT);
		  tc1.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditResponsibilityDialog.conditionName")); //$NON-NLS-1$
		  tc1.setWidth(100);				
		  final TableColumn tc2 = new TableColumn(table, SWT.LEFT);
		  tc2.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.FamilyDialog.description")); //$NON-NLS-1$
		  tc2.setWidth(175);
		  final SorterToTable sorter = new SorterToTable(table, new DefualtValidatorSorter(false,2));
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
	}
	
	private void fillPropertyTable(Table table, Vector properties, Vector componentsToMap, Family family) {		
		for (int i=0; i<properties.size(); i++) {
	             setComboBox(table,(ComponentRole) properties.get(i),componentsToMap);
		}
	}

	private void setComboBox(Table table, ComponentRole value, List componentsToMap){
		final TableItem item = new TableItem(table, SWT.NONE);
	    item.setText(new String[] { value.getFullName(), value.getAbstractInfo()});
	    item.setData(value);
	   	TableEditor editor = new TableEditor(table);
	   	final CCombo comboRole = new CCombo(table, SWT.READ_ONLY);
	   	GridData gd = new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL);
		gd.widthHint = 200;
		comboRole.setLayoutData(gd);          	
	   	int j=0;
	   	for (j=0; j < componentsToMap.size(); j++) {
			ComponentRole c = (ComponentRole)componentsToMap.get(j);
			comboRole.add(c.getFullName());
			comboRole.setData(String.valueOf(j), c);
			auxiliarTable.put(comboRole,c,new Integer(j));
		}
	   	if (value.getAbstractInfo().equals(ComponentRole.standardComponent)){
	    	comboRole.add(value.getFullName());
	    	comboRole.setData(String.valueOf(j), value);
	    	comboRole.select(j);
	    	auxiliarTable.put(comboRole,value,new Integer(j));
	    }
	   	else {
	   		comboRole.add(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.FamilyManagerDialog.noneRole")); //$NON-NLS-1$
	    	comboRole.setData("None", "None"); //$NON-NLS-1$ //$NON-NLS-2$
			comboRole.select(j);
	   	}
	   	editor.grabHorizontal = true;
	    editor.setEditor(comboRole, item, 2);
	    editorsTable.put(item,editor);
	    combosTable.put(item,comboRole);
	}
	
	private void setComboBoxToEvents(Table table, ConditionEvent value, List events){
		final TableItem item = new TableItem(table, SWT.NONE);
	    item.setText(new String[] { value.getName(), value.getDescription()});
	    item.setData(value);
	   	TableEditor editor = new TableEditor(table);
	   	final CCombo comboRole = new CCombo(table, SWT.READ_ONLY);
	   	GridData gd = new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL);
		gd.widthHint = 200;
		comboRole.setLayoutData(gd);          	
	   	int k = 0;
	   	for (int j=0; j < events.size(); j++) {
			ConditionEvent c = (ConditionEvent)events.get(j);
			comboRole.add(c.getName());
			comboRole.setData(String.valueOf(j), c);		
			auxiliarTableToEvent.put(comboRole,c,new Integer(j));
			if (value.equals(c)){
				k = j;
			}
		}
	   	comboRole.select(k);
	   	editor.grabHorizontal = true;
	    editor.setEditor(comboRole, item, 2);
	    editorsTableToEvent.put(item,editor);
	    combosTableToEvent.put(item,comboRole);
	}
	
	public void initEditFamily (List ArchitecturalUseCaseMaps, List FunctionalUseCaseMaps, Family family){		
		createShell();		
		Vector functionalMaps = new Vector();
		functionalMaps.addAll(FunctionalUseCaseMaps);
		functionalMaps.removeAll(ArchitecturalUseCaseMaps);
		createUseCaseMaps(shell, ArchitecturalUseCaseMaps, functionalMaps);		
		fillPropertyTable(architecturalUseCaseMapTable,family.getArchitecturalUseCaseMaps());		
		createEvents(shell, architecturalUseCaseMapTable);
		updateTablesToAddArchitecturalUseCaseMap(family.getArchitecturalUseCaseMaps(),functionalUseCaseMapTable,mappedTable);		
		fillPropertyTable(functionalUseCaseMapTable,family.getFunctionalUseCaseMaps());
		
		for (int i=0; i<family.getFunctionalUseCaseMaps().size(); i++)
			updateTablesToAddFunctionalUseCaseMap((UseCaseMap)family.getFunctionalUseCaseMaps().get(i));
		
		for (int i = 0; i < family.getFamilyElement().size(); i++) {
			FamilyElement familyElement = (FamilyElement) family.getFamilyElement().get(i);
			for (int j = 0; j < mappedTable.getItems().length; j++) {
				TableItem item = mappedTable.getItems()[j];
				if (item.getData().equals(familyElement.getArchitecturalComponent())){
					TableEditor editor = (TableEditor)editorsTable.get(item);
					CCombo combo = ((CCombo)editor.getEditor());
					for (int k = 0; k < combo.getItemCount(); k++) {
						if(auxiliarTable.get(combo,familyElement.getFunctionalComponent())!=null && (Integer)auxiliarTable.get(combo,familyElement.getFunctionalComponent())==k){
							combo.select(k);
							break;
						}
					}
				}
			}
		}
		
		Vector auxComponents = new Vector();
		for(int i=0;i< family.getFunctionalUseCaseMaps().size();i++){
			for (int j=0; j< ((UseCaseMap)family.getFunctionalUseCaseMaps().get(i)).getComponentRoles().size();j++){
				if (!auxComponents.contains(((UseCaseMap)family.getFunctionalUseCaseMaps().get(i)).getComponentRoles().get(j))){
					auxComponents.add(((UseCaseMap)family.getFunctionalUseCaseMaps().get(i)).getComponentRoles().get(j));
				}
			}
		}
		
		Vector architecturalMap = validateUseCaseMaps(family.getArchitecturalUseCaseMaps(),new Vector());
		for (int i=0; i<architecturalMap.size(); i++){
			UseCaseMap useCaseMap = (UseCaseMap) architecturalMap.get(i);
			for (int j=0; j < useCaseMap.getComponentRoles().size(); j++){
				boolean findComponent = false;
				for (int k = 0; k < mappedTable.getItems().length; k++) {
					TableItem item = mappedTable.getItems()[k];
					if (item.getData().equals(useCaseMap.getComponentRoles().get(j))){
						findComponent = true;
						break;
					}
				}
				if (!findComponent){
					boolean existsUseCaseMap = false;
					for (int k = 0; k < architecturalUseCaseMapTable.getItems().length; k++) {
						TableItem item = architecturalUseCaseMapTable.getItems()[k];
						if (item.getData().equals(((ComponentRole) useCaseMap.getComponentRoles().get(j)).getMap())){
							existsUseCaseMap = true;
							break;
						}
					}
					if (!existsUseCaseMap){
						 final TableItem item = new TableItem(architecturalUseCaseMapTable, SWT.NONE);
						 item.setText(new String[] { ((ComponentRole) useCaseMap.getComponentRoles().get(j)).getMap().getName(), ((ComponentRole) useCaseMap.getComponentRoles().get(j)).getMap().getDescription()});
						 item.setData(((ComponentRole) useCaseMap.getComponentRoles().get(j)).getMap());
					}
					setComboBox(mappedTable,(ComponentRole) useCaseMap.getComponentRoles().get(j),auxComponents);
				}
			}
		}
		
		ConditionEventToConditionEventMapEntryImpl key;
		Object value;
		for (Iterator e=family.getEvents().iterator(); e.hasNext();) {
			 key = (ConditionEventToConditionEventMapEntryImpl)e.next();
			 value = family.getEvents().get(key.getKey());
			 for (int j = 0; j < eventTable.getItems().length; j++) {
				TableItem item = eventTable.getItems()[j];
				if (item.getData().equals(key.getKey())){
					TableEditor editor = (TableEditor)editorsTableToEvent.get(item);
					CCombo combo = ((CCombo)editor.getEditor());
					for (int k = 0; k < combo.getItemCount(); k++) {
						if((Integer)auxiliarTableToEvent.get(combo,value)==k){
							combo.select(k);
							break;
						}
					}
				}
			}
		}
		
	    familyName.setText(modifyFamily.getName());
	}
	
	private void createEvents(Shell shell, Table architecturalUseCaseMapTable) {
		Composite respGroup = new Composite(shell, SWT.NONE);
			
		respGroup.setLayout(new GridLayout(1, false));		
		respGroup.setLayoutData(new GridData(GridData.FILL_BOTH));

		createEvents(respGroup);
		
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
		for (int j=result.size()-1;j>=0;j--){
			ConditionEvent event = (ConditionEvent) result.get(j);
			EList conditions = event.getAssociatedConditions();
			boolean contains = false; 
			for (int i=conditions.size()-1;i>=0;i--){
				if(architecturalMaps.contains(((Condition)conditions.get(i)).getSourceResponsibility().getMap())){
					contains = true;
					break;
				}
			}
			if (!contains){
				result.remove(j);
			}
		}
		return result;
	}

	private void createEvents(Composite Group) {
		Group respGroup = new Group(Group, SWT.NONE);
		respGroup.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.FamilyManagerDialog.eventFamily")); //$NON-NLS-1$
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
		tc1.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.FamilyManagerDialog.baseEvent")); //$NON-NLS-1$
		tc1.setWidth(130);				
		final TableColumn tc2 = new TableColumn(eventTable, SWT.LEFT);
		tc2.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.FamilyDialog.description")); //$NON-NLS-1$
		tc2.setWidth(170);
		final TableColumn tc3 = new TableColumn(eventTable, SWT.LEFT);
		tc3.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.FamilyManagerDialog.redefindedEvent")); //$NON-NLS-1$
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
				if (validateSelection()){
					exitValue = SWT.OK;
					shell.dispose();
				}
				else {
					MessageDialog dlg = new MessageDialog(
							shell,
				            Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.FamilyManagerDialog.incompleteMessageDialog"), //$NON-NLS-1$
				            null,
				            Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.FamilyManagerDialog.incompleteMessageDescription"), //$NON-NLS-1$
				            MessageDialog.ERROR,
				            new String[]{Messages.getString("org.isistan.flabot.edit.editor.okButton")}, //$NON-NLS-1$            
				            0);
					dlg.open();
				}
			}

			private boolean validateSelection() {
				if (mappedTable.getItems().length>0){
				FamilyElement familyElement;
				if (familyName.getText()!=""){ //$NON-NLS-1$
					modifyFamily.setName(familyName.getText());
				}
				else return false;
				
				modifyFamily.getFunctionalUseCaseMaps().clear();
				modifyFamily.getArchitecturalUseCaseMaps().clear();				
				modifyFamily.getFamilyElement().clear();
				for (int i=0; i < functionalUseCaseMapTable.getItemCount(); i++){
					UseCaseMap map = (UseCaseMap)functionalUseCaseMapTable.getItem(i).getData();
					if (!modifyFamily.getFunctionalUseCaseMaps().contains(map)&&!modifyFamily.getArchitecturalUseCaseMaps().contains(map)){
						modifyFamily.getFunctionalUseCaseMaps().add(map);
					}
				}
				for (int i=0; i < mappedTable.getItemCount(); i++){
					TableItem item = mappedTable.getItem(i);
					CCombo comboRoleFunctional = (CCombo) combosTable.get(item);
					ComponentRole componentFunctional = (ComponentRole)comboRoleFunctional.getData(String.valueOf(comboRoleFunctional.getSelectionIndex()));
					if (componentFunctional!=null){
						if (!modifyFamily.getFunctionalUseCaseMaps().contains(componentFunctional.getMap())&&!modifyFamily.getArchitecturalUseCaseMaps().contains(componentFunctional.getMap())){
							modifyFamily.getFunctionalUseCaseMaps().add(componentFunctional.getMap());
						}
						familyElement = CoremodelFactory.eINSTANCE.createFamilyElement();
						familyElement.setFunctionalComponent(componentFunctional);
						familyElement.setArchitecturalComponent((ComponentRole) item.getData());
						if (!modifyFamily.getArchitecturalUseCaseMaps().contains(((ComponentRole) item.getData()).getMap())){
							modifyFamily.getArchitecturalUseCaseMaps().add(((ComponentRole) item.getData()).getMap());
						}
						familyElement.setUseCaseMap(((ComponentRole)item.getData()).getMap());
						familyElement.setName(modifyFamily.getName());
						modifyFamily.getFamilyElement().add(familyElement);
					}
					else {return false;}
				}
				for (int i=0; i < eventTable.getItemCount(); i++){
					TableItem item = eventTable.getItem(i);
					CCombo comboRoleEvent = (CCombo) combosTableToEvent.get(item);
					ConditionEvent eventAssigned = (ConditionEvent)comboRoleEvent.getData(String.valueOf(comboRoleEvent.getSelectionIndex()));
					if (eventAssigned!=null){
						modifyFamily.getEvents().put(item.getData(),eventAssigned);
					}
					else {return false;}
				}
				return true;
			}
			return false;
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
	
	
	
	private Command getCommand() {
		if (exitValue == SWT.OK)
			return  new ModifyFamilyCommand(originalFamily, modifyFamily);
		
		return null;	
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