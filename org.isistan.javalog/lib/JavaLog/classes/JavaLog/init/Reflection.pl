%-*-Prolog-*-
% $Id: Reflection.pl,v 1.1.1.1 2002/02/19 20:41:33 azunino Exp $	
send(O, M, P, R) :- builtIn(send, O, M, P, R), !.
send(O, M, P) :- builtIn(send, O, M, P, _), !.
newInstance(C,N) :- builtIn(newInstance,C,N).
newInstance(C,P,O) :- builtIn(newInstance,C,P,O).
