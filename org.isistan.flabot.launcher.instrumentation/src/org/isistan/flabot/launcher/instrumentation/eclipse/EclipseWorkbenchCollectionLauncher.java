package org.isistan.flabot.launcher.instrumentation.eclipse;

import java.io.File;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.isistan.flabot.launcher.collection.CollectionLauncherException;
import org.isistan.flabot.launcher.collection.TraceConfigurationSavingCollectionLauncher;

public class EclipseWorkbenchCollectionLauncher extends TraceConfigurationSavingCollectionLauncher {

	@Override
	public void launch(ILaunchConfiguration flabotConfiguration,
			ILaunchConfiguration targetConfiguration,
			String mode, ILaunch launch, IProgressMonitor monitor,
			File traceConfiguration)
				throws CoreException, CollectionLauncherException {
		
		EclipseWorkbenchConfigurationDelegate delegate=
			new EclipseWorkbenchConfigurationDelegate(traceConfiguration);
		
		delegate.launch(targetConfiguration, mode, launch, monitor);
	}


}
