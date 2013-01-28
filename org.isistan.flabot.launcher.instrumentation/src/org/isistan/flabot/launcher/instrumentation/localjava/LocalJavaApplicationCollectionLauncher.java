package org.isistan.flabot.launcher.instrumentation.localjava;

import java.io.File;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.isistan.flabot.launcher.collection.CollectionLauncherException;
import org.isistan.flabot.launcher.collection.TraceConfigurationSavingCollectionLauncher;

public class LocalJavaApplicationCollectionLauncher extends TraceConfigurationSavingCollectionLauncher {

	@Override
	public void launch(ILaunchConfiguration flabotConfiguration,
			ILaunchConfiguration targetConfiguration,
			String mode, ILaunch launch, IProgressMonitor monitor,
			File traceConfiguration)
				throws CoreException, CollectionLauncherException {
		
		LocalJavaApplicationConfigurationDelegate delegate=
			new LocalJavaApplicationConfigurationDelegate(traceConfiguration);
		
		delegate.launch(targetConfiguration, mode, launch, monitor);
	}


}
