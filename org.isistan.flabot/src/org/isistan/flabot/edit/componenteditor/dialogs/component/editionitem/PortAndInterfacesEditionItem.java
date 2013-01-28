/**
 * $Id: PortAndInterfacesEditionItem.java,v 1.4 2006/03/24 03:35:02 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.edit.componenteditor.dialogs.component.editionitem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.InterfaceModel;
import org.isistan.flabot.coremodel.NamedElementModel;
import org.isistan.flabot.coremodel.PortModel;
import org.isistan.flabot.edit.componenteditor.commands.model.ModifyNamedElementCommand;
import org.isistan.flabot.edit.componenteditor.dialogs.RenameDialog;
import org.isistan.flabot.edit.componenteditor.dialogs.component.ComponentEditionItem;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.DefualtValidatorSorter;
import org.isistan.flabot.util.SorterToTable;
import org.isistan.flabot.util.edition.EditionItemStatus;
import org.isistan.flabot.util.edition.tab.EditionTabItemImpl;

/**
 * @author $Author: dacostae $
 *
 */
public class PortAndInterfacesEditionItem extends EditionTabItemImpl<ComponentModel> implements
		ComponentEditionItem {
			
	private Composite control;
	private EditionItemStatus status=EditionItemStatus.DEFAULT_OK;
	
	private Map renames = new HashMap();
	private Table interfaceTable = null;
		
	@Override
	public void initialize(TabFolder tabFolder, TabItem tabItem,
			final ComponentModel component) {
		control = new Composite(tabFolder, SWT.NONE);
		
		tabItem.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.component.editionitem.PortAndInterfacesEditionItem.tabName")); //$NON-NLS-1$
				
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 30;
		layout.horizontalSpacing = 12;
		control.setLayout(layout);
		
		control.setLayoutData(new GridData(GridData.FILL_BOTH));
			
		Group propertyGroup = new Group(control, SWT.NONE);
		propertyGroup.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.PortInterfaceDialog.group"));				 //$NON-NLS-1$
		propertyGroup.setLayout(new GridLayout(2, false));		
		propertyGroup.setLayoutData(new GridData(GridData.FILL_BOTH));	

		createPortsTable(propertyGroup, component.getOwnedPorts());		
		createInterfacesTable(propertyGroup);	    
	}

	public void activate() {
		
	}

	public void createPortsTable(Composite parent, List ports) {
		Composite c = new Composite(parent, 0);
		c.setLayout(new GridLayout(1, false));		
		c.setLayoutData(new GridData(GridData.FILL_BOTH));	
		
		final Label label = new Label(c, SWT.BOLD);
		label.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.PortInterfaceDialog.componentPorts")); //$NON-NLS-1$
		
		final Table portTable = new Table(c, SWT.BORDER | SWT.MULTI
				| SWT.FULL_SELECTION);		
		GridData gd = new GridData(GridData.FILL_BOTH | GridData.VERTICAL_ALIGN_BEGINNING);
		gd.widthHint = 100;
		gd.heightHint = 100;
		portTable.setLayoutData(gd);	
		portTable.setHeaderVisible(true);
		
		final TableColumn tc1 = new TableColumn(portTable, SWT.LEFT);
		final SorterToTable sorter = new SorterToTable(portTable, new DefualtValidatorSorter(false,1));
		tc1.addListener(SWT.Selection, new Listener() {
			   public void handleEvent(Event e) {
				   sorter.setColumn(tc1);
				   sorter.reverseDirection();
				   sorter.order();
			   }
			        });
		tc1.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.PortInterfaceDialog.portName")); //$NON-NLS-1$
		tc1.setWidth(115);
		
		portTable.addListener(SWT.Selection, new Listener() {
		    	public void handleEvent(Event e) {
		    		TableItem[] items = portTable.getSelection();
		    		if (items.length == 1)	{		    		
		    			PortModel port = (PortModel) items[0].getData(); 
		    			fillInterfaceTable(port);
		    		}
		    	}
		});
		
		portTable.addListener(SWT.MouseDoubleClick, new Listener() {
	    	public void handleEvent(Event e) {
	    		TableItem[] items = portTable.getSelection();
	    		if (items.length == 1) {			    		
		    		PortModel port = (PortModel) items[0].getData();
	    			RenameDialog r = new RenameDialog(control.getShell());
		    		String newName = r.open(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.PortInterfaceDialog.namePort"), Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.PortInterfaceDialog.renamePort"), items[0].getText(0)); //$NON-NLS-1$ //$NON-NLS-2$
	    			
		    		if (newName != null && !newName.equals(port.getName()) && !newName.equals("")) { //$NON-NLS-1$
		    			items[0].setText(newName);
		    			renames.put(port, newName);		    			
		    		}
	    		}
	    	}
		});
		
		for(int i=0; i<ports.size(); i++) {
			final PortModel port = (PortModel)ports.get(i);
			final TableItem item = new TableItem(portTable, SWT.NONE);
		    item.setText(new String[] { port.getName()});
		    item.setData(port);
		}
	}
	
	private void fillInterfaceTable(PortModel port) {
		interfaceTable.clearAll();
		interfaceTable.setItemCount(0);
		for(int i=0; i<port.getProvideds().size(); i++) {
			InterfaceModel inter = (InterfaceModel)port.getProvideds().get(i);
			final TableItem item = new TableItem(interfaceTable, SWT.NONE);
		    String name = inter.getName();
		    String rename = (String) renames.get(inter);
		    if (rename != null) 
		    	name = rename;
			item.setText(new String[] { name, Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.PortInterfaceDialog.provided")}); //$NON-NLS-1$
		    item.setData(inter);
		}
		
		for(int i=0; i<port.getRequireds().size(); i++) {
			InterfaceModel inter = (InterfaceModel)port.getRequireds().get(i);
			final TableItem item = new TableItem(interfaceTable, SWT.NONE);
			 String name = inter.getName();
			 String rename = (String) renames.get(inter);
			 if (rename != null) 
				 name = rename;
			item.setText(new String[] { name, Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.PortInterfaceDialog.required")}); //$NON-NLS-1$
		    item.setData(inter);
		}
	}
		
	public void createInterfacesTable(Composite parent) {
		Composite c = new Composite(parent, 0);
		c.setLayout(new GridLayout(1, false));		
		c.setLayoutData(new GridData(GridData.FILL_BOTH));	
		
		final Label label = new Label(c, SWT.BOLD);
		label.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.PortInterfaceDialog.interfacesForSelectedPort")); //$NON-NLS-1$
		
		interfaceTable = new Table(c, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);
		GridData gd = new GridData(GridData.FILL_BOTH | GridData.VERTICAL_ALIGN_BEGINNING);
		gd.widthHint = 200;
		gd.heightHint = 100;
		interfaceTable.setLayoutData(gd);	
		interfaceTable.setHeaderVisible(true);
		
		final TableColumn tc1 = new TableColumn(interfaceTable, SWT.LEFT);
		tc1.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.PortInterfaceDialog.interfaceName")); //$NON-NLS-1$
		tc1.setWidth(160);				
		final TableColumn tc2 = new TableColumn(interfaceTable, SWT.LEFT);
		tc2.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.PortInterfaceDialog.interfaceKind")); //$NON-NLS-1$
		tc2.setWidth(55);
		final SorterToTable sorter = new SorterToTable(interfaceTable, new DefualtValidatorSorter(false,2));
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
		
		interfaceTable.addListener(SWT.MouseDoubleClick, new Listener() {
	    	public void handleEvent(Event e) {
	    		TableItem[] items = interfaceTable.getSelection();
	    		if (items.length == 1) {			    		
		    		InterfaceModel inter = (InterfaceModel) items[0].getData();
	    			RenameDialog r = new RenameDialog(control.getShell());
		    		String newName = r.open(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.PortInterfaceDialog.nameInterface"), Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.PortInterfaceDialog.renameInterface"), items[0].getText(0)); //$NON-NLS-1$ //$NON-NLS-2$
	    			
		    		if (newName != null && !newName.equals(inter.getName()) && !newName.equals("")) { //$NON-NLS-1$
		    			items[0].setText(newName);
		    			renames.put(inter, newName);		    			
		    		}
	    		}
	    	}
		});
	}
	
	@Override
	public Control getControl() {
		return control;
	}

	public Command getCommand() {
		CompoundCommand compound = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.component.editionitem.PortAndInterfacesEditionItem.tabCommandLabel")); //$NON-NLS-1$
		for (Iterator iter = renames.keySet().iterator(); iter.hasNext();) {
			NamedElementModel namedElement = (NamedElementModel) iter.next();
			compound.add(new ModifyNamedElementCommand(namedElement, (String) renames.get(namedElement)));
		}
			
		if (compound.size() == 0)
			return null;
			
		return compound;
	}

	public boolean canCreateCommand() {
		EditionItemStatus.Type type=getStatus().getType();
		return type!=EditionItemStatus.Type.ERROR;
	}
	
	public EditionItemStatus getStatus() {
		return status;
	}

	public boolean accepts(ComponentModel element) {
		return true;
	}

}