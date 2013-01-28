package org.isistan.flabot.javamodel.jdt;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaElementDelta;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.isistan.flabot.javamodel.InternalModelException;
import org.isistan.flabot.javamodel.JArray;
import org.isistan.flabot.javamodel.MixedImplementationsException;
import org.isistan.flabot.javamodel.jdt.workspace.JProject;
import org.isistan.flabot.javamodel.jdt.workspace.JWorkspace;

public class WorkspaceImpl extends ObjectImpl implements JWorkspace, JNotificableElement {
	private static final int WORKSPACE_CHILDREN_CHANGE_FLAG=0;
	
	private IJavaModel jdtWorkspace;
	
	IJavaModel getJDTWorkspace() {
		return jdtWorkspace;
	}
	
	static IJavaModel getJDTWorkspace(JWorkspace jWorkspace) {
		if(jWorkspace instanceof WorkspaceImpl) {
			return ((WorkspaceImpl)jWorkspace).getJDTWorkspace();
		} else {
			throw new MixedImplementationsException(jWorkspace);
		} 
	}
	
	WorkspaceImpl(IJavaModel jdtWorkspace) {
		super(jdtWorkspace);
		this.jdtWorkspace=jdtWorkspace;
		JavaModelListener.getInstance().add(this, WORKSPACE_CHILDREN_CHANGE_FLAG, jdtWorkspace,
				IJavaElementDelta.F_CHILDREN);
	}
	

	public void changed(int flag, IJavaElement javaElement, int eventFlags, ElementChangedEvent event) {
		if(flag==WORKSPACE_CHILDREN_CHANGE_FLAG) {
			projects=null;
		}
	}

	public String getName() {
		return jdtWorkspace.getElementName();
	}
	private JArray<? extends JProject> projects=null;
	public JArray<? extends JProject> getProjects() {
		if(projects==null) {
			try {
				IJavaElement[] children = jdtWorkspace.getChildren();
				List<IJavaProject> projectsList=new LinkedList<IJavaProject>();
				for (IJavaElement child : children) {
					if(JavaModelJDTUtil.elementExists(child) && child instanceof IJavaProject) {
						projectsList.add((IJavaProject)child);
					}
				}
				IJavaProject[] projectsArray=projectsList.toArray(new IJavaProject[projectsList.size()]);
				projects=JDTFactory.getInstance().buildArray(projectsArray, 
						JDTFactory.getInstance().getProjectBuilder());
			} catch (JavaModelException e) {
				throw new InternalModelException(e);
			}
		}
		return projects;
	}

}
