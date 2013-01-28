/**
 * 
 */
package org.isistan.flabot.engine.executionstate.correlation;

import java.util.ArrayList;
import java.util.List;

import org.isistan.flabot.trace.log.Tag;
import org.isistan.flabot.trace.log.tagquery.TagQueryUtil;

/**
 * Correlates tags that executed on the same instance than the
 * correlation tag
 * @author mblech
 *
 */
public class SameInstanceCorrelator implements Correlator {

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.correlation.Correlator#correlate(java.util.List, java.util.List)
	 */
	public List<Tag> correlate(List<Tag> originalTags, Tag correlationTag) {
		List<Tag> tags = new ArrayList<Tag>();
		for (Tag tag: originalTags) {
			if (sameInstance(tag, correlationTag)) {
				tags.add(tag);
			}
		}
		return tags;
	}

	/**
	 * Check whether both execution tags are from the same instance
	 * or not
	 * @param tag1
	 * @param tag2
	 * @return
	 */
	private boolean sameInstance(Tag tag1, Tag tag2) {
		Tag snapshot1 = TagQueryUtil.INSTANCE.getExecutionInstanceSnapshot(tag1);
		Tag object1 = TagQueryUtil.INSTANCE.getObject(snapshot1);
		Tag snapshot2 = TagQueryUtil.INSTANCE.getExecutionInstanceSnapshot(tag2);
		Tag object2 = TagQueryUtil.INSTANCE.getObject(snapshot2);
		return object1 != null && object1 == object2;
	}

}
