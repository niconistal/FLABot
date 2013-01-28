/** * $Id: EclipseWorkbenchConfigurationDelegate.java,v 1.3 2006/02/03 21:03:00 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.launcher.instrumentation.eclipse;

import java.io.File;import org.eclipse.core.runtime.CoreException;import org.eclipse.core.runtime.IProgressMonitor;import org.eclipse.core.runtime.SubProgressMonitor;import org.eclipse.debug.core.ILaunch;import org.eclipse.debug.core.ILaunchConfiguration;import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;import org.eclipse.jdt.launching.IVMRunner;import org.eclipse.jdt.launching.VMRunnerConfiguration;import org.eclipse.pde.internal.core.PDECore;import org.eclipse.pde.internal.ui.PDEPlugin;import org.eclipse.pde.internal.ui.launcher.LaunchConfigurationHelper;import org.eclipse.pde.ui.launcher.EclipseApplicationLaunchConfiguration;import org.isistan.flabot.instrumentation.ClassLoaderGenerator;import org.isistan.flabot.instrumentation.launcher.Launcher;import org.isistan.flabot.launcher.instrumentation.FlabotInitializer;import org.isistan.flabot.launcher.instrumentation.LauncherInstrumentationUtils;public class EclipseWorkbenchConfigurationDelegate extends EclipseApplicationLaunchConfiguration {
		private File traceConfiguration;	public EclipseWorkbenchConfigurationDelegate(File traceConfiguration) {		this.traceConfiguration=traceConfiguration;	}	
	private String[] getProgramArguments(VMRunnerConfiguration runnerConfig) {
		String[] array=runnerConfig.getProgramArguments();
		String[] newArray=new String[array.length+3];
		newArray[0]=FlabotInitializer.class.getName();
		newArray[1]=traceConfiguration.getAbsolutePath();
		newArray[2]=runnerConfig.getClassToLaunch();
		
		for(int i=0; i<array.length; i++) {
			newArray[i+3]=array[i];
		}
		return newArray;
	}
	
	
	boolean generateClassLoader=true;
	protected VMRunnerConfiguration createVMRunner(VMRunnerConfiguration superRunnerConfig, boolean generateClassLoader) throws CoreException {
		if(generateClassLoader) {			VMRunnerConfiguration runnerConfig = new VMRunnerConfiguration(ClassLoaderGenerator.class.getName(),LauncherInstrumentationUtils.getClasspath(superRunnerConfig.getClassPath(), true));
			runnerConfig.setVMArguments(LauncherInstrumentationUtils.getVMArguments(superRunnerConfig.getVMArguments(), true));
			runnerConfig.setProgramArguments(new String[] {LauncherInstrumentationUtils.CLASSLOADER_FILE});
			runnerConfig.setEnvironment(superRunnerConfig.getEnvironment());
			runnerConfig.setVMSpecificAttributesMap(superRunnerConfig.getVMSpecificAttributesMap());
			runnerConfig.setBootClassPath(superRunnerConfig.getBootClassPath());
			runnerConfig.setResumeOnStartup(superRunnerConfig.isResumeOnStartup());
			runnerConfig.setWorkingDirectory(superRunnerConfig.getWorkingDirectory());
			return runnerConfig;
		} else {
			VMRunnerConfiguration runnerConfig = new VMRunnerConfiguration(Launcher.class.getName(), LauncherInstrumentationUtils.getClasspath(superRunnerConfig.getClassPath(), false));
			runnerConfig.setVMArguments(LauncherInstrumentationUtils.getVMArguments(superRunnerConfig.getVMArguments(), false));
			runnerConfig.setProgramArguments(getProgramArguments(superRunnerConfig));
			runnerConfig.setEnvironment(superRunnerConfig.getEnvironment());
			runnerConfig.setVMSpecificAttributesMap(superRunnerConfig.getVMSpecificAttributesMap());
			runnerConfig.setBootClassPath(superRunnerConfig.getBootClassPath());
			runnerConfig.setResumeOnStartup(superRunnerConfig.isResumeOnStartup());
			runnerConfig.setWorkingDirectory(superRunnerConfig.getWorkingDirectory());
			return runnerConfig;
		}	
	}


	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.eclipse.debug.core.ILaunchConfiguration, java.lang.String, org.eclipse.debug.core.ILaunch, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		sublaunch(configuration, mode, launch, monitor, true);
		sublaunch(configuration, mode, launch, monitor, false);
	}		public void sublaunch(ILaunchConfiguration configuration, String mode, ILaunch launch,			IProgressMonitor monitor, boolean generateClassLoader) throws CoreException {		try {			fConfigDir = null;			monitor.beginTask("", 4); //$NON-NLS-1$									preLaunchCheck(configuration, launch, new SubProgressMonitor(monitor, 2));						// Program arguments			String[] programArgs = getProgramArguments(configuration);			if (programArgs == null) {				monitor.setCanceled(true);				return;			}				VMRunnerConfiguration runnerConfig = new VMRunnerConfiguration(														"org.eclipse.core.launcher.Main",  //$NON-NLS-1$														getClasspath(configuration)); 			runnerConfig.setVMArguments(getVMArguments(configuration));			runnerConfig.setProgramArguments(programArgs);			runnerConfig.setWorkingDirectory(getWorkingDirectory(configuration).getAbsolutePath());			runnerConfig.setEnvironment(getEnvironment(configuration));			runnerConfig.setVMSpecificAttributesMap(getVMSpecificAttributesMap(configuration));			runnerConfig=createVMRunner(runnerConfig, generateClassLoader);						monitor.worked(1);								setDefaultSourceLocator(configuration);			LaunchConfigurationHelper.synchronizeManifests(configuration, getConfigDir(configuration));			PDEPlugin.getDefault().getLaunchListener().manage(launch);			IVMRunner runner = getVMRunner(configuration, mode);			if (runner != null)				runner.run(runnerConfig, launch, monitor);			else				monitor.setCanceled(true);			monitor.worked(1);		} catch (CoreException e) {			monitor.setCanceled(true);			throw e;		}	}	
}
