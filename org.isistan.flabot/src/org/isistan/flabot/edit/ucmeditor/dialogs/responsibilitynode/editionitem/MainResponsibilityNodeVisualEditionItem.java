package org.isistan.flabot.edit.ucmeditor.dialogs.responsibilitynode.editionitem;

import org.eclipse.gef.commands.Command;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.ucmeditor.dialogs.responsibilitynode.ResponsibilityNodeVisualEditionItem;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.edition.EditionItemStatus;
import org.isistan.flabot.util.edition.tab.EditionTabItemImpl;

/**
 * Edits main responsbility node visual properties
 * @author $Author: franco $
 *
 */
public class MainResponsibilityNodeVisualEditionItem
	extends EditionTabItemImpl<NodeVisualModel> implements ResponsibilityNodeVisualEditionItem {

	private Composite control;
	private NodeVisualModel nodeVisualModel;
	private int oldDetail;
	private Button showDependencies;
	@Override
	public void initialize(TabFolder tabFolder, TabItem tabItem,
			NodeVisualModel nodeVisualModel) {
		control=new Composite(tabFolder, SWT.NONE);
		GridLayout layout = new GridLayout(1, false);
		layout.verticalSpacing = 30;
		layout.horizontalSpacing = 12;
		control.setLayout(layout);
		tabItem.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.responsibilitynode.tabitem.ResponsibilityNodeTabEditionItem.text")); // //$NON-NLS-1$
		
		this.nodeVisualModel=nodeVisualModel;
    	createShowDependencyCheckbox();


	}
	
	public void activate() {
		
	}

	private void createShowDependencyCheckbox() {
    	showDependencies = new Button(control, SWT.CHECK);
    	GridData gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING |GridData.FILL_HORIZONTAL);
    	gd.horizontalSpan = 2;	    
    	showDependencies.setLayoutData(gd);
    	showDependencies.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.responsibilitynode.tabitem.ResponsibilityNodeTabEditionItem.showDependencies")); //$NON-NLS-1$
    	this.oldDetail=nodeVisualModel.getDetailLevel();
    	showDependencies.setSelection(oldDetail==VisualModel.HIGH_DETAIL );
	}

	@Override
	public Control getControl() {
		return control;
	}

	public Command getCommand() {
		final int newDetail=showDependencies.getSelection()? VisualModel.HIGH_DETAIL : VisualModel.LOW_DETAIL;
		if (newDetail == oldDetail)
			return null;
		
		
		return new Command(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.responsibilitynode.editionitem.MainResponsibilityNodeVisualEditionItem.tabCommandLabel")) { //$NON-NLS-1$
			public void execute() {
				nodeVisualModel.setDetailLevel(newDetail);
			}
			public void undo() {
				nodeVisualModel.setDetailLevel(oldDetail);
			}
		};
	}

	public boolean canCreateCommand() {
		return true;
	}

	public EditionItemStatus getStatus() {
		return EditionItemStatus.DEFAULT_OK;
	}

	public boolean accepts(NodeVisualModel element) {
		return true;
	}
}
