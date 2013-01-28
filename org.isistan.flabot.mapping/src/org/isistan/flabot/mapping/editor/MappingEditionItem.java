/**
 * $Id: MappingEditionItem.java,v 1.8 2006/03/29 00:37:09 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.mapping.editor;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.TreeItem;
import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JObject;
import org.isistan.flabot.javamodel.JPackage;
import org.isistan.flabot.javamodel.jdt.JavaModelJDTUtil;
import org.isistan.flabot.javamodel.jdt.workspace.JJavaFile;
import org.isistan.flabot.mapping.MappingType;
import org.isistan.flabot.mapping.builder.MappingBuilder;
import org.isistan.flabot.mapping.editor.WorkspaceViewerContentProvider.ContentFilter;
import org.isistan.flabot.mapping.mappingmodel.Mapping;
import org.isistan.flabot.mapping.messages.Messages;
import org.isistan.flabot.util.edition.EditionItemStatus;
import org.isistan.flabot.util.edition.tab.EditionTabItemImpl;
import org.isistan.flabot.util.problems.MessageAccumulator;
import org.isistan.flabot.util.problems.log.LoggerMessageAccumulator;

/**
 * @author $Author: dacostae $
 *
 */
public abstract class MappingEditionItem<T> extends EditionTabItemImpl<T> {
	
	private T element;
	
	private Mapping originalMapping;
	
	private boolean mappingChanged = false;
	
	private WorkspaceViewer workspaceViewer = null;
	private TreeViewer userSelectionViewer = null;
	private WorkspaceViewer filteredWorkspaceViewer = null;
	private WorkspaceViewer scopeViewer = null;
	private Button addButton;
	private Composite control;
	private TabFolder choosingFolder;
	private List<JObject> elements = new LinkedList<JObject>();
	private TabItem filteredTabItem;
	private MappingType type;

	private MappingBuilder mappingBuilder;
	
	private Button removeButton;
	
	private ClientViewerContentProvider clientContentProvider=new ClientViewerContentProvider(false, true);

	private TabItem scopeTabItem;

	private TabItem workspaceTabItem;

	private String text;

	private String commandName;

	private String scopeTabText;

	private boolean showWorkspace;

	private boolean showScopeInheritants;

	private RowData rd;
	private Composite mappingComposite;
	public MappingEditionItem(String text, String scopeTabText,
			String commandName, MappingType type,
			MappingBuilder mappingBuilder, boolean showWorkspace, boolean showScopeInheritants) {
		this.type=type;
		this.text=text;
		this.commandName=commandName;
		this.mappingBuilder=mappingBuilder;
		this.scopeTabText=scopeTabText;
		this.showWorkspace=showWorkspace;
		this.showScopeInheritants=showScopeInheritants;
	}
	
	protected abstract ContentFilter getContentFilter(T element);
	protected abstract Mapping[] getScopeMappings(T element);
	
	
	public void initialize(TabFolder tabFolder, TabItem tabItem,
			T element) {
		this.element=element;
		tabItem.setText(text);
		control = new Composite(tabFolder, SWT.NONE);
		control.setLayout(new RowLayout(SWT.VERTICAL));
		mappingComposite = new Composite(control, SWT.NONE);
		mappingComposite.setLayout(new RowLayout(SWT.HORIZONTAL));
		mappingComposite.setVisible(false);
		
		choosingFolder=new TabFolder(mappingComposite, SWT.NONE);
		
		rd = new RowData();
		rd.width = 300;
		rd.height = 300;
		
		choosingFolder.setLayoutData(rd);
		choosingFolder.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				updateAddButton();
			}
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		Composite addRemoveButtonsComposite = new Composite(mappingComposite, SWT.NONE);
		RowLayout layout = new RowLayout(SWT.VERTICAL);
		layout.fill = true;
		addRemoveButtonsComposite.setLayout(layout);
		
		addButton = new Button(addRemoveButtonsComposite, SWT.NONE);
		addButton.setText("Add >>");
		addButton.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleAdd();
			}	
		});
		addButton.setEnabled(false);
		
		removeButton = new Button(addRemoveButtonsComposite, SWT.NONE);
		removeButton.setText("<< Remove");
		removeButton.setEnabled(false);
		removeButton.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleRemove();

			}

		});
		
		userSelectionViewer = new TreeViewer(mappingComposite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		userSelectionViewer.getTree().setLayoutData(rd);
	}

	public void activate() {
		BusyIndicator.showWhile(control.getDisplay(), new Runnable() {
			public void run() {
				doActivate();
			}
		});
	}
	
	public void doActivate() {
		originalMapping=obtainMapping(element);
		
		ISelectionChangedListener addListener=new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				updateAddButton();
			}			
		};
		
		Mapping[] scopeMappings = getScopeMappings(element);
		if(scopeMappings!=null) {
			scopeTabItem = new TabItem(choosingFolder, SWT.NONE);
			scopeTabItem.setText(scopeTabText);
			scopeViewer=new WorkspaceViewer(choosingFolder,
					new WorkspaceViewerContentProvider(true,
							showScopeInheritants, false, false,
							type.isClasses() || type.isBehaviors(), type.isBehaviors(), 
							null),
					true);
			scopeViewer.setInput(getMatchingElements(scopeMappings));
			scopeViewer.getTree().setToolTipText(Messages.getString("org.isistan.flabot.mapping.editor.EditMappingToCodeDialog.workspaceElementsToolTipText")); //$NON-NLS-1$
			scopeViewer.getControl().setLayoutData(rd);
			scopeTabItem.setControl(scopeViewer.getControl());	
			scopeViewer.addSelectionChangedListener(addListener);
		}
		if(showWorkspace) {
			workspaceTabItem = new TabItem(choosingFolder, SWT.NONE);
			workspaceTabItem.setText("Workspace");
			workspaceViewer = new WorkspaceViewer(choosingFolder,
					new WorkspaceViewerContentProvider(true,
							false, true, true,
							type.isClasses() || type.isBehaviors(), type.isBehaviors(), 
							null),
					false);
			workspaceViewer.getTree().setToolTipText(Messages.getString("org.isistan.flabot.mapping.editor.EditMappingToCodeDialog.workspaceElementsToolTipText")); //$NON-NLS-1$
			workspaceViewer.getControl().setLayoutData(rd);
			workspaceViewer.setDefaultContentInput();
			workspaceTabItem.setControl(workspaceViewer.getControl());
			workspaceViewer.addSelectionChangedListener(addListener);
		}
		ContentFilter filter=getContentFilter(element);
		if(filter!=null) {
			filteredTabItem = new TabItem(choosingFolder, SWT.NONE);
			filteredTabItem.setText("Filtered");
			filteredWorkspaceViewer=new WorkspaceViewer(choosingFolder,
					new WorkspaceViewerContentProvider(true,
							false, true, true,
							type.isClasses() || type.isBehaviors(), type.isBehaviors(), 
							filter),
					false);
			filteredWorkspaceViewer.getTree().setToolTipText(Messages.getString("org.isistan.flabot.mapping.editor.EditMappingToCodeDialog.workspaceElementsToolTipText")); //$NON-NLS-1$
			filteredWorkspaceViewer.getControl().setLayoutData(rd);
			filteredWorkspaceViewer.setDefaultContentInput();
			filteredTabItem.setControl(filteredWorkspaceViewer.getControl());	
			filteredWorkspaceViewer.addSelectionChangedListener(addListener);
		}

		userSelectionViewer.setContentProvider(clientContentProvider);
		userSelectionViewer.setLabelProvider( new ClientViewerLabelProvider(JavaElementLabelProvider.SHOW_PARAMETERS | JavaElementLabelProvider.SHOW_OVERLAY_ICONS | JavaElementLabelProvider.SHOW_RETURN_TYPE | JavaElementLabelProvider.SHOW_QUALIFIED));
		userSelectionViewer.getTree().addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent event) {
				removeButton.setEnabled(
						userSelectionViewer.getTree().getSelectionCount()>0);
			}
		});

		appendToSelectionList(getMatchingElements(originalMapping));
		mappingComposite.setVisible(true);
	}
	
	private void updateAddButton() {
		ISelection selection;
		if(choosingFolder.getSelection()[0]==workspaceTabItem) {
			selection=workspaceViewer.getSelection();
		} else if(choosingFolder.getSelection()[0]==filteredTabItem) {
			selection=filteredWorkspaceViewer.getSelection();
		} else if(choosingFolder.getSelection()[0]==scopeTabItem) {
			selection=scopeViewer.getSelection();
		} else {
			addButton.setEnabled(false);
			return;
		}
		if (selection.isEmpty())
			addButton.setEnabled(false);
		else
			addButton.setEnabled(true);
		
	}

	private void handleAdd() {
		WorkspaceViewer viewer;
		if(choosingFolder.getSelection()[0]==workspaceTabItem) {
			viewer=workspaceViewer;
		} else if(choosingFolder.getSelection()[0]==filteredTabItem) {
			viewer=filteredWorkspaceViewer;
		} else if(choosingFolder.getSelection()[0]==scopeTabItem) {
			viewer=scopeViewer;
		} else {
			return;
		}
		
		appendToSelectionList(viewer.getSelectedElements(new WorkspaceViewer.SelectionFilter() {
			public boolean isSelectable(Object primaryElement, Object element) {
				if(type.isBehaviors() && element instanceof JBehavior) {
					return true;
				} else if(type.isClasses() && element instanceof JClass) {
					return true;
				} else if(type.isPackages() && element instanceof JPackage) {
					return true;
				} else {
					return false;
				}
			}

			public boolean propagatesSelection(Object primaryElement, Object element) {
				boolean isClasses=type.isClasses();
				boolean isPackages=type.isPackages();
				boolean isBehaviors=type.isBehaviors();
				if(isClasses && primaryElement instanceof JClass) {
					return false;
				}
				if(isPackages && primaryElement instanceof JPackage) {
					return false;
				}
				if(isBehaviors && primaryElement instanceof JBehavior) {
					return false;
				}
				if((isClasses || isBehaviors) && primaryElement instanceof JJavaFile) {
					return true;
				}
				if(!isPackages) {
					if(primaryElement instanceof JPackage) {
						return true;
					}
				}
				if(!isClasses) {
					if(primaryElement instanceof JClass) {
						return element instanceof JClass;
					}
				}
				if(!isBehaviors) {
					if(primaryElement instanceof JBehavior) {
						return element instanceof JBehavior;
					}
				}
				return false;
			}
		}));
		changed();
	}
	
	private void handleRemove() {
		TreeItem[] selection = userSelectionViewer.getTree().getSelection();										
		for(TreeItem item : selection) {
			remove(item.getData());
		}
		removeButton.setEnabled(false);
		changed();
	}		

	private void remove(Object data) {
		if(data instanceof Container) {
			Object[] children=clientContentProvider.getChildren(data);
			for (Object child : children) {
				remove(child);
			}
		} else {
			elements.remove(data);
		}
	}
	
	@Override
	public Control getControl() {
		return control;
	}

	
	public JObject[] getElements() {
		int index=0;
		JObject[] elements=new JObject[this.elements.size()];
		for (Object element : this.elements) {
			elements[index++]=(JObject) element;
		}
		return elements;
	}

	public Command getCommand() {
		if (!mappingChanged)
			return null;
			
		return new Command(commandName) {
			private final Mapping newMapping=
				mappingBuilder.buildMapping(getElements());

			@Override
			public void execute() {
				assignMapping(element, newMapping);
			}

			@Override
			public void undo() {
				assignMapping(element, originalMapping);
			}

		};
	}
	
	public abstract void assignMapping(T element, Mapping mapping);

	public abstract Mapping obtainMapping(T element);

	public boolean canCreateCommand() {
		return true;
	}

	public EditionItemStatus getStatus() {
		return EditionItemStatus.DEFAULT_OK;
	}
	
	private JObject[] getMatchingElements(Mapping mapping) {
		if(mapping==null)
			return new JObject[0];
		MessageAccumulator messageAccumulator = new LoggerMessageAccumulator();
		return mapping.getWorkspaceMapper().find(type, mapping, true, messageAccumulator);
	}
	
	private JObject[] getMatchingElements(Mapping[] parentScopeMappings) {
		List<JObject> elements=new LinkedList<JObject>();
		MessageAccumulator messageAccumulator = new LoggerMessageAccumulator();
		for (Mapping mapping : parentScopeMappings) {
			 JObject[] matches=mapping.getWorkspaceMapper().find(MappingType.CLASSES, mapping, true, messageAccumulator);
			 for (JObject match : matches) {
				 if(!JavaModelJDTUtil.contains(elements, match)) {
					 elements.add(match);
				 }
			}
			 
		}
		return elements.toArray(new JObject[elements.size()]);
	}

	private void changed() {
		mappingChanged = true;
		userSelectionViewer.setInput(this.elements.toArray());		
	}
	
	/**
	 * @param selectionList
	 * @param mapping
	 */
	private void appendToSelectionList(Object[] elements) {
		for (int i = 0; i < elements.length; i++) {
			JObject element=(JObject) elements[i];
			if(!JavaModelJDTUtil.contains(this.elements, element)) {
				this.elements.add(element);
			}

		}
		userSelectionViewer.setInput(this.elements.toArray());			
	}
}