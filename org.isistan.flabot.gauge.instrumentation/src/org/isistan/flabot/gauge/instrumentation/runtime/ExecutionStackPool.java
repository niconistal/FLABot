/**

import java.util.HashMap;
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