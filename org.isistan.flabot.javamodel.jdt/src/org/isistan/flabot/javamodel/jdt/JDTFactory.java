/** * $Id: JDTFactory.java,v 1.6 2006/03/24 00:33:59 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.jdt;

import org.isistan.flabot.javamodel.CompositeMirrorBuilder;import org.isistan.flabot.javamodel.Factory;import org.isistan.flabot.javamodel.JBehavior;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;import org.isistan.flabot.javamodel.jdt.workspace.JJavaFile;import org.isistan.flabot.javamodel.jdt.workspace.JPackageRoot;import org.isistan.flabot.javamodel.jdt.workspace.JProject;import org.isistan.flabot.javamodel.jdt.workspace.JWorkspace;import org.isistan.flabot.javamodel.jdt.workspace.JWorkspaceClass;import org.isistan.flabot.javamodel.jdt.workspace.JWorkspacePackage;public class JDTFactory extends Factory {

	private static JDTFactory instance=null;
	
	public static JDTFactory getInstance() {
		if(instance==null)
			instance=new JDTFactory();
		return instance;
	}
		@Override	protected void initialize() {
		objectBuilder=new ObjectBuilder();
		classBuilder=new WorkspaceClassBuilder();
		packageBuilder=new WorkspacePackageBuilder();		fieldBuilder=new FieldBuilder();
		behaviorBuilder=new CompositeMirrorBuilder<JBehavior>(
				new ObjectMirrorBuilder[] {
						methodBuilder=new MethodBuilder(),
						constructorBuilder=new ConstructorBuilder()
				}, new BehaviorBuilder()
			);
		arrayBuilder=new ArrayBuilder();				workspaceBuilder=new WorkspaceBuilder();		javaFileBuilder=new JavaFileBuilder();		packageRootBuilder=new PackageRootBuilder();		projectBuilder=new ProjectBuilder();	}		protected ObjectMirrorBuilder<? extends JWorkspace> workspaceBuilder;	protected ObjectMirrorBuilder<? extends JJavaFile> javaFileBuilder;	protected ObjectMirrorBuilder<? extends JPackageRoot> packageRootBuilder;	protected ObjectMirrorBuilder<? extends JProject> projectBuilder;	public ObjectMirrorBuilder<? extends JWorkspace> getWorkspaceBuilder() {		return workspaceBuilder;	}		@Override	public ObjectMirrorBuilder<? extends JWorkspacePackage> getPackageBuilder() {		return (ObjectMirrorBuilder<? extends JWorkspacePackage>) packageBuilder;	}		@Override	public ObjectMirrorBuilder<? extends JWorkspaceClass> getClassBuilder() {		return (ObjectMirrorBuilder<? extends JWorkspaceClass>) classBuilder;	}		public ObjectMirrorBuilder<? extends JJavaFile> getJavaFileBuilder() {		return javaFileBuilder;	}		public ObjectMirrorBuilder<? extends JPackageRoot> getPackageRootBuilder() {		return packageRootBuilder;	}		public ObjectMirrorBuilder<? extends JProject> getProjectBuilder() {		return projectBuilder;	}	public JWorkspace buildWorkspace(Object internalWorkspace) {		return build(internalWorkspace, workspaceBuilder);	}	@Override	public JWorkspacePackage buildPackage(Object internalPackage) {		return (JWorkspacePackage) build(internalPackage, packageBuilder);	}		@Override	public JWorkspaceClass buildClass(Object internalClass) {		return (JWorkspaceClass) build(internalClass, classBuilder);	}	public JJavaFile buildJavaFile(Object internalJavaFile) {		return build(internalJavaFile, javaFileBuilder);	}	public JPackageRoot buildPackageRoot(Object internalPackageRoot) {		return build(internalPackageRoot, packageRootBuilder);	}		public JProject buildProject(Object internalProject) {		return build(internalProject, projectBuilder);	}
}
