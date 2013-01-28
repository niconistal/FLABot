%-*-Prolog-*-
% $Id: ControlPredicates.pl,v 1.2 2002/02/26 18:43:00 azunino Exp $	
true.
fail :- builtIn(fail).
call(X) :- bound(X),X.
','(X,Y) :- bound(X),bound(Y),X,Y.
';'(X,_) :- call(X).
';'(_,Y) :- call(Y).
'->'(If,Then) :- call(If), !, call(Then).
% ';'('->'(If, Then), Else) is true iff and only if 
% (1) If is true and Then is true for the first solution
% of If or (2) If is false and Else is true. 

repeat.
repeat :- repeat.
and(X, Y) :- call(X),call(Y).
not(X) :- call(X),!,fail.
not(_).
'\+'(X) :- call(X),!,fail.
'\+'(_).
