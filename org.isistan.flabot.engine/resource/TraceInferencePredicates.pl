% adapter between the internally consulted executionState/5 and the user-specified
% eventState/2 that was asserted by the fault locator engine
executionState(LogQueryPredicates, ResponsibilityId, PreResponsibilityId, EventId, State) :-
	assert(logQueryPredicates(LogQueryPredicates)),
	assert(responsibilityId(ResponsibilityId)),
	assert(preResponsibilityId(PreResponsibilityId)),
	assert(eventId(EventId)),
	indirectEventState(EventId, State),
	retract(eventId(EventId)),
	retract(preResponsibilityId(PreResponsibilityId)),
	retract(responsibilityId(ResponsibilityId)),
	retract(logQueryPredicates(LogQueryPredicates)).
	
% indirect event state (uses event state)
indirectEventState(EventId, State) :-
	eventState(EventId, State).
	
% indirect event state (uses execution state)
indirectEventState(_, State) :-
	executionState(State).

% print the given object on the output stream (specifying first its class if not null)
printObject(Object) :-
	logQueryPredicates(P),
	send(P, printObject, [Object], _), !.
	
% show a popup dialog with the given object (specifying first its class if not null)
popupDialog(Object) :-
	logQueryPredicates(P),
	send(P, popupDialog, [Object], _), !.

% show a popup dialog with the given tags list and instantiate the list of user selected tags	
popupTagsSelect(TagsList, SelectedTagsList) :-
	logQueryPredicates(P),
	send(P, plPopupTagsSelect, [TagsList], SelectedTagsList), !.
	
% check if the given string matches the given regular expression
regexMatch(String, Regex) :-
	logQueryPredicates(P),
	send(P, plRegexMatch, [String, Regex], Return),
	Return == true, !.
	
% check if the 2 given strings are equal
stringsEqual(String1, String2) :-
	logQueryPredicates(P),
	send(P, plStringsEqual, [String1, String2], Return),
	Return == true, !.
	
% check if the given string contains the given substring
stringContains(String, Substring) :-
	logQueryPredicates(P),
	send(P, plStringContains, [String, Substring], Return),
	Return == true, !.
	
% instantiate the execution tag list for the current context
tags(TagList) :-
	logQueryPredicates(P),
	send(P, plTags, [], TagList),
	TagList \== null, !.
	
% instantiate the current filter settings (event override)
filterSettings(Filter) :-
	eventId(EventId),
	filter(EventId, Filter).
	
% instantiate the current filter settings (provided by the responsibility)
filterSettings([]).

% instantiate the current scope
scope(CurrentScope) :-
	responsibilityId(ResponsibilityId),
	scope(ResponsibilityId, CurrentScope).

% instantiate the previous scope
preScope(PreScope) :-
	preResponsibilityId(PreResponsibilityId),
	scope(PreResponsibilityId, PreScope).

% instantiate a correlated execution tag from the current context (deprecated, use correlatedTag instead)
executionTag(ExecutionTag) :-
	correlatedTag(ExecutionTag).
	
% instantiate a correlated execution tag from the current context
correlatedTag(Tag) :-
	correlatedTags(TagList), !,
	member(Tag, TagList).

% instantiate an (uncorrelated) execution tag from the current context
tag(Tag) :-
	tags(TagList),
	member(Tag, TagList).
	
% instantiate the list of correlated tags for the current context (cached)
correlatedTags(TagList) :-
	responsibilityId(ResponsibilityId),
	cachedCorrelatedTags(ResponsibilityId, TagList), !.
	
% instantiate the pre filtered tag list (tags that were accepted by the preFilter)
preFilteredTags([], []).

preFilteredTags([Tag| TagList], [Tag| FilteredTagList]) :-
	generalPreFilter(Tag),
	preFilterAccepts(Tag),
	preFilteredTags(TagList, FilteredTagList), !.
	
preFilteredTags([Tag| TagList], FilteredTagList) :-
	preFilteredTags(TagList, FilteredTagList), !.
	
% check if the preFilter accepts the given tag
generalPreFilter(Tag) :-
	generalPreFilter,
	generalPreFilterAccepts(Tag).

preFilterAccepts(Tag) :-
	eventId(EventId),
	eventPreFilter(EventId),
	eventPreFilterAccepts(EventId, Tag).
	
preFilterAccepts(Tag) :-
	eventId(EventId),
	not(eventPreFilter(EventId)),
	responsibilityPreFilter,
	responsibilityPreFilterAccepts(Tag).
	
preFilterAccepts(Tag) :-
	not(responsibilityPreFilter),
	eventId(EventId),
	not(eventPreFilter(EventId)).
	
% instantiate the list of correlated tags for the current context (calculate)
correlatedTags(CorrelatedTagList) :-
	tags(TagList),
	preFilteredTags(TagList, FilteredTagList),
	preCorrelatedTags(PreTagList),
	correlationParams(CorrelationParams),
	correlatedTags(FilteredTagList, PreTagList, CorrelationParams, CorrelatedTagList), !.
	
% get the correlation parameters specified by the user in the correlationSettings
correlationParams(CorrelationParams) :-
	correlationSettings(CorrelationParams), !.
	
% default correlation parameters
correlationParams([and, [sameThread], [lastExecution]]).

% instantiate the list of correlated tags for the previous context (cached)
preCorrelatedTags(PreTagList) :-
	preResponsibilityId(PreResponsibilityId),
	cachedCorrelatedTags(PreResponsibilityId, PreTagList).
	
% instantiate the list of correlated tags for the previous context (cache failed, instantiate the empty list)
preCorrelatedTags([]).
	
% instantiate the list of correlated tags using the given
% tag list, previous tag list and correlation parameters
correlatedTags(TagList, PreTagList, CorrelationParams, CorrelatedTagList) :-
	filterSettings(Filter),
	logQueryPredicates(P),
	send(P, plCorrelatedTags, [TagList, Filter, PreTagList, CorrelationParams], CorrelatedTagList),
	CorrelatedTagList \== null,
	assertCorrelated(CorrelatedTagList), !.
	
% assert the current correlated tag list (add to cache)
assertCorrelated(CorrelatedTagList) :-
	responsibilityId(Id),
	retractCorrelated(Id),
	assert(cachedCorrelatedTags(Id, CorrelatedTagList)).
	
% retract the correlated tag list with the given id from the cache
retractCorrelated(Id) :-
	retract(cachedCorrelatedTags(Id,_)).
	
% retract the correlated tag list with the given id from the cache
retractCorrelated(Id).

% instantiate the behavior tag for the given execution tag
behavior(ExecutionTag, BehaviorTag) :-
	logQueryPredicates(P),
	send(P, plBehavior, [ExecutionTag], BehaviorTag),
	BehaviorTag \== null, !.
	
% instantiate the behavior descriptor for the given behavior tag
behaviorDescriptor(BehaviorTag, BehaviorDescriptor) :-
	logQueryPredicates(P),
	send(P, plBehaviorDescriptor, [BehaviorTag], BehaviorDescriptor),
	BehaviorDescriptor \== null, !.
	
% check if the given execution tags behavior descriptor equals the given descriptor and
% instantiate the behavior tag
behaviorEquals(ExecutionTag, Descriptor, BehaviorTag) :-
	behavior(ExecutionTag, BehaviorTag),
	behaviorDescriptor(BehaviorTag, BehaviorDescriptor),
	stringsEqual(BehaviorDescriptor, Descriptor).
	
% check if the given execution tags behavior descriptor equals the given descriptor
behaviorEquals(ExecutionTag, Descriptor) :-
	behaviorEquals(ExecutionTag, Descriptor, _).

% check if the given execution tags behavior descriptor matches the given regex
% and instantiate the behavior tag
behaviorMatches(ExecutionTag, Regex, BehaviorTag) :-
	behavior(ExecutionTag, BehaviorTag),
	behaviorDescriptor(BehaviorTag, BehaviorDescriptor),
	regexMatch(BehaviorDescriptor, Regex).

% check if the given execution tags behavior descriptor matches the given regex
behaviorMatches(ExecutionTag, Regex) :-
	behaviorMatches(ExecutionTag, Regex, _).

% instantiate the declaring class tag for the given behavior tag	
declaringClass(BehaviorTag, ClassTag) :-
	logQueryPredicates(P),
	send(P, plDeclaringClass, [BehaviorTag], ClassTag),
	ClassTag \== null, !.
	
% instantiate the class descriptor for the given class tag
classDescriptor(ClassTag, ClassDescriptor) :-
	logQueryPredicates(P),
	send(P, plClassDescriptor, [ClassTag], ClassDescriptor),
	ClassDescriptor \== null, !.

% instantiate the internal event tag list for the given execution tag
internalEventList(ExecutionTag, InternalEventTagList) :-
	logQueryPredicates(P),
	send(P, plInternalEvents, [ExecutionTag], InternalEventTagList), !.

% instantiate an internal event tag from the given execution tag
internalEvent(ExecutionTag, InternalEventTag) :-
	internalEventList(ExecutionTag, InternalEventTagList),
	member(InternalEventTag, InternalEventTagList).
	
% check if the given event tag is a method call
isMethodCall(Tag) :-
	logQueryPredicates(P),
	send(P, plIsMethodCall, [Tag], Result),
	Result == true, !.

% instantiate an internal method call from the given execution tag
internalMethodCall(ExecutionTag, MethodCallTag) :-
	internalEvent(ExecutionTag, MethodCallTag),
	isMethodCall(MethodCallTag).
	
% check if the given execution or method call tags exit event is an error (an exception was thrown)
isExitError(ExecutionTag) :-
	logQueryPredicates(P),
	send(P, plExceptionThrown, [ExecutionTag], Result),
	Result == true, !.

% check if the given execution or method call tags exit event is null (the execution never ended)
isExitNull(ExecutionTag) :-
	logQueryPredicates(P),
	send(P, plIsExitNull, [ExecutionTag], Result),
	Result == true, !.

% check if the given execution or method call tags exit event is error or null
% (an exception was thrown or the execution never ended)	
isExitErrorOrNull(ExecutionTag) :-
	isExitError(ExecutionTag);
	isExitNull(ExecutionTag).
	
% instantiate the target behavior tag from the given call tag
targetBehavior(CallTag, BehaviorTag) :-
	logQueryPredicates(P),
	send(P, plTargetBehavior, [CallTag], BehaviorTag),
	BehaviorTag \== null, !.
	
% check if the target behavior descriptor equals the given descriptor and instantiate the
% target behavior tag
targetBehaviorEquals(CallTag, Descriptor, BehaviorTag) :-
	targetBehavior(CallTag, BehaviorTag),
	behaviorDescriptor(BehaviorTag, BehaviorDescriptor),
	stringsEqual(BehaviorDescriptor, Descriptor).
	
% check if the target behavior descriptor equals the given descriptor
targetBehaviorEquals(CallTag, Descriptor) :-
	targetBehaviorEquals(CallTag, Descriptor, _).
	
% check if the target behavior descriptor matches the given descriptor and instantiate the
% target behavior tag
targetBehaviorMatches(CallTag, Regex, BehaviorTag) :-
	targetBehavior(CallTag, BehaviorTag),
	behaviorDescriptor(BehaviorTag, BehaviorDescriptor),
	regexMatch(BehaviorDescriptor, Regex).
	
% check if the target behavior descriptor matches the given descriptor
targetBehaviorMatches(CallTag, Descriptor) :-
	targetBehaviorMatches(CallTag, Descriptor, _).
	
% instantiate an internal method call tag from the given execution tag whos target
% behavior descriptor equals the given descriptor
internalMethodCallEquals(ExecutionTag, Descriptor, MethodCallTag) :-
	internalMethodCall(ExecutionTag, MethodCallTag),
	targetBehaviorEquals(MethodCallTag, Descriptor).
	
% check if the given execution tag has an internal method call tag whos target
% behavior descriptor equals the given descriptor
internalMethodCallEquals(ExecutionTag, Descriptor) :-
	internalMethodCallEquals(ExecutionTag, Descriptor, _).
	
% instantiate an internal method call tag from the given execution tag whos target
% behavior descriptor matches the given regular expresion
internalMethodCallMatches(ExecutionTag, Regex, MethodCallTag) :-
	internalMethodCall(ExecutionTag, MethodCallTag),
	targetBehaviorMatches(MethodCallTag, Regex).
	
% check if the given execution tag has an internal method call tag whos target
% behavior descriptor matches the given regular expresion
internalMethodCallMatches(ExecutionTag, Regex) :-
	internalMethodCallMatches(ExecutionTag, Regex, _).
	
% check if the given event tag represents a field read
isFieldRead(Tag) :-
	logQueryPredicates(P),
	send(P, plIsFieldRead, [Tag], Result),
	Result == true, !.
	
% instantiate an internal field read tag from the given execution tag
internalFieldRead(ExecutionTag, FieldReadTag) :-
	internalEvent(ExecutionTag, FieldReadTag),
	isFieldRead(FieldReadTag).
	
% check if the given event tag represents a field write 
isFieldWrite(Tag) :-
	logQueryPredicates(P),
	send(P, plIsFieldWrite, [Tag], Result),
	Result == true, !.
	
% instantiate an internal field write event from the given execution tag
internalFieldWrite(ExecutionTag, FieldWriteTag) :-
	internalEvent(ExecutionTag, FieldWriteTag),
	isFieldWrite(FieldWriteTag).
	
% check if the given tag is a field (read or write) event
isFieldEvent(FieldEvent) :-
	isFieldRead(FieldEvent);
	isFieldWrite(FieldEvent).
	
% instantiate an internal field (read or write) event from the given execution tag
internalFieldEvent(ExecutionTag, FieldEventTag) :-
	internalEvent(ExecutionTag, FieldEventTag),
	isFieldEvent(FieldEventTag).
	
% instantiate the target field tag for the given field event tag
targetField(FieldEventTag, FieldTag) :-
	logQueryPredicates(P),
	send(P, plTargetField, [FieldEventTag], FieldTag),
	FieldTag \== null, !.
	
% instantiate the field descriptor for the given field tag
fieldDescriptor(FieldTag, FieldDescriptor) :-
	logQueryPredicates(P),
	send(P, plFieldDescriptor, [FieldTag], FieldDescriptor),
	FieldDescriptor \== null, !.
	
% check if the target fields descriptor equals the given descriptor and
% instantiate the field tag
targetFieldEquals(FieldEventTag, Descriptor, FieldTag) :-
	targetField(FieldEventTag, FieldTag),
	fieldDescriptor(FieldTag, FieldDescriptor),
	stringsEqual(Descriptor, FieldDescriptor).

% check if the target fields descriptor equals the given descriptor
targetFieldEquals(FieldEventTag, Descriptor) :-
	targetFieldEquals(FieldEventTag, Descriptor, _).
	
% check if the target fields descriptor matches the given regular expression
% and instantiate the field tag
targetFieldMatches(FieldEventTag, Regex, FieldTag) :-
	targetField(FieldEventTag, FieldTag),
	fieldDescriptor(FieldTag, FieldDescriptor),
	regexMatch(FieldDescriptor, Regex).
	
% check if the target fields descriptor equals the given descriptor
targetFieldMatches(FieldEventTag, Regex) :-
	targetFieldMatches(FieldEventTag, Regex, _).
	
% instantiate a field read tag from the given execution tag whose target
% field descriptor equals the given descriptor
internalFieldReadEquals(ExecutionTag, Descriptor, FieldReadTag) :-
	internalFieldRead(ExecutionTag, FieldReadTag),
	targetFieldEquals(FieldReadTag, Descriptor).
	
% check if the given execution tag has an internal field read tag whose target
% field descriptor equals the given descriptor
internalFieldReadEquals(ExecutionTag, Descriptor) :-
	internalFieldReadEquals(ExecutionTag, Descriptor, _).
	
% instantiate a field read tag from the given execution tag whose target
% field descriptor matches the given regular expression
internalFieldReadMatches(ExecutionTag, Regex, FieldReadTag) :-
	internalFieldRead(ExecutionTag, FieldReadTag),
	targetFieldMatches(FieldReadTag, Regex).
	
% check if the given execution tag has an internal field read tag whose target
% field descriptor matches the given regular expression
internalFieldReadMatches(ExecutionTag, Regex) :-
	internalFieldReadMatches(ExecutionTag, Regex, _).
	
% instantiate a field write tag from the given execution tag whose target
% field descriptor equals the given descriptor
internalFieldWriteEquals(ExecutionTag, Descriptor, FieldWriteTag) :-
	internalFieldWrite(ExecutionTag, FieldWriteTag),
	targetFieldEquals(FieldWriteTag, Descriptor).
	
% check if the given execution tag has an internal field write tag whose target
% field descriptor equals the given descriptor
internalFieldWriteEquals(ExecutionTag, Descriptor) :-
	internalFieldWriteEquals(ExecutionTag, Descriptor, _).
	
% instantiate a field write tag from the given execution tag whose target
% field descriptor matches the given regular expression
internalFieldWriteMatches(ExecutionTag, Regex, FieldWriteTag) :-
	internalFieldWrite(ExecutionTag, FieldWriteTag),
	targetFieldMatches(FieldWriteTag, Regex).
	
% check if the given execution tag has an internal field write tag whose target
% field descriptor matches the given regular expression
internalFieldWriteMatches(ExecutionTag, Regex) :-
	internalFieldWriteMatches(ExecutionTag, Regex, _).
	
% instantiate a field event (read or write) tag from the given execution tag whose target
% field descriptor equals the given descriptor
internalFieldEventEquals(ExecutionTag, Descriptor, FieldEventTag) :-
	internalFieldEvent(ExecutionTag, FieldEventTag),
	targetFieldEquals(FieldEventTag, Descriptor).
	
% check if the given execution tag has an internal field event (read or write) tag whose target
% field descriptor equals the given descriptor
internalFieldEventEquals(ExecutionTag, Descriptor) :-
	internalFieldEventEquals(ExecutionTag, Descriptor, _).
	
% instantiate a field event (read or write) tag from the given execution tag whose target
% field descriptor matches the given regular expression
internalFieldEventMatches(ExecutionTag, Regex, FieldEventTag) :-
	internalFieldEvent(ExecutionTag, FieldEventTag),
	targetFieldMatches(FieldEventTag, Regex).
	
% check if the given execution tag has an internal field event (read or write) tag whose target
% field descriptor matches the given regular expression
internalFieldEventMatches(ExecutionTag, Regex) :-
	internalFieldEventMatches(ExecutionTag, Regex, _).
	
% instantiate the thread tag for the given execution tag
executionThread(ExecutionTag, ThreadTag) :-
	logQueryPredicates(P),
	send(P, plExecutionThread, [ExecutionTag], ThreadTag),
	ThreadTag \== null, !.
	
% instantiate the (entry) timestamp for the given event tag
timestamp(EventTag, Timestamp) :-
	logQueryPredicates(P),
	send(P, plTimestamp, [EventTag], Timestamp),
	Timestamp \== null, !.
	
% instantiate the object instance snapshot tag for given execution tag
executionInstanceSnapshot(ExecutionTag, SnapshotTag) :-
	logQueryPredicates(P),
	send(P, plExecutionInstanceSnapshot, [ExecutionTag], SnapshotTag),
	SnapshotTag \== null, !.
	
% instantiate the object instance tag for the given snapshot tag
snapshotObject(SnapshotTag, ObjectTag) :-
	logQueryPredicates(P),
	send(P, plSnapshotObject, [SnapshotTag], ObjectTag),
	ObjectTag \== null, !.
	
% instantiate the object id for the given object tag
objectId(ObjectTag, ObjectId) :-
	logQueryPredicates(P),
	send(P, plObjectId, [ObjectTag], ObjectId),
	ObjectId \== null, !.
	
% instantiate the class tag for the given object tag
objectClass(ObjectTag, ClassTag) :-
	logQueryPredicates(P),
	send(P, plObjectClass, [ObjectTag], ClassTag),
	ClassTag \== null, !.
	
% instantiate the list of arguments for the given execution tag
% (each argument is an object snapshot)
arguments(ExecutionTag, Arguments) :-
	logQueryPredicates(P),
	send(P, plArguments, [ExecutionTag], Arguments),
	Arguments \== null, !.
	
% instantiate an argument's object snapshot for the given execution tag
argument(ExecutionTag, Argument) :-
	arguments(ExecutionTag, Arguments),
	member(Argument, Arguments).
	
% instantiate the return value for the given execution tag
returnValue(ExecutionTag, ReturnValue) :-
	logQueryPredicates(P),
	send(P, plReturnValue, [ExecutionTag], ReturnValue),
	ReturnValue \== null, !.
	
% get the toString value for the given object snapshot tag
snapshotToString(SnapshotTag, ToStringValue) :-
	logQueryPredicates(P),
	send(P, plSnapshotToString, [SnapshotTag], ToStringValue),
	ToStringValue \== null, !.
	
% instantiate the list of the given snapshots fields
snapshotFields(SnapshotTag, FieldList) :-
	logQueryPredicates(P),
	send(P, plSnapshotFields, [SnapshotTag], FieldList),
	FieldList \== null, !.
	
% instantiate a field from the given snapshot
snapshotField(SnapshotTag, Field) :-
	snapshotFields(SnapshotTag, FieldList),
	member(Field, FieldList).
	
% check if the given snapshot tag is the snapshot of a null reference
snapshotIsNull(SnapshotTag) :-
	logQueryPredicates(P),
	send(P, plSnapshotIsNull, [SnapshotTag], Result),
	Result == true.

elemetAt([H|_], 0, H).
elemetAt([H|List], X, Y):- X1 is X - 1, elemetAt(List,X1, Y).

% check if String1 is greater String2 (number format)
stringsGreater(String1, String2) :-
	logQueryPredicates(P),
	send(P, plStringsGreater, [String1, String2], Return),
	Return == true, !.
	
% check if String1 is greater equal String2 (number format)
stringsGreaterEqual(String1, String2) :-
	logQueryPredicates(P),
	send(P, plStringsGreaterEqual, [String1, String2], Return),
	Return == true, !.

% check if String1 is lower String2 (number format)
stringsLower(String1, String2) :-
	logQueryPredicates(P),
	send(P, plStringsLower, [String1, String2], Return),
	Return == true, !.
	
% check if String1 is lower equal String2 (number format)
stringsLowerEqual(String1, String2) :-
	logQueryPredicates(P),
	send(P, plStringsLowerEqual, [String1, String2], Return),
	Return == true, !.

targetInstance(CallTag, InstanceTag) :-
	logQueryPredicates(P),
	send(P, plTargetInstance, [CallTag], InstanceTag),
	InstanceTag \== null, !.
	
% check if the given scope accepts the given snapshot tag
scopeAcceptsSnapshot(Scope, [SnapshotTag]) :-
	logQueryPredicates(P),
	send(P, plScopeAcceptsSnapshotTag, [Scope, SnapshotTag], ReturnValue),
	ReturnValue == true, !.

scopeAcceptsSnapshot(Scope, [SnapshotTag|SnapshotTags]) :-
	scopeAcceptsSnapshot(Scope, SnapshotTag),
	scopeAcceptsSnapshot(Scope, SnapshotTags).	
	
% instantiate exception thrown for the given execution tag
exceptionThrown(ExecutionTag, Exception) :-
	logQueryPredicates(P),
	send(P, plExceptionThrown, [ExecutionTag], Exception),
	Exception \== null, !.