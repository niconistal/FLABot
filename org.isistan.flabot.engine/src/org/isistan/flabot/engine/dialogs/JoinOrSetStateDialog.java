/**
 * $Id: JoinOrSetStateDialog.java,v 1.13 2006/04/13 01:41:08 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.dialogs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.engine.EnginePlugin;
import org.isistan.flabot.engine.RuntimeManager;
import org.isistan.flabot.engine.executionstate.ExecutionState;
import org.isistan.flabot.engine.locator.FlabotEngineLocator;
import org.isistan.flabot.engine.messages.Messages;
import org.isistan.flabot.util.locator.ComponentLocatorException;
import org.isistan.flabot.util.locator.ComponentLocatorManager;

/**
 * This dialog is used during the execution of the engine; so the user indicates manually the state of an or join node (NotExecuted, Faulty or Executed).
 * 
 * @author usuario
 *
 */
public class JoinOrSetStateDialog extends ApplicationWindow {
		
	private Button[] radios = new Button[3];
	
	private ExecutionState values = ExecutionState.NOT_EXECUTED_LITERAL;
	
	private SimplePathNode valuesBranchSelection = null;

	private SimplePathNode node;
	
	private List<SimplePathNode> nodes = new ArrayList<SimplePathNode>();

	private Combo comboBranchs;

	private Hashtable stateByResponsibility;
	
	/**
	 * Instantiates a dialog
	 *  
	 * @param parent the shell parent
	 */
	public JoinOrSetStateDialog(Shell parent) {
		super(null);
	}

	public ExecutionState getExecutionInfo(SimplePathNode node, SimplePathNode node1, SimplePathNode node2, Hashtable stateByResponsibility){
		this.node = node;		
		nodes.add(node1);
		nodes.add(node2);
		this.stateByResponsibility = stateByResponsibility;
		return run();
	}

	/**
	 * Runs the application
	 */
	public ExecutionState run() {
		// Don't return from open() until window closes
		setBlockOnOpen(true);
		setShellStyle(getShellStyle()/* + SWT.APPLICATION_MODAL*/);
		
		// Open the main window
		open();		
		return values;
	}
		
	/**
	 * Constrain the shell size to be no larger than the display bounds.
	 * 
	 * @since 2.0
	 */
	protected void constrainShellSize() {
		super.constrainShellSize();
	    Shell shell = getShell();
		Display display = getShell().getDisplay();			    
	    Rectangle r = display.getClientArea();		
		int centerX = r.width - shell.getSize().x;
		int centerY = r.height/2 - shell.getSize().y / 2;
		shell.setLocation(centerX, centerY);
	}	
		
	/**
	 * Configures the shell
	 * 
	 * @param shell the shell
	 */
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(Messages.getString("org.isistan.flabot.engine.ResponsibilityExecutionStateDialog.executionStateSelection")); //$NON-NLS-1$
	}
	
	/**
	 * Creates the main window's contents
	 * 
	 * @param parent the main window
	 * @return Control
	 */
	protected Control createContents(Composite parent) {
	    setStateRuntime(false);
	    
	    Composite shell = new Composite(parent, SWT.NONE);
		
		GridLayout layout = new GridLayout(1, false);
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		shell.setLayout(layout);		
		shell.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Group stateGroup = new Group(shell, SWT.NONE);
		stateGroup.setText(Messages.getString("org.isistan.flabot.engine.dialogs.JoinOrSetStateDialog.branchStatesGroup")); //$NON-NLS-1$
		
		layout = new GridLayout(2, false);
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		stateGroup.setLayout(layout);		
		stateGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		
	    Group statesGroup = new Group(shell, SWT.NONE);
	    statesGroup.setText(Messages.getString("org.isistan.flabot.engine.ResponsibilityExecutionStateDialog.states")); //$NON-NLS-1$
		
		layout = new GridLayout(2, false);
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		statesGroup.setLayout(layout);		
		statesGroup.setLayoutData(new GridData(GridData.FILL_BOTH));			      	   
		
						
		radios[0] = new Button(statesGroup, SWT.RADIO);
	    radios[0].setText(ExecutionState.NOT_EXECUTED_LITERAL.getName());
	    radios[0].setData(ExecutionState.NOT_EXECUTED_LITERAL);
	    radios[0].setSelection(true);
	    values = (ExecutionState) radios[0].getData(); 
	    radios[0].addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event event) {
	        	comboBranchs.setEnabled(true);
	        	if (comboBranchs.getItemCount() > 0)
	        		comboBranchs.select(0);
	        }
	    });	            		            
	    
		comboBranchs = new Combo(statesGroup, SWT.READ_ONLY);
		
	    radios[1] = new Button(statesGroup, SWT.RADIO);
	    GridData gd = new GridData();
	    gd.horizontalSpan = 2;
	    radios[1].setLayoutData(gd);	    
	    radios[1].setText(ExecutionState.FAULTY_LITERAL.getName());
	    radios[1].setData(ExecutionState.FAULTY_LITERAL);
	    radios[1].addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event event) {
	        	comboBranchs.setEnabled(true);
	        	if (comboBranchs.getItemCount() > 0)
	        		comboBranchs.select(0);
	        }
	    });
	    
	    radios[2] = new Button(statesGroup, SWT.RADIO);
	    gd = new GridData();
	    gd.horizontalSpan = 2;
	    radios[2].setLayoutData(gd);	    
	    radios[2].setText(ExecutionState.EXECUTED_LITERAL.getName());
	    radios[2].setData(ExecutionState.EXECUTED_LITERAL);
	    radios[2].addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event event) {
	        	comboBranchs.deselectAll();
	        	comboBranchs.setEnabled(false);
	        }
	    });
	    
		createBranchs(stateGroup, nodes);		
	                
		Composite buttonsComposite = new Composite(shell, SWT.NONE);
		buttonsComposite.setLayout(new RowLayout());
		buttonsComposite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
		
	    final Button buttonOK = new Button(buttonsComposite, SWT.PUSH);
	    buttonOK.setText(Messages.getString("org.isistan.flabot.edit.editor.okButton")); //$NON-NLS-1$
	    buttonOK.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event event) {
	        	for (int i=0; i < radios.length; i++){
	            	if (radios[i].getSelection())
	            		values = (ExecutionState) radios[i].getData();
	        	}
	    	    valuesBranchSelection = (SimplePathNode) comboBranchs.getData(String.valueOf(comboBranchs.getSelectionIndex()));	            
	    	    close();
	        }
	    });
	    buttonOK.setFocus();
	    
		setStateRuntime(true);
	    return shell;
  }
  
  private void setStateRuntime(boolean state) {
	  FlabotFileModel flabotFileModel = node.getMap()
		.getCoreModel().getFile();
	  // add the file model to the parameters map
	  Map parameters = Collections
		.singletonMap(FlabotEngineLocator.PARAMETER_FLABOT_FILE_MODEL,
				flabotFileModel);
	  // obtain a reference to the component locator manager
	  ComponentLocatorManager locatorManager =
		FlabotPlugin.getDefault().getComponentLocatorManager();
	  try {
		RuntimeManager runtimeManager = (RuntimeManager)
			locatorManager.getComponent(FlabotEngineLocator.LOCATOR_ID,
					parameters);
		runtimeManager.setActiveRuntime(state); 
	  }catch (ComponentLocatorException e) {
		  EnginePlugin.getDefault().getLogger().error(
					Messages.getString("org.isistan.flabot.engine.dialogs.JoinOrSetStateDialog.executionError"),e); //$NON-NLS-1$
	  }	  
  }
  
  private void createBranchs(Composite c, List<SimplePathNode> nodes) {
	  	int i = 1;
	  	for(SimplePathNode node: nodes) {
	  		if(node!=null)
	  			addNewBranch(c, i++, node);
	  	}    
	    if (comboBranchs.getItemCount() > 0)
	    	comboBranchs.select(0);
  }
  
  private void addNewBranch(Composite composite, int branchNumber, SimplePathNode node) {
	  final Label id = new Label(composite, SWT.NULL);
	  id.setText(Messages.getString("org.isistan.flabot.engine.ResponsibilityExecutionStateDialog.branchText", Integer.valueOf(branchNumber), node.getName())); //$NON-NLS-1$

	  final Text idnode = new Text(composite, SWT.SINGLE | SWT.READ_ONLY | SWT.BORDER);
	  idnode.setLayoutData(new GridData(
			  GridData.VERTICAL_ALIGN_BEGINNING |
			  GridData.FILL_HORIZONTAL));	    
	  idnode.setText((String) stateByResponsibility.get(node));
	    
	  comboBranchs.setData(String.valueOf(comboBranchs.getItemCount()), node);
	  comboBranchs.add(Messages.getString("org.isistan.flabot.engine.ResponsibilityExecutionStateDialog.branchComboText", Integer.valueOf(branchNumber), node.getName())); //$NON-NLS-1$
  }
  
  public SimplePathNode getBranchSelection (){
	  return valuesBranchSelection;
  }
}