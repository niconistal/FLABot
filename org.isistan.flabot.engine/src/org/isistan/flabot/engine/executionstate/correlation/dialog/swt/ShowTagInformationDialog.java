/**
 * $Id: ShowTagInformationDialog.java,v 1.4 2006/03/21 03:18:12 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.correlation.dialog.swt;

import java.util.List;

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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.trace.log.Tag;
import org.isistan.flabot.trace.log.tagquery.TagQueryUtil;

/**
 * @author $Author: franco $
 *
 */
public class ShowTagInformationDialog extends Dialog { 

	/**
	 * the dialog's shell
	 */
	private Shell shell = null;  //  @jve:decl-index=0:visual-constraint="10,9"
	
	private TagQueryUtil tagQueryUtil = TagQueryUtil.INSTANCE;
	
	/**
	 * @param parent
	 */
	public ShowTagInformationDialog(Shell parent) {
		super(parent, 0);
	}


	/**
	 * Makes the dialog visible.
	 * 
	 * @return
	 */
	public void open(final Tag tag) {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialog.EditPropertyDialog.title")); //$NON-NLS-1$
		shell.setLayout(new GridLayout(1, true));		
		
		shell.addShellListener(new org.eclipse.swt.events.ShellAdapter() {				
			public void shellClosed(org.eclipse.swt.events.ShellEvent e) {
				handleOk();
			}
		});
		
		Composite composite = new Composite(shell, SWT.NONE);

		GridLayout layout = new GridLayout(1, false);
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		composite.setLayout(layout);		
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		
		createMethodGroup(composite, tag);
		createInstanceGroup(composite, tag);
    
    	// buttons composite (ok and cancel)	
		Composite buttonsComposite = new Composite(shell, SWT.NONE);
		buttonsComposite.setLayout(new RowLayout());
		buttonsComposite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
	
		Button buttonOK = new Button(buttonsComposite, SWT.NONE);
		buttonOK.setText(Messages.getString("org.isistan.flabot.edit.editor.okButton")); //$NON-NLS-1$
		buttonOK.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleOk();
			}
		});
				
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
	
	private void createMethodGroup(Composite parent, Tag tag) {
		Group methodGroup = new Group(parent, SWT.NONE);
		methodGroup.setText(org.isistan.flabot.engine.messages.Messages.getString("org.isistan.flabot.engine.executionstate.correlation.dialog.swt.ShowTagInformationDialog.methodPropertiesGroup")); //$NON-NLS-1$
		
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		
		methodGroup.setLayout(layout);		
		methodGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		String methodDescriptor = getMethodDescriptor(tag);
		
		//Method Class
		createItem(methodGroup, org.isistan.flabot.engine.messages.Messages.getString("org.isistan.flabot.engine.executionstate.correlation.dialog.swt.ShowTagInformationDialog.declaringClassItem"), getMethodClass(methodDescriptor)); //$NON-NLS-1$
		
		//Method name
		createItem(methodGroup, org.isistan.flabot.engine.messages.Messages.getString("org.isistan.flabot.engine.executionstate.correlation.dialog.swt.ShowTagInformationDialog.nameItem"), getMethodName(tag)); //$NON-NLS-1$
		
		//Method Return type
		createItem(methodGroup, org.isistan.flabot.engine.messages.Messages.getString("org.isistan.flabot.engine.executionstate.correlation.dialog.swt.ShowTagInformationDialog.returnTypeIetm"), getMethodReturnType(tag)); //$NON-NLS-1$

		//Method parameters
		final Label parametersName = new Label(methodGroup, SWT.NULL);
		parametersName.setText(org.isistan.flabot.engine.messages.Messages.getString("org.isistan.flabot.engine.executionstate.correlation.dialog.swt.ShowTagInformationDialog.parametersLabel")); //$NON-NLS-1$
		parametersName.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
		
		final Table parametersTable = new Table(methodGroup, SWT.BORDER | SWT.MULTI
				| SWT.FULL_SELECTION);		
		parametersTable.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.VERTICAL_ALIGN_BEGINNING));	
		parametersTable.setHeaderVisible(true);
		
		final TableColumn tc1 = new TableColumn(parametersTable, SWT.LEFT);
		tc1.setText(org.isistan.flabot.engine.messages.Messages.getString("org.isistan.flabot.engine.executionstate.correlation.dialog.swt.ShowTagInformationDialog.parametersColumn")); //$NON-NLS-1$
		tc1.setWidth(115);		
		
		List<Tag> parameters = getMethodParameterList(tag);
		for(int i=0; i<parameters.size(); i++) {
			Tag t = parameters.get(i);
			final TableItem item = new TableItem(parametersTable, SWT.NONE);
		    item.setText(getName(t));
		}
	}
	
	private void createInstanceGroup(Composite parent, Tag tag) {
		Group instanceGroup = new Group(parent, SWT.NONE);
		instanceGroup.setText(org.isistan.flabot.engine.messages.Messages.getString("org.isistan.flabot.engine.executionstate.correlation.dialog.swt.ShowTagInformationDialog.instancePropertiesGroup")); //$NON-NLS-1$
		
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		
		instanceGroup.setLayout(layout);		
		instanceGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		//Instance Class
		createItem(instanceGroup, org.isistan.flabot.engine.messages.Messages.getString("org.isistan.flabot.engine.executionstate.correlation.dialog.swt.ShowTagInformationDialog.classItem"), getInstanceClass(tag)); //$NON-NLS-1$
		
		//Instance ID
		createItem(instanceGroup, org.isistan.flabot.engine.messages.Messages.getString("org.isistan.flabot.engine.executionstate.correlation.dialog.swt.ShowTagInformationDialog.idItem"), getInstanceID(tag)); //$NON-NLS-1$
		
		//Instance
		createItem(instanceGroup, org.isistan.flabot.engine.messages.Messages.getString("org.isistan.flabot.engine.executionstate.correlation.dialog.swt.ShowTagInformationDialog.instanceItem"), getInstance(tag)); //$NON-NLS-1$

		//Instance parameters
		final Label parametersName = new Label(instanceGroup, SWT.NULL);
		parametersName.setText(org.isistan.flabot.engine.messages.Messages.getString("org.isistan.flabot.engine.executionstate.correlation.dialog.swt.ShowTagInformationDialog.parametersLabel")); //$NON-NLS-1$
		parametersName.setLayoutData( new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
		
		final Table parametersTable = new Table(instanceGroup, SWT.BORDER | SWT.MULTI
				| SWT.FULL_SELECTION);
		parametersTable.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.VERTICAL_ALIGN_BEGINNING));	
		parametersTable.setHeaderVisible(true);
		
		final TableColumn tc1 = new TableColumn(parametersTable, SWT.LEFT);
		tc1.setText(org.isistan.flabot.engine.messages.Messages.getString("org.isistan.flabot.engine.executionstate.correlation.dialog.swt.ShowTagInformationDialog.parametersColumn")); //$NON-NLS-1$
		tc1.setWidth(115);		
		
		List<Tag> parameters = getMethodParameterList(tag);
		for(int i=0; i<parameters.size(); i++) {
			Tag t = parameters.get(i);
			final TableItem item = new TableItem(parametersTable, SWT.NONE);
		    item.setText(getName(t));
		}
	}
	
	private void createItem(Composite parent, String labelString, String valueString) {
		final Label label = new Label(parent, SWT.NULL);
		GridData gd = new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL);
		gd.widthHint = 100;
		label.setLayoutData(gd);
		label.setText(labelString);
		
		final Text value = new Text(parent, SWT.SINGLE | SWT.BORDER);			
		gd = new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL);
		gd.widthHint = 350;
		value.setLayoutData(gd);		
		value.setText(valueString);
		value.setEditable(false);
	}
	
	private String getMethodDescriptor(Tag executionTag) {
		Tag behaviorTag = tagQueryUtil.getBehavior(executionTag);
		return tagQueryUtil.getBehaviorDescriptor(behaviorTag);	
	}
	
	private String getMethodReturnType(Tag executionTag) {
		Tag behaviorTag = tagQueryUtil.getBehavior(executionTag);
		return tagQueryUtil.getName(tagQueryUtil.getReturnType(behaviorTag));
	}
	
	private String getMethodClass(String behaviorDescriptor) {
		int index = behaviorDescriptor.lastIndexOf("#"); //$NON-NLS-1$
		if (index < 0) index = 0;
		return behaviorDescriptor.substring(0, index);
	}
	
	private String getMethodName(Tag executionTag) {
		Tag behaviorTag = tagQueryUtil.getBehavior(executionTag);
		return tagQueryUtil.getName(behaviorTag); 	
	}	
	
	private List<Tag> getMethodParameterList(Tag tag) {
		Tag executionTag = tagQueryUtil.getBehavior(tag);
		return tagQueryUtil.getParameterTypes(executionTag);
	}
	
	private String getName(Tag tag) {
		return tagQueryUtil.getName(tag);
	}
	
	private String getInstanceClass(Tag tag) {
		Tag objectSnapshotTag = tagQueryUtil.getExecutionInstanceSnapshot(tag);
		Tag objectTag = tagQueryUtil.getObject(objectSnapshotTag);
		return getName(tagQueryUtil.getObjectClass(objectTag));
	}
	
	private String getInstanceID(Tag tag) {			
		Tag objectSnapshotTag = tagQueryUtil.getExecutionInstanceSnapshot(tag);
		Tag objectTag = tagQueryUtil.getObject(objectSnapshotTag);		
		return tagQueryUtil.getObjectId(objectTag);		
	}
	
	private String getInstance(Tag tag) {			
		Tag objectSnapshotTag = tagQueryUtil.getExecutionInstanceSnapshot(tag);
		return tagQueryUtil.getToString(objectSnapshotTag);		
	}
	
	private void handleOk() {
		shell.dispose();
	}

}