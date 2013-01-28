%-*-Prolog-*-
% $Id: DataBase.pl,v 1.4 2002/02/28 15:39:37 azunino Exp $	
assert(X) :- bound(X),!,builtIn(assert, X).
asserta(X) :- bound(X),!,builtIn(asserta, X).
assertm(X,Y) :- bound(X),bound(Y),!,builtIn(assertm, X, Y).
assertz(X) :- bound(X),!,builtIn(assert, X).
clause(X,Y):- builtIn(clause, X, Z), iterar(Z,Elem),
              builtIn(clause2, X, Y, Elem).
%iterar(Z,_):- send(Z,hasMoreElements,[],false), !, fail.
iterar(Z,Elem):- send(Z,hasMoreElements,[]),
                 send(Z,nextElement,[],Elem).
iterar(Z,Elem):- send(Z,hasMoreElements,[]),iterar(Z,Elem).
consult(X) :- bound(X),!,builtIn(consult,X).
disable(X):- builtIn(disable,X).
enable(X):- builtIn(enable,X).
listing :- !,builtIn(listing).
listing([]).
listing([H|R]) :- builtIn(listing,H), listing(R).
listing(X) :- !,builtIn(listing,X).
publish(X) :- atom(X), builtIn(publish,X).
publishm(X) :- builtIn(publishm,X).
reconsult(X) :- bound(X),!,builtIn(reconsult,X).
retract(X) :- call(X),builtIn(retract, X).
retractall(A) :- repeat,
                 ( retract(A),
                   fail;
                   true).
abolish(A) :- retractall(A).


% Shows logic modules
listModules :- builtIn(listModules).
assertShared(X):-builtIn(assertShared,X).

% Creates an indexed logic module
createIndexedLogicModule(X) :- bound(X),!,builtIn( createIndexedLogicModule, X ).

% Creates a logic module
createLogicModule(X) :- bound(X),!,builtIn( createLogicModule, X ).

% This is used by ISO Prolog to declare a predicate (predspec) that
% may be inspected and modified. This is the default behavior of JavaLog...
dynamic(_) :- !.

% Consulta un archivo y lo carga en un LM
consultLogicModule(X,Y):- bound(X),bound(Y),!, builtIn(consultLogicModule,X,Y). 

% Carga un modulo logico (persistente o no) dentro de otro (persistente o no).
insertIntoLogicModule(M1,M2):-bound(M1),bound(M2),!, builtIn(insertIntoLogicModule,M1,M2). 
