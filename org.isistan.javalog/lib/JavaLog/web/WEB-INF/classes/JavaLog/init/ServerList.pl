%-*-Prolog-*-
% $Id: ServerList.pl,v 1.1.1.1 2002/02/19 20:41:33 azunino Exp $	
server(jpMainServer,'//127.0.0.1/PrologServer').
server(jpMainServer,'//localhost/PrologServer').
server(jpMainServer,'//blackmoon.fear/PrologServer').
server(jpMainServer,'//darkstar.nowin/PrologServer').
server(blackmoon,'//blackmoon.fear/PrologServer').
server(darkstar,'//darkstar.nowin/PrologServer').

connect(X,Y) :- builtIn(connect,X,Y).
connect(X) :- builtIn(connect,X).


rcall(Server,Service,Query) :- 
	bound(Query),builtIn(rcall,Server,Service,Query).
rcall(Service,Query) :- 
	bound(Query),builtIn(rcall,Service,Query).
registryObjs(X,Y) :-
	atom(X),
	builtIn(registryObjects,X,Y).
registryObjs(X) :-
	builtIn(registryObjects,localhost,X).
rsolutions(Server,Service,Query,Result) :- 
	bound(Query),builtIn(rsolutions,Server,Service,Query,Result).
rsolutions(Service,Query,Result) :- 
	bound(Query),builtIn(rsolutions,Service,Query,Result).

