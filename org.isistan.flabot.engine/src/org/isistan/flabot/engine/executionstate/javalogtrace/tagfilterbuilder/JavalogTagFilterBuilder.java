/**
 * 
 */
package org.isistan.flabot.engine.executionstate.javalogtrace.tagfilterbuilder;

import org.isistan.flabot.engine.executionstate.javalogtrace.TraceInferenceJavalogEngine;
import org.isistan.flabot.engine.executionstate.tagfilter.TagFilter;

import JavaLog.PlList;

/**
 * Builds a tag filter using a javalog descriptor
 * @author mblech
 *
 */
public interface JavalogTagFilterBuilder {
	
	/**
	 * The implementation instance for JavalogTagFilterBuilder
	 */
	public static final JavalogTagFilterBuilder INSTANCE = new DefaultJavalogTagFilterBuilder();
	
	public static final String FILTER_KEY_AND_COMPOSITE = "and";
	public static final String FILTER_KEY_INSTANCE_CLASS_SUBSTRING = "instanceClassSubstring";
	public static final String FILTER_KEY_JAVALOG = "javalog";
	
	/**
	 * Build a tag filter using the given PlList descriptor
	 * @param descriptor the PlList descriptor
	 * @param engine TODO
	 * @return the tag filter
	 */
	TagFilter buildFilter(PlList descriptor, TraceInferenceJavalogEngine engine);

}
