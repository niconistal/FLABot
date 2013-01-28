%-*-Prolog-*-
% $Id: Miscellaneous.pl,v 1.3 2002/02/28 18:02:24 azunino Exp $
collect(S,L) :-
	nextFound(X),
	!,
	collect([X|S],L).
collect(X,X).
findall(X,G,_) :-
	call(G),
        executionStateDialog(Dialog),send(Dialog,preprocessGoal,[X],XWithoutVar),
	fail.

findall(_,_,L) :-
	collect([],M),
	!,
	L=M.
halt :- builtIn(halt).
delay(X) :- bound(X), integer(X), builtIn(delay, X).
sOut(X,Y) :- builtIn(sOut,X,Y).
thread(X) :- builtIn(thread, X).
thread(X,Y):-bound(Y),builtIn(thread,X,Y).
% Si está instanciada tiene éxito. Sino, espera que se instancie
waitFor(X) :- bound(X),!.
waitFor(X) :- builtIn(waitFor, X).
nextFound(X) :-
	retract(found(X)),
	!.
opToken(X, Y) :- builtIn(opToken, X, Y).

trace :- !,builtIn(trace).
notrace:-!,builtIn(notrace).
tracing:-!,builtIn(tracing).

op(P,A,O) :- builtIn(op,P,A,O).
current_op(P,A,O) :-
	prolog(X),
	send(X,operators,[],Y),
	send(Y,elements,[],E),
	nextOp(E,P,A,O).

nextOp(E,P,A,O) :-
	send(E,hasMoreElements,[]),
	send(E,nextElement,[],OP),
	send(OP,op,[],O),
	send(OP,prec,[],P),
	send(OP,typeText,[],A).

nextOp(E,P,A,O) :-
	send(E,hasMoreElements,[]),
	nextOp(E,P,A,O).
prolog(X) :- builtIn(prolog, X).
