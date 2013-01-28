ham(true) :-
	ham_show, fail ; true.

ham(false) :-
	ham_silent, fail ; true.


ham_show :-
	ham1(X),
	write(X), nl.


ham_silent :-
	ham1(_).

ham1(X):-
	cycle_ham([a,b,c,d,e,f,g,h,i,j,k,l],X).
%	cycle_ham([a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t],X).



cycle_ham([X|Y],[X,T|L]):-
	chain_ham([X|Y],[],[T|L]),
	edge(T,X).


chain_ham([X],L,[X|L]).

chain_ham([X|Y],K,L):-
	del(Z,Y,T),
	edge(X,Z),
	chain_ham([Z|T],[X|K],L).




del(X,[X|Y],Y).

del(X,[U|Y],[U|Z]):-
	del(X,Y,Z).




edge(X,Y):-
	connect_(X,L),
	el(Y,L).




el(X,[X|_]).

el(X,[_|L]):-
	el(X,L).




connect_(a,[b,j,k]).
connect_(b,[a,c,p]).
connect_(c,[b,d,l]).
connect_(d,[c,e,q]).
connect_(e,[d,f,m]).
connect_(f,[e,g,r]).
connect_(g,[f,h,n]).
connect_(h,[i,g,s]).
connect_(i,[j,h,o]).
connect_(j,[a,i,t]).
connect_(k,[o,l,a]).
connect_(l,[k,m,c]).
connect_(m,[l,n,e]).
connect_(n,[m,o,g]).
connect_(o,[n,k,i]).
connect_(p,[b,q,t]).
connect_(q,[p,r,d]).
connect_(r,[q,s,f]).
connect_(s,[r,t,h]).
connect_(t,[p,s,j]).


% benchmark interface

benchmark(ShowResult) :-
	ham(ShowResult).

%:- include(common).
