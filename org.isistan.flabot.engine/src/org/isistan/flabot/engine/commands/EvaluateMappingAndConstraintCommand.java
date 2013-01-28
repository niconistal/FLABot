/**
 * $Id: EvaluateMappingAndConstraintCommand.java,v 1.1 2006/04/12 21:09:46 apersson Exp $
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

public class EvaluateMappingAndConstraintCommand extends Command{
	
	private JavaLogEngine javaLogEngine;

	public EvaluateMappingAndConstraintCommand(JavaLogEngine javaLogEngine) {
		this.name = "'EVALUATE_MAPPING_AND_CONSTRAINT'";
		this.javaLogEngine = javaLogEngine;
	}
	
	@Override
	public void execute(ExecutionContext context) throws PlException, IOException{
		String query = "especialEvaluateDependencies("+context.getCurrentFamily()+","+context.getCurrentResponsibility().getID()+","+context.getCurrentResponsibility().getMap().getID()+","+context.getCurrentResponsibility().getMap().getID()+",Event,Result,"+context.getCurrentStep()+").";
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


