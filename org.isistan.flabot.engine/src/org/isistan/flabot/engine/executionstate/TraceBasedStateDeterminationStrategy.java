/**
 * $Id: TraceBasedStateDeterminationStrategy.java,v 1.20 2006/03/31 00:33:23 mblech Exp $
 * $Author: mblech $
 */
package org.isistan.flabot.engine.executionstate;

import java.util.List;

import org.isistan.flabot.engine.executionstate.correlation.Correlator;
import org.isistan.flabot.engine.executionstate.tagfilter.TagFilter;
import org.isistan.flabot.mapping.mappingmodel.Mapping;
import org.isistan.flabot.trace.config.Context;
import org.isistan.flabot.trace.log.Tag;
import org.isistan.flabot.trace.log.TraceLog;

/**
 * State determination strategy that requires certain contexts to be logged
 * in an instrumented application execution, to then use these contexts to
 * determine responsibility execution state. Actual state determination is
 * delegated to the trace inference strategy.
 * @author $Author: mblech $
 * @model
 */
public interface TraceBasedStateDeterminationStrategy extends
		StateDeterminationStrategy{

	/**
	 * Key where the analyzed tags are stored in the diagnostic
	 */
	static final String ANALYZED_TAGS_KEY = "analyzedTags";

	/**
	 * Get this strategy's required log configuration context
	 * @return the required context
	 */
	Context getContext() throws ContextCreationException;
	
	/**
	 * Get the trace inference strategy for this trace based state
	 * determination strategy
	 * @return
	 * @model containment="true" opposite="stateDeterminationStrategy"
	 */
	TraceInferenceStrategy getTraceInferenceStrategy();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.engine.executionstate.TraceBasedStateDeterminationStrategy#getTraceInferenceStrategy <em>Trace Inference Strategy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace Inference Strategy</em>' containment reference.
	 * @see #getTraceInferenceStrategy()
	 * @generated
	 */
	void setTraceInferenceStrategy(TraceInferenceStrategy value);

	/**
	 * Get the list of all tags in this strategy's context
	 * @return the list of tags
	 */
	List<Tag> getAllTags();

	/**
	 * Get the list of tags (filtered using the given tag scope)
	 * @param filter the tag filter
	 * @return the list of tags within the given scope
	 */
	List<Tag> getTags(TagFilter filter);

	/**
	 * Get the list of correlated tags from the current context, given the
	 * scope, correlation tags and the correlator.
	 * @param tags the uncorrelated tags
	 * @param scope the scope
	 * @param correlationTags the set of tags to which this context's tags must
	 * be correlated to
	 * @param correlator the correlator that must be used
	 * @return a subset the current context's tags that are accepted by
	 * the given correlator
	 */
	List<Tag> getCorrelatedTags(List<Tag> tags, TagFilter scope, List<Tag> correlationTags, Correlator correlator);
	
	/**
	 * Get the last list of tags that was used by this state determination strategy
	 * @return
	 */
	List<Tag> getLastTags();

	/**
	 * Get the current log
	 * @return
	 */
	TraceLog getCurrentLog();
	
	/**
	 * Get the current scope filter
	 * @return
	 */
	TagFilter getScopeFilter();

	/**
	 * Get the current scope mapping
	 * @return
	 */
	Mapping getCurrentScope();

}
