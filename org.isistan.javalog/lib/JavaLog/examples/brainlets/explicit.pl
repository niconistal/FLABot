
PROTOCOLS
FETCH
CLAUSES

% Editar las cláusulas las direcciones IP que figuran debajo
% con las máquinas demás máquinas (aparte de la local) que están
% en la red Movilog. Por ejemplo, sites(['192.168.2.38','192.168.2.61'])
sites(['127.0.0.1']).
buy(A,R):- sites(S),lookForOffers(A,S,R).
getAllOffers(Art,List):-getAllOffers2(Art,List,[]).
getAllOffers2(Art,List,Temp):-article(Art,Ma,Mo,E),not(member(article(Art,Ma,Mo,E),Temp)),!,getAllOffers2(Art,List,[article(Art,Ma,Mo,E)|Temp]).
getAllOffers2(_,Temp,Temp).
lookForOffers(A,[],[]):-return.
lookForOffers(A,[S|R],[offers(S,L)|Rarts]):-moveTo(S),getAllOffers(A,L),lookForOffers(A,R,Rarts).
lookForOffers(A,[S|R],Rarts):-lookForOffers(A,R,Rarts).