package org.isistan.flabot.engine.executionstate.tagfilter;

import org.isistan.flabot.trace.log.Tag;

/**
 * AllScope: accepts all tags
 * @author mblech
 *
 */
public class AcceptAllFilter implements TagFilter {

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.scope.TagScope#accepts(org.isistan.flabot.trace.log.Tag)
	 */
	public boolean accepts(Tag executionTag) {
		return true;
	}

}
