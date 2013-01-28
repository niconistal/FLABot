
/* Exercise 17.1 (i) - intersect/3 */

intersect(Xs,Ys,Zs):-
  findall(Z, (member(Z,Xs),member(Z,Ys)), Zs).
