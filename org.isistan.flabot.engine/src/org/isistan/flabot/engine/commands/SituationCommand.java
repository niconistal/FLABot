/**
 * $Id: SituationCommand.java,v 1.7 2006/03/29 02:09:45 apersson Exp $
 */

package org.isistan.flabot.engine.commands;

import java.io.IOException;

import org.isistan.flabot.engine.JavaLogEngine;
import org.isistan.flabot.executionmodel.ExecutionContext;

import JavaLog.PlException;

/**
 * @author $Author: apersson $
 */

public class SituationCommand extends Command{
	
	private JavaLogEngine javaLogEngine;

	public SituationCommand(JavaLogEngine javaLogEngine) {
		this.name = "'SITUATION'";
		this.javaLogEngine = javaLogEngine;
	}
	
	@Override
	public void execute(ExecutionContext context) throws PlException, IOException{
		String query = "situationCommand ("+context.getCurrentResponsibility().getID()+","+context.getDependencies()+",Result,"+context.getCurrentFamily()+").";
		javaLogEngine.executeQuery(query);
		query = "retractRule(anlizedState(X,"+context.getCurrentStep()+")).";
		javaLogEngine.executeQuery(query);
		putPrologSentence(context);
		if (context.getBranchJoin().containsKey(context.getCurrentStep()))
			context.getBranchJoin().remove(context.getCurrentStep());
	}
	
	@Override
	public void putPrologSentence(ExecutionContext context) throws PlException, IOException{
			String query = "assertRule(situationCommand("+context.getCurrentStep()+","+context.getCurrentResponsibility().getID()+")).";
			javaLogEngine.executeQuery(query);
		
	}
}
