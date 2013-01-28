/* Exercise 3.3 (ii) - select/3 */

/* select(X,Xs,Ys) is true if Ys is the result of removing the first       */
/*   occurrence of X from Xs.                                              */
select(X,[X|Xs],Xs).
select(X,[Y|Ys],[Y|Zs]):-X\=Y,select(X,Ys,Zs).
