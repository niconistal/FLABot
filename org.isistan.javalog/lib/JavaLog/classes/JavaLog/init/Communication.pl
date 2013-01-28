% Communication.pl
% Representa las operaciones sobre el blackboard y los predicados de envío y recepción de 
% mensajes que pueden utilizar los brainlets.

% Operaciones sobre el blackboard
% Escritura
out(X):- bound(X), builtIn(out, X).
% Lectura bloqueante con borrado (esperar hasta poder "tomar" un elemento de la base de datos)
% Se espera por un elemento, y luego de obtenido se intenta borrarlo
in(X):- brd(X), retract(X).
% Lectura bloqueante sin borrado
brd(X):- call(X), !.
brd(X):- builtIn(brd, X), brd(X).
% Lectura no bloqueante sin borrado
rd(X):- call(X).
% Todas las instancias de X
all(X,Xs):- all2(X, Xs, []).
all2(X, Xs, Xt):- call(X), not(member(X,Xt)), !, all2(X, Xs, [X|Xt]).
all2(_, Xt, Xt).

checkMessageSyntax(message(Dest,Cont,Args)):- checkId(Dest), checkContent(Cont), checkArgumentList(Args). 
checkId(id(_,Rs)):- atom(Rs).
checkContent(Cont):- atom(Cont).
checkArgumentList([]):-!.
checkArgumentList([arg(K,V)|Y]):- atom(K), atom(V), checkArgumentList(Y).
sendAsyncMessage(message(D,C,A)):- checkMessageSyntax(message(D,C,A)),
					     builtIn(sendAsyncMessage,D,C,A,false).
sendReplyMessage(message(D,C,A)):- checkMessageSyntax(message(D,C,A)),
				    	     builtIn(sendAsyncMessage,D,C,A,true).
sendSyncMessage(message(D,C,A), message(Rr,Rc,Rargs)):- 
						  checkMessageSyntax(message(D,C,A)),
						  builtIn(sendSyncMessage,D,C,A,Rs),
						  Rs=message(Rr,_,Rc,Rargs,_,_).	
getCurrentBrainlet(X):-builtIn(getCurrentBrainlet, X).
getBrainlets(X):-builtIn(getBrainlets,X).
getBrainletsForRole(R,X):-atom(R), builtIn(getBrainletsForRole,R,X).
attachRole(R):- atom(R), builtIn(attachRole,R).
dettachRole(R):- atom(R), builtIn(dettachRole,R). 
% BroadCasting local
broadCast(Content,Args):-getBrainlets(X),broadCastMessage(Content,Args,X).
broadCastMessage(_,_,[]).
broadCastMessage(Content,Args,[I|Is]):-sendAsyncMessage(message(I,Content,Args)),
						   broadCastMessage(Content,Args,Is).
% Tratamiento de mensajes
handleMessage(message(S,_,C,A,false,false)):-handleAsyncMessage(message(S,C,A)).
handleMessage(message(S,_,C,A,true,false)):-handleSyncMessage(message(S,C,A)).
cloneBrainlet(X):- builtIn(cloneBrainlet, X).
cloneBrainlet(X,Y):- builtIn(cloneBrainlet, X, Y).
