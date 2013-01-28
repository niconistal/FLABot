/**
 * $Id: Constraint.java,v 1.1 2005/09/30 19:11:49 mblech Exp $
 * $Author: mblech $
 */
package org.isistan.flabot.util.consistency;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * Representation of a constraint entity. This is where constraints are actually
 * checked when delegated to the consistency manager.
 * @author $Author: mblech $
 *
 */
public interface Constraint {
	
	/**
	 * Validate this constraint on the given
	 * object, using the given diagnostic chain and context.
	 * @param constraintKey The key of the constraint
	 * @param model The model to validate
	 * @param diagnostics The diagnostic chain
	 * @param context The context
	 * @return
	 */
	boolean validate(Object constraintKey, Object model,
			DiagnosticChain diagnostics, Map context);
}
