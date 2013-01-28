%-*-Prolog-*-
% $Id: TermPredicates.pl,v 1.5 2002/03/13 17:00:39 azunino Exp $	
arg(A, T, V) :- builtIn(arg, A, T, V).
arity(T, A) :- builtIn(arity, T, A).
functor(T, F) :- builtIn(functor, T, F).
functor(T, F, A) :- functor(T, F),!,arity(T, A).
functor(T, T, 0) :- !.
functor(T, F, A1) :- bound(F),bound(A1),length(R, A1),!,
    listToTerm( [F|R], T ).
name(X,Y) :- atom(X),builtIn(name,X,Y).
%'=..'(X, Y) :- builtIn(univ, X, Y).
'=..'(Term, List) :- bound(Term), !, termToList(Term,List).
'=..'(Term, List) :- bound(List), !, listToTerm(List,Term).

termToList(Term,[F|Args]) :- functor(Term,F,Arity), argList(Term,Args,Arity).

argList(Term,Args,Arity) :- argList(Term,1,Args,Arity).
argList(_,NArg,[],Arity) :- NArg > Arity, !.
argList(Term,NArg,[Arg|Args],Arity) :- 
	arg(NArg, Term, Arg),
	NArg1 is NArg + 1,
	argList(Term,NArg1,Args,Arity).

listToTerm(List,Term) :- builtIn(listToStruct,List,Term).	


%copy_term(X,Y) is true if and only if Y unifies with a term T which is a
%renamed copy of X. 
%copy_term(A,B):-cp(A,[],B,_).
       
%cp(A,Vars,A,Vars):-
%	atomic(A).
%cp(V,Vars,NV,NVars):-
%    var(V),register_var(V,Vars,NV,NVars).
%cp(Term,Vars,NTerm,NVars):-
%    compound(Term),
%    Term=..[F|Args],    % decompose term
%    cp_args(Args,Vars,NArgs,NVars),
%    NTerm=..[F|NArgs].  % construct copy term
       
%cp_args([H|T],Vars,[NH|NT],NVars):-
%    cp(H,Vars,NH,SVars),
%    cp_args(T,SVars,NT,NVars).

%cp_args([],Vars,[],Vars).

%register_var(V,[X/H|T],N,[X/H|NT]):-
%	V\==X,         % different variables
%	register_var(V,T,N,NT).
%register_var(V,[X/H|T],H,[X/H|T]):-
%    V==X.          % same variables
%    register_var(V,[],N,[V/N]).

copy_term(X, Y ) :-
      copia_termo( X, Y, [], _ ).
  
copia_termo( X, Y, D1, D2 ) :- var(X), !, procura( D1, X/Y, D2 ).
copia_termo( X, Y, D, D ) :- atomic(X), !, X = Y.
copia_termo( [], [], D, D ) :- !.
%copia_termo( [H|T], [|], D1, D2 ) :-
	  
copia_termo( X, Y, D1, D2 ) :- compound(X), !,            
      functor(X,F,N),
      functor(Y,F,N),
      copia_args(N,X,Y,D1,D2).
  
copia_args(0,_,_,D,D) :- !.
copia_args(N,X,Y,D1,D3) :- 
      arg(N,X,Xn),
      arg(N,Y,Yn),
      copia_termo(Xn,Yn,D1,D2),
      N1 is N - 1, !,
      copia_args( N1, X, Y,D2,D3 ).
  
procura( [], X/Y, [X/Y]):-!.
procura( [V/Y|Vs], X/Y, [V/Y|Vs]) :-
      V == X, !.
procura( [V/W|Vs], X/Y, [V/W|D] ) :-
      procura( Vs, X/Y, D ).
  
