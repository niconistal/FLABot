/**
 * $Id: StateDeterminationStrategyRegistry.java,v 1.1 2006/01/27 00:10:12 mblech Exp $
 * $Author: mblech $
 */
package org.isistan.flabot.engine.executionstate;


import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * Registers State Determination Strategies using a responsibility as a key
 * @author $Author: mblech $
 * @model
 */
public interface StateDeterminationStrategyRegistry extends EObject {
	
	/**
	 * Get the registry's map.
	 * @return
	 * @model keyType="org.isistan.flabot.coremodel.Responsibility" valueType="StateDeterminationStrategy"
	 */
	EMap getRegistry();
}
