/** * $Id: InstrumentationException.java,v 1.2 2006/02/03 21:03:10 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.instrumentation.classloader;

public class InstrumentationException extends Exception {
	private static final long serialVersionUID = 1L;

	public InstrumentationException(String message, Exception exception) {
		super(message, exception);
	}
	
	@Override	public String toString() {
		return "Error while instrumenting: [" + getCause().getClass().getName() + "] " + getMessage();
	}
}
