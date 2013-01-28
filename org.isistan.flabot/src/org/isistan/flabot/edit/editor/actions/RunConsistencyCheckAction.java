/**
 * $Id: RunConsistencyCheckAction.java,v 1.10 2006/04/12 03:58:35 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.actions;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.edit.componenteditor.editparts.ComponentDiagramEditPart;
import org.isistan.flabot.edit.editor.dialogs.consistency.ConsistencyCheckVisualizer;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.ucmeditor.editparts.UCMDiagramEditPart;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class RunConsistencyCheckAction extends SelectionAction {
	
	public static final String
		RUN_CONSISTENCY = "RUN_CONSISTENCY";   //$NON-NLS-1$
	
	private ConsistencyCheckVisualizer consistencyCheckVisualizer;
	
	private int errors = 0;
	
	private int warnings = 0;
	
	private int exitValue = SWT.CANCEL;
	
	private FlabotFileModel fileModel;
	
	private Shell shell;
	
	public RunConsistencyCheckAction(IWorkbenchPart part) {
		super(part);
	
		shell = part.getSite().getShell();
		setId(RUN_CONSISTENCY);
		setText(Messages.getString("org.isistan.flabot.edit.editor.actions.RunConsistencyCheckAction.text")); //$NON-NLS-1$
		setToolTipText(Messages.getString("org.isistan.flabot.edit.editor.actions.RunConsistencyCheckAction.toolTipText"));							 //$NON-NLS-1$
	}	
	
	public RunConsistencyCheckAction(Shell shell) {
		super(null);
	
		setId(RUN_CONSISTENCY);
		setText(Messages.getString("org.isistan.flabot.edit.editor.actions.RunConsistencyCheckAction.text")); //$NON-NLS-1$
		setToolTipText(Messages.getString("org.isistan.flabot.edit.editor.actions.RunConsistencyCheckAction.toolTipText"));							 //$NON-NLS-1$
	
		this.shell = shell;
	}
		
	public boolean isEnabled() {
		return calculateEnabled();
	}
	
	public void setFlabotFileModel(FlabotFileModel fileModel) {
		this.fileModel = fileModel;
	}
	
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	private boolean canPerformAction() {	
		List selection = getSelectedObjects();
		if (fileModel != null) return true;
		
		if (selection == null ||
				selection.isEmpty()) return false;
		
		if (selection.size() > 1) return false;
		
		if (selection.get(0) instanceof ComponentDiagramEditPart ||
			selection.get(0) instanceof UCMDiagramEditPart)
			return true;
		
		return false;
	}
	
	private FlabotFileModel getFlabotFileModel() {
		if (fileModel == null) {
			List selection = getSelectedObjects();				
			EditPart selectionEditPart = (EditPart) selection.get(0);
			Diagram d = (Diagram)selectionEditPart.getModel();
			fileModel = d.getCoreModel().getFile();
		}
		return fileModel;
	}
	
	public synchronized void run() {	
		startChecking();				
		checkFlabotFileModel(getFlabotFileModel());
		finishChecking();
		
		//Waits until the dialog is closed.
		Shell shell = consistencyCheckVisualizer.getShell();
		Display display = shell.getDisplay();		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		exitValue = consistencyCheckVisualizer.getReturnCode();
	}	
	
	public void startChecking() {		
		consistencyCheckVisualizer = new ConsistencyCheckVisualizer(shell);
		FlabotPlugin.getDefault().getLog().addLogListener(consistencyCheckVisualizer);
		consistencyCheckVisualizer.open();
	}
	
	public void finishChecking() {
		if (consistencyCheckVisualizer != null) {
			consistencyCheckVisualizer.loggingFinished();		
		}
	}
	
	private void checkFlabotFileModel(FlabotFileModel fileModel) {
		errors = 0;
		warnings = 0;
				
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(fileModel);
		if (diagnostic.getSeverity() == Diagnostic.ERROR || 
			diagnostic.getSeverity() == Diagnostic.WARNING) {
			
			for (Iterator i=diagnostic.getChildren().iterator(); i.hasNext();) {
				Diagnostic childDiagnostic = (Diagnostic)i.next();
				switch (childDiagnostic.getSeverity()) {
				case Diagnostic.WARNING:
					FlabotPlugin.getDefault().getLogger()
					.warn(childDiagnostic.getMessage());
					warnings++;
					break;
				case Diagnostic.ERROR:
					FlabotPlugin.getDefault().getLogger()
					.error(childDiagnostic.getMessage());
					errors++;
					break;
				}
			}				
		}				
	}
	
	public int getTotalErrrors() {
		return errors;
	}
	
	public int getExitValue() {
		return exitValue;
	}
	
	public int getTotalWarnings() {
		return warnings;
	}
}