
/* Exercise 14.1 (i) - Integer Square Root */

/* squareroot(N, I) is true if I is the integer square root of the natural */
/*   number N.                                                             */
squareroot(N, I):-
  N >= 0,
  between(0, N, I),
  I * I =< N,
  (I + 1) * (I + 1) > N,
  !.
  
/* between(I, J, K) is true if K is an integer between I and J inclusive.  */
between(I, J, I):-I =< J.
between(I, J, K):-I < J, I1 is I + 1, between(I1, J, K).
