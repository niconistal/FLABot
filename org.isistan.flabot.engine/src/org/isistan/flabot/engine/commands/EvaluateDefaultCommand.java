/**
 * $Id: EvaluateDefaultCommand.java,v 1.5 2006/03/16 21:12:38 apersson Exp $
 */

package org.isistan.flabot.engine.commands;

import java.io.IOException;

import org.isistan.flabot.engine.JavaLogEngine;
import org.isistan.flabot.executionmodel.ExecutionContext;

import JavaLog.PlException;
import JavaLog.PlList;

/**
 * @author $Author: apersson $
 */

public class EvaluateDefaultCommand extends Command{
	
	private JavaLogEngine javaLogEngine;

	public EvaluateDefaultCommand(JavaLogEngine javaLogEngine) {
		this.name = "'EVALUATE_DEFAULT'";
		this.javaLogEngine = javaLogEngine;
	}
	
	@Override
	public void execute(ExecutionContext context) throws PlException, IOException{
		String query = "evaluateDependencies("+context.getCurrentFamily()+","+context.getCurrentResponsibility().getID()+","+context.getCurrentResponsibility().getMap().getID()+","+context.getCurrentResponsibility().getMap().getID()+",Event,Result,"+context.getCurrentStep()+").";
        PlList result = (PlList)javaLogEngine.executeQuery(query,"Result");
        context.setCurrentDependency(result.toString());
		context.setDependencies(result.toString());
		putPrologSentence(context);
	}
	
	@Override
	public void putPrologSentence(ExecutionContext context) throws PlException, IOException{
		String query = "assertRule(evaluateCommand("+context.getCurrentStep()+","+context.getCurrentResponsibility().getID()+")).";
		javaLogEngine.executeQuery(query);
	}
}


