/** * $Id: Initializer.java,v 1.1 2006/01/27 22:58:15 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.instrumentation.launcher;


/**
 * Used to produce data the launcher needs
 * @author $Author: dacostae $
 *
 */
public interface Initializer {
	/**
	 * Called when the launcher is started
	 * @param arguments
	 */
	public void start(String[] arguments) throws Throwable;
	
	/**
	 * Returns main class name
	 * @return
	 */
	public String getMainClassName() throws Throwable;
	
	/**
	 * Returns the arguments that should be passed to the main
	 * @return
	 */
	public String[] getArguments() throws Throwable;
	
	/**
	 * Called when the launcher ends (the application may still be
	 * runnig in another thread)
	 *
	 */
	public void finish() throws Throwable;
}
