/**
 * $Id: TraceLog.java,v 1.1 2006/01/27 19:46:05 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.trace.log;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * Model that represents a log file
 * @author $Author: dacostae $
 * @model
 */
public interface TraceLog extends EObject {
	/**
	 * Get the logged tags
	 * @return a list containing all the logged tags
	 * @model type="Tag" containment="true"
	 */
	EList getTags();
	
	/**
	 * Get the log contexts
	 * @return a list with all the contained log contexts
	 * @model type="LogContext" containment="true" opposite="log"
	 */
	EList getContexts();

}
