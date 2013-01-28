sister(Sister, Sib):-
  parent(Parent, Sister),
  parent(Parent, Sib),
  female(Sister),
  Sister =\= Sib.

niece(Niece, Person):-
  parent(Parent, Niece),
  sibling(Parent, Person),
  female(Niece).

sibling(Sib1, Sib2):-
  father(Father, Sib1),
  father(Father, Sib2),
  mother(Mother, Sib1),
  mother(Mother, Sib2),
  Sib1 =\= Sib2.
