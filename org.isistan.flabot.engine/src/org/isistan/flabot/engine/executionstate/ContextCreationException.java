package org.isistan.flabot.engine.executionstate;

public class ContextCreationException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ContextCreationException(String message) {
		super(message);
	}
	
	public String toString() {
		return this.getClass().getName() + ": " + getMessage();
	}
}
