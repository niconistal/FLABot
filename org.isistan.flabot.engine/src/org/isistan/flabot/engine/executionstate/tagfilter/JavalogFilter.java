/**
 * 
 */
package org.isistan.flabot.engine.executionstate.tagfilter;

import org.isistan.flabot.engine.executionstate.javalogtrace.TraceInferenceJavalogEngine;
import org.isistan.flabot.trace.log.Tag;

/**
 * Tag filter implemented as a javalog query
 * @author mblech
 *
 */
public class JavalogFilter implements TagFilter {
	
	private TraceInferenceJavalogEngine engine;
	private String query;

	/**
	 * Create a new instance of javalog filter that uses the given engine
	 * and functor
	 * @param engine the javalog engine
	 * @param query the query
	 */
	public JavalogFilter(TraceInferenceJavalogEngine engine, String query) {
		if (engine == null)
			throw new IllegalArgumentException("Engine can't be null");
		if (query == null)
			throw new IllegalArgumentException("Query can't be null");
		query = query.trim();
		if (query.length() == 0)
			throw new IllegalArgumentException("Query can't be the empty string");
		this.engine = engine;
		this.query = query + '.';
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.scope.TagFilter#accepts(org.isistan.flabot.trace.log.Tag)
	 */
	public boolean accepts(Tag executionTag) {
		boolean result = engine.getBrain().answerQuery(query, new Object[]{executionTag});
		return result;
	}

}
