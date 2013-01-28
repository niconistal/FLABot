%-*-Prolog-*-
% $Id: Equality.pl,v 1.1.1.1 2002/02/19 20:41:33 azunino Exp $	
unify(X, Y) :- builtIn(unify, X, Y).
'='(X, Y) :- builtIn(unify, X, Y).
'\='(X, Y) :- not( builtIn(unify, X, Y) ).
'\=='(X, Y) :- builtIn(ne, X, Y).
'=='(X, Y) :- builtIn(eq, X, Y).
