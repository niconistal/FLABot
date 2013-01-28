/**
 * $Id: TagFilterDialog.java,v 1.10 2006/05/03 02:44:37 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.correlation.dialog.swt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.isistan.flabot.engine.executionstate.correlation.dialog.TagFilterDialogManager;
import org.isistan.flabot.engine.executionstate.correlation.dialog.swt.TagTreeModel.TagWrapper;
import org.isistan.flabot.engine.executionstate.correlation.dialog.swt.TagTreeModel.Wrapper;
import org.isistan.flabot.engine.executionstate.correlation.dialog.swt.TagTreeViewSorter.InstanceComparator;
import org.isistan.flabot.engine.executionstate.correlation.dialog.swt.TagTreeViewSorter.TagComparator;
import org.isistan.flabot.engine.messages.Messages;
import org.isistan.flabot.trace.log.Tag;

/**
 * Implementation of TagFilterDialogManager that shows a SWT dialog
 * 
 * @author $Author: franco $
 *
 */
public class TagFilterDialog implements TagFilterDialogManager {

	class SWTTagFilterDialog extends ApplicationWindow {
						
		private IStructuredSelection selection = new StructuredSelection();
		
		private String dialogName;
		
		private List<Tag> selectedTags;
		
		private List<Tag> tags;
		
		private TreeViewer treeViewer;
		
		public SWTTagFilterDialog() {
			super(null);
		}

		/**
		 * Runs the application
		 */
		public List<Tag> run(String dialogName, List<Tag> tags, List<Tag> selectedTags, boolean modal) {
			this.dialogName = dialogName;
			this.selectedTags = selectedTags;
			this.tags = tags;

			// Don't return from open() until window closes
			setBlockOnOpen(true);
			int additionalProperties = SWT.NONE;
			if (modal)
				additionalProperties |= SWT.APPLICATION_MODAL;
			setShellStyle(getShellStyle() + additionalProperties);
			
			// Open the main window
			open();
			
			return getTagList();
		}	

		private List<Tag> getTagList() {
			List<Tag> ret = new ArrayList<Tag>();
			for(Iterator iter=selection.iterator(); iter.hasNext();) {
				TagWrapper tw = (TagWrapper) iter.next();
				ret.add(tw.getTag());
			}
			return ret;
		}
		
		/**
		 * Configures the shell
		 * 
		 * @param shell the shell
		 */
		protected void configureShell(Shell shell) {
			super.configureShell(shell);
			shell.setText(dialogName);
			shell.setMinimumSize(400, 400);
		}
		  
		
		private TreeViewer createTreeViewer(Composite parent) {
			// Create the table viewer to display the tags	   		  
			final TreeViewer treeViewer = new TreeViewer(parent);
			treeViewer.addSelectionChangedListener( new ISelectionChangedListener() {
				
				public void selectionChanged(SelectionChangedEvent event) {
					// if the selection is empty clear the label
					if(event.getSelection().isEmpty()) {
						selection = StructuredSelection.EMPTY;
						return;
					}
					
					if(event.getSelection() instanceof IStructuredSelection) {
						IStructuredSelection selectedTags = (IStructuredSelection)event.getSelection();
						
						List<Wrapper> selectedRightList = new ArrayList<Wrapper>();
						for (Iterator iterator = selectedTags.iterator(); iterator.hasNext();) {
							Wrapper wrapper = (Wrapper)iterator.next();
							//if a children is selected, it must be removed from the selection list
							if (wrapper.getParent() == null)
								selectedRightList.add(wrapper);
				       	}
						
						//if the size changed (some children was selected), the selection must be updated
						if (selectedTags.size() > selectedRightList.size()) {
							selection = new StructuredSelection(selectedRightList);
							((TreeViewer)event.getSource()).setSelection(selection, true);
						} else
							selection = selectedTags;
				   	}
				}
				
			});
			treeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
			treeViewer.setSorter(new TagTreeViewSorter());

			// Set up the table
		    Tree tree = treeViewer.getTree();
		    final TreeColumn tc0 = new TreeColumn(tree, SWT.LEFT);
		    tc0.setText(Messages.getString("org.isistan.flabot.engine.executionstate.correlation.dialog.swt.TagFilterDialog.tagColumn")); //$NON-NLS-1$
		    
		    final TagComparator tagComparator = new TagComparator();
		    tagComparator.setColumn(tc0);
		    tc0.addListener(SWT.Selection, new Listener() {
				   public void handleEvent(Event e) {
					   TagTreeViewSorter sorter = (TagTreeViewSorter) treeViewer.getSorter();
					   tagComparator.reverseOrder();
					   sorter.setComparator(tagComparator);
					   treeViewer.refresh();
				   }
		    });
		    
		    
		    new TreeColumn(tree, SWT.CENTER).setText(Messages.getString("org.isistan.flabot.engine.executionstate.correlation.dialog.swt.TagFilterDialog.timestampColumn")); //$NON-NLS-1$
			new TreeColumn(tree, SWT.LEFT).setText(Messages.getString("org.isistan.flabot.engine.executionstate.correlation.dialog.swt.TagFilterDialog.methodColumn")); //$NON-NLS-1$
			
			final TreeColumn tc3 = new TreeColumn(tree, SWT.LEFT);
		    final InstanceComparator instanceComparator = new InstanceComparator();
		    instanceComparator.setColumn(tc3);
			tc3.setText(Messages.getString("org.isistan.flabot.engine.executionstate.correlation.dialog.swt.TagFilterDialog.instanceColumn")); //$NON-NLS-1$
			tc3.addListener(SWT.Selection, new Listener() {
				   public void handleEvent(Event e) {
					   TagTreeViewSorter sorter = (TagTreeViewSorter) treeViewer.getSorter();
					   instanceComparator.reverseOrder();
					   sorter.setComparator(instanceComparator);
					   treeViewer.refresh();
				   }
		    });
		    new TreeColumn(tree, SWT.CENTER).setText(Messages.getString("org.isistan.flabot.engine.executionstate.correlation.dialog.swt.TagFilterDialog.threadColumn")); //$NON-NLS-1$
		    
		    treeViewer.setContentProvider(new TagFilterContentProvider());
		    treeViewer.setLabelProvider(new TagFilterLabelProvider());
		    
		    if (tags == null)
		    	tags = Collections.<Tag>emptyList();		    
		    treeViewer.setInput(new TagTreeModel(tags));

		    // Pack the columns
		    tree.getColumn(0).setWidth(150);
		    for (int i = 1, n = tree.getColumnCount(); i < n; i++) {
		    	tree.getColumn(i).pack();
		    }

		    // Turn on the header and the lines
		    tree.setHeaderVisible(true);
		    tree.setLinesVisible(true);

		    // Pack the window
		    parent.pack();
		    		    
			setSelected(treeViewer, selectedTags);
		    
		    return treeViewer;
		}
		
		private void setSelected(TreeViewer treeViewer, List<Tag> selectedTags) {
			List<Wrapper> selectedRightList = new ArrayList<Wrapper>();
			TreeItem[] items = treeViewer.getTree().getItems();
			for(TreeItem item : items) {
				if(item.getParentItem() == null) {
					TagWrapper tagWrapper = (TagWrapper) item.getData();
					if (selectedTags.contains(tagWrapper.getTag()))
						selectedRightList.add(tagWrapper);
				}
			}
			treeViewer.setSelection(new StructuredSelection(selectedRightList));
		}
		
		private Composite createFinalButtons(Composite parent) {
			Composite buttonsComposite = new Composite(parent, SWT.NONE);
			buttonsComposite.setLayout(new RowLayout());
			buttonsComposite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
			
			Button buttonOK= new Button(buttonsComposite, SWT.NONE);
			buttonOK.setText(Messages.getString("org.isistan.flabot.edit.editor.okButton")); //$NON-NLS-1$
			buttonOK.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					close();
				}
			});
			buttonOK.setFocus();
			
			Button selectAllButton= new Button(buttonsComposite, SWT.NONE);
			selectAllButton.setText(Messages.getString("org.isistan.flabot.engine.executionstate.correlation.dialog.swt.TagFilterDialog.selectAllButton")); //$NON-NLS-1$
			selectAllButton.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {				
					List<Wrapper> selectedRightList = new ArrayList<Wrapper>();
					TreeItem[] items = treeViewer.getTree().getItems();
					for(TreeItem item : items) {
						if(item.getParentItem() == null)
							selectedRightList.add((TagWrapper) item.getData());
					}
					treeViewer.setSelection(new StructuredSelection(selectedRightList));			
				}
			});

			Button buttonClearSelection= new Button(buttonsComposite, SWT.NONE);
			buttonClearSelection.setText(Messages.getString("org.isistan.flabot.engine.executionstate.correlation.dialog.swt.TagFilterDialog.clearSelectionButton")); //$NON-NLS-1$
			buttonClearSelection.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					treeViewer.setSelection(StructuredSelection.EMPTY);
					
				}
			});
						
			return buttonsComposite;
		}
		
		/**
		 * Creates the main window's contents
		 * 
		 * @param parent the main window
		 * @return Control
		 */
		protected Control createContents(Composite parent) {			
			Composite composite = new Composite(parent, SWT.NONE);
			
			GridLayout layout = new GridLayout(1, false);
			layout.verticalSpacing = 12;
			layout.horizontalSpacing = 12;
			composite.setLayout(layout);		
			composite.setLayoutData(new GridData(GridData.FILL_BOTH));				
			
			// Create the table viewer to display the tags	   		  
			treeViewer = createTreeViewer(composite);			
			createFinalButtons(composite);
					
			return composite;
		}	
		
	}
	
	public List<Tag> filterTags(String dialogName, List<Tag> tags, List<Tag> selectedTag, boolean modal) {			  
		SWTTagFilterDialog ttd =  new SWTTagFilterDialog();
		return ttd.run(dialogName, tags, selectedTag, modal);
	}

}