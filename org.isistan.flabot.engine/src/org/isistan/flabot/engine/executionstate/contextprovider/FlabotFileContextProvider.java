/**
 * $Id: FlabotFileContextProvider.java,v 1.13 2006/04/13 04:42:17 apersson Exp $
 * $Author: apersson $
 */
package org.isistan.flabot.engine.executionstate.contextprovider;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPathEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.edit.editor.actions.RunConsistencyCheckAction;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;
import org.isistan.flabot.engine.EnginePlugin;
import org.isistan.flabot.engine.executionstate.ExecutionStateManager;
import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;
import org.isistan.flabot.engine.executionstate.StateDeterminationStrategy;
import org.isistan.flabot.launcher.context.ContextProvider;
import org.isistan.flabot.launcher.context.ContextProviderException;
import org.isistan.flabot.trace.config.Context;
import org.isistan.flabot.util.emf.WorkaroundURIConverter;
import org.isistan.flabot.util.resource.PathUtil;
import org.isistan.flabot.util.swt.SWTUtils;

/**
 * Abstract flabot file-based trace configuration provider
 * @author mblech
 *
 */
public abstract class FlabotFileContextProvider implements
		ContextProvider {
	
	private static final Map<String, String> SAVE_OPTIONS = Collections.singletonMap(XMLResource.OPTION_ENCODING, "ISO-8859-15"); //$NON-NLS-1$
	
	protected Resource resource;
	
	private IEditorPart getActiveFlabotEditor(String path) {		
		try {
			IWorkbenchWindow[] workbenchWindows = EnginePlugin.getDefault().getWorkbench().getWorkbenchWindows();
			for (IWorkbenchWindow workbenchWindow: workbenchWindows) {
				IWorkbenchPage workbenchPage = workbenchWindow.getActivePage();
				if (workbenchPage != null) {
					IEditorPart editor = workbenchPage.getActiveEditor();
					if (editor != null && editor instanceof FlabotMultiPageEditor) {
						String editorPath = PathUtil.makeSystemAbsolute(getPath(editor.getEditorInput()));				
						if (editorPath.equals(path))
							return editor;
					}
				}					
			}	
		} catch (Throwable e) {
			EnginePlugin.getDefault().getLogger()
			.warn("Error checking active file", e);	
			return null;
		}
		return null;
	}
	
	private String getPath(IEditorInput input) {
		if (input instanceof IFileEditorInput) {
			IFileEditorInput fileInput = (IFileEditorInput) input;
			IPath path = fileInput.getFile().getFullPath();
			return path.toString();
		}
		if (input instanceof IPathEditorInput) {
			IPathEditorInput pathInput = (IPathEditorInput) input;
			IPath path = pathInput.getPath();
			return path.toString();
		}		
		return "";
	}
	
	public Context[] getContexts(ILaunchConfiguration launchConfiguration) throws ContextProviderException, CoreException {
		String flabotFile=launchConfiguration.getAttribute(LaunchConfigurationConstants.FLABOT_FILE,"");
		flabotFile=PathUtil.makeSystemAbsolute(flabotFile);
					
		if(flabotFile.trim().length()==0) {
			EnginePlugin.getDefault().getLogger()
				.error("Flabot file not selected");
			throw new ContextProviderException("Flabot file not selected.");
		}
		
		IEditorPart editor = getActiveFlabotEditor(flabotFile.trim());		
		if (editor != null && editor.isDirty())
		{
			EnginePlugin.getDefault().getLogger()
				.error("Flabot file not saved. Save changes and restart the Flabot launcher.");
			Display.getDefault().asyncExec( new Runnable() {
				public void run() {
					MessageDialog dlg = new MessageDialog(
							SWTUtils.getSomeShell(EnginePlugin.getDefault().getWorkbench().getDisplay()),
							"Flabot file not saved",
				            null,
				            "Save changes and restart the Flabot launcher.",
				            MessageDialog.ERROR,
				            new String[]{"Ok"},
				            0);
				    dlg.open();
				}
			});
			throw new ContextProviderException("Flabot file not saved. Save changes and restart the Flabot launcher.");
		}
				
		if (editor == null) {
			Display.getDefault().asyncExec( new Runnable() {
				public void run() {
					MessageDialog dlg = new MessageDialog(
							SWTUtils.getSomeShell(EnginePlugin.getDefault().getWorkbench().getDisplay()),
							"Flabot file not active",
				            null,
				            "Flabot file is not active",
				            MessageDialog.WARNING,
				            new String[]{"Ok"},
				            0);
				    dlg.open();
				}
			});
		}
		
		URI uri = URI.createFileURI(flabotFile);
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl()
				);
		
		resourceSet.getLoadOptions().put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE,
				Boolean.TRUE);

		resourceSet.setURIConverter(new WorkaroundURIConverter());

		if(ExecutionstatePackage.eINSTANCE==null);
		
		resource = resourceSet.getResource(uri, true);

    	try {
			resource.load(Collections.emptyMap());
		} catch (IOException e1) {
			EnginePlugin.getDefault().getLogger()
				.error("Error loading flabot file for extracting trace information: {}", e1);
			throw new ContextProviderException("Error loading flabot file", e1);
		}
    	final FlabotFileModel fileModel =
    		(FlabotFileModel) resource.getContents().get(0);
    	if (fileModel == null) {
    		EnginePlugin.getDefault().getLogger()
				.error("Error loading flabot file for extracting trace information: empty file");
			throw new ContextProviderException("Empty flabot file");
    	}
 
     	Display.getDefault().asyncExec( new Runnable() {
    		public void run() {
    			RunConsistencyCheckAction checkAction = new RunConsistencyCheckAction(SWTUtils.getSomeShell(FlabotPlugin.getDefault().getWorkbench().getDisplay()));
    			checkAction.setFlabotFileModel(fileModel);
    			if (checkAction.isEnabled()) {
    				checkAction.run();
    			}
    		}
    	});
     	
     	checkMappingAndFilter(fileModel);     	
     	
     	return extractContexts(fileModel);
	}

	protected abstract Context[] extractContexts(FlabotFileModel fileModel);
	
	protected void checkMappingAndFilter(FlabotFileModel fileModel)	
	{
		checkResponsibilities(fileModel.getCoreModel());
		if (fileModel.getAllImportedFiles().size() > 0)
		{
			checkFlabotFileModel(fileModel);
		}
		saveResource();
	}
	
	@SuppressWarnings("unchecked")
	protected void checkFlabotFileModel(FlabotFileModel fileModel)	
	{		
		for(FlabotFileModel model : (List<FlabotFileModel>)fileModel.getAllImportedFiles())
		{
			checkResponsibilities(model.getCoreModel());
			if (model.getAllImportedFiles().size() > 0)
			{
				checkFlabotFileModel(model);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	protected void checkResponsibilities(CoreModel coreModel)
	{
		StateDeterminationStrategy strategy;
		for(Responsibility responsibility : (List<Responsibility>) coreModel.getResponsibilities())
		{
			strategy = ExecutionStateManager.getStateDeterminationStrategy(responsibility);
			strategy.checkMapping();
			strategy.checkFilter();
		}
	}
	
	private void saveResource()
	{
		if (resource != null)
		{
			try
			{
				resource.save(SAVE_OPTIONS);
			} catch(IOException e)
			{
				
			}
		}
	}
}
