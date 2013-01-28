
%%%%%%%%%%%%%%%%%%%%%%%
%
%
%	inriasuite.pl
%
%    Author J.P.E. Hodgson
%	date 9 february 1999
%
%    Version 0.9
%
%   This is to be a batch version of
%   Ali's tests. It will read lines from a file
%   that are in the form [ Goal, Substs].
%
%
%   Modified 1999/02/24 to read several files and
%   report on them one by one. Output results
%   only when the result is not the expected one.
%
%    A more readable output can be obtained if the processor
%   supports numbervars/3 by  restoring the commented out
%   line in  write_if_wrong/5.
%
%    Revised April 8 1999.
%
%   Matching of solutions is not yet  perfected.
%


%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%  Operators required for the
%  tests.
%


%:- op( 20, xfx, <-- ).



%%%%%%%%%%%%%%%%%%%%
%
%  score/3 is dynamic.
% 
%  score(File, total(Tests), wrong(PossibleErrors)
%



%:- dynamic(score/3).


%%%%%%%%%%%%%%%%%%%%%%%%%
%
%  dynamic directives needed for the compiled
%  version of the tests.
%

%:- dynamic(bar/1).          % for asserta
%:- dynamic(foo/1).          % for assertz

%%%%%%%%%%%%%%%%
%
%  run_all_tests/0
%
%   Driver.


run_all_tests :-
	findall(F, file(F), Files),
        test_all(Files),
        write_results, !.


test_all([]).
test_all([F|Fs]) :-
	run_tests(F),
        test_all(Fs).

%%%%%%%%%%%%%%%%%%%%%%%%%
%
%   write_results/0.
%

write_results :-
	findall(F, inerror(F), ErrorBips),
        write('--------------------'), nl,
        ( 
        ErrorBips = []
        ->
        (
        write('All bips passed -------------'), nl
        )
        ;
        (nl, write('The following BIPs gave unexpected answers:'),nl,
         write('The results should be examined carefully.'), nl,
        nl,
        display_list(ErrorBips))
        ).




%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%5
%
%    result(+Goal, -Result)
%
%   evaluates the Goal and gives all the substitutions
%

result(G, Res) :-
      get_all_subs(G, Subs),
      special_ans_forms(Subs,Res).



%%%%%%%%%%%%%%%%%%%%%%%%%
%
%   certain substitutions appear in
%   a simplified form.
%


special_ans_forms([success], success) :- !.
special_ans_forms([failure], failure) :- !.
special_ans_forms([Error], Error) :-
	Error =..[E |_],error_type(E), !.
special_ans_forms(X,X).
	
%%%%%%%%%%%%%%%%
%
%   error_type(+E).
%

error_type(instantiation_error).
error_type(type_error).
error_type(domain_error).
error_type(existence_error).
error_type(permission_error).
error_type(representation_error).
error_type(evaluation_error).
error_type(resource_error).
error_type(syntax_error).
error_type(system_error).
error_type(unexpected_ball).          % for uncaught errors.





%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%   Extract  the variables from a term
%
%   vars_int_term(+Term, -Vars)
%

vars_in_term(T,V) :-
	vars_in_term(T, [], V).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%   vars_in_term(+Term, +AlreadyCollected, -Variables).
%

%  atoms (includes []).

vars_in_term(Term,VarsIn, VarsOut) :-
      atomic(Term), !, VarsOut= VarsIn.
% Term  is a variable

vars_in_term(Term, VarsIn, VarsOut) :-
	var(Term) ,!, 
        (already_appears(Term, VarsIn)
        ->
        VarsOut=VarsIn
        ;
        append(VarsIn, [Term], VarsOut)
        ). 

% Term is a list.

vars_in_term([A|B], VarsIn, Vars) :-
        !, 
        vars_in_term(A, VarsIn, V1),
        vars_in_term(B, V1, Vars).

% Term is a functor.

vars_in_term(T,VarsIn, VarList) :-
       T =.. [_F,A|Args],
       vars_in_term(A, VarsIn, Inter),
       vars_in_term(Args, Inter, VarList).

vars_in_term([], V, V).

%%%%%%%
%
%  already_appears(+Var,+VarList)
%
%  The variable Var is in the list VarList
%
 

already_appears(Var, [V1 | _Vlist] ) :-
	Var == V1.
already_appears(Var, [_V1 | Vlist] ) :-
        already_appears(Var, Vlist).
 


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%
%   call_goal_get_subs(+Goal, -Sub)
%
%   call a goal Goal and get the substitutions
%   associated to success.
%
% Vars=[X] GVars=[[1,2,3,4,5,6]]

call_goal_get_subs(G, Sub) :-
        copy_term(G,GT),
        vars_in_term(G,Vars),
        vars_in_term(GT, GVars),
        call(GT),
        make_subs_list1(Vars, GVars, Sub).





%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%  make_subs_list1(+OldVars, +Result, -Sub)
%
%   handles the speical cases else hands off
%  to make_subs_list(OldVars, Result, Sub)
%   and compress to handle [X <-- A, Y <-- A].
%

% special cases

make_subs_list1(_V, success, success).
make_subs_list1(_V, failure, failure).
make_subs_list1(_V, impl_def, impl_def).
make_subs_list1(_V, undefined, undefined).
make_subs_list1(_V, Error, Error) :-
	Error =.. [E|_],
        error_type(E), !.

make_subs_list1(Vs,GVs,Sub) :-
      make_subs_list(Vs, GVs, S),
      compress_sub_list(Vs, S, Sub).

%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%   make_subs_list(+Vars, +Result, -Subs).


make_subs_list([],[], []).

% no instantiation.

make_subs_list([V | Rest], [Ans |ARest], Subs) :-
	V == Ans , !,
        make_subs_list(Rest, ARest, Subs).

% Instantiation.

make_subs_list([V | Rest], [Ans |ARest], [ V <-- Ans | SubsRest]) :-
         make_subs_list(Rest, ARest, SubsRest).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%   list_make_subs(+Vars, +GTVars, -Subs).
%
%   Make substitution lists for Vars according to 
%  the set of instantiations given in GTVars.
%

list_make_subs_list(_, [], [failure]) :- !.
list_make_subs_list(V, GTV,S) :-
      list_make_subs_list_aux(V,GTV, S).

list_make_subs_list_aux(_Vars, [], []).
list_make_subs_list_aux(Vars, [GV1 |GVRest], [Sub1 |SubRest]) :- 
         make_subs_list1(Vars, GV1, Sub1),
         list_make_subs_list_aux(Vars, GVRest, SubRest).
	

%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%
%   call_with_result(G,R)
%

call_with_result(G,R ) :-
	call_goal_get_subs(G, Sub), 
        ( Sub = [] -> R = success; R = Sub).
call_with_result(_G, failure).

%%%%%%%%%%%%%%%%%%%%%%%%%
%
%
%  protect_call_result(G,R)
%
%  protected version of call_result/2.
%

protect_call_result(G,R) :-
	catch(call_result(G,R), B, extract_error(B,R)).


%%%%%%%%%%%%%%%
%
%  extract_error(+Ball, -Error)
%

extract_error(error(R, _), R) :- !.
extract_error(B, unexpected_ball(B)).




%%%%%%%%%%%%%%%%%%%%%
%
%  compress_sub_list(+Vars, +LIn, -LOut)
%
%   to replace pairs [X <--A, Y <-- A] by [Y <-- X]
%   when A is not one of the original variables.


compress_sub_list(_, [], success).
compress_sub_list(Vars, [X <-- A], [X <-- A]) :- X \== A, in_vars(A, Vars).
compress_sub_list(Vars,LIn, LOut) :-
      split_list(X <-- A, Before, After, LIn), 
      var(A),!,
      sub(X <-- A, Before, BN),
      sub(X <-- A, After, AN),
      append(BN,AN, L1),
      compress_sub_list(Vars, L1, LOut).

compress_sub_list(_,L,L).
      
%%%%%%%%%%%%%%%%%%%%%%%%
%
%   in_vars(Var, VarList)
%

in_vars(V, [V1 |_Vs]) :-
       V == V1, !.
in_vars(V, [_V1 |Vs]) :-
      in_vars(V, Vs).	



%%%%%%%%%%%%%%%%%%%
%
%  sub(X <-- A, OldList, NewList)
%
%  substitute A for X in OldList giving NewList.
%

sub(_X <-- _A, [], []).
sub(X <-- A, [H|T], [H1|T1]) :-
	sub1(X <-- A, H,H1),
        sub( X <-- A, T,T1).

%%%%%%%%%%%%%%%%%%%%%
%
%
%   sub1(X <-- A, Y <-- Old, Y <-- New)
%
%  perform a single substitution.
%

sub1(X <-- A, Y <-- Old, Y <-- New) :-
	exp_sub(X<-- A, Old, New).

exp_sub(X <-- A, B, New) :-
	var(B), B== A, !,
        New = X.
exp_sub(_X <-- _A, B, New) :-
        var(B), !,
        New = B.
exp_sub(_X <-- _A, B, New) :-
	atomic(B), !,
        New = B.
exp_sub(X <-- A, B, New) :-
       B = [_|_],!,
       list_exp_sub(X <-- A, B, New).
exp_sub(X <-- A, B, New) :-
	B =.. [F|L],
        list_exp_sub(X <-- A, L,L1),
        New =.. [F|L1].

list_exp_sub(_S, [],[]).
list_exp_sub(S, [E|ER], [EN|ERN]) :-
	exp_sub(S, E, EN),
        list_exp_sub(S, ER, ERN).



%%%%%%%%%%%%%%%%%%%%%%
%
%
%   split_list(?Element,-Before, -After, +List)
%
% split a list List  at a given Element.
%


split_list(Element, Before, After, List) :-
	append(Before, [Element | After], List).
       
	



%%%%%%%%%%%%%%%%%%%%%%%
%
%
%   compare_subst_lists(+First,
%                       +Second,
%                       +InFirstButNotSecond,
%                       +InSecondButNotFirst
%                      )
%   compare two substitution lists.
%

% special cases
compare_subst_lists(F,S, [],[]) :-
	\+ (F = [_|_]),
        \+ (S = [_|_]), 
        F = S, !.
compare_subst_lists(F,S, F,S) :-
      	\+ (F = [_|_]),
        \+ (S = [_|_]), !.
compare_subst_lists(F,S, FNS, SNF) :-
        \+(F = [_|_]), !,
       del_item(F, S, SNF),
      (member(F,S) -> FNS =[]; FNS = F).
compare_subst_lists(F,S, FNS,SNF) :-
     \+( S = [_|_]), !,
      del_item(S, F, FNS),
      (member(S,F) -> SNF =[]; SNF = S).

compare_subst_lists(F, S, [], []) :-
     F= [F1], S = [S1],
     same_subst(F1, S1), !.
 
compare_subst_lists(F, S, F, S) :-
     length(F,1),
     length(S,1), !. 

compare_subst_lists(F,S, FNS,SNF) :-
     length(F,1),!,
      del_item(F, S, SNF),
      (member(F,S) -> FNS =[]; FNS = F).
compare_subst_lists(F,S, FNS,SNF) :-
     length(S,1),
      del_item(S, F, FNS),
      (member(S,F) -> SNF =[]; SNF = S).


compare_subst_lists(F,S, FNS, SNF) :-
	list_del_item(F,S, SNF),
        list_del_item(S,F, FNS).


%list_del_item(L1, L2, L2LessL1)

list_del_item([], L,L).
list_del_item([It|R], L1, Left) :-
	del_item(It, L1, LInter),
        list_del_item(R, LInter, Left).
           
del_item(_Item, [],[]).
del_item(Item, [It |R], R) :-
      same_subst(Item, It), ! .
    %  del_item(Item, Rest, R).
del_item(Item, [It|Rest], [It |R]) :-
	del_item(Item, Rest, R).

%%
%  same_subst(Sub1, Sub2)
%
%  Sub1 and Sub2 represent the same subst.
%

same_subst([],[]).
same_subst([S1|SRest], Subs) :-
        delmemb(S1, Subs, Subs1),
        same_subst(SRest, Subs1).

%%%%%%%%%%
%
%  delmemb(Item, List, ListMinusItem)
%
% special delete for substitutions.
%

delmemb(_E, [], []).
delmemb(E <-- E1 , [F <-- F1| R], R) :-
         E == F, 
	copy_term(E <-- E1 ,F <-- F1).  % only when LHS's are eq.
delmemb(E, [F|R], [F|R1]) :-
      delmemb(E,R,R1).

%%%%%%%%%%%%%%%%%%%%
%
%    read_test(-Extra,-Missing)
%
%    read a test [G,Expected] from standard in
%    and find the Missing and Extra substitutions.
%

read_test(Extra, Missing) :-
	read(X),
        X = [G, Expected],
        result(G, R),
        compare_subst_lists(R, Expected, Extra, Missing),
        write('Extra Solutions found: '), write(Extra), nl,
        write('Solutions Missing: '), write(Missing).
        
        
%%%%%%%%%
%
%   read tests from a file
%


run_tests(File) :-
        asserta(score(File, total(0), wrong(0))),
	open(File, read, S),
        loop_through(File,S),
        close(S).

%%%%%%%%%%%%%%%%%%%%
%
%    loop_through(+File,+Source)
%
%    read a term from the file and test the term
%    the catch is for syntax errors 
%    (which will be errors in the processor).
%
 
loop_through(F, S) :-
	catch(read(S,X), B, X = B),
        (
       X = end_of_file
        -> true
       ;
        reset_flags,
        test(F,X),
        loop_through(F,S)
       ).
