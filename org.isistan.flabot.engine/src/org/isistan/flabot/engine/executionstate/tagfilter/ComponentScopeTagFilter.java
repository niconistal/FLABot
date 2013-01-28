/**
 * 
 */
package org.isistan.flabot.engine.executionstate.tagfilter;

import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.mapping.mappingmodel.Mapping;
import org.isistan.flabot.trace.log.Tag;
import org.isistan.flabot.trace.log.tagquery.TagQueryUtil;
import org.isistan.flabot.util.TriState;

/**
 * Filters tags using a component's scope
 * @author mblech
 *
 */
public class ComponentScopeTagFilter implements TagFilter {

	private Mapping mapping;

	/**
	 * Create a new instance of ComponentScopeTagFilter for
	 * the given mapping
	 * @param component
	 */
	public ComponentScopeTagFilter(Mapping mapping) {
		this.mapping = mapping;
	}

	public boolean accepts(Tag executionTag) {
		if (mapping == null)
			return true;
		Tag snapshot = TagQueryUtil.INSTANCE.getExecutionInstanceSnapshot(executionTag);
		Tag object = TagQueryUtil.INSTANCE.getObject(snapshot);
		Tag classTag = TagQueryUtil.INSTANCE.getObjectClass(object);
		if (classTag == null) {
			// the class is null, it was a static method or a constructor
			return true;
		}
		JClass jClass = new ClassTagJClass(classTag);
		return mapping.passes(jClass).equals(TriState.TRUE);
	}

}
