/** * $Id: UCMDiagram.java,v 1.15 2006/02/28 20:50:48 apersson Exp $ * $Author: apersson $ */package org.isistan.flabot.edit.ucmmodel;

import org.eclipse.emf.common.notify.Adapter;import org.isistan.flabot.coremodel.UseCaseMap;import org.isistan.flabot.edit.editormodel.Diagram;/**
 * UCMDiagram:
 * -	Extends from Diagram, represents a use case map diagram shown by the use case map diagram editor.
 * 
 * @model
 */
public interface UCMDiagram extends Diagram, Adapter{
	
	/**
	 * @model
	 */
	UseCaseMap getMap();

	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.ucmmodel.UCMDiagram#getMap <em>Map</em>}' reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Map</em>' reference.	 * @see #getMap()	 * @generated	 */
	void setMap(UseCaseMap value);

}
