/**
 * $Id: FlabotEngineLocator.java,v 1.8 2006/03/22 03:28:54 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.locator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.engine.EnginePlugin;
import org.isistan.flabot.engine.JavaLogEngine;
import org.isistan.flabot.engine.Loader;
import org.isistan.flabot.engine.RuntimeManager;
import org.isistan.flabot.engine.SystemFactory;
import org.isistan.flabot.executionmodel.ExecutionInfoManager;
import org.isistan.flabot.util.locator.ComponentLocator;
import org.isistan.flabot.util.locator.ComponentLocatorException;

import JavaLog.PlException;

/**
 * ComponentLocator implementation for the Flabot Engine
 * @author $Author: franco $
 *
 */
public class FlabotEngineLocator implements ComponentLocator {
	
	/**
	 * Locator id for the flabot engine component locator
	 */
	public static final String LOCATOR_ID = "flabotEngine";
	
	/**
	 * Key for the "flabotFileModel" parameter
	 */
	public static final String PARAMETER_FLABOT_FILE_MODEL = "flabotFileModel";
	
	/**
	 * Key for the "executionInfoManager" parameter
	 */
	public static final String PARAMETER_EXECUTION_INFO_MANAGER = "executionInfoManager";

	private Map runtimeManagers = new HashMap();

	/**
	 * Locate an instance of the flabot engine
	 */
	public Object locate(Map parameters) throws ComponentLocatorException {
		// try to extract the flabot file model parameter from the
		// parameters hashtable
		FlabotFileModel flabotFileModel = (FlabotFileModel)
			parameters.get(PARAMETER_FLABOT_FILE_MODEL);
		if (flabotFileModel == null) {
			// the required parameter is null, throw an exception
			throw new ComponentLocatorException("Can't locate or create a " +
					"runtime manager without a flabot file model");
		}
		
		// try to get a previously created runtime manager for the given
		// flabot file model
		RuntimeManager runtimeManager = (RuntimeManager)
			runtimeManagers.get(flabotFileModel);
		
		if (runtimeManager == null) {
			ExecutionInfoManager executionInfoManager = (ExecutionInfoManager)
			parameters.get(PARAMETER_EXECUTION_INFO_MANAGER);
			if (executionInfoManager == null) {
			// the required parameter is null, throw an exception
			throw new ComponentLocatorException("Can't locate or create a " +
					"runtime manager without a execution info manager");
			}
		
			// the runtime manager is null, create a new one and register it
			// for the file model
			try {
				runtimeManager = createRuntimeManager(executionInfoManager);
				runtimeManagers.put(flabotFileModel, runtimeManager);
			}
			catch (Exception e) {
				// the runtime manager couldn't be created, log the exception
				// and throw a new component locator exception with the original
				// exception as a cause
				EnginePlugin.getDefault().getLogger().error(
						"Couldn't initialize the runtime manager", e);
				throw new ComponentLocatorException("Couldn't initialize " +
						"the runtime manager", e);
			}
		}
		return runtimeManager;
	}

	private RuntimeManager createRuntimeManager(ExecutionInfoManager executionInfoManager)
			throws IOException,	PlException {
		JavaLogEngine javaLogEngine = new JavaLogEngine();
		Loader loader = new Loader(javaLogEngine);
		SystemFactory systemFactory = new SystemFactory(loader, javaLogEngine);
		RuntimeManager runtimeManager = new RuntimeManager(javaLogEngine,
				loader, systemFactory, executionInfoManager);
		systemFactory.setRuntimeManager(runtimeManager);
		return runtimeManager;
	}

}
