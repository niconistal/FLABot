/**
 * $Id: ConsistencyManager.java,v 1.1 2005/09/30 19:11:49 mblech Exp $
 * $Author: mblech $
 */
package org.isistan.flabot.util.consistency;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * Consistency Manager
 * Constraint checker methods generated by EMF Validation Framework must
 * delegate actual constraint checking and diagnosis to this consistency
 * manager.
 * @author $Author: mblech $
 *
 */
public interface ConsistencyManager {
	
	/**
	 * the singleton instance
	 */
	ConsistencyManager INSTANCE = GroupBasedConsistencyManagerImpl.getInstance();
	
	/**
	 * Validate the constraint specified by constraintKey on the given
	 * object, using the given diagnostic chain and context.
	 * @param constraintKey The key of the constraint to validate
	 * @param model The model to validate
	 * @param diagnostics The diagnostic chain
	 * @param context The context
	 * @return
	 */
	boolean validate(Object constraintKey, Object model,
			DiagnosticChain diagnostics, Map context);
}
