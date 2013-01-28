%-*-Prolog-*-
% $Id: TermType.pl,v 1.3 2002/03/04 12:28:23 azunino Exp $	
atom([]).
atom(X) :- builtIn(atom, X).
%atomic([]) :- !.
atomic(X) :- builtIn(atomic, X).
bound(X) :- builtIn(bound, X).
ground(X):- builtIn(ground, X).
integer(X) :- builtIn(integer, X).
nonvar(X) :- builtIn(nonvar, X).
var(X) :- builtIn(var, X).
float(X) :- builtIn(pfloat, X).
compound(X) :- builtIn(compound, X).
