/** * $Id: Family.java,v 1.11 2006/04/11 04:21:25 apersson Exp $ * $Author: apersson $ */package org.isistan.flabot.coremodel;

import org.eclipse.emf.common.util.EList;import org.eclipse.emf.common.util.EMap;/**
 * Represents a family to be used in mapping dependencies
 * @author $Author: apersson $
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='FamilyHasAllComponent'"
 * @model
 */
public interface Family extends NamedElementModel{
	
	/**
	 * @model type="FamilyElement" containment="true"
	 */
	EList getFamilyElement();

	/**
	 * @model type="SimplePathNode"
	 */
	EList getAssociatedResponsibilities();

	/**	 * @model type="UseCaseMap"	 */	EList getArchitecturalUseCaseMaps();		/**	 * @model type="UseCaseMap"	 */	EList getFunctionalUseCaseMaps();		/**	 * @model keyType="org.isistan.flabot.coremodel.ConditionEvent" valueType="org.isistan.flabot.coremodel.ConditionEvent"	 */	EMap getEvents();
}
