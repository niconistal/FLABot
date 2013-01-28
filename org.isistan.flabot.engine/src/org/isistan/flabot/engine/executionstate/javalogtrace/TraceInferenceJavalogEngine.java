/**
 * 
 */
package org.isistan.flabot.engine.executionstate.javalogtrace;

import java.io.IOException;

import org.isistan.flabot.engine.EnginePlugin;
import org.isistan.flabot.engine.JavaLogEngine;
import org.isistan.flabot.util.plugin.PluginUtils;

import JavaLog.PlException;

/**
 * JavalogEngine that has a set of useful predefined predicates for trace inference
 * @author mblech
 *
 */
public class TraceInferenceJavalogEngine extends JavaLogEngine {
	
	/**
	 * Trace inference predicates prolog file path
	 */
	public static final String TRACE_INFERENCE_PREDICATES = PluginUtils.getPluginFolder(EnginePlugin.getDefault()) + "resource/TraceInferencePredicates.pl";
	
	/**
	 * State logic module
	 */
	//LogicKnowledge lkState;

	/**
	 * Create a new instance of TraceInferenceJavalogEngine
	 * @throws IOException thrown when necessary files can't be opened
	 * @throws PlException thrown by the javalog brain during initialization
	 */
	public TraceInferenceJavalogEngine()
			throws IOException, PlException {
		super();
		this.reset();
	}
	
	@Override
	public void reset() throws IOException, PlException {
		System.out.println("Resetting engine...");
		super.reset();
        this.loadLogicModule(TRACE_INFERENCE_PREDICATES);
        this.changeLogicModule(TRACE_INFERENCE_PREDICATES);
        //lkState = new LogicKnowledge(getBrain(), "");
        //getBrain().addKnowledge(lkState);
        //lkState.disable();
        System.out.println("Engine reset finished");
	}
	
	
	/**
	 * Enable the state logic module
	 *
	 *//*
	public void enableState() {
		lkState.enable();
	}*/
	
	/**
	 * Disable the state logic module
	 *
	 *//*
	public void disableState() {
		lkState.disable();
	}*/
}
