/**

import org.eclipse.jdt.core.IJavaProject;

	public boolean accepts(Object object) {
		return object instanceof IJavaProject;
	}

	public JProject build(Object object) {
		return new ProjectImpl((IJavaProject) object);
	}

}