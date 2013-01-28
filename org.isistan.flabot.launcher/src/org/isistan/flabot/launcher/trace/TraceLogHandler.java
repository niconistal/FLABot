/**

import java.awt.GridLayout;
	private Resource traceLogResource=null;
	private TraceLog traceLog=null;
	public TraceLogHandler(String traceConfigurationFile, ControlPanelListener collectionHandler) {
		this.collectionHandler=collectionHandler;
		this.traceConfiguration=getConfiguration(traceConfigurationFile);
		this.traceLogResource=createLogResource(traceConfiguration.getOutputFileName());
		this.traceLog=createTraceLog(traceLogResource);
	}

	private Resource createLogResource(String logFile) {
		URI uri = URI.createFileURI(logFile);
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		if(LogPackage.eINSTANCE==null);
		Resource traceLogResource = resourceSet.createResource(uri);
		return traceLogResource;
	
	}
	private TraceLog createTraceLog(Resource traceLogResource) {
		TraceLog traceLog=LogFactory.eINSTANCE.createTraceLog();
		traceLogResource.getContents().add(traceLog);
		return traceLog;

	}

	private TraceConfiguration getConfiguration(String flabotFile) {
		URI uri = URI.createFileURI(flabotFile);


	}
	
	public void save() throws IOException {
		traceLogResource.save(Collections.EMPTY_MAP);
	}

}