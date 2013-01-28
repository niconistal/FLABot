/**
 * 
 */
package org.isistan.flabot.engine.executionstate.tagfilter;

import java.util.Collection;

import org.isistan.flabot.trace.log.Tag;

/**
 * And composite tag filter. Accepts tags when all the composed tags accept it.
 * @author mblech
 *
 */
public class AndCompositeFilter implements TagFilter {
	
	private Collection<TagFilter> composedFilters;

	/**
	 * Create a new instance of the and composite filter that uses the given
	 * collection of composed filters
	 * @param composedFilters
	 */
	public AndCompositeFilter(Collection<TagFilter> composedFilters) {
		this.composedFilters = composedFilters;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.tagfilter.TagFilter#accepts(org.isistan.flabot.trace.log.Tag)
	 */
	public boolean accepts(Tag executionTag) {
		for (TagFilter filter: composedFilters) {
			if (!filter.accepts(executionTag))
				return false;
		}
		return true;
	}

}
