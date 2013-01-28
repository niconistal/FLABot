/**
 * $Id: AnalyzeMappingCommand.java,v 1.8 2006/03/22 03:28:54 franco Exp $
 */

package org.isistan.flabot.engine.commands;

import org.isistan.flabot.engine.RuntimeManager;
import org.isistan.flabot.executionmodel.ExecutionContext;

import JavaLog.PlAtom;
import JavaLog.PlException;

/**
 * @author $Author: franco $
 * 
 */

public class AnalyzeMappingCommand extends Command{
	
	private RuntimeManager runtimeManager;

	public AnalyzeMappingCommand(RuntimeManager runtimeManager) {
		this.name = "'ANALYZE_MAPPING'";
		this.runtimeManager = runtimeManager;
	}
	
	@Override
	public void execute(ExecutionContext context) throws PlException{
		String lastFamily = context.getCurrentFamily();
		context.setCurrentFamily(context.getFamily());
		String query = "existsCurrentFamily(Family).";
		PlAtom family = (PlAtom)runtimeManager.getJavaLogEngine().executeQuery(query,"Family");
		if (family==null){
			query = "assertRule(currentFamily("+context.getFamily()+")).";
			runtimeManager.getJavaLogEngine().executeQuery(query,"Family");
		}
		runtimeManager.addExecutionStep(context);
		context.setLastMappingFamily(lastFamily);
		if (family!=null){
			context.setMappingFamily(family.toString());
		}
		query = "assertRule(nextCommand("+context.getCurrentStep()+",'ANALYZE_POST_MAPPING')).";
		runtimeManager.getJavaLogEngine().executeQuery(query);
		context.setStopStep("STOP");
		
	}
	
	@Override
	public void putPrologSentence(ExecutionContext context){}
}