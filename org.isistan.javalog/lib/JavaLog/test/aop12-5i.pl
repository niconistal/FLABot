/* Exercise 12.5 (i) - abolish/2 */

/* This item is coded using LPA Win-Prolog syntax.  */

/* abolish_(F, N) retracts all clauses for the procedure F of arity N.     */
abolish_(F, N):-functor(T, F, N), repeat, abolish_(T), !.

abolish_(T):-retract(T), fail.
abolish_(T):-retract((T:-U)), fail.
abolish_(T).
