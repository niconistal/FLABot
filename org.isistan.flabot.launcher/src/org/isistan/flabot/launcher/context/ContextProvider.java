package org.isistan.flabot.launcher.context;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.isistan.flabot.trace.config.Context;


/**
 * A context provider is used by the FlabotLauncherConfigurationDelegate
 * to load log configuration contexts so they can be sent to the
 * CollectionLauncher.
 * 
 * @author usuario
 *
 */
public interface ContextProvider {
	
	/**
	 * Gets a the list of log configuration contexts that should be
	 * used to collect information.
	 * 
	 * @param launchConfiguration
	 * @return
	 * @throws ContextProviderException
	 * @throws CoreException
	 */
	Context[] getContexts(ILaunchConfiguration launchConfiguration) throws ContextProviderException, CoreException;
	
	
	
}
