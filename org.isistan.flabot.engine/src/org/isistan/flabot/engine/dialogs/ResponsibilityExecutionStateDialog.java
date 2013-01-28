/**

import java.util.Collections;
		
	private String sourceResponsibilityName;
	private String sourceInstanceName;
	private String sourceComponentName;
	private String sourceScenarioName;
	
	
	private List<Tag> tagsBefore, tagsAfter;
	public ResponsibilityExecutionStateDialog(Shell parent) {
		//So it opens in a new window
	}

	public void setExecutionInfo(SimplePathNode node, Map engineContext) {		
	/**
		Group descriptionGroup = new Group(shell, SWT.NONE);
		sourceResponsibilityGroup.setText(Messages.getString("org.isistan.flabot.engine.dialogs.ResponsibilityExecutionStateDialog.sourceResponsibilityNodeGroup"));		 //$NON-NLS-1$
		
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		sourceResponsibilityGroup.setLayout(layout);		
		sourceResponsibilityGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
	    Group statesGroup = new Group(shell, SWT.NONE);
	    statesGroup.setText(Messages.getString("org.isistan.flabot.engine.ResponsibilityExecutionStateDialog.states")); //$NON-NLS-1$
		
		layout = new GridLayout(1, false);
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		statesGroup.setLayout(layout);		
		statesGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
			    	    
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
	    });		
  
  private void createInterfaceInstance(Composite c, String instanceName) {
	    final Label id = new Label(c, SWT.WRAP);
	    id.setText(Messages.getString("org.isistan.flabot.engine.ResponsibilityExecutionStateDialog.instance")); //$NON-NLS-1$
	    
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
  }  
}