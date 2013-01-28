/** * $Id: JEnum.java,v 1.1 2006/01/27 18:48:10 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;


/**
 * This is the common base class of all Java language enumeration types.
 *
 * @author $Author: dacostae $
 * @version 1.12, 06/08/04
 * @since   1.5
 */
public interface JEnum extends
			JObject,
			Comparable<JEnum> {
     /**
     * Returns the name of this enum constant, exactly as declared in its
     * enum declaration.
     * 
     * <b>Most programmers should use the {@link #toString} method in
     * preference to this one, as the toString method may return
     * a more user-friendly name.</b>  This method is designed primarily for
     * use in specialized situations where correctness depends on getting the
     * exact name, which will not vary from release to release.
     *
     * @return the name of this enum constant
     */
    public String name();

    /**
     * Returns the ordinal of this enumeration constant (its position
     * in its enum declaration, where the initial constant is assigned
     * an ordinal of zero).
     * 
     * Most programmers will have no use for this method.  It is
     * designed for use by sophisticated enum-based data structures, such
     * as {@link java.util.EnumSet} and {@link java.util.EnumMap}.
     *
     * @return the ordinal of this enumeration constant
     */
    public int ordinal();

    /**
     * Returns the name of this enum constant, as contained in the
     * declaration.  This method may be overridden, though it typically
     * isn't necessary or desirable.  An enum type should override this
     * method when a more "programmer-friendly" string form exists.
     *
     * @return the name of this enum constant
     */
    public String toString();

    /**
     * Compares this enum with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     * 
     * Enum constants are only comparable to other enum constants of the
     * same enum type.  The natural order implemented by this
     * method is the order in which the constants are declared.
     */
    public int compareTo(JEnum o);

    /**
     * Returns the Class object corresponding to this enum constant's
     * enum type.  Two enum constants e1 and  e2 are of the
     * same enum type if and only if
     *   e1.getDeclaringClass() == e2.getDeclaringClass().
     * (The value returned by this method may differ from the one returned
     * by the {@link Object#getClass} method for enum constants with
     * constant-specific class bodies.)
     *
     * @return the Class object corresponding to this enum constant's
     *     enum type
     */
    public JClass getDeclaringClass();
}
