/* Exercise 3.4 (i) - subtree/2 */

/* subtree(Subtree,Tree) is true if Subtree is a subtree of the binary     */
/*   tree Tree.                                                            */
subtree(T,T).
subtree(S,tree(X,L,R)):-subtree(S,L).
subtree(S,tree(X,L,R)):-subtree(S,R).
