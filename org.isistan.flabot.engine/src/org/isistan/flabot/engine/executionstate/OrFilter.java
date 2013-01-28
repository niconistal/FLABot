/**
 * 
 */
package org.isistan.flabot.engine.executionstate;

import org.eclipse.emf.common.util.EList;
import org.isistan.flabot.trace.config.Filter;

/**
 * Or filter: passes whenever any of the combined filters pass
 * @author mblech
 * @model
 */
public interface OrFilter extends Filter {
	
	/**
	 * Get the combined filters
	 * @return
	 * @model type="Filter"
	 */
	EList getCombinedFilters();

}
