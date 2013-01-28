/**
 * $Id: AnalyzeConstraintCommand.java,v 1.7 2006/02/20 23:23:31 apersson Exp $
 */

package org.isistan.flabot.engine.commands;

import java.io.IOException;

import org.isistan.flabot.engine.JavaLogEngine;
import org.isistan.flabot.engine.RuntimeManager;
import org.isistan.flabot.executionmodel.ExecutionContext;

import JavaLog.PlException;

/**
 * @author $Author: apersson $
 */

public class AnalyzeConstraintCommand extends Command{
	
	private JavaLogEngine javaLogEngine;
	private RuntimeManager runtimeManager;

	public AnalyzeConstraintCommand(JavaLogEngine javaLogEngine,
			RuntimeManager runtimeManager) {
		this.name = "'ANALYZE_CONSTRAINT'";
		this.javaLogEngine = javaLogEngine;
		this.runtimeManager = runtimeManager;
	}
	
	@Override
	public void execute(ExecutionContext context) throws IOException, PlException{
		javaLogEngine.changeLogicModule(RuntimeManager.LogicModuleConstraint);
		context.setCurrentLogicModule(RuntimeManager.LogicModuleConstraint);
		runtimeManager.addExecutionStep(context);
		String query = "assertRule(nextCommand("+context.getCurrentStep()+",'ANALYZE_POST_CONSTRAINT')).";
		javaLogEngine.executeQuery(query);
		context.setStopStep("STOP");
	}
	
	@Override
	public void putPrologSentence(ExecutionContext context){}
	
}