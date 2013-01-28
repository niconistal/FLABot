/**
 * $Id: JavaRuntime.java,v 1.17 2006/04/12 21:09:46 apersson Exp $
 */

package org.isistan.flabot.engine;
 
import java.io.IOException;
import java.util.Hashtable;

import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.engine.commands.AnalyzeCommand;
import org.isistan.flabot.engine.commands.AnalyzeConstraintCommand;
import org.isistan.flabot.engine.commands.AnalyzeDefaultCommand;
import org.isistan.flabot.engine.commands.AnalyzeMappingCommand;
import org.isistan.flabot.engine.commands.AnalyzePostConstraintCommand;
import org.isistan.flabot.engine.commands.AnalyzePostDefaultCommand;
import org.isistan.flabot.engine.commands.AnalyzePostMappingCommand;
import org.isistan.flabot.engine.commands.Command;
import org.isistan.flabot.engine.commands.EvaluateAndJoinCommand;
import org.isistan.flabot.engine.commands.EvaluateCommand;
import org.isistan.flabot.engine.commands.EvaluateDefaultCommand;
import org.isistan.flabot.engine.commands.EvaluateOrJoinCommand;
import org.isistan.flabot.engine.commands.EvaluatePostAndJoinCommand;
import org.isistan.flabot.engine.commands.EvaluatePostMappingStubCommand;
import org.isistan.flabot.engine.commands.EvaluatePostOrJoinCommand;
import org.isistan.flabot.engine.commands.EvaluatePostStubCommand;
import org.isistan.flabot.engine.commands.EvaluateMappingAndConstraintCommand;
import org.isistan.flabot.engine.commands.EvaluateStubCommand;
import org.isistan.flabot.engine.commands.SituationCommand;
import org.isistan.flabot.executionmodel.ExecutionContext;

import JavaLog.PlAtom;
import JavaLog.PlException;

/**
 * @author $Author: apersson $
 */

public class JavaRuntime {
	
	private ExecutionContext context;
	private JavaLogEngine javaLogEngine;
	private RuntimeManager runtimeManager;
	private Loader loader; 
	private Hashtable commands;
	public boolean stopStep = false;
	private Command currentCommand;
	
	public JavaRuntime (SimplePathNode responsibility, int step,
			ExecutionContext currentContext, JavaLogEngine javaLogEngine,
			RuntimeManager runtimeManager, Loader loader){
		this.javaLogEngine = javaLogEngine;
		this.runtimeManager = runtimeManager;
		this.loader = loader;
		context = currentContext;
		context.setCurrentResponsibility(responsibility);
		context.setCurrentStep(String.valueOf(step));
		commands = new Hashtable();
		loadCommands();
	}
	
	public JavaRuntime (SimplePathNode responsibility, int step,
			String Family, ExecutionContext currentContext,
			JavaLogEngine javaLogEngine, RuntimeManager runtimeManager,
			Loader loader){
		this.javaLogEngine = javaLogEngine;
		this.runtimeManager = runtimeManager;
		this.loader = loader;
		context = currentContext;
		context.setCurrentResponsibility(responsibility);
		context.setCurrentStep(String.valueOf(step));
		commands = new Hashtable();
		loadCommands();
	}

	public void run () throws PlException, IOException{
	   currentCommand = chooseFirstCommand();
	   while (currentCommand != null && !stopStep && context.getStopStep().equals("RUN")){
		   currentCommand.setExecutionContext(this.context);
		   currentCommand.execute(this.context);
		   currentCommand = chooseCommand();
	   }
	}
	
	private Command chooseCommand() throws PlException, IOException{
		String query = "chooseCommand("+context.getCurrentStep()+","+context.getCurrentResponsibility().getID()+","+context.getCurrentDependency()+",Result).";
		PlAtom command = (PlAtom) javaLogEngine.executeQuery(query,"Result");
		if (!command.toString().equals("'NULL'"))
		 return (Command)commands.get(command.toString());
	    return null;
	}
	
	private Command chooseFirstCommand() throws PlException, IOException{
		String query = "chooseFirstCommand("+context.getCurrentStep()+","+context.getCurrentResponsibility().getID()+","+context.getCurrentDependency()+",Result).";
		PlAtom command = (PlAtom) javaLogEngine.executeQuery(query,"Result");
		if (!command.toString().equals("'NULL'"))
		 return (Command)commands.get(command.toString());
	    return null;
	}
	
	public Hashtable getCommands(){
		return commands;
	}
	
	private void loadCommands(){
		Command analyzeCommand = new AnalyzeCommand(javaLogEngine, loader, this);
		commands.put(analyzeCommand.getNameCommand(),analyzeCommand);
		Command evaluateCommand = new EvaluateCommand(javaLogEngine,this);
		commands.put(evaluateCommand.getNameCommand(),evaluateCommand);
		Command situationCommand = new SituationCommand(javaLogEngine);
		commands.put(situationCommand.getNameCommand(),situationCommand);
		Command analyzeMappingCommand =  new AnalyzeMappingCommand(runtimeManager);
		commands.put(analyzeMappingCommand.getNameCommand(),analyzeMappingCommand);
		Command analyzeConstraintCommand =  new AnalyzeConstraintCommand(javaLogEngine, runtimeManager);
		commands.put(analyzeConstraintCommand.getNameCommand(),analyzeConstraintCommand);
		Command analyzeDefaultCommand =  new AnalyzeDefaultCommand(runtimeManager);
		commands.put(analyzeDefaultCommand.getNameCommand(),analyzeDefaultCommand);
		Command evaluateDefaultCommand =  new EvaluateDefaultCommand(javaLogEngine);
		commands.put(evaluateDefaultCommand.getNameCommand(),evaluateDefaultCommand);
		Command evaluateStubCommand =  new EvaluateStubCommand(javaLogEngine,loader,runtimeManager);
		commands.put(evaluateStubCommand.getNameCommand(),evaluateStubCommand);		
		Command analyzePostConstraintCommand =  new AnalyzePostConstraintCommand(runtimeManager);
		commands.put(analyzePostConstraintCommand.getNameCommand(),analyzePostConstraintCommand);
		Command analyzePostDefaultCommand =  new AnalyzePostDefaultCommand(runtimeManager);
		commands.put(analyzePostDefaultCommand.getNameCommand(),analyzePostDefaultCommand);
		Command analyzePostMappingCommand =  new AnalyzePostMappingCommand(runtimeManager);
		commands.put(analyzePostMappingCommand.getNameCommand(),analyzePostMappingCommand);
		Command evaluatePostStubCommand =  new EvaluatePostStubCommand(runtimeManager);
		commands.put(evaluatePostStubCommand.getNameCommand(),evaluatePostStubCommand);
		Command evaluatePostMappingStubCommand =  new EvaluatePostMappingStubCommand(runtimeManager);
		commands.put(evaluatePostMappingStubCommand.getNameCommand(),evaluatePostMappingStubCommand);
		Command evaluateAndoJoinCommand =  new EvaluateAndJoinCommand(runtimeManager,loader);
		commands.put(evaluateAndoJoinCommand.getNameCommand(),evaluateAndoJoinCommand);	
		Command evaluatePostAndJoinCommand =  new EvaluatePostAndJoinCommand(runtimeManager);
		commands.put(evaluatePostAndJoinCommand.getNameCommand(),evaluatePostAndJoinCommand);		
		Command evaluateOrJoinCommand =  new EvaluateOrJoinCommand(runtimeManager,loader);
		commands.put(evaluateOrJoinCommand.getNameCommand(),evaluateOrJoinCommand);
		Command evaluatePostOrJoinCommand =  new EvaluatePostOrJoinCommand(runtimeManager);
		commands.put(evaluatePostOrJoinCommand.getNameCommand(),evaluatePostOrJoinCommand);	
		Command evaluatePreconditionAndConstraintCommand =  new EvaluateMappingAndConstraintCommand(javaLogEngine);
		commands.put(evaluatePreconditionAndConstraintCommand.getNameCommand(),evaluatePreconditionAndConstraintCommand);
	}
	
	public ExecutionContext getExecutionContext(){
		return context;
	}
	
	public void stopStep(){
		stopStep = true;
	}
	
	public boolean acceptStepByStep() throws PlException {
		String query = "evaluateCommand("+context.getCurrentStep()+","+context.getCurrentResponsibility().getID()+").";
		Hashtable command = (Hashtable) javaLogEngine.executeQuery(query);
		if (command!=null){
			return false;
		}
		return true;
	}


}

