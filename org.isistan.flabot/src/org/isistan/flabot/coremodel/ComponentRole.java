/**
 * $Id: ComponentRole.java,v 1.6 2006/03/11 00:15:38 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.coremodel;

import org.eclipse.emf.common.notify.Adapter;

/**
 * ComponentRole
 * -	Represents a role or instance of a component in a use case map
 * 
 * @author $Author: dacostae $
 * @model
 */
public interface ComponentRole extends ExtensibleElement, NamedElementModel, NoteElementModel, Adapter{
	
	public static final String standardComponent = "StandardComponent";  //$NON-NLS-1$
	public static final String redefinedComponent = "RedefinedComponent";  //$NON-NLS-1$

	public static final int COMPONENT_TYPE = 0;
	public static final int PROCESS_TYPE = 1;
	public static final int AGENT_TYPE = 2;
	public static final int OBJECT_TYPE = 3;
	public static final int ACTOR_TYPE = 4;
	/**
	 * Returns the component instanced by this role
	 * @model
	 */
	ComponentModel getComponent();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.ComponentRole#getComponent <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * Sets which component this role instances
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component</em>' reference.
	 * @see #getComponent()
	 * @generated
	 */
	void setComponent(ComponentModel value);

	/**
	 * Get the map that contains this role
	 * @model opposite="componentRoles"
	 */
	UseCaseMap getMap();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.ComponentRole#getMap <em>Map</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * Sets the containing map to a new map
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map</em>' container reference.
	 * @see #getMap()
	 * @generated
	 */
	void setMap(UseCaseMap value);

	/**
	 * Obtain this role's full name, that is the role name and the component's
	 * name separated by a semicolon
	 */
	String getFullName();
	
	/**
	 * @model
	 */
	String getAbstractInfo();
	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.ComponentRole#getAbstractInfo <em>Abstract Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract Info</em>' attribute.
	 * @see #getAbstractInfo()
	 * @generated
	 */
	void setAbstractInfo(String value);

	/**
	 * Returns the value of the '<em><b>Component Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Type</em>' attribute.
	 * @see #setComponentType(int)
	 * @see org.isistan.flabot.coremodel.CoremodelPackage#getComponentRole_ComponentType()
	 * @model
	 * @generated
	 */
	int getComponentType();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.ComponentRole#getComponentType <em>Component Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Type</em>' attribute.
	 * @see #getComponentType()
	 * @generated
	 */
	void setComponentType(int value);

}