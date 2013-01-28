/**
 * 
 */
package org.isistan.flabot.instrumentation.classloader;



/**
 * @author $Author: dacostae $
 */
public abstract class Instrumentor {
	
	/**
	 * Instruments the class with the desired characteristics
	 * @param loader the classloader that loaded the class
	 * @param className the name of the loaded class
	 * @param bytecode the bytecodes of the class
	 * @return the instrumented bytecodes or null if no modification desired
	 * @throws InstrumentationException
	 */
	public abstract byte[] instrument(ClassLoader loader, String className, byte[] bytecode) throws InstrumentationException;
}
