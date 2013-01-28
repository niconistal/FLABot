/**
 * 
 */
package org.isistan.flabot.engine.executionstate.javalogtrace;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Display;
import org.isistan.flabot.engine.executionstate.correlation.Correlator;
import org.isistan.flabot.engine.executionstate.correlation.dialog.TagFilterDialogManager;
import org.isistan.flabot.engine.executionstate.tagfilter.ClassTagJClass;
import org.isistan.flabot.engine.executionstate.tagfilter.TagFilter;
import org.isistan.flabot.gauge.Gauge;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.mapping.mappingmodel.Mapping;
import org.isistan.flabot.trace.log.Tag;
import org.isistan.flabot.trace.log.tagquery.TagQueryUtil;
import org.isistan.flabot.trace.log.tagquery.TagQueryUtil.TraceGeneratorConstants;
import org.isistan.flabot.util.TriState;

/**
 * Default implementation of the LogQueryPredicates
 * @author mblech
 *
 */
public class DefaultLogQueryPredicates extends LogQueryPredicates {
	
	private JavalogTraceInferenceStrategy traceInferenceStrategy;

	/**
	 * Create a new instance for the given display and engine
	 * @param engine
	 */
	public DefaultLogQueryPredicates(Display display, JavalogTraceInferenceStrategy traceInferenceStrategy, TraceInferenceJavalogEngine engine) {
		super(display, engine);
		this.traceInferenceStrategy = traceInferenceStrategy;
	}
	
	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.javalogtrace.LogQueryPredicates#jTags()
	 */
	protected List<Tag> jTags() {
		return traceInferenceStrategy.getStateDeterminationStrategy().getAllTags();
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.javalogtrace.LogQueryPredicates#qBehaviorDescriptor(org.isistan.flabot.trace.log.Tag)
	 */
	protected String jBehaviorDescriptor(Tag behaviorTag) {
		return TagQueryUtil.INSTANCE.getBehaviorDescriptor(behaviorTag);
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.javalogtrace.LogQueryPredicates#qBehaviorExecuted(org.isistan.flabot.trace.log.Tag)
	 */
	protected Tag jBehavior(Tag executionTag) {
		return TagQueryUtil.INSTANCE.getBehavior(executionTag);
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.javalogtrace.LogQueryPredicates#qMethodCalls(org.isistan.flabot.trace.log.Tag)
	 */
	protected List<Tag> jInternalEvents(Tag executionTag) {
		return TagQueryUtil.INSTANCE.getInternalEvents(executionTag);
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.javalogtrace.LogQueryPredicates#qExceptionThrown(org.isistan.flabot.trace.log.Tag)
	 */
	protected Tag jExceptionThrown(Tag executionTag) {
		return TagQueryUtil.INSTANCE.getExceptionThrown(executionTag);
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.javalogtrace.LogQueryPredicates#qExceptionCaught(org.isistan.flabot.trace.log.Tag)
	 */
	protected List<Tag> jExceptionCaught(Tag executionTag) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.javalogtrace.LogQueryPredicates#jDeclaringClass(org.isistan.flabot.trace.log.Tag)
	 */
	@Override
	protected Tag jDeclaringClass(Tag behaviorTag) {
		return TagQueryUtil.INSTANCE.getDeclaringClass(behaviorTag);
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.javalogtrace.LogQueryPredicates#jClassDescriptor(org.isistan.flabot.trace.log.Tag)
	 */
	@Override
	protected String jClassDescriptor(Tag classTag) {
		return TagQueryUtil.INSTANCE.getClassDescriptor(classTag); 
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.javalogtrace.LogQueryPredicates#jIsMethodCall(org.isistan.flabot.trace.log.Tag)
	 */
	@Override
	protected boolean jIsMethodCall(Tag tag) {
		if (tag == null)
			return false;
		String eventType = tag.getProperty(TraceGeneratorConstants.EVENT_TYPE_PARAMETER_NAME);
		if (eventType != null && eventType.equals(Gauge.Type.BEFORE_METHOD_CALL.getName()))
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.javalogtrace.LogQueryPredicates#jIsExitError(org.isistan.flabot.trace.log.Tag)
	 */
	@Override
	protected boolean jIsExitError(Tag tag) {
		if (tag == null)
			return false;
		String exitEventType = tag.getProperty(TraceGeneratorConstants.EXIT_EVENT_TYPE_PARAMETER_NAME);
		if (exitEventType == null)
			return false;
		if (exitEventType.equals(Gauge.Type.ON_BEHAVIOR_ERROR.getName()) ||
				exitEventType.equals(Gauge.Type.ON_METHOD_CALL_ERROR.getName()))
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.javalogtrace.LogQueryPredicates#jIsExitNull(org.isistan.flabot.trace.log.Tag)
	 */
	@Override
	protected boolean jIsExitNull(Tag tag) {
		if (tag == null)
			return false;
		String exitEventType = tag.getProperty(TraceGeneratorConstants.EXIT_EVENT_TYPE_PARAMETER_NAME);
		if (exitEventType == null)
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.javalogtrace.LogQueryPredicates#jTargetBehavior(org.isistan.flabot.trace.log.Tag)
	 */
	@Override
	protected Tag jTargetBehavior(Tag tag) {
		return TagQueryUtil.INSTANCE.getTargetBehavior(tag);
	}
	
	@Override
	protected Tag jTargetInstance(Tag tag) {
		return TagQueryUtil.INSTANCE.getTargetInstance(tag);
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.javalogtrace.LogQueryPredicates#jIsFieldRead(org.isistan.flabot.trace.log.Tag)
	 */
	@Override
	protected boolean jIsFieldRead(Tag tag) {
		if (tag == null)
			return false;
		String eventType = (String) tag.getProperty(TraceGeneratorConstants.EVENT_TYPE_PARAMETER_NAME);
		if (eventType.equals(Gauge.Type.ON_FIELD_READ.getName()))
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.javalogtrace.LogQueryPredicates#jIsFieldWrite(org.isistan.flabot.trace.log.Tag)
	 */
	@Override
	protected boolean jIsFieldWrite(Tag tag) {
		if (tag == null)
			return false;
		String eventType = (String) tag.getProperty(TraceGeneratorConstants.EVENT_TYPE_PARAMETER_NAME);
		if (eventType.equals(Gauge.Type.ON_FIELD_WRITE.getName()))
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.javalogtrace.LogQueryPredicates#jTargetField(org.isistan.flabot.trace.log.Tag)
	 */
	@Override
	protected Tag jTargetField(Tag fieldEventTag) {
		if (fieldEventTag == null)
			return null;
		Tag targetField = (Tag) fieldEventTag.getTags().get(Gauge.AttributeName.TARGET_FIELD);
		return targetField;
	}

	@Override
	protected String jFieldDescriptor(Tag fieldTag) {
		// TODO implement field descriptor generation
		return "";
	}

	protected List<Tag> jCorrelatedTags(List<Tag> tags, TagFilter scope, List<Tag> correlationTags, Correlator correlator) {
		return traceInferenceStrategy.getStateDeterminationStrategy().getCorrelatedTags(tags, scope, correlationTags, correlator);
	}

	@Override
	protected List<Tag> jPopupTagsSelect(List<Tag> tags) {
		return TagFilterDialogManager.INSTANCE.filterTags("Test", tags, Collections.EMPTY_LIST, false);
	}

	@Override
	protected Tag jExecutionThread(Tag executionTag) {
		return TagQueryUtil.INSTANCE.getThread(executionTag);
	}

	@Override
	protected long jTimestamp(Tag eventTag) {
		return TagQueryUtil.INSTANCE.getTimestamp(eventTag).longValue();
	}

	@Override
	protected Tag jExecutionInstanceSnapshot(Tag executionTag) {
		return TagQueryUtil.INSTANCE.getExecutionInstanceSnapshot(executionTag);
	}

	@Override
	protected Tag jSnapshotObject(Tag snapshotTag) {
		return TagQueryUtil.INSTANCE.getObject(snapshotTag);
	}

	@Override
	protected String jObjectId(Tag objectTag) {
		return TagQueryUtil.INSTANCE.getObjectId(objectTag);
	}

	@Override
	protected Tag jObjectClass(Tag objectTag) {
		return TagQueryUtil.INSTANCE.getObjectClass(objectTag);
	}

	@Override
	protected List<Tag> jArguments(Tag executionTag) {
		return TagQueryUtil.INSTANCE.getArguments(executionTag);
	}

	@Override
	protected Tag jReturnValue(Tag executionTag) {
		return TagQueryUtil.INSTANCE.getReturnValue(executionTag);
	}

	@Override
	protected boolean jScopeAcceptsSnapshotTag(Mapping scope, Tag snapshotTag) {
		if (scope == null)
			return true;
		Tag object = TagQueryUtil.INSTANCE.getObject(snapshotTag);
		Tag classTag = TagQueryUtil.INSTANCE.getObjectClass(object);
		if (classTag == null) {
			// class is null, it was a null object snapshot. must be accepted
			return true;
		}
		JClass jClass = new ClassTagJClass(classTag);
		boolean passes = scope.passes(jClass).equals(TriState.TRUE);
		return passes;
	}

	@Override
	protected String jSnapshotToString(Tag snapshotTag) {
		return TagQueryUtil.INSTANCE.getToString(snapshotTag);
	}

	@Override
	protected Map<String, String> jSnapshotFields(Tag snapshotTag) {
		if (snapshotTag == null)
			return null;
		Tag fieldsTag = TagQueryUtil.INSTANCE.getFieldsTag(snapshotTag);
		if (fieldsTag == null)
			return Collections.emptyMap();
		return fieldsTag.getProperties().map();
	}

	@Override
	protected boolean jSnapshotIsNull(Tag snapshotTag) {
		return TagQueryUtil.INSTANCE.isNull(snapshotTag);
	}

}
