/**
 * 
 */
package org.isistan.flabot.engine.executionstate.correlation;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.isistan.flabot.trace.log.Tag;

/**
 * Correlates the tags that was the last ones to be executed before the
 * execution of the correlation tag
 * @author mblech
 *
 */
public class LastExecutionCorrelator implements Correlator {

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.correlation.Correlator#correlate(java.util.List, java.util.List)
	 */
	public List<Tag> correlate(List<Tag> originalTags, Tag correlationTag) {
		List<Tag> lastTags = null;
		long minDt = Long.MAX_VALUE;
		for (Tag tag: originalTags) {
			long dt = TimestampDeltaCorrelator.getTimestampDelta(tag, correlationTag);
			if (dt == minDt) {
				lastTags.add(tag);
			}
			else if (dt >= 0 && dt < minDt) {
				lastTags = new LinkedList<Tag>();
				lastTags.add(tag);
				minDt = dt;
			}
		}
		if (lastTags != null)
			return lastTags;
		else
			return Collections.emptyList();
	}

}
