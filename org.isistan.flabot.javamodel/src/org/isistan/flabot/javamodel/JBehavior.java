/** * $Id: JBehavior.java,v 1.4 2006/02/16 17:58:22 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;

import java.lang.reflect.GenericSignatureFormatError;import java.lang.reflect.MalformedParameterizedTypeException;/**
 * General type for JConstructor and JMethod
 */
public interface JBehavior extends
			JObject,
			JAccessibleObject,
			JGenericDeclaration, 
		    JMember {	
    /**
     * Returns an array of <code>Class</code> objects that represent the formal
     * parameter types, in declaration order, of the constructor
     * represented by this <code>Constructor</code> object.  Returns an array of
     * length 0 if the underlying constructor takes no parameters.
     *
     * @return the parameter types for the constructor this object
     * represents
     */
    public JArray<? extends JClass> getParameterTypes();


    /**
     * Returns an array of <tt>Type</tt> objects that represent the formal
     * parameter types, in declaration order, of the method represented by
     * this <tt>Constructor</tt> object. Returns an array of length 0 if the
     * underlying method takes no parameters.
     * 
     * <p>If a formal parameter type is a parameterized type,
     * the <tt>Type</tt> object returned for it must accurately reflect
     * the actual type parameters used in the source code.
     *
     * <p>If a formal parameter type is a type variable or a parameterized 
     * type, it is created. Otherwise, it is resolved.
     *
     * @return an array of <tt>Type</tt>s that represent the formal
     *     parameter types of the underlying method, in declaration order
     * @throws GenericSignatureFormatError
     *     if the generic method signature does not conform to the format
     *     specified in the Java Virtual Machine Specification, 3rd edition
     * @throws TypeNotPresentException if any of the parameter
     *     types of the underlying method refers to a non-existent type
     *     declaration
     * @throws MalformedParameterizedTypeException if any of
     *     the underlying method's parameter types refer to a parameterized
     *     type that cannot be instantiated for any reason
     * @since 1.5
     */
    public JArray<? extends JType> getGenericParameterTypes();
    
    /**
     * Returns an array of <code>Class</code> objects that represent the types
     * of exceptions declared to be thrown by the underlying constructor
     * represented by this <code>Constructor</code> object.  Returns an array of
     * length 0 if the constructor declares no exceptions in its <code>throws</code> clause.
     *
     * @return the exception types declared as being thrown by the
     * constructor this object represents
     */
    public JArray<? extends JClass> getExceptionTypes();


    /**
     * Returns an array of <tt>Type</tt> objects that represent the 
     * exceptions declared to be thrown by this <tt>Constructor</tt> object. 
     * Returns an array of length 0 if the underlying method declares
     * no exceptions in its <tt>throws</tt> clause.  
     * 
     * <p>If an exception type is a parameterized type, the <tt>Type</tt>
     * object returned for it must accurately reflect the actual type
     * parameters used in the source code.
     *
     * <p>If an exception type is a type variable or a parameterized 
     * type, it is created. Otherwise, it is resolved.
     *
     * @return an array of Types that represent the exception types
     *     thrown by the underlying method
     * @throws GenericSignatureFormatError
     *     if the generic method signature does not conform to the format
     *     specified in the Java Virtual Machine Specification, 3rd edition
     * @throws TypeNotPresentException if the underlying method's
     *     <tt>throws</tt> clause refers to a non-existent type declaration
     * @throws MalformedParameterizedTypeException if
     *     the underlying method's <tt>throws</tt> clause refers to a
     *     parameterized type that cannot be instantiated for any reason
     * @since 1.5
     */
    public JArray<? extends JType> getGenericExceptionTypes();
      
	/**
	 * Returns a string describing this <code>Constructor</code>.  The string is
	 * formatted as the constructor access modifiers, if any,
	 * followed by the fully-qualified name of the declaring class,
	 * followed by a parenthesized, comma-separated list of the
	 * constructor's formal parameter types.  For example:
	 * <pre>
	 *    public java.util.Hashtable(int,float)
	 * </pre>
	 *
	 * <p>The only possible modifiers for constructors are the access
	 * modifiers <tt>public</tt>, <tt>protected</tt> or
	 * <tt>private</tt>.  Only one of these may appear, or none if the
	 * constructor has default (package) access.
	 */
    public String toString();
    
    /**
     * Returns a string describing this <code>Constructor</code>,
     * including type parameters.  The string is formatted as the
     * constructor access modifiers, if any, followed by an
     * angle-bracketed comma separated list of the constructor's type
     * parameters, if any, followed by the fully-qualified name of the
     * declaring class, followed by a parenthesized, comma-separated
     * list of the constructor's generic formal parameter types.  A
     * space is used to separate access modifiers from one another and
     * from the type parameters or return type.  If there are no type
     * parameters, the type parameter list is elided; if the type
     * parameter list is present, a space separates the list from the
     * class name.  If the constructor is declared to throw
     * exceptions, the parameter list is followed by a space, followed
     * by the word &quot;<tt>throws</tt>&quot; followed by a
     * comma-separated list of the thrown exception types.
     *
     * <p>The only possible modifiers for constructors are the access
     * modifiers <tt>public</tt>, <tt>protected</tt> or
     * <tt>private</tt>.  Only one of these may appear, or none if the
     * constructor has default (package) access.
     *
     * @return a string describing this <code>Constructor</code>,
     * include type parameters
     *
     * @since 1.5
     */
    public String toGenericString();
    
    /**
     * Returns <tt>true</tt> if this method was declared to take
     * a variable number of arguments; returns <tt>false</tt>
     * otherwise.
     *
     * @return <tt>true</tt> if an only if this method was declared to
     * take a variable number of arguments.
     * @since 1.5
     */
    public boolean isVarArgs();
    
    /**
     * Returns an array of arrays that represent the annotations on the formal
     * parameters, in declaration order, of the method represented by
     * this <tt>Method</tt> object. (Returns an array of length zero if the
     * underlying method is parameterless.  If the method has one or more
     * parameters, a nested array of length zero is returned for each parameter
     * with no annotations.) The annotation objects contained in the returned
     * arrays are serializable.  The caller of this method is free to modify
     * the returned arrays; it will have no effect on the arrays returned to
     * other callers.
     *
     * @return an array of arrays that represent the annotations on the formal
     *    parameters, in declaration order, of the method represented by this
     *    Method object
     * @since 1.5
     */
    public JArray<? extends JAnnotation>/*2 dimensions*/ getParameterAnnotations();
    
    
    /**
     * Retrurns the user representation of the signature
     * ie:
     *  	For a method declared as: "int foo(String[] bar, boolean booh, URL more)"
     *  	the returned string is: "(java.lang.String[],boolean,java.net.URL):int" 
     *
     *  	For a contructor declared as: "Foo(String[] bar, boolean booh, URL more)"
     *  	the returned string is: "(java.lang.String[],boolean,java.net.URL)" 
     * @return
     */
    public String getSignature();
    
    /**
     * Retrurns the jni representation of the signature
     * ie:
     * ie:
     *  	For a method declared as: "int foo(String[] bar, boolean booh, URL more)"
     *  	the returned string is: "([Ljava/lang/String;ZLjava/net/URL;)I" 
     *
     *  	For a contructor declared as: "Foo(String[] bar, boolean booh, URL more)"
     *  	the returned string is: "([Ljava/lang/String;ZLjava/net/URL;)V" 
     * @return
     */
    public String getJNISignature();
}
