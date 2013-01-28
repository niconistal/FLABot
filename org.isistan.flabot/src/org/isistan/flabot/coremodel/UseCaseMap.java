/** * $Id: UseCaseMap.java,v 1.17 2006/01/27 00:09:14 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.coremodel;

import org.eclipse.emf.common.util.EList;/**
 * UseCaseMap
 * -	Represents a use case map.
 * -	Holds by contention all Paths and ComponentRoles present in the map.
 * -	Has some other properties like description.
 * 
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='UseCaseMapGeneral'"
 */
public interface UseCaseMap extends NamedElementModel{
	
	public static final String architecturalLevel = "Architectural"; //$NON-NLS-1$
	public static final String functionalLevel = "Functional"; //$NON-NLS-1$
	
	/**
	 * @model type="Path" containment="true"
	 */
	EList getPaths();
	
	/**
	 * @model type="ComponentRole" containment="true" opposite="map"
	 */
	EList getComponentRoles();
	
	/**
	 * @model opposite="useCaseMaps"
	 */
	CoreModel getCoreModel();

	/**	 * Sets the value of the '{@link org.isistan.flabot.coremodel.UseCaseMap#getCoreModel <em>Core Model</em>}' container reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Core Model</em>' container reference.	 * @see #getCoreModel()	 * @generated	 */
	void setCoreModel(CoreModel value);

	/**
	 * @model default=""
	 */
	String getDescription();

	/**	 * Sets the value of the '{@link org.isistan.flabot.coremodel.UseCaseMap#getDescription <em>Description</em>}' attribute.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Description</em>' attribute.	 * @see #getDescription()	 * @generated	 */
	void setDescription(String value);

	/**
	 * @model
	 */
	String getLevelInfo();

	/**	 * Sets the value of the '{@link org.isistan.flabot.coremodel.UseCaseMap#getLevelInfo <em>Level Info</em>}' attribute.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Level Info</em>' attribute.	 * @see #getLevelInfo()	 * @generated	 */
	void setLevelInfo(String value);

}