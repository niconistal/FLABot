/**

import java.util.Stack;
	private long nextId=0;
	private Stack<Long> stack=new Stack<Long>();
	
	public long peek() {
		return stack.peek().longValue();
	}
	
	public void push() {
	}
	
	public void pop() {
		stack.pop();
	}
}