/**

import java.io.IOException;
	private String mainClassName;
	private String[] arguments;
	private TraceLogHandler traceLogHandler;
	private StrategyInstrumentor instrumentor;
	public void start(String[] arguments) {
		String traceConfigurationFile=arguments[0];
		mainClassName=arguments[1];
		
		this.arguments=new String[arguments.length-2];
		for(int i=0; i<this.arguments.length; i++) {
			this.arguments[i]=arguments[i+2];
		}

		setInstrumentor(traceLogHandler.getGaugeConsumers(), traceLogHandler.isStartCollecting());
	
	private void setInstrumentor(GaugeConsumer[] gaugeConsumers, boolean startCollecting) {
		Strategy strategy=new Strategy(gaugeConsumers);
		Interceptor.addInstrumentor(instrumentor);
	}


	public String getMainClassName() {
		return mainClassName;
	}

	public String[] getArguments() {
		return arguments;
	}

	public void finish() throws IOException {
		traceLogHandler.save();
	}
}