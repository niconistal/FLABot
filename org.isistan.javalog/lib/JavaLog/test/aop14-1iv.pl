% Exercise 14.1 (iv) - Houses Puzzle

solve:-
  clues(Houses),
  queries(Houses).

clues(Houses):-
  house(A, Houses), colour(A, red), nationality(A, english),
  house(B, Houses), nationality(B, spaniard), pet(B, dog),
  house(C, Houses), colour(C, green), drink(C, coffee),
  house(D, Houses), nationality(D, ukranian), drink(D, tea),
  immed_to_right(Houses, E, F), colour(E, green), colour(F, ivory),
  house(G, Houses), smoke(G, winston), pet(G, snails),
  house(H, Houses), smoke(H, kools), colour(H, yellow),
  middle(Houses, I), drink(I, milk),
  first(Houses, J), nationality(J, norwegian),
  next_to(Houses, K, L), smoke(K, chesterfields), pet(L, fox),
  next_to(Houses, M, N), smoke(M, kools), pet(N, horse),
  house(O, Houses), smoke(O, luckystrike), drink(O, orangejuice),
  house(P, Houses), nationality(P, japanese), smoke(P, parliaments),
  next_to(Houses, Q, R), nationality(Q, norwegian), colour(R, blue).

queries(Houses):-
  house(X, Houses), pet(X, zebra), nationality(X, Nationality1),
  write('The '), write(Nationality1), write(' owns the zebra'), nl,
  house(Y, Houses), drink(Y, water), nationality(Y, Nationality2),
  write('The '), write(Nationality2), write(' drinks water'), nl.
  
colour(house(C,_,_,_,_), C). 
nationality(house(_,N,_,_,_), N). 
pet(house(_,_,P,_,_), P). 
drink(house(_,_,_,D,_), D). 
smoke(house(_,_,_,_,S), S). 

first(houses(X,_,_,_,_), X).  

middle(houses(_,_,X,_,_), X).  

immed_to_right(houses(L,R,_,_,_), R, L).
immed_to_right(houses(_,L,R,_,_), R, L).
immed_to_right(houses(_,_,L,R,_), R, L).
immed_to_right(houses(_,_,_,L,R), R, L).

next_to(Xs, X, Y):-
  immed_to_right(Xs, X, Y).
next_to(Xs, X, Y):-
  immed_to_right(Xs, Y, X).

house(X, houses(X,_,_,_,_)).
house(X, houses(_,X,_,_,_)).
house(X, houses(_,_,X,_,_)).
house(X, houses(_,_,_,X,_)).
house(X, houses(_,_,_,_,X)).
