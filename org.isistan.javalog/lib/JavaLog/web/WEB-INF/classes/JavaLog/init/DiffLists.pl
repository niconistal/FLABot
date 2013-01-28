% X/Y==X-Y
% append([b,c,d|Hole1]/Hole1,[a|Hole2]/Hole2,Ans/[]).
%append(OpenList1/Hole1,OpenList2/Hole2,OpenList1/Hole2):-
%	Hole1=OpenList2.
dappend(OpenList1/Hole1,Hole1/Hole2,OpenList1/Hole2).
% add_to_back(a,[b,c,d|Hole]/Hole,Ans).
add_to_back(El,OpenList/Hole,Ans):-
	dappend(OpenList/Hole,[El|ElHole]/ElHole,Ans/[]).


