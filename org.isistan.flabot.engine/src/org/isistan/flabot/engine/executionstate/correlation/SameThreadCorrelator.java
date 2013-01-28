/**
 * 
 */
package org.isistan.flabot.engine.executionstate.correlation;

import java.util.LinkedList;
import java.util.List;

import org.isistan.flabot.trace.log.Tag;
import org.isistan.flabot.trace.log.tagquery.TagQueryUtil;

/**
 * Correlates tags that are in the same thread than at least one
 * correlation tag
 * @author mblech
 *
 */
public class SameThreadCorrelator implements Correlator {

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.correlation.Correlator#correlate(java.util.List, java.util.List)
	 */
	public List<Tag> correlate(List<Tag> originalTags, Tag correlationTag) {
		List<Tag> tags = new LinkedList<Tag>();
		for (Tag tag: originalTags) {
			if (sameThread(tag, correlationTag)) {
				tags.add(tag);
			}
		}
		return tags;
	}

	/**
	 * Check whether the 2 given tags executed in the same thread or not
	 * @param tag1
	 * @param tag2
	 * @return
	 */
	private boolean sameThread(Tag tag1, Tag tag2) {
		Tag thread1 = TagQueryUtil.INSTANCE.getThread(tag1);
		Tag thread2 = TagQueryUtil.INSTANCE.getThread(tag2);
		return thread1 == thread2;
	}

}
