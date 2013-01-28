/**
 * $Id: EvaluateCommand.java,v 1.9 2006/02/20 22:52:03 apersson Exp $
 */

package org.isistan.flabot.engine.commands;

import java.io.IOException;
import java.util.Hashtable;

import org.isistan.flabot.engine.JavaLogEngine;
import org.isistan.flabot.engine.JavaRuntime;
import org.isistan.flabot.executionmodel.ExecutionContext;

import JavaLog.PlAtom;
import JavaLog.PlException;

/**
 * @author $Author: apersson $
 */

public class EvaluateCommand extends Command{
	
	private JavaLogEngine javaLogEngine;
	private JavaRuntime javaRuntime;

	public EvaluateCommand(JavaLogEngine javaLogEngine, JavaRuntime javaRuntime) {
		this.name = "'EVALUATE'";
		this.javaLogEngine = javaLogEngine;
		this.javaRuntime = javaRuntime;
	}
	
	@Override
	public void execute(ExecutionContext context) throws PlException, IOException{		
		String query = "chooseEvaluateCommand("+context.getCurrentStep()+","+context.getCurrentResponsibility().getID()+",Result)."; 
		Hashtable result =  javaLogEngine.executeQuery(query);
		PlAtom command = (PlAtom) result.get("Result");
		if (!command.toString().equals("'NULL'")){
		 Command commandToExecute = (Command)javaRuntime.getCommands().get(command.toString());
		 commandToExecute.execute(context);
		}
	}
	
	@Override
	public void putPrologSentence(ExecutionContext context) throws PlException, IOException{
		String query = "assertRule(evaluateCommand("+context.getCurrentStep()+","+context.getCurrentResponsibility().getID()+")).";
		javaLogEngine.executeQuery(query);
	}
}
