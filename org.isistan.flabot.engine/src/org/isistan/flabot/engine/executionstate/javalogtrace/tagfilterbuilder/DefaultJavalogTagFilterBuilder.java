/**
 * 
 */
package org.isistan.flabot.engine.executionstate.javalogtrace.tagfilterbuilder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.isistan.flabot.engine.executionstate.javalogtrace.TraceInferenceJavalogEngine;
import org.isistan.flabot.engine.executionstate.tagfilter.AcceptAllFilter;
import org.isistan.flabot.engine.executionstate.tagfilter.AndCompositeFilter;
import org.isistan.flabot.engine.executionstate.tagfilter.InstanceClassSubstringFilter;
import org.isistan.flabot.engine.executionstate.tagfilter.JavalogFilter;
import org.isistan.flabot.engine.executionstate.tagfilter.TagFilter;
import org.isistan.flabot.util.javalog.JavalogUtil;

import JavaLog.PlList;

/**
 * Default tag filter builder
 * @author mblech
 *
 */
public class DefaultJavalogTagFilterBuilder implements JavalogTagFilterBuilder {
	
	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.javalogtrace.scopebuilder.JavalogTagScopeBuilder#buildScope(JavaLog.PlList)
	 */
	public TagFilter buildFilter(PlList descriptor, TraceInferenceJavalogEngine engine) {
		if (descriptor == null || descriptor.isEmpty())
			return new AcceptAllFilter();
		String filterKey = JavalogUtil.INSTANCE.escapePrologString(
				descriptor.car().toString());
		PlList parameters = (PlList) descriptor.cdr();
		
		if (filterKey.equals(JavalogTagFilterBuilder.FILTER_KEY_AND_COMPOSITE)) {
			return buildAndComposite(parameters, engine);
		}
		if (filterKey.equals(JavalogTagFilterBuilder.FILTER_KEY_INSTANCE_CLASS_SUBSTRING)) {
			return buildInstanceClassSubstringFilter(parameters);
		}
		if (filterKey.equals(JavalogTagFilterBuilder.FILTER_KEY_JAVALOG)) {
			return buildJavalogFilter(parameters, engine);
		}
		
		throw new IllegalArgumentException("Unknown tag filter key: " + filterKey);
	}

	/**
	 * Build an and composite filter
	 * @param parameters
	 * @return
	 */
	private TagFilter buildAndComposite(PlList parameters, TraceInferenceJavalogEngine engine) {
		List<TagFilter> composedFilters = new LinkedList<TagFilter>();
		while (parameters != null && !parameters.isEmpty()) {
			PlList composedFilterDescriptor = (PlList) parameters.car();
			TagFilter composedFilter = buildFilter(composedFilterDescriptor, engine);
			composedFilters.add(composedFilter);
			parameters = (PlList) parameters.cdr();
		}
		AndCompositeFilter filter = new AndCompositeFilter(composedFilters);
		return filter;
	}

	/**
	 * Build an instance class substring filter
	 * @param parameters
	 * @return
	 */
	private TagFilter buildInstanceClassSubstringFilter(PlList parameters) {
		Set<String> prefixes = new HashSet<String>();
		while (parameters != null && !parameters.isEmpty()) {
			String prefix = parameters.car().toString();
			prefix = JavalogUtil.INSTANCE.escapePrologString(prefix);
			prefixes.add(prefix);
			parameters = (PlList) parameters.cdr();
		}
		return new InstanceClassSubstringFilter(prefixes);
	}

	private TagFilter buildJavalogFilter(PlList parameters, TraceInferenceJavalogEngine engine) {
		if (parameters == null || parameters.length() == 0)
			throw new IllegalArgumentException("Javalog filter needs a query parameter");
		if (parameters.length() > 1)
			throw new IllegalArgumentException("Javalog filter takes only 1 parameter");
		String query = JavalogUtil.INSTANCE.escapePrologString(
				parameters.car().toString());
		JavalogFilter filter = new JavalogFilter(engine, query);
		return filter;
	}
}
