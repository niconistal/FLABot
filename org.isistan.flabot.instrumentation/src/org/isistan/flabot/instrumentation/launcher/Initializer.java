/**


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