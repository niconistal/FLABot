%-*-Prolog-*-
% $Id: UnixCommands.pl,v 1.1.1.1 2002/02/19 20:41:33 azunino Exp $	
cd    :- builtIn(cd).
cd(X) :- atom(X),builtIn(cd,X).
ls    :- builtIn(ls).    % equivalent to dir on UNIX
pwd   :- builtIn(pwd).   % displays current directory
