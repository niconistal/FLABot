/** * $Id: JGenericDeclaration.java,v 1.3 2006/03/24 00:33:55 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;

import java.lang.reflect.GenericSignatureFormatError;/**
 * A common interface for all entities that declare type variables.
 *
 * @since 1.5
 */
public interface JGenericDeclaration extends
			JObject {
    /**
     * Returns an array of <tt>TypeVariable</tt> objects that
     * represent the type variables declared by the generic
     * declaration represented by this <tt>GenericDeclaration</tt>
     * object, in declaration order.  Returns an array of length 0 if
     * the underlying generic declaration declares no type variables.
     *
     * @return an array of <tt>TypeVariable</tt> objects that represent
     *     the type variables declared by this generic declaration
     */
    public JArray<? extends JTypeVariable> getTypeParameters();
}
