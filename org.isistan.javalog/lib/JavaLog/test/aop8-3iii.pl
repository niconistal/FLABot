/* Exercise 8.3 (iii) - between/3 */

/* between(I,J,K) is true if K is an integer between I and J inclusive.    */
between(I,J,J):-J>=I.
between(I,J,K):-J>I, J1 is J - 1, between(I,J1,K).
