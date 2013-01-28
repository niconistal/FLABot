%-*-Prolog-*-
% $Id: Arithmetic.pl,v 1.2 2002/03/13 15:16:52 azunino Exp $	
'is'(X, Y) :- builtIn('is', X, Y).
'<'(X, Y) :- builtIn(lt, X, Y).
'>'(X, Y) :- builtIn(gt, X, Y).
'=<'(X, Y) :- builtIn(le, X, Y).
'<='(X, Y) :- builtIn(le, X, Y).
'>='(X, Y) :- builtIn(ge, X, Y).
'=\='(X, Y) :- builtIn(arith_neq, X, Y).
'=:='(X, Y) :- builtIn(arith_eq, X, Y).
'floatv'(X,Y) :-builtIn(floatv, X, Y).
