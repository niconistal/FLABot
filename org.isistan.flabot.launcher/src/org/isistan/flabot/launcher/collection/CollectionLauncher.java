package org.isistan.flabot.launcher.collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.isistan.flabot.trace.config.TraceConfiguration;


/**
 * This interface is for clients to be able to launch particular launch configurations
 * in they particular way.
 * @see org.eclipse.debug.core.ILaunchConfigurationDelegate
 * 
 * @author usuario
 *
 */
public interface CollectionLauncher {
	
	/**
	 * Launches the application, behaves like org.eclipse.debug.core.ILaunchConfigurationDelegate.
	 * 
	 * @param flabotConfiguration the launch configuration
	 * @param targetConfiguration the original launch configuration
	 * @param mode launch mode ("run, debug, etc...")
	 * @param launch the launch itself
	 * @param monitor a progress monitor
	 * @param traceConfiguration the trace configuration for this launch
	 * @throws CoreException
	 * @throws CollectionLauncherException
	 */
	public void launch(ILaunchConfiguration flabotConfiguration,
			ILaunchConfiguration targetConfiguration,
			String mode, ILaunch launch, IProgressMonitor monitor,
			TraceConfiguration traceConfiguration)
				throws CoreException, CollectionLauncherException;
}
