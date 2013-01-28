/**
 * $Id: DependenciesPropertiesPage.java,v 1.16 2006/03/21 01:51:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.multipage;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.util.consistency.GroupBasedDiagnostician;

/**
 * Page for managing dependencies in flabot files
 * 
 * @author $Author: franco $
 *
 */
public class DependenciesPropertiesPage extends FlabotFormPage
		implements Adapter {
	private static final String PAGE_TITLE = "Dependencies";
	private static final String PAGE_ID = "org.isistan.flabot.edit.multipage.DependenciesPropertiesPage";
	private TableViewer viewer;
	private FlabotFileModel selectedFile = null;
	private Button deleteButton;
	private SectionPart spart;

	/**
	 * Create a new instance of this page for the given editor and model
	 * @param editor
	 * @param model
	 */
	public DependenciesPropertiesPage(FormEditor editor, FlabotFileModel model) {
		super(editor, PAGE_ID, PAGE_TITLE, model);
		model.eAdapters().add(this);
	}
	

	
	/**
	 * Content provider for the imported files
	 */
	class ImportedFilesContentProvider implements IStructuredContentProvider {
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof FlabotFileModel) {
				FlabotFileModel model = (FlabotFileModel) inputElement;
				return model.getImportedFiles().toArray();
			}
			return new Object[0];
		}
		public void dispose() {
		}
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}
	
	class ImportedFilesLabelProvider extends LabelProvider
			implements
				ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return obj.toString();
		}
		public Image getColumnImage(Object obj, int index) {
			//TODO return an image for imported files
			return null;
		}
	}
	
	/**
	 * Create the content of the imports page
	 */
	@Override
	protected void createFormContent(final IManagedForm managedForm) {
		//final ScrolledForm form = managedForm.getForm();
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText("Dependencies");
		form.getBody().setLayout(new GridLayout(1, true));
		Section section = toolkit.createSection(form.getBody(),
				Section.DESCRIPTION);
		section.setText("Required flabot files");
		section.setDescription("Specify the list of flabot files required for the operation of this project");
		section.marginWidth = 10;
		section.marginHeight = 5;
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		section.setLayoutData(gd);
		spart = new SectionPart(section);
		managedForm.addPart(spart);
		toolkit.createCompositeSeparator(section);
		Composite client = toolkit.createComposite(section, SWT.WRAP);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginWidth = 2;
		layout.marginHeight = 2;
		client.setLayout(layout);
		Table t = toolkit.createTable(client, SWT.NULL);
		gd = new GridData(GridData.FILL_BOTH);
		t.setLayoutData(gd);
		toolkit.paintBordersFor(client);
		Composite buttonComposite = toolkit.createComposite(client);
		gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		buttonComposite.setLayoutData(gd);
		buttonComposite.setLayout(new GridLayout(1,true));
		Button b = toolkit.createButton(buttonComposite, "Add...", SWT.PUSH);
		gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING
				|GridData.FILL_HORIZONTAL);
		b.setLayoutData(gd);
		b.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				FileDialog dlg = new FileDialog(getSite().getShell(), SWT.OPEN);
		        dlg.setFilterNames(new String[]{"Flabot files (*.flabot)"});
		        dlg.setFilterExtensions(new String[]{"*.flabot"});
		        String fn = dlg.open();
		        if (fn != null) {
		        	//file selected, load file and import contents
		        	Resource resource = new XMIResourceImpl(URI.createFileURI(fn));
		        	try {
						resource.load(Collections.emptyMap());
					} catch (Exception e1) {
						ErrorDialog.openError(
								getSite().getShell(),
								"Error loading file to import",
								null, new Status(IStatus.ERROR,
										FlabotPlugin.SYMBOLIC_NAME,
										FlabotPlugin.getDefault().getLogStatusCodes().getErrorCode(),
										"Error loading file to import",
										e1));
						FlabotPlugin.getDefault().getLogger()
							.error("Error loading file to import: {}", e1);
						return;
					}
		        	FlabotFileModel fileModel =
		        		(FlabotFileModel) resource.getContents().get(0);
		        	
		        	// validate the imported file
		        	Diagnostic result =	GroupBasedDiagnostician
		        		.INSTANCE.validate(fileModel, null);
		        	if (result != null) {
		        		List children = result.getChildren();
		        		if (!children.isEmpty()) {
		        			// validation failed, let the user choose
		        			if (!MessageDialog.openQuestion(
		        					getSite().getShell(),
		        					"Validation failed",
		        					"Validation of the imported file failed. " +
		        					"Do you want to import it anyway?")) {
		        				// the user selected not to import the file
		        				// cancel import operation then
		        				return;
		        			}
		        		}
		        	}
		        	
		        	// check the file for duplicate ids
		        	if (isDuplicate(fileModel.getId())) {
		        		// create a dialog for the user to write a different id
		        		InputDialog inputDialog = new InputDialog(
		        				getSite().getShell(),
		        				"Duplicate id", "There's already an imported " +
		        						"file with the new file's id. Please " +
		        						"choose a different one.",
		        						fileModel.getId(),
		        						new IInputValidator() {
											public String isValid(String newText) {
												if (isDuplicate(newText))
													return "Duplicate id";
												if (newText.trim().equals(""))
													return "Invalid id";
												return null;
											}});
		        		if (inputDialog.open() != Window.OK) {
		        			// the user cancelled, do nothing
							return;
						}
		        		// set the user selected id to the imported file
		        		String newId = inputDialog.getValue();
		        		fileModel.setId(newId);
		        	}
			        getModel().getImportedFiles().add(fileModel);
			        spart.markDirty();
		        }
			}
		});
		//
		b = toolkit.createButton(buttonComposite, "Remove...", SWT.PUSH);
		gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING
				|GridData.FILL_HORIZONTAL);
		b.setLayoutData(gd);
		b.setEnabled(false);
		b.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (MessageDialog.openConfirm(getSite().getShell(),
						"Confirm Dependency Removal",
						"Dangling references and other inconsistencies might " +
						"appear if an in-use dependency is removed. Do you " +
						"confirm this removal?")) {
					getModel().getImportedFiles().remove(selectedFile);
		        	spart.markDirty();
				}
			}	
		});
		deleteButton = b;
		//
		section.setClient(client);
		viewer = new TableViewer(t);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof IStructuredSelection &&
						!event.getSelection().isEmpty()) {
					IStructuredSelection selection =
						(IStructuredSelection) event.getSelection();
					selectedFile = (FlabotFileModel) selection.getFirstElement();
					deleteButton.setEnabled(true);
				}
				else {
					selectedFile = null;
					deleteButton.setEnabled(false);
				}
			}
		});
		viewer.setContentProvider(new ImportedFilesContentProvider());
		viewer.setLabelProvider(new ImportedFilesLabelProvider());
		viewer.setInput(this.getModel());
	}

	private boolean isDuplicate(String id) {
		if (getModel().getId().equals(id))
			return true;
		for (Iterator iter = getModel().getImportedFiles().iterator();
				iter.hasNext();) {
			FlabotFileModel current = (FlabotFileModel) iter.next();
			if (current.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}	

	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.editor.FormPage#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
		getModel().eAdapters().remove(this);
	}
	
	/**
	 * notification received from model, update the list
	 */
	public void notifyChanged(Notification notification) {
		if (EditormodelPackage.eINSTANCE.getFlabotFileModel_ImportedFiles()
				.equals(notification.getFeature()) && viewer != null) {
			viewer.refresh();
		}
	}

	public Notifier getTarget() {
		return getModel();
	}

	public void setTarget(Notifier newTarget) {
		// do nothing;
	}

	public boolean isAdapterForType(Object type) {
		return false;
	}

	public void unsetDirty() {
		if (spart != null)
			spart.refresh();
		this.firePropertyChange(PROP_DIRTY);
	}
}