%-*-Prolog-*-
% $Id: ListOperations.pl,v 1.2 2002/03/04 12:17:53 azunino Exp $	
append([], L, L).
append([X|L1], L2, [X|L3]) :- append(L1, L2, L3).
length(L, N) :- bound(L),!,builtIn(length, L, N).
length(L,N):-(integer(N);var(N)),!,length_(L,N).
length(L,N):-float(N),!,N1 is floor N, length(L,N1).
length_([],0).
length_([_|Cdr],N) :- length_(Cdr,N1), N is N1+1.
member(X,[X|_]).
member(X,[_|Y]):- member(X,Y).
nth0(I, L, E) :- builtIn(nth0, I, L, E).
nth1(I, L, E) :- I1 is I-1, builtIn(nth0, I1, L, E).
printList([],_).
printList([H],_) :- builtIn(print, H).
printList([H|T],S) :- builtIn(print, H),
                      builtIn(print,S),
                      printList(T,S).
