/* Exercise 3.1 (iv) - even/1 and odd/1 */
/* even(X) is true if X is an even natural number.                         */
even(0).
even(s(s(X))):-even(X).

/* odd(X) is true if X is an odd natural number.                           */
odd(s(0)).
odd(s(s(X))):-odd(X).
