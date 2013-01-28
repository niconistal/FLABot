/**
 * 
 */
package org.isistan.flabot.engine.executionstate.tagfilter;

import java.util.Collection;

import org.isistan.flabot.trace.log.Tag;
import org.isistan.flabot.trace.log.tagquery.TagQueryUtil;

/**
 * Scope that is specified with a collection of substrings. Accepts tags
 * whose execution instance's class name contains any of the given
 * substrings
 * @author mblech
 *
 */
public class InstanceClassSubstringFilter implements TagFilter {
	
	private Collection<String> substrings;

	/**
	 * Create an instance of PrefixTagScope for the given
	 * collection of prefixes
	 * @param substrings
	 */
	public InstanceClassSubstringFilter(Collection<String> substrings) {
		this.substrings = substrings;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.scope.TagScope#accepts(org.isistan.flabot.trace.log.Tag)
	 */
	public boolean accepts(Tag executionTag) {
		if (substrings.isEmpty())
			return true;
		Tag snapshot = TagQueryUtil.INSTANCE.getExecutionInstanceSnapshot(executionTag);
		Tag object = TagQueryUtil.INSTANCE.getObject(snapshot);
		Tag clazz = TagQueryUtil.INSTANCE.getObjectClass(object);
		String classDescriptor = TagQueryUtil.INSTANCE.getClassDescriptor(clazz);
		if (classDescriptor == null)
			return false;
		for (String substring: substrings) {
			if (substring.equals("*"))
				return true;
			if (classDescriptor.contains(substring))
				return true;
		}
		return false;
	}

}
