/**
 * $Id: FlabotMultipagePropertiesEditor.java,v 1.16 2006/04/06 00:15:38 mblech Exp $
 * $Author: mblech $
 */
package org.isistan.flabot.edit.multipage;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.part.MultiPageSelectionProvider;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;

/**
 * This class implements a multipage properties editor for .flabot files
 */
public class FlabotMultipagePropertiesEditor extends FormEditor
		implements UnsettableDirtyStateEditor {
	
	private FlabotFileModel model;
	
	/**
	 * Create a new instance of this multipage editor for the given model
	 * @param model
	 */
	public FlabotMultipagePropertiesEditor(FlabotFileModel model) {
		this.model = model;
	}
	
	protected FlabotFileModel getModel() {
		return model;
	}
	
	
	private static class FormEditorSelectionProvider extends MultiPageSelectionProvider {
		private ISelection globalSelection;

		/**
		 * @param multiPageEditor
		 */
		public FormEditorSelectionProvider(FormEditor formEditor) {
			super(formEditor);
		}

		public ISelection getSelection() {
			IEditorPart activeEditor = ((FormEditor) getMultiPageEditor())
				.getActiveEditor();
			if (activeEditor != null) {
				ISelectionProvider selectionProvider = activeEditor.getSite()
					.getSelectionProvider();
				if (selectionProvider != null)
					return selectionProvider.getSelection();
			}
			return globalSelection;
		}

		/*
		 * (non-Javadoc) Method declared on <code> ISelectionProvider </code> .
		 */
		public void setSelection(ISelection selection) {
			IEditorPart activeEditor = ((FormEditor) getMultiPageEditor())
				.getActiveEditor();
			if (activeEditor != null) {
				ISelectionProvider selectionProvider = activeEditor.getSite()
					.getSelectionProvider();
				if (selectionProvider != null)
					selectionProvider.setSelection(selection);
			} else {
				this.globalSelection = selection;
				fireSelectionChanged(new SelectionChangedEvent(this,
						globalSelection));
			}
		}
	}
	

	private OverviewPropertiesPage overviewPage;
	private TextEditor textEditor;
	
	/**
	 * in this method is where all pages must be added
	 */
	@Override
	protected void addPages() {
		addOverviewPage();
		addRawTextPage();
	}
	
	public IEditorPart getActiveEditor() {
		// TODO: Fix this selection. May be modify the selection provider
		// to support globalselection.
		IEditorPart editor = super.getActiveEditor();
		if (editor == null)
			editor = getTextEditor();
		return editor;
	}

	/**
	 * add the raw xml text editor page
	 *
	 */
	private void addRawTextPage() {
		try {
			textEditor = new TextEditor();
			int index = addPage(getTextEditor(), getEditorInput());			
			setPageText(index, "Raw XML");
		} catch (PartInitException e) {
			ErrorDialog.openError(
				getSite().getShell(),
				"Error creating nested text editor page",
				null,
				e.getStatus());
			FlabotPlugin.getDefault().getLogger()
				.error("Error creating nested text editor page: {}", e);
		}
	}

	/**
	 * add the overview page
	 *
	 */
	private void addOverviewPage() {
		try {
			overviewPage = new OverviewPropertiesPage(this, getModel());
			addPage(overviewPage);
		} catch (PartInitException e) {
			ErrorDialog.openError(
				getSite().getShell(),
				"Error creating nested overview page",
				null,
				e.getStatus());
			FlabotPlugin.getDefault().getLogger()
				.error("Error creating nested overview page: {}", e);
		}
	}

	public void init(IEditorSite site, IEditorInput input) {
		setSite(site);
		setInput(input);
		site.setSelectionProvider(new FormEditorSelectionProvider(this));
	}
	
	@Override
	public void doSave(IProgressMonitor monitor) {
		// do nothing
	}

	@Override
	public void doSaveAs() {
		// do nothing
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	/**
	 * @return Returns the overviewPage.
	 */
	public OverviewPropertiesPage getOverviewPage() {
		return overviewPage;
	}

	/**
	 * @return Returns the textEditor.
	 */
	public TextEditor getTextEditor() {
		return textEditor;
	}

	public void unsetDirty() {
		// unset dirty state in internal pages
		overviewPage.unsetDirty();
		try {
			textEditor.getDocumentProvider().resetDocument(getEditorInput());
		} catch (CoreException e) {
			FlabotPlugin.getDefault().getLogger().error(
					"Exception resetting the text editor's document to set " +
					"dirtyState = false", e);
		}
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}
}