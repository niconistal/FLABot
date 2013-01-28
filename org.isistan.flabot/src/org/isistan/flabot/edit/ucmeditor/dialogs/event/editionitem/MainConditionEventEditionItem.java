/**
 * $Id: MainConditionEventEditionItem.java,v 1.2 2006/04/11 23:31:51 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.dialogs.event.editionitem;

import org.eclipse.gef.commands.Command;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.edit.ucmeditor.commands.model.ModifyConditionEventCommand;
import org.isistan.flabot.edit.ucmeditor.dialogs.event.ConditionEventEditionItem;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.edition.CompositeEditionItemStatus;
import org.isistan.flabot.util.edition.EditionItemStatus;
import org.isistan.flabot.util.edition.SingleEditionItemStatus;
import org.isistan.flabot.util.edition.tab.EditionTabItemImpl;

/**
 * @author $Author: franco $
 *
 */
public class MainConditionEventEditionItem 
	extends EditionTabItemImpl<ConditionEvent> implements ConditionEventEditionItem {

	private Composite control;
	private ConditionEvent conditionEvent;
	private String newName=""; //$NON-NLS-1$
	private String newDescription=""; //$NON-NLS-1$
	private String oldName;
	private String oldDescription;
	private EditionItemStatus status=EditionItemStatus.DEFAULT_OK;
	
	@Override
	public void initialize(TabFolder tabFolder, TabItem tabItem,
			ConditionEvent conditionEvent) {
		control = new Composite(tabFolder, SWT.NONE);
		
		tabItem.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditResponsibilityDialog.text")); //$NON-NLS-1$
		tabItem.setToolTipText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditResponsibilityDialog.propertiesToolTipText")); //$NON-NLS-1$
		
		
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 30;
		layout.horizontalSpacing = 12;
		control.setLayout(layout);
		
		control.setLayoutData(new GridData(GridData.FILL_BOTH));
		this.conditionEvent=conditionEvent;
		newName=oldName=conditionEvent.getName();
		newDescription=oldDescription=conditionEvent.getDescription();
		updateStatus();
		
		//Name
		final Label name = new Label(control, SWT.NULL);
		name.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.event.editionitem.MainConditionEventEditionItem.eventName")); //$NON-NLS-1$
		    
		final Text nametext = new Text(control, SWT.SINGLE | SWT.BORDER);
		nametext.setText(oldName);
		if (oldName.length() > 0)
			nametext.setEnabled(false);
		nametext.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		nametext.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				newName=nametext.getText();
				updateStatus();
			}
		});
		
		//Description
		final Label description = new Label(control, SWT.NULL);
	    description.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.event.editionitem.MainConditionEventEditionItem.description")); //$NON-NLS-1$
	    description.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
	    
	    final Text descriptiontext = new Text(control, SWT.MULTI | SWT.BORDER 
	    			| SWT.V_SCROLL);
	    GridData gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING |GridData.FILL_HORIZONTAL);
	    gd.widthHint = 150;
	    gd.heightHint = 80;
	    descriptiontext.setLayoutData(gd);
	    descriptiontext.setText(oldDescription);
	    descriptiontext.addListener(SWT.Modify, new Listener() {
	        public void handleEvent(Event event) {
	        	newDescription=descriptiontext.getText();
	        	updateStatus();
	        }
	    });		
	}
		
	public void activate() {		
	
	}

	private void updateStatus() {
		EditionItemStatus nameStatus;
		if(newName.trim().length()==0) {
    		nameStatus=new SingleEditionItemStatus(
    				EditionItemStatus.Type.ERROR,
    				Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.event.editionitem.MainConditionEventEditionItem.noNameSet")); //$NON-NLS-1$
    	} else {
    		nameStatus=EditionItemStatus.DEFAULT_OK;
    	}    		
		
		if(newName.trim().length() > 0 && Character.isUpperCase(newName.trim().charAt(0))) {
			nameStatus=new SingleEditionItemStatus(
    				EditionItemStatus.Type.ERROR,
    				Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.event.editionitem.MainConditionEventEditionItem.nameWithUpperCase")); //$NON-NLS-1$
		}
		
		EditionItemStatus descriptionStatus;
    	if(newDescription.trim().length()==0) {
    		descriptionStatus=new SingleEditionItemStatus(
    				EditionItemStatus.Type.WARNING,
    				Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.event.editionitem.MainConditionEventEditionItem.noDescriptionSet")); //$NON-NLS-1$
    	} else {
    		descriptionStatus=EditionItemStatus.DEFAULT_OK;
    	}
    	status=new CompositeEditionItemStatus(nameStatus, descriptionStatus);
    	notifyChange();		
	}

	@Override
	public Control getControl() {
		return control;
	}

	public Command getCommand() {
		return new Command(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.responsibility.editionitem.MainResponsibilityEditionItem.tabCommandLabel")) {	 //$NON-NLS-1$
			@Override
			public void execute() {
				conditionEvent.setName(newName);
				conditionEvent.setDescription(newDescription);
			}

			@Override
			public void undo() {
				conditionEvent.setName(oldName);
				conditionEvent.setDescription(oldDescription);
			}			
		};		
	}

	public boolean canCreateCommand() {
		EditionItemStatus.Type type=getStatus().getType();
		return type!=EditionItemStatus.Type.ERROR;
	}

	public EditionItemStatus getStatus() {
		return status;
	}

	public boolean accepts(ConditionEvent element) {
		return true;
	}
}