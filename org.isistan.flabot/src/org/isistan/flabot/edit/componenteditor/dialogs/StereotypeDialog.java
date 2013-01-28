/**
 * $Id: StereotypeDialog.java,v 1.18 2006/03/21 01:51:58 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.dialogs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
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
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.Stereotype;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.DefualtValidatorSorter;
import org.isistan.flabot.util.SorterToTable;

/**
 * This dialog is used to add/remove/modify stereotypes.
 * 
 * @author $Author: franco $
 *
 */
public class StereotypeDialog extends Dialog {
	/**
	 * the dialog's shell
	 */
	private Shell shell = null;  //  @jve:decl-index=0:visual-constraint="10,9"
	
	private List newStereotypes = new ArrayList();
	private List removeStereotypes = new ArrayList();
	private Map updatedStereotypes = new HashMap();
	
	int exitValue = SWT.CANCEL;

	private Button editBtn;
	private Button removeBtn;	
	
	private Image image;
	
	public StereotypeDialog(Shell parent) {
		super(parent, 0);
		
		ImageDescriptor descriptor=ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/stereotype.gif"); //$NON-NLS-1$
		image=descriptor.createImage();
	}

	/**
	 * This method initializes the dialog's shell with the existing stereotypes shown in a table and the button for adding/modifying/removing
	 */
	private void createShell(final List stereotypes) {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.StereotypeDialog.title")); //$NON-NLS-1$
		shell.setLayout(new GridLayout(1, true));
		
		Group stereoGroup = new Group(shell, SWT.NONE);
		stereoGroup.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.StereotypeDialog.group")); //$NON-NLS-1$
		stereoGroup.setLayout(new GridLayout(2, false));
		stereoGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		final Table stereotypesTable = new Table(stereoGroup, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);
		
		GridData gd = new GridData(GridData.FILL_BOTH | GridData.GRAB_VERTICAL|GridData.VERTICAL_ALIGN_BEGINNING);
		gd.verticalSpan = 3;
		gd.widthHint = 200;
		gd.heightHint = 150;
		stereotypesTable.setLayoutData(gd);
		stereotypesTable.setHeaderVisible(true);
		stereotypesTable.addListener( SWT.Selection, new Listener() {
	        public void handleEvent(Event event) {
	          TableItem[] items = stereotypesTable.getSelection();
        	  editBtn.setEnabled(items.length == 1);
        	  removeBtn.setEnabled(items.length >= 1);
	        }			
		});	
		
		final TableColumn tc1 = new TableColumn(stereotypesTable, SWT.LEFT);
		tc1.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.StereotypeDialog.stereotypeName"));		 //$NON-NLS-1$
		tc1.setWidth(215);
		final SorterToTable sorter = new SorterToTable(stereotypesTable, new DefualtValidatorSorter(false,1));
		tc1.addListener(SWT.Selection, new Listener() {
			   public void handleEvent(Event e) {
				   sorter.setColumn(tc1);
				   sorter.reverseDirection();
				   sorter.order();
			   }
			        });
		fillStereotypeTable(stereotypesTable, stereotypes);
		
		stereotypesTable.addListener( SWT.MouseDoubleClick, new Listener() {
	        public void handleEvent(Event event) {
	        	renameAction(stereotypesTable);
	        }			
		});	

		//Creates the Add Button
		final Button addBtn = new Button(stereoGroup, SWT.NONE);
		addBtn.setText(Messages.getString("org.isistan.flabot.edit.editor.addButton")); //$NON-NLS-1$
		addBtn.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
		addBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				RenameDialog r = new RenameDialog(shell);
	    		String newName = r.open( Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.StereotypeDialog.nameStereotypeName"), Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.StereotypeDialog.renameStereotypeName"), ""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				
				if (newName != null && !newName.equals("")) { //$NON-NLS-1$
					Stereotype stereo = CoremodelFactory.eINSTANCE.createStereotype();
					stereo.setName(newName);
					
					final TableItem item = new TableItem(stereotypesTable, SWT.NONE);
				    item.setText(newName);
				    item.setData(stereo);
				    item.setImage(image);
				    newStereotypes.add(stereo);
				}
		    }
		});
		    
		//Creates the Edit Button
		editBtn = new Button(stereoGroup, SWT.NONE);
		editBtn.setText(Messages.getString("org.isistan.flabot.edit.editor.editButton")); //$NON-NLS-1$
		editBtn.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
		editBtn.setEnabled(false);
		editBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				renameAction(stereotypesTable);
		    }
		});
		
		//Creates the Remove Button
		removeBtn = new Button(stereoGroup, SWT.NONE);
		removeBtn.setText(Messages.getString("org.isistan.flabot.edit.editor.removeButton")); //$NON-NLS-1$
		removeBtn.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
		removeBtn.setEnabled(false);
		removeBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				TableItem[] items = stereotypesTable.getSelection();
				if(items.length==0) {
					return;
				}

				for (TableItem item : items) {
					Stereotype stereo = (Stereotype) item.getData();
					if (newStereotypes.contains(stereo))
						newStereotypes.remove(stereo);
					else
						removeStereotypes.add(stereo);
					
					if (updatedStereotypes.containsKey(stereo))
						updatedStereotypes.remove(stereo);					
		         }
				
				stereotypesTable.remove(stereotypesTable.getSelectionIndices());
				
				editBtn.setEnabled(false);
				removeBtn.setEnabled(false);
		    }
		});
				
		// buttons composite (ok and cancel)	
		Composite buttonsComposite = new Composite(shell, SWT.NONE);
		buttonsComposite.setLayout(new RowLayout());
		buttonsComposite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
		
		Button buttonOK = new Button(buttonsComposite, SWT.NONE);
		buttonOK.setText(Messages.getString("org.isistan.flabot.edit.editor.okButton")); //$NON-NLS-1$
		buttonOK.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				exitValue = SWT.OK;
				shell.dispose();
			}
		});
		
		Button buttonCancel = new Button(buttonsComposite, SWT.NONE);
		buttonCancel.setText(Messages.getString("org.isistan.flabot.edit.editor.cancelButton")); //$NON-NLS-1$
		buttonCancel.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				exitValue = SWT.CANCEL;
				shell.dispose();
			}
		});
	}
	
	private void renameAction(Table stereotypesTable) {
		TableItem[] items = stereotypesTable.getSelection();
        if (items.length == 1) {        	  
      	  RenameDialog r = new RenameDialog(shell);
      	  String newName = r.open("", Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.StereotypeDialog.renameStereotype"), items[0].getText(0));					 //$NON-NLS-1$ //$NON-NLS-2$
      	  
      	  if (newName != null && !newName.equals(""))	  					 //$NON-NLS-1$
      		  	items[0].setText(newName);	        	  	        	  
      	  if (newName != null && !newName.equals("")) {				 //$NON-NLS-1$
      		  	items[0].setText(newName);
      		  	Stereotype stereotype = (Stereotype) items[0].getData();
      		  	if (newStereotypes.contains(stereotype)) {
      		  		stereotype.setName(newName);
      		  	}
      		  	else {
      		  		Stereotype newStereotype = (Stereotype) EcoreUtil.copy(stereotype);
      		  		newStereotype.setName(newName);
      		  		updatedStereotypes.put(stereotype, newStereotype);
      		  	}
      	  }
        }
	}
	
	/**
	 * Creates and opens the dialog, which will show the existing stereotypes and lets the user add/remove/modify them.
	 * 
	 * @param stereotypes the list of existing stereotypes
	 * @return the exit value (SWT.OK/SWT.CANCEL)
	 */
	public int open(List stereotypes) {
		createShell(stereotypes);
		 
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
	
	/**
	 * Fills the table with all the existing stereotypes from the given list 
	 * 
	 * @param table the table to fill
	 * @param stereotypes the list of existing stereotypes
	 */
	private void fillStereotypeTable(Table table, List stereotypes) {	
		for (Iterator iter = stereotypes.iterator(); iter.hasNext();) {
			Stereotype stereo = (Stereotype) iter.next(); 
			final TableItem item = new TableItem(table, SWT.NONE);
		    item.setText(new String[] { stereo.getName()});
		    item.setData(stereo);
		    item.setImage(image);
		}
	}
	
	/**
	 * Returns the list of added stereotypes
	 * 
	 * @return the list of added stereotypes
	 */
	public List getNewStereotypes() {
		return newStereotypes;
	}
	
	/**
	 * Returns the list of removed sterotypes
	 * 
	 * @return the list of removed sterotypes
	 */
	public List getRemoveStereotypes() {
		return removeStereotypes;
	}
	
	/**
	 * Returns the list od modified stereotypes
	 * 
	 * @return the list od modified stereotypes
	 */
	public Map getUpdatedStereotypes() {
		return updatedStereotypes ;
	}
}