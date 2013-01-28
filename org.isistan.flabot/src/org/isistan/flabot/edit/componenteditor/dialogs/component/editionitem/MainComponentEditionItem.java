package org.isistan.flabot.edit.componenteditor.dialogs.component.editionitem;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.Stereotype;
import org.isistan.flabot.edit.componenteditor.commands.model.ModifyNamedElementCommand;
import org.isistan.flabot.edit.componenteditor.commands.model.ModifyStereotypeInElementCommand;
import org.isistan.flabot.edit.componenteditor.dialogs.component.ComponentEditionItem;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.edition.EditionItemStatus;
import org.isistan.flabot.util.edition.SingleEditionItemStatus;
import org.isistan.flabot.util.edition.tab.EditionTabItemImpl;

/**
 * Edits main responsibility properties
 * 
 * @author $Author: dacostae $
 *
 */
public class MainComponentEditionItem extends EditionTabItemImpl<ComponentModel> implements
		ComponentEditionItem {

	
	private ComponentModel component;
	private Composite control;
	private EditionItemStatus status=EditionItemStatus.DEFAULT_OK;
	
	private Text textName;
	private Combo comboStereotypes;
	
	@Override
	public void initialize(TabFolder tabFolder, TabItem tabItem,
			final ComponentModel component) {
		control = new Composite(tabFolder, SWT.NONE);
		
		tabItem.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.component.editionitem.MainComponentEditionItem.tabName")); //$NON-NLS-1$
		
		
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 30;
		layout.horizontalSpacing = 12;
		control.setLayout(layout);
		
		control.setLayoutData(new GridData(GridData.FILL_BOTH));
		this.component=component;

		
		//Name
		final Label name = new Label(control, SWT.NULL);
		name.setText("Nombre"); //$NON-NLS-1$
		    
		textName = new Text(control, SWT.SINGLE | SWT.BORDER);
		textName.setText(component.getName());
		textName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		textName.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				updateStatus();
			}
		});
		
		//Stereotypes
		final Label stereotypeLabel = new Label(control, SWT.NULL);
		stereotypeLabel.setText("Stereotype"); //$NON-NLS-1$
		
		comboStereotypes = new Combo(control, SWT.READ_ONLY);
		comboStereotypes.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));		
		
		List stereotypes = component.getCoreModel().getStereotypes();
		comboStereotypes.setData(String.valueOf(comboStereotypes.getItemCount()), null);
		comboStereotypes.add(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.component.editionitem.MainComponentEditionItem.noneStereotypesComboBox")); //$NON-NLS-1$
		comboStereotypes.select(0);
		
		for (int i=0; i < stereotypes.size(); i++) {
			Stereotype stereotype = (Stereotype)stereotypes.get(i);
			comboStereotypes.setData(String.valueOf(comboStereotypes.getItemCount()), stereotype);
			comboStereotypes.add(stereotype.getName());				
			if (stereotype == component.getStereotype())
				comboStereotypes.select(comboStereotypes.getItemCount() - 1);												
		}
		
		updateStatus();
	}
	
	public void activate() {
		
	}

	private void updateStatus() {
		EditionItemStatus nameStatus;
		if(textName.getText().trim().length()==0) {
    		nameStatus=new SingleEditionItemStatus(
    				EditionItemStatus.Type.ERROR,
    				Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.component.editionitem.MainComponentEditionItem.noNameSetForComponent")); //$NON-NLS-1$
    	} else {
    		nameStatus=EditionItemStatus.DEFAULT_OK;
    	}    		
		
    	status=nameStatus;
    	notifyChange();		
	}
	
	@Override
	public Control getControl() {
		return control;
	}

	public Command getCommand() {
		CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.component.editionitem.MainComponentEditionItem.tabCommandLabel"));  //$NON-NLS-1$
		
		if (!textName.getText().equals(component.getName()))
			commands.add(new ModifyNamedElementCommand(component, textName.getText()));
		
		Stereotype newStereotype = (Stereotype) comboStereotypes.getData(String.valueOf(comboStereotypes.getSelectionIndex()));
		if (newStereotype != component.getStereotype())
			commands.add(new ModifyStereotypeInElementCommand(component, newStereotype));
		
		if (commands.size() == 0)
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

	public boolean accepts(ComponentModel element) {
		return true;
	}
}