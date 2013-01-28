/**
 * $Id: Tag.java,v 1.1 2006/01/27 19:46:05 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.trace.log;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * Base model in the hierarchy of loggable elements
 * @author $Author: dacostae $
 * @model
 */
public interface Tag extends EObject{
	
	/**
	 * Container parent of this tag
	 * @model opposite="containedTags"
	 */
	Tag getParent();
	

	/**
	 * Sets the value of the '{@link org.isistan.flabot.trace.log.Tag#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Tag value);

	/**
	 * Sets the parent, appends itseft to the new parent's map
	 */
	void setParent(String key, Tag value);
	
	/**
	 * The properties for this tag
	 * @return this tag's properties
	 * @model keyType="String" valueType="String"
	 */
	EMap getProperties();
	
	/**
	 * Get the value of the property that has the given name
	 * @param propertyName the name of the property
	 * @return the value of the property
	 */
	String getProperty(String propertyName);
	
	/**
	 * Set the value of the property with the given name
	 * @param name the name of the property
	 * @param value the new value of the property
	 * @return the old value of the property (if the property had no
	 * previous value, returns null)
	 */
	String setProperty(String propertyName, String newValue);
	
	/**
	 * Get the contained tags
	 * @return
	 * @model type="Tag" containment="true" opposite="parent"
	 */
	EList getContainedTags();
	
	/**
	 * Get the referenced tags
	 * @return
	 * @model keyType="String" valueType="Tag"
	 */
	EMap getTags();
	
	
	/**
	 * Returns a object associated (in runtime) with this tag with the given key 
	 * @param key
	 * @return
	 */
	Object getRuntimeObject(Object key);

	/**
	 * Associates a object (in runtime) with this tag with the given key
	 * @param key
	 * @param value
	 */
	void setRuntimeObject(Object key, Object value);
}
