/**
 * $Id: FlabotTemplateWizardPage.java,v 1.1 2006/04/12 03:49:45 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.wizards;

import java.io.File;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class FlabotTemplateWizardPage extends WizardPage {
	private Text containerText;

	private Text fileText;

	private ISelection selection;
	
	private Combo comboTemplates;
	
	private File[] templatesList;

	/**
	 * Constructor for SampleNewWizardPage.
	 * 
	 * @param pageName
	 */
	public FlabotTemplateWizardPage(ISelection selection, File[] templatesList) {		
		super(Messages.getString("org.isistan.flabot.edit.wizards.FlabotTemplateWizardPage.name")); //$NON-NLS-1$
		setTitle(Messages.getString("org.isistan.flabot.edit.wizards.FlabotTemplateWizardPage.title")); //$NON-NLS-1$
		setDescription(Messages.getString("org.isistan.flabot.edit.wizards.FlabotTemplateWizardPage.description")); //$NON-NLS-1$
		this.selection = selection;
		this.templatesList = templatesList; 
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.verticalSpacing = 9;
		
		//Container Selection edition
		Label label = new Label(container, SWT.NULL);
		label.setText(Messages.getString("org.isistan.flabot.edit.wizards.FlabotTemplateWizardPage.container")); //$NON-NLS-1$

		containerText = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		containerText.setLayoutData(gd);
		containerText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		Button button = new Button(container, SWT.PUSH);
		button.setText(Messages.getString("org.isistan.flabot.edit.wizards.FlabotTemplateWizardPage.browse")); //$NON-NLS-1$
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleBrowse();
			}
		});
		
		
		//Template Selection edition
		Label labelTemplate = new Label(container, SWT.NULL);
		labelTemplate.setText(Messages.getString("org.isistan.flabot.edit.wizards.FlabotTemplateWizardPage.template")); //$NON-NLS-1$

		comboTemplates = new Combo(container, SWT.BORDER | SWT.SINGLE | SWT.READ_ONLY);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		comboTemplates.setLayoutData(gd);
		for(File template : templatesList) {						
			comboTemplates.setData(String.valueOf(comboTemplates.getItemCount()), template);
			comboTemplates.add(template.getName());
		}
		if (comboTemplates.getItemCount() > 0)
			comboTemplates.select(0);
		
		//File Name edition
		Label labelText = new Label(container, SWT.NULL);
		labelText.setText(Messages.getString("org.isistan.flabot.edit.wizards.FlabotTemplateWizardPage.fileName")); //$NON-NLS-1$

		fileText = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		fileText.setLayoutData(gd);
		fileText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		
		initialize();
		dialogChanged();
		setControl(container);
	}

	/**
	 * Tests if the current workbench selection is a suitable container to use.
	 */

	private void initialize() {
		if (selection != null && selection.isEmpty() == false
				&& selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) selection;
			if (ssel.size() > 1)
				return;
			Object obj = ssel.getFirstElement();
			IContainer container;
			if (obj instanceof IJavaProject) {
				container = ((IJavaProject) obj).getProject();
				containerText.setText(container.getFullPath().toString());
			} else if (obj instanceof IResource) {
				
				if (obj instanceof IContainer)
					container = (IContainer) obj;
				else
					container = ((IResource) obj).getParent();
				containerText.setText(container.getFullPath().toString());
			}
		}
		fileText.setText(Messages.getString("org.isistan.flabot.edit.wizards.FlabotTemplateWizardPage.defaultFileName")); //$NON-NLS-1$
	}

	/**
	 * Uses the standard container selection dialog to choose the new value for
	 * the container field.
	 */

	private void handleBrowse() {
		ContainerSelectionDialog dialog = new ContainerSelectionDialog(
				getShell(), ResourcesPlugin.getWorkspace().getRoot(), false,
				Messages.getString("org.isistan.flabot.edit.wizards.FlabotTemplateWizardPage.selectFileContainer")); //$NON-NLS-1$
		if (dialog.open() == ContainerSelectionDialog.OK) {
			Object[] result = dialog.getResult();
			if (result.length == 1) {
				containerText.setText(((Path) result[0]).toString());
			}
		}
	}

	/**
	 * Ensures that both text fields are set.
	 */

	private void dialogChanged() {
		IResource container = ResourcesPlugin.getWorkspace().getRoot()
				.findMember(new Path(getContainerName()));
		String fileName = getFileName();

		if (getContainerName().length() == 0) {
			updateStatus(Messages.getString("org.isistan.flabot.edit.wizards.FlabotTemplateWizardPage.status1")); //$NON-NLS-1$
			return;
		}
		if (container == null
				|| (container.getType() & (IResource.PROJECT | IResource.FOLDER)) == 0) {
			updateStatus(Messages.getString("org.isistan.flabot.edit.wizards.FlabotTemplateWizardPage.status2")); //$NON-NLS-1$
			return;
		}
		if (!container.isAccessible()) {
			updateStatus(Messages.getString("org.isistan.flabot.edit.wizards.FlabotTemplateWizardPage.status3")); //$NON-NLS-1$
			return;
		}
		if (fileName.length() == 0) {
			updateStatus(Messages.getString("org.isistan.flabot.edit.wizards.FlabotTemplateWizardPage.status4")); //$NON-NLS-1$
			return;
		}
		if (fileName.replace('\\', '/').indexOf('/', 1) > 0) {
			updateStatus(Messages.getString("org.isistan.flabot.edit.wizards.FlabotTemplateWizardPage.status5")); //$NON-NLS-1$
			return;
		}
		int dotLoc = fileName.lastIndexOf('.');
		if (dotLoc != -1) {
			String ext = fileName.substring(dotLoc + 1);
			if (ext.equalsIgnoreCase("flabot") == false) { //$NON-NLS-1$
				updateStatus(Messages.getString("org.isistan.flabot.edit.wizards.FlabotTemplateWizardPage.status6")); //$NON-NLS-1$
				return;
			}
		}
		if (container.getProject().findMember(new Path(fileName)) != null) {
			updateStatus(Messages.getString("org.isistan.flabot.edit.wizards.FlabotTemplateWizardPage.status7")); //$NON-NLS-1$
			return;
		}
		
		if (comboTemplates.getItemCount() == 0) {
			updateStatus(Messages.getString("org.isistan.flabot.edit.wizards.FlabotTemplateWizardPage.status8")); //$NON-NLS-1$
			return;
		}
		
		updateStatus(null);
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	public File getChoosenTemplate() {
		return (File) comboTemplates.getData(String.valueOf(comboTemplates.getSelectionIndex()));
	}
	
	public String getContainerName() {
		return containerText.getText();
	}

	public String getFileName() {
		return fileText.getText();
	}
}