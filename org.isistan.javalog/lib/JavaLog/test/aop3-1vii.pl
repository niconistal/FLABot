/* Exercise 3.1 (vii) - Greatest Common Divisor */

/* gcd(X,Y,Z) is true if Z is the greatest common divisor of X and Y.      */
gcd(X,X,X):-gt(X,0).
gcd(X,Y,G):-gt(X,Y),plus(Y,X1,X),gcd(X1,Y,G).
gcd(X,Y,G):-gt(Y,X),plus(X,Y1,Y),gcd(X,Y1,G).
