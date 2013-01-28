/**
 * 
 */
package org.isistan.flabot.engine.executionstate.correlation;

import java.util.LinkedList;
import java.util.List;

import org.isistan.flabot.trace.log.Tag;
import org.isistan.flabot.trace.log.tagquery.TagQueryUtil;

/**
 * Correlates using the timestamps: the tags whose timestamp difference
 * with the correlation tag falls between the limits is considered
 * to be correlated.
 * @author mblech
 *
 */
public class TimestampDeltaCorrelator implements Correlator {
	
	private long minDt;
	private long maxDt;

	/**
	 * Create a new instance of timestamp correlator with the given
	 * minimum and maximum timestamp deltas
	 * @param minDt
	 * @param maxDt
	 */
	public TimestampDeltaCorrelator(long minDt, long maxDt) {
		this.minDt = minDt;
		this.maxDt = maxDt;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.correlation.Correlator#correlate(java.util.List, java.util.List)
	 */
	public List<Tag> correlate(List<Tag> originalTags, Tag correlationTag) {
		List<Tag> tags = new LinkedList<Tag>();
		for (Tag tag: originalTags) {
			long dt = getTimestampDelta(tag, correlationTag);
			if (dt >= minDt && dt <= maxDt) {
				tags.add(tag);
			}
		}
		return tags;
	}

	/**
	 * Get the timestamp delta (t2 - t1)
	 * @param tag1
	 * @param tag2
	 * @return
	 */
	public static long getTimestampDelta(Tag tag1, Tag tag2) {
		long time1 = TagQueryUtil.INSTANCE.getTimestamp(tag1).longValue();
		long time2 = TagQueryUtil.INSTANCE.getTimestamp(tag2).longValue();
		long dt = time2 - time1;
		return dt;
	}

}
