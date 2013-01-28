/** * $Id: DefaultInitializer.java,v 1.1 2006/01/27 22:58:15 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.instrumentation.launcher;


public class DefaultInitializer implements Initializer {
	private String mainClassName;
	private String[] arguments;
	
	public void start(String[] arguments) {
		mainClassName=arguments[0];
		
		this.arguments=new String[arguments.length-1];
		for (int i = 0; i < this.arguments.length; i++) {
			this.arguments[i]=arguments[i+1];
		}
	}

	public String getMainClassName() {
		return mainClassName;
	}

	public String[] getArguments() {
		return arguments;
	}

	public void finish() {
	}

}
