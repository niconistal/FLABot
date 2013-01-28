package org.isistan.flabot.javamodel.jdt;

import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaElementDelta;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.isistan.flabot.javamodel.InternalModelException;
import org.isistan.flabot.javamodel.JArray;
import org.isistan.flabot.javamodel.MixedImplementationsException;
import org.isistan.flabot.javamodel.jdt.workspace.JJavaFile;
import org.isistan.flabot.javamodel.jdt.workspace.JWorkspaceClass;

public class JavaBinaryFileImpl extends JavaFileImpl implements JNotificableElement {
	private static final int CHILDREN_CHANGE_FLAG=0;
	
	private IClassFile jdtJavaBinaryFile;
	
	IClassFile getJDTJavaBinaryFile() {
		return jdtJavaBinaryFile;
	}
	
	static IClassFile getJDTJavaBinaryFile(JJavaFile jJavaBinaryFile) {
		if(jJavaBinaryFile instanceof JavaBinaryFileImpl) {
			return ((JavaBinaryFileImpl)jJavaBinaryFile).getJDTJavaBinaryFile();
		} else {
			throw new MixedImplementationsException(jJavaBinaryFile);
		} 
	}
	
	JavaBinaryFileImpl(IClassFile jdtJavaBinaryFile) {
		super(jdtJavaBinaryFile);
		this.jdtJavaBinaryFile=jdtJavaBinaryFile;
		JavaModelListener.getInstance().add(this, CHILDREN_CHANGE_FLAG, jdtJavaBinaryFile,
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
				IType type=jdtJavaBinaryFile.getType();
				IType[] types;
				if(JavaModelJDTUtil.elementExists(type)) {
					types=new IType[] {type};
				} else {
					types=new IType[0];
				}
				classes=JDTFactory.getInstance().buildArray(types,
						JDTFactory.getInstance().getClassBuilder());
			} catch (Exception e) {
				throw new InternalModelException(e);
			}
		}
		return classes;
	}
}
