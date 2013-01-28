package org.isistan.flabot.javamodel.jdt;

import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaElementDelta;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.isistan.flabot.javamodel.InternalModelException;
import org.isistan.flabot.javamodel.JArray;
import org.isistan.flabot.javamodel.MixedImplementationsException;
import org.isistan.flabot.javamodel.jdt.workspace.JPackageRoot;
import org.isistan.flabot.javamodel.jdt.workspace.JProject;
import org.isistan.flabot.javamodel.jdt.workspace.JWorkspace;

/**
 * Represents a workspace (as IJavaModel)
 * @author $Author: dacostae $
 *
 */
public class ProjectImpl extends ObjectImpl implements JProject, JNotificableElement {
	private static final int PROJECT_CLASSPATH_CHANGE_FLAG=0;

	private IJavaProject jdtProject;
	
	IJavaProject getJDTProject() {
		return jdtProject;
	}
	
	static IJavaProject getJDTProject(JProject jProject) {
		if(jProject instanceof ProjectImpl) {
			return ((ProjectImpl)jProject).getJDTProject();
		} else {
			throw new MixedImplementationsException(jProject);
		} 
	}
	
	ProjectImpl(IJavaProject jdtProject) {
		super(jdtProject);
		this.jdtProject=jdtProject;
		JavaModelListener.getInstance().add(this, PROJECT_CLASSPATH_CHANGE_FLAG, jdtProject,
				IJavaElementDelta.F_CLASSPATH_CHANGED);
	}
	

	public void changed(int flag, IJavaElement javaElement, int eventFlags, ElementChangedEvent event) {
		if(flag==PROJECT_CLASSPATH_CHANGE_FLAG) {
			packageRoots=null;
			allPackageRoots=null;
		}
	}
	
	public JWorkspace getWorkspace() {
		return JDTFactory.getInstance().buildWorkspace(jdtProject.getParent());
	}
	
	private JArray<? extends JPackageRoot> packageRoots=null;
	public JArray<? extends JPackageRoot> getPackageRoots() {
		if(packageRoots==null) {
			try {
				packageRoots=JDTFactory.getInstance().buildArray(
						JavaModelJDTUtil.getExistingElementsArray(
								jdtProject.getPackageFragmentRoots()),
						JDTFactory.getInstance().getPackageRootBuilder());
			} catch (JavaModelException e) {
				throw new InternalModelException(e);
			}
		}
		return packageRoots;
	}
	
	private JArray<? extends JPackageRoot> allPackageRoots=null;
	public JArray<? extends JPackageRoot> getAllPackageRoots() {
		if(allPackageRoots==null) {
			try {
				allPackageRoots=JDTFactory.getInstance().buildArray(jdtProject.getAllPackageFragmentRoots(),
						JDTFactory.getInstance().getPackageRootBuilder());
			} catch (JavaModelException e) {
				throw new InternalModelException(e);
			}
		}
		return allPackageRoots;
	}
	
	public String getName() {
		return jdtProject.getElementName();
	}

}
