/**
 * 
 */
package org.isistan.flabot.engine.executionstate.tagfilter;

import org.isistan.flabot.trace.log.Tag;

/**
 * Represents a scope that accepts or denies execution tags
 * @author mblech
 *
 */
public interface TagFilter {
	
	/**
	 * Check if this scope accepts the given execution tag or not
	 * @param executionTag the execution tag that must be checked
	 * against the scope
	 * @return true if the tag is accepted, false otherwise
	 */
	boolean accepts(Tag executionTag);

}
