/** * $Id: ResponsibilityExecutionStateDialog.java,v 1.21 2006/04/13 01:41:07 franco Exp $ * $Author: franco $ */package org.isistan.flabot.engine.dialogs;

import java.util.Collections;import java.util.List;import java.util.Map;import org.eclipse.jface.window.ApplicationWindow;import org.eclipse.swt.SWT;import org.eclipse.swt.events.SelectionAdapter;import org.eclipse.swt.events.SelectionEvent;import org.eclipse.swt.graphics.Rectangle;import org.eclipse.swt.layout.GridData;import org.eclipse.swt.layout.GridLayout;import org.eclipse.swt.layout.RowLayout;import org.eclipse.swt.widgets.Button;import org.eclipse.swt.widgets.Composite;import org.eclipse.swt.widgets.Control;import org.eclipse.swt.widgets.Display;import org.eclipse.swt.widgets.Event;import org.eclipse.swt.widgets.Group;import org.eclipse.swt.widgets.Label;import org.eclipse.swt.widgets.Listener;import org.eclipse.swt.widgets.Shell;import org.eclipse.swt.widgets.Text;import org.isistan.flabot.coremodel.ComponentRole;import org.isistan.flabot.coremodel.ResponsibilityNode;import org.isistan.flabot.coremodel.SimplePathNode;import org.isistan.flabot.coremodel.StubNode;import org.isistan.flabot.engine.InterfaceContextInfo;import org.isistan.flabot.engine.executionstate.Diagnostic;import org.isistan.flabot.engine.executionstate.ExecutionState;import org.isistan.flabot.engine.executionstate.correlation.dialog.TagFilterDialogManager;import org.isistan.flabot.engine.messages.Messages;import org.isistan.flabot.trace.log.Tag;/** * This dialog is used during the execution of the engine; so the user indicates manually the state of a responsibility node (NotExecuted, Faulty or Executed). *  * @author usuario * */public class ResponsibilityExecutionStateDialog extends ApplicationWindow {
		
	private String sourceResponsibilityName;
	private String sourceInstanceName;
	private String sourceComponentName;
	private String sourceScenarioName;		private String targetResponsibilityName;	private String targetInstanceName;	private String targetComponentName;	private String targetScenarioName;		private String eventName; 	private String conditionName;
		private Button[] radios = new Button[3];
		private SimplePathNode sourceResponsibilityNode;		private ExecutionState values;		private Diagnostic diagnostic;
	private List<Tag> tagsBefore, tagsAfter;		private ExecutionState actualExecutionState;		/**	 * Instantiates a dialog	 *  	 * @param parent the shell parent	 */
	public ResponsibilityExecutionStateDialog(Shell parent) {
		//So it opens in a new window		super(null);
	}

	public void setExecutionInfo(SimplePathNode node, Map engineContext) {				eventName = (String) engineContext.get(InterfaceContextInfo.EVENT);		if (eventName == null) eventName = Messages.getString("org.isistan.flabot.engine.dialogs.ResponsibilityExecutionStateDialog.defaultEventName"); //$NON-NLS-1$				conditionName = (String) engineContext.get(InterfaceContextInfo.CONDITION);		if (conditionName == null) conditionName = Messages.getString("org.isistan.flabot.engine.dialogs.ResponsibilityExecutionStateDialog.defaultConditionName"); //$NON-NLS-1$		//Target Responsibility			ComponentRole targetInstance = (ComponentRole) engineContext.get(InterfaceContextInfo.INSTANCE);		if (targetInstance == null)			targetInstanceName = Messages.getString("org.isistan.flabot.engine.dialogs.ResponsibilityExecutionStateDialog.defaultTargetInstanceName"); //$NON-NLS-1$		else			targetInstanceName = targetInstance.getFullName();				targetResponsibilityName = node.getName();				targetScenarioName = node.getMap().getName();		targetComponentName = Messages.getString("org.isistan.flabot.engine.dialogs.ResponsibilityExecutionStateDialog.defaultTargetComponentName"); //$NON-NLS-1$		if (node instanceof ResponsibilityNode && ((ResponsibilityNode)node).getRole() != null)			targetComponentName = ((ResponsibilityNode)node).getRole().getComponent().getName();		else 			targetComponentName = targetInstanceName;				//Source Responsibility		sourceResponsibilityNode = (SimplePathNode) engineContext.get(InterfaceContextInfo.PRE_RESPONSIBILITY_NODE);				ComponentRole sourceInstance = (ComponentRole) engineContext.get(InterfaceContextInfo.PRE_INSTANCE);		if (sourceResponsibilityNode instanceof StubNode)			sourceInstanceName = Messages.getString("org.isistan.flabot.engine.dialogs.ResponsibilityExecutionStateDialog.defaultSourceInstanceStub"); //$NON-NLS-1$		else if (sourceInstance == null)			sourceInstanceName = Messages.getString("org.isistan.flabot.engine.dialogs.ResponsibilityExecutionStateDialog.defaultSourceInstanceName"); //$NON-NLS-1$		else			sourceInstanceName = sourceInstance.getFullName();				sourceResponsibilityName = sourceResponsibilityNode.getName();				sourceScenarioName = sourceResponsibilityNode.getMap().getName();		sourceComponentName = Messages.getString("org.isistan.flabot.engine.dialogs.ResponsibilityExecutionStateDialog.defaultSourceComponentName"); //$NON-NLS-1$		if (sourceResponsibilityNode instanceof ResponsibilityNode && ((ResponsibilityNode)sourceResponsibilityNode).getRole() != null)			sourceComponentName = ((ResponsibilityNode)sourceResponsibilityNode).getRole().getComponent().getName();		else 			sourceComponentName = sourceInstanceName;	}		public void setDiagnosticInfo(Diagnostic diagnostic, List<Tag> tagsBefore, List<Tag> tagsAfter) {				this.diagnostic = diagnostic;		this.tagsBefore = tagsBefore;		this.tagsAfter = tagsAfter;	}		public ExecutionState getSelectedExecutionState(ExecutionState actualExecutionState) {		return run(actualExecutionState);	}		/**	 * Runs the application	 */	public ExecutionState run(ExecutionState actualExecutionState) {		this.actualExecutionState = actualExecutionState;				// Don't return from open() until window closes		setBlockOnOpen(true);		setShellStyle(getShellStyle()/* + SWT.APPLICATION_MODAL*/);				// Open the main window		open();				return values;	}				/**	 * Constrain the shell size to be no larger than the display bounds.	 * 	 * @since 2.0	 */	protected void constrainShellSize() {		super.constrainShellSize();	    Shell shell = getShell();		Display display = getShell().getDisplay();			    	    Rectangle r = display.getClientArea();				int centerX = r.width - shell.getSize().x;		int centerY = r.height/2 - shell.getSize().y / 2;		shell.setLocation(centerX, centerY);	}				/**	 * Configures the shell	 * 	 * @param shell the shell	 */	protected void configureShell(Shell shell) {		super.configureShell(shell);		shell.setText(Messages.getString("org.isistan.flabot.engine.ResponsibilityExecutionStateDialog.executionStateSelection")); //$NON-NLS-1$	}	
	/**	 * Creates the main window's contents	 * 	 * @param parent the main window	 * @return Control	 */	protected Control createContents(Composite parent) {		Composite shell = new Composite(parent, SWT.NONE);				GridLayout layout = new GridLayout(1, false);		layout.verticalSpacing = 12;		layout.horizontalSpacing = 12;		shell.setLayout(layout);				shell.setLayoutData(new GridData(GridData.FILL_BOTH));		
		Group descriptionGroup = new Group(shell, SWT.NONE);		descriptionGroup.setText(Messages.getString("org.isistan.flabot.engine.dialogs.ResponsibilityExecutionStateDialog.descriptionGroup")); //$NON-NLS-1$		layout = new GridLayout(1, false);		layout.verticalSpacing = 12;		layout.horizontalSpacing = 12;		descriptionGroup.setLayout(layout);				descriptionGroup.setLayoutData(new GridData(GridData.FILL_BOTH));	    final Label id = new Label(descriptionGroup, SWT.NULL);	    id.setText(Messages.getString("org.isistan.flabot.engine.ResponsibilityExecutionStateDialog.evaluatingDescription", eventName, conditionName)); //$NON-NLS-1$	    								    Composite composite = new Composite(shell, SWT.NONE);	    layout = new GridLayout(2, false);	    layout.marginHeight = 0;		layout.marginWidth = 0;	    layout.verticalSpacing = 0;		layout.horizontalSpacing = 0;		composite.setLayout(layout);				composite.setLayoutData(new GridData(GridData.FILL_BOTH));	    	    		//Source responsibility node group	    Group sourceResponsibilityGroup = new Group(composite, SWT.NONE);
		sourceResponsibilityGroup.setText(Messages.getString("org.isistan.flabot.engine.dialogs.ResponsibilityExecutionStateDialog.sourceResponsibilityNodeGroup"));		 //$NON-NLS-1$
				layout = new GridLayout(2, false);
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		sourceResponsibilityGroup.setLayout(layout);		
		sourceResponsibilityGroup.setLayoutData(new GridData(GridData.FILL_BOTH));		createResponsibilityGroup(sourceResponsibilityGroup, sourceInstanceName, sourceResponsibilityName, sourceComponentName, sourceScenarioName);				//Target responsibility node group		Group targetResponsibilityGroup = new Group(composite, SWT.NONE);		targetResponsibilityGroup.setText(Messages.getString("org.isistan.flabot.engine.dialogs.ResponsibilityExecutionStateDialog.evaluatingResponsibilityNodeGroup"));		 //$NON-NLS-1$				layout = new GridLayout(2, false);		layout.verticalSpacing = 12;		layout.horizontalSpacing = 12;		targetResponsibilityGroup.setLayout(layout);				targetResponsibilityGroup.setLayoutData(new GridData(GridData.FILL_BOTH));		createResponsibilityGroup(targetResponsibilityGroup, targetInstanceName, targetResponsibilityName, targetComponentName, targetScenarioName);				if (diagnostic != null) {			createDiagnosticGroup(targetResponsibilityGroup, tagsBefore, tagsAfter);		}		      	//States group
	    Group statesGroup = new Group(shell, SWT.NONE);
	    statesGroup.setText(Messages.getString("org.isistan.flabot.engine.ResponsibilityExecutionStateDialog.states")); //$NON-NLS-1$
		
		layout = new GridLayout(1, false);
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		statesGroup.setLayout(layout);		
		statesGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
			    	    	    //Load Execution States combos		ExecutionState[] executionStates = {ExecutionState.NOT_EXECUTED_LITERAL,	    									ExecutionState.FAULTY_LITERAL,	    									ExecutionState.EXECUTED_LITERAL};	    	    int index = 0;	    for(ExecutionState executionState: executionStates) {			radios[index] = new Button(statesGroup, SWT.RADIO);			radios[index].setData(executionState);			radios[index].setText(executionState.getName());						if (executionState == actualExecutionState) {				radios[index].setFocus();			    radios[index].setSelection(true);			    values = (ExecutionState)radios[index].getData();			}			index++;	    }	    	    //Button Ok	    Composite buttonsComposite = new Composite(shell, SWT.NONE);
		buttonsComposite.setLayout(new RowLayout());
		buttonsComposite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
		
	    final Button buttonOK = new Button(buttonsComposite, SWT.PUSH);
	    buttonOK.setText(Messages.getString("org.isistan.flabot.edit.editor.okButton")); //$NON-NLS-1$
	    buttonOK.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event event) {
	        	for (int i=0; i < radios.length; i++)
	            	if (radios[i].getSelection())
	            		values = (ExecutionState)radios[i].getData();
	        	close();	        	
	        }
	    });			    return shell;  }
  
  private void createInterfaceInstance(Composite c, String instanceName) {
	    final Label id = new Label(c, SWT.WRAP);
	    id.setText(Messages.getString("org.isistan.flabot.engine.ResponsibilityExecutionStateDialog.instance")); //$NON-NLS-1$
	    	    final Text idtext = new Text(c, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
	    idtext.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
	    idtext.setText(instanceName);
  }
  
  private void createInterfaceResponsibilityName(Composite c, String responsibilityName) {
	    final Label id = new Label(c, SWT.NULL);
	    id.setText(Messages.getString("org.isistan.flabot.engine.ResponsibilityExecutionStateDialog.responsibilityName")); //$NON-NLS-1$
	   
	    final Text idtext = new Text(c, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
	    idtext.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
	    idtext.setText(responsibilityName);
  }
  
  private void createInterfaceComponent(Composite c, String componentName) {
	    final Label id = new Label(c, SWT.NULL);
	    id.setText(Messages.getString("org.isistan.flabot.engine.ResponsibilityExecutionStateDialog.componentType")); //$NON-NLS-1$
	    
	    final Text idtext = new Text(c, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
	    idtext.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
	    idtext.setText(componentName);
  }
    
  private void createInterfaceScenario(Composite c, String scenarioName) {
	    final Label id = new Label(c, SWT.NULL);
	    id.setText(Messages.getString("org.isistan.flabot.engine.ResponsibilityExecutionStateDialog.scenario")); //$NON-NLS-1$
	    
	    final Text idtext = new Text(c, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
	    idtext.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
	    idtext.setText(scenarioName);
  }      private void createDiagnosticGroup(Composite c, final List<Tag> tagsBefore, final List<Tag> tagsAfter) {	  final Label idBefore = new Label(c, SWT.NULL);	  idBefore.setText(Messages.getString("org.isistan.flabot.engine.dialogs.ResponsibilityExecutionStateDialog.tagsBefore")); //$NON-NLS-1$	  	  final Button buttonBefore = new Button(c, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);	  GridData gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);	  gd.widthHint = 80;	  buttonBefore.setLayoutData(gd);	  buttonBefore.setText(Messages.getString("org.isistan.flabot.engine.dialogs.ResponsibilityExecutionStateDialog.viewTagsBeforeButton")); //$NON-NLS-1$	  buttonBefore.addSelectionListener(new SelectionAdapter() {			public void widgetSelected(SelectionEvent e) {				TagFilterDialogManager.INSTANCE.filterTags(Messages.getString("org.isistan.flabot.engine.dialogs.ResponsibilityExecutionStateDialog.showTagsBeforeDialogTitle"), tagsBefore, Collections.EMPTY_LIST, true); //$NON-NLS-1$			}	  });	  	  final Label idAfter = new Label(c, SWT.NULL);	  idAfter.setText(Messages.getString("org.isistan.flabot.engine.dialogs.ResponsibilityExecutionStateDialog.tagsAfter")); //$NON-NLS-1$	  	  final Button buttonAfter = new Button(c, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);	  gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);	  	  gd.widthHint = 80;	  buttonAfter.setLayoutData(gd);	  buttonAfter.setText(Messages.getString("org.isistan.flabot.engine.dialogs.ResponsibilityExecutionStateDialog.viewTagsAfterButton")); //$NON-NLS-1$	  buttonAfter.addSelectionListener(new SelectionAdapter() {			public void widgetSelected(SelectionEvent e) {				TagFilterDialogManager.INSTANCE.filterTags(Messages.getString("org.isistan.flabot.engine.dialogs.ResponsibilityExecutionStateDialog.showTagsAfterDialogTitle"), tagsAfter, Collections.EMPTY_LIST, true); //$NON-NLS-1$			}	  });	  	    }    private void createResponsibilityGroup(Composite composite, String instanceName, String responsibilityName, String componentName, String scenarioName) {	  createInterfaceInstance(composite, instanceName);	  createInterfaceResponsibilityName(composite, responsibilityName);	  createInterfaceComponent(composite, componentName);	  createInterfaceScenario(composite, scenarioName);  }
}