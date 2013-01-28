package org.isistan.flabot.javamodel.jdt;

import org.eclipse.jdt.core.IJavaElement;
import org.isistan.flabot.javamodel.MixedImplementationsException;
import org.isistan.flabot.javamodel.Util;
import org.isistan.flabot.javamodel.jdt.workspace.JJavaFile;
import org.isistan.flabot.javamodel.jdt.workspace.JWorkspacePackage;

public abstract class JavaFileImpl extends ObjectImpl implements JJavaFile {
	
	private IJavaElement jdtJavaFile;
	
	IJavaElement getJDTJavaFile() {
		return jdtJavaFile;
	}

	static IJavaElement getJDTJavaFile(JJavaFile jJavaFile) {
		if(jJavaFile instanceof JavaFileImpl) {
			return ((JavaFileImpl)jJavaFile).getJDTJavaFile();
		} else {
			throw new MixedImplementationsException(jJavaFile);
		} 
	}
	
	JavaFileImpl(IJavaElement jdtJavaFile) {
		super(jdtJavaFile);
		this.jdtJavaFile=jdtJavaFile;
	}

	public String getName() {
		return jdtJavaFile.getElementName();
	}
	
	public JWorkspacePackage getPackage() {
		return JDTFactory.getInstance().buildPackage(jdtJavaFile.getParent());
	}
	
	private String descriptor=null;
	public String getDescriptor() {
		if(descriptor==null) {
			String name=getName();
			name=name.substring(0, name.length()-5);
			descriptor=JAVA_FILE_DESCRIPTOR_TYPE + 
				Util.DESCRIPTOR_TYPE_DELIMITER + 
				jdtJavaFile.getParent().getElementName()
				+ Util.PACKAGE_DELIMITER + name;
		}
		return descriptor;
	}


}
