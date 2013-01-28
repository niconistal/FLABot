getComponentFamily(FamilyOriginal, FamilyActual, ComponentActual, Instance) :- FamilyOriginal = FamiliyActual, family(FamiliyActual,Instance,ComponentActual,_).
getComponentFamily(FamilyOriginal, FamilyActual, ComponentActual, ComponentToReturn) :- 
					FamilyOriginal \= FamilyActual, 
					family(FamilyActual, ComponentX, ComponentActual, _), 
					family(NewFamilyActual, ComponentY, ComponentX, _),!,
					not(analizedFamily(NewFamilyActual)),
					assertRule(analizedFamily(NewFamilyActual)),
					getComponentFamily(FamilyOriginal, NewFamilyActual, ComponentX, ComponentToReturn),
					retractRule(analizedFamily(NewFamilyActual)).

existsCurrentFamily(Family):- currentFamily(Family).

getFamily(ResponsibilityId,CurrentResponsibilityId,Family):- mapping(ResponsibilityId,B,CurrentResponsibilityId,D,E), responsibilityFamily(ResponsibilityId,CurrentResponsibilityId,Family).
getFamilyToStub(ResponsibilityId,CurrentResponsibilityId,Family):- stub(ResponsibilityId), stubEndPoint(ResponsibilityId,EndPointId),responsibilityFamily(ResponsibilityId,EndPointId,Family).
existConstrain(ResponsibilityId,CurrentResponsibilityId):- constraint(ResponsibilityId,B,CurrentResponsibilityId,D,E).
responsibilityOption (ResponsibilityId,ComponentType,CurrentScenario):-responsibility(ResponsibilityId,ComponentType,CurrentScenario,_).
responsibilityOption (ResponsibilityId,ComponentType,CurrentScenario):-fork(ResponsibilityId,CurrentScenario,_,ComponentType).
responsibilityOption (ResponsibilityId,ComponentType,CurrentScenario):-join(ResponsibilityId,CurrentScenario,_,_,ComponentType).
responsibilityOption (ResponsibilityId,aStubComponent,CurrentScenario):-stub(ResponsibilityId).
chooseInstance(Instance,ComponentType,CurrentScenario):- instance(Instance,ComponentType,CurrentScenario).
chooseInstance(aForkComponent,ComponentType,CurrentScenario):- ComponentType = 'aForkComponent'.

% This rule set the specified State to all the previous responsibilities from a specified one
% previas markAllPreviousResponsilitiesFrom(ResponsibilityId,'BUGGY_RESPONSIBILITY')
markAllPreviousResponsilitiesFrom(ResponsibilityId,State):-previous(ResponsibilityId,NextResponsibilityId,CurrentScenario,Event,PreviousEvent),not(marked(NextResponsibilityId)),markResponsibility(NextResponsibilityId,State),assertRule(marked(NextResponsibilityId)),markAllPreviousResponsilitiesFrom(NextResponsibilityId,State).
markAllPreviousResponsilitiesFrom(ResponsibilityId,State):-retractRule(marked(X)).

%Elige cual es el evento que tiene la precondition que seguir.
% Si existe un event para esa precondicion se sigue con ese. En caso contrario se sigue con el
%mismo evento. Por lo tanto, esta regla determina cual evento seguir por medio de la precondicion.
choosePreconditionEvent(Event,event,Event):- !.
choosePreconditionEvent(Event,PreEvent,PreEvent).

% This rule determines the execution state of the specified responsibility
responsibilityState(PreResponsibility,ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,State,Step,Condition) :- runnedOK(PreResponsibility,ResponsibilityId,Component,Event,Family,CurrentScenario,ExecutionScenario,State,Step,Condition).

% Reglas encargadas de determinar el estado de ejecuci� de una responsabilidad.
% Si no se tiene informacion al respecto, se solicita al usuario que determine dicha informaci�.
runnedOK(PreResponsibility,ResponsibilityId,Component,Event,Family,CurrentScenario,ExecutionScenario,ExecutionInfo,Step,Condition):-
	responsibilityLog(ResponsibilityId,Instance,Component,Event,CurrentScenario,ExecutionInfo,Step),!.
runnedOK(PreResponsibility,ResponsibilityId,Component,Event,Family,CurrentScenario,ExecutionScenario,ExecutionInfo,Step,Condition):-
	not(responsibilityLog(ResponsibilityId,Instance,Component,Event,ExecutionScenario,ExecutionInfo,Step)),
	chooseResponsibilityExecutionState(PreResponsibility,ResponsibilityId,Component,Event,Family,CurrentScenario,ExecutionScenario,ExecutionInfo,Step,Condition).

getExecutionState(PreResponsibility,ResponsibilityId,Instance,PreInstance,Event,Condition,Family,ExecutionInfo):-
	executionStateDialog(Dialog),
    send(Dialog,getExecutionInfo,[PreResponsibility,ResponsibilityId,Instance,PreInstance,Event,Condition,Family],ExecutionInfo),   
    ExecutionInfo \= 'StateFromMapping'.

getExecutionState(PreResponsibility,ResponsibilityId,Instance,PreInstance,Event,Condition,Family,NewExecutionInfo):-
    generateListMappings(ResponsibilityId,Instance,Family,MappingList),
    verifyMappingList(MappingList,NewExecutionInfo).

generateListMappings(ResponsibilityId,Instance,Family,[NewExecutionInfo|Z]):-
	mapping(ResponsibilityId,_,MappingResponsibilityId,_,_),
	not(analyzedMappingState(ResponsibilityId,MappingResponsibilityId)),
    assertRule(analyzedMappingState(ResponsibilityId,MappingResponsibilityId)),
	getFamilyToState(ResponsibilityId,MappingResponsibilityId,Family,NewFamily),
    getInstance(MappingResponsibilityId,NewFamily,MappedInstance),
    executionStateDialog(Dialog),
    send(Dialog,getExecutionInfo,[ResponsibilityId,MappingResponsibilityId,MappedInstance,Instance,Event,Condition,NewFamily],NewExecutionInfo),
    generateListMappings(ResponsibilityId,Instance,Family,Z),
    retractRule(analyzedMappingState(ResponsibilityId,MappingResponsibilityId)).

generateListMappings(ResponsibilityId,Instance,Family,[]).

verifyMappingList([State|Z],State):- State \= 'Executed'.
verifyMappingList([State|Z],ExecutionInfo):- State = 'Executed', verifyMappingList(Z,ExecutionInfo).
verifyMappingList([],'Executed').
    


getFamilyToState(ResponsibilityId,MappingResponsibilityId,Family,NewFamily):- 
	var(Family),
	responsibilityFamily(ResponsibilityId,MappingResponsibilityId,NewFamily).

getFamilyToState(ResponsibilityId,MappingResponsibilityId,Family,NewFamily):- 
	Family = 'Family',
	responsibilityFamily(ResponsibilityId,MappingResponsibilityId,NewFamily).

getFamilyToState(ResponsibilityId,MappingResponsibilityId,Family,Family).

% Muestra un dialogo al usuario con el fin de determinar el estado de ejecuci� de la responsabilidad.
% Luego de que el usuario lo determina, se almacena la informacion para esa responsabilidad en particular.
	
chooseResponsibilityExecutionState(PreResponsibility,ResponsibilityId,Component,Event,Family,CurrentScenario,ExecutionScenario,ExecutionInfo,Step,Condition):-
	    responsibilityOption(ResponsibilityId,ComponentType,CurrentScenario),
	    responsibilityOption(PreResponsibility,PreComponentType,PreCurrentScenario),
        Family = 'Family',
        not(currentFamily(ActualFamily)),
        getEventToFamily(Family,Event,NewEvent),
        getExecutionState(PreResponsibility,ResponsibilityId,ComponentType,PreComponentType,NewEvent,Condition,Family,ExecutionInfo),   
        assertRule(responsibilityLog(ResponsibilityId,Instance,Component,Event,Scenario,ExecutionInfo,Step)),!.

chooseResponsibilityExecutionState(PreResponsibility,ResponsibilityId,Component,Event,Family,CurrentScenario,ExecutionScenario,ExecutionInfo,Step,Condition):-
	    responsibilityOption(ResponsibilityId,ComponentType,CurrentScenario),
	    responsibilityOption(PreResponsibility,PreComponentType,PreCurrentScenario),
		currentFamily(CurrentFamily),
		getComponentFamily(CurrentFamily, Family, ComponentType, Instance),
		getComponentInstanceSource (Family, PreComponentType, PreInstance),
		getEventToFamily(CurrentFamily,Event,NewEvent),
		getExecutionState(PreResponsibility,ResponsibilityId,Instance,PreInstance,NewEvent,Condition,Family,ExecutionInfo),
        assertRule(responsibilityLog(ResponsibilityId,Instance,Component,Event,Scenario,ExecutionInfo,Step)),!.

chooseResponsibilityExecutionState(PreResponsibility,ResponsibilityId,Component,Event,Family,CurrentScenario,ExecutionScenario,ExecutionInfo,Step,Condition):-
	    responsibilityOption(ResponsibilityId,ComponentType,CurrentScenario),
	    responsibilityOption(PreResponsibility,PreComponentType,PreCurrentScenario),
	   	family(Family,Instance,ComponentType,CurrentScenario),
	   	getComponentInstanceSource (Family, PreComponentType, PreInstance),
	   	getEventToFamily(Family,Event,NewEvent),
		getExecutionState(PreResponsibility,ResponsibilityId,Instance,PreInstance,NewEvent,Condition,Family,ExecutionInfo),
        assertRule(responsibilityLog(ResponsibilityId,Instance,Component,Event,Scenario,ExecutionInfo,Step)),!.
        
chooseResponsibilityExecutionState(PreResponsibility,ResponsibilityId,Component,Event,Family,CurrentScenario,ExecutionScenario,ExecutionInfo,Step,Condition):-
	    responsibilityOption(ResponsibilityId,ComponentType,CurrentScenario),
	    responsibilityOption(PreResponsibility,PreComponentType,PreCurrentScenario),
	    getComponentInstanceSource (Family, PreComponentType, PreInstance),
	    getEventToFamily(Family,Event,NewEvent),
		getExecutionState(PreResponsibility,ResponsibilityId,ComponentType,PreInstance,NewEvent,Condition,Family,ExecutionInfo),
        assertRule(responsibilityLog(ResponsibilityId,ComponentType,Component,Event,Scenario,ExecutionInfo,Step)),!.

getEventToFamily(Family,Event,Event):-
		Family = 'Family'.

getEventToFamily(Family,Event,NewEvent):-
		Event \= 'Event',
		Family \= 'Family',
		familyEvent(Family,Event,NewEvent).

getEventToFamily(Family,Event,Event).

getComponentInstanceSource (Family, ComponentType, Instance):-
		currentFamily(CurrentFamily),
		CurrentFamily \= Family,
		getComponentFamily(CurrentFamily, Family, ComponentType, Instance).

getComponentInstanceSource (Family, ComponentType, Instance):-
		currentFamily(CurrentFamily),
		CurrentFamily \= Family,
		getComponentFamily(CurrentFamily, CurrentFamily, ComponentType, Instance).

getComponentInstanceSource (Family, ComponentType, Instance):-
		currentFamily(CurrentFamily),
		CurrentFamily = Family,
		getComponentFamily(CurrentFamily, CurrentFamily, ComponentType, Instance).
		
getComponentInstanceSource (Family, ComponentType, ComponentType):-
		currentFamily(CurrentFamily),
		CurrentFamily = Family.

getComponentInstanceSource (Family, ComponentType, Instance):-
		getComponentFamily(Family, Family, ComponentType, Instance).

getComponentInstanceSource (Family, ComponentType, ComponentType).


% This rule evals one of the preconditions of a specified responsibility.
% This rule is used for the findall rule in order to collect all the precondition
% responsibilities of a specified responsibility
eval(precondition,ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,state(ResponsibilityId,PreResponsibilityId,PreScenario,PreEvent,State,precondition),Step):-
	precondition(ResponsibilityId,_, PreResponsibilityId, PreScenario, PreEvent),
	choosePreconditionEvent(Event,PreEvent,NextEvent),
	responsibilityState(ResponsibilityId,PreResponsibilityId,Family,PreScenario,ExecutionScenario,PreEvent,State,Step,precondition).

eval(previous,ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,state(ResponsibilityId,PreResponsibilityId,PreviousScenario,NextEvent,State,previous),Step):-
	previous(ResponsibilityId,PreResponsibilityId,CurrentScenario,Event,NextEvent),
	responsibilityOption(ResponsibilityId,ComponentType,CurrentScenario),
	getEventToPrevious(ResponsibilityId,ComponentType,PreResponsibilityId,NewEvent,NexEvent),
	responsibilityState(ResponsibilityId,PreResponsibilityId,Family,CurrentScenario,ExecutionScenario,NewEvent,State,Step,previous).
    
eval(constrain,ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,state(ResponsibilityId,PreResponsibilityId,PreviousScenario,PreviousEvent,State,constrain),Step):-
    constraint(ResponsibilityId,CurrentScenario,PreResponsibilityId,PreviousScenario,PreviousEvent),
    responsibilityState(ResponsibilityId,PreResponsibilityId,Family,CurrentScenario,ExecutionScenario,PreviousEvent,State,Step,constraint).

eval(mapping,ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,state(ResponsibilityId,MappedResponsibilityId,MappedResponsibilityScenario,MappedEvent,State,mapping),Step):-
	mapping(ResponsibilityId,CurrentScenario,MappedResponsibilityId,MappedResponsibilityScenario,MappedEvent),
	responsibilityFamily(ResponsibilityId,MappedResponsibilityId,NewFamily),
	responsibilityState(ResponsibilityId,MappedResponsibilityId,NewFamily,MappedResponsibilityScenario,ExecutionScenario,MappedEvent,State,Step,mapping).
	
getEventToPrevious (ResponsibilityId,ComponentType,PreResponsibilityId,NewEvent,NexEvent):-
	previousEvent (ResponsibilityId,ComponentType,PreResponsibilityId,NewEvent).

getEventToPrevious (ResponsibilityId,ComponentType,PreResponsibilityId,NexEvent,NexEvent).

evaluateDependencies(Family,ResponsibilityId,CurrentScenario,ExecutionScenario,Event,Result,Step):-
	evalPreviousResponsibilities(ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,Result,Step),
	verifyCondition(Result).

evaluateDependencies(Family,ResponsibilityId,CurrentScenario,ExecutionScenario,Event,Result,Step):-
	evalPreconditions(ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,PreconditionList,Step),
	evalPreviousResponsibilities(ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,PreviousList,Step),
	append(PreviousList,PreconditionList,Result),
	verifyCondition(Result).

evaluateDependencies(Family,ResponsibilityId,CurrentScenario,ExecutionScenario,Event,Result,Step):-
	evalPreviousResponsibilities(ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,PreviousList,Step),
	evalNextLevels(ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,MappedList,Step),
	append(PreviousList,MappedList,Aux),
	evalPreconditions(ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,PreconditionList,Step),
	append(Aux,PreconditionList,Aux1),
	evalConstrains(ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,ConstrainList,Step),
	append(Aux1,ConstrainList,Result).

especialEvaluateDependencies(Family,ResponsibilityId,CurrentScenario,ExecutionScenario,Event,Result,Step):-
	evalPreviousResponsibilities(ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,PreviousList,Step),
	evalNextLevels(ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,MappedList,Step),
	append(PreviousList,MappedList,Aux),
	evalPreconditions(ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,PreconditionList,Step),
	append(Aux,PreconditionList,Aux1),
	evalConstrains(ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,ConstrainList,Step),
	append(Aux1,ConstrainList,Result).

getMappingOrConstraint(Family,ResponsibilityId,CurrentScenario,ExecutionScenario,Event,Result,Step):-
	evalPreconditions(ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,PreconditionList,Step),
	not(verifyCondition(PreconditionList)),
	evalNextLevels(ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,MappedList,Step),
	evalConstrains(ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,ConstrainList,Step),
	append(MappedList,ConstrainList,Result).
	
evaluateDependencies(Family,ResponsibilityId,CurrentScenario,ExecutionScenario,Event,[],Step).

verifyCondition ([state(ResponsibilityId,PreResponsibilityId,PreviousScenario,PreviousEvent,'NotExecuted',Condition)|R]).
verifyCondition ([state(ResponsibilityId,PreResponsibilityId,PreviousScenario,PreviousEvent,'Faulty',Condition)|R]).
verifyCondition ([state(ResponsibilityId,PreResponsibilityId,PreviousScenario,PreviousEvent,State,Condition)|R]):- State \= 'NotExecuted',   verifyCondition(R).


% Debe buscar por cada responsabilidad todas las precondiciones de todos los escenarios para ese Event
% para luego con cada una, evaluar las anteriores responsabilidad si se ejecutaron para alcanzar esta
% responsabilidad.

evalPreconditions(ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,PreconditionList,Step):-
	findall(State,eval(precondition,ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,State,Step),PreconditionList).

getInstance(PreResponsibilityId,Family,Instance):-
	responsibilityOption(PreResponsibilityId,ComponentType,_),
	getComponentInstanceSource (Family, ComponentType, Instance).
    			
evalPreviousResponsibilities(ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,PreconditionList,Step):-
	findall(State,eval(previous,ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,State,Step),PreconditionList).

evalConstrains(ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,PreconditionList,Step):-
	findall(State,eval(constrain,ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,State,Step),PreconditionList).

evalNextLevels(ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,PreconditionList,Step):-
	findall(State,eval(mapping,ResponsibilityId,Family,CurrentScenario,ExecutionScenario,Event,State,Step),PreconditionList).

chooseState(state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,Type),[state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,Type)|Rest],Type,PreviousEvent,Rest).

% Por cada responsabilidad que es precondicion de la inicial evaluar si ejecuto o no
%[responsibility(PreResponsibilityId,PreScenario,PreEvent),responsibility(PreResponsibilityId,PreScenario,PreEvent)]
evalPreconditionList(Responsibility,[responsibility(PreResponsibilityId,PreScenarioID,PreEvent)|Rest],ExecutionScenario,Event):-
	choosePreconditionEvent(Event,PreEvent,NextEvent),
        evalPrecondition(PreResponsibilityId,PreScenarioID,ExecutionScenario,NextEvent,State),
        evalPreconditionList(Responsibility,Rest,ExecutionScenario,Event).

evalPreconditionList(Responsibility,[],ExecutionScenario,Event).

markResponsibility(ResponsibilityId,Instance,State):-
	faultyComponent(ResponsibilityId,Instance,_),
	retractRule(faultyComponent(ResponsibilityId,Instance,PrevState)),
	assertRule(faultyComponent(ResponsibilityId,Instance,State)),!.

markResponsibility(ResponsibilityId,Instance,State):-
	assertRule(faultyComponent(ResponsibilityId,Instance,State)),!.

getResponsibilityState(ResponsibilityId,State):-
	faultyComponent(ResponsibilityId,Instance,State),!.

%Obtiene el valor del evento entre dos responsabilidades. En caso de no existir un proximo evento
% significa que no cambio de eventos entre ambas responsabilidades y debe ser el mismo.
getEventFor(RespId,NextRespId,CurrentScenary,CurrentEvent,NextEvent) :-
	event(RespId,RespName,ScenaryName,NextRespId,NextRespName,ScenaryName,NextEvent),!.

getEventFor(RespId,NextRespId,CurrentScenary,Event,Event).

chooseFirstCommand(Step,ResponsibilityID, Dependencies, Command):- nextCommand(Step,Command), retractRule(nextCommand(Step,Command)).
chooseFirstCommand(Step,ResponsibilityID, Dependencies, Command):- chooseCommand (Step,ResponsibilityID, Dependencies, Command).
chooseCommand (Step,ResponsibilityID, Dependencies, 'EVALUATE'):- not (evaluateCommand(Step,ResponsibilityID)).	   
chooseCommand (Step,ResponsibilityID, Dependencies, 'EVALUATE'):- not (finishEvaluateMappingANDConstraint(Step)), evaluateMappingANDConstraint(Step), assertRule(finishEvaluateMappingANDConstraint(Step)).	   
chooseCommand (Step,ResponsibilityID, [A|Z], 'ANALYZE'):- not (analyzeCommand(Step,ResponsibilityID)), not(evaluatingJoin(ResponsibilityID)).				   
chooseCommand (Step,ResponsibilityID, Dependencies, 'SITUATION'):- not (situationCommand(Step,ResponsibilityID)), not(evaluatingJoin(ResponsibilityID)).				   
chooseCommand (Step,ResponsibilityID, Dependencies, 'NULL').				   

chooseAnalizeCommand (Step,ResponsibilityID, PreResponsibilityID, none, 'ANALYZE_CONSTRAINT'):- existConstrain(ResponsibilityID,PreResponsibilityID), not (analyzeCommand(Step,ResponsibilityID)).
chooseAnalizeCommand (Step,ResponsibilityID, PreResponsibilityID, Family, 'ANALYZE_MAPPING'):- getFamily(ResponsibilityID,PreResponsibilityID,Family), not (analyzeCommand(Step,ResponsibilityID)).
chooseAnalizeCommand (Step,ResponsibilityID, PreResponsibilityID, none, 'ANALYZE_DEFAULT'):- not (analyzeCommand(Step,ResponsibilityID)).

chooseEvaluateCommand (Step,ResponsibilityID,'EVALUATE_STUB') :- existsStub (ResponsibilityID,Stub), not (analizedStub(ResponsibilityID,Stub,Step)).
chooseEvaluateCommand (Step,ResponsibilityID,'EVALUATE_STUB') :- existsStub (ResponsibilityID,Stub), analizedStub(ResponsibilityID,Stub,Step), stubStartPoint(Stub,StartStub), stubEndPoint(Stub,EndStub), situationForStub(Stub,StartStub,EndStub,State),not(analizedStub(ResponsibilityID,Stub,Step)).
chooseEvaluateCommand (Step,ResponsibilityID,'EVALUATE_JOIN_AND'):- existsJoin (ResponsibilityID,Join), join(ResponsibilityId,CurrentScenario,_,0,_).
chooseEvaluateCommand (Step,ResponsibilityID,'EVALUATE_JOIN_OR'):- existsJoin (ResponsibilityID,Join), join(ResponsibilityId,CurrentScenario,_,1,_).
chooseEvaluateCommand (Step,ResponsibilityID,'EVALUATE_MAPPING_AND_CONSTRAINT'):- evaluateMappingANDConstraint(Step), retractRule(evaluatePreconditionANDConstraint(Step)).
chooseEvaluateCommand (Step,ResponsibilityID,'EVALUATE_DEFAULT').

existsJoin(ResponsibilityID,PreResponsibilityId):- previous(ResponsibilityID,PreResponsibilityId,_,_,_), join(PreResponsibilityId,_,_,_,_).

existsStub(ResponsibilityID,PreResponsibilityId):- previous(ResponsibilityID,PreResponsibilityId,_,_,_), stub(PreResponsibilityId).
existsStub(ResponsibilityID,PreResponsibilityId):- precondition(ResponsibilityID,_, PreResponsibilityId, _, _), stub(PreResponsibilityId).
existsStub(ResponsibilityID,PreResponsibilityId):- mapping(ResponsibilityID,_,PreResponsibilityId,_,_), stub(PreResponsibilityId).
existsStub(ResponsibilityID,PreResponsibilityId):- constraint(ResponsibilityID,_,PreResponsibilityId,_,_), stub(PreResponsibilityId).

getStub(ResponsibilityID,PreResponsibilityId):- previous(ResponsibilityID,PreResponsibilityId,_,_,_), stub(PreResponsibilityId), not (analizedStub(ResponsibilityID,PreResponsibilityId,Step)), assertRule(analizedStub(ResponsibilityID,PreResponsibilityId,Step)).
getStub(ResponsibilityID,PreResponsibilityId):- precondition(ResponsibilityID,_, PreResponsibilityId, _, _), stub(PreResponsibilityId), not (analizedStub(ResponsibilityID,PreResponsibilityId,Step)), assertRule(analizedStub(ResponsibilityID,PreResponsibilityId,Step)).
getStub(ResponsibilityID,PreResponsibilityId):- mapping(ResponsibilityID,_,PreResponsibilityId,_,_), stub(PreResponsibilityId), not (analizedStub(ResponsibilityID,PreResponsibilityId,Step)), assertRule(analizedStub(ResponsibilityID,PreResponsibilityId,Step)).
getStub(ResponsibilityID,PreResponsibilityId):- constraint(ResponsibilityID,_,PreResponsibilityId,_,_), stub(PreResponsibilityId), not (analizedStub(ResponsibilityID,PreResponsibilityId,Step)), assertRule(analizedStub(ResponsibilityID,PreResponsibilityId,Step)).

getJoin(ResponsibilityID,PreResponsibilityId):- previous(ResponsibilityID,PreResponsibilityId,_,_,_), join(PreResponsibilityId,_,_,_,_).

situationForAndJoin(StepToLog,Step,Join,none,none,'Executed'):- assertRule(responsibilityLog(Join,Instance,Component,Event,ExecutionScenario,'Executed',Step)).
situationForAndJoin(StepToLog,Step,Join,none,R2,'Executed'):- responsibilityLog(R2,Instance,Component,Event,CurrentScenario,'Executed',StepToLog),
													assertRule(responsibilityLog(Join,Instance,Component,Event,ExecutionScenario,'Executed',Step)).												
situationForAndJoin(StepToLog,Step,Join,R1,none,'Executed'):- responsibilityLog(R1,Instance,Component,Event,CurrentScenario,'Executed',StepToLog),
													assertRule(responsibilityLog(Join,Instance,Component,Event,ExecutionScenario,'Executed',Step)).																								
situationForAndJoin(StepToLog,Step,Join,R1,R2,'Executed'):- responsibilityLog(R2,Instance,Component,Event,CurrentScenario,'Executed',StepToLog),
												  responsibilityLog(R1,Instance,Component,Event,CurrentScenario,'Executed',StepToLog),
												  assertRule(responsibilityLog(Join,Instance,Component,Event,ExecutionScenario,'Executed',Step)).
situationForAndJoin(StepToLog,Step,Join,R1,R2,'NotExecuted'):- assertRule(responsibilityLog(Join,Instance,Component,Event,ExecutionScenario,'NotExecuted',Step)).												  
 

situationForStub(Stub,StartStub,EndStub,'Executed',Family):-  
											getInstance(EndStub,Family,Instance),
											faultyComponent(EndStub,Instance,state(Family,'Executed',current)),
											assertRule(faultyComponent(Stub,aStubComponent,state(Family,'Executed',current))),
											assertRule(responsibilityLog(Stub,aStubComponent,Component,Event,ExecutionScenario,'Executed',Step)).
situationForStub(Stub,StartStub,EndStub,'NotExecuted',Family):-  faultyComponent(StartStub,Instance,state(Family,'NotExecuted',current)),
											assertRule(faultyComponent(Stub,aStubComponent,state(Family,'NotExecuted',current))),
											assertRule(responsibilityLog(Stub,aStubComponent,Component,Event,ExecutionScenario,'NotExecuted',Step)).
situationForStub(Stub,StartStub,EndStub,'Faulty',Family):-  assertRule(faultyComponent(Stub,aStubComponent,state(Family,'Faulty',current))),
													 assertRule(responsibilityLog(Stub,aStubComponent,Component,Event,ExecutionScenario,'Faulty',Step)).
											
getDependenciesForType([state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,TypeI)|Rest],TypeI,[state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,TypeI)|Result]):-
	getDependenciesForType(Rest,TypeI,Result).
getDependenciesForType([state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,TypeI)|Rest],TypeII,Result):-
	TypeI \= TypeII,
	getDependenciesForType(Rest,TypeII,Result).
getDependenciesForType([],Type,[]).

getFinalResult(Result):-
findall(faultyComponent(Responsibility,Instance,State),faultyComponent(Responsibility,Instance,State) , List),
        processList(List,Result).

processList([faultyComponent(Responsibility,Instance,State)|T],[faultyComponent(Responsibility,Instance,ResponsibilityName,State)|PT]):-
	responsibilityOption(Responsibility,X,Y),
	processList(T,PT).
processList([],[]).

resetLog(X):- responsibilityLog(X,Instance, Component, Event, Scenario,State),
	retractRule(responsibilityLog(X,Instance, Component, Event, Scenario,State)),
        fail.
resetLog(X).

reset(X):- resetLog(X),resetState(X).

assertModification(X):-
	executionStateDialog(Dialog),send(Dialog,preprocessGoal,[X],XWithoutVar),
	assertRule(XWithoutVar).

showLogInfo(LogInfo):-
	executionStateDialog(Dialog),!,
	send(Dialog,showLogInfo,[LogInfo],Result),!.

selectResponsibilities(ResponsibilityList,Result):-
	executionStateDialog(Dialog),
        send(Dialog,selectResponsibilities,[ResponsibilityList],Elements),
        deleteAllElements(Elements,ResponsibilityList,Result).

assertRule (Rule):- 
		%assert(Rule),
		executionStateDialog(Dialog),
        send(Dialog,assertRule,[Rule],ExecutionInfo).
        
retractRule (Rule):- 
		%retractall(Rule),
		executionStateDialog(Dialog),
        send(Dialog,retractRule,[Rule],ExecutionInfo).
        
resetResponsibilityState(ResponsibilityID,Step):- retractRule(evaluateCommand(Step,ResponsibilityID)),!, 
												  retractRule(analyzeCommand(Step,ResponsibilityID)),!,
												  retractRule(situationCommand(Step,ResponsibilityID)),!.
												  
updateDependencies(PreviousResponsibilityList,Result,Branch):-
	evalBranchCondition(PreviousResponsibilityList,Branch,Result).

evalBranchCondition ([],Branch,[]).
evalBranchCondition ([state(ResponsibilityId,Branch,PreviousScenario,NextEvent,State,previous)|Z],Branch,[state(ResponsibilityId,Branch,PreviousScenario,NextEvent,State,previous)|Rest]):- evalBranchCondition(Z,Branch,Rest).
evalBranchCondition ([state(ResponsibilityId,Branch1,PreviousScenario,NextEvent,State,previous)|Z],Branch,Rest) :- Branch \= Branch1, evalBranchCondition(Z,Branch,Rest).
	
	
	
	
	
	
	
	