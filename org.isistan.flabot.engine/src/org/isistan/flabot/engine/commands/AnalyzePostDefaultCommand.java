/* $Id: AnalyzePostDefaultCommand.java,v 1.2 2006/04/12 21:09:46 apersson Exp $
 */

package org.isistan.flabot.engine.commands;

import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.engine.RuntimeManager;
import org.isistan.flabot.executionmodel.ExecutionContext;

import JavaLog.PlException;
import JavaLog.PlList;

/**
 * @author $Author: apersson $
 */

public class AnalyzePostDefaultCommand extends Command{
	
	private RuntimeManager runtimeManager;

	public AnalyzePostDefaultCommand(RuntimeManager runtimeManager) {
		this.name = "'ANALYZE_POST_DEFAULT'";
		this.runtimeManager = runtimeManager;
	}
	
	@Override
	public void execute(ExecutionContext context) throws PlException{
		if (context.getCurrentTypeDependency().equals(Condition.preconditionCondition)){
			String query = "getMappingOrConstraint("+context.getCurrentFamily()+","+context.getCurrentResponsibility().getID()+","+context.getCurrentResponsibility().getMap().getID()+","+context.getCurrentResponsibility().getMap().getID()+",Event,Result,"+context.getCurrentStep()+").";
			PlList list = (PlList)runtimeManager.getJavaLogEngine().executeQuery(query,"Result");
			if (list!=null&&list.length()>0){
				query = "assertRule(evaluateMappingANDConstraint("+context.getCurrentStep()+")).";
				runtimeManager.getJavaLogEngine().executeQuery(query);
			}
			else{
				putPrologSentence(context);
			}
		}
		else{
			putPrologSentence(context);
		}
	}
	
	@Override
	public void putPrologSentence(ExecutionContext context) throws PlException{
		if (context.getCurrentDependency().equals("[]")){
			String query = "assertRule(analyzeCommand("+context.getCurrentStep()+","+context.getCurrentResponsibility().getID()+")).";
			runtimeManager.getJavaLogEngine().executeQuery(query);
		}
	}
}