/**
 * $Id: PropertyEditionItem.java,v 1.6 2006/04/11 01:31:18 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.dialogs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.Property;
import org.isistan.flabot.coremodel.PropertyElementModel;
import org.isistan.flabot.edit.componenteditor.commands.model.AddPropertyCommand;
import org.isistan.flabot.edit.componenteditor.commands.model.DeletePropertyCommand;
import org.isistan.flabot.edit.componenteditor.commands.model.ModifyPropertyCommand;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.DefualtValidatorSorter;
import org.isistan.flabot.util.SorterToTable;
import org.isistan.flabot.util.edition.EditionItemStatus;
import org.isistan.flabot.util.edition.tab.EditionTabItemImpl;

/**
 * @author $Author: franco $
 *
 */
public class PropertyEditionItem extends EditionTabItemImpl<PropertyElementModel> {
	
	private Composite control;
	private EditionItemStatus status=EditionItemStatus.DEFAULT_OK;

	private	Map propertiesMap = new HashMap();
	private List newProperties = new ArrayList();
	private List removeProperties = new ArrayList();
	private Map updateProperties = new HashMap();
	
	private PropertyElementModel propertyElementModel;
	
	private Button editBtn;
	private Button removeBtn;
	
	@Override
	public void initialize(TabFolder tabFolder, TabItem tabItem,
			PropertyElementModel propertyElementModel) {	
		this.propertyElementModel = propertyElementModel;
		
		control = new Composite(tabFolder, SWT.NONE);
		
		tabItem.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.PropertyEditionItem.tanName")); //$NON-NLS-1$
		
		GridLayout layout = new GridLayout(1, false);
		layout.verticalSpacing = 30;
		layout.horizontalSpacing = 12;
		control.setLayout(layout);
		
		control.setLayoutData(new GridData(GridData.FILL_BOTH));			
		
		Group propertyGroup = new Group(control, SWT.NONE);
		propertyGroup.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.PropertyDialog.group"));		 //$NON-NLS-1$
		propertyGroup.setLayout(new GridLayout(2, false));		
		propertyGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		final Table propertyTable = new Table(propertyGroup, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.widthHint = 300;
		gd.heightHint = 200;
		gd.verticalSpan = 3;
		propertyTable.setLayoutData(gd);
		propertyTable.setHeaderVisible(true);
		propertyTable.addListener( SWT.Selection, new Listener() {
	        public void handleEvent(Event event) {
	          TableItem[] items = propertyTable.getSelection();
        	  editBtn.setEnabled(items.length == 1);
        	  removeBtn.setEnabled(items.length >= 1);
	        }			
		});	
		
		final TableColumn tc1 = new TableColumn(propertyTable, SWT.LEFT);
		tc1.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.PropertyDialog.propertyName")); //$NON-NLS-1$
		tc1.setWidth(105);				
		final TableColumn tc2 = new TableColumn(propertyTable, SWT.LEFT);
		tc2.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.PropertyDialog.propertyValue")); //$NON-NLS-1$
		tc2.setWidth(110);
		final SorterToTable sorter = new SorterToTable(propertyTable, new DefualtValidatorSorter(false,2));
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
		fillPropertyTable(propertyTable, propertyElementModel.getProperties());
		
		propertyTable.addListener( SWT.MouseDoubleClick, new Listener() {
	        public void handleEvent(Event event) {
	        	renameAction(propertyTable);
	        }			
		});	
				
		final Button addBtn = new Button(propertyGroup, SWT.PUSH);
		gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		gd.widthHint = 100;
		addBtn.setLayoutData(gd);
		addBtn.setText(Messages.getString("org.isistan.flabot.edit.editor.addButton"));		 //$NON-NLS-1$
		addBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				EditPropertyDialog f = new EditPropertyDialog(control.getShell());
				String[] data = f.open(propertiesMap);
				
				if (data[0] != null && !data[0].equals("") && //$NON-NLS-1$
					data[1] != null) {
					Property prop = CoremodelFactory.eINSTANCE.createProperty();
				    prop.setName(data[0]);
					prop.setValue(data[1]);
					
					final TableItem item = new TableItem(propertyTable, SWT.NONE);
				    item.setText(data);
				    item.setData(prop);
				    newProperties.add(prop);
				    propertiesMap.put(prop.getName().toLowerCase(), prop);					
				}
		    }
		});
		
		editBtn = new Button(propertyGroup, SWT.PUSH);
		gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		gd.widthHint = 100;
		editBtn.setLayoutData(gd);
		editBtn.setText(Messages.getString("org.isistan.flabot.edit.editor.editButton"));		 //$NON-NLS-1$
		editBtn.setEnabled(false);
		editBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				renameAction(propertyTable);
		    }
		});
		    
		removeBtn = new Button(propertyGroup, SWT.PUSH);
		gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		gd.widthHint = 100;
		removeBtn.setLayoutData(gd);
		removeBtn.setText(Messages.getString("org.isistan.flabot.edit.editor.removeButton")); //$NON-NLS-1$
		removeBtn.setEnabled(false);
		removeBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				TableItem[] items = propertyTable.getSelection();
				if(items.length==0) {
					return;
				}

				for (TableItem item : items) {
					Property prop = (Property) item.getData();
					propertiesMap.remove(prop.getName().toLowerCase());
					if (newProperties.contains(prop))
						newProperties.remove(prop);
					else
						removeProperties.add(prop);
					
					Property modify = (Property) updateProperties.get(prop);
					if (modify != null) {
						updateProperties.remove(prop);
		        		 propertiesMap.remove(modify.getName().toLowerCase());
					}		        	  
		         }
				propertyTable.remove(propertyTable.getSelectionIndices());
				
				editBtn.setEnabled(false);
				removeBtn.setEnabled(false);
		    }
		});
	}
	
	public void activate() {
		
	}
	
	private void renameAction(Table table) {
		TableItem[] items = table.getSelection();
        if (items.length == 1) {
      	  String[] data = new String[2];
      	  data[0] = items[0].getText(0);
      	  data[1] = items[0].getText(1);
      	  
      	  EditPropertyDialog f = new EditPropertyDialog(control.getShell(), data);
      	  data = f.open(propertiesMap);
      	  
      	  if (data[0] != null && !data[0].equals("") &&  //$NON-NLS-1$
				  data[1] != null) {
      		  	items[0].setText(data);
      		  	Property property = (Property) items[0].getData();
      		  	propertiesMap.remove(property.getName().toLowerCase());
      		  	propertiesMap.put(data[0].toLowerCase(), property);
      		  	if (newProperties.contains(property)) {
      		  		property.setName(data[0]);
      		  		property.setValue(data[1]);
      		  	}
      		  	else {
      		  		Property updatedProperty =
      		  			(Property) EcoreUtil.copy(property);
      		  		updatedProperty.setName(data[0]);
      		  		updatedProperty.setValue(data[1]);
      		  		updateProperties.put(property, updatedProperty);
      		  	}
      	  }
        }
	}
	
	private void fillPropertyTable(Table table, List properties) {	
		for (Iterator iter = properties.iterator(); iter.hasNext();) {
			Property prop = (Property) iter.next(); 
			final TableItem item = new TableItem(table, SWT.NONE);
		    item.setText(new String[] { prop.getName(), prop.getValue()});
		    item.setData(prop);
		    propertiesMap.put(prop.getName().toLowerCase(), prop);
		}
	}
	
	@Override
	public Control getControl() {
		return control;
	}

	public Command getCommand() {	
		CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.PropertyEditionItem.tabCommandLabel")); //$NON-NLS-1$
		
		for (Iterator iter = removeProperties.iterator(); iter.hasNext();)
			commands.add( new DeletePropertyCommand(propertyElementModel, (Property) iter.next()));

		for (Iterator iter = newProperties.iterator(); iter.hasNext();)
			commands.add( new AddPropertyCommand(propertyElementModel, (Property) iter.next()));
			
		for (Iterator iter = updateProperties.keySet().iterator(); iter.hasNext();) {
			Property property = (Property) iter.next();
			Property updatedProperty = (Property)updateProperties.get(property);
			commands.add(new ModifyPropertyCommand(property, updatedProperty));
		}
				
		if(commands.size() == 0)
			return null;
		
		return commands;
	}

	public boolean canCreateCommand() {
		EditionItemStatus.Type type=getStatus().getType();
		return type!=EditionItemStatus.Type.ERROR;
	}
	
	public EditionItemStatus getStatus() {
		return status;
	}

	public boolean accepts(PropertyElementModel element) {
		return true;
	}	
}