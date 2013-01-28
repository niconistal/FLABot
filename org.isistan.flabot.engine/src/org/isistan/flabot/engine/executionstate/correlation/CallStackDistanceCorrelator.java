/**
 * 
 */
package org.isistan.flabot.engine.executionstate.correlation;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.isistan.flabot.trace.log.Tag;
import org.isistan.flabot.trace.log.tagquery.TagQueryUtil;

/**
 * Correlates tags whose call stack distance to the
 * correlation tag is between the specified limits
 * @author mblech
 *
 */
public class CallStackDistanceCorrelator implements Correlator {
	
	private int min;
	private int max;
	
	/**
	 * Create a new instance of CallStackDistanceCorrelator with
	 * the given limits
	 * @param min
	 * @param max
	 */
	public CallStackDistanceCorrelator(int min, int max) {
		this.min = min;
		this.max = max;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.correlation.Correlator#correlate(java.util.List, java.util.List)
	 */
	public List<Tag> correlate(List<Tag> originalTags, Tag correlationTag) {
		List<Tag> tags = new LinkedList<Tag>();
		for (Tag tag: originalTags) {
			int distance = callStackDistance(tag, correlationTag);
			if (distance >= min && distance <= max) {
				tags.add(tag);
			}
		}
		return tags;
	}

	/**
	 * Calculate the call stack distance between the 2 given tags
	 * @param tag1
	 * @param tag2
	 * @return
	 */
	private int callStackDistance(Tag tag1, Tag tag2) {
		int distance1 = 0;		
		while (tag2 != null) {
			int distance2 = 0;
			Tag aux = tag1;
			while (aux != null) {
				if (tag2 == aux)
					return distance1 + distance2;
				aux = findAncestor(aux);
				distance2++;
			}
			tag2 = findAncestor(tag2);
			distance1++;
		}		
		return Integer.MAX_VALUE;
	}

	private Tag findAncestor(Tag tag) {
		if (TagQueryUtil.INSTANCE.isThread(tag))
			return null;
		EObject eObject = tag;
		while (eObject != null) {
			eObject = eObject.eContainer();
			if (eObject instanceof Tag) {
				return (Tag) eObject;
			}
		}
		return null;
	}

}
