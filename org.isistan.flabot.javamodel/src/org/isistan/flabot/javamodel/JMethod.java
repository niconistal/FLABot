/** * $Id: JMethod.java,v 1.4 2006/03/24 00:33:55 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;

import java.lang.reflect.GenericSignatureFormatError;import java.lang.reflect.InvocationTargetException;import java.lang.reflect.MalformedParameterizedTypeException;
/**
 * A <code>Method</code> provides information about, and access to, a single method
 * on a class or interface.  The reflected method may be a class method
 * or an instance method (including an abstract method).
 *
 * <p>A <code>Method</code> permits widening conversions to occur when matching the
 * actual parameters to invoke with the underlying method's formal
 * parameters, but it throws an <code>IllegalArgumentException</code> if a
 * narrowing conversion would occur.
 *
 * @see JMember
 * @see java.lang.Class
 * @see java.lang.Class#getMethods()
 * @see java.lang.Class#getMethod(String, Class[])
 * @see java.lang.Class#getDeclaredMethods()
 * @see java.lang.Class#getDeclaredMethod(String, Class[])
 *
 * @author $Author: dacostae $
 */
public interface JMethod extends 
		JObject, 
		JBehavior {    

    /**
     * Returns a <tt>Type</tt> object that represents the formal return 
     * type of the method represented by this <tt>Method</tt> object.
     * 
     * <p>If the return type is a parameterized type,
     * the <tt>Type</tt> object returned must accurately reflect
     * the actual type parameters used in the source code.
     * 
     * <p>If the return type is a type variable or a parameterized type, it
     * is created. Otherwise, it is resolved.
     * @since 1.5
     */
    public JType getGenericReturnType();


    /**
     * Invokes the underlying method represented by this <code>Method</code> 
     * object, on the specified object with the specified parameters.
     * Individual parameters are automatically unwrapped to match
     * primitive formal parameters, and both primitive and reference
     * parameters are subject to method invocation conversions as
     * necessary.
     *
     * <p>If the underlying method is static, then the specified <code>obj</code> 
     * argument is ignored. It may be null.
     *
     * <p>If the number of formal parameters required by the underlying method is
     * 0, the supplied <code>args</code> array may be of length 0 or null.
     *
     * <p>If the underlying method is an instance method, it is invoked
     * using dynamic method lookup as documented in The Java Language
     * Specification, Second Edition, section 15.12.4.4; in particular,
     * overriding based on the runtime type of the target object will occur.
     *
     * <p>If the underlying method is static, the class that declared
     * the method is initialized if it has not already been initialized.
     *
     * <p>If the method completes normally, the value it returns is
     * returned to the caller of invoke; if the value has a primitive
     * type, it is first appropriately wrapped in an object. However,
     * if the value has the type of an array of a primitive type, the
     * elements of the array are <i>not</i> wrapped in objects; in
     * other words, an array of primitive type is returned.  If the
     * underlying method return type is void, the invocation returns
     * null.
     *
     * @param obj  the object the underlying method is invoked from
     * @param args the arguments used for the method call
     * @return the result of dispatching the method represented by
     * this object on <code>obj</code> with parameters
     * <code>args</code>
     */
    public JObject invoke(JObject obj, JArray<? extends JObject> args);

    /**
     * Returns <tt>true</tt> if this method is a bridge
     * method; returns <tt>false</tt> otherwise.
     *
     * @return true if and only if this method is a bridge
     * method as defined by the Java Language Specification.
     * @since 1.5
     */
    public boolean isBridge();


    /**
     * Returns the default value for the annotation member represented by
     * this <tt>Method</tt> instance.  If the member is of a primitive type,
     * an instance of the corresponding wrapper type is returned. Returns
     * null if no default is associated with the member, or if the method
     * instance does not represent a declared member of an annotation type.
     *
     * @return the default value for the annotation member represented
     *     by this <tt>Method</tt> instance.
     * @throws TypeNotPresentException if the annotation is of type
     *     {@link Class} and no definition can be found for the
     *     default class value.
     * @since  1.5
     */
    public JObject getDefaultValue();
   
}
