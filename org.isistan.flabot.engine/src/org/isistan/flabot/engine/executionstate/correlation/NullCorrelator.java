/**
 * 
 */
package org.isistan.flabot.engine.executionstate.correlation;

import java.util.List;

import org.isistan.flabot.trace.log.Tag;

/**
 * Null correlator: accepts all tags
 * @author mblech
 *
 */
public class NullCorrelator implements Correlator {

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.correlation.Correlator#correlate(java.util.List, org.isistan.flabot.trace.log.Tag)
	 */
	public List<Tag> correlate(List<Tag> originalTags, Tag correlationTag) {
		return originalTags;
	}

}
