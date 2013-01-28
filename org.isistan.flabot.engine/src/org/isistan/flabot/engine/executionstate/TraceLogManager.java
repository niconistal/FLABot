/**
 * $Id: TraceLogManager.java,v 1.12 2006/05/03 20:41:24 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.engine.executionstate;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.engine.EnginePlugin;
import org.isistan.flabot.trace.log.TraceLog;
import org.isistan.flabot.util.resource.PathUtil;
import org.isistan.flabot.util.resource.ResourceSelectionDialog;
import org.isistan.flabot.util.resource.filter.FilePatternFilter;
import org.isistan.flabot.util.resource.validator.CompositeValidator;
import org.isistan.flabot.util.resource.validator.FileValidator;
import org.isistan.flabot.util.resource.validator.SelectionSizeValidator;
import org.isistan.flabot.util.swt.SWTUtils;

/**
 * Manager of trace logs. Holds a reference to the current log. 
 * @author $Author: dacostae $
 */
public class TraceLogManager {
	private static TraceLogManager instance;
	private TraceLog currentLog;
	private TraceLog loadedTracelog;

	/**
	 * Create a new instance of TraceLogManager
	 */
	private TraceLogManager() {
	}
	
	public static TraceLogManager getDefault() {
		if (instance == null)
			instance = new TraceLogManager();
		return instance;
	}
	
	/**
	 * Get the current log
	 * @return
	 */
	public TraceLog getCurrentLogg() throws TraceLogManagerException {
		if (currentLog == null) {
			currentLog = loadLog();
		}
		return currentLog;
	}
	
	public TraceLog loadLog() {
		Runnable loadLogRunnable = new Runnable(){
			public void run() {
				Shell shell = SWTUtils.getSomeShell(FlabotPlugin.getDefault().getWorkbench().getDisplay());

				ISelectionStatusValidator validator=new CompositeValidator(
						new SelectionSizeValidator(EnginePlugin.SYMBOLIC_NAME, 1,1),
						new FileValidator(EnginePlugin.SYMBOLIC_NAME));
				
				ResourceSelectionDialog dlg=ResourceSelectionDialog.getInstance();
				Object[] results = dlg.open(
						shell,
						"Select Trace Log File",
						"Select a trace log file:",
						new FilePatternFilter(shell.getDisplay(), ".*\\.tracelog"),
						validator,
						false);
				if(results!=null) {
					Object result=results[0];
					IFile file=((IFile)result);
					IPath path=PathUtil.makeSystemAbsolute(file.getFullPath());
					String fileName=PathUtil.toString(path);
		        	Resource resource = new XMIResourceImpl(URI.createFileURI(fileName));
		        	try {
						resource.load(Collections.emptyMap());
					} catch (IOException e1) {
						ErrorDialog.openError(
								shell,
								"Error loading file to import",
								null, new Status(IStatus.ERROR,
										EnginePlugin.SYMBOLIC_NAME,
										EnginePlugin.getDefault().getLogStatusCodes().getErrorCode(),
										"Error loading file to import",
										e1));
						EnginePlugin.getDefault().getLogger()
							.error("Error loading trace log file: {}", e1);
					}
		        	loadedTracelog = (TraceLog) resource.getContents().get(0);
		        }
			}};
		FlabotPlugin.getDefault().getWorkbench().getDisplay().syncExec(loadLogRunnable);
		TraceLog tracelog = loadedTracelog;
		loadedTracelog = null;
		return tracelog;
	}
	
	/**
	 * Reset the current log
	 *
	 */
	public void resettt() {
		this.currentLog = null;
		// TODO just trying to free the unused log's memory to avoid OutOfMemoryExceptions
		System.gc();
	}
}
