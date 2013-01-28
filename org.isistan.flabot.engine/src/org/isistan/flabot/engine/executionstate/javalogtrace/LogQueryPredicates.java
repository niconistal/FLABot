/**
 * 
 */
package org.isistan.flabot.engine.executionstate.javalogtrace;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.isistan.flabot.engine.executionstate.correlation.Correlator;
import org.isistan.flabot.engine.executionstate.javalogtrace.correlatorbuilder.JavalogCorrelatorBuilder;
import org.isistan.flabot.engine.executionstate.javalogtrace.tagfilterbuilder.JavalogTagFilterBuilder;
import org.isistan.flabot.engine.executionstate.tagfilter.TagFilter;
import org.isistan.flabot.mapping.mappingmodel.Mapping;
import org.isistan.flabot.trace.log.Tag;
import org.isistan.flabot.util.javalog.JavalogUtil;

import JavaLog.PlAtom;
import JavaLog.PlJavaObj;
import JavaLog.PlList;
import JavaLog.PlNumber;
import JavaLog.PlReal;
import JavaLog.PlStructArgs;
import JavaLog.PlUVar;

/**
 * This abstract class defines the set of predefined predicates for querying the
 * trace log that must be implemented.
 * All queries have 2 methods, one with the 'pl' prefix and another with the 'j' prefix. 'pl' methods
 * handle the conversion (if necessary) of parameters and return values of their 'j' counterparts
 * to and from javalog-specific types, so that subclassers of this abstract class
 * don't have to worry about javalog-specific details
 * @author mblech
 *
 */
public abstract class LogQueryPredicates {
	
	public static final String FIELD_FUNCTOR = "field";

	/**
	 * Holds the display instance that's used to show popup dialogs
	 */
	private Display display;
	
	/**
	 * Holds the engine instance
	 */
	private TraceInferenceJavalogEngine engine;

	/**
	 * Create a new instance for the given display
	 * @param display
	 * @param engine 
	 */
	public LogQueryPredicates(Display display, TraceInferenceJavalogEngine engine) {
		this.engine = engine;
		this.display = display;
	}
	
	/**
	 * Get the display instance that's used by this LogQueryPredicates instance
	 * @return
	 */
	public Display getDisplay() {
		return display;
	}
	
	/**
	 * Print an object on system out specifying first its class
	 * @param o
	 */
	public void printObject(Object o) {
		if (o!=null)
			System.out.print(o.getClass() + " : ");
		System.out.println(o);
	}
	
	/**
	 * Show the given object and its class on a popup dialog
	 * @param o
	 */
	public void popupDialog(Object o) {
		final StringBuffer message = new StringBuffer();
		if (o != null) {
			message.append(o.getClass());
			message.append('\n');
		}
		message.append(o);
		display.syncExec(new Runnable(){
			public void run() {
				MessageDialog.openInformation(display.getActiveShell(),
						"Javalog popup object", message.toString());
			}});
	}
	
	/**
	 * Javalog converter for jPopupTagsSelect
	 * @param plTags the PlList of tags
	 * @return a PlList containing the selected tags
	 */
	public PlList plPopupTagsSelect(PlList plTags) {
		List<Tag> tags = new LinkedList<Tag>();
		while (!plTags.isEmpty()) {
			PlJavaObj head = (PlJavaObj) plTags.car();
			plTags = (PlList) plTags.cdr();
			tags.add((Tag) head.reference());
		}
		List<Tag> result = jPopupTagsSelect(tags);
		return JavalogUtil.INSTANCE.createPlList(result);
	}
	
	/**
	 * Popup the given list of tags to the user and return the tags that the user
	 * selected
	 * @param tags
	 */
	protected abstract List<Tag> jPopupTagsSelect(List<Tag> tags);

	/**
	 * Check whether the given string matches the given regular expression or not
	 * @param string the string
	 * @param regex the regular expression
	 * @return the result of string.matches(regex)
	 */
	public boolean plRegexMatch(String string, String regex) {
		if (string == null)
			return false;
		if (regex == null)
			return false;
		return string.matches(regex);
	}
	
	/**
	 * Check whether the 2 given strings are equal
	 * @param string1
	 * @param string2
	 * @return
	 */
	public boolean plStringsEqual(String string1, String string2) {
		if (string1 == null)
			return false;
		if (string2 == null)
			return false;
		string1 = JavalogUtil.INSTANCE.escapePrologString(string1);
		string2 = JavalogUtil.INSTANCE.escapePrologString(string2);
		boolean equals = string1.equals(string2);
		return equals;
	}
	
	/**
	 * Check whether string contains substring or not
	 * @param string the string
	 * @param substring the substring
	 * @return true if string contains substring, false otherwise
	 */
	public boolean plStringContains(String string, String substring) {
		if (string == null)
			return false;
		if (substring == null)
			return false;
		string = JavalogUtil.INSTANCE.escapePrologString(string);
		substring = JavalogUtil.INSTANCE.escapePrologString(substring);
		boolean hasSubstring = string.contains(substring);
		return hasSubstring;
	}
		
	/**
	 * Check whether string1 is greater than  string2 (numeric format)
	 * @param string1
	 * @param string2
	 * @return
	 */
	public boolean plStringsGreater(String string1, String string2) {
		if (string1 == null)
			return false;
		if (string2 == null)
			return false;
		string1 = JavalogUtil.INSTANCE.escapePrologString(string1);
		string2 = JavalogUtil.INSTANCE.escapePrologString(string2);
		
		double v1, v2;
		try
		{
			v1 = Double.parseDouble(string1);
			v2 = Double.parseDouble(string2);
		}
		catch (NumberFormatException e)
		{
			return false;
		}
		return v1 > v2;
	}
	
	/**
	 * Check whether string1 is greater equal than  string2 (numeric format)
	 * @param string1
	 * @param string2
	 * @return
	 */
	public boolean plStringsGreaterEqual(String string1, String string2) {
		if (string1 == null)
			return false;
		if (string2 == null)
			return false;
		string1 = JavalogUtil.INSTANCE.escapePrologString(string1);
		string2 = JavalogUtil.INSTANCE.escapePrologString(string2);
		
		double v1, v2;
		try
		{
			v1 = Double.parseDouble(string1);
			v2 = Double.parseDouble(string2);
		}
		catch (NumberFormatException e)
		{
			return false;
		}
		return v1 >= v2;
	}
	
	/**
	 * Check whether string1 is lower than  string2 (numeric format)
	 * @param string1
	 * @param string2
	 * @return
	 */
	public boolean plStringsLower(String string1, String string2) {
		if (string1 == null)
			return false;
		if (string2 == null)
			return false;
		string1 = JavalogUtil.INSTANCE.escapePrologString(string1);
		string2 = JavalogUtil.INSTANCE.escapePrologString(string2);
		
		double v1, v2;
		try
		{
			v1 = Double.parseDouble(string1);
			v2 = Double.parseDouble(string2);
		}
		catch (NumberFormatException e)
		{
			return false;
		}
		return v1 < v2;
	}
	
	/**
	 * Check whether string1 is lower equal than  string2 (numeric format)
	 * @param string1
	 * @param string2
	 * @return
	 */
	public boolean plStringsLowerEqual(String string1, String string2) {
		if (string1 == null)
			return false;
		if (string2 == null)
			return false;
		string1 = JavalogUtil.INSTANCE.escapePrologString(string1);
		string2 = JavalogUtil.INSTANCE.escapePrologString(string2);
		
		double v1, v2;
		try
		{
			v1 = Double.parseDouble(string1);
			v2 = Double.parseDouble(string2);
		}
		catch (NumberFormatException e)
		{
			return false;
		}
		return v1 <= v2;
	}
	
	/**
	 * Javalog converter for jTags
	 * @return
	 */
	public PlList plTags() {
		List<Tag> tagsList = jTags();
		if (tagsList == null)
			return null;
		PlList tagsPlList = JavalogUtil.INSTANCE.createPlList(tagsList);
		return tagsPlList;
	}
	
	private TagFilter buildFilter(PlList filterDescriptor) {
		return JavalogTagFilterBuilder.INSTANCE.buildFilter(filterDescriptor, engine);
	}

	/**
	 * Get the list of all tags in the current context
	 * @return
	 */
	protected abstract List<Tag> jTags();
	
	/**
	 * Javalog converter for jCorrelatedTags
	 * @return
	 */
	public PlList plCorrelatedTags(PlList tags, PlList filterDescriptor, PlList correlationTags, PlList correlatorDescriptor) {
		// build scope
		TagFilter filter = buildFilter(filterDescriptor);
		// extract correlationTags
		List<Tag> correlationTagsList = new LinkedList<Tag>();
		while (!correlationTags.isEmpty()) {
			PlJavaObj head = (PlJavaObj) correlationTags.car();
			correlationTags = (PlList) correlationTags.cdr();
			correlationTagsList.add((Tag) head.reference());
		}
		// extract tags
		List<Tag> tagsList = new LinkedList<Tag>();
		while (!tags.isEmpty()) {
			PlJavaObj head = (PlJavaObj) tags.car();
			tags = (PlList) tags.cdr();
			tagsList.add((Tag) head.reference());
		}
		// build correlator using the descriptor
		Correlator correlator = buildCorrelator(correlatorDescriptor);
		// call jCorrelatedTags
		List<Tag> correlatedTags = jCorrelatedTags(tagsList, filter, correlationTagsList, correlator);
		// convert the return value to PlList
		return JavalogUtil.INSTANCE.createPlList(correlatedTags);
	}
	
	/**
	 * Create the correlator that corresponds to the given descriptor
	 * @param descriptor
	 * @return
	 */
	private Correlator buildCorrelator(PlList descriptor) {
		return JavalogCorrelatorBuilder.INSTANCE.buildCorrelator(descriptor);
	}

	/**
	 * Get the list of correlated tags from the current context, given the
	 * scope, correlation tags and correlator
	 * @param tags the tag list
	 * @param scope the tag scope
	 * @param correlationTags the set of tags to which this context's tags must
	 * be correlated to
	 * @param correlator the correlator
	 * @return a subset the current context's tags that match the given scope
	 * and are accepted by the given correlator
	 */
	protected abstract List<Tag> jCorrelatedTags(
			List<Tag> tags, TagFilter scope, List<Tag> correlationTags, Correlator correlator);

	/**
	 * This method handles prolog conversion for jBehavior
	 * (just delegates because conversion isn't needed)
	 * @param executionTag
	 * @return
	 */
	public Tag plBehavior(Tag executionTag) {
		return jBehavior(executionTag);
	}
	
	/**
	 * Get the behavior tag of the behavior (method or constructor)
	 * that's executed in the given execution tag
	 * @param executionTag the execution tag
	 * @return the behavior tag
	 */
	protected abstract Tag jBehavior(Tag executionTag);
	
	/**
	 * This method handles prolog conversion for jDeclaringClass
	 * (just delegates because conversion isn't needed)
	 * @param behaviorTag
	 * @return
	 */
	public Tag plDeclaringClass(Tag behaviorTag) {
		return jDeclaringClass(behaviorTag);
	}
	
	/**
	 * Get the class tag for the declaring class of the given behavior
	 * @param behaviorTag the behavior tag
	 * @return the declaring class' class tag
	 */
	protected abstract Tag jDeclaringClass(Tag behaviorTag);
	
	/**
	 * This method handles prolog conversion for jBehaviorDescriptor
	 * (just delegates because no conversion is needed)
	 * @param behaviorTag
	 * @return
	 */
	public String plBehaviorDescriptor(Tag behaviorTag) {
		return jBehaviorDescriptor(behaviorTag);
	}
	
	/**
	 * Get the string descriptor of the given behavior tag
	 * @param behaviorTag the behavior tag
	 * @return the descriptor
	 */
	protected abstract String jBehaviorDescriptor(Tag behaviorTag);
	
	/**
	 * this method handles javalog conversion for jClassDescriptor
	 * (no conversion needed, it only delegates)
	 * @param classTag
	 * @return
	 */
	public String plClassDescriptor(Tag classTag) {
		return jClassDescriptor(classTag);
	}
	
	/**
	 * Get the descriptor for the class specified in the given classTag
	 * @param classTag the class tag
	 * @return the descriptor for the class
	 */
	protected abstract String jClassDescriptor(Tag classTag);
	
	/**
	 * This method handles conversion from the List<Tag> returned by
	 * jInternalEvents to PlList for javalog
	 * @param executionTag
	 * @return
	 */
	public PlList plInternalEvents(Tag executionTag) {
		List<Tag> internalEvents = jInternalEvents(executionTag);
		return JavalogUtil.INSTANCE.createPlList(internalEvents);
	}
	
	/**
	 * Get the list of internal event tags within the given execution tag
	 * @param executionTag the execution tag
	 * @return a list containing all the internal event tags
	 */
	protected abstract List<Tag> jInternalEvents(Tag executionTag);
	
	/**
	 * Get the exception that was thrown in the given execution tag
	 * @param executionTag the execution tag
	 * @return the object tag of the exception that was thrown (null if none)
	 */
	protected abstract Tag jExceptionThrown(Tag executionTag);
	
	/**
	 * Get a list of the exceptions that were caught in the given execution tag
	 * @param executionTag the execution tag
	 * @return 
	 */
	protected abstract List<Tag> jExceptionCaught(Tag executionTag);
	
	/**
	 * This method handles javalog conversion for jIsMethodCall
	 * (just delegates because no conversion is necessary)
	 * @param tag
	 * @return
	 */
	public boolean plIsMethodCall(Tag tag) {
		return jIsMethodCall(tag);
	}

	/**
	 * Check whether the given tag represents a method call or not
	 * @param tag the tag
	 * @return true if the tag isn't null and represents a method call
	 */
	protected abstract boolean jIsMethodCall(Tag tag);
	
	/**
	 * Javalog converter for jIsExitError
	 * @param tag
	 * @return
	 */
	public boolean plIsExitError(Tag tag) {
		return jIsExitError(tag);
	}
	
	/**
	 * Check if the given behavior execution or method call tag
	 * indicates that an exception was thrown
	 * @param tag the behavior execution or method call tag
	 * @return true if the given tag isn't null and an exception was thrown
	 */
	protected abstract boolean jIsExitError(Tag tag);
	
	/**
	 * Javalog converter for jIsExitNull
	 * @param tag
	 * @return
	 */
	public boolean plIsExitNull(Tag tag) {
		return jIsExitNull(tag);
	}
	
	/**
	 * Check if the given behavior execution or method call tag
	 * doesn't have an exit event
	 * @param tag the tag
	 * @return true if the tag isn't null and indicates that the behavior execution
	 * never ended
	 */
	protected abstract boolean jIsExitNull(Tag tag);
	
	/**
	 * Javalog converter for jTargetBehavior
	 * @param tag
	 * @return
	 */
	public Tag plTargetBehavior(Tag tag) {
		return jTargetBehavior(tag);
	}
	
	public Tag plTargetInstance(Tag tag) {
		return jTargetInstance(tag);
	}
	
	/**
	 * Get the target behavior tag for the given method call tag
	 * @param tag the method call tag
	 * @return the target behavior tag
	 */
	protected abstract Tag jTargetBehavior(Tag tag);
	
	protected abstract Tag jTargetInstance(Tag tag);
	
	/**
	 * Javalog converter for jIsFieldRead
	 * @param tag
	 * @return
	 */
	public boolean plIsFieldRead(Tag tag) {
		return jIsFieldRead(tag);
	}
	
	/**
	 * Check if the given tag is a field read
	 * @param tag the tag
	 * @return true if the tag isn't null and represents a field read
	 */
	protected abstract boolean jIsFieldRead(Tag tag);
	
	/**
	 * Javalog converter for jIsFieldWrite
	 * @param tag
	 * @return
	 */
	public boolean plIsFieldWrite(Tag tag) {
		return jIsFieldWrite(tag);
	}
	
	/**
	 * Check if the given tag is a field write
	 * @param tag the tag
	 * @return true if the tag isn't null and represents a field write
	 */
	protected abstract boolean jIsFieldWrite(Tag tag);
	
	/**
	 * Javalog converter for jTargetField
	 * @param fieldEventTag
	 * @return
	 */
	public Tag plTargetField(Tag fieldEventTag) {
		return jTargetField(fieldEventTag);
	}
	
	/**
	 * Get the target field tag for the given field read or write tag
	 * @param fieldEventTag a field read or write tag
	 * @return the target field for the field event tag
	 */
	protected abstract Tag jTargetField(Tag fieldEventTag);
	
	
	/**
	 * Javalog converter for jFieldDescriptor
	 * @param fieldTag
	 * @return
	 */
	public String plFieldDescriptor(Tag fieldTag) {
		return jFieldDescriptor(fieldTag);
	}
	
	/**
	 * Get the field descriptor string for the given field tag
	 * @param fieldTag the field tag
	 * @return the descriptor
	 */
	protected abstract String jFieldDescriptor(Tag fieldTag);
	
	/**
	 * Javalog converter for jExecutionThread
	 * @param executionTag
	 * @return
	 */
	public Tag plExecutionThread(Tag executionTag) {
		return jExecutionThread(executionTag);
	}
	
	/**
	 * Get the thread tag for the given execution tag
	 * @param executionTag the execution tag
	 * @return the thread tag for the thread where it executed
	 */
	protected abstract Tag jExecutionThread(Tag executionTag);
	
	/**
	 * Javalog converter for jTimestamp
	 * @param eventTag
	 * @return
	 */
	public PlNumber plTimestamp(Tag eventTag) {
		long timestamp = jTimestamp(eventTag);
		PlNumber plTimestamp = new PlReal(timestamp);
		return plTimestamp;
	}
	
	/**
	 * Get the (entry) timestamp for the given eventTag
	 * @param eventTag
	 * @return
	 */
	protected abstract long jTimestamp(Tag eventTag);
	
	/**
	 * Javalog converter for jInstance
	 * @param executionTag
	 * @return
	 */
	public Tag plExecutionInstanceSnapshot(Tag executionTag) {
		return jExecutionInstanceSnapshot(executionTag);
	}
	
	/**
	 * Get the object instance snapshot tag for the given execution tag
	 * @param executionTag the execution tag
	 * @return the object snapshot tag for the instance where it executed 
	 */
	protected abstract Tag jExecutionInstanceSnapshot(Tag executionTag);
	
	/**
	 * Javalog converter for jSnapshotObject
	 * @param snapshotTag
	 * @return
	 */
	public Tag plSnapshotObject(Tag snapshotTag) {
		return jSnapshotObject(snapshotTag);
	}
	
	/**
	 * Get the object tag for the given snapshot tag
	 * @param snapshotTag the object snapshot tag
	 * @return the object for the given snapshot
	 */
	protected abstract Tag jSnapshotObject(Tag snapshotTag);
	
	/**
	 * Javalog converter for jObjectId
	 * @param objectTag
	 * @return
	 */
	public String plObjectId(Tag objectTag) {
		return jObjectId(objectTag);
	}
	
	/**
	 * Get the object id for the given object tag
	 * @param objectTag the object tag
	 * @return the given object's id
	 */
	protected abstract String jObjectId(Tag objectTag);
	
	/**
	 * Javalog converter for jObjectClass
	 * @param objectTag
	 * @return
	 */
	public Tag plObjectClass(Tag objectTag) {
		return jObjectClass(objectTag);
	}
	
	/**
	 * Get the class tag for the given object tag
	 * @param objectTag the object tag
	 * @return the given object's class tag
	 */
	protected abstract Tag jObjectClass(Tag objectTag);
	
	/**
	 * Javalog converter for jArguments
	 * @param executionTag
	 * @return
	 */
	public PlList plArguments(Tag executionTag) {
		List<Tag> argumentsList = jArguments(executionTag);
		PlList argumentsPlList = JavalogUtil.INSTANCE.createPlList(argumentsList);
		return argumentsPlList;
	}
	
	/**
	 * Get the list of the received arguments' snapshots for the
	 * given execution tag
	 * @param executionTag the execution tag
	 * @return the list of argument snapshots
	 */
	protected abstract List<Tag> jArguments(Tag executionTag);
	
	/**
	 * Javalog converter for jReturnValue
	 * @param executionTag
	 * @return
	 */
	public Tag plReturnValue(Tag executionTag) {
		return jReturnValue(executionTag);
	}
	
	public Tag plExceptionThrown(Tag executionTag) {
		return jExceptionThrown(executionTag);
	}
	
	/**
	 * Get the return value object snapshot tag for the given execution tag
	 * @param executionTag the execution tag
	 * @return the object snapshot tag for the execution's return value
	 */
	protected abstract Tag jReturnValue(Tag executionTag);

	/**
	 * Get the engine used by this instance of log query predicates
	 * @return
	 */
	public TraceInferenceJavalogEngine getEngine() {
		return engine;
	}
	
	/**
	 * Javalog converter for jScopeAcceptsSnapshotTag
	 * @param scope
	 * @param snapshotTag
	 * @return
	 */
	public boolean plScopeAcceptsSnapshotTag(Mapping scope, Tag snapshotTag) {
		return jScopeAcceptsSnapshotTag(scope, snapshotTag);
	}

	/**
	 * Check if the given class scope accepts the given snapshot tag
	 * @param scope the class scope
	 * @param snapshotTag an object snapshot tag
	 * @return whether the scope accepts the tag or not
	 */
	protected abstract boolean jScopeAcceptsSnapshotTag(Mapping scope, Tag snapshotTag);
	
	/**
	 * Javalog converter for jSnapshotToString
	 * @param snapshotTag
	 * @return
	 */
	public String plSnapshotToString(Tag snapshotTag) {
		return jSnapshotToString(snapshotTag);
	}
	
	/**
	 * Get the toString() value for the given snapshot tag
	 * @param snapshotTag the snapshot tag
	 * @return the toString() value for the object at the time the snapshot
	 * was taken
	 */
	protected abstract String jSnapshotToString(Tag snapshotTag);
	
	/**
	 * Javalog converter for jSnapshotFields. Converts the map of fields
	 * to a PlList of field(name,value) structs
	 * @param snapshotTag
	 * @return
	 */
	public PlList plSnapshotFields(Tag snapshotTag) {
		Map<String, String> fieldsMap = jSnapshotFields(snapshotTag);
		Set<Entry<String, String>> entries = fieldsMap.entrySet();
		PlStructArgs[] fields = new PlStructArgs[entries.size()];
		int i = 0;
		for (Entry<String, String> entry: entries) {
			fields[i] = new PlStructArgs(FIELD_FUNCTOR,
					new PlAtom(entry.getKey()),
					new PlAtom(entry.getValue()),
					new PlUVar[]{});
			i++;
		}
		PlList fieldsPlList = PlList.arrayToPlList(fields, new PlUVar[]{});
		return fieldsPlList;
	}
	
	protected abstract Map<String, String> jSnapshotFields(Tag snapshotTag);
	
	public boolean plSnapshotIsNull(Tag snapshotTag) {
		return jSnapshotIsNull(snapshotTag);
	}
	
	protected abstract boolean jSnapshotIsNull(Tag snapshotTag);
}
