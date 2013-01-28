/** * $Id: JField.java,v 1.4 2006/03/24 00:33:55 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;
import java.lang.reflect.Modifier;

/**
 * A <code>Field</code> provides information about, and dynamic access to, a
 * single field of a class or an interface.  The reflected field may
 * be a class (static) field or an instance field.
 *
 *
 * @see Member
 * @see java.lang.Class
 * @see java.lang.Class#getFields()
 * @see java.lang.Class#getField(String)
 * @see java.lang.Class#getDeclaredFields()
 * @see java.lang.Class#getDeclaredField(String)
 *
 * @author $Author: dacostae $
 */
public interface JField extends
			JObject,
			JAccessibleObject,
			JMember {

    /**
     * Returns a <code>Class</code> object that identifies the
     * declared type for the field represented by this
     * <code>Field</code> object.
     *
     * @return a <code>Class</code> object identifying the declared
     * type of the field represented by this object
     */
    public JClass getType();

    /**
     * Returns a <tt>Type</tt> object that represents the declared type for
     * the field represented by this <tt>Field</tt> object.
     * 
     * <p>If the <tt>Type</tt> is a parameterized type, the
     * <tt>Type</tt> object returned must accurately reflect the
     * actual type parameters used in the source code.
     * 
     * <p>If an the  type of the underlying field is a type variable or a
     * parameterized type, it is created. Otherwise, it is resolved.
     *
     * @since 1.5
     */
    public JType getGenericType();


    /**
     * Returns a string describing this <code>Field</code>, including
     * its generic type.  The format is the access modifiers for the
     * field, if any, followed by the generic field type, followed by
     * a space, followed by the fully-qualified name of the class
     * declaring the field, followed by a period, followed by the name
     * of the field.
     *
     * <p>The modifiers are placed in canonical order as specified by
     * "The Java Language Specification".  This is <tt>public</tt>,
     * <tt>protected</tt> or <tt>private</tt> first, and then other
     * modifiers in the following order: <tt>static</tt>, <tt>final</tt>,
     * <tt>transient</tt>, <tt>volatile</tt>.
     *
     * @return a string describing this <code>Field</code>, including
     * its generic type
     *
     * @since 1.5
     */
    public String toGenericString();

    /**
     * Returns the value of the field represented by this <code>Field</code>, on
     * the specified object. The value is automatically wrapped in an
     * object if it has a primitive type.
     *
     * <p>The underlying field's value is obtained as follows:
     *
     * <p>If the underlying field is a static field, the <code>obj</code> argument
     * is ignored; it may be null.
     *
     *
     * If the underlying field is static, the class that declared the
     * field is initialized if it has not already been initialized. 
     *
     * <p>Otherwise, the value is retrieved from the underlying instance
     * or static field.  If the field has a primitive type, the value
     * is wrapped in an object before being returned, otherwise it is
     * returned as is.
     *
     * <p>If the field is hidden in the type of <code>obj</code>,
     * the field's value is obtained according to the preceding rules.
     *
     * @param obj object from which the represented field's value is
     * to be extracted
     * @return the value of the represented field in object
     * <tt>obj</tt>; primitive values are wrapped in an appropriate
     * object before being returned
     */
    public JObject get(JObject obj);

 
    /**
     * Sets the field represented by this <code>Field</code> object on the
     * specified object argument to the specified new value. The new
     * value is automatically unwrapped if the underlying field has a
     * primitive type.
     *
     * <p>The operation proceeds as follows:
     *
     * <p>If the underlying field is static, the <code>obj</code> argument is
     * ignored; it may be null.
     *
     *
     * <p>If the underlying field is static, the class that declared the
     * field is initialized if it has not already been initialized.
     *
     * <p>The field is set to the possibly unwrapped and widened new value.
     *
     * <p>If the field is hidden in the type of <code>obj</code>,
     * the field's value is set according to the preceding rules.
     *
     * @param obj the object whose field should be modified
     * @param value the new value for the field of <code>obj</code>
     * being modified
     */
    public void set(JObject obj, JObject value);        /**     * Returns <tt>true</tt> if this field represents an element of     * an enumerated type; returns <tt>false</tt> otherwise.     *     * @return <tt>true</tt> if and only if this field represents an element of     * an enumerated type.     * @since 1.5     */    public boolean isEnumConstant();
}
