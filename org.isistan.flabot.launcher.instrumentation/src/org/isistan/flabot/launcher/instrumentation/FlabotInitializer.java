/** * $Id: FlabotInitializer.java,v 1.8 2006/03/29 21:36:44 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.launcher.instrumentation;

import java.io.IOException;import org.isistan.flabot.gauge.GaugeConsumer;import org.isistan.flabot.gauge.Strategy;import org.isistan.flabot.gauge.instrumentation.StrategyInstrumentor;import org.isistan.flabot.instrumentation.classloader.Interceptor;import org.isistan.flabot.instrumentation.launcher.Initializer;import org.isistan.flabot.launcher.trace.ControlPanelListener;import org.isistan.flabot.launcher.trace.TraceLogHandler;public class FlabotInitializer implements Initializer, ControlPanelListener {
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
		System.out.println("Trace configuration in file: " + traceConfigurationFile);		traceLogHandler = new TraceLogHandler(traceConfigurationFile, this);
		setInstrumentor(traceLogHandler.getGaugeConsumers(), traceLogHandler.isStartCollecting());		traceLogHandler.openControlPanel();	}
	
	private void setInstrumentor(GaugeConsumer[] gaugeConsumers, boolean startCollecting) {
		Strategy strategy=new Strategy(gaugeConsumers);		instrumentor=new StrategyInstrumentor(new Strategy[] {strategy}, startCollecting);
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
	}	public boolean start() {		instrumentor.setEnabled(true);		return true;	}	public boolean pause() {		instrumentor.setEnabled(false);		return true;	}	public boolean save() {		try {			finish();			return true;		} catch (IOException e) {			e.printStackTrace();			return false;		}	}	public boolean reset() {		traceLogHandler.reset();		return true;	}
}
