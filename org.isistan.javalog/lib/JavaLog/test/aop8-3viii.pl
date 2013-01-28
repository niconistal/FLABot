/* Exercise 8.3 (viii) - range/3 */

/* range(I,J,Ks) is true if Ks is the list of integers between I and J     */
/*   inclusive.                                                            */
range(I,J,Ks):-range(I,J,[],Ks).

range(I,I,Ks,[I|Ks]):-!.
range(I,J,As,Ks):-I < J, J1 is J - 1, range(I,J1,[J|As],Ks).
