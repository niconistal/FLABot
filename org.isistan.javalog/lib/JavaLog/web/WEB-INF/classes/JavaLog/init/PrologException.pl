throw(X) :-builtIn(search,catch(_,X,Handler)),builtIn(insert,Handler),!.
catch(Goal,_,_) :- call(Goal),!.



