/**

import org.eclipse.jdt.core.IJavaModel;

	public boolean accepts(Object object) {
		return object instanceof IJavaModel;
	}

	public JWorkspace build(Object object) {
		return new WorkspaceImpl((IJavaModel) object);
	}

}