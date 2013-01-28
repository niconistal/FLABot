current_input(S) :- builtIn(currentInput,S).
current_output(S) :- builtIn(currentOutput,S).

create(S,_,_,_) :- var(S),builtIn(print,instantation_error(source)), !, fail.
create(_,M,_,_) :- var(M),builtIn(print,instantation_error(mode)),!,fail.
create(_,_,_,T) :- var(T),builtIn(print,instantation_error(type)),!,fail.
create(_,_,S,_) :- nonvar(S),builtIn(print, error(type_error(variable, stream))),!,fail.
create(S,M,St,T) :- builtIn(create,S,M,St,T).

open(S,_,_) :- var(S),builtIn(print,instantation_error(source)), !, fail.
open(_,M,_) :- var(M),builtIn(print,instantation_error(mode)),!,fail.
open(_,_,S) :- nonvar(S),builtIn(print, error(type_error(variable, stream))),!,fail.
open(S,M,T) :- builtIn(open,S,M,T).


open(S,_,_,_) :- var(S), builtIn(print,instantation_error(source)), !, fail.
open(_,M,_,_) :- var(M), builtIn(print,instantation_error(source)), !, fail.
open(_,_,S,_) :- nonvar(S), builtIn(print, error(type_error(variable, stream))),!,fail.
open(S,M,T,O) :- builtIn(openOp,S,M,T,O).

set_input(A) :- var(A), builtIn(print,instantation_error(source)), !, fail.
set_input(A) :- builtIn(setInput, A).

set_output(A) :- var(A), builtIn(print,instantation_error(source)), !, fail.
set_output(A) :- builtIn(setOutput, A).

at_end_of_stream :- current_input(S), at_end_of_stream(S).

at_end_of_stream(S):- builtIn(atEndOfStream, S).

close(S):- close(S,force(true)).

close(S,_):- var(S), builtIn(print,instantation_error(source)), !, fail.
close(S, force(T)):- builtIn(close, S, T).

get_char(S,_) :- var(S), builtIn(print,instantation_error(source)), !, fail.
get_char(S,A) :- builtIn(getChar,S,A).

get_char(A) :- current_input(S), get_char(S,A).

put_char(S,_) :- var(S), builtIn(print,instantation_error(source)), !, fail.
put_char(S,A) :- builtIn(putChar,S,A).

put_char(A) :- current_output(S), put_char(S,A).

set_stream_position(S,_):-var(S), builtIn(print,instantation_error(source)), !, fail.
set_stream_position(_,A):-var(A), builtIn(print,instantation_error(position)), !, fail.
set_stream_position(S,A):-builtIn(setStreamPosition, S,A).

get_code(S,_) :- var(S), builtIn(print,instantation_error(source)), !, fail.
get_code(S,A) :- builtIn(getCode,S,A).

get_code(A) :- current_input(S), get_code(S,A).

peek_char(S,_) :- var(S), builtIn(print,instantation_error(source)), !, fail.
peek_char(S,A) :- builtIn(peekChar,S,A).

peek_char(A) :- current_input(S), peek_char(S,A).

peek_code(S,_) :- var(S), builtIn(print,instantation_error(source)), !, fail.
peek_code(S,A) :- builtIn(peekCode,S,A).

peek_code(A) :- current_input(S), peek_code(S,A).

put_code(S,_) :- var(S), builtIn(print,instantation_error(source)), !, fail.
put_code(S,A) :- builtIn(putCode,S,A).

put_code(A) :- current_output(S), put_code(S,A).

nl:-current_output(S), nl(S).
nl(S) :- var(S), builtIn(print,instantation_error(source)), !, fail.
nl(S) :- builtIn(nl,S).

get_byte(S,_) :- var(S), builtIn(print,instantation_error(source)), !, fail.
get_byte(S,A) :- builtIn(getByte,S,A).

get_byte(A) :- current_input(S), get_byte(S,A).

peek_byte(S,_) :- var(S), builtIn(print,instantation_error(source)), !, fail.
peek_byte(S,A) :- builtIn(peekByte,S,A).

peek_byte(A) :- current_input(S), peek_byte(S,A).

put_byte(S,_) :- var(S), builtIn(print,instantation_error(source)), !, fail.
put_byte(S,A) :- builtIn(putByte,S,A).

put_byte(A) :- current_output(S), put_byte(S,A).

stream_property(S,A):-var(S), current_input(S),all_stream_property(S,A).
stream_property(S,A):-var(S), current_output(S),all_stream_property(S,A).

all_stream_property(S,A) :- builtIn(getStreams, S,S),stream_property(S,A).
all_stream_property(P,A) :- builtIn(getStreams, P,N), all_stream_property(N,A). 

stream_property(S,file_name(A)):- nonvar(S), builtIn(streamPName, S,A).
stream_property(S,mode(A)):- nonvar(S), builtIn(streamPMode, S,A).
stream_property(S,input):- nonvar(S), builtIn(streamPInput, S).
stream_property(S,output):- nonvar(S), builtIn(streamPOutput, S).
stream_property(S,alias(A)):- nonvar(S), builtIn(streamPAlias, S,A).
stream_property(S,position(A)):- nonvar(S), builtIn(streamPPosition, S,A).
stream_property(S,end_of_stream(A)):- nonvar(S), builtIn(streamPEndOfStream, S,A).
stream_property(S,eof_action(A)):- nonvar(S), builtIn(streamPEofAction, S,A).
stream_property(S,reposition(A)):- nonvar(S), builtIn(streamPReposition, S,A).
stream_property(S,type(A)):- nonvar(S), builtIn(streamPType, S,A).


read_term(Stream,Term):- nonvar(Stream), read_term(Stream,Term,[]).
read(Term,Options):- var(Term), current_input(S), read_term(S,Term,Options).
read(Term):- var(Term), current_input(S), read_term(S,Term,[]).
read_term(Stream,Term,Options):- builtIn(readTerm, Stream, Term, Options).

write_term(S,_,_):- var(S), builtIn(print,instantation_error(source)), !, fail.
write_term(S,T,A):- nonvar(S), builtIn(writeTerm, S,T,A).
write_term(S,T):- atom(S),write_term(S,T,[nv(true),i(false), q(false)]).
write_term(T,A):- compound(T),current_output(S), write_term(S,T,A).
write_term(S,T):- write_term(S,T,[nv(true),i(false), q(false)]).
write(T):- current_output(S), write_term(S,T,[nv(true),i(false), q(false)]).
writeq(T):- current_output(S), write_term(S,T,[nv(true),i(false), q(true)]).
writeq(S,T):- write_term(S,T,[nv(true),i(false), q(true)]).
write_canonical(T):- current_output(S), write_term(S,T,[nv(false),i(true), q(true)]).
write_canonical(S,T):- write_term(S,T,[nv(false),i(true), q(true)]).

