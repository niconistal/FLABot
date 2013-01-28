#!/usr/bin/perl -pwi.bak
s/#([^#]+)#/<tt>$1<\/tt>/g;
s/{\\tt\s*([^}]+)}/<tt>$1<\/tt>/g;
s/{\\em\s*([^}]+)}/<em>$1<\/em>/g;
s/\\begin{enumerate}/<OL>/g;
s/\\end{enumerate}/<\/OL>/g;
s/\\begin{itemize}/<UL>/g;
s/\\end{itemize}/<\/UL>/g;
s/\\item/<LI>/g;

