/**

import org.eclipse.jdt.core.IPackageFragment;

	public boolean accepts(Object object) {
		return object instanceof IPackageFragment || object instanceof IPackageBinding;
	}

	public JWorkspacePackage build(Object object) {
		return new WorkspacePackageImpl((IPackageFragment) object);
	}

}