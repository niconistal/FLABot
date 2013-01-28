/**
 * $Id: EditStubDialog.java,v 1.11 2006/04/10 21:02:33 apersson Exp $
 * $Author: apersson $
 */
package org.isistan.flabot.edit.ucmeditor.dialogs;

import java.util.Iterator;
import java.util.List;

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
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.messages.Messages;

/**
 * Dialog that's used to edit the stub properties
 * 
 * @author $Author: apersson $
 *
 */
public class EditStubDialog extends Dialog {

	/**
	 * the dialog's shell
	 */
	private Shell shell = null;  //  @jve:decl-index=0:visual-constraint="10,9"
	
	StubNode stub;
	
	private Text stubName = null;
	private Combo comboMaps = null;	
	private Combo comboStartNodes = null;
	private Combo comboEndNodes = null;
	private Combo comboFamilies = null;
	
	public EditStubDialog(Shell parent, StubNode stubNode) {
		super(parent, 0);
		this.stub = CoremodelFactory.eINSTANCE.createStubNode(stubNode);
	}
	
	/**
	 * Creates and opens a dialog for editing stub properties.
	 * 
	 * @param useCaseMaps the list of core model use case maps
	 * @param actualMap the actual use case map
	 * @return the modified stub
	 */
	public StubNode open(final List useCaseMaps, final UseCaseMap actualMap, final List families) {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditStubDialog.dialogTitle")); //$NON-NLS-1$
		shell.setLayout(new GridLayout(1, false));
		
		shell.addShellListener(new org.eclipse.swt.events.ShellAdapter() {				
			public void shellClosed(org.eclipse.swt.events.ShellEvent e) {
				handleCancel();
			}
		});	
		
		Group dependencyGroup = new Group(shell, SWT.NONE);
		dependencyGroup.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditStubDialog.stubPropertiesGroup")); //$NON-NLS-1$
		
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		dependencyGroup.setLayout(layout);
		
		dependencyGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
				
		createStubName(dependencyGroup);
		createUseCaseMaps(dependencyGroup, useCaseMaps, families, actualMap, stub.getReferencedMap());
		
		Group pathGroup = new Group(dependencyGroup, SWT.NONE);
		pathGroup.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditStubDialog.pathPropertiesGroup")); //$NON-NLS-1$
		pathGroup.setLayout(layout);
		
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;
		pathGroup.setLayoutData(gd);
		
		createStartNodes(pathGroup);
		createEndNodes(pathGroup);			
		updateStartNodes(stub.getStartPointReference());
		
		updateEndNodes(getActiveStartNode(), stub.getEndPointReference());
		
		Group familyGroup = new Group(dependencyGroup, SWT.NONE);
		familyGroup.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditStubDialog.familySelectionGroup")); //$NON-NLS-1$
		familyGroup.setLayout(layout);
		
		gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;
		familyGroup.setLayoutData(gd);
		
		createFamilyGroup(familyGroup);
		updateFamilies(getActiveMap(), stub.getFamily(), families);
		
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
				            Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditStubDialog.incompleteMessageTitle"), //$NON-NLS-1$
				            null,
				            Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditStubDialog.incompleteMessageDescription")+errorMessage+" ", //$NON-NLS-1$ //$NON-NLS-2$
				            MessageDialog.ERROR,
				            new String[]{Messages.getString("org.isistan.flabot.edit.editor.okButton")}, //$NON-NLS-1$           
				            0);
					dlg.open();
				} else {
					setStub();
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
		
		return stub;
	}
	
	private void handleCancel() {
		stub = null;
        shell.dispose();
	}
	
	/**
	 * Creates a text box for the stub name
	 * 
	 * @param parent the composite parent
	 */
	private void createStubName(Composite parent) {
		// Stub Name
		final Label label = new Label(parent, SWT.NONE);
		label.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditStubDialog.stubName"));  //$NON-NLS-1$
		
		stubName = new Text(parent, SWT.BORDER);
		stubName.setText(stub.getName());
		stubName.setLayoutData(new GridData(
					GridData.VERTICAL_ALIGN_BEGINNING |
					GridData.FILL_HORIZONTAL));
	}
	
	/***
	 * Creates a combo box for given list of use case maps, not including actualMap 
	 * 
	 * @param parent the composite parent
	 * @param maps the list of use case maps
	 * @param actualMap th actual map is not include in the combo box
	 */
	private void createUseCaseMaps(Composite parent, List maps, final List familes, UseCaseMap actualMap, UseCaseMap selectedMap) {
		//Use Case Maps
		final Label label = new Label(parent, SWT.NONE);
		label.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditStubDialog.stubMap")); //$NON-NLS-1$
			
		comboMaps = new Combo(parent, SWT.READ_ONLY);
		comboMaps.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));		

		comboMaps.addListener(SWT.Selection, new Listener() {
	    	public void handleEvent(Event event) {	    		
	    		updateStartNodes(getActiveStartNode());
	    		updateFamilies(getActiveMap(), getActiveFamily(), familes);
	    	}
		});
		
		
		int selected = 0;
		for(Iterator iter=maps.iterator(); iter.hasNext();) {
			UseCaseMap map = (UseCaseMap) iter.next();
			//the actual map is not added to the selection combo box
			//if the actual map has architectural level, the added map must be only architectural too
			//can add a stub from an architectural map to a functional map
			if(map == actualMap || actualMap.getLevelInfo().equals(UseCaseMap.architecturalLevel) && map.getLevelInfo().equals(UseCaseMap.functionalLevel))
				continue;
			
			if (selectedMap == map)
				selected = comboMaps.getItemCount();

			comboMaps.setData(String.valueOf(comboMaps.getItemCount()), map);
			comboMaps.add(map.getName());
		}
		
		if (comboMaps.getItemCount() > 0)
			comboMaps.select(selected);
	}	
	
	/**
	 * Updates the start nodes combo box with the starts nodes of the paths of the new selected use case map.
	 * Also sets the first start node found as the selected and disables the combo end nodes.
	 * 
	 * @param map the selected use case map
	 */
	private void updateStartNodes(SimplePathNode activeStartNode) {		
		comboStartNodes.removeAll();
		
		UseCaseMap activeMap = getActiveMap();				
		if (activeMap == null)	
			return;

		int selected = 0;		
		for(Iterator iterPaths=activeMap.getPaths().iterator(); iterPaths.hasNext();) {
			Path path = (Path) iterPaths.next();
			for (Iterator iterNodes=path.getStartNodes().iterator(); iterNodes.hasNext();) {
				SimplePathNode startNode = (SimplePathNode) iterNodes.next();
				if (activeStartNode == startNode)
					selected = comboStartNodes.getItemCount();
				
				comboStartNodes.setData(String.valueOf(comboStartNodes.getItemCount() ), startNode);
				comboStartNodes.add(startNode.getName());										
			}		
		}
		if (comboStartNodes.getItemCount() > 0) {
			comboStartNodes.setEnabled(true);
			comboEndNodes.setEnabled(true);
			comboStartNodes.select(selected);
			updateEndNodes(getActiveStartNode(), getActiveEndNode());
		} else {
			comboEndNodes.setEnabled(false);
			comboStartNodes.setEnabled(false);
		}
	}
	
	/**
	 * Updates the end nodes combo box with the end nodes of the new start node path.
	 * Also sets the first end node found as the selected.
	 * 
	 * @param map the selected use case map
	 */
	private void updateEndNodes(SimplePathNode selectedStartNode, SimplePathNode selectedEndNode) {
		comboEndNodes.removeAll();
		
		if (selectedStartNode == null)
			return;
			
		int selected = 0;
		for (Iterator iterNodes=selectedStartNode.getPath().getEndNodes().iterator(); iterNodes.hasNext();) {
			SimplePathNode endNode = (SimplePathNode) iterNodes.next();
			if (selectedEndNode == endNode)
				selected = comboEndNodes.getItemCount();
			
			comboEndNodes.setData(String.valueOf(comboEndNodes.getItemCount()), endNode);
			comboEndNodes.add(endNode.getName());		
		}
		if (comboEndNodes.getItemCount() > 0) {
			comboEndNodes.setEnabled(true);
			comboEndNodes.select(selected);
		} else
			comboEndNodes.setEnabled(false);
	}

	/***
	 * Creates a combo box for start nodes of all the paths of the selected use case map 
	 * 
	 * @param parent the composite parent
	 */
	private void createStartNodes(Composite parent) {
		//Start Nodes
		final Label label = new Label(parent, SWT.NONE);
		label.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditStubDialog.stubStartNode")); //$NON-NLS-1$
			
		comboStartNodes = new Combo(parent, SWT.READ_ONLY);
		comboStartNodes.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
		
		comboStartNodes.addListener(SWT.Selection, new Listener() {
	    	public void handleEvent(Event event) {
	    		updateEndNodes(getActiveStartNode(), getActiveEndNode());
	    	}
		});
	}

	/***
	 * Creates a combo box for end nodes of the selected start node 
	 * 
	 * @param parent the composite parent
	 */	
	private void createEndNodes(Composite parent) {
		//End Nodes
		final Label label = new Label(parent, SWT.NONE);
		label.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditStubDialog.stubEndNode")); //$NON-NLS-1$
			
		comboEndNodes = new Combo(parent, SWT.READ_ONLY);
		comboEndNodes.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));		
	}
	
	/***
	 * Creates a combo box for end nodes of the selected start node 
	 * 
	 * @param parent the composite parent
	 */	
	private void createFamilyGroup(Composite parent) {
		//Families
		final Label label = new Label(parent, SWT.NONE);
		label.setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditStubDialog.stubFamily")); //$NON-NLS-1$
			
		comboFamilies = new Combo(parent, SWT.READ_ONLY);
		comboFamilies.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));		
	}
	
	private void updateFamilies(UseCaseMap selectedMap, Family selectedFamily, List families) {		
		comboFamilies.removeAll();
		comboFamilies.setEnabled(false);
		
		if (selectedMap == null)
			return;
					
		if (selectedMap.getLevelInfo().equals(UseCaseMap.architecturalLevel)) {						
			comboFamilies.setEnabled(true);
			
			int selected = 0;
			for (Iterator iterNodes=families.iterator(); iterNodes.hasNext();) {
				Family family = (Family) iterNodes.next();
				//if (family.getFunctionalUseCaseMaps().contains(selectedMap)) {
				if (family.getArchitecturalUseCaseMaps().contains(selectedMap)) {
					if (selectedFamily == family)
						selected = comboFamilies.getItemCount();
					
					comboFamilies.setData(String.valueOf(comboFamilies.getItemCount()), family);
					comboFamilies.add(family.getName());					
				}
			}
			
			if (comboFamilies.getItemCount() > 0) {
				comboFamilies.setEnabled(true);
				comboFamilies.select(selected);
			} else
				comboFamilies.setEnabled(false);
		}
	}
	
	/**
	 * Sets the values for the copied stub.
	 *
	 */
	private void setStub(){		
		stub.setName(stubName.getText());
		stub.setReferencedMap(getActiveMap());
		stub.setStartPointReference(getActiveStartNode());
		stub.setEndPointReference(getActiveEndNode());
		stub.setFamily(getActiveFamily());
	}
	
	
	private UseCaseMap getActiveMap() {
		if (comboMaps == null)
			return null;
		
		return (UseCaseMap)comboMaps.getData(String.valueOf(comboMaps.getSelectionIndex()));
	}
	
	private SimplePathNode getActiveStartNode() {
		if (comboStartNodes == null)
			return null;
		
		return (SimplePathNode)comboStartNodes.getData(String.valueOf(comboStartNodes.getSelectionIndex()));
	}
	
	private SimplePathNode getActiveEndNode() {
		if (comboEndNodes == null)
			return null;
		
		return (SimplePathNode)comboEndNodes.getData(String.valueOf(comboEndNodes.getSelectionIndex()));
	}
	
	private Family getActiveFamily() {
		if (comboFamilies == null)
			return null;
		
		return (Family)comboFamilies.getData(String.valueOf(comboFamilies.getSelectionIndex()));
	}
	
	
	/**
	 * Verifies that all the data needed for this stub is completed.
	 * @return a strig with error messages, otherwise an empty string
	 */
	private String isValidEnd() {
		String valuesIncomplete = ""; //$NON-NLS-1$
		if (stubName.getText().equals("")){ //$NON-NLS-1$
			valuesIncomplete += "\n - ";
			valuesIncomplete += Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditStubDialog.errorStubName"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		
		UseCaseMap activeMap = getActiveMap(); 
		if (getActiveMap() == null){
			valuesIncomplete += "\n - ";
			valuesIncomplete += Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditStubDialog.errorUCM"); //$NON-NLS-1$ //$NON-NLS-2$
		} else {
			if (activeMap.getLevelInfo().equals(UseCaseMap.architecturalLevel)) {
				if (getActiveFamily() == null){
					valuesIncomplete += "\n - ";
					valuesIncomplete += Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditStubDialog.errorFamily"); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		}
		
		if (getActiveStartNode() == null){
			valuesIncomplete += "\n - ";
			valuesIncomplete += Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditStubDialog.errorStartNode"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		
		if (getActiveEndNode() == null){
			valuesIncomplete += "\n - ";
			valuesIncomplete += Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditStubDialog.errorEndNode"); //$NON-NLS-1$ //$NON-NLS-2$
		}
				
		return valuesIncomplete;
	}
}