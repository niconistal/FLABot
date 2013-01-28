/** * $Id: JConstructor.java,v 1.3 2006/03/24 00:33:55 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;

import java.lang.reflect.InvocationTargetException;/**
 * <code>Constructor</code> provides information about, and access to, a single
 * constructor for a class.
 *
 *
 * @see java.lang.reflect.Member
 * @see java.lang.Class
 * @see java.lang.Class#getConstructors()
 * @see java.lang.Class#getConstructor(Class[])
 * @see java.lang.Class#getDeclaredConstructors()
 *
 * @author $Author: dacostae $
 */
public interface JConstructor extends
			JObject,
			JBehavior {


 
    public static final String BEHAVIOR_NAME = "<init>";

	/**
     * Uses the constructor represented by this <code>Constructor</code> object to
     * create and initialize a new instance of the constructor's
     * declaring class, with the specified initialization parameters.
     * Individual parameters are automatically unwrapped to match
     * primitive formal parameters, and both primitive and reference
     * parameters are subject to method invocation conversions as necessary.
     *
     * <p>If the number of formal parameters required by the underlying constructor
     * is 0, the supplied <code>initargs</code> array may be of length 0 or null.
     *
     * <p>If the required access and argument checks succeed and the
     * instantiation will proceed, the constructor's declaring class
     * is initialized if it has not already been initialized.
     *
     * <p>If the constructor completes normally, returns the newly
     * created and initialized instance.
     *
     * @param initargs array of objects to be passed as arguments to
     * the constructor call; values of primitive types are wrapped in
     * a wrapper object of the appropriate type (e.g. a <tt>float</tt>
     * in a {@link java.lang.Float Float})
     *
     * @return a new object created by calling the constructor
     * this object represents
     */
    public JObject newInstance(JArray<? extends JObject> initargs);

}
