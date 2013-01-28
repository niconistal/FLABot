/**
 * 
 */
package org.isistan.flabot.engine.executionstate.correlation;

import java.util.List;

import org.isistan.flabot.trace.log.Tag;

/**
 * Implementations of this class are used to correlate log tags
 * with a given set of tags
 * 
 * @author mblech
 *
 */
public interface Correlator {
	
	/**
	 * Correlate the originalTags sublist of Tags that correlate
	 * to correlationTags
	 * @param originalTags the original (unfiltered) tags
	 * @param correlationTag the tag to which originalTags must be
	 * correlated against
	 * @return the list of tags from originalTags that correlate to the
	 * correlationTag
	 */
	List<Tag> correlate(List<Tag> originalTags, Tag correlationTag);
}
