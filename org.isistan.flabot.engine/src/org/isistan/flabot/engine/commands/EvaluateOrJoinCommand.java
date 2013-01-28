/**
 * $Id: EvaluateOrJoinCommand.java,v 1.3 2006/03/22 03:28:54 franco Exp $
 */

package org.isistan.flabot.engine.commands;

import java.io.IOException;
import java.util.Hashtable;

import org.isistan.flabot.coremodel.JoinNode;
import org.isistan.flabot.engine.Loader;
import org.isistan.flabot.engine.RuntimeManager;
import org.isistan.flabot.executionmodel.ExecutionContext;

import JavaLog.PlAtom;
import JavaLog.PlException;

/**
 * @author $Author: franco $
 */

public class EvaluateOrJoinCommand extends Command{
	
	private RuntimeManager runtimeManager;
	private Loader loader;
	
	public EvaluateOrJoinCommand(RuntimeManager runtimeManager, Loader loader) {
		this.name = "'EVALUATE_JOIN_OR'";
		this.runtimeManager = runtimeManager;
		this.loader = loader;
	}
	
	@Override
	public void execute(ExecutionContext context) throws PlException, IOException{
		String query = "getJoin("+context.getCurrentResponsibility().getID()+",Join)."; 
		Hashtable result =  runtimeManager.getJavaLogEngine().executeQuery(query);
		PlAtom join = (PlAtom) result.get("Join");
		JoinNode joinNode = (JoinNode)loader.getResponsibilitiesNodeByID().get(join.toString());
		context.setResponsibilityToJoin(context.getCurrentResponsibility());
		context.setPreResponsibilityToJoin(context.getPreResponsibility());
		context.setPreResponsibility(joinNode);
		context.setEnabled(ExecutionContext.not_enabled_Step);
		runtimeManager.addExecutionStep(context);
		query = "assertRule(nextCommand("+context.getCurrentStep()+",'EVALUATE_POST_JOIN_OR')).";
		runtimeManager.getJavaLogEngine().executeQuery(query);
		query = "assertRule(evaluatingJoin("+joinNode.getID()+")).";
		runtimeManager.getJavaLogEngine().executeQuery(query);
		context.setStopStep("STOP");	
	}
	
	@Override
	public void putPrologSentence(ExecutionContext context) throws PlException, IOException{}
}


