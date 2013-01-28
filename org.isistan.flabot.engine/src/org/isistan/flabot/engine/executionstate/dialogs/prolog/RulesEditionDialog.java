/**
 * $Id: RulesEditionDialog.java,v 1.8 2006/04/13 01:41:07 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs.prolog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.PredefinedCondition;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.SnapshotPredefinedCondition;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.properties.ArgumentPredefinedProperty;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.properties.ExecutionInstancePredefinedProperty;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.properties.ReturnValuePredefinedProperty;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.properties.SnapshotFieldPredefinedProperty;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.properties.SnapshotNullPredefinedProperty;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.properties.SnapshotObjectPredefinedProperty;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.properties.SnapshotToStringPredefinedProperty;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.properties.StringMatchingPredefinedProperty;
import org.isistan.flabot.engine.messages.Messages;

/**
 * @author usuario
 *
 */
public class RulesEditionDialog extends Dialog {	
	
	/**
	 * the dialog's shell
	 */
	private Shell shell = null;  //  @jve:decl-index=0:visual-constraint="10,9"		

	private Combo comboStates;
	
	private Combo comboRules;
	
	private Text previewText;
	
	private Label descriptionText;
	
	private Group configurationGroup;
	
	private PredefinedCondition selectedPredefinedCondition;
	
	private Map<String, List<PredefinedCondition>> conditions = new HashMap<String, List<PredefinedCondition>>();	

	private ScrolledComposite strategyConfigurationComposite;

	private String returnText;
	
	private String[] requiredRules;
	
	private int validSelections = 0;
	
	private Button buttonOK;
	
	/**
	 * @param parent
	 */
	public RulesEditionDialog(Shell parent) {
		super(parent, 0);
	}
	/**
	 * Makes the dialog visible.
	 * 
	 * @return
	 */
	public String open(Map<String, List<PredefinedCondition>> conditions) {
		this.conditions = conditions;
		
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.RulesEditionDialog.tabName")); //$NON-NLS-1$
		shell.setLayout(new GridLayout(1, true));		
		
		shell.addShellListener(new org.eclipse.swt.events.ShellAdapter() {				
			public void shellClosed(org.eclipse.swt.events.ShellEvent e) {
				handleCancel();
			}
		});
		
		Group propertyGroup = new Group(shell, SWT.NONE);
		propertyGroup.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.RulesEditionDialog.group")); //$NON-NLS-1$
		
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		
		propertyGroup.setLayout(layout);		
		propertyGroup.setLayoutData(new GridData(GridData.FILL_BOTH));		
		
		createComboStates(propertyGroup);
		createComboRules(propertyGroup);
		createDescription(shell);
		createConditionConfigurationGroup(shell);
		
		//Load Combo
		if (comboStates.getItemCount() > 0) {			
			comboStates.select(0);
			updateConditions((List<PredefinedCondition>)comboStates.getData(String.valueOf(comboStates.getSelectionIndex())));
		}
    
    	// buttons composite (ok and cancel)	
		Composite buttonsComposite = new Composite(shell, SWT.NONE);
		buttonsComposite.setLayout(new RowLayout());
		buttonsComposite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
	
		buttonOK = new Button(buttonsComposite, SWT.NONE);
		buttonOK.setEnabled(false);
		buttonOK.setText(Messages.getString("org.isistan.flabot.edit.editor.okButton")); //$NON-NLS-1$
		buttonOK.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleOk();
			}
		});
		
		Button buttonCancel = new Button(buttonsComposite, SWT.NONE);
		buttonCancel.setText(Messages.getString("org.isistan.flabot.edit.editor.cancelButton")); //$NON-NLS-1$
		buttonCancel.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleCancel();
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
		
		return returnText;
	}
	
	private void createComboStates(Composite composite) {
		new Label(composite, SWT.NULL).setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.RulesEditionDialog.stateLabel")); //$NON-NLS-1$
		
		comboStates = new Combo(composite, SWT.READ_ONLY);	
		comboStates.addListener(SWT.Selection, new Listener() {
	    	public void handleEvent(Event event) {
	    		//Reset the condition
	    		if (selectedPredefinedCondition != null)
	    			selectedPredefinedCondition.getProperties().clear();
	    		updateConditions((List<PredefinedCondition>) comboStates.getData(String.valueOf(comboStates.getSelectionIndex())));
	    	}
		});		
		
		for(Iterator<String> iter=conditions.keySet().iterator(); iter.hasNext();) {
			String condition = iter.next();
			comboStates.setData(String.valueOf(comboStates.getItemCount()), conditions.get(condition));
			comboStates.add(condition);
		}
	}
	
	private void createComboRules(Composite composite) {
		new Label(composite, SWT.NULL).setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.RulesEditionDialog.predefinedConditionLabel")); //$NON-NLS-1$
		
		comboRules = new Combo(composite, SWT.READ_ONLY);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.widthHint = 100;
		comboRules.setLayoutData(gd);
		comboRules.addListener(SWT.Selection, new Listener() {
	    	public void handleEvent(Event event) {	    		
	    		updateRuleChanged((PredefinedCondition)comboRules.getData(String.valueOf(comboRules.getSelectionIndex())));
	    	}
		});
	}
	
	private void createDescription(Composite c) {
		Group descriptionGroup = new Group(c, SWT.NONE);
		descriptionGroup.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.RulesEditionDialog.descriptionGroup")); //$NON-NLS-1$
		GridLayout layout = new GridLayout(1, false);
		layout.verticalSpacing = 1;
		layout.horizontalSpacing = 1;
		
		descriptionGroup.setLayout(layout);		
		descriptionGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		descriptionText = new Label(descriptionGroup, SWT.NONE);
		descriptionText.setLayoutData(new GridData(GridData.FILL_BOTH));
	}
	
	private void createConditionConfigurationGroup(Composite c) {
		configurationGroup = new Group(c, SWT.NONE);
		configurationGroup.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.RulesEditionDialog.configurationConditionGroup")); //$NON-NLS-1$
		GridLayout layout = new GridLayout(1, false);
		layout.verticalSpacing = 1;
		layout.horizontalSpacing = 1;
		
		configurationGroup.setLayout(layout);		
		configurationGroup.setLayoutData(new GridData(GridData.FILL_BOTH));		
		
		Group previewGroup = new Group(c, SWT.NONE);
		previewGroup.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.RulesEditionDialog.previewGroup")); //$NON-NLS-1$
		
		layout = new GridLayout(1, false);
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		
		previewGroup.setLayout(layout);		
		previewGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		previewText = new Text(previewGroup,  SWT.MULTI | SWT.BORDER | SWT.READ_ONLY | SWT.V_SCROLL | SWT.H_SCROLL);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.widthHint = 200;
		gd.heightHint = 100;
		previewText.setLayoutData(gd);
	}

	private void updateConditions(List<PredefinedCondition> predefinedConditions) {
		comboRules.removeAll();
		
		for(PredefinedCondition predefinedCondition : predefinedConditions) {
			comboRules.setData(String.valueOf(comboRules.getItemCount()), predefinedCondition);
			comboRules.add(predefinedCondition.getName());
		}
		
		if (comboRules.getItemCount() > 0) {
			comboRules.select(0);
			updateRuleChanged((PredefinedCondition)comboRules.getData(String.valueOf(comboRules.getSelectionIndex())));
		}		
	}	
	
	private void updateRuleChanged(PredefinedCondition predefinedCondition) {
		//Reset the condition
		if (selectedPredefinedCondition != null)
			selectedPredefinedCondition.getProperties().clear();	
		selectedPredefinedCondition = predefinedCondition;
		
		buildConfiguration(predefinedCondition);
		updatePreview(predefinedCondition);
	}
	
	private void updatePreview(PredefinedCondition predefinedCondition) {		
		previewText.setText(predefinedCondition.getPrologCode());
		descriptionText.setText(predefinedCondition.getDescription());
	}
	
	private void buildConfiguration(PredefinedCondition predefinedCondition) {

		if (strategyConfigurationComposite != null &&
				!strategyConfigurationComposite.isDisposed())
			strategyConfigurationComposite.dispose();
		
		// create the scrolled composite (contains the strategy-specific composite)
		strategyConfigurationComposite =
			new ScrolledComposite(configurationGroup, SWT.HORIZONTAL|SWT.VERTICAL);
		Composite c = new Composite(strategyConfigurationComposite, SWT.NONE);
		((ScrolledComposite)strategyConfigurationComposite).setContent(c);
		
		c.setLayout(new GridLayout(3, false));
		
		Map<Integer, PredefinedCondition> properties = predefinedCondition.getProperties();
		int accepted = 0;		

		if (predefinedCondition.acceptProperty(PredefinedCondition.RETURN_VALUE_PROPERTY)) {
			PredefinedCondition pp = properties.get(Integer.valueOf(PredefinedCondition.RETURN_VALUE_PROPERTY));
			if (pp == null)
				pp = new ReturnValuePredefinedProperty();
			create(c, Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.RulesEditionDialog.returnValueGroup"), predefinedCondition, PredefinedCondition.RETURN_VALUE_PROPERTY, pp); //$NON-NLS-1$
			accepted++;
		}

		if (predefinedCondition.acceptProperty(PredefinedCondition.ARGUMENTS_PROPERTY)) {
			PredefinedCondition pp = properties.get(Integer.valueOf(PredefinedCondition.ARGUMENTS_PROPERTY));
			if (pp == null)
				pp = new ArgumentPredefinedProperty();
			create(c, Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.RulesEditionDialog.argumentsGroup") , predefinedCondition, PredefinedCondition.ARGUMENTS_PROPERTY, pp); //$NON-NLS-1$
			accepted++;
		}
		
		if (predefinedCondition.acceptProperty(PredefinedCondition.INSTANCE_PROPERTY)) {
			PredefinedCondition pp = properties.get(Integer.valueOf(PredefinedCondition.INSTANCE_PROPERTY));
			if (pp == null)
				pp = new ExecutionInstancePredefinedProperty();
			create(c, Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.RulesEditionDialog.instanceGroup") , predefinedCondition, PredefinedCondition.INSTANCE_PROPERTY, pp); //$NON-NLS-1$
			accepted++;
		}
		
		if (accepted == 0) {
			new Label(c, SWT.NONE).setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.RulesEditionDialog.noConfigurationNeeded")); //$NON-NLS-1$
		}
		updateButtons(accepted == 0);
		
		// compute the composite's size and layout
		c.setSize(c.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		configurationGroup.layout(true);
	}
	
	private void create(Composite composite, String name, final PredefinedCondition predefinedCondition, final int property, final PredefinedCondition predefinedPropery) {
		Group configurationGroup = new Group(composite, SWT.NONE);
		configurationGroup.setText(name);
		GridLayout layout = new GridLayout(2, false);	
		configurationGroup.setLayout(layout);		
		configurationGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		final Button checkReturnValueButton = new Button(configurationGroup, SWT.CHECK);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;
		checkReturnValueButton.setLayoutData(gd);
		checkReturnValueButton.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.RulesEditionDialog.evaluate") + name); //$NON-NLS-1$
		
		final Control[] controls = createSnapshotGroup(configurationGroup, predefinedCondition, property, predefinedPropery);
		updateControls(controls, false);
		
		checkReturnValueButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (checkReturnValueButton.getSelection()) {
					predefinedCondition.setPredefinedProperty(property, predefinedPropery);
					validSelections++;
				} else {
					predefinedCondition.setPredefinedProperty(property, null);
					validSelections--;
				}
				updateButtons(validSelections > 0);
				updateControls(controls, checkReturnValueButton.getSelection());
				updatePreview(predefinedCondition);
			}
		});
	}
	
	private void updateButtons(boolean enabled) {
		if (buttonOK != null)
			buttonOK.setEnabled(enabled);
	}
	
	private void updateControls(Control[] controls, boolean value) {
		for (Control control : controls) {
			control.setEnabled(value);
		}
	}
	
	private Control[] createSnapshotGroup(Composite composite, final PredefinedCondition predefinedCondition, final int property, final PredefinedCondition predefinedProperty) {
		String fieldName = predefinedProperty.getFieldName();		
		SnapshotPredefinedCondition snapshotPredefinedPropery = (SnapshotPredefinedCondition)predefinedProperty;
		final List<Control> controls = new ArrayList<Control>();
		final List<Control> returnControls = new ArrayList<Control>();		
		if (snapshotPredefinedPropery.acceptSnaptshot(SnapshotPredefinedCondition.SNAPSHOT_TOSTRING_PROPERTY))  {
			createSnapshotToString(composite, returnControls, controls, predefinedCondition, fieldName, property);			
		}			
		if (snapshotPredefinedPropery.acceptSnaptshot(SnapshotPredefinedCondition.SNAPSHOT_FIELD_PROPERTY))  {
			createSnapshotField(composite, returnControls, controls, predefinedCondition, fieldName, property);
		}		
		if (snapshotPredefinedPropery.acceptSnaptshot(SnapshotPredefinedCondition.SNAPSHOT_OBJECT_PROPERTY))  {
			createSnapshotObject(composite, returnControls, controls, predefinedCondition, fieldName, property);
		}		
		if (snapshotPredefinedPropery.acceptSnaptshot(SnapshotPredefinedCondition.SNAPSHOT_NULL_PROPERTY))  {
			createSnapshotNull(composite, returnControls, controls, predefinedCondition, fieldName, property);
		}			
		return returnControls.toArray(new Control[returnControls.size()]);
	}
	
	private void createSnapshotToString(Composite composite, List<Control> returnControls, final List<Control> controls, final PredefinedCondition predefinedCondition, String fieldName, final int property) {
		final Button radioToStringButton = new Button(composite, SWT.RADIO);
		radioToStringButton.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.RulesEditionDialog.toStringLabel"));		 //$NON-NLS-1$
		SnapshotToStringPredefinedProperty snapshotToStringPredefinedProperty = new SnapshotToStringPredefinedProperty(fieldName); 
		radioToStringButton.setData(snapshotToStringPredefinedProperty);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;
		radioToStringButton.setLayoutData(gd);
		returnControls.add(radioToStringButton);
	
		final Label toStringLabel = new Label(composite, SWT.NONE);
		toStringLabel.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.RulesEditionDialog.valueLabel")); //$NON-NLS-1$
		toStringLabel.setEnabled(false);
		gd = new GridData();
		gd.horizontalIndent = 20;
		toStringLabel.setLayoutData(gd);
		controls.add(toStringLabel);			
		final Control controlToString = addButtonEdition(composite, (StringMatchingPredefinedProperty)snapshotToStringPredefinedProperty.getMatchingToString(), predefinedCondition);
		controlToString.setEnabled(false);
		controls.add(controlToString);
		
		radioToStringButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				updateControls(controls.toArray(new Control[controls.size()]), false);
				controlToString.setEnabled(true);
				toStringLabel.setEnabled(true);
				updateProperty(predefinedCondition, property, (PredefinedCondition)radioToStringButton.getData());
				updatePreview(predefinedCondition);
			}
		});
	}
	
	private void createSnapshotField(Composite composite, List<Control> returnControls, final List<Control> controls, final PredefinedCondition predefinedCondition, String fieldName, final int property) {
		final  Button radioFieldButton = new Button(composite, SWT.RADIO);		
		radioFieldButton.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.RulesEditionDialog.useFieldLabel")); //$NON-NLS-1$
		SnapshotFieldPredefinedProperty snapshotFieldPredefinedProperty = new SnapshotFieldPredefinedProperty(fieldName);
		radioFieldButton.setData(snapshotFieldPredefinedProperty);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;
		radioFieldButton.setLayoutData(gd);
		returnControls.add(radioFieldButton);
	
		final Label fieldNameLabel = new Label(composite, SWT.NONE);
		fieldNameLabel.setEnabled(false);
		fieldNameLabel.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.RulesEditionDialog.fieldNameLabel"));	 //$NON-NLS-1$
		gd = new GridData();
		gd.horizontalIndent = 20;
		fieldNameLabel.setLayoutData(gd);
		controls.add(fieldNameLabel);
		final Control controlValue1 = addButtonEdition(composite, (StringMatchingPredefinedProperty) snapshotFieldPredefinedProperty.getMatchingName(), predefinedCondition);
		controlValue1.setEnabled(false);
		controls.add(controlValue1);
		
		final Label fieldValueLabel = new Label(composite, SWT.NONE);
		fieldValueLabel.setEnabled(false);
		fieldValueLabel.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.RulesEditionDialog.fieldValueLabel")); //$NON-NLS-1$
		gd = new GridData();
		gd.horizontalIndent = 20;
		fieldValueLabel.setLayoutData(gd);
		controls.add(fieldValueLabel);
		final Control controlValue2 = addButtonEdition(composite, (StringMatchingPredefinedProperty) snapshotFieldPredefinedProperty.getMatchingValue(), predefinedCondition);
		controlValue2.setEnabled(false);
		controls.add(controlValue2);
		
		radioFieldButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				updateControls(controls.toArray(new Control[controls.size()]), false);
				controlValue1.setEnabled(true);
				controlValue2.setEnabled(true);
				fieldNameLabel.setEnabled(true);
				fieldValueLabel.setEnabled(true);
				updateProperty(predefinedCondition, property, (PredefinedCondition)radioFieldButton.getData());
				updatePreview(predefinedCondition);
			}
		});
	}
	
	private void createSnapshotObject(Composite composite, List<Control> returnControls, final List<Control> controls, final PredefinedCondition predefinedCondition, String fieldName, final int property) {
		final Button radioObjectButton = new Button(composite, SWT.RADIO);
		radioObjectButton.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.RulesEditionDialog.objectLabel"));		 //$NON-NLS-1$
		SnapshotObjectPredefinedProperty snapshotToStringPredefinedProperty = new SnapshotObjectPredefinedProperty(fieldName); 
		radioObjectButton.setData(snapshotToStringPredefinedProperty);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;
		radioObjectButton.setLayoutData(gd);
		returnControls.add(radioObjectButton);
	
		final Label classLabel = new Label(composite, SWT.NONE);
		classLabel.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.RulesEditionDialog.classNameLabel")); //$NON-NLS-1$
		classLabel.setEnabled(false);
		gd = new GridData();
		gd.horizontalIndent = 20;
		classLabel.setLayoutData(gd);
		controls.add(classLabel);			
		final Control controlObject = addButtonEdition(composite, (StringMatchingPredefinedProperty)snapshotToStringPredefinedProperty.getMatchingToString(), predefinedCondition);
		controlObject.setEnabled(false);
		controls.add(controlObject);
		
		radioObjectButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				updateControls(controls.toArray(new Control[controls.size()]), false);
				controlObject.setEnabled(true);
				classLabel.setEnabled(true);
				updateProperty(predefinedCondition, property, (PredefinedCondition)radioObjectButton.getData());
				updatePreview(predefinedCondition);
			}
		});
	}
	
	private void createSnapshotNull(Composite composite, List<Control> returnControls, final List<Control> controls, final PredefinedCondition predefinedCondition, String fieldName, final int property) {
		final Button radioNullButton = new Button(composite, SWT.RADIO);
		radioNullButton.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.RulesEditionDialog.nullLabel")); //$NON-NLS-1$
		SnapshotNullPredefinedProperty snapshotNullPredefinedProperty = new SnapshotNullPredefinedProperty(fieldName); 
		radioNullButton.setData(snapshotNullPredefinedProperty);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;
		radioNullButton.setLayoutData(gd);
		returnControls.add(radioNullButton);
		
		radioNullButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				updateControls(controls.toArray(new Control[controls.size()]), false);
				updateProperty(predefinedCondition, property, (PredefinedCondition)radioNullButton.getData());
				updatePreview(predefinedCondition);
			}
		});
	}
	
	private void updateProperty(PredefinedCondition predefinedCondition, int property, PredefinedCondition predefinedValue) {
		PredefinedCondition pc = predefinedCondition.getProperties().get(Integer.valueOf(property));
		if (pc != null) {
			pc.setPredefinedProperty(PredefinedCondition.SNAPSHOT_PROPERTY, predefinedValue);
		}
	}
		
	private Control addButtonEdition(Composite composite, final StringMatchingPredefinedProperty pp, final PredefinedCondition predefinedCondition) {
		Button button = new Button(composite, SWT.NONE);
		button.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.prolog.RulesEditionDialog.editButton")); //$NON-NLS-1$
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				MatchingPredefinedPropertyDialog dialog = new MatchingPredefinedPropertyDialog(shell);
				PredefinedCondition changed = dialog.open(pp);
				if (changed != null)
					updatePreview(predefinedCondition);				
			}
		});
		return button;
	}	
	
	public String[] getRequiredRules() {
		return requiredRules;
	}
	
	private void handleCancel() {
		//Reset the condition
		if (selectedPredefinedCondition != null)
			selectedPredefinedCondition.getProperties().clear();
		returnText = null;
		shell.dispose();
	}
	
	private void handleOk() {
		returnText = null;
		//Reset the condition
		if (selectedPredefinedCondition != null) {
			returnText = selectedPredefinedCondition.getPrologCode();
			requiredRules = selectedPredefinedCondition.getRequiredRules();
			selectedPredefinedCondition.getProperties().clear();			
		}
		shell.dispose();
	}
}