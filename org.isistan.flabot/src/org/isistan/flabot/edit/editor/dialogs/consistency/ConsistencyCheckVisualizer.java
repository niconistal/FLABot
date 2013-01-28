package org.isistan.flabot.edit.editor.dialogs.consistency;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.ApplicationWindow;
//import org.eclipse.pde.internal.runtime.logview.LogEntry;
//import org.eclipse.pde.internal.runtime.logview.LogView;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.XMLMemento;
import org.eclipse.ui.internal.views.log.LogEntry;
import org.eclipse.ui.internal.views.log.LogView;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.isistan.flabot.messages.Messages;

public class ConsistencyCheckVisualizer extends ApplicationWindow implements ILogListener {
	
	private int MESSAGE_ORDER = -1;
	private int PLUGIN_ORDER = -1;
	private int DATE_ORDER = -1;
	
	private TreeViewer fTreeViewer;
	
	private ConsistencyDetailsDialog propertyDialog;
	
	private List<LogEntry> fLogs = new ArrayList<LogEntry>();
	
	private Comparator comparator;
	
	private Comparator collator;
	
	private Button buttonOK;
	
	public ConsistencyCheckVisualizer(Shell parent) {
		super(parent);
	}

	/**
	 * Runs the application
	 */
	public void run() {

		// Don't return from open() until window closes
		setBlockOnOpen(true);
		setShellStyle(getShellStyle() + SWT.APPLICATION_MODAL);
		
		// Open the main window
		open();
	}	

	/**
	 * Configures the shell
	 * 
	 * @param shell the shell
	 */
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(Messages.getString("org.isistan.flabot.edit.editor.dialogs.consistency.ConsistencyCheckVisualizer.dialogTitle")); //$NON-NLS-1$
		shell.setMinimumSize(755, 400);
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
		Group dependencyGroup = new Group(composite, SWT.NONE);
		dependencyGroup.setText(Messages.getString("org.isistan.flabot.edit.editor.dialogs.consistency.ConsistencyCheckVisualizer.problemsGroup")); //$NON-NLS-1$
		
		layout = new GridLayout(2, false);
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		dependencyGroup.setLayout(layout);
		
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.widthHint = 100;
		gd.heightHint = 200;
		dependencyGroup.setLayoutData(gd);						
		
		createViewer(dependencyGroup);
		
		// buttons composite (ok and cancel)	
		Composite buttonsComposite = new Composite(composite, SWT.NONE);
		buttonsComposite.setLayout(new RowLayout());
		buttonsComposite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
		
		buttonOK = new Button(buttonsComposite, SWT.NONE);
		buttonOK.setText(Messages.getString("org.isistan.flabot.edit.editor.okButton")); //$NON-NLS-1$
		buttonOK.setEnabled(false);
		buttonOK.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				setReturnCode(SWT.OK);
				close();
			}
		});
		
		Button buttonCancel = new Button(buttonsComposite, SWT.NONE);
		buttonCancel.setText(Messages.getString("org.isistan.flabot.edit.editor.cancelButton")); //$NON-NLS-1$
		buttonCancel.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleCancel();
			}
		});				
				
		return composite;
	}	
			
	private void createViewer(Composite parent) {
		fTreeViewer = new TreeViewer(parent);

		Tree fTree = fTreeViewer.getTree();
	        
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.widthHint = 100;
		fTree.setLayoutData(gd);
		createColumns(fTree);
		fTreeViewer.setContentProvider(new ConsistencyContentProvider(fLogs));
		IViewPart viewPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.eclipse.pde.runtime.LogView");
		fTreeViewer.setLabelProvider(new ConsistencyLabelProvider((LogView)viewPart));
		fTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent e) {
					StructuredSelection elements = (StructuredSelection) fTreeViewer.getSelection();
					IAdaptable element = (IAdaptable) elements.getFirstElement();
					if (element == null)
						return;
					if (propertyDialog != null && propertyDialog.isOpen())
						propertyDialog.resetSelection(element);
			}
		});
		fTreeViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				TreeItem[] treeItems = fTreeViewer.getTree().getSelection();				
				if (treeItems.length == 1) {
					XMLMemento memento = XMLMemento.createWriteRoot("workingSet"); //$NON-NLS-1$
					propertyDialog = new ConsistencyDetailsDialog(getShell(), (LogEntry)treeItems[0].getData(), fTreeViewer, comparator, memento);					
					propertyDialog.create();
					propertyDialog.getShell().setText(Messages.getString("org.isistan.flabot.edit.editor.dialogs.consistency.ConsistencyCheckVisualizer.detailsDialogTitle")); //$NON-NLS-1$
					propertyDialog.open();
				}
			}		
		});
		fTreeViewer.setInput(this);
	        
		//Pack the columns
		fTree.getColumn(0).setWidth(400);
		fTree.getColumn(1).setWidth(150);
		fTree.getColumn(2).setWidth(150);
	}

	private void createColumns(Tree tree) {
		TreeColumn fColumn1 = new TreeColumn(tree, SWT.LEFT);
		fColumn1.setText(Messages.getString("org.isistan.flabot.edit.editor.dialogs.consistency.ConsistencyCheckVisualizer.messageColumn")); //$NON-NLS-1$
		fColumn1.setWidth(100);
		fColumn1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				    MESSAGE_ORDER *= -1;
	                ViewerSorter sorter = getViewerSorter(LogView.MESSAGE);
	                fTreeViewer.setSorter(sorter);
	                collator = sorter.getCollator();
	                resetSelection(LogView.MESSAGE, MESSAGE_ORDER);
	                setComparator(LogView.MESSAGE);
	                if (propertyDialog != null && propertyDialog.isOpen())
	                	propertyDialog.setComparator(comparator);
			}
		});

		TreeColumn fColumn2 = new TreeColumn(tree, SWT.LEFT);
		fColumn2.setText(Messages.getString("org.isistan.flabot.edit.editor.dialogs.consistency.ConsistencyCheckVisualizer.pluginColumn")); //$NON-NLS-1$
		fColumn2.setWidth(50);
		fColumn2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
	                PLUGIN_ORDER *= -1;
	                ViewerSorter sorter = getViewerSorter(LogView.PLUGIN);
	                fTreeViewer.setSorter(sorter);
	                collator = sorter.getCollator();            
	                resetSelection(LogView.PLUGIN, PLUGIN_ORDER);
	                setComparator(LogView.PLUGIN);
	                if (propertyDialog != null && propertyDialog.isOpen())
	                	propertyDialog.setComparator(comparator);
			}
		});

		TreeColumn fColumn3 = new TreeColumn(tree, SWT.LEFT);
		fColumn3.setText(Messages.getString("org.isistan.flabot.edit.editor.dialogs.consistency.ConsistencyCheckVisualizer.dateColumn")); //$NON-NLS-1$
		fColumn3.setWidth(50);
		fColumn3.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
	                if (DATE_ORDER == LogView.ASCENDING) {
	                    DATE_ORDER = LogView.DESCENDING;
	                } else {
	                    DATE_ORDER = LogView.ASCENDING;
	                }
	                ViewerSorter sorter = getViewerSorter(LogView.DATE);
	                fTreeViewer.setSorter(sorter);
	                collator = sorter.getCollator();
	                resetSelection(LogView.DATE, DATE_ORDER);
	                setComparator(LogView.DATE);
	                if (propertyDialog != null && propertyDialog.isOpen())
	                	propertyDialog.setComparator(comparator);
			}
		});
	        
		tree.setHeaderVisible(true);
	}
		    
	public LogEntry[] getLogs() {
		return fLogs.toArray(new LogEntry[fLogs.size()]);
	}
	    	   
	public void logging(IStatus status, String plugin) {
		pushStatus(status);
	}
	    
	private void pushStatus(final IStatus status) {
		if (!fTreeViewer.getTree().isDisposed()) {
			LogEntry entry = new LogEntry(status);
			fLogs.add(entry);
			fTreeViewer.refresh();
		}
	}
	
	private StructuredSelection getStructuredSelection() {
		return (StructuredSelection)fTreeViewer.getSelection();
	}	
	
	public boolean resetSelection(byte sortType, int sortOrder){
		IAdaptable element = (IAdaptable) getStructuredSelection().getFirstElement();
		if (element == null)
			return false;
		if (propertyDialog != null && propertyDialog.isOpen()){
			propertyDialog.resetSelection(element, sortType, sortOrder);
			return true;
		}
		return false;
	}
	
	public void resetSelection(){
		IAdaptable element = (IAdaptable) getStructuredSelection().getFirstElement();
		if (element == null)
			return;
		if (propertyDialog != null && propertyDialog.isOpen())
			propertyDialog.resetSelection(element);
	}	
	
	private ViewerSorter getViewerSorter(byte sortType) {
		if (sortType == LogView.PLUGIN) {
			return new ViewerSorter() {
				public int compare(Viewer viewer, Object e1, Object e2) {
					LogEntry entry1 = (LogEntry) e1;
					LogEntry entry2 = (LogEntry) e2;
					return super.compare(viewer, entry1.getPluginId(), entry2
							.getPluginId())
							* PLUGIN_ORDER;
				}
			};
		} else if (sortType == LogView.MESSAGE) {
			return new ViewerSorter() {
				public int compare(Viewer viewer, Object e1, Object e2) {
					LogEntry entry1 = (LogEntry) e1;
					LogEntry entry2 = (LogEntry) e2;
					return super.compare(viewer, entry1.getMessage(), entry2.getMessage())
	                            * MESSAGE_ORDER;
				}
			};
		} else {
			return new ViewerSorter() {
				public int compare(Viewer viewer, Object e1, Object e2) {
					try {
						SimpleDateFormat formatter = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss.SSS"); //$NON-NLS-1$
						Date date1 = formatter.parse(((LogEntry) e1).getDate().toString());
						Date date2 = formatter.parse(((LogEntry) e2).getDate().toString());
						if (DATE_ORDER == LogView.ASCENDING)
							return date1.before(date2) ? -1 : 1;
						
						return date1.after(date2) ? -1 : 1;
					} catch (ParseException e) {}
					return 0;
				}
			};
		}
	}
	

	private void setComparator(byte sortType) {
		if (sortType == LogView.DATE) {
			comparator = new Comparator() {
				public int compare(Object e1, Object e2) {
					try {
						SimpleDateFormat formatter = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss.SSS"); //$NON-NLS-1$
						Date date1 = formatter.parse(((LogEntry) e1).getDate().toString());
						Date date2 = formatter.parse(((LogEntry) e2).getDate().toString());
						if (DATE_ORDER == LogView.ASCENDING)
							return date1.before(date2) ? -1 : 1;
						return date1.after(date2) ? -1 : 1;
					} catch (ParseException e) {}
					return 0;
				}
			};
		} else if (sortType == LogView.PLUGIN) {
			comparator = new Comparator() {
				public int compare(Object e1, Object e2) {
					LogEntry entry1 = (LogEntry) e1;
					LogEntry entry2 = (LogEntry) e2;
					return collator.compare(entry1.getPluginId(), entry2.getPluginId())
								* PLUGIN_ORDER;
				}
			};
		} else {
			comparator = new Comparator() {
				public int compare(Object e1, Object e2) {
					LogEntry entry1 = (LogEntry) e1;
					LogEntry entry2 = (LogEntry) e2;
					return collator.compare(entry1.getMessage(), entry2.getMessage())
								* MESSAGE_ORDER;
				}
			};
		}
	}
	
	private void handleCancel() {
		setReturnCode(SWT.CANCEL);
		close();
	}
	
	public void loggingFinished() {
		buttonOK.setEnabled(true);		
	}	
}