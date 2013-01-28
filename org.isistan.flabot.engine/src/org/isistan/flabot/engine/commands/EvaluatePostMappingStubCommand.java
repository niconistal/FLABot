/**
 * $Id: EvaluatePostMappingStubCommand.java,v 1.3 2006/03/31 03:28:03 apersson Exp $
 */

package org.isistan.flabot.engine.commands;

import java.io.IOException;

import org.isistan.flabot.engine.RuntimeManager;
import org.isistan.flabot.executionmodel.ExecutionContext;

import JavaLog.PlException;
import JavaLog.PlList;

/**
 * @author $Author: apersson $
 */

public class EvaluatePostMappingStubCommand extends Command{
	
	private RuntimeManager runtimeManager;

	public EvaluatePostMappingStubCommand(RuntimeManager runtimeManager) {
		this.name = "'EVALUATE_POST_MAPPING_STUB'";
		this.runtimeManager = runtimeManager;
	}
	
	@Override
	public void execute(ExecutionContext context) throws PlException, IOException{
		context.setCurrentResponsibility(context.getResponsibilityToStub());
		context.setPreResponsibility(context.getPreResponsibilityToStub());
		runtimeManager.getJavaLogEngine().changeLogicModule(RuntimeManager.LogicModuleGeneral);
		context.setCurrentLogicModule(RuntimeManager.LogicModuleGeneral);
		String query = "situationForStub("+context.getStubNode().getID()+","+context.getStartNodeToStub().getID()+","+context.getEndNodeToStub().getID()+",Result,"+context.getCurrentFamily()+").";
		runtimeManager.getJavaLogEngine().executeQuery(query);
		context.setCurrentFamily(context.getLastMappingFamily());
		if (context.getMappingFamily()==null){
			query = "retractRule(currentFamily("+context.getFamily()+")).";
			runtimeManager.getJavaLogEngine().executeQuery(query);
		}
		query = "evaluateDependencies("+context.getCurrentFamily()+","+context.getCurrentResponsibility().getID()+","+context.getCurrentResponsibility().getMap().getID()+","+context.getCurrentResponsibility().getMap().getID()+",Event,Result,"+context.getCurrentStep()+").";
        PlList resultFinal = (PlList)runtimeManager.getJavaLogEngine().executeQuery(query,"Result");
        context.setCurrentDependency(resultFinal.toString());
		context.setDependencies(resultFinal.toString());
		putPrologSentence(context);
	}
	
	@Override
	public void putPrologSentence(ExecutionContext context) throws PlException, IOException{
		String query = "assertRule(evaluateCommand("+context.getCurrentStep()+","+context.getCurrentResponsibility().getID()+")).";
		runtimeManager.getJavaLogEngine().executeQuery(query);
	}
	
}

