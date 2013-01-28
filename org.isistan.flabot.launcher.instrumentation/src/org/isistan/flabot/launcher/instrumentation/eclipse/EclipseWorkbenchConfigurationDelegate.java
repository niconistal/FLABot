/**

import java.io.File;

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
		if(generateClassLoader) {
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
	@Override
		sublaunch(configuration, mode, launch, monitor, true);
		sublaunch(configuration, mode, launch, monitor, false);
	}
}