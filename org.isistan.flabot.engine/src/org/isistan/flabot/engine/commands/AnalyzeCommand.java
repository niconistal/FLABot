/**
 * $Id: AnalyzeCommand.java,v 1.14 2006/04/12 03:40:29 apersson Exp $
 */

package org.isistan.flabot.engine.commands;

import java.io.IOException;
import java.util.Hashtable;

import org.isistan.flabot.coremodel.ForkNode;
import org.isistan.flabot.coremodel.JoinNode;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.engine.JavaLogEngine;
import org.isistan.flabot.engine.JavaRuntime;
import org.isistan.flabot.engine.Loader;
import org.isistan.flabot.executionmodel.ExecutionContext;

import JavaLog.PlAtom;
import JavaLog.PlAtomic;
import JavaLog.PlException;
import JavaLog.PlList;
import JavaLog.PlStructArgs;

/**
 * @author $Author: apersson $
 */

public class AnalyzeCommand extends Command{
	
	private JavaLogEngine javaLogEngine;
	private Loader loader;
	private JavaRuntime javaRuntime;

	public AnalyzeCommand(JavaLogEngine javaLogEngine, Loader loader,
			JavaRuntime javaRuntime) {
		this.name = "'ANALYZE'";
		this.javaLogEngine = javaLogEngine;
		this.loader = loader;
		this.javaRuntime = javaRuntime;
	}
	
	@Override
	public void execute(ExecutionContext context) throws PlException, IOException{
		String query = "chooseState(Result,"+context.getCurrentDependency()+",Dependency,Event,Rest).";
		Hashtable result =  javaLogEngine.executeQuery(query);
		PlStructArgs state = (PlStructArgs)result.get("Result");
		PlList rest = (PlList)result.get("Rest");
		Object event = (Object)result.get("Event");
		PlAtomic typeDependency = (PlAtomic)result.get("Dependency");
		context.setCurrentDependency(rest.toString());
		context.setCurrentState(state.toString());
		context.setEvent(event.toString());
		context.setCurrentTypeDependency(typeDependency.toString());
		if (context.getCurrentResponsibility() instanceof ForkNode){
			query = "analyzeResponsibilities(Result,"+context.getCurrentFamily()+",aForkComponent,aForkComponent,"+context.getCurrentState()+").";
		}
		else if (context.getCurrentResponsibility() instanceof StubNode){
			query = "analyzeResponsibilities(Result,"+context.getCurrentFamily()+",aStubComponent,aStubComponent,"+context.getCurrentState()+").";
		}
		else if (context.getCurrentResponsibility() instanceof JoinNode){
			if (context.getBranchJoin().containsKey(context.getCurrentStep())){
				String branch = (String)context.getBranchJoin().get(context.getCurrentStep());
				updateDependencies(branch,context);
			}
			query = "analyzeResponsibilities(Result,"+context.getCurrentFamily()+",aJoinComponent,aJoinComponent,"+context.getCurrentState()+").";
		}
		else
			query = "analyzeResponsibilities(Result,"+context.getCurrentFamily()+","+((ResponsibilityNode)context.getCurrentResponsibility()).getRole().getID()+","+((ResponsibilityNode)context.getCurrentResponsibility()).getRole().getID()+","+context.getCurrentState()+").";
		result =  javaLogEngine.executeQuery(query);
		PlAtomic value = (PlAtomic)result.get("Result");
		if (!value.toString().equals("-1")){
			query = "anlizedState("+context.getCurrentState()+","+context.getCurrentStep()+").";
			Hashtable existsState = (Hashtable)javaLogEngine.executeQuery(query);
			if (existsState==null){
				query = "assertRule(anlizedState("+context.getCurrentState()+","+context.getCurrentStep()+")).";
				javaLogEngine.executeQuery(query);
				query = "chooseAnalizeCommand ("+context.getCurrentStep()+","+context.getCurrentResponsibility().getID()+","+value.toString()+",Family,Result).";
				result =  javaLogEngine.executeQuery(query);
				PlAtom command = (PlAtom) result.get("Result");
				PlAtom family = (PlAtom) result.get("Family");
				if (!command.toString().equals("'NULL'")){
					 Command commandToExecute = (Command)javaRuntime.getCommands().get(command.toString());
					 context.setPreResponsibility((SimplePathNode)loader.getResponsibilitiesNodeByID().get(value.toString()));
					 context.setFamily(family.toString());
					 commandToExecute.execute(context);
				}
			}
		}
		putPrologSentence(context);
	}
	
	private void updateDependencies(String branch, ExecutionContext context) throws PlException {
		String query = "updateDependencies("+context.getCurrentDependency()+",Result,"+branch+").";
		PlList list = (PlList) javaLogEngine.executeQuery(query,"Result");
		if (!context.getCurrentDependency().equals("[]")){
			context.setCurrentDependency(list.toString());
			context.setDependencies(list.toString());
			query = "chooseState(Result,"+context.getCurrentDependency()+",Dependency,Event,Rest).";
			Hashtable result =  javaLogEngine.executeQuery(query);
			PlStructArgs state = (PlStructArgs)result.get("Result");
			PlList rest = (PlList)result.get("Rest");
			Object event = (Object)result.get("Event");
			PlAtomic typeDependency = (PlAtomic)result.get("Dependency");
			context.setCurrentDependency(rest.toString());
			context.setCurrentState(state.toString());
			context.setEvent(event.toString());
			context.setCurrentTypeDependency(typeDependency.toString());
		}
	}

	@Override
	public void putPrologSentence(ExecutionContext context) throws PlException, IOException{
		if (context.getCurrentDependency().equals("[]")){
			String query = "assertRule(analyzeCommand("+context.getCurrentStep()+","+context.getCurrentResponsibility().getID()+")).";
			javaLogEngine.executeQuery(query);
		}
	}
}
