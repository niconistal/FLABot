/** * $Id: ExecutionStackPool.java,v 1.1 2006/03/01 20:27:28 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.gauge.instrumentation.runtime;

import java.util.HashMap;import java.util.Map;public class ExecutionStackPool {
	private static Map<Thread, ExecutionStack> executionStacks=new HashMap<Thread, ExecutionStack>();
	
	public static ExecutionStack getExecutionStack() {
		ExecutionStack executionStack=executionStacks.get(Thread.currentThread());
		if(executionStack==null) {
			executionStack=new ExecutionStack();
			executionStacks.put(Thread.currentThread(), executionStack);
		}
		return executionStack;
	}
}
