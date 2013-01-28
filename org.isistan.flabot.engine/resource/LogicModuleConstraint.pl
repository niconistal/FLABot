analyzeResponsibilities(Result,Family,CurrentScenario,ExecutionScenario,state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,Type)):-
        analyzeResponsibility(Result,Family,CurrentScenario,ExecutionScenario,state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,Type)).

analyzeResponsibilities(-1,Family,CurrentScenario,ExecutionScenario,state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,Type)).

analyzeResponsibility(-1,Family,CurrentScenario,ExecutionScenario,state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,constrain)):-
       	State = 'Executed',
      	responsibilityOption(CurrentResponsibility,ComponentType,_),
		getComponentInstanceSource (Family, ComponentType, Instance), 	
	markResponsibility(CurrentResponsibility,Instance,state(Family,'FaultyConstrain',constrain)).

analyzeResponsibility(PreResponsibilityId,Family,CurrentScenario,ExecutionScenario,state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,Type)):-
       	State = 'Executed'.

analyzeResponsibility(-1,Family,CurrentScenario,ExecutionScenario,state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,Type)):-
       	State \= 'Executed',
       	responsibilityOption(PreResponsibilityId,ComponentType,_),
		getComponentInstanceSource (Family, ComponentType, Instance),
       	retractRule(faultyComponent(PreResponsibilityId,Instance,PrevState)),
		assertRule(faultyComponent(PreResponsibilityId,Instance,state(Family,State,current))).

situationCommand (ResponsibilityId,[],'FaultyConstraintStart',Family):-
	responsibilityLog(ResponsibilityId,Instance,Component,Event,Scenario,'Executed',Step),
	responsibilityOption(ResponsibilityId,ComponentType,_),
	getComponentInstanceSource (Family, ComponentType, Instance),
    retractRule(faultyComponent(ResponsibilityId,Instance,PrevState)),
	assertRule(faultyComponent(ResponsibilityId,Instance,state(Family,'FaultyConstraintStart',current))).
	
situationCommand (ResponsibilityId,Dependencies,'FaultyConstraintStart',Family):-
	notExecutedDependencies (Dependencies),
	responsibilityOption(ResponsibilityId,ComponentType,_),
	getComponentInstanceSource (Family, ComponentType, Instance),
	retractRule(faultyComponent(ResponsibilityId,Instance,PrevState)),
	assertRule(faultyComponent(ResponsibilityId,Instance,state(Family,'FaultyConstraintStart',current))).
	
situationCommand (ResponsibilityId,Dependencies,'Executed',Family):- 
	responsibilityLog(ResponsibilityId,Instance,Component,Event,Scenario,'Executed',Step),
	responsibilityOption(ResponsibilityId,ComponentType,_),
	getComponentInstanceSource (Family, ComponentType, Instance),
	retractRule(faultyComponent(ResponsibilityId,Instance,State)),
	assertRule(faultyComponent(ResponsibilityId,Instance,state(Family,'Executed',current))).
	
situationCommand (ResponsibilityId,Dependencies,'Faulty',Family):- 
	responsibilityOption(ResponsibilityId,ComponentType,_),
	getComponentInstanceSource (Family, ComponentType, Instance),
	markResponsibility(ResponsibilityId,Instance,state(Family,'Faulty',current)).

notExecutedDependencies ([]).
notExecutedDependencies ([state(CurrentResponsibility,PreResponsibilityId,PreviousScenario,PreviousEvent,State,Type)|Rest]):-
	State \= 'Executed',
	notExecutedDependencies (Rest).