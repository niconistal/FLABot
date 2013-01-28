/**
 * $Id: StateDeterminationStrategy.java,v 1.7 2006/03/22 03:28:54 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate;


import java.util.Map;

import org.isistan.flabot.coremodel.Registrable;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.engine.Loader;

/**
 * Determines execution states for a given responsibility node.
 * @author $Author: franco $
 * @model abstract="true"
 */
public interface StateDeterminationStrategy extends Registrable{
	
	/**
	 * Get the state for the given node
	 * @param node
	 * @param engineContext 
	 * @param loader the engine's loader
	 * @return
	 * @throws StateDeterminationException 
	 */
	Diagnostic getState(ResponsibilityNode node, Map engineContext, Loader loader) throws StateDeterminationException;

	/**
	 * Get the responsibility that this strategy is associated to
	 * @model
	 */
	Responsibility getResponsibility();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.engine.executionstate.StateDeterminationStrategy#getResponsibility <em>Responsibility</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Responsibility</em>' reference.
	 * @see #getResponsibility()
	 * @generated
	 */
	void setResponsibility(Responsibility value);

	
	void checkMapping();
	
	void checkFilter();
}
