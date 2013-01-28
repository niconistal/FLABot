/**


/**
 * Member is an interface that reflects identifying information about
 * a single behavior a method or a constructor.
 *
 * @see	java.lang.Class
 * @see	java.lang.reflect.Field
 * @see	java.lang.reflect.Method
 * @see	java.lang.reflect.Constructor
 *
 * @author $Author: dacostae $
 */
public interface JMember 
	extends
	
	/**
     * Returns the Class object representing the class or interface
     * that declares the member or constructor represented by this Member.
     *
     * @return an object representing the declaring class of the
     * underlying member
     */
    public JClass getDeclaringClass();

    /**
     * Returns the simple name of the underlying member or constructor
     * represented by this Member. Constructors return "&lt;init&gt;"
     * 
     * @return the simple name of the underlying member
     */
    public String getName();

    /**
     * Returns the Java language modifiers for the member or
     * constructor represented by this Member, as an integer.  The
     * Modifier class should be used to decode the modifiers in
     * the integer.
     * 
     * @return the Java language modifiers for the underlying member
     * @see java.lang.reflect.Modifier
     */
    public int getModifiers();

    /**
     * Returns <tt>true</tt> if this member was introduced by
     * the compiler; returns <tt>false</tt> otherwise.
     *
     * @return true if and only if this member was introduced by
     * the compiler.
     * @since 1.5
     */
    public boolean isSynthetic();
}