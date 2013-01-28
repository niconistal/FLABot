analyzeResponsibilities(Result,Family,CurrentScenario,ExecutionScenario,state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,Type)):-
        analyzeResponsibility(Result,Family,CurrentScenario,ExecutionScenario,state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,Type)).

analyzeResponsibilities(-1,Family,CurrentScenario,ExecutionScenario,state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,Type)).

analyzeResponsibility(PreResponsibilityId,Family,CurrentScenario,ExecutionScenario,state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,constrain)):-
       	State = 'Executed',
       	responsibilityOption(CurrentResponsibility,ComponentType,_),
		getComponentInstanceSource (Family, ComponentType, Instance),
		markResponsibility(CurrentResponsibility,Instance,state(Family,'Faulty',constrain)).
%	markResponsibility(PreResponsibilityId,state(Family,'Faulty',path)),
%	markAllPreviousResponsilitiesFrom(PreResponsibilityId,state(Family,'Faulty',path))

analyzeResponsibility(-1,CurrentScenario,ExecutionScenario,state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,constrain)):-
       	State \= 'Executed',
       	responsibilityOption(PreResponsibilityId,ComponentType,_),
		getComponentInstanceSource (Family, ComponentType, Instance),
       	retractRule(faultyComponent(PreResponsibilityId,Instance,State)),
		assertRule(faultyComponent(PreResponsibilityId,Instance,state(Family,State,current))).

analyzeResponsibility(PreResponsibilityId,Family,CurrentScenario,ExecutionScenario,state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,precondition)):-
       	State \= 'Executed'.
	
analyzeResponsibility(-1,Family,CurrentScenario,ExecutionScenario,state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,precondition)):-
       	State = 'Executed',
       	responsibilityOption(PreResponsibilityId,PreComponentType,_),
		getComponentInstanceSource (Family, PreComponentType, PreInstance),
		markResponsibility(PreResponsibilityId,PreInstance,state(Family,State,precondition)).

analyzeResponsibility(PreResponsibilityId,Family,CurrentScenario,ExecutionScenario,state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,previous)):-
       	State \= 'Executed'.

analyzeResponsibility(-1,Family,CurrentScenario,ExecutionScenario,state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,previous)):-
       	State = 'Executed',
 	responsibilityOption(PreResponsibilityId,PreComponentType,_),
	getComponentInstanceSource (Family, PreComponentType, PreInstance),
	markResponsibility(PreResponsibilityId,PreInstance,state(Family,State,previous)).

analyzeResponsibility(PreResponsibilityId,Family,CurrentScenario,ExecutionScenario,state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,mapping)):-
       	State \= 'Executed'.
       	
analyzeResponsibility(-1,Family,CurrentScenario,ExecutionScenario,state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,mapping)):-
       	State = 'Executed',   
       	responsibilityOption(PreResponsibilityId,ComponentType,_),
		getComponentInstanceSource (Family, ComponentType, Instance),
       	markResponsibility(PreResponsibilityId,Instance,state(Family,State,mapping)).    	

evaluateMultipleErrors([state(CurrentResponsibility1,PreResponsibilityId1,PreviousScenario1,PreviousEvent1,State1,Type1)|R]):-
		analizeState(state(CurrentResponsibility1,PreResponsibilityId1,PreviousScenario1,PreviousEvent1,State1,Type1),R).

evaluateMultipleErrors([state(CurrentResponsibility1,PreResponsibilityId1,PreviousScenario1,PreviousEvent1,State1,Type1)|R]):-
		evaluateMultipleErrors(R).

analizeState(state(CurrentResponsibility1,PreResponsibilityId1,PreviousScenario1,PreviousEvent1,State1,Type1),[state(CurrentResponsibility2,PreResponsibilityId2,PreviousScenario2,PreviousEvent2,State2,Type2)|R]):-
		Type1 \= Type2, verifyStates(State1,State2).
				
analizeState(state(CurrentResponsibility1,PreResponsibilityId1,PreviousScenario1,PreviousEvent1,State1,Type1),[state(CurrentResponsibility2,PreResponsibilityId2,PreviousScenario2,PreviousEvent2,State2,Type2)|R]):-
		analizeState(state(CurrentResponsibility1,PreResponsibilityId1,PreviousScenario1,PreviousEvent1,State1,Type1),R).

verifyStates(State1,State2):-
		State1 = 'NotExecuted',
		State2 = 'NotExecuted'.

verifyStates(State1,State2):-
		State1 = 'NotExecuted',
		State2 = 'Faulty'.

verifyStates(State1,State2):-
		State1 = 'Faulty',
		State2 = 'NotExecuted'.

verifyStates(State1,State2):-
		State1 = 'Faulty',
		State2 = 'Faulty'.

situationCommand (ResponsibilityId,Dependencies,'MultipleErrors',Family):-
	evaluateMultipleErrors(Dependencies),
	responsibilityOption(ResponsibilityId,ComponentType,_),
	getComponentInstanceSource (Family, ComponentType, Instance),
	retractRule(faultyComponent(ResponsibilityId,Instance,PrevState)),
	assertRule(faultyComponent(ResponsibilityId,Instance,state(Family,'MultipleErrors',current))).

situationCommand (ResponsibilityId,Dependencies,'FaultyPrecondition',Family):-
	getDependenciesForType(Dependencies,precondition,Result),
	situationForPrecondition(Result),
	responsibilityOption(ResponsibilityId,ComponentType,_),
	getComponentInstanceSource (Family, ComponentType, Instance),
	retractRule(faultyComponent(ResponsibilityId,Instance,PrevState)),
	assertRule(faultyComponent(ResponsibilityId,Instance,state(Family,'FaultyPrecondition',precondition))).

situationCommand (ResponsibilityId,Dependencies,'FaultyNextLevels',Family):- 
	getDependenciesForType(Dependencies,mapping,Result),
	situationForMapping(Result),
	responsibilityOption(ResponsibilityId,ComponentType,_),
	getComponentInstanceSource (Family, ComponentType, Instance),
	retractRule(faultyComponent(ResponsibilityId,Instance,PrevState)),
	assertRule(faultyComponent(ResponsibilityId,Instance,state(Family,'FaultyNextLevels',current))).

situationCommand (ResponsibilityId,Dependencies,'FaultyPrevious',Family):- 
	getDependenciesForType(Dependencies,previous,Result),
	situationForPrevious(Result),
	responsibilityOption(ResponsibilityId,ComponentType,_),
	getComponentInstanceSource (Family, ComponentType, Instance),
	retractRule(faultyComponent(ResponsibilityId,Instance,PrevState)),
	assertRule(faultyComponent(ResponsibilityId,Instance,state(Family,'FaultyPrevious',current))).

situationCommand (ResponsibilityId,Dependencies,'FaultyConstrain',Family):-
	getDependenciesForType(Dependencies,constrain,Result),
	situationForConstrain(Result),
	responsibilityOption(ResponsibilityId,ComponentType,_),
	getComponentInstanceSource (Family, ComponentType, Instance),
	retractRule(faultyComponent(ResponsibilityId,Instance,PrevState)),
	assertRule(faultyComponent(ResponsibilityId,Instance,state(Family,'FaultyConstrain',current))).

situationCommand (ResponsibilityId,Dependencies,'Executed',Family):- 
	responsibilityLog(ResponsibilityId,Instance,Component,Event,Scenario,'Executed',Step),
	responsibilityOption(ResponsibilityId,ComponentType,_),
	getComponentInstanceSource (Family, ComponentType, Instance),
	retractRule(faultyComponent(ResponsibilityId,Instance,State)),
	assertRule(faultyComponent(ResponsibilityId,Instance,state(Family,'Executed',current))).

situationCommand (ResponsibilityId,Dependencies,'Faulty',Family):-
	getDependenciesForType(Dependencies,previous,Result),
	situationForNotExecuted(Result),	
	responsibilityOption(ResponsibilityId,ComponentType,_),
	getComponentInstanceSource (Family, ComponentType, Instance),
	retractRule(faultyComponent(ResponsibilityId,Instance,PrevState)),
	assertRule(faultyComponent(ResponsibilityId,Instance,state(Family,'Faulty',current))).

situationCommand (ResponsibilityId,Dependencies,'NotExecuted',Family):- 
	responsibilityOption(ResponsibilityId,ComponentType,_),
	getComponentInstanceSource (Family, ComponentType, Instance),
	markResponsibility(ResponsibilityId,Instance,state(Family,'NotExecuted',current)).

situationCommand (ResponsibilityId,Dependencies,'Faulty',Family):- 
	responsibilityOption(ResponsibilityId,ComponentType,_),
	getComponentInstanceSource (Family, ComponentType, Instance),
	markResponsibility(ResponsibilityId,Instance,state(Family,'Faulty',current)).
	
situationForPrecondition ([state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,Type)|Rest]):- 
	State \= 'Executed', faultyComponent(PreResponsibilityId,Instance,state(Family,NewState,current)), NewState \= 'NotExecuted'.
situationForPrecondition ([state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,Type)|Rest]):- 
	situationForPrecondition (Rest).
	
situationForPrevious ([state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,Type)|Rest]):- 
	State \= 'Executed', faultyComponent(PreResponsibilityId,Instance,state(Family,NewState,current)), NewState \= 'NotExecuted'.
situationForPrevious ([state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,Type)|Rest]):- 
	situationForPrevious (Rest).
	
situationForMapping ([state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,Type)|Rest]):- 
	State \= 'Executed', faultyComponent(PreResponsibilityId,Instance,state(Family,NewState,current)), NewState \= 'NotExecuted'.
situationForMapping ([state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,Type)|Rest]):- 
	situationForMapping (Rest).
	
situationForConstrain ([state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,Type)|Rest]):- 
	State \= 'Executed', faultyComponent(PreResponsibilityId,Instance,state(Family,NewState,current)), NewState \= 'NotExecuted'.
situationForConstrain ([state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,Type)|Rest]):- 
	situationForConstrain (Rest).
	
situationForNotExecuted ([state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,Type)|Rest]):- 
	State = 'Executed'.
situationForNotExecuted ([state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,Type)|Rest]):- 
	situationForNotExecuted (Rest).