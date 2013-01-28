/* $Id: AnalyzePostMappingCommand.java,v 1.3 2006/04/12 21:09:46 apersson Exp $
 */

package org.isistan.flabot.engine.commands;

import org.isistan.flabot.engine.RuntimeManager;
import org.isistan.flabot.executionmodel.ExecutionContext;

import JavaLog.PlException;
import JavaLog.PlList;

/**
 * @author $Author: apersson $
 */

public class AnalyzePostMappingCommand extends Command{
	
	private RuntimeManager runtimeManager;

	public AnalyzePostMappingCommand(RuntimeManager runtimeManager) {
		this.name = "'ANALYZE_POST_MAPPING'";
		this.runtimeManager = runtimeManager;
	}
	
	@Override
	public void execute(ExecutionContext context) throws PlException{
		context.setCurrentFamily(context.getLastMappingFamily());
		if (context.getMappingFamily()==null){
			String query = "retractRule(currentFamily("+context.getFamily()+")).";
			runtimeManager.getJavaLogEngine().executeQuery(query);
		}
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