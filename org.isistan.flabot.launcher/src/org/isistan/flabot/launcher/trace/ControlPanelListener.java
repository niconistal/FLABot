package org.isistan.flabot.launcher.trace;

/**
 * This interface should be implemented by TraceLogHandler users
 * to manage the collection control panel.
 * @author usuario
 *
 */
public interface ControlPanelListener {
	/**
	 * Called when the start button is presed.
	 * @return false if could not start, true otherwise.
	 */
	boolean start();
	
	/**
	 * Called when the pause button is presed.
	 * @return false if could not pause, true otherwise.
	 */
	boolean pause();
	
	/**
	 * Called when the stop button is presed.
	 * @return false if could not stop, true otherwise.
	 */
	boolean save();
	
	/**
	 * Called when the reset button is presed
	 * @return false if could not reset, true otherwise.
	 */
	boolean reset();
}
