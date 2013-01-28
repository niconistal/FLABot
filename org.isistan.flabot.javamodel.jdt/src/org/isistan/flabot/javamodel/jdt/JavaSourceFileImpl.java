package org.isistan.flabot.javamodel.jdt;

import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaElementDelta;
import org.eclipse.jdt.core.JavaModelException;
import org.isistan.flabot.javamodel.InternalModelException;
import org.isistan.flabot.javamodel.JArray;
import org.isistan.flabot.javamodel.MixedImplementationsException;
import org.isistan.flabot.javamodel.jdt.workspace.JJavaFile;
import org.isistan.flabot.javamodel.jdt.workspace.JWorkspaceClass;

public class JavaSourceFileImpl extends JavaFileImpl implements JNotificableElement {
	private static final int CHILDREN_CHANGE_FLAG=0;
	
	private ICompilationUnit jdtJavaSourceFile;
	
	ICompilationUnit getJDTJavaSourceFile() {
		return jdtJavaSourceFile;
	}

	static ICompilationUnit getJDTJavaSourceFile(JJavaFile jJavaSourceFile) {
		if(jJavaSourceFile instanceof JavaSourceFileImpl) {
			return ((JavaSourceFileImpl)jJavaSourceFile).getJDTJavaSourceFile();
		} else {
			throw new MixedImplementationsException(jJavaSourceFile);
		} 
	}
	
	JavaSourceFileImpl(ICompilationUnit jdtJavaSourceFile) {
		super(jdtJavaSourceFile);
		this.jdtJavaSourceFile=jdtJavaSourceFile;
		JavaModelListener.getInstance().add(this, CHILDREN_CHANGE_FLAG, jdtJavaSourceFile,
				IJavaElementDelta.F_CHILDREN);
	}
	

	public void changed(int flag, IJavaElement javaElement, int eventFlags, ElementChangedEvent event) {
		if(flag==CHILDREN_CHANGE_FLAG) {
			classes=null;
		}
	}

	private JArray<? extends JWorkspaceClass> classes=null;
	public JArray<? extends JWorkspaceClass> getClasses() {
		if(classes==null) {
			try {
				classes=JDTFactory.getInstance().buildArray(
						JavaModelJDTUtil.getExistingElementsArray(
								jdtJavaSourceFile.getTypes()),
						JDTFactory.getInstance().getClassBuilder());
			} catch (JavaModelException e) {
				throw new InternalModelException(e);
			}
		}
		return classes;
	}
}
