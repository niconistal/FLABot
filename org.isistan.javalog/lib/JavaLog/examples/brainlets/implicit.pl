
PROTOCOLS
protocol(article,4).
FETCH
CLAUSES
buy(A,R):- getAllOffers(A,R).
getAllOffers(Art,List):-getAllOffers2(Art,List,[]).
getAllOffers2(Art,List,Temp):-article(Art,Ma,Mo,E),not(member(article(Art,Ma,Mo,E),Temp)),getAllOffers2(Art,List,[article(Art,Ma,Mo,E)|Temp]).
getAllOffers2(_,Temp,Temp).