/**
 * 
 */
package org.isistan.flabot.engine.executionstate.javalogtrace;

import java.io.IOException;
import java.util.Map;
import java.util.WeakHashMap;

import org.isistan.flabot.trace.log.TraceLog;
import org.isistan.flabot.util.locator.ComponentLocator;
import org.isistan.flabot.util.locator.ComponentLocatorException;

import JavaLog.PlException;

/**
 * Component locator that handles javalog engine instance creation for
 * trace inference
 * @author usuario
 *
 */
public class TraceInferenceJavalogEngineLocator implements ComponentLocator {
	
	/**
	 * Locator id for the flabot engine component locator
	 */
	public static final String LOCATOR_ID = "traceInferenceJavalogEngine";
	
	/**
	 * Key for the "traceLog" parameter
	 */
	public static final String PARAMETER_TRACE_LOG = "traceLog";
	
	private Map javalogEngines = new WeakHashMap();

	public Object locate(Map parameters) throws ComponentLocatorException {
		// parameter extraction
		Object traceLogObject = parameters.get(PARAMETER_TRACE_LOG);
		if (!parameters.containsKey(PARAMETER_TRACE_LOG)) {
			throw new ComponentLocatorException(
					"Can't locate a TraceInferenceJavalogEngine without the" +
					"required 'traceLog' parameter");
		}
		if (traceLogObject != null && !(traceLogObject instanceof TraceLog)) {
			throw new ComponentLocatorException(
					"The parameter 'traceLog' isn't an instance of TraceLog");
		}
		TraceLog traceLog = (TraceLog)traceLogObject;		
		//parameter extracted
		
		TraceInferenceJavalogEngine engine =
			(TraceInferenceJavalogEngine)javalogEngines.get(traceLog);
		if (engine == null) {
			//engine initialization
			try {
				engine = new TraceInferenceJavalogEngine();
				javalogEngines.put(traceLog, engine);
			} catch (IOException e) {
				throw new ComponentLocatorException(
						"IOException initializing the TraceInferenceJavalogEngine",
						e);
			} catch (PlException e) {
				throw new ComponentLocatorException(
						"PlException initializing the TraceInferenceJavalogEngine",
						e);
			}
		}
		
		return engine;
	}

}
