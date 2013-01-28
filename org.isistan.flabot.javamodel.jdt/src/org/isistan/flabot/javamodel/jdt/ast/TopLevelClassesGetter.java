package org.isistan.flabot.javamodel.jdt.ast;

import java.util.List;

import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * This visitor can obtain all non-nested types declared in a compilation unit
 * @author usuario
 *
 */
public class TopLevelClassesGetter  {
	/**
	 * Returns all non-nested classes declared in a compilation unit
	 * @param compilationUnit
	 * @return
	 * @throws JavaModelException 
	 */
	public static AbstractTypeDeclaration[] getTopLevelClasses(ICompilationUnit compilationUnit) throws JavaModelException {
		if(!compilationUnit.exists()) {
			throw new IllegalArgumentException("Compilation unit must exist");
		}
		if(!compilationUnit.isOpen())
			compilationUnit.open(null);

		CompilationUnit node=ASTUtil.getASTRoot(compilationUnit);
		return getClasses(node);
	}
	
	/**
	 * Returns all non-nested classes declared in a class file
	 * @param compilationUnit
	 * @return
	 * @throws JavaModelException 
	 */
	public static AbstractTypeDeclaration[] getTopLevelClasses(IClassFile classFile) throws JavaModelException {
		if(!classFile.exists()) {
			throw new IllegalArgumentException("Class file must exist");
		}
		if(!classFile.isOpen())
			classFile.open(null);
		
		CompilationUnit node=ASTUtil.getASTRoot(classFile);
		return getClasses(node);
	}
	
	/**
	 * Obtains the type bindings for all top level types declared
	 * under the compilation unit node
	 * @param node
	 * @return
	 */
	private static AbstractTypeDeclaration[] getClasses(CompilationUnit node) {
		List<?> classNodes = node.types();
		AbstractTypeDeclaration[] classes=new AbstractTypeDeclaration[classNodes.size()];
		int index=0;
		for (Object classNode : classNodes) {
			AbstractTypeDeclaration clazz=(AbstractTypeDeclaration)classNode;
			classes[index++] = clazz;
		}
		return classes;
	}
}
