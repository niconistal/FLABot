/** * $Id: ExecutionStack.java,v 1.2 2006/03/24 00:33:59 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.gauge.instrumentation.runtime;

import java.util.Stack;public class ExecutionStack {
	private long nextId=0;
	private Stack<Long> stack=new Stack<Long>();
	
	public long peek() {
		return stack.peek().longValue();
	}
	
	public void push() {		stack.push(Long.valueOf(nextId++));
	}
	
	public void pop() {
		stack.pop();
	}
}
