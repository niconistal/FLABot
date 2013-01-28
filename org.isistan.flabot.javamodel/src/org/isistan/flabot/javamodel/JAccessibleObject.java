/** * $Id: JAccessibleObject.java,v 1.2 2006/03/24 00:33:56 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;


/**
 * The AccessibleObject class is the base class for Field, Method and
 * Constructor objects.  It provides the ability to flag a reflected
 * object as suppressing default Java language access control checks
 * when it is used.  The access checks--for public, default (package)
 * access, protected, and private members--are performed when Fields,
 * Methods or Constructors are used to set or get fields, to invoke
 * methods, or to create and initialize new instances of classes,
 * respectively.
 *
 * <p>Setting the <tt>accessible</tt> flag in a reflected object
 * permits sophisticated applications with sufficient privilege, such
 * as Java Object Serialization or other persistence mechanisms, to
 * manipulate objects in a manner that would normally be prohibited.
 *
 * @see java.lang.reflect.Field
 * @see java.lang.reflect.Method
 * @see java.lang.reflect.Constructor
 * @see java.lang.reflect.ReflectPermission
 *
 * @since 1.2
 */
public interface JAccessibleObject extends
			JObject,
			JAnnotatedElement {

    /**
     * Set the <tt>accessible</tt> flag for this object to
     * the indicated boolean value.  A value of <tt>true</tt> indicates that
     * the reflected object should suppress Java language access
     * checking when it is used.  A value of <tt>false</tt> indicates 
     * that the reflected object should enforce Java language access checks.
     *
     * <p>First, if there is a security manager, its
     * <code>checkPermission</code> method is called with a
     * <code>ReflectPermission("suppressAccessChecks")</code> permission.
     * 
     * <p>A <code>SecurityException</code> is raised if <code>flag</code> is
     * <code>true</code> but accessibility of this object may not be changed
     * (for example, if this element object is a {@link java.lang.reflect.Constructor} object for
     * the class {@link java.lang.Class}).
     *
     * <p>A <code>SecurityException</code> is raised if this object is a {@link
     * java.lang.reflect.Constructor} object for the class
     * <code>java.lang.Class</code>, and <code>flag</code> is true.
     *
     * @param flag the new value for the <tt>accessible</tt> flag
     * @see SecurityManager#checkPermission
     * @see java.lang.RuntimePermission
     */
    public void setAccessible(boolean flag);

    /**
     * Get the value of the <tt>accessible</tt> flag for this object.
     *
     * @return the value of the object's <tt>accessible</tt> flag
     */
    public boolean isAccessible();
}
