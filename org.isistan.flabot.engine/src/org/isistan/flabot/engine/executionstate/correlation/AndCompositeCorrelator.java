/**
 * 
 */
package org.isistan.flabot.engine.executionstate.correlation;

import java.util.List;

import org.isistan.flabot.trace.log.Tag;

/**
 * Logical AND combination of a set of individual correlators
 * @author mblech
 *
 */
public class AndCompositeCorrelator implements Correlator {
	
	/**
	 * List of combined correlators
	 */
	private List<Correlator> correlators;

	/**
	 * Create a new instance of AndCompositeCorrelator using the
	 * given list of correlators
	 * @param correlators
	 */
	public AndCompositeCorrelator(List<Correlator> correlators) {
		this.correlators = correlators;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.correlation.Correlator#correlate(java.util.List, java.util.List)
	 */
	public List<Tag> correlate(List<Tag> originalTags, Tag correlationTag) {
		List<Tag> aux = originalTags;
		for (Correlator correlator: correlators)
			aux = correlator.correlate(aux, correlationTag);
		return aux;
	}

}
