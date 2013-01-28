/**
 * $Id: WorkspaceViewerContentProvider.java,v 1.6 2006/03/24 00:34:01 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.mapping.editor;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.javamodel.InternalModelException;
import org.isistan.flabot.javamodel.JArray;
import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JObject;
import org.isistan.flabot.javamodel.JPackage;
import org.isistan.flabot.javamodel.JavaMetaModelException;
import org.isistan.flabot.javamodel.jdt.JDTFactory;
import org.isistan.flabot.javamodel.jdt.JavaModelJDTUtil;
import org.isistan.flabot.javamodel.jdt.workspace.JJavaFile;
import org.isistan.flabot.javamodel.jdt.workspace.JPackageRoot;
import org.isistan.flabot.javamodel.jdt.workspace.JProject;
import org.isistan.flabot.javamodel.jdt.workspace.JWorkspace;
import org.isistan.flabot.javamodel.jdt.workspace.JWorkspaceClass;
import org.isistan.flabot.javamodel.jdt.workspace.JWorkspacePackage;
import org.isistan.flabot.mapping.MappingPlugin;
import org.isistan.flabot.mapping.messages.Messages;

/**
 * @author $Author: dacostae $
 *
 */
public class WorkspaceViewerContentProvider
		implements ITreeContentProvider {	
	
	protected static final Object[] EMPTY_ARRAY=new Object[0];
	
	static class InvalidElement {
		private Throwable exception;

		InvalidElement(Throwable exception) {
			this.exception=exception;
		}
		
		@Override
		public String toString() {
			return Messages.getString("org.isistan.flabot.mapping.editor.MappingContentProvider.error", exception.toString()); //$NON-NLS-1$
		}
		
	}
	
	public interface ContentFilter {
		public boolean accept(JWorkspaceClass jClass, boolean hasShowableChildren);
		public boolean accept(JBehavior jBehavior, boolean hasShowableChildren);
	}
	
	private boolean flat;
	private ContentFilter contentFilter;
	private boolean showSubclasses;
	private boolean showNestedClasses;
	private boolean showLocalClasses;
	private boolean showBehaviors;
	private boolean showClasses;

	public WorkspaceViewerContentProvider(boolean flat,
			boolean showSubclasses, boolean showNestedClasses, boolean showLocalClasses,
			boolean showClasses, boolean showBehaviors, 
			ContentFilter contentFilter) {
		this.flat=flat;
		this.contentFilter=contentFilter;
		this.showSubclasses=showSubclasses;
		this.showNestedClasses=showNestedClasses;
		this.showLocalClasses=showLocalClasses;
		this.showClasses=showClasses;
		this.showBehaviors=showBehaviors;
	}

	public Map<Object, Object[]> childrenCache=new WeakHashMap<Object, Object[]>();
	public Object[] getChildren(Object parent) {
		Object[] children=childrenCache.get(parent);
		if(children!=null) {
			return children;
		}
		
		try {
			if(parent instanceof JWorkspace) {
				children=getWorkspaceChildren((JWorkspace)parent);
			} else if(parent instanceof JProject) {
				children=getProjectChildren((JProject)parent);
			} else if(parent instanceof JPackageRoot) {
				children=getPackageRootChildren((JPackageRoot)parent);
			} else if(parent instanceof JWorkspacePackage) {
				children=getWorkspacePackageChildren((JWorkspacePackage)parent);
			} else if(parent instanceof JJavaFile) {
				children=getJavaFileChildren((JJavaFile)parent);
			} else if(parent instanceof JWorkspaceClass) {
				children=getClassChildren((JWorkspaceClass)parent);
			} else if(parent instanceof JBehavior) {
				children=getBehaviorChildren((JBehavior)parent);
			}
		} catch (JavaMetaModelException e) {
			Throwable exception=e;
			if(e instanceof InternalModelException && e.getCause()!=null) {
				exception=e.getCause();
			}
			children=new Object[] {new InvalidElement(exception)};
			FlabotPlugin.getDefault().getLogger().error(
					Messages.getString("org.isistan.flabot.mapping.editor.MappingContentProvider.workspaceError"), //$NON-NLS-1$
					exception);
		}
		if(children==null) {
			children=EMPTY_ARRAY;
		}

		childrenCache.put(parent, children);
		
		return children;
	}

	private Object[] getClassChildren(JWorkspaceClass jClass) {
		if(!showNestedClasses && !showBehaviors && !showLocalClasses && !showSubclasses) {
			return EMPTY_ARRAY;
		}
		List<JObject> classChildren = new LinkedList<JObject>();
		if(showSubclasses) {
			JArray<? extends JClass> jSubclasses = jClass.getSubclasses(true);
			for (JClass jSubclass : jSubclasses) {
				if(contentFilter==null || contentFilter.accept((JWorkspaceClass)jSubclass, hasChildren(jSubclass))) {
					classChildren.add(jSubclass);
				}
			}
		}
		if(showNestedClasses) {
			JArray<? extends JClass> jDeclaredClasses = jClass.getDeclaredClasses();
			for (JClass jDeclaredClass : jDeclaredClasses) {
				if(jDeclaredClass.getEnclosingBehavior()==null) {
					if(contentFilter==null || contentFilter.accept((JWorkspaceClass)jDeclaredClass, hasChildren(jDeclaredClass))) {
						classChildren.add(jDeclaredClass);
					}
				}
			}
		}
		if(showBehaviors || showLocalClasses) {
			JArray<? extends JBehavior> jDeclaredBehaviors = jClass.getDeclaredBehaviors();
			for (JBehavior jDeclaredBehavior : jDeclaredBehaviors) {
				if(showBehaviors) {
					if(contentFilter==null || contentFilter.accept(jDeclaredBehavior, hasChildren(jDeclaredBehavior))) {
						classChildren.add(jDeclaredBehavior);
					}
				} else if(showLocalClasses){
					//type==classe
					if(hasChildren(jDeclaredBehavior)) {
						classChildren.add(jDeclaredBehavior);
					}
				}
				
			}
		}
		return classChildren.toArray();
	}
	

	private Object[] getBehaviorChildren(JBehavior jBehavior) {
		if(!showLocalClasses) {
			return EMPTY_ARRAY;
		} else {
			JArray<? extends JClass> jDeclaredClasses = jBehavior.getDeclaringClass().getDeclaredClasses();
			List<JObject> behaviorChildren = new LinkedList<JObject>();
			for (JClass jDeclaredClass : jDeclaredClasses) {
				if(jDeclaredClass.getEnclosingBehavior()==jBehavior) {
					if(contentFilter==null || contentFilter.accept((JWorkspaceClass)jDeclaredClass, hasChildren(jDeclaredClass))) {
						behaviorChildren.add(jDeclaredClass);
					}
				}
			}
			return behaviorChildren.toArray();
		}
	}
	
	private Object[] getJavaFileChildren(JJavaFile jJavaFile) {
		List<JClass> classes=new LinkedList<JClass>();
		for (JClass jClass : jJavaFile.getClasses()) {
			if(contentFilter==null || contentFilter.accept((JWorkspaceClass)jClass, hasChildren(jClass))) {
				classes.add(jClass);
			}
		}
		return classes.toArray();
	}

	private Object[] getWorkspacePackageChildren(JWorkspacePackage jWorkspacePackage) {
		if(flat) {
			if(!showClasses) {
				return EMPTY_ARRAY;
			} else {
				List<JJavaFile> javaFiles=new LinkedList<JJavaFile>();
				for (JJavaFile jJavaFile : jWorkspacePackage.getJavaFiles()) {
					if(hasChildren(jJavaFile)) {
						javaFiles.add(jJavaFile);
					}
				}
				return javaFiles.toArray();
			}
		} else {
			JArray<? extends JWorkspacePackage> jWorkspacePackages = jWorkspacePackage.getPackages();
			JArray<? extends JJavaFile> jJavaFiles=null;
			List<JObject> packageChildren=new LinkedList<JObject>();
			
			if(showClasses) {
				jJavaFiles = jWorkspacePackage.getJavaFiles();
			}
			for (int i=0; i<jWorkspacePackages.length() ; i++) {
				JWorkspacePackage jChildWorkspacePackage=jWorkspacePackages.at(i);
				packageChildren.add(jChildWorkspacePackage);
			}
			if(showClasses) {
				for (int i=0; i<jJavaFiles.length() ; i++) {
					JJavaFile jJavaFile=jJavaFiles.at(i);
					if(hasChildren(jJavaFile)) {
						packageChildren.add(jJavaFile);
					}
				}
			}
			return packageChildren.toArray();
		}
	}

	private Object[] getPackageRootChildren(JPackageRoot jPackageRoot) {
		JArray<? extends JWorkspacePackage> packages=jPackageRoot.getAllPackages();
		if(flat) {
			packages=jPackageRoot.getAllPackages();

		} else {
			packages=jPackageRoot.getPackages();
		}
		List<JWorkspacePackage> childPackages=new LinkedList<JWorkspacePackage>();
		for (JWorkspacePackage jWorkspacePackage : packages) {
			childPackages.add(jWorkspacePackage);
		}
		return childPackages.toArray();
	}

	private Object[] getProjectChildren(JProject jProject) {
		List<JPackageRoot> packageRoots=new LinkedList<JPackageRoot>();
		for (JPackageRoot jPackageRoot : jProject.getAllPackageRoots()) {
			packageRoots.add(jPackageRoot);
		}
		return packageRoots.toArray();
	}

	private Object[] getWorkspaceChildren(JWorkspace jWorkspace) {
		List<JProject> projects=new LinkedList<JProject>();
		for (JProject jProject : jWorkspace.getProjects()) {
			projects.add(jProject);
		}
		return projects.toArray();
	}
	

	public Object getParent(Object element) {
		throw new RuntimeException("getParent not supported, because of the multiparent facility.");
	}

	public boolean hasChildren(Object element) {
		if(element instanceof JPackage) {
			if(!showClasses) {
				return false;
			}
			try {
				return ((IPackageFragment)JavaModelJDTUtil.getJavaElement((JPackage)element)).hasChildren();
			} catch (JavaModelException e) {
				MappingPlugin.getDefault().getLogger().error("JavaModelException",e);
				return true;
			}
		} else if(element instanceof JJavaFile && contentFilter==null) {
			return true;
		} else {
			return getChildren(element).length>0;
		}
	}
	
	
	private JWorkspace workspace;
	public Object[] getElements(Object inputElement) {
		if(inputElement instanceof IJavaModel) {
			IJavaModel javaModel=(IJavaModel)inputElement;
			workspace=JDTFactory.getInstance().buildWorkspace(javaModel);
			return getChildren(workspace);
		} else {
			Object[] elements=(Object[])inputElement;
			Object[] containers=new Object[elements.length];
			for (int i = 0; i < elements.length; i++) {
				containers[i]=elements[i];
			}
			return containers;
		}
	}
	
	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	
	}
}
