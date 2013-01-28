/**
 * $Id: EditDependencyDialog.java,v 1.22 2006/05/04 21:20:23 apersson Exp $
 * $Author: apersson $
 */
package org.isistan.flabot.edit.ucmeditor.dialogs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.coremodel.FamilyElement;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.edit.editor.dialogs.StandardEditionDialog;
import org.isistan.flabot.edit.ucmeditor.commands.model.AddConditionEventToCoreModelCommand;
import org.isistan.flabot.edit.ucmeditor.commands.model.AddFamilyToCoreModelCommand;
import org.isistan.flabot.edit.ucmeditor.commands.model.ModifyConditionCommand;
import org.isistan.flabot.edit.ucmeditor.dialogs.event.ConditionEventEditionItem;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.problems.log.LoggerMessageAccumulator;

/**
 * Dialog that's used to edit the responsibility node conditions properties (including name, dependency, use case map, responsibility node, family and event).
 * 
 * @author $Author: apersson $
 *
 */
public class EditDependencyDialog extends Dialog {

	/**
	 * the dialog's shell
	 */
	private Shell shell = null;  //  @jve:decl-index=0:visual-constraint="10,9"
	
	private Condition originalCondition;
	
	private Condition modifyCondition;
	
	private Map<UseCaseMap,Map<Responsibility, ResponsibilityNode>>  maps= new HashMap<UseCaseMap,Map<Responsibility, ResponsibilityNode>>();
	private CoreModel coreModel;
	
	private Text textName = null;	
	
	private Combo comboDependencies = null;	
	private Combo comboMap = null;
	private Combo comboResponsibilities = null;
	private Combo comboFamilies = null;
	private Combo comboConditionEvents = null;
	
	private int exitValue = SWT.CANCEL;
	
	private ResponsibilityNode selectedResponsibilityNode;

	private Vector mappingResponsibilites;
	
	/**
	 * 
	 * @param parent
	 */
	public EditDependencyDialog(Shell parent) {
		super(parent, 0);
	}
	
	/**
	 * Creates and open a dialog for editing responsibility node condition properties.
	 * 
	 * @param condition the condition to edit
	 * @param selectedResponsibilityNode the selected responsibility node
	 * @param mappingResponsibilities 
	 * @return the modification commands or null
	 */
	public Command open(List<String> dependencies, Condition condition, ResponsibilityNode selectedResponsibilityNode, Vector mappingResponsibilities) {
		this.coreModel = selectedResponsibilityNode.getResponsibility().getCoreModel();		
		this.selectedResponsibilityNode = selectedResponsibilityNode;
		this.mappingResponsibilites = mappingResponsibilities;
		this.originalCondition = condition;		
		this.modifyCondition = (Condition) EcoreUtil.copy(originalCondition);
		modifyCondition.setSourceResponsibility(selectedResponsibilityNode);				
		
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditDependencyDialog.dialogTitle")); //$NON-NLS-1$
		shell.setLayout(new GridLayout(1, false));
		
		shell.addShellListener(new org.eclipse.swt.events.ShellAdapter() {				
			public void shellClosed(org.eclipse.swt.events.ShellEvent e) {
				handleCancel();
			}
		});	
		
		Group dependencyGroup = new Group(shell, SWT.NONE);
		dependencyGroup.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditDependencyDialog.conditionGroup")); //$NON-NLS-1$
		
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		dependencyGroup.setLayout(layout);
		
		dependencyGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
				
		createConditionName(dependencyGroup);
		createDependency(dependencyGroup, dependencies);
		createFamily(dependencyGroup);
		createUseCaseMap(dependencyGroup);
		createResponsibility(dependencyGroup);		
		createEvent(dependencyGroup);
		
		//Load data
		updateConditionEvents(coreModel.getConditionEvents(),  condition.getEvent());
		updateFamilies(coreModel.getFamilies(), condition.getFamily(), selectedResponsibilityNode.getRole());	
		updateUseCaseMaps(coreModel.getUseCaseMaps(), condition.getUseCaseMap(), selectedResponsibilityNode.getMap());
		updateFamilyButton();
		
		// buttons composite (ok and cancel)	
		Composite buttonsComposite = new Composite(shell, SWT.NONE);
		buttonsComposite.setLayout(new RowLayout());
		buttonsComposite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
		
		Button buttonOK = new Button(buttonsComposite, SWT.NONE);
		buttonOK.setText(Messages.getString("org.isistan.flabot.edit.editor.okButton")); //$NON-NLS-1$
		buttonOK.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				String errorMessage = isValidEnd();
				if (!errorMessage.equals("")) { //$NON-NLS-1$
					MessageDialog dlg = new MessageDialog(
							shell,
				            Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditDependencyDialog.incompleteDataTitle"), //$NON-NLS-1$
				            null,
				            Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditDependencyDialog.incompleteDataMessage")+errorMessage+" ", //$NON-NLS-1$ //$NON-NLS-2$
				            MessageDialog.ERROR,
				            new String[]{Messages.getString("org.isistan.flabot.edit.editor.okButton")}, //$NON-NLS-1$	            
				            0);
					dlg.open();
				} else {
					setCondition();
					exitValue = SWT.OK;
					shell.dispose();
				}
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
		
		return getCommand();
	}
	
	/**
	 * Handles the cancel option.
	 * Also disposes the shell.
	 *
	 */
	private void handleCancel() {
		exitValue = SWT.CANCEL;
		shell.dispose();
	}
	
	/**
	 * Creates the label and text box for the Condition name.
	 * 
	 * @param parent the composite parent
	 */
	private void createConditionName(Composite parent) {
		// Condition Name
		final Label label = new Label(parent, SWT.NONE);
		label.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditDependencyDialog.conditionName"));  //$NON-NLS-1$
		
		textName = new Text(parent, SWT.BORDER);
		textName.setText(modifyCondition.getName());
		textName.setLayoutData(new GridData(
					GridData.VERTICAL_ALIGN_BEGINNING |
					GridData.FILL_HORIZONTAL));
	}
	
	/**
	 * Creates the label and combo box for the Condition dependencies.
	 * 
	 * @param parent the composite parent
	 */
	private void createDependency(Composite parent, List<String> dependencies) {
		// Dependecies
		final Label label = new Label(parent, SWT.NONE);
		label.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditDependencyDialog.conditionDependency")); //$NON-NLS-1$
						
		comboDependencies = new Combo(parent, SWT.READ_ONLY);
		comboDependencies.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));	
		
		for(String dependencyConditionID : dependencies) {
			comboDependencies.setData(String.valueOf(comboDependencies.getItemCount()), dependencyConditionID);
			comboDependencies.add(DependencyToNameFactory.getName(dependencyConditionID));			
		}				
		comboDependencies.select(0);
		
		comboDependencies.addListener(SWT.Selection, new Listener() {
	    	public void handleEvent(Event event) {
	    		updateFamilyButton();
	    		updateUseCaseMaps(coreModel.getUseCaseMaps(), getActiveMap(),  selectedResponsibilityNode.getMap());
	    	}
		});
		
		//Selects the actual dependency
		String dependency = modifyCondition.getType();
		for (int i=0; i < comboDependencies.getItemCount(); i++) {
			String d = (String)comboDependencies.getData(String.valueOf(i));
			if (dependency.equals(d)) {
				comboDependencies.select(i);
				break;
			}
		}
	}
	
	private void updateResponsibilities()  {
		comboResponsibilities.removeAll();
		
		UseCaseMap activeMap = getActiveMap();
		if (activeMap != null) {
			updateMapsResponsibilityNodes(activeMap);
			
			List list = getResponsibilitiesList((Map)maps.get(activeMap));
			for (int j=0; j<list.size(); j++) {
				Responsibility responsibility = (Responsibility)list.get(j);						
				ResponsibilityNode activeResponsibilityNode = (ResponsibilityNode)((Map)getResponsibilyToResponsibilyNodeMap(activeMap)).get(responsibility);
				String textSelected =  getActiveDependency();
				if (activeResponsibilityNode != modifyCondition.getSourceResponsibility() && (!(mappingResponsibilites.contains(activeResponsibilityNode)&&textSelected.equals(Condition.mappingCondition)))) {			
					comboResponsibilities.setData(String.valueOf(comboResponsibilities.getItemCount()), responsibility);
					comboResponsibilities.add(responsibility.getName());
					if (modifyCondition.getDependencyResponsibility() == activeResponsibilityNode)
						comboResponsibilities.select(comboResponsibilities.getItemCount() - 1);
				}
			}
			comboResponsibilities.setEnabled(true);
		} else
			comboResponsibilities.setEnabled(false);				
	}
	
	/**
	 * Updates the UseCaseMap combo box with a list of UseCaseMaps.
	 * The selectedMap is selected in the combo box if exists.
	 * It also updated the Responsibilities combo box.
	 * 
	 * @param useCaseMaps the list of UseCaseMaps to add to the combo
	 * @param selectedMap the UseCaseMap to select
	 */
	private void updateUseCaseMaps(List useCaseMaps, UseCaseMap selectedMap, UseCaseMap currentUseCaseMap) {
		comboMap.removeAll();
		
		for (int i=0; i < useCaseMaps.size(); i++) {
			UseCaseMap map = (UseCaseMap)useCaseMaps.get(i);
			String selectedDependency = (String) comboDependencies.getData(String.valueOf(comboDependencies.getSelectionIndex()));
			if (((selectedDependency.equals(Condition.constraintCondition) || selectedDependency.equals(Condition.preconditionCondition))&&(map.getLevelInfo().equals(currentUseCaseMap.getLevelInfo()))) || (selectedDependency.equals(Condition.mappingCondition) && map.getLevelInfo().equals(UseCaseMap.architecturalLevel))){
				comboMap.setData(String.valueOf(comboMap.getItemCount()), map);
				comboMap.add(map.getName());				
				if (selectedMap == map)
					comboMap.select(comboMap.getItemCount() - 1);												
			}
		}		
		updateResponsibilities();
	}

	/**
	 * Creates the label and combo box for the Condition use case maps.
	 * 
	 * @param parent the composite parent
	 */
	private void createUseCaseMap(Composite parent) {
		//Use Case Maps
		final Label label = new Label(parent, SWT.NONE);
		label.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditDependencyDialog.conditionUCM")); //$NON-NLS-1$
		
		comboMap = new Combo(parent, SWT.READ_ONLY);
		comboMap.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
				
		comboMap.addListener(SWT.Selection, new Listener() {
	    	public void handleEvent(Event event) {
	    		//When the map changed. The responsibilities combo must be updated.
	    		updateResponsibilities();
	    	}
		});			
	}
	
	/**
	 * Creates the label and combo box for the Condition responsibility nodes.
	 * 
	 * @param parent the composite parent
	 */
	private void createResponsibility(Composite parent) {
		//Responsibilities
		final Label label = new Label(parent, SWT.NONE);		
		label.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditDependencyDialog.conditionResponsibility")); //$NON-NLS-1$
		
		comboResponsibilities = new Combo(parent, SWT.READ_ONLY);
		comboResponsibilities.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));	
		comboResponsibilities.setEnabled(false);
	}
	
	/**
	 * Creates the label and combo box for the Condition families.
	 * 
	 * @param parent the composite parent
	 */
	private void createFamily(Composite parent) {
		//Family
		final Label label = new Label(parent, SWT.NONE);
		label.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditDependencyDialog.conditionFamily"));		 //$NON-NLS-1$
		
		Composite c = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2,false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		c.setLayout(layout);
		c.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		comboFamilies = new Combo(c, SWT.READ_ONLY);
		comboFamilies.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));	
		comboFamilies.setEnabled(false);	
		comboFamilies.addListener(SWT.Selection, new Listener() {
	    	public void handleEvent(Event event) {
	    		Family family = getActiveFamily();
	    		if (family != null) {
	    			updateUseCaseMaps(family.getArchitecturalUseCaseMaps(), getActiveMap(), selectedResponsibilityNode.getMap());
	    		} else {
	    			comboMap.setEnabled(false);
	    		}
	    	}
		});	
		
		
		Button familyManager = new Button(c, SWT.NONE);
		familyManager.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditDependencyDialog.conditionAddFamilyButton")); //$NON-NLS-1$
		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_END);
		gd.heightHint = 20;
		gd.horizontalIndent = 5;
		familyManager.setLayoutData(gd);
		familyManager.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				Family newFamily = CoremodelFactory.eINSTANCE.createFamily();
				FamilyManagerDialog managerdialog = new FamilyManagerDialog(shell);
				Command command = managerdialog.open(newFamily, coreModel.getArchitecturalUseCaseMaps(), coreModel.getFunctionalUseCaseMaps());
				if (command != null) {
					CompoundCommand commands = new CompoundCommand();
					commands.add(command);		
					commands.add( new AddFamilyToCoreModelCommand(coreModel, newFamily));
					commands.execute();
				}
				updateFamilies(coreModel.getFamilies(), modifyCondition.getFamily(), selectedResponsibilityNode.getRole());
			}
		});
	}
	
	/**
	 * Updates the Family combo box with a list of Families.
	 * The selectedFamily is selected in the combo box if exists.
	 * 
	 * @param families the list of Families to add to the combo
	 * @param selectedFamily the Family to select
	 */
	private void updateFamilies(List families, Family selectedFamily, ComponentRole mappedComponent) {
		comboFamilies.removeAll();
		
		for (Iterator iter=families.iterator(); iter.hasNext();) {
			Family family = (Family) iter.next();
			if (hasMappedComponent(family, mappedComponent)) {
				comboFamilies.setData(String.valueOf(comboFamilies.getItemCount()), family);
				comboFamilies.add(family.getName());
				if (family == selectedFamily)
					comboFamilies.select(comboFamilies.getItemCount() - 1);
			}
		}	
	}
	
	private boolean hasMappedComponent(Family family, ComponentRole component) {
		for (Iterator iter=family.getFamilyElement().iterator(); iter.hasNext();) {
			FamilyElement familyElement = (FamilyElement) iter.next();
			if (familyElement.getFunctionalComponent() == component)
				return true;
		}		
		return false;
	}
	
	/**
	 * Creates the label and combo box for the Condition events.
	 * 
	 * @param parent the composite parent
	 */
	private void createEvent(Composite parent) {
		//Event
		final Label label = new Label(parent, SWT.NONE);
		label.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditDependencyDialog.conditionEvent")); //$NON-NLS-1$
			
		Composite c = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2,false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		c.setLayout(layout);
		c.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		comboConditionEvents = new Combo(c, SWT.READ_ONLY);
		comboDependencies.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		Button eventManager = new Button(c, SWT.NONE);
		eventManager.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditDependencyDialog.conditionAddEventButton")); //$NON-NLS-1$
		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_END);
		gd.horizontalIndent = 5;
		gd.heightHint = 20;
		eventManager.setLayoutData(gd);
		eventManager.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				ConditionEvent newConditionEvent = CoremodelFactory.eINSTANCE.createConditionEvent();				
				StandardEditionDialog<ConditionEvent> f=getEditionDialog();
				Command command = f.open(newConditionEvent);
				if (command != null) {
					CompoundCommand commands = new CompoundCommand();
					commands.add(command);		
					commands.add(new AddConditionEventToCoreModelCommand(coreModel, newConditionEvent));
					commands.execute();
				}												
				updateConditionEvents(coreModel.getConditionEvents(), modifyCondition.getEvent());
			}
		});
	}
	
	private StandardEditionDialog<ConditionEvent> getEditionDialog() {
		StandardEditionDialog<ConditionEvent> f =
			new StandardEditionDialog<ConditionEvent>(
					shell,
					Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EventDialog.tabTitle"), //$NON-NLS-1$
					Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EventDialog.commandTabLabel"), //$NON-NLS-1$
					ConditionEventEditionItem.LOADER.getEditionItems(
							new LoggerMessageAccumulator()));
		return f;
	}
	
	/**
	 * Updates the ConditionEvent combo box with a list of ConditionEvents.
	 * The selectedEvent is selected in the combo box if exists.
	 * 
	 * @param conditionEvents the list of ConditionEvent to add to the combo
	 * @param selectedEvent the ConditionEvent to select
	 */
	private void updateConditionEvents(List conditionEvents, ConditionEvent selectedEvent) {
		comboConditionEvents.removeAll();
		
		for (int i=0; i < conditionEvents.size(); i++) {
			ConditionEvent event = (ConditionEvent)conditionEvents.get(i);
			comboConditionEvents.setData(String.valueOf(comboConditionEvents.getItemCount()), event);
			comboConditionEvents.add(event.getName());
			if (event == selectedEvent)
				comboConditionEvents.select(comboConditionEvents.getItemCount() - 1);
		}
	}
	
	/**
	 * Sets the edited values in the modified condition.
	 *
	 */
	private void setCondition() {		
		UseCaseMap activeMap = getActiveMap();
		Responsibility activeRespesponsibility = getActiveResponsibility();
		ResponsibilityNode activeResponsibilityNode = (ResponsibilityNode)((Map)getResponsibilyToResponsibilyNodeMap(activeMap)).get(activeRespesponsibility);
		Family activeFamily = getActiveFamily();
		ConditionEvent conditionEvent = getActiveConditionEvent();		
		String typeDependency = (String)comboDependencies.getData(String.valueOf(comboDependencies.getSelectionIndex()));
		
		modifyCondition.setType(typeDependency);
		modifyCondition.setName(textName.getText());		
		modifyCondition.setEvent(conditionEvent);
		modifyCondition.setUseCaseMap(activeMap);
		modifyCondition.setDependencyResponsibility(activeResponsibilityNode);		
		modifyCondition.setFamily(activeFamily);			
		
		String dependency = 
				       typeDependency + 
				"( "  + textName.getText() + //$NON-NLS-1$
				", "  + activeResponsibilityNode.getName() + //$NON-NLS-1$
				", "  + activeMap.getName() + //$NON-NLS-1$
				", "  + conditionEvent.getName();  //$NON-NLS-1$
				
	   if (activeFamily!=null){
		   dependency +=	", "  + activeFamily.getName(); //$NON-NLS-1$
	   }
	   dependency +=	" )."; //$NON-NLS-1$
	   modifyCondition.setValue(dependency);
	}
	
	/**
	 * Updates the family combo box when the Depencency is changed.
	 * The family combo box is active if Mapping depency is selected.
	 *
	 */
	private void updateFamilyButton() {
		String textSelected =  getActiveDependency();
		if (textSelected.equals(Condition.mappingCondition))
			comboFamilies.setEnabled(true);
		else {
			comboFamilies.setEnabled(false);
			comboFamilies.deselectAll();
		}
	}
		
	//Obtain a List of Responsibilities from a list of ResponsibilityNodes
	private List getResponsibilitiesList(Map responsibilyToResponsibilyNodeMap){
		List result = new ArrayList();		
		for (Iterator iter=responsibilyToResponsibilyNodeMap.keySet().iterator(); iter.hasNext();)
			result.add(iter.next());			
		return result;
	}

	//Obtain a Map of Responsibility to Responsibility Nodes of a UseCaseMap
	private Map<Responsibility,ResponsibilityNode> getResponsibilyToResponsibilyNodeMap(UseCaseMap useCaseMap){
		Map<Responsibility,ResponsibilityNode> map = new HashMap<Responsibility,ResponsibilityNode>();
		for (int i=0; i < useCaseMap.getPaths().size(); i++){
			Path path = (Path) useCaseMap.getPaths().get(i);
			for (int j=0; j < path.getNodes().size(); j++){
				if((path.getNodes().get(j) instanceof ResponsibilityNode)) {
					ResponsibilityNode node = (ResponsibilityNode) path.getNodes().get(j);
					map.put(node.getResponsibility(), node);
				}
			}
		}
		return map;
	}
	
	private void updateMapsResponsibilityNodes(UseCaseMap map) {
		if (map != null) {
			Map nodes = maps.get(map);
			if (nodes == null)
				maps.put(map, getResponsibilyToResponsibilyNodeMap(map));
		}
	}
	
	
	/**
	 * Returns the selected ConditionEvent according to its combo box, otherwise return null
	 * 
	 * @return the selected ConditionEvent according to the combo box, otherwise null
	 */
	private String getActiveDependency() {
		if (comboDependencies == null)
			return null;
		
		return (String)comboDependencies.getData(String.valueOf(comboDependencies.getSelectionIndex()));
	}
	
	/**
	 * Returns the selected ConditionEvent according to its combo box, otherwise return null
	 * 
	 * @return the selected ConditionEvent according to the combo box, otherwise null
	 */
	private ConditionEvent getActiveConditionEvent() {
		if (comboConditionEvents == null)
			return null;
		
		return (ConditionEvent)comboConditionEvents.getData(String.valueOf(comboConditionEvents.getSelectionIndex()));
	}
	
	/**
	 * Returns the selected Family according to its combo box, otherwise return null
	 * 
	 * @return the selected Family according to the combo box, otherwise null
	 */
	private Family getActiveFamily() {
		if (comboFamilies == null)
			return null;
		
		return (Family)comboFamilies.getData(String.valueOf(comboFamilies.getSelectionIndex()));
	}
	
	/**
	 * Returns the selected UseCaseMap according to its combo box, otherwise return null
	 * 
	 * @return the selected UseCaseMap according to the combo box, otherwise null
	 */
	private UseCaseMap getActiveMap() {
		if (comboMap == null)
			return null;
		
		return (UseCaseMap)comboMap.getData(String.valueOf(comboMap.getSelectionIndex()));
	}
	
	/**
	 * Returns the selected Responsibility according to its combo box, otherwise return null
	 * 
	 * @return the selected Responsibility according to the combo box, otherwise null
	 */
	private Responsibility getActiveResponsibility() {
		if (comboResponsibilities == null)
			return null;
		
		return (Responsibility)comboResponsibilities.getData(String.valueOf(comboResponsibilities.getSelectionIndex()));
	}
	
	private String isValidEnd() {
		String valuesIncomplete = ""; //$NON-NLS-1$
		if (textName.getText().length() <= 0){
			valuesIncomplete += "\n - ";
			valuesIncomplete += Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditDependencyDialog.errorName"); //$NON-NLS-1$
		}
		if (getActiveMap() == null){
			valuesIncomplete += "\n - ";
			valuesIncomplete += Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditDependencyDialog.errorUCM"); //$NON-NLS-1$
		}
		
		if (getActiveResponsibility() == null){
			valuesIncomplete += "\n - ";
			valuesIncomplete += Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditDependencyDialog.errorResponsibility"); //$NON-NLS-1$
		}
		
		if (getActiveDependency() == null) {
			valuesIncomplete += "\n - ";
			valuesIncomplete += Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditDependencyDialog.errorDependency"); //$NON-NLS-1$
		}
		
		if (getActiveDependency() != null && getActiveDependency().equals(Condition.mappingCondition) && getActiveFamily() == null){
			valuesIncomplete += "\n - ";
			valuesIncomplete += Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditDependencyDialog.errorFamily"); //$NON-NLS-1$
		}
		
		if (getActiveConditionEvent() == null){
			valuesIncomplete += "\n - ";
			valuesIncomplete += Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditDependencyDialog.errorEvent"); //$NON-NLS-1$
		}
		
		return valuesIncomplete;
	}
	
	public Command getCommand() {
		if (exitValue == SWT.OK)
			return new ModifyConditionCommand(originalCondition, modifyCondition);
		
		return null;
	}
	
	public static class DependencyToNameFactory {
		private static final Map<String, String> shownNames = new HashMap<String, String>();
		
		static {
			shownNames.put(Condition.previous, Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditDependencyDialog.previousCondition")); //$NON-NLS-1$
			shownNames.put(Condition.mappingCondition, Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditDependencyDialog.mappingCondition")); //$NON-NLS-1$
			shownNames.put(Condition.constraintCondition, Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditDependencyDialog.constraintCondition")); //$NON-NLS-1$
			shownNames.put(Condition.preconditionCondition, Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditDependencyDialog.preconditionCondition")); //$NON-NLS-1$
		}
		
		public static String getName(String condition) {
			String name = shownNames.get(condition);
			if (name == null)
				return ""; //$NON-NLS-1$
			
			return name;
		}
	}
}