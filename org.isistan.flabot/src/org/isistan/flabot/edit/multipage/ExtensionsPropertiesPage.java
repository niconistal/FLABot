/**
 * $Id: ExtensionsPropertiesPage.java,v 1.4 2006/04/03 21:00:18 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.multipage;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.messages.Messages;

/**
 * Properties page for extensions
 * @author $Author: franco $
 *
 */
public class ExtensionsPropertiesPage extends FlabotFormPage {

	private static final String PAGE_TITLE = Messages.getString("org.isistan.flabot.edit.multipage.ExtensionsPropertiesPage.extensionsTabName"); //$NON-NLS-1$
	private static final String PAGE_ID = "org.isistan.flabot.edit.multipage.ExtensionsPropertiesPage"; //$NON-NLS-1$
	private ExtensionsBlock block;
	
	/**
	 * create an instance of the extensions page for the given flabot file model
	 * @param editor
	 * @param model
	 */
	public ExtensionsPropertiesPage(FormEditor editor, FlabotFileModel model) {
		super(editor, PAGE_ID, PAGE_TITLE, model);
		block = new ExtensionsBlock(this);
	}
	
	protected void createFormContent(final IManagedForm managedForm) {
		final ScrolledForm form = managedForm.getForm();
		//FormToolkit toolkit = managedForm.getToolkit();
		form.setText(Messages.getString("org.isistan.flabot.edit.multipage.ExtensionsPropertiesPage.extensionsTabText")); //$NON-NLS-1$
		block.createContent(managedForm);
	}
	

	/**
	 * Internal master block for the ExtensionsPropertiesPage
	 * @author $Author: franco $
	 *
	 */
	private class ExtensionsBlock extends MasterDetailsBlock {

		private ExtensionsPropertiesPage page;
		
		/**
		 * create an instance of the master-details block in the given editor
		 * @param page
		 */
		public ExtensionsBlock(ExtensionsPropertiesPage page) {
			this.page = page;
		}
		
		/**
		 * Content provider for the master block: provides the imports
		 */
		class MasterContentProvider implements IStructuredContentProvider {
			public Object[] getElements(Object inputElement) {
				return new Object[0];
			}
			public void dispose() {
			}
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}
		}
		
		/**
		 * Label provider for the master block: returns the titles and images
		 * for items
		 */
		class MasterLabelProvider extends LabelProvider
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
		 * construct all the widgets for the master part
		 */
		@Override
		protected void createMasterPart(final IManagedForm managedForm,
				Composite parent) {
			//final ScrolledForm form = managedForm.getForm();
			FormToolkit toolkit = managedForm.getToolkit();
			Section section = toolkit.createSection(parent, Section.DESCRIPTION);
			section.setText(Messages.getString("org.isistan.flabot.edit.multipage.ExtensionsPropertiesPage.modelObjectsSectionName")); //$NON-NLS-1$
			section.setDescription(Messages.getString("org.isistan.flabot.edit.multipage.ExtensionsPropertiesPage.modelObjectsSectionDescription")); //$NON-NLS-1$
			section.marginWidth = 10;
			section.marginHeight = 5;
			toolkit.createCompositeSeparator(section);
			Composite client = toolkit.createComposite(section, SWT.WRAP);
			GridLayout layout = new GridLayout();
			layout.numColumns = 2;
			layout.marginWidth = 2;
			layout.marginHeight = 2;
			client.setLayout(layout);
			Table t = toolkit.createTable(client, SWT.NULL);
			GridData gd = new GridData(GridData.FILL_BOTH);
			gd.heightHint = 20;
			gd.widthHint = 100;
			t.setLayoutData(gd);
			toolkit.paintBordersFor(client);
			Button b = toolkit.createButton(client, Messages.getString("org.isistan.flabot.edit.multipage.ExtensionsPropertiesPage.addButton"), SWT.PUSH); //$NON-NLS-1$
			gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
			b.setLayoutData(gd);
			section.setClient(client);
			final SectionPart spart = new SectionPart(section);
			managedForm.addPart(spart);
			TableViewer viewer = new TableViewer(t);
			viewer.addSelectionChangedListener(new ISelectionChangedListener() {
				public void selectionChanged(SelectionChangedEvent event) {
					managedForm.fireSelectionChanged(spart, event.getSelection());
				}
			});
			viewer.setContentProvider(new MasterContentProvider());
			viewer.setLabelProvider(new MasterLabelProvider());
			viewer.setInput(page.getModel());
		}

		@Override
		protected void createToolBarActions(IManagedForm managedForm) {
			final ScrolledForm form = managedForm.getForm();
			Action haction = new Action(Messages.getString("org.isistan.flabot.edit.multipage.ExtensionsPropertiesPage.horizontalActionName"), Action.AS_RADIO_BUTTON) { //$NON-NLS-1$
				public void run() {
					sashForm.setOrientation(SWT.HORIZONTAL);
					form.reflow(true);
				}
			};
			haction.setChecked(true);
			haction.setToolTipText(Messages.getString("org.isistan.flabot.edit.multipage.ExtensionsPropertiesPage.horizontalActionToolTip"));  //$NON-NLS-1$
			/*haction.setImageDescriptor(FlabotPlugin.getDefault()
					.getImageRegistry()
					.getDescriptor(FlabotPlugin.IMG_HORIZONTAL));*/
			Action vaction = new Action(Messages.getString("org.isistan.flabot.edit.multipage.ExtensionsPropertiesPage.verticalActionName"), Action.AS_RADIO_BUTTON) { //$NON-NLS-1$
				public void run() {
					sashForm.setOrientation(SWT.VERTICAL);
					form.reflow(true);
				}
			};
			vaction.setChecked(false);
			vaction.setToolTipText(Messages.getString("org.isistan.flabot.edit.multipage.ExtensionsPropertiesPage.verticalActionToolTip")); //$NON-NLS-1$
			/*vaction.setImageDescriptor(FlabotPlugin.getDefault()
					.getImageRegistry().getDescriptor(FlabotPlugin.IMG_VERTICAL));*/
			form.getToolBarManager().add(haction);
			form.getToolBarManager().add(vaction);
		}

		@Override
		protected void registerPages(DetailsPart detailsPart) {
			detailsPart.registerPage(FlabotFileModel.class, new FlabotFileDetailsPage());
		}

	}

	public void unsetDirty() {
		// do nothing for now, because this page still doesn't modify the model
	}
}