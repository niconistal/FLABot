% -*-prolog-*-

padre(alberto,alfredo).
padre(alberto,rodolfo).
padre(alberto,guillermo).
padre(alberto,alejandro).
madre(susana,alfredo).
madre(susana,rodolfo).
madre(susana,guillermo).
madre(susana,alejandro).
padre(dora,alberto).
padre(victor,susana).
madre(elsa,susana).
padre(victor,silvia).
madre(elsa,silvia).
padre(hector,octavio).
padre(hector,gustavo).
padre(hector,emilia).
madre(silvia,octavio).
madre(silvia,gustavo).
madre(silvia,emilia).

% relacion progenitor: X es progenitor de Y
progenitor(X,Y) :- padre(X,Y).
progenitor(X,Y) :- madre(X,Y).

% todo aquel que tiene un hijo es feliz
feliz(X) :- progenitor(X,_).

% todo aquel que tiene un hermano que tiene un hijo es tio
% X es hermano de Y
hermano(X,Y) :- progenitor(P,X), progenitor(P,Y), X \== Y.
% Tio es tio de Sobrino
tio(Tio,Sobrino) :- hermano(Tio,Hermano), progenitor(Hermano,Sobrino).

% todo aquel que tiene un abuelo es nieto
% Abuelo es abuelo de Nieto
abuelo(Abuelo,Nieto) :- progenitor(Abuelo,Hijo), progenitor(Hijo,Nieto).
% X es nieto de Y
nieto(Nieto,Abuelo) :- abuelo(Abuelo,Nieto).


gusta(silvia,rock).
gusta(lucas,jazz).
gusta(luis,folklore).
gusta(juan,jazz).
gusta(pedro,rock).
gusta(matias,folklore).
fuma(silvia).
fuma(luis).

% juan simpatiza con las personas que fuman y a las que les gusta la misma
% musica que a el
simpatiza(juan,Y) :- fuma(Y).
simpatiza(juan,Y) :- gusta(juan,Musica), gusta(Y,Musica).

% una persona que fuma es poco saludable
pocoSaludable(X) :- fuma(X).

% Dos personas tienen gustos similares su gustan de la misma musica
gustosSimilares(X,Y) :- gusta(X,Musica), gusta(Y, Musica), X \== Y.

% matias simpatiza con la gente que fuma y con la gente a la que le gusta 
% el jazz
simpatiza(matias,X) :- fuma(X).
simpatiza(matias,X) :- gusta(X,jazz).