/**
 * $Id: FlabotTemplateWizard.java,v 1.2 2006/04/12 20:09:05 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.wizards;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

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
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.plugin.PluginUtils;

/**
 * @author $Author: franco $
 *
 */
public class FlabotTemplateWizard extends Wizard implements INewWizard {
	
	public static final String TEMPLATES_FOLDER = PluginUtils.getPluginFolder(FlabotPlugin.getDefault()) + "resource/templates";
	
	private FlabotTemplateWizardPage page;
	
	private File[] templatesList;
	
	private ISelection selection;
	
	/**
	 * Constructor for FlabotNewWizard.
	 */
	public FlabotTemplateWizard() {
		super();
		setNeedsProgressMonitor(true);
		setWindowTitle(Messages.getString("org.isistan.flabot.edit.wizards.FlabotNewWizard.title")); //$NON-NLS-1$
		
		File file = Path.fromOSString(TEMPLATES_FOLDER).toFile();
		templatesList = file.listFiles(new FlabotFilenameFilter());
	}
	
	
	
	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		page = new FlabotTemplateWizardPage(selection, templatesList);
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
		final File chooseTemplateName = page.getChoosenTemplate();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(containerName, fileName, chooseTemplateName, monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(false, false, op);
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
		File choosenTemplate,
		IProgressMonitor monitor/*,
		File choosenTemplate*/)
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
			InputStream stream = openContentStream(choosenTemplate);
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

	private InputStream openContentStream(File choosenTemplate) throws FileNotFoundException {
		return new FileInputStream(choosenTemplate);
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
	
	private class FlabotFilenameFilter implements FilenameFilter {
		
		public boolean accept(File dir, String name) {
			int index = name.lastIndexOf("."); //$NON-NLS-1$
			if (index > 0) {
				String extension = name.substring(index);
				if (extension.toLowerCase().equals(".flabot")) //$NON-NLS-1$
					return true;
			}
			return false;
		}	
	}
}