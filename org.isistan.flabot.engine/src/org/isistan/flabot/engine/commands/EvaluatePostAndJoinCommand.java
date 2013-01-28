/* $Id: EvaluatePostAndJoinCommand.java,v 1.4 2006/03/22 03:28:54 franco Exp $
 */

package org.isistan.flabot.engine.commands;

import java.io.IOException;

import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.engine.RuntimeManager;
import org.isistan.flabot.executionmodel.ExecutionContext;

import JavaLog.PlException;
import JavaLog.PlList;

/**
 * @author $Author: franco $
 */

public class EvaluatePostAndJoinCommand extends Command{
	
	private RuntimeManager runtimeManager;
	
	public EvaluatePostAndJoinCommand(RuntimeManager runtimeManager) {
		this.name = "'EVALUATE_POST_JOIN_AND'";
		this.runtimeManager = runtimeManager;
	}
	
	@Override
	public void execute(ExecutionContext context) throws PlException, IOException{
		String query = "retractRule(evaluateCommand("+String.valueOf(Integer.parseInt(context.getCurrentStep())+1)+","+context.getPreResponsibility().getID()+")).";
		runtimeManager.getJavaLogEngine().executeQuery(query);
		query = "retractRule(evaluatingJoin("+context.getPreResponsibility().getID()+")).";
		runtimeManager.getJavaLogEngine().executeQuery(query);
		query = "situationForAndJoin("+String.valueOf(Integer.parseInt(context.getCurrentStep())+1)+","+context.getCurrentStep()+","+context.getPreResponsibility().getID()+","+getPrevious((SimplePathNode)context.getPreResponsibility().uGetPrevious().get(0))+","+getPrevious((SimplePathNode)context.getPreResponsibility().uGetPrevious().get(1))+",Result).";
		runtimeManager.getJavaLogEngine().executeQuery(query,"Result");
		context.setCurrentResponsibility(context.getResponsibilityToJoin());
		context.setPreResponsibility(context.getPreResponsibilityToJoin());
		query = "evaluateDependencies("+context.getCurrentFamily()+","+context.getCurrentResponsibility().getID()+","+context.getCurrentResponsibility().getMap().getID()+","+context.getCurrentResponsibility().getMap().getID()+",Event,Result,"+context.getCurrentStep()+").";
        PlList resultFinal = (PlList)runtimeManager.getJavaLogEngine().executeQuery(query,"Result");
        context.setCurrentDependency(resultFinal.toString());
		context.setDependencies(resultFinal.toString());
		putPrologSentence(context);		
	}
	
	public String getPrevious (SimplePathNode node){
		if (node instanceof ResponsibilityNode || node instanceof StubNode){
			return (node.getID());
		}	
		else
			if (node.uGetPrevious().size() > 0){
				return getPrevious ((SimplePathNode)node.uGetPrevious().get(0));
			}
			else {
				return "none";
			}
	}

	@Override
	public void putPrologSentence(ExecutionContext context) throws PlException, IOException{
		String query = "assertRule(evaluateCommand("+context.getCurrentStep()+","+context.getCurrentResponsibility().getID()+")).";
		runtimeManager.getJavaLogEngine().executeQuery(query);
	}
}