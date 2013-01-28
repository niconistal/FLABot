/* $Id: AnalyzePostConstraintCommand.java,v 1.1 2006/02/20 20:13:37 apersson Exp $
 */

package org.isistan.flabot.engine.commands;

import org.isistan.flabot.engine.RuntimeManager;
import org.isistan.flabot.executionmodel.ExecutionContext;

import JavaLog.PlException;

/**
 * @author $Author: apersson $
 */

public class AnalyzePostConstraintCommand extends Command{
	
	private RuntimeManager runtimeManager;

	public AnalyzePostConstraintCommand(RuntimeManager runtimeManager) {
		this.name = "'ANALYZE_POST_CONSTRAINT'";
		this.runtimeManager = runtimeManager;
	}
	
	@Override
	public void execute(ExecutionContext context) throws PlException{
		runtimeManager.getJavaLogEngine().changeLogicModule(RuntimeManager.LogicModuleGeneral);
		context.setCurrentLogicModule(RuntimeManager.LogicModuleGeneral);
		putPrologSentence(context);
	}
	
	@Override
	public void putPrologSentence(ExecutionContext context) throws PlException{
		if (context.getCurrentDependency().equals("[]")){
			String query = "assertRule(analyzeCommand("+context.getCurrentStep()+","+context.getCurrentResponsibility().getID()+")).";
			runtimeManager.getJavaLogEngine().executeQuery(query);
		}
	}
}