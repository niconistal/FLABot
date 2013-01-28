%There is an ordering on Prolog terms obtained as follows: 

%variables term precede floats which term precede integers which term precede atoms which
%term precede compound. 

%Within each term the ordering is the obvious one except that 

%  1.For variables the order is implementation dependent. 
%  2.for compound terms: X term precedes Y if arity(X) < arity(Y, if the arities are the same then X term
%    precedes Y if functor name X term precedes the functor name of Y, If arity and functor names are the
%    same then the left most differing arguments determine the term precedence. 

% (@=<)/2 
%    Term less than or equal to. 
% (==)/2 
%    Term identical 
% ((\==)/2 
%    Term not identical 
% (@<)/2 
%    Term less than 
% (@>)/2 
%    Term greater than 
% (@>=)/2 
%    Term greater than or equal to. 

%Templates
%'@=<'(@term,@term)
%'=='(@term,@term)
%'\=='(@term,@term)
%'@<'(@term,@term)
%'@>'(@term,@term)
%'@>='(@term,@term)

'\=='(X, Y):-!,builtIn(notIdentical,X,Y).
'@<'(X,Y):-builtIn(lessThan,X,Y).
'@>'(X,Y):-builtIn(greater,X,Y).
'@>='(X,Y):-builtIn(greaterOrEqual,X,Y).
'@=<'(X,Y):-builtIn(lessOrEqualThan,X,Y).
'=='(X,Y):-builtIn(identical,X,Y).
