%-*-Prolog-*-
% $Id: Flags.pl,v 1.1 2002/02/26 18:43:48 azunino Exp $	

%current_prolog_flag/2

%current_prolog_flag(Flag,Value) is true if and only if Flag is a supported
%flag and Value is its value. On backtracking the values of all supported
%flags can be determined. 

%Template:current_prolog_flag(?flag, ?term) 

%Errors: 

% 1.Flag/tt> is neither a variable nor an atom -- type_error(atom, Flag) 
% 2.Flag is an atom but an invalid flag for the processor --
%    domain_error(prolog_flag, Flag) 

%set_prolog_flag/2

%set_prolog_flag(Flag, Value) sets the Prolog flag Flag to the value Value.
%The goal either succeeds or raises an exception. 

%Template: set_prolog_flag(+flag, @nonvar) 

%Errors: 

% 1.Flag is a variable -- instantiation_error 
% 2.Value is a variable -- instantiation_error 
% 3.Flag/tt> is neither a variable nor an atom -- type_error(atom, Flag) 
% 4.Flag is an atom but an invalid flag for the processor --
%    domain_error(prolog_flag, Flag) 
% 5.Value is inadmissible for Flag -- domain_error(flag_value, Flag +
%    Value) 
% 6.Value is admissible for Flag but the flag Flag is not modifiable --
%    permission_error(modify, flag, Flag) 

%bounded 
%    Possible value: true, false
%    Default Value: Implementation defined
%    Changeable: No
%max_integer 
%    Possible value: the default value
%    Default value: implementation defined
%    Changeable: No
%min_integer 
%    Possible value: the default value
%    Default value: implementation defined
%    Changeable: No 
%integer_rounding_function 
%    Possible values: down, toward_zero
%    Default value: implementation defined
%    Changeable: No
%char_conversion 
%    Possible values: on, off
%    Default value: on
%    Changeable: Yes
%debug 
%    Possible values: on, off
%    Default value: off
%    Changeable: Yes
%max_arity 
%    Possible value: the default value
%    Default value: implementation defined
%    Changeable: No
%unknown 
%    Possible values: error, fail, warning
%    Default value: error Changeable: Yes

%    Determines the behaviour of the processor upon attempting to execute a procedure which does not exist. 
%double_quotes 
%    Possible values: chars, codes, atom Default value: implementation defined
%    Changeable: Yes

%    Determines the syntax of a double quoted list. 
