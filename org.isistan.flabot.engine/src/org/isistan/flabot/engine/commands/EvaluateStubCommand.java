/**
 * $Id: EvaluateStubCommand.java,v 1.19 2006/03/31 03:28:03 apersson Exp $
 */

package org.isistan.flabot.engine.commands;

import java.io.IOException;
import java.util.Hashtable;

import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.engine.JavaLogEngine;
import org.isistan.flabot.engine.Loader;
import org.isistan.flabot.engine.RuntimeManager;
import org.isistan.flabot.executionmodel.ExecutionContext;

import JavaLog.PlAtom;
import JavaLog.PlException;
import JavaLog.PlList;

/**
 * @author $Author: apersson $
 */

public class EvaluateStubCommand extends Command{
	
	private JavaLogEngine javaLogEngine;
	private RuntimeManager runtimeManager;
	private Loader loader;
	
	public EvaluateStubCommand(JavaLogEngine javaLogEngine, Loader loader,
			RuntimeManager runtimeManager) {
		this.name = "'EVALUATE_STUB'";
		this.javaLogEngine = javaLogEngine;
		this.runtimeManager = runtimeManager;
		this.loader = loader;
	}
	
	@Override
	public void execute(ExecutionContext context) throws PlException, IOException{
		boolean existsFamily = false;
		String query = "getStub("+context.getCurrentResponsibility().getID()+",Stub)."; 
		Hashtable result =  javaLogEngine.executeQuery(query);
		PlAtom stub = (PlAtom) result.get("Stub");
		StubNode stubNode = (StubNode)loader.getResponsibilitiesNodeByID().get(stub.toString());
		SimplePathNode endResp = Loader.getPrevious(stubNode.getEndPointReference());
		SimplePathNode startResp = Loader.getNext(stubNode.getStartPointReference());
		context.setStubNode(stubNode);
		context.setStartNodeToStub(startResp);
		context.setEndNodeToStub(endResp);
		query = "getFamilyToStub("+stubNode.getID()+","+endResp.getID()+",Family).";
		Object family = javaLogEngine.executeQuery(query,"Family");
		if (family!=null){
			context.setFamily(family.toString());
	    	String lastFamily = context.getCurrentFamily();
			context.setCurrentFamily(context.getFamily());
			query = "existsCurrentFamily(Family).";
			family = (PlAtom)runtimeManager.getJavaLogEngine().executeQuery(query,"Family");
			if (family==null){
				query = "assertRule(currentFamily("+context.getFamily()+")).";
				runtimeManager.getJavaLogEngine().executeQuery(query,"Family");
			}
			context.setLastMappingFamily(lastFamily);
			if (family!=null){
				context.setMappingFamily(family.toString());
			}
			existsFamily = true;
		}
		query = "runnedOK("+context.getCurrentResponsibility().getID()+","+endResp.getID()+",Component,"+context.getEvent()+","+context.getCurrentFamily()+","+endResp.getMap().getID()+","+endResp.getMap().getID()+",ExecutionInfo,"+context.getCurrentStep()+",Condition).";
		javaLogEngine.executeQuery(query);
		query = "responsibilityLog("+endResp.getID()+",Instance,Component,Event,Scenario,ExecutionInfo,"+context.getCurrentStep()+").";
		result =  javaLogEngine.executeQuery(query);
        Object stateFirstNode = (Object) result.get("ExecutionInfo");
		if (!stateFirstNode.toString().equals("'Executed'")){
				javaLogEngine.changeLogicModule(RuntimeManager.LogicModuleStub);
				context.setCurrentLogicModule(RuntimeManager.LogicModuleStub);
				SimplePathNode node = context.getCurrentResponsibility();
				SimplePathNode previousnode = context.getPreResponsibility();
				context.setResponsibilityToStub(node);
				context.setPreResponsibilityToStub(previousnode);
				context.setCurrentResponsibility(stubNode);
				context.setPreResponsibility(endResp);
				if (existsFamily){
					query = "assertRule(nextCommand("+context.getCurrentStep()+",'EVALUATE_POST_MAPPING_STUB')).";
			    }else{
			    	query = "assertRule(nextCommand("+context.getCurrentStep()+",'EVALUATE_POST_STUB')).";
			    }
				context.setCurrentTypeDependency(Condition.previous);
				runtimeManager.addExecutionStep(context);
			    runtimeManager.getJavaLogEngine().executeQuery(query);
			    context.setStopStep("STOP");
			    }
		else{	
				query = "getInstance("+endResp.getID()+","+context.getCurrentFamily()+",Instance).";
				Object instance = javaLogEngine.executeQuery(query,"Instance");
				query = "assertRule(faultyComponent("+endResp.getID()+","+instance.toString()+",state(Family,'Executed',current))).";
				javaLogEngine.executeQuery(query);
				query = "situationForStub("+stubNode.getID()+","+startResp.getID()+","+endResp.getID()+",Result,"+context.getCurrentFamily()+").";
				javaLogEngine.executeQuery(query);
				query = "evaluateDependencies("+context.getCurrentFamily()+","+context.getCurrentResponsibility().getID()+","+context.getCurrentResponsibility().getMap().getID()+","+context.getCurrentResponsibility().getMap().getID()+",Event,Result,"+context.getCurrentStep()+").";
		        PlList resultFinal = (PlList)javaLogEngine.executeQuery(query,"Result");
		        context.setCurrentDependency(resultFinal.toString());
				context.setDependencies(resultFinal.toString());
		}
		 
				
	}
	
	@Override
	public void putPrologSentence(ExecutionContext context) throws PlException, IOException{}
}


