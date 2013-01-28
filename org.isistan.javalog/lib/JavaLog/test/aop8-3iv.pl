/* Exercise 8.3 (iv) - timeslist/2 */

/* timeslist(Is,Prod) is true if Prod is the product of the list Is.       */
timeslist([I|Is],Prod):-timeslist(Is,I,Prod).

timeslist([],Prod,Prod).
timeslist([I|Is],Temp,Prod):-Temp1 is Temp*I, timeslist(Is,Temp1,Prod).
