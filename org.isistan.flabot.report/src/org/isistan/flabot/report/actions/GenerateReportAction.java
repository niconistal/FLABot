package org.isistan.flabot.report.actions;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceRuleFactory;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;
import org.isistan.flabot.report.FlabotReportGenerator;
import org.isistan.flabot.report.FlabotReportGeneratorException;
import org.isistan.flabot.report.ReportPlugin;
import org.isistan.flabot.report.velocity.VelocityReportGenerator;
import org.isistan.flabot.util.resource.PathUtil;

/**
 * Our sample action implements workbench action delegate.
 * The action proxy will be created by the workbench and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be 
 * delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class GenerateReportAction implements IWorkbenchWindowActionDelegate {
	FlabotFileModel currentModel = null;
	
	private IWorkbenchWindow window;
	/**
	 * The constructor.
	 */
	public GenerateReportAction() {
	}

	/**
	 * The action has been activated. The argument of the
	 * method represents the 'real' action sitting
	 * in the workbench UI.
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) {
		if (action.isEnabled() && currentModel != null) {
			IPath outputFilePath = browseOutputFile();
			if (outputFilePath != null) {
				scheduleJob(currentModel, outputFilePath);
			}
		}
	}
	
	private IPath browseOutputFile() {
		SaveAsDialog dialog= new SaveAsDialog(window.getShell());
		dialog.setTitle("Trace Log File Selection");
		//dialog.setMessage("Select where the trace log should be saved.");
		dialog.create();
		if (dialog.open() == Window.OK) {
			IPath path = dialog.getResult();
			if(path == null)
				return null;
			String extension = path.getFileExtension();
			if(extension == null || extension.length() == 0) {
				path = path.addFileExtension("html");
			}
			
			return path;
		}
		return null;
	}

	private void scheduleJob(final FlabotFileModel currentModel, final IPath path) {
		IPath parentPath=path.removeLastSegments(1);
		final IResource resource =
			ResourcesPlugin.getWorkspace().getRoot().findMember(parentPath);
		IResourceRuleFactory factory = 
			ResourcesPlugin.getWorkspace().getRuleFactory();

		ISchedulingRule rule = factory.refreshRule(resource);

		Job job = new WorkspaceJob("Generating report") {
			public IStatus runInWorkspace(IProgressMonitor monitor) {
				try {
					FlabotReportGenerator reportGen = getFlabotReportGenerator();
					Map parameters = new HashMap();
					String fileName = PathUtil.makeSystemAbsolute(
							path).toPortableString();
					reportGen.generateReport(currentModel, parameters, fileName);
					resource.refreshLocal(IResource.DEPTH_ONE, monitor);
					return Status.OK_STATUS;
				} catch (FlabotReportGeneratorException e) {
					MessageDialog.openError(window.getShell(),
							"Error generating FLABot report",
							e.toString());
					e.printStackTrace();
					return new Status(IStatus.ERROR,
							ReportPlugin.SYMBOLIC_NAME,
							IStatus.OK,
							"Error generating FLABot report.",
							e);
				} catch (CoreException e) {
					return new Status(IStatus.WARNING,
							ReportPlugin.SYMBOLIC_NAME,
							IStatus.OK,
							"Couldn't update workspace contents.",
							e);		
				}
			}
		};
		job.setRule(rule);
		job.setUser(true);
		job.schedule();
	}
	
	private FlabotReportGenerator getFlabotReportGenerator() {
		return new VelocityReportGenerator();
	}

	/**
	 * Selection in the workbench has been changed. We 
	 * can change the state of the 'real' action here
	 * if we want, but this can only happen after 
	 * the delegate has been created.
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		IWorkbenchPage activePage = window.getActivePage();
		action.setEnabled(false);
		currentModel = null;
		if (activePage != null) {
			IEditorPart editor = activePage.getActiveEditor();
			if (editor != null && editor instanceof FlabotMultiPageEditor) {
				FlabotMultiPageEditor fmeditor = (FlabotMultiPageEditor) editor;
				currentModel = fmeditor.getModel();
				action.setEnabled(true);
			}
		}
	}

	/**
	 * We can use this method to dispose of any system
	 * resources we previously allocated.
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
	}

	/**
	 * We will cache window object in order to
	 * be able to provide parent shell for the message dialog.
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
}