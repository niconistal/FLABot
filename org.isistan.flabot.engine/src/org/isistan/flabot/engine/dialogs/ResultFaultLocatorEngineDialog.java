/**
 * $Id: ResultFaultLocatorEngineDialog.java,v 1.27 2006/05/03 01:53:27 apersson Exp $
 * $Author: apersson $
 */
package org.isistan.flabot.engine.dialogs;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

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
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.engine.executionstate.ExecutionState;
import org.isistan.flabot.engine.messages.Messages;
import org.isistan.flabot.util.DefualtValidatorSorter;
import org.isistan.flabot.util.SorterToTable;

/**
 * @author $Author: apersson $
 *
 */
public class ResultFaultLocatorEngineDialog extends Dialog {
	/**
	 * the dialog's shell
	 */
	private Shell shell = null;  //  @jve:decl-index=0:visual-constraint="10,9"
	
	List<Vector> componentsRole = new ArrayList<Vector>();
	
	int exitValue = SWT.CANCEL;

	private boolean failureLocatedActionsAvailable;

	private boolean treatFailure = false;

	private Vector faultyResponsibilities = new Vector();

	public ResultFaultLocatorEngineDialog(Shell parent, boolean failureLocatedActionsAvailable) {
		super(parent, 0);
		this.failureLocatedActionsAvailable = failureLocatedActionsAvailable;
	}

	/**
	 * This method initializes the dialog's shell
	 */
	private void createShell(final Hashtable stateResponsibilities) {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(Messages.getString("org.isistan.flabot.engine.ResultFaultLocatorEngineDialog.faultLocatorEngine")); //$NON-NLS-1$
		shell.setLayout(new GridLayout(1, true));
		
		Group propertyGroup = new Group(shell, SWT.NONE);
		propertyGroup.setText(Messages.getString("org.isistan.flabot.engine.ResultFaultLocatorEngineDialog.results"));		 //$NON-NLS-1$
		propertyGroup.setLayout(new GridLayout(1, false));		
		propertyGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		final Table propertyTable;
		if (failureLocatedActionsAvailable){
		  propertyTable = new Table(propertyGroup, SWT.BORDER | SWT.CHECK | SWT.MULTI | SWT.FULL_SELECTION);
		}
		else{
		  propertyTable = new Table(propertyGroup, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);		 
		}
		
		final GridData gd = new GridData(GridData.FILL_BOTH);
		gd.widthHint = 800;
		gd.heightHint = 200;
		gd.verticalSpan = 3;
		propertyTable.setLayoutData(gd);
		propertyTable.setHeaderVisible(true);
		
		final TableColumn tc1 = new TableColumn(propertyTable, SWT.LEFT);
		tc1.setText(Messages.getString("org.isistan.flabot.engine.ResultFaultLocatorEngineDialog.responsibility"));		 //$NON-NLS-1$
		tc1.setWidth(250);
		final TableColumn tc2 = new TableColumn(propertyTable, SWT.LEFT);
		tc2.setText(Messages.getString("org.isistan.flabot.engine.ResultFaultLocatorEngineDialog.executionState"));		 //$NON-NLS-1$
		tc2.setWidth(265);
		final TableColumn tc3 = new TableColumn(propertyTable, SWT.LEFT);
		tc3.setText(Messages.getString("org.isistan.flabot.engine.ResultFaultLocatorEngineDialog.instance"));		 //$NON-NLS-1$
		tc3.setWidth(265);
		final SorterToTable sorter = new SorterToTable(propertyTable, new DefualtValidatorSorter(true,2));
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
		fillStereotypeTable(propertyTable, stateResponsibilities);
		
				
		// buttons composite (ok and cancel)	
		Composite buttonsComposite = new Composite(shell, SWT.NONE);
		buttonsComposite.setLayout(new RowLayout());
		buttonsComposite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
		
		Button buttonOK = new Button(buttonsComposite, SWT.NONE);
		buttonOK.setText(Messages.getString("org.isistan.flabot.edit.editor.okButton")); //$NON-NLS-1$
		buttonOK.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateChanges(propertyTable); 
				exitValue = SWT.OK;
				shell.dispose();
			}
		});
		
		final Button treatFailureButton = new Button(propertyGroup, SWT.CHECK);
		treatFailureButton.setText(Messages.getString("org.isistan.flabot.engine.ResultFaultLocatorEngineDialog.treatFailure")); //$NON-NLS-1$
		treatFailureButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateChanges(propertyTable);
				treatFailure = treatFailureButton.getSelection();
			}
		});
		if (!failureLocatedActionsAvailable){
			treatFailureButton.setEnabled(false);
		}
	}

	public int open(Hashtable stateResponsibilities) {
		createShell(stateResponsibilities);
		 
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
	    
		return exitValue;
	}
	
	private void fillStereotypeTable(Table table, Hashtable stateResponsibilities) {	
		SimplePathNode node;
		Vector list;
		for (Enumeration e=stateResponsibilities.keys(); e.hasMoreElements();){
			node = (SimplePathNode)e.nextElement();
            list = (Vector)stateResponsibilities.get(node);
            ExecutionState state = (ExecutionState)list.get(0);
            if (state.getName().equals(ExecutionState.FAULTY_LITERAL.getName()) || state.getName().equals(ExecutionState.FAULTY_CURRENT_LITERAL.getName())){
		    	 faultyResponsibilities .add(node);
		    }
		}
		for (Enumeration e=stateResponsibilities.keys(); e.hasMoreElements();) {
             node = (SimplePathNode)e.nextElement();
             list = (Vector)stateResponsibilities.get(node);
             ExecutionState state = (ExecutionState)list.get(0);
             String instance = "None"; //$NON-NLS-1$
             if (!list.get(1).equals("None")){ //$NON-NLS-1$
            	 instance = ((ComponentRole)list.get(1)).getFullName();
             }
             if (node instanceof ResponsibilityNode){
	             final TableItem item = new TableItem(table, SWT.NONE);
	             item.setText(new String[] { node.getName(), state.getName(), instance});
	 		     item.setData("Responsibility",node); //$NON-NLS-1$
	 		     item.setData("Instance",list.get(1)); //$NON-NLS-1$
	 		     if (validateBreakPoint(node,state.getName())){
	 		    	 item.setChecked(true);
	 		    	 Vector var = new Vector();
	 		    	 var.add(node);
	 		    	 if (!list.get(1).equals("None")) //$NON-NLS-1$
	 		    		 var.add(list.get(1));
	 		         else
	 		        	 var.add(null);
	 		    	 componentsRole.add(var);
	 		     }
             }
		}
	}
	
	private boolean validateBreakPoint(SimplePathNode node, String state) {
		if (faultyResponsibilities.contains(node))
			return true;
		for (int i=0; i<faultyResponsibilities.size();i++){
			SimplePathNode faultyNode = (SimplePathNode)faultyResponsibilities.get(i);
			for (int j=0; j<faultyNode.uGetPrevious().size();j++){
				if (getPrevious((SimplePathNode)faultyNode.uGetPrevious().get(j))!=null&&getPrevious((SimplePathNode)faultyNode.uGetPrevious().get(j)).equals(node)){
					return true;
				}
			}
			for (int j=0; j<node.uGetPrevious().size();j++){
				if (getPrevious((SimplePathNode)node.uGetPrevious().get(j))!=null&&getPrevious((SimplePathNode)node.uGetPrevious().get(j)).equals(faultyNode)){
					return true;
				}
			}
			if (faultyNode instanceof ResponsibilityNode)
			for (int j=0; j<((ResponsibilityNode)faultyNode).getResponsibility().getPreconditions().size(); j++){
				if (!state.equals(ExecutionState.EXECUTED_LITERAL.getName())){
					if (((Condition)((ResponsibilityNode)faultyNode).getResponsibility().getPreconditions().get(j)).getDependencyResponsibility().equals(node)){
						return true;					
					}
					if (((Condition)((ResponsibilityNode)faultyNode).getResponsibility().getPreconditions().get(j)).getSourceResponsibility().equals(node)){
						return true;					
					}
				}
			}
			if (node instanceof ResponsibilityNode)
				if (!state.equals(ExecutionState.EXECUTED_LITERAL.getName())){
					for (int j=0; j<((ResponsibilityNode)node).getResponsibility().getPreconditions().size(); j++){
						if (((Condition)((ResponsibilityNode)node).getResponsibility().getPreconditions().get(j)).getDependencyResponsibility().equals(faultyNode)){
							if (((Condition)((ResponsibilityNode)node).getResponsibility().getPreconditions().get(j)).getType().equals(Condition.mappingCondition)){
								if (state.equals(ExecutionState.FAULTY_NEXT_LEVELS_LITERAL.getName()))
									return true;
							}
							else
								return true;
						}
						if (((Condition)((ResponsibilityNode)node).getResponsibility().getPreconditions().get(j)).getSourceResponsibility().equals(faultyNode)){
							if (((Condition)((ResponsibilityNode)node).getResponsibility().getPreconditions().get(j)).getType().equals(Condition.mappingCondition)){
								if (state.equals(ExecutionState.FAULTY_NEXT_LEVELS_LITERAL.getName()))
									return true;
							}
							else
								return true;
						}
					}
				}
		}
		return false;
	}
	
	private SimplePathNode getPrevious (SimplePathNode node){
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

	private void updateChanges(Table table) {
		TableItem[] tia = table.getItems();  
		componentsRole.clear();
		for (int i = 0; i < tia.length; i++) {			
			if (failureLocatedActionsAvailable && tia[i].getChecked()){
				Vector var = new Vector();
				var.add(tia[i].getData("Responsibility")); //$NON-NLS-1$
				if (!(tia[i].getData("Instance") instanceof String)) //$NON-NLS-1$
					var.add(tia[i].getData("Instance")); //$NON-NLS-1$
				else
					var.add(null);
				componentsRole.add(var);
			}
        }
	}
	
	public List<Vector> getResponsibilitieNodes(){
		return componentsRole;
	}
	
	public boolean isTreatFailure(){
		return treatFailure; 
	}
}