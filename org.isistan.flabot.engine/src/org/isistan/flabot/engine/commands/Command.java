/**
 * $Id: Command.java,v 1.8 2006/02/21 00:46:48 franco Exp $
 */

package org.isistan.flabot.engine.commands;

import java.io.IOException;

import org.isistan.flabot.executionmodel.ExecutionContext;

import JavaLog.PlException;


/**
 * @author $Author: franco $
 */

public abstract class Command{
	
	protected String name;
	protected ExecutionContext context;
	
	public abstract void execute(ExecutionContext context) throws PlException, IOException;
	
	public abstract void putPrologSentence(ExecutionContext context) throws PlException, IOException;
	
	public String getNameCommand (){
		return name;
	}
	
	public void setExecutionContext(ExecutionContext context){
		this.context = context;
	}
}
