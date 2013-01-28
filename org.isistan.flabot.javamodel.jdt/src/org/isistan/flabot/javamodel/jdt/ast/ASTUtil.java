package org.isistan.flabot.javamodel.jdt.ast;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;


/**
 * Utility class to handle the AST
 * @author usuario
 *
 */
public class ASTUtil {
	/**
	 * Interface used to search through the AST
	 * @author usuario
	 *
	 */
	public static interface ASTNodeFilter {
		/**
		 * Returns if the node is accepted, menning may change on each case
		 * @param node
		 * @return
		 */
		public boolean accept(ASTNode node);
		
		/**
		 * Returns if the action should be stopped, menning may change on each case
		 * @param node
		 * @return
		 */
		public boolean stop(ASTNode node);
	}
	
	/**
	 * Searches the closest ancestor accepted by the filter, if accepted it is returned,
	 * if root of AST is reached or if filter's stop method returns true, null is returned,
	 * the passed node is not queryed itself; 
	 * @param node
	 * @param ancestorFilter
	 * @return
	 */
	public static ASTNode getAncestor(ASTNode node, ASTNodeFilter ancestorFilter) {
		node=node.getParent();
		while(node!=null) {
			if(ancestorFilter.accept(node)) {
				return node;
			} else if(ancestorFilter.stop(node)) {
				return null;
			}
			node=node.getParent();
		}
		return null;
	}
	
	/**
	 * Searches all descendants accepted by the filter, if the filter's stop method
	 * returns true, the subtree of that node won't be searched, the passed node is
	 * not queryed itself
	 * @param node
	 * @param ancestorFilter
	 * @return
	 */
	public static ASTNode[] getDescendants(ASTNode node, ASTNodeFilter ancestorFilter) {
		DescendantsASTVisitor visitor=new DescendantsASTVisitor(node, ancestorFilter);
		node.accept(visitor);
		return visitor.getNodes();
	}
	
	private static class DescendantsASTVisitor extends DelegatingASTVisitor {
		private List<ASTNode> nodes=new LinkedList<ASTNode>();
		private ASTNode node;
		private ASTNodeFilter ancestorFilter;
		private DescendantsASTVisitor(ASTNode node, ASTNodeFilter ancestorFilter) {
			this.node=node;
			this.ancestorFilter=ancestorFilter;
		}
		@Override
		public boolean visitNode(ASTNode node) {
			if(ancestorFilter.accept(node)) {
				nodes.add(node);
			}
			return !ancestorFilter.stop(node);
		}
		
		public ASTNode[] getNodes() {
			return nodes.toArray(new ASTNode[nodes.size()]);
		}
		
	}
	
	/**
	 * Obtains the compilation unit (root) node 
	 * @param compilationUnit
	 * @return
	 */
	public static CompilationUnit getASTRoot(ICompilationUnit compilationUnit) {
		ASTParser parser=ASTParser.newParser(AST.JLS3);
		parser.setSource(compilationUnit);
		parser.setResolveBindings(true);
		return (CompilationUnit)parser.createAST(null);
	}
	
	/**
	 * Obtains the class file (root) node 
	 * @param compilationUnit
	 * @return
	 */
	public static CompilationUnit getASTRoot(IClassFile classFile) {
		ASTParser parser=ASTParser.newParser(AST.JLS3);
		parser.setSource(classFile);
		parser.setResolveBindings(true);
		return (CompilationUnit)parser.createAST(null);
	}
}
