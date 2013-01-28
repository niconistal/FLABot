/** * $Id: JClassLoader.java,v 1.2 2006/03/24 00:33:56 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;

import java.io.IOException;/**
 * A class loader is an object that is responsible for loading classes. The
 * class <tt>ClassLoader</tt> is an abstract class.  Given the <a
 * href="#name">binary name</a> of a class, a class loader should attempt to
 * locate or generate data that constitutes a definition for the class.  A
 * typical strategy is to transform the name into a file name and then read a
 * "class file" of that name from a file system.
 *
 * <p> Every {@link Class <tt>Class</tt>} object contains a {@link
 * Class#getClassLoader() reference} to the <tt>ClassLoader</tt> that defined
 * it.
 *
 * <p> <tt>Class</tt> objects for array classes are not created by class
 * loaders, but are created automatically as required by the Java runtime.
 * The class loader for an array class, as returned by {@link
 * Class#getClassLoader()} is the same as the class loader for its element
 * type; if the element type is a primitive type, then the array class has no
 * class loader.
 *
 * <p> Applications implement subclasses of <tt>ClassLoader</tt> in order to
 * extend the manner in which the Java virtual machine dynamically loads
 * classes.
 *
 * <p> Class loaders may typically be used by security managers to indicate
 * security domains.
 *
 * <p> The <tt>ClassLoader</tt> class uses a delegation model to search for
 * classes and resources.  Each instance of <tt>ClassLoader</tt> has an
 * associated parent class loader.  When requested to find a class or
 * resource, a <tt>ClassLoader</tt> instance will delegate the search for the
 * class or resource to its parent class loader before attempting to find the
 * class or resource itself.  The virtual machine's built-in class loader,
 * called the "bootstrap class loader", does not itself have a parent but may
 * serve as the parent of a <tt>ClassLoader</tt> instance.
 *
 * <p> Normally, the Java virtual machine loads classes from the local file
 * system in a platform-dependent manner.  For example, on UNIX systems, the
 * virtual machine loads classes from the directory defined by the
 * <tt>CLASSPATH</tt> environment variable.
 *
 * <p> However, some classes may not originate from a file; they may originate
 * from other sources, such as the network, or they could be constructed by an
 * application.  The method {@link #defineClass(String, byte[], int, int)
 * <tt>defineClass</tt>} converts an array of bytes into an instance of class
 * <tt>Class</tt>. Instances of this newly defined class can be created using
 * {@link Class#newInstance <tt>Class.newInstance</tt>}.
 *
 * <p> The methods and constructors of objects created by a class loader may
 * reference other classes.  To determine the class(es) referred to, the Java
 * virtual machine invokes the {@link #loadClass <tt>loadClass</tt>} method of
 * the class loader that originally created the class.
 *
 * <p> For example, an application could create a network class loader to
 * download class files from a server.  Sample code might look like:
 *
 * <blockquote><pre>
 *   ClassLoader loader&nbsp;= new NetworkClassLoader(host,&nbsp;port);
 *   Object main&nbsp;= loader.loadClass("Main", true).newInstance();
 *	 &nbsp;.&nbsp;.&nbsp;.
 * </pre></blockquote>
 *
 * <p> The network class loader subclass must define the methods {@link
 * #findClass <tt>findClass</tt>} and <tt>loadClassData</tt> to load a class
 * from the network.  Once it has downloaded the bytes that make up the class,
 * it should use the method {@link #defineClass <tt>defineClass</tt>} to
 * create a class instance.  A sample implementation is:
 *
 * <blockquote><pre>
 *     class NetworkClassLoader extends ClassLoader {
 *         String host;
 *         int port;
 *
 *         public Class findClass(String name) {
 *             byte[] b = loadClassData(name);
 *             return defineClass(name, b, 0, b.length);
 *         }
 *
 *         private byte[] loadClassData(String name) {
 *             // load the class data from the connection
 *             &nbsp;.&nbsp;.&nbsp;.
 *         }
 *     }
 * </pre></blockquote>
 *
 * <h4> <a name="name">Binary names</a> </h4>
 *
 * <p> Any class name provided as a {@link String} parameter to methods in
 * <tt>ClassLoader</tt> must be a binary name as defined by the <a
 * href="http://java.sun.com/docs/books/jls/">Java Language Specification</a>.
 *
 * <p> Examples of valid class names include:
 * <blockquote><pre>
 *   "java.lang.String"
 *   "javax.swing.JSpinner$DefaultEditor"
 *   "java.security.KeyStore$Builder$FileBuilder$1"
 *   "java.net.URLClassLoader$3$1"
 * </pre></blockquote>
 *
 * @version  1.186, 08/02/04
 * @see      #resolveClass(Class)
 * @since 1.0
 */
public interface JClassLoader extends
			JObject {

	/**
     * Loads the class with the specified <a href="#name">binary name</a>.
     * This method searches for classes in the same manner as the {@link
     * #loadClass(String, boolean)} method.  It is invoked by the Java virtual
     * machine to resolve class references.  Invoking this method is equivalent
     * to invoking {@link #loadClass(String, boolean) <tt>loadClass(name,
     * false)</tt>}.  </p>
     *
     * @param  name
     *         The <a href="#name">binary name</a> of the class
     *
     * @return  The resulting <tt>Class</tt> object or null if the class     * wasn't found
     */
    public JClass loadClass(String name);

 
    /**
     * Finds the resource with the given name.  A resource is some data
     * (images, audio, text, etc) that can be accessed by class code in a way
     * that is independent of the location of the code.
     *
     * <p> The name of a resource is a '<tt>/</tt>'-separated path name that
     * identifies the resource.
     *
     * <p> This method will first search the parent class loader for the
     * resource; if the parent is <tt>null</tt> the path of the class loader
     * built-in to the virtual machine is searched.  That failing, this method
     * will invoke {@link #findResource(String)} to find the resource.  </p>
     *
     * @param  name
     *         The resource name
     *
     * @return  A <tt>URL</tt> object for reading the resource, or
     *          <tt>null</tt> if the resource could not be found or the invoker
     *          doesn't have adequate  privileges to get the resource.
     *
     * @since  1.1
     */
    public JObject/*URL*/ getResource(String name);

    /**
     * Finds all the resources with the given name. A resource is some data
     * (images, audio, text, etc) that can be accessed by class code in a way
     * that is independent of the location of the code.
     *
     * <p>The name of a resource is a <tt>/</tt>-separated path name that
     * identifies the resource.
     *
     * <p> The search order is described in the documentation for {@link
     * #getResource(String)}.  </p>
     *
     * @param  name
     *         The resource name
     *
     * @return  An enumeration of {@link java.net.URL <tt>URL</tt>} objects for
     *          the resource.  If no resources could  be found, the enumeration
     *          will be empty.  Resources that the class loader doesn't have
     *          access to will not be in the enumeration.
     *
     *
     * @see  #findResources(String)
     *
     * @since  1.2
     */
    public JArray<? extends JObject> /*Object is URL*/ getResources(String name);
    /**
     * Returns an input stream for reading the specified resource.
     *
     * <p> The search order is described in the documentation for {@link
     * #getResource(String)}.  </p>
     *
     * @param  name
     *         The resource name
     *
     * @return  An input stream for reading the resource, or <tt>null</tt>
     *          if the resource could not be found
     *
     * @since  1.1
     */
    public JObject/*InputStream*/ getResourceAsStream(String name);

    // -- Hierarchy --

    /**
     * Returns the parent class loader for delegation. Some implementations may
     * use <tt>null</tt> to represent the bootstrap class loader. This method
     * will return <tt>null</tt> in such implementations if this class loader's
     * parent is the bootstrap class loader.
     *
     * <p> If a security manager is present, and the invoker's class loader is
     * not <tt>null</tt> and is not an ancestor of this class loader, then this
     * method invokes the security manager's {@link
     * SecurityManager#checkPermission(java.security.Permission)
     * <tt>checkPermission</tt>} method with a {@link
     * RuntimePermission#RuntimePermission(String)
     * <tt>RuntimePermission("getClassLoader")</tt>} permission to verify
     * access to the parent class loader is permitted.  If not, a
     * <tt>SecurityException</tt> will be thrown.  </p>
     *
     * @return  The parent <tt>ClassLoader</tt>
     *
     * 
     * @since  1.2
     */
    public JClassLoader getParent();

     /**
     * Sets the default assertion status for this class loader.  This setting
     * determines whether classes loaded by this class loader and initialized
     * in the future will have assertions enabled or disabled by default.
     * This setting may be overridden on a per-package or per-class basis by
     * invoking {@link #setPackageAssertionStatus(String, boolean)} or {@link
     * #setClassAssertionStatus(String, boolean)}.  </p>
     *
     * @param  enabled
     *         <tt>true</tt> if classes loaded by this class loader will
     *         henceforth have assertions enabled by default, <tt>false</tt>
     *         if they will have assertions disabled by default.
     *
     * @since  1.4
     */
    public void setDefaultAssertionStatus(boolean enabled);

    /**
     * Sets the package default assertion status for the named package.  The
     * package default assertion status determines the assertion status for
     * classes initialized in the future that belong to the named package or
     * any of its "subpackages".
     *
     * <p> A subpackage of a package named p is any package whose name begins
     * with "<tt>p.</tt>".  For example, <tt>javax.swing.text</tt> is a
     * subpackage of <tt>javax.swing</tt>, and both <tt>java.util</tt> and
     * <tt>java.lang.reflect</tt> are subpackages of <tt>java</tt>.
     *
     * <p> In the event that multiple package defaults apply to a given class,
     * the package default pertaining to the most specific package takes
     * precedence over the others.  For example, if <tt>javax.lang</tt> and
     * <tt>javax.lang.reflect</tt> both have package defaults associated with
     * them, the latter package default applies to classes in
     * <tt>javax.lang.reflect</tt>.
     *
     * <p> Package defaults take precedence over the class loader's default
     * assertion status, and may be overridden on a per-class basis by invoking
     * {@link #setClassAssertionStatus(String, boolean)}.  </p>
     *
     * @param  packageName
     *         The name of the package whose package default assertion status
     *         is to be set. A <tt>null</tt> value indicates the unnamed
     *         package that is "current" (<a *
     *         href="http://java.sun.com/docs/books/jls/">Java Language
     *         Specification</a>, section 7.4.2).
     *
     * @param  enabled
     *         <tt>true</tt> if classes loaded by this classloader and
     *         belonging to the named package or any of its subpackages will
     *         have assertions enabled by default, <tt>false</tt> if they will
     *         have assertions disabled by default.
     *
     * @since  1.4
     */
    public void setPackageAssertionStatus(String packageName,
                                                       boolean enabled);

    /**
     * Sets the desired assertion status for the named top-level class in this
     * class loader and any nested classes contained therein.  This setting
     * takes precedence over the class loader's default assertion status, and
     * over any applicable per-package default.  This method has no effect if
     * the named class has already been initialized.  (Once a class is
     * initialized, its assertion status cannot change.)
     *
     * <p> If the named class is not a top-level class, this invocation will
     * have no effect on the actual assertion status of any class, and its
     * return value is undefined.  </p>
     *
     * @param  className
     *         The fully qualified class name of the top-level class whose
     *         assertion status is to be set.
     *
     * @param  enabled
     *         <tt>true</tt> if the named class is to have assertions
     *         enabled when (and if) it is initialized, <tt>false</tt> if the
     *         class is to have assertions disabled.
     *
     * @since  1.4
     */
    public void setClassAssertionStatus(String className,
                                                     boolean enabled);

    /**
     * Sets the default assertion status for this class loader to
     * <tt>false</tt> and discards any package defaults or class assertion
     * status settings associated with the class loader.  This method is
     * provided so that class loaders can be made to ignore any command line or
     * persistent assertion status settings and "start with a clean slate."
     * </p>
     *
     * @since  1.4
     */
    public void clearAssertionStatus();
}

