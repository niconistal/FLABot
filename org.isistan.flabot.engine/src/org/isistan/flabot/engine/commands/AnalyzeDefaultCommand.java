/**
 * $Id: AnalyzeDefaultCommand.java,v 1.5 2006/02/20 23:23:31 apersson Exp $
 */

package org.isistan.flabot.engine.commands;

import org.isistan.flabot.engine.RuntimeManager;
import org.isistan.flabot.executionmodel.ExecutionContext;

import JavaLog.PlException;

/**
 * @author $Author: apersson $
 */

public class AnalyzeDefaultCommand extends Command{
	
	private RuntimeManager runtimeManager;

	public AnalyzeDefaultCommand(RuntimeManager runtimeManager) {
		this.name = "'ANALYZE_DEFAULT'";
		this.runtimeManager = runtimeManager;
	}
	
	@Override
	public void execute(ExecutionContext context) throws PlException{
		runtimeManager.addExecutionStep(context);
		String query = "assertRule(nextCommand("+context.getCurrentStep()+",'ANALYZE_POST_DEFAULT')).";
		runtimeManager.getJavaLogEngine().executeQuery(query);
		context.setStopStep("STOP");
	}
	
	@Override
	public void putPrologSentence(ExecutionContext context){}
}

