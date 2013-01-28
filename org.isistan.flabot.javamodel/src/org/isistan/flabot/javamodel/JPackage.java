/** * $Id: JPackage.java,v 1.3 2006/03/29 20:39:53 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;
/**
 * <code>Package</code> objects contain version information
 * about the implementation and specification of a Java package.
 * This versioning information is retrieved and made available
 * by the {@link ClassLoader <code>ClassLoader</code>} instance that
 * loaded the class(es).  Typically, it is stored in the manifest that is
 * distributed with the classes.
 *
 * <p>The set of classes that make up the package may implement a
 * particular specification and if so the specification title, version number,
 * and vendor strings identify that specification.
 * An application can ask if the package is
 * compatible with a particular version, see the {@link #isCompatibleWith
 * <code>isCompatibleWith</code>} method for details.
 *
 * <p>Specification version numbers use a syntax that consists of positive
 * decimal integers separated by periods ".", for example "2.0" or
 * "1.2.3.4.5.6.7".  This allows an extensible number to be used to represent
 * major, minor, micro, etc. versions.  The version specification is described
 * by the following formal grammar:
 * <blockquote>
 * <dl>
 * <dt><i>SpecificationVersion:
 * <dd>Digits RefinedVersion<sub>opt</sub></i>

 * <p><dt><i>RefinedVersion:</i>
 * <dd><code>.</code> <i>Digits</i>
 * <dd><code>.</code> <i>Digits RefinedVersion</i>
 *
 * <p><dt><i>Digits:
 * <dd>Digit
 * <dd>Digits</i>
 *
 * <p><dt><i>Digit:</i>
 * <dd>any character for which {@link Character#isDigit} returns <code>true</code>,
 * e.g. 0, 1, 2, ...
 * </dl>
 * </blockquote>
 *
 * <p>The implementation title, version, and vendor strings identify an
 * implementation and are made available conveniently to enable accurate
 * reporting of the packages involved when a problem occurs. The contents
 * all three implementation strings are vendor specific. The
 * implementation version strings have no specified syntax and should
 * only be compared for equality with desired version identifiers.
 *
 * <p>Within each <code>ClassLoader</code> instance all classes from the same
 * java package have the same Package object.  The static methods allow a package
 * to be found by name or the set of all packages known to the current class
 * loader to be found.
 *
 * @see ClassLoader#definePackage
 */
public interface JPackage extends
			JObject,
			JAnnotatedElement,			JDescriptedElement {
    /**     * Return the name of this package.     *     * @return The name of this package using the Java language dot notation     * 		for the package. i.e  java.lang     */    public String getName();        /**     * Return the name of this package.     *     * @return The name of this package using the Java language dot notation     * 		for the package. i.e package java.lang returns lang     */    public String getSimpleName();        /**     * Returns true if this package is the default one, the one with no name.     * @return     */    public boolean isDefault();        /**     * Returns true if this package is in the root, that is, contains no '.' in it's name.     * @return     */    public boolean isInRoot();

    /**
     * Return the title of the specification that this package implements.
     * @return the specification title, null is returned if it is not known.
     */
    public String getSpecificationTitle();

    /**
     * Returns the version number of the specification
     * that this package implements.
     * This version string must be a sequence of positive decimal
     * integers separated by "."'s and may have leading zeros.
     * When version strings are compared the most significant
     * numbers are compared.
     * @return the specification version, null is returned if it is not known.
     */
    public String getSpecificationVersion();

    /**
     * Return the name of the organization, vendor,
     * or company that owns and maintains the specification
     * of the classes that implement this package.
     * @return the specification vendor, null is returned if it is not known.
     */
    public String getSpecificationVendor();

    /**
     * Return the title of this package.
     * @return the title of the implementation, null is returned if it is not known.
     */
    public String getImplementationTitle();

    /**
     * Return the version of this implementation. It consists of any string
     * assigned by the vendor of this implementation and does
     * not have any particular syntax specified or expected by the Java
     * runtime. It may be compared for equality with other
     * package version strings used for this implementation
     * by this vendor for this package.
     * @return the version of the implementation, null is returned if it is not known.
     */
    public String getImplementationVersion();

    /**
     * Returns the name of the organization,
     * vendor or company that provided this implementation.
     * @return the vendor that implemented this package..
     */
    public String getImplementationVendor();

    /**
     * Returns true if this package is sealed.
     *
     * @return true if the package is sealed, false otherwise
     */
    public boolean isSealed();

    /**
     * Returns true if this package is sealed with respect to the specified
     * code source url.
     *
     * @param url the code source url
     * @return true if this package is sealed with respect to url
     */
    public boolean isSealed(JObject/*URL*/ url);

    /**
     * Compare this package's specification version with a
     * desired version. It returns true if
     * this packages specification version number is greater than or equal
     * to the desired version number. <p>
     *
     * Version numbers are compared by sequentially comparing corresponding
     * components of the desired and specification strings.
     * Each component is converted as a decimal integer and the values
     * compared.
     * If the specification value is greater than the desired
     * value true is returned. If the value is less false is returned.
     * If the values are equal the period is skipped and the next pair of
     * components is compared.
     *
     * @param desired the version string of the desired version.
     * @return true if this package's version number is greater
     * 		than or equal to the desired version number
     *
     * @exception NumberFormatException if the desired or current version
     *		is not of the correct dotted form.
     */
    public boolean isCompatibleWith(String desired)
	throws NumberFormatException;

    /**
     * Return the hash code computed from the package name.
     * @return the hash code computed from the package name.
     */
    public int hashCode();

    /**
     * Returns the string representation of this Package.
     * Its value is the string "package " and the package name.
     * If the package title is defined it is appended.
     * If the package version is defined it is appended.
     * @return the string representation of the package.
     */
    public String toString();    	/**	 * returns the parent package, null if package is directly in root	 * @return	 */	public JPackage getParentPackage();		/**	 * returns the child packages (none if package is default)	 * @return	 * @throws JavaModelException	 */	public JArray<? extends JPackage> getPackages();    }
