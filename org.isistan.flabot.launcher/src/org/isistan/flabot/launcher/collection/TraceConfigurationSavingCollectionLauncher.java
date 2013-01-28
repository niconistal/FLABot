package org.isistan.flabot.launcher.collection;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.isistan.flabot.trace.config.TraceConfiguration;

/**
 * This is an abstract collection launcher that saves the trace configuration into
 * a file and calls. This is an convenience class.
 * 
 * @author usuario
 *
 */
public abstract class TraceConfigurationSavingCollectionLauncher implements
		CollectionLauncher {

	private static final Map SAVE_OPTIONS = Collections.singletonMap(XMLResource.OPTION_ENCODING, "ISO-8859-15");

	/**
	 * Saves the traceConfiguration into a file and the calls the launch method
	 * that receives that file.
	 */
	public final void launch(ILaunchConfiguration flabotConfiguration,
			ILaunchConfiguration targetConfiguration, String mode,
			ILaunch launch, IProgressMonitor monitor,
			TraceConfiguration traceConfiguration) throws CoreException,
			CollectionLauncherException {
		
		File file;
		try {
			file = save(traceConfiguration);
		} catch (IOException e) {
			throw new CollectionLauncherException("Error saving trace configuration to " +
					"a temporary file.", e);
		}
		
		launch(flabotConfiguration, targetConfiguration, mode, launch, monitor, file);
	}

	protected abstract void launch(ILaunchConfiguration flabotConfiguration,
			ILaunchConfiguration targetConfiguration, String mode,
			ILaunch launch, IProgressMonitor monitor,
			File traceConfiguration) throws CoreException,
			CollectionLauncherException;

	
	private File save(TraceConfiguration traceConfiguration) throws IOException {
		File file=File.createTempFile("flabotTraceConfiguration", ".traceConfiguration");
		
		URI uri = URI.createFileURI(file.getAbsolutePath());
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		Resource traceConfigurationResource = resourceSet.createResource(uri);
		traceConfigurationResource.getContents().add(traceConfiguration);
		traceConfigurationResource.save(SAVE_OPTIONS);
		return file;
	}
}
