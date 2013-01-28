/**
 * $Id: FlabotNewWizard.java,v 1.8 2006/04/08 05:10:13 dacostae Exp $
 */
package org.isistan.flabot.edit.wizards;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.edit.componentmodel.ComponentDiagram;
import org.isistan.flabot.edit.componentmodel.ComponentmodelFactory;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.edit.ucmmodel.UcmmodelFactory;
import org.isistan.flabot.messages.Messages;

/**
 * This is a sample new wizard. Its role is to create a new file 
 * resource in the provided container. If the container resource
 * (a folder or a project) is selected in the workspace 
 * when the wizard is opened, it will accept it as the target
 * container. The wizard creates one file with the extension
 * "flabot". If a sample multi-page editor (also available
 * as a template) is registered for the same extension, it will
 * be able to open it.
 * @author $Author: dacostae $
 */

public class FlabotNewWizard extends Wizard implements INewWizard {
	private FlabotNewWizardPage page;
	private ISelection selection;

	/**
	 * Constructor for FlabotNewWizard.
	 */
	public FlabotNewWizard() {
		super();
		setNeedsProgressMonitor(true);
		setWindowTitle(Messages.getString("org.isistan.flabot.edit.wizards.FlabotNewWizard.title")); //$NON-NLS-1$
	}
	
	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		page = new FlabotNewWizardPage(selection);
		addPage(page);
	}

	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard. We will create an operation and run it
	 * using wizard as execution context.
	 */
	public boolean performFinish() {
		final String containerName = page.getContainerName();
		final String fileName = page.getFileName();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(containerName, fileName, monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			FlabotPlugin.getDefault().getLogger()
			.error("Error in wizard: {}", e); //$NON-NLS-1$
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), Messages.getString("org.isistan.flabot.edit.wizards.FlabotNewWizard.error"), realException.getMessage()); //$NON-NLS-1$
			FlabotPlugin.getDefault().getLogger()
			.error("Error in wizard: {}", e); //$NON-NLS-1$
			return false;
		}
		return true;
	}
	
	/**
	 * The worker method. It will find the container, create the
	 * file if missing or just replace its contents, and open
	 * the editor on the newly created file.
	 */

	private void doFinish(
		String containerName,
		String fileName,
		IProgressMonitor monitor)
		throws CoreException {
		// create a sample file
		monitor.beginTask(Messages.getString("org.isistan.flabot.edit.wizards.FlabotNewWizard.beginTaskName") + fileName, 2); //$NON-NLS-1$
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IResource resource = root.findMember(new Path(containerName));
		if (!resource.exists() || !(resource instanceof IContainer)) {
			throwCoreException("Container \"" + containerName + "\" does not exist."); //$NON-NLS-1$ //$NON-NLS-2$
		}
		IContainer container = (IContainer) resource;
		final IFile file = container.getFile(new Path(fileName));
		try {
			InputStream stream = openContentStream();
			if (file.exists()) {
				file.setContents(stream, true, true, monitor);
			} else {
				file.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
		}
		monitor.worked(1);
		monitor.setTaskName(Messages.getString("org.isistan.flabot.edit.wizards.FlabotNewWizard.taskName")); //$NON-NLS-1$
		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page =
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(page, file, true);
				} catch (PartInitException e) {
				}
			}
		});
		monitor.worked(1);
	}
	
	/**
	 * We will initialize file contents with a sample text.
	 */

	private InputStream openContentStream() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Resource resource = new XMIResourceImpl();

		//Creates a new Core Model
		CoreModel core = CoremodelFactory.eINSTANCE.createCoreModel();
		
		// Creates a new Flabot File Model
		FlabotFileModel model = EditormodelFactory.eINSTANCE.createFlabotFileModel();		
		model.setCoreModel(core);

		// Creates a new Component Diagram
		ComponentDiagram cd = ComponentmodelFactory.eINSTANCE.createComponentDiagram();
		cd.setCoreModel(core);
		cd.setName(Messages.getString("org.isistan.flabot.edit.wizards.FlabotNewWizard.defaulComponentDiagramName"));		 //$NON-NLS-1$
		model.getDiagrams().add(cd);
		model.getOpenDiagrams().add(cd);
		
		// Creates a new UCM Diagram
		UCMDiagram ucmd = UcmmodelFactory.eINSTANCE.createUCMDiagram();
		ucmd.setName(Messages.getString("org.isistan.flabot.edit.wizards.FlabotNewWizard.defaultUCMDiagramName")); //$NON-NLS-1$
		ucmd.setCoreModel(core);		
		model.getDiagrams().add(ucmd);
		model.getOpenDiagrams().add(ucmd);
		
		// Creates a new Map and add it to the UCM Diagram and CoreModel
		UseCaseMap map = CoremodelFactory.eINSTANCE.createUseCaseMap();
		map.setName(Messages.getString("org.isistan.flabot.edit.wizards.FlabotNewWizard.defaultUCMDiagramName")); //$NON-NLS-1$
		core.getUseCaseMaps().add(map);
		ucmd.setMap(map);
				
		resource.getContents().add(model);
		try {
			resource.save(out, Collections.emptyMap());
		} catch (IOException e) {
			FlabotPlugin.getDefault().getLogger()
				.error(Messages.getString("org.isistan.flabot.edit.wizards.FlabotNewWizard.errorMessage"), e); //$NON-NLS-1$
		}
		return new ByteArrayInputStream(out.toByteArray());
	}

	private void throwCoreException(String message) throws CoreException {
		IStatus status =
			new Status(IStatus.ERROR, "org.isistan.flabot", IStatus.OK, message, null); //$NON-NLS-1$
		throw new CoreException(status);
	}

	/**
	 * We will accept the selection in the workbench to see if
	 * we can initialize from it.
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
}